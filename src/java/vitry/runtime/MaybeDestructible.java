package vitry.runtime;

import vitry.runtime.struct.Seq;

/**
 * Implemented by possibly destructable values.
 */
public interface MaybeDestructible
    {
        boolean isDestructible();

        Seq<Pattern> destruct();
    }
