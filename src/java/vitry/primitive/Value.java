package vitry.primitive;

/**
 * Instances represent values in the Vitry language, including atoms, functions
 * and types.
 * 
 * 
 * Optimizations: 
 * - Flattening nested unions to a single level. 
 * - Removing structurally equivalent values, redirecting references to it. 
 * - Allthough the value tree is not allowed to change *conceptually* we will 
 * of course garbage collect every value that becomes non-reachable from 
 * user code.
 * 
 * @author hans
 */
public abstract class Value extends Node {

    @Override
    public boolean equals(Object o) {
        return false;
    }

    public boolean isTypeOf(Value v) {
        return false;
    }

    public boolean isType() {
        return false;
    }

    @Override
    public Symbol getLabel() {
        return null;
    }

    @Override
    public Value[] getChildren() {
        return null;
    }
}
