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
import vitry.runtime.struct.Cons;
import vitry.runtime.struct.MapSeq;
import vitry.runtime.struct.Seq;
import vitry.runtime.struct.SeqIterator;

/**
 * Base implementation, relying on the underlying Seq logic.
 *
 * See also AbstractProduct.
 */
abstract class CompoundPattern extends BasePattern implements Seq<Pattern>
    {
        public boolean eq(Set o) {
            return o == this || this.match(o) && this.matchFor(o);
        }

        public boolean eq(Union o) {
            return o == this || this.match(o) && this.matchFor(o);
        }

        public boolean eq(Intersection o) {
            return o == this || this.match(o) && this.matchFor(o);
        }

        public boolean match(Set a) {
            if (a == Vitry.bottom) return true;
            for (Pattern x : a)
                if (!x.matchFor(this)) return false;
            return true;
        }

        public boolean match(Union a) {
            for (Pattern x : a)
                if (!x.matchFor(this)) return false;
            return true;
        }

        public boolean match(Intersection a) {
            for (Pattern x : a)
                if (x.matchFor(this)) return true;
            return false;
        }
        
        public Seq<Pattern> cons(Pattern head) {
            return new Cons<Pattern>(head, this);
        }

        public <U> MapSeq<Pattern, U> map(Apply fn) {
            return new MapSeq<Pattern,U>(fn, this);
        }
        
        
        // Java stuff
        
        public boolean equals(Object o) {
            if (o == this) return true;

            if (o instanceof Set) return this.eq((Set) o);
            if (o instanceof Union) return this.eq((Union) o);
            if (o instanceof Intersection) return this.eq((Intersection) o);
            return false;
        }

        public int hashCode() {
            return Hashing.hash(this.getClass().hashCode(), this);
        }

        public Iterator<Pattern> iterator() {
            return new SeqIterator<Pattern>(this);
        }
    }