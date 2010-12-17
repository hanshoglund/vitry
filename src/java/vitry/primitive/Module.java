package vitry.primitive;

/**
 *
 */
public class Module extends Callable
  {

    public Module( Env<Symbol, Object> e ) {
      super(e);
    }

    public Value get() {
      return null; // TODO give empty module?
    }
  }
