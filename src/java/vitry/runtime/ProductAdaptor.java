package vitry.runtime;

import vitry.runtime.struct.Sequence;

abstract public class ProductAdaptor extends AbstractProduct
    {
        
        abstract public Product asProduct();

        public Pattern head() {
            return asProduct().head();
        }

        public Sequence<Pattern> tail() {
            return asProduct().tail();
        }

        public boolean hasTail() {
            return asProduct().hasTail();
        }

    }
