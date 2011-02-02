package vitry.runtime;

import vitry.runtime.struct.Sequence;

/**
 * Implemented by possibly destructable values.
 */
public interface MaybeDestructible
    {
        boolean isDestructible();

        Sequence<Pattern> destruct();
    }
