/*
 * Vitry, copyright (c) Hans Höglund 2010, see COPYING.txt for details
 */

/**
 * Launcher script, bootstraps and calls vitry.core.main(args).
 * Usage: java vitry.main [args]
 *
 * @author Hans Höglund
 */
version(180);        

Packages.vitry.java.core
.doBootstrapRequire(
  "vitry/core", 
  {})
  .main(arguments);