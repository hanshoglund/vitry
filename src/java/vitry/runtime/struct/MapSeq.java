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

import vitry.runtime.Apply;
import vitry.runtime.Dynamic;
import vitry.runtime.Function;
import vitry.runtime.InvocationException;
import vitry.runtime.misc.Checks;


/**
 * A seq adapted from another seq by the map operation.
 */
public class MapSeq<A, B> implements Dynamic, Seq<B>
    {
        private final Apply fn;

        private final Seq<A> input;

        public MapSeq(Apply fn, Seq<A> input) {
            Checks.checkNotNull(fn, input);
            if (fn instanceof Function) Checks.checkArity((Function) fn, 1);
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
                // Either returns or throw an InvocationException
                return (B) fn.apply(head);
                
            } catch (InvocationException e) {
                throw new InvocationException(
                        "MapIterator faild to convert value " 
                        + head + " using " + fn, e);
           }
        }

        public Seq<B> tail() {
            Seq<A> tail = input.tail();
            return (tail == null) ? null : new MapSeq<A, B>(fn, tail);
        }

        public Seq<B> cons(B head) {
            return new Cons<B>(head, this);
        }

        public <C> Seq<C> map(Apply fn) {
            return new MapSeq<B, C>(fn, this);
        }

    }


class MapIterator<T> implements Iterator<T>
    {

        private Apply fn;

        private Iterator<?> input;

        public MapIterator(Apply fn, Iterator<?> input) {
            if (fn instanceof Function) Checks.checkArity((Function) fn, 1);
            this.fn = fn;
            this.input = input;
        }

        public boolean hasNext() {
            return input.hasNext();
        }

        @SuppressWarnings("unchecked")
        
        public T next() {
            Object next = null;
            try {
                // Either next suceeds so that next is set to return value, 
                // or we catch and rethrow a NoSuchElementException
                next = input.next();

                // Either returns or throw an InvocationException
                return (T) fn.apply(next);

            } catch (NoSuchElementException e) {
                throw e;
            } catch (InvocationException e) {
                throw new InvocationException(
                        "MapIterator faild to convert value " 
                        + next+ " using " + fn, e);
            }
        }

        public void remove() {
            throw new UnsupportedOperationException("Can not remove from a MapIterator");
        }

    }