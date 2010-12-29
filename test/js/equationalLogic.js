/*
load("~/macbook/Vitry/test/js/equationalLogic.js");

Test of the basic equational logic
See TODO
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

LazyProduct = function(routine){
  this.__iterator__ = routine;
}

Set = function(/* ... */){
  for(let i=0; i<arguments.length;i++)
    this[i] = arguments[i];
};    

Union = function(/* ... */){
  if (arguments.length <= 1) throw Error("A union requires at least two components.");
  for(let i=0; i<arguments.length;i++)
    this[i] = arguments[i];
};   

LazyUnion = function(routine){
  this.__iterator__ = routine;
}

Intersection = function(/* ... */){
  if (arguments.length <= 1) throw Error("An intersection requires at least two components.");
  for(let i=0; i<arguments.length;i++)
    this[i] = arguments[i];
};     

FunctionType = function(codom, dom) {
  this.codom = codom;
  this.dom = dom;
};        
                  
Type = function(root, name) {
  this.root = root;
  this.name = name;
}     

         
Term.prototype = {
  equals : function(v) {
    return false;
  },
  
  matches : function(v) {
    return false;
  }  
}

Atom.prototype    = new Term();
Product.prototype = new Term();
LazyProduct.prototype = new Product();
Set.prototype     = new Term();
Union.prototype   = new Term();
LazyUnion.prototype = Union.prototype;
Intersection.prototype = new Term();
FunctionType.prototype = new Term();
Type.prototype    = new Term();
Value.prototype   = new Atom();




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

FunctionType.prototype.equals = function(that) {
  if (!(that instanceof FunctionType)) return false;
  return this.codom.equals(that.codom) && this.dom.equals(that.dom);
}

Type.prototype.equals = function(that) {   
  if (!(that instanceof Type)) return false;  
  return this === that || this.name === that.name;
}






Value.prototype.matches = function(that) {
  if (that instanceof Atom) {
    // x = y
    return this.equals(that);
  }                            
  if (that instanceof Intersection) {
    // y : head(x) or head(x) : y or y : tail(x) or tail(x) : y  
    let some = false;       
    for each (thatVal in that) {  
      if (thatVal.matches(this) || this.matches(thatVal)) some = true;
    }
    return some;
  }
  return false;
}

Product.prototype.matches = function(that) {
  if (that instanceof Product) {
  
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
  if (that instanceof Intersection) {
    // y : head(x) or head(x) : y or y : tail(x) or tail(x) : y  
    let some = false;       
    for each (thatVal in that) {  
      if (thatVal.matches(this) || this.matches(thatVal)) some = true;
    }
    return some;
  }      
  return false;
}           

Set.prototype.matches = function(that) {
  if (that instanceof Atom || that instanceof Product || that instanceof FunctionType) {
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
  if (that instanceof Atom || that instanceof Product || that instanceof FunctionType) {
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
  if (that instanceof Atom || that instanceof Product || that instanceof FunctionType) {
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
    // for each element E in y, E : head(x) or head(x) : E or E : tail(x) or tail(x) : E
    for each (thisVal in this) {
      let some = false;       
      for each (thatVal in that) {  
        if (thatVal.matches(thisVal) 
          || thisVal.matches(thatVal)
        ) some = true;
        matching = thatVal;
      }
      if (!some) return false;    
    }
    return true;
  }
  return false;
}

FunctionType.prototype.matches = function(that) { 
  if (!(that instanceof FunctionType)) return false;            
  return this.codom.matches(that.codom) && this.dom.matches(that.dom);
}

Type.prototype.matches = function(that) {
  // if (!(that instanceof Ref)) return false;  
  return (that.type.equals(this));
}



    

// Nominal types


/*let*/ 
Ref = function (value, type) {
 return {        
   value : value,
   type : type,
   // equals : value.equals.bind(value),
   // matches : value.matches.bind(value), 
   equals : function(that) {
     return this === that;
   },
   matches : function(that) {
     return this === that;
   },
   toString : function() {
     return "(" + value + " : " + type + ")";
   },   
   __iterator__ : function() {
     Iterator(value);
   }
 }         
}              

tag = function(value, type) {
  if (type.root.matches(value)) {
    return new Ref(value, type);
  } else {
    throw new Error("Can not apply tag " + type + " to " + value);
  }
}


// Higher-order

list = function(type) {
  return new Type(list2(type), "[" + type + "]");
}                  

// () | (a, list a)                            
let list2 = function(type) {
  return new LazyUnion(function(){
    yield new Product;
    yield new Product(type, list2(type));  
  });
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
  let k = 0;
  for each (v in this) {
    if (k > 0) {
      str += ",";
    }
    str += v;
    k++;
  }
  str += ")";
  return str;
}

Union.prototype.toString = function() {
  var str = "(";      
  let k = 0;
  for each (v in this) {
    if (k > 0) {
      str += "|";
    }
    str += v;
    k++;
  }
  str += ")";
  return str;
}

Intersection.prototype.toString = function() {
  var str = "(";               
  let k = 0;
  for each (v in this) {
    if (k > 0) {
      str += " & ";
    }
    str += v;
    k++;
  }
  str += ")";
  return str;
}

Set.prototype.toString = function() {
  var str = "{";
  let k = 0;
  for each (v in this) {
    if (k > 0) {
      str += ",";
    }
    k++;
    str += v;
  }
  str += "}";
  return str;
}    

FunctionType.prototype.toString = function() {
  return "" + this.codom + " -> " + this.dom;
}

Type.prototype.toString = function() {
  return "" + this.name;
}

Value.prototype.toString = function() {
  return String(this.wrap);
}


Object.enumerable(Term.prototype,    ["toString", "equals", "matches"], false);
Object.enumerable(Atom.prototype,    ["toString", "equals", "matches"], false);
Object.enumerable(Product.prototype, ["toString", "equals", "matches"], false);
Object.enumerable(Union.prototype,   ["toString", "equals", "matches"], false);
Object.enumerable(Intersection.prototype, 
                                     ["toString", "equals", "matches"], false);
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
F = FunctionType;
T = Type;
l = list;
a = new V("a");
b = new V("b");
c = new V("c");
d = new V("d");  
e = new V("e");  
f = new V("f");  
g = new V("g");  
h = new V("h");  
i = new V("i");  

asList = function(/*...*/) {
  if (arguments.length == 0)
    return new P;
  else
    return new P(arguments[0], asList.apply(null, Array.prototype.slice.call(arguments, 1)));
}



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
printMatches(new F(a,b),new F(a,b));
printMatches(new F(a,new F(b,c)),new F(a,new F(b,c)));

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
printMatches(new I(a,b,c), new I(a,b));
printMatches(new I(a,new I(b,c)), new I(a,b));    

printMatches(new F(a,new F(b,c)), new F(a,new U(new F(b,c), new F(b,a))));


ab = new T(new U(a,b), "ab");
a_ = tag(a, ab);
b_ = tag(b, ab);

print();
print("nominal:");                    
printEquals(a_, a_);
printEquals(ab, ab);
printMatches(a_, a_);
printMatches(a_, ab);

printMatches(tag(asList(), list(a)), list(a));  
printMatches(tag(asList(a), list(a)), list(a));  
printMatches(tag(asList(a,a,a), list(a)), list(a));  
printMatches(tag(asList(a,b,c), list(new U(a,b,c))), list(new U(a,b,c)));  

printMatches(tag(asList(new P(a,b), new P(b,a)), list(new P(wildcard, wildcard))), list(new P(wildcard, wildcard)));  

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
printMatches(new I(a,b), new I(a,b,c));
//printMatches(new U(a,b), new S(a,b));
                                       
printMatches(tag(asList(a,b,c), list(new U(a,b,c))), list(new I(a,b))); 
printMatches(tag(asList(new P(a,b,c), new P(b,a,c)), list(new P(wildcard, wildcard,c))), list(wildcard));


printMatches(a_, a);
printEquals(a, a_);
printEquals(a_, a);
printMatches(a, a_);
printMatches(a_, a);
printEquals(a_, b_);  
                                       


