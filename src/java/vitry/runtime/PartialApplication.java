package vitry.runtime;

import vitry.runtime.misc.Utils;
import vitry.runtime.struct.Sequence;


class PartialApplication extends StandardFunction
    {

        /**
         * Original function.
         */
        private final StandardFunction original;

        /**
         * Provided arguments.
         */
        private final Object[] args;


        public PartialApplication(StandardFunction original, Object... args) {
            super(original.arity - args.length);
            this.original = original;
            this.args = args;

            assert (this.arity > 0);
        }

        public Object apply(Object a0) throws InvocationError {
            switch (arity) {
                case 1:
                    return original.applyVar(Utils.conc(args, a0));
                default:
                    return new PartialApplication(this, a0);
            }
        }

        public Object apply(Object a0, Object a1) throws InvocationError {

            switch (arity) {
                case 1:
                    return ((Function) this.apply(a0)).apply(a1);
                case 2:
                    return original.applyVar(Utils.conc(args, a0, a1));
                default:
                    return new PartialApplication(this, a0, a1);
            }
        }

        public Object apply(Object a0, Object a1, Object a2) throws InvocationError {

            switch (arity) {
                case 1:
                    return ((Function) this.apply(a0)).apply(a1, a2);
                case 2:
                    return ((Function) this.apply(a0, a1)).apply(a2);
                case 3:
                    return original.applyVar(Utils.conc(args, a0, a1, a2));
                default:
                    return new PartialApplication(this, a0, a1, a2);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3) throws InvocationError {

            switch (arity) {
                case 1:
                    return ((Function) this.apply(a0)).apply(a1, a2, a3);
                case 2:
                    return ((Function) this.apply(a0, a1)).apply(a2, a3);
                case 3:
                    return ((Function) this.apply(a0, a1, a2)).apply(a3);
                case 4:
                    return original.applyVar(Utils.conc(args, a0, a1, a2, a3));
                default:
                    return new PartialApplication(this, a0, a1, a2, a3);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4)
                throws InvocationError {

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
                    return original.applyVar(Utils.conc(args, a0, a1, a2, a3, a4));
                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5)
                throws InvocationError {

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
                    return original.applyVar(Utils.conc(args, a0, a1, a2, a3, a4, a5));
                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5,
                Object a6) throws InvocationError {

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
                    return original.applyVar(Utils.conc(args, a0, a1, a2, a3, a4, a5, a6));
                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5, a6);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5,
                Object a6, Object a7) throws InvocationError {

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
                    return original.applyVar(Utils.conc(args, a0, a1, a2, a3, a4, a5, a6, a7));

                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5, a6, a7);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5,
                Object a6, Object a7, Object a8) throws InvocationError {

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
                    return original.applyVar(Utils.conc(args, a0, a1, a2, a3, a4, a5, a6, a7,
                            a8));
                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5, a6, a7, a8);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5,
                Object a6, Object a7, Object a8, Object a9) throws InvocationError {

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
                    return original.applyVar(Utils.conc(args, a0, a1, a2, a3, a4, a5, a6, a7,
                            a8, a9));
                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5, a6, a7, a8, a9);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5,
                Object a6, Object a7, Object a8, Object a9, Object a10) throws InvocationError {

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
                    return original.applyVar(Utils.conc(args, a0, a1, a2, a3, a4, a5, a6, a7,
                            a8, a9, a10));
                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5, a6, a7, a8,
                            a9, a10);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5,
                Object a6, Object a7, Object a8, Object a9, Object a10, Object a11)
                throws InvocationError {

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
                    return original.applyVar(Utils.conc(args, a0, a1, a2, a3, a4, a5, a6, a7,
                            a8, a9, a10, a11));
                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5, a6, a7, a8,
                            a9, a10, a11);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5,
                Object a6, Object a7, Object a8, Object a9, Object a10, Object a11, Object a12)
                throws InvocationError {

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
                    return original.applyVar(Utils.conc(args, a0, a1, a2, a3, a4, a5, a6, a7,
                            a8, a9, a10, a11, a12));
                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5, a6, a7, a8,
                            a9, a10, a11, a12);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5,
                Object a6, Object a7, Object a8, Object a9, Object a10, Object a11,
                Object a12, Object a13) throws InvocationError {

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
                    return original.applyVar(Utils.conc(args, a0, a1, a2, a3, a4, a5, a6, a7,
                            a8, a9, a10, a11, a12, a13));
                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5, a6, a7, a8,
                            a9, a10, a11, a12, a13);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5,
                Object a6, Object a7, Object a8, Object a9, Object a10, Object a11,
                Object a12, Object a13, Object a14) throws InvocationError {

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
                    return original.applyVar(Utils.conc(args, a0, a1, a2, a3, a4, a5, a6, a7,
                            a8, a9, a10, a11, a12, a13, a14));
                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5, a6, a7, a8,
                            a9, a10, a11, a12, a13, a14);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5,
                Object a6, Object a7, Object a8, Object a9, Object a10, Object a11,
                Object a12, Object a13, Object a14, Object a15) throws InvocationError {

            switch (arity) {
                case 1:
                    return ((Function) this.apply(a0)).apply(a1, a2, a3, a4, a5, a6, a7, a8,
                            a9, a10, a11, a12, a13, a14, a15);
                case 2:
                    return ((Function) this.apply(a0, a1)).apply(a2, a3, a4, a5, a6, a7, a8,
                            a9, a10, a11, a12, a13, a14, a15);
                case 3:
                    return ((Function) this.apply(a0, a1, a2)).apply(a3, a4, a5, a6, a7, a8,
                            a9, a10, a11, a12, a13, a14, a15);
                case 4:
                    return ((Function) this.apply(a0, a1, a2, a3)).apply(a4, a5, a6, a7, a8,
                            a9, a10, a11, a12, a13, a14, a15);
                case 5:
                    return ((Function) this.apply(a0, a1, a2, a3, a4)).apply(a5, a6, a7, a8,
                            a9, a10, a11, a12, a13, a14, a15);
                case 6:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5)).apply(a6, a7, a8,
                            a9, a10, a11, a12, a13, a14, a15);
                case 7:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5, a6)).apply(a7, a8,
                            a9, a10, a11, a12, a13, a14, a15);
                case 8:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5, a6, a7)).apply(a8,
                            a9, a10, a11, a12, a13, a14, a15);
                case 9:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8)).apply(
                            a9, a10, a11, a12, a13, a14, a15);
                case 10:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9))
                            .apply(a10, a11, a12, a13, a14, a15);
                case 11:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10))
                            .apply(a11, a12, a13, a14, a15);
                case 12:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10,
                            a11)).apply(a12, a13, a14, a15);
                case 13:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10,
                            a11, a12)).apply(a13, a14, a15);
                case 14:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10,
                            a11, a12, a13)).apply(a14, a15);
                case 15:
                    return ((Function) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10,
                            a11, a12, a13, a14)).apply(a15);
                case 16:
                    return original.applyVar(Utils.conc(args, a0, a1, a2, a3, a4, a5, a6, a7,
                            a8, a9, a10, a11, a12, a13, a14, a15));
                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5, a6, a7, a8,
                            a9, a10, a11, a12, a13, a14, a15);
            }
        }

        public Pattern head() {
            return null;
            // TODO Auto-generated method stub
        }

        public Sequence<Pattern> tail() {
            return null;
            // TODO Auto-generated method stub
        }

        public boolean hasTail() {
            return false;
            // TODO Auto-generated method stub
        }

    }