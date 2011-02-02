package vitry.runtime;

import vitry.runtime.struct.PairSequence;
import vitry.runtime.struct.MapSequence;
import vitry.runtime.struct.Sequence;


abstract public class ConstructionPattern extends BasePattern 
implements Sequence<Pattern>, MaybeDestructible
    {
        public boolean isDestructible() {
            return true;
        }

        public Sequence<Pattern> destruct() {
            return this;
        }
        
        /**
         * Instances destructs on their elements.
         */
        public Sequence<Pattern> cons(Pattern head) {
            return new PairSequence<Pattern>(head, this);
        }

        public <U> Sequence<U> map(Apply fn) {
            return new MapSequence<Pattern, U>(fn, this);
        }
    }
