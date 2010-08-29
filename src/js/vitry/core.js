/*
 * Vitry, copyright (c) Hans Höglund 2010, see COPYING.txt for details
 */

/**
 * Core data structures.
 *
 * @author Hans Höglund
 * @date 2010
 */
exports.addAll = {
  main: main
};

var require = JAVA.coreRequire( 
  { 
    Packages      : undefined,
    java          : undefined,
    java          : undefined,
    environment   : undefined,
    history       : undefined,

    importPackage : undefined,
    importClass   : undefined,
    help          : undefined,
    defineClass   : undefined,
    deserialize   : undefined,
    gc            : undefined,
    load          : undefined,
    loadClass     : undefined,
//    print         : undefined,
    readFile      : undefined,
    readUrl       : undefined,
    runCommand    : undefined,
    seal          : undefined,
    serialize     : undefined,
    spawn         : undefined,
    sync          : undefined,
    quit          : undefined,
    version       : undefined
  });
  
require("vitry/music");      

function main(args) {
  print("Welcome " + args[0]);
}
