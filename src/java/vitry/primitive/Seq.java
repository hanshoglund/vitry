package vitry.primitive;

/**
 * Sequence abstraction
 *   - tail returns further elements or null
 * 
 */
public interface Seq<T> extends Iterable<T>
    {
        T head();
        
        Seq<T> tail();
    }
