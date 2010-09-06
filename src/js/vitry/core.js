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
  version : [0, 6, 0]
}

//======================================================================
// Standard objects

// Object

// TODO 
// - Standard handling of destructuve/non-destructive
// - Efficient algorithms for frozen (immutable) objects
// - Outline how writable and preventChanges relate to seal, freeze and preventExtensions
// 
// What about:
//   - prototype methods (extend and clone); imperative and destructive by default
//   - entries method (overlaps Rhino's Iterator class)


/**
 * Copies all enumerable properties of a given object to another.
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

Object.extend(Object, {

  /**
   * Returns a shallow copy of the given object.
   *
   * @param obj
   *  Object to copy
   */
  clone : function(obj) {
    return Object.extend({}, obj);
  }, 

  /**
   * 
   */
  fromEntries : function(entries, prototype) {
    var obj = ( prototype ? Object.create(prototype) : {} );
    for each ({key:k,value:v} in entries)
      obj[k] = v;
    return obj;
  },
     
  /**
   * Converts an object containing functions to an object with 
   * accessor properties.
   * @param 
   *   accessors
   * @param
   *   construcor to create the new object (optional)
   */
  fromGetters : function(accessors, prototype) {
    var obj = ( prototype ? Object.create(prototype) : {} );
    for (k in accessors) {
      Object.defineProperty(obj, k, { get : accessors[k] });
    }      
    return obj;
  },                        
   
  /**
   *
   */
  map : function(obj, f, thisValue) {
    return Object.fromEntries(obj.entries().map(f, thisValue));
  },

  /**
   *
   */
  reduce : function(obj, f, init) {
    return Object.fromEntries(obj.entries().reduce(f, init));
  },

  /**
   *
   */
  reduceRight : function(obj, f, init) {
    return Object.fromEntries(obj.entries().reduceRight(f, init));
  },

  /**
   *
   */
  mapKeys : function(obj, f, thisValue) {
    return obj.map(
      function ({key : k, value : v}) {
        return { key : f.call(thisValue, k), value : v };
      }
    );
  },
              
  /**
   *
   */
  mapValues : function(obj, f, thisValue) {
    return obj.map(
      function ({key : k, value : v}) {
        return { key : k, value : f.call(thisValue, v) };
      }
    );
  },



  /**
   * Return the values of all enumerable properties in this object.
   * (This function behaves exactly as in Prototype).
   *
   * @param obj
   *  Object to enumerate for properties
   */
  values : function(obj) {
    return [v for each (v in obj)];
  },

  /**
   * Returns an array of {key: , value: } pairs for all enumerable properties
   * in this object.
   *
   * @param obj
   *  Object to enumerate for properties
   */
  entries : function(obj) {
    return [{ key:k, value:obj[k] } for (k in obj)];
  },

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
  enumerable : function(obj, prop, status) {
    Object.defineAllProperties(obj, prop, { enumerable : status });
  },

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
  writable : function(obj, prop, status) {
    // TODO What about lookup properties? Coerced, ignored? 
    Object.defineAllProperties(obj, prop, { writable : status });
  },

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
  preventChanges : function(obj, prop) {
    Object.defineAllProperties(obj, prop, { configurable : false });
  },

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
  defineAllProperties : function (obj, prop, descr) {
    if (
      Function.isFunction(prop)) {
      Object.defineAllProperties( 
        obj, 
        Object.keys(obj).filter(prop), 
        descr);
    } else if (
      Array.isArray(prop)) {
      prop.forEach(
        function(p) Object.defineAllProperties( 
          obj, 
          p, 
          descr ));
    } else {
      Object.defineProperty( obj, prop, descr );
    }
  }
  
});



// Function

// TODO
// - Implement standard higher-order functions
// - Object -> Function view and vice-versa


Object.extend(Function, {

  constant : function(v) {
    return (function() v);
  },

  identity : function() {
    return (function(v) v);
  },

  curry : function() {
    // TODO
  },

  uncurry : function() {
    // TODO
  },

  compose : function() {
    // TODO any number of fns
  },

  sequence : function() {
    // TODO any number of fns
  },

  power : function() {
    // TODO
  },

  flip : function() {
    // TODO
  },


  and : function() {
    // TODO
  },

  or : function() {
    // TODO
  },

  not : function() {
    // TODO
  },

  equalTo : function() {
    // TODO
  },

  strictlyEqualTo : function() {
    // TODO
  },

  greaterThan : function() {
    // TODO
  },

  lessThan : function() {
    // TODO
  },


  some : function() {
    // TODO
  },

  all : function() {
    // TODO
  },

  memberOf : function() {
    // TODO
  },

  empty : function() {
    // TODO
  },

  isNull : function() {
    // TODO
  },

  isUndefined : function() {
    // TODO
  },

  isNotNull : function() {
    // TODO
  },

  isDefined : function() {
    // TODO
  },


  /**
   * Binds an function owned by a constructor to its prototype.
   * @param constructor
   * @param name
   */
  bindPrototype : function(constructor, name) {
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
  },

  /**
   * Binds an function owned by a prototype to its constructor.
   * @param constructor
   * @param name
   */
  bindConstructor : function(constructor, name) {
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

});






// Sequence


/**
 * An immutable sequential structure.
 */
function Sequence(first, rest) {
  /* Constr guard : */ if (!(this instanceof Sequence)) return new Sequence(first, rest);
  
  this.first        = Function.constant(first);
  this.rest         = Function.constant(rest);
  this.__iterator__ = this.iterator;
  
  Object.freeze(this);  
}

Sequence.prototype = {
  first    : { /* closure */ },
  rest     : { /* closure */ },
  
  iterator : function(keysOnly) {
    return new SequenceIterator(this, keysOnly);
  }   
}

function SequenceIterator(seq, keys) {
  this.seq = seq;                  
  this.keys = keys;
}                

SequenceIterator.prototype = {
  next : function() {
    if (this.seq instanceof Sequence) {
      var v = this.seq.first();
      this.seq = this.seq.rest();
      return this.keys ? undefined : v;
    } else {
      throw StopIteration;
    }
  }
}

Array.prototype.__proto__ = Sequence.prototype;



// Array

// TODO 
// - Replace naive implementations:
//   - Use persistent copies for immutables
//   - Integrate with Sequences
// - Implement permutations and shuffle
// - Implement all set views
   
// Array.prototype__proto__ = new Sequence();
  
Object.extend(Array, {

  /**
   * Returns the union of the given objects.
   *
   * This function will retain duplicates in the first objects but not the second.
   */
  union : function(first, second) {
    var union = first.clone();
    for each (v in second) {
      if (first.indexOf(v) < 0) {
        union.push(v);
      }
    }
    return union;
  },

  /**
   * Returns the intersection of the given objects.
   *
   * This function will retain duplicates in the first objects but not the second.
   */
  intersection : function(first, second) {
    var intersection = [];
    for each (v in first) {
      if (second.indexOf(v) >= 0) {
        intersection.push(v);
      }
    }
    return intersection;
  },
  
  difference : function(first, second) {
    // TODO
  },
    
  powerSet : function(first, second) {
    // TODO
  },
  
  isSubsetOf : function(first, second) {
    // TODO
  },
  
  isProperSubsetOf : function(first, second) {
    // TODO
  },
  
  isSupersetOf : function(first, second) {
    // TODO
  },
  
  isProperSupersetOf : function(first, second) {
    // TODO
  }

});

Object.extend(Array.prototype, {

  first : function() {
    return this[0];
  },
  
  rest : function() {
    return this.slice(1);
  },

  clone : function() {
   return this.slice(0);
  },
  
  add : function() {            
    var res = this.clone();
    Array.prototype.push.apply(res, arguments);
    return res;
  },   

  addBefore : function() {
    var res = this.clone();
    Array.prototype.unshift.apply(res, arguments);
    return res;
  },

  removeFirst : function() {
    var res = this.clone();
    Array.prototype.shift.apply(res, arguments);
    return res;
  },

  removeLast : function() {
    var res = this.clone();
    Array.prototype.pop.apply(res, arguments);
    return res;
  },

  reversed : function() {
    var res = this.clone();
    Array.prototype.reverse.apply(res, arguments);
    return res;
  },

  sorted : function() {
    var res = this.clone();
    Array.prototype.sort.apply(res, arguments);
    return res;
  }
});







// Date                                       

Date.prototype.setISO8601 = function(string) {
  var regexp = "([0-9]{4})(-([0-9]{2})(-([0-9]{2})" +
      "(T([0-9]{2}):([0-9]{2})(:([0-9]{2})(\.([0-9]+))?)?" +
      "(Z|(([-+])([0-9]{2}):([0-9]{2})))?)?)?)?";
  var d = string.match(new RegExp(regexp));

  var offset = 0;
  var date = new Date(d[1], 0, 1);

  if (d[3])  date.setMonth(d[3] - 1);
  if (d[5])  date.setDate(d[5]);
  if (d[7])  date.setHours(d[7]);
  if (d[8])  date.setMinutes(d[8]);
  if (d[10]) date.setSeconds(d[10]);
  if (d[12]) date.setMilliseconds(Number("0." + d[12]) * 1000);
  if (d[14]) {
      offset = (Number(d[16]) * 60) + Number(d[17]);
      offset *= ((d[15] == '-') ? 1 : -1);
  }

  offset -= date.getTimezoneOffset();
  time = (Number(date) + (offset * 60 * 1000));
  this.setTime(Number(time));
}       



function Natural(value) { 
  if (!(this instanceof Natural)) 
    return new Natural(value);
  
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
  if (!(this instanceof Integer)) 
    return new Integer(value);

  
  // TODO
}

Integer.prototype = Object.extend(new Natural(), {
  // TODO
});


function Ratio(nom, den) {
  if (!(this instanceof Ratio)) 
    return new Ratio(nom, den);

  // TODO
}

Ratio.prototype = Object.extend(new Integer(), {
  // TODO
});





// TEMPORARY

String.prototype.toRational = function ()
{
    return Rational.parse(this.toString());
}


// FIXME does not properly coerce arguments
/**
 * Represents a rational number.
 */
Rational = function(num, denom) {
  var m, n;

  switch (arguments.length) {
    case 0:
      m = 0
      n = 1
      break;
    case 1:
      m = num;
      n = 1;
      break;
    default:
      m = num
      n = denom

      if (n === 0)
        throw new Error("Invalid rational number " + m + "/" + n);
      if (m === 0)
        n = 1;
      else {
        g = gcd(m, n)
        m = m / g
        n = n / g

        if (n < 0) {
          m = -m
          n = -n
        }
      }
  }

  /**
   * @methodOf Rational.prototype
   */
  this.num = function() {
    return m
  }

  /**
   * @methodOf Rational.prototype
   */
  this.denom = function() {
    return n
  }
};

/**
 * Returns this + value.
 */
Rational.prototype.add = function(value) {
  var that = Rational.parse(value), p = this.num(), q = this.denom(), r = that.num(), s = that
    .denom();
  return new Rational((p * s + q * r), q * s)
}

/**
 * Returns this - value.
 */
Rational.prototype.subtract = function(value) {
  var that = Rational.parse(value), p = this.num(), q = this.denom(), r = that.num(), s = that
    .denom();
  return new Rational((p * s - q * r), q * s);
}

/**
 * Returns this * value.
 */
Rational.prototype.multiply = function(value) {
  var that = Rational.parse(value), p = this.num(), q = this.denom(), r = that.num(), s = that
    .denom();
  return new Rational(p * r, q * s)
}

/**
 * Returns this / value.
 */
Rational.prototype.divide = function(value) {
  var that = Rational.parse(value), p = this.num(), q = this.denom(), r = that.num(), s = that
    .denom();
  return new Rational(p * s, q * r)
}

/**
 *
 */
Rational.prototype.negate = function() {
  return new Rational(-this.num(), this.denom())
}

/**
 *
 */
Rational.prototype.reciprocal = function(value) {
  // XXX R(1).divide(this) more effective ?
  return new Rational(this.denom(), this.num())
}


/**
 * Returns this === value.
 */
Rational.prototype.equals = function(value) {
  var that = Rational.parse(value), p = this.num(), q = this.denom(), r = that.num(), s = that
    .denom();
  return p * s === q * r
}


/**
 * Returns a floating-point approximation of this rational number.
 */
Rational.prototype.valueOf = function() {
  var p = this.num(), q = this.denom();
  return p / q
}

/**
 * Returns M/N where M is the numerator and N the denominator of this
 * rational number.
 */
Rational.prototype.toString = function() {
  return String(this.num()) + "/" + String(this.denom())
}

/**
 * Returns a serializable representation of this rational number.
 */
Rational.prototype.serialize = function() {
  return {
    m: this.num(),
    n: this.denom()
  }
}

Rational.prototype.clone = function() {
  return new Rational(this.num(), this.denom());
}


/**
 * Returns a floating-point approximation of the difference between the given
 * rational numbers. This function can be used as a sorting function.
 */
Rational.compare = function(a, b) {
  return Rational.parse(a).subtract(b).valueOf()
}


// Math

Rational.pow = function(base, exponent) {
  var a = Rational.parse(base), p = 1, i = 0;
  for (; i < exponent; ++i)
    p *= a;
  return p;
}


/**
 * Returns a rational number which is the result of parsing the given
 * expression.
 */
Rational.parse = function(value) {
  if (value instanceof Rational) {
    return value;

  } else if (typeof value === "string") {
    var result;

    // TODO make regexp accept strings not containing /

    // if (value.indexOf("/") < 0)
    //   return new Rational(parseInt(value));   
    result = strParser.exec(value)

    //result.postln();
    if (result[2])
      return new Rational(parseInt(result[1]), parseInt(result[2]));
    else
      return new Rational(parseInt(result[1]));

  } else {
    return new Rational(value)
  }
}

Rational.coerce = function(value) {
  if (typeof value === "string")
    return Rational.parse(value);
  if (typeof value === "number")
    return new Rational(value);
    // return new Rational(Math.floor(value));
  else
    return new Rational();
}   

function gcd(a, b) {
  var c;
  while (b !== 0) {
    c = b
    b = a % b
    a = c
  }
  return a
}

function lcm(a, b) {
  var a2 = Math.abs(a), b2 = Math.abs(b);
  return a2 * (b2 / gcd(a2, b2))
}


/*
 * Pattern    := (Simple)(?:/(Simple))?
 * Simple     := \d+Exponent|\d+\.\d*Exponent|\.\d+Exponent
 * Exponent := (?:[eE]\+?\-?\d+)?
 */
/*
 * (Simple)(?:/(Simple))?
 * \d+(?:\.\d*)?Exponent?|\.\d+Exponent?
 * (?:[eE]\+?\-?\d+)
 */
var strParser = new RegExp("(\\d+(?:\\.\\d*)?(?:[eE]\\+?\\-?\\d+)?|\\.\\d+(?:[eE]\\+?\\-?\\d+)?)(?:\\/(\\d+(?:\\.\\d*)?(?:[eE]\\+?\\-?\\d+)?|\\.\\d+(?:[eE]\\+?\\-?\\d+)?))?");



     

// Top-level functions
               

// function parseArgs(a) {
//   // TODO Return lazy seq instead of copy
//   
//   var given = [];
//   Array.prototype.push.apply(given, a);
//   return given;
// }    

// function chain(expr) {          
//   var value = expr;
//   var i;
//   for (i = 1; i < arguments.length; ++i) {
//     Function.check(arguments[i]);
//     value = arguments[i].call(null, value);    
//   }
//   return value;
// }
//   



//======================================================================
// Type system

// TODO
// - Common Lisp-like type expression schemes
// - Runtime checks
// - Auto-generation of compliant constructors/accessors (== primitive pattern matching)
             


// Checks

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
  if (!Object.isObject(val))
    throw TypeError("Type of " + val + " is not object");
  return true;
}

Array.check = function(val) {
  if (!Array.isArray(val))
    throw TypeError("Type of " + val + " is not array");
  return true;
}

Function.check = function(val) {
  if (!Function.isFunction(val))
    throw TypeError("Type of " + val + " is not function");
  return true;
}

Boolean.check = function(val) {
  if (!Boolean.isBoolean(val))
    throw TypeError("Type of " + val + " is not boolean");
  return true;
}

Number.check = function(val) {
  if (!Number.isNumber(val))
    throw TypeError("Type of " + val + " is not number");
  return true;
}

String.check = function(val) {
  if (!String.isString(val))
    throw TypeError("Type of " + val + " is not string");
  return true;
} 



//======================================================================
// Configure

// Double-binding

Function.bindPrototype( Object,   "clone"                    );
Function.bindPrototype( Object,   "keys"                     );
Function.bindPrototype( Object,   "values"                   );
Function.bindPrototype( Object,   "entries"                  );
Function.bindPrototype( Object,   "defineProperty"           );
Function.bindPrototype( Object,   "getOwnPropertyDescriptor" );
Function.bindPrototype( Object,   "getOwnPropertyNames"      );

Function.bindPrototype( Object,   "map"                      );
Function.bindPrototype( Object,   "reduce"                   );
Function.bindPrototype( Object,   "mapKeys"                  );
Function.bindPrototype( Object,   "mapValues"                 );
                                                             
Function.bindPrototype( Array,    "union"                    );
Function.bindPrototype( Array,    "intersection"             );
                                                             
                                                             
Function.bindPrototype( Function, "curry"                    );
Function.bindPrototype( Function, "uncurry"                  );
Function.bindPrototype( Function, "sequence"                 );
Function.bindPrototype( Function, "and"                      );
Function.bindPrototype( Function, "or"                       );
Function.bindPrototype( Function, "not"                      );
Function.bindPrototype( Function, "equalTo"                  );
Function.bindPrototype( Function, "strictlyEqualTo"          );
Function.bindPrototype( Function, "greaterThan"              );
Function.bindPrototype( Function, "lessThan"                 );
Function.bindPrototype( Function, "some"                     );
Function.bindPrototype( Function, "all"                      );
Function.bindPrototype( Function, "memberOf"                 );
Function.bindPrototype( Function, "empty"                    );
Function.bindPrototype( Function, "isNull"                   );
Function.bindPrototype( Function, "isUndefined"              );
Function.bindPrototype( Function, "isNotNull"                );
Function.bindPrototype( Function, "isDefined"                );


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
  "fromEntries",
  "map",
  "reduce",
  "reduceRight",
  "mapKeys",
  "mapValues",
  "isObject",
  "check"
], false);
  
Object.enumerable(Object.prototype, [
  "hash",
  "hashCode",
  "extend",
  "clone",
  "keys",
  "values",
  "entries",
  "defineProperty",
  "getOwnPropertyDescriptor",
  "getOwnPropertyNames",
  "map",
  "reduce",
  "mapKeys",
  "mapValues"
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

Object.enumerable(Sequence, [
], false);

Object.enumerable(Sequence.prototype, [
  "first",
  "rest",
  "iterator"
], false);

Object.enumerable(Array, [
  "union",
  "intersection",
  "check",
  "some"
], false);

Object.enumerable(Array.prototype, [
  "first",
  "rest",
  "iterator",
  "union",
  "intersection",
  "clone",
  "removeLast",
  "add",
  "removeFirst",
  "addBefore",
  "reversed",
  "sorted"
], false);



//======================================================================
// Environment

var vitryModules = {
  core          : "vitry/core",
  music         : "vitry/music",
  readers       : "vitry/readers",
  writers       : "vitry/writers"
}

/**
 * Shortcut to vitry modules (fetched lazily).
 */
var vitry = Object.fromGetters(
  vitryModules.mapValues(function(v) (function() require(v))));
            
var scope = {
  Packages      : Packages,
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
}   

/**
 * Global require function
 */
var require = Packages.vitry.java.core.getSimpleRequire(scope); 

                                

//======================================================================
// Utilities

function getReader(name) {
  return Packages.vitry.java.core.getReader(name);
}

function getWriter(name) {
  return Packages.vitry.java.core.getWriter(name);
}
          
function isNative(obj) {
  return Packages.vitry.java.core.isNative(obj);
}
      
var io = {
  stdIn  : Packages.vitry.java.core.getIn(),
  stdOut : Packages.vitry.java.core.getOut(),
  stdErr : Packages.vitry.java.core.getErr()
}



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

function print(val) {
  if (val === undefined && arguments.length === 0)
    return print("");
    
  if (Object.isObject(val) &&
   !Function.isFunction(val) &&
   !isNative(val) &&
   (val.toString() === Object.prototype.toString()))
     return print(JSON.stringify(val));

  io.stdOut.println(String(val));
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

function shown(obj) {
  for each (k in Object.getOwnPropertyNames(obj)) 
      print("  " + k);
}
  
/**
 * Prints help information about the given object or about the current environment.
 * TODO
 */
function help(obj) {
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
      
/**
 * Prints a good-bye message and exits.
 */
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
      } 
      catch (e if e instanceof JavaException) {
        return null;
      }    
    }
  }
}
        
/**
 * Enters a read-eval-print loop.
 * @param prompt
 *   String to use as propmt.
 */
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
              version, versionString, 
              getReader, getWriter, isNative, main );
