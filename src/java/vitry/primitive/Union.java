package vitry.primitive;

/**
 * 
 * @author hans
 */
public class Union extends Type {

    public boolean hasValue(Value v) {
        for (Value node : getChildren())
            if (node.hasValue(v))
                return true;
        return false;
    }
}
