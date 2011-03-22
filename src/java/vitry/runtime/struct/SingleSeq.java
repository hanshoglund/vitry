package vitry.runtime.struct;

class SingleSeq<T> extends AbstractSeq<T> implements Finite<T>
{
    private final T obj;

    public SingleSeq(T obj) {
        this.obj = obj;
    }

    public T head()
    {
        return obj;
    }

    public Seq<T> tail()
    {
        return null;
    }

    public int length()
    {
        return 1;
    }

    public boolean hasTail()
    {
        return false;
    }
}