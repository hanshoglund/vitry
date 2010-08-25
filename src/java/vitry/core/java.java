package vitry.core;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Script;
import org.mozilla.javascript.Scriptable;

/**
 * Provides some Java hooks.
 *
 * @author Hans Höglund
 */
public class Java {

    private Java(){}

    public static Object executeScript(Script s, Context cx, Scriptable scope) {
	return s.exec(cx, scope);
    }

    public static Object newInstanceForName(String className) {
	try {
	    return Class.forName(className).newInstance();
	} catch (Exception e) {
	    return null;
	}
    }
}
