/*
 * Vitry, copyright (c) Hans Höglund 2010, see COPYING.txt for details
 */

// Some utilities for exports and require

Object.defineProperty(
  exports,
  "all", {
    set : function (from) {
      if (Array.isArray(from)) {
        if (from.length > 0 && from[0]) {
          var parent = from[0].__parent__;
          for (k in parent) {
            if (from.indexOf(parent[k]) > -1) {
              exports[k] = parent[k];
            }
          }
        }
      } else {
        for (k in from) exports[k] = from[k];
      }
    }
  }
);