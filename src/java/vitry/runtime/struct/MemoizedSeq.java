package vitry.runtime.struct;

import vitry.runtime.misc.Checks;


public class MemoizedSeq<T> extends AbstractSeq<T>
{
    private final Seq<T> s;
    private T head;
    private Seq<T> tail;
    private boolean headed;
    private boolean tailed;

    public MemoizedSeq(Seq<T> s) {
        Checks.checkNotNull(s);
        this.s = s;
    }

    public T head()
    {
        if (!this.headed)
        {
            this.head = s.head();
        }
        return this.head;
    }

    public Seq<T> tail()
    {
        if (!this.tailed)
        {
            this.tail = s.tail();
        }
        return this.tail;
    }

    public boolean hasTail()
    {
        if (this.tailed)
        {
            return !Seqs.isNil(this.tail);
        }
        else
        {
            return s.hasTail();
        }
    }
}
