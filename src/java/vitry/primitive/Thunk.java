package vitry.primitive;

/**
 *
 * @author hans
 */
abstract public class Thunk extends Callable {
    
    public Thunk(Environment<Symbol, Value> e)
    {
        super(e);
    }

    public abstract Value get();    
}
