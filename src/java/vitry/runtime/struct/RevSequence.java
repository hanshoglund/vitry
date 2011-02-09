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

import vitry.runtime.Function;



/**
 * Doubly-linked sequence with O(1) reversal.
 * 
 * TODO
 * 
 */
//public class RevSequence<T> extends AbstractSequence<T>
//    {        
//        private T head;
//        private Sequence<T> front;
//        private Sequence<T> back;
//
//        public RevSequence(T head, Sequence<T> front, Sequence<T> back) {
//            this.head = head;
//            this.front = front;
//            this.back = back;
//        }
//
//        public T head() {
//            return head;
//        }
//
//        public Sequence<T> tail() {
//            return front;
//        }
//        
//        public boolean hasTail() {
//            return front != null;
//        }
//        
//        public RevSequence<T> reverse() {
//            return new RevSequence<T>(head, back, front);
//        }
//
//        public RevSequence<T> cons(T val) {
//            return new RevSequence<T>(val, this.tail().cons(val), back.tail().cons(val));
//        }
//
//        public <U> RevSequence<U> map(Function fn) {
//            // TODO convert value lazily?
//            U val = (U) fn.apply(head);
//            return new RevSequence<U>(val, front.tail().<U>map(fn), back.tail().<U>map(fn));
//        }
//    }
