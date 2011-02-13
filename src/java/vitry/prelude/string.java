package vitry.prelude;

import vitry.runtime.StandardFunction;
import vitry.runtime.error.InvocationError;

public class string extends StandardFunction
    {
        public string() {
            super(1);
        }

        public Object apply(Object a) throws InvocationError {
            return a.toString();
        }
    }