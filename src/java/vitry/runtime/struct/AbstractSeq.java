package vitry.runtime.struct;

import vitry.runtime.Apply;


abstract public class AbstractSeq<T> implements Seq<T>
    {
        public Seq<T> cons(T head) {
            return new Cons<T>(head, this);
        }

        public <U> MapSeq<T, U> map(Apply fn) {
            return new MapSeq<T, U>(fn, this);
        }
    }
