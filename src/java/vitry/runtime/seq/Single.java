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
package vitry.runtime.seq;

import java.util.Iterator;
import java.util.NoSuchElementException;

import vitry.runtime.Apply;


/**
 * A seq containing a single value.
 */
public class Single<T> implements Seq<T>
    {
        
        private final T obj;
        
        public Single(T obj) {
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
        
        public Seq<T> cons(T head) {
            return new Cons<T>(head, this);
        }

        public <U> Seq<U> map(Apply fn) {
            return new MapSeq<T,U>(fn, this);
        }
    }

/**
 * Iterates over a single value.
 */
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
