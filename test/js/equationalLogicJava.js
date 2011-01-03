/*
load("~/macbook/Vitry/test/js/equationalLogicJava.js");
 */

importPackage(Packages.vitry.primitive);


P = Util.product;
S = Util.set;
U = Util.union;
I = Util.intersection;

s = Symbol.intern;
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
  if (result) succeeded++; else failed++;
  if (result && !y.equals(x))
    throw Error("Equality is not symmetric on " + x + " and " + y);
  print(pad("" + x + " = " + y, 35) + "=> " + result);
}
// Note argument order, mimicks the : expression
printMatches = function(x, y) {
  var result = x.matchFor(y);
  if (result) succeeded++; else failed++;
  print(pad("" + x + " : " + y, 35) + "=> " + result);
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
  
  printMatches(I(a, b), I(a, b));
  printMatches(I(a, a), I(a, U(a, b)));
  printMatches(I(a, b), I(a, U(a, b)));
  printMatches(I(a, b, c), I(a, b));
  printMatches(I(a, I(b, c)), I(a, b));
  printMatches(I(S(a),S(b),S(c)), I(S(a),S(b)));
  printMatches(I(S(a),I(S(b),S(c))), I(S(a),S(b)));
  
  printMatches(a, I(a, U(a, b)));

  // printMatches(F(a,F(b,c)), F(a,U(F(b,c), F(b,a))));


  print();
  print("false cases:");

  printMatches(a, b);
  printMatches(a, new P(a, b));
  printEquals(new P(a, b), new P(b, a));
  // printEquals(new S, new S(new S));
  printEquals(new S(a, new S(b, c)), new S(new S(a, b), c));
  printMatches(a, new I(a, b));
  printMatches(new S(b, c), new S(a, new S(b, c)));
  printMatches(new S(a, b, c), new S(a, new S(b, c)));
  printMatches(new P(a, b, c), new P(a, new S(a, b), new S(b, new U(c, d))))
  printMatches(new I(a, b), new I(a, b, c));

  print();
  print("" + failed + " failed, " + succeeded + " succeeded");
}

test();