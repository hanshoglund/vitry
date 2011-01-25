// $ANTLR 3.2 Sep 23, 2009 12:02:23 src/grammar/Vitry.g 2011-01-25 00:55:12
package vitry.runtime.parse;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

public class VitryParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Par", "Bra", "Ang", "Module", "Fn", "Let", "Where", "Assign", "Left", "Quote", "Apply", "Type", "If", "Match", "Loop", "Recur", "Do", "Ops", "Dummy", "TypeDecl", "ImplicitDecl", "FnDecl", "MemberDecl", "Symbol", "Natural", "Float", "Complex", "String", "Op", "Exponent", "Whitespace", "EscapeSeq", "HexDigit", "UnicodeEsc", "OctalEsc", "':'", "'('", "')'", "'['", "']'", "'{'", "'}'", "'`'", "'fn'", "'let'", "'loop'", "'do'", "'if'", "'else'", "'match'", "'recur'", "'='", "'module'", "'import'", "'type'", "'impicit'", "'.'"
    };
    public static final int TypeDecl=23;
    public static final int Ops=21;
    public static final int MemberDecl=26;
    public static final int Module=7;
    public static final int Dummy=22;
    public static final int Where=10;
    public static final int Exponent=33;
    public static final int Quote=13;
    public static final int EOF=-1;
    public static final int T__60=60;
    public static final int HexDigit=36;
    public static final int Recur=19;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int Let=9;
    public static final int Assign=11;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__59=59;
    public static final int Left=12;
    public static final int OctalEsc=38;
    public static final int Do=20;
    public static final int UnicodeEsc=37;
    public static final int Ang=6;
    public static final int Bra=5;
    public static final int Op=32;
    public static final int String=31;
    public static final int Symbol=27;
    public static final int Whitespace=34;
    public static final int T__50=50;
    public static final int If=16;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int FnDecl=25;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int Type=15;
    public static final int T__45=45;
    public static final int Natural=28;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int Complex=30;
    public static final int Apply=14;
    public static final int ImplicitDecl=24;
    public static final int Float=29;
    public static final int EscapeSeq=35;
    public static final int Match=17;
    public static final int T__39=39;
    public static final int Par=4;
    public static final int Fn=8;
    public static final int Loop=18;

    // delegates
    // delegators


        public VitryParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public VitryParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return VitryParser.tokenNames; }
    public String getGrammarFileName() { return "src/grammar/Vitry.g"; }


    // TODO override mismatch() and recoverFromMismatchSet()


    public static class expr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expr"
    // src/grammar/Vitry.g:35:1: expr : ( ( delim[true] ':' )=> delim[true] ':' expr -> ^( Type delim expr ) | delim[true] );
    public final VitryParser.expr_return expr() throws RecognitionException {
        VitryParser.expr_return retval = new VitryParser.expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal2=null;
        VitryParser.delim_return delim1 = null;

        VitryParser.expr_return expr3 = null;

        VitryParser.delim_return delim4 = null;


        Object char_literal2_tree=null;
        RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        RewriteRuleSubtreeStream stream_delim=new RewriteRuleSubtreeStream(adaptor,"rule delim");
        try {
            // src/grammar/Vitry.g:36:5: ( ( delim[true] ':' )=> delim[true] ':' expr -> ^( Type delim expr ) | delim[true] )
            int alt1=2;
            switch ( input.LA(1) ) {
            case 40:
                {
                int LA1_1 = input.LA(2);

                if ( (synpred1_Vitry()) ) {
                    alt1=1;
                }
                else if ( (true) ) {
                    alt1=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 1, input);

                    throw nvae;
                }
                }
                break;
            case 42:
                {
                int LA1_2 = input.LA(2);

                if ( (synpred1_Vitry()) ) {
                    alt1=1;
                }
                else if ( (true) ) {
                    alt1=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 2, input);

                    throw nvae;
                }
                }
                break;
            case 44:
                {
                int LA1_3 = input.LA(2);

                if ( (synpred1_Vitry()) ) {
                    alt1=1;
                }
                else if ( (true) ) {
                    alt1=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 3, input);

                    throw nvae;
                }
                }
                break;
            case 46:
                {
                int LA1_4 = input.LA(2);

                if ( (synpred1_Vitry()) ) {
                    alt1=1;
                }
                else if ( (true) ) {
                    alt1=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 4, input);

                    throw nvae;
                }
                }
                break;
            case Natural:
            case Float:
            case Complex:
            case String:
                {
                int LA1_5 = input.LA(2);

                if ( (synpred1_Vitry()) ) {
                    alt1=1;
                }
                else if ( (true) ) {
                    alt1=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 5, input);

                    throw nvae;
                }
                }
                break;
            case Symbol:
                {
                int LA1_6 = input.LA(2);

                if ( (synpred1_Vitry()) ) {
                    alt1=1;
                }
                else if ( (true) ) {
                    alt1=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 6, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // src/grammar/Vitry.g:36:7: ( delim[true] ':' )=> delim[true] ':' expr
                    {
                    pushFollow(FOLLOW_delim_in_expr200);
                    delim1=delim(true);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_delim.add(delim1.getTree());
                    char_literal2=(Token)match(input,39,FOLLOW_39_in_expr203); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_39.add(char_literal2);

                    pushFollow(FOLLOW_expr_in_expr205);
                    expr3=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr3.getTree());


                    // AST REWRITE
                    // elements: expr, delim
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 36:52: -> ^( Type delim expr )
                    {
                        // src/grammar/Vitry.g:36:55: ^( Type delim expr )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Type, "Type"), root_1);

                        adaptor.addChild(root_1, stream_delim.nextTree());
                        adaptor.addChild(root_1, stream_expr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // src/grammar/Vitry.g:37:7: delim[true]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_delim_in_expr226);
                    delim4=delim(true);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, delim4.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "expr"

    public static class left_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "left"
    // src/grammar/Vitry.g:42:1: left : ( ( delim[false] ':' )=> delim[false] ':' expr -> ^( Left ^( Type delim expr ) ) | delim[false] -> ^( Left delim ) );
    public final VitryParser.left_return left() throws RecognitionException {
        VitryParser.left_return retval = new VitryParser.left_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal6=null;
        VitryParser.delim_return delim5 = null;

        VitryParser.expr_return expr7 = null;

        VitryParser.delim_return delim8 = null;


        Object char_literal6_tree=null;
        RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        RewriteRuleSubtreeStream stream_delim=new RewriteRuleSubtreeStream(adaptor,"rule delim");
        try {
            // src/grammar/Vitry.g:43:5: ( ( delim[false] ':' )=> delim[false] ':' expr -> ^( Left ^( Type delim expr ) ) | delim[false] -> ^( Left delim ) )
            int alt2=2;
            switch ( input.LA(1) ) {
            case 40:
                {
                int LA2_1 = input.LA(2);

                if ( (synpred2_Vitry()) ) {
                    alt2=1;
                }
                else if ( (true) ) {
                    alt2=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;
                }
                }
                break;
            case 42:
                {
                int LA2_2 = input.LA(2);

                if ( (synpred2_Vitry()) ) {
                    alt2=1;
                }
                else if ( (true) ) {
                    alt2=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 2, input);

                    throw nvae;
                }
                }
                break;
            case 44:
                {
                int LA2_3 = input.LA(2);

                if ( (synpred2_Vitry()) ) {
                    alt2=1;
                }
                else if ( (true) ) {
                    alt2=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 3, input);

                    throw nvae;
                }
                }
                break;
            case 46:
                {
                int LA2_4 = input.LA(2);

                if ( (synpred2_Vitry()) ) {
                    alt2=1;
                }
                else if ( (true) ) {
                    alt2=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 4, input);

                    throw nvae;
                }
                }
                break;
            case Natural:
            case Float:
            case Complex:
            case String:
                {
                int LA2_5 = input.LA(2);

                if ( (synpred2_Vitry()) ) {
                    alt2=1;
                }
                else if ( (true) ) {
                    alt2=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 5, input);

                    throw nvae;
                }
                }
                break;
            case Symbol:
                {
                int LA2_6 = input.LA(2);

                if ( (synpred2_Vitry()) ) {
                    alt2=1;
                }
                else if ( (true) ) {
                    alt2=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 6, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // src/grammar/Vitry.g:43:7: ( delim[false] ':' )=> delim[false] ':' expr
                    {
                    pushFollow(FOLLOW_delim_in_left259);
                    delim5=delim(false);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_delim.add(delim5.getTree());
                    char_literal6=(Token)match(input,39,FOLLOW_39_in_left262); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_39.add(char_literal6);

                    pushFollow(FOLLOW_expr_in_left264);
                    expr7=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr7.getTree());


                    // AST REWRITE
                    // elements: delim, expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 43:52: -> ^( Left ^( Type delim expr ) )
                    {
                        // src/grammar/Vitry.g:43:55: ^( Left ^( Type delim expr ) )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Left, "Left"), root_1);

                        // src/grammar/Vitry.g:43:62: ^( Type delim expr )
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(Type, "Type"), root_2);

                        adaptor.addChild(root_2, stream_delim.nextTree());
                        adaptor.addChild(root_2, stream_expr.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // src/grammar/Vitry.g:44:7: delim[false]
                    {
                    pushFollow(FOLLOW_delim_in_left287);
                    delim8=delim(false);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_delim.add(delim8.getTree());


                    // AST REWRITE
                    // elements: delim
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 44:52: -> ^( Left delim )
                    {
                        // src/grammar/Vitry.g:44:55: ^( Left delim )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Left, "Left"), root_1);

                        adaptor.addChild(root_1, stream_delim.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "left"

    public static class delim_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "delim"
    // src/grammar/Vitry.g:48:1: delim[boolean rs] : ( '(' ( inline[rs] )? ')' -> ^( Par ( inline )? ) | '[' ( inline[rs] )? ']' -> ^( Bra ( inline )? ) | '{' ( inline[rs] )? '}' -> ^( Ang ( inline )? ) | '`' delim[rs] -> ^( Quote delim ) | atom {...}? | Symbol );
    public final VitryParser.delim_return delim(boolean rs) throws RecognitionException {
        VitryParser.delim_return retval = new VitryParser.delim_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal9=null;
        Token char_literal11=null;
        Token char_literal12=null;
        Token char_literal14=null;
        Token char_literal15=null;
        Token char_literal17=null;
        Token char_literal18=null;
        Token Symbol21=null;
        VitryParser.inline_return inline10 = null;

        VitryParser.inline_return inline13 = null;

        VitryParser.inline_return inline16 = null;

        VitryParser.delim_return delim19 = null;

        VitryParser.atom_return atom20 = null;


        Object char_literal9_tree=null;
        Object char_literal11_tree=null;
        Object char_literal12_tree=null;
        Object char_literal14_tree=null;
        Object char_literal15_tree=null;
        Object char_literal17_tree=null;
        Object char_literal18_tree=null;
        Object Symbol21_tree=null;
        RewriteRuleTokenStream stream_45=new RewriteRuleTokenStream(adaptor,"token 45");
        RewriteRuleTokenStream stream_43=new RewriteRuleTokenStream(adaptor,"token 43");
        RewriteRuleTokenStream stream_44=new RewriteRuleTokenStream(adaptor,"token 44");
        RewriteRuleTokenStream stream_42=new RewriteRuleTokenStream(adaptor,"token 42");
        RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
        RewriteRuleTokenStream stream_46=new RewriteRuleTokenStream(adaptor,"token 46");
        RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
        RewriteRuleSubtreeStream stream_inline=new RewriteRuleSubtreeStream(adaptor,"rule inline");
        RewriteRuleSubtreeStream stream_delim=new RewriteRuleSubtreeStream(adaptor,"rule delim");
        try {
            // src/grammar/Vitry.g:49:5: ( '(' ( inline[rs] )? ')' -> ^( Par ( inline )? ) | '[' ( inline[rs] )? ']' -> ^( Bra ( inline )? ) | '{' ( inline[rs] )? '}' -> ^( Ang ( inline )? ) | '`' delim[rs] -> ^( Quote delim ) | atom {...}? | Symbol )
            int alt6=6;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt6=1;
                }
                break;
            case 42:
                {
                alt6=2;
                }
                break;
            case 44:
                {
                alt6=3;
                }
                break;
            case 46:
                {
                alt6=4;
                }
                break;
            case Natural:
            case Float:
            case Complex:
            case String:
                {
                alt6=5;
                }
                break;
            case Symbol:
                {
                alt6=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // src/grammar/Vitry.g:49:7: '(' ( inline[rs] )? ')'
                    {
                    char_literal9=(Token)match(input,40,FOLLOW_40_in_delim348); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(char_literal9);

                    // src/grammar/Vitry.g:49:11: ( inline[rs] )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( ((LA3_0>=Symbol && LA3_0<=Op)||LA3_0==40||LA3_0==42||LA3_0==44||(LA3_0>=46 && LA3_0<=51)||(LA3_0>=53 && LA3_0<=54)) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // src/grammar/Vitry.g:49:11: inline[rs]
                            {
                            pushFollow(FOLLOW_inline_in_delim350);
                            inline10=inline(rs);

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_inline.add(inline10.getTree());

                            }
                            break;

                    }

                    char_literal11=(Token)match(input,41,FOLLOW_41_in_delim354); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_41.add(char_literal11);



                    // AST REWRITE
                    // elements: inline
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 49:52: -> ^( Par ( inline )? )
                    {
                        // src/grammar/Vitry.g:49:55: ^( Par ( inline )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Par, "Par"), root_1);

                        // src/grammar/Vitry.g:49:61: ( inline )?
                        if ( stream_inline.hasNext() ) {
                            adaptor.addChild(root_1, stream_inline.nextTree());

                        }
                        stream_inline.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // src/grammar/Vitry.g:50:7: '[' ( inline[rs] )? ']'
                    {
                    char_literal12=(Token)match(input,42,FOLLOW_42_in_delim396); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_42.add(char_literal12);

                    // src/grammar/Vitry.g:50:11: ( inline[rs] )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( ((LA4_0>=Symbol && LA4_0<=Op)||LA4_0==40||LA4_0==42||LA4_0==44||(LA4_0>=46 && LA4_0<=51)||(LA4_0>=53 && LA4_0<=54)) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // src/grammar/Vitry.g:50:11: inline[rs]
                            {
                            pushFollow(FOLLOW_inline_in_delim398);
                            inline13=inline(rs);

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_inline.add(inline13.getTree());

                            }
                            break;

                    }

                    char_literal14=(Token)match(input,43,FOLLOW_43_in_delim402); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_43.add(char_literal14);



                    // AST REWRITE
                    // elements: inline
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 50:52: -> ^( Bra ( inline )? )
                    {
                        // src/grammar/Vitry.g:50:55: ^( Bra ( inline )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Bra, "Bra"), root_1);

                        // src/grammar/Vitry.g:50:61: ( inline )?
                        if ( stream_inline.hasNext() ) {
                            adaptor.addChild(root_1, stream_inline.nextTree());

                        }
                        stream_inline.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // src/grammar/Vitry.g:51:7: '{' ( inline[rs] )? '}'
                    {
                    char_literal15=(Token)match(input,44,FOLLOW_44_in_delim444); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_44.add(char_literal15);

                    // src/grammar/Vitry.g:51:11: ( inline[rs] )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( ((LA5_0>=Symbol && LA5_0<=Op)||LA5_0==40||LA5_0==42||LA5_0==44||(LA5_0>=46 && LA5_0<=51)||(LA5_0>=53 && LA5_0<=54)) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // src/grammar/Vitry.g:51:11: inline[rs]
                            {
                            pushFollow(FOLLOW_inline_in_delim446);
                            inline16=inline(rs);

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_inline.add(inline16.getTree());

                            }
                            break;

                    }

                    char_literal17=(Token)match(input,45,FOLLOW_45_in_delim450); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_45.add(char_literal17);



                    // AST REWRITE
                    // elements: inline
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 51:52: -> ^( Ang ( inline )? )
                    {
                        // src/grammar/Vitry.g:51:55: ^( Ang ( inline )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Ang, "Ang"), root_1);

                        // src/grammar/Vitry.g:51:61: ( inline )?
                        if ( stream_inline.hasNext() ) {
                            adaptor.addChild(root_1, stream_inline.nextTree());

                        }
                        stream_inline.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // src/grammar/Vitry.g:52:7: '`' delim[rs]
                    {
                    char_literal18=(Token)match(input,46,FOLLOW_46_in_delim492); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_46.add(char_literal18);

                    pushFollow(FOLLOW_delim_in_delim494);
                    delim19=delim(rs);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_delim.add(delim19.getTree());


                    // AST REWRITE
                    // elements: delim
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 52:52: -> ^( Quote delim )
                    {
                        // src/grammar/Vitry.g:52:55: ^( Quote delim )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Quote, "Quote"), root_1);

                        adaptor.addChild(root_1, stream_delim.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // src/grammar/Vitry.g:53:7: atom {...}?
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_atom_in_delim542);
                    atom20=atom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, atom20.getTree());
                    if ( !((rs)) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "delim", "$rs");
                    }

                    }
                    break;
                case 6 :
                    // src/grammar/Vitry.g:54:7: Symbol
                    {
                    root_0 = (Object)adaptor.nil();

                    Symbol21=(Token)match(input,Symbol,FOLLOW_Symbol_in_delim552); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Symbol21_tree = (Object)adaptor.create(Symbol21);
                    adaptor.addChild(root_0, Symbol21_tree);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "delim"

    public static class atom_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "atom"
    // src/grammar/Vitry.g:57:1: atom : ( Natural | Float | Complex | String );
    public final VitryParser.atom_return atom() throws RecognitionException {
        VitryParser.atom_return retval = new VitryParser.atom_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set22=null;

        Object set22_tree=null;

        try {
            // src/grammar/Vitry.g:58:5: ( Natural | Float | Complex | String )
            // src/grammar/Vitry.g:
            {
            root_0 = (Object)adaptor.nil();

            set22=(Token)input.LT(1);
            if ( (input.LA(1)>=Natural && input.LA(1)<=String) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set22));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "atom"

    public static class inline_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "inline"
    // src/grammar/Vitry.g:65:1: inline[boolean rs] : ({...}? inlineRight | ( Op ( apply )? )+ -> ^( Ops ( ^( Op ( apply )? ) )+ ) | ( apply Op )=>e+= apply ( Op (f+= apply )? )+ -> ^( Ops $e ( ^( Op $f) )+ ) | apply );
    public final VitryParser.inline_return inline(boolean rs) throws RecognitionException {
        VitryParser.inline_return retval = new VitryParser.inline_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Op24=null;
        Token Op26=null;
        List list_e=null;
        List list_f=null;
        VitryParser.inlineRight_return inlineRight23 = null;

        VitryParser.apply_return apply25 = null;

        VitryParser.apply_return apply27 = null;

        RuleReturnScope e = null;
        RuleReturnScope f = null;
        Object Op24_tree=null;
        Object Op26_tree=null;
        RewriteRuleTokenStream stream_Op=new RewriteRuleTokenStream(adaptor,"token Op");
        RewriteRuleSubtreeStream stream_apply=new RewriteRuleSubtreeStream(adaptor,"rule apply");
        try {
            // src/grammar/Vitry.g:66:5: ({...}? inlineRight | ( Op ( apply )? )+ -> ^( Ops ( ^( Op ( apply )? ) )+ ) | ( apply Op )=>e+= apply ( Op (f+= apply )? )+ -> ^( Ops $e ( ^( Op $f) )+ ) | apply )
            int alt11=4;
            alt11 = dfa11.predict(input);
            switch (alt11) {
                case 1 :
                    // src/grammar/Vitry.g:66:7: {...}? inlineRight
                    {
                    root_0 = (Object)adaptor.nil();

                    if ( !((rs)) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "inline", "$rs");
                    }
                    pushFollow(FOLLOW_inlineRight_in_inline622);
                    inlineRight23=inlineRight();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, inlineRight23.getTree());

                    }
                    break;
                case 2 :
                    // src/grammar/Vitry.g:67:7: ( Op ( apply )? )+
                    {
                    // src/grammar/Vitry.g:67:7: ( Op ( apply )? )+
                    int cnt8=0;
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==Op) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // src/grammar/Vitry.g:67:8: Op ( apply )?
                    	    {
                    	    Op24=(Token)match(input,Op,FOLLOW_Op_in_inline631); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_Op.add(Op24);

                    	    // src/grammar/Vitry.g:67:11: ( apply )?
                    	    int alt7=2;
                    	    int LA7_0 = input.LA(1);

                    	    if ( ((LA7_0>=Symbol && LA7_0<=String)||LA7_0==40||LA7_0==42||LA7_0==44||LA7_0==46) ) {
                    	        alt7=1;
                    	    }
                    	    switch (alt7) {
                    	        case 1 :
                    	            // src/grammar/Vitry.g:67:11: apply
                    	            {
                    	            pushFollow(FOLLOW_apply_in_inline633);
                    	            apply25=apply();

                    	            state._fsp--;
                    	            if (state.failed) return retval;
                    	            if ( state.backtracking==0 ) stream_apply.add(apply25.getTree());

                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt8 >= 1 ) break loop8;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(8, input);
                                throw eee;
                        }
                        cnt8++;
                    } while (true);



                    // AST REWRITE
                    // elements: Op, apply
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 67:52: -> ^( Ops ( ^( Op ( apply )? ) )+ )
                    {
                        // src/grammar/Vitry.g:67:55: ^( Ops ( ^( Op ( apply )? ) )+ )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Ops, "Ops"), root_1);

                        if ( !(stream_Op.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_Op.hasNext() ) {
                            // src/grammar/Vitry.g:67:61: ^( Op ( apply )? )
                            {
                            Object root_2 = (Object)adaptor.nil();
                            root_2 = (Object)adaptor.becomeRoot(stream_Op.nextNode(), root_2);

                            // src/grammar/Vitry.g:67:66: ( apply )?
                            if ( stream_apply.hasNext() ) {
                                adaptor.addChild(root_2, stream_apply.nextTree());

                            }
                            stream_apply.reset();

                            adaptor.addChild(root_1, root_2);
                            }

                        }
                        stream_Op.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // src/grammar/Vitry.g:68:7: ( apply Op )=>e+= apply ( Op (f+= apply )? )+
                    {
                    pushFollow(FOLLOW_apply_in_inline700);
                    e=apply();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_apply.add(e.getTree());
                    if (list_e==null) list_e=new ArrayList();
                    list_e.add(e.getTree());

                    // src/grammar/Vitry.g:68:30: ( Op (f+= apply )? )+
                    int cnt10=0;
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==Op) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // src/grammar/Vitry.g:68:31: Op (f+= apply )?
                    	    {
                    	    Op26=(Token)match(input,Op,FOLLOW_Op_in_inline703); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_Op.add(Op26);

                    	    // src/grammar/Vitry.g:68:35: (f+= apply )?
                    	    int alt9=2;
                    	    int LA9_0 = input.LA(1);

                    	    if ( ((LA9_0>=Symbol && LA9_0<=String)||LA9_0==40||LA9_0==42||LA9_0==44||LA9_0==46) ) {
                    	        alt9=1;
                    	    }
                    	    switch (alt9) {
                    	        case 1 :
                    	            // src/grammar/Vitry.g:68:35: f+= apply
                    	            {
                    	            pushFollow(FOLLOW_apply_in_inline707);
                    	            f=apply();

                    	            state._fsp--;
                    	            if (state.failed) return retval;
                    	            if ( state.backtracking==0 ) stream_apply.add(f.getTree());
                    	            if (list_f==null) list_f=new ArrayList();
                    	            list_f.add(f.getTree());


                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt10 >= 1 ) break loop10;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(10, input);
                                throw eee;
                        }
                        cnt10++;
                    } while (true);



                    // AST REWRITE
                    // elements: f, e, Op
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: f, e
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_f=new RewriteRuleSubtreeStream(adaptor,"token f",list_f);
                    RewriteRuleSubtreeStream stream_e=new RewriteRuleSubtreeStream(adaptor,"token e",list_e);
                    root_0 = (Object)adaptor.nil();
                    // 68:52: -> ^( Ops $e ( ^( Op $f) )+ )
                    {
                        // src/grammar/Vitry.g:68:55: ^( Ops $e ( ^( Op $f) )+ )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Ops, "Ops"), root_1);

                        adaptor.addChild(root_1, stream_e.nextTree());
                        if ( !(stream_f.hasNext()||stream_Op.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_f.hasNext()||stream_Op.hasNext() ) {
                            // src/grammar/Vitry.g:68:64: ^( Op $f)
                            {
                            Object root_2 = (Object)adaptor.nil();
                            root_2 = (Object)adaptor.becomeRoot(stream_Op.nextNode(), root_2);

                            adaptor.addChild(root_2, stream_f.nextTree());

                            adaptor.addChild(root_1, root_2);
                            }

                        }
                        stream_f.reset();
                        stream_Op.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // src/grammar/Vitry.g:69:7: apply
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_apply_in_inline742);
                    apply27=apply();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, apply27.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "inline"

    public static class inlineRight_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "inlineRight"
    // src/grammar/Vitry.g:73:1: inlineRight : ( 'fn' '(' ( left )* ')' inline[true] -> ^( Fn ( left )* inline ) | 'let' '(' ( assign )* ')' inline[true] -> ^( Let ( assign )* inline ) | 'loop' '(' ( assign )* ')' inline[true] -> ^( Loop ( assign )* inline ) | 'do' '(' ( assign )* ')' ( expr )* -> ^( Do ( assign )* ( expr )* ) | 'if' expr expr ( 'else' )? inline[true] -> ^( If expr expr inline ) | 'match' v= expr '(' (l+= left r+= expr )* ')' -> ^( Match $v ( ^( $l $r) )* ) | 'recur' ( expr )* -> ^( Recur ( expr )* ) );
    public final VitryParser.inlineRight_return inlineRight() throws RecognitionException {
        VitryParser.inlineRight_return retval = new VitryParser.inlineRight_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal28=null;
        Token char_literal29=null;
        Token char_literal31=null;
        Token string_literal33=null;
        Token char_literal34=null;
        Token char_literal36=null;
        Token string_literal38=null;
        Token char_literal39=null;
        Token char_literal41=null;
        Token string_literal43=null;
        Token char_literal44=null;
        Token char_literal46=null;
        Token string_literal48=null;
        Token string_literal51=null;
        Token string_literal53=null;
        Token char_literal54=null;
        Token char_literal55=null;
        Token string_literal56=null;
        List list_l=null;
        List list_r=null;
        VitryParser.expr_return v = null;

        VitryParser.left_return left30 = null;

        VitryParser.inline_return inline32 = null;

        VitryParser.assign_return assign35 = null;

        VitryParser.inline_return inline37 = null;

        VitryParser.assign_return assign40 = null;

        VitryParser.inline_return inline42 = null;

        VitryParser.assign_return assign45 = null;

        VitryParser.expr_return expr47 = null;

        VitryParser.expr_return expr49 = null;

        VitryParser.expr_return expr50 = null;

        VitryParser.inline_return inline52 = null;

        VitryParser.expr_return expr57 = null;

        RuleReturnScope l = null;
        RuleReturnScope r = null;
        Object string_literal28_tree=null;
        Object char_literal29_tree=null;
        Object char_literal31_tree=null;
        Object string_literal33_tree=null;
        Object char_literal34_tree=null;
        Object char_literal36_tree=null;
        Object string_literal38_tree=null;
        Object char_literal39_tree=null;
        Object char_literal41_tree=null;
        Object string_literal43_tree=null;
        Object char_literal44_tree=null;
        Object char_literal46_tree=null;
        Object string_literal48_tree=null;
        Object string_literal51_tree=null;
        Object string_literal53_tree=null;
        Object char_literal54_tree=null;
        Object char_literal55_tree=null;
        Object string_literal56_tree=null;
        RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
        RewriteRuleTokenStream stream_48=new RewriteRuleTokenStream(adaptor,"token 48");
        RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
        RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
        RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
        RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
        RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
        RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
        RewriteRuleTokenStream stream_54=new RewriteRuleTokenStream(adaptor,"token 54");
        RewriteRuleTokenStream stream_50=new RewriteRuleTokenStream(adaptor,"token 50");
        RewriteRuleSubtreeStream stream_assign=new RewriteRuleSubtreeStream(adaptor,"rule assign");
        RewriteRuleSubtreeStream stream_inline=new RewriteRuleSubtreeStream(adaptor,"rule inline");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        RewriteRuleSubtreeStream stream_left=new RewriteRuleSubtreeStream(adaptor,"rule left");
        try {
            // src/grammar/Vitry.g:74:5: ( 'fn' '(' ( left )* ')' inline[true] -> ^( Fn ( left )* inline ) | 'let' '(' ( assign )* ')' inline[true] -> ^( Let ( assign )* inline ) | 'loop' '(' ( assign )* ')' inline[true] -> ^( Loop ( assign )* inline ) | 'do' '(' ( assign )* ')' ( expr )* -> ^( Do ( assign )* ( expr )* ) | 'if' expr expr ( 'else' )? inline[true] -> ^( If expr expr inline ) | 'match' v= expr '(' (l+= left r+= expr )* ')' -> ^( Match $v ( ^( $l $r) )* ) | 'recur' ( expr )* -> ^( Recur ( expr )* ) )
            int alt20=7;
            switch ( input.LA(1) ) {
            case 47:
                {
                alt20=1;
                }
                break;
            case 48:
                {
                alt20=2;
                }
                break;
            case 49:
                {
                alt20=3;
                }
                break;
            case 50:
                {
                alt20=4;
                }
                break;
            case 51:
                {
                alt20=5;
                }
                break;
            case 53:
                {
                alt20=6;
                }
                break;
            case 54:
                {
                alt20=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // src/grammar/Vitry.g:74:7: 'fn' '(' ( left )* ')' inline[true]
                    {
                    string_literal28=(Token)match(input,47,FOLLOW_47_in_inlineRight786); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_47.add(string_literal28);

                    char_literal29=(Token)match(input,40,FOLLOW_40_in_inlineRight788); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(char_literal29);

                    // src/grammar/Vitry.g:74:16: ( left )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( ((LA12_0>=Symbol && LA12_0<=String)||LA12_0==40||LA12_0==42||LA12_0==44||LA12_0==46) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // src/grammar/Vitry.g:74:16: left
                    	    {
                    	    pushFollow(FOLLOW_left_in_inlineRight790);
                    	    left30=left();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_left.add(left30.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    char_literal31=(Token)match(input,41,FOLLOW_41_in_inlineRight793); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_41.add(char_literal31);

                    pushFollow(FOLLOW_inline_in_inlineRight795);
                    inline32=inline(true);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_inline.add(inline32.getTree());


                    // AST REWRITE
                    // elements: left, inline
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 74:52: -> ^( Fn ( left )* inline )
                    {
                        // src/grammar/Vitry.g:74:55: ^( Fn ( left )* inline )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Fn, "Fn"), root_1);

                        // src/grammar/Vitry.g:74:60: ( left )*
                        while ( stream_left.hasNext() ) {
                            adaptor.addChild(root_1, stream_left.nextTree());

                        }
                        stream_left.reset();
                        adaptor.addChild(root_1, stream_inline.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // src/grammar/Vitry.g:75:7: 'let' '(' ( assign )* ')' inline[true]
                    {
                    string_literal33=(Token)match(input,48,FOLLOW_48_in_inlineRight828); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_48.add(string_literal33);

                    char_literal34=(Token)match(input,40,FOLLOW_40_in_inlineRight830); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(char_literal34);

                    // src/grammar/Vitry.g:75:17: ( assign )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( ((LA13_0>=Symbol && LA13_0<=String)||LA13_0==40||LA13_0==42||LA13_0==44||LA13_0==46) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // src/grammar/Vitry.g:75:17: assign
                    	    {
                    	    pushFollow(FOLLOW_assign_in_inlineRight832);
                    	    assign35=assign();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_assign.add(assign35.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    char_literal36=(Token)match(input,41,FOLLOW_41_in_inlineRight835); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_41.add(char_literal36);

                    pushFollow(FOLLOW_inline_in_inlineRight837);
                    inline37=inline(true);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_inline.add(inline37.getTree());


                    // AST REWRITE
                    // elements: inline, assign
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 75:52: -> ^( Let ( assign )* inline )
                    {
                        // src/grammar/Vitry.g:75:55: ^( Let ( assign )* inline )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Let, "Let"), root_1);

                        // src/grammar/Vitry.g:75:61: ( assign )*
                        while ( stream_assign.hasNext() ) {
                            adaptor.addChild(root_1, stream_assign.nextTree());

                        }
                        stream_assign.reset();
                        adaptor.addChild(root_1, stream_inline.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // src/grammar/Vitry.g:76:7: 'loop' '(' ( assign )* ')' inline[true]
                    {
                    string_literal38=(Token)match(input,49,FOLLOW_49_in_inlineRight867); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_49.add(string_literal38);

                    char_literal39=(Token)match(input,40,FOLLOW_40_in_inlineRight869); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(char_literal39);

                    // src/grammar/Vitry.g:76:18: ( assign )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( ((LA14_0>=Symbol && LA14_0<=String)||LA14_0==40||LA14_0==42||LA14_0==44||LA14_0==46) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // src/grammar/Vitry.g:76:18: assign
                    	    {
                    	    pushFollow(FOLLOW_assign_in_inlineRight871);
                    	    assign40=assign();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_assign.add(assign40.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    char_literal41=(Token)match(input,41,FOLLOW_41_in_inlineRight874); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_41.add(char_literal41);

                    pushFollow(FOLLOW_inline_in_inlineRight876);
                    inline42=inline(true);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_inline.add(inline42.getTree());


                    // AST REWRITE
                    // elements: inline, assign
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 76:52: -> ^( Loop ( assign )* inline )
                    {
                        // src/grammar/Vitry.g:76:55: ^( Loop ( assign )* inline )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Loop, "Loop"), root_1);

                        // src/grammar/Vitry.g:76:62: ( assign )*
                        while ( stream_assign.hasNext() ) {
                            adaptor.addChild(root_1, stream_assign.nextTree());

                        }
                        stream_assign.reset();
                        adaptor.addChild(root_1, stream_inline.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // src/grammar/Vitry.g:77:7: 'do' '(' ( assign )* ')' ( expr )*
                    {
                    string_literal43=(Token)match(input,50,FOLLOW_50_in_inlineRight905); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_50.add(string_literal43);

                    char_literal44=(Token)match(input,40,FOLLOW_40_in_inlineRight907); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(char_literal44);

                    // src/grammar/Vitry.g:77:16: ( assign )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( ((LA15_0>=Symbol && LA15_0<=String)||LA15_0==40||LA15_0==42||LA15_0==44||LA15_0==46) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // src/grammar/Vitry.g:77:16: assign
                    	    {
                    	    pushFollow(FOLLOW_assign_in_inlineRight909);
                    	    assign45=assign();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_assign.add(assign45.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);

                    char_literal46=(Token)match(input,41,FOLLOW_41_in_inlineRight912); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_41.add(char_literal46);

                    // src/grammar/Vitry.g:77:28: ( expr )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( ((LA16_0>=Symbol && LA16_0<=String)||LA16_0==40||LA16_0==42||LA16_0==44||LA16_0==46) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // src/grammar/Vitry.g:77:28: expr
                    	    {
                    	    pushFollow(FOLLOW_expr_in_inlineRight914);
                    	    expr47=expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_expr.add(expr47.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);



                    // AST REWRITE
                    // elements: assign, expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 77:52: -> ^( Do ( assign )* ( expr )* )
                    {
                        // src/grammar/Vitry.g:77:55: ^( Do ( assign )* ( expr )* )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Do, "Do"), root_1);

                        // src/grammar/Vitry.g:77:60: ( assign )*
                        while ( stream_assign.hasNext() ) {
                            adaptor.addChild(root_1, stream_assign.nextTree());

                        }
                        stream_assign.reset();
                        // src/grammar/Vitry.g:77:68: ( expr )*
                        while ( stream_expr.hasNext() ) {
                            adaptor.addChild(root_1, stream_expr.nextTree());

                        }
                        stream_expr.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // src/grammar/Vitry.g:78:7: 'if' expr expr ( 'else' )? inline[true]
                    {
                    string_literal48=(Token)match(input,51,FOLLOW_51_in_inlineRight953); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_51.add(string_literal48);

                    pushFollow(FOLLOW_expr_in_inlineRight955);
                    expr49=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr49.getTree());
                    pushFollow(FOLLOW_expr_in_inlineRight957);
                    expr50=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr50.getTree());
                    // src/grammar/Vitry.g:78:22: ( 'else' )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==52) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // src/grammar/Vitry.g:78:22: 'else'
                            {
                            string_literal51=(Token)match(input,52,FOLLOW_52_in_inlineRight959); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_52.add(string_literal51);


                            }
                            break;

                    }

                    pushFollow(FOLLOW_inline_in_inlineRight962);
                    inline52=inline(true);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_inline.add(inline52.getTree());


                    // AST REWRITE
                    // elements: expr, expr, inline
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 78:52: -> ^( If expr expr inline )
                    {
                        // src/grammar/Vitry.g:78:55: ^( If expr expr inline )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(If, "If"), root_1);

                        adaptor.addChild(root_1, stream_expr.nextTree());
                        adaptor.addChild(root_1, stream_expr.nextTree());
                        adaptor.addChild(root_1, stream_inline.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 6 :
                    // src/grammar/Vitry.g:79:7: 'match' v= expr '(' (l+= left r+= expr )* ')'
                    {
                    string_literal53=(Token)match(input,53,FOLLOW_53_in_inlineRight992); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_53.add(string_literal53);

                    pushFollow(FOLLOW_expr_in_inlineRight996);
                    v=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(v.getTree());
                    char_literal54=(Token)match(input,40,FOLLOW_40_in_inlineRight998); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(char_literal54);

                    // src/grammar/Vitry.g:79:26: (l+= left r+= expr )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( ((LA18_0>=Symbol && LA18_0<=String)||LA18_0==40||LA18_0==42||LA18_0==44||LA18_0==46) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // src/grammar/Vitry.g:79:27: l+= left r+= expr
                    	    {
                    	    pushFollow(FOLLOW_left_in_inlineRight1003);
                    	    l=left();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_left.add(l.getTree());
                    	    if (list_l==null) list_l=new ArrayList();
                    	    list_l.add(l.getTree());

                    	    pushFollow(FOLLOW_expr_in_inlineRight1007);
                    	    r=expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_expr.add(r.getTree());
                    	    if (list_r==null) list_r=new ArrayList();
                    	    list_r.add(r.getTree());


                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);

                    char_literal55=(Token)match(input,41,FOLLOW_41_in_inlineRight1011); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_41.add(char_literal55);



                    // AST REWRITE
                    // elements: r, l, v
                    // token labels: 
                    // rule labels: v, retval
                    // token list labels: 
                    // rule list labels: r, l
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_v=new RewriteRuleSubtreeStream(adaptor,"rule v",v!=null?v.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_r=new RewriteRuleSubtreeStream(adaptor,"token r",list_r);
                    RewriteRuleSubtreeStream stream_l=new RewriteRuleSubtreeStream(adaptor,"token l",list_l);
                    root_0 = (Object)adaptor.nil();
                    // 79:52: -> ^( Match $v ( ^( $l $r) )* )
                    {
                        // src/grammar/Vitry.g:79:55: ^( Match $v ( ^( $l $r) )* )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Match, "Match"), root_1);

                        adaptor.addChild(root_1, stream_v.nextTree());
                        // src/grammar/Vitry.g:79:66: ( ^( $l $r) )*
                        while ( stream_r.hasNext()||stream_l.hasNext() ) {
                            // src/grammar/Vitry.g:79:66: ^( $l $r)
                            {
                            Object root_2 = (Object)adaptor.nil();
                            root_2 = (Object)adaptor.becomeRoot(stream_l.nextNode(), root_2);

                            adaptor.addChild(root_2, stream_r.nextTree());

                            adaptor.addChild(root_1, root_2);
                            }

                        }
                        stream_r.reset();
                        stream_l.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 7 :
                    // src/grammar/Vitry.g:80:7: 'recur' ( expr )*
                    {
                    string_literal56=(Token)match(input,54,FOLLOW_54_in_inlineRight1040); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_54.add(string_literal56);

                    // src/grammar/Vitry.g:80:15: ( expr )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( ((LA19_0>=Symbol && LA19_0<=String)||LA19_0==40||LA19_0==42||LA19_0==44||LA19_0==46) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // src/grammar/Vitry.g:80:15: expr
                    	    {
                    	    pushFollow(FOLLOW_expr_in_inlineRight1042);
                    	    expr57=expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_expr.add(expr57.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);



                    // AST REWRITE
                    // elements: expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 80:37: -> ^( Recur ( expr )* )
                    {
                        // src/grammar/Vitry.g:80:40: ^( Recur ( expr )* )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Recur, "Recur"), root_1);

                        // src/grammar/Vitry.g:80:48: ( expr )*
                        while ( stream_expr.hasNext() ) {
                            adaptor.addChild(root_1, stream_expr.nextTree());

                        }
                        stream_expr.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "inlineRight"

    public static class assign_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assign"
    // src/grammar/Vitry.g:83:1: assign : left '=' expr -> ^( Assign left expr ) ;
    public final VitryParser.assign_return assign() throws RecognitionException {
        VitryParser.assign_return retval = new VitryParser.assign_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal59=null;
        VitryParser.left_return left58 = null;

        VitryParser.expr_return expr60 = null;


        Object char_literal59_tree=null;
        RewriteRuleTokenStream stream_55=new RewriteRuleTokenStream(adaptor,"token 55");
        RewriteRuleSubtreeStream stream_left=new RewriteRuleSubtreeStream(adaptor,"rule left");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // src/grammar/Vitry.g:84:5: ( left '=' expr -> ^( Assign left expr ) )
            // src/grammar/Vitry.g:84:7: left '=' expr
            {
            pushFollow(FOLLOW_left_in_assign1085);
            left58=left();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_left.add(left58.getTree());
            char_literal59=(Token)match(input,55,FOLLOW_55_in_assign1087); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_55.add(char_literal59);

            pushFollow(FOLLOW_expr_in_assign1089);
            expr60=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expr.add(expr60.getTree());


            // AST REWRITE
            // elements: expr, left
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 84:52: -> ^( Assign left expr )
            {
                // src/grammar/Vitry.g:84:55: ^( Assign left expr )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Assign, "Assign"), root_1);

                adaptor.addChild(root_1, stream_left.nextTree());
                adaptor.addChild(root_1, stream_expr.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "assign"

    public static class apply_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "apply"
    // src/grammar/Vitry.g:88:1: apply : ( ( expr expr )=> ( expr )+ -> ^( Apply ( expr )+ ) | expr );
    public final VitryParser.apply_return apply() throws RecognitionException {
        VitryParser.apply_return retval = new VitryParser.apply_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        VitryParser.expr_return expr61 = null;

        VitryParser.expr_return expr62 = null;


        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // src/grammar/Vitry.g:89:5: ( ( expr expr )=> ( expr )+ -> ^( Apply ( expr )+ ) | expr )
            int alt22=2;
            switch ( input.LA(1) ) {
            case 40:
                {
                int LA22_1 = input.LA(2);

                if ( (synpred4_Vitry()) ) {
                    alt22=1;
                }
                else if ( (true) ) {
                    alt22=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 1, input);

                    throw nvae;
                }
                }
                break;
            case 42:
                {
                int LA22_2 = input.LA(2);

                if ( (synpred4_Vitry()) ) {
                    alt22=1;
                }
                else if ( (true) ) {
                    alt22=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 2, input);

                    throw nvae;
                }
                }
                break;
            case 44:
                {
                int LA22_3 = input.LA(2);

                if ( (synpred4_Vitry()) ) {
                    alt22=1;
                }
                else if ( (true) ) {
                    alt22=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 3, input);

                    throw nvae;
                }
                }
                break;
            case 46:
                {
                int LA22_4 = input.LA(2);

                if ( (synpred4_Vitry()) ) {
                    alt22=1;
                }
                else if ( (true) ) {
                    alt22=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 4, input);

                    throw nvae;
                }
                }
                break;
            case Natural:
            case Float:
            case Complex:
            case String:
                {
                int LA22_5 = input.LA(2);

                if ( (synpred4_Vitry()) ) {
                    alt22=1;
                }
                else if ( (true) ) {
                    alt22=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 5, input);

                    throw nvae;
                }
                }
                break;
            case Symbol:
                {
                int LA22_6 = input.LA(2);

                if ( (synpred4_Vitry()) ) {
                    alt22=1;
                }
                else if ( (true) ) {
                    alt22=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 6, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // src/grammar/Vitry.g:89:7: ( expr expr )=> ( expr )+
                    {
                    // src/grammar/Vitry.g:89:22: ( expr )+
                    int cnt21=0;
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( ((LA21_0>=Symbol && LA21_0<=String)||LA21_0==40||LA21_0==42||LA21_0==44||LA21_0==46) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // src/grammar/Vitry.g:89:22: expr
                    	    {
                    	    pushFollow(FOLLOW_expr_in_apply1160);
                    	    expr61=expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_expr.add(expr61.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt21 >= 1 ) break loop21;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(21, input);
                                throw eee;
                        }
                        cnt21++;
                    } while (true);



                    // AST REWRITE
                    // elements: expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 89:52: -> ^( Apply ( expr )+ )
                    {
                        // src/grammar/Vitry.g:89:55: ^( Apply ( expr )+ )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Apply, "Apply"), root_1);

                        if ( !(stream_expr.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_expr.hasNext() ) {
                            adaptor.addChild(root_1, stream_expr.nextTree());

                        }
                        stream_expr.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // src/grammar/Vitry.g:90:7: expr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_expr_in_apply1202);
                    expr62=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr62.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "apply"

    public static class module_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "module"
    // src/grammar/Vitry.g:99:1: module : 'module' moduleName ( '(' (exports+= Symbol )* ')' )? ( 'import' (imports+= moduleName )* )* ( '(' declarations+= moduleDecl ')' )* -> ^( Module moduleName ( ^( $exports) )* ( ^( $imports) )* ( ^( $declarations) )* ) ;
    public final VitryParser.module_return module() throws RecognitionException {
        VitryParser.module_return retval = new VitryParser.module_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal63=null;
        Token char_literal65=null;
        Token char_literal66=null;
        Token string_literal67=null;
        Token char_literal68=null;
        Token char_literal69=null;
        Token exports=null;
        List list_exports=null;
        List list_imports=null;
        List list_declarations=null;
        VitryParser.moduleName_return moduleName64 = null;

        RuleReturnScope imports = null;
        RuleReturnScope declarations = null;
        Object string_literal63_tree=null;
        Object char_literal65_tree=null;
        Object char_literal66_tree=null;
        Object string_literal67_tree=null;
        Object char_literal68_tree=null;
        Object char_literal69_tree=null;
        Object exports_tree=null;
        RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
        RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
        RewriteRuleTokenStream stream_Symbol=new RewriteRuleTokenStream(adaptor,"token Symbol");
        RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
        RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
        RewriteRuleSubtreeStream stream_moduleName=new RewriteRuleSubtreeStream(adaptor,"rule moduleName");
        RewriteRuleSubtreeStream stream_moduleDecl=new RewriteRuleSubtreeStream(adaptor,"rule moduleDecl");
        try {
            // src/grammar/Vitry.g:100:5: ( 'module' moduleName ( '(' (exports+= Symbol )* ')' )? ( 'import' (imports+= moduleName )* )* ( '(' declarations+= moduleDecl ')' )* -> ^( Module moduleName ( ^( $exports) )* ( ^( $imports) )* ( ^( $declarations) )* ) )
            // src/grammar/Vitry.g:100:7: 'module' moduleName ( '(' (exports+= Symbol )* ')' )? ( 'import' (imports+= moduleName )* )* ( '(' declarations+= moduleDecl ')' )*
            {
            string_literal63=(Token)match(input,56,FOLLOW_56_in_module1234); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_56.add(string_literal63);

            pushFollow(FOLLOW_moduleName_in_module1236);
            moduleName64=moduleName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_moduleName.add(moduleName64.getTree());
            // src/grammar/Vitry.g:100:27: ( '(' (exports+= Symbol )* ')' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==40) ) {
                int LA24_1 = input.LA(2);

                if ( (LA24_1==Symbol) ) {
                    int LA24_3 = input.LA(3);

                    if ( (LA24_3==Symbol||LA24_3==41) ) {
                        alt24=1;
                    }
                }
                else if ( (LA24_1==41) ) {
                    alt24=1;
                }
            }
            switch (alt24) {
                case 1 :
                    // src/grammar/Vitry.g:100:28: '(' (exports+= Symbol )* ')'
                    {
                    char_literal65=(Token)match(input,40,FOLLOW_40_in_module1239); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(char_literal65);

                    // src/grammar/Vitry.g:100:39: (exports+= Symbol )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==Symbol) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // src/grammar/Vitry.g:100:39: exports+= Symbol
                    	    {
                    	    exports=(Token)match(input,Symbol,FOLLOW_Symbol_in_module1243); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_Symbol.add(exports);

                    	    if (list_exports==null) list_exports=new ArrayList();
                    	    list_exports.add(exports);


                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);

                    char_literal66=(Token)match(input,41,FOLLOW_41_in_module1246); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_41.add(char_literal66);


                    }
                    break;

            }

            // src/grammar/Vitry.g:101:7: ( 'import' (imports+= moduleName )* )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==57) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // src/grammar/Vitry.g:101:8: 'import' (imports+= moduleName )*
            	    {
            	    string_literal67=(Token)match(input,57,FOLLOW_57_in_module1257); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_57.add(string_literal67);

            	    // src/grammar/Vitry.g:101:24: (imports+= moduleName )*
            	    loop25:
            	    do {
            	        int alt25=2;
            	        int LA25_0 = input.LA(1);

            	        if ( (LA25_0==Symbol) ) {
            	            alt25=1;
            	        }


            	        switch (alt25) {
            	    	case 1 :
            	    	    // src/grammar/Vitry.g:101:24: imports+= moduleName
            	    	    {
            	    	    pushFollow(FOLLOW_moduleName_in_module1261);
            	    	    imports=moduleName();

            	    	    state._fsp--;
            	    	    if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) stream_moduleName.add(imports.getTree());
            	    	    if (list_imports==null) list_imports=new ArrayList();
            	    	    list_imports.add(imports.getTree());


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop25;
            	        }
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

            // src/grammar/Vitry.g:102:7: ( '(' declarations+= moduleDecl ')' )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==40) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // src/grammar/Vitry.g:102:9: '(' declarations+= moduleDecl ')'
            	    {
            	    char_literal68=(Token)match(input,40,FOLLOW_40_in_module1274); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_40.add(char_literal68);

            	    pushFollow(FOLLOW_moduleDecl_in_module1278);
            	    declarations=moduleDecl();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_moduleDecl.add(declarations.getTree());
            	    if (list_declarations==null) list_declarations=new ArrayList();
            	    list_declarations.add(declarations.getTree());

            	    char_literal69=(Token)match(input,41,FOLLOW_41_in_module1280); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_41.add(char_literal69);


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);



            // AST REWRITE
            // elements: declarations, moduleName, exports, imports
            // token labels: 
            // rule labels: retval
            // token list labels: exports
            // rule list labels: declarations, imports
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_exports=new RewriteRuleTokenStream(adaptor,"token exports", list_exports);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_declarations=new RewriteRuleSubtreeStream(adaptor,"token declarations",list_declarations);
            RewriteRuleSubtreeStream stream_imports=new RewriteRuleSubtreeStream(adaptor,"token imports",list_imports);
            root_0 = (Object)adaptor.nil();
            // 103:5: -> ^( Module moduleName ( ^( $exports) )* ( ^( $imports) )* ( ^( $declarations) )* )
            {
                // src/grammar/Vitry.g:103:8: ^( Module moduleName ( ^( $exports) )* ( ^( $imports) )* ( ^( $declarations) )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Module, "Module"), root_1);

                adaptor.addChild(root_1, stream_moduleName.nextTree());
                // src/grammar/Vitry.g:103:28: ( ^( $exports) )*
                while ( stream_exports.hasNext() ) {
                    // src/grammar/Vitry.g:103:28: ^( $exports)
                    {
                    Object root_2 = (Object)adaptor.nil();
                    root_2 = (Object)adaptor.becomeRoot(stream_exports.nextNode(), root_2);

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_exports.reset();
                // src/grammar/Vitry.g:103:41: ( ^( $imports) )*
                while ( stream_imports.hasNext() ) {
                    // src/grammar/Vitry.g:103:41: ^( $imports)
                    {
                    Object root_2 = (Object)adaptor.nil();
                    root_2 = (Object)adaptor.becomeRoot(stream_imports.nextNode(), root_2);

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_imports.reset();
                // src/grammar/Vitry.g:103:54: ( ^( $declarations) )*
                while ( stream_declarations.hasNext() ) {
                    // src/grammar/Vitry.g:103:54: ^( $declarations)
                    {
                    Object root_2 = (Object)adaptor.nil();
                    root_2 = (Object)adaptor.becomeRoot(stream_declarations.nextNode(), root_2);

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_declarations.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "module"

    public static class moduleDecl_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "moduleDecl"
    // src/grammar/Vitry.g:106:1: moduleDecl : ( 'type' '(' ( assign )* ')' -> ^( TypeDecl ( assign )* ) | 'impicit' '(' ( expr expr )* ')' -> ^( ImplicitDecl ( ^( expr expr ) )* ) | 'fn' Symbol '(' ( left )* ')' '=' inline[true] -> ^( FnDecl Symbol ( left )+ inline ) | left '=' expr -> ^( MemberDecl left expr ) );
    public final VitryParser.moduleDecl_return moduleDecl() throws RecognitionException {
        VitryParser.moduleDecl_return retval = new VitryParser.moduleDecl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal70=null;
        Token char_literal71=null;
        Token char_literal73=null;
        Token string_literal74=null;
        Token char_literal75=null;
        Token char_literal78=null;
        Token string_literal79=null;
        Token Symbol80=null;
        Token char_literal81=null;
        Token char_literal83=null;
        Token char_literal84=null;
        Token char_literal87=null;
        VitryParser.assign_return assign72 = null;

        VitryParser.expr_return expr76 = null;

        VitryParser.expr_return expr77 = null;

        VitryParser.left_return left82 = null;

        VitryParser.inline_return inline85 = null;

        VitryParser.left_return left86 = null;

        VitryParser.expr_return expr88 = null;


        Object string_literal70_tree=null;
        Object char_literal71_tree=null;
        Object char_literal73_tree=null;
        Object string_literal74_tree=null;
        Object char_literal75_tree=null;
        Object char_literal78_tree=null;
        Object string_literal79_tree=null;
        Object Symbol80_tree=null;
        Object char_literal81_tree=null;
        Object char_literal83_tree=null;
        Object char_literal84_tree=null;
        Object char_literal87_tree=null;
        RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
        RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
        RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
        RewriteRuleTokenStream stream_Symbol=new RewriteRuleTokenStream(adaptor,"token Symbol");
        RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
        RewriteRuleTokenStream stream_55=new RewriteRuleTokenStream(adaptor,"token 55");
        RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
        RewriteRuleSubtreeStream stream_assign=new RewriteRuleSubtreeStream(adaptor,"rule assign");
        RewriteRuleSubtreeStream stream_inline=new RewriteRuleSubtreeStream(adaptor,"rule inline");
        RewriteRuleSubtreeStream stream_left=new RewriteRuleSubtreeStream(adaptor,"rule left");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // src/grammar/Vitry.g:107:5: ( 'type' '(' ( assign )* ')' -> ^( TypeDecl ( assign )* ) | 'impicit' '(' ( expr expr )* ')' -> ^( ImplicitDecl ( ^( expr expr ) )* ) | 'fn' Symbol '(' ( left )* ')' '=' inline[true] -> ^( FnDecl Symbol ( left )+ inline ) | left '=' expr -> ^( MemberDecl left expr ) )
            int alt31=4;
            switch ( input.LA(1) ) {
            case 58:
                {
                alt31=1;
                }
                break;
            case 59:
                {
                alt31=2;
                }
                break;
            case 47:
                {
                alt31=3;
                }
                break;
            case Symbol:
            case Natural:
            case Float:
            case Complex:
            case String:
            case 40:
            case 42:
            case 44:
            case 46:
                {
                alt31=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // src/grammar/Vitry.g:107:7: 'type' '(' ( assign )* ')'
                    {
                    string_literal70=(Token)match(input,58,FOLLOW_58_in_moduleDecl1334); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_58.add(string_literal70);

                    char_literal71=(Token)match(input,40,FOLLOW_40_in_moduleDecl1341); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(char_literal71);

                    // src/grammar/Vitry.g:107:23: ( assign )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( ((LA28_0>=Symbol && LA28_0<=String)||LA28_0==40||LA28_0==42||LA28_0==44||LA28_0==46) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // src/grammar/Vitry.g:107:23: assign
                    	    {
                    	    pushFollow(FOLLOW_assign_in_moduleDecl1343);
                    	    assign72=assign();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_assign.add(assign72.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop28;
                        }
                    } while (true);

                    char_literal73=(Token)match(input,41,FOLLOW_41_in_moduleDecl1346); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_41.add(char_literal73);



                    // AST REWRITE
                    // elements: assign
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 107:50: -> ^( TypeDecl ( assign )* )
                    {
                        // src/grammar/Vitry.g:107:53: ^( TypeDecl ( assign )* )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TypeDecl, "TypeDecl"), root_1);

                        // src/grammar/Vitry.g:107:64: ( assign )*
                        while ( stream_assign.hasNext() ) {
                            adaptor.addChild(root_1, stream_assign.nextTree());

                        }
                        stream_assign.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // src/grammar/Vitry.g:108:7: 'impicit' '(' ( expr expr )* ')'
                    {
                    string_literal74=(Token)match(input,59,FOLLOW_59_in_moduleDecl1378); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_59.add(string_literal74);

                    char_literal75=(Token)match(input,40,FOLLOW_40_in_moduleDecl1382); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(char_literal75);

                    // src/grammar/Vitry.g:108:23: ( expr expr )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( ((LA29_0>=Symbol && LA29_0<=String)||LA29_0==40||LA29_0==42||LA29_0==44||LA29_0==46) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // src/grammar/Vitry.g:108:24: expr expr
                    	    {
                    	    pushFollow(FOLLOW_expr_in_moduleDecl1385);
                    	    expr76=expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_expr.add(expr76.getTree());
                    	    pushFollow(FOLLOW_expr_in_moduleDecl1387);
                    	    expr77=expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_expr.add(expr77.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop29;
                        }
                    } while (true);

                    char_literal78=(Token)match(input,41,FOLLOW_41_in_moduleDecl1391); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_41.add(char_literal78);



                    // AST REWRITE
                    // elements: expr, expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 108:50: -> ^( ImplicitDecl ( ^( expr expr ) )* )
                    {
                        // src/grammar/Vitry.g:108:53: ^( ImplicitDecl ( ^( expr expr ) )* )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ImplicitDecl, "ImplicitDecl"), root_1);

                        // src/grammar/Vitry.g:108:68: ( ^( expr expr ) )*
                        while ( stream_expr.hasNext()||stream_expr.hasNext() ) {
                            // src/grammar/Vitry.g:108:68: ^( expr expr )
                            {
                            Object root_2 = (Object)adaptor.nil();
                            root_2 = (Object)adaptor.becomeRoot(stream_expr.nextNode(), root_2);

                            adaptor.addChild(root_2, stream_expr.nextTree());

                            adaptor.addChild(root_1, root_2);
                            }

                        }
                        stream_expr.reset();
                        stream_expr.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // src/grammar/Vitry.g:109:7: 'fn' Symbol '(' ( left )* ')' '=' inline[true]
                    {
                    string_literal79=(Token)match(input,47,FOLLOW_47_in_moduleDecl1422); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_47.add(string_literal79);

                    Symbol80=(Token)match(input,Symbol,FOLLOW_Symbol_in_moduleDecl1424); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_Symbol.add(Symbol80);

                    char_literal81=(Token)match(input,40,FOLLOW_40_in_moduleDecl1426); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(char_literal81);

                    // src/grammar/Vitry.g:109:23: ( left )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( ((LA30_0>=Symbol && LA30_0<=String)||LA30_0==40||LA30_0==42||LA30_0==44||LA30_0==46) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // src/grammar/Vitry.g:109:23: left
                    	    {
                    	    pushFollow(FOLLOW_left_in_moduleDecl1428);
                    	    left82=left();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_left.add(left82.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop30;
                        }
                    } while (true);

                    char_literal83=(Token)match(input,41,FOLLOW_41_in_moduleDecl1431); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_41.add(char_literal83);

                    char_literal84=(Token)match(input,55,FOLLOW_55_in_moduleDecl1433); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_55.add(char_literal84);

                    pushFollow(FOLLOW_inline_in_moduleDecl1435);
                    inline85=inline(true);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_inline.add(inline85.getTree());


                    // AST REWRITE
                    // elements: left, Symbol, inline
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 109:50: -> ^( FnDecl Symbol ( left )+ inline )
                    {
                        // src/grammar/Vitry.g:109:53: ^( FnDecl Symbol ( left )+ inline )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FnDecl, "FnDecl"), root_1);

                        adaptor.addChild(root_1, stream_Symbol.nextNode());
                        if ( !(stream_left.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_left.hasNext() ) {
                            adaptor.addChild(root_1, stream_left.nextTree());

                        }
                        stream_left.reset();
                        adaptor.addChild(root_1, stream_inline.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // src/grammar/Vitry.g:110:7: left '=' expr
                    {
                    pushFollow(FOLLOW_left_in_moduleDecl1457);
                    left86=left();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_left.add(left86.getTree());
                    char_literal87=(Token)match(input,55,FOLLOW_55_in_moduleDecl1459); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_55.add(char_literal87);

                    pushFollow(FOLLOW_expr_in_moduleDecl1461);
                    expr88=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr88.getTree());


                    // AST REWRITE
                    // elements: left, expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 110:50: -> ^( MemberDecl left expr )
                    {
                        // src/grammar/Vitry.g:110:53: ^( MemberDecl left expr )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MemberDecl, "MemberDecl"), root_1);

                        adaptor.addChild(root_1, stream_left.nextTree());
                        adaptor.addChild(root_1, stream_expr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "moduleDecl"

    public static class moduleName_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "moduleName"
    // src/grammar/Vitry.g:113:1: moduleName : Symbol ( '.' Symbol )* -> ^( Symbol ( Symbol )+ ) ;
    public final VitryParser.moduleName_return moduleName() throws RecognitionException {
        VitryParser.moduleName_return retval = new VitryParser.moduleName_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Symbol89=null;
        Token char_literal90=null;
        Token Symbol91=null;

        Object Symbol89_tree=null;
        Object char_literal90_tree=null;
        Object Symbol91_tree=null;
        RewriteRuleTokenStream stream_Symbol=new RewriteRuleTokenStream(adaptor,"token Symbol");
        RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");

        try {
            // src/grammar/Vitry.g:113:12: ( Symbol ( '.' Symbol )* -> ^( Symbol ( Symbol )+ ) )
            // src/grammar/Vitry.g:114:5: Symbol ( '.' Symbol )*
            {
            Symbol89=(Token)match(input,Symbol,FOLLOW_Symbol_in_moduleName1521); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_Symbol.add(Symbol89);

            // src/grammar/Vitry.g:114:12: ( '.' Symbol )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==60) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // src/grammar/Vitry.g:114:13: '.' Symbol
            	    {
            	    char_literal90=(Token)match(input,60,FOLLOW_60_in_moduleName1524); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_60.add(char_literal90);

            	    Symbol91=(Token)match(input,Symbol,FOLLOW_Symbol_in_moduleName1526); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_Symbol.add(Symbol91);


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);



            // AST REWRITE
            // elements: Symbol, Symbol
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 114:26: -> ^( Symbol ( Symbol )+ )
            {
                // src/grammar/Vitry.g:114:29: ^( Symbol ( Symbol )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_Symbol.nextNode(), root_1);

                if ( !(stream_Symbol.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_Symbol.hasNext() ) {
                    adaptor.addChild(root_1, stream_Symbol.nextNode());

                }
                stream_Symbol.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "moduleName"

    // $ANTLR start synpred1_Vitry
    public final void synpred1_Vitry_fragment() throws RecognitionException {   
        // src/grammar/Vitry.g:36:7: ( delim[true] ':' )
        // src/grammar/Vitry.g:36:8: delim[true] ':'
        {
        pushFollow(FOLLOW_delim_in_synpred1_Vitry192);
        delim(true);

        state._fsp--;
        if (state.failed) return ;
        match(input,39,FOLLOW_39_in_synpred1_Vitry195); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_Vitry

    // $ANTLR start synpred2_Vitry
    public final void synpred2_Vitry_fragment() throws RecognitionException {   
        // src/grammar/Vitry.g:43:7: ( delim[false] ':' )
        // src/grammar/Vitry.g:43:8: delim[false] ':'
        {
        pushFollow(FOLLOW_delim_in_synpred2_Vitry251);
        delim(false);

        state._fsp--;
        if (state.failed) return ;
        match(input,39,FOLLOW_39_in_synpred2_Vitry254); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_Vitry

    // $ANTLR start synpred3_Vitry
    public final void synpred3_Vitry_fragment() throws RecognitionException {   
        // src/grammar/Vitry.g:68:7: ( apply Op )
        // src/grammar/Vitry.g:68:8: apply Op
        {
        pushFollow(FOLLOW_apply_in_synpred3_Vitry691);
        apply();

        state._fsp--;
        if (state.failed) return ;
        match(input,Op,FOLLOW_Op_in_synpred3_Vitry693); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_Vitry

    // $ANTLR start synpred4_Vitry
    public final void synpred4_Vitry_fragment() throws RecognitionException {   
        // src/grammar/Vitry.g:89:7: ( expr expr )
        // src/grammar/Vitry.g:89:8: expr expr
        {
        pushFollow(FOLLOW_expr_in_synpred4_Vitry1153);
        expr();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_expr_in_synpred4_Vitry1155);
        expr();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_Vitry

    // Delegated rules

    public final boolean synpred1_Vitry() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_Vitry_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_Vitry() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_Vitry_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_Vitry() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_Vitry_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_Vitry() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_Vitry_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA11 dfa11 = new DFA11(this);
    static final String DFA11_eotS =
        "\21\uffff";
    static final String DFA11_eofS =
        "\21\uffff";
    static final String DFA11_minS =
        "\1\33\10\uffff\6\0\2\uffff";
    static final String DFA11_maxS =
        "\1\66\10\uffff\6\0\2\uffff";
    static final String DFA11_acceptS =
        "\1\uffff\1\1\6\uffff\1\2\6\uffff\1\3\1\4";
    static final String DFA11_specialS =
        "\11\uffff\1\0\1\1\1\2\1\3\1\4\1\5\2\uffff}>";
    static final String[] DFA11_transitionS = {
            "\1\16\4\15\1\10\7\uffff\1\11\1\uffff\1\12\1\uffff\1\13\1\uffff"+
            "\1\14\5\1\1\uffff\2\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            ""
    };

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "65:1: inline[boolean rs] : ({...}? inlineRight | ( Op ( apply )? )+ -> ^( Ops ( ^( Op ( apply )? ) )+ ) | ( apply Op )=>e+= apply ( Op (f+= apply )? )+ -> ^( Ops $e ( ^( Op $f) )+ ) | apply );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA11_9 = input.LA(1);

                         
                        int index11_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_Vitry()) ) {s = 15;}

                        else if ( (true) ) {s = 16;}

                         
                        input.seek(index11_9);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA11_10 = input.LA(1);

                         
                        int index11_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_Vitry()) ) {s = 15;}

                        else if ( (true) ) {s = 16;}

                         
                        input.seek(index11_10);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA11_11 = input.LA(1);

                         
                        int index11_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_Vitry()) ) {s = 15;}

                        else if ( (true) ) {s = 16;}

                         
                        input.seek(index11_11);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA11_12 = input.LA(1);

                         
                        int index11_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_Vitry()) ) {s = 15;}

                        else if ( (true) ) {s = 16;}

                         
                        input.seek(index11_12);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA11_13 = input.LA(1);

                         
                        int index11_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_Vitry()) ) {s = 15;}

                        else if ( (true) ) {s = 16;}

                         
                        input.seek(index11_13);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA11_14 = input.LA(1);

                         
                        int index11_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_Vitry()) ) {s = 15;}

                        else if ( (true) ) {s = 16;}

                         
                        input.seek(index11_14);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 11, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_delim_in_expr200 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_expr203 = new BitSet(new long[]{0x00005500F8000000L});
    public static final BitSet FOLLOW_expr_in_expr205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_delim_in_expr226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_delim_in_left259 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_left262 = new BitSet(new long[]{0x00005500F8000000L});
    public static final BitSet FOLLOW_expr_in_left264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_delim_in_left287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_delim348 = new BitSet(new long[]{0x006FD701F8000000L});
    public static final BitSet FOLLOW_inline_in_delim350 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_delim354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_delim396 = new BitSet(new long[]{0x006FDD01F8000000L});
    public static final BitSet FOLLOW_inline_in_delim398 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_delim402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_delim444 = new BitSet(new long[]{0x006FF501F8000000L});
    public static final BitSet FOLLOW_inline_in_delim446 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_delim450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_delim492 = new BitSet(new long[]{0x00005500F8000000L});
    public static final BitSet FOLLOW_delim_in_delim494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_delim542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Symbol_in_delim552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_atom0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inlineRight_in_inline622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Op_in_inline631 = new BitSet(new long[]{0x00005501F8000002L});
    public static final BitSet FOLLOW_apply_in_inline633 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_apply_in_inline700 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_Op_in_inline703 = new BitSet(new long[]{0x00005501F8000002L});
    public static final BitSet FOLLOW_apply_in_inline707 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_apply_in_inline742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_inlineRight786 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_inlineRight788 = new BitSet(new long[]{0x00005700F8000000L});
    public static final BitSet FOLLOW_left_in_inlineRight790 = new BitSet(new long[]{0x00005700F8000000L});
    public static final BitSet FOLLOW_41_in_inlineRight793 = new BitSet(new long[]{0x006FD501F8000000L});
    public static final BitSet FOLLOW_inline_in_inlineRight795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_inlineRight828 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_inlineRight830 = new BitSet(new long[]{0x00005700F8000000L});
    public static final BitSet FOLLOW_assign_in_inlineRight832 = new BitSet(new long[]{0x00005700F8000000L});
    public static final BitSet FOLLOW_41_in_inlineRight835 = new BitSet(new long[]{0x006FD501F8000000L});
    public static final BitSet FOLLOW_inline_in_inlineRight837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_inlineRight867 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_inlineRight869 = new BitSet(new long[]{0x00005700F8000000L});
    public static final BitSet FOLLOW_assign_in_inlineRight871 = new BitSet(new long[]{0x00005700F8000000L});
    public static final BitSet FOLLOW_41_in_inlineRight874 = new BitSet(new long[]{0x006FD501F8000000L});
    public static final BitSet FOLLOW_inline_in_inlineRight876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_inlineRight905 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_inlineRight907 = new BitSet(new long[]{0x00005700F8000000L});
    public static final BitSet FOLLOW_assign_in_inlineRight909 = new BitSet(new long[]{0x00005700F8000000L});
    public static final BitSet FOLLOW_41_in_inlineRight912 = new BitSet(new long[]{0x00005500F8000002L});
    public static final BitSet FOLLOW_expr_in_inlineRight914 = new BitSet(new long[]{0x00005500F8000002L});
    public static final BitSet FOLLOW_51_in_inlineRight953 = new BitSet(new long[]{0x00005500F8000000L});
    public static final BitSet FOLLOW_expr_in_inlineRight955 = new BitSet(new long[]{0x00005500F8000000L});
    public static final BitSet FOLLOW_expr_in_inlineRight957 = new BitSet(new long[]{0x007FD501F8000000L});
    public static final BitSet FOLLOW_52_in_inlineRight959 = new BitSet(new long[]{0x006FD501F8000000L});
    public static final BitSet FOLLOW_inline_in_inlineRight962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_inlineRight992 = new BitSet(new long[]{0x00005500F8000000L});
    public static final BitSet FOLLOW_expr_in_inlineRight996 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_inlineRight998 = new BitSet(new long[]{0x00005700F8000000L});
    public static final BitSet FOLLOW_left_in_inlineRight1003 = new BitSet(new long[]{0x00005500F8000000L});
    public static final BitSet FOLLOW_expr_in_inlineRight1007 = new BitSet(new long[]{0x00005700F8000000L});
    public static final BitSet FOLLOW_41_in_inlineRight1011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_inlineRight1040 = new BitSet(new long[]{0x00005500F8000002L});
    public static final BitSet FOLLOW_expr_in_inlineRight1042 = new BitSet(new long[]{0x00005500F8000002L});
    public static final BitSet FOLLOW_left_in_assign1085 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_assign1087 = new BitSet(new long[]{0x00005500F8000000L});
    public static final BitSet FOLLOW_expr_in_assign1089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_apply1160 = new BitSet(new long[]{0x00005500F8000002L});
    public static final BitSet FOLLOW_expr_in_apply1202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_module1234 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_moduleName_in_module1236 = new BitSet(new long[]{0x0200010000000002L});
    public static final BitSet FOLLOW_40_in_module1239 = new BitSet(new long[]{0x0000020008000000L});
    public static final BitSet FOLLOW_Symbol_in_module1243 = new BitSet(new long[]{0x0000020008000000L});
    public static final BitSet FOLLOW_41_in_module1246 = new BitSet(new long[]{0x0200010000000002L});
    public static final BitSet FOLLOW_57_in_module1257 = new BitSet(new long[]{0x0200010008000002L});
    public static final BitSet FOLLOW_moduleName_in_module1261 = new BitSet(new long[]{0x0200010008000002L});
    public static final BitSet FOLLOW_40_in_module1274 = new BitSet(new long[]{0x0C00D500F8000000L});
    public static final BitSet FOLLOW_moduleDecl_in_module1278 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_module1280 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_58_in_moduleDecl1334 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_moduleDecl1341 = new BitSet(new long[]{0x00005700F8000000L});
    public static final BitSet FOLLOW_assign_in_moduleDecl1343 = new BitSet(new long[]{0x00005700F8000000L});
    public static final BitSet FOLLOW_41_in_moduleDecl1346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_moduleDecl1378 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_moduleDecl1382 = new BitSet(new long[]{0x00005700F8000000L});
    public static final BitSet FOLLOW_expr_in_moduleDecl1385 = new BitSet(new long[]{0x00005500F8000000L});
    public static final BitSet FOLLOW_expr_in_moduleDecl1387 = new BitSet(new long[]{0x00005700F8000000L});
    public static final BitSet FOLLOW_41_in_moduleDecl1391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_moduleDecl1422 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_Symbol_in_moduleDecl1424 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_moduleDecl1426 = new BitSet(new long[]{0x00005700F8000000L});
    public static final BitSet FOLLOW_left_in_moduleDecl1428 = new BitSet(new long[]{0x00005700F8000000L});
    public static final BitSet FOLLOW_41_in_moduleDecl1431 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_moduleDecl1433 = new BitSet(new long[]{0x006FD501F8000000L});
    public static final BitSet FOLLOW_inline_in_moduleDecl1435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_left_in_moduleDecl1457 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_moduleDecl1459 = new BitSet(new long[]{0x00005500F8000000L});
    public static final BitSet FOLLOW_expr_in_moduleDecl1461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Symbol_in_moduleName1521 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_60_in_moduleName1524 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_Symbol_in_moduleName1526 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_delim_in_synpred1_Vitry192 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_synpred1_Vitry195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_delim_in_synpred2_Vitry251 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_synpred2_Vitry254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_apply_in_synpred3_Vitry691 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_Op_in_synpred3_Vitry693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_synpred4_Vitry1153 = new BitSet(new long[]{0x00005500F8000000L});
    public static final BitSet FOLLOW_expr_in_synpred4_Vitry1155 = new BitSet(new long[]{0x0000000000000002L});

}