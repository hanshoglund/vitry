package vitry.primitive;


/**
 * The core runtime environment.
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

        static Function           type;

        static Function           hasType;

        static Function           typeTag;

        static InvertibleFunction  compose;

        static InvertibleFunction  decompose;

        static Function           union;

        static Function           intersection;

        static Function           invoke;

        static Function           invokeInverse;

        static Function           eval;
    }
