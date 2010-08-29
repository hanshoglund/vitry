/*
 * Vitry, copyright (c) Hans Höglund 2010, see COPYING.txt for details
 */
/**
 * Core environment.
 *
 * @author Hans Höglund
 * @date 2010
 */
exports.addAll = {
  Type    : Type,
  Integer : Integer,
  Ratio   : Ratio,
  version : version,
  versionString : versionString,
  main    : main
};

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
    version       : undefined,

    print         : print,
    Packages      : Packages,
    vitry         : {}
  }
);

var repl = require("vitry/repl");

// ======================================================================

var versionArray = [0, 0, 2];



//======================================================================
// Data types

function Type() {

  // Atom type
  if (arguments.length == 0) {
    let f = function(){ return f };
    return f;
  }

  // TODO
}


function Integer (value) {
  // TODO
}


function Ratio (nom, denom) {
  // TODO
}


//======================================================================
// Interpreter

function main(args) {
  if (args.length > 0) {
    // TODO load and execute files

  } else {
    print("Vitry, version " + versionString());
    print("See http://github.com/hanshoglund/Vitry")
    print("Starting JavaScript interpreter...");

    repl.repl("Vitry> ");
  }
}

function version() {
  return versionArray;
}

function versionString() {
  return version().join(".");
}

