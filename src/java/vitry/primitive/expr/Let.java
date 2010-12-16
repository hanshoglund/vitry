package vitry.primitive.expr;

import vitry.primitive.Expr;

/**
 *
 * @author hans
 */
public class Let extends Expr
  {
    public Assign[] assigns;
    public Expr     body;
  }
