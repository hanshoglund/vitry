package vitry.prelude;

import vitry.runtime.StandardFunction;

public class id extends StandardFunction
    {
        public id() {
            super(1);
        }

        public Object apply(Object a) {
            return a;
        }
    }