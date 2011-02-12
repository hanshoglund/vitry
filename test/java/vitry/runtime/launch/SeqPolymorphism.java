package vitry.runtime.launch;

import static vitry.runtime.VitryRuntime.*;
import vitry.runtime.Function;
import vitry.runtime.Pattern;
import vitry.runtime.Product;
import vitry.runtime.Union;
import vitry.runtime.VitryRuntime;


public class SeqPolymorphism
    {

        private static final Function id = (Function) VitryRuntime.getPreludeValue("id");

        public static void main(String[] args) {

            Product a = null, b = null, c = null, d = null;

            a = productOf(1, 2, 3);
            
            
            b = a.mapProduct(id);
            pr(b);
            pr(b.getClass());
            
            
        }

        public static void pr(Object s) {
            System.out.println(s);
        }


    }
