/*
load("~/macbook/Vitry/test/js/equationalLogicJava.js");
 */

importPackage(Packages.vitry.primitive);


P = Util.product;
S = Util.set;
U = Util.union;
I = Util.intersection;
F = (function(a,b) new FunctionTypeImpl(a,b));
T = Util.type;

s = Symbol.intern;
l = (function(a) new ListType(a));
u = Unit.getInstance();
_ = Empty.getInstance();
q = Wildcard.getInstance();

a = s("a");
b = s("b");
c = s("c");
d = s("d");


// Tests
printEquals = function(x, y) {
  var result = x.equals(y);
  if (result)
    succeeded++;
  else
    failed++;
  if (result && !y.equals(x))
    throw Error("Equality is not symmetric on " + x + " and " + y);
  print(pad("" + x + " = " + y, 45) + "=> " + result);
}
// Note argument order, mimicks the : expression
printMatches = function(x, y) {
  var result = x.matchFor(y);
  if (result)
    succeeded++;
  else
    failed++;
  print(pad("" + x + " : " + y, 45) + "=> " + result);
}

function pad(str, len) {
  if (str.length >= len)
    return str;
  else {
    let
    chars = (len - str.length);
    if (!pads[chars]) {
      pads[chars] = "";
      for (i = 0; i < chars; i++)
        pads[chars] += " ";
    }
    return str += pads[chars];
  }
}
pads = [];


test = function() {
  failed = 0, succeeded = 0;

  print("true:");
  printEquals(a, a);
  printEquals(u, u);
  printEquals(P(a, b), P(a, b));
  printEquals(P(a, P(b, c)), P(a, P(b, c)));
  printEquals(U(a, b), U(a, b));
  printEquals(U(a, U(b, c)), U(U(a, b), c));
  printEquals(S(a, b), S(b, a));
  // printEquals(S, S);
  // printEquals(S(S), S(S));
  // printMatches(F(a, b), F(a, b));
  // printMatches(F(a, F(b, c)), F(a, F(b, c)));


  print();
  printMatches(a, a);
  printMatches(u, u);
  printMatches(P(a, b), P(a, b));
  printMatches(a, U(a, b));
  printMatches(b, U(a, b));
  printMatches(a, I(a, a));
  printMatches(a, I(a, U(a, b)));
  printMatches(c, U(a, U(b, c)));
  printMatches(c, U(a, q));
  printMatches(a, S(a, b));
  printMatches(b, S(a, b));
  printMatches(a, S(a, S(b, c)));
  printEquals(_, _);
  printEquals(S(_), S(_));
  printMatches(a, U(a, P(b, S(c, d))))
  printMatches(P(b, d), U(a, P(b, S(c, d))))
  printMatches(P(a, b, c), P(a, S(a, b), U(b, U(c, d))))
  printMatches(P(a, b, c), P(a, S(a, b), U(b, S(c, d))))
  printEquals(q, q);
  printMatches(a, q);
  printMatches(P(a, b), P(q, q));
  printMatches(P(a, P(a, a)), P(q, P(q, q)));
  printMatches(U(a, b), U(a, b));
  printMatches(S(a, b), S(a, b));
  printMatches(U(a, b), U(a, U(b, c)));
  printMatches(U(a, b), U(a, U(b, c)));
  
  printMatches(u, l(a));
  printMatches((P(a,P(a,u))), l(a));
  printMatches((P(a,P(a,P(b,u)))), l(U(a,b)));
  
  
  print();
  printMatches(F(a,b), F(a,q));
  printMatches(F(a,P(a,b)), F(a,U(P(a,b),P(c,d))));

  printMatches(I(a, b), I(a, b));
  printMatches(I(a, a), I(a, U(a, b)));
  printMatches(I(a, b), I(a, U(a, b)));
  printMatches(I(a, b, c), I(a, b));
  printMatches(I(a, I(b, c)), I(a, b));
  printMatches(I(S(a), S(b), S(c)), I(S(a), S(b)));
  printMatches(I(S(a), I(S(b), S(c))), I(S(a), S(b)));
  printMatches(a, I(a, U(a, b)));



  
  print();
  print("true with rewriting semantics:");
  printMatches(U(P(a, a), P(a, b)), P(a, U(a, b)));
  printMatches(P(a, U(a, b)), U(P(a, a), P(a, b)));
  printMatches(F(a,F(b,c)), F(a,U(F(b,c), F(b,a))));


  print();
  print("false:");

  printMatches(a, b);
  printMatches(a, P(a, b));
  printEquals(P(a, b), P(b, a));
  printEquals(_, S(_));
  printEquals(S(a, S(b, c)), S(S(a, b), c));
  printMatches(a, I(a, b));
  printMatches(S(b, c), S(a, S(b, c)));
  printMatches(S(a, b, c), S(a, S(b, c)));
  printMatches(P(a, b, c), P(a, S(a, b), S(b, U(c, d))))
  printMatches(I(a, b), I(a, b, c));

  print();
  print("" + failed + " failed, " + succeeded + " succeeded");
}

testSpecials = function(){
  print();
  print("special values:");

  printEquals(u,u);
  printEquals(_,_);
  printEquals(q,q);
  
  printMatches(u,u);
  printMatches(_,u);
  printMatches(q,u);
  printMatches(u,_);
  printMatches(_,_);
  printMatches(q,_);
  printMatches(u,q);
  printMatches(_,q);
  printMatches(q,q);
}

test();
testSpecials();