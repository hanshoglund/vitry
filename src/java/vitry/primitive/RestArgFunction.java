package vitry.primitive;

/**
 * Invariants:
 *   Whenever a RestArgFunction f is called with N arguments:
 *           if  N < f.arity,  then a partial application is returned
 *           if  N = f.arity,  then f(a1,a2..a[N]) is returned
 *           if  N > f.arity,  then f(a1,a2..a[f.arity], rest) is returned, 
 *              where rest is an array containing a[f.arity]...a[N]
 */
abstract public class RestArgFunction extends Function
    {
        
        public Object apply(Object a0) throws Exception {
            switch (arity) {
                case 1:
                    throw new NoImplementationException();

                default:
                    return new PartialApplication(this, a0);
            }
        }

        public Object apply(Object a0, Object a1) throws Exception {

            switch (arity) {
                case 1:
                    return apply(a0, new Object[]{ a1 });
                case 2:
                    throw new NoImplementationException();

                default:
                    return new PartialApplication(this, a0, a1);
            }
        }

        public Object apply(Object a0, Object a1, Object a2) throws Exception {

            switch (arity) {
                case 1:
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
                case 1:
                    return ((Function) this.apply(a0)).apply(a1, a2, a3);
                case 2:
                    return ((Function) this.apply(a0, a1)).apply(a2, a3);
                case 3:
                    return ((Function) this.apply(a0, a1, a2)).apply(a3);
                case 4:
                    throw new NoImplementationException();

                default:
                    return new PartialApplication(this, a0, a1, a2, a3);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4)
                throws Exception {

            switch (arity) {
                case 1:
                    return ((Function) this.apply(a0)).apply(a1, a2, a3, a4);
                case 2:
                    return ((Function) this.apply(a0, a1)).apply(a2, a3, a4);
                case 3:
                    return ((Function) this.apply(a0, a1, a2)).apply(a3, a4);
                case 4:
                    return ((Function) this.apply(a0, a1, a2, a3)).apply(a4);
                case 5:
                    throw new NoImplementationException();

                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5)
                throws Exception {

            switch (arity) {
                case 1:
                    return ((Function) this.apply(a0)).apply(a1, a2, a3, a4, a5);
                case 2:
                    return ((Function) this.apply(a0, a1)).apply(a2, a3, a4, a5);
                case 3:
                    return ((Function) this.apply(a0, a1, a2)).apply(a3, a4, a5);
                case 4:
                    return ((Function) this.apply(a0, a1, a2, a3)).apply(a4, a5);
                case 5:
                    return ((Function) this.apply(a0, a1, a2, a3, a4)).apply(a5);
                case 6:
                    throw new NoImplementationException();

                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5,
                Object a6) throws Exception {

            switch (arity) {
                case 1:
                    return ((Function) this.apply(a0)).apply(a1, a2, a3, a4, a5, a6);
                case 2:
                    return ((Function) this.apply(a0, a1)).apply(a2, a3, a4, a5, a6);
                case 3:
                    return ((Function) this.apply(a0, a1, a2)).apply(a3, a4, a5, a6);
                case 4:
                    return ((Function) this.apply(a0, a1, a2, a3)).apply(a4, a5, a6);
                case 5:
                    return ((Function) this.apply(a0, a1, a2, a3, a4)).apply(a5, a6);
                case 6:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5)).apply(a6);
                case 7:
                    throw new NoImplementationException();

                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5, a6);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5,
                Object a6, Object a7) throws Exception {

            switch (arity) {
                case 1:
                    return ((Function) this.apply(a0)).apply(a1, a2, a3, a4, a5, a6, a7);
                case 2:
                    return ((Function) this.apply(a0, a1)).apply(a2, a3, a4, a5, a6, a7);
                case 3:
                    return ((Function) this.apply(a0, a1, a2)).apply(a3, a4, a5, a6, a7);
                case 4:
                    return ((Function) this.apply(a0, a1, a2, a3)).apply(a4, a5, a6, a7);
                case 5:
                    return ((Function) this.apply(a0, a1, a2, a3, a4)).apply(a5, a6, a7);
                case 6:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5)).apply(a6, a7);
                case 7:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5, a6)).apply(a7);
                case 8:
                    throw new NoImplementationException();

                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5, a6, a7);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5,
                Object a6, Object a7, Object a8) throws Exception {

            switch (arity) {
                case 1:
                    return ((Function) this.apply(a0)).apply(a1, a2, a3, a4, a5, a6, a7, a8);
                case 2:
                    return ((Function) this.apply(a0, a1)).apply(a2, a3, a4, a5, a6, a7, a8);
                case 3:
                    return ((Function) this.apply(a0, a1, a2)).apply(a3, a4, a5, a6, a7, a8);
                case 4:
                    return ((Function) this.apply(a0, a1, a2, a3)).apply(a4, a5, a6, a7, a8);
                case 5:
                    return ((Function) this.apply(a0, a1, a2, a3, a4)).apply(a5, a6, a7, a8);
                case 6:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5)).apply(a6, a7, a8);
                case 7:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5, a6)).apply(a7, a8);
                case 8:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5, a6, a7)).apply(a8);
                case 9:
                    throw new NoImplementationException();

                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5, a6, a7, a8);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5,
                Object a6, Object a7, Object a8, Object a9) throws Exception {

            switch (arity) {
                case 1:
                    return ((Function) this.apply(a0)).apply(a1, a2, a3, a4, a5, a6, a7, a8,
                            a9);
                case 2:
                    return ((Function) this.apply(a0, a1)).apply(a2, a3, a4, a5, a6, a7, a8,
                            a9);
                case 3:
                    return ((Function) this.apply(a0, a1, a2)).apply(a3, a4, a5, a6, a7, a8,
                            a9);
                case 4:
                    return ((Function) this.apply(a0, a1, a2, a3)).apply(a4, a5, a6, a7, a8,
                            a9);
                case 5:
                    return ((Function) this.apply(a0, a1, a2, a3, a4)).apply(a5, a6, a7, a8,
                            a9);
                case 6:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5)).apply(a6, a7, a8,
                            a9);
                case 7:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5, a6)).apply(a7, a8,
                            a9);
                case 8:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5, a6, a7)).apply(a8,
                            a9);
                case 9:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8))
                            .apply(a9);
                case 10:
                    throw new NoImplementationException();

                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5, a6, a7, a8, a9);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5,
                Object a6, Object a7, Object a8, Object a9, Object a10) throws Exception {

            switch (arity) {
                case 1:
                    return ((Function) this.apply(a0)).apply(a1, a2, a3, a4, a5, a6, a7, a8,
                            a9, a10);
                case 2:
                    return ((Function) this.apply(a0, a1)).apply(a2, a3, a4, a5, a6, a7, a8,
                            a9, a10);
                case 3:
                    return ((Function) this.apply(a0, a1, a2)).apply(a3, a4, a5, a6, a7, a8,
                            a9, a10);
                case 4:
                    return ((Function) this.apply(a0, a1, a2, a3)).apply(a4, a5, a6, a7, a8,
                            a9, a10);
                case 5:
                    return ((Function) this.apply(a0, a1, a2, a3, a4)).apply(a5, a6, a7, a8,
                            a9, a10);
                case 6:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5)).apply(a6, a7, a8,
                            a9, a10);
                case 7:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5, a6)).apply(a7, a8,
                            a9, a10);
                case 8:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5, a6, a7)).apply(a8,
                            a9, a10);
                case 9:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8)).apply(
                            a9, a10);
                case 10:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9))
                            .apply(a10);
                case 11:
                    throw new NoImplementationException();

                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5, a6, a7, a8,
                            a9, a10);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5,
                Object a6, Object a7, Object a8, Object a9, Object a10, Object a11)
                throws Exception {

            switch (arity) {
                case 1:
                    return ((Function) this.apply(a0)).apply(a1, a2, a3, a4, a5, a6, a7, a8,
                            a9, a10, a11);
                case 2:
                    return ((Function) this.apply(a0, a1)).apply(a2, a3, a4, a5, a6, a7, a8,
                            a9, a10, a11);
                case 3:
                    return ((Function) this.apply(a0, a1, a2)).apply(a3, a4, a5, a6, a7, a8,
                            a9, a10, a11);
                case 4:
                    return ((Function) this.apply(a0, a1, a2, a3)).apply(a4, a5, a6, a7, a8,
                            a9, a10, a11);
                case 5:
                    return ((Function) this.apply(a0, a1, a2, a3, a4)).apply(a5, a6, a7, a8,
                            a9, a10, a11);
                case 6:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5)).apply(a6, a7, a8,
                            a9, a10, a11);
                case 7:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5, a6)).apply(a7, a8,
                            a9, a10, a11);
                case 8:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5, a6, a7)).apply(a8,
                            a9, a10, a11);
                case 9:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8)).apply(
                            a9, a10, a11);
                case 10:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9))
                            .apply(a10, a11);
                case 11:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10))
                            .apply(a11);
                case 12:
                    throw new NoImplementationException();

                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5, a6, a7, a8,
                            a9, a10, a11);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5,
                Object a6, Object a7, Object a8, Object a9, Object a10, Object a11, Object a12)
                throws Exception {

            switch (arity) {
                case 1:
                    return ((Function) this.apply(a0)).apply(a1, a2, a3, a4, a5, a6, a7, a8,
                            a9, a10, a11, a12);
                case 2:
                    return ((Function) this.apply(a0, a1)).apply(a2, a3, a4, a5, a6, a7, a8,
                            a9, a10, a11, a12);
                case 3:
                    return ((Function) this.apply(a0, a1, a2)).apply(a3, a4, a5, a6, a7, a8,
                            a9, a10, a11, a12);
                case 4:
                    return ((Function) this.apply(a0, a1, a2, a3)).apply(a4, a5, a6, a7, a8,
                            a9, a10, a11, a12);
                case 5:
                    return ((Function) this.apply(a0, a1, a2, a3, a4)).apply(a5, a6, a7, a8,
                            a9, a10, a11, a12);
                case 6:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5)).apply(a6, a7, a8,
                            a9, a10, a11, a12);
                case 7:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5, a6)).apply(a7, a8,
                            a9, a10, a11, a12);
                case 8:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5, a6, a7)).apply(a8,
                            a9, a10, a11, a12);
                case 9:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8)).apply(
                            a9, a10, a11, a12);
                case 10:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9))
                            .apply(a10, a11, a12);
                case 11:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10))
                            .apply(a11, a12);
                case 12:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10,
                            a11)).apply(a12);
                case 13:
                    throw new NoImplementationException();

                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5, a6, a7, a8,
                            a9, a10, a11, a12);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5,
                Object a6, Object a7, Object a8, Object a9, Object a10, Object a11,
                Object a12, Object a13) throws Exception {

            switch (arity) {
                case 1:
                    return ((Function) this.apply(a0)).apply(a1, a2, a3, a4, a5, a6, a7, a8,
                            a9, a10, a11, a12, a13);
                case 2:
                    return ((Function) this.apply(a0, a1)).apply(a2, a3, a4, a5, a6, a7, a8,
                            a9, a10, a12, a13);
                case 3:
                    return ((Function) this.apply(a0, a1, a2)).apply(a3, a4, a5, a6, a7, a8,
                            a9, a10, a11, a12, a13);
                case 4:
                    return ((Function) this.apply(a0, a1, a2, a3)).apply(a4, a5, a6, a7, a8,
                            a9, a10, a11, a12, a13);
                case 5:
                    return ((Function) this.apply(a0, a1, a2, a3, a4)).apply(a5, a6, a7, a8,
                            a9, a10, a11, a12, a13);
                case 6:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5)).apply(a6, a7, a8,
                            a9, a10, a11, a12, a13);
                case 7:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5, a6)).apply(a7, a8,
                            a9, a10, a11, a12, a13);
                case 8:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5, a6, a7)).apply(a8,
                            a9, a10, a11, a12, a13);
                case 9:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8)).apply(
                            a9, a10, a11, a12, a13);
                case 10:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9))
                            .apply(a10, a11, a12, a13);
                case 11:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10))
                            .apply(a11, a12, a13);
                case 12:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10,
                            a11)).apply(a12, a13);
                case 13:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10,
                            a11, a12)).apply(a13);
                case 14:
                    throw new NoImplementationException();

                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5, a6, a7, a8,
                            a9, a10, a11, a12, a13);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5,
                Object a6, Object a7, Object a8, Object a9, Object a10, Object a11,
                Object a12, Object a13, Object a14) throws Exception {

            switch (arity) {
                case 1:
                    return ((Function) this.apply(a0)).apply(a1, a2, a3, a4, a5, a6, a7, a8,
                            a9, a10, a11, a12, a13, a14);
                case 2:
                    return ((Function) this.apply(a0, a1)).apply(a2, a3, a4, a5, a6, a7, a8,
                            a9, a10, a11, a12, a13, a14);
                case 3:
                    return ((Function) this.apply(a0, a1, a2)).apply(a3, a4, a5, a6, a7, a8,
                            a9, a10, a11, a12, a13, a14);
                case 4:
                    return ((Function) this.apply(a0, a1, a2, a3)).apply(a4, a5, a6, a7, a8,
                            a9, a10, a11, a12, a13, a14);
                case 5:
                    return ((Function) this.apply(a0, a1, a2, a3, a4)).apply(a5, a6, a7, a8,
                            a9, a10, a11, a12, a13, a14);
                case 6:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5)).apply(a6, a7, a8,
                            a9, a10, a11, a12, a13, a14);
                case 7:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5, a6)).apply(a7, a8,
                            a9, a10, a11, a12, a13, a14);
                case 8:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5, a6, a7)).apply(a8,
                            a9, a10, a11, a12, a13, a14);
                case 9:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8)).apply(
                            a9, a10, a11, a12, a13, a14);
                case 10:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9))
                            .apply(a10, a11, a12, a13, a14);
                case 11:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10))
                            .apply(a11, a12, a13, a14);
                case 12:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10,
                            a11)).apply(a12, a13, a14);
                case 13:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10,
                            a11, a12)).apply(a13, a14);
                case 14:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10,
                            a11, a12, a13)).apply(a14);

                case 15:
                    throw new NoImplementationException();

                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5, a6, a7, a8,
                            a9, a10, a11, a12, a13, a14);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5,
                Object a6, Object a7, Object a8, Object a9, Object a10, Object a11,
                Object a12, Object a13, Object a14, Object a15) throws Exception {

            switch (arity) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                    return apply(a0, new Object[]{ a1, a2, a3, a4, a5, a6, a7, a8, a9, a10,
                            a11, a12, a13, a14, a15 });
                case 16:
                    throw new NoImplementationException();

                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5, a6, a7, a8,
                            a9, a10, a11, a12, a13, a14, a15);

            }
        }

    }
