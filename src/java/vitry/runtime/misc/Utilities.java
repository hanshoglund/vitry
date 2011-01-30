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
package vitry.runtime.misc;


public class Utilities
    {
        private Utilities() {
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
        
        
        public static String limit(String s, int maxLength) {
            if (s.length() > maxLength)
                return s.substring(0, maxLength) + "...";
            else
                return s;
        }

    }
