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

//        private Evaluator         interpreter;

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
                     Object a,
                     Object b) {
                 return a.equals(b);
             }
         };
         
         static Function           match = new Function()
         {
             public int arity() {
                 return 2;
             }
        
             public FunctionType type() {
                 return null; // TODO
             }
        
             public Object apply(
                     Object a,
                     Object b) {
                 if (b instanceof Pattern) {
                     if (a instanceof Pattern)
                         return ((Pattern) b).match((Pattern) a);
                     else
                         return ((Pattern) b).match(a);
                 } else {
                     return a.equals(b);
                 }
             }
         };



    }
