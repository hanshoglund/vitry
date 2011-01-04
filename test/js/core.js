/*
load("~/macbook/Vitry/test/js/core.js") 
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

eq          = Vitry.eq;
match       = Vitry.match;
id          = Vitry.id;
arity       = Vitry.arity;
const_      = Vitry.const_;
add         = Vitry.add;
