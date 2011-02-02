package vitry.runtime.struct;

import java.util.Map;
import java.util.WeakHashMap;

import vitry.runtime.Pattern;
import vitry.runtime.SimpleProduct;
import vitry.runtime.misc.FactoryMethods;
import vitry.runtime.misc.Utils;

/**
 * Fast implementation of some sequencing functions.
 */
public class Sequences
    {
        
        private Sequences(){}
        
        private static Map<Object,Object> memoizedLasts = new WeakHashMap<Object, Object>();

        
        public static <T> Sequence<T> butLast(Sequence<T> s) {
            if (s.tail() == null) {
                memoizedLasts.put(s, s.head());
                return null;
            } else {
                T x = s.head();
                Sequence<T> xs = butLast(s.tail());
                if (xs != null)
                    return xs.prepend(x);
                else
                    return new SingleSequence<T>(x);
            }
        }
        
        public static <T> T last(Sequence<T> s) {
            if (memoizedLasts.containsKey(s)) return Utils.unsafe(memoizedLasts.get(s));
            while(s.tail() != null) {
                s = s.tail();
            }
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
        
//        
//        public static void main(String[] args) {
//            Pattern p = FactoryMethods.product(1, 2, 3, 4, 5);
//            System.out.println(new SimpleProduct(butLast((Sequence) p)));
//            System.out.println(last((Sequence) p));
//        }
    }
