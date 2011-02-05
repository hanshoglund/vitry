package vitry.runtime;

import vitry.runtime.struct.Sequence;


public class Constructor extends AbstractFunction implements InvertibleFunction
    {

        public Constructor(int arity) {
            super(arity);
        }

        public Sequence<Object> applyInverse(Object a0) throws InvocationError {
            return null;
        }

        public InvertibleFunction inverse() {
            return null;
        }
    }
