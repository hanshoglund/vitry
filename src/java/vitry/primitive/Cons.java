package vitry.primitive;

import java.util.Iterator;


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
    }
