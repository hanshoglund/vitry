/*
 * Vitry, copyright (C) Hans Hoglund 2011
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * See COPYING.txt for details.
 */
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

        public static void checkNotNull(Object... args) {
            for (Object o : args) {
                if (o == null)
                    throw new IllegalArgumentException(
                            "Excepted non-null argument");
            }
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
            return new SimpleType(pattern, tag);
        }

        public static Type type(Pattern pattern, String symStr) {
            return new SimpleType(pattern, Symbol.intern(symStr));
        }

    }
