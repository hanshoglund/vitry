package vitry.primitive;

/**
 * Sequence abstraction
 * 
 * - We implement this on all sequential language types, such as products,
 *   compound patterns and lists to support efficient conversions. 
 * - May be lazy.
 * - Extends iterable to support efficient traversal of non-linked structures.
 * 
 * Implement:
 *   - head/tail, iterator or both
 *   
 * Semantics:
 *   - tail returns further elements or null 
 */
public interface Seq<T> extends Iterable<T>
    {
        T head();

        Seq<T> tail();
    }
