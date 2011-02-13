package vitry.prelude;

import vitry.runtime.*;
import vitry.runtime.error.*;
import vitry.runtime.struct.*;


public class union extends RestFunction
    {

        public Object applyVar(Sequence<?> args) {
            return VitryRuntime.unionOf(Sequences.toArray(args));
        }
    }
