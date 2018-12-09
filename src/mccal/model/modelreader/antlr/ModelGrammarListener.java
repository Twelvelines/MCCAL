package mccal.model.modelreader.antlr;// Generated from ModelGrammar.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ModelGrammarParser}.
 */
public interface ModelGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ModelGrammarParser#model_file}.
	 * @param ctx the parse tree
	 */
	void enterModel_file(ModelGrammarParser.model_fileContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelGrammarParser#model_file}.
	 * @param ctx the parse tree
	 */
	void exitModel_file(ModelGrammarParser.model_fileContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelGrammarParser#nofagents}.
	 * @param ctx the parse tree
	 */
	void enterNofagents(ModelGrammarParser.NofagentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelGrammarParser#nofagents}.
	 * @param ctx the parse tree
	 */
	void exitNofagents(ModelGrammarParser.NofagentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelGrammarParser#statesdef}.
	 * @param ctx the parse tree
	 */
	void enterStatesdef(ModelGrammarParser.StatesdefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelGrammarParser#statesdef}.
	 * @param ctx the parse tree
	 */
	void exitStatesdef(ModelGrammarParser.StatesdefContext ctx);
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
	 * Enter a parse tree produced by {@link ModelGrammarParser#atomsdef}.
	 * @param ctx the parse tree
	 */
	void enterAtomsdef(ModelGrammarParser.AtomsdefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelGrammarParser#atomsdef}.
	 * @param ctx the parse tree
	 */
	void exitAtomsdef(ModelGrammarParser.AtomsdefContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelGrammarParser#singledef}.
	 * @param ctx the parse tree
	 */
	void enterSingledef(ModelGrammarParser.SingledefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelGrammarParser#singledef}.
	 * @param ctx the parse tree
	 */
	void exitSingledef(ModelGrammarParser.SingledefContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelGrammarParser#gstateslist}.
	 * @param ctx the parse tree
	 */
	void enterGstateslist(ModelGrammarParser.GstateslistContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelGrammarParser#gstateslist}.
	 * @param ctx the parse tree
	 */
	void exitGstateslist(ModelGrammarParser.GstateslistContext ctx);
}