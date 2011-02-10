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
package vitry.runtime;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

import vitry.runtime.struct.MapSequence;
import vitry.runtime.struct.Sequence;

/**
 * A set of host values, defined by a class or interface. 
 *
 * Matches wrapped and nonwrapped host objects that are instaces of some
 * host type. Subclasses behave as expected. 
 *
 * Does not work for other Pattern instances other than Native.
 */
public final class NativeSet extends AbstractSet
    {

        private static final Map<Class<?>, Set> instanceMap = new WeakHashMap<Class<?>, Set>();

        private final Class<?> javaClass;


        private NativeSet(Class<?> javaClass) {
            this.javaClass = javaClass;
        }

        public static Set forClass(Class<?> javaClass) {
            Set obj = instanceMap.get(javaClass);
            if (obj == null) {
                obj = new NativeSet(javaClass);
                instanceMap.put(javaClass, obj);
            }
            return obj;
        }

        public boolean eq(Set o) {
            if (o == this) return true;
            if (o instanceof NativeSet) return ((NativeSet) o).javaClass == this.javaClass;
            return false;
        }


        public boolean match(Object o) {
            return javaClass.isAssignableFrom(o.getClass());
        }

        public boolean match(Atom o) {
            if (o instanceof Native) return javaClass.isInstance( ((Native) o).obj);
            return false;
        }
        
        public boolean eq(Product o) {
            return false;
        }

        public boolean eq(Tagged o) {
            // ?
            return false;
        }

        public boolean eqFor(Pattern o) {
            return o.eq(this);
        }

        public boolean matchFor(Pattern p) {
            return p.match(this);
        }

        // Throw on enumeration
        // TODO implement this using an interface EnumerableNativeType + registration?

        public Pattern head() {
            return throwEnumeration();
        }

        public Sequence<Pattern> tail() {
            return throwEnumeration();
        }

        public Iterator<Pattern> iterator() {
            return throwEnumeration();
        }

        public Sequence<Pattern> cons(Pattern head) {
            return throwEnumeration();
        }

        public <U> MapSequence<Pattern, U> map(Function fn) {
            return throwEnumeration();
        }

        private <T> T throwEnumeration() {
            throw new UnsupportedOperationException("Can not enumerate a native type");
        }

        public boolean hasTail() {
            return false;
            // TODO Auto-generated method stub
        }
    }