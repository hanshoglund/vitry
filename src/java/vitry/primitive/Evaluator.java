package vitry.primitive;

public interface Evaluator
    {
        public Value eval(Pattern e) throws Exception;
        
        public Value eval(Pattern e, Module[] link) throws Exception;

        public Value eval(Pattern e, ClassLoader link) throws Exception;
    }
