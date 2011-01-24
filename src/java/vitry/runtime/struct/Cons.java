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

import vitry.runtime.Apply;

/**
 * A cons of two seqs.
 */
public class Cons<T> implements Seq<T>
    {        
        private T head;
        private Seq<T> tail;

        public Cons(T head, Seq<T> tail) {
            this.head = head;
            this.tail = tail;
        }

        public Iterator<T> iterator() {
            return new SeqIterator<T>(this);
        }

        public T head() {
            return head;
        }

        public Seq<T> tail() {
            return tail;
        }

        public Seq<T> cons(T head) {
            return new Cons<T>(head, this);
        }

        public <U> Seq<U> map(Apply fn) {
            return new MapSeq<T,U>(fn, this);
        }
    }
