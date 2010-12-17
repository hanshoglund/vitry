package vitry.primitive;

import java.io.Serializable;

/**
 * Used for non-local variable access.
 * 
 * Invariants:
 *     lookup, define and getParent are referentially transparent
 *     lookup checks parent environments and throws exceptions as needed
 *     
 *     get returns local binding or null
 *  
 */
public interface Env<K, V> extends Serializable
    {
        Env<K, V> define(K key, V val) throws BindingException;

        V lookup(K key) throws UndefinedException;

        V get(Object key);

        Env<K, V> parent();
    }