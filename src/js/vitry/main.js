/* 
 * Vitry, copyright (c) Hans Höglund 2010, see COPYING.txt for details
 */

/**
 * Main script, bootstraps the module system.
 *
 * See http://wiki.commonjs.org/wiki/Modules/1.1.1 for details.
 * 
 * @author Hans Höglund 
 * @date 2010
 */
// ======================================================================

/*
 * Globals for the core.vitry module.
 */

var CLASSPATH = Packages;

var JAVA    = CLASSPATH.vitry.core.java;

var LANG    = {};

var MODULES = {};

/**
 * Returns the specified module or null if no such module could be found.
 *
 * @param id
 *    String identifying the module to load.
 * @param mixin
 *    Optional enumeration of objects to add to the global scope. These will
 *    replace any standard object (such as Array) of the same name.
 */
function require(id) {
  if (!MODULES[id]) {
    loadModule(id, LANG);
  }
  if (MODULES[id]) {
      return MODULES[id];
  } else {
      return null;
  }
}    

function requireFirst(id, mixin) {
  if (!MODULES[id]) {
    loadModule(id, mixin);
  }
  if (MODULES[id]) {
      return MODULES[id];
  } else {
      return null;
  }
}


/**
 * Loads a module (internal).
 */
function loadModule(id, mixin) {
  var exportObj = {};
  var moduleObj = { id : id };
  var requireObj = require.bind({});

  Object.defineProperty(requireObj, "main", { value : moduleObj });

  var global = {
    "module" : moduleObj,
    "exports" : exportObj,
    "require" : requireObj
  };

  if (mixin) {
    for (k in mixin) {
      global[k] = mixin[k];
    }
  }

  var script;
  if (script = JAVA.newInstanceForName(moduleIdToClass(id))) {
    MODULES[id] = exportObj;
    exec(script, global);
  } else {
    return undefined;
  }
}


function classToModuleId(cl) {
  var e = /([^.]*)\./g;
  var str = cl + ".";
  var parts = [];
  while (r = e.exec(str)) {
    if (!r[1]) {
      throw SyntaxError("Invalid Java Class.");
    }
    parts.push(r[1]);
  }
  return "/" + parts.join("/");
}


function moduleIdToClass(id) {
  var e = /\/([\w.]*)/g;
  var str = id[0] === "/" ? id : "/" + id;
  var parts = [];
  while (r = e.exec(str)) {
    if (!r[1]) {
      throw SyntaxError("Invalid Java Class.");
    }
    if (r[1].indexOf(".") > 0) {
      throw Error("Relative module identifiers not supported yet.");
    }
    parts.push(r[1]);
  }
  return parts.join(".");
}


/**
 * Executes the given script in a standard global context.
 *
 * @param script
 *    An instance of a class implementing org.mozilla.javascript.Script.
 * @param mixin
 *    Optional enumeration of objects to add to the global scope. These will
 *    replace any standard object (such as Array) of the same name.
 *
 */
function exec(script, mixin) {
  var ctxt = (new Packages.org.mozilla.javascript.ContextFactory()).enterContext();
  var global = ctxt.initStandardObjects();

  try {
    // Delete some java-specific stuff
    delete global.JavaException;
    delete global.With;
    delete global.Call;
    delete global.Script;
    delete global.Packages;
    delete global.java;
    delete global.javax;
    delete global.org;
    delete global.com;
    delete global.edu;
    delete global.net;
    delete global.getClass;
    delete global.JavaAdapter;
    delete global.JavaImporter;
    delete global.Continuation;
    delete global.Namespace;
    delete global.QName;
    delete global.Java;
  } catch (e){}

  if (mixin) {
    for (k in mixin) {
      global[k] = mixin[k];
    }
  }
  JAVA.executeScript(script, ctxt, global);
}



// ======================================================================
// Run application

requireFirst("vitry/core/vitry", {
    
  CLASSPATH : this.CLASSPATH,
  JAVA : this.JAVA,
  LANG : this.LANG,
  
  print : this.print
  
})
.main(arguments);

