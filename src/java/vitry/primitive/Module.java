package vitry.primitive;

/**
 *
 */
public class Module extends Callable
  {

    public Module( Environment<Symbol, Value> e ) {
      super(e);
    }

    public Value get() {
      return null; // TODO give empty module?
    }
  }
