package vitry.runtime;

import vitry.runtime.struct.Seq;
import vitry.runtime.struct.Seqs;

/**
 * Basic record.
 */
public class HashRec<K, V> extends HashEnv<K, V> implements Rec<K, V>
{
    public Seq<K> getKeys()
    {
        return Seqs.from(bindings.keySet());
    }
}
