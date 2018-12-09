package mccal.model.modelreader;

import java.util.*;
import org.antlr.v4.runtime.tree.TerminalNode;
import mccal.model.*;
import mccal.model.modelreader.antlr.*;

/**
 * ModelExtractor is a Listener that generates a Model object from the parse tree.
 * There is a walker traversing the parse tree while the ModelExtractor listens to the various events happening,
 * i.e when entering/exiting the rules.
 */

public class ModelExtractor extends ModelGrammarBaseListener {
    private ModelGrammarParser parser;
    // the model to build
    private Model model = new Model();
    // the id of the current atom being parsed
    private String curAtom;
    // a list of states that the current atom points to
    private Set<String> curStateSet;

    public ModelExtractor(ModelGrammarParser p) {
        this.parser = p;
    }

    /**
     * Sets the number of agents when the parser enter the nofagents rule.
     * Accesses the node from the context and then extract the value
     */
    @Override
    public void enterNofagents(ModelGrammarParser.NofagentsContext ctx) {
        model.setNumberOfAgents(Integer.parseInt(ctx.NONZEROINT().getText()));
    }

    /**
     * Stores global states when entering the definition of a set of states.
     * Iterates through the nodes(tokens) to extract each state
     */
    @Override
    public void enterStatesdef(ModelGrammarParser.StatesdefContext ctx) {
        for (TerminalNode i : ctx.ID()) {
            String curState = i.getText();
            model.addGlobalState(curState);
        }
    }

    /**
     * Registers a explicit equivalence relation i.e. specified in the model file.
     * TODO revision needed - replicated method with addRelation?
     */
    @Override
    public void enterEdge(ModelGrammarParser.EdgeContext ctx) {
        Integer agent = Integer.parseInt(ctx.NONZEROINT().getText());
        model.addRelation(agent, ctx.ID().get(0).getText(), ctx.ID().get(1).getText());
    }

    /**
     * Registers the implicit equivalence relations i.e. self-mapping.
     * Happens after all equivalence relations are added.
     */
    @Override
    public void exitReldef(ModelGrammarParser.ReldefContext ctx) {
        List<String> states = model.getAllStates();
        for (String s : states) {
            for (int agent = 1; agent <= model.getNumberOfAgents(); agent++) {
                model.addRelation(agent, s, s);
            }
        }
    }

    @Override
    public void enterSingledef(ModelGrammarParser.SingledefContext ctx) {
        curAtom = ctx.ID().getText();
        curStateSet = new HashSet<>();
    }

    @Override
    public void enterGstateslist(ModelGrammarParser.GstateslistContext ctx) {
        for (TerminalNode id : ctx.ID()) {
            curStateSet.add(id.getText());
        }
    }

    /**
     * Stores an atom and registers the set of states where the proposition is specified to be true in the model
     * with the help of enterAtom and enterStateslist, which perform initialisation of a set of states and
     * registration of a state into the set respectively
     */
    @Override
    public void exitSingledef(ModelGrammarParser.SingledefContext ctx) {
        model.addAtoms(curAtom, curStateSet);
    }

    public Model getModel() {
        return model;
    }
}
