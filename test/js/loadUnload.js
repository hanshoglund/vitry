/*
load("~/macbook/Vitry/test/js/loadUnload.js") 
*/

importPackage(Packages.vitry.primitive);
       
iter = 1000;    
m = new ModuleClassLoader();

p = "se.hanshoglund.test.cl.gen.Dummy";
p2 = "se.hanshoglund.test.cl.gen2.Dummy";

loadClasses = function (cl, prefix) {
    for (i = 0; i < iter; i++) {
        cl.loadClass(prefix + i);
    }
}

unloadClasses = function (cl, prefix) {     
    var cl2 = cl;
    for (i = 0; i < iter; i++) {
        cl2 = cl2.unloadClass(prefix + i);
    }            
    return cl2;
}