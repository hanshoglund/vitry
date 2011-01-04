package vitry.primitive;

import java.util.Iterator;


public class ListType extends AbstractUnion
    {
        final Pattern type;

        public ListType(Pattern type) {
            this.type = type;
        }

        public Pattern head() {
            return Unit.getInstance();
        }

        public Seq<Pattern> tail() {
            // TODO implement a proper lazy seq
            return new Seq<Pattern>()
                {

                    public Iterator<Pattern> iterator() {
                        return null;
                    }

                    public Pattern head() {
                        return new Cons(type);
                    }

                    public Seq<Pattern> tail() {
                        return null;
                    }
                };
        }

        public String toString() {
            return "[" + type + "]";
        }
    }


class Cons extends AbstractProduct
    {
        final Pattern type;

        public Cons(Pattern type) {
            this.type = type;
        }

        public Pattern head() {
            return type;
        }

        public Seq<Pattern> tail() {
            return new Seq<Pattern>()
                {
                    public Iterator<Pattern> iterator() {
                        return null;
                    }

                    public Pattern head() {
                        return new ListType(type);
                    }

                    public Seq<Pattern> tail() {
                        return null;
                    }
                };
        }
    }
