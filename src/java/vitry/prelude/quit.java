package vitry.prelude;

import vitry.runtime.InvocationError;
import vitry.runtime.StandardFunction;

public class quit extends StandardFunction
    {
        public quit() {
            super(1);
        }

        public Object apply(Object a) throws InvocationError {
            if (a instanceof Number)
                System.exit(((Number) a).intValue());
            else
                System.exit(-1);
            
            // Never reached
            return null;
        }
    }