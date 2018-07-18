// Generated from /Users/franco/college/mysoft/mccogwed/src/grammars/CogwedModelGrammar.g by ANTLR 4.5
package cogwedmc.model.modelreader.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CogwedModelGrammarParser}.
 */
public interface CogwedModelGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CogwedModelGrammarParser#cogwed_model_file}.
	 * @param ctx the parse tree
	 */
	void enterCogwed_model_file(CogwedModelGrammarParser.Cogwed_model_fileContext ctx);
	/**
	 * Exit a parse tree produced by {@link CogwedModelGrammarParser#cogwed_model_file}.
	 * @param ctx the parse tree
	 */
	void exitCogwed_model_file(CogwedModelGrammarParser.Cogwed_model_fileContext ctx);
	/**
	 * Enter a parse tree produced by {@link CogwedModelGrammarParser#nofagents}.
	 * @param ctx the parse tree
	 */
	void enterNofagents(CogwedModelGrammarParser.NofagentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CogwedModelGrammarParser#nofagents}.
	 * @param ctx the parse tree
	 */
	void exitNofagents(CogwedModelGrammarParser.NofagentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CogwedModelGrammarParser#statesdef}.
	 * @param ctx the parse tree
	 */
	void enterStatesdef(CogwedModelGrammarParser.StatesdefContext ctx);
	/**
	 * Exit a parse tree produced by {@link CogwedModelGrammarParser#statesdef}.
	 * @param ctx the parse tree
	 */
	void exitStatesdef(CogwedModelGrammarParser.StatesdefContext ctx);
	/**
	 * Enter a parse tree produced by {@link CogwedModelGrammarParser#reldef}.
	 * @param ctx the parse tree
	 */
	//void enterStatedef(CogwedModelGrammarParser.StatedefContext ctx);
	/**
	 * Exit a parse tree produced by {@link CogwedModelGrammarParser#statedef}.
	 * @param ctx the parse tree
	 */
	//void exitStatedef(CogwedModelGrammarParser.StatedefContext ctx);
	/**
	 * Enter a parse tree produced by {@link CogwedModelGrammarParser#lstateslist}.
	 * @param ctx the parse tree
	 */
	//void enterLstateslist(CogwedModelGrammarParser.LstateslistContext ctx);
	/**
	 * Exit a parse tree produced by {@link CogwedModelGrammarParser#lstateslist}.
	 * @param ctx the parse tree
	 */
	//void exitLstateslist(CogwedModelGrammarParser.LstateslistContext ctx);
	/**
	 * Enter a parse tree produced by { CogwedModelGrammarParser#tempreldef}.
	 * @param ctx the parse tree
	 */
	void enterReldef(CogwedModelGrammarParser.ReldefContext ctx);
	/**
	 * Exit a parse tree produced by {@link CogwedModelGrammarParser#reldef}.
	 * @param ctx the parse tree
	 */
	void exitReldef(CogwedModelGrammarParser.ReldefContext ctx);
	/**
	 * Enter a parse tree produced by {@link CogwedModelGrammarParser#edge}.
	 * @param ctx the parse tree
	 */
	void enterEdge(CogwedModelGrammarParser.EdgeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CogwedModelGrammarParser#edge}.
	 * @param ctx the parse tree
	 */
	void exitEdge(CogwedModelGrammarParser.EdgeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CogwedModelGrammarParser#atomsdef}.
	 * @param ctx the parse tree
	 */
	void enterAtomsdef(CogwedModelGrammarParser.AtomsdefContext ctx);
	/**
	 * Exit a parse tree produced by {@link CogwedModelGrammarParser#atomsdef}.
	 * @param ctx the parse tree
	 */
	void exitAtomsdef(CogwedModelGrammarParser.AtomsdefContext ctx);
	/**
	 * Enter a parse tree produced by {@link CogwedModelGrammarParser#singledef}.
	 * @param ctx the parse tree
	 */
	void enterSingledef(CogwedModelGrammarParser.SingledefContext ctx);
	/**
	 * Exit a parse tree produced by {@link CogwedModelGrammarParser#singledef}.
	 * @param ctx the parse tree
	 */
	void exitSingledef(CogwedModelGrammarParser.SingledefContext ctx);
	/**
	 * Enter a parse tree produced by {@link CogwedModelGrammarParser#gstateslist}.
	 * @param ctx the parse tree
	 */
	void enterGstateslist(CogwedModelGrammarParser.GstateslistContext ctx);
	/**
	 * Exit a parse tree produced by {@link CogwedModelGrammarParser#gstateslist}.
	 * @param ctx the parse tree
	 */
	void exitGstateslist(CogwedModelGrammarParser.GstateslistContext ctx);
}