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

public class main {

  private main(){}

  /**
   * Returns the given module, using the passed top-level scope.
   *
   * @param name
   * @param nativeScope
   * @return
   */
  public static Scriptable require(String id, Scriptable nativeScope) {
    Context context = Context.enter();
    Require require;

    try {
      require = new Require(
        context,
        nativeScope,
        (new ModuleScriptProvider(){
          public ModuleScript getModuleScript(Context context, String id, Scriptable paths)
          throws Exception {
            String className = id.replace("/", ".");
            Script script = (Script) Class.forName(className).newInstance();
            return new ModuleScript(script, null);
          }
        }),
        null,
        null,
        false);
    } catch (Exception e) {
      return null;
    }
    return require.requireMain(context, id);
  }
}
