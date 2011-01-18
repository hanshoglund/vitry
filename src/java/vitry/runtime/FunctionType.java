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

import vitry.runtime.misc.HashUtil;
import vitry.runtime.seq.Seq;
import vitry.runtime.seq.SeqIterator;
import vitry.runtime.seq.Single;

/**
 * The function type constructor.
 * 
 * Function types are sequencable over nested types, 
 *   i.e. if `this` represents `a -> b -> c`, 
 *   then `this.head() == a` and `this.tail()` represents `b -> c`.
 * 
 */
public interface FunctionType extends Pattern, Seq<Pattern>
    {
        Pattern co();

        Pattern dom();
    }


class SimpleFunctionType extends BasePattern implements FunctionType
    {

        private final Pattern codomain;

        private final Pattern domain;

        public SimpleFunctionType(Pattern codomain, Pattern domain) {
            this.codomain = codomain;
            this.domain = domain;
        }

        public Pattern co() {
            return this.codomain;
        }

        public Pattern dom() {
            return this.domain;
        }

        public boolean eq(FunctionType o) {
            return (o == this) || o.co().eqFor(this.codomain)
                && o.dom().eqFor(this.domain);
        }

        public boolean match(Atom o) {
            // We have to cast, as Function is not in the main visitor
            return (o instanceof Function) && ((Function) o).type.eq(this);
        }

        public boolean match(FunctionType p) {
            return (p == this) || (p.co().matchFor(this.codomain) 
                        && p.dom().matchFor(this.domain));
        }

        public boolean matchFor(Pattern p) {
            return p.match(this);
        }

        public boolean eqFor(Value o) {
            return o.eq(this);
        }
        
        public String toString() {
            return ("" + codomain + " -> " + domain);
        }
        
        public int hashCode() {
            int hash = this.getClass().hashCode();
            hash = HashUtil.hash(hash, codomain);
            hash = HashUtil.hash(hash, domain);
            return hash;
        }

        public Pattern head() {
            return codomain;
        }

        public Seq<Pattern> tail() {
            if (domain instanceof Function)
                return ((Function) domain).type;
            else
                return new Single<Pattern>(domain);
        }

        public Iterator<Pattern> iterator() {
            return new SeqIterator<Pattern>(this);
        }

        public Seq<Pattern> cons(Pattern head) {
            return null;
            // TODO Auto-generated method stub
        }
    }