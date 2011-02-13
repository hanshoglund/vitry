package vitry.prelude;

import vitry.runtime.*;
import vitry.runtime.error.*;
import vitry.runtime.struct.*;


public class list extends InvertibleRestFunction
    {
        public Sequence<?> applyVarInverse(Object a) throws InvocationError {
            if (a instanceof List)
                return ((Destructible) a).destruct();
            return throwDestruct(a);
        }

        public Object applyVar(Sequence<?> args) {
            return VitryRuntime.listOf(Sequences.toArray(args));
        }

        private <T> T throwDestruct(Object val) {
            throw new TypeError(val, this);
        }

        public String toString() {
            return "[,]";
        }
        
        
    }
