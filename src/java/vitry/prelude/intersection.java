package vitry.prelude;

import vitry.runtime.*;
import vitry.runtime.error.*;
import vitry.runtime.struct.*;


public class intersection extends RestFunction
    {

        public Object applyVar(Sequence<?> args) {
            return VitryRuntime.intersectionOf(Sequences.toArray(args));
        }
    }
