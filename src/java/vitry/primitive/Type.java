package vitry.primitive;

/**
 *
 * @author hans
 */
public class Type extends Value {
    
    public boolean equals(Object o) {
        if (o instanceof Reference)
            return ((Reference) o).references(this);
        else
            return o == this;
    }
    
    // TODO enumerate
}
