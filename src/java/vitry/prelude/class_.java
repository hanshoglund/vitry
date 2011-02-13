package vitry.prelude;

import vitry.runtime.StandardFunction;
import vitry.runtime.Symbol;
import vitry.runtime.VitryRuntime;
import vitry.runtime.error.InvocationError;
import vitry.runtime.error.ResolveError;

public class class_ extends StandardFunction
    {
        public class_() {
            super(1);
        }
        
        String[] prefixes = {"", "java.lang.", "vitry.runtime.", "vitry.prelude."};

        /**
         * type class = symbol
         * 
         * class : str -> class
         * 
         * Loads the given class using reflection and returns a symbol
         * referencing it.
         */
        public Object apply(Object nameStr) throws InvocationError {

            String name = null;
            Symbol ref = null;
            
            for (String p : prefixes) {
                name = p + ((String) nameStr);
                try {
                    ref = Symbol.intern(name);
                    VitryRuntime.internClass(ref);
                } catch(ClassNotFoundException _) {
                    ref = null;
                    continue;
                }
                if (ref != null) return ref;
            }
            throw new ResolveError("Could not find class " + nameStr);
        }
    }