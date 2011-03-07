package vitry.prelude;

import static vitry.runtime.VitryRuntime.FALSE;
import static vitry.runtime.VitryRuntime.TRUE;

import java.math.BigInteger;

import vitry.runtime.BigRational;
import vitry.runtime.RestFunction;
import vitry.runtime.Symbol;
import vitry.runtime.error.TypeError;
import vitry.runtime.struct.Seq;
import vitry.runtime.struct.Seqs;


public class sub extends RestFunction
{

    public Object applyVar(Seq<?> args) {
        return applyVar(Seqs.toArray(args));
    }
    
    public Object applyVar(Object[] args) {
        switch (args.length) {
            case 1:
                return negate(args[0]);
            case 2:
                return BINARY.apply(args[0], args[1]);
            default:
                throw new IllegalArgumentException();
        }
    }
    
    private static final MathPrimitive BINARY = new MathPrimitive()
        {
            final Symbol withBool(Symbol x, Symbol y)
            {
                return x != y ? TRUE : FALSE;
            }

            final BigInteger withInt(BigInteger x, BigInteger y)
            {
                return x.subtract(y);
            }

            final BigRational withRat(BigRational x, BigRational y)
            {
                return x.subtract(y);
            }

            final Float withFloat(float x, float y)
            {
                return x - y;
            }

            final Double withDouble(double x, double y)
            {
                return x - y;
            }
        };

    private Object negate(Object x)
    {
        if (x instanceof BigRational)
            return ((BigRational) x).negate();
        if (x instanceof BigInteger)
            return ((BigInteger) x).negate();
        if (x instanceof Float)
            return ((Float) x).floatValue() * -1;
        if (x instanceof Double)
            return ((Double) x).doubleValue() * -1;
        throw new TypeError("Can not apply " + this + " to " + x);
    }


}