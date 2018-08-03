package cogwedmc.formula.formulareader.antlr;// Generated from CogwedFormulaGrammar.g by ANTLR 4.7.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CogwedFormulaGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, INT=11, WS=12, LINE_COMMENT=13, COMMENT=14, ID=15;
	public static final int
		RULE_start = 0, RULE_formula = 1, RULE_agentid = 2;
	public static final String[] ruleNames = {
		"start", "formula", "agentid"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'!'", "'not'", "'and'", "'or'", "'implies'", "'->'", "'('", "')'", 
		"'K'", "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "INT", 
		"WS", "LINE_COMMENT", "COMMENT", "ID"
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
			setState(6);
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
			setState(23);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
				{
				_localctx = new NegationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(9);
				_la = _input.LA(1);
				if ( !(_la==T__0 || _la==T__1) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(10);
				formula(7);
				}
				break;
			case T__6:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(11);
				match(T__6);
				setState(12);
				formula(0);
				setState(13);
				match(T__7);
				}
				break;
			case T__8:
				{
				_localctx = new KnowledgeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(15);
				match(T__8);
				setState(16);
				match(T__6);
				setState(17);
				agentid();
				setState(18);
				match(T__9);
				setState(19);
				formula(0);
				setState(20);
				match(T__7);
				}
				break;
			case ID:
				{
				_localctx = new IdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(22);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(36);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(34);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new ConjunctionContext(new FormulaContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(25);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(26);
						match(T__2);
						setState(27);
						formula(7);
						}
						break;
					case 2:
						{
						_localctx = new DisjunctionContext(new FormulaContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(28);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(29);
						match(T__3);
						setState(30);
						formula(6);
						}
						break;
					case 3:
						{
						_localctx = new ImplicationContext(new FormulaContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(31);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(32);
						_la = _input.LA(1);
						if ( !(_la==T__4 || _la==T__5) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(33);
						formula(5);
						}
						break;
					}
					} 
				}
				setState(38);
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
		enterRule(_localctx, 4, RULE_agentid);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
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
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\21,\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\5\3\32\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3%\n\3\f\3\16"+
		"\3(\13\3\3\4\3\4\3\4\2\3\4\5\2\4\6\2\4\3\2\3\4\3\2\7\b\2.\2\b\3\2\2\2"+
		"\4\31\3\2\2\2\6)\3\2\2\2\b\t\5\4\3\2\t\3\3\2\2\2\n\13\b\3\1\2\13\f\t\2"+
		"\2\2\f\32\5\4\3\t\r\16\7\t\2\2\16\17\5\4\3\2\17\20\7\n\2\2\20\32\3\2\2"+
		"\2\21\22\7\13\2\2\22\23\7\t\2\2\23\24\5\6\4\2\24\25\7\f\2\2\25\26\5\4"+
		"\3\2\26\27\7\n\2\2\27\32\3\2\2\2\30\32\7\21\2\2\31\n\3\2\2\2\31\r\3\2"+
		"\2\2\31\21\3\2\2\2\31\30\3\2\2\2\32&\3\2\2\2\33\34\f\b\2\2\34\35\7\5\2"+
		"\2\35%\5\4\3\t\36\37\f\7\2\2\37 \7\6\2\2 %\5\4\3\b!\"\f\6\2\2\"#\t\3\2"+
		"\2#%\5\4\3\7$\33\3\2\2\2$\36\3\2\2\2$!\3\2\2\2%(\3\2\2\2&$\3\2\2\2&\'"+
		"\3\2\2\2\'\5\3\2\2\2(&\3\2\2\2)*\7\r\2\2*\7\3\2\2\2\5\31$&";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}