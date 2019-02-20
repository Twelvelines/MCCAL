package mccal.antlr.model;// Generated from ModelGrammar.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ModelGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, NONZEROINT=11, INT=12, WS=13, LINE_COMMENT=14, COMMENT=15, ID=16;
	public static final int
		RULE_modelfile = 0, RULE_numagents = 1, RULE_allstates = 2, RULE_reldef = 3, 
		RULE_edge = 4, RULE_propositions = 5, RULE_prop = 6, RULE_atoms = 7, RULE_statelist = 8;
	public static final String[] ruleNames = {
		"modelfile", "numagents", "allstates", "reldef", "edge", "propositions", 
		"prop", "atoms", "statelist"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'N'", "'n'", "'='", "';'", "'R'", "'{'", "','", "'}'", "'('", "')'"
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
	public String getGrammarFileName() { return "ModelGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ModelGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ModelfileContext extends ParserRuleContext {
		public NumagentsContext numagents() {
			return getRuleContext(NumagentsContext.class,0);
		}
		public AllstatesContext allstates() {
			return getRuleContext(AllstatesContext.class,0);
		}
		public ReldefContext reldef() {
			return getRuleContext(ReldefContext.class,0);
		}
		public PropositionsContext propositions() {
			return getRuleContext(PropositionsContext.class,0);
		}
		public ModelfileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modelfile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ModelGrammarListener ) ((ModelGrammarListener)listener).enterModelfile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ModelGrammarListener ) ((ModelGrammarListener)listener).exitModelfile(this);
		}
	}

	public final ModelfileContext modelfile() throws RecognitionException {
		ModelfileContext _localctx = new ModelfileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_modelfile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			numagents();
			setState(19);
			allstates();
			setState(20);
			reldef();
			setState(21);
			propositions();
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

	public static class NumagentsContext extends ParserRuleContext {
		public TerminalNode NONZEROINT() { return getToken(ModelGrammarParser.NONZEROINT, 0); }
		public NumagentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numagents; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ModelGrammarListener ) ((ModelGrammarListener)listener).enterNumagents(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ModelGrammarListener ) ((ModelGrammarListener)listener).exitNumagents(this);
		}
	}

	public final NumagentsContext numagents() throws RecognitionException {
		NumagentsContext _localctx = new NumagentsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_numagents);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23);
			_la = _input.LA(1);
			if ( !(_la==T__0 || _la==T__1) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(24);
			match(T__2);
			setState(25);
			match(NONZEROINT);
			setState(26);
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

	public static class AllstatesContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(ModelGrammarParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ModelGrammarParser.ID, i);
		}
		public AllstatesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_allstates; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ModelGrammarListener ) ((ModelGrammarListener)listener).enterAllstates(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ModelGrammarListener ) ((ModelGrammarListener)listener).exitAllstates(this);
		}
	}

	public final AllstatesContext allstates() throws RecognitionException {
		AllstatesContext _localctx = new AllstatesContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_allstates);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(28);
				match(ID);
				setState(29);
				match(T__3);
				}
				}
				setState(32); 
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
			if ( listener instanceof ModelGrammarListener ) ((ModelGrammarListener)listener).enterReldef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ModelGrammarListener ) ((ModelGrammarListener)listener).exitReldef(this);
		}
	}

	public final ReldefContext reldef() throws RecognitionException {
		ReldefContext _localctx = new ReldefContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_reldef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			match(T__4);
			setState(35);
			match(T__2);
			setState(36);
			match(T__5);
			setState(37);
			edge();
			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(38);
				match(T__6);
				setState(39);
				edge();
				}
				}
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(45);
			match(T__7);
			setState(46);
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
		public TerminalNode NONZEROINT() { return getToken(ModelGrammarParser.NONZEROINT, 0); }
		public List<TerminalNode> ID() { return getTokens(ModelGrammarParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ModelGrammarParser.ID, i);
		}
		public EdgeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_edge; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ModelGrammarListener ) ((ModelGrammarListener)listener).enterEdge(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ModelGrammarListener ) ((ModelGrammarListener)listener).exitEdge(this);
		}
	}

	public final EdgeContext edge() throws RecognitionException {
		EdgeContext _localctx = new EdgeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_edge);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(T__8);
			setState(49);
			match(NONZEROINT);
			setState(50);
			match(T__6);
			setState(51);
			match(ID);
			setState(52);
			match(T__6);
			setState(53);
			match(ID);
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(54);
				match(T__6);
				setState(55);
				match(ID);
				}
				}
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(61);
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

	public static class PropositionsContext extends ParserRuleContext {
		public List<PropContext> prop() {
			return getRuleContexts(PropContext.class);
		}
		public PropContext prop(int i) {
			return getRuleContext(PropContext.class,i);
		}
		public PropositionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propositions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ModelGrammarListener ) ((ModelGrammarListener)listener).enterPropositions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ModelGrammarListener ) ((ModelGrammarListener)listener).exitPropositions(this);
		}
	}

	public final PropositionsContext propositions() throws RecognitionException {
		PropositionsContext _localctx = new PropositionsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_propositions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(63);
				prop();
				setState(64);
				match(T__3);
				}
				}
				setState(70);
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

	public static class PropContext extends ParserRuleContext {
		public AtomsContext atoms() {
			return getRuleContext(AtomsContext.class,0);
		}
		public StatelistContext statelist() {
			return getRuleContext(StatelistContext.class,0);
		}
		public PropContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ModelGrammarListener ) ((ModelGrammarListener)listener).enterProp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ModelGrammarListener ) ((ModelGrammarListener)listener).exitProp(this);
		}
	}

	public final PropContext prop() throws RecognitionException {
		PropContext _localctx = new PropContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_prop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			atoms();
			setState(72);
			match(T__2);
			setState(73);
			match(T__5);
			setState(74);
			statelist();
			setState(75);
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

	public static class AtomsContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ModelGrammarParser.ID, 0); }
		public AtomsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atoms; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ModelGrammarListener ) ((ModelGrammarListener)listener).enterAtoms(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ModelGrammarListener ) ((ModelGrammarListener)listener).exitAtoms(this);
		}
	}

	public final AtomsContext atoms() throws RecognitionException {
		AtomsContext _localctx = new AtomsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_atoms);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(ID);
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

	public static class StatelistContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(ModelGrammarParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ModelGrammarParser.ID, i);
		}
		public StatelistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statelist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ModelGrammarListener ) ((ModelGrammarListener)listener).enterStatelist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ModelGrammarListener ) ((ModelGrammarListener)listener).exitStatelist(this);
		}
	}

	public final StatelistContext statelist() throws RecognitionException {
		StatelistContext _localctx = new StatelistContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_statelist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(ID);
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(80);
				match(T__6);
				setState(81);
				match(ID);
				}
				}
				setState(86);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\22Z\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2\3\2"+
		"\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\6\4!\n\4\r\4\16\4\"\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\7\5+\n\5\f\5\16\5.\13\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\7\6;\n\6\f\6\16\6>\13\6\3\6\3\6\3\7\3\7\3\7\7\7E\n\7\f\7\16\7"+
		"H\13\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\n\7\nU\n\n\f\n\16\nX"+
		"\13\n\3\n\2\2\13\2\4\6\b\n\f\16\20\22\2\3\3\2\3\4\2U\2\24\3\2\2\2\4\31"+
		"\3\2\2\2\6 \3\2\2\2\b$\3\2\2\2\n\62\3\2\2\2\fF\3\2\2\2\16I\3\2\2\2\20"+
		"O\3\2\2\2\22Q\3\2\2\2\24\25\5\4\3\2\25\26\5\6\4\2\26\27\5\b\5\2\27\30"+
		"\5\f\7\2\30\3\3\2\2\2\31\32\t\2\2\2\32\33\7\5\2\2\33\34\7\r\2\2\34\35"+
		"\7\6\2\2\35\5\3\2\2\2\36\37\7\22\2\2\37!\7\6\2\2 \36\3\2\2\2!\"\3\2\2"+
		"\2\" \3\2\2\2\"#\3\2\2\2#\7\3\2\2\2$%\7\7\2\2%&\7\5\2\2&\'\7\b\2\2\',"+
		"\5\n\6\2()\7\t\2\2)+\5\n\6\2*(\3\2\2\2+.\3\2\2\2,*\3\2\2\2,-\3\2\2\2-"+
		"/\3\2\2\2.,\3\2\2\2/\60\7\n\2\2\60\61\7\6\2\2\61\t\3\2\2\2\62\63\7\13"+
		"\2\2\63\64\7\r\2\2\64\65\7\t\2\2\65\66\7\22\2\2\66\67\7\t\2\2\67<\7\22"+
		"\2\289\7\t\2\29;\7\22\2\2:8\3\2\2\2;>\3\2\2\2<:\3\2\2\2<=\3\2\2\2=?\3"+
		"\2\2\2><\3\2\2\2?@\7\f\2\2@\13\3\2\2\2AB\5\16\b\2BC\7\6\2\2CE\3\2\2\2"+
		"DA\3\2\2\2EH\3\2\2\2FD\3\2\2\2FG\3\2\2\2G\r\3\2\2\2HF\3\2\2\2IJ\5\20\t"+
		"\2JK\7\5\2\2KL\7\b\2\2LM\5\22\n\2MN\7\n\2\2N\17\3\2\2\2OP\7\22\2\2P\21"+
		"\3\2\2\2QV\7\22\2\2RS\7\t\2\2SU\7\22\2\2TR\3\2\2\2UX\3\2\2\2VT\3\2\2\2"+
		"VW\3\2\2\2W\23\3\2\2\2XV\3\2\2\2\7\",<FV";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}