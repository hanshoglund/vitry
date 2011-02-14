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

import static java.lang.System.arraycopy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import vitry.runtime.util.Utils;


/**
 * Rewrites indentation as parentheses.
 * 
 * At the moment also handles comment stripping, this should be factored out.
 * Comments are indicate by any operator character at the beginning of a line
 * (no whitespace before).
 */
public class IndentationReader extends Reader
    {   
        /**
         * Operator characters (sorted!).
         */
        private static final char[] OP_CHARS = {
            '!', '#', '$', '%', '&', '\'', '*', '+', ',', '-',
            '.', '/', ':', ';', '<', '=', '>', '?', '@', '\\', '^', 
            '_', '|', '~'
        };
        
        private final Reader r;

        private Stack<Integer> levels = new Stack<Integer>();
        private Queue<Character> inserted = new LinkedList<Character>();
        
        private char[] line;
        private char[] ahead;
        
        private int lineCount;
        private int linePos;
        private int lineLen;
        private int aheadLen;

        private int added;
        

        public IndentationReader(Reader source) {
            this.r = source;
        }
        

        
        
        public int read(char[] buf, int off, int len) throws IOException {
            int n = 0;
            
            if (line == null) {
                // First line
                line = new char[12];
                ahead = new char[12];
                levels.push(1);
                lineCount = 0;
                
                readNextLine();
            }

            while (n < len && off + n < buf.length) {
                if (linePos >= lineLen-1) {
                    int nextIndent;
                    boolean nextIsComment;
                    boolean nextIsAllWhitespace;
                    
                    do {
                        if ((nextIndent = getNextLineIndent()) < 0 || readNextLine() < 0) {
                            while(n < len && off + n < buf.length && !inserted.isEmpty()) {
                                buf[off + n] = inserted.poll();
                                n++;
                            }
                            return -1;
                        }
                        
                        nextIsComment = aheadLen > 0 && isOpChar(ahead[0]);
                        nextIsAllWhitespace = true;
                        for(int i = 0; i < aheadLen; i++) {
                            nextIsAllWhitespace &= Character.isWhitespace(ahead[i]);
                        }
                        
                    } while (nextIsComment || nextIsAllWhitespace);
                    
//                    if (levels.peek() > nextIndent) {
//                        levels.push(nextIndent);
//                    }
//                    while (levels.size() > 1 && levels.peek() < nextIndent) {
//                        levels.pop();
//                        inserted.offer(')');
//                    }
//                    

                    while (levels.size() > 0 && nextIndent < levels.peek()) {
                        inserted.offer(')');
                        levels.pop();
                    }
                    if (levels.size() > 0 && nextIndent == levels.peek() && lineCount > 0) {
                        inserted.offer(')');
                    }
                    if (levels.size() > 0 && nextIndent > levels.peek()) {
                        levels.push(nextIndent);
                    }
                    inserted.offer('\n');
                    inserted.offer('(');    
                    lineCount++;
                    
                }
                
                if (!inserted.isEmpty()) {
                    buf[off + n] = inserted.poll();
                    n++;
                } else {
                    buf[off + n] = line[linePos];
                    linePos++;
                    n++;
                }
                    
            }
            return n;
        }
        
        /**
         * Reads characters into currentLine until a newline is encountered.
         * Resets linePos, lineLength and addedChars.
         */
        private int readNextLine() throws IOException {
            linePos = 0;
            added = 0;
            
            resizeLine(aheadLen);
            System.arraycopy(ahead, 0, line, 0, aheadLen);            

            if (aheadLen > 0 && line[aheadLen-1] == '\n') {
                lineLen = aheadLen;
            
            } else {
            
                int n = aheadLen;
                int c;
                do {
                    c = r.read();
                    resizeLine(n);
                    line[n++] = (char) c;
                } while (c > 0 && c != '\n');
                if (c < 0) return -1;
                lineLen = n;
            }
            return lineLen;
        }
        
        /**
         * Reads ahead into the next line until a non-whitespace element is
         * encountered. Returns the number of whitespace characters consumed or -1.
         * 
         * Assure we are at the beginning of a line before calling.
         */
        private int getNextLineIndent() throws IOException {
            int n = 0;
            int c;
            do {
                c = r.read();
                resizeAhead(n);
                ahead[n++] = (char) c;
            } while (c > 0 && (c == ' ' || c == '\t'));
            if (c < 0) return -1;
            aheadLen = n;
            return n;
        }
        




        private void resizeAhead(int n) {
            if (ahead.length <= n) {
                char[] a = new char[(int) (n * 1.8)];
                arraycopy(ahead, 0, a, 0, ahead.length);
                this.ahead = a;
            }
        }
        private void resizeLine(int n) {
            if (line.length <= n) {
                char[] a = new char[(int) (n * 1.8)];
                arraycopy(line, 0, a, 0, line.length);
                this.line = a;
            }
        }        


        
        
        public void close() throws IOException {
            r.close();
        }
        
//        
//        /**
//         * Returns the current position in the current line, not taking
//         * generated characters into account.
//         */
//        public int getLineNumber() {
//            return lineNum;
//        }
//        
//        /**
//         * Returns the current position in the current line, not taking
//         * generated characters into account.
//         */
//        public int getLinePosition() {
//            return linePos - lineAddedChars;
//        }


        
        
        

        private boolean isOpChar(char c) {
            return Arrays.binarySearch(OP_CHARS, c) >= 0;
        }
        
        
        
        
        
        
        public static void main(String[] args) throws IOException {
            Reader r = new InputStreamReader(ClassLoader.getSystemResourceAsStream("vitry/music/Time.vitry"));
            IndentationReader ir = new IndentationReader(r);
            BufferedReader br = new BufferedReader(ir);
            
            int c;
            while ( (c = ir.read()) >= 0) {
                System.out.write(c);
            }
//            String s;
//            while ( (s = br.readLine()) != null) {
//                System.out.println(s);
//            }


        }
        

    }
