/*
 * Vitry, copyright (c) Hans Höglund 2010, see COPYING.txt for details
 */

/**
 * Launcher script, bootstraps and calls vitry.core.main(args).
 *
 * Usage: java vitry.main [args]
 *
 * @author Hans Höglund
 * @date 2010
 */
var CLASSPATH = Packages;

var core = CLASSPATH.vitry.java.main.require("vitry/core", this);
core.main(arguments);