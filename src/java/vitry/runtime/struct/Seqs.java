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

import static vitry.Build.MEMOIZE_SEQUENCES;

import java.util.Map;
import java.util.WeakHashMap;

import vitry.runtime.Function;
import vitry.runtime.VitryRuntime;
import vitry.runtime.misc.Utils;


/**
 * Basic sequence operations.
 */
public final class Seqs
    {

        private static final Object[] EMPTY_ARRAY = new Object[0];

        private static final Map<Object, Object> MEMOIZE_LAST = new WeakHashMap<Object, Object>();
//        private static final Map<Object, Integer> MEMOIZE_LENGTH = new WeakHashMap<Object, Integer>();

        private Seqs() {}

        

        public static <T> Seq<T> single(T x) {
            return cons(x, null);
        }

        public static <T> Seq<T> cons(T x, Seq<T> xs) {
            if (isNil(xs))
                return new Single<T>(x);
            else
                return xs.cons(x);
        }
        
        public static <T> Seq<T> seq(T... a) {
            return from(a);
        }

        public static <T> Seq<T> from(T[] a) {
            if (a.length == 0)
                return null;
            else
                return new ArraySeq<T>(a);
        }
        
        public static <T> Seq<T> from(Iterable<T> a) {
            if (!a.iterator().hasNext())
                return null;
            else
                return new IterableSeq<T>(a);
        }

        public static <T> T head(Seq<T> xs) {
            return xs.head();
        }

        public static <T> Seq<T> tail(Seq<T> xs) {
            return xs.tail();
        }

        public static <T> T last(Seq<T> s) {
            if (MEMOIZE_SEQUENCES) {
                Object m = MEMOIZE_LAST.get(s);
                if (m != null) return Utils.<T> unsafe(m);
            }
            while (!isNil(s.tail())) {
                s = tail(s);
            }
            T r = s.head();

            if (MEMOIZE_SEQUENCES) {
                MEMOIZE_LAST.put(s, r);
            }
            return r;
        }

        public static <T> Seq<T> init(Seq<T> s) {
            if (isNil(s.tail())) {
                if (MEMOIZE_SEQUENCES) {
                    MEMOIZE_LAST.put(s, s.head());
                }
                return null;
            } else {
                return cons(head(s), init(tail(s)));
            }
        }

        public static <T> Seq<T> until(Seq<T> s, Seq<T> t) {
            if (isNil(s) || s == t) 
                return null;
            else
                return cons(head(s), until(tail(s), t));
        }

        public static <T> Seq<T> untilElement(Seq<T> s, T e) {
            if (isNil(s) || s.head().equals(e)) 
                return null;
            else
                return cons(head(s), untilElement(tail(s), e));
        }


        public static boolean isNil(Seq<?> s) {
            return s == null || s == VitryRuntime.NIL;
        }

        public static int length(Seq<?> s) {
            if (s instanceof Finite) return ((Finite<?>) s).length();
            
            // if (MEMOIZE_SEQUENCES) {
            //     Integer l = MEMOIZE_LENGTH.get(s);
            //     if (l != null) return l;
            // }      
            int length = 0;
            do {
                length++;
                s = s.tail();
            } while (!isNil(s));
            // if (MEMOIZE_SEQUENCES) {
            //     MEMOIZE_LENGTH.put(s, length);
            // }  
            return length;
        }

        public static <T> T first(Seq<T> s) {
            return s.head();
        }

        public static <T> T second(Seq<T> s) {
            return s.tail().head();
        }

        public static <T> T third(Seq<T> s) {
            return s.tail().tail().head();
        }

        public static <T> T nth(Seq<T> s, int i) {
            for (int j = 0; j < i; j++)
                s = tail(s);
            return s.head();
        }

        public static <T> T nthLast(Seq<T> s, int i) {
            return nth(reverse(s), i);
        }

        public static <U, T> U foldl(Function fn, U init, Seq<T> s) {
            U res = init;
            while (!isNil(s)) {
                res = Utils.<U>unsafe(fn.apply(res, s.head()));
                s = s.tail();
            }
            return res;
        }
        
        public static <U, T> U foldr(Function fn, U init, Seq<T> s) {
            U res = init;
            while (!isNil(s)) {
                res = Utils.<U>unsafe(fn.apply(s.head(), res));
                s = s.tail();
            }
            return res;
        }

        public static <T> Seq<T> reverse(Seq<T> xs) {
            return reverseAppend(xs, null);
        }

        public static <T> Seq<T> append(Seq<T> xs, Seq<T> ys) {
            if (isNil(xs)) 
                return ys;
            else
                return cons(head(xs), append(tail(xs), ys));
        }

        public static <T> Seq<T> reverseAppend(Seq<T> xs, Seq<T> ys) {
            if (isNil(xs))
                return ys;
            else
                return reverseAppend(xs.tail(), cons(xs.head(), ys));
        }

        public static <T> Seq<T> printable(Seq<T> s) {
            return new PrintableSeq<T>(s);
        }

        public static <T> SeqIterator<T> iterate(Seq<T> s) {
            return new SeqIterator<T>(s);
        }

        public static Object[] toArray(Seq<?> s) {
            if (isNil(s)) return EMPTY_ARRAY;
        
            Object[] a;
            if (s instanceof Finite) a = new Object[ ((Finite<?>) s).length()];
            else
                a = new Object[length(s)];
        
            int i = 0;
            do {
                a[i++] = s.head();
                s = s.tail();
            } while (!isNil(s));
            return a;
        }

        public static <T> T[] toArray(Seq<T> s, T[] dummy) {
            java.util.List<T> l = new java.util.LinkedList<T>();
            if (isNil(s)) return l.toArray(dummy);
            do {
                l.add(s.head());
                s = tail(s);
            } while (!isNil(s));
            return l.toArray(dummy);
        }
    }
    
    
class Single<T> extends AbstractSeq<T> implements Finite<T>
    {        
        private final T obj;

        public Single(T obj) {
            this.obj = obj;
        }

        public T head() {
            return obj;
        }

        public Seq<T> tail() {
            return null;
        }

        public int length() {
            return 1;
        }

        public boolean hasTail() {
            return false;
        }
    }
