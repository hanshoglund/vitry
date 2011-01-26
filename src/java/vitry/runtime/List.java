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

import vitry.runtime.struct.Seq;

/**
 * 
 */
public class List extends AbstractProduct
    {
        public final Pattern type;
        
        protected List(Pattern type) {
            this.type = type;
        }

        public Pattern type() {
            return type;
        }

        public Pattern head() {
            return null;
        }

        public Seq<Pattern> tail() {
            return null;
        }

        public Product fst() {
            return null;
            // TODO Auto-generated method stub
        }

        public Product snd() {
            return null;
            // TODO Auto-generated method stub
        }

        public Seq<Pattern> cons(Pattern head) {
            return null;
            // TODO Auto-generated method stub
        }

        public <U> Seq<U> map(Apply fn) {
            return null;
            // TODO Auto-generated method stub
        }
    }
