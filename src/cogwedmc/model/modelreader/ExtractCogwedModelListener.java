package cogwedmc.model.modelreader;

import java.util.*;

import org.antlr.v4.runtime.tree.TerminalNode;

import cogwedmc.model.*;
import cogwedmc.model.modelreader.antlr.*;

/* Franco 130721
   A Listener to generate a CogwedModel object from the parse tree.
   This is the only complicated part. There is a walker traversing
   the parse tree and we need to listen to the various events 
   (entering/exiting rules).

*/
public class ExtractCogwedModelListener
        extends CogwedModelGrammarBaseListener {
    private CogwedModelGrammarParser parser;

    // This is the model we want to build.
    private CogwedModel cogwedmodel;

    // Temporarily storing number of agents
    //private int numAgent;
    // Temporarily storing all states for constructing implicit relations
    //List<String> gStates;


    // Some variables to store temporary values.    
    // the id of the current global state
    //private String curGStateID;
    /*
    // A list of local states;
    private List<String> curLStateList = new ArrayList<String>();
    */
    // the id of the current atom
    private String curAtom;
    // A list of global states
    private Set<String> curGStateList = new HashSet<String>();


    public ExtractCogwedModelListener(CogwedModelGrammarParser p) {
        this.parser = p;
        // In the constructor we create an empty model.
        cogwedmodel = new CogwedModel();
    }

    // Just setting the number of agents: this is easy, when the parser enter
    // the nofagents rule, we get them (the way to do this is a bit complicated,
    // we need to get the context and then extract the value from this, but the
    // idea is simple).
    @Override
    public void enterNofagents(CogwedModelGrammarParser.NofagentsContext ctx) {
        cogwedmodel.setNumberOfAgents(Integer.parseInt(ctx.NONZEROINT().getText()));
    }



    // This is to store global states.
    // Entering the definition of a global state
    @Override
    public void enterStatesdef(cogwedmc.model.modelreader.antlr.CogwedModelGrammarParser.StatesdefContext ctx) {
        for (TerminalNode i : ctx.ID()) {
            String curState = i.getText();
            cogwedmodel.addGlobalState(curState);
        }
    }

    /*
    // Entering the definition of a list of local states
    @Override
    public void enterLstateslist(cogwedmc.model.modelreader.antlr.CogwedModelGrammarParser.LstateslistContext ctx) {
        for (TerminalNode id : ctx.ID()) {
            curLStateList.add(id.getText());
        }
    }

    // Exiting the definition of a global state
    @Override
    public void exitStatedef(cogwedmc.model.modelreader.antlr.CogwedModelGrammarParser.StatedefContext ctx) {
        cogwedmodel.addGlobalState(new String(curGStateID), new ArrayList<String>(curLStateList));
    }
    // All done with global states
    */


    // Add the relation to rk
    @Override
    public void enterEdge(CogwedModelGrammarParser.EdgeContext ctx) {
        Integer agent = Integer.parseInt(ctx.NONZEROINT().getText());
        cogwedmodel.addRelation(agent, ctx.ID().get(0).getText(), ctx.ID().get(1).getText());
    }

    // Add implicit relations

    @Override
    public void exitReldef(CogwedModelGrammarParser.ReldefContext ctx) {
        List<String> states = cogwedmodel.getAllStates();
        for (String s : states) {
            for (int agent = 1; agent <= cogwedmodel.getNumberOfAgents(); agent++) {
                cogwedmodel.addRelation(agent, s, s);
            }
        }
    }


    // Finally, we need to get the list of atoms. This is similar to the list of local states above.
    // The relevant rules are: atoms, singledef, and gstateslist.

    @Override
    public void enterSingledef(CogwedModelGrammarParser.SingledefContext ctx) {
        curAtom = ctx.ID().getText();
        curGStateList.clear();
    }

    @Override
    public void enterGstateslist(CogwedModelGrammarParser.GstateslistContext ctx) {
        for (TerminalNode id : ctx.ID()) {
            curGStateList.add(id.getText());
        }
    }

    @Override
    public void exitSingledef(CogwedModelGrammarParser.SingledefContext ctx) {
        cogwedmodel.addAtom(new String(curAtom), new HashSet<String>(curGStateList));
    }

    // A simple getter to retrieve the model.
    public CogwedModel getModel() {
        return cogwedmodel;
    }

}
