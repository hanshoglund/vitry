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

import vitry.runtime.Arity;
import vitry.runtime.Function;
import vitry.runtime.error.InvocationError;
import vitry.runtime.util.Checks;
import vitry.runtime.util.Utils;


/**
 * A seq adapted from another seq by the map operation.
 *
 * The function is applied on head lookup, not tail.
 */
public class MapSequence<A, B> extends AbstractSequence<B>
    {
        private final Function fn;
        private final Sequence<A> input;

        public MapSequence(Function fn, Sequence<A> input) {
            Checks.checkNotNull(fn, input);
            if (fn instanceof Arity) Checks.checkArity((Arity) fn, 1);
            this.fn = fn;
            this.input = input;
        }

        public Iterator<B> iterator() {
            return new MapIterator<B>(fn, input.iterator());
        }

        public B head() {
            A head = input.head();

            if (head == null) return null;

            try {
                // Either returns or throw an InvocationException
                return Utils.<B>unsafe(fn.apply(head));
                
            } catch (InvocationError e) {
                throw new InvocationError(
                        "MapIterator faild to convert value " 
                        + head + " using " + fn, e);
           }
        }

        public Sequence<B> tail() {
            if (input.hasTail()) {
                return new MapSequence<A, B>(fn, input.tail());
            } else {
                return null;
            }
        }

        public boolean hasTail() {
            return input.hasTail();
        }
    }


class MapIterator<T> implements Iterator<T>
    {

        private Function fn;
        private Iterator<?> input;

        public MapIterator(Function fn, Iterator<?> input) {
            if (fn instanceof Arity) Checks.checkArity((Arity) fn, 1);
            this.fn = fn;
            this.input = input;
        }

        public boolean hasNext() {
            return input.hasNext();
        }
        
        public T next() {
            Object next = null;
            try {
                // Either next suceeds so that next is set to return value, 
                // or we catch and rethrow a NoSuchElementException
                next = input.next();

                // Either returns or throw an InvocationException
                return Utils.<T>unsafe(fn.apply(next));

            } catch (NoSuchElementException e) {
                throw e;
            } catch (InvocationError e) {
                throw new InvocationError(
                        "MapIterator faild to convert value " 
                        + next+ " using " + fn, e);
            }
        }

        public void remove() {
            throw new UnsupportedOperationException("Can not remove from a MapIterator");
        }

    }