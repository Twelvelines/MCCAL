package mccal.formula.formulareader;

// TODO tidy up the imports
import java.util.*;

import mccal.ModelChecker;
import mccal.exceptions.ForeignComponentException;
import mccal.formula.formulareader.antlr.*;
import mccal.model.*;


/* Franco 230721
   This is a listener to compute the set of states in which a 
   given formula holds. We use a stack to store intermediate
   results.

*/
public class FormulaEvaluator extends FormulaGrammarBaseListener {
    private FormulaGrammarParser parser;

    // This is the model where we want to evaluate the formula.
    private Model model;
    // announcement cache
    private Model aModelCache;

    // This is the stack where we store temporary results.
    private Stack<Set<String>> evalStack;

    private Stack<Set<String>> aFalseStatesCache;

    private List<Integer> coalitionAgentlistCache;


    public FormulaEvaluator(FormulaGrammarParser p) {
        this.parser = p;
        // In the constructor we create an empty stack.
        evalStack = new Stack<>();
        aFalseStatesCache = new Stack<>();
    }

    public void setModel(Model m) {
        this.model = m;
    }

    // Basic case: an atom, which is an ID
    @Override
    public void exitId(FormulaGrammarParser.IdContext ctx) {
        // Nothing special, the model gives us the set of states
        Set<String> validStates = model.getStatesWhereTrue(ctx.ID().getText());
        if (validStates == null) {
            validStates = new HashSet<>();
        }
        evalStack.push(validStates);
    }

    // Negation: we have to take the complement of the set
    @Override

    public void exitNegation(FormulaGrammarParser.NegationContext ctx) {
        Set<String> allStates = new HashSet<>(this.model.getAllStates());
        Set<String> previous = evalStack.pop();

        // removeAll is the set difference
        // TODO: check what happens with empty difference
        allStates.removeAll(previous);
        evalStack.push(new HashSet<>(allStates));
    }

    // For the conjunction we take the intersection of the two elements on top
    // of the stack
    @Override
    public void exitConjunction(FormulaGrammarParser.ConjunctionContext ctx) {
        Set<String> left = evalStack.pop();
        Set<String> right = evalStack.pop();
        // retainAll is the intersection.
        left.retainAll(right);
        // FIXME: check that everything is OK with an empty intersection
        evalStack.push(new HashSet<>(left));
    }

    // This is similar to conjunction above
    @Override
    public void exitDisjunction(FormulaGrammarParser.DisjunctionContext ctx) {
        Set<String> left = evalStack.pop();
        Set<String> right = evalStack.pop();
        // addAll is the union.
        left.addAll(right);
        evalStack.push(new HashSet<>(left));
    }

    // (a -> b) is (!a or b)
    @Override
    public void exitImplication(FormulaGrammarParser.ImplicationContext ctx) {
        // Arguments are swapped on top of stack!
        // (bug fixed)
        Set<String> right = evalStack.pop();
        Set<String> left = evalStack.pop();

        // These are all the states
        Set<String> allStates = new HashSet<>(this.model.getAllStates());

        // We compute !a:
        allStates.removeAll(left);

        // Now we add b:
        allStates.addAll(right);

        // And we push to stack:
        evalStack.push(new HashSet<>(allStates));
    }


    @Override
    public void exitKnowledge(FormulaGrammarParser.KnowledgeContext ctx) {
        // List<String> allStates = this.model.getAllStates();    // all the states
        Set<String> previous = evalStack.pop();    // The set of states where the inner formula is true
        int agent = Integer.valueOf(ctx.agentid().getText());
        Set<String> result = new HashSet<>();

        for (String state : previous) {     // for every states in the previous true states
            boolean allRelatedStatesAreInThePreviousTrueStates = true;
            for (Set<String> equivClass : model.getEquivClasses(agent)) {    // examine all equiv relations
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
    public void exitAn_formula(FormulaGrammarParser.An_formulaContext ctx) {
        // states where the announcement is true
        Set<String> trueStates = evalStack.pop();
        Set<String> falseStates;
        // check if it is currently in a sub-formula (local formula)
        falseStates = evalStack.empty() ? new HashSet<>(model.getAllStates()) : evalStack.pop();
        // states where the announcement is false
        falseStates.removeAll(trueStates);
        // cache false states in which the evaluation are always true. Used when announcement exits
        aFalseStatesCache.push(falseStates);
        aModelCache = model;
        model = model.getShrunkModel(trueStates);
    }

    @Override
    public void exitAnnouncement(FormulaGrammarParser.AnnouncementContext ctx) {
        model = aModelCache;
        aModelCache = null;
        Set<String> result = evalStack.pop();
        result.addAll(aFalseStatesCache.pop());
        evalStack.push(result);
    }

    // TODO make a strat class
    @Override
    public void exitAgentlist(FormulaGrammarParser.AgentlistContext ctx) {
        // get agent list
        List<Integer> agentlist = new ArrayList<>();
        for (FormulaGrammarParser.AgentidContext aCtx  : ctx.agentid()) {
            agentlist.add(Integer.valueOf(aCtx.getText()));
        }
        coalitionAgentlistCache = agentlist;
    }

    @Override
    public void enterCa_formula(FormulaGrammarParser.Ca_formulaContext ctx) {
        String formula = ctx.getText();
        Set<String> result = new HashSet<>();
        List<Integer> agentlist = coalitionAgentlistCache;
        List<Integer> restAgentlist = new ArrayList<>();
        // iterate to create a list
        for (int i = 0; i < model.getNumberOfAgents(); i++) {
            restAgentlist.add(i+1);
        }
        restAgentlist.removeAll(agentlist);
        coalitionAgentlistCache = null;
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
                result.add(state);
                break;    // - to the next state
            }
        }
        // push the collected states as result
        evalStack.push(result);
    }

    @Override
    public void exitCoalitional_announcement(FormulaGrammarParser.Coalitional_announcementContext ctx) {
        // getting rid of extra parsed result
        evalStack.pop();
    }

    public Model getModel() {
        return model;
    }

    public Set<String> getSolution() {
        return evalStack.peek();
    }
}
