/*
 * load("~/macbook/Vitry/test/js/equationalLogic.js");
 * 
 * Test of the basic equational logic
 * See TODO
 */
Term = function() {};

Atom = function() {};

Value = function (wrap) {
  this.wrap = wrap;
};

Product = function(/* ... */){
  for(let i=0; i<arguments.length;i++)
    this[i] = arguments[i];
};

Set = function(/* ... */){
  for(let i=0; i<arguments.length;i++)
    this[i] = arguments[i];
};    

Union = function(/* ... */){
  if (arguments.length <= 1) throw Error("A union requires at least two components.");
  for(let i=0; i<arguments.length;i++)
    this[i] = arguments[i];
};

Intersection = function(/* ... */){
  if (arguments.length <= 1) throw Error("An intersection requires at least two components.");
  for(let i=0; i<arguments.length;i++)
    this[i] = arguments[i];
};
         
Term.prototype = {
  equals : function(v) {
    return false;
  },
  
  matches : function(v) {
    return false;
  }  
}

Atom.prototype = new Term();
Product.prototype = new Term();
Set.prototype = new Term();
Union.prototype = new Term();
Intersection.prototype = new Term();
Value.prototype = new Atom();




// Implementations



Value.prototype.equals = function(that) {  
  // trivial
  return  this.wrap === that.wrap;
}

Product.prototype.equals = function(that) {
  if (!(that instanceof Product)) return false;

  if (this.keys().length !== that.keys().length) 
    return false;                               

  // x = () and y = ()
  if (this.keys().length == 0)
    return true;
  
  // head(x) = head(y) and tail(x) = tail(y)
  for (i = 0; i < this.keys().length; i++) {
    if (!this[i].equals(that[i])) return false;    
  }
  return true;
}

Set.prototype.equals = function(that) {
  if (!(that instanceof Set)) return false;

  // x = {} and y = {}
//  if (this.keys().length === 0 && that.keys().length === 0) return true;
//  if (this.keys().length === 0 || that.keys().length === 0) return false;

  return this.matches(that) && that.matches(this);
}

Union.prototype.equals = function(that) {
  return this.matches(that) && that.matches(this);
}

Intersection.prototype.equals = function(that) {
  return this.matches(that) && that.matches(this);
}





Value.prototype.matches = function(that) {
  if (that instanceof Atom) {
    // x = y
    return this.equals(that);
  }
  return false;
}

Product.prototype.matches = function(that) {
  if (!(that instanceof Product)) return false;
  
  // x = y
  if (this.equals(that)) return true;

  // head(x) : head(y) and tail(x) : tail(y)

  if (this.keys().length !== that.keys().length) 
    return false;                            
  for (i = 0; i < this.keys().length; i++) {
    if (!this[i].matches(that[i])) return false;    
  }
  return true;
}

Set.prototype.matches = function(that) {
  if (that instanceof Atom || that instanceof Product) {
    // iff x = head(y) or x = tail(y)
    for each (v in this)
      if (v.equals(that)) return true;
  }
  if (that instanceof Set) {
    // for each element E in x, E = head(y) or E = tail(y)
    for each (thatVal in that) {
      let some = false;
      for each (thisVal in this) {
        if (thisVal.equals(thatVal)) some = true;
      }
      if (!some) return false;    
    }
    return true;
  }
  if (that instanceof Union) {
    throw new Error("No implementation.");
  }
  if (that instanceof Intersection) {
    throw new Error("No implementation.");
  }
  return false;
}

Union.prototype.matches = function(that) {
  if (that instanceof Atom || that instanceof Product) {
    // iff x : head(y) or x : tail(y)
    for each (v in this)
      if (v.matches(that)) return true;
  }
  if (that instanceof Set) {
    // for each element E in x, E : head(y) or E : tail(y)
    for each (thatVal in that) {
      let some = false;
      for each (thisVal in this) {
        if (thisVal.matches(thatVal)) some = true;
      }
      if (!some) return false;    
    }
    return true;
  }
  if (that instanceof Union) {
    // for each element E in x, E : head(y) or head(y) : E or E : tail(y) or tail(y) : E
    for each (thatVal in that) {
      let some = false;
      for each (thisVal in this) {
        if (thisVal.matches(thatVal)) some = true;
        if (thatVal.matches(thisVal)) some = true;
      }
      if (!some) return false;    
    }
    return true;
  }
  if (that instanceof Intersection) {
    throw new Error("No implementation.");
  }
  return false;
}

Intersection.prototype.matches = function(that) {
  if (that instanceof Atom || that instanceof Product) {
    // iff x : head(y) and x : tail(y)
    for each (v in this)
      if (!v.matches(that)) return false;
    return true;
  }
  if (that instanceof Set) {
    // for each element E in x, E : head(y) and E : tail(y)
    for each (thatVal in that) {
      let every = true;
      for each (thisVal in this) {
        if (!thisVal.matches(thatVal)) every = false;
      }
      if (!every) return false;    
    }
    return true;
  }
  if (that instanceof Union) {
    throw new Error("No implementation.");
  }
  if (that instanceof Intersection) {
    // for each element E in x, ( E : head(y) or head(y) : E ) and ( E : tail(y) or tail(y) : E )
    for each (thatVal in that) {
      let every = true;
      for each (thisVal in this) {
        // FIXME
        if (!(thisVal.matches(thatVal)) && !(thatVal.matches(thisVal))) every = false;
//        if (!(thisVal.matches(thatVal)) && thatVal.matches(thisVal)) every = false;
//        if (thisVal.matches(thatVal) && !(thatVal.matches(thisVal))) every = false;
      }
      if (!every) return false;    
    }
    return true;
  }
  return false;
}

    



// Wildcard

wildcard = new Value();

wildcard.equals = function(other) {
  return other === wildcard;
}                           

wildcard.matches = function() {
  return true;
}

wildcard.toString = function() {
  return "?";
}



// Testing


Product.prototype.toString = function() {
  var str = "(";
  for (k in this) {
    if (k > 0) {
      str += ",";
    }
    str += this[k];
  }
  str += ")";
  return str;
}

Union.prototype.toString = function() {
  var str = "(";
  for (k in this) {
    if (k > 0) {
      str += "|";
    }
    str += this[k];
  }
  str += ")";
  return str;
}

Intersection.prototype.toString = function() {
  var str = "";
  for (k in this) {
    if (k > 0) {
      str += " & ";
    }
    str += this[k];
  }
  str += "";
  return str;
}


Set.prototype.toString = function() {
  var str = "{";
  for (k in this) {
    if (k > 0) {
      str += ",";
    }
    str += this[k];
  }
  str += "}";
  return str;
}


Value.prototype.toString = function() {
  return String(this.wrap);
}


Object.enumerable(Term.prototype,    ["toString", "equals", "matches"], false);
Object.enumerable(Atom.prototype,    ["toString", "equals", "matches"], false);
Object.enumerable(Product.prototype, ["toString", "equals", "matches"], false);
Object.enumerable(Union.prototype,   ["toString", "equals", "matches"], false);
Object.enumerable(Intersection.prototype, ["toString", "equals", "matches"], false);
Object.enumerable(Set.prototype,     ["toString", "equals", "matches"], false);
Object.enumerable(Value.prototype,   ["toString", "equals", "matches"], false);

// Tests
printEquals = function(x, y) {
  var result = x.equals(y);
  if (result && !y.equals(x)) 
    throw Error("Equality is not symmetric on " + x + " and " + y);
  print(pad("" + x + " = " + y, 35) + "=> " + result);
}
// Note argument order, mimicks the : expression
printMatches = function(e, c){
  var result = c.matches(e);
  print(pad("" + e + " : " + c, 35) + "=> " + result); 
}

function pad(str, len) {
  if (str.length >= len)
    return str;
  else {
    let chars = (len - str.length);
    if (!pads[chars]) {
      pads[chars] = "";
      for(i=0; i<chars; i++)
        pads[chars] += " ";  
    }
    return str += pads[chars];
  }
}
pads = [];


// Shortcuts

P = Product;
U = Union;
I = Intersection;
S = Set;
V = Value;
a = new V("a");
b = new V("b");
c = new V("c");
d = new V("d");




// Cases

printEquals(a, a);
printEquals(new P, new P);
printEquals(new P(a, b), new P(a, b));
printEquals(new P(a, new P(b, c)), new P(a, new P(b, c)));
printEquals(new U(a, b), new U(a, b));
printEquals(new U(a, new U(b, c)), new U(new U(a, b), c));
printEquals(new S(a, b), new S(b, a));
printEquals(new S,new S);
printEquals(new S(new S),new S(new S));

print();
printMatches(a, a);
printMatches(new P, new P);
printMatches(new P(a, b), new P(a, b));
printMatches(a, new U(a, b));
printMatches(b, new U(a, b));
printMatches(a, new I(a, a));
printMatches(a, new I(a, new U(a, b)));
printMatches(c, new U(a, new U(b, c)));
printMatches(c, new U(a, wildcard));
printMatches(a, new S(a, b));
printMatches(b, new S(a, b));
printMatches(a, new S(a, new S(b, c)));
printEquals(new S, new S);
printEquals(new S(new S), new S(new S));
printMatches(a, new U(a,new P(b,new S(c,d))))
printMatches(new P(b, d), new U(a,new P(b,new S(c,d))))
printMatches(new P(a, b, c), new P(a,new S(a,b), new U(b,new U(c,d))))
printMatches(new P(a, b, c), new P(a,new S(a,b), new U(b,new S(c,d))))
printEquals(wildcard, wildcard);
printMatches(a, wildcard);
printMatches(new P(a, b), new P(wildcard, wildcard));
printMatches(new P(a, new P(a, a)), new P(wildcard, new P(wildcard, wildcard)));
printMatches(new U(a,b), new U(a,b));
printMatches(new S(a,b), new S(a,b));
printMatches(new U(a,b), new U(a,new U(b,c)));
printMatches(new U(a,b), new U(a,new U(b,c)));
printMatches(a, new I(a,new U(a,b)));
printMatches(new I(a,a), new I(a,new U(a,b)));
printMatches(new I(a,b), new I(a,new U(a,b)));

print();
print("false cases:");                    

printMatches(a, b);
printMatches(a, new P(a, b));
printEquals(new P(a, b), new P(b, a));
printEquals(new S, new S(new S));
printEquals(new S(a, new S(b, c)), new S(new S(a, b), c));
printMatches(a, new I(a, b));
printMatches(new S(b, c), new S(a, new S(b, c)));
printMatches(new S(a, b, c), new S(a, new S(b, c)));
printMatches(new P(a, b, c), new P(a,new S(a,b), new S(b,new U(c,d))))
printMatches(new I(a,b), new I(a,new U(a,b), c));
//printMatches(new U(a,b), new S(a,b));


