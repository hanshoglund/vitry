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


/*
 * Attempt at let-polymorphic version of the methods in Sequences.
 * 
 * TODO If it is to work, generated sequences (singles, pairs etc) must be
 * wrapped in S handlers.
 */
public class SequenceManipulations<U, S extends Sequence<U>>
    {
        public SequenceManipulations() {
        }

        private static final Map<Object, Object> memoizedLasts = new WeakHashMap<Object, Object>();

        private static final Object[] EMPTY_OBJ_ARRAY = new Object[0];


        public S cons(U x, S xs) {
            if (xs == null) return (S) new SingleSequence<U>(x);
            else
                return (S) xs.cons(x);
        }
        
        private S wrap(Sequence<U> s, S original) {
//            original.getClass().newInstance();
        }

//        public T head(S xs) {
//            return xs.head();
//        }
//
//        public S tail(S xs) {
//            return (S) xs.tail();
//        }
//
//        public T last(S s) {
//            if (MEMOIZE_SEQS) {
//                Object m = memoizedLasts.get(s);
//                if (m != null) return Utils.<T> unsafe(m);
//            }
//
//            while (s.tail() != null) {
//                s = tail(s);
//            }
//
//            T r = s.head();
//
//            if (MEMOIZE_SEQS) {
//                memoizedLasts.put(s, r);
//            }
//            return r;
//        }
//
//        public S init(S s) {
//            if (s.tail() == null) {
//                if (MEMOIZE_SEQS) {
//                    memoizedLasts.put(s, s.head());
//                }
//                return null;
//            } else {
//                return (S) cons(head(s), init(tail(s)));
//            }
//        }
//
//        public S until(S s, S t) {
//            if (s == null || s == t) return null;
//            else
//                return (S) cons(head(s), until(tail(s), t));
//        }
//
//        public S untilElement(S s, T e) {
//            if (s == null || s.head().equals(e)) return null;
//            else
//                return (S) cons(head(s), untilElement(tail(s), e));
//        }
//
//
//        public int length(Sequence<?> s) {
//            if (s instanceof Finite) return ((Finite<?>) s).length();
//
//            int length = 0;
//            do {
//                length++;
//                s = s.tail();
//            } while (s != null);
//            return length;
//        }
//
//        public S reverse(S xs) {
//            return (S) reverseAppend(xs, null);
//        }
//
//        public S append(S xs, S ys) {
//            if (xs == null) return ys;
//            else
//                return cons(head(xs), append(tail(xs), ys));
//        }
//
//        public S reverseAppend(S xs, S ys) {
//            if (xs == null) return ys;
//            else
//                return (S) reverseAppend((S) xs.tail(), cons(xs.head(), ys));
//        }
//
//        public T first(S s) {
//            return s.head();
//        }
//
//        public T second(S s) {
//            return s.tail().head();
//        }
//
//        public T third(S s) {
//            return s.tail().tail().head();
//        }
//
//        public T nth(S s, int i) {
//            for (int j = 0; j < i; j++)
//                s = tail(s);
//            return s.head();
//        }
//
//        public T nthLast(S s, int i) {
//            return nth(reverse(s), i);
//        }
//
//        public S printable(S s) {
//            return (S) new PrintableSequence<T>(s);
//        }
//
//
//        public Object[] toArray(Sequence<?> s) {
//            if (s == null) return EMPTY_OBJ_ARRAY;
//
//            Object[] a;
//            if (s instanceof Finite) a = new Object[ ((Finite<?>) s).length()];
//            else
//                a = new Object[length(s)];
//
//            int i = 0;
//            do {
//                a[i++] = s.head();
//                s = s.tail();
//            } while (s != null);
//            return a;
//        }
//
//        public T[] toArray(S s, T[] dummy) {
//            ArrayList<T> l = new ArrayList<T>();
//            if (s == null) return l.toArray(dummy);
//            do {
//                l.add(s.head());
//                s = tail(s);
//            } while (s != null);
//            return l.toArray(dummy);
//        }
//
//        public SequenceIterator<T> iterate(S s) {
//            return new SequenceIterator<T>(s);
//        }
//
//        public RewindableSequenceIterator<T> rewindableIterate(S s) {
//            return new RewindableSequenceIterator<T>(iterate(s));
//        }


        // public static void main(String[] args) {
        //            Pattern p = FactoryMethods.product(1, 2, 3, 4, 5);
        //            System.out.println(new SimpleProduct(butLast((Sequence<Pattern>) p)));
        //            System.out.println(last((Sequence<?>) p)); 

        // ArraySequence<Pattern> s = new ArraySequence<Pattern>(new Pattern[]{ VitryRuntime.nil, VitryRuntime.true_ });
        // Sequence<Pattern> s2 = revappend(s, s);
        // System.out.println(new SimpleProduct((Sequence<Pattern>) s2));
        // }
    }
