package vitry.primitive;

/**
 *
 * @author hans
 */
public abstract class Thunk extends Value {
    
    private Environment environment;

    public Thunk(Environment e)
    {
        this.environment = e;
    }

    protected final Value define(Symbol s, Value v) {
        return environment.put(s, v);
    }

    protected final Value lookup(Symbol s) {
        return environment.get(s);
    }

    public abstract Value get();    
}
