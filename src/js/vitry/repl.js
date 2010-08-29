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
 repl : repl,
};

// Visible functions    

function help() {
  
}

function quit() {           
  print("Bye!")
  java.lang.System.exit(0);
}


// ----------------------------------------------------------------------
       
function repl(prompt) {
  var consoleReader = new Packages.jline.ConsoleReader();
  var line;
  var res;

  // TODO auto completion    
  
  print("Try help(), show() or quit() if you get stuck");
  print();

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

var avoid = [ "exports", "module", "require", "repl", "avoid", "show" ];

function show(object) {
  Object.keys(object || this)
    .forEach(function(k) avoid.indexOf(k) < 0 ? print(k) : null);
}
