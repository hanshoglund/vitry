package vitry.primitive;

/**
 * Invariants:
 *   Whenever a RestArgFunction f is called with N arguments:
 *           if  N < f.arity,  then a partial application is returned
 *           if  N = f.arity,  then f(a1,a2..a[N]) is returned
 *           if  N > f.arity,  then f(a1,a2..a[f.arity], rest) is returned, 
 *              where rest is an array containing a[f.arity]...a[N]
 *   
 * This class is provided to make it possible to implement top-level
 * function polymorphism as match expressions. We want to rewrite something
 * like
 * 
 *   foo x:a      = M
 *   foo x:b, y:z = N
 * 
 * into
 *   foo = fn input
 *     match input
 *       (x:a)      (M)
 *       (x:b, y:c) (N)
 * 
 *              
 * TODO
 *  Add missing cases
 *  Use Vitry seq instead of JVM array?
 */
abstract public class RestArgFunction extends Function
    {

        public RestArgFunction(int arity, FunctionType type) {
            super(arity, type);
        }
        
        // No need to override apply(Object)

        public Object apply(Object a0, Object a1) throws Exception {

            switch (arity) {
                case 1:
                    return apply(new Object[]{ a0, a1 });
                case 2:
                    throw new NoImplementationException();
                default:
                    return new PartialApplication(this, a0, a1);
            }
        }

        public Object apply(Object a0, Object a1, Object a2) throws Exception {

            switch (arity) {
                case 1:
                    return apply(new Object[]{ a0, a1, a2 });
                case 2:
                    return apply(a0, new Object[]{ a1, a2 });
                case 3:
                    throw new NoImplementationException();
                default:
                    return new PartialApplication(this, a0, a1, a2);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3) throws Exception {

            switch (arity) {

                case 4:
                    throw new NoImplementationException();
                default:
                    return new PartialApplication(this, a0, a1, a2, a3);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4) throws Exception {

            switch (arity) {

                case 5:
                    throw new NoImplementationException();
                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5) throws Exception {

            switch (arity) {

                case 6:
                    throw new NoImplementationException();
                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5, Object a6) throws Exception {

            switch (arity) {


                case 7:
                    throw new NoImplementationException();
                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5, a6);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5, Object a6, Object a7) throws Exception {

            switch (arity) {


                case 8:
                    throw new NoImplementationException();

                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5, a6, a7);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5, Object a6, Object a7, Object a8) throws Exception {

            switch (arity) {


                case 9:
                    throw new NoImplementationException();
                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5, a6, a7, a8);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5, Object a6, Object a7, Object a8, Object a9) throws Exception {

            switch (arity) {


                case 10:
                    throw new NoImplementationException();

                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5, a6, a7, a8, a9);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5, Object a6, Object a7, Object a8, Object a9, Object a10) throws Exception {

            switch (arity) {


                case 11:
                    throw new NoImplementationException();
                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5, Object a6, Object a7, Object a8, Object a9, Object a10, Object a11) throws Exception {

            switch (arity) {


                case 12:
                    throw new NoImplementationException();
                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5, Object a6, Object a7, Object a8, Object a9, Object a10, Object a11, Object a12) throws Exception {

            switch (arity) {


                case 13:
                    throw new NoImplementationException();
                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5, Object a6, Object a7, Object a8, Object a9, Object a10, Object a11, Object a12, Object a13) throws Exception {

            switch (arity) {


                case 14:
                    throw new NoImplementationException();
                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5, Object a6, Object a7, Object a8, Object a9, Object a10, Object a11, Object a12, Object a13, Object a14) throws Exception {

            switch (arity) {


                case 15:
                    throw new NoImplementationException();
                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5, Object a6, Object a7, Object a8, Object a9, Object a10, Object a11, Object a12, Object a13, Object a14, Object a15) throws Exception {

            switch (arity) {
                case 1:
                    return apply(new Object[]{ a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15 });
                case 2:
                    return apply(a0, new Object[]{ a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15 });
                case 3:
                    return apply(a0, a1, new Object[]{ a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15 });
                case 4:
                    return apply(a0, a1, a2, new Object[]{ a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15 });
                case 5:
                    return apply(a0, a1, a2, a3, new Object[]{ a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15 });
                case 6:
                    return apply(a0, a1, a2, a3, a4, new Object[]{ a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15 });
                case 7:
                    return apply(a0, a1, a2, a3, a4, a5, new Object[]{ a6, a7, a8, a9, a10, a11, a12, a13, a14, a15 });
                case 8:
                    return apply(a0, a1, a2, a3, a4, a5, a6, new Object[]{ a7, a8, a9, a10, a11, a12, a13, a14, a15 });
                case 9:
                    return apply(a0, a1, a2, a3, a4, a5, a6, a7, new Object[]{ a8, a9, a10, a11, a12, a13, a14, a15 });
                case 10:
                    return apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, new Object[]{ a9, a10, a11, a12, a13, a14, a15 });
                case 11:
                    return apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, new Object[]{ a10, a11, a12, a13, a14, a15 });
                case 12:
                    return apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, new Object[]{ a11, a12, a13, a14, a15 });
                case 13:
                    return apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, new Object[]{ a12, a13, a14, a15 });
                case 14:
                    return apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, new Object[]{ a13, a14, a15 });
                case 15:
                    return apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, new Object[]{ a14, a15 });
                case 16:
                    throw new NoImplementationException();
                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15);

            }
        }

    }
