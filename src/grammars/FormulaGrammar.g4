/**
 Franco 220720: This is the grammar for a cogwed /formula/
 
 Simple examples:

a or b; // A simple disjunction

// not ready implies there exists in the future ready
!ready -> (EF(ready)) 

// p implies that, with certainty < 0.2, agent 1 believes q
p -> B[<0.2](1,q);

// Other possible formulas:
B[=.8](2,(a -> EG(b)))

No group modalities for the moment. Also, two temporal operators only.

 **/

grammar FormulaGrammar;

// This is because there is some recursion.
start: formula;

formula:
    ('!'|'not') formula             # Negation
    | formula 'and' formula         # Conjunction
    | formula 'or' formula          # Disjunction
    | formula ('implies'|'->') formula      # Implication
    | '(' formula ')'               # parens
    | 'K' '(' agentid ',' formula ')'       # Knowledge
    | '[' an_formula ']' formula    # Announcement
    | '<<' agentlist '>>' ca_formula        # Coalitional_announcement
    | ID                            # id
    ;

an_formula: formula;
ca_formula: formula;

agentid:  INT;
agentlist: agentid (',' agentid )* ;

INT: [0-9]+;

// We throw away white spaces, tabs and new lines.
WS: [ \t\r\n]+ -> skip ; 

// We throw away comments, either on a single line or on multiple lines
LINE_COMMENT: '//' .*? '\r'? '\n' -> skip ; 
COMMENT: '/*' .*? '*/' -> skip ; 

// C-style IDs
ID : ID_LETTER (ID_LETTER | DIGIT)* ;
// Fragment means that we cannot access it from the parser
fragment ID_LETTER : 'a'..'z'|'A'..'Z'|'_' ;
fragment DIGIT : '0'..'9' ;

