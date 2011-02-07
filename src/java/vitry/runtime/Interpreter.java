/*
 * Vitry, copyright (C) Hans Hoglund 2011
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * See COPYING.txt for details.
 */
package vitry.runtime;

import static vitry.runtime.Build.*;
import static vitry.runtime.struct.Sequences.*;

import java.math.BigInteger;
import java.util.Iterator;

import vitry.runtime.misc.*;
import vitry.runtime.parse.*;
import vitry.runtime.struct.*;

/**
 * Standard interpreter.
 * 
 * This implementation optimizes tail calls to interpreted functions, but not
 * to compiled functions.
 */
public class Interpreter implements Eval 
    {                

        // Token types
        
        private static final int TYPE_OP      = VitryParser.Op;
        private static final int TYPE_SYM     = VitryParser.Symbol;
        private static final int TYPE_NAT     = VitryParser.Natural;
        private static final int TYPE_FLOAT   = VitryParser.Float;
        private static final int TYPE_COMPLEX = VitryParser.Complex;
        private static final int TYPE_STRING  = VitryParser.String;
        
        private static final int TYPE_ANG     = VitryParser.Ang;
        private static final int TYPE_APPLY   = VitryParser.Apply;
        private static final int TYPE_ASSIGN  = VitryParser.Assign;
        private static final int TYPE_BRA     = VitryParser.Bra;
        private static final int TYPE_DO      = VitryParser.Do;
        private static final int TYPE_FN      = VitryParser.Fn;
        private static final int TYPE_IF      = VitryParser.If;
        private static final int TYPE_LEFT    = VitryParser.Left;
        private static final int TYPE_LET     = VitryParser.Let;
        private static final int TYPE_LOOP    = VitryParser.Loop;
        private static final int TYPE_MATCH   = VitryParser.Match;
        private static final int TYPE_MODULE  = VitryParser.Module;
        private static final int TYPE_OPS     = VitryParser.Ops;
        private static final int TYPE_PAR     = VitryParser.Par;
        private static final int TYPE_QUOTE   = VitryParser.Quote;
        private static final int TYPE_RECUR   = VitryParser.Recur;
        private static final int TYPE_TYPE    = VitryParser.Type;

        
        // Various identifiers
        
        private static final Symbol DELIMITER = Symbol.intern("delimiter");
        private static final Symbol SIDE      = Symbol.intern("side");
        private static final Symbol QUOTED    = Symbol.intern("quoted");
        private static final Symbol PAR       = Symbol.intern("()");
        private static final Symbol BRA       = Symbol.intern("[]");
        private static final Symbol ANG       = Symbol.intern("{}");
        private static final Symbol LEFT      = Symbol.intern("left");
        private static final Symbol RIGHT     = Symbol.intern("right");
        private static final Symbol TRUE      = Symbol.intern("true");
        private static final Symbol FALSE     = Symbol.intern("false");


        // Context for semantic disambiguition
        
        static final Environment<Symbol, Symbol> STANDARD_CONTEXT = (new HashEnvironment<Symbol, Symbol>()
            .define( DELIMITER , PAR    )
            .define( SIDE      , RIGHT  )
            .define( QUOTED    , FALSE  ));        
                
                
        public boolean acceptsParserTokens() {
            return true;
        }
        
        public boolean acceptsUserTokens() {
            return true;
        }
        
        
        public Object eval
                (
                Pattern expr
                ) 
        throws ParseError, LinkageError, TypeError {
            return eval
                (
                expr, 
                STANDARD_CONTEXT,
                VitryRuntime.prelude,
                VitryRuntime.preludeFixities);
        }
        


       
 
        
        final Object eval
                (
                Pattern expr,
                Environment<Symbol, Symbol> context,
                Environment<Symbol, Object> frame,
//                Sequence<vitry.runtime.Type> types,
//                Environment<Symbol, Sequence<Type>> implicits,
                Environment<Symbol, Fixity> fixities
                )
        throws ParseError, LinkageError, TypeError {
                             
            /*
             * Expr head or null
             */
            Pattern op;
            
            /*
             * Expr tail or null
             */
            Sequence<Pattern> ar;
            
            /*
             * Type of head
             */
            int opType;

            
            while (true) {
                                                  
                if (DEBUG) {
                    String exprStr = expr.toString();
                    Utils.nothing(exprStr);
                }     
                
                if (isSelfEvaluating(expr)) return expr;    
                
                /*
                 * Parse tree structure
                 *
                 * Now we infer operand, arguments and type, based on the current
                 * value of expr
                 */
                try {
                    if (isAcceptedToken(expr)) {
                        op = expr;
                        ar = null;                            
                    } else {
                        op = ((Product) expr).head();
                        ar = ((Product) expr).tail();
                    }
                } catch (Exception _) {
                    throw new ParseError("Unknown form: " 
                            + Utils.limit( expr.toString(), TRACE_LIMIT) );
                }
                try {
                    try {
                        opType = VitryTokenTypes.parserTokenType(op);
                    } catch (Exception _) {
                        opType = VitryTokenTypes.symbolicTokenType(op);
                    }
                } catch (VitryError e) {
                    throw e;
                }
                
                
                /*
                 * Process expr    
                 *         
                 * Each case should
                 *      1) update expr and continue
                 *      2) return
                 *      3) throw exception
                 */                
                switch (opType) {
                    
                    // Simple values
                               
                    case TYPE_NAT: 
                        return evalNat(op);
                    
                    case TYPE_FLOAT: 
                        return evalFloat(op);
                        
                    case TYPE_COMPLEX: 
                        return evalComplex(op);

                    case TYPE_STRING: 
                        return evalString(op);
                        
                    
                    // Single operators and symbols

                    case TYPE_OP:
                        if (context.lookup(SIDE) == LEFT || context.lookup(QUOTED) == TRUE) {
                            return evalOperator( op, context.lookup(DELIMITER) );  
                        } else {
                            return frame.lookup( evalOperator( op, context.lookup(DELIMITER) ));   
                        }
                        
                    
                    case TYPE_SYM:
                        if (context.lookup(SIDE) == LEFT || context.lookup(QUOTED) == TRUE ) {
                            return evalSymbol(op);
                        } else {
                            return frame.lookup(evalSymbol(op));
                        }
                                                                                     
                    
                    // Brackets
                    // TODO Allow syntax such as `(+) to parse as (`+) ?

                    case TYPE_PAR:
                        if (ar == null) {
                            if (context.lookup(SIDE) == LEFT || context.lookup(QUOTED) == TRUE ) {
                                return PAR;
                            } else {
                                return frame.lookup(PAR);                                
                            }
                        } else {
                            context = context.extend(DELIMITER, PAR).define(QUOTED, FALSE);
                            expr = ar.head();
                            continue;
                        }
                        
                    case TYPE_BRA:
                        if (ar == null) {
                            if (context.lookup(SIDE) == LEFT || context.lookup(QUOTED) == TRUE ) {
                                return BRA;
                            } else {
                                return frame.lookup(BRA);                                
                            }
                        } else {
                            context = context.extend(DELIMITER, BRA).define(QUOTED, FALSE);
                            expr = ar.head();
                            continue;
                        }
                        
                    case TYPE_ANG:
                        if (ar == null) {
                            if (context.lookup(SIDE) == LEFT || context.lookup(QUOTED) == TRUE ) {
                                return ANG;
                            } else {
                                return frame.lookup(ANG);                                
                            }
                        } else {
                            context = context.extend(DELIMITER, ANG).define(QUOTED, FALSE);
                            expr = ar.head();
                            continue;
                        }
                       
                    
                    // Context switches

                    case TYPE_LEFT:
                        context = context.extend(SIDE, LEFT);
                        expr = ar.head();
                        continue;

                    case TYPE_QUOTE:
                        context = context.extend(QUOTED, TRUE);
                        expr = ar.head();
                        continue;
                        
                    
                    // Modules and lambdas
                             
                    case TYPE_MODULE:
                        // TODO

                    case TYPE_FN:
                        {
                            Sequence<Pattern> params = butLast(ar);
                            Pattern body = last(ar);
                            
                            return new InterpretedFunction
                                (
                                    params, 
                                    body, 
                                    length(params), 
                                    frame
                                );
                        }
                        

                    // Let, loop and do

                    case TYPE_LET:
                        {
                            Sequence<Pattern> assignments = butLast(ar);
                            expr = last(ar);
                            
                            frame = frame.extend();
                            
                            for (Pattern a : assignments) {
                                eval(a, context, frame, fixities);              
                            }
                        }
                        continue;
                        
                    case TYPE_LOOP:
                        // Store expr for recur
                        // Tail expr

                    case TYPE_RECUR:
                        // Tail recur expr

                    case TYPE_DO:
                        // Push a mutable env
                        // Eval
                        // Tail the last expr

                    case TYPE_ASSIGN:
                        {
                            Object id = eval(first(ar), context, frame, fixities);
                            Object val = eval(second(ar), context, frame, fixities);
                            
                            try {
                                frame.define((Symbol) id, val);
                            } catch (ClassCastException e) {
                                throwAssignment(id);
                            }
                            return null;
                        }
                        
                        

                    // Application and infix ops

                    case TYPE_APPLY:
                        if (context.lookup(SIDE) == LEFT) {
                            // TODO
                        
                        } else {
                            Object function = eval(ar.head(), context, frame, fixities);
                            Sequence<Pattern> functionArguments = ar.tail();

                            /*
                             * If the given function is interpreted and has the correct arity, 
                             * evaluate it directly, otherwise fall back on the common calling 
                             * mechanism.
                             */
                            InterpretedFunction interpretedFunction = null;
                            try {  
                                interpretedFunction = (InterpretedFunction) function;  
                            } catch (Exception _) {
                            }   
                            
                            if (interpretedFunction       != null
                             && interpretedFunction.arity == length(functionArguments)) {

                                context = STANDARD_CONTEXT;                           
                                frame = interpretedFunction.getEnvironment().extend();
                                // types
                                // implicits
                                // fixities
                                
                                assignExprs(interpretedFunction, functionArguments, context, frame, fixities);
                                expr = interpretedFunction.body;
                                continue;
                                
                            } else {
                                return applyDefault(function, functionArguments, context, frame, fixities);
                            }
                        }
                        
                    case TYPE_OPS:
                        // Rewrite as application
                        // Tail
                        
                        
                    
                    // Branching

                    case TYPE_IF:
                        {
                            Object condition = eval(Sequences.first(ar), context, frame, fixities);    
                            if (! (condition.equals(FALSE)) ) {
                                expr = Sequences.second(ar);
                            } else {
                                expr = Sequences.third(ar);
                            }
                            continue;
                        }

                    case TYPE_MATCH:
                        // Pattern input = op;
                        // Sequence<Pattern> leftSide = null;
                        // Sequence<Pattern> rightSide = null;
                        // while (leftSide != null && rightSide != null) {
                        //     if (input.matchFor(leftSide.head())) {
                        //         return rightSide.head();
                        //     }
                        //     leftSide = leftSide.tail();
                        //     rightSide = rightSide.tail();
                        // }
                        // throw new MatchingError(input); 



                    // Type restr/spec
                        
                    case TYPE_TYPE:
                        if (context.lookup(SIDE) == LEFT) {
                            // Eval value
                            // Assert value corresponds to tag or throw TypeError                            
                        } else {
                            // Apply tag
                            // Return value
                        }


                    default:
                        throw new ParseError("Unkown form '" + op + "' in tree " 
                            + Utils.limit(expr.toString(), TRACE_LIMIT));
                }
            }
        }

        /**
         * Assign paremeters of the given values.
         */
        private void assignExprs
            (
            InterpretedFunction         ifn,
            Sequence<Pattern>           fnArgs, 
            Environment<Symbol, Symbol> context,
            Environment<Symbol, Object> frame,
            Environment<Symbol, Fixity> fixities
            )
        {    
            for (Iterator<Pattern> l = ifn.params.iterator(), r = fnArgs.iterator();
                 l.hasNext() && r.hasNext();) {
                Object name = eval(l.next(), context, frame, fixities);
                Object value = eval(r.next(), context, frame, fixities);
                try {
                    frame.define((Symbol) name, value);
                } catch (ClassCastException e) {
                    throwAssignment(name);
                }
            }
        }

        private Object applyDefault
            (
            Object fn,
            Sequence<Pattern> fnArgs, 
            Environment<Symbol, Symbol> context,
            Environment<Symbol, Object> frame, 
            Environment<Symbol, Fixity> fixities
            )
        {    
            // TODO this is a hack, find a faster and simpler way to do it...
            java.util.List<Object> fnArgVals = new java.util.LinkedList<Object>();
            
            for (Pattern fa : fnArgs) {
                fnArgVals.add(eval(fa, context, frame, fixities));
            }
            return ((StandardFunction) fn).applyVar(fnArgVals.toArray());
        }

        

        private static boolean isSelfEvaluating(Pattern expr) {
            return (expr instanceof Atom && !(expr instanceof VitryToken)) 
                || !(expr instanceof Pattern);
        }
        
        private static boolean isAcceptedToken(Pattern expr) {
            return expr instanceof VitryToken;
        }
        
        private static BigInteger evalNat(Pattern expr) {
            return new BigInteger(expr.toString());
        }

        private static Float evalFloat(Pattern expr) {
            return Float.valueOf(expr.toString());
        }

        private static Object evalComplex(Pattern expr) {
            return throwComplex();
        }
        
        private static Symbol evalOperator(Pattern expr, Symbol delimiter) {
            if (delimiter == PAR) return Symbol.intern("(" + expr + ")");
            if (delimiter == BRA) return Symbol.intern("[" + expr + "]");
            if (delimiter == ANG) return Symbol.intern("{" + expr + "}");
            assert false;
            return null;
        }
        
        private static Symbol evalSymbol(Pattern expr) {
            return Symbol.intern(expr.toString());
        }

        private static String evalString(Pattern expr) {
            String str = Utils.unescapeJava(expr.toString());
            return str.substring(1, str.length() - 1);
        }
        
        

        private static <T> T throwAssignment(Object id) {
            throw new ParseError("Can not assign to non-symbol " + id);
        }

        private static<T> T throwComplex() {
            throw new ParseError("Does not support complex numbers yet");
        }
    }




class InterpretedFunction extends RestFunction implements Arity
    {
        final Sequence<Pattern> params;
        final Pattern body;
        final Environment<Symbol, Object> env;
        final int arity;

        Interpreter i;

        public InterpretedFunction(Sequence<Pattern> params, Pattern body, int arity,
                Environment<Symbol, Object> env) {
            this.arity = arity;
            this.params = params;
            this.body = body;
            this.env = env;
        }

        public Environment<Symbol, Object> getEnvironment() {
            return env;
        }

        public int getArity() {
            return arity;
        }
        
        
        public Object applyTo(Sequence<?> args, int length) {
//            Environment<Symbol, Object> frame = this.getEnvironment().extend();                                
//            i.assignParameters(Interpreter.STANDARD_CONTEXT, frame, this, args);
//            return i.eval(body, Interpreter.STANDARD_CONTEXT, frame);
            return null; // TODO
        }
    }





class InterpretedModule extends Module
    {

        public InterpretedModule(Environment<Symbol, Object> env) {
            super(env);
            // TODO Auto-generated constructor stub
        }
    }
    
