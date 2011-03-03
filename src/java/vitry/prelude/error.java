package vitry.prelude;

import vitry.runtime.*;
import vitry.runtime.error.StandardError;

public class error extends StandardFunction
    {
        private VitryRuntime rt;

        public error(VitryRuntime rt) {
            super(1, rt.getPrelude());
            this.rt = rt;
        }

        public Object apply(Object a) {
            throw new StandardError((String) a);
        }
    }