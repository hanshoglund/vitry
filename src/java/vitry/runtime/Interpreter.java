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

import static vitry.runtime.build.*;
import static vitry.runtime.misc.Utils.limit;
import static vitry.runtime.struct.Sequences.butLast;
import static vitry.runtime.struct.Sequences.first;
import static vitry.runtime.struct.Sequences.last;
import static vitry.runtime.struct.Sequences.length;
import static vitry.runtime.struct.Sequences.second;

import java.math.BigInteger;
import java.util.Iterator;

import vitry.runtime.misc.Utils;
import vitry.runtime.parse.VitryParser;
import vitry.runtime.parse.VitryToken;
import vitry.runtime.struct.Sequence;
import vitry.runtime.struct.Sequences;


/**
 * Standard interpreter.
 * 
 * This implementation optimizes tail calls to interpreted functions, but not
 * to compiled functions (as these use standard calling conventions).
 * 
 * This class may be used with both parser-generated and custom syntax trees, i.e. it
 * accepts both Symbols and VitryTokens for imaginary nodes, and both atomic values and 
 * VitryTokens for terminal symbols.
 */
public class Interpreter implements Eval
    {   

             
        private static final int     EXPR_TRACE_LIMIT = 50;
        
        
        // Token types
        
        private static final int OP           = VitryParser.Op;
        private static final int SYM          = VitryParser.Symbol;
        private static final int NAT          = VitryParser.Natural;
        private static final int FLOAT        = VitryParser.Float;
        private static final int COMPLEX      = VitryParser.Complex;
        private static final int STRING       = VitryParser.String;
        
        private static final int Ang          = VitryParser.Ang;
        private static final int Apply        = VitryParser.Apply;
        private static final int Assign       = VitryParser.Assign;
        private static final int Bra          = VitryParser.Bra;
        private static final int Do           = VitryParser.Do;
        private static final int Fn           = VitryParser.Fn;
        private static final int If           = VitryParser.If;
        private static final int Left         = VitryParser.Left;
        private static final int Let          = VitryParser.Let;
        private static final int Loop         = VitryParser.Loop;
        private static final int Match        = VitryParser.Match;
        private static final int Module       = VitryParser.Module;
        private static final int Ops          = VitryParser.Ops;
        private static final int Par          = VitryParser.Par;
        private static final int Quote        = VitryParser.Quote;
        private static final int Recur        = VitryParser.Recur;
        private static final int Type         = VitryParser.Type;


        
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
        
        
        /**
         * Maps user-provided symbolic tokens to parser-generated types. 
         */
        private static final Environment<Pattern, Integer> SYMBOLIC_TOKENS =
             new HashEnvironment<Pattern, Integer>()
             .define( Symbol.intern("Ang")    , Ang    )
             .define( Symbol.intern("Apply")  , Apply  )
             .define( Symbol.intern("Assign") , Assign )
             .define( Symbol.intern("Bra")    , Bra    )
             .define( Symbol.intern("Do")     , Do     )
             .define( Symbol.intern("Fn")     , Fn     )
             .define( Symbol.intern("If")     , If     )
             .define( Symbol.intern("Left")   , Left   )
             .define( Symbol.intern("Let")    , Let    )
             .define( Symbol.intern("Loop")   , Loop   )
             .define( Symbol.intern("Match")  , Match  )
             .define( Symbol.intern("Module") , Module )
             .define( Symbol.intern("Ops")    , Ops    )
             .define( Symbol.intern("Par")    , Par    )
             .define( Symbol.intern("Quote")  , Quote  )
             .define( Symbol.intern("Recur")  , Recur  )
             .define( Symbol.intern("Type")   , Type   )
             ;
        

        /**
         * Context for semantic disambiguition
         */
        private static final Environment<Symbol, Symbol> standardContext = 
            new HashEnvironment<Symbol, Symbol>()
            .define( DELIMITER , PAR    )
            .define( SIDE      , RIGHT  )
            .define( QUOTED    , FALSE )
            ; 
                
                
                
        public boolean acceptsParserTokens() {
            return true;
        }
        
        
        public boolean acceptsUserTokens() {
            return true;
        }
        
        
        
        
        public Object eval
                (
                Pattern expr, 
                Prerequisites setup
                ) 
        throws ParseError, LinkageError, TypeError {
            return eval
                (
                expr, 
                setup, 
                standardContext,
                VitryRuntime.prelude/*.makeChild()*/);
        }
        



        Object eval
                (
                Pattern expr,
                Prerequisites pre,
                Environment<Symbol, Symbol> context,
                Environment<Symbol, Object> frame
//                Sequence<vitry.runtime.Type> types,
//                Environment<Symbol, Sequence<Type>> implicits,
//                Environment<Symbol, Fixity> fixities
                )
        throws ParseError, LinkageError, TypeError {
                                    
            // Subexpressions, generated during analysis
            // Do not change from the switch block
                       
            Pattern op;                     // expr head or null
            Sequence<Pattern> args;         // expr tail or null
            int type;                       // type of head (to switch on)


            while (true)
            {              
                
                if (DEBUG) 
                {                    
                    String exprStr = expr.toString();
                    Utils.nothing(exprStr);
                }
                
                // Analysis phase
                
                if (isSelfEvaluating(expr)) return expr;                    
                
                try {
                    if (isToken(expr)) 
                    {
                        op   = expr;
                        args = null;                            
                    } 
                    else 
                    {
                        op   = ((Product) expr).head();
                        args = ((Product) expr).tail();
                    }
                } catch (Exception _) {
                    throw new ParseError("Malformed syntax tree: " + limit( expr.toString(), EXPR_TRACE_LIMIT) );
                }
                try {
                    try {
                        type = parserTokenType(op);
                    } catch (Exception _) {
                        type = symbolicTokenType(op);
                    }
                } catch (VitryError e) {
                    throw e;
                }
                
                
                switch (type)
                {
                                        
                    // Terminals
                    
                    case NAT:      
                        return parseNat(op);

                    
                    case FLOAT:    
                        return parseFloat(op);
                        

                    case COMPLEX:
                        return parseComplex(op);
                    

                    case STRING:   
                        return parseString(op);
                                            

                    case OP:
                        // Operators depend on delimiter context
                        if (context.lookup(QUOTED) == TRUE) {
                            return parseOperator( op, context.lookup(DELIMITER) );  
                        } else {
                            return frame.lookup( parseOperator( op, context.lookup(DELIMITER) ));   
                        }


                    case SYM:
                        if (context.lookup(SIDE) == LEFT) {
                            return parseSymbol(op);
                        } else {
                            if (context.lookup(QUOTED) == TRUE) {
                                return parseSymbol(op);
                            } else {
                                return frame.lookup( parseSymbol(op) );
                            }                            
                        }

                    
                    // Non-terminals
                    
                    // These forms all have the same behaviour: If () is bound to nil, 
                    // evaluate the contained expression in a context where delimiter=();
                    // else apply the bound function to the contained expression evaluated
                    // a context where delimiter=()
                    
                    case Par:
                        context = context.makeChild()
                            .define(DELIMITER, PAR)
                            .define(QUOTED, FALSE);
                        
                        expr = args.head();
                        
                        if (frame.lookup(PAR) != VitryRuntime.nil) 
                        {
                            Object value = eval(expr, pre, context, frame);
                            return ((Apply) frame.lookup(PAR)).apply(value);
                        } 
                        else continue;
                        

                    case Bra:
                        context = context.makeChild()
                            .define(DELIMITER, BRA)
                            .define(QUOTED, FALSE);
                        
                        expr = args.head();
                        
                        if (frame.lookup(BRA) != VitryRuntime.nil) 
                        {
                            Object value = eval(expr, pre, context, frame);
                            return ((Apply) frame.lookup(BRA)).apply(value);
                        } 
                        else continue;
                        
                        
                    case Ang:
                        context = context.makeChild()
                            .define(DELIMITER, ANG)
                            .define(QUOTED, FALSE);
                        
                        expr = args.head();
                        
                        if (frame.lookup(ANG) != VitryRuntime.nil) 
                        {
                            Object value = eval(expr, pre, context, frame);
                            return ((Apply) frame.lookup(ANG)).apply(value);
                        } 
                        else continue;
                        
                        
                        
                        
                    case Module:
                        // Typecheck
//                        return new InterpretedModule();
                           
                    

                    case Fn:
                        {
                            Sequence<Pattern> params = butLast(args);
                            Pattern body = last(args);
                            int arity = length(params);
                            
                            return new InterpretedFunction(params, body, arity, frame);
                        }


                    case Let:
                        {
                            Sequence<Pattern> assignments = butLast(args);
                            expr = last(args);
                            frame = frame.makeChild();
                            for (Pattern a : assignments) {
                                eval(a, pre, context, frame);              
                            }
                        }
                        continue;
                        

                    case Assign:
                        {
                        Object name = eval(first(args), pre, context, frame);
                        Object value = eval(second(args), pre, context, frame);
                            try {
                                frame.define((Symbol) name, value);
                            } catch (ClassCastException e) {
                                throw new ParseError("Can not assign to non-symbol " + name);
                            }
                            return null;
                        }
                        

                    case Left:
                        context = context.makeChild().define(SIDE, LEFT);
                        expr = args.head();
                        continue;
                        

                    case Quote:
                        context = context.makeChild().define(QUOTED, TRUE);
                        expr = args.head();
                        continue;
                        

                    case Apply:
                        if (context.lookup(SIDE) == LEFT) {
                            // TODO
                        
                        } else {
                            Object fn = eval(args.head(), pre, context, frame);
                            Sequence<Pattern> fnArgs = args.tail();

                            // If fn is interpreted and has the correct arity, we evaluate it directly, 
                            // otherwise we fall back on the common calling conventions
                            
                            InterpretedFunction ifn = null;
                            try { 
                                ifn = (InterpretedFunction) fn; 
                                } catch (Exception _){}
                            
                            if (ifn != null && ifn.arity == length(fnArgs)) {
                                frame = ifn.environment().makeChild();                                
                                assignParameters(pre, context, frame, ifn, fnArgs);
                                expr = ifn.body;
                                continue;
                                
                            } else {
                                return applyDefault(pre, context, frame, fn, fnArgs);
                            }
                        }
                        

                    case Type:
                        if (context.lookup(SIDE) == LEFT) {
                            // Eval value
                            // Assert value corresponds to tag or throw TypeError                            
                        } else {
                            // Apply tag
                            // Return value
                        }

                    case If:
                        {
                            Object condition = eval(Sequences.first(args), pre, context, frame);
    
                            if (! (condition.equals(FALSE)) ) {
                                expr = Sequences.second(args);
                            } else {
                                expr = Sequences.third(args);
                            }
                            continue;
                        }

                    case Match:
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

                    case Loop:
                        // Store expr for recur
                        // Tail expr

                    case Recur:
                        // Tail recur expr

                    case Do:
                        // Push a mutable env
                        // Eval
                        // Tail the last expr

                    case Ops:
                        // Rewrite as application
                        // Tail

                    default:
                        throw new ParseError("Unkown form '" + op + "' in tree " 
                                + limit(expr.toString(), EXPR_TRACE_LIMIT));
                }
            }
        }




        private void assignParameters
            (
            Prerequisites pre, 
            Environment<Symbol, Symbol> context,
            Environment<Symbol, Object> frame, 
            InterpretedFunction ifn,
            Sequence<Pattern> fnArgs
            )
        {    
            for (Iterator<Pattern> l = ifn.params.iterator(), r = fnArgs.iterator();
                 l.hasNext() && r.hasNext();) {
                Object name = eval(l.next(), pre, context, frame);
                Object value = eval(r.next(), pre, context, frame);
                try {
                    frame.define((Symbol) name, value);
                } catch (ClassCastException e) {
                    throw new ParseError("Can not assign to non-symbol " + name);
                }
            }
        }




        private Object applyDefault
            (
            Prerequisites pre, 
            Environment<Symbol, Symbol> context,
            Environment<Symbol, Object> frame, 
            Object fn, 
            Sequence<Pattern> fnArgs
            )
        {    
            java.util.List<Object> fnArgVals = new java.util.LinkedList<Object>();
            
            for (Pattern fa : fnArgs) {
                fnArgVals.add(eval(fa, pre, context, frame));
            }
            return ((Function) fn).applyTo(fnArgVals.toArray());
        }
        
        


        private int parserTokenType(Pattern op) {
            return ((VitryToken) op).tokenType();
        }   
        
        private int symbolicTokenType(Pattern p) {
            try {
                return SYMBOLIC_TOKENS.lookup(p);                
            } catch (Exception e) {
                throw new ParseError("Unknown form: " + p);
            }
        }

        private boolean isSelfEvaluating(Pattern expr) {
            return (expr instanceof Atom && !(expr instanceof VitryToken)) || !(expr instanceof Value);
        }
        
        private boolean isToken(Pattern expr) {
            return expr instanceof VitryToken;
        }
        
        


        private BigInteger parseNat(Pattern expr) {
            return new BigInteger(expr.toString());
        }

        private Float parseFloat(Pattern expr) {
            return Float.valueOf(expr.toString());
        }

        private Object parseComplex(Pattern expr) {
            throw new ParseError("Does not support complex numbers yet");
        }
        
        private Symbol parseOperator(Pattern expr, Symbol delimiter) {
            if (delimiter == PAR) return Symbol.intern("(" + expr + ")");
            if (delimiter == BRA) return Symbol.intern("[" + expr + "]");
            if (delimiter == ANG) return Symbol.intern("{" + expr + "}");
            assert false;
            return null;
        }
        
        private Symbol parseSymbol(Pattern expr) {
            return Symbol.intern(expr.toString());
        }

        private String parseString(Pattern expr) {
            String str = Utils.unescapeJava(expr.toString());
            return str.substring(1, str.length() - 1);
        }
        
        

        
        static class InterpretedFunction extends Function
            {
                Sequence<Pattern> params;
                Pattern body;
                Environment<Symbol, Object> env;

                public InterpretedFunction(Sequence<Pattern> params, Pattern body, int arity, Environment<Symbol, Object> env) {
                    this.params = params;
                    this.body = body;
                    this.arity = arity;
                    this.env = env;
                }

                public Environment<Symbol, Object> environment() {
                    return env;
                }
            }
            





        static class InterpretedModule extends Module
            {
            }
            
            

//        static class IFn1 extends InterpretedFunction
//            {   
//                
//                public Object apply(Object a0) throws InvocationError {
//                    return a0;
//                }
//            }
//
//        static class IFn2 extends InterpretedFunction
//            {
//                public Object apply(Object a0, Object a1) throws InvocationError {
//                    return a1;
//                }
//            }
//
//        static class IFn3 extends InterpretedFunction
//            {
//                public Object apply(Object a0, Object a1, Object a2) throws InvocationError {
//                    return a2;
//                }
//            }
//
//        static class IFn4 extends InterpretedFunction
//            {
//                public Object apply(Object a0, Object a1, Object a2, Object a3)
//                        throws InvocationError {
//                    return a3;
//                }
//            }
//
//        static class IFn5 extends InterpretedFunction
//            {
//                public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4)
//                        throws InvocationError {
//                    return a4;
//                }
//            }
//
//        static class IFn6 extends InterpretedFunction
//            {
//                public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4,
//                        Object a5) throws InvocationError {
//                    return a5;
//                }
//            }
//
//        static class IFn7 extends InterpretedFunction
//            {
//                public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4,
//                        Object a5, Object a6) throws InvocationError {
//                    return a6;
//                }
//            }
//
//        static class IFn8 extends InterpretedFunction
//            {
//                public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4,
//                        Object a5, Object a6, Object a7) throws InvocationError {
//                    return a7;
//                }
//            }
//
//        static class IFn9 extends InterpretedFunction
//            {
//                public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4,
//                        Object a5, Object a6, Object a7, Object a8) throws InvocationError {
//                    return a8;
//                }
//            }
//
//        static class IFn10 extends InterpretedFunction
//            {
//                public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4,
//                        Object a5, Object a6, Object a7, Object a8, Object a9)
//                        throws InvocationError {
//                    return a9;
//                }
//            }
//
//        static class IFn11 extends InterpretedFunction
//            {
//                public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4,
//                        Object a5, Object a6, Object a7, Object a8, Object a9, Object a10)
//                        throws InvocationError {
//                    return a10;
//                }
//            }
//
//        static class IFn12 extends InterpretedFunction
//            {
//                public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4,
//                        Object a5, Object a6, Object a7, Object a8, Object a9, Object a10,
//                        Object a11) throws InvocationError {
//                    return a11;
//                }
//            }
//
//        static class IFn13 extends InterpretedFunction
//            {
//                public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4,
//                        Object a5, Object a6, Object a7, Object a8, Object a9, Object a10,
//                        Object a11, Object a12) throws InvocationError {
//                    return a12;
//                }
//            }
//
//        static class IFn14 extends InterpretedFunction
//            {
//                public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4,
//                        Object a5, Object a6, Object a7, Object a8, Object a9, Object a10,
//                        Object a11, Object a12, Object a13) throws InvocationError {
//                    return a13;
//                }
//            }
//
//        static class IFn15 extends InterpretedFunction
//            {
//                public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4,
//                        Object a5, Object a6, Object a7, Object a8, Object a9, Object a10,
//                        Object a11, Object a12, Object a13, Object a14) throws InvocationError {
//                    return a14;
//                }
//            }
//
//        static class IFn16 extends InterpretedFunction
//            {
//                public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4,
//                        Object a5, Object a6, Object a7, Object a8, Object a9, Object a10,
//                        Object a11, Object a12, Object a13, Object a14, Object a15)
//                        throws InvocationError {
//                    return a15;
//                }
//            }

    }


    
