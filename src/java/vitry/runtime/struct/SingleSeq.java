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
import java.util.NoSuchElementException;

/**
 * A seq containing a single value.
 */
public class SingleSeq<T> extends AbstractSeq<T> implements Countable
    {
        
        private final T obj;
        
        public SingleSeq(T obj) {
            this.obj = obj;
        }

        public Iterator<T> iterator() {
            return new SingleIterator<T>(obj);
        }

        public T head() {
            return obj;
        }

        public Seq<T> tail() {
            return null;
        }

        public int count() {
            return 1;
        }
    }

class SingleIterator<T> implements Iterator<T> {
        
    private final T obj;
    private boolean called = false;

    public SingleIterator(T obj) {
        this.obj = obj;
    }

    public boolean hasNext() {
        return !called;
    }

    public T next() {
        if (called) throw new NoSuchElementException();
        else {
            called = true;
            return obj;            
        }
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }        
}
