package vitry.runtime.struct;

import java.math.BigInteger;


public class Range extends AbstractSeq<BigInteger>
{
    private final BigInteger min;
    private final BigInteger max;

    public Range(BigInteger min, BigInteger max) {
        this.min = min;
        this.max = max;
    }

    public BigInteger head()
    {
        return min;
    }

    public Seq<BigInteger> tail()
    {
        if (!hasTail())
            return null;
        else
            return new Range(min.add(BigInteger.ONE), max);
    }

    public boolean hasTail()
    {
        return max.subtract(BigInteger.ONE).compareTo(min) > 0;
    }
}
