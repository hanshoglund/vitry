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
}

tokens {
    Par; Bra; Ang;
    Module; Fn;
    Let; Where; Assign; Left; Quote;
    Apply; Type; If; Match; Loop; Recur; Do;
    Ops; 
       
    TypeDecl; ImplicitDecl; FnDecl; MemberDecl;
}


@header 
{// See src/antlr/Vitry.g        
package vitry.runtime.parse;
}

@lexer::header 
{// See src/antlr/Vitry.g
package vitry.runtime.parse;
}                         

@members {
    // TODO override mismatch() and recoverFromMismatchSet()
}

@lexer::members{
}



/*
 * Parser rules
 */

expr    
    : (delim[true] ':') => delim[true] ':' expr    -> ^(Type delim expr)
    | delim[true]
    ; 

/*
 * Left-side expression, forces destructuring and type checks
 * Note that in a : b, b is always right-side
 */
left   
    : (delim[false] ':') => delim[false] ':' expr  -> ^(Left ^(Type delim expr))
    | delim[false]                                 -> ^(Left delim)
    ;

/* 
 * Delimited, quoted or atomic
 */
delim [boolean rs]
    : '(' inline[rs]? ')'       -> ^(Par inline?)
    | '[' inline[rs]? ']'       -> ^(Bra inline?)
    | '{' inline[rs]? '}'       -> ^(Ang inline?)
    | '`' Op                    -> ^(Quote Op)
    | '`' delim[rs]             -> ^(Quote delim)
    | atom
    ;   

atom
    : Symbol
    | Natural
    | Float
    | Complex
    | String
    ;

/*    
 * Inline, that is operator expression, application or special form
 */
inline [boolean rs]
    : {$rs}? inlineRight
    | (Op) => Op
    | (Op apply)+                                  -> ^(Ops ^(Op apply?)+)
    | (apply Op) => e+=apply (Op f+=apply?)+       -> ^(Ops $e ^(Op $f)+)
    | apply
    ;                      

/*    
 * Strictly right-side special forms
 *
 * TODO For now, we allow any delimiter for these expressions, however none
 * of them emit context. Is this confusing?
 * 
 * We should probably restrict to proper individual pairs, i.e. forbid
 * expressions such as (let [x=1} x)
 */
inlineRight
    : 'fn'   '(' left*   ')' inline[true]              -> ^(Fn left* inline)
    | 'fn'   '[' left*   ']' inline[true]              -> ^(Fn left* inline)
    | 'let'  '(' assign* ')' inline[true]              -> ^(Let assign* inline)
    | 'let'  '[' assign* ']' inline[true]              -> ^(Let assign* inline)
    | 'loop' '(' assign* ')' inline[true]              -> ^(Loop assign* inline)
    | 'loop' '[' assign* ']' inline[true]              -> ^(Loop assign* inline)
    | 'do'   '(' assign* ')' expr*                     -> ^(Do assign* expr*)
    | 'do'   '[' assign* ']' expr*                     -> ^(Do assign* expr*)
    | 'match' v=expr '(' (c+=left e+=expr)* ')'        -> ^(Match $v ^($c $e)*)    
    | 'if' expr expr 'else'? inline[true]              -> ^(If expr expr inline)
    | 'recur' expr*         			       -> ^(Recur expr*)
    ;

assign
    : left '=' expr                                -> ^(Assign left expr)
    ;
    

apply
    : (expr expr) => expr+                         -> ^(Apply expr+)
    | expr
    ;



    

/* 
 * Declarative forms
 * TODO
 */

// module 
//     : 'module' moduleName ('(' exports+=Symbol* ')')?
//       ('import' imports+=moduleName*)*
//       ( '(' declarations+=moduleDecl ')' )*
//     -> ^(Module moduleName ^($exports)* ^($imports)* ^($declarations)*)
//     ;
//     
// moduleDecl
//     : 'type'    '(' assign* ')'                -> ^(TypeDecl assign*)
//     | 'implicit' '(' (expr expr)* ')'           -> ^(ImplicitDecl ^(expr expr)*)
//     | Symbol    '(' left* ')' '=' inline[true] -> ^(FnDecl Symbol left+ inline)
//     | left '=' expr                              -> ^(MemberDecl left expr)
//     ;
//     
// moduleName :
//     Symbol ('.' Symbol)* -> ^(Symbol Symbol+)
//     ; 
    





/*
 * Lexer rules
 */
 
Op  : (
        '!' | '#' | '$' | '%' | '&' | '\'' | '*' | '+' | ',' | '-' |
        '.' | '/' | ';' | '<' | '=' | '>' | '?' | '@' | '\\' | '^' | 
        '_' | '|' | '~' | ':'
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

