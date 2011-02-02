package vitry.runtime.misc;

import vitry.runtime.Arrow;
import vitry.runtime.Pattern;
import vitry.runtime.SimpleIntersection;
import vitry.runtime.SimpleProduct;
import vitry.runtime.SimpleSet;
import vitry.runtime.SimpleUnion;
import vitry.runtime.Symbol;
import vitry.runtime.Type;

public class FactoryMethods
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

        public static Pattern type(Pattern pattern, Symbol id) {
            return new Type(pattern, id, null);
        }

        public static Pattern functionType(Pattern co, Pattern dom) {
            return new Arrow(co, dom);
        }

    }
