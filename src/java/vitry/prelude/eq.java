package vitry.prelude;

import static vitry.runtime.VitryRuntime.*;
import vitry.runtime.Atom;
import vitry.runtime.Pattern;
import vitry.runtime.StandardFunction;


public class eq extends StandardFunction
    {
        public eq() {
            super(2);
        }

        public Object apply(Object a, Object b) {
            if (b instanceof Pattern) {
                if (a instanceof Pattern) { 
                    return toVitryBool( ((Pattern) a).eqFor((Pattern) b)); 
                }
                return toVitryBool( ((Pattern) b).eq(a));
            }
            return toVitryBool(a.equals(b));
        }
    }