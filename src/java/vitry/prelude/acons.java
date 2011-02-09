package vitry.prelude;

import vitry.runtime.Destructible;
import vitry.runtime.InvertibleFunction;
import vitry.runtime.InvocationError;
import vitry.runtime.SimpleProduct;
import vitry.runtime.StandardFunction;
import vitry.runtime.struct.Sequence;

// TODO test destructor

public class acons extends StandardFunction implements InvertibleFunction
    {
        public acons() {
            super(2);
        }

        public Object apply(Object a, Object b) throws InvocationError {
            throw new UnsupportedOperationException();
        }

        public Sequence<?> applyVarInverse(Object a) throws InvocationError {
            if (a instanceof Destructible)
                return ((Destructible) a).destruct();
            throw new IllegalArgumentException();
        }

        public Object applyInverse(Object a) throws InvocationError {
            throw new UnsupportedOperationException();
        }

        public InvertibleFunction getInverse() {
            throw new UnsupportedOperationException();
        }
    }