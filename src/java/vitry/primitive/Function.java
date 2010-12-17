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
abstract public class Function extends Callable
  {

    /* Restrict arity (both inclusive) */
    static int MIN_ARITY = 1;
    static int MAX_ARITY = 0xf;

    public Function( Env<Symbol, Object> e ) {
      super(e);
    }

    /**
     * 
     */
    public Function() {
        // TODO Auto-generated constructor stub
    }

    public abstract int arity();

    public abstract FunctionType type();

    public Object apply( Object a0, Object a1 ) throws Exception {
      throw new InvocationException("Expected function " + this
                + " to have arity " + arity());
    }

    public Object apply( Object a0, Object a1, Object a2 ) throws Exception {
      throw new InvocationException("Expected function " + this
                + " to have arity " + arity());
    }

    public Object apply( Object a0, Object a1, Object a2, Object a3 ) throws Exception {
      throw new InvocationException("Expected function " + this
                + " to have arity " + arity());
    }

    public Object apply( Object a0, Object a1, Object a2, Object a3, Object a4 )
            throws Exception {
      throw new InvocationException("Expected function " + this
                + " to have arity " + arity());
    }

    public Object apply( Object a0, Object a1, Object a2, Object a3, Object a4,
            Object a5 ) throws Exception {
      throw new InvocationException("Expected function " + this
                + " to have arity " + arity());
    }

    public Object apply( Object a0, Object a1, Object a2, Object a3, Object a4,
            Object a5, Object a6 ) throws Exception {
      throw new InvocationException("Expected function " + this
                + " to have arity " + arity());
    }

    public Object apply( Object a0, Object a1, Object a2, Object a3, Object a4,
            Object a5, Object a6, Object a7 ) throws Exception {
      throw new InvocationException("Expected function " + this
                + " to have arity " + arity());
    }

    public Object apply( Object a0, Object a1, Object a2, Object a3, Object a4,
            Object a5, Object a6, Object a7, Object a8 ) throws Exception {
      throw new InvocationException("Expected function " + this
                + " to have arity " + arity());
    }

    public Object apply( Object a0, Object a1, Object a2, Object a3, Object a4,
            Object a5, Object a6, Object a7, Object a8, Object a9 ) throws Exception {
      throw new InvocationException("Expected function " + this
                + " to have arity " + arity());
    }

    public Object apply( Object a0, Object a1, Object a2, Object a3, Object a4,
            Object a5, Object a6, Object a7, Object a8, Object a9, Object a10 )
            throws Exception {
      throw new InvocationException("Expected function " + this
                + " to have arity " + arity());
    }

    public Object apply( Object a0, Object a1, Object a2, Object a3, Object a4,
            Object a5, Object a6, Object a7, Object a8, Object a9, Object a10,
            Object a11 ) throws Exception {
      throw new InvocationException("Expected function " + this
                + " to have arity " + arity());
    }

    public Object apply( Object a0, Object a1, Object a2, Object a3, Object a4,
            Object a5, Object a6, Object a7, Object a8, Object a9, Object a10,
            Object a11, Object a12 ) throws Exception {
      throw new InvocationException("Expected function " + this
                + " to have arity " + arity());
    }

    public Object apply( Object a0, Object a1, Object a2, Object a3, Object a4,
            Object a5, Object a6, Object a7, Object a8, Object a9, Object a10,
            Object a11, Object a12, Object a13 ) throws Exception {
      throw new InvocationException("Expected function " + this
                + " to have arity " + arity());
    }

    public Object apply( Object a0, Object a1, Object a2, Object a3, Object a4,
            Object a5, Object a6, Object a7, Object a8, Object a9, Object a10,
            Object a11, Object a12, Object a13, Object a14 ) throws Exception {
      throw new InvocationException("Expected function " + this
                + " to have arity " + arity());
    }

    public Object apply( Object a0, Object a1, Object a2, Object a3, Object a4,
            Object a5, Object a6, Object a7, Object a8, Object a9, Object a10,
            Object a11, Object a12, Object a13, Object a14, Object a15 )
            throws Exception {
      throw new InvocationException("Expected function " + this
                + " to have arity " + arity());
    }
  }
