package vitry.primitive;

/**
 *
 * @author hans
 */
public abstract class Thunk extends Callable {
    
    public Thunk(Environment e)
    {
        super(e);
    }

    public abstract Value get();    
}
