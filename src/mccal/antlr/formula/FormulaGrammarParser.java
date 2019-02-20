package mccal.antlr.formula;// Generated from FormulaGrammar.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FormulaGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, INT=15, WS=16, LINE_COMMENT=17, 
		COMMENT=18, ID=19;
	public static final int
		RULE_formula = 0, RULE_galformula = 1, RULE_calformula = 2, RULE_agentid = 3, 
		RULE_agentlist = 4;
	public static final String[] ruleNames = {
		"formula", "galformula", "calformula", "agentid", "agentlist"
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
	public String getGrammarFileName() { return "FormulaGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FormulaGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
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
			if ( listener instanceof FormulaGrammarListener ) ((FormulaGrammarListener)listener).enterParens(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaGrammarListener ) ((FormulaGrammarListener)listener).exitParens(this);
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
			if ( listener instanceof FormulaGrammarListener ) ((FormulaGrammarListener)listener).enterDisjunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaGrammarListener ) ((FormulaGrammarListener)listener).exitDisjunction(this);
		}
	}
	public static class NegationContext extends FormulaContext {
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public NegationContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaGrammarListener ) ((FormulaGrammarListener)listener).enterNegation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaGrammarListener ) ((FormulaGrammarListener)listener).exitNegation(this);
		}
	}
	public static class AnnouncementContext extends FormulaContext {
		public GalformulaContext galformula() {
			return getRuleContext(GalformulaContext.class,0);
		}
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public AnnouncementContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaGrammarListener ) ((FormulaGrammarListener)listener).enterAnnouncement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaGrammarListener ) ((FormulaGrammarListener)listener).exitAnnouncement(this);
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
			if ( listener instanceof FormulaGrammarListener ) ((FormulaGrammarListener)listener).enterConjunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaGrammarListener ) ((FormulaGrammarListener)listener).exitConjunction(this);
		}
	}
	public static class CoAnnouncementContext extends FormulaContext {
		public AgentlistContext agentlist() {
			return getRuleContext(AgentlistContext.class,0);
		}
		public CalformulaContext calformula() {
			return getRuleContext(CalformulaContext.class,0);
		}
		public CoAnnouncementContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaGrammarListener ) ((FormulaGrammarListener)listener).enterCoAnnouncement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaGrammarListener ) ((FormulaGrammarListener)listener).exitCoAnnouncement(this);
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
			if ( listener instanceof FormulaGrammarListener ) ((FormulaGrammarListener)listener).enterKnowledge(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaGrammarListener ) ((FormulaGrammarListener)listener).exitKnowledge(this);
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
			if ( listener instanceof FormulaGrammarListener ) ((FormulaGrammarListener)listener).enterImplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaGrammarListener ) ((FormulaGrammarListener)listener).exitImplication(this);
		}
	}
	public static class AtomContext extends FormulaContext {
		public TerminalNode ID() { return getToken(FormulaGrammarParser.ID, 0); }
		public AtomContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaGrammarListener ) ((FormulaGrammarListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaGrammarListener ) ((FormulaGrammarListener)listener).exitAtom(this);
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
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_formula, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
				{
				_localctx = new NegationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(11);
				_la = _input.LA(1);
				if ( !(_la==T__0 || _la==T__1) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(12);
				formula(9);
				}
				break;
			case T__6:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(13);
				match(T__6);
				setState(14);
				formula(0);
				setState(15);
				match(T__7);
				}
				break;
			case T__8:
				{
				_localctx = new KnowledgeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(17);
				match(T__8);
				setState(18);
				match(T__6);
				setState(19);
				agentid();
				setState(20);
				match(T__9);
				setState(21);
				formula(0);
				setState(22);
				match(T__7);
				}
				break;
			case T__10:
				{
				_localctx = new AnnouncementContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(24);
				match(T__10);
				setState(25);
				galformula();
				setState(26);
				match(T__11);
				setState(27);
				formula(3);
				}
				break;
			case T__12:
				{
				_localctx = new CoAnnouncementContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(29);
				match(T__12);
				setState(30);
				agentlist();
				setState(31);
				match(T__13);
				setState(32);
				calformula();
				}
				break;
			case ID:
				{
				_localctx = new AtomContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(34);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(48);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(46);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new ConjunctionContext(new FormulaContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(37);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(38);
						match(T__2);
						setState(39);
						formula(9);
						}
						break;
					case 2:
						{
						_localctx = new DisjunctionContext(new FormulaContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(40);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(41);
						match(T__3);
						setState(42);
						formula(8);
						}
						break;
					case 3:
						{
						_localctx = new ImplicationContext(new FormulaContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(43);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(44);
						_la = _input.LA(1);
						if ( !(_la==T__4 || _la==T__5) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(45);
						formula(7);
						}
						break;
					}
					} 
				}
				setState(50);
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

	public static class GalformulaContext extends ParserRuleContext {
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public GalformulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_galformula; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaGrammarListener ) ((FormulaGrammarListener)listener).enterGalformula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaGrammarListener ) ((FormulaGrammarListener)listener).exitGalformula(this);
		}
	}

	public final GalformulaContext galformula() throws RecognitionException {
		GalformulaContext _localctx = new GalformulaContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_galformula);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
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

	public static class CalformulaContext extends ParserRuleContext {
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public CalformulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_calformula; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaGrammarListener ) ((FormulaGrammarListener)listener).enterCalformula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaGrammarListener ) ((FormulaGrammarListener)listener).exitCalformula(this);
		}
	}

	public final CalformulaContext calformula() throws RecognitionException {
		CalformulaContext _localctx = new CalformulaContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_calformula);
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
		public TerminalNode INT() { return getToken(FormulaGrammarParser.INT, 0); }
		public AgentidContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_agentid; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaGrammarListener ) ((FormulaGrammarListener)listener).enterAgentid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaGrammarListener ) ((FormulaGrammarListener)listener).exitAgentid(this);
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
			if ( listener instanceof FormulaGrammarListener ) ((FormulaGrammarListener)listener).enterAgentlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaGrammarListener ) ((FormulaGrammarListener)listener).exitAgentlist(this);
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
		case 0:
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
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2&\n\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2\61\n\2\f\2\16\2\64\13\2\3\3\3\3\3"+
		"\4\3\4\3\5\3\5\3\6\3\6\3\6\7\6?\n\6\f\6\16\6B\13\6\3\6\2\3\2\7\2\4\6\b"+
		"\n\2\4\3\2\3\4\3\2\7\b\2G\2%\3\2\2\2\4\65\3\2\2\2\6\67\3\2\2\2\b9\3\2"+
		"\2\2\n;\3\2\2\2\f\r\b\2\1\2\r\16\t\2\2\2\16&\5\2\2\13\17\20\7\t\2\2\20"+
		"\21\5\2\2\2\21\22\7\n\2\2\22&\3\2\2\2\23\24\7\13\2\2\24\25\7\t\2\2\25"+
		"\26\5\b\5\2\26\27\7\f\2\2\27\30\5\2\2\2\30\31\7\n\2\2\31&\3\2\2\2\32\33"+
		"\7\r\2\2\33\34\5\4\3\2\34\35\7\16\2\2\35\36\5\2\2\5\36&\3\2\2\2\37 \7"+
		"\17\2\2 !\5\n\6\2!\"\7\20\2\2\"#\5\6\4\2#&\3\2\2\2$&\7\25\2\2%\f\3\2\2"+
		"\2%\17\3\2\2\2%\23\3\2\2\2%\32\3\2\2\2%\37\3\2\2\2%$\3\2\2\2&\62\3\2\2"+
		"\2\'(\f\n\2\2()\7\5\2\2)\61\5\2\2\13*+\f\t\2\2+,\7\6\2\2,\61\5\2\2\n-"+
		".\f\b\2\2./\t\3\2\2/\61\5\2\2\t\60\'\3\2\2\2\60*\3\2\2\2\60-\3\2\2\2\61"+
		"\64\3\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2\63\3\3\2\2\2\64\62\3\2\2\2\65"+
		"\66\5\2\2\2\66\5\3\2\2\2\678\5\2\2\28\7\3\2\2\29:\7\21\2\2:\t\3\2\2\2"+
		";@\5\b\5\2<=\7\f\2\2=?\5\b\5\2><\3\2\2\2?B\3\2\2\2@>\3\2\2\2@A\3\2\2\2"+
		"A\13\3\2\2\2B@\3\2\2\2\6%\60\62@";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}