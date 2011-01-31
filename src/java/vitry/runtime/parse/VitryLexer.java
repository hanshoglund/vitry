// $ANTLR 3.2 Sep 23, 2009 12:02:23 src/antlr/Vitry.g 2011-02-01 00:22:00
package vitry.runtime.parse;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class VitryLexer extends Lexer {
    public static final int TypeDecl=22;
    public static final int Ops=21;
    public static final int MemberDecl=25;
    public static final int Module=7;
    public static final int Where=10;
    public static final int Exponent=32;
    public static final int Quote=13;
    public static final int EOF=-1;
    public static final int HexDigit=35;
    public static final int Recur=19;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int Assign=11;
    public static final int Let=9;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__59=59;
    public static final int Left=12;
    public static final int OctalEsc=37;
    public static final int Do=20;
    public static final int UnicodeEsc=36;
    public static final int Ang=6;
    public static final int Bra=5;
    public static final int Op=31;
    public static final int String=30;
    public static final int Symbol=26;
    public static final int Whitespace=33;
    public static final int T__50=50;
    public static final int If=16;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int FnDecl=24;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int Type=15;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int Natural=27;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int Complex=29;
    public static final int Apply=14;
    public static final int ImplicitDecl=23;
    public static final int Float=28;
    public static final int EscapeSeq=34;
    public static final int Match=17;
    public static final int T__38=38;
    public static final int Par=4;
    public static final int T__39=39;
    public static final int Fn=8;
    public static final int Loop=18;



    // delegates
    // delegators

    public VitryLexer() {;} 
    public VitryLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public VitryLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "src/antlr/Vitry.g"; }

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/antlr/Vitry.g:11:7: ( ':' )
            // src/antlr/Vitry.g:11:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/antlr/Vitry.g:12:7: ( '(' )
            // src/antlr/Vitry.g:12:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/antlr/Vitry.g:13:7: ( ')' )
            // src/antlr/Vitry.g:13:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/antlr/Vitry.g:14:7: ( '[' )
            // src/antlr/Vitry.g:14:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/antlr/Vitry.g:15:7: ( ']' )
            // src/antlr/Vitry.g:15:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/antlr/Vitry.g:16:7: ( '{' )
            // src/antlr/Vitry.g:16:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/antlr/Vitry.g:17:7: ( '}' )
            // src/antlr/Vitry.g:17:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/antlr/Vitry.g:18:7: ( '`' )
            // src/antlr/Vitry.g:18:9: '`'
            {
            match('`'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/antlr/Vitry.g:19:7: ( 'fn' )
            // src/antlr/Vitry.g:19:9: 'fn'
            {
            match("fn"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/antlr/Vitry.g:20:7: ( 'let' )
            // src/antlr/Vitry.g:20:9: 'let'
            {
            match("let"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/antlr/Vitry.g:21:7: ( 'loop' )
            // src/antlr/Vitry.g:21:9: 'loop'
            {
            match("loop"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/antlr/Vitry.g:22:7: ( 'do' )
            // src/antlr/Vitry.g:22:9: 'do'
            {
            match("do"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/antlr/Vitry.g:23:7: ( 'if' )
            // src/antlr/Vitry.g:23:9: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/antlr/Vitry.g:24:7: ( 'else' )
            // src/antlr/Vitry.g:24:9: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/antlr/Vitry.g:25:7: ( 'match' )
            // src/antlr/Vitry.g:25:9: 'match'
            {
            match("match"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/antlr/Vitry.g:26:7: ( 'recur' )
            // src/antlr/Vitry.g:26:9: 'recur'
            {
            match("recur"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/antlr/Vitry.g:27:7: ( '=' )
            // src/antlr/Vitry.g:27:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/antlr/Vitry.g:28:7: ( 'module' )
            // src/antlr/Vitry.g:28:9: 'module'
            {
            match("module"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/antlr/Vitry.g:29:7: ( 'import' )
            // src/antlr/Vitry.g:29:9: 'import'
            {
            match("import"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/antlr/Vitry.g:30:7: ( 'type' )
            // src/antlr/Vitry.g:30:9: 'type'
            {
            match("type"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/antlr/Vitry.g:31:7: ( 'implicit' )
            // src/antlr/Vitry.g:31:9: 'implicit'
            {
            match("implicit"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/antlr/Vitry.g:32:7: ( '.' )
            // src/antlr/Vitry.g:32:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "Op"
    public final void mOp() throws RecognitionException {
        try {
            int _type = Op;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/antlr/Vitry.g:122:5: ( ( '!' | '#' | '$' | '%' | '&' | '\\'' | '*' | '+' | ',' | '-' | '.' | '/' | ';' | '<' | '=' | '>' | '?' | '@' | '\\\\' | '^' | '_' | '`' | '|' | '~' | ':' )* )
            // src/antlr/Vitry.g:122:7: ( '!' | '#' | '$' | '%' | '&' | '\\'' | '*' | '+' | ',' | '-' | '.' | '/' | ';' | '<' | '=' | '>' | '?' | '@' | '\\\\' | '^' | '_' | '`' | '|' | '~' | ':' )*
            {
            // src/antlr/Vitry.g:122:7: ( '!' | '#' | '$' | '%' | '&' | '\\'' | '*' | '+' | ',' | '-' | '.' | '/' | ';' | '<' | '=' | '>' | '?' | '@' | '\\\\' | '^' | '_' | '`' | '|' | '~' | ':' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='!'||(LA1_0>='#' && LA1_0<='\'')||(LA1_0>='*' && LA1_0<='/')||(LA1_0>=':' && LA1_0<='@')||LA1_0=='\\'||(LA1_0>='^' && LA1_0<='`')||LA1_0=='|'||LA1_0=='~') ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // src/antlr/Vitry.g:
            	    {
            	    if ( input.LA(1)=='!'||(input.LA(1)>='#' && input.LA(1)<='\'')||(input.LA(1)>='*' && input.LA(1)<='/')||(input.LA(1)>=':' && input.LA(1)<='@')||input.LA(1)=='\\'||(input.LA(1)>='^' && input.LA(1)<='`')||input.LA(1)=='|'||input.LA(1)=='~' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Op"

    // $ANTLR start "Symbol"
    public final void mSymbol() throws RecognitionException {
        try {
            int _type = Symbol;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/antlr/Vitry.g:130:5: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )* )
            // src/antlr/Vitry.g:130:10: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // src/antlr/Vitry.g:130:30: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // src/antlr/Vitry.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Symbol"

    // $ANTLR start "Natural"
    public final void mNatural() throws RecognitionException {
        try {
            int _type = Natural;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/antlr/Vitry.g:134:5: ( ( '0' .. '9' )+ )
            // src/antlr/Vitry.g:134:10: ( '0' .. '9' )+
            {
            // src/antlr/Vitry.g:134:10: ( '0' .. '9' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // src/antlr/Vitry.g:134:10: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Natural"

    // $ANTLR start "Float"
    public final void mFloat() throws RecognitionException {
        try {
            int _type = Float;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/antlr/Vitry.g:138:5: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( Exponent )? | ( '0' .. '9' )+ Exponent )
            int alt8=2;
            alt8 = dfa8.predict(input);
            switch (alt8) {
                case 1 :
                    // src/antlr/Vitry.g:138:9: ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( Exponent )?
                    {
                    // src/antlr/Vitry.g:138:9: ( '0' .. '9' )+
                    int cnt4=0;
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:138:10: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt4 >= 1 ) break loop4;
                                EarlyExitException eee =
                                    new EarlyExitException(4, input);
                                throw eee;
                        }
                        cnt4++;
                    } while (true);

                    match('.'); 
                    // src/antlr/Vitry.g:138:25: ( '0' .. '9' )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:138:26: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    // src/antlr/Vitry.g:138:37: ( Exponent )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0=='E'||LA6_0=='e') ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // src/antlr/Vitry.g:138:37: Exponent
                            {
                            mExponent(); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // src/antlr/Vitry.g:139:9: ( '0' .. '9' )+ Exponent
                    {
                    // src/antlr/Vitry.g:139:9: ( '0' .. '9' )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:139:10: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt7 >= 1 ) break loop7;
                                EarlyExitException eee =
                                    new EarlyExitException(7, input);
                                throw eee;
                        }
                        cnt7++;
                    } while (true);

                    mExponent(); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Float"

    // $ANTLR start "Complex"
    public final void mComplex() throws RecognitionException {
        try {
            int _type = Complex;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/antlr/Vitry.g:143:5: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( Exponent )? 'i' | ( '0' .. '9' )+ Exponent 'i' | ( '0' .. '9' )+ 'i' )
            int alt14=3;
            alt14 = dfa14.predict(input);
            switch (alt14) {
                case 1 :
                    // src/antlr/Vitry.g:143:9: ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( Exponent )? 'i'
                    {
                    // src/antlr/Vitry.g:143:9: ( '0' .. '9' )+
                    int cnt9=0;
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( ((LA9_0>='0' && LA9_0<='9')) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:143:10: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt9 >= 1 ) break loop9;
                                EarlyExitException eee =
                                    new EarlyExitException(9, input);
                                throw eee;
                        }
                        cnt9++;
                    } while (true);

                    match('.'); 
                    // src/antlr/Vitry.g:143:25: ( '0' .. '9' )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( ((LA10_0>='0' && LA10_0<='9')) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:143:26: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    // src/antlr/Vitry.g:143:37: ( Exponent )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0=='E'||LA11_0=='e') ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // src/antlr/Vitry.g:143:37: Exponent
                            {
                            mExponent(); 

                            }
                            break;

                    }

                    match('i'); 

                    }
                    break;
                case 2 :
                    // src/antlr/Vitry.g:144:9: ( '0' .. '9' )+ Exponent 'i'
                    {
                    // src/antlr/Vitry.g:144:9: ( '0' .. '9' )+
                    int cnt12=0;
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( ((LA12_0>='0' && LA12_0<='9')) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:144:10: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt12 >= 1 ) break loop12;
                                EarlyExitException eee =
                                    new EarlyExitException(12, input);
                                throw eee;
                        }
                        cnt12++;
                    } while (true);

                    mExponent(); 
                    match('i'); 

                    }
                    break;
                case 3 :
                    // src/antlr/Vitry.g:145:9: ( '0' .. '9' )+ 'i'
                    {
                    // src/antlr/Vitry.g:145:9: ( '0' .. '9' )+
                    int cnt13=0;
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( ((LA13_0>='0' && LA13_0<='9')) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:145:10: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt13 >= 1 ) break loop13;
                                EarlyExitException eee =
                                    new EarlyExitException(13, input);
                                throw eee;
                        }
                        cnt13++;
                    } while (true);

                    match('i'); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Complex"

    // $ANTLR start "Whitespace"
    public final void mWhitespace() throws RecognitionException {
        try {
            int _type = Whitespace;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/antlr/Vitry.g:149:5: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
            // src/antlr/Vitry.g:149:7: ( ' ' | '\\t' | '\\r' | '\\n' )
            {
            if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Whitespace"

    // $ANTLR start "String"
    public final void mString() throws RecognitionException {
        try {
            int _type = String;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/antlr/Vitry.g:157:5: ( '\"' ( EscapeSeq | ~ ( '\\\\' | '\"' ) )* '\"' )
            // src/antlr/Vitry.g:157:8: '\"' ( EscapeSeq | ~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 
            // src/antlr/Vitry.g:157:12: ( EscapeSeq | ~ ( '\\\\' | '\"' ) )*
            loop15:
            do {
                int alt15=3;
                int LA15_0 = input.LA(1);

                if ( (LA15_0=='\\') ) {
                    alt15=1;
                }
                else if ( ((LA15_0>='\u0000' && LA15_0<='!')||(LA15_0>='#' && LA15_0<='[')||(LA15_0>=']' && LA15_0<='\uFFFF')) ) {
                    alt15=2;
                }


                switch (alt15) {
            	case 1 :
            	    // src/antlr/Vitry.g:157:14: EscapeSeq
            	    {
            	    mEscapeSeq(); 

            	    }
            	    break;
            	case 2 :
            	    // src/antlr/Vitry.g:157:26: ~ ( '\\\\' | '\"' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "String"

    // $ANTLR start "Exponent"
    public final void mExponent() throws RecognitionException {
        try {
            // src/antlr/Vitry.g:161:10: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
            // src/antlr/Vitry.g:161:12: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // src/antlr/Vitry.g:161:22: ( '+' | '-' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0=='+'||LA16_0=='-') ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // src/antlr/Vitry.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            // src/antlr/Vitry.g:161:33: ( '0' .. '9' )+
            int cnt17=0;
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>='0' && LA17_0<='9')) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // src/antlr/Vitry.g:161:34: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt17 >= 1 ) break loop17;
                        EarlyExitException eee =
                            new EarlyExitException(17, input);
                        throw eee;
                }
                cnt17++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "Exponent"

    // $ANTLR start "HexDigit"
    public final void mHexDigit() throws RecognitionException {
        try {
            // src/antlr/Vitry.g:164:10: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // src/antlr/Vitry.g:164:12: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "HexDigit"

    // $ANTLR start "EscapeSeq"
    public final void mEscapeSeq() throws RecognitionException {
        try {
            // src/antlr/Vitry.g:168:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | UnicodeEsc | OctalEsc )
            int alt18=3;
            int LA18_0 = input.LA(1);

            if ( (LA18_0=='\\') ) {
                switch ( input.LA(2) ) {
                case '\"':
                case '\'':
                case '\\':
                case 'b':
                case 'f':
                case 'n':
                case 'r':
                case 't':
                    {
                    alt18=1;
                    }
                    break;
                case 'u':
                    {
                    alt18=2;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                    {
                    alt18=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // src/antlr/Vitry.g:168:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
                    {
                    match('\\'); 
                    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 2 :
                    // src/antlr/Vitry.g:169:9: UnicodeEsc
                    {
                    mUnicodeEsc(); 

                    }
                    break;
                case 3 :
                    // src/antlr/Vitry.g:170:9: OctalEsc
                    {
                    mOctalEsc(); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "EscapeSeq"

    // $ANTLR start "OctalEsc"
    public final void mOctalEsc() throws RecognitionException {
        try {
            // src/antlr/Vitry.g:175:5: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
            int alt19=3;
            int LA19_0 = input.LA(1);

            if ( (LA19_0=='\\') ) {
                int LA19_1 = input.LA(2);

                if ( ((LA19_1>='0' && LA19_1<='3')) ) {
                    int LA19_2 = input.LA(3);

                    if ( ((LA19_2>='0' && LA19_2<='7')) ) {
                        int LA19_5 = input.LA(4);

                        if ( ((LA19_5>='0' && LA19_5<='7')) ) {
                            alt19=1;
                        }
                        else {
                            alt19=2;}
                    }
                    else {
                        alt19=3;}
                }
                else if ( ((LA19_1>='4' && LA19_1<='7')) ) {
                    int LA19_3 = input.LA(3);

                    if ( ((LA19_3>='0' && LA19_3<='7')) ) {
                        alt19=2;
                    }
                    else {
                        alt19=3;}
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 19, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // src/antlr/Vitry.g:175:9: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 
                    // src/antlr/Vitry.g:175:14: ( '0' .. '3' )
                    // src/antlr/Vitry.g:175:15: '0' .. '3'
                    {
                    matchRange('0','3'); 

                    }

                    // src/antlr/Vitry.g:175:25: ( '0' .. '7' )
                    // src/antlr/Vitry.g:175:26: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // src/antlr/Vitry.g:175:36: ( '0' .. '7' )
                    // src/antlr/Vitry.g:175:37: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 2 :
                    // src/antlr/Vitry.g:176:9: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 
                    // src/antlr/Vitry.g:176:14: ( '0' .. '7' )
                    // src/antlr/Vitry.g:176:15: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // src/antlr/Vitry.g:176:25: ( '0' .. '7' )
                    // src/antlr/Vitry.g:176:26: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 3 :
                    // src/antlr/Vitry.g:177:9: '\\\\' ( '0' .. '7' )
                    {
                    match('\\'); 
                    // src/antlr/Vitry.g:177:14: ( '0' .. '7' )
                    // src/antlr/Vitry.g:177:15: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "OctalEsc"

    // $ANTLR start "UnicodeEsc"
    public final void mUnicodeEsc() throws RecognitionException {
        try {
            // src/antlr/Vitry.g:182:5: ( '\\\\' 'u' HexDigit HexDigit HexDigit HexDigit )
            // src/antlr/Vitry.g:182:9: '\\\\' 'u' HexDigit HexDigit HexDigit HexDigit
            {
            match('\\'); 
            match('u'); 
            mHexDigit(); 
            mHexDigit(); 
            mHexDigit(); 
            mHexDigit(); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "UnicodeEsc"

    public void mTokens() throws RecognitionException {
        // src/antlr/Vitry.g:1:8: ( T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | Op | Symbol | Natural | Float | Complex | Whitespace | String )
        int alt20=29;
        alt20 = dfa20.predict(input);
        switch (alt20) {
            case 1 :
                // src/antlr/Vitry.g:1:10: T__38
                {
                mT__38(); 

                }
                break;
            case 2 :
                // src/antlr/Vitry.g:1:16: T__39
                {
                mT__39(); 

                }
                break;
            case 3 :
                // src/antlr/Vitry.g:1:22: T__40
                {
                mT__40(); 

                }
                break;
            case 4 :
                // src/antlr/Vitry.g:1:28: T__41
                {
                mT__41(); 

                }
                break;
            case 5 :
                // src/antlr/Vitry.g:1:34: T__42
                {
                mT__42(); 

                }
                break;
            case 6 :
                // src/antlr/Vitry.g:1:40: T__43
                {
                mT__43(); 

                }
                break;
            case 7 :
                // src/antlr/Vitry.g:1:46: T__44
                {
                mT__44(); 

                }
                break;
            case 8 :
                // src/antlr/Vitry.g:1:52: T__45
                {
                mT__45(); 

                }
                break;
            case 9 :
                // src/antlr/Vitry.g:1:58: T__46
                {
                mT__46(); 

                }
                break;
            case 10 :
                // src/antlr/Vitry.g:1:64: T__47
                {
                mT__47(); 

                }
                break;
            case 11 :
                // src/antlr/Vitry.g:1:70: T__48
                {
                mT__48(); 

                }
                break;
            case 12 :
                // src/antlr/Vitry.g:1:76: T__49
                {
                mT__49(); 

                }
                break;
            case 13 :
                // src/antlr/Vitry.g:1:82: T__50
                {
                mT__50(); 

                }
                break;
            case 14 :
                // src/antlr/Vitry.g:1:88: T__51
                {
                mT__51(); 

                }
                break;
            case 15 :
                // src/antlr/Vitry.g:1:94: T__52
                {
                mT__52(); 

                }
                break;
            case 16 :
                // src/antlr/Vitry.g:1:100: T__53
                {
                mT__53(); 

                }
                break;
            case 17 :
                // src/antlr/Vitry.g:1:106: T__54
                {
                mT__54(); 

                }
                break;
            case 18 :
                // src/antlr/Vitry.g:1:112: T__55
                {
                mT__55(); 

                }
                break;
            case 19 :
                // src/antlr/Vitry.g:1:118: T__56
                {
                mT__56(); 

                }
                break;
            case 20 :
                // src/antlr/Vitry.g:1:124: T__57
                {
                mT__57(); 

                }
                break;
            case 21 :
                // src/antlr/Vitry.g:1:130: T__58
                {
                mT__58(); 

                }
                break;
            case 22 :
                // src/antlr/Vitry.g:1:136: T__59
                {
                mT__59(); 

                }
                break;
            case 23 :
                // src/antlr/Vitry.g:1:142: Op
                {
                mOp(); 

                }
                break;
            case 24 :
                // src/antlr/Vitry.g:1:145: Symbol
                {
                mSymbol(); 

                }
                break;
            case 25 :
                // src/antlr/Vitry.g:1:152: Natural
                {
                mNatural(); 

                }
                break;
            case 26 :
                // src/antlr/Vitry.g:1:160: Float
                {
                mFloat(); 

                }
                break;
            case 27 :
                // src/antlr/Vitry.g:1:166: Complex
                {
                mComplex(); 

                }
                break;
            case 28 :
                // src/antlr/Vitry.g:1:174: Whitespace
                {
                mWhitespace(); 

                }
                break;
            case 29 :
                // src/antlr/Vitry.g:1:185: String
                {
                mString(); 

                }
                break;

        }

    }


    protected DFA8 dfa8 = new DFA8(this);
    protected DFA14 dfa14 = new DFA14(this);
    protected DFA20 dfa20 = new DFA20(this);
    static final String DFA8_eotS =
        "\4\uffff";
    static final String DFA8_eofS =
        "\4\uffff";
    static final String DFA8_minS =
        "\1\60\1\56\2\uffff";
    static final String DFA8_maxS =
        "\1\71\1\145\2\uffff";
    static final String DFA8_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA8_specialS =
        "\4\uffff}>";
    static final String[] DFA8_transitionS = {
            "\12\1",
            "\1\3\1\uffff\12\1\13\uffff\1\2\37\uffff\1\2",
            "",
            ""
    };

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "137:1: Float : ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( Exponent )? | ( '0' .. '9' )+ Exponent );";
        }
    }
    static final String DFA14_eotS =
        "\5\uffff";
    static final String DFA14_eofS =
        "\5\uffff";
    static final String DFA14_minS =
        "\1\60\1\56\3\uffff";
    static final String DFA14_maxS =
        "\1\71\1\151\3\uffff";
    static final String DFA14_acceptS =
        "\2\uffff\1\3\1\2\1\1";
    static final String DFA14_specialS =
        "\5\uffff}>";
    static final String[] DFA14_transitionS = {
            "\12\1",
            "\1\4\1\uffff\12\1\13\uffff\1\3\37\uffff\1\3\3\uffff\1\2",
            "",
            "",
            ""
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "142:1: Complex : ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( Exponent )? 'i' | ( '0' .. '9' )+ Exponent 'i' | ( '0' .. '9' )+ 'i' );";
        }
    }
    static final String DFA20_eotS =
        "\1\23\1\30\6\uffff\1\31\7\24\1\44\1\24\1\46\2\uffff\1\52\4\uffff"+
        "\1\53\2\24\1\56\1\57\5\24\1\uffff\1\24\2\uffff\1\72\3\uffff\1\73"+
        "\1\24\2\uffff\6\24\1\uffff\2\72\3\uffff\1\106\2\24\1\111\3\24\1"+
        "\115\1\uffff\1\72\1\uffff\2\24\1\uffff\1\120\1\24\1\122\1\uffff"+
        "\1\123\1\24\1\uffff\1\125\2\uffff\1\24\1\uffff\1\127\1\uffff";
    static final String DFA20_eofS =
        "\130\uffff";
    static final String DFA20_minS =
        "\1\11\1\41\6\uffff\1\41\1\156\1\145\1\157\1\146\1\154\1\141\1\145"+
        "\1\41\1\171\1\41\2\uffff\1\56\4\uffff\1\60\1\164\1\157\2\60\1\160"+
        "\1\163\1\164\1\144\1\143\1\uffff\1\160\1\uffff\1\53\1\60\3\uffff"+
        "\1\60\1\160\2\uffff\1\154\1\145\1\143\2\165\1\145\3\60\1\53\2\uffff"+
        "\1\60\1\162\1\151\1\60\1\150\1\154\1\162\3\60\1\uffff\1\164\1\143"+
        "\1\uffff\1\60\1\145\1\60\1\uffff\1\60\1\151\1\uffff\1\60\2\uffff"+
        "\1\164\1\uffff\1\60\1\uffff";
    static final String DFA20_maxS =
        "\1\175\1\176\6\uffff\1\176\1\156\2\157\1\155\1\154\1\157\1\145\1"+
        "\176\1\171\1\176\2\uffff\1\151\4\uffff\1\172\1\164\1\157\2\172\1"+
        "\160\1\163\1\164\1\144\1\143\1\uffff\1\160\1\uffff\1\71\1\151\3"+
        "\uffff\1\172\1\160\2\uffff\1\157\1\145\1\143\2\165\1\145\1\71\2"+
        "\151\1\71\2\uffff\1\172\1\162\1\151\1\172\1\150\1\154\1\162\1\172"+
        "\1\71\1\151\1\uffff\1\164\1\143\1\uffff\1\172\1\145\1\172\1\uffff"+
        "\1\172\1\151\1\uffff\1\172\2\uffff\1\164\1\uffff\1\172\1\uffff";
    static final String DFA20_acceptS =
        "\2\uffff\1\2\1\3\1\4\1\5\1\6\1\7\13\uffff\1\27\1\30\1\uffff\1\34"+
        "\1\35\1\1\1\10\12\uffff\1\21\1\uffff\1\26\2\uffff\1\33\1\31\1\11"+
        "\2\uffff\1\14\1\15\12\uffff\1\32\1\12\12\uffff\1\13\2\uffff\1\16"+
        "\3\uffff\1\24\2\uffff\1\17\1\uffff\1\20\1\23\1\uffff\1\22\1\uffff"+
        "\1\25";
    static final String DFA20_specialS =
        "\130\uffff}>";
    static final String[] DFA20_transitionS = {
            "\2\26\2\uffff\1\26\22\uffff\1\26\1\uffff\1\27\5\uffff\1\2\1"+
            "\3\4\uffff\1\22\1\uffff\12\25\1\1\2\uffff\1\20\3\uffff\32\24"+
            "\1\4\1\uffff\1\5\2\uffff\1\10\3\24\1\13\1\15\1\11\2\24\1\14"+
            "\2\24\1\12\1\16\4\24\1\17\1\24\1\21\6\24\1\6\1\uffff\1\7",
            "\1\23\1\uffff\5\23\2\uffff\6\23\12\uffff\7\23\33\uffff\1\23"+
            "\1\uffff\3\23\33\uffff\1\23\1\uffff\1\23",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\23\1\uffff\5\23\2\uffff\6\23\12\uffff\7\23\33\uffff\1\23"+
            "\1\uffff\3\23\33\uffff\1\23\1\uffff\1\23",
            "\1\32",
            "\1\33\11\uffff\1\34",
            "\1\35",
            "\1\36\6\uffff\1\37",
            "\1\40",
            "\1\41\15\uffff\1\42",
            "\1\43",
            "\1\23\1\uffff\5\23\2\uffff\6\23\12\uffff\7\23\33\uffff\1\23"+
            "\1\uffff\3\23\33\uffff\1\23\1\uffff\1\23",
            "\1\45",
            "\1\23\1\uffff\5\23\2\uffff\6\23\12\uffff\7\23\33\uffff\1\23"+
            "\1\uffff\3\23\33\uffff\1\23\1\uffff\1\23",
            "",
            "",
            "\1\50\1\uffff\12\25\13\uffff\1\47\37\uffff\1\47\3\uffff\1\51",
            "",
            "",
            "",
            "",
            "\12\24\7\uffff\32\24\6\uffff\32\24",
            "\1\54",
            "\1\55",
            "\12\24\7\uffff\32\24\6\uffff\32\24",
            "\12\24\7\uffff\32\24\6\uffff\32\24",
            "\1\60",
            "\1\61",
            "\1\62",
            "\1\63",
            "\1\64",
            "",
            "\1\65",
            "",
            "\1\66\1\uffff\1\66\2\uffff\12\67",
            "\12\70\13\uffff\1\71\37\uffff\1\71\3\uffff\1\51",
            "",
            "",
            "",
            "\12\24\7\uffff\32\24\6\uffff\32\24",
            "\1\74",
            "",
            "",
            "\1\76\2\uffff\1\75",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\102",
            "\1\103",
            "\12\67",
            "\12\67\57\uffff\1\51",
            "\12\70\13\uffff\1\71\37\uffff\1\71\3\uffff\1\51",
            "\1\104\1\uffff\1\104\2\uffff\12\105",
            "",
            "",
            "\12\24\7\uffff\32\24\6\uffff\32\24",
            "\1\107",
            "\1\110",
            "\12\24\7\uffff\32\24\6\uffff\32\24",
            "\1\112",
            "\1\113",
            "\1\114",
            "\12\24\7\uffff\32\24\6\uffff\32\24",
            "\12\105",
            "\12\105\57\uffff\1\51",
            "",
            "\1\116",
            "\1\117",
            "",
            "\12\24\7\uffff\32\24\6\uffff\32\24",
            "\1\121",
            "\12\24\7\uffff\32\24\6\uffff\32\24",
            "",
            "\12\24\7\uffff\32\24\6\uffff\32\24",
            "\1\124",
            "",
            "\12\24\7\uffff\32\24\6\uffff\32\24",
            "",
            "",
            "\1\126",
            "",
            "\12\24\7\uffff\32\24\6\uffff\32\24",
            ""
    };

    static final short[] DFA20_eot = DFA.unpackEncodedString(DFA20_eotS);
    static final short[] DFA20_eof = DFA.unpackEncodedString(DFA20_eofS);
    static final char[] DFA20_min = DFA.unpackEncodedStringToUnsignedChars(DFA20_minS);
    static final char[] DFA20_max = DFA.unpackEncodedStringToUnsignedChars(DFA20_maxS);
    static final short[] DFA20_accept = DFA.unpackEncodedString(DFA20_acceptS);
    static final short[] DFA20_special = DFA.unpackEncodedString(DFA20_specialS);
    static final short[][] DFA20_transition;

    static {
        int numStates = DFA20_transitionS.length;
        DFA20_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA20_transition[i] = DFA.unpackEncodedString(DFA20_transitionS[i]);
        }
    }

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = DFA20_eot;
            this.eof = DFA20_eof;
            this.min = DFA20_min;
            this.max = DFA20_max;
            this.accept = DFA20_accept;
            this.special = DFA20_special;
            this.transition = DFA20_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | Op | Symbol | Natural | Float | Complex | Whitespace | String );";
        }
    }
 

}