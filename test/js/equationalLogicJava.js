/*
load("~/macbook/Vitry/test/js/equationalLogicJava.js");
 */

importPackage(Packages.vitry.runtime);


let fact = Packages.vitry.runtime.VitryRuntime;

P = fact.productOf;
S = fact.setOf;
U = fact.unionOf;
I = fact.intersectionOf;
// T = fact.type;
// F = fact.functionType;

s = Symbol.intern;
//l = (function(a) new ListType(a));
nil = VitryRuntime.NIL;
bot = VitryRuntime.BOTTOM;
any = VitryRuntime.ANY;

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
  printEquals(nil, nil);
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
  printMatches(nil, nil);
  printMatches(P(a, b), P(a, b));
  printMatches(a, U(a, b));
  printMatches(b, U(a, b));
  printMatches(a, I(a, a));
  printMatches(a, I(a, U(a, b)));
  printMatches(c, U(a, U(b, c)));
  printMatches(c, U(a, any));
  printMatches(a, S(a, b));
  printMatches(b, S(a, b));
  printMatches(a, S(a, S(b, c)));
  printEquals(bot, bot);
  printEquals(S(bot), S(bot));
  printMatches(a, U(a, P(b, S(c, d))))
  printMatches(P(b, d), U(a, P(b, S(c, d))))
  printMatches(P(a, b, c), P(a, S(a, b), U(b, U(c, d))))
  printMatches(P(a, b, c), P(a, S(a, b), U(b, S(c, d))))
  printEquals(any, any);
  printMatches(a, any);
  printMatches(P(a, b), P(any, any));
  printMatches(P(a, P(a, a)), P(any, P(any, any)));
  printMatches(U(a, b), U(a, b));
  printMatches(S(a, b), S(a, b));
  printMatches(U(a, b), U(a, U(b, c)));
  printMatches(U(a, b), U(a, U(b, c)));
  
//  printMatches(nil, l(a));
//  printMatches((P(a,P(a,nil))), l(a));
//  printMatches((P(a,P(a,P(b,nil)))), l(U(a,b)));
  
  
  print();
  // printMatches(F(a,b), F(a,any));
  // printMatches(F(a,P(a,b)), F(a,U(P(a,b),P(c,d))));

  printMatches(I(a, b), I(a, b));
  printMatches(I(a, a), I(a, U(a, b)));
  printMatches(I(a, b), I(a, U(a, b)));
  printMatches(I(a, b, c), I(a, b));
  printMatches(I(a, I(b, c)), I(a, b));
  printMatches(I(S(a), S(b), S(c)), I(S(a), S(b)));
  printMatches(I(S(a), I(S(b), S(c))), I(S(a), S(b)));
  printMatches(a, I(a, U(a, b)));
  printMatches(bot,S(a,a));
  printMatches(a, U(a,bot));
  printMatches(bot, I(a,bot));


  
  print();
  print("true with rewriting semantics:");
  printMatches(U(P(a, a), P(a, b)), P(a, U(a, b)));
  printMatches(P(a, U(a, b)), U(P(a, a), P(a, b)));
  // printMatches(F(a,F(b,c)), F(a,U(F(b,c), F(b,a))));


  print();
  print("false:");

  printMatches(a, b);
  printMatches(a, P(a, b));
  printEquals(P(a, b), P(b, a));
  printEquals(bot, S(bot));
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

  printEquals(nil,nil);
  printEquals(bot,bot);
  printEquals(any,any);
  
  printMatches(nil,nil);
  printMatches(bot,nil);
  printMatches(any,nil);
  printMatches(nil,bot);
  printMatches(bot,bot);
  printMatches(any,bot);
  printMatches(nil,any);
  printMatches(bot,any);
  printMatches(any,any);
}

test();
testSpecials();

