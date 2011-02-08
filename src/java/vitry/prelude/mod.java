package vitry.prelude;

import java.math.BigInteger;

import vitry.runtime.BigRational;
import vitry.runtime.StandardFunction;

public class mod extends StandardFunction
    {
        
        public mod() {
            super(2);
        }
        

        public Object apply(Object a, Object b) {
            
            if (a instanceof BigRational) {
                if (b instanceof BigRational) 
                    return ((BigRational) a).intValue() % ((BigRational) b).intValue();

                else if (b instanceof Number) 
                    return ((BigRational) a).intValue() % (((Number) b).intValue());

                return throwArithmetic();
            }
            
            if (a instanceof BigInteger)  {
                if (b instanceof BigInteger)
                    return ((BigInteger) a).mod((BigInteger) b);

                // TODO
                return throwArithmetic();
            }
            
            if (a instanceof Double)      {
                if (b instanceof Number)
                    return ((Double) a) % ((Number) b).doubleValue();
                
                return throwArithmetic();
            }
            
            if (a instanceof Float)      {
                if (b instanceof Number)
                    return ((Float) a) % ((Number) b).floatValue();
                
                return throwArithmetic();
            }   
            
            return throwArithmetic();
        }
        
        
        <T> T throwArithmetic() {
            throw new ArithmeticException("Expected number type");
        }
    }