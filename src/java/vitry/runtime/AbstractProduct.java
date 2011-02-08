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

import vitry.runtime.misc.Utils;
import vitry.runtime.struct.Sequence;
import vitry.runtime.struct.SequenceIterator;

/**
 * Base implementation, relying on a sequence.
 * 
 * For the reified block types, we have to override the Sequence methods to adapt
 * traversal to the generated accessors.
 */
abstract public class AbstractProduct extends ConstructionPattern 
implements Product
    {
        
        public InvertibleFunction structor() {
            return null;
        }
        
        public boolean eq(Product o) {
            Sequence<Pattern> left = o;
            Sequence<Pattern> right = this;

            while (left != null && right != null) {
                if (!left.head().eqFor(right.head())) return false;
                left = left.tail();
                right = right.tail();
            }
            return (left == null && right == null);
        }

        public boolean match(Product p) {
            Sequence<Pattern> left = p;
            Sequence<Pattern> right = this;

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

        public boolean eqFor(Pattern p) {
            return p.eq(this);
        }

        public boolean matchFor(Pattern p) {
            return p.match(this);
        }
        
        public Product productMap(Function fn) {
            return new SimpleProduct(this.map(fn));
        }
        
        


        

        // Java stuff

        public boolean equals(Object o) {
            if (o == this) return true;
            if (o instanceof Product) return eq((Product) o);
            return false;
        }

        public int hashCode() {
            return Utils.hash(this.getClass().hashCode(), this);
        }


        public Iterator<Pattern> iterator() {
            return new SequenceIterator<Pattern>(this);
        }

        public String toString() {
            return Utils.join(this, "(", ", ", ")");
        }
        
        
        // Accessors

        public Pattern first() {
            return this.head();
        }

        public Pattern second() {
            return this.tail().head();
//            Seq<Pattern> tail = this.tail();
//            return (tail == null ? null : tail.head());
        }
        
        protected <T> T throwUnsupported() {
            throw new UnsupportedOperationException("No value for this accessor.");
        }
    }