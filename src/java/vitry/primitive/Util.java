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

        public static Product product(Object... objs) {
            return new SimpleProduct(objs);
        }

        public static Set set(Object... objs) {
            return new SimpleSet(objs);
        }

        public static Union union(Object... objs) {
            return new SimpleUnion(objs);
        }

        public static Intersection intersection(Object... objs) {
            return new SimpleIntersection(objs);
        }

    }
