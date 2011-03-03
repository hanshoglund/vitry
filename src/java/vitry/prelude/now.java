package vitry.prelude;

import java.math.BigInteger;

import vitry.runtime.*;
import vitry.runtime.error.StandardError;

public class now extends StandardFunction
    {
        private VitryRuntime rt;

        public now(VitryRuntime rt) {
            super(1, rt.getPrelude());
            this.rt = rt;
        }

        public Object apply(Object a) {
            return BigInteger.valueOf(System.currentTimeMillis());
        }
    }