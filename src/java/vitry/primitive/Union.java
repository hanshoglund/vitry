package vitry.primitive;

/**
 * 
 * @author hans
 */
public class Union extends Value {

    public boolean isTypeOf(Value v) {
        for (Value node : getChildren())
            if (node.isTypeOf(v))
                return true;
        return false;
    }
}
