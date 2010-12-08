package vitry.primitive;


/**
 * Subclassed by compiled and generated functions.
 * 
 * @author hans
 */
public abstract class Function extends Atom {

    public abstract FunctionType getType();
    
    public abstract Value apply(Value n);
}
