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

import vitry.runtime.struct.ArraySequence;
import vitry.runtime.struct.Sequence;


public class SimpleUnion extends AbstractUnion
    {
        Sequence<Pattern> elements;

        public SimpleUnion(Sequence<Pattern> elements) {
            this.elements = elements;
        }

        public SimpleUnion(Pattern... elements) {
            this.elements = new ArraySequence<Pattern>(elements);
        }

        public SimpleUnion(Object... elements) {
            this.elements = Native.wrap(new ArraySequence<Object>(elements));
        }
        
        public Iterator<Pattern> iterator() {
            return elements.iterator();
        }

        public Pattern head() {
            return elements.head();
        }

        public Sequence<Pattern> tail() {
            return elements.tail();
        }

        public boolean hasTail() {
            return elements.hasTail();
        }
    }
