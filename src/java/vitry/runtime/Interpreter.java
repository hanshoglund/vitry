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

import static vitry.Build.*;
import static vitry.runtime.struct.Seqs.*;

import java.math.BigInteger;
import java.util.Iterator;

import vitry.runtime.error.*;
import vitry.runtime.misc.*;
import vitry.runtime.parse.*;
import vitry.runtime.struct.*;


/**
 * Standard interpreter.
 *
 * This implementation optimizes tail calls to interpreted functions,
 * but not to compiled functions.
 *
 * @author Hans Höglund
 */
public class Interpreter implements Eval
{

    static final Symbol DELIMITER = Symbol.intern("delimiter");
    static final Symbol SIDE        = Symbol.intern("side");
    static final Symbol QUOTED     = Symbol.intern("quoted");
    static final Symbol MUTABLE    = Symbol.intern("mutable");
    static final Symbol PAR         = Symbol.intern("()");
    static final Symbol BRA         = Symbol.intern("[]");
    static final Symbol ANG         = Symbol.intern("{}");
    static final Symbol LEFT        = Symbol.intern("left");
    static final Symbol RIGHT      = Symbol.intern("right");
    static final Symbol TRUE        = Symbol.intern("true");
    static final Symbol FALSE      = Symbol.intern("false");


    public static final Env<Symbol, Symbol> STANDARD_CONTEXT = (new HashEnv<Symbol, Symbol>()
        .define( DELIMITER , PAR    )
        .define( SIDE        , RIGHT  )
        .define( QUOTED     , FALSE  )
        .define( MUTABLE    , FALSE  ));


    final VitryRuntime runtime;

    final ModuleProvider moduleProvider;


    public Interpreter(VitryRuntime runtime) {
        this.runtime = runtime;
        this.moduleProvider = null;
    }

    public Interpreter(VitryRuntime runtime, ModuleProvider moduleProvider) {
        this.runtime = runtime;
        this.moduleProvider = moduleProvider;
    }


    public boolean acceptsParserTokens() {
        return true;
    }

    public boolean acceptsUserTokens() {
        return true;
    }

    public VitryRuntime getRuntime() {
        return runtime;
    }

    public ModuleProvider getModuleProvider() {
        return moduleProvider;
    }


    public Object eval(Object expr) throws ParseError, LinkageError, TypeError {
        return eval(expr,
                        STANDARD_CONTEXT,
                        runtime.getPrelude(),
                        runtime.getPreludeFixities());
    }



    
    
    
    
    public final Object eval(Object expr,
                             Env<Symbol, Symbol> context,
                             Env<Symbol, Object> frame,
                             // Sequence<vitry.runtime.Type> types,
                             // Environment<Symbol, Sequence<Type>> implicits,
                             Env<Symbol, Fixity> fixities)

    throws ParseError, LinkageError, TypeError
    {
        Pattern exprHead;
        Seq<Pattern> exprTail;
        int exprType;

        interpreter : while (true)
        {
            if (isSelfEvaluating(expr))
            {
                if (expr instanceof Symbol)
                {
                    return maybeLookup((Symbol) expr, context, frame);
                }
                else
                {
                    return expr;
                }
            }

            try {
                if (isAcceptedToken(expr))
                {
                    exprHead = Utils.<Pattern>unsafe(expr);
                    exprTail = null;
                }
                else
                {
                    exprHead = Utils.<Seq<Pattern>>unsafe(expr).head();
                    exprTail = Utils.<Seq<Pattern>>unsafe(expr).tail();
                }

                exprType = VitryTokenTypes.tokenType(exprHead);

            } catch (Exception _) {
                throw new ParseError("Unknown form: "
                        + Utils.limit( expr.toString(), TRACE_LIMIT) );
            }

            /*
             * Switch on type
             *
             * Each case must either
             *    - update expr and continue (i.e. self-call eval)
             *    - return
             *    - throw exception
             */
            switch (exprType)
            {

                /*
                 * Trivial forms
                 */
                case VitryParser.Natural: return evalNat(exprHead);
                case VitryParser.Float:   return evalFloat(exprHead);
                case VitryParser.Complex: return evalComplex(exprHead);
                case VitryParser.String:  return evalString(exprHead);

                /*
                 * Symbols and operators
                 *
                 * May lookup or self-evaluate, depending on context
                 */
                case VitryParser.Op:      return maybeLookupEvalOp(exprHead, context, frame);
                case VitryParser.Symbol:  return maybeLookupEval(exprHead, context, frame);

                
                /*
                 * Brackets
                 *
                 * The empty case is a symbol, while non-empty cases are context switches
                 * They also reset quote context
                 *
                 * We have to duplicate some code in order to get the tail-call :(
                 */
                case VitryParser.Par:
                {
                    if (isNil(exprTail))
                    {
                        return evalNullaryDelimiter(PAR, context, frame);
                    }
                    Object bound = frame.lookup(PAR);

                    if (!isOps(exprTail.head()) && bound instanceof Product)
                    {
                        return evalSingleDelimiter(exprTail, bound, context, frame, fixities);
                    }
                    context = context.extend(DELIMITER, PAR).define(QUOTED, FALSE);
                    expr = exprTail.head();
                    continue interpreter;
                }

                case VitryParser.Bra:
                {

                    if (isNil(exprTail))
                    {
                        return evalNullaryDelimiter(BRA, context, frame);
                    }
                    Object bound = frame.lookup(BRA);

                    if (!isOps(exprTail.head()) && bound instanceof Product)
                    {
                        return evalSingleDelimiter(exprTail, bound, context, frame, fixities);
                    }
                    context = context.extend(DELIMITER, BRA).define(QUOTED, FALSE);
                    expr = exprTail.head();
                    continue interpreter;
                }

                case VitryParser.Ang:
                {
                    if (isNil(exprTail))
                    {
                        return evalNullaryDelimiter(ANG, context, frame);
                    }
                    Object bound = frame.lookup(ANG);

                    if (!isOps(exprTail.head()) && bound instanceof Product)
                    {
                        return evalSingleDelimiter(exprTail, bound, context, frame, fixities);
                    }
                    context = context.extend(DELIMITER, ANG).define(QUOTED, FALSE);
                    expr = exprTail.head();
                    continue interpreter;
                }


                /*
                 * Context switches
                 */
                case VitryParser.Left:
                    context = context.extend(SIDE, LEFT);
                    expr = exprTail.head();
                    continue;

                case VitryParser.Quote:
                    context = context.extend(QUOTED, TRUE);
                    expr = exprTail.head();
                    continue interpreter;




                case VitryParser.Module:
                    // TODO

                    


                case VitryParser.Fn:
                    {
                        Seq<Pattern> params = init(exprTail);
                        Pattern body = last(exprTail);
                        return new InterpretedFunction(params, body, frame, fixities, this);
                    }


                /*
                 * Let and do
                 *
                 * These forms push a new frame before evaluating their assignments, 
                 * then tail-call so that the updated frame is discarded upon return
                 */
                case VitryParser.Let:
                    {
                        Seq<Pattern> assignments = init(exprTail);
                        expr = last(exprTail);
                        frame = frame.extend();
                        context = context.extend()
                            .define(MUTABLE, FALSE)
                            .define(DELIMITER, PAR)
                            .define(QUOTED, FALSE)
                            .define(SIDE, RIGHT);

                        for (Pattern a : assignments) 
                        {
                            eval(a, context, frame, fixities);
                        }
                    }
                    continue interpreter;

                case VitryParser.Do:
                    {
                        Seq<Pattern> assignments = init(exprTail);
                        expr = last(exprTail);                        
                        // Actually, expr may be an assignment as well, but
                        // we will discard its value anyway
                        
                        frame = frame.extend();
                        context = context.extend()
                            .define(MUTABLE, TRUE)
                            .define(DELIMITER, PAR)
                            .define(QUOTED, FALSE)
                            .define(SIDE, RIGHT);

                        if (assignments != null)
                        {
                            for (Pattern a : assignments) 
                            {
                                eval(a, context, frame, fixities);
                            }
                        }
                    }
                    continue interpreter;



                case VitryParser.Assign:
                    {
                        Object left = eval(first(exprTail), context, frame, fixities);
                        Object right = eval(second(exprTail), context, frame, fixities);

                        if (left instanceof LeftContinuation) {
                            ((LeftContinuation) left).invoke(right, frame);

                        } else {
                            try {
                                if (context.lookup(MUTABLE) == TRUE) {
                                    frame.assoc((Symbol) left, right);
                                } else {
                                    frame.define((Symbol) left, right);
                                }
                            } catch (ClassCastException e) {
                                throwAssignment(left);
                            }
                        }  
                        // Discarded except in the final clause of a do-expression 
                        return right;
                    }
                    



                case VitryParser.If:
                    {
                        Object condition = eval(Seqs.first(exprTail), context, frame, fixities);
                        
                        if (!(condition.equals(FALSE)))
                        {
                            expr = Seqs.second(exprTail);
                        } 
                        else 
                        {
                            expr = Seqs.third(exprTail);
                        }
                        continue interpreter;
                    }
                    


                case VitryParser.Match:
                    {
                        Object        value = eval(exprTail.head(), context, frame, fixities);
                        Seq<Pattern> cases = exprTail.tail();
                        Env<Symbol, Object> topFrame = frame;

                        match :
                        for (Pattern c : cases) {
                            Seq<Pattern> caseTail = ((Seq<Pattern>) c).tail();
                            Object left = eval(first(caseTail), context, frame, fixities);

                            frame = topFrame.extend();
                            expr = second(caseTail);

                            try {
                                if (left instanceof LeftContinuation) {
                                    ((LeftContinuation) left).invoke(value, frame);
                                } else {
                                    if (left instanceof Symbol) {
                                        frame.define((Symbol) left, value);
                                    } else {
                                        if (value instanceof Pattern) {
                                            if (!((Pattern) value).matchFor(Native.wrap(left)))
                                                TypeError.throwMismatch(value, left);            // TODO throw something lighter...
                                        } else {
                                            if (!Native.wrap(value).matchFor(Native.wrap(left)))
                                                TypeError.throwMismatch(value, left);
                                        }
                                    }
                                }
                            } catch (TypeError e) {
                                continue match;
                            } catch (ClassCastException e) {
                                throwAssignment(left);
                            }
                            continue interpreter;

                        }
                        throw new MatchingError(value);
                    }




                // Application and infix ops

                case VitryParser.Apply:
                    final Object        fn    = eval(exprTail.head(), context.extend(SIDE, RIGHT), frame, fixities);
                    final Seq<Pattern> args = exprTail.tail();
                    final int          numArgs = length(args);

                    if (context.lookup(SIDE) == LEFT && (fn instanceof InvertibleFunction)) {
                        final Env<Symbol, Symbol> contextCs = context;
                        final Env<Symbol, Object> frameCs = frame;
                        final Env<Symbol, Fixity> fixitiesCs = fixities;

                        return new LeftContinuation()
                            {
                                public void invoke(Object value, Env<Symbol, Object> frame) {
                                    if (fn instanceof InvertibleFunction) {
                                        InvertibleFunction ifn = (InvertibleFunction) fn;

                                        Seq<?> vals = ifn.applyVarInverse(value);

                                        Iterator<Pattern> keyExprIt;
                                        Iterator<?> valIt;

                                        for (keyExprIt = args.iterator(), valIt = vals.iterator();
                                        keyExprIt.hasNext() && valIt.hasNext();)
                                        {
                                            Object key = eval(keyExprIt.next(), contextCs, frameCs, fixitiesCs);
                                            Object val = valIt.next();

                                            if (key instanceof LeftContinuation) {
                                                ((LeftContinuation) key).invoke(val, frame);

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
                                context = STANDARD_CONTEXT;
                                Env<Symbol, Object> callFrame = frame;
                                frame = ifn.env.extend();

                                SeqIterator<?> param;
                                Iterator<Pattern> arg;

                                for (param = ifn.params.sequenceIterator(), arg = args.iterator();
                                param.hasNext() && arg.hasNext();)
                                {
                                    Object name = eval(param.next(), context, frame, ifn.fixities);
                                    Object value = eval(arg.next(), context, callFrame, ifn.fixities);
                                    try {
                                        frame.define((Symbol) name, value);
                                    } catch (ClassCastException e) {
                                        throwAssignment(name);
                                    }
                                }
                                return new InterpretedFunction(param.following(),      // Remaining parameters
                                                                ifn.body,
                                                                frame,                  // Updated frame
                                                                ifn.fixities,
                                                                ifn.interpr);
                            }
                            if (numArgs == arity) {
                                context = STANDARD_CONTEXT;
                                Env<Symbol, Object> callFrame = frame;
                                frame = ifn.env.extend();

                                for (Iterator<?> param = ifn.params.iterator(), arg = args.iterator();
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
                                continue interpreter;
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
                            return ((Function) fn).applyVar(vals.toArray());
                        }
                    }


                case VitryParser.Ops:
                    OperatorRewrite rw = new OperatorRewrite(fixities, context);
                    expr = rw.rewrite(exprTail);
                    continue interpreter;




                // Type restr/spec

                case VitryParser.Type:
                    {
                        // TODO native types

                        final Object left = eval(Seqs.first(exprTail), context, frame, fixities);
                        final Pattern right = Native.wrap(eval(Seqs.second(exprTail), context.extend(SIDE, RIGHT), frame, fixities));

                        if (context.lookup(SIDE) == LEFT) {

                            return new LeftContinuation() {
                                public void invoke(Object value, Env<Symbol, Object> frame) {

                                    // Check type
                                    if (!Native.wrap(value).matchFor(right)) TypeError.throwMismatch(value, right);

                                    if (left instanceof LeftContinuation) {
                                        // Left may be a destructuring or other type check
                                        // It should do its work after we have verified the type of value
                                        ((LeftContinuation) left).invoke(value, frame);
                                    } else {
                                        // Finish pending assignment
                                        try {
                                            frame.define((Symbol) left, value);
                                        } catch (ClassCastException e) {
                                            throwAssignment(left);
                                        }
                                    }
                                }
                            };

                        } else {
                            if (right instanceof Type)
                                return ((Type) right).tag(Native.wrap(left));
                            else {
                                if (!Native.wrap(left).matchFor(right))
                                    TypeError.throwMismatch(left, right);
                                return left;
                            }
                        }
                    }


                default:
                    throwUnknownForm(expr, exprHead);
            }
        }
    }
    
    
    

    
    final Object evalSingleDelimiter(Seq<Pattern> exprTail,
                                     Object bound,
                                     Env<Symbol, Symbol> context,
                                     Env<Symbol, Object> frame,
                                     Env<Symbol, Fixity> fixities) 
    throws LinkageError {
        Function f = (Function) Seqs.second((Product) bound);
        Object    v = eval(exprTail.head(), context, frame, fixities);
        if (context.lookup(SIDE) == LEFT && f instanceof InvertibleFunction) {
            return new SingletonExprContinuation(f, v);
        } else {
            return f.apply(v);
        }
    }

    
    static final Object evalNullaryDelimiter(Symbol delim,
                                             Env<Symbol, Symbol> context,
                                             Env<Symbol, Object> frame) {
        if (shouldLookup(context)) {
            return delim;
        } else {
            Object obj = frame.lookup(delim);
            if (obj instanceof Product) {
                return Seqs.first((Product) obj);
            } else {
                return obj;
            }
        }
    }

    
    static final Object maybeLookup(Symbol expr,
                                    Env<Symbol, Symbol> context,
                                    Env<Symbol, Object> frame) {
        if (shouldLookup(context)) {
            return expr;
        } else {
            return frame.lookup(expr);
        }
    }

    
    static final Object maybeLookupEval(Pattern exprHead,
                                    Env<Symbol, Symbol> context,
                                    Env<Symbol, Object> frame) {
        if (shouldLookup(context)) {
            return evalSymbol(exprHead);
        } else {
            return frame.lookup(evalSymbol(exprHead));
        }
    }

    
    static final Object maybeLookupEvalOp(Pattern exprHead,
                                     Env<Symbol, Symbol> context,
                                     Env<Symbol, Object> frame) {
        if (shouldLookup(context)) {
            return evalOperator(exprHead, context.lookup(DELIMITER) );
        } else {
            return frame.lookup(evalOperator(exprHead, context.lookup(DELIMITER)));
        }
    }

    static final boolean shouldLookup(Env<Symbol, Symbol> context) {
        return context.lookup(SIDE) == LEFT || context.lookup(QUOTED) == TRUE;
    }




    static final BigInteger evalNat(Pattern expr) {
        return new BigInteger(expr.toString());
    }

    static final Float evalFloat(Pattern expr) {
        return Float.valueOf(expr.toString());
    }

    static final Object evalComplex(Pattern expr) {
        return throwComplex();
    }

    static final Symbol evalOperator(Pattern expr, Symbol delimiter) {
        if (delimiter == PAR) return Symbol.intern("(" + expr + ")");
        if (delimiter == BRA) return Symbol.intern("[" + expr + "]");
        if (delimiter == ANG) return Symbol.intern("{" + expr + "}");
        
        // There should not be any other delimiters
        throw new AssertionError();
    }

    static final Symbol evalSymbol(Pattern expr) {
        return Symbol.intern(expr.toString());
    }

    static final String evalString(Pattern expr) {
        String str = Utils.unescape(expr.toString());
        return str.substring(1, str.length() - 1);
    }






    // Predicates

    static final boolean isSelfEvaluating(Object expr)
    {
        return !(expr instanceof Pattern)
            || (expr instanceof Atom && !(expr instanceof VitryToken));
    }

    static final boolean isAcceptedToken(Object expr)
    {
        return expr instanceof VitryToken;
    }

    /**
     * Whether the given pattern is headed by an Ops token.
     * Note that this is not the same predicate as the one used in the rewriting class.
     */
    static final boolean isOps(Object o)
    {
        if (o instanceof Seq)
        {
            Seq<?> s = (Seq<?>) o;
            return (length(s) >= 2
                && isOpsToken(first(s)));
        }
        return false;
    }

    static final boolean isOpsToken(Object o)
    {
        if (o instanceof Pattern)
        {
            return VitryTokenTypes.tokenType((Pattern) o) == VitryParser.Ops;
        }
        return false;
    }



    // Errors

    static final <T> T throwAssignment(Object id)
    {
        throw new ParseError("Can not assign to non-symbol " + id);
    }

    static final <T> T throwNotSupported()
    {
        throw new ParseError("Does not support this feature yet");
    }

    static final <T> T throwComplex()
    {
        throw new ParseError("Does not support complex numbers yet");
    }

    static final void throwUnknownForm(Object expr, Pattern exprHead)
    {
        throw new ParseError("Unkown form '" + exprHead + "' in tree "
            + Utils.limit(expr.toString(), TRACE_LIMIT));
    }
}




/**
 * Represents an unfinished left-side computation. Callers passing
 * left-expressions should check the returned value against this interface and
 * react if it is received.
 */
interface LeftContinuation
{
    /**
     * Invoke this continuation, passing a right-side value for further
     * processing.
     */
    public void invoke(Object value, Env<Symbol, Object> frame);
}


/**
 * Implements expressions such as (a), [a], and {a}.
 */
class SingletonExprContinuation implements LeftContinuation
{
    private final Function constructor;
    private final Object content;

    public SingletonExprContinuation(Function constructor,
                                     Object content) {
        this.constructor = constructor;
        this.content = content;
    }

    public void invoke(Object val, Env<Symbol, Object> frame)
    {
        Object contentVal = ((InvertibleFunction) constructor).applyVarInverse(val).head();
        if (content instanceof LeftContinuation)
        {
            ((LeftContinuation) content).invoke(contentVal, frame);
        }
        else
        {
            try {
                frame.define((Symbol) content, contentVal);
            } catch (ClassCastException e) {
                Interpreter.throwAssignment(content);
            }
        }
    }
}



final class InterpretedFunction extends RestFunction implements Arity
{
    /**
     * Param and body expressions
     */
    final Seq<?> params;
    final Pattern body;
    final int arity;
    final Env<Symbol, Fixity> fixities;

    /*
     * Creating interpreter
     */
    final Interpreter interpr;

    public InterpretedFunction(Seq<?> params,
                                Pattern body,
                                Env<Symbol, Object> env,
                                Env<Symbol, Fixity> fixities,
                                Interpreter interpreter)
    {
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


    public Object applyVar(Seq<?> args, int length)
    {
        Env<Symbol, Symbol> context = Interpreter.STANDARD_CONTEXT;
        Env<Symbol, Object> callFrame = this.env;
        Env<Symbol, Object> frame = this.env.extend();

        SeqIterator<?> param = this.params.sequenceIterator();
        Iterator<?> arg = args.iterator();

        while (param.hasNext() && arg.hasNext())
        {
            Object name = interpr.eval(param.next(), context, frame, fixities);
            Object value = interpr.eval(arg.next(), context, callFrame, fixities);
            try {
                frame.define((Symbol) name, value);
            } catch (ClassCastException e) {
                Interpreter.throwAssignment(name);
            }
        }

        if (length(args) < arity)
        {
            return new InterpretedFunction(param.following(), body, frame, fixities, interpr);
        }
        else
        {
            return interpr.eval(body, context, frame, fixities);
        }
    }


    // Overridden to get a faster length

    public Object applyVar(Seq<?> args)
    {
        return applyVar(args, length(args));
    }

    public Object applyVar(Object[] args)
    {
        return applyVar(new ArraySeq<Object>(args), args.length);
    }
}


final class InterpretedModule extends Module
{
    public InterpretedModule(Env<Symbol, Object> env)
    {
        super(env); // TODO
    }
}
