/*
 * Vitry, copyright (c) Hans Höglund 2010, see COPYING.txt for details
 */
package vitry.java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Script;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.commonjs.module.ModuleScript;
import org.mozilla.javascript.commonjs.module.ModuleScriptProvider;
import org.mozilla.javascript.commonjs.module.Require;

public class core {

  private core(){}


  // Module system

  public static Scriptable getSimpleRequire(Scriptable scope) {
    Context context = Context.enter();
    try {
      return (new Require(context, scope,
          (new ModuleScriptProvider(){
            public ModuleScript getModuleScript(Context context, String id, Scriptable paths)
                throws Exception {
              Script script = getScriptInClasspath(id);
              return new ModuleScript(script, null);
            }
          }), getScriptInClasspath("vitry/header"), getScriptInClasspath("vitry/footer"), false));
    } catch (Exception e) {
      return null;
    }
  }


  // I/O primitives

  public static Script getScriptInClasspath(String id) {
    try {
      return (Script) Class.forName(id.replace("/", ".")).newInstance();
    } catch (Exception e) {
      return null;
    }
  }

  public static InputStream getIn() {
    return System.in;
  }

  public static PrintStream getOut() {
    return System.out;
  }

  public static PrintStream getErr() {
    return System.err;
  }


  public static BufferedReader getReader(String name) {
    try {
      return new BufferedReader(
        new InputStreamReader(
          new FileInputStream(new File(name))));
    } catch (IOException e) {
      throw new RuntimeException("Could read from " + name);
    }
  }

  public static PrintWriter getWriter(String name) {
    try {
      return new PrintWriter(
        new BufferedWriter(
          new OutputStreamWriter(
            new FileOutputStream(new File(name)))));
    } catch (IOException e) {
      throw new RuntimeException("Could write to " + name);
    }
  }

  // Other

  public static boolean isNative(Object obj) {
    return ! (obj instanceof Scriptable);
  }
}
