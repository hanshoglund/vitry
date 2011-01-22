package vitry.runtime.misc;

import vitry.runtime.Pattern;
import vitry.runtime.SimpleIntersection;
import vitry.runtime.SimpleProduct;
import vitry.runtime.SimpleSet;
import vitry.runtime.SimpleUnion;

/**
 *
 */
public class Types
    {
        public Pattern product(Object... args) {
            return new SimpleProduct(args);
        }

        public Pattern set(Object... args) {
            return new SimpleSet(args);
        }

        public Pattern union(Object... args) {
            return new SimpleUnion(args);
        }

        public Pattern intersection(Object... args) {
            return new SimpleIntersection(args);
        }

//        Pattern type(Object... args) {
//            return new SimpleType()
//        }


    }
