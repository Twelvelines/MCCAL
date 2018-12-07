package mccal.formula.formulareader.antlr;// Generated from FormulaGrammar.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FormulaGrammarParser}.
 */
public interface FormulaGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FormulaGrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(FormulaGrammarParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormulaGrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(FormulaGrammarParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parens}
	 * labeled alternative in {@link FormulaGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterParens(FormulaGrammarParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link FormulaGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitParens(FormulaGrammarParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Disjunction}
	 * labeled alternative in {@link FormulaGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterDisjunction(FormulaGrammarParser.DisjunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Disjunction}
	 * labeled alternative in {@link FormulaGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitDisjunction(FormulaGrammarParser.DisjunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Negation}
	 * labeled alternative in {@link FormulaGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterNegation(FormulaGrammarParser.NegationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Negation}
	 * labeled alternative in {@link FormulaGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitNegation(FormulaGrammarParser.NegationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Announcement}
	 * labeled alternative in {@link FormulaGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterAnnouncement(FormulaGrammarParser.AnnouncementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Announcement}
	 * labeled alternative in {@link FormulaGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitAnnouncement(FormulaGrammarParser.AnnouncementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Conjunction}
	 * labeled alternative in {@link FormulaGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterConjunction(FormulaGrammarParser.ConjunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Conjunction}
	 * labeled alternative in {@link FormulaGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitConjunction(FormulaGrammarParser.ConjunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code id}
	 * labeled alternative in {@link FormulaGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterId(FormulaGrammarParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code id}
	 * labeled alternative in {@link FormulaGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitId(FormulaGrammarParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Knowledge}
	 * labeled alternative in {@link FormulaGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterKnowledge(FormulaGrammarParser.KnowledgeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Knowledge}
	 * labeled alternative in {@link FormulaGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitKnowledge(FormulaGrammarParser.KnowledgeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Coalitional_announcement}
	 * labeled alternative in {@link FormulaGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterCoalitional_announcement(FormulaGrammarParser.Coalitional_announcementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Coalitional_announcement}
	 * labeled alternative in {@link FormulaGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitCoalitional_announcement(FormulaGrammarParser.Coalitional_announcementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Implication}
	 * labeled alternative in {@link FormulaGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterImplication(FormulaGrammarParser.ImplicationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Implication}
	 * labeled alternative in {@link FormulaGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitImplication(FormulaGrammarParser.ImplicationContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormulaGrammarParser#an_formula}.
	 * @param ctx the parse tree
	 */
	void enterAn_formula(FormulaGrammarParser.An_formulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormulaGrammarParser#an_formula}.
	 * @param ctx the parse tree
	 */
	void exitAn_formula(FormulaGrammarParser.An_formulaContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormulaGrammarParser#ca_formula}.
	 * @param ctx the parse tree
	 */
	void enterCa_formula(FormulaGrammarParser.Ca_formulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormulaGrammarParser#ca_formula}.
	 * @param ctx the parse tree
	 */
	void exitCa_formula(FormulaGrammarParser.Ca_formulaContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormulaGrammarParser#agentid}.
	 * @param ctx the parse tree
	 */
	void enterAgentid(FormulaGrammarParser.AgentidContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormulaGrammarParser#agentid}.
	 * @param ctx the parse tree
	 */
	void exitAgentid(FormulaGrammarParser.AgentidContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormulaGrammarParser#agentlist}.
	 * @param ctx the parse tree
	 */
	void enterAgentlist(FormulaGrammarParser.AgentlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormulaGrammarParser#agentlist}.
	 * @param ctx the parse tree
	 */
	void exitAgentlist(FormulaGrammarParser.AgentlistContext ctx);
}