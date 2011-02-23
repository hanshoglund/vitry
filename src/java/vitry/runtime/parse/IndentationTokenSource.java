package vitry.runtime.parse;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.antlr.runtime.BufferedTokenStream;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenSource;

/**
 * FIXME
 *      Single lines (sometimes?) emit one ) to much.
 * 
 * TODO
 *      Strip trailing whitespace as an option (for debugging).
 */
public class IndentationTokenSource implements TokenSource
    {       
                
        private static final CommonToken PAR_LEFT = new CommonToken(VitryTokenTypes.PL, "(");
        private static final CommonToken PAR_RIGHT = new CommonToken(VitryTokenTypes.PR, ")");

        private static final CommonToken SPACE = new CommonToken(VitryParser.LineSpace, " ");
        private static final CommonToken BREAK = new CommonToken(VitryParser.LineBreak, "\n");
        static {
            SPACE.setChannel(VitryLexer.HIDDEN_CHANNEL);
            SPACE.setChannel(VitryLexer.HIDDEN_CHANNEL);
        }


        private final BufferedTokenStream input;
        
        private Stack<Integer> levels = new Stack<Integer>();
        private List<Token> currentLine = new ArrayList<Token>();
        private int pos;
        private int linesEmitted = 0;

        /**
         * When this flag is set, act as if indentation is same as previous
         * line.
         */
        private boolean postEnclose = false;
        

        public IndentationTokenSource(BufferedTokenStream input) {
            this.input = input;
            this.levels.push(0);
        }
        
        public String getSourceName() {
            return input.getSourceName();
        }
        
        /**
         * Returns the next token, or a token of type Token.EOF if all
         * tokens have been read.
         */
        public Token nextToken() {
            if (pos >= currentLine.size()) {
                nextLine();
            }
            Token t = currentLine.get(pos);
            if (!isEof(t.getType())) {
                pos++;
            }
//System.err.println(t);
            return t;
        }


        /**
         * Read next line and fill buffer.
         */
        private void nextLine() {
            Token t;
            int indent = 0;

            currentLine.clear();

            /**
             * Consume as many space characters as possible. 
             * Track indent (number of tokens following last line break).
             */
            while (true) {
                indent = 0;
                while (isLineBreak(input.LA(1))) {
                    input.consume();
                }
                while (isLineSpace(input.LA(1))) {
                    input.consume();
                    indent++;
                }
                if (isComment(input.LA(1))) {
                    input.consume();
                    continue;
                }
                if (isLineBreak(input.LA(1))) {
                    continue;
                }
                break;
            };
            
            if (isEof(input.LA(1))) {
                finish();
                return;
            }

            boolean isInline = isOp(input.LA(1));


            if (!isInline) {
            
                /*
                 * Emit closing parentheses for previous line
                 */
                if (postEnclose) {
//System.err.println(input.LT(1));
//System.err.println(indent);
                    
                    currentLine.add(PAR_RIGHT);
//                    levels.push(indent + 1); 
                    postEnclose = false;

                    
                }
                while (levels.size() > 1 && indent < levels.peek() && linesEmitted >= 1) {
                    currentLine.add(PAR_RIGHT);
                    levels.pop();
                }
                if (levels.size() > 0 && indent == levels.peek() && linesEmitted >= 1) {
                    currentLine.add(PAR_RIGHT);                    
                }
                if (levels.size() > 0 && indent > levels.peek()) {
                    levels.push(indent);
                }
                
            
                /**
                 * Emit break and indent for current line.
                 */
                if (linesEmitted >= 1) {
                    currentLine.add(BREAK);
                }

                for (int i = 0; i < indent; i++) {
                    currentLine.add(SPACE);
                }
                if (postEnclose && levels.peek() != 0) {
                    currentLine.add(SPACE);
                }
    
                currentLine.add(PAR_LEFT);
            } else {
                currentLine.add(SPACE);
            }
            
//            postEnclose = false;
            
            
            /**
             * Should we enclose rest of line in an additional pair of
             * brackets?
             */
            boolean enclose = false;
            int encloseStart = -1;
            
            /**
             * Possible if we are some special top level declarations
             * Also possible if we see a keyword
             */
            if (
                (levels.peek() == 0 && !isSingleTopLevel(input.LA(1))) 
                || isKeyword(input.LA(1))
            ) {    
                /**
                 * Track the next non-space token
                 * If this is a (OP) style expression, skip the token and pars
                 */
                if (isLeftDelim(input.LA(1))) {
                    encloseStart = 4;
                } else {
                    encloseStart = 2;
                }
                
                int la = -1;
                do {
                    la = input.LA(encloseStart++);
                } while (isLineSpace(la));
                
                /**
                 * If the line is not finished and we do not see =, then we enclose.
                 */
                enclose = !isLineBreak(input.LA(encloseStart-1)) && !isEq(input.LA(encloseStart-1));
            }

            /**
             * Emit rest of line.
             */
            if (enclose) {
                for (int i=1; i < encloseStart-1; i++) {
                    currentLine.add(input.LT(i));
                }
                for (int i=1; i < encloseStart-1; i++) {
                    input.consume();
                }
                
                if (!isInline) {
                    currentLine.add(PAR_LEFT);                    
                }
                
                do {
                    t = input.LT(1);
                    currentLine.add(t);
                    input.consume();
                } while (!isEof(input.LA(1)) && !isLineBreak(input.LA(1)));                

                postEnclose = true;
            
            } else {

                do {
                    t = input.LT(1);
                    currentLine.add(t);
                    input.consume();
                } while (!isEof(input.LA(1)) && !isLineBreak(input.LA(1)));
            }

            if (isEof(input.LA(1))) {
                finish();
                return;
            }
            linesEmitted++;
            pos = 0;
        }
        
        
        /**
         * Close all open parentheses and emit EOF.
         */
        private void finish() {
            while (levels.size() > 0) {
                currentLine.add(PAR_RIGHT);
                levels.pop();
            }
            currentLine.add(BREAK);
            currentLine.add(Token.EOF_TOKEN);
            pos = 0;
            return;
        }
        
        /**
         * Escape the enclosing mechanism.
         */
        private static boolean isSingleTopLevel(int a) {
            return a == VitryTokenTypes.MODULE;
        }

        private boolean isEq(int a) {
            return a == VitryTokenTypes.EQ;
        }
        
        private static boolean isLeftDelim(int a) {
            return a == VitryTokenTypes.PL 
                || a == VitryTokenTypes.BL 
                || a == VitryTokenTypes.AL;
        }

        private static boolean isKeyword(int a) {
            return a == VitryTokenTypes.DO
                || a == VitryTokenTypes.LET
                || a == VitryTokenTypes.MATCH
                || a == VitryTokenTypes.TYPE
                || a == VitryTokenTypes.IMPLICIT;
        }

        private static boolean isOp(int a) {
            return a == VitryParser.Op;
        }

        private static boolean isComment(int a) {
            return a == VitryParser.Comment;
        }

        private static boolean isLineSpace(int a) {
            return a == VitryParser.LineSpace;
        }

        private static boolean isLineBreak(int a) {
            return a == VitryParser.LineBreak;
        }

        private static boolean isEof(int a) {
            return a == Token.EOF;
        }

    }
