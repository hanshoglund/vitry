package vitry.runtime.struct;

import java.util.ArrayList;
import java.util.Map;
import java.util.WeakHashMap;

import vitry.runtime.misc.Utils;


/**
 * Fast implementation of some sequencing functions.
 */
public class Sequences
    {
        private Sequences() {}

        private static final Map<Object, Object> memoizedLasts = new WeakHashMap<Object, Object>();
        private static final Object[] EMPTY_OBJ_ARRAY = new Object[0];

        
        
        public static <T> Sequence<T> cons(T x, Sequence<T> xs) {
            if (xs == null) return new SingleSequence<T>(x);
            else return xs.cons(x);
        }

        public static <T> Sequence<T> append(Sequence<T> xs, Sequence<T> ys) {
            if (xs == null) return ys;
            else return cons(xs.head(), append(xs.tail(), ys));
        }

        public static <T> Sequence<T> reverseAppend(Sequence<T> xs, Sequence<T> ys) {
            if (xs == null) return ys;
            else return reverseAppend(xs.tail(), cons(xs.head(), ys));
        }

        public static <T> Sequence<T> reverse(Sequence<T> xs) {
            return reverseAppend(xs, null);
        }

        public static <T> Sequence<T> butLast(Sequence<T> s) {
            if (s.tail() == null) {
                memoizedLasts.put(s, s.head());
                return null;
            } else {
                return cons(s.head(), butLast(s.tail()));
            }
        }

        public static <T> T last(Sequence<T> s) {
            Object m = memoizedLasts.get(s);
            if (m != null) return Utils.<T>unsafe(m);
            
            while (s.tail() != null) {
                s = s.tail();
            }
            memoizedLasts.put(s, s.head());
            return s.head();
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
                a = new Object[((Finite) s).length()];
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
