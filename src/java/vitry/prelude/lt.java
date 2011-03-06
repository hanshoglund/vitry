package vitry.prelude;

import static vitry.runtime.VitryRuntime.FALSE;
import static vitry.runtime.VitryRuntime.TRUE;

import java.math.BigInteger;

import vitry.runtime.BigRational;
import vitry.runtime.Symbol;


public class lt extends MathPrimitive
{
    final Symbol withBool(Symbol x, Symbol y)
    {
        return (x == FALSE && y == TRUE) ? TRUE : FALSE;
    }

    final Symbol withInt(BigInteger x, BigInteger y)
    {
        return x.compareTo(y) < 0 ? TRUE : FALSE;
    }

    final Symbol withRat(BigRational x, BigRational y)
    {
        return x.compareTo(y) < 0 ? TRUE : FALSE;
    }

    final Symbol withFloat(float x, float y)
    {
        return x < y ? TRUE : FALSE;
    }

    final Symbol withDouble(double x, double y)
    {
        return x < y ? TRUE : FALSE;
    }
}