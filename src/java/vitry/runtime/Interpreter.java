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
 * @author Hans Hoglund
 */
public class Interpreter implements Eval {

    static final Symbol DELIMITER         = Symbol.intern("delimiter");
    static final Symbol SIDE              = Symbol.intern("side");
    static final Symbol QUOTED            = Symbol.intern("quoted");
    static final Symbol MUTABLE           = Symbol.intern("mutable");
    static final Symbol PAR               = Symbol.intern("()");
    static final Symbol BRA               = Symbol.intern("[]");
    static final Symbol ANG               = Symbol.intern("{}");
    static final Symbol LEFT              = Symbol.intern("left");
    static final Symbol RIGHT             = Symbol.intern("right");
    static final Symbol TRUE              = Symbol.intern("true");
    static final Symbol FALSE             = Symbol.intern("false");

    private static final int NAT_EXPR     = VitryParser.Natural;
    private static final int FLOAT_EXPR   = VitryParser.Float;
    private static final int COMPLEX_EXPR = VitryParser.Complex;
    private static final int STR_EXPR     = VitryParser.String;
    private static final int OP_EXPR      = VitryParser.Op;
    private static final int SYMBOL_EXPR  = VitryParser.Symbol;
    private static final int MODULE_EXPR  = VitryParser.Module;
    private static final int FN_EXPR      = VitryParser.Fn;
    private static final int LEFT_EXPR    = VitryParser.Left;
    private static final int QUOTE_EXPR   = VitryParser.Quote;
    private static final int PAR_EXPR     = VitryParser.Par;
    private static final int BRA_EXPR     = VitryParser.Bra;
    private static final int ANG_EXPR     = VitryParser.Ang;
    private static final int LET_EXPR     = VitryParser.Let;
    private static final int DO_EXPR      = VitryParser.Do;
    private static final int ASSIGN_EXPR  = VitryParser.Assign;
    private static final int IF_EXPR      = VitryParser.If;
    private static final int MATCH_EXPR   = VitryParser.Match;
    private static final int APPLY_EXPR   = VitryParser.Apply;
    private static final int OPS_EXPR     = VitryParser.Ops;
    private static final int TYPE_EXPR    = VitryParser.Type;

    private static final int UPDATE_EXPR    = -3;
    private static final int DELIMITER_EXPR = -4;
    private static final int FRAME_EXPR     = -5;


    private final VitryRuntime runtime;

    private ModuleProvider moduleProvider;

    private Context standardContext;


    public Interpreter(VitryRuntime runtime) {
        this(runtime, null);
    }

    public Interpreter(VitryRuntime runtime, ModuleProvider moduleProvider) {
        this.runtime = runtime;
        this.moduleProvider = moduleProvider;
        this.standardContext = (new Context()
            .define(DELIMITER, PAR)
            .define(SIDE, RIGHT)
            .define(QUOTED, FALSE)
            .define(MUTABLE, FALSE));
    }
    
    public Interpreter(VitryRuntime runtime, ModuleProvider moduleProvider, Context standardContext) {
        this.runtime = runtime;
        this.moduleProvider = moduleProvider;
        this.standardContext = standardContext;
    }


    public boolean acceptsParserTokens()
    {
        return true;
    }

    public boolean acceptsUserTokens()
    {
        return true;
    }

    /**
     * Returns the runtime system owning this interpreter.
     */
    public VitryRuntime getRuntime()
    {
        return runtime;
    }

    /**
     * Returns the source from which this interpreter imports dependencies for
     * created modules (may be null)
     */
    public ModuleProvider getModuleProvider()
    {
        return moduleProvider;
    }

    /**
     * Set the source from which to imports dependencies for.
     */
    public void setModuleProvider(ModuleProvider moduleProvider)
    {
        this.moduleProvider = moduleProvider;
    }

    public Context getStandardContext()
    {
        return standardContext;
    }

    public void setStandardContext(Context standardContext)
    {
        this.standardContext = standardContext;
    }



    
    public Object eval(Object expr) 
    throws ParseError, TypeError, ResolveError
    {
        return eval(expr, runtime.getPrelude());
    }

    public final Object eval(Object expr, Module module)
    throws ParseError, LinkageError, TypeError 
    {
        return eval(expr, this.standardContext, module.getValues(), module);
    }

    public final Object eval
        (
        Object expr, 
        Context context,
        Env<Symbol, Object> frame, 
        Module module
        ) 
    throws ParseError, LinkageError, TypeError
    {
        Object       exOp   = null;
        Seq<Pattern> exTail = null;
        int          jmp    = 0;                          

        main : while (true)
        {
            if (jmp >= 0)
            {
                if (isSelfEvaluating(expr))
                {
                    if (expr instanceof Symbol) 
                        return maybeLookup((Symbol) expr, context, frame);
                    else return expr;
                }
                try {
                    if (isAcceptedToken(expr))
                    {
                        exOp = (Pattern) expr;
                        exTail = null;
                    }
                    else
                    {
                        exOp = head((Seq<Pattern>) expr);
                        exTail = tail((Seq<Pattern>) expr);
                    }
                    jmp = VitryTokenTypes.tokenType(exOp);
    
                } catch (Exception e) {
                    throwUnknownForm(expr);
                }
            }
                
            /*
             * Each case must either
             *    - update expr or jmp, then continue
             *    - return
             *    - throw exception
             * 
             * Jump cases must reset jmp to 0, to allow other
             * expressions to dispatch on expr type again
             */
            switch (jmp) {
                
                case NAT_EXPR:      return evalNat(exOp);
                case FLOAT_EXPR:    return evalFloat(exOp);
                case COMPLEX_EXPR:  return evalComplex(exOp);
                case STR_EXPR:      return evalString(exOp);

                case OP_EXPR:       return maybeLookupEvalOp(exOp, context, frame);
                case SYMBOL_EXPR:   return maybeLookupEval(exOp, context, frame);

                case MODULE_EXPR:   throwNotSupported();
                case FN_EXPR:       return new InterpretedFunction(init(exTail), last(exTail), frame, module, this);

                
                case LEFT_EXPR:
                    context = context.extend(SIDE, LEFT);
                    jmp = UPDATE_EXPR;
                    continue;

                case QUOTE_EXPR:
                    context = context.extend(QUOTED, TRUE);
                    jmp = UPDATE_EXPR;
                    continue;

                case UPDATE_EXPR:
                    jmp = 0;
                    expr = exTail.head();
                    continue;
                    
                
                /*
                 * Brackets
                 *
                 * The empty case is a symbol, while non-empty cases are context switches
                 * This single case may also act as a unary constructor, see
                 *     https://github.com/hanshoglund/Vitry/issues/12
                 */  
                case PAR_EXPR: 
                    context = context.extend(DELIMITER, PAR).define(QUOTED, FALSE);
                    jmp = DELIMITER_EXPR;
                    continue;

                case BRA_EXPR:
                    context = context.extend(DELIMITER, BRA).define(QUOTED, FALSE);
                    jmp = DELIMITER_EXPR;
                    continue;

                case ANG_EXPR:
                    context = context.extend(DELIMITER, ANG).define(QUOTED, FALSE);
                    jmp = DELIMITER_EXPR;
                    continue;
                
                case DELIMITER_EXPR:
                {
                    jmp = 0;
                    Symbol delim = context.lookup(DELIMITER);
                    
                    if (isNil(exTail))
                    {                        
                        return evalNullary(delim, context, frame);
                    }
                    Object bound = frame.lookup(delim);
                    
                    if (!isOperatorExpr(exTail.head()) && bound instanceof Product) {                        
                        return evalSingle(second((Product) bound), exTail.head(), context, frame, module);
                    }
                    expr = exTail.head();
                    continue;
                }

                
                /*
                 * Let and do
                 *
                 * These forms push a new frame before evaluating their assignments,
                 * then tail-call so that the updated frame is discarded upon return
                 */          
                case LET_EXPR:
                {
                    context = context.extend(MUTABLE, FALSE).define(DELIMITER, PAR)
                             .define(QUOTED, FALSE).define(SIDE, RIGHT);
                    jmp = FRAME_EXPR;
                    continue;
                }

                case DO_EXPR:
                {
                    context = context.extend(MUTABLE, TRUE).define(DELIMITER, PAR)
                             .define(QUOTED, FALSE).define(SIDE, RIGHT);
                    jmp = FRAME_EXPR;
                    continue;
                }
                
                case FRAME_EXPR:
                {
                    jmp = 0;
                    Seq<?> assignments = init(exTail);

                    /* 
                     * Actually, this may be an assignment as well
                     * This makes no difference, as the frame is discarded 
                     * after expr is evalutated anyway
                     */
                    expr = last(exTail);                    
                    frame = frame.extend();

                    if (assignments != null)
                    {
                        for (Object a : assignments)
                            eval(a, context, frame, module);
                    }
                    continue;
                }

                case ASSIGN_EXPR:
                {
                    Object left = eval(first(exTail), context, frame, module);
                    Object right = eval(second(exTail), context, frame, module);

                    if (left instanceof LeftCont)
                    {
                        ((LeftCont) left).invoke(right, frame);
                    }
                    else
                    {
                        try {
                            if (context.lookup(MUTABLE) == TRUE) {                                
                                frame.assoc((Symbol) left, right);
                            }
                            else 
                            {                                
                                frame.define((Symbol) left, right);
                            }
                        } catch (ClassCastException e) {
                            throwAssignment(left);
                        }
                    }
                    return right;
                }


                case APPLY_EXPR:
                    Object f    = eval(exTail.head(), context.extend(SIDE, RIGHT), frame, module);
                    Seq<?> args = exTail.tail();

                    if ((f instanceof InvertibleFunction) && (context.lookup(SIDE) == LEFT))
                    // Left-application
                    {
                        return new ApplyCont((InvertibleFunction) f, args, this, context, frame, module);
                    }
                    else
                    // Right-application
                    {
                        if (f instanceof InterpretedFunction)
                        {
                            InterpretedFunction ff = (InterpretedFunction) f;
                            Env<Symbol, Object> callFrame = frame;
                            context = this.standardContext;
                            frame   = ff.env.extend();
                            
                            SeqIterator<?> param = ff.params.seqIterator();
                            SeqIterator<?> arg   = args.seqIterator();
                            
                            while (param.hasNext() && arg.hasNext())
                            {
                                Object name = eval(param.next(), context, frame, ff.module);
                                Object value = eval(arg.next(), context, callFrame, ff.module);
                                
                                if (name instanceof LeftCont) {
                                    ((LeftCont) name).invoke(value, frame);
                                }
                                else
                                {
                                    try
                                    {
                                        frame.define((Symbol) name, value);
                                    }
                                    catch (ClassCastException e)
                                    {
                                        throwAssignment(name);
                                    }
                                }
                            }
                            
                            if (param.hasNext())
                            {
                                return new InterpretedFunction(param.following(), ff.body,
                                        frame, ff.module, ff.interpreter);
                            }
                            if (!arg.hasNext())
                            {
                                expr = ff.body;
                                continue;
                            }
                            {
                                Function res = (Function) eval(ff.body, context, frame, module);
                                return res.applyVar(arg.following());
                            }

                        }
                        else
                        // Compiled function
                        {
                            java.util.List<Object> vals = new java.util.LinkedList<Object>();
                            for (Object arg : args)
                            {
                                vals.add(eval(arg, context, frame, module));
                            }
                            return ((Function) f).applyVar(vals.toArray());
                        }
                    }

                case OPS_EXPR:
                    Rewriting rw = Rewriting.operators(module.getFixities(), context);
                    expr = rw.rewrite(exTail);
                    continue;

                    
                

                case IF_EXPR:
                {
                    Object cond = eval(first(exTail), context, frame, module);
                    if (!(cond.equals(FALSE)))
                        expr = second(exTail);
                    else
                        expr = third(exTail);
                    continue;
                }

                case MATCH_EXPR:
                {
                    Object value = eval(exTail.head(), context, frame, module);
                    Seq<Pattern> cases = exTail.tail();
                    
                    Env<Symbol, Object> topFrame = frame;

                    match : for (Pattern c : cases)
                    {
                        Seq<Pattern> caseTail = ((Seq<Pattern>) c).tail();

                        Object left = eval(first(caseTail), context, frame, module);
                        expr = second(caseTail);
                        frame = topFrame.extend();

                        try {
                            if (left instanceof LeftCont)
                            {
                                ((LeftCont) left).invoke(value, frame);
                            }
                            else
                            {
                                if (left instanceof Symbol)
                                {
                                    frame.define((Symbol) left, value);
                                }
                                else
                                {
                                    if (value instanceof Pattern)
                                    {
                                        if (! ((Pattern) value).matchFor(Native.wrap(left)))
                                            TypeError.throwMismatch(value, left); // TODO throw something lighter...
                                    }
                                    else
                                    {
                                        if (!Native.wrap(value).matchFor(Native.wrap(left)))
                                            TypeError.throwMismatch(value, left);
                                    }
                                }
                            }
                        } 
                        catch (TypeError e)
                        {
                            continue match;
                        } 
                        catch (ClassCastException e)
                        {
                            throwAssignment(left);
                        }
                        // Case matched, continue with current frame and expr
                        continue main;

                    }
                    // Nothing matched
                    throw new MatchingError(value);
                }


                case TYPE_EXPR:
                {
                    // TODO native types

                    Object left = eval(first(exTail), context, frame, module);
                    Pattern right = Native.wrap(eval(second(exTail), context.extend(SIDE, RIGHT), frame, module));

                    if (context.lookup(SIDE) == LEFT)
                    {
                        return new TypeCont(left, right);
                    }
                    else
                    {
                        if (right instanceof Type)
                            return ((Type) right).tag(Native.wrap(left));
                        else
                        {
                            if (!Native.wrap(left).matchFor(right))
                                TypeError.throwMismatch(left, right);
                            return left;
                        }
                    }
                }
                
                default: throwUnknownForm(expr, exOp);
                
            }
        }
    }
    
    
    private Object evalSingle(Object f, Object expr, Context context, Env<Symbol, 
                              Object> frame, Module module) 
    {
        Object v = eval(expr, context, frame, module);
        if (context.lookup(SIDE) == LEFT && f instanceof InvertibleFunction)
            return new SingleCont((InvertibleFunction) f, v);
        else
            return ((Function) f).apply(v);
    }
    
    private Object evalNullary(Symbol delim, Context context, Env<Symbol, Object> frame)
    {
        if (!shouldLookup(context))
            return delim;
        else
        {
            Object obj = frame.lookup(delim);
            if (obj instanceof Product)
                return first((Product) obj);
            else
                return obj;
        }
    }
    
    private Object maybeLookupEval(Object expr, Context context, Env<Symbol, Object> frame)
    {
        return maybeLookup(evalSymbol(expr), context, frame);
    }
    
    private Object maybeLookupEvalOp(Object expr, Context context, Env<Symbol, Object> frame)
    {
        return maybeLookup(evalOperator(expr, context.lookup(DELIMITER)), context, frame);
    }
    
    private Object maybeLookup(Symbol expr, Context context, Env<Symbol, Object> frame)
    {
        if (!shouldLookup(context))
            return expr;
        else
            return frame.lookup(expr);
    }
    
    private boolean shouldLookup(Context context)
    {
        return context.lookup(SIDE) != LEFT && context.lookup(QUOTED) != TRUE;
    }


    
    static final BigInteger evalNat(Object expr)
    {
        return new BigInteger(expr.toString());
    }

    static final Float evalFloat(Object expr)
    {
        return Float.valueOf(expr.toString());
    }

    static final Object evalComplex(Object expr)
    {
        return throwComplex();
    }

    static final Symbol evalOperator(Object expr, Symbol delimiter)
    {
        if (delimiter == PAR) return Symbol.intern("(" + expr + ")");
        if (delimiter == BRA) return Symbol.intern("[" + expr + "]");
        if (delimiter == ANG) return Symbol.intern("{" + expr + "}");

        // There should not be any other delimiters
        throw new AssertionError();
    }

    static final Symbol evalSymbol(Object expr)
    {
        return Symbol.intern(expr.toString());
    }

    static final String evalString(Object expr)
    {
        String str = Utils.unescape(expr.toString());
        return str.substring(1, str.length() - 1);
    }

    static final boolean isSelfEvaluating(Object expr)
    {
        return ! (expr instanceof Pattern)
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
    static final boolean isOperatorExpr(Object o)
    {
        if (o instanceof Seq)
        {
            Seq<?> s = (Seq<?>) o;
            return (length(s) >= 2 && isOpsToken(first(s)));
        }
        return false;
    }

    private static boolean isOpsToken(Object o)
    {
        if (o instanceof Pattern)
        {
            return VitryTokenTypes.tokenType((Pattern) o) == VitryParser.Ops;
        }
        return false;
    }
    
    

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

    static final void throwUnknownForm(Object tree)
    {
        throw new ParseError("Unknown form in tree "
                + Utils.limit(tree.toString(), TRACE_LIMIT));
    }

    static final void throwUnknownForm(Object tree, Object form)
    {
        throw new ParseError("Unkown form '" + form + "' in tree "
                + Utils.limit(tree.toString(), TRACE_LIMIT));
    }
}



//class LightTypeError extends TypeError {
//    private static final long serialVersionUID = -1007523215169937962L;
//
//    public synchronized Throwable fillInStackTrace() {
//        return this;
//    }
//}


/**
 * Represents an unfinished left-side computation. Callers passing
 * left-expressions should check the returned value against this interface and
 * react if it is received.
 */
interface LeftCont {
    
    /**
     * Invoke this continuation, passing a right-side value for further
     * processing.
     */
    public void invoke(Object value, Env<Symbol, Object> frame);
}


final class SingleCont implements LeftCont {

    private final InvertibleFunction constructor;
    private final Object content;

    public SingleCont(InvertibleFunction constructor, Object content) {
        this.constructor = constructor;
        this.content = content;
    }

    public void invoke(Object val, Env<Symbol, Object> frame)
    {
        Object contentVal = constructor.applyVarInverse(val).head();

        if (content instanceof LeftCont)
        {
            ((LeftCont) content).invoke(contentVal, frame);
        } 
        else
        {
            try
            {
                frame.define((Symbol) content, contentVal);
            } catch (ClassCastException e)
            {
                Interpreter.throwAssignment(content);
            }
        }
    }
}


final class TypeCont implements LeftCont {

    private final Object left;
    private final Pattern right;

    public TypeCont(Object left, Pattern right) {
        this.left = left;
        this.right = right;
    }

    public void invoke(Object value, Env<Symbol, Object> frame)
    {

        // Check type
        if (!Native.wrap(value).matchFor(right))
            TypeError.throwMismatch(value, right);

        if (left instanceof LeftCont)
        {
            // Left may be a destructuring or other type check
            // It should do its work after we have verified the type of value
            ((LeftCont) left).invoke(value, frame);
        } 
        else
        {
            // Finish pending assignment
            try
            {
                frame.define((Symbol) left, value);
            } catch (ClassCastException e)
            {
                Interpreter.throwAssignment(left);
            }
        }
    }
}


final class ApplyCont implements LeftCont {
    
    private final InvertibleFunction fn;
    private final Seq<?> args;
    private final Interpreter interpr;
    private final Context context;
    private final Env<Symbol, Object> frame;
    private Module module;


    public ApplyCont(InvertibleFunction fn, Seq<?> args, Interpreter interpr,
            Context context, Env<Symbol, Object> frame,
            Module module) {
        this.fn = fn;
        this.args = args;
        this.interpr = interpr;
        this.context = context;
        this.frame = frame;
        this.module = module;
    }

    public void invoke(Object value, Env<Symbol, Object> frame)
    {
        if (fn instanceof InvertibleFunction)
        {
            InvertibleFunction ifn = (InvertibleFunction) fn;

            Seq<?> vals = ifn.applyVarInverse(value);

            Iterator<?> keyExprIt;
            Iterator<?> valIt;

            for (keyExprIt = args.iterator(), valIt = vals.iterator(); keyExprIt.hasNext()
                    && valIt.hasNext();)
            {
                Object key = interpr.eval(keyExprIt.next(), context, this.frame, module);
                Object val = valIt.next();

                if (key instanceof LeftCont)
                {
                    ((LeftCont) key).invoke(val, frame);
                }
                else
                {
                    try
                    {
                        frame.define((Symbol) key, val);
                    } catch (ClassCastException e)
                    {
                        Interpreter.throwAssignment(key);
                    }
                }
            }

        }
        else
        {
            assert false;
        }
    }
}



final class InterpretedFunction extends RestFunction implements Arity {
    
    /**
     * Param and body expressions
     */
    final Seq<?> params;
    final Pattern body;
    final int arity;
    Module module;

    /*
     * Creating interpreter
     */
    final Interpreter interpreter;

    public InterpretedFunction(Seq<?> params, Pattern body, Env<Symbol, Object> env,
            Module module, Interpreter interpreter) {
        super(env);
        this.body = body;
        this.params = params;
        this.arity = length(params);
        this.module = module;
        this.interpreter = interpreter;
    }


    public int getArity()
    {
        return arity;
    }

    public Object applyVar(Seq<?> args, int length)
    {
        Context context = interpreter.getStandardContext();
        Env<Symbol, Object> callFrame = this.env;
        Env<Symbol, Object> frame = this.env.extend();

        SeqIterator<?> param = this.params.seqIterator();
        Iterator<?> arg = args.iterator();

        while (param.hasNext() && arg.hasNext())
        {
            Object name = interpreter.eval(param.next(), context, frame, module);
            Object value = interpreter.eval(arg.next(), context, callFrame, module);
            try
            {
                frame.define((Symbol) name, value);
            } 
            catch (ClassCastException e)
            {
                Interpreter.throwAssignment(name);
            }
        }

        if (length(args) < arity)
            return new InterpretedFunction(param.following(), body, frame, module, interpreter);
        else
            return interpreter.eval(body, context, frame, module);
    }

    /**
     * Overridden to get a faster length
     */
    public Object applyVar(Seq<?> args)
    {
        return applyVar(args, length(args));
    }

    public Object applyVar(Object[] args)
    {
        return applyVar(new ArraySeq<Object>(args), args.length);
    }
}


final class InterpretedModule extends Module {

    public InterpretedModule(Seq<Symbol> name) {
        super(name);
    }
    
}
