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

import vitry.runtime.struct.Sequence;


public final class Bottom extends InclusionPattern implements Set
    {
        private Bottom() {}

        public static final Bottom instance = new Bottom();

        public boolean eq(Set o) {
            return o == this;
        }

        public boolean eqFor(Pattern o) {
            return o.eq(this);
        }

        public boolean matchFor(Pattern p) {
            if (p == this) return true; // Optimization
            return p.match(this);
        }

        public String toString() {
            return "{}";
        }

        public int hashCode() {
            return -1;
        }

        public boolean hasTail() {
            return false;
        }
        

        public Pattern head() {
            return throwUnsupported();
        }

        public Sequence<Pattern> tail() {
            return throwUnsupported();
        }       
        
        private <T> T throwUnsupported() {
            throw new UnsupportedOperationException("{} has no members.");
        }
    }