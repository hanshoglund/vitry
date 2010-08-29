/*
 * Vitry, copyright (c) Hans Höglund 2010, see COPYING.txt for details
 */

exports.addAll = {
 repl : repl,
};

var core = require("vitry/core");


// Visible

function help() {
  print();
  print("   show()     Displays all objects and functions in the current scope");
  print();
}

function quit() {
  print("Bye!")
  Packages.java.lang.System.exit(0);
}

function version() {
  return core.version();
}

function repl(prompt) {

  var consoleReader = new Packages.jline.ConsoleReader();
  var line;
  var res;

  var scope = {
    show:show,
    help:help,
    quit:quit,
    version:version
  };

  function show(object) {
    Object.keys(object || scope)
      .forEach(function(k) print(k));
  }

  // TODO auto completion

  print();

  while (true) {
    line = consoleReader.readLine(prompt);
    try {
      res = eval("" + line, scope);
      res === undefined || print(res);
    } catch (e) {
      print(e.constructor.name + ": " + e.message);
    }
  }
}


