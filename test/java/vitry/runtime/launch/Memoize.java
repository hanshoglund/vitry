package vitry.runtime.launch;

import static java.lang.System.out;
import vitry.runtime.struct.AbstractSeq;
import vitry.runtime.struct.MemoizedSeq;
import vitry.runtime.struct.Seq;
import vitry.runtime.struct.Seqs;


public class Memoize
{

    static final class Foo extends AbstractSeq
    {
        public Object head()
        {
            return Math.round(Math.random() * 100.);
        }

        public Seq tail()
        {
            return new Foo();
        }
    }

    public static void main(String[] args)
    {
        Seq<Integer> s = new MemoizedSeq(new Foo());

        out.println(Seqs.first(s));
        out.println(Seqs.second(s));
        out.println(Seqs.third(s));

        out.println(Seqs.first(s));
        out.println(Seqs.second(s));
        out.println(Seqs.third(s));

        out.println(Seqs.first(s));
        out.println(Seqs.second(s));
        out.println(Seqs.third(s));

    }

}
