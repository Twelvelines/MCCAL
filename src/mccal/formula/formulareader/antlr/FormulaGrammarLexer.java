package mccal.formula.formulareader.antlr;// Generated from FormulaGrammar.g4 by ANTLR 4.7.1

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FormulaGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, INT=15, WS=16, LINE_COMMENT=17, 
		COMMENT=18, ID=19;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "INT", "WS", "LINE_COMMENT", 
		"COMMENT", "ID", "ID_LETTER", "DIGIT"
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


	public FormulaGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "FormulaGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\25\u008d\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\3\3\3\3\3\3\3"+
		"\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3"+
		"\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3"+
		"\17\3\17\3\17\3\20\6\20Y\n\20\r\20\16\20Z\3\21\6\21^\n\21\r\21\16\21_"+
		"\3\21\3\21\3\22\3\22\3\22\3\22\7\22h\n\22\f\22\16\22k\13\22\3\22\5\22"+
		"n\n\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\7\23x\n\23\f\23\16\23{"+
		"\13\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\7\24\u0085\n\24\f\24\16"+
		"\24\u0088\13\24\3\25\3\25\3\26\3\26\4iy\2\27\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\2"+
		"+\2\3\2\5\3\2\62;\5\2\13\f\17\17\"\"\5\2C\\aac|\2\u0091\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"+
		"\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2"+
		"\2\'\3\2\2\2\3-\3\2\2\2\5/\3\2\2\2\7\63\3\2\2\2\t\67\3\2\2\2\13:\3\2\2"+
		"\2\rB\3\2\2\2\17E\3\2\2\2\21G\3\2\2\2\23I\3\2\2\2\25K\3\2\2\2\27M\3\2"+
		"\2\2\31O\3\2\2\2\33Q\3\2\2\2\35T\3\2\2\2\37X\3\2\2\2!]\3\2\2\2#c\3\2\2"+
		"\2%s\3\2\2\2\'\u0081\3\2\2\2)\u0089\3\2\2\2+\u008b\3\2\2\2-.\7#\2\2.\4"+
		"\3\2\2\2/\60\7p\2\2\60\61\7q\2\2\61\62\7v\2\2\62\6\3\2\2\2\63\64\7c\2"+
		"\2\64\65\7p\2\2\65\66\7f\2\2\66\b\3\2\2\2\678\7q\2\289\7t\2\29\n\3\2\2"+
		"\2:;\7k\2\2;<\7o\2\2<=\7r\2\2=>\7n\2\2>?\7k\2\2?@\7g\2\2@A\7u\2\2A\f\3"+
		"\2\2\2BC\7/\2\2CD\7@\2\2D\16\3\2\2\2EF\7*\2\2F\20\3\2\2\2GH\7+\2\2H\22"+
		"\3\2\2\2IJ\7M\2\2J\24\3\2\2\2KL\7.\2\2L\26\3\2\2\2MN\7]\2\2N\30\3\2\2"+
		"\2OP\7_\2\2P\32\3\2\2\2QR\7>\2\2RS\7>\2\2S\34\3\2\2\2TU\7@\2\2UV\7@\2"+
		"\2V\36\3\2\2\2WY\t\2\2\2XW\3\2\2\2YZ\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[ \3\2"+
		"\2\2\\^\t\3\2\2]\\\3\2\2\2^_\3\2\2\2_]\3\2\2\2_`\3\2\2\2`a\3\2\2\2ab\b"+
		"\21\2\2b\"\3\2\2\2cd\7\61\2\2de\7\61\2\2ei\3\2\2\2fh\13\2\2\2gf\3\2\2"+
		"\2hk\3\2\2\2ij\3\2\2\2ig\3\2\2\2jm\3\2\2\2ki\3\2\2\2ln\7\17\2\2ml\3\2"+
		"\2\2mn\3\2\2\2no\3\2\2\2op\7\f\2\2pq\3\2\2\2qr\b\22\2\2r$\3\2\2\2st\7"+
		"\61\2\2tu\7,\2\2uy\3\2\2\2vx\13\2\2\2wv\3\2\2\2x{\3\2\2\2yz\3\2\2\2yw"+
		"\3\2\2\2z|\3\2\2\2{y\3\2\2\2|}\7,\2\2}~\7\61\2\2~\177\3\2\2\2\177\u0080"+
		"\b\23\2\2\u0080&\3\2\2\2\u0081\u0086\5)\25\2\u0082\u0085\5)\25\2\u0083"+
		"\u0085\5+\26\2\u0084\u0082\3\2\2\2\u0084\u0083\3\2\2\2\u0085\u0088\3\2"+
		"\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087(\3\2\2\2\u0088\u0086"+
		"\3\2\2\2\u0089\u008a\t\4\2\2\u008a*\3\2\2\2\u008b\u008c\4\62;\2\u008c"+
		",\3\2\2\2\n\2Z_imy\u0084\u0086\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}