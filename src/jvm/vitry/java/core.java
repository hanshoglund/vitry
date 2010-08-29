/*
 * Vitry, copyright (c) Hans Höglund 2010, see COPYING.txt for details
 */
package vitry.java;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Script;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.commonjs.module.ModuleScript;
import org.mozilla.javascript.commonjs.module.ModuleScriptProvider;
import org.mozilla.javascript.commonjs.module.Require;

public class core {

  private core(){}

  public static Scriptable coreRequire(Scriptable scope) {
    Context context = Context.enter();
    try {
      return (new Require(
          context,
          scope,
          // TODO
          (new ModuleScriptProvider(){
            public ModuleScript getModuleScript(
              Context context,
              String id,
              Scriptable paths)
            throws Exception {
              Script script = getScriptInClasspath(id);
              return new ModuleScript(script, null);
            }
          }),
          getScriptInClasspath("vitry/prelude"),
          null,
          false));
    } catch (Exception e) {
      return null;
    }
  }

  /**
   * Returns the module of the given id. This is resolved by simply searching
   * the classpath for a Java class of the given id, where slashes are replaced
   * by dots.
   *
   * @param id
   * @param scope
   * @return
   */
  public static Scriptable doBootstrapRequire(String id, Scriptable scope) {
    Context context = Context.enter();

    try {
      return
      (new Require(
          context,
          scope,
          (new ModuleScriptProvider(){
            public ModuleScript getModuleScript(
              Context context,
              String id,
              Scriptable paths)
            throws Exception {
              Script script = getScriptInClasspath(id);
              return new ModuleScript(script, null);
            }
          }),
          getScriptInClasspath("vitry/prelude"),
          null,
          false))
          .requireMain(context, id);
    } catch (Exception e) {
      return null;
    }
  }

  public static Script getScriptInClasspath(String id) {
    try {
      return (Script) Class.forName(id.replace("/", ".")).newInstance();
    } catch (Exception e) {
      throw new RuntimeException("Could not initialize.");
    }
  }
}