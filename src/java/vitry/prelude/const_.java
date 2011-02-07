package vitry.prelude;

import vitry.runtime.StandardFunction;

public class const_ extends StandardFunction
    {
        public const_() {
            super(1);
        }

        public Object apply(final Object a) {
            return new StandardFunction(1)
                {
                    public Object apply(Object b) {
                        return a;
                    }
                };
        }
    }