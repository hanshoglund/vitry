package vitry.prelude;

import java.math.BigInteger;

import vitry.runtime.BigRational;
import vitry.runtime.StandardFunction;
import vitry.runtime.Symbol;
import vitry.runtime.VitryRuntime;
import vitry.runtime.error.InvocationError;
import vitry.runtime.error.TypeError;


abstract class MathPrimitive extends StandardFunction.Binary
{

    public final Object apply(Object x, Object y) throws InvocationError
    {
        if (x instanceof Symbol)
        {
            if (y instanceof Symbol)
                return withBool((Symbol) x, (Symbol) y);

            x = boolToInt((Symbol) x);
        }
        if (x instanceof BigInteger)
        {
            if (y instanceof Symbol)
                return withInt((BigInteger) x, boolToInt((Symbol) y));

            if (y instanceof BigInteger)
                return withInt((BigInteger) x, (BigInteger) y);

            x = intToRat((BigInteger) x);
        }
        if (x instanceof BigRational)
        {
            if (y instanceof Symbol)
                return withRat((BigRational) x, intToRat(boolToInt((Symbol) y)));

            if (y instanceof BigInteger)
                return withRat((BigRational) x, intToRat((BigInteger) y));

            if (y instanceof BigRational)
                return withRat((BigRational) x, (BigRational) y);
        }
        if (x instanceof Float)
        {
            if (y instanceof Float)
                return withFloat((Float) x, (Float) y);
            x = floatToDouble((Float) x);
        }
        if (x instanceof Double)
        {
            if (y instanceof Float)
                return withDouble((Double) x, (Double) y);
            if (y instanceof Double)
                return withDouble((Double) x, (Double) y);
        }
        throw new TypeError("Can not apply " + this + " to " + x + " and " + y);
    }

    abstract Object withBool(Symbol x, Symbol y);

    //    abstract BigInteger withNat(BigInteger x, BigInteger y);

    abstract Object withInt(BigInteger x, BigInteger y);

    abstract Object withRat(BigRational x, BigRational y);

    abstract Object withFloat(float x, float y);

    abstract Object withDouble(double x, double y);


    static final BigInteger boolToInt(Symbol x)
    {
        if (VitryRuntime.toPrimBool(x))
            return BigInteger.ONE;
        else
            return BigInteger.ZERO;
    }

    static final BigInteger natToInt(BigInteger x)
    {
        return x;
    }

    static final BigRational intToRat(BigInteger x)
    {
        return BigRational.valueOf(x);
    }

    static final BigInteger ratToInt(BigRational x)
    {
        if (x.isInteger())
            return x.bigIntegerValue();
        else
            throw new TypeError("Could not convert rat to nat");
    }

    static final Double floatToDouble(Float x)
    {
        return Double.valueOf(x);
    }

}
