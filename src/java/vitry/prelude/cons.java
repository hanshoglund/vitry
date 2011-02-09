package vitry.prelude;

import vitry.runtime.InvocationError;
import vitry.runtime.SimpleProduct;
import vitry.runtime.StandardFunction;

// TODO test constructor

public class cons extends StandardFunction
    {
        public cons() {
            super(2);
        }

        public Object apply(Object a, Object b) throws InvocationError {
            return new SimpleProduct(a, b);
        }
    }