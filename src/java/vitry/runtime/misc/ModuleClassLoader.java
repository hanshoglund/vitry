/*
 * Vitry, copyright (C) Hans Hoglund 2011
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * See COPYING.txt for details.
 */
package vitry.runtime.misc;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * Loads classes from the java class path and/or any specified path.
 *  
 *   - Delegates base packages by default
 *   - Delegates other classes if it can not find them
 *   - Loads each requested class separately along with its references
 *   - {@link #unloadClass} and {@link #reloadClass} works like a persistent collection
 *   - Unloaded classes may be reclaimed iff there are no external reference to them
 * 
 * Invariants:
 * 
 *   - The method loadClass(S) is referentially transparent.
 *   - If this class delegates loading of a class C to another loader L,
 *     then for any type T that is referenced by C, this.loadClass == L.loadClass(). 
 *   
 *   
 */
public class ModuleClassLoader extends ClassLoader
    {

        public ModuleClassLoader() {
            this.classes = new HashMap<String, Class<?>>();
        }

        public ModuleClassLoader(Map<String, Class<?>> classes) {
            this.classes = classes;
        }

        private final List<URL> paths;

        {
            paths = new LinkedList<URL>();
            paths.addAll(JAVA_CLASS_PATH);
        }


        private final Map<String, Class<?>> classes;


        public synchronized Class<?> loadClass(String name, boolean resolve)
                throws ClassNotFoundException {

            boolean delegateEagerly = moduleLoaderShouldDelegate(name);
            ClassNotFoundException ex = null;
            Class<?> c = findLoadedClass(name);

            if (c == null) c = classes.get(name);
            if (c == null && delegateEagerly) 
                try {
                    c = this.getParent().loadClass(name);
                } catch (ClassNotFoundException e) {
                    ex = e;
                }
            if (c == null) 
                try {
                    c = new DefiningClassLoader(getPathsArray()).loadClass(name, this);
                } catch (ClassNotFoundException e) {
            }
            if (c == null) {
                if (delegateEagerly) {
                    // Only reached if delegation failed
                    assert (ex != null);
                    throw ex;
                } else {
                    c = this.getParent().loadClass(name);
                }
            }

            if (resolve) resolveClass(c);
            return c;
        }

        public synchronized ModuleClassLoader unloadClass(String name) {
            // TODO use persistent collection
            Map<String, Class<?>> removed = new HashMap<String, Class<?>>(classes);
            removed.remove(name);
            return new ModuleClassLoader(removed);
        }

        public synchronized ModuleClassLoader reloadClass(String name)
                throws ClassNotFoundException {
            ModuleClassLoader mcl = this.unloadClass(name);
            mcl.loadClass(name);
            return mcl;
        }

        public void addPath(String path) {
            addPath(new File(path));
        }

        public void addPath(File path) {
            try {
                addPath(path.toURI().toURL());
            } catch (MalformedURLException e) {
                throw new RuntimeException("Could not translate file name to URL.", e);
            }
        }

        public void addPath(URL path) {
            assert paths.add(path);
        }


        static class DefiningClassLoader extends URLClassLoader
            {
                public DefiningClassLoader(URL[] paths) {
                    super(paths, null);
                }

                private ModuleClassLoader tempParent;

                public Class<?> loadClass(String name) throws ClassNotFoundException {

                    Class<?> c = findLoadedClass(name);

                    if (c == null) {
                        if (definingLoaderShouldDelegate(name)) c = tempParent.loadClass(name);
                        else
                            c = super.findClass(name);
                    }
                    return c;
                }

                public Class<?> loadClass(String name, ModuleClassLoader parent)
                        throws ClassNotFoundException {
                    // Store parent temporarily for recursive invocations by the JVM                    
                    tempParent = parent;
                    Class<?> c = loadClass(name);
                    tempParent.classes.put(name, c);

                    // Set it to null before return, to allow outdated instances 
                    // of ModuleClassLoader to be reclaimed.
                    tempParent = null;
                    return c;
                }
            }

        URL[] getPathsArray() {
            return paths.toArray(new URL[paths.size()]);
        }

        static boolean moduleLoaderShouldDelegate(String name) {
            for (String prefix : DEFINING_DELEGATES) {
                if (name.startsWith(prefix)) return true;
            }
            return false;
        }

        static boolean definingLoaderShouldDelegate(String name) {
            for (String prefix : DEFINING_DELEGATES) {
                if (name.startsWith(prefix)) return true;
            }
            return false;
        }


        static final String[] MODULE_DELEGATES = { "java.", "javax." };

        static final String[] DEFINING_DELEGATES = { "java.", "javax.", "vitry." };


        static final List<URL> JAVA_CLASS_PATH = new LinkedList<URL>();

        static {
            String cpStr = System.getProperty("java.class.path");

            assert (cpStr != null);

            for (String pathStr : cpStr.split(File.pathSeparator)) {
                try {
                    JAVA_CLASS_PATH.add(new File(pathStr).toURI().toURL());
                } catch (MalformedURLException e) {
                    // Ignore invalid paths
                }
            }
        }
    }
