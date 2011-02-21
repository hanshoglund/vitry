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

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PushbackReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.Stack;


/**
 * Rewrites indentation as parentheses.
 * 
 * At the moment also handles comment stripping, this should be factored out.
 * Comments are indicated by a comment character at the beginning of a line.
 */
public class IndentationReader extends Reader
    {   
        /**
         * Comment characters (sorted!).
         */
        private static final char[] COMMENT_CHARS = {
            ';'
        };
        
        private Stack<Integer> levels;
        private final   PushbackReader input;
        private char[]  buffer;
        private int     length = 0;
        private int     position = 0;
        private int     linesRead = 0;
        private int     linesEmitted = 0;
        private int     charactersAdded = 0;
        private boolean finished = false;
        

        public IndentationReader(Reader input) {
            this.input = new PushbackReader(input, 2);
            this.levels = new Stack<Integer>();     
            this.buffer = new char[80];
            this.levels.push(0);
        }

        
        public int read() throws IOException {
            if (position >= this.length) {
                if (finished)
                    return -1;
                nextLine();
            }
            return buffer[position++];
        }
        
        public int read(char[] sink, int offset, int length) throws IOException {
            // FIXME temporary
            int count = 0;
            int c;
            while (count < length) {
                c = this.read();
                if (c < 0) return -1;
                sink[offset+count] = (char) c;
                count++;
            }
            return count;
            
//            int count = 0;
//            int max = min(length, sink.length - offset);
//
//            while (count < max) {
//                if (position >= this.length) {
//                    if (finished)
//                        return -1;
//                    nextLine();
//                }
//                
//                sink[count + offset] = buffer[position];
//                position++;
//                count++;
//            }
//            if (count > 0) {
//                return count;
//            } else {
//                return -1;
//            }
        }
        
        /**
         * Returns the line number in input.
         */
        public int getLineNumber() {
            return linesRead + 1;
        }

        /**
         * Returns the position in the current input line.
         * Generated characters are not considered.
         */
        public int getLinePosition() {
            return position - charactersAdded; // TODO
        }          
        
        public void close() throws IOException {
            input.close();
        }
        
        
        
        
        // Implementation

        /**
         * Fill buffer with characters, from the next line
         * Reset position and end
         */
        private void nextLine() throws IOException {
            int n = 0;
            int indent;
            boolean skip;

            /*
             * Consume line break, empty or comment lines
             * Consume and count initial whitespace
             */
            do {
                while(consumeBreak() > 0) linesRead++;
                indent = consumeLineSpace();
                
                skip = (isCommentChar(peek()) || peek() == '\n');
                while (skip && readLineChar() >= 0);
                
            } while (!finished && skip);
            
            /*
             * Emit closing parentheses for previous line
             */            
            while (levels.size() > 1 && indent < levels.peek() && linesEmitted >= 1) {
                setBuffer(n++, ')');
                levels.pop();
            }
            if (levels.size() > 0 && indent == levels.peek() && linesEmitted >= 1) {
                setBuffer(n++, ')');
            }
            if (levels.size() > 0 && indent > levels.peek()) {
                levels.push(indent);
            }
            
            if (!finished) {
                if (linesEmitted >= 1) 
                    setBuffer(n++, '\n');

                linesEmitted++;

                for (int i = 0; i < indent; i++)
                    setBuffer(n++, ' ');
                    
                setBuffer(n++, '(');
            }
                
            /*
             * Emit rest of line
             */
            int c;
            while (true) {
                c = readLineChar();
                if (c >= 0 && c != 0xffff) { // FIXME
                    setBuffer(n++, (char) c);
                } else {                    
                    break;
                }
            }
            if (finished) {
                while (levels.size() > 1) {
                    setBuffer(n++, ')');
                    levels.pop();
                }
                setBuffer(n++, '\n');
            }
            
            position = 0;
            length = n;
        }
        
        /**
         * Returns the next character to be read.
         */
        private int peek() throws IOException {
            int a = input.read();
            input.unread(a);
            return a;
        }

        /**
         * Read the next character if if is not a line break.
         * Returns the character or -1.
         */
        private int readLineChar() throws IOException {
            int a = input.read();
            if (a < 0) {
                finished = true;
                return a;
            }
            if (a == '\n' || a == '\r') {
                input.unread(a);
                return -1;
            }
            return a;
        }
        
        /**
         * Consume one line break (\n or \r or \n\r).
         * Returns the number of characters consumed (0-2).
         */
        private int consumeBreak() throws IOException {
            int a = input.read();
            int b = input.read();
            if (b < 0) {
                finished = true; 
                return 0;
            }
            if (a == '\n' && b == '\r') return 2;
            input.unread(b);
            if (a == '\n' || a == '\r') return 1;
            input.unread(a);
            return 0;
        }

        
        /**
         * Consume any number of space characters (' ' or \t)
         * Returns the number of characters consumed.
         */
        private int consumeLineSpace() throws IOException {
            int n = 0;
            int c;
            do {
                c = input.read();
                n++;
            } while (c >= 0 && c == ' ' || c == '\t'); 
            if (c < 0) {
                finished = true;
                return 0;
            } else {
                input.unread(c);
                n--;
            }
            return n;
        }


        private void setBuffer(int n, char c) {
            if (buffer.length <= n) {
                char[] a = new char[(int) (n * 1.8)];
                System.arraycopy(buffer, 0, a, 0, buffer.length);
                this.buffer = a;
            }
            buffer[n] = c;
        }        
           

        private boolean isCommentChar(int i) {
            return Arrays.binarySearch(COMMENT_CHARS, (char) i) >= 0;
        }
        
        
        
        
        public static void main(String[] args) throws IOException {
            Reader r = new InputStreamReader(ClassLoader.getSystemResourceAsStream("Vitry/Music/Time.vitry"));
            IndentationReader ir = new IndentationReader(r);

//            char[] cs = new char[20];
//            while (ir.read(cs, 0, 1) > 0) {
//                System.out.print(cs);
//            }
//            System.out.flush();
            
            int c;
            while ( (c = ir.read()) >= 0) {
                System.out.write(c);
            }
            
            while ( (c = ir.read()) >= 0) {
                if (c == 'q') {
                    System.out.println("Line: " + ir.getLineNumber());
                    System.out.println("Pos: "  + ir.getLinePosition());
                }
            }
            System.out.flush();
        }
    }
