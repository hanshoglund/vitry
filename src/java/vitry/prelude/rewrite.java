package vitry.prelude;

import vitry.runtime.*;
import vitry.runtime.struct.Seq;


public class rewrite extends StandardFunction
    {
        private VitryRuntime rt;

        public rewrite(VitryRuntime rt) {
            super(1, rt.getPrelude());
            this.rt = rt;
        }

        public Object apply(Object a) {
        return Rewriting.opsRewriter(rt.getPrelude().getFixities(),
                ((Interpreter) rt.getInterpreter()).getStandardContext()).rewrite(
                (Seq<Pattern>) a);
        }
    }