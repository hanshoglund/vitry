package vitry.prelude;

import static vitry.runtime.VitryRuntime.FALSE;
import static vitry.runtime.VitryRuntime.TRUE;

import java.math.BigInteger;

import vitry.runtime.BigRational;
import vitry.runtime.Symbol;


public class pow extends MathPrimitive
{
    final Symbol withBool(Symbol x, Symbol y)
    {
        return (x == FALSE && y == TRUE) ? FALSE : TRUE;
    }

    final BigInteger withInt(BigInteger x, BigInteger y)
    {
        // TODO
        return x.pow(y.intValue());
    }

    final BigRational withRat(BigRational x, BigRational y)
    {
        // TODO
        return x.power(y.intValue());
    }

    final Double withFloat(float x, float y)
    {
        return Math.pow(x, y);
    }

    final Double withDouble(double x, double y)
    {
        return Math.pow(x, y);
    }
}