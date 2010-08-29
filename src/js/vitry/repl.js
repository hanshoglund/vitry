/*
 * Vitry, copyright (c) Hans Höglund 2010, see COPYING.txt for details
 */

/**
 * Provides the music model.
 *
 * @author Hans Höglund
 * @date 2010
 */
exports.addAll = {
 repl : repl
};


function repl(prompt) {
  var consoleReader;
  var line;
  var res;

  consoleReader = new Packages.jline.ConsoleReader();

  // TODO auto completion

  while (true) {
    line = consoleReader.readLine(prompt);
    try {
      res = eval("" + line);
      res === undefined || print(res);
    } catch (e) {
      print(e.constructor.name + ": " + e.message);
    }
  }
}

var avoid = [ "exports", "module", "require", "show", "repl", "avoid" ];

function show(object) {
  Object.keys(object || this)
    .forEach(function(k) avoid.indexOf(k) < 0 ? print(k) : null);
}
