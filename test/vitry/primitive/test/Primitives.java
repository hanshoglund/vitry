package vitry.primitive.test;

import vitry.primitive.Pattern;
import vitry.primitive.NativeType;
import vitry.primitive.Native;
import vitry.primitive.Value;
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
