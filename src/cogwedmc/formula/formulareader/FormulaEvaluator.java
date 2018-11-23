package cogwedmc.formula.formulareader;

import java.util.*;

import cogwedmc.formula.formulareader.antlr.*;
import cogwedmc.model.*;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;


/* Franco 230721
   This is a listener to compute the set of states in which a 
   given formula holds. We use a stack to store intermediate
   results.

*/
public class FormulaEvaluator extends CogwedFormulaGrammarBaseListener {
    private CogwedFormulaGrammarParser parser;

    // This is the model where we want to evaluate the formula.
    private CogwedModel cogwedmodel;
    // announcement cache
    private CogwedModel aModelCache;

    // This is the stack where we store temporary results.
    private Stack<Set<String>> evalStack;

    private Stack<Set<String>> aFalseStatesCache;

    private List<Integer> coalitionAgentlistCache;


    public FormulaEvaluator(CogwedFormulaGrammarParser p) {
        this.parser = p;
        // In the constructor we create an empty stack.
        evalStack = new Stack<>();
        aFalseStatesCache = new Stack<>();
    }

    public void setModel(CogwedModel m) {
        this.cogwedmodel = m;
    }

    // Basic case: an atom, which is an ID
    @Override
    public void exitId(CogwedFormulaGrammarParser.IdContext ctx) {
        // Nothing special, the model gives us the set of states
        Set<String> validStates = cogwedmodel.getStatesWhereTrue(ctx.ID().getText());
        if (validStates == null) {
            validStates = new HashSet<>();
        }
        evalStack.push(validStates);
    }

    // Negation: we have to take the complement of the set
    @Override

    public void exitNegation(CogwedFormulaGrammarParser.NegationContext ctx) {
        Set<String> allStates = new HashSet<>(this.cogwedmodel.getAllStates());
        Set<String> previous = evalStack.pop();

        // removeAll is the set difference
        // TODO: check what happens with empty difference
        allStates.removeAll(previous);
        evalStack.push(new HashSet<>(allStates));
    }

    // For the conjunction we take the intersection of the two elements on top
    // of the stack
    @Override
    public void exitConjunction(CogwedFormulaGrammarParser.ConjunctionContext ctx) {
        Set<String> left = evalStack.pop();
        Set<String> right = evalStack.pop();
        // retainAll is the intersection.
        left.retainAll(right);
        // FIXME: check that everything is OK with an empty intersection
        evalStack.push(new HashSet<>(left));
    }

    // This is similar to conjunction above
    @Override
    public void exitDisjunction(CogwedFormulaGrammarParser.DisjunctionContext ctx) {
        Set<String> left = evalStack.pop();
        Set<String> right = evalStack.pop();
        // addAll is the union.
        left.addAll(right);
        evalStack.push(new HashSet<>(left));
    }

    // (a -> b) is (!a or b)
    @Override
    public void exitImplication(CogwedFormulaGrammarParser.ImplicationContext ctx) {
        // Arguments are swapped on top of stack!
        // (bug fixed)
        Set<String> right = evalStack.pop();
        Set<String> left = evalStack.pop();

        // These are all the states
        Set<String> allStates = new HashSet<>(this.cogwedmodel.getAllStates());

        // We compute !a:
        allStates.removeAll(left);

        // Now we add b:
        allStates.addAll(right);

        // And we push to stack:
        evalStack.push(new HashSet<>(allStates));
    }


    @Override
    public void exitKnowledge(CogwedFormulaGrammarParser.KnowledgeContext ctx) {
        // List<String> allStates = this.cogwedmodel.getAllStates();    // all the states
        Set<String> previous = evalStack.pop();    // The set of states where the inner formula is true
        int agent = Integer.valueOf(ctx.agentid().getText());
        Set<String> result = new HashSet<>();

        for (String state : previous) {     // for every states in the previous true states
            boolean allRelatedStatesAreInThePreviousTrueStates = true;
            for (Set<String> equivClass : cogwedmodel.getEquivClasses(agent)) {    // examine all equiv relations
                if (!equivClass.contains(state)) {     // rid of the irrelevant
                    continue;
                }    // the rest relations contains the current state
                if (!previous.containsAll(equivClass)) {
                    // if any state in the relation is not among the previous true states
                    allRelatedStatesAreInThePreviousTrueStates = false;
                    break;
                }
            }
            if (allRelatedStatesAreInThePreviousTrueStates) {
                result.add(state);
            }
        }

        // Pushing the result to the stack
        evalStack.push(new HashSet<>(result));
    }

    @Override
    public void exitAn_formula(CogwedFormulaGrammarParser.An_formulaContext ctx) {
        // states where the announcement is true
        Set<String> trueStates = evalStack.pop();
        Set<String> falseStates;
        // check if it is currently in a sub-formula (local formula)
        falseStates = evalStack.empty() ? new HashSet<>(cogwedmodel.getAllStates()) : evalStack.pop();
        // states where the announcement is false
        falseStates.removeAll(trueStates);
        // cache false states in which the evaluation are always true. Used when announcement exits
        aFalseStatesCache.push(falseStates);
        aModelCache = cogwedmodel;
        cogwedmodel = cogwedmodel.getShrunkModel(trueStates);
    }

    @Override
    public void exitAnnouncement(CogwedFormulaGrammarParser.AnnouncementContext ctx) {
        cogwedmodel = aModelCache;
        aModelCache = null;
        Set<String> result = evalStack.pop();
        result.addAll(aFalseStatesCache.pop());
        evalStack.push(result);
    }

    // TODO make a strat class
    @Override
    public void exitAgentlist(CogwedFormulaGrammarParser.AgentlistContext ctx) {
        // get agent list
        List<Integer> agentlist = new ArrayList<>();
        for (CogwedFormulaGrammarParser.AgentidContext aCtx  : ctx.agentid()) {
            agentlist.add(Integer.valueOf(aCtx.getText()));
        }
        coalitionAgentlistCache = agentlist;
    }

    @Override
    public void enterCa_formula(CogwedFormulaGrammarParser.Ca_formulaContext ctx) {
        String formula = ctx.getText();
        Set<String> result = new HashSet<>();
        List<Integer> agentlist = coalitionAgentlistCache;
        coalitionAgentlistCache = null;
        for (String state : cogwedmodel.getAllStates()) {
            System.out.println("CA on state: " + state);
            System.out.println(cogwedmodel.getRK());
            List<Set<String>> allStrats = new ArrayList<>(cogwedmodel.getStrategies(state, agentlist));
            int numStrats = allStrats.size();
            for (int i = 0; i < numStrats; i++) {
                Set<String> strat = allStrats.get(i);
                boolean allParsingReturnsTrue = true;
                for (int j = i+1; j < numStrats; j++) {
                    Set<String> oStrat = allStrats.get(j);
                    System.out.println(cogwedmodel.getRK());
                    CogwedModel submodel = cogwedmodel.getShrunkModel(CogwedModel.intersect(strat, oStrat));
                    System.out.println(cogwedmodel.getRK());
                    if (!subparse(submodel, formula).contains(state)) {
                        allParsingReturnsTrue = false;
                        break;
                    }
                }
                if (!allParsingReturnsTrue) {
                    continue;    // - to the next strat
                    // the loop will olso be finished here if for every strat, !allParsingReturnsTrue,
                    // thus break to the next state
                }
                // if for the strat, all parsing of formula on the submodel made is true
                result.add(state);
                System.out.println("CA on state: " + state + " result: true");
                break;    // - to the next state
            }
        }
        // push the collected states as result
        evalStack.push(result);
        // TODO test this exit rule
        ctx.exitRule(this);
    }

    private Set<String> subparse(CogwedModel model, String formula) {
        ANTLRInputStream finput = new ANTLRInputStream(formula);
        CogwedFormulaGrammarLexer flexer = new
                CogwedFormulaGrammarLexer(finput);
        // create a buffer of tokens pulled from the lexer
        CommonTokenStream ftokens = new CommonTokenStream(flexer);
        // create a parser that feeds off the tokens buffer
        CogwedFormulaGrammarParser fparser = new CogwedFormulaGrammarParser(ftokens);
        // begin parsing
        ParseTree ftree = fparser.start();
        // Just a standard walker
        ParseTreeWalker fwalker = new ParseTreeWalker();
        // Now we associate our extractor to the parser.
        FormulaEvaluator evaluator = new FormulaEvaluator(fparser);
        evaluator.setModel(model);
        // and we walk the tree with our extractor.
        System.out.println("Subparsing formula: " + formula + ", and the model look like: ");
        System.out.println(model.getAtoms());
        System.out.println(model.getRK());
        System.out.println(model.getAllStates());
        fwalker.walk(evaluator, ftree);
        return evaluator.getSolution();
    }

    @Override
    public void exitCoalitional_announcement(CogwedFormulaGrammarParser.Coalitional_announcementContext ctx) {
        // TODO get partial parser's result and push it into stack
    }

    public CogwedModel getModel() {
        return cogwedmodel;
    }

    public Set<String> getSolution() {
        return evalStack.peek();
    }


    /*

    // EX is easy: just the pre-image of all the states in which
    // the formula is true.
    @Override
    public void exitEx(cogwedmc.formula.formulareader.antlr.CogwedFormulaGrammarParser.ExContext ctx) {
        Set<String> tmpResult = new HashSet<String>();
        Set<String> previous = stack.pop();

        // We iterate over all states in which the formula is true
        // and we add the predecessors to tmpResult
        for (String aState : previous) {
            tmpResult.addAll(this.cogwedmodel.getPredecessors(aState));
        }
        stack.push(new HashSet<String>(tmpResult));
    }

    // TODO: implement EG (fix-point etc.)
    // EG is computed using a fix-point, based on the idea that
    // EG p = p and (EX EG p)
    @Override
    public void exitEg(cogwedmc.formula.formulareader.antlr.CogwedFormulaGrammarParser.EgContext ctx) {

        Set<String> previous = stack.pop();

        // Two temporary variables
        Set<String> tmp = new HashSet<String>();
        Set<String> q = new HashSet<String>(previous);

        while (!tmp.equals(q)) {
            tmp = new HashSet<String>(q);
            Set<String> x = new HashSet<String>(this.cogwedmodel.getPredecessors(tmp));
            x.retainAll(previous);
        }

        stack.push(new HashSet<String>(q));
    }

    // This is the only complicated operator
    @Override
    public void exitBelief(cogwedmc.formula.formulareader.antlr.CogwedFormulaGrammarParser.BeliefContext ctx) {
        // all the states
        // Set<String> allStates = this.cogwedmodel.getAllStates().keySet();

        // The set of states where the inner formula is true:
        Set<String> previous = stack.pop();

        float value = Float.parseFloat(ctx.comparisonexpr().comparisonvalue().getText());
        int agentID = Integer.valueOf(ctx.agentid().getText());

        String operator = ctx.comparisonexpr().comparisonoperator().getText();

        Set<String> tmpResult = new HashSet<String>();

        // IDEA!
        // We don't need to iterate over all states, it is enough
        // to check the ratio of the equiv. class w.r.t. the comparison
        // operator: the truth value is the same for all the states in the
        // equiv. class.

        for (Set<String> eqClass : this.cogwedmodel.getEquivClasses(agentID - 1)) {

            // the set of states of the equivalence class in which the
            // formula is true: it's just the intersection:
            Set<String> whereTrue = new HashSet<String>(eqClass);
            whereTrue.retainAll(previous);

            float ratio = ((float) whereTrue.size()) /
                    ((float) eqClass.size());

            // Now we have to compare this ratio with the value passed.
            // We have to go through the possible cases.
            boolean addSet = false;
            if (operator.equals("=")) {
                if (ratio == value) {
                    addSet = true;
                }
            } else if (operator.equals("<")) {
                if (ratio < value) {
                    addSet = true;
                }
            } else if (operator.equals(">")) {
                if (ratio > value) {
                    addSet = true;
                }
            } else {
                System.err.println("Unknown operator: " + operator + ". Exiting now");
                System.exit(1);
            }

            // If the comparison was successful, we add the equiv. class
            // to the set of states where the formula is true
            if (addSet) {
                tmpResult.addAll(new HashSet<String>(eqClass));
            }
        } // end of loop over equivalence classes for agent.

        // Pushing the result to the stack
        stack.push(new HashSet<String>(tmpResult));
    }
    */

}
