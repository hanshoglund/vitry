package vitry.primitive.expr;

import vitry.primitive.Expr;

/**
 *
 * @author hans
 */
public class Match extends Expr
  {
    public Left[] lefts;
    public Expr[] rights;
    public Expr   def;

  }
