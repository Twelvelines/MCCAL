package cogwedmc.model.modelreader.antlr;// Generated from ModelGrammar.g by ANTLR 4.7.1

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ModelGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, NONZEROINT=11, INT=12, WS=13, LINE_COMMENT=14, COMMENT=15, ID=16;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "NONZEROINT", "INT", "WS", "LINE_COMMENT", "COMMENT", "ID", "ID_LETTER", 
		"DIGIT"
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


	public ModelGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ModelGrammar.g"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\22x\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t"+
		"\3\t\3\n\3\n\3\13\3\13\3\f\3\f\7\f>\n\f\f\f\16\fA\13\f\3\r\6\rD\n\r\r"+
		"\r\16\rE\3\16\6\16I\n\16\r\16\16\16J\3\16\3\16\3\17\3\17\3\17\3\17\7\17"+
		"S\n\17\f\17\16\17V\13\17\3\17\5\17Y\n\17\3\17\3\17\3\17\3\17\3\20\3\20"+
		"\3\20\3\20\7\20c\n\20\f\20\16\20f\13\20\3\20\3\20\3\20\3\20\3\20\3\21"+
		"\3\21\3\21\7\21p\n\21\f\21\16\21s\13\21\3\22\3\22\3\23\3\23\4Td\2\24\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37"+
		"\21!\22#\2%\2\3\2\6\3\2\63;\3\2\62;\5\2\13\f\17\17\"\"\5\2C\\aac|\2}\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\3\'\3\2"+
		"\2\2\5)\3\2\2\2\7+\3\2\2\2\t-\3\2\2\2\13/\3\2\2\2\r\61\3\2\2\2\17\63\3"+
		"\2\2\2\21\65\3\2\2\2\23\67\3\2\2\2\259\3\2\2\2\27;\3\2\2\2\31C\3\2\2\2"+
		"\33H\3\2\2\2\35N\3\2\2\2\37^\3\2\2\2!l\3\2\2\2#t\3\2\2\2%v\3\2\2\2\'("+
		"\7P\2\2(\4\3\2\2\2)*\7p\2\2*\6\3\2\2\2+,\7?\2\2,\b\3\2\2\2-.\7=\2\2.\n"+
		"\3\2\2\2/\60\7T\2\2\60\f\3\2\2\2\61\62\7}\2\2\62\16\3\2\2\2\63\64\7.\2"+
		"\2\64\20\3\2\2\2\65\66\7\177\2\2\66\22\3\2\2\2\678\7*\2\28\24\3\2\2\2"+
		"9:\7+\2\2:\26\3\2\2\2;?\t\2\2\2<>\t\3\2\2=<\3\2\2\2>A\3\2\2\2?=\3\2\2"+
		"\2?@\3\2\2\2@\30\3\2\2\2A?\3\2\2\2BD\t\3\2\2CB\3\2\2\2DE\3\2\2\2EC\3\2"+
		"\2\2EF\3\2\2\2F\32\3\2\2\2GI\t\4\2\2HG\3\2\2\2IJ\3\2\2\2JH\3\2\2\2JK\3"+
		"\2\2\2KL\3\2\2\2LM\b\16\2\2M\34\3\2\2\2NO\7\61\2\2OP\7\61\2\2PT\3\2\2"+
		"\2QS\13\2\2\2RQ\3\2\2\2SV\3\2\2\2TU\3\2\2\2TR\3\2\2\2UX\3\2\2\2VT\3\2"+
		"\2\2WY\7\17\2\2XW\3\2\2\2XY\3\2\2\2YZ\3\2\2\2Z[\7\f\2\2[\\\3\2\2\2\\]"+
		"\b\17\2\2]\36\3\2\2\2^_\7\61\2\2_`\7,\2\2`d\3\2\2\2ac\13\2\2\2ba\3\2\2"+
		"\2cf\3\2\2\2de\3\2\2\2db\3\2\2\2eg\3\2\2\2fd\3\2\2\2gh\7,\2\2hi\7\61\2"+
		"\2ij\3\2\2\2jk\b\20\2\2k \3\2\2\2lq\5#\22\2mp\5#\22\2np\5%\23\2om\3\2"+
		"\2\2on\3\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2r\"\3\2\2\2sq\3\2\2\2tu\t"+
		"\5\2\2u$\3\2\2\2vw\4\62;\2w&\3\2\2\2\13\2?EJTXdoq\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}