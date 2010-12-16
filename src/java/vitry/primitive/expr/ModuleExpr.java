package vitry.primitive.expr;

import vitry.primitive.Expr;

/**
 *
 */
public class ModuleExpr extends Expr
  {
    public String   name;
    public String[] imports;
    public Assign[] assigns;
  }
