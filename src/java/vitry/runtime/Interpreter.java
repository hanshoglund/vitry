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

import java.math.BigInteger;
import java.util.Properties;

import vitry.runtime.misc.Utilities;
import vitry.runtime.parse.VitryParser;
import vitry.runtime.parse.VitryToken;
import vitry.runtime.struct.Seq;


/**
 * Standard interpreter.
 */
public class Interpreter implements Eval
    {        

        static final int PrimOp      = VitryParser.Op;
        static final int PrimSymbol  = VitryParser.Symbol;
        static final int PrimNatural = VitryParser.Natural;
        static final int PrimFloat   = VitryParser.Float;
        static final int PrimComplex = VitryParser.Complex;
        static final int PrimString  = VitryParser.String;
        
        static final int Ang         = VitryParser.Ang;
        static final int Apply       = VitryParser.Apply;
        static final int Assign      = VitryParser.Assign;
        static final int Bra         = VitryParser.Bra;
        static final int Do          = VitryParser.Do;
        static final int Fn          = VitryParser.Fn;
        static final int If          = VitryParser.If;
        static final int Left        = VitryParser.Left;
        static final int Let         = VitryParser.Let;
        static final int Loop        = VitryParser.Loop;
        static final int Match       = VitryParser.Match;
        static final int Module      = VitryParser.Module;
        static final int Ops         = VitryParser.Ops;
        static final int Par         = VitryParser.Par;
        static final int Quote       = VitryParser.Quote;
        static final int Recur       = VitryParser.Recur;
        static final int Type        = VitryParser.Type;

        static final Symbol delimiter = Symbol.intern("delimiter");
        static final Symbol nil       = Symbol.intern("nil");
        static final Symbol par       = Symbol.intern("par");
        static final Symbol bra       = Symbol.intern("bra");
        static final Symbol ang       = Symbol.intern("ang");
        static final Symbol side      = Symbol.intern("side");
        static final Symbol left      = Symbol.intern("left");
        static final Symbol right     = Symbol.intern("right");
        static final Symbol quoted    = Symbol.intern("quoted");
        static final Symbol t         = Symbol.intern("true");
        static final Symbol f         = Symbol.intern("false");
        
        
        // Contexts for semantic disambiguition of constructs such as
        // side-sensitive expressions, delimiters and quoting
        
        static final Environment<Symbol, Symbol> stdContext = new HashEnvironment<Symbol, Symbol>();
        static {
            stdContext.define(delimiter, nil);
            stdContext.define(side, right);
            stdContext.define(quoted, f);
        }
        
        

        public Object eval
                (
                Pattern e, 
                ClassLoader cl, 
                Seq<Module> link, 
                Properties useProps
                )
        throws ParseError, LinkageError {
            return null;
        }
        
        
        public Object eval
                (
                Pattern expr, 
                ClassLoader cl, 
                Seq<Module> link, 
                Properties useProps,
                Scope scope,
                Object types,       // TODO
                Object implicits,   // TODO
                Object fixities     // TODO
                )
        throws ParseError, LinkageError {
            
            Environment<Symbol, Symbol> context = stdContext;
            Environment<Symbol, Object> environment = scope.environment();
            // TODO types
            // TODO implicits
            // TODO fixities
            
            // We simulate tail calls to eval() by continue
            
            // Calls to actual functions use apply() for the time being
            // For interpreted functions this could of course be changed to a jump,
            // given that we can fix the handling of partial application
            
            while (true) {
                
                if (isSelfEvaluating(expr)) return expr;                
                if (isPrimitive(expr))      return evalPrimitive(expr, context, environment);
                
                Pattern      op;
                Seq<Pattern> args;
                int          tokenType = -1;
                
                try {
                    op   = ((Product) expr).head();
                    args = ((Product) expr).tail();
                } catch (ClassCastException t) {
                    throw new ParseError(
                        "Improperly formed syntax tree" + Utilities.limit(expr.toString(), 50));
                }                
                
                try {
                    tokenType = ((VitryToken) op).tokenType();
                } catch (ClassCastException t) {
                    throw new IllegalArgumentException(
                        "This interpreter only supports VitryTokens");
                }

                switch (tokenType) {
                    
                    case Par:
                        context = context.makeChild();
                        context.define(delimiter, par);
                        // Tail eval body
                        // (Pop context)

                    case Bra:
                        context = context.makeChild();
                        context.define(delimiter, bra);
                        // Tail eval body
                        // (Pop context)

                    case Ang:
                        context = context.makeChild();
                        context.define(delimiter, ang);
                        // Tail eval body
                        // (Pop context)

                    case Module:
                        // Typecheck
//                        return new InterpretedModule();

                    case Fn:
                        // Typecheck
                        // Store expr etc.
//                        return new InterpretedFunction(scope);

                    case Let:
                        environment = environment.makeChild();
                        // Do assignments
                        // Tail eval body
                        // (Pop env)

                    case Assign:
                        Symbol key  = (Symbol) args.head();
                        Pattern val = args.tail().head();
                        environment.define(key, val);

                    case Left:
                        context = context.makeChild();
                        context.define(side, left);
                        // Tail eval body
                        // (Pop context)

                    case Quote:
                        context = context.makeChild();
                        context.define(quoted, t);
                        // Tail eval body
                        // (Pop context)

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
                        Pattern alt1 = args.tail().head();
                        Pattern alt2 = args.tail().tail().head();

                        if (!cond.eq(f)) {
                            // Tail eval alt1
                        } else {
                            // Tail eval alt2
                        }

                    case Match:
                        // See below

                    case Loop:
                        // Make new env, assign
                        // Execute body with rec point here

                    case Recur:
                        // Jumpt to rec point

                    case Do:
                        // TODO

                    case Ops:
                        assert false : "Operators must be rewritten as application";

                    default:
                        assert false : "Unrecognized expression: " + expr;
                }
                context = context.parent();
            }
        }
         
        
        

        private Object evalPrimitive
                (
                Pattern expr, 
                Environment<Symbol, Symbol> context, 
                Environment<Symbol, Object> env
                )
            {
            int tokenType = -1;            
            try {
                tokenType = ((VitryToken) expr).tokenType();
            } catch (ClassCastException t) {
                throw new IllegalArgumentException(
                    "This interpreter only supports VitryTokens");
            }
            
            switch(tokenType) {
                case PrimNatural:  return new BigInteger(expr.toString());
                case PrimFloat:    return Float.valueOf(expr.toString());
                case PrimComplex:  throw new RuntimeException("Does not support complex numbers yet");
                case PrimString:   return expr.toString();
                
                case PrimOp: 
                case PrimSymbol:
                    if (context.lookup(quoted) == t) {
                        return Symbol.intern(expr.toString());
                    } else {
                        return env.lookup(Symbol.intern(expr.toString()));
                    }
            }
            assert false : "Invalid primitive token: " + expr.toString();
            return null;
        }
        
        


        private boolean isPrimitive(Pattern e) {
            if (e instanceof VitryToken) {
                int type = ((VitryToken) e).tokenType();
                return type == PrimOp
                    || type == PrimSymbol
                    || type == PrimNatural
                    || type == PrimFloat
                    || type == PrimComplex
                    || type == PrimString;
            }
            return false;
        }


        private boolean isSelfEvaluating(Pattern e) {
            return !(e instanceof Value) || e instanceof Atom;
        }
        
        
        
        
//        // TODO Deconstruction, type restrictions
//        public Value match(final Value input, Seq<Pattern> left, Seq<Pattern> right) {
//            while (left != null && right != null) {
//                if (input.matchFor(left.head())) {
//                    return right.head();
//                }
//                left = left.tail();
//                right = right.tail();
//            }
//            throw new MatchingError(input);
//        }

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


    
