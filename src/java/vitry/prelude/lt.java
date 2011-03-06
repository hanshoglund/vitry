package vitry.prelude;

import vitry.runtime.StandardFunction;
import vitry.runtime.VitryRuntime;

public class lt extends StandardFunction
    {        
        public lt() {
            super(2);
        }

        public Object apply(Object a, Object b) {
            return VitryRuntime.toVitryBool(((Comparable) a).compareTo(b) < 0);
        }
        
        
        <T> T throwArithmetic() {
            throw new ArithmeticException("Expected number type");
        }
    }