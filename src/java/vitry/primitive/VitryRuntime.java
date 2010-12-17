package vitry.primitive;


/**
 * The core environment, defined by the current set of loaded modules.
 * Modules are loaded from source code files, or from precompiled class files.
 * Either way, the result is an instance of vitry.primitive.Function that
 * returns the module when called.
 * 
 * Mapping to Java names:
 * 
 * Module: a.b -> a/b/$.class prelude -> prelude/$.class
 * 
 * Functions, types etc: prelude.main -> prelude/main.class prelude.nat ->
 * prelude/nat.class
 * 
 * 
 * @author hans
 */
public class VitryRuntime
    {
        private static int anonymousFns = 0;

        static String getAnonymousFnName() {
            return "fn$" + (anonymousFns++);
        }

        private Evaluator         interpreter;

        private Compiler          compiler;

        private ModuleClassLoader modules;


        // Core

        static Type               top    = new Type()
                                     {

                                     };

        static Function           type;

        static Function           hasType;

        static Function           typeTag;

        static Function           equals = new Function()
                                     {
                                         public int arity() {
                                             return 2;
                                         }

                                         public FunctionType type() {
                                             return null; // TODO
                                         }

                                         public Object apply(
                                                 Object a0,
                                                 Object a1) {
                                             return null; // TODO
                                         }
                                     };

        static BijectiveFunction  compose;

        static BijectiveFunction  decompose;

        static Function           union;

        static Function           intersection;

        static Function           invoke;

        static Function           invokeInverse;

        static Function           eval;
    }
