package cogwedmc.formula.formulareader.antlr;// Generated from CogwedFormulaGrammar.g by ANTLR 4.7.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CogwedFormulaGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, INT=11, WS=12, LINE_COMMENT=13, COMMENT=14, ID=15;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "INT", "WS", "LINE_COMMENT", "COMMENT", "ID", "ID_LETTER", "DIGIT"
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


	public CogwedFormulaGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CogwedFormulaGrammar.g"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\21{\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\6\fG"+
		"\n\f\r\f\16\fH\3\r\6\rL\n\r\r\r\16\rM\3\r\3\r\3\16\3\16\3\16\3\16\7\16"+
		"V\n\16\f\16\16\16Y\13\16\3\16\5\16\\\n\16\3\16\3\16\3\16\3\16\3\17\3\17"+
		"\3\17\3\17\7\17f\n\17\f\17\16\17i\13\17\3\17\3\17\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\7\20s\n\20\f\20\16\20v\13\20\3\21\3\21\3\22\3\22\4Wg\2\23\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37"+
		"\21!\2#\2\3\2\5\3\2\62;\5\2\13\f\17\17\"\"\5\2C\\aac|\2\177\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2"+
		"\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\3%\3\2\2\2\5\'\3\2\2\2\7+\3"+
		"\2\2\2\t/\3\2\2\2\13\62\3\2\2\2\r:\3\2\2\2\17=\3\2\2\2\21?\3\2\2\2\23"+
		"A\3\2\2\2\25C\3\2\2\2\27F\3\2\2\2\31K\3\2\2\2\33Q\3\2\2\2\35a\3\2\2\2"+
		"\37o\3\2\2\2!w\3\2\2\2#y\3\2\2\2%&\7#\2\2&\4\3\2\2\2\'(\7p\2\2()\7q\2"+
		"\2)*\7v\2\2*\6\3\2\2\2+,\7c\2\2,-\7p\2\2-.\7f\2\2.\b\3\2\2\2/\60\7q\2"+
		"\2\60\61\7t\2\2\61\n\3\2\2\2\62\63\7k\2\2\63\64\7o\2\2\64\65\7r\2\2\65"+
		"\66\7n\2\2\66\67\7k\2\2\678\7g\2\289\7u\2\29\f\3\2\2\2:;\7/\2\2;<\7@\2"+
		"\2<\16\3\2\2\2=>\7*\2\2>\20\3\2\2\2?@\7+\2\2@\22\3\2\2\2AB\7M\2\2B\24"+
		"\3\2\2\2CD\7.\2\2D\26\3\2\2\2EG\t\2\2\2FE\3\2\2\2GH\3\2\2\2HF\3\2\2\2"+
		"HI\3\2\2\2I\30\3\2\2\2JL\t\3\2\2KJ\3\2\2\2LM\3\2\2\2MK\3\2\2\2MN\3\2\2"+
		"\2NO\3\2\2\2OP\b\r\2\2P\32\3\2\2\2QR\7\61\2\2RS\7\61\2\2SW\3\2\2\2TV\13"+
		"\2\2\2UT\3\2\2\2VY\3\2\2\2WX\3\2\2\2WU\3\2\2\2X[\3\2\2\2YW\3\2\2\2Z\\"+
		"\7\17\2\2[Z\3\2\2\2[\\\3\2\2\2\\]\3\2\2\2]^\7\f\2\2^_\3\2\2\2_`\b\16\2"+
		"\2`\34\3\2\2\2ab\7\61\2\2bc\7,\2\2cg\3\2\2\2df\13\2\2\2ed\3\2\2\2fi\3"+
		"\2\2\2gh\3\2\2\2ge\3\2\2\2hj\3\2\2\2ig\3\2\2\2jk\7,\2\2kl\7\61\2\2lm\3"+
		"\2\2\2mn\b\17\2\2n\36\3\2\2\2ot\5!\21\2ps\5!\21\2qs\5#\22\2rp\3\2\2\2"+
		"rq\3\2\2\2sv\3\2\2\2tr\3\2\2\2tu\3\2\2\2u \3\2\2\2vt\3\2\2\2wx\t\4\2\2"+
		"x\"\3\2\2\2yz\4\62;\2z$\3\2\2\2\n\2HMW[grt\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}