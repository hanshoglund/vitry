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
  version : [0, 0, 3]
}

/**
 * Global require function (set below so).
 */
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

require = Packages.vitry.java.core.getSimpleRequire({
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
// Standard objects

// Object

/**
 * Copies all enumerable properties of a given object to another.
 * (This function behaves exactly as in Prototype).
 *
 * @param to
 *  Object to receive properties
 * @param from
 *  Object to enumerate for properties
 */
Object.extend = function(to, from) {
  for (k in from) to[k] = from[k];
  return to;
}

/**
 * Returns a shallow copy of the given object.
 * (This function behaves exactly as in Prototype).
 *
 * @param obj
 *  Object to copy
 */
Object.clone = function(obj) {
  return Object.extend({}, obj);
}

/**
 * Return the values of all enumerable properties in this object.
 * (This function behaves exactly as in Prototype).
 *
 * @param obj
 *  Object to enumerate for properties
 */
Object.values = function(obj) {
  return [v for each (v in obj)];
}

/**
 * Returns an array of [key, value] pairs for all enumerable properties
 * in this object.
 *
 * @param obj
 *  Object to enumerate for properties
 */
Object.entries = function(obj) {
  return [[k, obj[k]] for (k in obj)];
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
  Object.defineAllProperties(obj, prop, { writable : status });
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
  Object.defineAllProperties(obj, prop, { enumerable : status });
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
  Object.defineAllProperties(obj, prop, { configurable : false });
}


/**
 * Redefine properties for the given object using the specified descriptor
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
Object.defineAllProperties = function (obj, prop, descr) {
  if (Function.isFunction(prop)) {
    Object.defineAllProperties(obj, Object.keys(obj).filter(prop), descr);
    
  } else if (Array.isArray(prop)) {
    prop.forEach(function(prop) Object.defineAllProperties(obj, prop, descr));
  
  } else {
    Object.defineProperty(obj, prop, descr);
  }
}
     
/**
 * Converts an object containing functions to an object with 
 * accessor properties.
 * @param 
 *   accessors
 * @param
 *   construcor to create the new object (optional)
 */
Object.fromGetters = function(accessors, prototype) {
  var obj = Object.create(prototype);
  for (k in accessors) {
    Object.defineProperty(obj, k, { get : accessors[k] });
  }      
  return obj;
}


// Function

Function.constant = function(val) {
  return (function() val);
}

Function.identity = function() {
  return (function(val) val);
}

Function.curry = function(f) {
  // TODO
}

Function.uncurry = function(f) {
  // TODO
}

Function.compose = function(f, g) {
  // TODO any number of fns
}

Function.sequence = function(f, g) {
  // TODO any number of fns
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

Function.isDefined = function() {
  // TODO
}


/**
 * Binds an function owned by a constructor to its prototype.
 * @param constructor
 * @param name
 */
Function.bindPrototype = function(constructor, name) {
  var constructorFunction = constructor[name];
  var prototypeFunction;

  if (Function.check(constructor) && Function.check(constructorFunction)) {

    prototypeFunction = (function() {
      var newArgs = [this];
      Array.prototype.push.apply(newArgs, arguments);
      return constructorFunction.apply(null, newArgs);
    });

    // TODO use setter to read original length (in case it is changed)
//    prototypeFunction.length = Math.max(0, constructorFunction.length - 1);
    constructor.prototype[name] = prototypeFunction;
  }
}

/**
 * Binds an function owned by a prototype to its constructor.
 * @param constructor
 * @param name
 */
Function.bindConstructor = function(constructor, name) {
  if (Function.check(constructor)) {

    var prototypeFunction = constructor.prototype[name];
    var constructorFunction;

    if (Function.check(prototypeFunction)) {

      constructorFunction = (function() {
        var given = [];
        Array.prototype.push.apply(given, arguments);
        return prototypeFunction.apply(given.shift(), given);
      });

      // TODO use setter to read original length (in case it is changed)
//      constructorFunction.length = prototypeFunction.length + 1;
      constructor[name] = constructorFunction;
    }
  }
}


// Array

// TODO Naive implementations. Replace with more efficient variants as needed.

/**
 * Returns the union of the given objects.
 *
 * This function will retain duplicates in the first objects but not the second.
 */
Array.union = function(first, second) {
  var union = first.clone();
  for each (v in second) {
    if (first.indexOf(v) < 0) {
      union.push(v);
    }
  }
  return union;
}

/**
 * Returns the intersection of the given objects.
 *
 * This function will retain duplicates in the first objects but not the second.
 */
Array.intersection = function(first, second) {
  var intersection = [];
  for each (v in first) {
    if (second.indexOf(v) >= 0) {
      intersection.push(v);
    }
  }
  return intersection;
}



Array.prototype.clone = function() {
  return [v for (v in this)];
}

Array.prototype.removeLast = function(){
  return Array.prototype.pop.apply(this.clone(), arguments);
}

Array.prototype.add = function(){
  return Array.prototype.push.apply(this.clone(), arguments);
}

Array.prototype.removeFirst = function(){
  return Array.prototype.shift.apply(this.clone(), arguments);
}

Array.prototype.addBefore = function(){
  return Array.prototype.unshift.apply(this.clone(), arguments);
}

// XXX Any need to replace slice (compare slice/splice)?
// Array.prototype.section = function(){
//   Array.prototype.splice.apply(this.clone(), arguments);
// }

Array.prototype.reversed = function(){
  return Array.prototype.reverse.apply(this.clone(), arguments);
}

Array.prototype.sorted = function(){
  return Array.prototype.sort.apply(this.clone(), arguments);
}


//Array.prototype.union


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

// Double-binding

Function.bindPrototype(Object, "extend");
Function.bindPrototype(Object, "clone");
Function.bindPrototype(Object, "keys");
Function.bindPrototype(Object, "values");

// XXX Will binding in these pollute Object.property to much?
// Function.bindPrototype(Object, "writable");
// Function.bindPrototype(Object, "enumerable");
// Function.bindPrototype(Object, "preventChanges");
// Function.bindPrototype(Object, "seal");
// Function.bindPrototype(Object, "freeze");
// Function.bindPrototype(Object, "preventExtensions");    

Function.bindPrototype(Object, "defineProperty");
Function.bindPrototype(Object, "getOwnPropertyDescriptor");
Function.bindPrototype(Object, "getOwnPropertyNames");

Function.bindPrototype(Function, "curry");
Function.bindPrototype(Function, "uncurry");
Function.bindPrototype(Function, "sequence");
Function.bindPrototype(Function, "and");
Function.bindPrototype(Function, "or");
Function.bindPrototype(Function, "not");
Function.bindPrototype(Function, "equalTo");
Function.bindPrototype(Function, "strictlyEqualTo");
Function.bindPrototype(Function, "greaterThan");
Function.bindPrototype(Function, "lessThan");
Function.bindPrototype(Function, "some");
Function.bindPrototype(Function, "all");
Function.bindPrototype(Function, "memberOf");
Function.bindPrototype(Function, "empty");
Function.bindPrototype(Function, "isNull");
Function.bindPrototype(Function, "isUndefined");
Function.bindPrototype(Function, "isNotNull");
Function.bindPrototype(Function, "isDefined");



// Encapsulate extensions
                      
Object.enumerable(Object, [
  "extend",
  "clone",
  "values",
  "entries",
  "writable",
  "enumerable",
  "preventChanges",
  "defineAllProperties",
  "fromGetters",
  "isObject",
  "check"
], false);
  
Object.enumerable(Object.prototype, [
  "extend",
  "clone",
  "keys",
  "values",
  "defineProperty",
  "getOwnPropertyDescriptor",
  "getOwnPropertyNames"
], false);

Object.enumerable(Function.prototype, [
  "curry",
  "uncurry",
  "sequence",
  "and",
  "or",
  "not",
  "equalTo",
  "strictlyEqualTo",
  "greaterThan",
  "lessThan",
  "some",
  "all",
  "memberOf",
  "empty",
  "isNull",
  "isUndefined",
  "isNotNull",
  "isDefined"
], false);

Object.enumerable(Function, [
  "constant",
  "identity",
  "curry",
  "uncurry",
  "compose",
  "sequence",
  "power",
  "flip",
  "and",
  "or",
  "not",
  "equalTo",
  "strictlyEqualTo",
  "greaterThan",
  "lessThan",
  "some",
  "all",
  "memberOf",
  "empty",
  "isNull",
  "isUndefined",
  "isNotNull",
  "isDefined",
  "bindPrototype",
  "bindConstructor",
  "isFunction",
  "check"
], false);

Object.enumerable(Array.prototype, [
  "clone",
  "removeLast",
  "add",
  "removeFirst",
  "addBefore",
  "reversed",
  "sorted"
], false);

Object.enumerable(Array, [
  "union",
  "intersection",
  "check",
  "some"
], false);


//======================================================================
// New types

function Natural(value) {
  // TODO
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
  // TODO
}

Integer.prototype = Object.extend(new Natural(), {
  // TODO
});


function Ratio(nom, denom) {
  // TODO
}

Ratio.prototype = Object.extend(new Integer(), {
  // TODO
});



//======================================================================
// Interpreter

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

var inStream = Packages.vitry.java.core.getIn();
var outStream = Packages.vitry.java.core.getOut();
var errStream = Packages.vitry.java.core.getErr();

function print(val) {
  if (val === undefined && arguments.length === 0)
    return print("");

  if (Function.isFunction(val))
    return print(val.toString());

  if (Object.isObject(val))
    return print(JSON.stringify(val));

  outStream.println("" + val);
}

function version() {
  return about.version;
}

function versionString() {
  return version().join(".");
}

function show(obj) {
  for (k in (obj && obj != this ? obj : visible)) 
    print("  " + k);
}

function showOwn(obj) {
  for (k in (obj && obj != this ? obj : visible)) 
    if ((obj || visible).hasOwnProperty(k)) 
      print("  " + k);
}

function help() {
  print("  show([val])  Displays all enumerable properties of the given object.         ");
  print("               If none is given, displays all top-level objects.               ");
  print("  show([val])  Displays all non-inherited, enumerable properties of the given  ");
  print("               object. If none is given, displays all top-level objects.       ");
  print("  help([val])  Displays help text about the given object.                      ");
  print("               If none is given, displays this text.                           ");
  print("  load()       Loads and interprets a file (as if it had been entered          ");
  print("               in the console).                                                ");
  print("  quit()       Leaves Vitry.                                                   ");
  print();
}

function quit() {
  print("Leaving " + about.name + "...")
  Packages.java.lang.System.exit(0);
}

function load(fileName) {
  if (arguments.length > 1) {
    for each (v in arguments) load(v);

  } else {
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



//======================================================================

exports.add ( Natural, Integer, Ratio,
              version, versionString, main );
