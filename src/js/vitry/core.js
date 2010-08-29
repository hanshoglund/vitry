/*
 * Vitry, copyright (c) Hans Höglund 2010, see COPYING.txt for details
 */
/**
 * Core environment.
 *
 * @author Hans Höglund
 * @date 2010
 */
exports.add ( Type, Natural, Integer, Ratio, 
              version, versionString, main );

/*
 * Meta-information.
 */
var about = {
  name    : "Vitry",
  url     : "http://github.com/hanshoglund/Vitry",
  version : [0, 0, 2]
};

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
// Language extensions
        
Object.extend = function(to, from) {
  for (k in from) to[k] = from[k];
}

Object.clone = function(obj) {
  return Object.extend({}, obj);
}

Object.values = function(val) {
  return [v for each (v in val)];
}   


// Property utils

/*
Object.writable = function(val, property, status) {
  Object.defineProperty(val, property, { writable : status });
}

Object.enumerable = function(val, property, status) {
  Object.defineProperty(val, property, { enumerable : status });
}

Object.preventChanges = function(val, property) {
  Object.defineProperty(val, property, { configurable : false });
}

Object.prototype.writable = function(properties, status) {
  for each (property in [].concat(properties)) {
    Object.writable(this, property, status);
  }
}

Object.prototype.enumerable = function(properties, status) {
  for each (property in [].concat(properties)) {
    Object.enumerable(this, property, status);
  }
}                        

Object.prototype.preventChanges = function(properties) {
  for each (property in [].concat(properties)) {
    Object.preventChanges(this, property);
  }
}
*/

// Type checks

Object.isObject = function(val) {
  return (typeof val === "object") || (typeof val === "function");
}

Function.isFunction = function(val) {
  return (typeof val === "function") || (val.__proto__ === Function.prototype);
}

Boolean.isBoolean = function(val) {
  return (typeof val === "boolean");
}

Number.isNumber = function(val) {
  return (typeof val === "number");  
}

String.isString = function(val) {
  return (typeof val === "string");
}

Object.check = function(val) {
  if (!Object.isObject(val)) {
    throw TypeError("Type of " + val + " is not object");
  }
}

Array.check = function(val) {
  if (!Array.isArray(val)) {
    throw TypeError("Type of " + val + " is not array");
  }
}

Function.check = function(val) {
  if (!Function.isFunction(val)) {
    throw TypeError("Type of " + val + " is not function");
  }
}

Boolean.check = function(val) {
  if (!Boolean.isBoolean(val)) {
    throw TypeError("Type of " + val + " is not boolean");
  }
}

Number.check = function(val) {
  if (!Number.isNumber(val)) {
    throw TypeError("Type of " + val + " is not number");
  }
}

String.check = function(val) {
  if (!String.isString(val)) {
    throw TypeError("Type of " + val + " is not string");
  }
}

// Encapsulation

Object.defineProperties(Object, {
  extend : { enumerable : false },
  clone : { enumerable : false },
  values : { enumerable : false },
  isObject : { enumerable : false },
  check : { enumerable : false }
});

Object.defineProperties(Array, {
  check : { enumerable : false }
});

Object.defineProperties(Function, {
  check : { enumerable : false },
  isFunction : { enumerable : false }
});   

Object.defineProperties(Boolean, {
  check : { enumerable : false },
  isBoolean : { enumerable : false }
});

Object.defineProperties(Number, {
  check : { enumerable : false },
  isNumber : { enumerable : false }
});

Object.defineProperties(String, {
  check : { enumerable : false },
  isString : { enumerable : false }
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


function Natural(value) {
  // XXX ?
  var obj = (this instanceof Natural ? 
    this : 
    Object.create(Natural.prototype));
  return obj;
}

Natural.prototype = {
  
  add : function(n) {
    return Natural(this.valueOf + n);
  },
  
  subtract : function() {
    return Natural(this.valueOf - n);    
  },
  
  multiply : function() {
    return Natural(this.valueOf * n);    
  },
  
  divide : function() {
    return Natural(this.valueOf / n);    
  },
  
  modulo : function() {
    return Natural(this.valueOf % n);    
  },
  
  succ : function() {
    return this.valueOf + 1;    
  },
  
  op : function(op, n) {
    switch (op) {
      case("+"): return this.add(n);
      case("-"): return this.subtract(n);
      case("*"): return this.multiply(n);
      case("/"): return this.divide(n);
      case("%"): return this.modulo(n);
    }
  }
};


function Integer(value) {
 
  
  
}
Integer.prototype = Object.extend(new Natural(), {
});


function Ratio(nom, denom) {
  // TODO
}
Ratio.prototype = Object.extend(new Integer(), {
});


//======================================================================
// Interpreter

function main(args) {
  if (args.length > 0) {
    load.apply(null, args);

  } else {
    print(about.name + ", version " + versionString());
    print("See " + about.url)
    print("Starting JavaScript interpreter...");
          
    load("~/.vitry.js");
    repl(about.name + "> ");
  }
}

var visible = {
  require:require,
  vitry:vitry,
  version:version,
  versionString:versionString,
  show:show,
  help:help,
  load:load,
  quit:quit
};

function version() {
  return about.version;
}

function versionString() {
  return version().join(".");
}

function show(object) {
  for (k in (object || visible)) print("  " + k);
}

function help() {
  print("  show([val])  Displays all properties of the given object.");
  print("               If none is given, displays all top-level functions.");
  print("  help([val])  Displays help text about the given object.");
  print("               If none is given, displays this text.");
  print("  load()       Loads and interprets a file (as if it had been entered.");
  print("               in the console).");
  print("  quit()       Leaves Vitry.");
  print();
}      

function quit() {
  print("Leaving " + about.name + "...")
  Packages.java.lang.System.exit(0);
}     

function load(fileName) {
  if (arguments.length > 1) {
    for each (v in arguments) load(v);
    return null;
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
