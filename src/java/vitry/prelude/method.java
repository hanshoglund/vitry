package vitry.prelude;

import java.lang.reflect.Method;

import vitry.runtime.Function;
import vitry.runtime.StandardFunction;
import vitry.runtime.Symbol;
import vitry.runtime.VitryRuntime;
import vitry.runtime.error.InvocationError;
import vitry.runtime.error.ResolveError;
import vitry.runtime.struct.Sequence;
import vitry.runtime.struct.Sequences;


public class method extends StandardFunction
    {

        private static final Class<?>[] dummy = new Class<?>[0];

        private final VitryRuntime rt;
        private final Function string;

        public method(VitryRuntime rt) {
            super(3);
            this.rt = rt;
            this.string = (Function) rt.getPreludeValue("string");
        }

        /**
         * class, name:str, [types:str] -> (... -> a)
         * 
         * Returns a function wrapping a method.
         */
        public Object apply(Object c, Object n, Object t) throws InvocationError {
            Symbol clRef = (Symbol) c;
            Symbol name = (Symbol) n;
            Sequence<Symbol> types = (Sequence<Symbol>) t;

            try {
                Class<?> cl = rt.internClass(clRef);
                Class<?>[] clTypes = null;
                if (t != VitryRuntime.NIL)
                    clTypes = Sequences.toArray(types.<Class<?>> map(string), dummy);

                final Method m = cl.getMethod(name.toString(), clTypes);
//System.out.println(m);
                int arity = Sequences.length(types);
                
                switch (arity){
                    case 0:
                        return new StandardFunction(1){
                            public Object apply(Object t) throws InvocationError {
                                try {
                                    return m.invoke(t, (Object) null);
                                } catch (Exception e) {
                                    throw new InvocationError("Could not call method " + m + " for arguments " + t);
                                }
                            }                        
                        };
                        
//                    case 1:
//                        return new StandardFunction(2){
//                            public Object apply(Object t, Object a1) throws InvocationError {
//                                return m.invoke(t, a1);
//                            }                        
//                        };
                    case 2:
                    // etc
                    default:
                        throw new RuntimeException("Has not implemented reflection for arity > 5");
                }
                
                
            } catch (ClassNotFoundException e) {
                throw new ResolveError("Could not find class " + clRef);
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            return null;


        }
    }