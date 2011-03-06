package vitry.prelude;

import java.math.BigInteger;

import vitry.runtime.BigRational;
import vitry.runtime.Native;
import vitry.runtime.StandardFunction;

public class pow extends StandardFunction
    {
        /**
         */
        public pow() {
            super(2);
        }

        public Object apply(Object a, Object b) {
//            a = Native.unwrap(a);
//            b = Native.unwrap(b);

            if (a instanceof BigRational) return ((BigRational) a).pow(((Number) b).intValue());
            if (a instanceof BigInteger)  return ((BigInteger) a).pow(((Number) b).intValue());
            if (a instanceof Number)      return Math.pow(((Number) a).doubleValue(), ((Number) b).doubleValue());
            throw new RuntimeException("Expected number type.");
        }
    }