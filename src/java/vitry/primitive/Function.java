package vitry.primitive;

/**
 * Subclassed by compiled and generated functions.
 * 
 * @author hans
 */
public abstract class Function extends Atom {

    private Environment environment;

    public Function(Environment e)
    {
        this.environment = e;
    }

    public abstract int arity();

    public abstract FunctionType type();

    public abstract Value apply(Value n);
}
