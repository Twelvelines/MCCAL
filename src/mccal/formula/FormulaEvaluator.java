package mccal.formula;

import mccal.ModelChecker;
import mccal.exceptions.ForeignComponentException;
import mccal.antlr.formula.FormulaGrammarBaseListener;
import mccal.antlr.formula.FormulaGrammarParser;
import mccal.model.*;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.*;

// TODO rearrange the methods

/**
 * A Listener that computes the set of states in which a given formula holds in a model.
 * A stack is used to store intermediate results corresponding to the recursive rules (and their method call) stack.
 * Thus, instead of return the result directly, a formula-contexted method (i.e. entering or exiting the formula's rule)
 * return its result for via pushing it into the return stack so as for the outer (super)formula to receive them.
 */
public class FormulaEvaluator extends FormulaGrammarBaseListener {
    private boolean verbose = false;
    private Model model;    // the model where the formula is evaluated
    // the stack for caching results corresponding to the formula recursion; see javadoc for the class
    private Stack<Set<String>> evalStack = new Stack<>();
    // model caching slot for announcement logic
    private Stack<Model> aModelsCache = new Stack<>();

    public FormulaEvaluator(Model model, boolean verbose) {
        this.model = model;
        this.verbose = verbose;
    }

    /**
     * The base case method, where a proposition (an ID in terms of token) is examined, and
     * a set of states where the proposition holds is pushed into the return stack evalStack.
     */
    @Override
    public void exitAtom(FormulaGrammarParser.AtomContext ctx) {
        Set<String> validStates = model.getStates(ctx.ID().getText());
        evalStack.push(validStates);
    }

    /**
     * Pushes to the return stack the Negation of the proposition,
     * i.e. the complement of the set in regard of the whole set of states in the model.
     */
    @Override
    public void exitNegation(FormulaGrammarParser.NegationContext ctx) {
        Set<String> allStates = new HashSet<>(this.model.getAllStates());
        Set<String> previous = evalStack.pop();
        // TODO: check what happens with empty difference
        allStates.removeAll(previous);
        evalStack.push(allStates);
    }

    /**
     * Pushes to the return stack the value of a Conjunction ("or"),
     * which is the Intersection of the two subformula's results currently on top of the stack.
     */
    @Override
    public void exitConjunction(FormulaGrammarParser.ConjunctionContext ctx) {
        Set<String> right = evalStack.pop();
        Set<String> left = evalStack.pop();
        evalStack.push(Model.intersect(left, right));
    }

    /**
     * Pushes to return stack the value of a Disjunction ("and"),
     * which is the Union of the two subformula's results currently on top of the stack.
     */
    @Override
    public void exitDisjunction(FormulaGrammarParser.DisjunctionContext ctx) {
        Set<String> left = evalStack.pop();
        Set<String> right = evalStack.pop();
        left.addAll(right);
        evalStack.push(new HashSet<>(left));
    }

    /**
     * Pushes to return stack the value of a Implication, which is the logical sequence of two subformula.
     * Definitively, (a -> b) is (!a or b), which is how this is implemented as well.
     */
    @Override
    public void exitImplication(FormulaGrammarParser.ImplicationContext ctx) {
        Set<String> b = evalStack.pop();
        Set<String> a = evalStack.pop();
        Set<String> result = new HashSet<>(this.model.getAllStates());
        // !a:
        result.removeAll(a);
        // !a or b:
        result.addAll(b);
        evalStack.push(result);
    }


    @Override
    public void exitKnowledge(FormulaGrammarParser.KnowledgeContext ctx) {
        Set<String> innerTrueZone = evalStack.pop();
        int agent = Integer.valueOf(ctx.agentid().getText());
        Set<String> result = new HashSet<>();

        for (Set<String> equivClass : model.getEquivClasses(agent)) {
            if (innerTrueZone.containsAll(equivClass))    // if all state in the cluster is in the true states zone
                result.addAll(equivClass);
        }

        // push the result to the stack
        evalStack.push(result);
    }

    @Override
    public void exitPalformula(FormulaGrammarParser.PalformulaContext ctx) {
        // states where the announcement is true
        Set<String> trueStates = evalStack.pop();
        Set<String> falseStates = new HashSet<>(model.getAllStates());
        falseStates.removeAll(trueStates);
        // push back the false states which will be used again when exiting Announcement, as result of this stage,
        // which is same result as negation of the formula
        evalStack.push(falseStates);
        aModelsCache.push(model);
        model = model.getShrunkModel(trueStates);
    }

    @Override
    public void exitPuAnnouncement(FormulaGrammarParser.PuAnnouncementContext ctx) {
        model = aModelsCache.pop();
        Set<String> result = evalStack.pop();
        // adding up the false states of announcement formula stored when exiting it
        result.addAll(evalStack.pop());
        evalStack.push(result);
    }

    // TODO maybe make a strat class

    @Override
    public void enterGrAnnouncement(FormulaGrammarParser.GrAnnouncementContext ctx) {
        List<Integer> agentlist = new ArrayList<>();
        for (FormulaGrammarParser.AgentidContext aCtx : ctx.agentlist().agentid()) {
            agentlist.add(Integer.valueOf(aCtx.getText()));
        }
        String formula = ctx.galformula().getText();
        Set<String> result = new HashSet<>();

        for (String state : model.getAllStates()) {
            Set<Set<String>> strats;
            try {
                strats = model.getStrategies(state, agentlist);
            } catch (ForeignComponentException fe) {
                // TODO handle ForeignComponentException
                return;
            }
            for (Set<String> strat : strats) {
                Model submodel = model.getShrunkModel(strat);
                if (ModelChecker.evalFormula(submodel, formula).contains(state)) {
                    System.out.println("- GAL: strategy "+strat.toString()+" of agents "+agentlist.toString()+"is valid on state "+state);
                    result.add(state);
                    break;
                }
            }
        }

        // push the collected states as result
        evalStack.push(result);
    }

    @Override
    public void exitGalformula(FormulaGrammarParser.GalformulaContext ctx) {
        // getting rid of extra parsed result
        evalStack.pop();
    }

    @Override
    public void enterCoAnnouncement(FormulaGrammarParser.CoAnnouncementContext ctx) {
        List<Integer> agentlist = new ArrayList<>();
        for (FormulaGrammarParser.AgentidContext aCtx : ctx.agentlist().agentid()) {
            agentlist.add(Integer.valueOf(aCtx.getText()));
        }
        String formula = ctx.calformula().getText();
        Set<String> result = new HashSet<>();
        List<Integer> restAgentlist = new ArrayList<>();
        // iterate to create a list
        for (int i = 0; i < model.getNumberOfAgents(); i++) {
            restAgentlist.add(i+1);
        }
        restAgentlist.removeAll(agentlist);

        for (String state : model.getAllStates()) {
            Set<Set<String>> agentsStrategies;
            Set<Set<String>> otherAgentsStrategies;
            try {
                agentsStrategies = model.getStrategies(state, agentlist);
                otherAgentsStrategies = model.getStrategies(state, restAgentlist);
            } catch (ForeignComponentException fe) {
                // TODO handle ForeignComponentException
                return;
            }
            for (Set<String> strat : agentsStrategies) {
                boolean allParsingReturnsTrue = true;
                for (Set<String> oStrat : otherAgentsStrategies) {
                    Model submodel = model.getShrunkModel(Model.intersect(strat, oStrat));
                    if (!ModelChecker.evalFormula(submodel, formula).contains(state)) {
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
                System.out.println("- CAL: strategy "+strat.toString()+" of agents "+agentlist.toString()+" is valid on state "+state);
                result.add(state);
                break;    // - to the next state
            }
        }
        // push the collected states as result
        evalStack.push(result);
    }

    @Override
    public void exitCalformula(FormulaGrammarParser.CalformulaContext ctx) {
        // getting rid of extra parsed result
        evalStack.pop();
    }

    public Model getModel() {
        return model;
    }

    public Set<String> getSolution() {
        return evalStack.peek();
    }

    //debugging tool - formula: eval result (set of states)
    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        if (verbose && evalStack.size() != 0) {
            String formula = ctx.getText();
            int stacksize = evalStack.size();
            Set<String> top = evalStack.peek();
            System.out.println(formula+":\t(stack size: "+stacksize+")\n\t" +
                    top.toString() + "\t" +
                    top.size() + " states"
            );
        }
    }
}
