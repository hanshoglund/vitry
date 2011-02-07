package vitry.prelude;

import vitry.runtime.Atom;
import vitry.runtime.Pattern;
import vitry.runtime.StandardFunction;
import vitry.runtime.VitryRuntime;

public class eq extends StandardFunction
    {
        public eq() {
            super(2);
        }

        public Object apply(Object a, Object b) {
            if (b instanceof Pattern) {
                if (a instanceof Pattern) { return VitryRuntime.toVitryBool( ((Atom) a)
                        .eqFor((Pattern) b)); }
                return VitryRuntime.toVitryBool( ((Pattern) b).eq(a));
            }
            return VitryRuntime.toVitryBool(a.equals(b));
        }
    }