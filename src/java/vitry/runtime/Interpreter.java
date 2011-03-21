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
import static vitry.runtime.Context.*;
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

    /*
     * Main branches
     *
     * These correspond directly to token types.
     */
    private static final int NAT_EXPR     = VitryParser.Natural;
    private static final int FLOAT_EXPR   = VitryParser.Float;
    private static final int COMPLEX_EXPR = VitryParser.Complex;
    private static final int STR_EXPR     = VitryParser.String;
    private static final int OP_EXPR      = VitryParser.Op;
    private static final int SYMBOL_EXPR  = VitryParser.Symbol;
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

    private static final int MODULE_DECL  = VitryParser.Module;
    private static final int IMPORT_DECL   = VitryParser.Import;
    private static final int EXPORT_DECL   = VitryParser.Export;
    private static final int IMPLICIT_DECL = VitryParser.Implicit;
    private static final int FIXITY_DECL   = VitryParser.Fixity;
    private static final int TYPE_DECL     = VitryParser.TypeDecl;

    
    /*
     * Sub-branches
     *
     * Interpreter constructs used as simple subroutines. 
     * Must be negative to avoid collisions.
     */
    private static final int UPDATE_EXPR    = -1;
    private static final int DELIMITER_EXPR = -2;
    private static final int FRAME_EXPR     = -3;
    
    /*
     * Reserved in case we want to jump into the default branch
     * (which raises an unknown expression error).
     */
    private static final int UNKNOWN        = Integer.MIN_VALUE;


    
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

    /**
     * Get the context used for generated functions and modules. 
     */
    public Context getStandardContext()
    {
        return standardContext;
    }

    /**
     * Set the context used for generated functions and modules. 
     */
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


    public final Object eval(Object expr, Context context, Env<Symbol, Object> frame, Module module) 
    throws ParseError, LinkageError, TypeError
    {   
        Object       exOp   = null;
        Seq<Pattern> exTail = null;
        int          branch = 0;                          
           
        main : while (true)
        {   
 
            
            if (branch >= 0)
            {
                try 
                {
                    if (isSelfEvaluating(expr))
                    {                        
                        if (expr instanceof Symbol) return lookup((Symbol) expr, context, frame);
                        else return expr;
                    }
                    else
                    {
                        if (isAcceptedToken(expr))
                        {
                            exOp = expr;
                            exTail = null;
                        }
                        else
                        {
                            exOp = head((Seq<Pattern>) expr);
                            exTail = tail((Seq<Pattern>) expr);
                        }
                        branch = Parsing.getTokenType(exOp);
                    }
                } 
                catch (Exception e) 
                {
                    throwUnknownForm(expr);
                }
            }
                
            
            switch (branch) {

                case NAT_EXPR:      return evalNat(exOp);
                case FLOAT_EXPR:    return evalDouble(exOp);
                case COMPLEX_EXPR:  return evalComplex(exOp);
                case STR_EXPR:      return evalString(exOp);

                case OP_EXPR:       return lookupOp(exOp, context, frame);
                case SYMBOL_EXPR:   return lookupExpr(exOp, context, frame);

                case FN_EXPR:       return new InterpretedFunction(init(exTail), last(exTail), frame, module, this);

                case LEFT_EXPR:
                    context = context.extend(SIDE, LEFT);
                    branch = UPDATE_EXPR;
                    continue;

                case QUOTE_EXPR:
                    context = context.extend(QUOTED, TRUE);
                    branch = UPDATE_EXPR;
                    continue;

                case UPDATE_EXPR:
                    branch = 0;
                    expr = exTail.head();
                    continue;
                
                case PAR_EXPR:
                    context = context.extend(DELIMITER, PAR).define(QUOTED, FALSE);
                    branch = DELIMITER_EXPR;
                    continue;

                case BRA_EXPR:
                    context = context.extend(DELIMITER, BRA).define(QUOTED, FALSE);
                    branch = DELIMITER_EXPR;
                    continue;

                case ANG_EXPR:
                    context = context.extend(DELIMITER, ANG).define(QUOTED, FALSE);
                    branch = DELIMITER_EXPR;
                    continue;
                    
                case LET_EXPR:
                    context = context.extend(MUTABLE, FALSE).define(DELIMITER, PAR)
                                     .define(QUOTED, FALSE).define(SIDE, RIGHT);
                    branch = FRAME_EXPR;
                    continue;

                case DO_EXPR:
                    context = context.extend(MUTABLE, TRUE).define(DELIMITER, PAR)
                                     .define(QUOTED, FALSE).define(SIDE, RIGHT);
                    branch = FRAME_EXPR;
                    continue;
                    
                case OPS_EXPR:
                    // FIXME only prelude fixities
//                    expr = Rewriting.ops(module.getFixities(), context).rewrite(exTail);
                    expr = Rewriting.ops(getRuntime().getPrelude().getFixities(), context).rewrite(exTail);
                    continue;
                    
                case IF_EXPR:
                    if (!(eval(first(exTail), context, frame, module).equals(FALSE)))
                        expr = second(exTail);
                    else
                        expr = third(exTail);
                    continue;
                
                case DELIMITER_EXPR:
                {
                    branch = 0;
                    Symbol delim = context.getDelimiter();
                    
                    if (isNil(exTail))
                    {                        
                        return evalNullary(delim, context, frame);
                    }
                    else 
                    {
                        Object bound = frame.lookup(delim);

                        if (!isOperatorExpr(exTail.head()) && bound instanceof Product) {                        
                            return evalUnary((Function) second((Product) bound), exTail.head(), context, frame, module);
                        }
                        expr = exTail.head();
                        continue;                        
                    }
                }
                
                case FRAME_EXPR:
                {
                    branch = 0;
                    Seq<?> assignments = init(exTail);

                    expr = last(exTail);                    
                    frame = frame.extend();

                    if (!Seqs.isNil(assignments))
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
                        try 
                        {
                            if (!left.equals(VitryRuntime.WILDCARD)) {                                
                                if (context.isMutable()) 
                                    frame.assoc((Symbol) left, right);
                                else 
                                    frame.define((Symbol) left, right);
                            }
                        } 
                        catch (ClassCastException e)
                        {
                            throwAssignment(left);
                        }
                    }
                    return right;
                }


                case APPLY_EXPR:
                {
                    Function fn = (Function) eval(exTail.head(), context.extend(SIDE, RIGHT), frame, module);
                    Seq<?>   args = exTail.tail();

                    if (fn.isInvertible() && context.isLeftSide())
                        return new ApplyCont((InvertibleFunction) fn, args, context, frame, module, this);
                    else
                    {
                        if (fn.isCompiled())
                            return ((Function) fn).applyVar(evalAll(args, context, frame, module));
                        else
                        {
                            InterpretedFunction ifn = (InterpretedFunction) fn;
                            Env<Symbol, Object> callFrame = frame;

                            context = this.standardContext;
                            frame   = ifn.environment.extend();
                            
                            SeqIterator<?> par = ifn.parameters.seqIterator();
                            SeqIterator<?> arg = args.seqIterator();
                            
                            while (par.hasNext() && arg.hasNext())
                            {
                                Object name = eval(par.next(), context, frame, ifn.module);
                                Object value = eval(arg.next(), context, callFrame, module);
                                
                                if (name instanceof LeftCont) {
                                    ((LeftCont) name).invoke(value, frame);
                                }
                                else
                                {
                                    try
                                    {
                                        if (!name.equals(VitryRuntime.WILDCARD))
                                            frame.define((Symbol) name, value);
                                    }
                                    catch (ClassCastException e)
                                    {
                                        throwAssignment(name);
                                    }
                                }
                            }
                            
                            if (par.hasNext())
                            {
                                return new InterpretedFunction(par.following(), ifn.body, frame, ifn.module, ifn.interpreter);
                            }
                            if (!arg.hasNext())
                            {
                                expr = ifn.body;
                                continue;
                            }
                            else
                            {
                                Function res = (Function) eval(ifn.body, context, frame, module);
                                return res.applyVar(evalAll(arg.following(), context, callFrame, module));
                            }

                        }
                    }
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
                                ((LeftCont) left).invoke(value, frame, true);
                            }
                            else
                            {
                                // TODO allow other symbols pointing to types to evade matching
                                // This must be implemented in AbstractLeftCont as well!
                                if (shouldBind(left))
                                {
                                    try 
                                    {
                                        if (!left.equals(VitryRuntime.WILDCARD))
                                            frame.define((Symbol) left, value);
                                    } 
                                    catch (ClassCastException e)
                                    {
                                        throwAssignment(left);
                                    }
                                }
                                else
                                {
                                    match(value, left);
                                }
                            }
                        } 
                        catch (TypeError e)
                        {
                            continue match;
                        }
                        continue main;

                    }
                    throw new MatchingError(value);
                }


                case TYPE_EXPR:
                {
                    // TODO native types

                    Object left = eval(first(exTail), context, frame, module);
                    Object right = eval(second(exTail), context.extend(SIDE, RIGHT), frame, module);

                    if (context.isLeftSide())
                    {
                        return new TypeCont(left, right);
                    }
                    else
                    {
                        if (right instanceof Type)
                            return ((Type) right).tag(Native.wrap(left));
                        else
                        {
                            match(left, right);
                            return left;
                        }
                    }
                }
                
                case MODULE_DECL:
                {
                    Seq<Symbol> name = (Seq<Symbol>) evalAllQuoted(exTail.head(), context, frame, module);
                    Seq<?>      declarations = exTail.tail();
                    return new InterpretedModule(name, declarations, this);
                }
                
                
                case IMPORT_DECL:
                {
                    // TODO 'as' syntax
                    Seq<Symbol> name = (Seq<Symbol>) evalAllQuoted(exTail.head(), context, frame, module);
                    
                    module.importModule(moduleProvider.forName(name));
                    return module;
                }
                    
                case EXPORT_DECL:   throwNotSupported();
                case IMPLICIT_DECL: throwNotSupported();
                case FIXITY_DECL:   throwNotSupported();
                case TYPE_DECL:     throwNotSupported();

                
                
                case UNKNOWN: default:            
                    throwUnknownForm(expr, exOp);
            }
        }
    }

    static void match(Object a, Object b) throws TypeError
    {
        Pattern bp;
        boolean m;

        if (b instanceof Pattern)
            bp = (Pattern) b;
        else
            bp = Native.wrap(b);

        if (a instanceof Pattern)
            m = ((Pattern) a).matchFor(bp);
        else
            m = bp.match(a);

        if (!m) TypeError.throwMismatch(a, b);
    }
    
                    
    
    static final boolean shouldBind(Object left)
    {
//        if (left.equals(Context.PAR)) return false;
//        if (left.equals(Context.BRA)) return false;
//        if (left.equals(Context.ANG)) return false;
        return (left instanceof Symbol);
    }

    static BigInteger evalNat(Object expr)
    {
//        return new BigInteger(expr.toString());
        return VitryRuntime.intFrom(expr.toString());
    }

    static Double evalDouble(Object expr)
    {
        return Double.valueOf(expr.toString());
    }

    static Object evalComplex(Object expr)
    {
        return throwComplex();
    }

    static Symbol evalOperator(Object expr, Symbol delimiter)
    {
        if (delimiter == PAR) return Symbol.intern("(" + expr + ")");
        if (delimiter == BRA) return Symbol.intern("[" + expr + "]");
        if (delimiter == ANG) return Symbol.intern("{" + expr + "}");

        // There should not be any other delimiters
        throw new AssertionError();
    }

    static Symbol evalSymbol(Object expr)
    {
        return Symbol.intern(expr.toString());
    }

    static String evalString(Object expr)
    {
        String str = Utils.unescape(expr.toString());
        return str.substring(1, str.length() - 1);
    }
    
    
    
    Object evalNullary(Symbol delim, Context context, Env<Symbol, Object> frame)
    {
        if (context.shouldLookup())
        {
            Object obj = frame.lookup(delim);
            if (obj instanceof Product)
                return first((Product) obj);
            else
                return obj;
        }
        else
            return delim;
    }

    Object evalUnary(Function f, Object expr, Context context, Env<Symbol, Object> frame, Module module) 
    {
        Object v = eval(expr, context, frame, module);
        
        if (context.isLeftSide() && f.isInvertible())
            return new UnaryCont((InvertibleFunction) f, v);
        else
            return f.apply(v);
    }

    
    Seq<?> evalAll(Seq<?> exprs, final Context context, 
                  final Env<Symbol, Object> frame, final Module module) 
    {
        return exprs.map(new StandardFunction.Unary() {
            public Object apply(Object e) throws InvocationError {
                return eval(e, context, frame, module);
            }
        });
    }
    
    Seq<?> evalAllQuoted(Object expr, Context context,
                         Env<Symbol, Object> frame, Module module)
    {
        return evalAll((Seq<?>) expr, context.extend(QUOTED, TRUE), frame, module);
    }

    Object lookupExpr(Object expr, Context context, Env<Symbol, Object> frame)
    {
        return lookup(evalSymbol(expr), context, frame);
    }

    Object lookupOp(Object expr, Context context, Env<Symbol, Object> frame)
    {
        return lookup(evalOperator(expr, context.getDelimiter()), context, frame);
    }
    
    Object lookup(Symbol expr, Context context, Env<Symbol, Object> frame)
    {
        if (context.shouldLookup())
            return frame.lookup(expr);
        else
            return expr;
    }
    
    

    static boolean isSelfEvaluating(Object expr)
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
     *
     * (This is not the same predicate as the one used in the 
     * rewriting class).
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
            return Parsing.getTokenType((Pattern) o) == VitryParser.Ops;
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




final class InterpretedFunction extends RestFunction implements Arity
{

    /*
     * Unevaluated parameters and body. 
     */
    public final Seq<?> parameters;
    public final Object body;

    /**
     * Containing module.
     */
    public final Module module;

    /*
     * Creating interpreter
     */
    final Interpreter interpreter;
    public final int arity;

    public InterpretedFunction(Seq<?> params, Object body, Module module,
            Interpreter interpreter) {
        this(params, body, module.getValues(), module, interpreter);
    }

    public InterpretedFunction(Seq<?> params, Object body, Env<Symbol, Object> env,
            Module module, Interpreter interpreter) {
        super(env);
        this.body = body;
        this.parameters = params;
        this.arity = length(params);
        this.module = module;
        this.interpreter = interpreter;
    }


    public int getArity()
    {
        return arity;
    }

    public boolean isCompiled()
    {
        return false;
    }


    public Object applyVar(Seq<?> args)
    {
        Context context = interpreter.getStandardContext();
        Env<Symbol, Object> frame = this.environment.extend();

        SeqIterator<?> par = this.parameters.seqIterator();
        SeqIterator<?> arg = args.seqIterator();

        while (par.hasNext() && arg.hasNext())
        {
            Object name = interpreter.eval(par.next(), context, frame, this.module);
            Object value = arg.next();

            if (name instanceof LeftCont)
            {
                ((LeftCont) name).invoke(value, frame);
            }
            else
            {
                try
                {
                    if (!name.equals(VitryRuntime.WILDCARD))
                        frame.define((Symbol) name, value);
                } catch (ClassCastException e)
                {
                    Interpreter.throwAssignment(name);
                }
            }
        }

        if (par.hasNext())
        {
            return new InterpretedFunction(par.following(), this.body, frame, this.module, this.interpreter);
        }
        if (!arg.hasNext())
        {
            return this.interpreter.eval(this.body, context, frame, this.module);
        }
        else
        {
            Function res = (Function) this.interpreter.eval(this.body, context, frame, this.module);
            return res.applyVar(arg.following());
        }
    }

}


final class InterpretedModule extends Module
{

    /**
     * Unevaluated declarations.
     */
    private Seq<?> declExprs;
    
    final Interpreter interpreter;


    public InterpretedModule(Seq<Symbol> name, Seq<?> declExprs, Interpreter interpreter) {
        super(name);
        this.declExprs = declExprs;
        this.interpreter = interpreter;

        this.importModule(interpreter.getRuntime().getPrelude());
        this.evalDeclarations();
    }

    public boolean isCompiled()
    {
        return false;
    }

    private void evalDeclarations()
    {
        /*
         * TODO
         * 
         * We have to sort and evaluate in the rough order
         *  - exports
         *  - imports
         *  - types
         *  - implicits
         *  - values
         */
        for (Object expr : declExprs) {
            Object decl = Rewriting.topLevel().rewrite((Seq<Pattern>) expr);
            Object val = interpreter.eval(decl, interpreter.getStandardContext(), values, this);
        }

    }
}


/**
 * Represents an unfinished left-side computation, such as destructuring.
 *
 * Evaluating left-side expression may result in a LeftCont instance, 
 * which is typically handled separately by the evaluator.
 */
interface LeftCont
{

    /**
     * Invoke this continuation, passing a right-side value for further
     * processing.
     */
    public void invoke(Object value, Env<Symbol, Object> frame);

    public void invoke(Object value, Env<Symbol, Object> frame, boolean matching);

}


abstract class AbstractLeftCont implements LeftCont
{

    private boolean matching = false;

    public void invoke(Object value, Env<Symbol, Object> frame, boolean matching)
    {
        this.matching = matching;
        this.invoke(value, frame);
    }

    protected void finish(Object key, Object val, Env<Symbol, Object> frame)
            throws BindingError
    {
        if (key instanceof LeftCont)
        {
            ((LeftCont) key).invoke(val, frame, this.matching);
        }
        else
        {
            if (this.matching && !(Interpreter.shouldBind(key)))
            {
                Interpreter.match(val, key);
            }
            else
            {
                try
                {
                    if (!key.equals(VitryRuntime.WILDCARD))
                        frame.define((Symbol) key, val);

                } catch (ClassCastException e)
                {
                    Interpreter.throwAssignment(key);
                }
            }
        }
    }
}


final class UnaryCont extends AbstractLeftCont
{

    private final InvertibleFunction structor;
    private final Object key;

    public UnaryCont(InvertibleFunction structor, Object key) {
        this.structor = structor;
        this.key = key;
    }

    public void invoke(Object val, Env<Symbol, Object> frame)
    {
        Object v = structor.applyVarInverse(val).head();
        finish(key, v, frame);
    }
}


final class TypeCont extends AbstractLeftCont
{

    private final Object left;
    private final Object right;

    public TypeCont(Object left, Object right) {
        this.left = left;
        this.right = right;
    }

    public void invoke(Object val, Env<Symbol, Object> frame)
    {
        Interpreter.match(val, right);
        finish(left, val, frame);
    }
}


final class ApplyCont extends AbstractLeftCont
{

    private final InvertibleFunction fn;
    private final Seq<?> params;
    private final Context context;
    private final Env<Symbol, Object> frame;
    private Module module;
    private final Interpreter interpr;


    public ApplyCont(InvertibleFunction fn, Seq<?> args, Context context,
            Env<Symbol, Object> frame, Module module, Interpreter interpr) {
        this.fn = fn;
        this.params = args;
        this.context = context;
        this.frame = frame;
        this.module = module;
        this.interpr = interpr;
    }

    public void invoke(Object value, Env<Symbol, Object> frame)
    {
        Seq<?> args = fn.applyVarInverse(value);

        Iterator<?> par = params.iterator();
        Iterator<?> arg = args.iterator();

        while (par.hasNext() && arg.hasNext())
        {
            Object key = interpr.eval(par.next(), context, this.frame, module);
            Object val = arg.next();
            finish(key, val, frame);
        }
        if (par.hasNext() || arg.hasNext())
        {
            TypeError.throwWrongCount(value);
        }
    }
}
