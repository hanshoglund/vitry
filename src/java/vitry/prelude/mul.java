package vitry.prelude;

import java.math.BigInteger;

import vitry.runtime.BigRational;
import vitry.runtime.Native;
import vitry.runtime.StandardFunction;

public class mul extends StandardFunction
    {
        
        public mul() {
            super(2);
        }
        

        public Object apply(Object a, Object b) {
            a = Native.unwrap(a);
            b = Native.unwrap(b);
            
            if (a instanceof BigRational) {
                if (b instanceof BigRational) 
                    return ((BigRational) a).multiply((BigRational) b);

                else if (b instanceof Number) 
                    return ((BigRational) a).multiply(((Number) b).longValue());

                return throwArithmetic();
            }
            
            if (a instanceof BigInteger)  {
                if (b instanceof BigInteger)
                    return ((BigInteger) a).multiply((BigInteger) b);
                if (b instanceof Number)
                    return ((Number) a).doubleValue() * ((Number) b).doubleValue();

                // TODO
                return throwArithmetic();
            }
            
            if (a instanceof Double)      {
                if (b instanceof Number)
                    return ((Double) a) * ((Number) b).doubleValue();
                
                return throwArithmetic();
            }
            
            if (a instanceof Float)      {
                if (b instanceof Number)
                    return ((Float) a) * ((Number) b).floatValue();
                
                return throwArithmetic();
            }   
            
            return throwArithmetic();
        }
        
        
        <T> T throwArithmetic() {
            throw new ArithmeticException("Expected number type");
        }
    }