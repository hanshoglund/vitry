package vitry.primitive;

/**
 *
 */
abstract public class Callable extends Atom {
    
    public Callable(Environment<Symbol, Value> e)
    {
        this.environment = e;
    }

    protected final Environment<Symbol, Value> define(Symbol s, Value v) {
        return environment.define(s, v);
    }

    protected final Value lookup(Symbol s) {
        return environment.lookup(s);
    }
    
    protected final Environment<Symbol, Value> makeChildEnvironent() {
        return new Environment<Symbol, Value>(this.environment);
    }

    private Environment<Symbol, Value> environment;
}
