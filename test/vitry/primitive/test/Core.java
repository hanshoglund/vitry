package vitry.primitive.test;

import static java.lang.System.out;

import vitry.primitive.Symbol;
import vitry.primitive.Value;
import static vitry.primitive.Vitry.*;
import static vitry.primitive.Util.*;

/**
 *
 */
public class Core
    {

        /**
         * @param args
         * @throws Exception 
         */
        public static void main(String[] args) throws Exception {

            Value a = Symbol.intern("a");
            Value b = Symbol.intern("b");
            Value c = Symbol.intern("c");
            Value d = Symbol.intern("d");
            
            out.println(id);
            out.println(id);
            out.println(id.apply(union(a, b)));
          
            

        }

    }
