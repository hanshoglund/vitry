package vitry.primitive;

import java.io.Serializable;

/**
 * Used for non-local variable access.
 * 
 * Invariants:
 *     - lookup, define and parent are referentially transparent
 *     - lookup checks parent environments and throws exception as needed,
 *       normal return implies a valid binding
 *     
 *     - get returns local binding or null
 *  
 */
public interface Env<K, V> extends Serializable
    {
        Env<K, V> define(K key, V val) throws BindingException;

        V lookup(K key) throws UndefinedException;

        V at(K key);

        Env<K, V> parent();
    }