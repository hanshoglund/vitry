package vitry.primitive;

/**
 * Invariants:
 *   Whenever a function f is called with N arguments:
 *       if not f instanceof RestArgFunction
 *           if  N   < f.arity,  then a partial application is returned
 *           if  N   = f.arity,  then f(a1,a2..a[N]) is returned
 *           if  N+1 = f.arity,  then f(a1,a2..a[N-1]) f[N] is returned
 *           if  N+2 = f.arity,  then f(a1,a2..a[N-2]) f[N-1] f[N] is returned
 *           etc.
 *       else
 *           if  N < f.arity,  then a partial application is returned
 *           if  N = f.arity,  then f(a1,a2..a[N]) is returned
 *           if  N > f.arity,  then f(a1,a2..a[f.arity], rest) is returned, 
 *              where rest is an array containing a[f.arity]...a[N]
 *           
 * See "Making a Fast Curry: Push/Enter vs Eval/Apply for Higher-order 
 * Languages" by Marlow and Jones
 * 
 * @author hans
 */
public abstract class Function extends Callable {

    public Function(Environment<Symbol, Value> e)
    {
        super(e);
    }

    public abstract int arity();

    public abstract Functor type();
    
    public Value apply(Value a0, Value a1) throws Exception {
        throw new InvocationException("Expected function " + this
                + " to have arity " + arity());
    }

    public Value apply(Value a0, Value a1, Value a2) throws Exception {
        throw new InvocationException("Expected function " + this
                + " to have arity " + arity());
    }

    public Value apply(Value a0, Value a1, Value a2, Value a3) throws Exception {
        throw new InvocationException("Expected function " + this
                + " to have arity " + arity());
    }

    public Value apply(Value a0, Value a1, Value a2, Value a3, Value a4)
            throws Exception {
        throw new InvocationException("Expected function " + this
                + " to have arity " + arity());
    }

    public Value apply(Value a0, Value a1, Value a2, Value a3, Value a4,
            Value a5) throws Exception {
        throw new InvocationException("Expected function " + this
                + " to have arity " + arity());
    }

    public Value apply(Value a0, Value a1, Value a2, Value a3, Value a4,
            Value a5, Value a6) throws Exception {
        throw new InvocationException("Expected function " + this
                + " to have arity " + arity());
    }

    public Value apply(Value a0, Value a1, Value a2, Value a3, Value a4,
            Value a5, Value a6, Value a7) throws Exception {
        throw new InvocationException("Expected function " + this
                + " to have arity " + arity());
    }

    public Value apply(Value a0, Value a1, Value a2, Value a3, Value a4,
            Value a5, Value a6, Value a7, Value a8) throws Exception {
        throw new InvocationException("Expected function " + this
                + " to have arity " + arity());
    }

    public Value apply(Value a0, Value a1, Value a2, Value a3, Value a4,
            Value a5, Value a6, Value a7, Value a8, Value a9) throws Exception {
        throw new InvocationException("Expected function " + this
                + " to have arity " + arity());
    }

    public Value apply(Value a0, Value a1, Value a2, Value a3, Value a4,
            Value a5, Value a6, Value a7, Value a8, Value a9, Value a10)
            throws Exception {
        throw new InvocationException("Expected function " + this
                + " to have arity " + arity());
    }

    public Value apply(Value a0, Value a1, Value a2, Value a3, Value a4,
            Value a5, Value a6, Value a7, Value a8, Value a9, Value a10,
            Value a11) throws Exception {
        throw new InvocationException("Expected function " + this
                + " to have arity " + arity());
    }

    public Value apply(Value a0, Value a1, Value a2, Value a3, Value a4,
            Value a5, Value a6, Value a7, Value a8, Value a9, Value a10,
            Value a11, Value a12) throws Exception {
        throw new InvocationException("Expected function " + this
                + " to have arity " + arity());
    }

    public Value apply(Value a0, Value a1, Value a2, Value a3, Value a4,
            Value a5, Value a6, Value a7, Value a8, Value a9, Value a10,
            Value a11, Value a12, Value a13) throws Exception {
        throw new InvocationException("Expected function " + this
                + " to have arity " + arity());
    }

    public Value apply(Value a0, Value a1, Value a2, Value a3, Value a4,
            Value a5, Value a6, Value a7, Value a8, Value a9, Value a10,
            Value a11, Value a12, Value a13, Value a14) throws Exception {
        throw new InvocationException("Expected function " + this
                + " to have arity " + arity());
    }

    public Value apply(Value a0, Value a1, Value a2, Value a3, Value a4,
            Value a5, Value a6, Value a7, Value a8, Value a9, Value a10,
            Value a11, Value a12, Value a13, Value a14, Value a15)
            throws Exception {
        throw new InvocationException("Expected function " + this
                + " to have arity " + arity());
    }
}
