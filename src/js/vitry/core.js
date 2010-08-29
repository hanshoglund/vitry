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
 * About sVitry
 */
var meta = {      
  name    : "Vitry",
  url     : "http://github.com/hanshoglund/Vitry",
  version : [0, 0, 2]
};

/*
 * Canonical require function (used to load the rest of the environment).
 */      
var req;

/*
 * Global providing simple access to the vitry modules
 * E.g. vitry.music is equivalent to require("vitry.music")
 */
var vitry;


vitry = Object.create(Object.prototype, {
  core    : { get : function() req("vitry/core") },
  music   : { get : function() req("vitry/music") },
  readers : { get : function() req("vitry/readers") },
  writers : { get : function() req("vitry/writers") }
});        

req = Packages.vitry.java.core.getSimpleRequire({
  Packages      : undefined,
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
  print         : print,
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

    repl(meta.name + "> ");
  }
}

//Visible

function version() {
  return meta.version;
}

function versionString() {
  return version().join(".");
}

function help() {
  print();
  print("  show()     Displays all objects and functions in the current scope");
  print();
}

function quit() {
  print("Leaving " + meta.name + "...")
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
