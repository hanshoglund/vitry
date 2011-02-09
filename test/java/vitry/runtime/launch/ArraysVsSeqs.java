package vitry.runtime.launch;

import java.util.Arrays;

import vitry.runtime.struct.Sequence;
import static vitry.runtime.struct.Sequences.*;
import static java.lang.System.out;


public class ArraysVsSeqs
    {

        public static void main(String[] args) {
            Object o = new Object();
            int n = 2000;

            Object[] oa = new Object[n];
            Arrays.fill(oa, o);

            Sequence<Object> os = null;
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


class Timer
    {
        long start = -1;

        public void start() {
            start = System.currentTimeMillis();
        }

        public long time() {
            long time = System.currentTimeMillis();
            if (start < 0) start = time;
            return time - start;
        }

        public void report(String msg) {
            long time = time();
            System.out.println(msg + " took " + time);
        }
    }
