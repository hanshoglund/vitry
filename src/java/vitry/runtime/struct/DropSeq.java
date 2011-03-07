package vitry.runtime.struct;

public class DropSeq<T> extends AbstractSeq<T>
{
    final Seq<T> xs;
    final int n;

    Seq<T> ys;
    boolean done;

    public DropSeq(Seq<T> xs, int n) {
        this.xs = xs;
        this.n = n;
    }

    public T head()
    {
        if (!done) drop();
        return ys.head();
    }

    public Seq<T> tail()
    {
        if (!done) drop();
        return ys.tail();
    }

    private void drop()
    {
        Seq<T> zs = xs;
        for (int i = 0; i < n; i++) {
            zs = zs.tail();
        }
        ys = zs;
    }

}
