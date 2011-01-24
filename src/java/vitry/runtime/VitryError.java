package vitry.runtime;

/**
 * Abstract superclass of exceptions.
 */
@SuppressWarnings("serial")

/**
 * Indicates all language errors. We do not use checked exceptions for the
 * Vitry language.
 * 
 * The runtime classes may also throw general exceptions such as 
 * IllegalArgumentException and of course VirtualMachineErrors. These should
 * be considered bugs in the implementation.
 */
abstract public class VitryError extends RuntimeException
    {

        public VitryError(String string) {
            super(string);
        }

        /**
         * @param string
         * @param cause
         */
        public VitryError(String string, Throwable cause) {
            super(string, cause);
        }
    }
