/*
 * load("~/macbook/Vitry/test/js/equationalLogic.js");
 * 
 * Test of the basic equational logic
 * See TODO
 */
OPTMIZATION = true;

Term = function() {};

Atom = function() {};

Value = function (wrap) {
  this.wrap = wrap;
};

Product = function(/* ... */){
  for(let i=0; i<arguments.length;i++)
    this[i] = arguments[i];
};

Union = function(/* ... */){
  for(let i=0; i<arguments.length;i++)
    this[i] = arguments[i];
};

Set = function(/* ... */){
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
Union.prototype = new Term();
Set.prototype = new Term();
Value.prototype = new Atom();


// Implementations

/*
 * x:Value = y:Value 
 *     (trivial)
 */
Value.prototype.equals = function(that) {  
  return  this.wrap === that.wrap;
}

/*
 * x:Product = y:Product
 *     iff x = () and y = ()
 *     or x and y have the same elements in the same order
 */
Product.prototype.equals = function(that) {
  if (!(that instanceof Product)) return false;

//  if (OPTMIZATION) {
    if (this.keys().length !== that.keys().length) 
      return false;                               
//  }
  
  if (this.keys().length == 0)
    return true;
  for (i = 0; i < this.keys().length; i++) {
    if (!this[i].equals(that[i])) return false;    
  }
  return true;
}

/*
 * x:Union = y:Union
 *     iff for each element e1 in x, for some element e2 of y
 *         e1 matches e2 or e2 matches e1
 */
Union.prototype.equals = function(that) {
  if (!(that instanceof Union)) return false;
                    
  if (this.keys().length == 0 && that.keys().length == 0)
    return true;
  
  // iterate members
  for (i = 0; i < this.keys().length; i++) {
    let found = false;  
    // perform linear search
    for (j = 0; j < that.keys().length; j++) {
      if(this[i].matches(that[j]) || that[j].matches(this[i])) 
        found = true;
    }
    if (!found) return false;
  }                 
  return true;
}

/*
 * x:Set = y:Set
 *     iff for each element e1 in x, for some element e2 of y, e1 equals e2
 *         and for each element e1 in y, for some element e2 of x, e1 equals e2
 */
Set.prototype.equals = function(that) {
  if (!(that instanceof Set)) return false;
  
  if (this.keys().length == 0 && that.keys().length == 0)
    return true;
            
  // iterate members
  for (i = 0; i < this.keys().length; i++) {
    let found = false;  
    // perform linear search
    for (j = 0; j < that.keys().length; j++) {
      if(this[i].equals(that[j])) found = true;
    }
    if (!found) return false;
  }                 
  // iterate members of that
  for (i = 0; i < that.keys().length; i++) {
    let found = false;
    for (j = 0; j < this.keys().length; j++) {
      if(that[i].equals(this[j])) found = true;
    }
    if (!found) return false;
  }
  return true;
}

/*
 * x:Value :: y:Value
 *     iff x = y
 */
Value.prototype.matches = function(that) {
  if (that instanceof Atom) 
    return this.equals(that);
  return false;
}

/*
 * x:Product :: y:Product
 *     iff x = y
 *     or elements of x mathes y ... TODO
 */
Product.prototype.matches = function(that) {
  if (!(that instanceof Product)) return false;
  if (this.equals(that)) return true;

  if (this.keys().length !== that.keys().length) 
    return false;                            
  for (i = 0; i < this.keys().length; i++) {
    if (!this[i].matches(that[i])) return false;    
  }
  return true;
}

/*
 * x:Atom|Product :: y:Union
 *     TODO
 * x:Union :: y:Union
 *     TODO
 * x:Set :: y:Union
 *     TODO
 */
Union.prototype.matches = function(that) {
  if (that instanceof Atom || that instanceof Product) {
    for each (v in this)
      if (v.matches(that)) return true;
  }
  if (that instanceof Union) {
    for each (v in this)
      if (v.matches(that)) return true;
  }
  if (that instanceof Set) {
    for each (v in this)
      if (v.equals(that)) return true;
  }
  
  return false;
}

/*
 * x:Atom|Product :: y:Set
 *     TODO
 * x:Union :: y:Set
 *     TODO
 * x:Set :: y:Set
 *     TODO
 */
Set.prototype.matches = function(that) {
  if (that instanceof Atom || that instanceof Product) {
    for each (v in this)
      if (v.equals(that)) return true;
  }
  if (that instanceof Union) {
    for each (v in this)
      if (v.matches(that)) return true;
  }
  if (that instanceof Set) {
    for each (v in this)
      if (v.equals(that)) return true;
  }
  
  return false;
}
    

/*
 * ? = ?
 * for all x, x :: ?
 * 
 * FIXME can not match wildcards in sets
 */
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
S = Set;
V = Value;
a = new V("a");
b = new V("b");
c = new V("c");
d = new V("d");




// Cases

//printEquals(a, a);
//printEquals(a, b);
//print();
//
//printEquals(new P(a,b,c), new P(a,b,c));
//printEquals(new P(b,a,c), new P(a,b,c));
//printEquals(new U(a,b,c), new U(a,b,c));
//printEquals(new U(b,a,c), new U(a,b,c));
//printEquals(new S(a,b,c), new S(a,b,c));
//printEquals(new S(b,a,c), new S(a,b,c));
//print();
//
//
//printMatches(a, a);
//printMatches(a, b);
//printMatches(a, new P(a, b));
//printMatches(new P(a, b), new P(a, b));
//print();
//
//printMatches(a, new U(a,b,c));
//printMatches(new P(a, b), new U(a,b, new P(a, b)));
//print();
//
//printMatches();


printEquals(a, a);
printEquals(new P(a, b), new P(a, b));
printEquals(new P(a, new P(b, c)), new P(a, new P(b, c)));
printEquals(new U(a, b), new U(a, b));
printEquals(new U(a, new U(b, c)), new U(new U(a, b), c));
printEquals(new S(a, b, c), new S(a, b, c));
printEquals(new S,new S);
printEquals(new S(new S),new S(new S));
//(()) = () no unary tuples

print();
printMatches(new P(a, b), new P(a, b));
printMatches(a, new U(a, b));
printMatches(b, new U(a, b));
printMatches(c, new U(a, new U(b, c)));
printMatches(c, new U(a, wildcard));
printMatches(a, new S(a, b));
printMatches(b, new S(a, b));
//printMatches(c, new S(a, wildcard));
printMatches(a, new S(a, new S(b, c)));
printMatches(new S(b, c), new S(a, new S(b, c)));
printEquals(new S, new S);
printEquals(new S(new S), new S(new S));
// printEquals(new U(new U), new U(new U(new U))); no empty unions
printMatches(a, new U(a,new P(b,new S(c,d))))
printMatches(new P(b, d), new U(a,new P(b,new S(c,d))))
printMatches(new P(a, b, c), new P(a,new S(a,b), new U(b,new U(c,d))))
printMatches(new P(a, b, c), new P(a,new S(a,b), new U(b,new S(c,d))))
printEquals(wildcard, wildcard);
printMatches(a, wildcard);
printMatches(new P(a, b), new P(wildcard, wildcard));
printMatches(new P(a, new P(a, a)), new P(wildcard, new P(wildcard, wildcard)));

print();
print("false cases:");                    
printEquals(new P(a, b), new P(b, a));
printEquals(new S, new S(new S));
printEquals(new S(a, new S(b, c)), new S(new S(a, b), c));
printMatches(new U(a,b), new U(a,b));
printMatches(new S(a,b), new S(a,b));
printMatches(new U(a,b), new S(a,b));
printMatches(new S(a, b, c), new S(a, new S(b, c)));
printMatches(new P(a, b, c), new P(a,new S(a,b), new S(b,new U(c,d))))


