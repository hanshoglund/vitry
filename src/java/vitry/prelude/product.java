package vitry.prelude;

import vitry.runtime.Destructible;
import vitry.runtime.InvertibleRestFunction;
import vitry.runtime.InvocationError;
import vitry.runtime.Pattern;
import vitry.runtime.SimpleProduct;
import vitry.runtime.struct.Sequence;


public class product extends InvertibleRestFunction
    {
        public Sequence<?> applyVarInverse(Object a) throws InvocationError {
            if (a instanceof Destructible)
                return ((Destructible) a).destruct();
            return throwDestructuring();
        }

        public Object applyVar(Sequence<?> args) {
            return new SimpleProduct((Sequence<Pattern>)args);
        }

        private <T> T throwDestructuring() {
            throw new DestructuringError("");
        }
    }
