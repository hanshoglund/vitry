package vitry.primitive;

/**
 * The core environment defined by the current set of loaded modules, including
 * the "prelude" module. To be able to reload modules we use a stack of chained
 * classloaders, where the top element refers to this class.
 * 
 * Modules are loaded from source code files, or from precompiled class files.
 * Either way, the result is an instance of vitry.primitive.Function that
 * returns the module when called.
 * 
 * 
 * Mapping to Java names:
 * 
 * Module: 
 *   a.b -> a/b/$.class
 *   prelude -> prelude/$.class
 * 
 * Functions, types etc:
 *   prelude.main -> prelude/main.class
 *   prelude.nat -> prelude/nat.class
 * 
 * 
 * @author hans
 */
public class Runtime {
    

    // TODO implement a class loader...
}
