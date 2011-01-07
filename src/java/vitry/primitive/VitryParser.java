// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g 2011-01-06 01:53:27
package vitry.primitive;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

public class VitryParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Par", "Bra", "Ang", "Module", "Fn", "Let", "Where", "Assign", "Left", "Quote", "Apply", "Type", "If", "Match", "Loop", "Recur", "Do", "Ops", "Dummy", "TypeDecl", "ImplicitDecl", "FnDecl", "MemberDecl", "Symbol", "Op", "Natural", "Float", "Complex", "String", "Exponent", "Whitespace", "EscapeSeq", "HexDigit", "UnicodeEsc", "OctalEsc", "':'", "'('", "')'", "'['", "']'", "'{'", "'}'", "'`'", "'fn'", "'let'", "'loop'", "'if'", "'else'", "'match'", "'='", "'recur'", "'module'", "'import'", "'type'", "'impicit'", "'->'", "'.'"
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
    public static final int Op=28;
    public static final int String=32;
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
    public static final int Natural=29;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int Complex=31;
    public static final int Apply=14;
    public static final int ImplicitDecl=24;
    public static final int Float=30;
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
    public String getGrammarFileName() { return "/Users/hans/Documents/Kod/antlr/Vitry/Vitry.g"; }


    // TODO override mismatch() and recoverFromMismatchSet()


    public static class expr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expr"
    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:27:1: expr : ( ( delim[true] ':' )=> delim[true] ':' expr -> ^( Type delim expr ) | delim[true] );
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
            // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:28:5: ( ( delim[true] ':' )=> delim[true] ':' expr -> ^( Type delim expr ) | delim[true] )
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
                    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:28:7: ( delim[true] ':' )=> delim[true] ':' expr
                    {
                    pushFollow(FOLLOW_delim_in_expr192);
                    delim1=delim(true);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_delim.add(delim1.getTree());
                    char_literal2=(Token)match(input,39,FOLLOW_39_in_expr195); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_39.add(char_literal2);

                    pushFollow(FOLLOW_expr_in_expr197);
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
                    // 28:52: -> ^( Type delim expr )
                    {
                        // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:28:55: ^( Type delim expr )
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
                    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:29:7: delim[true]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_delim_in_expr218);
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
    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:32:1: left : ( ( delim[false] ':' )=> delim[false] ':' expr -> ^( Left ^( Type delim expr ) ) | delim[false] -> ^( Left delim ) );
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
            // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:33:5: ( ( delim[false] ':' )=> delim[false] ':' expr -> ^( Left ^( Type delim expr ) ) | delim[false] -> ^( Left delim ) )
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
                    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:33:7: ( delim[false] ':' )=> delim[false] ':' expr
                    {
                    pushFollow(FOLLOW_delim_in_left253);
                    delim5=delim(false);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_delim.add(delim5.getTree());
                    char_literal6=(Token)match(input,39,FOLLOW_39_in_left256); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_39.add(char_literal6);

                    pushFollow(FOLLOW_expr_in_left258);
                    expr7=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr7.getTree());


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
                    // 33:52: -> ^( Left ^( Type delim expr ) )
                    {
                        // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:33:55: ^( Left ^( Type delim expr ) )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Left, "Left"), root_1);

                        // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:33:62: ^( Type delim expr )
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
                    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:34:7: delim[false]
                    {
                    pushFollow(FOLLOW_delim_in_left281);
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
                    // 34:52: -> ^( Left delim )
                    {
                        // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:34:55: ^( Left delim )
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
    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:37:1: delim[boolean rs] : ( '(' ( inline[rs] )? ')' -> ^( Par ( inline )? ) | '[' ( inline[rs] )? ']' -> ^( Bra ( inline )? ) | '{' ( inline[rs] )? '}' -> ^( Ang ( inline )? ) | '`' delim[rs] -> ^( Quote delim ) | atom | Symbol );
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
            // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:38:5: ( '(' ( inline[rs] )? ')' -> ^( Par ( inline )? ) | '[' ( inline[rs] )? ']' -> ^( Bra ( inline )? ) | '{' ( inline[rs] )? '}' -> ^( Ang ( inline )? ) | '`' delim[rs] -> ^( Quote delim ) | atom | Symbol )
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
                    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:38:7: '(' ( inline[rs] )? ')'
                    {
                    char_literal9=(Token)match(input,40,FOLLOW_40_in_delim341); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(char_literal9);

                    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:38:11: ( inline[rs] )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( ((LA3_0>=Symbol && LA3_0<=String)||LA3_0==40||LA3_0==42||LA3_0==44||(LA3_0>=46 && LA3_0<=50)||LA3_0==52||LA3_0==54) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:38:11: inline[rs]
                            {
                            pushFollow(FOLLOW_inline_in_delim343);
                            inline10=inline(rs);

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_inline.add(inline10.getTree());

                            }
                            break;

                    }

                    char_literal11=(Token)match(input,41,FOLLOW_41_in_delim347); if (state.failed) return retval; 
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
                    // 38:52: -> ^( Par ( inline )? )
                    {
                        // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:38:55: ^( Par ( inline )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Par, "Par"), root_1);

                        // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:38:61: ( inline )?
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
                    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:39:7: '[' ( inline[rs] )? ']'
                    {
                    char_literal12=(Token)match(input,42,FOLLOW_42_in_delim389); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_42.add(char_literal12);

                    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:39:11: ( inline[rs] )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( ((LA4_0>=Symbol && LA4_0<=String)||LA4_0==40||LA4_0==42||LA4_0==44||(LA4_0>=46 && LA4_0<=50)||LA4_0==52||LA4_0==54) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:39:11: inline[rs]
                            {
                            pushFollow(FOLLOW_inline_in_delim391);
                            inline13=inline(rs);

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_inline.add(inline13.getTree());

                            }
                            break;

                    }

                    char_literal14=(Token)match(input,43,FOLLOW_43_in_delim395); if (state.failed) return retval; 
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
                    // 39:52: -> ^( Bra ( inline )? )
                    {
                        // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:39:55: ^( Bra ( inline )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Bra, "Bra"), root_1);

                        // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:39:61: ( inline )?
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
                    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:40:7: '{' ( inline[rs] )? '}'
                    {
                    char_literal15=(Token)match(input,44,FOLLOW_44_in_delim437); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_44.add(char_literal15);

                    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:40:11: ( inline[rs] )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( ((LA5_0>=Symbol && LA5_0<=String)||LA5_0==40||LA5_0==42||LA5_0==44||(LA5_0>=46 && LA5_0<=50)||LA5_0==52||LA5_0==54) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:40:11: inline[rs]
                            {
                            pushFollow(FOLLOW_inline_in_delim439);
                            inline16=inline(rs);

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_inline.add(inline16.getTree());

                            }
                            break;

                    }

                    char_literal17=(Token)match(input,45,FOLLOW_45_in_delim443); if (state.failed) return retval; 
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
                    // 40:52: -> ^( Ang ( inline )? )
                    {
                        // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:40:55: ^( Ang ( inline )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Ang, "Ang"), root_1);

                        // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:40:61: ( inline )?
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
                    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:41:7: '`' delim[rs]
                    {
                    char_literal18=(Token)match(input,46,FOLLOW_46_in_delim485); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_46.add(char_literal18);

                    pushFollow(FOLLOW_delim_in_delim487);
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
                    // 41:52: -> ^( Quote delim )
                    {
                        // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:41:55: ^( Quote delim )
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
                    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:42:20: atom
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_atom_in_delim537);
                    atom20=atom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, atom20.getTree());

                    }
                    break;
                case 6 :
                    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:43:7: Symbol
                    {
                    root_0 = (Object)adaptor.nil();

                    Symbol21=(Token)match(input,Symbol,FOLLOW_Symbol_in_delim598); if (state.failed) return retval;
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

    public static class inline_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "inline"
    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:46:1: inline[boolean rs] : ({...}? inlineRight | ( Op ( apply )? )+ -> ^( Ops ( ^( Op ( apply )? ) )+ ) | ( apply Op )=>e+= apply ( Op (f+= apply )? )+ -> ^( Ops $e ( ^( Op $f) )+ ) | apply );
    public final VitryParser.inline_return inline(boolean rs) throws RecognitionException {
        VitryParser.inline_return retval = new VitryParser.inline_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Op23=null;
        Token Op25=null;
        List list_e=null;
        List list_f=null;
        VitryParser.inlineRight_return inlineRight22 = null;

        VitryParser.apply_return apply24 = null;

        VitryParser.apply_return apply26 = null;

        RuleReturnScope e = null;
        RuleReturnScope f = null;
        Object Op23_tree=null;
        Object Op25_tree=null;
        RewriteRuleTokenStream stream_Op=new RewriteRuleTokenStream(adaptor,"token Op");
        RewriteRuleSubtreeStream stream_apply=new RewriteRuleSubtreeStream(adaptor,"rule apply");
        try {
            // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:47:5: ({...}? inlineRight | ( Op ( apply )? )+ -> ^( Ops ( ^( Op ( apply )? ) )+ ) | ( apply Op )=>e+= apply ( Op (f+= apply )? )+ -> ^( Ops $e ( ^( Op $f) )+ ) | apply )
            int alt11=4;
            alt11 = dfa11.predict(input);
            switch (alt11) {
                case 1 :
                    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:47:7: {...}? inlineRight
                    {
                    root_0 = (Object)adaptor.nil();

                    if ( !((rs)) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "inline", "$rs");
                    }
                    pushFollow(FOLLOW_inlineRight_in_inline623);
                    inlineRight22=inlineRight();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, inlineRight22.getTree());

                    }
                    break;
                case 2 :
                    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:48:7: ( Op ( apply )? )+
                    {
                    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:48:7: ( Op ( apply )? )+
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
                    	    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:48:8: Op ( apply )?
                    	    {
                    	    Op23=(Token)match(input,Op,FOLLOW_Op_in_inline632); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_Op.add(Op23);

                    	    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:48:11: ( apply )?
                    	    int alt7=2;
                    	    int LA7_0 = input.LA(1);

                    	    if ( (LA7_0==Symbol||(LA7_0>=Natural && LA7_0<=String)||LA7_0==40||LA7_0==42||LA7_0==44||LA7_0==46) ) {
                    	        alt7=1;
                    	    }
                    	    switch (alt7) {
                    	        case 1 :
                    	            // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:48:11: apply
                    	            {
                    	            pushFollow(FOLLOW_apply_in_inline634);
                    	            apply24=apply();

                    	            state._fsp--;
                    	            if (state.failed) return retval;
                    	            if ( state.backtracking==0 ) stream_apply.add(apply24.getTree());

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
                    // 48:52: -> ^( Ops ( ^( Op ( apply )? ) )+ )
                    {
                        // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:48:55: ^( Ops ( ^( Op ( apply )? ) )+ )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Ops, "Ops"), root_1);

                        if ( !(stream_Op.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_Op.hasNext() ) {
                            // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:48:61: ^( Op ( apply )? )
                            {
                            Object root_2 = (Object)adaptor.nil();
                            root_2 = (Object)adaptor.becomeRoot(stream_Op.nextNode(), root_2);

                            // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:48:66: ( apply )?
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
                    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:49:7: ( apply Op )=>e+= apply ( Op (f+= apply )? )+
                    {
                    pushFollow(FOLLOW_apply_in_inline701);
                    e=apply();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_apply.add(e.getTree());
                    if (list_e==null) list_e=new ArrayList();
                    list_e.add(e.getTree());

                    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:49:30: ( Op (f+= apply )? )+
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
                    	    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:49:31: Op (f+= apply )?
                    	    {
                    	    Op25=(Token)match(input,Op,FOLLOW_Op_in_inline704); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_Op.add(Op25);

                    	    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:49:35: (f+= apply )?
                    	    int alt9=2;
                    	    int LA9_0 = input.LA(1);

                    	    if ( (LA9_0==Symbol||(LA9_0>=Natural && LA9_0<=String)||LA9_0==40||LA9_0==42||LA9_0==44||LA9_0==46) ) {
                    	        alt9=1;
                    	    }
                    	    switch (alt9) {
                    	        case 1 :
                    	            // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:49:35: f+= apply
                    	            {
                    	            pushFollow(FOLLOW_apply_in_inline708);
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
                    // elements: f, Op, e
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
                    // 49:52: -> ^( Ops $e ( ^( Op $f) )+ )
                    {
                        // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:49:55: ^( Ops $e ( ^( Op $f) )+ )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Ops, "Ops"), root_1);

                        adaptor.addChild(root_1, stream_e.nextTree());
                        if ( !(stream_f.hasNext()||stream_Op.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_f.hasNext()||stream_Op.hasNext() ) {
                            // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:49:64: ^( Op $f)
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
                    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:50:7: apply
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_apply_in_inline743);
                    apply26=apply();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, apply26.getTree());

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

    public static class atom_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "atom"
    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:53:1: atom : ( Natural | Float | Complex | String );
    public final VitryParser.atom_return atom() throws RecognitionException {
        VitryParser.atom_return retval = new VitryParser.atom_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set27=null;

        Object set27_tree=null;

        try {
            // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:54:2: ( Natural | Float | Complex | String )
            // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:
            {
            root_0 = (Object)adaptor.nil();

            set27=(Token)input.LT(1);
            if ( (input.LA(1)>=Natural && input.LA(1)<=String) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set27));
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

    public static class inlineRight_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "inlineRight"
    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:60:1: inlineRight : ( 'fn' '(' ( left )* ')' inline[true] -> ^( Fn ( left )+ inline ) | 'let' '(' ( assign )* ')' inline[true] -> ^( Let ( assign )+ inline ) | 'loop' '(' ( assign )* ')' inline[true] -> ^( Loop ( assign )+ inline ) | 'if' expr expr ( 'else' )? inline[true] -> ^( If ( expr )+ ( inline )? ) | 'match' v= expr '(' (l+= left r+= expr )* ')' -> ^( Match $v ( ^( $l $r) )* ) | recur );
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
        Token string_literal46=null;
        Token string_literal48=null;
        Token char_literal49=null;
        Token char_literal50=null;
        List list_l=null;
        List list_r=null;
        VitryParser.expr_return v = null;

        VitryParser.left_return left30 = null;

        VitryParser.inline_return inline32 = null;

        VitryParser.assign_return assign35 = null;

        VitryParser.inline_return inline37 = null;

        VitryParser.assign_return assign40 = null;

        VitryParser.inline_return inline42 = null;

        VitryParser.expr_return expr44 = null;

        VitryParser.expr_return expr45 = null;

        VitryParser.inline_return inline47 = null;

        VitryParser.recur_return recur51 = null;

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
        Object string_literal46_tree=null;
        Object string_literal48_tree=null;
        Object char_literal49_tree=null;
        Object char_literal50_tree=null;
        RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
        RewriteRuleTokenStream stream_48=new RewriteRuleTokenStream(adaptor,"token 48");
        RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
        RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
        RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
        RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
        RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
        RewriteRuleTokenStream stream_50=new RewriteRuleTokenStream(adaptor,"token 50");
        RewriteRuleSubtreeStream stream_assign=new RewriteRuleSubtreeStream(adaptor,"rule assign");
        RewriteRuleSubtreeStream stream_inline=new RewriteRuleSubtreeStream(adaptor,"rule inline");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        RewriteRuleSubtreeStream stream_left=new RewriteRuleSubtreeStream(adaptor,"rule left");
        try {
            // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:61:5: ( 'fn' '(' ( left )* ')' inline[true] -> ^( Fn ( left )+ inline ) | 'let' '(' ( assign )* ')' inline[true] -> ^( Let ( assign )+ inline ) | 'loop' '(' ( assign )* ')' inline[true] -> ^( Loop ( assign )+ inline ) | 'if' expr expr ( 'else' )? inline[true] -> ^( If ( expr )+ ( inline )? ) | 'match' v= expr '(' (l+= left r+= expr )* ')' -> ^( Match $v ( ^( $l $r) )* ) | recur )
            int alt17=6;
            switch ( input.LA(1) ) {
            case 47:
                {
                alt17=1;
                }
                break;
            case 48:
                {
                alt17=2;
                }
                break;
            case 49:
                {
                alt17=3;
                }
                break;
            case 50:
                {
                alt17=4;
                }
                break;
            case 52:
                {
                alt17=5;
                }
                break;
            case 54:
                {
                alt17=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:61:7: 'fn' '(' ( left )* ')' inline[true]
                    {
                    string_literal28=(Token)match(input,47,FOLLOW_47_in_inlineRight833); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_47.add(string_literal28);

                    char_literal29=(Token)match(input,40,FOLLOW_40_in_inlineRight835); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(char_literal29);

                    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:61:16: ( left )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==Symbol||(LA12_0>=Natural && LA12_0<=String)||LA12_0==40||LA12_0==42||LA12_0==44||LA12_0==46) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:61:16: left
                    	    {
                    	    pushFollow(FOLLOW_left_in_inlineRight837);
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

                    char_literal31=(Token)match(input,41,FOLLOW_41_in_inlineRight840); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_41.add(char_literal31);

                    pushFollow(FOLLOW_inline_in_inlineRight842);
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
                    // 61:52: -> ^( Fn ( left )+ inline )
                    {
                        // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:61:55: ^( Fn ( left )+ inline )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Fn, "Fn"), root_1);

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
                case 2 :
                    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:62:7: 'let' '(' ( assign )* ')' inline[true]
                    {
                    string_literal33=(Token)match(input,48,FOLLOW_48_in_inlineRight875); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_48.add(string_literal33);

                    char_literal34=(Token)match(input,40,FOLLOW_40_in_inlineRight877); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(char_literal34);

                    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:62:17: ( assign )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==Symbol||(LA13_0>=Natural && LA13_0<=String)||LA13_0==40||LA13_0==42||LA13_0==44||LA13_0==46) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:62:17: assign
                    	    {
                    	    pushFollow(FOLLOW_assign_in_inlineRight879);
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

                    char_literal36=(Token)match(input,41,FOLLOW_41_in_inlineRight882); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_41.add(char_literal36);

                    pushFollow(FOLLOW_inline_in_inlineRight884);
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
                    // 62:52: -> ^( Let ( assign )+ inline )
                    {
                        // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:62:55: ^( Let ( assign )+ inline )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Let, "Let"), root_1);

                        if ( !(stream_assign.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
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
                    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:63:7: 'loop' '(' ( assign )* ')' inline[true]
                    {
                    string_literal38=(Token)match(input,49,FOLLOW_49_in_inlineRight914); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_49.add(string_literal38);

                    char_literal39=(Token)match(input,40,FOLLOW_40_in_inlineRight916); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(char_literal39);

                    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:63:18: ( assign )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==Symbol||(LA14_0>=Natural && LA14_0<=String)||LA14_0==40||LA14_0==42||LA14_0==44||LA14_0==46) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:63:18: assign
                    	    {
                    	    pushFollow(FOLLOW_assign_in_inlineRight918);
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

                    char_literal41=(Token)match(input,41,FOLLOW_41_in_inlineRight921); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_41.add(char_literal41);

                    pushFollow(FOLLOW_inline_in_inlineRight923);
                    inline42=inline(true);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_inline.add(inline42.getTree());


                    // AST REWRITE
                    // elements: assign, inline
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 63:52: -> ^( Loop ( assign )+ inline )
                    {
                        // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:63:55: ^( Loop ( assign )+ inline )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Loop, "Loop"), root_1);

                        if ( !(stream_assign.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
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
                    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:64:7: 'if' expr expr ( 'else' )? inline[true]
                    {
                    string_literal43=(Token)match(input,50,FOLLOW_50_in_inlineRight952); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_50.add(string_literal43);

                    pushFollow(FOLLOW_expr_in_inlineRight954);
                    expr44=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr44.getTree());
                    pushFollow(FOLLOW_expr_in_inlineRight956);
                    expr45=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr45.getTree());
                    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:64:22: ( 'else' )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==51) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:64:22: 'else'
                            {
                            string_literal46=(Token)match(input,51,FOLLOW_51_in_inlineRight958); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_51.add(string_literal46);


                            }
                            break;

                    }

                    pushFollow(FOLLOW_inline_in_inlineRight961);
                    inline47=inline(true);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_inline.add(inline47.getTree());


                    // AST REWRITE
                    // elements: expr, inline
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 64:52: -> ^( If ( expr )+ ( inline )? )
                    {
                        // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:64:55: ^( If ( expr )+ ( inline )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(If, "If"), root_1);

                        if ( !(stream_expr.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_expr.hasNext() ) {
                            adaptor.addChild(root_1, stream_expr.nextTree());

                        }
                        stream_expr.reset();
                        // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:64:66: ( inline )?
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
                case 5 :
                    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:65:7: 'match' v= expr '(' (l+= left r+= expr )* ')'
                    {
                    string_literal48=(Token)match(input,52,FOLLOW_52_in_inlineRight991); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_52.add(string_literal48);

                    pushFollow(FOLLOW_expr_in_inlineRight995);
                    v=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(v.getTree());
                    char_literal49=(Token)match(input,40,FOLLOW_40_in_inlineRight997); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(char_literal49);

                    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:65:26: (l+= left r+= expr )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==Symbol||(LA16_0>=Natural && LA16_0<=String)||LA16_0==40||LA16_0==42||LA16_0==44||LA16_0==46) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:65:27: l+= left r+= expr
                    	    {
                    	    pushFollow(FOLLOW_left_in_inlineRight1002);
                    	    l=left();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_left.add(l.getTree());
                    	    if (list_l==null) list_l=new ArrayList();
                    	    list_l.add(l.getTree());

                    	    pushFollow(FOLLOW_expr_in_inlineRight1006);
                    	    r=expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_expr.add(r.getTree());
                    	    if (list_r==null) list_r=new ArrayList();
                    	    list_r.add(r.getTree());


                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);

                    char_literal50=(Token)match(input,41,FOLLOW_41_in_inlineRight1010); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_41.add(char_literal50);



                    // AST REWRITE
                    // elements: l, v, r
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
                    // 65:52: -> ^( Match $v ( ^( $l $r) )* )
                    {
                        // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:65:55: ^( Match $v ( ^( $l $r) )* )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Match, "Match"), root_1);

                        adaptor.addChild(root_1, stream_v.nextTree());
                        // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:65:66: ( ^( $l $r) )*
                        while ( stream_l.hasNext()||stream_r.hasNext() ) {
                            // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:65:66: ^( $l $r)
                            {
                            Object root_2 = (Object)adaptor.nil();
                            root_2 = (Object)adaptor.becomeRoot(stream_l.nextNode(), root_2);

                            adaptor.addChild(root_2, stream_r.nextTree());

                            adaptor.addChild(root_1, root_2);
                            }

                        }
                        stream_l.reset();
                        stream_r.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 6 :
                    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:66:7: recur
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_recur_in_inlineRight1039);
                    recur51=recur();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, recur51.getTree());

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
    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:69:1: assign : left '=' expr -> ^( Assign left expr ) ;
    public final VitryParser.assign_return assign() throws RecognitionException {
        VitryParser.assign_return retval = new VitryParser.assign_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal53=null;
        VitryParser.left_return left52 = null;

        VitryParser.expr_return expr54 = null;


        Object char_literal53_tree=null;
        RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
        RewriteRuleSubtreeStream stream_left=new RewriteRuleSubtreeStream(adaptor,"rule left");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:70:5: ( left '=' expr -> ^( Assign left expr ) )
            // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:70:7: left '=' expr
            {
            pushFollow(FOLLOW_left_in_assign1056);
            left52=left();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_left.add(left52.getTree());
            char_literal53=(Token)match(input,53,FOLLOW_53_in_assign1058); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_53.add(char_literal53);

            pushFollow(FOLLOW_expr_in_assign1060);
            expr54=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expr.add(expr54.getTree());


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
            // 70:52: -> ^( Assign left expr )
            {
                // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:70:55: ^( Assign left expr )
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
    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:73:1: apply : ( ( expr expr )=> ( expr )+ -> ^( Apply ( expr )+ ) | expr );
    public final VitryParser.apply_return apply() throws RecognitionException {
        VitryParser.apply_return retval = new VitryParser.apply_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        VitryParser.expr_return expr55 = null;

        VitryParser.expr_return expr56 = null;


        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:74:5: ( ( expr expr )=> ( expr )+ -> ^( Apply ( expr )+ ) | expr )
            int alt19=2;
            switch ( input.LA(1) ) {
            case 40:
                {
                int LA19_1 = input.LA(2);

                if ( (synpred4_Vitry()) ) {
                    alt19=1;
                }
                else if ( (true) ) {
                    alt19=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 19, 1, input);

                    throw nvae;
                }
                }
                break;
            case 42:
                {
                int LA19_2 = input.LA(2);

                if ( (synpred4_Vitry()) ) {
                    alt19=1;
                }
                else if ( (true) ) {
                    alt19=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 19, 2, input);

                    throw nvae;
                }
                }
                break;
            case 44:
                {
                int LA19_3 = input.LA(2);

                if ( (synpred4_Vitry()) ) {
                    alt19=1;
                }
                else if ( (true) ) {
                    alt19=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 19, 3, input);

                    throw nvae;
                }
                }
                break;
            case 46:
                {
                int LA19_4 = input.LA(2);

                if ( (synpred4_Vitry()) ) {
                    alt19=1;
                }
                else if ( (true) ) {
                    alt19=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 19, 4, input);

                    throw nvae;
                }
                }
                break;
            case Natural:
            case Float:
            case Complex:
            case String:
                {
                int LA19_5 = input.LA(2);

                if ( (synpred4_Vitry()) ) {
                    alt19=1;
                }
                else if ( (true) ) {
                    alt19=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 19, 5, input);

                    throw nvae;
                }
                }
                break;
            case Symbol:
                {
                int LA19_6 = input.LA(2);

                if ( (synpred4_Vitry()) ) {
                    alt19=1;
                }
                else if ( (true) ) {
                    alt19=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 19, 6, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:74:7: ( expr expr )=> ( expr )+
                    {
                    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:74:22: ( expr )+
                    int cnt18=0;
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==Symbol||(LA18_0>=Natural && LA18_0<=String)||LA18_0==40||LA18_0==42||LA18_0==44||LA18_0==46) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:74:22: expr
                    	    {
                    	    pushFollow(FOLLOW_expr_in_apply1126);
                    	    expr55=expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_expr.add(expr55.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt18 >= 1 ) break loop18;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(18, input);
                                throw eee;
                        }
                        cnt18++;
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
                    // 74:52: -> ^( Apply ( expr )+ )
                    {
                        // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:74:55: ^( Apply ( expr )+ )
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
                    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:75:7: expr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_expr_in_apply1168);
                    expr56=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr56.getTree());

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

    public static class recur_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "recur"
    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:78:1: recur : ( ( 'recur' expr expr )=> 'recur' ( expr )+ -> ^( Recur ( expr )+ ) | 'recur' expr -> ^( Recur expr ) );
    public final VitryParser.recur_return recur() throws RecognitionException {
        VitryParser.recur_return retval = new VitryParser.recur_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal57=null;
        Token string_literal59=null;
        VitryParser.expr_return expr58 = null;

        VitryParser.expr_return expr60 = null;


        Object string_literal57_tree=null;
        Object string_literal59_tree=null;
        RewriteRuleTokenStream stream_54=new RewriteRuleTokenStream(adaptor,"token 54");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:79:5: ( ( 'recur' expr expr )=> 'recur' ( expr )+ -> ^( Recur ( expr )+ ) | 'recur' expr -> ^( Recur expr ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==54) ) {
                int LA21_1 = input.LA(2);

                if ( (synpred5_Vitry()) ) {
                    alt21=1;
                }
                else if ( (true) ) {
                    alt21=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 21, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:79:7: ( 'recur' expr expr )=> 'recur' ( expr )+
                    {
                    string_literal57=(Token)match(input,54,FOLLOW_54_in_recur1199); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_54.add(string_literal57);

                    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:79:38: ( expr )+
                    int cnt20=0;
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==Symbol||(LA20_0>=Natural && LA20_0<=String)||LA20_0==40||LA20_0==42||LA20_0==44||LA20_0==46) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:79:38: expr
                    	    {
                    	    pushFollow(FOLLOW_expr_in_recur1201);
                    	    expr58=expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_expr.add(expr58.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt20 >= 1 ) break loop20;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(20, input);
                                throw eee;
                        }
                        cnt20++;
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
                    // 79:52: -> ^( Recur ( expr )+ )
                    {
                        // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:79:55: ^( Recur ( expr )+ )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Recur, "Recur"), root_1);

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
                    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:80:7: 'recur' expr
                    {
                    string_literal59=(Token)match(input,54,FOLLOW_54_in_recur1227); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_54.add(string_literal59);

                    pushFollow(FOLLOW_expr_in_recur1229);
                    expr60=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr60.getTree());


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
                    // 80:52: -> ^( Recur expr )
                    {
                        // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:80:55: ^( Recur expr )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Recur, "Recur"), root_1);

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
    // $ANTLR end "recur"

    public static class module_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "module"
    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:83:1: module : 'module' moduleName ( '(' (exports+= Symbol )* ')' )? ( 'import' (imports+= moduleName )* )* ( '(' declarations+= moduleDecl ')' )* -> ^( Module moduleName ( ^( $exports) )* ( ^( $imports) )* ( ^( $declarations) )* ) ;
    public final VitryParser.module_return module() throws RecognitionException {
        VitryParser.module_return retval = new VitryParser.module_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal61=null;
        Token char_literal63=null;
        Token char_literal64=null;
        Token string_literal65=null;
        Token char_literal66=null;
        Token char_literal67=null;
        Token exports=null;
        List list_exports=null;
        List list_imports=null;
        List list_declarations=null;
        VitryParser.moduleName_return moduleName62 = null;

        RuleReturnScope imports = null;
        RuleReturnScope declarations = null;
        Object string_literal61_tree=null;
        Object char_literal63_tree=null;
        Object char_literal64_tree=null;
        Object string_literal65_tree=null;
        Object char_literal66_tree=null;
        Object char_literal67_tree=null;
        Object exports_tree=null;
        RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
        RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
        RewriteRuleTokenStream stream_Symbol=new RewriteRuleTokenStream(adaptor,"token Symbol");
        RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
        RewriteRuleTokenStream stream_55=new RewriteRuleTokenStream(adaptor,"token 55");
        RewriteRuleSubtreeStream stream_moduleName=new RewriteRuleSubtreeStream(adaptor,"rule moduleName");
        RewriteRuleSubtreeStream stream_moduleDecl=new RewriteRuleSubtreeStream(adaptor,"rule moduleDecl");
        try {
            // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:84:5: ( 'module' moduleName ( '(' (exports+= Symbol )* ')' )? ( 'import' (imports+= moduleName )* )* ( '(' declarations+= moduleDecl ')' )* -> ^( Module moduleName ( ^( $exports) )* ( ^( $imports) )* ( ^( $declarations) )* ) )
            // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:84:7: 'module' moduleName ( '(' (exports+= Symbol )* ')' )? ( 'import' (imports+= moduleName )* )* ( '(' declarations+= moduleDecl ')' )*
            {
            string_literal61=(Token)match(input,55,FOLLOW_55_in_module1291); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_55.add(string_literal61);

            pushFollow(FOLLOW_moduleName_in_module1293);
            moduleName62=moduleName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_moduleName.add(moduleName62.getTree());
            // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:84:27: ( '(' (exports+= Symbol )* ')' )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==40) ) {
                int LA23_1 = input.LA(2);

                if ( (LA23_1==Symbol) ) {
                    int LA23_3 = input.LA(3);

                    if ( (LA23_3==Symbol||LA23_3==41) ) {
                        alt23=1;
                    }
                }
                else if ( (LA23_1==41) ) {
                    alt23=1;
                }
            }
            switch (alt23) {
                case 1 :
                    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:84:28: '(' (exports+= Symbol )* ')'
                    {
                    char_literal63=(Token)match(input,40,FOLLOW_40_in_module1296); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(char_literal63);

                    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:84:39: (exports+= Symbol )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==Symbol) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:84:39: exports+= Symbol
                    	    {
                    	    exports=(Token)match(input,Symbol,FOLLOW_Symbol_in_module1300); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_Symbol.add(exports);

                    	    if (list_exports==null) list_exports=new ArrayList();
                    	    list_exports.add(exports);


                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);

                    char_literal64=(Token)match(input,41,FOLLOW_41_in_module1303); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_41.add(char_literal64);


                    }
                    break;

            }

            // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:85:7: ( 'import' (imports+= moduleName )* )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==56) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:85:8: 'import' (imports+= moduleName )*
            	    {
            	    string_literal65=(Token)match(input,56,FOLLOW_56_in_module1314); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_56.add(string_literal65);

            	    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:85:24: (imports+= moduleName )*
            	    loop24:
            	    do {
            	        int alt24=2;
            	        int LA24_0 = input.LA(1);

            	        if ( (LA24_0==Symbol) ) {
            	            alt24=1;
            	        }


            	        switch (alt24) {
            	    	case 1 :
            	    	    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:85:24: imports+= moduleName
            	    	    {
            	    	    pushFollow(FOLLOW_moduleName_in_module1318);
            	    	    imports=moduleName();

            	    	    state._fsp--;
            	    	    if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) stream_moduleName.add(imports.getTree());
            	    	    if (list_imports==null) list_imports=new ArrayList();
            	    	    list_imports.add(imports.getTree());


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop24;
            	        }
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:86:7: ( '(' declarations+= moduleDecl ')' )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==40) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:86:9: '(' declarations+= moduleDecl ')'
            	    {
            	    char_literal66=(Token)match(input,40,FOLLOW_40_in_module1331); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_40.add(char_literal66);

            	    pushFollow(FOLLOW_moduleDecl_in_module1335);
            	    declarations=moduleDecl();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_moduleDecl.add(declarations.getTree());
            	    if (list_declarations==null) list_declarations=new ArrayList();
            	    list_declarations.add(declarations.getTree());

            	    char_literal67=(Token)match(input,41,FOLLOW_41_in_module1337); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_41.add(char_literal67);


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);



            // AST REWRITE
            // elements: imports, declarations, moduleName, exports
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
            // 87:5: -> ^( Module moduleName ( ^( $exports) )* ( ^( $imports) )* ( ^( $declarations) )* )
            {
                // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:87:8: ^( Module moduleName ( ^( $exports) )* ( ^( $imports) )* ( ^( $declarations) )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Module, "Module"), root_1);

                adaptor.addChild(root_1, stream_moduleName.nextTree());
                // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:87:28: ( ^( $exports) )*
                while ( stream_exports.hasNext() ) {
                    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:87:28: ^( $exports)
                    {
                    Object root_2 = (Object)adaptor.nil();
                    root_2 = (Object)adaptor.becomeRoot(stream_exports.nextNode(), root_2);

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_exports.reset();
                // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:87:41: ( ^( $imports) )*
                while ( stream_imports.hasNext() ) {
                    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:87:41: ^( $imports)
                    {
                    Object root_2 = (Object)adaptor.nil();
                    root_2 = (Object)adaptor.becomeRoot(stream_imports.nextNode(), root_2);

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_imports.reset();
                // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:87:54: ( ^( $declarations) )*
                while ( stream_declarations.hasNext() ) {
                    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:87:54: ^( $declarations)
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
    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:90:1: moduleDecl : ( 'type' '(' ( assign )* ')' -> ^( TypeDecl ( assign )* ) | 'impicit' '(' ( expr '->' expr )* ')' -> ^( ImplicitDecl ( ^( expr expr ) )* ) | 'fn' Symbol '(' ( left )* ')' '=' inline[true] -> ^( FnDecl Symbol ( left )+ inline ) | left '=' expr -> ^( MemberDecl left expr ) );
    public final VitryParser.moduleDecl_return moduleDecl() throws RecognitionException {
        VitryParser.moduleDecl_return retval = new VitryParser.moduleDecl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal68=null;
        Token char_literal69=null;
        Token char_literal71=null;
        Token string_literal72=null;
        Token char_literal73=null;
        Token string_literal75=null;
        Token char_literal77=null;
        Token string_literal78=null;
        Token Symbol79=null;
        Token char_literal80=null;
        Token char_literal82=null;
        Token char_literal83=null;
        Token char_literal86=null;
        VitryParser.assign_return assign70 = null;

        VitryParser.expr_return expr74 = null;

        VitryParser.expr_return expr76 = null;

        VitryParser.left_return left81 = null;

        VitryParser.inline_return inline84 = null;

        VitryParser.left_return left85 = null;

        VitryParser.expr_return expr87 = null;


        Object string_literal68_tree=null;
        Object char_literal69_tree=null;
        Object char_literal71_tree=null;
        Object string_literal72_tree=null;
        Object char_literal73_tree=null;
        Object string_literal75_tree=null;
        Object char_literal77_tree=null;
        Object string_literal78_tree=null;
        Object Symbol79_tree=null;
        Object char_literal80_tree=null;
        Object char_literal82_tree=null;
        Object char_literal83_tree=null;
        Object char_literal86_tree=null;
        RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
        RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
        RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
        RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
        RewriteRuleTokenStream stream_Symbol=new RewriteRuleTokenStream(adaptor,"token Symbol");
        RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
        RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
        RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
        RewriteRuleSubtreeStream stream_assign=new RewriteRuleSubtreeStream(adaptor,"rule assign");
        RewriteRuleSubtreeStream stream_inline=new RewriteRuleSubtreeStream(adaptor,"rule inline");
        RewriteRuleSubtreeStream stream_left=new RewriteRuleSubtreeStream(adaptor,"rule left");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:91:5: ( 'type' '(' ( assign )* ')' -> ^( TypeDecl ( assign )* ) | 'impicit' '(' ( expr '->' expr )* ')' -> ^( ImplicitDecl ( ^( expr expr ) )* ) | 'fn' Symbol '(' ( left )* ')' '=' inline[true] -> ^( FnDecl Symbol ( left )+ inline ) | left '=' expr -> ^( MemberDecl left expr ) )
            int alt30=4;
            switch ( input.LA(1) ) {
            case 57:
                {
                alt30=1;
                }
                break;
            case 58:
                {
                alt30=2;
                }
                break;
            case 47:
                {
                alt30=3;
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
                alt30=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:91:7: 'type' '(' ( assign )* ')'
                    {
                    string_literal68=(Token)match(input,57,FOLLOW_57_in_moduleDecl1391); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_57.add(string_literal68);

                    char_literal69=(Token)match(input,40,FOLLOW_40_in_moduleDecl1398); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(char_literal69);

                    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:91:23: ( assign )*
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==Symbol||(LA27_0>=Natural && LA27_0<=String)||LA27_0==40||LA27_0==42||LA27_0==44||LA27_0==46) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:91:23: assign
                    	    {
                    	    pushFollow(FOLLOW_assign_in_moduleDecl1400);
                    	    assign70=assign();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_assign.add(assign70.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop27;
                        }
                    } while (true);

                    char_literal71=(Token)match(input,41,FOLLOW_41_in_moduleDecl1403); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_41.add(char_literal71);



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
                    // 91:50: -> ^( TypeDecl ( assign )* )
                    {
                        // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:91:53: ^( TypeDecl ( assign )* )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TypeDecl, "TypeDecl"), root_1);

                        // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:91:64: ( assign )*
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
                    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:92:7: 'impicit' '(' ( expr '->' expr )* ')'
                    {
                    string_literal72=(Token)match(input,58,FOLLOW_58_in_moduleDecl1435); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_58.add(string_literal72);

                    char_literal73=(Token)match(input,40,FOLLOW_40_in_moduleDecl1439); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(char_literal73);

                    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:92:23: ( expr '->' expr )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==Symbol||(LA28_0>=Natural && LA28_0<=String)||LA28_0==40||LA28_0==42||LA28_0==44||LA28_0==46) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:92:24: expr '->' expr
                    	    {
                    	    pushFollow(FOLLOW_expr_in_moduleDecl1442);
                    	    expr74=expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_expr.add(expr74.getTree());
                    	    string_literal75=(Token)match(input,59,FOLLOW_59_in_moduleDecl1444); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_59.add(string_literal75);

                    	    pushFollow(FOLLOW_expr_in_moduleDecl1446);
                    	    expr76=expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_expr.add(expr76.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop28;
                        }
                    } while (true);

                    char_literal77=(Token)match(input,41,FOLLOW_41_in_moduleDecl1450); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_41.add(char_literal77);



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
                    // 92:50: -> ^( ImplicitDecl ( ^( expr expr ) )* )
                    {
                        // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:92:53: ^( ImplicitDecl ( ^( expr expr ) )* )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ImplicitDecl, "ImplicitDecl"), root_1);

                        // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:92:68: ( ^( expr expr ) )*
                        while ( stream_expr.hasNext()||stream_expr.hasNext() ) {
                            // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:92:68: ^( expr expr )
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
                    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:93:7: 'fn' Symbol '(' ( left )* ')' '=' inline[true]
                    {
                    string_literal78=(Token)match(input,47,FOLLOW_47_in_moduleDecl1476); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_47.add(string_literal78);

                    Symbol79=(Token)match(input,Symbol,FOLLOW_Symbol_in_moduleDecl1478); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_Symbol.add(Symbol79);

                    char_literal80=(Token)match(input,40,FOLLOW_40_in_moduleDecl1480); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(char_literal80);

                    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:93:23: ( left )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==Symbol||(LA29_0>=Natural && LA29_0<=String)||LA29_0==40||LA29_0==42||LA29_0==44||LA29_0==46) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:93:23: left
                    	    {
                    	    pushFollow(FOLLOW_left_in_moduleDecl1482);
                    	    left81=left();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_left.add(left81.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop29;
                        }
                    } while (true);

                    char_literal82=(Token)match(input,41,FOLLOW_41_in_moduleDecl1485); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_41.add(char_literal82);

                    char_literal83=(Token)match(input,53,FOLLOW_53_in_moduleDecl1487); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_53.add(char_literal83);

                    pushFollow(FOLLOW_inline_in_moduleDecl1489);
                    inline84=inline(true);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_inline.add(inline84.getTree());


                    // AST REWRITE
                    // elements: inline, left, Symbol
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 93:50: -> ^( FnDecl Symbol ( left )+ inline )
                    {
                        // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:93:53: ^( FnDecl Symbol ( left )+ inline )
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
                    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:94:7: left '=' expr
                    {
                    pushFollow(FOLLOW_left_in_moduleDecl1511);
                    left85=left();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_left.add(left85.getTree());
                    char_literal86=(Token)match(input,53,FOLLOW_53_in_moduleDecl1513); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_53.add(char_literal86);

                    pushFollow(FOLLOW_expr_in_moduleDecl1515);
                    expr87=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr87.getTree());


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
                    // 94:50: -> ^( MemberDecl left expr )
                    {
                        // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:94:53: ^( MemberDecl left expr )
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
    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:97:1: moduleName : Symbol ( '.' Symbol )* -> ^( Symbol ( Symbol )+ ) ;
    public final VitryParser.moduleName_return moduleName() throws RecognitionException {
        VitryParser.moduleName_return retval = new VitryParser.moduleName_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Symbol88=null;
        Token char_literal89=null;
        Token Symbol90=null;

        Object Symbol88_tree=null;
        Object char_literal89_tree=null;
        Object Symbol90_tree=null;
        RewriteRuleTokenStream stream_Symbol=new RewriteRuleTokenStream(adaptor,"token Symbol");
        RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");

        try {
            // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:97:12: ( Symbol ( '.' Symbol )* -> ^( Symbol ( Symbol )+ ) )
            // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:98:5: Symbol ( '.' Symbol )*
            {
            Symbol88=(Token)match(input,Symbol,FOLLOW_Symbol_in_moduleName1575); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_Symbol.add(Symbol88);

            // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:98:12: ( '.' Symbol )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==60) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:98:13: '.' Symbol
            	    {
            	    char_literal89=(Token)match(input,60,FOLLOW_60_in_moduleName1578); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_60.add(char_literal89);

            	    Symbol90=(Token)match(input,Symbol,FOLLOW_Symbol_in_moduleName1580); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_Symbol.add(Symbol90);


            	    }
            	    break;

            	default :
            	    break loop31;
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
            // 98:26: -> ^( Symbol ( Symbol )+ )
            {
                // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:98:29: ^( Symbol ( Symbol )+ )
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
        // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:28:7: ( delim[true] ':' )
        // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:28:8: delim[true] ':'
        {
        pushFollow(FOLLOW_delim_in_synpred1_Vitry184);
        delim(true);

        state._fsp--;
        if (state.failed) return ;
        match(input,39,FOLLOW_39_in_synpred1_Vitry187); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_Vitry

    // $ANTLR start synpred2_Vitry
    public final void synpred2_Vitry_fragment() throws RecognitionException {   
        // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:33:7: ( delim[false] ':' )
        // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:33:8: delim[false] ':'
        {
        pushFollow(FOLLOW_delim_in_synpred2_Vitry245);
        delim(false);

        state._fsp--;
        if (state.failed) return ;
        match(input,39,FOLLOW_39_in_synpred2_Vitry248); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_Vitry

    // $ANTLR start synpred3_Vitry
    public final void synpred3_Vitry_fragment() throws RecognitionException {   
        // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:49:7: ( apply Op )
        // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:49:8: apply Op
        {
        pushFollow(FOLLOW_apply_in_synpred3_Vitry692);
        apply();

        state._fsp--;
        if (state.failed) return ;
        match(input,Op,FOLLOW_Op_in_synpred3_Vitry694); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_Vitry

    // $ANTLR start synpred4_Vitry
    public final void synpred4_Vitry_fragment() throws RecognitionException {   
        // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:74:7: ( expr expr )
        // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:74:8: expr expr
        {
        pushFollow(FOLLOW_expr_in_synpred4_Vitry1119);
        expr();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_expr_in_synpred4_Vitry1121);
        expr();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_Vitry

    // $ANTLR start synpred5_Vitry
    public final void synpred5_Vitry_fragment() throws RecognitionException {   
        // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:79:7: ( 'recur' expr expr )
        // /Users/hans/Documents/Kod/antlr/Vitry/Vitry.g:79:8: 'recur' expr expr
        {
        match(input,54,FOLLOW_54_in_synpred5_Vitry1190); if (state.failed) return ;
        pushFollow(FOLLOW_expr_in_synpred5_Vitry1192);
        expr();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_expr_in_synpred5_Vitry1194);
        expr();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred5_Vitry

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
    public final boolean synpred5_Vitry() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_Vitry_fragment(); // can never throw exception
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
        "\20\uffff";
    static final String DFA11_eofS =
        "\20\uffff";
    static final String DFA11_minS =
        "\1\33\7\uffff\6\0\2\uffff";
    static final String DFA11_maxS =
        "\1\66\7\uffff\6\0\2\uffff";
    static final String DFA11_acceptS =
        "\1\uffff\1\1\5\uffff\1\2\6\uffff\1\3\1\4";
    static final String DFA11_specialS =
        "\10\uffff\1\0\1\1\1\2\1\3\1\4\1\5\2\uffff}>";
    static final String[] DFA11_transitionS = {
            "\1\15\1\7\4\14\7\uffff\1\10\1\uffff\1\11\1\uffff\1\12\1\uffff"+
            "\1\13\4\1\1\uffff\1\1\1\uffff\1\1",
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
            return "46:1: inline[boolean rs] : ({...}? inlineRight | ( Op ( apply )? )+ -> ^( Ops ( ^( Op ( apply )? ) )+ ) | ( apply Op )=>e+= apply ( Op (f+= apply )? )+ -> ^( Ops $e ( ^( Op $f) )+ ) | apply );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA11_8 = input.LA(1);

                         
                        int index11_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_Vitry()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index11_8);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA11_9 = input.LA(1);

                         
                        int index11_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_Vitry()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index11_9);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA11_10 = input.LA(1);

                         
                        int index11_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_Vitry()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index11_10);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA11_11 = input.LA(1);

                         
                        int index11_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_Vitry()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index11_11);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA11_12 = input.LA(1);

                         
                        int index11_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_Vitry()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index11_12);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA11_13 = input.LA(1);

                         
                        int index11_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_Vitry()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index11_13);
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
 

    public static final BitSet FOLLOW_delim_in_expr192 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_expr195 = new BitSet(new long[]{0x00005501E8000000L});
    public static final BitSet FOLLOW_expr_in_expr197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_delim_in_expr218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_delim_in_left253 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_left256 = new BitSet(new long[]{0x00005501E8000000L});
    public static final BitSet FOLLOW_expr_in_left258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_delim_in_left281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_delim341 = new BitSet(new long[]{0x0057D701F8000000L});
    public static final BitSet FOLLOW_inline_in_delim343 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_delim347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_delim389 = new BitSet(new long[]{0x0057DD01F8000000L});
    public static final BitSet FOLLOW_inline_in_delim391 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_delim395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_delim437 = new BitSet(new long[]{0x0057F501F8000000L});
    public static final BitSet FOLLOW_inline_in_delim439 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_delim443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_delim485 = new BitSet(new long[]{0x00005501E8000000L});
    public static final BitSet FOLLOW_delim_in_delim487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_delim537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Symbol_in_delim598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inlineRight_in_inline623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Op_in_inline632 = new BitSet(new long[]{0x00005501F8000002L});
    public static final BitSet FOLLOW_apply_in_inline634 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_apply_in_inline701 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_Op_in_inline704 = new BitSet(new long[]{0x00005501F8000002L});
    public static final BitSet FOLLOW_apply_in_inline708 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_apply_in_inline743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_atom0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_inlineRight833 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_inlineRight835 = new BitSet(new long[]{0x00005701E8000000L});
    public static final BitSet FOLLOW_left_in_inlineRight837 = new BitSet(new long[]{0x00005701E8000000L});
    public static final BitSet FOLLOW_41_in_inlineRight840 = new BitSet(new long[]{0x0057D501F8000000L});
    public static final BitSet FOLLOW_inline_in_inlineRight842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_inlineRight875 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_inlineRight877 = new BitSet(new long[]{0x00005701E8000000L});
    public static final BitSet FOLLOW_assign_in_inlineRight879 = new BitSet(new long[]{0x00005701E8000000L});
    public static final BitSet FOLLOW_41_in_inlineRight882 = new BitSet(new long[]{0x0057D501F8000000L});
    public static final BitSet FOLLOW_inline_in_inlineRight884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_inlineRight914 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_inlineRight916 = new BitSet(new long[]{0x00005701E8000000L});
    public static final BitSet FOLLOW_assign_in_inlineRight918 = new BitSet(new long[]{0x00005701E8000000L});
    public static final BitSet FOLLOW_41_in_inlineRight921 = new BitSet(new long[]{0x0057D501F8000000L});
    public static final BitSet FOLLOW_inline_in_inlineRight923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_inlineRight952 = new BitSet(new long[]{0x00005501E8000000L});
    public static final BitSet FOLLOW_expr_in_inlineRight954 = new BitSet(new long[]{0x00005501E8000000L});
    public static final BitSet FOLLOW_expr_in_inlineRight956 = new BitSet(new long[]{0x005FD501F8000000L});
    public static final BitSet FOLLOW_51_in_inlineRight958 = new BitSet(new long[]{0x0057D501F8000000L});
    public static final BitSet FOLLOW_inline_in_inlineRight961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_inlineRight991 = new BitSet(new long[]{0x00005501E8000000L});
    public static final BitSet FOLLOW_expr_in_inlineRight995 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_inlineRight997 = new BitSet(new long[]{0x00005701E8000000L});
    public static final BitSet FOLLOW_left_in_inlineRight1002 = new BitSet(new long[]{0x00005501E8000000L});
    public static final BitSet FOLLOW_expr_in_inlineRight1006 = new BitSet(new long[]{0x00005701E8000000L});
    public static final BitSet FOLLOW_41_in_inlineRight1010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_recur_in_inlineRight1039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_left_in_assign1056 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_assign1058 = new BitSet(new long[]{0x00005501E8000000L});
    public static final BitSet FOLLOW_expr_in_assign1060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_apply1126 = new BitSet(new long[]{0x00005501E8000002L});
    public static final BitSet FOLLOW_expr_in_apply1168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_recur1199 = new BitSet(new long[]{0x00005501E8000000L});
    public static final BitSet FOLLOW_expr_in_recur1201 = new BitSet(new long[]{0x00005501E8000002L});
    public static final BitSet FOLLOW_54_in_recur1227 = new BitSet(new long[]{0x00005501E8000000L});
    public static final BitSet FOLLOW_expr_in_recur1229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_module1291 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_moduleName_in_module1293 = new BitSet(new long[]{0x0100010000000002L});
    public static final BitSet FOLLOW_40_in_module1296 = new BitSet(new long[]{0x0000020008000000L});
    public static final BitSet FOLLOW_Symbol_in_module1300 = new BitSet(new long[]{0x0000020008000000L});
    public static final BitSet FOLLOW_41_in_module1303 = new BitSet(new long[]{0x0100010000000002L});
    public static final BitSet FOLLOW_56_in_module1314 = new BitSet(new long[]{0x0100010008000002L});
    public static final BitSet FOLLOW_moduleName_in_module1318 = new BitSet(new long[]{0x0100010008000002L});
    public static final BitSet FOLLOW_40_in_module1331 = new BitSet(new long[]{0x0600D501E8000000L});
    public static final BitSet FOLLOW_moduleDecl_in_module1335 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_module1337 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_57_in_moduleDecl1391 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_moduleDecl1398 = new BitSet(new long[]{0x00005701E8000000L});
    public static final BitSet FOLLOW_assign_in_moduleDecl1400 = new BitSet(new long[]{0x00005701E8000000L});
    public static final BitSet FOLLOW_41_in_moduleDecl1403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_moduleDecl1435 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_moduleDecl1439 = new BitSet(new long[]{0x00005701E8000000L});
    public static final BitSet FOLLOW_expr_in_moduleDecl1442 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_59_in_moduleDecl1444 = new BitSet(new long[]{0x00005501E8000000L});
    public static final BitSet FOLLOW_expr_in_moduleDecl1446 = new BitSet(new long[]{0x00005701E8000000L});
    public static final BitSet FOLLOW_41_in_moduleDecl1450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_moduleDecl1476 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_Symbol_in_moduleDecl1478 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_moduleDecl1480 = new BitSet(new long[]{0x00005701E8000000L});
    public static final BitSet FOLLOW_left_in_moduleDecl1482 = new BitSet(new long[]{0x00005701E8000000L});
    public static final BitSet FOLLOW_41_in_moduleDecl1485 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_moduleDecl1487 = new BitSet(new long[]{0x0057D501F8000000L});
    public static final BitSet FOLLOW_inline_in_moduleDecl1489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_left_in_moduleDecl1511 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_moduleDecl1513 = new BitSet(new long[]{0x00005501E8000000L});
    public static final BitSet FOLLOW_expr_in_moduleDecl1515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Symbol_in_moduleName1575 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_60_in_moduleName1578 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_Symbol_in_moduleName1580 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_delim_in_synpred1_Vitry184 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_synpred1_Vitry187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_delim_in_synpred2_Vitry245 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_synpred2_Vitry248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_apply_in_synpred3_Vitry692 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_Op_in_synpred3_Vitry694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_synpred4_Vitry1119 = new BitSet(new long[]{0x00005501E8000000L});
    public static final BitSet FOLLOW_expr_in_synpred4_Vitry1121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_synpred5_Vitry1190 = new BitSet(new long[]{0x00005501E8000000L});
    public static final BitSet FOLLOW_expr_in_synpred5_Vitry1192 = new BitSet(new long[]{0x00005501E8000000L});
    public static final BitSet FOLLOW_expr_in_synpred5_Vitry1194 = new BitSet(new long[]{0x0000000000000002L});

}