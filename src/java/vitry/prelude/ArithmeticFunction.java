package vitry.prelude;

import vitry.runtime.StandardFunction;

public class ArithmeticFunction extends StandardFunction {

    public ArithmeticFunction(int i) {
        super(2);
    }
    
    
    // TODO factor out instance checks to here
    // Try to avoid call overhead
}