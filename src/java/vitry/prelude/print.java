package vitry.prelude;

import vitry.runtime.*;

public class print extends StandardFunction
    {
        private VitryRuntime rt;

        public print(VitryRuntime rt) {
            super(1, rt.getPrelude());
            this.rt = rt;
        }

        public Object apply(Object a) {
            System.out.println(a);
            return a;
        }
    }