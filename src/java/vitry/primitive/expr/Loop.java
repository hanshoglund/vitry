package vitry.primitive.expr;

import vitry.primitive.Expr;

/**
 *
 * @author hans
 */
public class Loop extends Expr
{
    
    public Assign[] assigns;
    public Expr body;
}
