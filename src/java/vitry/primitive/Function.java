package vitry.primitive;

/**
 * Subclassed by compiled and generated functions.
 * 
 * @author hans
 */
public abstract class Function extends Callable {

    public Function(Environment e)
    {
        super(e);
    }

    public abstract int arity();

    public abstract Functor type();

    public abstract Value apply(Value n);
}
