package vitry.runtime.launch;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.BufferedTokenStream;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.TokenStream;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.HeaderTokenizer.Token;

import vitry.runtime.parse.IndentationTokenSource;
import vitry.runtime.parse.VitryLexer;


public class IndentFile
    {
        public static void main(String[] args) throws IOException {
            if (args.length < 1) {
                System.out.println("Args: file");
                System.exit(-1);
            }
            Reader input = new FileReader(args[0]);
            Lexer lexer = new VitryLexer(new ANTLRReaderStream(input));
//            TokenStream tokens = new CommonTokenStream(lexer);
            TokenStream tokens = new CommonTokenStream(new IndentationTokenSource(new BufferedTokenStream(lexer)));
            
            System.out.println(tokens);
        }


    }
