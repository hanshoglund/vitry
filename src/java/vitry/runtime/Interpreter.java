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

import java.math.BigInteger;

import vitry.runtime.misc.Utils;
import vitry.runtime.parse.VitryParser;
import vitry.runtime.parse.VitryToken;
import vitry.runtime.struct.Seq;


/**
 * Standard interpreter.
 * 
 * This implementation optimizes tail calls to interpreted functions, but not
 * to compiled functions (as these use standard calling conventions).
 */
public class Interpreter implements Eval
    {        

        static final int EXPR_TRACE_LIMIT = 50;
        
        static final int OP           = VitryParser.Op;
        static final int SYM          = VitryParser.Symbol;
        static final int NAT          = VitryParser.Natural;
        static final int FLOAT        = VitryParser.Float;
        static final int COMPLEX      = VitryParser.Complex;
        static final int STRING       = VitryParser.String;
        
        static final int Ang          = VitryParser.Ang;
        static final int Apply        = VitryParser.Apply;
        static final int Assign       = VitryParser.Assign;
        static final int Bra          = VitryParser.Bra;
        static final int Do           = VitryParser.Do;
        static final int Fn           = VitryParser.Fn;
        static final int If           = VitryParser.If;
        static final int Left         = VitryParser.Left;
        static final int Let          = VitryParser.Let;
        static final int Loop         = VitryParser.Loop;
        static final int Match        = VitryParser.Match;
        static final int Module       = VitryParser.Module;
        static final int Ops          = VitryParser.Ops;
        static final int Par          = VitryParser.Par;
        static final int Quote        = VitryParser.Quote;
        static final int Recur        = VitryParser.Recur;
        static final int Type         = VitryParser.Type;

        static final Symbol delimiter = Symbol.intern("delimiter");
        static final Symbol nil       = Symbol.intern("nil");
        static final Symbol par       = Symbol.intern("()");
        static final Symbol bra       = Symbol.intern("[]");
        static final Symbol ang       = Symbol.intern("{}");
        static final Symbol side      = Symbol.intern("side");
        static final Symbol left      = Symbol.intern("left");
        static final Symbol right     = Symbol.intern("right");
        static final Symbol quoted    = Symbol.intern("quoted");
        static final Symbol true_     = Symbol.intern("true");
        static final Symbol false_    = Symbol.intern("false");
        
        
        // Contexts for semantic disambiguition of constructs such as
        // side-sensitive expressions, delimiters and quoting
        
        static final Environment<Symbol, Symbol> stdContext = new HashEnvironment<Symbol, Symbol>();
        static {
            stdContext.define(delimiter, par);
            stdContext.define(side,      right);
            stdContext.define(quoted,    false_);
        }
                      
        static class EvalState {
                Environment<Symbol, Symbol> context;
                Scope scope;
                Object types;       // TODO
                Object implicits;   // TODO
                Object fixities;    // TODO
        }
        
        
        public Object eval(Pattern expr, EvalPre pre) throws ParseError, LinkageError {
            // TODO
            EvalState state = new EvalState();
            
            state.scope = new Scope(){
                public Environment<Symbol, Object> environment() {
                    HashEnvironment<Symbol, Object> env = new HashEnvironment<Symbol, Object>();
                    env.define(par, nil);
                    env.define(ang, nil);
                    env.define(bra, nil);
                    env.define(nil, nil);
                    env.define(true_, true_);
                    env.define(false_, false_);                    
                    return env;
                }
            };
            return eval(expr, pre, state);
        }
        

        public Object eval
                (
                Pattern expr,
                EvalPre pre,
                EvalState state
                )
        throws ParseError, LinkageError {
            return eval(expr, pre, 
                    state.context = state.context == null ? stdContext : state.context,
                    state.scope.environment(),
                    state.types,
                    state.implicits,
                    state.fixities);
        }
        

        
        public Object eval
                (
                Pattern expr,
                EvalPre pre,
                Environment<Symbol, Symbol> context,
                Environment<Symbol, Object> frame,
                Object types,       // TODO
                Object implicits,   // TODO
                Object fixities     // TODO
                )
        throws ParseError, LinkageError {
                        
            // We do everything insida a loop and simulate tail calls to eval() by continue
            // To self-calf, update the parameters you need and jump
            // Calls to actual functions use apply() for the time being
            
            // Subexpressions, generated during the analysis phase of each pass from the current value of expr
            // Do not update from the switch block, they will get overwritten
                       
            Pattern      op;            // expr list head or null
            Seq<Pattern> args;          // expr list tail or null
            int          type;          // integer type of the head token (for switch)

            
            while (true)
            {           
                
                @SuppressWarnings("unused")
                String exprStr = expr.toString(); // Debugger
                
                
                // Return self-evaluating
                
                if (!(expr instanceof Value) || (expr instanceof Atom && !(expr instanceof VitryToken)))
                    return expr;
                    
                
                // Analysis phase
                
                if (expr instanceof VitryToken) {
                    op   = expr;
                    args = null;
                } else {
                    try {
                        op   = ((Product) expr).head();
                        args = ((Product) expr).tail();
                    } catch (ClassCastException t) {
                        throw new ParseError(
                            "Interpreter failed to evaluate syntax tree " +
                            "" + limit(expr.toString(), EXPR_TRACE_LIMIT));
                    }                
                }
                
                try {
                    type = ((VitryToken) op).tokenType();
                } catch (ClassCastException t) {
                    throw new IllegalArgumentException("This interpreter expects VitryTokens");
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
                        if (context.lookup(quoted) == true_) {
                            return parseSymbol(op);
                        } else {
                            return frame.lookup(parseSymbol(op));
                        }

                    
                    // Non-terminals
                    
                        
                    // These forms all have the same behaviour: If () is bound to nil, 
                    // evaluate the contained expression in a context where delimiter=();
                    // else apply the bound function to the contained expression evaluated
                    // a context where delimiter=()
                    
                    case Par:
                        context = context.makeChild();
                        context.define(delimiter, par);
                        context.define(quoted, false_);
                        expr = args.head();
                        if (frame.lookup(par) == nil) {
                            continue;                            
                        } else {
                            Object val = eval(expr, pre, context, frame, types, implicits, fixities);
                            return ((Apply) frame.lookup(par)).apply(val);
                        }

                    case Bra:
                        context = context.makeChild();
                        context.define(delimiter, bra);
                        context.define(quoted, false_);
                        expr = args.head();
                        if (frame.lookup(bra) == nil) {
                            continue;                            
                        } else {
                            Object val = eval(expr, pre, context, frame, types, implicits, fixities);
                            return ((Apply) frame.lookup(bra)).apply(val);
                        }
                        
                    case Ang:
                        context = context.makeChild();
                        context.define(delimiter, bra);
                        context.define(quoted, false_);
                        expr = args.head();
                        if (frame.lookup(ang) == nil) {
                            continue;                            
                        } else {
                            Object val = eval(expr, pre, context, frame, types, implicits, fixities);
                            return ((Apply) frame.lookup(ang)).apply(val);
                        }
                        
                    case Module:
                        // Typecheck
//                        return new InterpretedModule();

                    case Fn:
                        // Typecheck
//                        new InterpretedFunction(scope);

                    case Let:
                        frame = frame.makeChild();

                        Seq<Pattern> assigns = (Seq<Pattern>) args.head(); 
                        // Do assignments

                        expr = args.tail().head();
                        continue;

                    case Assign:
                        Symbol  key = (Symbol) args.head();
                        Pattern val = args.tail().head();
                        frame.define(key, val);

                    case Left:
                        context = context.makeChild();
                        context.define(side, left);
                        // Tail eval body

                    case Quote:
                        context = context.makeChild();
                        context.define(quoted, true_);
                        expr = args.head();
                        continue;

                    case Apply:
                        if (context.lookup(side) == left) {
                            // Cast to Apply
                            // Eval args
                            // Invoke
                            // Return result
                        } else {
                            // Cast to ApplyLeft
                            // Eval args
                            // Invoke
                            // Return result
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
                        Pattern cond = args.head();
                        if (!cond.eq(false_)) {
                            expr = args.tail().head();
                            continue;
                        } else {
                            expr = args.tail().tail().head();
                            continue;
                        }

                    case Match:
                        Pattern input = op;
                        Seq<Pattern> leftSide = null;
                        Seq<Pattern> rightSide = null;
                        while (leftSide != null && rightSide != null) {
                            if (input.matchFor(leftSide.head())) {
                                return rightSide.head();
                            }
                            leftSide = leftSide.tail();
                            rightSide = rightSide.tail();
                        }
                        throw new MatchingError(input);

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
                        throw new ParseError("Evaluation failed, unknown form: "
                                + limit(expr.toString(), EXPR_TRACE_LIMIT));
                }
            }
        }


        private BigInteger parseNat(Pattern expr) {
            return new BigInteger(parseString(expr));
        }

        private Float parseFloat(Pattern expr) {
            return Float.valueOf(parseString(expr));
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
        
         


        
        abstract class InterpretedFunction extends Function
            {
                Seq<Pattern> vars;

                Pattern body;
            }

        class IFn1 extends InterpretedFunction
            {
                public Object apply(Object a0) throws InvocationError {
                    return a0;
                }
            }

        class IFn2 extends InterpretedFunction
            {
                public Object apply(Object a0, Object a1) throws InvocationError {
                    return a1;
                }
            }

        class IFn3 extends InterpretedFunction
            {
                public Object apply(Object a0, Object a1, Object a2) throws InvocationError {
                    return a2;
                }
            }

        class IFn4 extends InterpretedFunction
            {
                public Object apply(Object a0, Object a1, Object a2, Object a3)
                        throws InvocationError {
                    return a3;
                }
            }

        class IFn5 extends InterpretedFunction
            {
                public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4)
                        throws InvocationError {
                    return a4;
                }
            }

        class IFn6 extends InterpretedFunction
            {
                public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4,
                        Object a5) throws InvocationError {
                    return a5;
                }
            }

        class IFn7 extends InterpretedFunction
            {
                public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4,
                        Object a5, Object a6) throws InvocationError {
                    return a6;
                }
            }

        class IFn8 extends InterpretedFunction
            {
                public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4,
                        Object a5, Object a6, Object a7) throws InvocationError {
                    return a7;
                }
            }

        class IFn9 extends InterpretedFunction
            {
                public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4,
                        Object a5, Object a6, Object a7, Object a8) throws InvocationError {
                    return a8;
                }
            }

        class IFn10 extends InterpretedFunction
            {
                public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4,
                        Object a5, Object a6, Object a7, Object a8, Object a9)
                        throws InvocationError {
                    return a9;
                }
            }

        class IFn11 extends InterpretedFunction
            {
                public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4,
                        Object a5, Object a6, Object a7, Object a8, Object a9, Object a10)
                        throws InvocationError {
                    return a10;
                }
            }

        class IFn12 extends InterpretedFunction
            {
                public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4,
                        Object a5, Object a6, Object a7, Object a8, Object a9, Object a10,
                        Object a11) throws InvocationError {
                    return a11;
                }
            }

        class IFn13 extends InterpretedFunction
            {
                public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4,
                        Object a5, Object a6, Object a7, Object a8, Object a9, Object a10,
                        Object a11, Object a12) throws InvocationError {
                    return a12;
                }
            }

        class IFn14 extends InterpretedFunction
            {
                public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4,
                        Object a5, Object a6, Object a7, Object a8, Object a9, Object a10,
                        Object a11, Object a12, Object a13) throws InvocationError {
                    return a13;
                }
            }

        class IFn15 extends InterpretedFunction
            {
                public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4,
                        Object a5, Object a6, Object a7, Object a8, Object a9, Object a10,
                        Object a11, Object a12, Object a13, Object a14) throws InvocationError {
                    return a14;
                }
            }

        class IFn16 extends InterpretedFunction
            {
                public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4,
                        Object a5, Object a6, Object a7, Object a8, Object a9, Object a10,
                        Object a11, Object a12, Object a13, Object a14, Object a15)
                        throws InvocationError {
                    return a15;
                }
            }

        class InterpretedModule extends Module
            {


            }
    }


    
