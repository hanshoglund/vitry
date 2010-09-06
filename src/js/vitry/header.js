/*
 * Vitry, copyright (c) Hans Höglund 2010, see COPYING.txt for details
 */

/** 
 * Utility functions for the module system.
 * 
 * Pre-core, only standard JavaScript here.
 */
 
(function() {

  Object.defineProperties(
    exports,
    {
      /*
       * Adds all the specified values to the exports object. All given values must
       * be defined in the same lexical context, or this method will throw an error.
       */
      "add" : {     
        value : function() {
          var parent;       
          var supplied = [];
        
          Array.prototype.push.apply(supplied, arguments);
          parent = supplied.reduce((function(p, v) p || getParent(v)), null);

          if (parent) {
            Object.keys(parent).
            filter(function(k) supplied.indexOf(parent[k]) >= 0).
            forEach(function(k) {
              exports[k] = parent[k];
            });
          }
        }
      },
        
      /*
       * Adds all given values, using the given names. This method accepts an enumerable
       * object and copies its names and values to the exports object.
       */
      "addNamed" : {
        value : function(from) {
          for (k in from) exports[k] = from[k];
        }
      }
    }
  );

  function getParent(obj) {
    return obj.__parent__;
  }  
  
}());    




//======================================================================

Map=function(size)
{this.buckets=new Array();if(isNaN(size)||size<1)
size=10;for(var i=0;i<size;i++)
this.buckets[i]=new Bucket();}
Map.prototype.bucketFor=function(obj)
{with(this)
{return buckets[obj.hash()%buckets.length];}}
Map.prototype.size=function()
{var sz=0;with(this)
{for(var i=0;i<buckets.length;i++)
sz+=buckets[i].depth;}
return sz;}
Map.prototype.isEmpty=function()
{with(this)
{for(var i=0;i<buckets.length;i++)
if(buckets[i].depth>0)
return false;}
return true;}
Map.prototype.keys=function()
{var a=new Array();with(this)
{var bucket,e;for(var i=0;i<buckets.length;i++)
{bucket=buckets[i];for(e=bucket.first;e!=null;e=e.next)
a[a.length]=e.key;}}
return a;}
Map.prototype.values=function()
{var a=new Array();with(this)
{var bucket,e;for(var i=0;i<buckets.length;i++)
{bucket=buckets[i];for(e=bucket.first;e!=null;e=e.next)
a[a.length]=e.value;}}
return a;}
Map.prototype.containsKey=function(key)
{if(key&&key!=null)
{with(this)
{var bucket=bucketFor(key);for(var e=bucket.first;e!=null;e=e.next)
if(e.key==key)
return true;}}
return false;}
Map.prototype.containsValue=function(value)
{if(value)
{with(this)
{var bucket,e;for(var i=0;i<buckets.length;i++)
{bucket=buckets[i];for(e=bucket.first;e!=null;e=e.next)
if(e.value==value)
return true;}}}
return false;}
Map.prototype.put=function(key,value)
{with(this)
{return(key&&(key!==null)&&value)?bucketFor(key).add(key,value):null;}}
Map.prototype.get=function(key)
{if(key&&key!=null)
{with(this)
{var bucket=bucketFor(key);for(var e=bucket.first;e!=null;e=e.next)
if(e.key==key)
return e.value;}}
return null;}
Map.prototype.remove=function(key)
{if(key&&key!=null)
{with(this)
{return bucketFor(key).remove(key);}}
return null;}
Map.prototype.clear=function()
{with(this)
{for(var i=0;i<buckets.length;i++)
buckets[i].clear();}}
Map.prototype.toString=function()
{return"[object Map]";}
function Bucket()
{this.depth=0;this.first=null;}
Bucket.prototype.add=function(key,value)
{with(this)
{if(first!=null)
{for(var e=first;e!=null;e=e.next)
{if(e.key==key)
{var old=e.value;e.value=value;return old;}}}
first=new Entry(key,value,first);depth++;}
return null;}
Bucket.prototype.remove=function(key)
{with(this)
{if(first!=null)
{for(var e=first,prev=null;e!=null;prev=e,e=e.next)
{if(e.key==key)
{if(prev==null)
first=e.next;else prev.next=e.next;depth--;return e.value;}}}}
return null;}
Bucket.prototype.clear=function()
{with(this)
{first=null;depth=0;}}
Bucket.prototype.toString=function()
{return"[object Bucket]";}
function Entry(k,val,nxt)
{this.key=k;this.value=val;this.next=nxt?nxt:null;}
Entry.prototype.toString=function()
{return"[object Entry]";}
Map.prototype.serialize=function(){var obj,keys;obj={}
keys=this.keys()
keys.map(function(k){obj[k]=this.get(k);},this);return obj;}



/**
 * Stores the computed hash code for later reference.
 */
Object.prototype.hashCode = -1;

/**
 * Computes a hash code for an object.
 */
Object.prototype.hash = function()
{ 
    var str, i;
    if (this.hashCode === Object.prototype.hashCode) {
        this.hashCode = 0
        str = this.toString()
        for(i = 0; i < str.length; i++)
            this.hashCode ^= str.charCodeAt(i)
    }
    return this.hashCode
}    
    
// Object.prototype.hash = function() {
//   if (this.hashCode === Object.prototype.hashCode) { 
//     this.hashCode = 0;
//     for (k in this) {
//       this.hashCode += hashValue(k) + hashValue(this[k]);
//     }
//   }
//   return this.hashCode;
// }
// 
// Boolean.prototype.hash = function() {
//   return hashValue(this.valueOf());
// }
// 
// Number.prototype.hash = function() {
//   return hashValue(this.valueOf());
// }     
// 
// String.prototype.hash = function() {
//   return hashValue(this.valueOf());
// }
// 
// 
// function hashValue(v) {
//   if (typeof v === "object") return v.hash();
//   if (typeof v === "string") {
//     var hash = 0;
//     for(i = 0; i < v.length; i++)
//       hash ^= v.charCodeAt(i);
//     return hash;
//   }                             
//   return Number(v);
// }   



//======================================================================

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

/**
 *
 */
Rational.prototype.post = function() {
  MJOS.post(this.toString());
}

/**
 *
 */
Rational.prototype.postln = function(pretty, console) {
  MJOS.postln(this.toString(), pretty, console);
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

