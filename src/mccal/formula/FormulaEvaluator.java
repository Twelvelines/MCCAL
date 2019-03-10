package mccal.formula;

import mccal.Intersection;
import mccal.ModelChecker;
import mccal.exceptions.UnknownAgentException;
import mccal.antlr.formula.FormulaGrammarBaseListener;
import mccal.antlr.formula.FormulaGrammarParser;
import mccal.model.*;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.*;

/**
 * A Listener that computes the set of states in which a given formula holds in a model.
 * A stack is used to store intermediate results corresponding to the recursive rules (and their method call) stack.
 * Thus, instead of return the result directly, a formula-contexted method (i.e. entering or exiting the formula's rule)
 * return its result for via pushing it into the return stack so as for the outer (super)formula to receive them.
 */
public class FormulaEvaluator extends FormulaGrammarBaseListener {
    private boolean verbose;
    private Model model;    // the model where the formula is evaluated
    // the stack for caching results corresponding to the formula recursion; see javadoc for the class
    private Stack<Set<String>> evalStack = new Stack<>();
    // model caching slot for announcement logic
    private Stack<Model> aModelsCache = new Stack<>();

    public FormulaEvaluator(Model model, boolean verbose) {
        this.model = model;
        this.verbose = verbose;
    }

    private void printValidStrat(Set<String> strat, Map<Integer, Set<String>> rawstrat, List<Integer> agents, String state, String formula) {
        System.out.println("- CAL: " +
                "co-strategy " + strat.toString() +
                " from agents " + agents.toString() +
                " is valid for " + formula +
                " under state " + state
        );
        for (int agent : rawstrat.keySet()) {
            System.out.println("\t"+agent+": "+rawstrat.get(agent).toString());
        }
    }

    // TODO maybe make a strat class
    @Override
    public void enterCoAnnouncement(FormulaGrammarParser.CoAnnouncementContext ctx) {
        List<Integer> agents = new ArrayList<>();
        for (FormulaGrammarParser.AgentidContext aCtx : ctx.agentlist().agentid()) {
            agents.add(Integer.valueOf(aCtx.getText()));
        }

        List<Integer> restOfAgents = new ArrayList<>();
        for (int i = 0; i < model.getNumberOfAgents(); i++) {
            restOfAgents.add(i+1);
        }
        restOfAgents.removeAll(agents);

        String formula = ctx.calformula().getText();

        Set<String> result = new HashSet<>();
        for (String state : model.getAllStates()) {
            Set<Map<Integer, Set<String>>> agentsStrategies;
            Set<Set<String>> otherAgentsStrategies;
            try {
                agentsStrategies = model.getDetailedStrategies(state, agents);
                otherAgentsStrategies = model.getStrategies(state, restOfAgents);
            } catch (UnknownAgentException e) {
                System.err.println(e.toString());
                evalStack.push(new HashSet<>());
                return;
            }

            for (Map<Integer, Set<String>> rawstrat : agentsStrategies) {
                Set<String> strat = Intersection.intersect(rawstrat.values());
                boolean allParsingReturnsTrue = true;
                for (Set<String> oStrat : otherAgentsStrategies) {
                    Model submodel = model.getShrunkModel(Intersection.intersect(strat, oStrat));
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
                printValidStrat(strat, rawstrat, agents, state, formula);
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

    @Override
    public void enterGrAnnouncement(FormulaGrammarParser.GrAnnouncementContext ctx) {
        List<Integer> agents = new ArrayList<>();
        for (FormulaGrammarParser.AgentidContext aCtx : ctx.agentlist().agentid()) {
            agents.add(Integer.valueOf(aCtx.getText()));
        }
        String formula = ctx.galformula().getText();

        Set<String> result = new HashSet<>();
        for (String state : model.getAllStates()) {
            Set<Map<Integer, Set<String>>> strats;
            try {
                strats = model.getDetailedStrategies(state, agents);
            } catch (UnknownAgentException e) {
                System.err.println(e.toString());
                evalStack.push(new HashSet<>());
                return;
            }
            for (Map<Integer, Set<String>> rawstrat : strats) {
                Set<String> strat = Intersection.intersect(rawstrat.values());
                Model submodel = model.getShrunkModel(strat);
                if (ModelChecker.evalFormula(submodel, formula).contains(state)) {
                    printValidStrat(strat, rawstrat, agents, state, formula);
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
    public void exitPalformula(FormulaGrammarParser.PalformulaContext ctx) {
        // states where the announcement is true
        Set<String> trueStates = evalStack.pop();
        Set<String> falseStates = model.getAllStates();
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

    @Override
    public void exitKnowledge(FormulaGrammarParser.KnowledgeContext ctx) {
        Set<String> innerTrueZone = evalStack.pop();
        int agent = Integer.valueOf(ctx.agentid().getText());
        Set<String> result = new HashSet<>();

        List<Set<String>> equivClasses;
        try {
            equivClasses = model.getEquivClasses(agent);
        } catch (UnknownAgentException e) {
            System.err.println(e.toString());
            evalStack.push(new HashSet<>());
            return;
        }

        for (Set<String> equivClass : equivClasses) {
            if (innerTrueZone.containsAll(equivClass))    // if all state in the cluster is in the true states zone
                result.addAll(equivClass);
        }

        // push the result to the stack
        evalStack.push(result);
    }

    /**
     * Pushes to return stack the value of a Implication, which is the logical sequence of two subformula.
     * Definitively, (a -> b) is (!a or b), which is how this is implemented as well.
     */
    @Override
    public void exitImplication(FormulaGrammarParser.ImplicationContext ctx) {
        Set<String> b = evalStack.pop();
        Set<String> a = evalStack.pop();
        Set<String> result = model.getAllStates();
        // !a:
        result.removeAll(a);
        // !a or b:
        result.addAll(b);
        evalStack.push(result);
    }

    /**
     * Pushes to the return stack the Negation of the proposition,
     * i.e. the complement of the set in regard of the whole set of states in the model.
     */
    @Override
    public void exitNegation(FormulaGrammarParser.NegationContext ctx) {
        Set<String> negation = model.getAllStates();
        Set<String> previous = evalStack.pop();
        negation.removeAll(previous);
        evalStack.push(negation);
    }

    /**
     * Pushes to the return stack the value of a Conjunction ("or"),
     * which is the Intersection of the two subformula's results currently on top of the stack.
     */
    @Override
    public void exitConjunction(FormulaGrammarParser.ConjunctionContext ctx) {
        Set<String> right = evalStack.pop();
        Set<String> left = evalStack.pop();
        evalStack.push(Intersection.intersect(left, right));
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
     * The base case method, where a proposition (an ID in terms of token) is examined, and
     * a set of states where the proposition holds is pushed into the return stack evalStack.
     */
    @Override
    public void exitAtom(FormulaGrammarParser.AtomContext ctx) {
        Set<String> validStates = model.getStates(ctx.ID().getText());
        evalStack.push(validStates);
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
