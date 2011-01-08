package vitry.primitive;


public class AbstractList extends AbstractProduct
    {
        public final Pattern type;
        
        protected AbstractList(Pattern type) {
            this.type = type;
        }

        public Pattern head() {
            return null;
        }

        public Seq<Pattern> tail() {
            return null;
        }

        public Product first() {
            return null;
            // TODO Auto-generated method stub
        }

        public Product second() {
            return null;
            // TODO Auto-generated method stub
        }
    }
