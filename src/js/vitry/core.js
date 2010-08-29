/*
 * Vitry, copyright (c) Hans Höglund 2010, see COPYING.txt for details
 */

/**
 * Core data structures.
 *
 * @author Hans Höglund
 * @date 2010
 */
exports.addAll = {
  main: main
};

var require = JAVA.coreRequire( {
  Packages: null
});

function main(args) {
  print("Welcome " + args[0]);
}
