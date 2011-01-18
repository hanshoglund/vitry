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

import vitry.runtime.misc.MiscUtil;
import vitry.runtime.seq.Seq;

/**
 * Compound entity, matching on membership.
 * 
 * Equality and matching semantics:
 * 
 * <pre>
 * a = b, a ∈ CompoundType, b ∈ CompoundType, a : b ∪ b : a
 *
 * a : b, a ∈ (Atom ∪ Product), b ∈ Set <=> ∃x (x ∈ b,   a = x)
 * a : b, a ∈ Set, b ∈ Set              <=> ∀x (x ∈ a -> x : b) 
 * a : b, a ∈ Union, b ∈ Set            <=> ∀x (x ∈ a -> x : b) 
 * a : b, a ∈ Intersection, b ∈ Set     <=> ∃x (x ∈ a,   x : b)
 * </pre>
 */
public interface Set extends Pattern, Seq<Pattern>
    {

        public static final class Empty extends CompoundPattern implements Set
            {
                private Empty() {
                }

                public static final Empty instance = new Empty();

                public boolean eq(Set o) {
                    return o == this;
                }

                public boolean eqFor(Value o) {
                    return o.eq(this);
                }

                public boolean matchFor(Pattern p) {
                    // The empty set is a match for any compund pattern, including itself
                    // This case could be handled by the standard logic, this is just an 
                    // optimization of the special case ({}:{}).
                    if (p == this) return true;
                    return p.matchFor(this);
                }

                public Pattern head() {
                    throw new UnsupportedOperationException("{} has no members.");
                }

                public Seq<Pattern> tail() {
                    throw new UnsupportedOperationException("{} has no members.");
                }

                public String toString() {
                    return "{}";
                }

                public int hashCode() {
                    return -1;
                }
            }
    }


abstract class AbstractSet extends CompoundPattern implements Set
    {
        public boolean match(Atom a) {
            for (Pattern x : this)
                if (x.eq(a)) return true;
            return false;
        }

        public boolean match(Product a) {
            for (Pattern x : this)
                if (x.eq(a)) return true;
            return false;
        }

        public boolean eqFor(Value p) {
            return p.eq(this);
        }

        public boolean matchFor(Pattern p) {
            return p.match(this);
        }

        public String toString() {
            return MiscUtil.join(this, "{", ", ", "}");
        }
    }
