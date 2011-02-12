package vitry.prelude;

import vitry.runtime.*;
import vitry.runtime.error.*;
import vitry.runtime.struct.*;


public class product extends InvertibleRestFunction
    {
        public Sequence<?> applyVarInverse(Object a) throws InvocationError {
            if (a instanceof Destructible)
                return ((Destructible) a).destruct();
            return throwDestructuring();
        }

        public Object applyVar(Sequence<?> args) {
            // TODO temporary hack, find something more efficient
//            return VitryRuntime.product((Sequence<?>) args);
            return VitryRuntime.productOf(Sequences.toArray(args));
        }

        private <T> T throwDestructuring() {
            throw new DestructuringError("");
        }
    }
