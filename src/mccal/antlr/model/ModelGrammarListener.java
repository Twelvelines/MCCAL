package mccal.antlr.model;// Generated from ModelGrammar.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ModelGrammarParser}.
 */
public interface ModelGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ModelGrammarParser#modelfile}.
	 * @param ctx the parse tree
	 */
	void enterModelfile(ModelGrammarParser.ModelfileContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelGrammarParser#modelfile}.
	 * @param ctx the parse tree
	 */
	void exitModelfile(ModelGrammarParser.ModelfileContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelGrammarParser#numagents}.
	 * @param ctx the parse tree
	 */
	void enterNumagents(ModelGrammarParser.NumagentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelGrammarParser#numagents}.
	 * @param ctx the parse tree
	 */
	void exitNumagents(ModelGrammarParser.NumagentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelGrammarParser#allstates}.
	 * @param ctx the parse tree
	 */
	void enterAllstates(ModelGrammarParser.AllstatesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelGrammarParser#allstates}.
	 * @param ctx the parse tree
	 */
	void exitAllstates(ModelGrammarParser.AllstatesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelGrammarParser#reldef}.
	 * @param ctx the parse tree
	 */
	void enterReldef(ModelGrammarParser.ReldefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelGrammarParser#reldef}.
	 * @param ctx the parse tree
	 */
	void exitReldef(ModelGrammarParser.ReldefContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelGrammarParser#edge}.
	 * @param ctx the parse tree
	 */
	void enterEdge(ModelGrammarParser.EdgeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelGrammarParser#edge}.
	 * @param ctx the parse tree
	 */
	void exitEdge(ModelGrammarParser.EdgeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelGrammarParser#propositions}.
	 * @param ctx the parse tree
	 */
	void enterPropositions(ModelGrammarParser.PropositionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelGrammarParser#propositions}.
	 * @param ctx the parse tree
	 */
	void exitPropositions(ModelGrammarParser.PropositionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelGrammarParser#prop}.
	 * @param ctx the parse tree
	 */
	void enterProp(ModelGrammarParser.PropContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelGrammarParser#prop}.
	 * @param ctx the parse tree
	 */
	void exitProp(ModelGrammarParser.PropContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelGrammarParser#atoms}.
	 * @param ctx the parse tree
	 */
	void enterAtoms(ModelGrammarParser.AtomsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelGrammarParser#atoms}.
	 * @param ctx the parse tree
	 */
	void exitAtoms(ModelGrammarParser.AtomsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelGrammarParser#statelist}.
	 * @param ctx the parse tree
	 */
	void enterStatelist(ModelGrammarParser.StatelistContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelGrammarParser#statelist}.
	 * @param ctx the parse tree
	 */
	void exitStatelist(ModelGrammarParser.StatelistContext ctx);
}