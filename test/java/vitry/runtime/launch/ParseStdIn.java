//package vitry.runtime.launch;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.StringReader;
//
//import org.antlr.runtime.ANTLRReaderStream;
//import org.antlr.runtime.CommonTokenStream;
//import org.antlr.runtime.ParserRuleReturnScope;
//import org.antlr.runtime.RecognitionException;
//
//import vitry.runtime.parse.VitryTree;
//import vitry.runtime.parse.VitryTreeAdaptor;
//import vitry.runtime.parse.VitryLexer;
//import vitry.runtime.parse.VitryParser;
//
//
//public class ParseStdIn
//    {
//        public static void main(String[] args) {
//
//            // Read lines from std in
//
//            BufferedReader lineReader = new BufferedReader(new InputStreamReader(System.in));
//            String line;
//
//            try {
//                while ( (line = lineReader.readLine()) != null) {
//                    if (line.length() == 0) continue;
//
//                    VitryLexer lexer = new VitryLexer(new ANTLRReaderStream(new StringReader(
//                            line)));
//                    CommonTokenStream tokens = new CommonTokenStream(lexer);
//
//                    VitryParser parser = new VitryParser(tokens);
//                    parser.setTreeAdaptor(new VitryTreeAdaptor());
//
//                    try {
//                        ParserRuleReturnScope res = parser.expr();
//
//                        System.out.println(res.getTree());
//
//                    } catch (RecognitionException e) {
//                        e.printStackTrace();
//                    }
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//
//    }
