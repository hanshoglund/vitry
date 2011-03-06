package vitry.prelude;

import java.math.BigInteger;

import vitry.runtime.BigRational;
import vitry.runtime.Native;
import vitry.runtime.RestFunction;
import vitry.runtime.struct.Seq;
import vitry.runtime.struct.Seqs;

public class sub extends RestFunction
    {
        
        public Object applyVar(Seq<?> args) {
            return applyVar(Seqs.toArray(args));
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

        private Object negate(Object a) {
//            a = Native.unwrap(a);
            
            if (a instanceof BigRational)
                return ((BigRational) a).negate();
            if (a instanceof BigInteger)
                return ((BigInteger) a).negate();
            if (a instanceof Float)
                return ((Float) a).floatValue() * -1;
            return throwArithmetic();
        }

        public Object apply(Object a, Object b) {
//            a = Native.unwrap(a);
//            b = Native.unwrap(b);
            
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