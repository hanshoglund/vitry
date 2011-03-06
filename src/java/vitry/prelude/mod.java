package vitry.prelude;

import static vitry.runtime.VitryRuntime.FALSE;

import java.math.BigInteger;

import vitry.runtime.BigRational;
import vitry.runtime.Symbol;


public class mod extends MathPrimitive
{
    final Symbol withBool(Symbol x, Symbol y)
    {
        if (y == FALSE) throw new ArithmeticException("Divide by 0");
        return FALSE;
    }

    final BigInteger withInt(BigInteger x, BigInteger y)
    {
        if (y.equals(BigInteger.ZERO)) throw new ArithmeticException("Divide by 0");
        return x.mod(y);
    }

    final BigRational withRat(BigRational x, BigRational y)
    {
        return x.mod(y);
    }

    final Float withFloat(float x, float y)
    {
        return x % y;
    }

    final Double withDouble(double x, double y)
    {
        return x % y;
    }
}