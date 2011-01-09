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
package vitry.primitive;

/**
 * This interface implements the nominative type system.
 * 
 * Type instances are associated with a *tag* and a *pattern*. A tagged value
 * is a non-type value with an associated tag. Type overrides its match operation
 * to simple tag comparison.
 * 
 * TODO
 * We need tagged values to retain other properties such as deconstructability,
 * i.e. we need to have an applyTag visitor.
 */
public interface Type extends Pattern
    {
        Pattern pattern();

        Object tag();
        
        Value applyTag(Value v) throws TypeException;
    }


class TypeImpl extends BasePattern implements Type
    {
        private final Pattern pattern;
        private final Object tag;
        
        public TypeImpl(Pattern pattern, Object tag) {
            this.pattern = pattern;
            this.tag = tag;
        }

        public Pattern pattern() {
            return pattern;
        }

        public Object tag() {
            return tag;
        }

        public Value applyTag(Value v) throws TypeException {
            if (v.matchFor(pattern))
                return new Tagged<Object>(v, tag);
            else 
                throw new TypeException(tag, v);
        }

        public boolean eq(Type o) {
            return (this == o) || (pattern.eqFor(o.pattern()) && tag.equals(o.tag()));
        }
        
        public boolean match(Tagged<?> p) {
            return p.tag == tag;
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
        
        public String toString() {
            return tag.toString();
        }

        public int hashCode() {
            int hash = this.getClass().hashCode();
            hash = Util.hash(hash, pattern);
            hash = Util.hash(hash, tag);
            return hash;
        }

    }
