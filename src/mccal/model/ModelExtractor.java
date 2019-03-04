package mccal.model;

import mccal.antlr.model.ModelGrammarBaseListener;
import mccal.antlr.model.ModelGrammarParser;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A Listener that generates a Model object from the parse tree.
 * There is a walker traversing the parse tree while the ModelExtractor listens to the various events happening,
 * i.e when entering/exiting the rules.
 */
public class ModelExtractor extends ModelGrammarBaseListener {
    private Model model;    // the model to build
    private String curAtom;    // the id of the current atom being parsed
    private Set<String> curStateSet;    // a list of states that the current atom points to

    /**
     * Sets the number of agents when the parser enter the nofagents rule.
     * Accesses the node from the context and then extract the value
     */
    @Override
    public void enterNumagents(ModelGrammarParser.NumagentsContext ctx) {
        model = new Model(Integer.parseInt(ctx.NONZEROINT().getText()));
    }

    /**
     * Stores global states when entering the definition of a set of states.
     * Iterates through the nodes(tokens) to extract each state
     */
    @Override
    public void enterAllstates(ModelGrammarParser.AllstatesContext ctx) {
        for (TerminalNode i : ctx.ID()) {
            String curState = i.getText();
            model.addState(curState);
        }
    }

    /**
     * Registers a explicit equivalence relation i.e. specified in the model file.
     */
    @Override
    public void enterEdge(ModelGrammarParser.EdgeContext ctx) {
        int agent = Integer.parseInt(ctx.NONZEROINT().getText());
        List<TerminalNode> nodeList = ctx.ID();
        if (nodeList.size() < 2) {
            System.err.println("incorrect number of states; edge ignored");
            return;
        } else if (nodeList.size() == 2)
            model.addEquivRelation(agent, nodeList.get(0).getText(), nodeList.get(1).getText());
        // else (.size > 2)
        Set<String> sset = new HashSet<>();
        for (TerminalNode n : nodeList) {
            sset.add(n.getText());
        }
        model.addEquivClass(agent, sset);
    }

    /**
     * Registers the implicit equivalence relations i.e. self-mapping.
     * Happens after all equivalence relations are added.
     */
    @Override
    public void exitReldef(ModelGrammarParser.ReldefContext ctx) {
        Set<String> states = model.getAllStates();
        for (String s : states) {
            for (int agent = 1; agent <= model.getNumberOfAgents(); agent++) {
                model.addEquivRelation(agent, s, s);
            }
        }
    }

    @Override
    public void enterProp(ModelGrammarParser.PropContext ctx) {
        curAtom = ctx.atoms().ID().getText();
        curStateSet = new HashSet<>();
    }

    @Override
    public void enterStatelist(ModelGrammarParser.StatelistContext ctx) {
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
    public void exitProp(ModelGrammarParser.PropContext ctx) {
        model.addAtom(curAtom, curStateSet);
    }

    public Model getModel() {
        return model;
    }
}
