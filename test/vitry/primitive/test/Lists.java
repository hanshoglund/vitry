package vitry.primitive.test;

import static java.lang.System.out;
import vitry.primitive.ListType;
import vitry.primitive.Pattern;
import vitry.primitive.Symbol;
import vitry.primitive.Util;
import vitry.primitive.Vitry;


/**
 *
 */
public class Lists
    {

        /**
         * @param args
         */
        public static void main(String[] args) {

            Symbol a = Symbol.intern("a");
            Symbol b = Symbol.intern("b");
            
            Pattern l = new ListType(a);
            
            out.println(Vitry.unit.matchFor(l));
            out.println(Util.product(a, Vitry.unit.matchFor(l)));
          
            

        }

    }
