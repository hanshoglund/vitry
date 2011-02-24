package vitry.prelude;

import vitry.runtime.*;
import vitry.runtime.struct.Seq;


public class rewrite extends StandardFunction
    {
        private VitryRuntime rt;

        public rewrite(VitryRuntime rt) {
            super(1, rt);
            this.rt = rt;
        }

        public Object apply(Object a) {
            return Rewriting.operators(rt.getPreludeFixities(), Interpreter.STANDARD_CONTEXT)
                    .rewrite((Seq<Pattern>) a);
        }
    }