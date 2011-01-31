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
package vitry.runtime.struct;

import java.util.Iterator;

/**
 * Adapts seq from an Iterable. This class will fetch a single iterator
 * from the given object at construction time and traverse it as required.
 * 
 * Concurrently modifying the iterable is not recommended.
 */
public class IterableSeq<T> extends AbstractSeq<T>
    {
        private Iterable<T> itbl;
        private Iterator<T> it;
        private T head;
        private Seq<T> tail;
        private boolean tailed = false;

        public IterableSeq(Iterable<T> itbl) {
            this.itbl = itbl;
            this.it = itbl.iterator();
        }

        private IterableSeq(Iterable<T> itbl, Iterator<T> it) {
            this.itbl = itbl;
            this.it = it;
        }

        public Iterator<T> iterator() {
            return itbl != null ? itbl.iterator() : super.iterator();
        }

        public T head() {
            if (head == null) head = it.next();
            return head;
        }

        public Seq<T> tail() {
            head();    
            if (!tailed) {
                if (!it.hasNext()) return null;
                tail = new IterableSeq<T>(null, it);
                tailed = true;
            }
            return tail;
        }

        public boolean hasTail() {
            if (!tailed) tail();
            return tail != null;
        }
    }
