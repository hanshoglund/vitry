package vitry.runtime.launch;

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
        System.out.println(msg + " took " + time + " ms");
    }
}