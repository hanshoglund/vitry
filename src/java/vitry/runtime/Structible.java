package vitry.runtime;

import vitry.runtime.struct.Sequence;

/**
 * Implemented by possibly destructable values.
 */
public interface Structible
    {
        public Bijection structor();
        
        boolean isDestructible();

        Sequence<Pattern> destruct();
    }
