package vitry.prelude;

import java.math.BigInteger;

import vitry.runtime.BigRational;
import vitry.runtime.RestFunction;
import vitry.runtime.struct.Sequence;
import vitry.runtime.struct.Sequences;

public class sub extends RestFunction
    {
        
        public Object applyVar(Sequence<?> args) {
            return applyVar(Sequences.toArray(args));
        }
        
        public Object applyVar(Object[] args) {
            switch (args.length) {
                case 1:
                    return negate(args[0]);
                case 2:
                    return apply(args[0], args[1]);
                default:
                    throw new IllegalArgumentException();
            }
        }

        private Object negate(Object v) {
            if (v instanceof BigRational)
                return ((BigRational) v).negate();
            if (v instanceof BigInteger)
                return ((BigInteger) v).negate();
            if (v instanceof Float)
                return ((Float) v).floatValue() * -1;
            return throwArithmetic();
        }

        public Object apply(Object a, Object b) {
            
            if (a instanceof BigRational) {
                if (b instanceof BigRational) 
                    return ((BigRational) a).subtract((BigRational) b);

                else if (b instanceof Number) 
                    return ((BigRational) a).subtract(((Number) b).longValue());

                return throwArithmetic();
            }
            
            if (a instanceof BigInteger)  {
                if (b instanceof BigInteger)
                    return ((BigInteger) a).subtract((BigInteger) b);
                if (b instanceof Number)
                    return ((Number) a).doubleValue() - ((Number) b).doubleValue();

                // TODO
                return throwArithmetic();
            }
            
            if (a instanceof Double)      {
                if (b instanceof Number)
                    return ((Double) a) - ((Number) b).doubleValue();
                
                return throwArithmetic();
            }
            
            if (a instanceof Float)      {
                if (b instanceof Number)
                    return ((Float) a) - ((Number) b).floatValue();
                
                return throwArithmetic();
            }   
            
            return throwArithmetic();
        }
        
        
        <T> T throwArithmetic() {
            throw new ArithmeticException("Expected number type");
        }
    }