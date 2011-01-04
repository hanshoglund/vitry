package vitry.primitive.test;

import vitry.primitive.Pattern;
import vitry.primitive.PrimitiveType;
import vitry.primitive.PrimitiveValue;
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

            Pattern num = PrimitiveType.forClass(Number.class);
            Pattern str = PrimitiveType.forClass(String.class);
            Pattern bool = PrimitiveType.forClass(Boolean.class);

            out.println(PrimitiveValue.wrap("test").matchFor(str));
            out.println(PrimitiveValue.wrap(2).matchFor(num));
            out.println(PrimitiveValue.wrap(2.0).matchFor(num));
            out.println(PrimitiveValue.wrap(true).matchFor(bool));

        }

    }
