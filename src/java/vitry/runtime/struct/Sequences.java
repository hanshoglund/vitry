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
package vitry.runtime.struct;

import static vitry.runtime.Build.MEMOIZE_SEQS;

import java.util.ArrayList;
import java.util.Map;
import java.util.WeakHashMap;

import vitry.runtime.misc.Utils;

/**
 * Basic sequence operations.
 * 
 * TODO rewrite in core with proper tail calls.
 */
public class Sequences
    {
        private Sequences() {}

        private static final Map<Object, Object> memoizedLasts = new WeakHashMap<Object, Object>();
        private static final Object[] EMPTY_OBJ_ARRAY = new Object[0];
        
        
        public static <T> Sequence<T> cons(T x, Sequence<T> xs) {
            if (xs == null) 
                return new SingleSequence<T>(x);
            else 
                return xs.cons(x);
        }

        public static <T> Sequence<T> append(Sequence<T> xs, Sequence<T> ys) {
            if (xs == null) 
                return ys;
            else 
                return cons(xs.head(), append(xs.tail(), ys));
        }

        public static <T> Sequence<T> reverseAppend(Sequence<T> xs, Sequence<T> ys) {
            if (xs == null) 
                return ys;
            else 
                return reverseAppend(xs.tail(), cons(xs.head(), ys));
        }

        public static <T> Sequence<T> reverse(Sequence<T> xs) {
            return reverseAppend(xs, null);
        }

        public static <T> Sequence<T> butLast(Sequence<T> s) {
            if (s.tail() == null) {
                if (MEMOIZE_SEQS) {
                    memoizedLasts.put(s, s.head());                    
                }
                return null;
            } else {
                return cons(s.head(), butLast(s.tail()));
            }
        }

        public static <T> T last(Sequence<T> s) {
            if (MEMOIZE_SEQS) {                
                Object m = memoizedLasts.get(s);
                if (m != null) return Utils.<T>unsafe(m);
            }            

            while (s.tail() != null) {
                s = s.tail();
            }
            
            T r = s.head();
            
            if (MEMOIZE_SEQS) {
                memoizedLasts.put(s, r);                
            }
            return r;
        }

        public static <T> T first(Sequence<T> s) {
            return s.head();
        }

        public static <T> T second(Sequence<T> s) {
            return s.tail().head();
        }

        public static <T> T third(Sequence<T> s) {
            return s.tail().tail().head();
        }


        public static int length(Sequence<?> s) {
            if (s instanceof Finite)
                return ((Finite<?>) s).length();
                
            int length = 0;
            do {
                length++;
                s = s.tail();
            } while (s != null);
            return length;
        }

        public static Object[] toArray(Sequence<?> s) {
            if (s == null) return EMPTY_OBJ_ARRAY;
            
            Object[] a;
            if (s instanceof Finite)
                a = new Object[((Finite<?>) s).length()];
            else
                a = new Object[length(s)];
            
            int i = 0;
            do {
                a[i++] = s.head();
                s = s.tail();
            } while (s != null);
            return a;
        }

        public static <T> T[] toArray(Sequence<T> s, T[] dummy) {
            ArrayList<T> l = new ArrayList<T>();
            if (s == null) return l.toArray(dummy);
            do {
                l.add(s.head());
                s = s.tail();
            } while (s != null);
            return l.toArray(dummy);
        }
        


        // public static void main(String[] args) {
            //            Pattern p = FactoryMethods.product(1, 2, 3, 4, 5);
            //            System.out.println(new SimpleProduct(butLast((Sequence<Pattern>) p)));
            //            System.out.println(last((Sequence<?>) p)); 

            // ArraySequence<Pattern> s = new ArraySequence<Pattern>(new Pattern[]{ VitryRuntime.nil, VitryRuntime.true_ });
            // Sequence<Pattern> s2 = revappend(s, s);
            // System.out.println(new SimpleProduct((Sequence<Pattern>) s2));
        // }
    }
