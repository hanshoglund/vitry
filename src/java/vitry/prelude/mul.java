package vitry.prelude;

import static vitry.runtime.VitryRuntime.FALSE;
import static vitry.runtime.VitryRuntime.TRUE;

import java.math.BigInteger;

import vitry.runtime.BigRational;
import vitry.runtime.Symbol;


public class mul extends MathPrimitive
{
    final Symbol withBool(Symbol x, Symbol y)
    {
        return (x == TRUE && y == TRUE) ? TRUE : FALSE;
    }

    final BigInteger withInt(BigInteger x, BigInteger y)
    {
        return x.multiply(y);
    }

    final BigRational withRat(BigRational x, BigRational y)
    {
        return x.multiply(y);
    }

    final Float withFloat(float x, float y)
    {
        return x * y;
    }

    final Double withDouble(double x, double y)
    {
        return x * y;
    }
}