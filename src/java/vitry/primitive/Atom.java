package vitry.primitive;

/**
 * Invariants:
 *  if A = B, then A matches B and B matches A, where A and B are atoms
 * 
 * @author hans
 */
public abstract class Atom extends Value {

    public boolean memberOf(Value v) {
        return equals(v);
    }
    
    public boolean isType() {
        return true;
    }
}
