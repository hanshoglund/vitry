package vitry.primitive.test;

import static java.lang.System.out;
import vitry.runtime.ListType;
import vitry.runtime.Pattern;
import vitry.runtime.Symbol;
import vitry.runtime.Vitry;
import vitry.runtime.misc.MiscUtil;


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
            out.println(MiscUtil.product(a, Vitry.unit.matchFor(l)));
          
            

        }

    }
