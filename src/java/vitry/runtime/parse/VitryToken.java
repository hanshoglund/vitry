package vitry.runtime.parse;

import org.antlr.runtime.Token;

import vitry.runtime.Atom;

/**
 * Simple wrapper for CommonToken that displays, equals and matches its
 * text.
 */
public class VitryToken extends Atom
    {
        final Token tok;

        public VitryToken(Token tok) {
            this.tok = tok;
        }

        public boolean equals(Object o) {
            return tok.getText().equals(o.toString());
        }

        public String toString() {
            return tok.getText();
        }
    }
