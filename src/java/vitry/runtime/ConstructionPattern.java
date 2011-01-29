package vitry.runtime;

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

    }
