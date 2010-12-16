package vitry.primitive;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Invariants:
 * - The method loadClass(S) is referentially transparent.
 * - If this class delegates loading of a class C to another loader L,
 *   then for any type T that is linked to by C, this.loadClass == L.loadClass(). 
 *   
 * Used to load modules. This class basically behaves like a persistent
 * collection, i.e. the unloadClass(S) and reloadClass(S) methods return a
 * new instance of ModuleClassLoader with the class represented by S removed.
 * 
 * TODO
 *   To actually un/reload a module, we have to make it unreachable, that
 *   is un/reload all modules that depend on it as well. We could attempt
 *   to track that here, or use information available in the modules themselves
 *   at RT level.
 */
@SuppressWarnings("rawtypes")
public class ModuleClassLoader extends ClassLoader
    {

        public ModuleClassLoader() {
            this.classes = new HashMap<String, Class>();
        }

        private ModuleClassLoader(Map<String, Class> classes) {
            this.classes = classes;
        }

        private List<URL> paths;
        
        {
            paths = new LinkedList<URL>();
            paths.addAll(JAVA_CLASS_PATH);
        }


        private Map<String, Class> classes;


        public synchronized Class<?> loadClass(String name, boolean resolve)
                throws ClassNotFoundException {

            boolean delegateEagerly = inDelegatedPackage(name);
            ClassNotFoundException ex = null;

            Class<?> theClass = findLoadedClass(name);

            if (theClass == null) {
                theClass = classes.get(name);
            }
            if (theClass == null && delegateEagerly) {
                try {
                    theClass = this.getParent().loadClass(name);
                } catch (ClassNotFoundException e) {
                    ex = e;
                }
            }
            if (theClass == null) {
                try {
                    theClass = new DefiningClassLoader().getTheClass(name);
                } catch (ClassNotFoundException e) {
                }
            }
            if (theClass == null) {
                if (delegateEagerly) throw ex; // Already checked parent
                else {
                    // Delegate, throws if none found
                    theClass = this.getParent().loadClass(name);
                }
            }
            assert (theClass != null);

            if (resolve)
                resolveClass(theClass);

            return theClass;
        }

        public synchronized ModuleClassLoader unloadClass(String name) {
            // TODO use persistent collection
            Map<String, Class> removed = new HashMap<String, Class>(classes);
            removed.remove(name);
            return new ModuleClassLoader(removed);
        }

        public synchronized ModuleClassLoader reloadClass(String name) {
            // TODO how to check reachability?
            // We can use WeakReference, but this would give unusable error
            // messages
            throw new UnsupportedOperationException();
        }

        public void addPath(String path) {
            addPath(new File(path));
        }
        
        public void addPath(File path) {
            try {
                addPath(path.toURI().toURL());
            } catch (MalformedURLException e) {
                // TODO
            }
        }
        
        public void addPath(URL path) {
            assert paths.add(path);
        }


        class DefiningClassLoader extends URLClassLoader
            {
                public DefiningClassLoader() {
                    super(ModuleClassLoader.this.getPathsArray(), ModuleClassLoader.this);
                }

                private Class<?> theClass;

                // This method will only be called once
                // Dependencies will delegate to the enclosing ModuleClassLoader
                public Class<?> getTheClass(String name) throws ClassNotFoundException {
                    if (theClass != null)
                        throw new IllegalStateException(
                                "A DefiningClassLoader is only meant to be used once.");
                    theClass = super.findClass(name);
                    classes.put(name, theClass);
                    return theClass;
                }
            }
        
        URL[] getPathsArray() {
            return paths.toArray(new URL[paths.size()]);
        }
        
        static boolean inDelegatedPackage(String name) {
            // TODO add when stable
            for (String prefix : DELEGATED_PREFICES) {
                if (name.startsWith(prefix)) return true;
            }
            return false;
        }

        static final String[]  DELEGATED_PREFICES = {
                                                  "java.",
                                                  "javax."
                                                  };


        static final List<URL> JAVA_CLASS_PATH = new LinkedList<URL>();
        static {
            String cpStr = System.getProperty("java.class.path");

            assert (cpStr != null);

            for (String pathStr : cpStr.split(File.pathSeparator)) {
                try {
                    JAVA_CLASS_PATH.add(new File(pathStr).toURI().toURL());
                } catch (MalformedURLException e) {
                    // TODO add fallback on systemCL, probably log
                }
            }
        }

        public static void main(String[] args) throws Exception {
            //            for (URL p : CLASS_PATH)
            //                System.out.println(p);

            ModuleClassLoader cl = new ModuleClassLoader();
            Class node = cl.loadClass("vitry.primitive.Node");
            Class value = cl.loadClass("vitry.primitive.Value");
            Class atom = cl.loadClass("vitry.primitive.Atom");

            System.out.println(node.getClassLoader());
            System.out.println(value.getClassLoader());
            System.out.println(atom.getClassLoader());
            System.out.println(node.isAssignableFrom(value));
            System.out.println(value.isAssignableFrom(atom));

            cl = cl.unloadClass("vitry.primitive.Node");
            cl = cl.unloadClass("vitry.primitive.Value");
            cl = cl.unloadClass("vitry.primitive.Atom");
            System.gc();
            
            node = cl.loadClass("vitry.primitive.Node");
            value = cl.loadClass("vitry.primitive.Value");
            atom = cl.loadClass("vitry.primitive.Atom");

            System.out.println(node.getClassLoader());
            System.out.println(value.getClassLoader());
            System.out.println(atom.getClassLoader());
            System.out.println(node.isAssignableFrom(value));
            System.out.println(value.isAssignableFrom(atom));
        }

    }
