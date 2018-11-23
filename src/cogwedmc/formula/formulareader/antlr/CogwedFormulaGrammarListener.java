package cogwedmc.formula.formulareader.antlr;// Generated from CogwedFormulaGrammar.g by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CogwedFormulaGrammarParser}.
 */
public interface CogwedFormulaGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CogwedFormulaGrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(CogwedFormulaGrammarParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link CogwedFormulaGrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(CogwedFormulaGrammarParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parens}
	 * labeled alternative in {@link CogwedFormulaGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterParens(CogwedFormulaGrammarParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link CogwedFormulaGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitParens(CogwedFormulaGrammarParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Disjunction}
	 * labeled alternative in {@link CogwedFormulaGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterDisjunction(CogwedFormulaGrammarParser.DisjunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Disjunction}
	 * labeled alternative in {@link CogwedFormulaGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitDisjunction(CogwedFormulaGrammarParser.DisjunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Negation}
	 * labeled alternative in {@link CogwedFormulaGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterNegation(CogwedFormulaGrammarParser.NegationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Negation}
	 * labeled alternative in {@link CogwedFormulaGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitNegation(CogwedFormulaGrammarParser.NegationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Announcement}
	 * labeled alternative in {@link CogwedFormulaGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterAnnouncement(CogwedFormulaGrammarParser.AnnouncementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Announcement}
	 * labeled alternative in {@link CogwedFormulaGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitAnnouncement(CogwedFormulaGrammarParser.AnnouncementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Conjunction}
	 * labeled alternative in {@link CogwedFormulaGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterConjunction(CogwedFormulaGrammarParser.ConjunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Conjunction}
	 * labeled alternative in {@link CogwedFormulaGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitConjunction(CogwedFormulaGrammarParser.ConjunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code id}
	 * labeled alternative in {@link CogwedFormulaGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterId(CogwedFormulaGrammarParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code id}
	 * labeled alternative in {@link CogwedFormulaGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitId(CogwedFormulaGrammarParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Knowledge}
	 * labeled alternative in {@link CogwedFormulaGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterKnowledge(CogwedFormulaGrammarParser.KnowledgeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Knowledge}
	 * labeled alternative in {@link CogwedFormulaGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitKnowledge(CogwedFormulaGrammarParser.KnowledgeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Coalitional_announcement}
	 * labeled alternative in {@link CogwedFormulaGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterCoalitional_announcement(CogwedFormulaGrammarParser.Coalitional_announcementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Coalitional_announcement}
	 * labeled alternative in {@link CogwedFormulaGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitCoalitional_announcement(CogwedFormulaGrammarParser.Coalitional_announcementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Implication}
	 * labeled alternative in {@link CogwedFormulaGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterImplication(CogwedFormulaGrammarParser.ImplicationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Implication}
	 * labeled alternative in {@link CogwedFormulaGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitImplication(CogwedFormulaGrammarParser.ImplicationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CogwedFormulaGrammarParser#an_formula}.
	 * @param ctx the parse tree
	 */
	void enterAn_formula(CogwedFormulaGrammarParser.An_formulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link CogwedFormulaGrammarParser#an_formula}.
	 * @param ctx the parse tree
	 */
	void exitAn_formula(CogwedFormulaGrammarParser.An_formulaContext ctx);
	/**
	 * Enter a parse tree produced by {@link CogwedFormulaGrammarParser#ca_formula}.
	 * @param ctx the parse tree
	 */
	void enterCa_formula(CogwedFormulaGrammarParser.Ca_formulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link CogwedFormulaGrammarParser#ca_formula}.
	 * @param ctx the parse tree
	 */
	void exitCa_formula(CogwedFormulaGrammarParser.Ca_formulaContext ctx);
	/**
	 * Enter a parse tree produced by {@link CogwedFormulaGrammarParser#agentid}.
	 * @param ctx the parse tree
	 */
	void enterAgentid(CogwedFormulaGrammarParser.AgentidContext ctx);
	/**
	 * Exit a parse tree produced by {@link CogwedFormulaGrammarParser#agentid}.
	 * @param ctx the parse tree
	 */
	void exitAgentid(CogwedFormulaGrammarParser.AgentidContext ctx);
	/**
	 * Enter a parse tree produced by {@link CogwedFormulaGrammarParser#agentlist}.
	 * @param ctx the parse tree
	 */
	void enterAgentlist(CogwedFormulaGrammarParser.AgentlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link CogwedFormulaGrammarParser#agentlist}.
	 * @param ctx the parse tree
	 */
	void exitAgentlist(CogwedFormulaGrammarParser.AgentlistContext ctx);
}