package vitry.primitive;

/**
 * 
 * @author hans
 */
public class Union extends Value {

    public boolean memberOf(Value v) {
        for (Value node : getChildren())
            if (node.memberOf(v))
                return true;
        return false;
    }
}
