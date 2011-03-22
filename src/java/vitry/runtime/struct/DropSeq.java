package vitry.runtime.struct;



/**
 * Lazily drops n elements.
 */
public class DropSeq<T> extends AbstractSeq<T>
{
    private Seq<T> xs;
    private int n;

    public DropSeq(Seq<T> xs, int n) {
        this.xs = xs;
        this.n = n;
    }

    public T head()
    {
        if (n > 0) drop();
        return xs.head();
    }

    public Seq<T> tail()
    {
        if (n > 0) drop();
        return xs.tail();
    }

    private void drop()
    {
        for (; n > 0; n--)
        {
            if (!Seqs.isNil(this.xs))
                this.xs = this.xs.tail();
        }
    }

    public boolean isNil()
    {
        if (n > 0) drop();
        return Seqs.isNil(this.xs);
    }


}
