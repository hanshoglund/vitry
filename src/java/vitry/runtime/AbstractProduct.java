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

import vitry.runtime.misc.Hashing;
import vitry.runtime.misc.Utilities;
import vitry.runtime.struct.Seq;
import vitry.runtime.struct.SeqIterator;

/**
 * Base implementation, relying on the underlying Seq logic.
 * 
 * Does not support the <em>n</em>-accessors.
 * 
 * For the reified block types, we have to override the Seq methods to adapt
 * traversal to accessors instead of the other way around.
 */
public abstract class AbstractProduct extends BasePattern implements Product
    {
        public boolean eq(Product o) {
            Seq<Pattern> left = o;
            Seq<Pattern> right = this;

            while (left != null && right != null) {
                if (!left.head().eqFor(right.head())) return false;
                left = left.tail();
                right = right.tail();
            }
            return (left == null && right == null);
        }

        public boolean match(Product p) {
            Seq<Pattern> left = p;
            Seq<Pattern> right = this;

            while (left != null && right != null) {
                if (!left.head().matchFor(right.head())) return false;
                left = left.tail();
                right = right.tail();
            }
            return (left == null && right == null);
        }

        public boolean match(Intersection a) {
            for (Pattern x : a)
                if (x.matchFor(this)) return true;
            return false;
        }

        public boolean eqFor(Value p) {
            return p.eq(this);
        }

        public boolean matchFor(Pattern p) {
            return p.match(this);
        }
        
        // Java stuff

        public boolean equals(Object o) {
            if (o == this) return true;
            if (o instanceof Product) return eq((Product) o);
            return false;
        }

        public int hashCode() {
            return Hashing.hash(this.getClass().hashCode(), this);
        }


        public Iterator<Pattern> iterator() {
            return new SeqIterator<Pattern>(this);
        }

        public String toString() {
            return Utilities.join(this, "(", ", ", ")");
        }
        
        
        // Accessors

        public Pattern fst() {
            return this.head();
        }

        public Pattern snd() {
            Seq<Pattern> tail = this.tail();
            return (tail == null ? null : tail.head());
        }

        public Pattern _1() {
            return fst();
        }

        public Pattern _2() {
            return snd();
        }

        public Pattern _3() {
            return throwUnsupported();
        }

        public Pattern _4() {
            return throwUnsupported();
        }

        public Pattern _5() {
            return throwUnsupported();
        }

        public Pattern _6() {
            return throwUnsupported();
        }

        public Pattern _7() {
            return throwUnsupported();
        }

        public Pattern _8() {
            return throwUnsupported();
        }

        public Pattern _9() {
            return throwUnsupported();
        }
        
        protected <T> T throwUnsupported() {
            throw new UnsupportedOperationException("No value for this accessor.");
        }
    }