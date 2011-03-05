package vitry.prelude;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import vitry.runtime.*;
import vitry.runtime.error.*;
import vitry.runtime.misc.*;
import vitry.runtime.struct.*;


public final class method extends StandardFunction
{

    private static final Class<?>[] dummy = new Class<?>[0];

    private final VitryRuntime rt;

    public method(VitryRuntime rt, Scope prelude) {
        super(3, prelude);
        this.rt = rt;
    }

    /**
     * class, name:str, [types] -> (... -> a)
     * 
     * Returns a function wrapping a method.
     */
    public Object apply(Object r, Object n, Object t) throws InvocationError
    {
        Symbol className = Utils.maybeIntern(r);
        String methodName = n.toString();
        Seq<Symbol> typeNames = (Seq<Symbol>) t;
        final Method m;

        try
        {
            Class<?> clazz = rt.internClass(className);
            Class<?>[] types = null;
            if (typeNames != null)
            {
                types = Seqs.toArray(typeNames.<Class<?>> map(new StandardFunction.Unary()
                    {
                        public Object apply(Object n) throws InvocationError
                        {
                            try
                            {
                                return rt.internClass((Symbol) n);
                            }
                            catch (ClassNotFoundException _)
                            {
                            }
                            return throwResolveClass(n);
                        }
                    }), dummy);
            }

            m = clazz.getMethod(methodName, types);
            final int arity = types.length + (isStatic(m) ? 0 : 1);

//            System.err.println(m);

            switch (arity) {
                case 0:
                    return new StandardFunction(1) {
                        public Object apply(Object _) throws InvocationError
                        {
                            try
                            {
                                return m.invoke(null);
                            }
                            catch (Exception e)
                            {
                            }
                            return throwInvoke(m);
                        }
                    };
                case 1:
                    return new StandardFunction(1) {
                        public Object apply(Object a) throws InvocationError
                        {
                            a = Native.unwrap(a);
                            try
                            {
                                if (isStatic(m))
                                    return m.invoke(null, a);
                                else
                                    return m.invoke(a);
                            }
                            catch (Exception e)
                            {
                            }
                            return throwInvoke(m, a);
                        }
                    };
                case 2:
                    return new StandardFunction(2) {
                        public Object apply(Object a, Object b) throws InvocationError
                        {
                            a = Native.unwrap(a);
                            b = Native.unwrap(b);
                            try
                            {
                                if (isStatic(m))
                                    return m.invoke(null, a, b);
                                else
                                    return m.invoke(a, b);
                            }
                            catch (Exception e)
                            {
                            }
                            return throwInvoke(m, a);
                        }
                    };
                case 3:
                    return new StandardFunction(3) {
                        public Object apply(Object a, Object b, Object c) throws InvocationError
                        {
                            a = Native.unwrap(a);
                            b = Native.unwrap(b);
                            c = Native.unwrap(c);
                            try
                            {
                                if (isStatic(m))
                                    return m.invoke(null, a, b, c);
                                else
                                    return m.invoke(a, b, c);
                            }
                            catch (Exception e)
                            {
                            }
                            return throwInvoke(m, a);
                        }
                    };
                case 4:
                    return new StandardFunction(4) {
                        public Object apply(Object a, Object b, Object c, Object d) throws InvocationError
                        {
                            a = Native.unwrap(a);
                            b = Native.unwrap(b);
                            c = Native.unwrap(c);
                            d = Native.unwrap(d);
                            try
                            {
                                if (isStatic(m))
                                    return m.invoke(null, a, b, c, d);
                                else
                                    return m.invoke(a, b, c, d);
                            }
                            catch (Exception e)
                            {
                            }
                            return throwInvoke(m, a);
                        }
                    };
                case 5:
                    return new StandardFunction(5) {
                        public Object apply(Object a, Object b, Object c, Object d, Object e) throws InvocationError
                        {
                            a = Native.unwrap(a);
                            b = Native.unwrap(b);
                            c = Native.unwrap(c);
                            d = Native.unwrap(d);
                            e = Native.unwrap(e);
                            try
                            {
                                if (isStatic(m))
                                    return m.invoke(null, a, b, c, d, e);
                                else
                                    return m.invoke(a, b, c, d, e);
                            }
                            catch (Exception ex)
                            {
                            }
                            return throwInvoke(m, a);
                        }
                    };
                default:
                    throw new RuntimeException("Has not implemented reflection for arity > 5");
            }
        }
        catch (ClassNotFoundException e)
        {
            return throwResolveClass(className);
        }
        catch (SecurityException e)
        {
            return throwResolveMethod(methodName);
        }
        catch (NoSuchMethodException e)
        {
            return throwResolveMethod(methodName);
        }
    }

    boolean isStatic(final Method m)
    {
        return Modifier.isStatic(m.getModifiers());
    }
    
    

    <T> T throwInvoke(Method method)
    {
        throw new InvocationError("Could not call method " + method + " for no arguments");
    }

    <T> T throwInvoke(Method method, Object args) throws InvocationError
    {
        throw new InvocationError("Could not call method " + method + " for arguments " + args);
    }
    
    <T> T throwResolveMethod(Object name) throws ResolveError
    {
        throw new ResolveError("Could not find method " + name);
    }

    <T> T throwResolveClass(Object name) throws ResolveError
    {
        throw new ResolveError("Could not find class " + name);
    }
}