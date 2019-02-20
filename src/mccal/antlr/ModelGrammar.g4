/** This is the grammar for a model file.
    models are essentially interpreted multiagent systems.

    A minimal example:

    ----------

    // number of agents
    N = 2;

    // list of states
    S1; S2;

    // epistemic relation: a list of triples (agent, state, state)
    R = { (1, S1, S2) };

    // atoms: atom1 is true in S1 and S3
    atom1 = { S1 };

    ----------

    */

grammar ModelGrammar;

// A model is a sequence of definitions
modelfile: numagents allstates reldef propositions;

// The number of agents (must be > 0)
numagents: ('N'|'n') '=' NONZEROINT ';';

// Definition of states within the model
allstates: (ID ';')+;

// The epistemic relations are a list of relations/edges (agent, state, state)
reldef: 'R' '=' '{' edge (',' edge)* '}' ';';
edge: '(' NONZEROINT ',' ID ',' ID (',' ID)* ')';

// Definition of each atom with a list of states where it holds true; could be non-existing i.e. no atoms
propositions: (prop ';')*;
prop: atoms '=' '{' statelist '}';
atoms: ID;
statelist: ID (',' ID)*;

/* ------ Lexer rules ------ */

NONZEROINT: [1-9] ([0-9])*;
INT: [0-9]+;

// White spaces, tabs and new lines are ignored/skipped
WS: [ \t\r\n]+ -> skip;

// Comments, either on a single line or on multipe lines, are ignored/skipped
LINE_COMMENT: '//' .*? '\r'? '\n' -> skip;
COMMENT: '/*' .*? '*/' -> skip;

// C-style IDs
ID : ID_LETTER (ID_LETTER | DIGIT)* ; 
// Fragment cannot be accessed from the parser
fragment ID_LETTER : 'a'..'z'|'A'..'Z'|'_';
fragment DIGIT : '0'..'9';
