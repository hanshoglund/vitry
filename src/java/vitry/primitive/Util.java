package vitry.primitive;


public class Util
    {
        private Util() {
        }

        public static Object[] concat(Object[] a, Object... b) {
            Object[] res = new Object[a.length + b.length];
            System.arraycopy(a, 0, res, 0, a.length);
            System.arraycopy(b, 0, res, a.length, b.length);
            return res;
        }

        public static String join(Iterable<?> elements, String start, String delim, String end) {
            StringBuilder strb = new StringBuilder();
            boolean first = true;

            strb.append(start);
            for (Object e : elements) {
                if (first) first = false;
                else
                    strb.append(delim);
                strb.append(e);
            }
            strb.append(end);
            return strb.toString();
        }


        public static Product product(Object... elem) {
            return new SimpleProduct(elem);
        }

        public static Set set(Object... elem) {
            return new SimpleSet(elem);
        }

        public static Union union(Object... elem) {
            return new SimpleUnion(elem);
        }

        public static Intersection intersection(Object... elem) {
            return new SimpleIntersection(elem);
        }

        public static Type type(Pattern pattern, Object tag) {
            return new TypeImpl(pattern, tag);
        }

        public static Type type(Pattern pattern, String symStr) {
            return new TypeImpl(pattern, Symbol.intern(symStr));
        }


        public static int hash(int seed, int val) {
            return (seed * 65050 + val) % 2044508069;
        }

        public static int hash(int seed, Object val) {
            return hash(seed, val.hashCode());
        }

        public static int hash(int seed, Iterable<?> vals) {
            int hash = seed;
            for (Object v : vals)
                hash = hash(hash, v);
            return hash;
        }

        public static void checkArity(Function fn, int arity) {
            if (fn.arity != arity)
                throw new IllegalArgumentException(
                            "Function must have arity " + arity);
        }

        public static void checkNull(Object... args) {
            for (Object o : args) {
                if (o == null)
                    throw new IllegalArgumentException(
                            "Excepted non-null argument");
            }
        }

    }
