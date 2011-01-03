package vitry.primitive;

import java.io.Serializable;

/**
 * Used for non-local variable access.
 * 
 * Invariants:
 *     - lookup and parent are referentially transparent
 *     - lookup checks parent environments and throws exception as needed,
 *       normal return implies a valid binding
 *     
 *     - fetch returns local binding or null
 *  
 */
public interface Environment<K, V> extends Serializable
    {
        Environment<K, V> define(K key, V val) throws BindingException;

        V lookup(K key) throws UndefinedException;

        V fetch(K key);

        Environment<K, V> parent();
    }