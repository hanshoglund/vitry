/*
 * Vitry, copyright (c) Hans Höglund 2010, see COPYING.txt for details
 */
/**
 * Core environment.
 *
 * @author Hans Höglund
 * @date 2010
 */
exports.all = [ Type, Integer, Ratio, version, versionString, main ]
      
var req;
var vitry;

vitry = Object.create(Object.prototype, {
  core    : { get : function() req("vitry/core") },
  music   : { get : function() req("vitry/music") },
  readers : { get : function() req("vitry/readers") },
  writers : { get : function() req("vitry/writers") }
});

req = Packages.vitry.java.core.coreRequire(
  {
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
    vitry         : vitry
  }
);


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

    repl("Vitry> ");
  }
}

//Visible

function version() {
  return versionArray;
}

function versionString() {
  return version().join(".");
}

function help() {
  print();
  print("   show()     Displays all objects and functions in the current scope");
  print();
}

function quit() {
  print("Leaving Vitry...")
  Packages.java.lang.System.exit(0);
}

function repl(prompt) {

  var consoleReader = new Packages.jline.ConsoleReader();
  var line;
  var res;

  var scope = {
    require:req,
    vitry:vitry,
    show:show,
    help:help,
    quit:quit,
    version:version,
    versionString:versionString
  };

  function show(object) {
    for (k in (object || scope)) print("  " + k);
  }

  // TODO auto completion

  print();

  while (true) {
    line = consoleReader.readLine(prompt);
    try {
      res = eval("" + line, scope);
      res === undefined || print(res);
    } catch (e) {
      print(e.constructor.name + ": " + e.message);
    }
  }
}
