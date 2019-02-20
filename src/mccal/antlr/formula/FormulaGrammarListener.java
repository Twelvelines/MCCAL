package mccal.antlr.formula;// Generated from FormulaGrammar.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FormulaGrammarParser}.
 */
public interface FormulaGrammarListener extends ParseTreeListener {
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
	 * Enter a parse tree produced by the {@code CoAnnouncement}
	 * labeled alternative in {@link FormulaGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterCoAnnouncement(FormulaGrammarParser.CoAnnouncementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CoAnnouncement}
	 * labeled alternative in {@link FormulaGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitCoAnnouncement(FormulaGrammarParser.CoAnnouncementContext ctx);
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
	 * Enter a parse tree produced by the {@code Atom}
	 * labeled alternative in {@link FormulaGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterAtom(FormulaGrammarParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Atom}
	 * labeled alternative in {@link FormulaGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitAtom(FormulaGrammarParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormulaGrammarParser#galformula}.
	 * @param ctx the parse tree
	 */
	void enterGalformula(FormulaGrammarParser.GalformulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormulaGrammarParser#galformula}.
	 * @param ctx the parse tree
	 */
	void exitGalformula(FormulaGrammarParser.GalformulaContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormulaGrammarParser#calformula}.
	 * @param ctx the parse tree
	 */
	void enterCalformula(FormulaGrammarParser.CalformulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormulaGrammarParser#calformula}.
	 * @param ctx the parse tree
	 */
	void exitCalformula(FormulaGrammarParser.CalformulaContext ctx);
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