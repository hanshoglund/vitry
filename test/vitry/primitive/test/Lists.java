package vitry.primitive.test;

import vitry.primitive.ListType;
import vitry.primitive.Pattern;
import vitry.primitive.PrimitiveType;
import vitry.primitive.PrimitiveValue;
import vitry.primitive.Symbol;
import vitry.primitive.Unit;
import vitry.primitive.Util;
import vitry.primitive.Value;
import static java.lang.System.out;


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
            
            out.println(Unit.getInstance().matchFor(l));
            out.println(Util.product(a, Unit.getInstance()).matchFor(l));
          
            

        }

    }
