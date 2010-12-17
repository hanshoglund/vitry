package vitry.primitive;

/**
 *
 * @author hans
 */
abstract public class Thunk extends Callable
  {

    public Thunk( Env<Symbol, Object> e ) {
      super(e);
    }

    public Value get() {
      throw new InvocationException("Invalid thunk block.");
    }
  }
