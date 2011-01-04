package vitry.primitive;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;


public class PrimitiveType extends AbstractPattern implements Set
    {

        private static final Map<Class<?>, Set> instanceMap = new WeakHashMap<Class<?>, Set>();

        private final Class<?>                  javaClass;


        private PrimitiveType(Class<?> javaClass) {
            this.javaClass = javaClass;
        }

        public static Set forClass(Class<?> javaClass) {
            Set obj = instanceMap.get(javaClass);
            if (obj == null) {
                obj = new PrimitiveType(javaClass);
                instanceMap.put(javaClass, obj);
            }
            return obj;
        }

        public boolean eq(Set o) {
            if (o == this) return true;
            if (o instanceof PrimitiveType) {
                return ((PrimitiveType) o).javaClass == this.javaClass;
            }
            return false;
        }

        public boolean match(Atom o) {
            if (o instanceof PrimitiveValue)
                return javaClass.isInstance(((PrimitiveValue) o).obj);
            return false;
        }

        public boolean eqFor(Value o) {
            return o.eq(this);
        }

        public boolean matchFor(Pattern p) {
            return p.match(this);
        }

        // Throw on enumeration
        // TODO implement this?

        public Pattern head() {
            throw new UnsupportedOperationException("Can not enumerate a primitive type");
        }

        public Seq<Pattern> tail() {
            throw new UnsupportedOperationException("Can not enumerate a primitive type");
        }

        public Iterator<Pattern> iterator() {
            throw new UnsupportedOperationException("Can not enumerate a primitive type");
        }
    }
