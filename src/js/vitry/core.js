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
   
var version = [0, 0, 2];
var site    = "http://github.com/hanshoglund/Vitry";
    
// Canonical require method
var require = JAVA.coreRequire( 
  {                        
    // Remove Rhino globals
    Packages      : undefined,
    java          : undefined,
    JAVA          : undefined,
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
    print         : undefined,
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
  
  
function show(object) {
   Object.keys(object || this).map(function(n) print(n));
}

function arrayToJavaList(array) {
  return new java.util.List({
     // TODO
  });
}

function javaListToArray(list) {
  Object.create(nulls, [
    // TODO
  ]);
}

function objectToJavaMap(obj) {
  return new java.util.Map({
     // TODO
  });
}

function javaMapToObject(map) {
  Object.create(nulls, [
    // TODO
  ]);
}    

function versionString() {
  return version.join(".");
}

function main(args) {
  print("Vitry, version " + versionString());
  print("For more information see " + site)        
  print("Starting JavaScript interpreter");
  
}
