/** This is the grammar for a string of formula

    Simple examples:

    a or b;  // A simple disjunction
    p -> K(1, q);  // p implies that agent 1 knows q
    <<3>> ! K(1, atom1)

    */

grammar FormulaGrammar;

// recursion in formula
formula:
    ('!'|'not') formula             # Negation
    | formula ('&'|'and') formula         # Conjunction
    | formula ('|'|'or') formula          # Disjunction
    | formula ('implies'|'->') formula      # Implication
    | '(' formula ')'               # parens
    | ('/<'|'K') '(' agentid ',' formula ')'       # Knowledge
    | '[' palformula ']' formula    # PuAnnouncement
    | '<' agentlist '>' galformula    # GrAnnouncement
    | '<<' agentlist '>>' calformula        # CoAnnouncement
    | ID                            # Atom
;

palformula: formula;
galformula: formula;
calformula: formula;

agentid:  INT;
agentlist: agentid (',' agentid )* ;

/* ------ Lexer rules ------ */

INT: [0-9]+;

// White spaces, tabs and new lines are ignored/skipped
WS: [ \t\r\n]+ -> skip ; 

// Comments, either on a single line or on multipe lines, are ignored/skipped
LINE_COMMENT: '//' .*? '\r'? '\n' -> skip ; 
COMMENT: '/*' .*? '*/' -> skip ; 

// C-style IDs
ID : ID_LETTER (ID_LETTER | DIGIT)* ;
// Fragment cannot be accessed from the parser
fragment ID_LETTER : 'a'..'z'|'A'..'Z'|'_' ;
fragment DIGIT : '0'..'9' ;
