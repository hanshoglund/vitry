package vitry.prelude;

import vitry.runtime.StandardFunction;
import vitry.runtime.Symbol;

public class symbol extends StandardFunction
    {
        public symbol() {
            super(1);
        }

        public Object apply(Object a) {
            return Symbol.intern((String) a);
        }
    }