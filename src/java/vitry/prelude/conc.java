package vitry.prelude;

import vitry.runtime.Arity;
import vitry.runtime.StandardFunction;

public class conc extends StandardFunction
    {
        public conc() {
            super(2);
        }

        public Object apply(Object a, Object b) {
            return ((String) a).concat((String) b);
        }
    }