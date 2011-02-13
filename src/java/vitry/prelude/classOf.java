package vitry.prelude;

import vitry.runtime.StandardFunction;
import vitry.runtime.Symbol;
import vitry.runtime.VitryRuntime;
import vitry.runtime.error.InvocationError;

public class classOf extends StandardFunction
    {
        public classOf() {
            super(1);
        }

        /**
         * a:_ -> class
         * Returns a reference to the class of a.
         */
        public Object apply(Object obj) throws InvocationError {
            Symbol ref = Symbol.intern(obj.getClass().getName());
            try {
                VitryRuntime.internClass(ref);
            } catch (ClassNotFoundException e) {
                throw new AssertionError("Failed interning a loaded class");
            }
            return ref;
        }
    }