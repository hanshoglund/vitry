package vitry.runtime.struct;

import java.math.BigInteger;


public class Range extends AbstractSeq<BigInteger>
{
    private final BigInteger min;
    private final BigInteger max;
    private final BigInteger last;

    public Range(BigInteger min, BigInteger max) {
        this.min = min;
        this.max = max;
        this.last = max.subtract(BigInteger.ONE);
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
        return last.compareTo(min) > 0;
    }
}
