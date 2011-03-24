package vitry.runtime.util;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Pushes input from one stream to another.
 * 
 * @author Hans Hoglund
 */
public class Pusher
{
    private static enum PusherState
    {
        INIT,
        STARTED,
        STOPPED,
        STREAM_END
    }

    private final InputStream source;    
    private final OutputStream sink;
    private volatile PusherState state = PusherState.INIT;
    private PushThread thread = null;
    private Throwable exception = null;
    
    public Pusher(InputStream source, OutputStream sink) {
        this.source = source;
        this.sink = sink;
    }
    public Pusher(BufferedInputStream source, PrintStream sink) {
        this.source = source;
        this.sink = sink;
    }
    
    /**
     * Start pushing asynchronously.
     * @throws IllegalStateException if the end of stream has been reached.
     */
    public void start()
    {
        switch (state)
        {
            case INIT:
            case STOPPED:
                thread = new PushThread();
                thread.start();
                break;
            case STARTED:
                break;
            case STREAM_END:
                throw new IllegalStateException("Nothing more to push");
        }        
    }

    /**
     * Stop pushing.
     */
    public void stop()
    {
        switch (state)
        {
            case INIT:
            case STOPPED:
            case STREAM_END:
                break;
            case STARTED:
                thread.interrupt();
                break;
        }
    }

    
    /**
     * Whether the pusher completed normally.
     */
    public boolean isDone()
    {
        return state == PusherState.STREAM_END;
    }
    
    /**
     * If an exception has occured during push, return it, otherwise
     * return null.
     */
    public Throwable getException()
    {
        return exception;
    }
    
    private class PushThread extends Thread
    {
        public void run()
        {
            int chars;
            byte[] buffer = new byte[1024];
            try
            {
                while ((chars = source.read(buffer, 0, buffer.length)) > 0)
                {
                    sink.write(buffer, 0, chars);
                    
                    synchronized (this) {
                        // Wait for interrupt
                        this.wait(1);
                    }
                }
                // No more input
                sink.flush();
                state = PusherState.STREAM_END;
            }
            catch (InterruptedException e)
            {
                state = PusherState.STOPPED;
            }
            catch (IOException e)
            {
                exception = e;
            }
        }
    }
    
    
    public static void main(String[] args) {
        Pusher p = new Pusher(System.in, System.out);
        p.start();
    }
}
