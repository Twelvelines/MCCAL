package cogwedmc.model.modelreader.antlr;// Generated from CogwedModelGrammar.g by ANTLR 4.7.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CogwedModelGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, NONZEROINT=11, INT=12, WS=13, LINE_COMMENT=14, COMMENT=15, ID=16;
	public static final int
		RULE_cogwed_model_file = 0, RULE_nofagents = 1, RULE_statesdef = 2, RULE_reldef = 3, 
		RULE_edge = 4, RULE_atomsdef = 5, RULE_singledef = 6, RULE_gstateslist = 7;
	public static final String[] ruleNames = {
		"cogwed_model_file", "nofagents", "statesdef", "reldef", "edge", "atomsdef", 
		"singledef", "gstateslist"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'N'", "'n'", "'='", "';'", "'RT'", "'{'", "','", "'}'", "'('", 
		"')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "NONZEROINT", 
		"INT", "WS", "LINE_COMMENT", "COMMENT", "ID"
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
	public String getGrammarFileName() { return "CogwedModelGrammar.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CogwedModelGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class Cogwed_model_fileContext extends ParserRuleContext {
		public NofagentsContext nofagents() {
			return getRuleContext(NofagentsContext.class,0);
		}
		public StatesdefContext statesdef() {
			return getRuleContext(StatesdefContext.class,0);
		}
		public ReldefContext reldef() {
			return getRuleContext(ReldefContext.class,0);
		}
		public AtomsdefContext atomsdef() {
			return getRuleContext(AtomsdefContext.class,0);
		}
		public Cogwed_model_fileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cogwed_model_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CogwedModelGrammarListener ) ((CogwedModelGrammarListener)listener).enterCogwed_model_file(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CogwedModelGrammarListener ) ((CogwedModelGrammarListener)listener).exitCogwed_model_file(this);
		}
	}

	public final Cogwed_model_fileContext cogwed_model_file() throws RecognitionException {
		Cogwed_model_fileContext _localctx = new Cogwed_model_fileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_cogwed_model_file);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			nofagents();
			setState(17);
			statesdef();
			setState(18);
			reldef();
			setState(19);
			atomsdef();
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

	public static class NofagentsContext extends ParserRuleContext {
		public TerminalNode NONZEROINT() { return getToken(CogwedModelGrammarParser.NONZEROINT, 0); }
		public NofagentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nofagents; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CogwedModelGrammarListener ) ((CogwedModelGrammarListener)listener).enterNofagents(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CogwedModelGrammarListener ) ((CogwedModelGrammarListener)listener).exitNofagents(this);
		}
	}

	public final NofagentsContext nofagents() throws RecognitionException {
		NofagentsContext _localctx = new NofagentsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_nofagents);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			_la = _input.LA(1);
			if ( !(_la==T__0 || _la==T__1) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(22);
			match(T__2);
			setState(23);
			match(NONZEROINT);
			setState(24);
			match(T__3);
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

	public static class StatesdefContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(CogwedModelGrammarParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CogwedModelGrammarParser.ID, i);
		}
		public StatesdefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statesdef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CogwedModelGrammarListener ) ((CogwedModelGrammarListener)listener).enterStatesdef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CogwedModelGrammarListener ) ((CogwedModelGrammarListener)listener).exitStatesdef(this);
		}
	}

	public final StatesdefContext statesdef() throws RecognitionException {
		StatesdefContext _localctx = new StatesdefContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statesdef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(26);
				match(ID);
				setState(27);
				match(T__3);
				}
				}
				setState(30); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
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

	public static class ReldefContext extends ParserRuleContext {
		public List<EdgeContext> edge() {
			return getRuleContexts(EdgeContext.class);
		}
		public EdgeContext edge(int i) {
			return getRuleContext(EdgeContext.class,i);
		}
		public ReldefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reldef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CogwedModelGrammarListener ) ((CogwedModelGrammarListener)listener).enterReldef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CogwedModelGrammarListener ) ((CogwedModelGrammarListener)listener).exitReldef(this);
		}
	}

	public final ReldefContext reldef() throws RecognitionException {
		ReldefContext _localctx = new ReldefContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_reldef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(T__4);
			setState(33);
			match(T__2);
			setState(34);
			match(T__5);
			setState(35);
			edge();
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(36);
				match(T__6);
				setState(37);
				edge();
				}
				}
				setState(42);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(43);
			match(T__7);
			setState(44);
			match(T__3);
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

	public static class EdgeContext extends ParserRuleContext {
		public TerminalNode NONZEROINT() { return getToken(CogwedModelGrammarParser.NONZEROINT, 0); }
		public List<TerminalNode> ID() { return getTokens(CogwedModelGrammarParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CogwedModelGrammarParser.ID, i);
		}
		public EdgeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_edge; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CogwedModelGrammarListener ) ((CogwedModelGrammarListener)listener).enterEdge(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CogwedModelGrammarListener ) ((CogwedModelGrammarListener)listener).exitEdge(this);
		}
	}

	public final EdgeContext edge() throws RecognitionException {
		EdgeContext _localctx = new EdgeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_edge);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(T__8);
			setState(47);
			match(NONZEROINT);
			setState(48);
			match(T__6);
			setState(49);
			match(ID);
			setState(50);
			match(T__6);
			setState(51);
			match(ID);
			setState(52);
			match(T__9);
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

	public static class AtomsdefContext extends ParserRuleContext {
		public List<SingledefContext> singledef() {
			return getRuleContexts(SingledefContext.class);
		}
		public SingledefContext singledef(int i) {
			return getRuleContext(SingledefContext.class,i);
		}
		public AtomsdefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomsdef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CogwedModelGrammarListener ) ((CogwedModelGrammarListener)listener).enterAtomsdef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CogwedModelGrammarListener ) ((CogwedModelGrammarListener)listener).exitAtomsdef(this);
		}
	}

	public final AtomsdefContext atomsdef() throws RecognitionException {
		AtomsdefContext _localctx = new AtomsdefContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_atomsdef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(54);
				singledef();
				setState(55);
				match(T__3);
				}
				}
				setState(61);
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

	public static class SingledefContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CogwedModelGrammarParser.ID, 0); }
		public GstateslistContext gstateslist() {
			return getRuleContext(GstateslistContext.class,0);
		}
		public SingledefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singledef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CogwedModelGrammarListener ) ((CogwedModelGrammarListener)listener).enterSingledef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CogwedModelGrammarListener ) ((CogwedModelGrammarListener)listener).exitSingledef(this);
		}
	}

	public final SingledefContext singledef() throws RecognitionException {
		SingledefContext _localctx = new SingledefContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_singledef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(ID);
			setState(63);
			match(T__2);
			setState(64);
			match(T__5);
			setState(65);
			gstateslist();
			setState(66);
			match(T__7);
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

	public static class GstateslistContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(CogwedModelGrammarParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CogwedModelGrammarParser.ID, i);
		}
		public GstateslistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gstateslist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CogwedModelGrammarListener ) ((CogwedModelGrammarListener)listener).enterGstateslist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CogwedModelGrammarListener ) ((CogwedModelGrammarListener)listener).exitGstateslist(this);
		}
	}

	public final GstateslistContext gstateslist() throws RecognitionException {
		GstateslistContext _localctx = new GstateslistContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_gstateslist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(ID);
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(69);
				match(T__6);
				setState(70);
				match(ID);
				}
				}
				setState(75);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\22O\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\3\2\3\2"+
		"\3\3\3\3\3\3\3\3\3\3\3\4\3\4\6\4\37\n\4\r\4\16\4 \3\5\3\5\3\5\3\5\3\5"+
		"\3\5\7\5)\n\5\f\5\16\5,\13\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\7\3\7\3\7\7\7<\n\7\f\7\16\7?\13\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t"+
		"\3\t\7\tJ\n\t\f\t\16\tM\13\t\3\t\2\2\n\2\4\6\b\n\f\16\20\2\3\3\2\3\4\2"+
		"J\2\22\3\2\2\2\4\27\3\2\2\2\6\36\3\2\2\2\b\"\3\2\2\2\n\60\3\2\2\2\f=\3"+
		"\2\2\2\16@\3\2\2\2\20F\3\2\2\2\22\23\5\4\3\2\23\24\5\6\4\2\24\25\5\b\5"+
		"\2\25\26\5\f\7\2\26\3\3\2\2\2\27\30\t\2\2\2\30\31\7\5\2\2\31\32\7\r\2"+
		"\2\32\33\7\6\2\2\33\5\3\2\2\2\34\35\7\22\2\2\35\37\7\6\2\2\36\34\3\2\2"+
		"\2\37 \3\2\2\2 \36\3\2\2\2 !\3\2\2\2!\7\3\2\2\2\"#\7\7\2\2#$\7\5\2\2$"+
		"%\7\b\2\2%*\5\n\6\2&\'\7\t\2\2\')\5\n\6\2(&\3\2\2\2),\3\2\2\2*(\3\2\2"+
		"\2*+\3\2\2\2+-\3\2\2\2,*\3\2\2\2-.\7\n\2\2./\7\6\2\2/\t\3\2\2\2\60\61"+
		"\7\13\2\2\61\62\7\r\2\2\62\63\7\t\2\2\63\64\7\22\2\2\64\65\7\t\2\2\65"+
		"\66\7\22\2\2\66\67\7\f\2\2\67\13\3\2\2\289\5\16\b\29:\7\6\2\2:<\3\2\2"+
		"\2;8\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2>\r\3\2\2\2?=\3\2\2\2@A\7\22"+
		"\2\2AB\7\5\2\2BC\7\b\2\2CD\5\20\t\2DE\7\n\2\2E\17\3\2\2\2FK\7\22\2\2G"+
		"H\7\t\2\2HJ\7\22\2\2IG\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2L\21\3\2\2"+
		"\2MK\3\2\2\2\6 *=K";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}