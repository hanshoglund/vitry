package vitry.primitive;

/**
 * Includes product types and values.
 *
 * @author hans
 */
public class Product extends Value implements Reference {

    private short cacheConcrete = -1;
    
    public boolean equals(Object o) {
        return references(o);
    }
 
    public boolean isConcrete(Value v) {
        if (cacheConcrete < 0) cacheConcrete = _isConcrete(v);
        return cacheConcrete > 0;
    }
    
    private short _isConcrete(Value v) {
        for (Value child : getChildren()) {
            if (!child.isConcrete()) return 0;
        }
        return 1;
    }
    
    public boolean references(Object o) {
        Value[] children = getChildren();
        return children.length == 1 && children[0] == o;
    }
}
