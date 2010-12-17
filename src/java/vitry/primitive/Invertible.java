package vitry.primitive;


/**
 * Invariants:
 *   f(A) = B iff f.inverse(B) = A
 */
public interface Invertible<T>
    {

        T inverse();
    }