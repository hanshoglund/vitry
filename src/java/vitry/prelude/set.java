package vitry.prelude;

import vitry.runtime.*;
import vitry.runtime.error.*;
import vitry.runtime.struct.*;


public class set extends RestFunction
    {

        public Object applyVar(Sequence<?> args) {
            return VitryRuntime.setOf(Sequences.toArray(args));
        }
    }
