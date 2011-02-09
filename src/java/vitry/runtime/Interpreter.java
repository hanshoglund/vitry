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
        
        static final int TYPE_OP      = VitryParser.Op;
        static final int TYPE_SYM     = VitryParser.Symbol;
        static final int TYPE_NAT     = VitryParser.Natural;
        static final int TYPE_FLOAT   = VitryParser.Float;
        static final int TYPE_COMPLEX = VitryParser.Complex;
        static final int TYPE_STRING  = VitryParser.String;
        
        static final int TYPE_ANG     = VitryParser.Ang;
        static final int TYPE_APPLY   = VitryParser.Apply;
        static final int TYPE_ASSIGN  = VitryParser.Assign;
        static final int TYPE_BRA     = VitryParser.Bra;
        static final int TYPE_DO      = VitryParser.Do;
        static final int TYPE_FN      = VitryParser.Fn;
        static final int TYPE_IF      = VitryParser.If;
        static final int TYPE_LEFT    = VitryParser.Left;
        static final int TYPE_LET     = VitryParser.Let;
        static final int TYPE_LOOP    = VitryParser.Loop;
        static final int TYPE_MATCH   = VitryParser.Match;
        static final int TYPE_MODULE  = VitryParser.Module;
        static final int TYPE_OPS     = VitryParser.Ops;
        static final int TYPE_PAR     = VitryParser.Par;
        static final int TYPE_QUOTE   = VitryParser.Quote;
        static final int TYPE_RECUR   = VitryParser.Recur;
        static final int TYPE_TYPE    = VitryParser.Type;

        
        // Various identifiers
        
        static final Symbol DELIMITER = Symbol.intern("delimiter");
        static final Symbol SIDE      = Symbol.intern("side");
        static final Symbol QUOTED    = Symbol.intern("quoted");
        static final Symbol PAR       = Symbol.intern("()");
        static final Symbol BRA       = Symbol.intern("[]");
        static final Symbol ANG       = Symbol.intern("{}");
        static final Symbol LEFT      = Symbol.intern("left");
        static final Symbol RIGHT     = Symbol.intern("right");
        static final Symbol TRUE      = Symbol.intern("true");
        static final Symbol FALSE     = Symbol.intern("false");


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
            Sequence<Pattern> ops;
            
            /*
             * Type of head
             */
            int type;

            
            while (true) {
                                                  
                if (DEBUG) {
                    String exprStr = expr.toString();
                    Utils.nothing(exprStr);
                }     
                
                if (isSelfEvaluating(expr)) return expr;    
                
                /*
                 * Parse tree structure
                 *
                 * Now we infer operator, operands and type, based on the current
                 * value of expr
                 */
                try {
                    if (isAcceptedToken(expr)) {
                        op  = expr;
                        ops = null;                            
                    } else {           
                        // TODO Seq<P>, not Product?
                        op  = ((Sequence<Pattern>) expr).head();
                        ops = ((Sequence<Pattern>) expr).tail();
                    }
                } catch (Exception _) {
                    throw new ParseError("Unknown form: " 
                            + Utils.limit( expr.toString(), TRACE_LIMIT) );
                }
                try {
                    try {
                        type = VitryTokenTypes.parserTokenType(op);
                    } catch (Exception _) {
                        type = VitryTokenTypes.symbolicTokenType(op);
                    }
                } catch (VitryError e) {
                    throw e;
                }
                
                
                /*
                 * Process expr    
                 *         
                 * Each case should do one of:
                 *      1) update expr and continue
                 *      2) return
                 *      3) throw exception
                 */         
                        
                switch (type) {
                                                   
                    case TYPE_NAT: 
                        return evalNat(op);
                    
                    case TYPE_FLOAT: 
                        return evalFloat(op);
                        
                    case TYPE_COMPLEX: 
                        return evalComplex(op);

                    case TYPE_STRING: 
                        return evalString(op);
                        
                    
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
                    
                    /*
                     * The empty case is a symbol, while non-empty cases are context switches
                     * They also reset quote context
                     * 
                     * TODO Allow syntax such as `(+) to parse as (`+) ?
                     */

                    case TYPE_PAR:
                        if (ops == null) {
                            if (context.lookup(SIDE) == LEFT || context.lookup(QUOTED) == TRUE ) {
                                return PAR;
                            } else {
                                return frame.lookup(PAR);                                
                            }
                        } else {
                            context = context.extend(DELIMITER, PAR).define(QUOTED, FALSE);
                            expr = ops.head();
                            continue;
                        }
                        
                    case TYPE_BRA:
                        if (ops == null) {
                            if (context.lookup(SIDE) == LEFT || context.lookup(QUOTED) == TRUE ) {
                                return BRA;
                            } else {
                                return frame.lookup(BRA);                                
                            }
                        } else {
                            context = context.extend(DELIMITER, BRA).define(QUOTED, FALSE);
                            expr = ops.head();
                            continue;
                        }
                        
                    case TYPE_ANG:
                        if (ops == null) {
                            if (context.lookup(SIDE) == LEFT || context.lookup(QUOTED) == TRUE ) {
                                return ANG;
                            } else {
                                return frame.lookup(ANG);                                
                            }
                        } else {
                            context = context.extend(DELIMITER, ANG).define(QUOTED, FALSE);
                            expr = ops.head();
                            continue;
                        }
                       
                    
                    // Context switches

                    case TYPE_LEFT:
                        context = context.extend(SIDE, LEFT);
                        expr = ops.head();
                        continue;

                    case TYPE_QUOTE:
                        context = context.extend(QUOTED, TRUE);
                        expr = ops.head();
                        continue;
                        
                    

                             
                    case TYPE_MODULE:
                        // TODO



                    case TYPE_FN:
                        {
                            Sequence<Pattern> params = init(ops);
                            Pattern body = last(ops);   
                            return new InterpretedFunction(params, body, frame, fixities, this);
                        }
                        

                    // Let, loop and do
                        
                    /*
                     * These all involve the assign construct
                     * All should push a new frame before evaluating their assignments,
                     * then tail-call eval with the expression body so that this frame
                     * is properly discarded upon return
                     */

                    case TYPE_LET:
                        {
                            Sequence<Pattern> assignments = init(ops);
                            expr = last(ops);
                            frame = frame.extend();
                            
                            for (Pattern a : assignments) {
                                eval(a, context, frame, fixities);              
                            }
                        }
                        continue;
                        
                    case TYPE_LOOP:
                        throwNotSupported(); // TODO

                        // Store expr for recur
                        // Tail expr
                        

                    case TYPE_RECUR:
                        throwNotSupported(); // TODO

                        // Tail recur expr
                        

                    case TYPE_DO:
                        throwNotSupported(); // TODO
                        // Push a mutable env
                        // Eval
                        // Tail the last expr
                        

                    case TYPE_ASSIGN:
                        {
                            Object left = eval(first(ops), context, frame, fixities);
                            Object right = eval(second(ops), context, frame, fixities);
                            
                            if (left instanceof AssignContinuation) {
                                ((AssignContinuation) left).invoke(right, frame);
                                
                            } else {                            
                                try {
                                    frame.define((Symbol) left, right);
                                } catch (ClassCastException e) {
                                    throwAssignment(left);
                                }
                            }
                            return null;
                        }
                        
                        

                    // Application and infix ops

                    case TYPE_APPLY:
                        final Object            fn   = eval(ops.head(), context.extend(SIDE, RIGHT), frame, fixities);
                        final Sequence<Pattern> args = ops.tail();
                        final int               numArgs = length(args);

                        if (context.lookup(SIDE) == LEFT && (fn instanceof InvertibleFunction)) {
                            final Environment<Symbol, Symbol> contextCs = context;
                            final Environment<Symbol, Object> frameCs = frame;
                            final Environment<Symbol, Fixity> fixitiesCs = fixities;
                            
                            return new AssignContinuation()
                                {
                                    public void invoke(Object value, Environment<Symbol, Object> frame) {
                                        if (fn instanceof InvertibleFunction) {
                                            InvertibleFunction ifn = (InvertibleFunction) fn;
                                            
                                            // TODO Should we invoke applyVar for single args ?
                                            // Is this something that is dispatched by InvertibleFunction
                                            
                                            Sequence<?> vals = ifn.applyVarInverse(value);
                                            
                                            Iterator<Pattern> keyExprIt;
                                            Iterator<?> valIt;
                                            
                                            for (keyExprIt = args.iterator(), valIt = vals.iterator();
                                            keyExprIt.hasNext() && valIt.hasNext();) 
                                            {
                                                Object key = eval(keyExprIt.next(), contextCs, frameCs, fixitiesCs);
                                                Object val = valIt.next();

                                                if (key instanceof AssignContinuation) {
                                                    ((AssignContinuation) key).invoke(val, frame);
                                                    
                                                } else {                            
                                                    try {
                                                        frame.define((Symbol) key, val);
                                                    } catch (ClassCastException e) {
                                                        throwAssignment(key);
                                                    }
                                                }                                                
                                            }
                                            
                                        } else {
                                            assert false;                                            
                                        }
                                    }
                                };
                                
                        } else {

                            if (fn instanceof InterpretedFunction) {
                                
                                // Interpreted call
                             
                                InterpretedFunction ifn = (InterpretedFunction) fn;
                                int arity = ifn.getArity();

                                if (numArgs < arity) {
                                    Environment<Symbol, Object> callFrame = frame;
                                    frame = ifn.env.extend();
                                    
                                    SequenceIterator<Pattern> param;
                                    Iterator<Pattern> arg;
                                    
                                    for (param = ifn.params.sequenceIterator(), arg = args.iterator();
                                    param.hasNext() && arg.hasNext();) 
                                    {
                                        Object name = eval(param.next(), STANDARD_CONTEXT, frame, ifn.fixities);
                                        Object value = eval(arg.next(), STANDARD_CONTEXT, callFrame, ifn.fixities);
                                        try {
                                            frame.define((Symbol) name, value);
                                        } catch (ClassCastException e) {
                                            throwAssignment(name);
                                        }
                                    }
                                    return new InterpretedFunction
                                        (
                                        param.following(),  // Remaining parameters
                                        ifn.body, 
                                        frame,                    // Updated frame
                                        ifn.fixities, 
                                        ifn.interpr
                                        );
                                } 
                                if (numArgs == arity) {
                                    context = STANDARD_CONTEXT;
                                    Environment<Symbol, Object> callFrame = frame;
                                    frame = ifn.env.extend();
                                    
                                    for (Iterator<Pattern> param = ifn.params.iterator(), arg = args.iterator();
                                    param.hasNext() && arg.hasNext();) 
                                    {
                                        Object name = eval(param.next(), context, frame, fixities);
                                        Object value = eval(arg.next(), context, callFrame, fixities);
                                        try {
                                            frame.define((Symbol) name, value);
                                        } catch (ClassCastException e) {
                                            throwAssignment(name);
                                        }
                                    }
                                    expr = ifn.body;
                                    continue;
                                }
                                assert (numArgs > arity); 
                                {
                                    throwNotSupported();
                                    // eval as above
                                    // apply result to arg.currentSequence()
                                }
                                
                            } else {
                                
                                // Standard call
                                
                                // Doubly-linked, should be faster than a sequence
                                java.util.List<Object> vals = new java.util.LinkedList<Object>();
                                
                                for (Pattern arg : args) {
                                    vals.add(eval(arg, context, frame, fixities));
                                }
                                return ((StandardFunction) fn).applyVar(vals.toArray());
                            }
                        }
                        
                    case TYPE_OPS:
                        OperatorRewrite rw = new OperatorRewrite(fixities, context);
                        expr = rw.rewrite(ops);
                        continue;
                        
                    
                    // Branching

                    case TYPE_IF:
                        {
                            Object condition = eval(Sequences.first(ops), context, frame, fixities);    
                            if (! (condition.equals(FALSE)) ) {
                                expr = Sequences.second(ops);
                            } else {
                                expr = Sequences.third(ops);
                            }
                            continue;
                        }

                    case TYPE_MATCH:
                        throwNotSupported();

                        
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
                        {
                            // TODO native types
                            
                            Pattern left = (Pattern) eval(Sequences.first(ops), context, frame, fixities);
                            Pattern right = (Pattern) eval(Sequences.second(ops), context, frame, fixities);
    
                            if (context.lookup(SIDE) == LEFT) {
                                // TODO implement correct let behaviour with continuation?
                                if (!left.matchFor(right))
                                    throw new TypeError();
                                else
                                    return left;
                            } else {
                                if (right instanceof Type)
                                    return ((Type) right).tag(left);
                                else {
                                    // TODO create simplistic type or simply check?
                                    if (!left.matchFor(right))
                                        throw new TypeError();
                                    return left;
                                }
                            }
                        }


                    default:
                        throw new ParseError("Unkown form '" + op + "' in tree " 
                            + Utils.limit(expr.toString(), TRACE_LIMIT));
                }
            }
        }


        
        static boolean isSelfEvaluating(Pattern expr) {
            return (expr instanceof Atom && !(expr instanceof VitryToken)) 
                || !(expr instanceof Pattern);
        }
        
        static boolean isAcceptedToken(Pattern expr) {
            return expr instanceof VitryToken;
        }
        
        static BigInteger evalNat(Pattern expr) {
            return new BigInteger(expr.toString());
        }

        static Float evalFloat(Pattern expr) {
            return Float.valueOf(expr.toString());
        }

        static Object evalComplex(Pattern expr) {
            return throwComplex();
        }
        
        static Symbol evalOperator(Pattern expr, Symbol delimiter) {
            if (delimiter == PAR) return Symbol.intern("(" + expr + ")");
            if (delimiter == BRA) return Symbol.intern("[" + expr + "]");
            if (delimiter == ANG) return Symbol.intern("{" + expr + "}");
            assert false;
            return null;
        }
        
        static Symbol evalSymbol(Pattern expr) {
            return Symbol.intern(expr.toString());
        }

        static String evalString(Pattern expr) {
            String str = Utils.unescapeJava(expr.toString());
            return str.substring(1, str.length() - 1);
        }
        
        
        // Errors
        
        private static <T> T throwAssignment(Object id) {
            throw new ParseError("Can not assign to non-symbol " + id);
        }

        private static<T> T throwNotSupported() {
            throw new ParseError("Does not support this feature yet");
        }

        private static<T> T throwComplex() {
            throw new ParseError("Does not support complex numbers yet");
        }
    }




class InterpretedFunction extends RestFunction implements Arity
    {
        /**
         * Param and body expressions
         */
        final Sequence<Pattern> params;
        final Pattern body;
        final int arity;
        final Environment<Symbol, Fixity> fixities;
        
        /*
         * Creating interpreter
         */
        final Interpreter interpr;

        public InterpretedFunction(
                Sequence<Pattern> params, 
                Pattern body,
                Environment<Symbol, Object> env, 
                Environment<Symbol, Fixity> fixities,
                Interpreter interpreter) {
            super(env);
            this.body = body;
            this.params = params;
            this.arity = length(params);
            this.fixities = fixities;
            this.interpr = interpreter;
        }

        public int getArity() {
            return arity;
        }
        
        
        public Object applyVar(Sequence<?> args, int length) {
            Environment<Symbol, Object> frame = this.getEnvironment().extend();

            // TODO adapt to standard CC
            
            return null;                                
        }
        
        
        // Override to get a faster length
        
        public Object applyVar(Sequence<?> args) {
            return applyVar(args, length(args));
        }

        public Object applyVar(Object[] args) {
            return applyVar(new ArraySequence<Object>(args), args.length);
        }
    }


interface AssignContinuation {
    public void invoke(Object value, Environment<Symbol, Object> frame);
}


class InterpretedModule extends Module
    {

        public InterpretedModule(Environment<Symbol, Object> env) {
            super(env);
            // TODO Auto-generated constructor stub
        }
    }
    
