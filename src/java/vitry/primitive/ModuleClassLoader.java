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
 * 
 *  To fully support reloading, we must guarantee that the unloaded class
 *  is actually not reachable, probably using references.
 */
public class ModuleClassLoader extends ClassLoader
  {

    public ModuleClassLoader( ) {
      // TODO pass extra paths etc
    }

    public synchronized Class<?> loadClass( String name, boolean resolve )
        throws ClassNotFoundException {

      boolean delegate = inDelegatedPackage(name);
      ClassNotFoundException ex = null;

      Class<?> c = findLoadedClass(name); // }
                                          // } TODO Are these redundant?
      if (c == null) c = findClass(name); // } 
      
      if (c == null && delegate)
        try {
          c = this.getParent().loadClass(name);          
        } catch (ClassNotFoundException e){
          ex = e;
        }
      
      if (c == null)
        try {
          c = new DefiningClassLoader().loadClass(name);
        } catch (ClassNotFoundException e) {}
      
      if (c == null)
        if (delegate)
          throw ex;  // Already checked parent
        else
          c = this.getParent().loadClass(name);
      
      assert(c != null);

      if (resolve)
        resolveClass(c);
      
      return c;
    }
    
    public synchronized void unloadClass( String name ) {
      // TODO how to check reachability?
      // We can use WeakReference, but this would give unusable error
      // messages
    }

    public synchronized Class<?> reloadClass( String name ) {
      // TODO see above
      return null;
    }

    protected Class<?> findClass( String name ) throws ClassNotFoundException {
      return classes.get(name);
    }

    static boolean inDelegatedPackage( String name ) {
      for (String prefix : DELEGATED_PREFICES) {
        if (name.startsWith(prefix)) return true;
      }
      return false;
    }

    static final String[]            DELEGATED_PREFICES = {
                                                         "java.",
                                                         "javax."
                                                         };


    // TODO should use persistent
    private final Map<String, Class> classes            = new HashMap<String, Class>();

    class DefiningClassLoader extends URLClassLoader
      {
        public DefiningClassLoader( ) {
          super(classPath.toArray(new URL[classPath.size()]), ModuleClassLoader.this);
        }

        private Class<?> theClass;

        public Class<?> getTheClass( String name ) throws ClassNotFoundException {
          if (theClass != null)
            throw new IllegalStateException("DefiningClassLoader has already been used.");
          theClass = super.findClass(name);
          classes.put(name, theClass);
          return theClass;
        }
      }

    static final List<URL> classPath = new LinkedList<URL>();
    static {
      String cpStr = System.getProperty("java.class.path");

      assert (cpStr != null);

      for (String pathStr : cpStr.split(File.pathSeparator)) {
        try {
          classPath.add(new File(pathStr).toURI().toURL());
        } catch (MalformedURLException e) {
          // TODO add fallback on systemCL, probably log
        }
      }
    }

    public static void main( String[] args ) throws Exception {
      //      URL vitry = new File("/Users/hans/Documents/Kod/java/workspaces/macbook/Vitry/bin").toURI().toURL();
      //      
      //      ClassLoader cl = new ModuleClassLoader(new URL[]{vitry}, null);
      //      System.out.println(ClassLoader.getSystemClassLoader());
      //      System.out.println(Thread.currentThread().getContextClassLoader());
      //      
      //      ClassLoader cl2 = new ModuleClassLoader(new URL[]{}, cl);
      //      
      //      System.out.println(cl.loadClass("vitry.primitive.Atom").getClassLoader());
      //      System.out.println(cl2.loadClass("vitry.primitive.Atom").getClassLoader());
      //      System.out.println(cl2.loadClass("vitry.primitive.Symbol").getClassLoader());
      //      System.out.println(cl.loadClass("vitry.primitive.Symbol").getClassLoader());
    }

  }
