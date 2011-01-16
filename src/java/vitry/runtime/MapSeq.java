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
import java.util.NoSuchElementException;


public class MapSeq<A,B> implements Seq<B>, Dynamic
    {
        private final Apply fn;
        private final Seq<A> input;

        public MapSeq(Apply fn, Seq<A> input) {
            Util.checkNotNull(fn, input);
//            Util.checkArity(fn, 1);
            this.fn = fn;
            this.input = input;
        }

        public Iterator<B> iterator() {
            return new MapIterator<B>(fn, input.iterator());
        }

        @SuppressWarnings("unchecked")
        public B head() {
            A head = input.head();
            if (head == null) return null;
            try {
                return (B) fn.apply(head);
            } catch (Exception e) {
            }
            throw new RuntimeException(
                    "MapIterator faild to convert value " 
                    + head + " using " + fn);
        }

        public Seq<B> tail() {
            Seq<A> tail = input.tail();
            return (tail == null) ? null : new MapSeq<A, B>(fn, tail);
        }

        public Seq<B> cons(B head) {
            return null;
            // TODO Auto-generated method stub
        }
    }

class MapIterator<T> implements Iterator<T> {
        
    private Apply fn;
    private Iterator<?> input;

    public MapIterator(Apply fn, Iterator<?> input) {
//        Util.checkArity(fn, 1);
        this.fn = fn;
        this.input = input;
    }

    public boolean hasNext() {
        return input.hasNext();
    }

    @SuppressWarnings("unchecked")
    public T next() {
        Object next = input.next();
        try {
            return (T) fn.apply(next);
        } catch (NoSuchElementException e) {
            throw e;
        } catch (Exception e) {
        }
        throw new RuntimeException(
                "MapIterator faild to convert value " 
                + next + " using " + fn);
    }

    public void remove() {
        throw new UnsupportedOperationException("Can not remove from a MapIterator");
    }
        
}