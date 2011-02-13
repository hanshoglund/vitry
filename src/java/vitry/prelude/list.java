package vitry.prelude;

import vitry.runtime.*;
import vitry.runtime.error.*;
import vitry.runtime.struct.*;


public class list extends InvertibleRestFunction
    {
        public Sequence<?> applyVarInverse(Object a) throws InvocationError {
            if (a instanceof Destructible)
                return ((Destructible) a).destruct();
            return throwDestructuring();
        }

        public Object applyVar(Sequence<?> args) {
            return VitryRuntime.listOf(Sequences.toArray(args));
        }

        private <T> T throwDestructuring() {
            throw new DestructuringError("");
        }
    }
