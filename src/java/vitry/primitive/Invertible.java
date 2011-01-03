package vitry.primitive;

/**
 * Invariants:
 *   f(A) = B <=> f.inverse(B) = A
 */
public interface Invertible<T>
    {
        T inverse();
    }