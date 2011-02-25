package vitry.runtime.launch;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.TokenStream;

import vitry.runtime.parse.Indentation;
import vitry.runtime.parse.VitryLexer;
import vitry.runtime.parse.VitryToken;


public class IndentFile
    {
        public static void main(String[] args) throws IOException {
            if (args.length < 1) {
                System.out.println("Args: file");
                System.exit(-1);
            }
            Reader input = new FileReader(args[0]);
            Lexer lexer = new VitryLexer(new ANTLRReaderStream(input));
            Indentation indent = new Indentation(lexer);
            
//            indent.setStartToken(new CommonToken(0, "{"));
//            indent.setEndToken(new CommonToken(0, "}"));
//            indent.setPreserveSpace(false);
//            indent.setInlineEnabled(false);
//            indent.setEncloseEnabled(false);
            
            TokenStream tokens = new CommonTokenStream(indent);
          
            System.out.println(tokens);
        }


    }
