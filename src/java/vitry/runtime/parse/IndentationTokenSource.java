package vitry.runtime.parse;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.antlr.runtime.BufferedTokenStream;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenSource;


public class IndentationTokenSource implements TokenSource
    {
        public static final int PAR_LEFT_TYPE = VitryParser.T__34;
        public static final int PAR_RIGHT_TYPE = VitryParser.T__35;


        private static final CommonToken PAR_LEFT = new CommonToken(PAR_LEFT_TYPE, "(");
        private static final CommonToken PAR_RIGHT = new CommonToken(PAR_RIGHT_TYPE, ")");

private static final CommonToken DUMMY = new CommonToken(VitryParser.LineSpace, "#");
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


        public IndentationTokenSource(BufferedTokenStream input) {
            this.input = input;
            this.levels.push(0);
        }

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
         * Read tokens form next line and fill buffer.
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
//System.err.println(input.LT(1));
//System.err.println(input.LT(2));
//System.err.println(input.LT(3));
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

            /*
             * Emit closing parentheses for previous line
             */
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
             
            // TODO skip if inline
            currentLine.add(PAR_LEFT);
            
            
            /**
             * Should we enclose rest of line in an additional pair of
             * brackets?
             */
            boolean enclose = false;
            int encloseStart = 0;
            
            if ((!isSingleTopLevel(input.LA(1)) && levels.peek() == 0) 
                    || isKeyword(input.LA(1))) {    
                if (isLeftParen(input.LA(1))) {
                    encloseStart = 4;
                } else {
                    encloseStart = 2;
                }
                
                int la = -1;
                do {
                    la = input.LA(encloseStart++);
                } while (isLineSpace(la));
                if (!isLineBreak(input.LA(encloseStart-1)) 
                    && !(input.LA(encloseStart-1) == 47)) {
//currentLine.add(DUMMY);                    
                    enclose = true;
                }
            }

            /**
             * Emit rest of line.
             */
            if (enclose) {
System.err.println(input.LT(encloseStart-1));
                for (int i=1; i < encloseStart-1; i++) {
                    currentLine.add(input.LT(i));
                }
                for (int i=1; i < encloseStart-1; i++) {
                    input.consume();
                }
                
                currentLine.add(PAR_LEFT);
                
                do {
                    t = input.LT(1);
                    currentLine.add(t);
                    input.consume();
                } while (!isEof(input.LA(1)) && !isLineBreak(input.LA(1)));                

                currentLine.add(PAR_RIGHT);
            
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
        

        private boolean isSingleTopLevel(int i) {
            return i == VitryParser.T__48;
        }
        private boolean isKeyword(int i) {
            return i == VitryParser.Do
                || i == VitryParser.Let
                || i == VitryParser.Match; // TODO type, implicit
        }

        private boolean isLeftParen(int la) {
            return la == 34 || la == 36 || la == 38;
        }

        
        private boolean isComment(int la) {
            return la == VitryParser.Comment;
        }

        private boolean isLineSpace(int a) {
            return a == VitryParser.LineSpace;
        }

        private boolean isLineBreak(int a) {
            return a == VitryParser.LineBreak;
        }

        private boolean isEof(int a) {
            return a == Token.EOF;
        }


        public String getSourceName() {
            return input.getSourceName();
        }
    }
