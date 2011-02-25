/*
 * Vitry, copyright (C) Hans Hoglund 2011
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * See COPYING.txt for details.
 */
package vitry.runtime.parse;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.antlr.runtime.*;

/**
 * An implementation of TokenSource that inserts special tokens representing
 * indent levels. The rewriting rules are straightforward:
 *
 * - The indent level of a line is the number of space or tab 
 *   tokens preceding its first non-whitespace token. Blank lines are ignored.
 * 
 * - For each line, one start token is emitted, followed by the contents of
 *   the line, followed by eventual end tokens. The number of end tokens to
 *   emit is determined as follows:
 *      - If the indent level of the next line is increasing, emit 0 end tokens
 *        and push the indent level of the next line on the level stack.
 *      - If the indent level of the next line is unchanged, emit 1 end token.
 *      - If the indent level of the next line is decreasing, emit n end token
 *        where n is the number of levels on the level stack that are greater
 *        than or equal to the indent level of the next line; then pop n-1 levels
 *        off the level stack.
 *
 * - If the first non-space token of a line is an operator, that line is threated
 *   as an extension of the previous line, and no extra tokens are emitted.
 *
 * - If the first non-space token of a line is a symbol or one of the keywords
 *   <em>import</em>, <em>type</em>, <em>implicit</em>, <em>infix</em>, <em>let</em> or <em>do</em>, 
 *   and the immediatly following token is not =, then all tokens of the line 
 *   except the first are threated as a separate line with indent level n+1, 
 *   where n is the indent level of the current line. 
 *
 *
 *
 * Usage:
 * <pre>
 *     Lexer lexer = new VitryLexer(...);
 *     TokenStream tokens = new CommonTokenStream(new Indentation(lexer));
 * </pre>
 * 
 * 
 * @author Hans Höglund
 */
public class Indentation implements TokenSource
    {       
        
        private final BufferedTokenStream input;

        
        // Setup
                 
        /*
         * Tokens to emit at start and end of lines
         */
        private Token startToken = new CommonToken(VitryTokenTypes.PL, "(");
        
        private Token endToken   = new CommonToken(VitryTokenTypes.PR, ")");
        
        /**
         * If true, this class emits whitespace tokens mimicking the original
         * layout (useful for debugging)
         */
        private boolean preserveSpace = true;
        
        /**
         * Enables or disables the inline rule.
         */
        private boolean inlineEnabled = true;
        
        /**
         * Enables or disables the enclose rule.
         */
        private boolean encloseEnabled = true;
        

        // Internal state
        
        private Stack<Integer> levelStack = new Stack<Integer>();
        
        private List<Token> buffer = new ArrayList<Token>();
        
        /**
         * Number of tokens read from buffer.
         */
        private int count = 0;
        
        /**
         * Number of lines read from buffer.
         * The number of lines written to buffer is always (lineCount + 1).
         */
        private int lineCount = -1;
        
        /**
         * Indent levels carrying over from previous lines.
         * (This is necessary for the inlining to work).
         */
        private int carry = 0;
        
        
        
        
        public Indentation(TokenSource input) {
            this(new BufferedTokenStream(input));
        }

        public Indentation(BufferedTokenStream input) {
            this.input = input;
            this.levelStack.push(0);
        }
        
        
        
        public String getSourceName() {
            return input.getSourceName();
        }

        public Token getStartToken() {
            return startToken;
        }

        public Token getEndToken() {
            return endToken;
        }

        public boolean isPreservingSpace() {
            return preserveSpace;
        }

        public boolean isInlineEnabled() {
            return inlineEnabled;
        }

        public boolean isEncloseEnabled() {
            return encloseEnabled;
        }

        public int getCount() {
            return count;
        }

        public int getLineCount() {
            return lineCount;
        }

        public void setStartToken(Token startToken) {
            this.startToken = startToken;
        }

        public void setEndToken(Token endToken) {
            this.endToken = endToken;
        }

        public void setPreserveSpace(boolean preserveSpace) {
            this.preserveSpace = preserveSpace;
        }

        public void setInlineEnabled(boolean inlineEnabled) {
            this.inlineEnabled = inlineEnabled;
        }

        public void setEncloseEnabled(boolean encloseEnabled) {
            this.encloseEnabled = encloseEnabled;
        }
        
        
        

        /**
         * Returns the next token, pulling lines from the input
         * as necessary.
         */
        public Token nextToken() {
            if (count >= buffer.size()) {
                nextLine();
                lineCount++;
            }
            Token t = buffer.get(count);

            if (t.getType() != Token.EOF) {
                count++;
            }
            return t;
        }


        /**
         * Append the next line and eventual added tokens to the buffer.
         */
        private void nextLine() {
            
            // Clearing does not affect operation, this is CPU vs. heap
//            buffer.clear();
//            count = 0;

            int indent = consumeIndent();
            
            if (nextIsEOF()) {
                finish();
                return;
            }

            if (inlineEnabled && nextIsOp()) {
                if (preserveSpace) {
                    buffer.add(SPACE);
                }
                emitRestOfLine();

                if (nextIsEOF()) {
                    finish();
                }
                return;
            }

            int n = indent;
            while (carry > 0) {
                levelStack.push(++n);
                carry--;
            }

            while (levelStack.size() > 1 && indent < levelStack.peek() && lineCount >= 0) {
                buffer.add(endToken);
                levelStack.pop();
            }
            if (levelStack.size() > 0 && indent == levelStack.peek() && lineCount >= 0) {
                buffer.add(endToken);
            }
            if (levelStack.size() > 0 && indent > levelStack.peek()) {
                levelStack.push(indent);
            }       
            if (preserveSpace) {
                if (lineCount >= 0) {
                    buffer.add(BREAK);
                }
                for (int i = 0; i < indent; i++) {
                    buffer.add(SPACE);
                }
            }
            buffer.add(startToken);
        
            
            if (encloseEnabled) {
                
                Token t;
                do {
                    t = input.LT(1);
                    buffer.add(t);
                    input.consume();
                    
                    if (onlySpaceRemaining()) {
                        continue;
                    }
                    
                    int tt = t.getType();
                    if (tt == VitryTokenTypes.LET
                     || tt == VitryTokenTypes.DO
                     || tt == VitryTokenTypes.IMPORT
                     || tt == VitryTokenTypes.TYPE
                     || tt == VitryTokenTypes.IMPLICIT
                     || tt == VitryTokenTypes.INFIX) 
                    {
                        if (nextIsLineSpace()) {
                            input.consume();
                            buffer.add(SPACE);
                        }
                        buffer.add(startToken);
                        carry++;
                    }
                } while (!nextIsEOF() && !nextIsLineBreak());
            
            } else {
                emitRestOfLine();                
            }

            if (nextIsEOF()) {
                finish();
                return;
            }
        }
            
            
            /**
             * Possible if we are some special top level declarations
             * Also possible if we see a keyword
             */
//            if (
//                (levelStack.peek() == 0 && !isSingleTopLevel(input.LA(1))) 
//                || isKeyword(input.LA(1))
//            ) {    
//                /**
//                 * Track the next non-space token
//                 * If this is a (OP) style expression, skip the token and pars
//                 */
//                if (isLeftDelim(input.LA(1))) {
//                    encl = 4;
//                } else {
//                    encl= 2;
//                }
//                
//                int la = -1;
//                do {
//                    la = input.LA(encl++);
//                } while (isLineSpace(la));
//
//                if (!isLineBreak(input.LA(encl-1)) && !isEq(input.LA(encl-1))) {
//                    for (int i=1; i < encl-1; i++) {
//                        buffer.add(input.LT(i));
//                    }
//                    for (int i=1; i < encl-1; i++) {
//                        input.consume();
//                    }
//                    buffer.add(startToken);
//                    carry++;
//                    
//                }
//                if (inputIsAtEnd()) {
//                    finish();
//                    return;
//                }            
//            }
            

        
        

        private int consumeIndent() {
            int indent;
            while (true) {
                indent = 0;
                while (nextIsLineBreak()) {
                    input.consume();
                }
                while (nextIsLineSpace()) {
                    input.consume();
                    indent++;
                }
                if (nextIsComment()) // FIXME Assumes only line-comments
                {
                    input.consume();
                    continue;
                }
                if (nextIsLineBreak()) {
                    // Skip empty line
                    continue;
                }
                break;
            }
            return indent;
        }
        
        private boolean onlySpaceRemaining() {
            int i = 0, t = 0;
            do {
                t = input.LA(++i);
            } while (t == VitryParser.LineSpace || t == VitryParser.Comment);
            return input.LA(i) == VitryParser.LineBreak;
        }

        private void emitRestOfLine() {
            Token t;
            do {
                t = input.LT(1);
                buffer.add(t);
                input.consume();
            } while (!nextIsEOF() && !nextIsLineBreak());
        }
        
        
        /**
         * Emit closeing tokens for all levels on the stack and EOF.
         */
        private void finish() {
            while (levelStack.size() > 0) {
                buffer.add(endToken);
                levelStack.pop();
            }
            if (preserveSpace) {
                buffer.add(BREAK);
            }
            buffer.add(Token.EOF_TOKEN);
            count = 0;
            return;
        }


        private boolean nextIsOp() {
            return input.LA(1) == VitryParser.Op;
        }

        private boolean nextIsComment() {
            return input.LA(1) == VitryParser.Comment;
        }

        private boolean nextIsLineSpace() {
            return input.LA(1) == VitryParser.LineSpace;
        }

        private boolean nextIsLineBreak() {
            return input.LA(1) == VitryParser.LineBreak;
        }

        private boolean nextIsEOF() {
            return input.LA(1) == Token.EOF;
        }
        
        

        private static final CommonToken SPACE = new CommonToken(VitryParser.LineSpace, " ");
        
        private static final CommonToken BREAK = new CommonToken(VitryParser.LineBreak, System.getProperty("line.separator"));
        
        static {
            SPACE.setChannel(Token.HIDDEN_CHANNEL);
            SPACE.setChannel(Token.HIDDEN_CHANNEL);
        }
    }





//class TracingTokenStream extends BufferedTokenStream
//    {
//        public TracingTokenStream(TokenSource ts) {
//            super(new TracingTokenSource(ts));
//        }
//    }
//
//
//class TracingTokenSource implements TokenSource
//    {        
//        private final TokenSource ts;
//
//        public TracingTokenSource(TokenSource ts) {
//            this.ts = ts;
//        }
//
//        public String getSourceName() {
//            return ts.getSourceName();
//        }
//
//        public Token nextToken() {
//            Token t = ts.nextToken();
//            System.err.println(t);
//            return t;
//        }
//
//    }
