package vitry.primitive;

import java.util.Map;

/**
 * 
 * @author hans
 */
public abstract class Function extends Atom {

    private Function parent;
    
    private Map<Symbol, Value> scope;
    
    private FunctionType type;
    
    
    public abstract Value apply(Value n);
}
