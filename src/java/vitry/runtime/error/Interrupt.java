package vitry.runtime.error;

public class Interrupt extends VitryError
{
    public Interrupt() {
        super("Interrupted");
    }
    
    private static final long serialVersionUID = 2052449159646281219L;
}
