package vitry.primitive;

/**
 * 
 * @author hans
 */
public class UnionType extends Type {

    public boolean matches(Value v) {
        for (Value node : getChildren())
            if (node.matches(v))
                return true;
        return false;
    }
}
