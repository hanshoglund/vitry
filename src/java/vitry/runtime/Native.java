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

import vitry.runtime.struct.MapSeq;
import vitry.runtime.struct.Seq;

/**
 * Wrapper for host objects. As vitry code can hold direct references to java 
 * objects it is generally not necessary to wrap native objects to simpy expose
 * them; however, this class may be used to view a native object as an Atom
 * (and thus a Pattern), which is necessary to use it in a match expression.
 *
 * Note that values have to be referentially transparent on {@link equals()}
 * and {@link hashCode()}.
 *
 */
public final class Native extends Atom
    {
        final Object obj;

        private Native(Object obj) {
            this.obj = obj;
        }

        public boolean equals(Object o) {
            if (o instanceof Native) return obj.equals( ((Native) o).obj);
            return false;
        }

        public int hashCode() {
            return obj.hashCode();
        }

        public String toString() {
            return obj.toString();
        }

        /**
         * Returns the given object iff it is a pattern, or a Native instance
         * wrapping it otherwise.
         */
        public static Pattern wrap(Object o) {
            if (o instanceof Pattern) return (Pattern) o;
            else
                return new Native(o);
        }

        /**
         * Applies {@link #wrap(Object)} to the given values.
         */
        public static Pattern[] wrap(Object... values) {
            Pattern[] values2 = new Pattern[values.length];
            for (int i = 0; i < values.length; ++i)
                values2[i] = wrap(values[i]);
            return values2;
        }

        /**
         * Applies {@link #wrap(Object)} lazily to the given seq.
         */
        public static Seq<Pattern> wrap(Seq<Object> values) {
            return new MapSeq<Object, Pattern>(new Function(1, null){
                public Object apply(Object v) throws InvocationError {
                    return wrap(v);
                }
            }, values);
        }
    }
