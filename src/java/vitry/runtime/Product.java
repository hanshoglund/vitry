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


/**
 * A compound value, representing tuples as well as product types.
 * 
 * We disallow nullary and unary instances, as () and (x)
 * are represented by the Unit class and the class of x respectively. Thus
 * instances of this interface represent n-tuples where n < 1.
 * 
 * TODO should Unit extend Product?
 * 
 * Invariants:
 *   - p.first() != null
 *   - p.second() != null
 * 
 */
public interface Product extends Pattern, Seq<Pattern>
    {
        public Pattern first();
        public Pattern second();
    }


abstract class AbstractProduct extends BasePattern implements Product
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
        
        public Pattern first() {
            return this.head();
        }
        
        public Pattern second() {
            Seq<Pattern> tail = this.tail();
            return (tail == null ? null : tail.head());
        }
        

        
        // Java stuff

        public boolean equals(Object o) {
            if (o == this) return true;
            if (o instanceof Product) return eq((Product) o);
            return false;
        }
        
        public int hashCode() {
            return Util.hash(this.getClass().hashCode(), this);
        }


        public Iterator<Pattern> iterator() {
            return new SeqIterator<Pattern>(this);
        }

        public String toString() {
            return Util.join(this, "(", ", ", ")");
        }
    }