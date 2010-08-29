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

Packages.vitry.java.core.getSimpleRequire({
//  Packages      : undefined,
//  java          : undefined,
//  environment   : undefined,
//  history       : undefined,
//  importPackage : undefined,
//  importClass   : undefined,
//  help          : undefined,
//  defineClass   : undefined,
//  deserialize   : undefined,
//  gc            : undefined,
//  load          : undefined,
//  loadClass     : undefined,
//  print         : undefined,
//  readFile      : undefined,
//  readUrl       : undefined,
//  runCommand    : undefined,
//  seal          : undefined,
//  serialize     : undefined,
//  spawn         : undefined,
//  sync          : undefined,
//  quit          : undefined,
//  version       : undefined,
})
.apply(this, ["vitry/core"])
.main(arguments);