package vitry.primitive;

/**
 * Invariants:
 *   f(A) = B iff f.inverse(B) = A
 * 
 * Used for destructuring etc.
 */
abstract public class BijectiveFunction extends Function implements Invertible<BijectiveFunction>
  {

    public BijectiveFunction( Env<Symbol, Object> e ) {
      super(e);
    }

    abstract public BijectiveFunction inverse();
  }
