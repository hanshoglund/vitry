package vitry.primitive.expr;

import vitry.primitive.Expr;

/**
 *
 * @author hans
 */
public class Where extends Expr
  {
    public Expr     body;
    public Assign[] assigns;
  }
