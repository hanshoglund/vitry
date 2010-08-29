/*
 * Vitry, copyright (c) Hans Höglund 2010, see COPYING.txt for details
 */

// Some utilities for exports and require

Object.defineProperty(
  exports,
  "addAll", {
    set : function (from) {
      if (Array.isArray(from)) {
        // TODO
      } else {
        for (k in from) exports[k] = from[k];
      }
    }
  }
);