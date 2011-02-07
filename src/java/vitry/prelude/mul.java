package vitry.prelude;

import java.math.BigInteger;

import vitry.runtime.BigRational;
import vitry.runtime.StandardFunction;

public class mul extends StandardFunction
    {
        /**
         */
        public mul() {
            super(2);
        }

        public Object apply(Object a, Object b) {
            if (a instanceof BigRational) {
                if (b instanceof BigRational) return ((BigRational) a).multiply((BigRational) b);
                else if (b instanceof Number) return ((BigRational) a).multiply(((Number) b).longValue());
                throw new RuntimeException("Expected number type.");
            }
            if (a instanceof BigInteger)  {
                if (b instanceof BigInteger)  return ((BigInteger) a).multiply((BigInteger) b);
                throw new RuntimeException("Expected number type.");
            }
            if (a instanceof Double)      {
                if (b instanceof Number)      return ((Double) a) * ((Number) b).doubleValue();
                throw new RuntimeException("Expected number type.");
            }
            if (a instanceof Float)      {
                if (b instanceof Number)      return ((Float) a) * ((Number) b).floatValue();
                throw new RuntimeException("Expected number type.");
            }
            throw new RuntimeException("Expected number type.");
        }
    }