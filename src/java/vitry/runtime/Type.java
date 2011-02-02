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

import vitry.runtime.misc.Utils;
import vitry.runtime.struct.Sequence;

/**
 * A type or type operator.
 */
public class Type extends BasePattern
    {
        private final Pattern          pattern;
        private final Symbol           id;
        private final Sequence<Symbol> vars;

        public Type(Pattern pattern, Symbol id, Sequence<Symbol> vars) {
            this.pattern = pattern;
            this.id = id;
            this.vars = vars;
        }

        public Pattern pattern() {
            return pattern;
        }

        public Symbol id() {
            return id;
        }

        public Sequence<Symbol> vars() {
            return vars;
        }

        public Pattern tag(Value v) throws TypeError {
            if (v.matchFor(pattern)) return new Tagged(v, this);
            else throw new TypeError(this, v);
        }

        
        
        
        
        
        
        
        
        // TODO eq match

        public boolean matchFor(Pattern p) {
            return p.match(this);
        }

        public boolean eqFor(Value o) {
            return o.eq(this);
        }

        public boolean isDestructible() {
            if (pattern instanceof Structible)
                return ((Structible) pattern).isDestructible();
            return false;
        }

        public Sequence<Pattern> destruct() {
            if (pattern instanceof Structible)
                return ((Structible) pattern).destruct();
            throw new UnsupportedOperationException("Can not destruct " + pattern);
        }

        public String toString() {
            return pattern.toString();
        }

        public int hashCode() {
            int hash = this.getClass().hashCode();
            hash = Utils.hash(hash, pattern);
            return hash;
        }

    }