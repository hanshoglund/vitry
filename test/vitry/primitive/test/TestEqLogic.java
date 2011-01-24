package vitry.primitive.test;

import static java.lang.System.out;
import vitry.runtime.Pattern;
import vitry.runtime.SimpleUnion;
import vitry.runtime.Symbol;
import vitry.runtime.misc.Utilities;
import vitry.runtime.struct.ArraySeq;

/**
 *
 */
public class TestEqLogic
    {

        /**
         * @param args
         */
        public static void main(String[] args) {
            
//            Value u = Unit.getInstance();
//            out.println(u);
//            out.println(new SimpleProduct(u, 1));
//
//            out.println(new SimpleProduct(1, 2, 3, 4));
//            out.println(new SimpleProduct(1, 2, 3, 4).equals(new SimpleProduct(1, 2, 3, 4)));
//            out.println(new SimpleProduct(1, 2, 3, 4).matchFor(new SimpleProduct(1, 2, 3)));
            
            Pattern a = Symbol.intern("a");
            Pattern b = Symbol.intern("b");
            
            out.println(a.matchFor(new SimpleUnion(a)));
            out.println(a.matchFor(Utilities.union(a)));
        }
        

    }
