package vitry.prelude;

import vitry.runtime.*;
import vitry.runtime.error.*;
import vitry.runtime.struct.*;


public class product extends InvertibleRestFunction
    {
        public Sequence<?> applyVarInverse(Object a) throws InvocationError {
            if (a instanceof Product)
                return ((Destructible) a).destruct();
            return throwDestruct(a);
        }

        public Object applyVar(Sequence<?> args) {
            return VitryRuntime.productOf(Sequences.toArray(args));
        }

        private <T> T throwDestruct(Object val) {
            throw new TypeError(val, this);
        }
        
        public String toString() {
            return "(,)";
        }
    }
