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

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import vitry.runtime.ParseError;
import vitry.runtime.Pattern;
import vitry.runtime.Product;
import vitry.runtime.SimpleProduct;
import vitry.runtime.Vitry;
import vitry.runtime.struct.Sequence;


public class Utils
    {
        private Utils() {
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
        
        
        public static String unescapeJava(String str) {
            if (str == null) {
                return null;
            }
            StringWriter writer = null;
            try {
                writer = new StringWriter(str.length());
                unescapeJava(writer, str);
            } catch (IOException ioe) {
                // this should never ever happen while writing to a StringWriter
                assert false;
            }
            return writer.toString();
        }
        
        public static void unescapeJava(Writer out, String str) throws IOException {
            if (out == null) {
                throw new IllegalArgumentException("The Writer must not be null");
            }
            if (str == null) {
                return;
            }
            int sz = str.length();
            StringBuilder unicode = new StringBuilder(4);
            boolean hadSlash = false;
            boolean inUnicode = false;
            for (int i = 0; i < sz; i++) {
                char ch = str.charAt(i);
                if (inUnicode) {
                    // if in unicode, then we're reading unicode
                    // values in somehow
                    unicode.append(ch);
                    if (unicode.length() == 4) {
                        // unicode now contains the four hex digits
                        // which represents our unicode character
                        try {
                            int value = Integer.parseInt(unicode.toString(), 16);
                            out.write((char) value);
                            unicode.setLength(0);
                            inUnicode = false;
                            hadSlash = false;
                        } catch (NumberFormatException nfe) {
                            throw new ParseError("Unable to parse unicode value: " + unicode);
                        }
                    }
                    continue;
                }
                if (hadSlash) {
                    // handle an escaped value
                    hadSlash = false;
                    switch (ch) {
                        case '\\':
                            out.write('\\');
                            break;
                        case '\'':
                            out.write('\'');
                            break;
                        case '\"':
                            out.write('"');
                            break;
                        case 'r':
                            out.write('\r');
                            break;
                        case 'f':
                            out.write('\f');
                            break;
                        case 't':
                            out.write('\t');
                            break;
                        case 'n':
                            out.write('\n');
                            break;
                        case 'b':
                            out.write('\b');
                            break;
                        case 'u':
                            {
                                // uh-oh, we're in unicode country....
                                inUnicode = true;
                                break;
                            }
                        default :
                            out.write(ch);
                            break;
                    }
                    continue;
                } else if (ch == '\\') {
                    hadSlash = true;
                    continue;
                }
                out.write(ch);
            }
            if (hadSlash) {
                // then we're in the weird case of a \ at the end of the
                // string, let's output it anyway.
                out.write('\\');
            }
        }
        
        @SuppressWarnings("unchecked")
        public static <T,U> U unsafe(T val) {
            return (U) val;
        }

        public static <T> void nothing(T val) {
            return;
        }
        
        
        // TODO lazy variant
        public static Product prune(Product p) {
            try {
                if ( ((Product) p.head()).tail() == null) {
                    Pattern h = ((Product) p.head()).head();
                    Product t = prune(new SimpleProduct(p.tail()));
                    return new SimpleProduct(t.prepend(h));
                }
            } catch (ClassCastException e) {
            }
            if (p.tail() == null) return p;
            Pattern h = p.head();
            Product t = prune(new SimpleProduct(p.tail()));
            return new SimpleProduct(t.prepend(h));
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

    }
