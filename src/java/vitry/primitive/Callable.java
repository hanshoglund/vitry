package vitry.primitive;

/**
 *
 */
abstract public class Callable extends Atom
  {

    public Callable() {
        this.environment = HashEnv.EMPTY;
    }

    public Callable( Env<Symbol, Object> e ) {
      this.environment = e;
    }

    protected final Env<Symbol, Object> define( Symbol s, Value v ) {
      return environment.define(s, v);
    }

    protected final Object lookup( Symbol s ) {
      return environment.lookup(s);
    }

//    protected final Env<Symbol, Value> makeChildEnvironent() {
//      return new HashEnv<Symbol, Value>(this.environment);
//    }

    private Env<Symbol, Object> environment;
  }
