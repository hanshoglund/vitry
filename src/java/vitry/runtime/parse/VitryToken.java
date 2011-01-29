package vitry.runtime.parse;

import org.antlr.runtime.Token;

import vitry.runtime.Atom;

/**
 * Simple wrapper for CommonToken that displays, equals and matches as
 * its text. The string constructor is used to construct dummy tokens
 * used for matching.
 */
public class VitryToken extends Atom
    {
        final Token tok;
        final String str;

        public VitryToken(Token tok) {
            this.tok = tok;
            this.str = tok.getText();
        }
        
        public VitryToken(String str) {
            this.tok = null;
            this.str = str;
        }
        
        public boolean equals(Object o) {
            if (o instanceof VitryToken)
                return this.str == o.toString();
            return false;
        }
        
        /**
         * Returns the orginal token or null if this is a dummy.
         */
        public Token getToken() {
            return tok;
        }
        
        public int getType() {
            return tok.getType();
        }

        public String toString() {
            return str;
        }
    }
