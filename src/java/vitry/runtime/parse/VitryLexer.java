// $ANTLR 3.2 Sep 23, 2009 12:02:23 src/antlr/Vitry.g 2011-02-13 03:11:45
// See src/antlr/Vitry.g
package vitry.runtime.parse;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class VitryLexer extends Lexer {
    public static final int Ops=14;
    public static final int Module=9;
    public static final int Exponent=25;
    public static final int Quote=8;
    public static final int EOF=-1;
    public static final int HexDigit=28;
    public static final int Assign=12;
    public static final int Let=11;
    public static final int Left=7;
    public static final int OctalEsc=30;
    public static final int Do=17;
    public static final int Ang=6;
    public static final int UnicodeEsc=29;
    public static final int Bra=5;
    public static final int Op=19;
    public static final int String=24;
    public static final int Symbol=20;
    public static final int Whitespace=26;
    public static final int If=15;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__44=44;
    public static final int Type=18;
    public static final int T__45=45;
    public static final int Natural=21;
    public static final int Complex=23;
    public static final int Apply=13;
    public static final int Float=22;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int EscapeSeq=27;
    public static final int T__36=36;
    public static final int Match=16;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int Par=4;
    public static final int Fn=10;



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

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/antlr/Vitry.g:13:7: ( ':' )
            // src/antlr/Vitry.g:13:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/antlr/Vitry.g:14:7: ( '(' )
            // src/antlr/Vitry.g:14:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/antlr/Vitry.g:15:7: ( ')' )
            // src/antlr/Vitry.g:15:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/antlr/Vitry.g:16:7: ( '[' )
            // src/antlr/Vitry.g:16:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/antlr/Vitry.g:17:7: ( ']' )
            // src/antlr/Vitry.g:17:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/antlr/Vitry.g:18:7: ( '{' )
            // src/antlr/Vitry.g:18:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/antlr/Vitry.g:19:7: ( '}' )
            // src/antlr/Vitry.g:19:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/antlr/Vitry.g:20:7: ( '`' )
            // src/antlr/Vitry.g:20:9: '`'
            {
            match('`'); 

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
            // src/antlr/Vitry.g:21:7: ( 'fn' )
            // src/antlr/Vitry.g:21:9: 'fn'
            {
            match("fn"); 


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
            // src/antlr/Vitry.g:22:7: ( 'let' )
            // src/antlr/Vitry.g:22:9: 'let'
            {
            match("let"); 


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
            // src/antlr/Vitry.g:23:7: ( 'do' )
            // src/antlr/Vitry.g:23:9: 'do'
            {
            match("do"); 


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
            // src/antlr/Vitry.g:24:7: ( 'match' )
            // src/antlr/Vitry.g:24:9: 'match'
            {
            match("match"); 


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
            // src/antlr/Vitry.g:25:7: ( 'if' )
            // src/antlr/Vitry.g:25:9: 'if'
            {
            match("if"); 


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
            // src/antlr/Vitry.g:26:7: ( 'else' )
            // src/antlr/Vitry.g:26:9: 'else'
            {
            match("else"); 


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
    // $ANTLR end "T__45"

    // $ANTLR start "Op"
    public final void mOp() throws RecognitionException {
        try {
            int _type = Op;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/antlr/Vitry.g:180:5: ( ( '!' | '#' | '$' | '%' | '&' | '\\'' | '*' | '+' | ',' | '-' | '.' | '/' | ';' | '<' | '=' | '>' | '?' | '@' | '\\\\' | '^' | '_' | '|' | '~' | ':' )* )
            // src/antlr/Vitry.g:180:7: ( '!' | '#' | '$' | '%' | '&' | '\\'' | '*' | '+' | ',' | '-' | '.' | '/' | ';' | '<' | '=' | '>' | '?' | '@' | '\\\\' | '^' | '_' | '|' | '~' | ':' )*
            {
            // src/antlr/Vitry.g:180:7: ( '!' | '#' | '$' | '%' | '&' | '\\'' | '*' | '+' | ',' | '-' | '.' | '/' | ';' | '<' | '=' | '>' | '?' | '@' | '\\\\' | '^' | '_' | '|' | '~' | ':' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='!'||(LA1_0>='#' && LA1_0<='\'')||(LA1_0>='*' && LA1_0<='/')||(LA1_0>=':' && LA1_0<='@')||LA1_0=='\\'||(LA1_0>='^' && LA1_0<='_')||LA1_0=='|'||LA1_0=='~') ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // src/antlr/Vitry.g:
            	    {
            	    if ( input.LA(1)=='!'||(input.LA(1)>='#' && input.LA(1)<='\'')||(input.LA(1)>='*' && input.LA(1)<='/')||(input.LA(1)>=':' && input.LA(1)<='@')||input.LA(1)=='\\'||(input.LA(1)>='^' && input.LA(1)<='_')||input.LA(1)=='|'||input.LA(1)=='~' ) {
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
            // src/antlr/Vitry.g:188:5: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )* )
            // src/antlr/Vitry.g:188:10: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // src/antlr/Vitry.g:188:30: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
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
            // src/antlr/Vitry.g:192:5: ( ( '0' .. '9' )+ )
            // src/antlr/Vitry.g:192:10: ( '0' .. '9' )+
            {
            // src/antlr/Vitry.g:192:10: ( '0' .. '9' )+
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
            	    // src/antlr/Vitry.g:192:10: '0' .. '9'
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
            // src/antlr/Vitry.g:196:5: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( Exponent )? | ( '0' .. '9' )+ Exponent )
            int alt8=2;
            alt8 = dfa8.predict(input);
            switch (alt8) {
                case 1 :
                    // src/antlr/Vitry.g:196:9: ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( Exponent )?
                    {
                    // src/antlr/Vitry.g:196:9: ( '0' .. '9' )+
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
                    	    // src/antlr/Vitry.g:196:10: '0' .. '9'
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
                    // src/antlr/Vitry.g:196:25: ( '0' .. '9' )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:196:26: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    // src/antlr/Vitry.g:196:37: ( Exponent )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0=='E'||LA6_0=='e') ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // src/antlr/Vitry.g:196:37: Exponent
                            {
                            mExponent(); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // src/antlr/Vitry.g:197:9: ( '0' .. '9' )+ Exponent
                    {
                    // src/antlr/Vitry.g:197:9: ( '0' .. '9' )+
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
                    	    // src/antlr/Vitry.g:197:10: '0' .. '9'
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
            // src/antlr/Vitry.g:201:5: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( Exponent )? 'i' | ( '0' .. '9' )+ Exponent 'i' | ( '0' .. '9' )+ 'i' )
            int alt14=3;
            alt14 = dfa14.predict(input);
            switch (alt14) {
                case 1 :
                    // src/antlr/Vitry.g:201:9: ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( Exponent )? 'i'
                    {
                    // src/antlr/Vitry.g:201:9: ( '0' .. '9' )+
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
                    	    // src/antlr/Vitry.g:201:10: '0' .. '9'
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
                    // src/antlr/Vitry.g:201:25: ( '0' .. '9' )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( ((LA10_0>='0' && LA10_0<='9')) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:201:26: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    // src/antlr/Vitry.g:201:37: ( Exponent )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0=='E'||LA11_0=='e') ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // src/antlr/Vitry.g:201:37: Exponent
                            {
                            mExponent(); 

                            }
                            break;

                    }

                    match('i'); 

                    }
                    break;
                case 2 :
                    // src/antlr/Vitry.g:202:9: ( '0' .. '9' )+ Exponent 'i'
                    {
                    // src/antlr/Vitry.g:202:9: ( '0' .. '9' )+
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
                    	    // src/antlr/Vitry.g:202:10: '0' .. '9'
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
                    // src/antlr/Vitry.g:203:9: ( '0' .. '9' )+ 'i'
                    {
                    // src/antlr/Vitry.g:203:9: ( '0' .. '9' )+
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
                    	    // src/antlr/Vitry.g:203:10: '0' .. '9'
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
            // src/antlr/Vitry.g:207:5: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
            // src/antlr/Vitry.g:207:7: ( ' ' | '\\t' | '\\r' | '\\n' )
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
            // src/antlr/Vitry.g:215:5: ( '\"' ( EscapeSeq | ~ ( '\\\\' | '\"' ) )* '\"' )
            // src/antlr/Vitry.g:215:8: '\"' ( EscapeSeq | ~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 
            // src/antlr/Vitry.g:215:12: ( EscapeSeq | ~ ( '\\\\' | '\"' ) )*
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
            	    // src/antlr/Vitry.g:215:14: EscapeSeq
            	    {
            	    mEscapeSeq(); 

            	    }
            	    break;
            	case 2 :
            	    // src/antlr/Vitry.g:215:26: ~ ( '\\\\' | '\"' )
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
            // src/antlr/Vitry.g:219:10: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
            // src/antlr/Vitry.g:219:12: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // src/antlr/Vitry.g:219:22: ( '+' | '-' )?
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

            // src/antlr/Vitry.g:219:33: ( '0' .. '9' )+
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
            	    // src/antlr/Vitry.g:219:34: '0' .. '9'
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
            // src/antlr/Vitry.g:222:10: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // src/antlr/Vitry.g:222:12: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
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
            // src/antlr/Vitry.g:226:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | UnicodeEsc | OctalEsc )
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
                    // src/antlr/Vitry.g:226:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
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
                    // src/antlr/Vitry.g:227:9: UnicodeEsc
                    {
                    mUnicodeEsc(); 

                    }
                    break;
                case 3 :
                    // src/antlr/Vitry.g:228:9: OctalEsc
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
            // src/antlr/Vitry.g:233:5: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
            int alt19=3;
            int LA19_0 = input.LA(1);

            if ( (LA19_0=='\\') ) {
                int LA19_1 = input.LA(2);

                if ( ((LA19_1>='0' && LA19_1<='3')) ) {
                    int LA19_2 = input.LA(3);

                    if ( ((LA19_2>='0' && LA19_2<='7')) ) {
                        int LA19_4 = input.LA(4);

                        if ( ((LA19_4>='0' && LA19_4<='7')) ) {
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
                    // src/antlr/Vitry.g:233:9: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 
                    // src/antlr/Vitry.g:233:14: ( '0' .. '3' )
                    // src/antlr/Vitry.g:233:15: '0' .. '3'
                    {
                    matchRange('0','3'); 

                    }

                    // src/antlr/Vitry.g:233:25: ( '0' .. '7' )
                    // src/antlr/Vitry.g:233:26: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // src/antlr/Vitry.g:233:36: ( '0' .. '7' )
                    // src/antlr/Vitry.g:233:37: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 2 :
                    // src/antlr/Vitry.g:234:9: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 
                    // src/antlr/Vitry.g:234:14: ( '0' .. '7' )
                    // src/antlr/Vitry.g:234:15: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // src/antlr/Vitry.g:234:25: ( '0' .. '7' )
                    // src/antlr/Vitry.g:234:26: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 3 :
                    // src/antlr/Vitry.g:235:9: '\\\\' ( '0' .. '7' )
                    {
                    match('\\'); 
                    // src/antlr/Vitry.g:235:14: ( '0' .. '7' )
                    // src/antlr/Vitry.g:235:15: '0' .. '7'
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
            // src/antlr/Vitry.g:240:5: ( '\\\\' 'u' HexDigit HexDigit HexDigit HexDigit )
            // src/antlr/Vitry.g:240:9: '\\\\' 'u' HexDigit HexDigit HexDigit HexDigit
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
        // src/antlr/Vitry.g:1:8: ( T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | Op | Symbol | Natural | Float | Complex | Whitespace | String )
        int alt20=22;
        alt20 = dfa20.predict(input);
        switch (alt20) {
            case 1 :
                // src/antlr/Vitry.g:1:10: T__31
                {
                mT__31(); 

                }
                break;
            case 2 :
                // src/antlr/Vitry.g:1:16: T__32
                {
                mT__32(); 

                }
                break;
            case 3 :
                // src/antlr/Vitry.g:1:22: T__33
                {
                mT__33(); 

                }
                break;
            case 4 :
                // src/antlr/Vitry.g:1:28: T__34
                {
                mT__34(); 

                }
                break;
            case 5 :
                // src/antlr/Vitry.g:1:34: T__35
                {
                mT__35(); 

                }
                break;
            case 6 :
                // src/antlr/Vitry.g:1:40: T__36
                {
                mT__36(); 

                }
                break;
            case 7 :
                // src/antlr/Vitry.g:1:46: T__37
                {
                mT__37(); 

                }
                break;
            case 8 :
                // src/antlr/Vitry.g:1:52: T__38
                {
                mT__38(); 

                }
                break;
            case 9 :
                // src/antlr/Vitry.g:1:58: T__39
                {
                mT__39(); 

                }
                break;
            case 10 :
                // src/antlr/Vitry.g:1:64: T__40
                {
                mT__40(); 

                }
                break;
            case 11 :
                // src/antlr/Vitry.g:1:70: T__41
                {
                mT__41(); 

                }
                break;
            case 12 :
                // src/antlr/Vitry.g:1:76: T__42
                {
                mT__42(); 

                }
                break;
            case 13 :
                // src/antlr/Vitry.g:1:82: T__43
                {
                mT__43(); 

                }
                break;
            case 14 :
                // src/antlr/Vitry.g:1:88: T__44
                {
                mT__44(); 

                }
                break;
            case 15 :
                // src/antlr/Vitry.g:1:94: T__45
                {
                mT__45(); 

                }
                break;
            case 16 :
                // src/antlr/Vitry.g:1:100: Op
                {
                mOp(); 

                }
                break;
            case 17 :
                // src/antlr/Vitry.g:1:103: Symbol
                {
                mSymbol(); 

                }
                break;
            case 18 :
                // src/antlr/Vitry.g:1:110: Natural
                {
                mNatural(); 

                }
                break;
            case 19 :
                // src/antlr/Vitry.g:1:118: Float
                {
                mFloat(); 

                }
                break;
            case 20 :
                // src/antlr/Vitry.g:1:124: Complex
                {
                mComplex(); 

                }
                break;
            case 21 :
                // src/antlr/Vitry.g:1:132: Whitespace
                {
                mWhitespace(); 

                }
                break;
            case 22 :
                // src/antlr/Vitry.g:1:143: String
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
        "\2\uffff\1\1\1\2";
    static final String DFA8_specialS =
        "\4\uffff}>";
    static final String[] DFA8_transitionS = {
            "\12\1",
            "\1\2\1\uffff\12\1\13\uffff\1\3\37\uffff\1\3",
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
            return "195:1: Float : ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( Exponent )? | ( '0' .. '9' )+ Exponent );";
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
        "\2\uffff\1\2\1\3\1\1";
    static final String DFA14_specialS =
        "\5\uffff}>";
    static final String[] DFA14_transitionS = {
            "\12\1",
            "\1\4\1\uffff\12\1\13\uffff\1\2\37\uffff\1\2\3\uffff\1\3",
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
            return "200:1: Complex : ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( Exponent )? 'i' | ( '0' .. '9' )+ Exponent 'i' | ( '0' .. '9' )+ 'i' );";
        }
    }
    static final String DFA20_eotS =
        "\1\20\1\25\7\uffff\6\21\1\34\2\uffff\1\36\3\uffff\1\41\1\21\1\43"+
        "\1\21\1\45\1\21\1\uffff\1\51\4\uffff\1\54\1\uffff\1\21\1\uffff\1"+
        "\21\1\51\3\uffff\1\51\1\uffff\1\21\1\62\1\uffff\1\51\1\63\2\uffff";
    static final String DFA20_eofS =
        "\64\uffff";
    static final String DFA20_minS =
        "\1\11\1\41\7\uffff\1\156\1\145\1\157\1\141\1\146\1\154\1\41\2\uffff"+
        "\1\56\3\uffff\1\60\1\164\1\60\1\164\1\60\1\163\1\uffff\1\60\2\uffff"+
        "\1\53\1\uffff\1\60\1\uffff\1\143\1\uffff\1\145\1\60\1\53\1\uffff"+
        "\2\60\1\uffff\1\150\4\60\2\uffff";
    static final String DFA20_maxS =
        "\1\175\1\176\7\uffff\1\156\1\145\1\157\1\141\1\146\1\154\1\176\2"+
        "\uffff\1\151\3\uffff\1\172\1\164\1\172\1\164\1\172\1\163\1\uffff"+
        "\1\151\2\uffff\1\71\1\uffff\1\172\1\uffff\1\143\1\uffff\1\145\1"+
        "\151\1\71\1\uffff\1\71\1\151\1\uffff\1\150\1\172\1\71\1\151\1\172"+
        "\2\uffff";
    static final String DFA20_acceptS =
        "\2\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\7\uffff\1\20\1\21\1\uffff"+
        "\1\25\1\26\1\1\6\uffff\1\17\1\uffff\1\22\1\24\1\uffff\1\11\1\uffff"+
        "\1\13\1\uffff\1\15\3\uffff\1\23\2\uffff\1\12\5\uffff\1\16\1\14";
    static final String DFA20_specialS =
        "\64\uffff}>";
    static final String[] DFA20_transitionS = {
            "\2\23\2\uffff\1\23\22\uffff\1\23\1\uffff\1\24\5\uffff\1\2\1"+
            "\3\6\uffff\12\22\1\1\2\uffff\1\17\3\uffff\32\21\1\4\1\uffff"+
            "\1\5\2\uffff\1\10\3\21\1\13\1\16\1\11\2\21\1\15\2\21\1\12\1"+
            "\14\15\21\1\6\1\uffff\1\7",
            "\1\20\1\uffff\5\20\2\uffff\6\20\12\uffff\7\20\33\uffff\1\20"+
            "\1\uffff\2\20\34\uffff\1\20\1\uffff\1\20",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\26",
            "\1\27",
            "\1\30",
            "\1\31",
            "\1\32",
            "\1\33",
            "\1\20\1\uffff\5\20\2\uffff\6\20\12\uffff\7\20\33\uffff\1\20"+
            "\1\uffff\2\20\34\uffff\1\20\1\uffff\1\20",
            "",
            "",
            "\1\35\1\uffff\12\22\13\uffff\1\40\37\uffff\1\40\3\uffff\1\37",
            "",
            "",
            "",
            "\12\21\7\uffff\32\21\6\uffff\32\21",
            "\1\42",
            "\12\21\7\uffff\32\21\6\uffff\32\21",
            "\1\44",
            "\12\21\7\uffff\32\21\6\uffff\32\21",
            "\1\46",
            "",
            "\12\47\13\uffff\1\50\37\uffff\1\50\3\uffff\1\37",
            "",
            "",
            "\1\52\1\uffff\1\52\2\uffff\12\53",
            "",
            "\12\21\7\uffff\32\21\6\uffff\32\21",
            "",
            "\1\55",
            "",
            "\1\56",
            "\12\47\13\uffff\1\50\37\uffff\1\50\3\uffff\1\37",
            "\1\57\1\uffff\1\57\2\uffff\12\60",
            "",
            "\12\53",
            "\12\53\57\uffff\1\37",
            "",
            "\1\61",
            "\12\21\7\uffff\32\21\6\uffff\32\21",
            "\12\60",
            "\12\60\57\uffff\1\37",
            "\12\21\7\uffff\32\21\6\uffff\32\21",
            "",
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
            return "1:1: Tokens : ( T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | Op | Symbol | Natural | Float | Complex | Whitespace | String );";
        }
    }
 

}