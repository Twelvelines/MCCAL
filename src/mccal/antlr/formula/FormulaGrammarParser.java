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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, INT=20, WS=21, LINE_COMMENT=22, COMMENT=23, ID=24;
	public static final int
		RULE_formula = 0, RULE_palformula = 1, RULE_galformula = 2, RULE_calformula = 3, 
		RULE_agentid = 4, RULE_agentlist = 5;
	public static final String[] ruleNames = {
		"formula", "palformula", "galformula", "calformula", "agentid", "agentlist"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'!'", "'not'", "'&'", "'and'", "'|'", "'or'", "'implies'", "'->'", 
		"'('", "')'", "'/<'", "'K'", "','", "'['", "']'", "'<'", "'>'", "'<<'", 
		"'>>'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, "INT", "WS", "LINE_COMMENT", 
		"COMMENT", "ID"
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
	public static class PuAnnouncementContext extends FormulaContext {
		public PalformulaContext palformula() {
			return getRuleContext(PalformulaContext.class,0);
		}
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public PuAnnouncementContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaGrammarListener ) ((FormulaGrammarListener)listener).enterPuAnnouncement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaGrammarListener ) ((FormulaGrammarListener)listener).exitPuAnnouncement(this);
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
	public static class GrAnnouncementContext extends FormulaContext {
		public AgentlistContext agentlist() {
			return getRuleContext(AgentlistContext.class,0);
		}
		public GalformulaContext galformula() {
			return getRuleContext(GalformulaContext.class,0);
		}
		public GrAnnouncementContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaGrammarListener ) ((FormulaGrammarListener)listener).enterGrAnnouncement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaGrammarListener ) ((FormulaGrammarListener)listener).exitGrAnnouncement(this);
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
			setState(42);
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
				formula(10);
				}
				break;
			case T__8:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(15);
				match(T__8);
				setState(16);
				formula(0);
				setState(17);
				match(T__9);
				}
				break;
			case T__10:
			case T__11:
				{
				_localctx = new KnowledgeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(19);
				_la = _input.LA(1);
				if ( !(_la==T__10 || _la==T__11) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(20);
				match(T__8);
				setState(21);
				agentid();
				setState(22);
				match(T__12);
				setState(23);
				formula(0);
				setState(24);
				match(T__9);
				}
				break;
			case T__13:
				{
				_localctx = new PuAnnouncementContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(26);
				match(T__13);
				setState(27);
				palformula();
				setState(28);
				match(T__14);
				setState(29);
				formula(4);
				}
				break;
			case T__15:
				{
				_localctx = new GrAnnouncementContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(31);
				match(T__15);
				setState(32);
				agentlist();
				setState(33);
				match(T__16);
				setState(34);
				galformula();
				}
				break;
			case T__17:
				{
				_localctx = new CoAnnouncementContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(36);
				match(T__17);
				setState(37);
				agentlist();
				setState(38);
				match(T__18);
				setState(39);
				calformula();
				}
				break;
			case ID:
				{
				_localctx = new AtomContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(41);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(55);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(53);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new ConjunctionContext(new FormulaContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(44);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(45);
						_la = _input.LA(1);
						if ( !(_la==T__2 || _la==T__3) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(46);
						formula(10);
						}
						break;
					case 2:
						{
						_localctx = new DisjunctionContext(new FormulaContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(47);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(48);
						_la = _input.LA(1);
						if ( !(_la==T__4 || _la==T__5) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(49);
						formula(9);
						}
						break;
					case 3:
						{
						_localctx = new ImplicationContext(new FormulaContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(50);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(51);
						_la = _input.LA(1);
						if ( !(_la==T__6 || _la==T__7) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(52);
						formula(8);
						}
						break;
					}
					} 
				}
				setState(57);
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

	public static class PalformulaContext extends ParserRuleContext {
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public PalformulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_palformula; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaGrammarListener ) ((FormulaGrammarListener)listener).enterPalformula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaGrammarListener ) ((FormulaGrammarListener)listener).exitPalformula(this);
		}
	}

	public final PalformulaContext palformula() throws RecognitionException {
		PalformulaContext _localctx = new PalformulaContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_palformula);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
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
		enterRule(_localctx, 4, RULE_galformula);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
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
		enterRule(_localctx, 6, RULE_calformula);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
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
		enterRule(_localctx, 8, RULE_agentid);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
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
		enterRule(_localctx, 10, RULE_agentlist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			agentid();
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__12) {
				{
				{
				setState(67);
				match(T__12);
				setState(68);
				agentid();
				}
				}
				setState(73);
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
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\32M\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\5\2-\n\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\28\n\2\f"+
		"\2\16\2;\13\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\7\7H\n\7\f\7"+
		"\16\7K\13\7\3\7\2\3\2\b\2\4\6\b\n\f\2\7\3\2\3\4\3\2\r\16\3\2\5\6\3\2\7"+
		"\b\3\2\t\n\2P\2,\3\2\2\2\4<\3\2\2\2\6>\3\2\2\2\b@\3\2\2\2\nB\3\2\2\2\f"+
		"D\3\2\2\2\16\17\b\2\1\2\17\20\t\2\2\2\20-\5\2\2\f\21\22\7\13\2\2\22\23"+
		"\5\2\2\2\23\24\7\f\2\2\24-\3\2\2\2\25\26\t\3\2\2\26\27\7\13\2\2\27\30"+
		"\5\n\6\2\30\31\7\17\2\2\31\32\5\2\2\2\32\33\7\f\2\2\33-\3\2\2\2\34\35"+
		"\7\20\2\2\35\36\5\4\3\2\36\37\7\21\2\2\37 \5\2\2\6 -\3\2\2\2!\"\7\22\2"+
		"\2\"#\5\f\7\2#$\7\23\2\2$%\5\6\4\2%-\3\2\2\2&\'\7\24\2\2\'(\5\f\7\2()"+
		"\7\25\2\2)*\5\b\5\2*-\3\2\2\2+-\7\32\2\2,\16\3\2\2\2,\21\3\2\2\2,\25\3"+
		"\2\2\2,\34\3\2\2\2,!\3\2\2\2,&\3\2\2\2,+\3\2\2\2-9\3\2\2\2./\f\13\2\2"+
		"/\60\t\4\2\2\608\5\2\2\f\61\62\f\n\2\2\62\63\t\5\2\2\638\5\2\2\13\64\65"+
		"\f\t\2\2\65\66\t\6\2\2\668\5\2\2\n\67.\3\2\2\2\67\61\3\2\2\2\67\64\3\2"+
		"\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2:\3\3\2\2\2;9\3\2\2\2<=\5\2\2\2=\5"+
		"\3\2\2\2>?\5\2\2\2?\7\3\2\2\2@A\5\2\2\2A\t\3\2\2\2BC\7\26\2\2C\13\3\2"+
		"\2\2DI\5\n\6\2EF\7\17\2\2FH\5\n\6\2GE\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3"+
		"\2\2\2J\r\3\2\2\2KI\3\2\2\2\6,\679I";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}