// Generated from CogwedFormulaGrammar.g by ANTLR 4.7.1
package cogwedmc.formula.formulareader.antlr;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CogwedFormulaGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, INT=15, WS=16, LINE_COMMENT=17, 
		COMMENT=18, ID=19;
	public static final int
		RULE_start = 0, RULE_formula = 1, RULE_an_formula = 2, RULE_agentid = 3, 
		RULE_agentlist = 4;
	public static final String[] ruleNames = {
		"start", "formula", "an_formula", "agentid", "agentlist"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'!'", "'not'", "'and'", "'or'", "'implies'", "'->'", "'('", "')'", 
		"'K'", "','", "'['", "']'", "'<<'", "'>>'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, "INT", "WS", "LINE_COMMENT", "COMMENT", "ID"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "CogwedFormulaGrammar.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CogwedFormulaGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CogwedFormulaGrammarListener ) ((CogwedFormulaGrammarListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CogwedFormulaGrammarListener ) ((CogwedFormulaGrammarListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(10);
			formula(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormulaContext extends ParserRuleContext {
		public FormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formula; }
	 
		public FormulaContext() { }
		public void copyFrom(FormulaContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ParensContext extends FormulaContext {
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public ParensContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CogwedFormulaGrammarListener ) ((CogwedFormulaGrammarListener)listener).enterParens(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CogwedFormulaGrammarListener ) ((CogwedFormulaGrammarListener)listener).exitParens(this);
		}
	}
	public static class DisjunctionContext extends FormulaContext {
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public DisjunctionContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CogwedFormulaGrammarListener ) ((CogwedFormulaGrammarListener)listener).enterDisjunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CogwedFormulaGrammarListener ) ((CogwedFormulaGrammarListener)listener).exitDisjunction(this);
		}
	}
	public static class NegationContext extends FormulaContext {
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public NegationContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CogwedFormulaGrammarListener ) ((CogwedFormulaGrammarListener)listener).enterNegation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CogwedFormulaGrammarListener ) ((CogwedFormulaGrammarListener)listener).exitNegation(this);
		}
	}
	public static class AnnouncementContext extends FormulaContext {
		public An_formulaContext an_formula() {
			return getRuleContext(An_formulaContext.class,0);
		}
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public AnnouncementContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CogwedFormulaGrammarListener ) ((CogwedFormulaGrammarListener)listener).enterAnnouncement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CogwedFormulaGrammarListener ) ((CogwedFormulaGrammarListener)listener).exitAnnouncement(this);
		}
	}
	public static class ConjunctionContext extends FormulaContext {
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public ConjunctionContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CogwedFormulaGrammarListener ) ((CogwedFormulaGrammarListener)listener).enterConjunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CogwedFormulaGrammarListener ) ((CogwedFormulaGrammarListener)listener).exitConjunction(this);
		}
	}
	public static class IdContext extends FormulaContext {
		public TerminalNode ID() { return getToken(CogwedFormulaGrammarParser.ID, 0); }
		public IdContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CogwedFormulaGrammarListener ) ((CogwedFormulaGrammarListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CogwedFormulaGrammarListener ) ((CogwedFormulaGrammarListener)listener).exitId(this);
		}
	}
	public static class KnowledgeContext extends FormulaContext {
		public AgentidContext agentid() {
			return getRuleContext(AgentidContext.class,0);
		}
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public KnowledgeContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CogwedFormulaGrammarListener ) ((CogwedFormulaGrammarListener)listener).enterKnowledge(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CogwedFormulaGrammarListener ) ((CogwedFormulaGrammarListener)listener).exitKnowledge(this);
		}
	}
	public static class Coalitional_announcementContext extends FormulaContext {
		public AgentlistContext agentlist() {
			return getRuleContext(AgentlistContext.class,0);
		}
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public Coalitional_announcementContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CogwedFormulaGrammarListener ) ((CogwedFormulaGrammarListener)listener).enterCoalitional_announcement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CogwedFormulaGrammarListener ) ((CogwedFormulaGrammarListener)listener).exitCoalitional_announcement(this);
		}
	}
	public static class ImplicationContext extends FormulaContext {
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public ImplicationContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CogwedFormulaGrammarListener ) ((CogwedFormulaGrammarListener)listener).enterImplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CogwedFormulaGrammarListener ) ((CogwedFormulaGrammarListener)listener).exitImplication(this);
		}
	}

	public final FormulaContext formula() throws RecognitionException {
		return formula(0);
	}

	private FormulaContext formula(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FormulaContext _localctx = new FormulaContext(_ctx, _parentState);
		FormulaContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_formula, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
				{
				_localctx = new NegationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(13);
				_la = _input.LA(1);
				if ( !(_la==T__0 || _la==T__1) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(14);
				formula(9);
				}
				break;
			case T__6:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(15);
				match(T__6);
				setState(16);
				formula(0);
				setState(17);
				match(T__7);
				}
				break;
			case T__8:
				{
				_localctx = new KnowledgeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(19);
				match(T__8);
				setState(20);
				match(T__6);
				setState(21);
				agentid();
				setState(22);
				match(T__9);
				setState(23);
				formula(0);
				setState(24);
				match(T__7);
				}
				break;
			case T__10:
				{
				_localctx = new AnnouncementContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(26);
				match(T__10);
				setState(27);
				an_formula();
				setState(28);
				match(T__11);
				setState(29);
				formula(3);
				}
				break;
			case T__12:
				{
				_localctx = new Coalitional_announcementContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(31);
				match(T__12);
				setState(32);
				agentlist();
				setState(33);
				match(T__13);
				setState(34);
				formula(2);
				}
				break;
			case ID:
				{
				_localctx = new IdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(36);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(50);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(48);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new ConjunctionContext(new FormulaContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(39);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(40);
						match(T__2);
						setState(41);
						formula(9);
						}
						break;
					case 2:
						{
						_localctx = new DisjunctionContext(new FormulaContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(42);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(43);
						match(T__3);
						setState(44);
						formula(8);
						}
						break;
					case 3:
						{
						_localctx = new ImplicationContext(new FormulaContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(45);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(46);
						_la = _input.LA(1);
						if ( !(_la==T__4 || _la==T__5) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(47);
						formula(7);
						}
						break;
					}
					} 
				}
				setState(52);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class An_formulaContext extends ParserRuleContext {
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public An_formulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_an_formula; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CogwedFormulaGrammarListener ) ((CogwedFormulaGrammarListener)listener).enterAn_formula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CogwedFormulaGrammarListener ) ((CogwedFormulaGrammarListener)listener).exitAn_formula(this);
		}
	}

	public final An_formulaContext an_formula() throws RecognitionException {
		An_formulaContext _localctx = new An_formulaContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_an_formula);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			formula(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AgentidContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(CogwedFormulaGrammarParser.INT, 0); }
		public AgentidContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_agentid; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CogwedFormulaGrammarListener ) ((CogwedFormulaGrammarListener)listener).enterAgentid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CogwedFormulaGrammarListener ) ((CogwedFormulaGrammarListener)listener).exitAgentid(this);
		}
	}

	public final AgentidContext agentid() throws RecognitionException {
		AgentidContext _localctx = new AgentidContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_agentid);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AgentlistContext extends ParserRuleContext {
		public List<AgentidContext> agentid() {
			return getRuleContexts(AgentidContext.class);
		}
		public AgentidContext agentid(int i) {
			return getRuleContext(AgentidContext.class,i);
		}
		public AgentlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_agentlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CogwedFormulaGrammarListener ) ((CogwedFormulaGrammarListener)listener).enterAgentlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CogwedFormulaGrammarListener ) ((CogwedFormulaGrammarListener)listener).exitAgentlist(this);
		}
	}

	public final AgentlistContext agentlist() throws RecognitionException {
		AgentlistContext _localctx = new AgentlistContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_agentlist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			agentid();
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(58);
				match(T__9);
				setState(59);
				agentid();
				}
				}
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return formula_sempred((FormulaContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean formula_sempred(FormulaContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 8);
		case 1:
			return precpred(_ctx, 7);
		case 2:
			return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\25D\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3("+
		"\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3\63\n\3\f\3\16\3\66\13\3\3"+
		"\4\3\4\3\5\3\5\3\6\3\6\3\6\7\6?\n\6\f\6\16\6B\13\6\3\6\2\3\4\7\2\4\6\b"+
		"\n\2\4\3\2\3\4\3\2\7\b\2G\2\f\3\2\2\2\4\'\3\2\2\2\6\67\3\2\2\2\b9\3\2"+
		"\2\2\n;\3\2\2\2\f\r\5\4\3\2\r\3\3\2\2\2\16\17\b\3\1\2\17\20\t\2\2\2\20"+
		"(\5\4\3\13\21\22\7\t\2\2\22\23\5\4\3\2\23\24\7\n\2\2\24(\3\2\2\2\25\26"+
		"\7\13\2\2\26\27\7\t\2\2\27\30\5\b\5\2\30\31\7\f\2\2\31\32\5\4\3\2\32\33"+
		"\7\n\2\2\33(\3\2\2\2\34\35\7\r\2\2\35\36\5\6\4\2\36\37\7\16\2\2\37 \5"+
		"\4\3\5 (\3\2\2\2!\"\7\17\2\2\"#\5\n\6\2#$\7\20\2\2$%\5\4\3\4%(\3\2\2\2"+
		"&(\7\25\2\2\'\16\3\2\2\2\'\21\3\2\2\2\'\25\3\2\2\2\'\34\3\2\2\2\'!\3\2"+
		"\2\2\'&\3\2\2\2(\64\3\2\2\2)*\f\n\2\2*+\7\5\2\2+\63\5\4\3\13,-\f\t\2\2"+
		"-.\7\6\2\2.\63\5\4\3\n/\60\f\b\2\2\60\61\t\3\2\2\61\63\5\4\3\t\62)\3\2"+
		"\2\2\62,\3\2\2\2\62/\3\2\2\2\63\66\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2"+
		"\65\5\3\2\2\2\66\64\3\2\2\2\678\5\4\3\28\7\3\2\2\29:\7\21\2\2:\t\3\2\2"+
		"\2;@\5\b\5\2<=\7\f\2\2=?\5\b\5\2><\3\2\2\2?B\3\2\2\2@>\3\2\2\2@A\3\2\2"+
		"\2A\13\3\2\2\2B@\3\2\2\2\6\'\62\64@";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}