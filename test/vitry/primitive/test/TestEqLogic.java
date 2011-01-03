package vitry.primitive.test;

import vitry.primitive.Pattern;
import vitry.primitive.SimpleProduct;
import vitry.primitive.SimpleUnion;
import vitry.primitive.Symbol;
import vitry.primitive.Unit;
import vitry.primitive.Util;
import vitry.primitive.Value;
import static java.lang.System.out;

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
            out.println(a.matchFor(Util.union(a)));
        }
        

    }
