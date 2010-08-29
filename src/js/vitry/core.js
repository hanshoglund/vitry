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
  version : version,
  
  Type    : Type,
  Integer : Integer,
  Ratio   : Ratio,
  
  main    : main
};    
  

// Core values

var version = [0, 0, 2];
              
var require = JAVA.coreRequire( 
  {                        
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
            
  

// Data types

function Type() {
  // TODO
}

function Integer () {
  // TODO
}

function Ratio () {
  // TODO
}




// Interpreter       

function main(args) { 
  if (args.length > 0) {
    // TODO

  } else {

    print("Vitry, version " + versionString());
    print("For more information see http://github.com/hanshoglund/Vitry")        
    print("Starting JavaScript interpreter");
    
    
  }
}

function show(object) {
   Object.keys(object || this).map(function(n) print(n));
}

function versionString() {
  return version.join(".");
}   

