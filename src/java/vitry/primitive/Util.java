package vitry.primitive;

/**
 *
 */
public class Util
    {
        private Util(){}
        
        public static Object[] concat(Object[] a, Object... b) {
            Object[] res = new Object[a.length + b.length];
            System.arraycopy(a, 0, res, 0, a.length);
            System.arraycopy(b, 0, res, a.length, b.length);
            return res;
        }
    }
