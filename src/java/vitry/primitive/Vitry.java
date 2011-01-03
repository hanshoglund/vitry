package vitry.primitive;

/**
 * The core runtime environment.
 * 
 * @author hans
 */
public class Vitry
    {

        /**
         * a = b
         */
        public static final Function equals = new Function()
           {
               public Object apply(Object a, Object b) {
//                   if (b instanceof Value) {
//                       return b.equals(a);
//                   } else {
//                       return a.equals(b);
//                   }
                   // TODO
                   return false;
               }

               public int arity() {
                   return 2;
               }

               public FunctionType type() {
                   throw new UnsupportedOperationException();
               }
           };

        /**
         * a : b
         */
        public static final Function match  = new Function()
           {
               public Object apply(Object a, Object b) {
//                   if (b instanceof Pattern) {
//                       if (a instanceof Pattern) {
//                           return ((Pattern) a).matchFor((Pattern) b);
//                       } else {
//                           return ((Pattern) b).match(a);
//                       }
//                   } else {
//                       if (b instanceof Value) {
//                           return b.equals(a);
//                       } else {
//                           return a.equals(b);
//                       }
//                   }
                   // TODO
                   return false;
               }

               public int arity() {
                   return 2;
               }

               public FunctionType type() {
                   throw new UnsupportedOperationException();
               }
           };


    }
