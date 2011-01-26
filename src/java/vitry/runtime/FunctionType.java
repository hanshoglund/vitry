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
import vitry.runtime.struct.ConsSeq;
import vitry.runtime.struct.MapSeq;
import vitry.runtime.struct.Seq;
import vitry.runtime.struct.SeqIterator;
import vitry.runtime.struct.SingleSeq;

/**
 * The function type constructor.
 * 
 * Function types are sequencable over nested types, 
 *   i.e. if <code>this</code> represents <code>a -> b -> c</code>, 
 *   then <code>this.head() == a</code> and <code>this.tail()</code> represents <code>b -> c</code>.
 * 
 */
public class FunctionType extends BasePattern implements Seq<Pattern>
    {

        private final Pattern co;

        private final Pattern dom;

        public FunctionType(Pattern codomain, Pattern domain) {
            this.co = codomain;
            this.dom = domain;
        }

        public Pattern co() {
            return this.co;
        }

        public Pattern dom() {
            return this.dom;
        }

        public boolean eq(FunctionType o) {
            return (o == this) || o.co().eqFor(this.co) && o.dom().eqFor(this.dom);
        }

        public boolean match(Atom o) {
            // We have to cast, as Function is not in the main visitor
            return (o instanceof Function) && ((Function) o).type().eq(this);
        }

        public boolean match(FunctionType p) {
            return (p == this) || (p.co().matchFor(this.co) && p.dom().matchFor(this.dom));
        }

        public boolean matchFor(Pattern p) {
            return p.match(this);
        }

        public boolean eqFor(Value o) {
            return o.eq(this);
        }

        public String toString() {
            if (co instanceof FunctionType) 
                return ("(" + co + ") -> " + dom);
            else
                return ("" + co + " -> " + dom);
        }

        public int hashCode() {
            int hash = this.getClass().hashCode();
            hash = Hashing.hash(hash, co);
            hash = Hashing.hash(hash, dom);
            return hash;
        }

        public Pattern head() {
            return co;
        }

        public Seq<Pattern> tail() {
            //        if (dom instanceof Function)
            //            return ((Function) dom).type();
            return new SingleSeq<Pattern>(dom);
        }

        public Iterator<Pattern> iterator() {
            return new SeqIterator<Pattern>(this);
        }

        public Seq<Pattern> cons(Pattern head) {
            return new ConsSeq<Pattern>(head, this);
        }

        public <U> MapSeq<Pattern, U> map(Apply fn) {
            return new MapSeq<Pattern, U>(fn, this);
        }

    }