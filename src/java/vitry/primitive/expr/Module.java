package vitry.primitive.expr;

import vitry.primitive.Expr;

/**
 *
 */
public class Module extends Expr {
    
    public String name;
    public String[] imports;
    public Assign[] assigns;
}
