package vitry.primitive;

/**
 * Invariants:
 *  this.references(o) -> this.equals(o)
 *  
 * @author hans
 */
public interface Reference {
    
    public boolean references(Object v);
}
