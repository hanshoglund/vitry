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

import vitry.runtime.struct.*;
import vitry.runtime.util.Utils;


abstract public class InclusionPattern extends BasePattern implements Sequence<Pattern>
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
            if (a == VitryRuntime.BOTTOM) return true;
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
        
        public Sequence<Pattern> cons(Pattern head) {
            return new PairSequence<Pattern>(head, this);
        }

        public <U> MapSequence<Pattern, U> map(Function fn) {
            return new MapSequence<Pattern,U>(fn, this);
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
            return Utils.hash(this.getClass().hashCode(), this);
        }

        public Iterator<Pattern> iterator() {
            return new SequenceIterator<Pattern>(this);
        }

        public SequenceIterator<Pattern> sequenceIterator() {
            return new SequenceIterator<Pattern>(this);
        }
    }
