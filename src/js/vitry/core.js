/*
 * Vitry, copyright (c) Hans Höglund 2010, see COPYING.txt for details
 */
/**
 * Core environment.
 *
 * @author Hans Höglund
 * @date 2010
 */

var about = {
  name    : "Vitry",
  url     : "http://github.com/hanshoglund/Vitry",
  version : [0, 0, 2]
};

var require;

/*
 * Shortcut to the vitry modules
 */
var vitry = Object.create(Object.prototype, {
  core    : { get : function() require( "vitry/core"    ) },
  music   : { get : function() require( "vitry/music"   ) },
  readers : { get : function() require( "vitry/readers" ) },
  writers : { get : function() require( "vitry/writers" ) }
});

var java = Packages.vitry.java.core;

require = java.getSimpleRequire({
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


// Object

Object.extend = function(to, from) {
  for (k in from) to[k] = from[k];
  return to;
}

Object.clone = function(obj) {
  return Object.extend({}, obj);
}

Object.values = function(val) {
  return [v for each (v in val)];
}


/**
 * Updates writable status for the specified properties.
 *
 * @obj
 *  Object to modify.
 * @prop
 *  String property name OR
 *  Array property names OR
 *  Function property selector
 * @status
 *  Status to set
 */
Object.writable = function(obj, prop, status) {
  if (Function.isFunction(prop)) {
    Object.writable(obj, Object.keys(obj).filter(prop), status);

  } else if (Array.isArray(prop)) {
    prop.forEach(function(prop) Object.writable(obj, prop, status));

  } else {
    Object.defineProperty(obj, prop, { writable : status });
  }
}

/**
 * Updates enumerable status for the specified properties.
 *
 * @obj
 *  Object to modify.
 * @prop
 *  String property name OR
 *  Array property names OR
 *  Function property selector
 * @status
 *  Status to set
 */
Object.enumerable = function(obj, prop, status) {
  if (Function.isFunction(prop)) {
    Object.enumerable(obj, Object.keys(obj).filter(prop), status);

  } else if (Array.isArray(prop)) {
    prop.forEach(function(prop) Object.enumerable(obj, prop, status));

  } else {
    Object.defineProperty(obj, prop, { enumerable : status });
  }
}

/**
 * Makes the specified properties unconfigurable.
 *
 * @obj
 *  Object to modify.
 * @prop
 *  String property name OR
 *  Array property names OR
 *  Function property selector
 */
Object.preventChanges = function(obj, prop) {
  if (Function.isFunction(prop)) {
    Object.preventChanges(obj, Object.keys(obj).filter(prop));

  } else if (Array.isArray(prop)) {
    prop.forEach(function(prop) Object.preventChanges(obj, prop));

  } else {
    Object.defineProperty(obj, prop, { configurable : false });
  }
}


// Function

Function.constant = function(val) {
  return (function() val);
}

Function.identity = function() {
  return (function(val) val);
}

Function.curry = function() {
  // TODO
}

Function.uncurry = function() {
  // TODO
}

Function.compose = function() {
  // TODO
}

Function.sequence = function() {
  // TODO
}

Function.power = function() {
  // TODO
}

Function.flip = function() {
  // TODO
}



Function.and = function() {
  // TODO
}

Function.or = function() {
  // TODO
}

Function.not = function() {
  // TODO
}

Function.equalTo = function() {
  // TODO
}

Function.strictlyEqualTo = function() {
  // TODO
}

Function.greaterThan = function() {
  // TODO
}

Function.lessThan = function() {
  // TODO
}

Function.some = function() {
  // TODO
}

Function.all = function() {
  // TODO
}

Function.memberOf = function() {
  // TODO
}

Function.empty = function() {
  // TODO
}

Function.isNull = function() {
  // TODO
}

Function.isUndefined = function() {
  // TODO
}

Function.isNotNull = function() {
  // TODO
}

Function.isNotUndefined = function() {
  // TODO
}


/**
 * Binds an function owned by a construcor to its prototype.
 * @param ct
 * @param name
 */
Function.bindPrototype = function(ct, name) {
  var fn = ct[name];
  if (Function.check(ct) && Function.check(fn)) {
    ct.prototype[name] = (function() {
      var args = [this];
      Array.prototype.push.apply(args, arguments);
      return fn.apply(null, args);
    });
  }
}


// Type checks

Object.isObject = function(val) {
  return (typeof val === "object") || (typeof val === "function");
}

Function.isFunction = function(val) {
  return (typeof val === "function");
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
  return true;
}

Array.check = function(val) {
  if (!Array.isArray(val)) {
    throw TypeError("Type of " + val + " is not array");
  }
  return true;
}

Function.check = function(val) {
  if (!Function.isFunction(val)) {
    throw TypeError("Type of " + val + " is not function");
  }
  return true;
}

Boolean.check = function(val) {
  if (!Boolean.isBoolean(val)) {
    throw TypeError("Type of " + val + " is not boolean");
  }
  return true;
}

Number.check = function(val) {
  if (!Number.isNumber(val)) {
    throw TypeError("Type of " + val + " is not number");
  }
  return true;
}

String.check = function(val) {
  if (!String.isString(val)) {
    throw TypeError("Type of " + val + " is not string");
  }
  return true;
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


function Natural(value) {
  // XXX ?
//  var obj = (this instanceof Natural ?
//    this :
//    Object.create(Natural.prototype));
//  return obj;
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

var inStream = java.getIn();
var outStream = java.getOut();
var errStream = java.getErr();

function print(val) {
  if (val === undefined && arguments.length === 0) {
    return print("");
  }
  if (Function.isFunction(val)) {
    return print(val.toString())
  }
  if (Object.isObject(val)) {
    return print(JSON.stringify(val));
  }
  outStream.println("" + val);
}

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



//======================================================================

exports.add ( Natural, Integer, Ratio,
              version, versionString, main );
