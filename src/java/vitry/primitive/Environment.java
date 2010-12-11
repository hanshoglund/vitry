package vitry.primitive;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Adds the following semantics to java.util.Map:
 * 
 * - Each Environment has a parent environment
 * 
 * - When looking up a key K en environment E
 *      if E contains K, return K
 *      if the parent of E contains K, return K
 *          etc.
 *      if no ancestor contains K, return null
 *      
 * - A child environment may not modify its parent
 *     - Thus clear, remove, values, keySet and entrySet are not supported
 * 
 * - put and get allow null keys
 * - define is like put, but does not allow local modification
 * - lookup is like get, but throws an exception instead of returning null
 *
 * 
 * @author hans
 */
public class Environment<K,V> implements Map<K,V> {
    
    @SuppressWarnings("rawtypes")
    public static final Environment EMPTY = new Emtpy();

    @SuppressWarnings("unchecked")
    public Environment() {
        this(EMPTY);
    }
    
    public Environment(Environment<K,V> parent) {
        this.parent = parent;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> coll) {
        local.putAll(coll);
    }
    
    public Environment<K,V> define(K k, V v) {
        if (local.containsKey(k)) throw new AlreadyBoundException();
        put(k, v);
        return this;
    }

    public V lookup(Object k) {
        V val = get(k);
        if(val == null) throw new UndefinedException();
        return val;
    }

    @Override
    public V put(K key, V value) {
        return local.put(key, value);
    }

    @Override
    public V get(Object k) {
        V localVal = local.get(k);
        return localVal != null ? localVal : parent.get(k);
    }

    public V removeLocal(Object k) {
        return local.remove(k);
    }

    public void clearLocal() {
        local.clear();
    }

    @Override
    public boolean containsKey(Object k) {
        return local.containsKey(k) || parent.containsKey(k);
    }

    @Override
    public boolean containsValue(Object v) {
        return local.containsValue(v) || parent.containsValue(v);
    }

    @Override
    public int size() {
        return local.size() + parent.size();
    }

    public int localSize() {
        return local.size();
    }

    @Override
    public boolean isEmpty() {
        return local.isEmpty() && parent.isEmpty();
    }

    // Unsupported
    
    @Override
    public void clear() {
        throw new UnsupportedOperationException(
                "Can not clear an environment. See clearLocal.");
    }

    @Override
    public V remove(Object k) {
        throw new UnsupportedOperationException(
                "Can not remove from an environment. See removeLocal.");
    }

    @Override
    public Collection<V> values() {
        throw new UnsupportedOperationException(
                "Can not get mutable view of values in an environment.");
    }

    @Override
    public Set<java.util.Map.Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException(
                "Can not get mutable set view of an environment.");
    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException(
                "Can not get mutable set view of an environment.");
    }


    private Map<K, V> local = new HashMap<K, V>();

    private Environment<K, V> parent;

    private static class Emtpy<K, V> extends Environment<K, V> {
        @Override
        public boolean containsKey(Object k) {
            return false;
        }
    
        @Override
        public boolean containsValue(Object v) {
            return false;
        }
    
        @Override
        public V get(Object k) {
            return null;
        }
    
        @Override
        public boolean isEmpty() {
            return true;
        }
    
        @Override
        public V put(K key, V value) {
            throw new UnsupportedOperationException(
                    "Can not modify the empty environment.");
        }
    
        @Override
        public void putAll(Map<? extends K, ? extends V> coll) {
            throw new UnsupportedOperationException(
                    "Can not modify the empty environment.");
        }
    
        @Override
        public int size() {
            return 0;
        }
    
    }
 

}
