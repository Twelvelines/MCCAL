/**
 TODO: refactor the docs
 Franco 130720: This is the grammar for a cogwed /model/.
 cogwed models are essentially interpreted systems. This grammar
 is very simplified: no structures for local states; global states are
 tuples of local states.
 The temporal relation is provided a list of pairs (of global states).

 Simple example:

 ----- cut here -----

 // This is a single line comment
 // (Multiple line comments are possible as well)

 // The number of agents
 N = 3;

 // The list of global states.
 S1; S2; S3; S4; S5; S6;

 // This tells that atom1 is true in S1 and S3, etc.
 atom1 = { S1, S3 };
 atom2 = { S3, S4, S5};
----- cut here -----

 **/

grammar CogwedModelGrammar;

// A model is just a sequence of definitions:
cogwed_model_file: nofagents statesdef reldef atomsdef;



// Let's define the various parts



// The number of agents (must be > 0)
nofagents: ('N'|'n') '=' NONZEROINT ';' ;


/* This is the definition of global states. */
statesdef: (ID ';')+;
// End of statesdef


/* The epistemic relation is a list of triples (agent, state, state) */
reldef: 'RT' '=' '{' edge (',' edge)* '}' ';';
// Just an INT and two IDs
edge: '(' NONZEROINT ',' ID ',' ID ')';
// End of reldef


/* Definition of the propositional atoms (i.e.: what is true where?) 
   This section could be empty (i.e., no atoms)
*/
atomsdef: (singledef ';')*;
singledef: ID '=' '{' gstateslist '}';
// gstatelist is  alist of global states (at least one):
gstateslist: ID (',' ID)*;



/* **** Lexer rules ****** */

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

