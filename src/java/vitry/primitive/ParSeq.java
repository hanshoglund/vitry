package vitry.primitive;

public interface ParSeq<T> extends Seq<T>
    {
        T get();
        ParSeq<T> left();
        ParSeq<T> right();
        ParSeq<T> conc(ParSeq<T> rest);
    }
