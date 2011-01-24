package vitry.runtime.misc;

import vitry.runtime.Pattern;
import vitry.runtime.SimpleFunctionType;
import vitry.runtime.SimpleIntersection;
import vitry.runtime.SimpleProduct;
import vitry.runtime.SimpleSet;
import vitry.runtime.SimpleType;
import vitry.runtime.SimpleUnion;

public class StaticFactoryMethods
    {
        public static Pattern product(Object... args) {
            return new SimpleProduct(args);
        }

        public static Pattern set(Object... args) {
            return new SimpleSet(args);
        }

        public static Pattern union(Object... args) {
            return new SimpleUnion(args);
        }

        public static Pattern intersection(Object... args) {
            return new SimpleIntersection(args);
        }

        public static Pattern type(Pattern pattern, Object tag) {
            return new SimpleType(pattern, tag);
        }

        public static Pattern functionType(Pattern co, Pattern dom) {
            return new SimpleFunctionType(co, dom);
        }

    }
