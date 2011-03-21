/*
 * Vitry, copyright (C) Hans Hoglund 2011
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WAR'}'NTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICU'{'R PU')'OSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * See COPYING.txt for details.
 */
grammar Vitry;

options {     
  language = Java;
  output = AST;
  memoize = true;
}

tokens {
    Par; 
    Bra; 
    Ang;    
    Left; 
    Quote;
    Module; 
    Fn;
    Let; 
    Assign;
    Apply;
    Ops; 
    Delay; 
    If; 
    Match;    
    Do;
    Type;
    Import;
    Export;
    Implicit;
    Fixity;
    TypeDecl;
}


@header {
    // See src/antlr/Vitry.g
    package vitry.runtime.parse;
    
    import vitry.runtime.error.*;
}

// @members {
//     protected void mismatch(IntStream input, int ttype, BitSet follow) throws RecognitionException {
//         throw new MismatchedTokenException(ttype, input);
//     }
//     public Object recoverFromMismatchedSet(IntStream input, RecognitionException ex, BitSet follow) 
//          throws RecognitionException
//     {
//         throw new ParseError("Mismatched token", ex);
//     }
// }    
// 
// @rulecatch {
//     catch (RecognitionException ex) {
//         throw new ParseError("Recognition failed", ex);
//     }
// }        

@lexer::header {
    // See src/antlr/Vitry.g
    package vitry.runtime.parse;
}

@lexer::members{
    // public static int DEFAULT_CHANNEL = Token.DEFAULT_CHANNEL;
    public static int HIDDEN_CHANNEL  = Token.HIDDEN_CHANNEL;
    public static int COMMENT_CHANNEL = 55;
}


/*
 * Parser rules
 *
 * We have two main entry-points: 
 *     - expr, used by read and repl. Returns a single expression.
 *     - file, used by readFile. Returns a list of declarations.
 */

expr
    : 'fn'  '(' leftType+ ')'  expr                -> ^(Fn leftType+ expr)
    | 'let' ( ('(' left '=')=> assign )*  expr     -> ^(Let assign* expr)
    | 'do'  ( ('(' | '[' | '{' | '`' | literal )=> 
              ( ('(' left '=')=> assignOrExpr+=assign 
                | assignOrExpr+=type) )+           -> ^(Do $assignOrExpr+)
    | 'if' type type 'else'? expr                  -> ^(If type type expr)
    | 'match' type assign+                         -> ^(Match type assign+)
    | 'delay' expr                                 -> ^(Delay expr)    
    | inline
    ;

left
    : inline -> ^(Left inline)
    ;                    

inline
    : (Op (')' | ']' | '}')) => Op
    | (Op apply)+                                   -> ^(Ops ^(Op apply)+)
    | (apply Op) => e=apply (Op f+=apply)+          -> ^(Ops $e ^(Op $f)+)  
    | apply
    ;     

assign
    : '(' left '=' expr ')'  -> ^(Assign left expr)
    ;

apply
    : (type type) => type+  -> ^(Apply type+)
    | type
    ;

type    
    : (simple ':') => simple ':' simple   -> ^(Type simple simple)
    | simple
    ;
    
leftType
    : type -> ^(Left type)
    ; 

simple
    : '(' expr? ')'  -> ^(Par expr?)
    | '[' expr? ']'  -> ^(Bra expr?)
    | '{' expr? '}'  -> ^(Ang expr?)
    | '`' Op         -> ^(Quote Op)
    | '`' simple     -> ^(Quote simple)
    | literal;
    
literal
    : Symbol
    | Natural
    | Float
    | Complex
    | String
    ;



file 
    : '(' 'module' moduleName exportDecl* ')' decl+ -> ^(Module moduleName ^(Export exportDecl)* decl+)
    ;


decl 
    : '(' 'import' importDecl+ ')'   -> ^(Import importDecl)+
    | '(' 'implicit' simple+ ')'     -> ^(Implicit simple)+
    | '(' 'infix' infix+ ')'         -> ^(Fixity infix)+          
//    | 'type' ('(' assign ')')*
    | assign
    ;
    
    
exportDecl
    : Symbol
    | '(' Symbol ')' -> Symbol
    ;
    
importDecl
    : moduleName
    | '(' moduleName ('as' Symbol)? ')' -> moduleName Symbol?
    ;

infix 
    : '(' assoc=simple style=Op? pred=simple op=simple ')' -> $op $pred $assoc $style?
    ;

   
dummy :
    'module' | 'import' | 'as' | 'type' | 'implicit' | 'infix'
    ;
     

/*
 * TODO We should use some canonical separator, but we can not enforce it
 * without making it a special character.
 *
 * Maybe use a semantic predicate checking LA(1)?
 */
moduleName :
    Symbol (Op Symbol)* -> ^(Symbol Symbol*)
    ;   
    


/*
 * Lexer rules
 */
Op  : (
         '!' | '#' | '$' | '%' | '&' | '\'' | '*' | '+' | ',' | '-' |
         '.' | '/' | ':' | ';' | '<' | '=' | '>' | '?' | '@' | '\\' | '^' | 
         '|' | '~'
       )*
     ;

    
Symbol
    :    ('_'|'a'..'z'|'A'..'Z') ('_'|'a'..'z'|'A'..'Z'|'0'..'9')*
    ;

Natural
    :    '0'..'9'+
    ;

Float
    // :   ('0'..'9')+ '.' ('0'..'9')* Exponent?
    :   ('0'..'9')+ '.' ('0'..'9')+ Exponent?
    |   ('0'..'9')+ Exponent
    ;
    
Complex
    :   ('0'..'9')+ '.' ('0'..'9')* Exponent? 'i'
    |   ('0'..'9')+ Exponent 'i'
    |   ('0'..'9')+ 'i'
    ;
    
Comment
    :   ';' ~('\n'|'\r')* '\r'? '\n' {$channel=COMMENT_CHANNEL;}
    |   '#|' ( options {greedy=false;} : . )* '|#' {$channel=COMMENT_CHANNEL;}
    ;
        
LineSpace
    : (' ' | '\t') {$channel=HIDDEN;}
    ;
LineBreak
    : ('\n' | '\r' '\n'?) {$channel=HIDDEN;}
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

