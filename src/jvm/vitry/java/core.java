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

  public static Scriptable getSimpleRequire(Scriptable scope) {
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
          getScriptInClasspath("vitry/__header"),
          getScriptInClasspath("vitry/__footer"),
          false));
    } catch (Exception e) {
      return null;
    }
  }

  public static Script getScriptInClasspath(String id) {
    try {
      return (Script) Class.forName(id.replace("/", ".")).newInstance();
    } catch (Exception e) {
      return null;
    }
  }
}
