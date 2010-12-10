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

    protected final Value define(Symbol s, Value v) {
        return environment.put(s, v);
    }

    protected final Value lookup(Symbol s) {
        return environment.get(s);
    }

    public abstract int arity();

    public abstract Functor type();

    public abstract Value apply(Value n);
}
