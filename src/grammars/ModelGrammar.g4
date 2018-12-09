/** This is the grammar for a model file.
    models are essentially interpreted systems.

    A minimal example:

    ----- cut here -----

    // The number of agents
    N = 2;

    // The list of states.
    S1; S2;

    // The epistemic relation is a list of triples (agent, state, state)
    R = { (1, S1, S2) };

    // This tells that atom1 is true in S1 and S3, etc.
    atom1 = { S1 };

    ----- cut here -----

    */

grammar ModelGrammar;

// A model is just a sequence of definitions:
// TODO ->modelfile
model_file: nofagents statesdef reldef atomsdef;

// The number of agents (must be > 0)
nofagents: ('N'|'n') '=' NONZEROINT ';' ;
// This is the definition of states.
// TODO ->statesetdef
statesdef: (ID ';')+;
// The epistemic relations are a list of triples (agent, state, state)
reldef: 'R' '=' '{' edge (',' edge)* '}' ';';
edge: '(' NONZEROINT ',' ID ',' ID ')';
// Definition of the propositional atoms (i.e.: what is true where?)
// This section could be empty i.e. no atoms
// TODO atomsdef->atomsetdef
atomsdef: (singledef ';')*;
// TODO singledef->atomdef
// TODO gstate->state
singledef: ID '=' '{' gstateslist '}';
// gstatelist is  alist of states (at least one):
gstateslist: ID (',' ID)*;

/* ------ Lexer rules ------ */

NONZEROINT: [1-9] ([0-9])*;
INT: [0-9]+;

// We throw away white spaces, tabs and new lines.
WS: [ \t\r\n]+ -> skip ; 

// We throw away comments, either on a single line or on multipe lines
LINE_COMMENT: '//' .*? '\r'? '\n' -> skip ; 
COMMENT: '/*' .*? '*/' -> skip ; 

// C-style IDs
ID : ID_LETTER (ID_LETTER | DIGIT)* ; 
// Fragment means that we cannot access it from the parser
fragment ID_LETTER : 'a'..'z'|'A'..'Z'|'_' ;
fragment DIGIT : '0'..'9' ;

