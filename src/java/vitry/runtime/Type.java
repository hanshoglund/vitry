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

import vitry.runtime.misc.Hashing;
import vitry.runtime.struct.Seq;

/**
 * A type or type operator.
 */
public class Type extends BasePattern implements MaybeDestructible
    {
        
        private final Pattern pattern;

        private final Object tag;
        
        // TODO
        private boolean retained;
        

        public Type(Pattern pattern, Object tag) {
            this.pattern = pattern;
            this.tag = tag;
        }

        public Pattern pattern() {
            return pattern;
        }

        public Object tag() {
            return tag;
        }

        public Value applyTag(Value v) throws TypeError {
            if (v.matchFor(pattern)) return new Tagged<Object>(v, tag);
            else
                throw new TypeError(tag, v);
        }

        public boolean eq(Type o) {
            return (this == o) || (pattern.eqFor(o.pattern()) && tag.equals(o.tag()));
        }

        public boolean match(Tagged<?> p) {
            return p.getTag() == tag;
        }

        public boolean match(Type o) {
            return pattern.matchFor(o.pattern()) && tag.equals(o.tag());
        }

        public boolean matchFor(Pattern p) {
            return p.match(this);
        }

        public boolean eqFor(Value o) {
            return o.eq(this);
        }

        public boolean isDestructible() {
            if (pattern instanceof MaybeDestructible)
                return ((MaybeDestructible) pattern).isDestructible();
            return false;
        }

        public Seq<Pattern> destruct() {
            if (pattern instanceof MaybeDestructible)
                return ((MaybeDestructible) pattern).destruct();
            throw new UnsupportedOperationException("Can not destruct " + pattern);
        }

        public String toString() {
            return tag.toString();
        }

        public int hashCode() {
            int hash = this.getClass().hashCode();
            hash = Hashing.hash(hash, pattern);
            hash = Hashing.hash(hash, tag);
            return hash;
        }

    }