grammar Vitry;

options {     
  language = Java;
  output = AST;
}

tokens {
    Par; Bra; Ang;
    Module; Fn;
    Let; Where; Assign; Left; Quote;
    Apply; Type; If; Match; Loop; Recur; Do;
    Ops; Dummy; 
       
    TypeDecl; ImplicitDecl; FnDecl; MemberDecl;
}
@header {package vitry.runtime.parse;}
@lexer::header {package vitry.runtime.parse;}

@members {
// TODO override mismatch() and recoverFromMismatchSet()
}
@lexer::members{
}

// General precedence order (higher to lower):
//   (:)
//   (`)
//   a b
//   a + b -- defined by user
// 
// XXX if, let and other forms vs. application?


expr    
    : (delim[true] ':') => delim[true] ':' expr    -> ^(Type delim expr)
    | delim[true]
    ; 

// Left-side expression, forces destructuring and type checks
// Note that in a : b, b is always right-side
left   
    : (delim[false] ':') => delim[false] ':' expr  -> ^(Left ^(Type delim expr))
    | delim[false]                                 -> ^(Left delim)
    ;

// Delimited, quoted or atomic
delim [boolean rs]
    : '(' inline[rs]? ')'                          -> ^(Par inline?)
    | '[' inline[rs]? ']'                          -> ^(Bra inline?)
    | '{' inline[rs]? '}'                          -> ^(Ang inline?)
    | '`' delim[rs]                                -> ^(Quote delim)
    | atom {$rs}?
    | Symbol
    ;   

atom
    : Natural
    | Float
    | Complex
    | String
    ;
    
// Inline, that is operator expr, application or special form
inline [boolean rs]
    : {$rs}? inlineRight
    | (Op apply?)+                                 -> ^(Ops ^(Op apply?)+)
    | (apply Op) => e+=apply (Op f+=apply?)+       -> ^(Ops $e ^(Op $f)+) // FIXME
    | apply
    ;                      
    
// Strictly right-side special forms
inlineRight
    : 'fn' '(' left* ')' inline[true]              -> ^(Fn left* inline)
    | 'let' '(' assign* ')' inline[true]           -> ^(Let assign* inline)
    | 'loop' '(' assign* ')' inline[true]          -> ^(Loop assign* inline)
    | 'do' '(' assign* ')' expr*                   -> ^(Do assign* expr*)
    | 'if' expr expr 'else'? inline[true]          -> ^(If expr expr inline)
    | 'match' v=expr '(' (l+=left r+=expr)* ')'    -> ^(Match $v ^($l $r)*)
    | 'recur' expr*         					   -> ^(Recur expr*)
    ;

assign
    : left '=' expr                                -> ^(Assign left expr)
    ;
    

apply
    : (expr expr) => expr+                         -> ^(Apply expr+)
    | expr
    ;
    
    
// Declarative forms
// These are a superset of the expression language
// They compile into functions that constructs modules and are implemented
// by rewriting

module 
    : 'module' moduleName ('(' exports+=Symbol* ')')?
      ('import' imports+=moduleName*)*
      ( '(' declarations+=moduleDecl ')' )*
    -> ^(Module moduleName ^($exports)* ^($imports)* ^($declarations)*)
    ;
    
moduleDecl
    : 'type'    '(' assign* ')'                -> ^(TypeDecl assign*)
    | 'impicit' '(' (expr expr)* ')'           -> ^(ImplicitDecl ^(expr expr)*)
    | Symbol    '(' left* ')' '=' inline[true] -> ^(FnDecl Symbol left+ inline)
    | left '=' expr                              -> ^(MemberDecl left expr)
    ;
    
moduleName :
    Symbol ('.' Symbol)* -> ^(Symbol Symbol+)
    ; 
    



// Lexer      

Op  : (
        '!' | '#' | '$' | '%' | '&' | '\'' | '*' | '+' | ',' | '-' |
        '.' | '/' | ';' | '<' | '=' | '>' | '?' | '@' | '\\' | '^' | 
        '_' | '`' | '|' | '~' | ':'
      )*
    ;
    
Symbol
    :    ('a'..'z'|'A'..'Z') ('a'..'z'|'A'..'Z'|'0'..'9')*
    ;

Natural
    :    '0'..'9'+
    ;

Float
    :   ('0'..'9')+ '.' ('0'..'9')* Exponent?
    |   ('0'..'9')+ Exponent
    ;
    
Complex
    :   ('0'..'9')+ '.' ('0'..'9')* Exponent? 'i'
    |   ('0'..'9')+ Exponent 'i'
    |   ('0'..'9')+ 'i'
    ;
    
Whitespace
    : ( ' '
      | '\t'
      | '\r'
      | '\n'
      ) {$channel=HIDDEN;}
    ;

String
    :  '"' ( EscapeSeq | ~('\\'|'"') )* '"'
    ;

fragment
Exponent : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;

fragment
HexDigit : ('0'..'9'|'a'..'f'|'A'..'F') ;

fragment
EscapeSeq
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    |   UnicodeEsc
    |   OctalEsc
    ;

fragment
OctalEsc
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UnicodeEsc
    :   '\\' 'u' HexDigit HexDigit HexDigit HexDigit
    ;

