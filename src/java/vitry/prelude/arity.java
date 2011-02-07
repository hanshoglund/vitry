package vitry.prelude;

import vitry.runtime.Arity;
import vitry.runtime.StandardFunction;

public class arity extends StandardFunction
    {
        public arity() {
            super(1);
        }

        public Object apply(Object a) {
            return ((Arity) a).getArity();
        }
    }