package vitry.primitive;

/**
 * Includes product types and values.
 *
 * @author hans
 */
public class Product extends Value implements Reference {

    private Boolean cacheConcrete = null;
    
    // TODO hasValue, equals
    

    public boolean isConcrete(Value v) {
        if (cacheConcrete == null) cacheConcrete = _isConcrete(v);
        return cacheConcrete;
    }
    
    private boolean _isConcrete(Value v) {
        for (Value child : getChildren()) {
            if (!child.isConcrete()) return false;
        }
        return true;
    }
    
    public boolean references(Value v) {
        // TODO
        return false;
    }
}
