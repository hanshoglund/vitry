/*
 * Vitry, copyright (c) Hans Höglund 2010, see COPYING.txt for details
 */
/**
 * Core environment.
 *
 * @author Hans Höglund
 * @date 2010
 */
exports.all = [ Type, Integer, Ratio, version, versionString, main ];

/*
 * Meta-information.
 */
var meta = Object.freeze({
  name    : "Vitry",
  url     : "http://github.com/hanshoglund/Vitry",
  version : [0, 0, 2]
});

/*
 * Canonical require function (used to load the rest of the environment).
 */ 
var require;

/*
 * Global providing simple access to the vitry modules
 * E.g. vitry.music is equivalent to require("vitry.music")
 */
var vitry;


vitry = Object.create(Object.prototype, {

  core    : { get : function() require("vitry/core") },
  music   : { get : function() require("vitry/music") },
  readers : { get : function() require("vitry/readers") },
  writers : { get : function() require("vitry/writers") }

});

require = Packages.vitry.java.core.getSimpleRequire({

// Needed by the current require implementation
//  Packages      : undefined,
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

  vitry         : vitry,
  print         : print
});


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
    print(meta.name + ", version " + versionString());
    print("See " + meta.url)
    print("Starting JavaScript interpreter...");
          
    load("~/.vitry.js");
    repl(meta.name + "> ");
  }
}

var visible = {
  require:require,
  vitry:vitry,
  show:show,
  help:help,
  load:load,
  quit:quit,
  version:version,
  versionString:versionString
};

function show(object) {
  for (k in (object || visible)) print("  " + k);
}

function help() {
  print("  show([obj])  Displays all properties of the given object.");
  print("               If none is given, displays all top-level functions.");
  print("  help([obj])  Displays help text about the given object.");
  print("               If none is given, displays this text.");
  print("  load()       Loads and interprets a file (as if it had been entered.");
  print("               in the console).");
  print("  quit()       Leaves Vitry.");
  print();
}      

function load(fileName) {
  if (arguments.length > 1) {
    for each (v in arguments) load(v);
  }
  if (fileName) {
    var file = fileName;
    file = file.replace("~", environment["user.home"]);  
    try {
      eval(readFile(file));
    } catch (e if e instanceof JavaException) {
      return null;
    }
  }
}

function quit() {
  print("Leaving " + meta.name + "...")
  Packages.java.lang.System.exit(0);
}

function version() {
  return meta.version;
}

function versionString() {
  return version().join(".");
}

function repl(prompt) {

  var consoleReader = new Packages.jline.ConsoleReader();
  var line;
  var res;

  // TODO auto completion

  print();

  while (true) {
    line = "" + consoleReader.readLine(prompt);
    try {
      res = eval(line);
      res === undefined || print(res);
    } catch (e) {
      print(e.constructor.name + ": " + e.message);
    }
  }
}
