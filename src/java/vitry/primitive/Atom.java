package vitry.primitive;

/**
 * Invariants:
 *  if A = B, then A matches B and B matches A, where A and B are atoms
 * 
 * @author hans
 */
public abstract class Atom extends Value {

    @Override
    public boolean memberOf(Value v) {
        return equals(v);
    }
    
    @Override
    public boolean isType() {
        return true;
    }
}
