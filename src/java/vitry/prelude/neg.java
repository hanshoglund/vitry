package vitry.prelude;

import java.math.BigInteger;

import vitry.runtime.BigRational;
import vitry.runtime.StandardFunction;

public class neg extends StandardFunction
    {
        public neg() {
            super(1);
        }

        public Object apply(Object a) {
            if (a instanceof BigRational) return ((BigRational) a).negate();
            if (a instanceof BigInteger)  return ((BigInteger) a).negate();
            if (a instanceof Number)      return ((Number) a).floatValue() * -1;
            throw new RuntimeException("Expected number type.");
        }
    }