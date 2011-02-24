package vitry.runtime.launch;

import java.util.Arrays;

import vitry.runtime.struct.Seq;
import static vitry.runtime.struct.Seqs.*;
import static java.lang.System.out;


public class ArraysVsSeqs
    {

        public static void main(String[] args) {
            Object o = new Object();
            int n = 10000;

            Object[] oa = new Object[n];
            Arrays.fill(oa, o);

            Seq<Object> os = null;
            for (int i = 0; i < n; i++) {
                os = cons(o, os);
            }

            out.println(oa.length);
            out.println(length(os));

            Timer t = new Timer();
            t.start();
            System.arraycopy(oa, 0, new Object[n], 0, n-1);
            t.time();
            t.report("System.arraycopy");

            t.start();
            init(os);
            t.time();
            t.report("butLast");


        }

    }
