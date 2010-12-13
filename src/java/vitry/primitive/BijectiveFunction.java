package vitry.primitive;

/**
 * An invertible function. 
 * 
 * These may be used in left-hand expressions.
 */
abstract public class BijectiveFunction extends Function {

    public BijectiveFunction(Environment<Symbol, Value> e)
    {
        super(e);
    }
    
    abstract public BijectiveFunction getInverse();
}
