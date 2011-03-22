package vitry.runtime.struct;


public class TakeSeq<T> extends AbstractSeq<T>
{
    private final Seq<T> xs;
    private final int n;

    public TakeSeq(Seq<T> xs, int n) {
        this.xs = xs;
        this.n = n;
    }

    public T head()
    {
        return xs.head();
    }

    public Seq<T> tail()
    {
        if (n > 1)
        {
            return new TakeSeq<T>(xs.tail(), n - 1);
        }
        else
        {
            return null;
        }
    }

    public boolean hasTail()
    {
        return n > 1 && xs.hasTail();
    }
    
    // TODO isNil
}
