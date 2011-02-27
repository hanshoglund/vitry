package vitry.runtime.struct;


public class MemoizedSeq<T> extends AbstractSeq<T>
{
    private final Seq<T> s;
    private T head;
    private Seq<T> tail;
    private boolean headed;
    private boolean tailed;

    public MemoizedSeq(Seq<T> s) {
        this.s = s;
    }

    public T head()
    {
        if (!this.headed) {
            this.head = s.head();
        }
        return this.head;
    }

    public Seq<T> tail()
    {
        if (!this.tailed) {
            this.tail = s.tail();
        }
        return this.tail;
    }

    public boolean hasTail()
    {
        if (this.tailed) {
            return this.tail != null;
        } else {
            return s.hasTail();
        }
    }
}
