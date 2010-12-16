package vitry.primitive;

/**
 * An invertible function. 
 * 
 * Used for destructuring etc.
 */
abstract public class BijectiveFunction extends Function
  {

    public BijectiveFunction( Environment<Symbol, Value> e ) {
      super(e);
    }

    abstract public BijectiveFunction getInverse();
  }
