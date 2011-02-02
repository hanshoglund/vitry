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

import static vitry.runtime.misc.Utils.limit;
import static vitry.runtime.misc.Utils.nothing;

import java.math.BigInteger;

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
        private static final boolean DEBUG = true;
        
        
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

        /**
         * Maps user-provided symbolic tokens to parser-generated types. 
         */
        private static final Environment<Pattern, Integer> SYMBOLIC_TOKENS =
            new HashEnvironment<Pattern, Integer>()
                .define(Symbol.intern("Ang"),    Ang)
                .define(Symbol.intern("Apply"),  Apply)
                .define(Symbol.intern("Assign"), Assign)
                .define(Symbol.intern("Bra"),    Bra)
                .define(Symbol.intern("Do"),     Do)
                .define(Symbol.intern("Fn"),     Fn)
                .define(Symbol.intern("If"),     If)
                .define(Symbol.intern("Left"),   Left)
                .define(Symbol.intern("Let"),    Let)
                .define(Symbol.intern("Loop"),   Loop)
                .define(Symbol.intern("Match"),  Match)
                .define(Symbol.intern("Module"), Module)
                .define(Symbol.intern("Ops"),    Ops)
                .define(Symbol.intern("Par"),    Par)
                .define(Symbol.intern("Quote"),  Quote)
                .define(Symbol.intern("Recur"),  Recur)
                .define(Symbol.intern("Type"),   Type)
                ;

        
        // Various identifiers
         
        private static final Symbol delimiter = Symbol.intern("delimiter");
        private static final Symbol nil       = Symbol.intern("nil");
        private static final Symbol par       = Symbol.intern("()");
        private static final Symbol bra       = Symbol.intern("[]");
        private static final Symbol ang       = Symbol.intern("{}");
        private static final Symbol side      = Symbol.intern("side");
        private static final Symbol left      = Symbol.intern("left");
        private static final Symbol right     = Symbol.intern("right");
        private static final Symbol quoted    = Symbol.intern("quoted");
        private static final Symbol true_     = Symbol.intern("true");
        private static final Symbol false_    = Symbol.intern("false");
        private static final Symbol add       = Symbol.intern("add");

        /**
         * Context for semantic disambiguition
         */
        private static final Environment<Symbol, Symbol> STD_CONTEXT = 
            new HashEnvironment<Symbol, Symbol> ()
                .define(delimiter, par)
                .define(side,      right)
                .define(quoted,    false_)
                ;
        
        private static final Scope STD_SCOPE = new Scope(){
            public Environment<Symbol, Object> environment() {
                return new HashEnvironment<Symbol, Object>()
                    .define(par, nil)
                    .define(ang, nil)
                    .define(bra, nil)
                    .define(nil, nil)
                    .define(add, Vitry.add)
                    .define(true_, true_)
                    .define(false_, false_)
                    ;
            }
        };


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
                STD_CONTEXT,
                STD_SCOPE.environment());
        }
        




 

        public Object eval
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
                                    
            // Subexpressions, generated during the analysis phase
            // Do not update from the switch block, or your value is overwritten
                       
            Pattern op;                     // expr head or null
            Sequence<Pattern> args;         // expr tail or null
            int type;                       // type of head (to switch on)


            while (true)
            {              
                
                if (DEBUG) 
                {                    
                    String exprStr = expr.toString();
                    nothing(exprStr);
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
                    throw new ParseError("Malformed syntax tree: " + limit(expr.toString(), EXPR_TRACE_LIMIT));
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
                        if (context.lookup(quoted) == true_) {
                            return parseOperator
                                (
                                op, 
                                context.lookup(delimiter)
                                );  
                        } else {
                            return frame.lookup(parseOperator
                                (
                                op, 
                                context.lookup(delimiter)
                                ));   
                        }

                    case SYM:
                        if (context.lookup(side) == left) {
                            return parseSymbol(op);
                        } else {
                            if (context.lookup(quoted) == true_) {
                                return parseSymbol(op);
                            } else {
                                return frame.lookup(parseSymbol(op));
                            }                            
                        }

                    
                    // Non-terminals
                    
                        
                    // These forms all have the same behaviour: If () is bound to nil, 
                    // evaluate the contained expression in a context where delimiter=();
                    // else apply the bound function to the contained expression evaluated
                    // a context where delimiter=()
                    
                    case Par:
                        context = context.makeChild()
                            .define(delimiter, par)
                            .define(quoted, false_);
                        expr = args.head();
                        if (frame.lookup(par) == nil) {
                            continue;                            
                        } else {
                            Object val = eval(expr, pre, context, frame);
                            return ((Apply) frame.lookup(par)).apply(val);
                        }

                    case Bra:
                        context = context.makeChild()
                            .define(delimiter, bra)
                            .define(quoted, false_);
                        expr = args.head();
                        if (frame.lookup(bra) == nil) {
                            continue;                            
                        } else {
                            Object val = eval(expr, pre, context, frame);
                            return ((Apply) frame.lookup(bra)).apply(val);
                        }   
                        
                    case Ang:
                        context = context.makeChild()
                            .define(delimiter, ang)
                            .define(quoted, false_);
                        expr = args.head();
                        if (frame.lookup(ang) == nil) {
                            continue;                            
                        } else {
                            Object val = eval(expr, pre, context, frame);
                            return ((Apply) frame.lookup(ang)).apply(val);
                        }
                        
                    case Module:
                        // Typecheck
//                        return new InterpretedModule();

                    case Fn:
                        {
                            Sequence<Pattern> params = Sequences.butLast(args);
                            expr = Sequences.last(args);
                        }

                        
                        
                        // Typecheck
//                        new InterpretedFunction(scope);

                    case Let:
                        {
                            Sequence<Pattern> assigns = Sequences.butLast(args);
                            expr = Sequences.last(args);
                            frame = frame.makeChild();
                            for (Pattern a : assigns)
                                eval(a, pre, context, frame);
                        }
                        continue;

                    case Assign:
                        {
                            Object key = eval(Sequences.first(args), pre, context, frame);
                            Object val = eval(Sequences.second(args), pre, context, frame);
                            try {
                                frame.define((Symbol) key, val);
                            } catch (ClassCastException e) {
                                throw new ParseError("Can not assign to non-symbol " + key);
                            }
                            return null;
                        }

                    case Left:
                        context = context.makeChild().define(side, left);
                        expr = args.head();
                        continue;

                    case Quote:
                        context = context.makeChild().define(quoted, true_);
                        expr = args.head();
                        continue;

                    case Apply:
                        if (context.lookup(side) == left) {
                            // TODO
                        
                        } else {
                            Object f = eval(args.head(), pre, context, frame);
                            
                            if (f instanceof InterpretedFunction) {
                                // TODO
                            } else {
                                java.util.List<Object> fargs = new java.util.LinkedList<Object>();
                                for (Pattern farg : args.tail()) {
                                    fargs.add(eval(farg, pre, context, frame));
                                }
                                return ((Apply) f).applyTo(fargs.toArray());
                            }
                        }

                    case Type:
                        if (context.lookup(side) == left) {
                            // Eval value
                            // Assert value corresponds to tag or throw TypeError                            
                        } else {
                            // Apply tag
                            // Return value
                        }

                    case If:
                        Object cond = eval(args.head(), pre, context, frame );
                        if (!false_.equals(cond)) {
                            expr = args.tail().head();
                            continue;
                        } else {
                            expr = args.tail().tail().head();
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
                        throw new ParseError("Unknown form: "
                                + limit(expr.toString(), EXPR_TRACE_LIMIT));
                }
            }
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
            if (delimiter == par) return Symbol.intern("(" + expr + ")");
            if (delimiter == bra) return Symbol.intern("[" + expr + "]");
            if (delimiter == ang) return Symbol.intern("{" + expr + "}");
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
                Sequence<Pattern> vars;
                Pattern body;
                int arity;
                
                public InterpretedFunction(Sequence<Pattern> args, Pattern body, int arity) {
                    this.vars = args;
                    this.body = body;
                    this.arity = arity;
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


    
