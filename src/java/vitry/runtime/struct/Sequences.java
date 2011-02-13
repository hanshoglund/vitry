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

import static vitry.runtime.Build.MEMOIZE_SEQUENCESS;

import java.util.ArrayList;
import java.util.Map;
import java.util.WeakHashMap;

import vitry.runtime.Function;
import vitry.runtime.util.Utils;


/**
 * Basic sequence operations.
 */
public class Sequences
    {
        private Sequences() {}

        private static final Map<Object, Object> memoizedLasts = new WeakHashMap<Object, Object>();

        private static final Object[] EMPTY_OBJ_ARRAY = new Object[0];
        
        

        public static <T> Sequence<T> single(T x) {
            return cons(x, null);
        }

        public static <T> Sequence<T> cons(T x, Sequence<T> xs) {
            if (xs == null)
                return new Single<T>(x);
            else
                return xs.cons(x);
        }

        public static <T> T head(Sequence<T> xs) {
            return xs.head();
        }

        public static <T> Sequence<T> tail(Sequence<T> xs) {
            return xs.tail();
        }

        public static <T> T last(Sequence<T> s) {
            if (MEMOIZE_SEQUENCESS) {
                Object m = memoizedLasts.get(s);
                if (m != null) return Utils.<T> unsafe(m);
            }
            while (s.tail() != null) {
                s = tail(s);
            }
            T r = s.head();

            if (MEMOIZE_SEQUENCESS) {
                memoizedLasts.put(s, r);
            }
            return r;
        }

        public static <T> Sequence<T> init(Sequence<T> s) {
            if (s.tail() == null) {
                if (MEMOIZE_SEQUENCESS) {
                    memoizedLasts.put(s, s.head());
                }
                return null;
            } else {
                return cons(head(s), init(tail(s)));
            }
        }

        public static <T> Sequence<T> until(Sequence<T> s, Sequence<T> t) {
            if (s == null || s == t) 
                return null;
            else
                return cons(head(s), until(tail(s), t));
        }

        public static <T> Sequence<T> untilElement(Sequence<T> s, T e) {
            if (s == null || s.head().equals(e)) 
                return null;
            else
                return cons(head(s), untilElement(tail(s), e));
        }


        public static int length(Sequence<?> s) {
            if (s instanceof Finite) return ((Finite<?>) s).length();
            int length = 0;
            do {
                length++;
                s = s.tail();
            } while (s != null);
            return length;
        }

        public static <T> Sequence<T> reverse(Sequence<T> xs) {
            return reverseAppend(xs, null);
        }

        public static <T> Sequence<T> append(Sequence<T> xs, Sequence<T> ys) {
            if (xs == null) 
                return ys;
            else
                return cons(head(xs), append(tail(xs), ys));
        }

        public static <T> Sequence<T> reverseAppend(Sequence<T> xs, Sequence<T> ys) {
            if (xs == null)
                return ys;
            else
                return (Sequence<T>) reverseAppend(xs.tail(), cons(xs.head(), ys));
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

        public static <T> T index(Sequence<T> s, int i) {
            for (int j = 0; j < i; j++)
                s = tail(s);
            return s.head();
        }

        public static <T> T nthLast(Sequence<T> s, int i) {
            return index(reverse(s), i);
        }

        public static <U, T> U foldl(Function fn, U init, Sequence<T> s) {
            U res = init;
            while (s != null) {
                res = Utils.<U>unsafe(fn.apply(init, s.head()));
                s = s.tail();
            }
            return res;
        }
        
        public static <U, T> U foldr(Function fn, U init, Sequence<T> s) {
            U res = init;
            while (s != null) {
                res = Utils.<U>unsafe(fn.apply(s.head(), init));
                s = s.tail();
            }
            return res;
        }

        public static <T> Sequence<T> printable(Sequence<T> s) {
            return new PrintableSequence<T>(s);
        }

        public static <T> SequenceIterator<T> iterate(Sequence<T> s) {
            return new SequenceIterator<T>(s);
        }

        public static <T> RewindableSequenceIterator<T> rewindableIterate(Sequence<T> s) {
            return new RewindableSequenceIterator<T>(iterate(s));
        }

        public static Object[] toArray(Sequence<?> s) {
            if (s == null) return EMPTY_OBJ_ARRAY;
        
            Object[] a;
            if (s instanceof Finite) a = new Object[ ((Finite<?>) s).length()];
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
            java.util.List<T> l = new java.util.LinkedList<T>();
            if (s == null) return l.toArray(dummy);
            do {
                l.add(s.head());
                s = tail(s);
            } while (s != null);
            return l.toArray(dummy);
        }
    }
