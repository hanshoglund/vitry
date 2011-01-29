package vitry.runtime;

import vitry.runtime.struct.ConsSeq;
import vitry.runtime.struct.MapSeq;
import vitry.runtime.struct.Seq;


abstract public class ConstructionPattern extends BasePattern 
implements Seq<Pattern>, MaybeDestructible
    {
        public boolean isDestructible() {
            return true;
        }

        public Seq<Pattern> destruct() {
            return this;
        }
        
        /**
         * Instances destructs on their elements.
         */
        public Seq<Pattern> cons(Pattern head) {
            return new ConsSeq<Pattern>(head, this);
        }

        public <U> Seq<U> map(Apply fn) {
            return new MapSeq<Pattern, U>(fn, this);
        }
    }
