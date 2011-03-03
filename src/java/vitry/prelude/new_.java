package vitry.prelude;

import vitry.runtime.StandardFunction;
import vitry.runtime.Symbol;
import vitry.runtime.VitryRuntime;
import vitry.runtime.error.ResolveError;

public class new_ extends StandardFunction
    {
        private VitryRuntime rt;

        public new_(VitryRuntime rt) {
            super(1, rt.getPrelude());
            this.rt = rt;
        }

        /**
         * sym -> instance
         * 
         * TODO arguments to constructors 
         */
        public Object apply(Object c) {
            try
            {
                return rt.internClass((Symbol) c).newInstance();
            }
            catch (Exception _)
            {
                throw new ResolveError("Could not initiate class" + c);
            }
        }
    }