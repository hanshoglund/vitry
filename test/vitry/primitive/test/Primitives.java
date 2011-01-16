package vitry.primitive.test;

import vitry.runtime.Native;
import vitry.runtime.NativeType;
import vitry.runtime.Pattern;
import vitry.runtime.Value;
import static java.lang.System.out;


/**
 *
 */
public class Primitives
    {

        /**
         * @param args
         */
        public static void main(String[] args) {

            Pattern num = NativeType.forClass(Number.class);
            Pattern str = NativeType.forClass(String.class);
            Pattern bool = NativeType.forClass(Boolean.class);

            out.println(Native.wrap("test").matchFor(str));
            out.println(Native.wrap(2).matchFor(num));
            out.println(Native.wrap(2.0).matchFor(num));
            out.println(Native.wrap(true).matchFor(bool));

        }

    }
