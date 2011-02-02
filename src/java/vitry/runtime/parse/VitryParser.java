// $ANTLR 3.2 Sep 23, 2009 12:02:23 src/antlr/Vitry.g 2011-02-01 02:29:45
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Par", "Bra", "Ang", "Module", "Fn", "Let", "Where", "Assign", "Left", "Quote", "Apply", "Type", "If", "Match", "Loop", "Recur", "Do", "Ops", "TypeDecl", "ImplicitDecl", "FnDecl", "MemberDecl", "Op", "Symbol", "Natural", "Float", "Complex", "String", "Exponent", "Whitespace", "EscapeSeq", "HexDigit", "UnicodeEsc", "OctalEsc", "':'", "'('", "')'", "'['", "']'", "'{'", "'}'", "'`'", "'fn'", "'let'", "'loop'", "'do'", "'if'", "'else'", "'match'", "'recur'", "'='", "'module'", "'import'", "'type'", "'implicit'", "'.'"
    };
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
    public static final int T__51=51;
    public static final int Let=9;
    public static final int Assign=11;
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
    public static final int Op=26;
    public static final int String=31;
    public static final int Symbol=27;
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
    public static final int T__44=44;
    public static final int Type=15;
    public static final int T__45=45;
    public static final int Natural=28;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int Complex=30;
    public static final int Apply=14;
    public static final int ImplicitDecl=23;
    public static final int Float=29;
    public static final int EscapeSeq=34;
    public static final int Match=17;
    public static final int T__38=38;
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
    public String getGrammarFileName() { return "src/antlr/Vitry.g"; }


    // TODO override mismatch() and recoverFromMismatchSet()


    public static class expr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expr"
    // src/antlr/Vitry.g:35:1: expr : ( ( delim[true] ':' )=> delim[true] ':' expr -> ^( Type delim expr ) | delim[true] );
    public final VitryParser.expr_return expr() throws RecognitionException {
        VitryParser.expr_return retval = new VitryParser.expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal2=null;
        VitryParser.delim_return delim1 = null;

        VitryParser.expr_return expr3 = null;

        VitryParser.delim_return delim4 = null;


        Object char_literal2_tree=null;
        RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        RewriteRuleSubtreeStream stream_delim=new RewriteRuleSubtreeStream(adaptor,"rule delim");
        try {
            // src/antlr/Vitry.g:36:5: ( ( delim[true] ':' )=> delim[true] ':' expr -> ^( Type delim expr ) | delim[true] )
            int alt1=2;
            switch ( input.LA(1) ) {
            case 39:
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
            case 41:
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
            case 43:
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
            case 45:
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
            case Symbol:
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
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // src/antlr/Vitry.g:36:7: ( delim[true] ':' )=> delim[true] ':' expr
                    {
                    pushFollow(FOLLOW_delim_in_expr194);
                    delim1=delim(true);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_delim.add(delim1.getTree());
                    char_literal2=(Token)match(input,38,FOLLOW_38_in_expr197); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_38.add(char_literal2);

                    pushFollow(FOLLOW_expr_in_expr199);
                    expr3=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr3.getTree());


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
                    // 36:52: -> ^( Type delim expr )
                    {
                        // src/antlr/Vitry.g:36:55: ^( Type delim expr )
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
                    // src/antlr/Vitry.g:37:7: delim[true]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_delim_in_expr220);
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
    // src/antlr/Vitry.g:42:1: left : ( ( delim[false] ':' )=> delim[false] ':' expr -> ^( Left ^( Type delim expr ) ) | delim[false] -> ^( Left delim ) );
    public final VitryParser.left_return left() throws RecognitionException {
        VitryParser.left_return retval = new VitryParser.left_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal6=null;
        VitryParser.delim_return delim5 = null;

        VitryParser.expr_return expr7 = null;

        VitryParser.delim_return delim8 = null;


        Object char_literal6_tree=null;
        RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        RewriteRuleSubtreeStream stream_delim=new RewriteRuleSubtreeStream(adaptor,"rule delim");
        try {
            // src/antlr/Vitry.g:43:5: ( ( delim[false] ':' )=> delim[false] ':' expr -> ^( Left ^( Type delim expr ) ) | delim[false] -> ^( Left delim ) )
            int alt2=2;
            switch ( input.LA(1) ) {
            case 39:
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
            case 41:
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
            case 43:
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
            case 45:
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
            case Symbol:
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
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // src/antlr/Vitry.g:43:7: ( delim[false] ':' )=> delim[false] ':' expr
                    {
                    pushFollow(FOLLOW_delim_in_left253);
                    delim5=delim(false);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_delim.add(delim5.getTree());
                    char_literal6=(Token)match(input,38,FOLLOW_38_in_left256); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_38.add(char_literal6);

                    pushFollow(FOLLOW_expr_in_left258);
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
                        // src/antlr/Vitry.g:43:55: ^( Left ^( Type delim expr ) )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Left, "Left"), root_1);

                        // src/antlr/Vitry.g:43:62: ^( Type delim expr )
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
                    // src/antlr/Vitry.g:44:7: delim[false]
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
                    // 44:52: -> ^( Left delim )
                    {
                        // src/antlr/Vitry.g:44:55: ^( Left delim )
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
    // src/antlr/Vitry.g:48:1: delim[boolean rs] : ( '(' ( inline[rs] )? ')' -> ^( Par ( inline )? ) | '[' ( inline[rs] )? ']' -> ^( Bra ( inline )? ) | '{' ( inline[rs] )? '}' -> ^( Ang ( inline )? ) | '`' Op -> ^( Quote Op ) | '`' delim[rs] -> ^( Quote delim ) | atom );
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
        Token Op19=null;
        Token char_literal20=null;
        VitryParser.inline_return inline10 = null;

        VitryParser.inline_return inline13 = null;

        VitryParser.inline_return inline16 = null;

        VitryParser.delim_return delim21 = null;

        VitryParser.atom_return atom22 = null;


        Object char_literal9_tree=null;
        Object char_literal11_tree=null;
        Object char_literal12_tree=null;
        Object char_literal14_tree=null;
        Object char_literal15_tree=null;
        Object char_literal17_tree=null;
        Object char_literal18_tree=null;
        Object Op19_tree=null;
        Object char_literal20_tree=null;
        RewriteRuleTokenStream stream_45=new RewriteRuleTokenStream(adaptor,"token 45");
        RewriteRuleTokenStream stream_43=new RewriteRuleTokenStream(adaptor,"token 43");
        RewriteRuleTokenStream stream_Op=new RewriteRuleTokenStream(adaptor,"token Op");
        RewriteRuleTokenStream stream_44=new RewriteRuleTokenStream(adaptor,"token 44");
        RewriteRuleTokenStream stream_42=new RewriteRuleTokenStream(adaptor,"token 42");
        RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
        RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
        RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");
        RewriteRuleSubtreeStream stream_inline=new RewriteRuleSubtreeStream(adaptor,"rule inline");
        RewriteRuleSubtreeStream stream_delim=new RewriteRuleSubtreeStream(adaptor,"rule delim");
        try {
            // src/antlr/Vitry.g:49:5: ( '(' ( inline[rs] )? ')' -> ^( Par ( inline )? ) | '[' ( inline[rs] )? ']' -> ^( Bra ( inline )? ) | '{' ( inline[rs] )? '}' -> ^( Ang ( inline )? ) | '`' Op -> ^( Quote Op ) | '`' delim[rs] -> ^( Quote delim ) | atom )
            int alt6=6;
            switch ( input.LA(1) ) {
            case 39:
                {
                alt6=1;
                }
                break;
            case 41:
                {
                alt6=2;
                }
                break;
            case 43:
                {
                alt6=3;
                }
                break;
            case 45:
                {
                int LA6_4 = input.LA(2);

                if ( (LA6_4==Op) ) {
                    alt6=4;
                }
                else if ( ((LA6_4>=Symbol && LA6_4<=String)||LA6_4==39||LA6_4==41||LA6_4==43||LA6_4==45) ) {
                    alt6=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 4, input);

                    throw nvae;
                }
                }
                break;
            case Symbol:
            case Natural:
            case Float:
            case Complex:
            case String:
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
                    // src/antlr/Vitry.g:49:7: '(' ( inline[rs] )? ')'
                    {
                    char_literal9=(Token)match(input,39,FOLLOW_39_in_delim342); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_39.add(char_literal9);

                    // src/antlr/Vitry.g:49:11: ( inline[rs] )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( ((LA3_0>=Op && LA3_0<=String)||LA3_0==39||LA3_0==41||LA3_0==43||(LA3_0>=45 && LA3_0<=50)||(LA3_0>=52 && LA3_0<=53)) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // src/antlr/Vitry.g:49:11: inline[rs]
                            {
                            pushFollow(FOLLOW_inline_in_delim344);
                            inline10=inline(rs);

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_inline.add(inline10.getTree());

                            }
                            break;

                    }

                    char_literal11=(Token)match(input,40,FOLLOW_40_in_delim348); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(char_literal11);



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
                        // src/antlr/Vitry.g:49:55: ^( Par ( inline )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Par, "Par"), root_1);

                        // src/antlr/Vitry.g:49:61: ( inline )?
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
                    // src/antlr/Vitry.g:50:7: '[' ( inline[rs] )? ']'
                    {
                    char_literal12=(Token)match(input,41,FOLLOW_41_in_delim390); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_41.add(char_literal12);

                    // src/antlr/Vitry.g:50:11: ( inline[rs] )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( ((LA4_0>=Op && LA4_0<=String)||LA4_0==39||LA4_0==41||LA4_0==43||(LA4_0>=45 && LA4_0<=50)||(LA4_0>=52 && LA4_0<=53)) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // src/antlr/Vitry.g:50:11: inline[rs]
                            {
                            pushFollow(FOLLOW_inline_in_delim392);
                            inline13=inline(rs);

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_inline.add(inline13.getTree());

                            }
                            break;

                    }

                    char_literal14=(Token)match(input,42,FOLLOW_42_in_delim396); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_42.add(char_literal14);



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
                        // src/antlr/Vitry.g:50:55: ^( Bra ( inline )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Bra, "Bra"), root_1);

                        // src/antlr/Vitry.g:50:61: ( inline )?
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
                    // src/antlr/Vitry.g:51:7: '{' ( inline[rs] )? '}'
                    {
                    char_literal15=(Token)match(input,43,FOLLOW_43_in_delim438); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_43.add(char_literal15);

                    // src/antlr/Vitry.g:51:11: ( inline[rs] )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( ((LA5_0>=Op && LA5_0<=String)||LA5_0==39||LA5_0==41||LA5_0==43||(LA5_0>=45 && LA5_0<=50)||(LA5_0>=52 && LA5_0<=53)) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // src/antlr/Vitry.g:51:11: inline[rs]
                            {
                            pushFollow(FOLLOW_inline_in_delim440);
                            inline16=inline(rs);

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_inline.add(inline16.getTree());

                            }
                            break;

                    }

                    char_literal17=(Token)match(input,44,FOLLOW_44_in_delim444); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_44.add(char_literal17);



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
                        // src/antlr/Vitry.g:51:55: ^( Ang ( inline )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Ang, "Ang"), root_1);

                        // src/antlr/Vitry.g:51:61: ( inline )?
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
                    // src/antlr/Vitry.g:52:7: '`' Op
                    {
                    char_literal18=(Token)match(input,45,FOLLOW_45_in_delim486); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_45.add(char_literal18);

                    Op19=(Token)match(input,Op,FOLLOW_Op_in_delim488); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_Op.add(Op19);



                    // AST REWRITE
                    // elements: Op
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 52:52: -> ^( Quote Op )
                    {
                        // src/antlr/Vitry.g:52:55: ^( Quote Op )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Quote, "Quote"), root_1);

                        adaptor.addChild(root_1, stream_Op.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // src/antlr/Vitry.g:53:7: '`' delim[rs]
                    {
                    char_literal20=(Token)match(input,45,FOLLOW_45_in_delim542); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_45.add(char_literal20);

                    pushFollow(FOLLOW_delim_in_delim544);
                    delim21=delim(rs);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_delim.add(delim21.getTree());


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
                    // 53:52: -> ^( Quote delim )
                    {
                        // src/antlr/Vitry.g:53:55: ^( Quote delim )
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
                case 6 :
                    // src/antlr/Vitry.g:54:7: atom
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_atom_in_delim592);
                    atom22=atom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, atom22.getTree());

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
    // src/antlr/Vitry.g:57:1: atom : ( Symbol | Natural | Float | Complex | String );
    public final VitryParser.atom_return atom() throws RecognitionException {
        VitryParser.atom_return retval = new VitryParser.atom_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set23=null;

        Object set23_tree=null;

        try {
            // src/antlr/Vitry.g:58:5: ( Symbol | Natural | Float | Complex | String )
            // src/antlr/Vitry.g:
            {
            root_0 = (Object)adaptor.nil();

            set23=(Token)input.LT(1);
            if ( (input.LA(1)>=Symbol && input.LA(1)<=String) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set23));
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
    // src/antlr/Vitry.g:66:1: inline[boolean rs] : ({...}? inlineRight | ( Op ( apply )? )+ -> ^( Ops ( ^( Op ( apply )? ) )+ ) | ( apply Op )=>e+= apply ( Op (f+= apply )? )+ -> ^( Ops $e ( ^( Op $f) )+ ) | apply );
    public final VitryParser.inline_return inline(boolean rs) throws RecognitionException {
        VitryParser.inline_return retval = new VitryParser.inline_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Op25=null;
        Token Op27=null;
        List list_e=null;
        List list_f=null;
        VitryParser.inlineRight_return inlineRight24 = null;

        VitryParser.apply_return apply26 = null;

        VitryParser.apply_return apply28 = null;

        RuleReturnScope e = null;
        RuleReturnScope f = null;
        Object Op25_tree=null;
        Object Op27_tree=null;
        RewriteRuleTokenStream stream_Op=new RewriteRuleTokenStream(adaptor,"token Op");
        RewriteRuleSubtreeStream stream_apply=new RewriteRuleSubtreeStream(adaptor,"rule apply");
        try {
            // src/antlr/Vitry.g:67:5: ({...}? inlineRight | ( Op ( apply )? )+ -> ^( Ops ( ^( Op ( apply )? ) )+ ) | ( apply Op )=>e+= apply ( Op (f+= apply )? )+ -> ^( Ops $e ( ^( Op $f) )+ ) | apply )
            int alt11=4;
            alt11 = dfa11.predict(input);
            switch (alt11) {
                case 1 :
                    // src/antlr/Vitry.g:67:7: {...}? inlineRight
                    {
                    root_0 = (Object)adaptor.nil();

                    if ( !((rs)) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "inline", "$rs");
                    }
                    pushFollow(FOLLOW_inlineRight_in_inline670);
                    inlineRight24=inlineRight();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, inlineRight24.getTree());

                    }
                    break;
                case 2 :
                    // src/antlr/Vitry.g:68:7: ( Op ( apply )? )+
                    {
                    // src/antlr/Vitry.g:68:7: ( Op ( apply )? )+
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
                    	    // src/antlr/Vitry.g:68:8: Op ( apply )?
                    	    {
                    	    Op25=(Token)match(input,Op,FOLLOW_Op_in_inline679); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_Op.add(Op25);

                    	    // src/antlr/Vitry.g:68:11: ( apply )?
                    	    int alt7=2;
                    	    int LA7_0 = input.LA(1);

                    	    if ( ((LA7_0>=Symbol && LA7_0<=String)||LA7_0==39||LA7_0==41||LA7_0==43||LA7_0==45) ) {
                    	        alt7=1;
                    	    }
                    	    switch (alt7) {
                    	        case 1 :
                    	            // src/antlr/Vitry.g:68:11: apply
                    	            {
                    	            pushFollow(FOLLOW_apply_in_inline681);
                    	            apply26=apply();

                    	            state._fsp--;
                    	            if (state.failed) return retval;
                    	            if ( state.backtracking==0 ) stream_apply.add(apply26.getTree());

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
                    // elements: apply, Op
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 68:52: -> ^( Ops ( ^( Op ( apply )? ) )+ )
                    {
                        // src/antlr/Vitry.g:68:55: ^( Ops ( ^( Op ( apply )? ) )+ )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Ops, "Ops"), root_1);

                        if ( !(stream_Op.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_Op.hasNext() ) {
                            // src/antlr/Vitry.g:68:61: ^( Op ( apply )? )
                            {
                            Object root_2 = (Object)adaptor.nil();
                            root_2 = (Object)adaptor.becomeRoot(stream_Op.nextNode(), root_2);

                            // src/antlr/Vitry.g:68:66: ( apply )?
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
                    // src/antlr/Vitry.g:69:7: ( apply Op )=>e+= apply ( Op (f+= apply )? )+
                    {
                    pushFollow(FOLLOW_apply_in_inline748);
                    e=apply();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_apply.add(e.getTree());
                    if (list_e==null) list_e=new ArrayList();
                    list_e.add(e.getTree());

                    // src/antlr/Vitry.g:69:30: ( Op (f+= apply )? )+
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
                    	    // src/antlr/Vitry.g:69:31: Op (f+= apply )?
                    	    {
                    	    Op27=(Token)match(input,Op,FOLLOW_Op_in_inline751); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_Op.add(Op27);

                    	    // src/antlr/Vitry.g:69:35: (f+= apply )?
                    	    int alt9=2;
                    	    int LA9_0 = input.LA(1);

                    	    if ( ((LA9_0>=Symbol && LA9_0<=String)||LA9_0==39||LA9_0==41||LA9_0==43||LA9_0==45) ) {
                    	        alt9=1;
                    	    }
                    	    switch (alt9) {
                    	        case 1 :
                    	            // src/antlr/Vitry.g:69:35: f+= apply
                    	            {
                    	            pushFollow(FOLLOW_apply_in_inline755);
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
                    // elements: e, Op, f
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
                    // 69:52: -> ^( Ops $e ( ^( Op $f) )+ )
                    {
                        // src/antlr/Vitry.g:69:55: ^( Ops $e ( ^( Op $f) )+ )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Ops, "Ops"), root_1);

                        adaptor.addChild(root_1, stream_e.nextTree());
                        if ( !(stream_Op.hasNext()||stream_f.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_Op.hasNext()||stream_f.hasNext() ) {
                            // src/antlr/Vitry.g:69:64: ^( Op $f)
                            {
                            Object root_2 = (Object)adaptor.nil();
                            root_2 = (Object)adaptor.becomeRoot(stream_Op.nextNode(), root_2);

                            adaptor.addChild(root_2, stream_f.nextTree());

                            adaptor.addChild(root_1, root_2);
                            }

                        }
                        stream_Op.reset();
                        stream_f.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // src/antlr/Vitry.g:70:7: apply
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_apply_in_inline790);
                    apply28=apply();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, apply28.getTree());

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
    // src/antlr/Vitry.g:74:1: inlineRight : ( 'fn' '(' ( left )* ')' inline[true] -> ^( Fn ( left )* inline ) | 'let' '(' ( assign )* ')' inline[true] -> ^( Let ( assign )* inline ) | 'loop' '(' ( assign )* ')' inline[true] -> ^( Loop ( assign )* inline ) | 'do' '(' ( assign )* ')' ( expr )* -> ^( Do ( assign )* ( expr )* ) | 'if' expr expr ( 'else' )? inline[true] -> ^( If expr expr inline ) | 'match' v= expr '(' (l+= left r+= expr )* ')' -> ^( Match $v ( ^( $l $r) )* ) | 'recur' ( expr )* -> ^( Recur ( expr )* ) );
    public final VitryParser.inlineRight_return inlineRight() throws RecognitionException {
        VitryParser.inlineRight_return retval = new VitryParser.inlineRight_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal29=null;
        Token char_literal30=null;
        Token char_literal32=null;
        Token string_literal34=null;
        Token char_literal35=null;
        Token char_literal37=null;
        Token string_literal39=null;
        Token char_literal40=null;
        Token char_literal42=null;
        Token string_literal44=null;
        Token char_literal45=null;
        Token char_literal47=null;
        Token string_literal49=null;
        Token string_literal52=null;
        Token string_literal54=null;
        Token char_literal55=null;
        Token char_literal56=null;
        Token string_literal57=null;
        List list_l=null;
        List list_r=null;
        VitryParser.expr_return v = null;

        VitryParser.left_return left31 = null;

        VitryParser.inline_return inline33 = null;

        VitryParser.assign_return assign36 = null;

        VitryParser.inline_return inline38 = null;

        VitryParser.assign_return assign41 = null;

        VitryParser.inline_return inline43 = null;

        VitryParser.assign_return assign46 = null;

        VitryParser.expr_return expr48 = null;

        VitryParser.expr_return expr50 = null;

        VitryParser.expr_return expr51 = null;

        VitryParser.inline_return inline53 = null;

        VitryParser.expr_return expr58 = null;

        RuleReturnScope l = null;
        RuleReturnScope r = null;
        Object string_literal29_tree=null;
        Object char_literal30_tree=null;
        Object char_literal32_tree=null;
        Object string_literal34_tree=null;
        Object char_literal35_tree=null;
        Object char_literal37_tree=null;
        Object string_literal39_tree=null;
        Object char_literal40_tree=null;
        Object char_literal42_tree=null;
        Object string_literal44_tree=null;
        Object char_literal45_tree=null;
        Object char_literal47_tree=null;
        Object string_literal49_tree=null;
        Object string_literal52_tree=null;
        Object string_literal54_tree=null;
        Object char_literal55_tree=null;
        Object char_literal56_tree=null;
        Object string_literal57_tree=null;
        RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
        RewriteRuleTokenStream stream_48=new RewriteRuleTokenStream(adaptor,"token 48");
        RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
        RewriteRuleTokenStream stream_46=new RewriteRuleTokenStream(adaptor,"token 46");
        RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
        RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
        RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
        RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
        RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");
        RewriteRuleTokenStream stream_50=new RewriteRuleTokenStream(adaptor,"token 50");
        RewriteRuleSubtreeStream stream_assign=new RewriteRuleSubtreeStream(adaptor,"rule assign");
        RewriteRuleSubtreeStream stream_inline=new RewriteRuleSubtreeStream(adaptor,"rule inline");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        RewriteRuleSubtreeStream stream_left=new RewriteRuleSubtreeStream(adaptor,"rule left");
        try {
            // src/antlr/Vitry.g:75:5: ( 'fn' '(' ( left )* ')' inline[true] -> ^( Fn ( left )* inline ) | 'let' '(' ( assign )* ')' inline[true] -> ^( Let ( assign )* inline ) | 'loop' '(' ( assign )* ')' inline[true] -> ^( Loop ( assign )* inline ) | 'do' '(' ( assign )* ')' ( expr )* -> ^( Do ( assign )* ( expr )* ) | 'if' expr expr ( 'else' )? inline[true] -> ^( If expr expr inline ) | 'match' v= expr '(' (l+= left r+= expr )* ')' -> ^( Match $v ( ^( $l $r) )* ) | 'recur' ( expr )* -> ^( Recur ( expr )* ) )
            int alt20=7;
            switch ( input.LA(1) ) {
            case 46:
                {
                alt20=1;
                }
                break;
            case 47:
                {
                alt20=2;
                }
                break;
            case 48:
                {
                alt20=3;
                }
                break;
            case 49:
                {
                alt20=4;
                }
                break;
            case 50:
                {
                alt20=5;
                }
                break;
            case 52:
                {
                alt20=6;
                }
                break;
            case 53:
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
                    // src/antlr/Vitry.g:75:7: 'fn' '(' ( left )* ')' inline[true]
                    {
                    string_literal29=(Token)match(input,46,FOLLOW_46_in_inlineRight834); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_46.add(string_literal29);

                    char_literal30=(Token)match(input,39,FOLLOW_39_in_inlineRight836); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_39.add(char_literal30);

                    // src/antlr/Vitry.g:75:16: ( left )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( ((LA12_0>=Symbol && LA12_0<=String)||LA12_0==39||LA12_0==41||LA12_0==43||LA12_0==45) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:75:16: left
                    	    {
                    	    pushFollow(FOLLOW_left_in_inlineRight838);
                    	    left31=left();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_left.add(left31.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    char_literal32=(Token)match(input,40,FOLLOW_40_in_inlineRight841); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(char_literal32);

                    pushFollow(FOLLOW_inline_in_inlineRight843);
                    inline33=inline(true);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_inline.add(inline33.getTree());


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
                    // 75:52: -> ^( Fn ( left )* inline )
                    {
                        // src/antlr/Vitry.g:75:55: ^( Fn ( left )* inline )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Fn, "Fn"), root_1);

                        // src/antlr/Vitry.g:75:60: ( left )*
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
                    // src/antlr/Vitry.g:76:7: 'let' '(' ( assign )* ')' inline[true]
                    {
                    string_literal34=(Token)match(input,47,FOLLOW_47_in_inlineRight876); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_47.add(string_literal34);

                    char_literal35=(Token)match(input,39,FOLLOW_39_in_inlineRight878); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_39.add(char_literal35);

                    // src/antlr/Vitry.g:76:17: ( assign )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( ((LA13_0>=Symbol && LA13_0<=String)||LA13_0==39||LA13_0==41||LA13_0==43||LA13_0==45) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:76:17: assign
                    	    {
                    	    pushFollow(FOLLOW_assign_in_inlineRight880);
                    	    assign36=assign();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_assign.add(assign36.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    char_literal37=(Token)match(input,40,FOLLOW_40_in_inlineRight883); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(char_literal37);

                    pushFollow(FOLLOW_inline_in_inlineRight885);
                    inline38=inline(true);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_inline.add(inline38.getTree());


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
                    // 76:52: -> ^( Let ( assign )* inline )
                    {
                        // src/antlr/Vitry.g:76:55: ^( Let ( assign )* inline )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Let, "Let"), root_1);

                        // src/antlr/Vitry.g:76:61: ( assign )*
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
                    // src/antlr/Vitry.g:77:7: 'loop' '(' ( assign )* ')' inline[true]
                    {
                    string_literal39=(Token)match(input,48,FOLLOW_48_in_inlineRight915); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_48.add(string_literal39);

                    char_literal40=(Token)match(input,39,FOLLOW_39_in_inlineRight917); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_39.add(char_literal40);

                    // src/antlr/Vitry.g:77:18: ( assign )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( ((LA14_0>=Symbol && LA14_0<=String)||LA14_0==39||LA14_0==41||LA14_0==43||LA14_0==45) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:77:18: assign
                    	    {
                    	    pushFollow(FOLLOW_assign_in_inlineRight919);
                    	    assign41=assign();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_assign.add(assign41.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    char_literal42=(Token)match(input,40,FOLLOW_40_in_inlineRight922); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(char_literal42);

                    pushFollow(FOLLOW_inline_in_inlineRight924);
                    inline43=inline(true);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_inline.add(inline43.getTree());


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
                    // 77:52: -> ^( Loop ( assign )* inline )
                    {
                        // src/antlr/Vitry.g:77:55: ^( Loop ( assign )* inline )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Loop, "Loop"), root_1);

                        // src/antlr/Vitry.g:77:62: ( assign )*
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
                    // src/antlr/Vitry.g:78:7: 'do' '(' ( assign )* ')' ( expr )*
                    {
                    string_literal44=(Token)match(input,49,FOLLOW_49_in_inlineRight953); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_49.add(string_literal44);

                    char_literal45=(Token)match(input,39,FOLLOW_39_in_inlineRight955); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_39.add(char_literal45);

                    // src/antlr/Vitry.g:78:16: ( assign )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( ((LA15_0>=Symbol && LA15_0<=String)||LA15_0==39||LA15_0==41||LA15_0==43||LA15_0==45) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:78:16: assign
                    	    {
                    	    pushFollow(FOLLOW_assign_in_inlineRight957);
                    	    assign46=assign();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_assign.add(assign46.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);

                    char_literal47=(Token)match(input,40,FOLLOW_40_in_inlineRight960); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(char_literal47);

                    // src/antlr/Vitry.g:78:28: ( expr )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( ((LA16_0>=Symbol && LA16_0<=String)||LA16_0==39||LA16_0==41||LA16_0==43||LA16_0==45) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:78:28: expr
                    	    {
                    	    pushFollow(FOLLOW_expr_in_inlineRight962);
                    	    expr48=expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_expr.add(expr48.getTree());

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
                    // 78:52: -> ^( Do ( assign )* ( expr )* )
                    {
                        // src/antlr/Vitry.g:78:55: ^( Do ( assign )* ( expr )* )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Do, "Do"), root_1);

                        // src/antlr/Vitry.g:78:60: ( assign )*
                        while ( stream_assign.hasNext() ) {
                            adaptor.addChild(root_1, stream_assign.nextTree());

                        }
                        stream_assign.reset();
                        // src/antlr/Vitry.g:78:68: ( expr )*
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
                    // src/antlr/Vitry.g:79:7: 'if' expr expr ( 'else' )? inline[true]
                    {
                    string_literal49=(Token)match(input,50,FOLLOW_50_in_inlineRight1001); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_50.add(string_literal49);

                    pushFollow(FOLLOW_expr_in_inlineRight1003);
                    expr50=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr50.getTree());
                    pushFollow(FOLLOW_expr_in_inlineRight1005);
                    expr51=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr51.getTree());
                    // src/antlr/Vitry.g:79:22: ( 'else' )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==51) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // src/antlr/Vitry.g:79:22: 'else'
                            {
                            string_literal52=(Token)match(input,51,FOLLOW_51_in_inlineRight1007); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_51.add(string_literal52);


                            }
                            break;

                    }

                    pushFollow(FOLLOW_inline_in_inlineRight1010);
                    inline53=inline(true);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_inline.add(inline53.getTree());


                    // AST REWRITE
                    // elements: inline, expr, expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 79:52: -> ^( If expr expr inline )
                    {
                        // src/antlr/Vitry.g:79:55: ^( If expr expr inline )
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
                    // src/antlr/Vitry.g:80:7: 'match' v= expr '(' (l+= left r+= expr )* ')'
                    {
                    string_literal54=(Token)match(input,52,FOLLOW_52_in_inlineRight1040); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_52.add(string_literal54);

                    pushFollow(FOLLOW_expr_in_inlineRight1044);
                    v=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(v.getTree());
                    char_literal55=(Token)match(input,39,FOLLOW_39_in_inlineRight1046); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_39.add(char_literal55);

                    // src/antlr/Vitry.g:80:26: (l+= left r+= expr )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( ((LA18_0>=Symbol && LA18_0<=String)||LA18_0==39||LA18_0==41||LA18_0==43||LA18_0==45) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:80:27: l+= left r+= expr
                    	    {
                    	    pushFollow(FOLLOW_left_in_inlineRight1051);
                    	    l=left();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_left.add(l.getTree());
                    	    if (list_l==null) list_l=new ArrayList();
                    	    list_l.add(l.getTree());

                    	    pushFollow(FOLLOW_expr_in_inlineRight1055);
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

                    char_literal56=(Token)match(input,40,FOLLOW_40_in_inlineRight1059); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(char_literal56);



                    // AST REWRITE
                    // elements: l, r, v
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
                    // 80:52: -> ^( Match $v ( ^( $l $r) )* )
                    {
                        // src/antlr/Vitry.g:80:55: ^( Match $v ( ^( $l $r) )* )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Match, "Match"), root_1);

                        adaptor.addChild(root_1, stream_v.nextTree());
                        // src/antlr/Vitry.g:80:66: ( ^( $l $r) )*
                        while ( stream_l.hasNext()||stream_r.hasNext() ) {
                            // src/antlr/Vitry.g:80:66: ^( $l $r)
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
                case 7 :
                    // src/antlr/Vitry.g:81:7: 'recur' ( expr )*
                    {
                    string_literal57=(Token)match(input,53,FOLLOW_53_in_inlineRight1088); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_53.add(string_literal57);

                    // src/antlr/Vitry.g:81:15: ( expr )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( ((LA19_0>=Symbol && LA19_0<=String)||LA19_0==39||LA19_0==41||LA19_0==43||LA19_0==45) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:81:15: expr
                    	    {
                    	    pushFollow(FOLLOW_expr_in_inlineRight1090);
                    	    expr58=expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_expr.add(expr58.getTree());

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
                    // 81:37: -> ^( Recur ( expr )* )
                    {
                        // src/antlr/Vitry.g:81:40: ^( Recur ( expr )* )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Recur, "Recur"), root_1);

                        // src/antlr/Vitry.g:81:48: ( expr )*
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
    // src/antlr/Vitry.g:84:1: assign : left '=' expr -> ^( Assign left expr ) ;
    public final VitryParser.assign_return assign() throws RecognitionException {
        VitryParser.assign_return retval = new VitryParser.assign_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal60=null;
        VitryParser.left_return left59 = null;

        VitryParser.expr_return expr61 = null;


        Object char_literal60_tree=null;
        RewriteRuleTokenStream stream_54=new RewriteRuleTokenStream(adaptor,"token 54");
        RewriteRuleSubtreeStream stream_left=new RewriteRuleSubtreeStream(adaptor,"rule left");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // src/antlr/Vitry.g:85:5: ( left '=' expr -> ^( Assign left expr ) )
            // src/antlr/Vitry.g:85:7: left '=' expr
            {
            pushFollow(FOLLOW_left_in_assign1133);
            left59=left();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_left.add(left59.getTree());
            char_literal60=(Token)match(input,54,FOLLOW_54_in_assign1135); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_54.add(char_literal60);

            pushFollow(FOLLOW_expr_in_assign1137);
            expr61=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expr.add(expr61.getTree());


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
            // 85:52: -> ^( Assign left expr )
            {
                // src/antlr/Vitry.g:85:55: ^( Assign left expr )
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
    // src/antlr/Vitry.g:89:1: apply : ( ( expr expr )=> ( expr )+ -> ^( Apply ( expr )+ ) | expr );
    public final VitryParser.apply_return apply() throws RecognitionException {
        VitryParser.apply_return retval = new VitryParser.apply_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        VitryParser.expr_return expr62 = null;

        VitryParser.expr_return expr63 = null;


        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // src/antlr/Vitry.g:90:5: ( ( expr expr )=> ( expr )+ -> ^( Apply ( expr )+ ) | expr )
            int alt22=2;
            switch ( input.LA(1) ) {
            case 39:
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
            case 41:
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
            case 43:
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
            case 45:
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
            case Symbol:
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
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // src/antlr/Vitry.g:90:7: ( expr expr )=> ( expr )+
                    {
                    // src/antlr/Vitry.g:90:22: ( expr )+
                    int cnt21=0;
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( ((LA21_0>=Symbol && LA21_0<=String)||LA21_0==39||LA21_0==41||LA21_0==43||LA21_0==45) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:90:22: expr
                    	    {
                    	    pushFollow(FOLLOW_expr_in_apply1208);
                    	    expr62=expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_expr.add(expr62.getTree());

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
                    // 90:52: -> ^( Apply ( expr )+ )
                    {
                        // src/antlr/Vitry.g:90:55: ^( Apply ( expr )+ )
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
                    // src/antlr/Vitry.g:91:7: expr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_expr_in_apply1250);
                    expr63=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr63.getTree());

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
    // src/antlr/Vitry.g:100:1: module : 'module' moduleName ( '(' (exports+= Symbol )* ')' )? ( 'import' (imports+= moduleName )* )* ( '(' declarations+= moduleDecl ')' )* -> ^( Module moduleName ( ^( $exports) )* ( ^( $imports) )* ( ^( $declarations) )* ) ;
    public final VitryParser.module_return module() throws RecognitionException {
        VitryParser.module_return retval = new VitryParser.module_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal64=null;
        Token char_literal66=null;
        Token char_literal67=null;
        Token string_literal68=null;
        Token char_literal69=null;
        Token char_literal70=null;
        Token exports=null;
        List list_exports=null;
        List list_imports=null;
        List list_declarations=null;
        VitryParser.moduleName_return moduleName65 = null;

        RuleReturnScope imports = null;
        RuleReturnScope declarations = null;
        Object string_literal64_tree=null;
        Object char_literal66_tree=null;
        Object char_literal67_tree=null;
        Object string_literal68_tree=null;
        Object char_literal69_tree=null;
        Object char_literal70_tree=null;
        Object exports_tree=null;
        RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
        RewriteRuleTokenStream stream_Symbol=new RewriteRuleTokenStream(adaptor,"token Symbol");
        RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
        RewriteRuleTokenStream stream_55=new RewriteRuleTokenStream(adaptor,"token 55");
        RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");
        RewriteRuleSubtreeStream stream_moduleName=new RewriteRuleSubtreeStream(adaptor,"rule moduleName");
        RewriteRuleSubtreeStream stream_moduleDecl=new RewriteRuleSubtreeStream(adaptor,"rule moduleDecl");
        try {
            // src/antlr/Vitry.g:101:5: ( 'module' moduleName ( '(' (exports+= Symbol )* ')' )? ( 'import' (imports+= moduleName )* )* ( '(' declarations+= moduleDecl ')' )* -> ^( Module moduleName ( ^( $exports) )* ( ^( $imports) )* ( ^( $declarations) )* ) )
            // src/antlr/Vitry.g:101:7: 'module' moduleName ( '(' (exports+= Symbol )* ')' )? ( 'import' (imports+= moduleName )* )* ( '(' declarations+= moduleDecl ')' )*
            {
            string_literal64=(Token)match(input,55,FOLLOW_55_in_module1282); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_55.add(string_literal64);

            pushFollow(FOLLOW_moduleName_in_module1284);
            moduleName65=moduleName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_moduleName.add(moduleName65.getTree());
            // src/antlr/Vitry.g:101:27: ( '(' (exports+= Symbol )* ')' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==39) ) {
                int LA24_1 = input.LA(2);

                if ( (LA24_1==Symbol) ) {
                    int LA24_3 = input.LA(3);

                    if ( (LA24_3==Symbol||LA24_3==40) ) {
                        alt24=1;
                    }
                }
                else if ( (LA24_1==40) ) {
                    alt24=1;
                }
            }
            switch (alt24) {
                case 1 :
                    // src/antlr/Vitry.g:101:28: '(' (exports+= Symbol )* ')'
                    {
                    char_literal66=(Token)match(input,39,FOLLOW_39_in_module1287); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_39.add(char_literal66);

                    // src/antlr/Vitry.g:101:39: (exports+= Symbol )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==Symbol) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:101:39: exports+= Symbol
                    	    {
                    	    exports=(Token)match(input,Symbol,FOLLOW_Symbol_in_module1291); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_Symbol.add(exports);

                    	    if (list_exports==null) list_exports=new ArrayList();
                    	    list_exports.add(exports);


                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);

                    char_literal67=(Token)match(input,40,FOLLOW_40_in_module1294); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(char_literal67);


                    }
                    break;

            }

            // src/antlr/Vitry.g:102:7: ( 'import' (imports+= moduleName )* )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==56) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // src/antlr/Vitry.g:102:8: 'import' (imports+= moduleName )*
            	    {
            	    string_literal68=(Token)match(input,56,FOLLOW_56_in_module1305); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_56.add(string_literal68);

            	    // src/antlr/Vitry.g:102:24: (imports+= moduleName )*
            	    loop25:
            	    do {
            	        int alt25=2;
            	        int LA25_0 = input.LA(1);

            	        if ( (LA25_0==Symbol) ) {
            	            alt25=1;
            	        }


            	        switch (alt25) {
            	    	case 1 :
            	    	    // src/antlr/Vitry.g:102:24: imports+= moduleName
            	    	    {
            	    	    pushFollow(FOLLOW_moduleName_in_module1309);
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

            // src/antlr/Vitry.g:103:7: ( '(' declarations+= moduleDecl ')' )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==39) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // src/antlr/Vitry.g:103:9: '(' declarations+= moduleDecl ')'
            	    {
            	    char_literal69=(Token)match(input,39,FOLLOW_39_in_module1322); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_39.add(char_literal69);

            	    pushFollow(FOLLOW_moduleDecl_in_module1326);
            	    declarations=moduleDecl();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_moduleDecl.add(declarations.getTree());
            	    if (list_declarations==null) list_declarations=new ArrayList();
            	    list_declarations.add(declarations.getTree());

            	    char_literal70=(Token)match(input,40,FOLLOW_40_in_module1328); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_40.add(char_literal70);


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);



            // AST REWRITE
            // elements: declarations, exports, imports, moduleName
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
            // 104:5: -> ^( Module moduleName ( ^( $exports) )* ( ^( $imports) )* ( ^( $declarations) )* )
            {
                // src/antlr/Vitry.g:104:8: ^( Module moduleName ( ^( $exports) )* ( ^( $imports) )* ( ^( $declarations) )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Module, "Module"), root_1);

                adaptor.addChild(root_1, stream_moduleName.nextTree());
                // src/antlr/Vitry.g:104:28: ( ^( $exports) )*
                while ( stream_exports.hasNext() ) {
                    // src/antlr/Vitry.g:104:28: ^( $exports)
                    {
                    Object root_2 = (Object)adaptor.nil();
                    root_2 = (Object)adaptor.becomeRoot(stream_exports.nextNode(), root_2);

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_exports.reset();
                // src/antlr/Vitry.g:104:41: ( ^( $imports) )*
                while ( stream_imports.hasNext() ) {
                    // src/antlr/Vitry.g:104:41: ^( $imports)
                    {
                    Object root_2 = (Object)adaptor.nil();
                    root_2 = (Object)adaptor.becomeRoot(stream_imports.nextNode(), root_2);

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_imports.reset();
                // src/antlr/Vitry.g:104:54: ( ^( $declarations) )*
                while ( stream_declarations.hasNext() ) {
                    // src/antlr/Vitry.g:104:54: ^( $declarations)
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
    // src/antlr/Vitry.g:107:1: moduleDecl : ( 'type' '(' ( assign )* ')' -> ^( TypeDecl ( assign )* ) | 'implicit' '(' ( expr expr )* ')' -> ^( ImplicitDecl ( ^( expr expr ) )* ) | Symbol '(' ( left )* ')' '=' inline[true] -> ^( FnDecl Symbol ( left )+ inline ) | left '=' expr -> ^( MemberDecl left expr ) );
    public final VitryParser.moduleDecl_return moduleDecl() throws RecognitionException {
        VitryParser.moduleDecl_return retval = new VitryParser.moduleDecl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal71=null;
        Token char_literal72=null;
        Token char_literal74=null;
        Token string_literal75=null;
        Token char_literal76=null;
        Token char_literal79=null;
        Token Symbol80=null;
        Token char_literal81=null;
        Token char_literal83=null;
        Token char_literal84=null;
        Token char_literal87=null;
        VitryParser.assign_return assign73 = null;

        VitryParser.expr_return expr77 = null;

        VitryParser.expr_return expr78 = null;

        VitryParser.left_return left82 = null;

        VitryParser.inline_return inline85 = null;

        VitryParser.left_return left86 = null;

        VitryParser.expr_return expr88 = null;


        Object string_literal71_tree=null;
        Object char_literal72_tree=null;
        Object char_literal74_tree=null;
        Object string_literal75_tree=null;
        Object char_literal76_tree=null;
        Object char_literal79_tree=null;
        Object Symbol80_tree=null;
        Object char_literal81_tree=null;
        Object char_literal83_tree=null;
        Object char_literal84_tree=null;
        Object char_literal87_tree=null;
        RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
        RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
        RewriteRuleTokenStream stream_Symbol=new RewriteRuleTokenStream(adaptor,"token Symbol");
        RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
        RewriteRuleTokenStream stream_54=new RewriteRuleTokenStream(adaptor,"token 54");
        RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");
        RewriteRuleSubtreeStream stream_assign=new RewriteRuleSubtreeStream(adaptor,"rule assign");
        RewriteRuleSubtreeStream stream_inline=new RewriteRuleSubtreeStream(adaptor,"rule inline");
        RewriteRuleSubtreeStream stream_left=new RewriteRuleSubtreeStream(adaptor,"rule left");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // src/antlr/Vitry.g:108:5: ( 'type' '(' ( assign )* ')' -> ^( TypeDecl ( assign )* ) | 'implicit' '(' ( expr expr )* ')' -> ^( ImplicitDecl ( ^( expr expr ) )* ) | Symbol '(' ( left )* ')' '=' inline[true] -> ^( FnDecl Symbol ( left )+ inline ) | left '=' expr -> ^( MemberDecl left expr ) )
            int alt31=4;
            switch ( input.LA(1) ) {
            case 57:
                {
                alt31=1;
                }
                break;
            case 58:
                {
                alt31=2;
                }
                break;
            case Symbol:
                {
                int LA31_3 = input.LA(2);

                if ( (LA31_3==39) ) {
                    alt31=3;
                }
                else if ( (LA31_3==38||LA31_3==54) ) {
                    alt31=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 31, 3, input);

                    throw nvae;
                }
                }
                break;
            case Natural:
            case Float:
            case Complex:
            case String:
            case 39:
            case 41:
            case 43:
            case 45:
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
                    // src/antlr/Vitry.g:108:7: 'type' '(' ( assign )* ')'
                    {
                    string_literal71=(Token)match(input,57,FOLLOW_57_in_moduleDecl1382); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_57.add(string_literal71);

                    char_literal72=(Token)match(input,39,FOLLOW_39_in_moduleDecl1387); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_39.add(char_literal72);

                    // src/antlr/Vitry.g:108:21: ( assign )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( ((LA28_0>=Symbol && LA28_0<=String)||LA28_0==39||LA28_0==41||LA28_0==43||LA28_0==45) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:108:21: assign
                    	    {
                    	    pushFollow(FOLLOW_assign_in_moduleDecl1389);
                    	    assign73=assign();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_assign.add(assign73.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop28;
                        }
                    } while (true);

                    char_literal74=(Token)match(input,40,FOLLOW_40_in_moduleDecl1392); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(char_literal74);



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
                    // 108:48: -> ^( TypeDecl ( assign )* )
                    {
                        // src/antlr/Vitry.g:108:51: ^( TypeDecl ( assign )* )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TypeDecl, "TypeDecl"), root_1);

                        // src/antlr/Vitry.g:108:62: ( assign )*
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
                    // src/antlr/Vitry.g:109:7: 'implicit' '(' ( expr expr )* ')'
                    {
                    string_literal75=(Token)match(input,58,FOLLOW_58_in_moduleDecl1424); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_58.add(string_literal75);

                    char_literal76=(Token)match(input,39,FOLLOW_39_in_moduleDecl1426); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_39.add(char_literal76);

                    // src/antlr/Vitry.g:109:22: ( expr expr )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( ((LA29_0>=Symbol && LA29_0<=String)||LA29_0==39||LA29_0==41||LA29_0==43||LA29_0==45) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:109:23: expr expr
                    	    {
                    	    pushFollow(FOLLOW_expr_in_moduleDecl1429);
                    	    expr77=expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_expr.add(expr77.getTree());
                    	    pushFollow(FOLLOW_expr_in_moduleDecl1431);
                    	    expr78=expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_expr.add(expr78.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop29;
                        }
                    } while (true);

                    char_literal79=(Token)match(input,40,FOLLOW_40_in_moduleDecl1435); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(char_literal79);



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
                    // 109:49: -> ^( ImplicitDecl ( ^( expr expr ) )* )
                    {
                        // src/antlr/Vitry.g:109:52: ^( ImplicitDecl ( ^( expr expr ) )* )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ImplicitDecl, "ImplicitDecl"), root_1);

                        // src/antlr/Vitry.g:109:67: ( ^( expr expr ) )*
                        while ( stream_expr.hasNext()||stream_expr.hasNext() ) {
                            // src/antlr/Vitry.g:109:67: ^( expr expr )
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
                    // src/antlr/Vitry.g:110:7: Symbol '(' ( left )* ')' '=' inline[true]
                    {
                    Symbol80=(Token)match(input,Symbol,FOLLOW_Symbol_in_moduleDecl1466); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_Symbol.add(Symbol80);

                    char_literal81=(Token)match(input,39,FOLLOW_39_in_moduleDecl1471); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_39.add(char_literal81);

                    // src/antlr/Vitry.g:110:21: ( left )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( ((LA30_0>=Symbol && LA30_0<=String)||LA30_0==39||LA30_0==41||LA30_0==43||LA30_0==45) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:110:21: left
                    	    {
                    	    pushFollow(FOLLOW_left_in_moduleDecl1473);
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

                    char_literal83=(Token)match(input,40,FOLLOW_40_in_moduleDecl1476); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(char_literal83);

                    char_literal84=(Token)match(input,54,FOLLOW_54_in_moduleDecl1478); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_54.add(char_literal84);

                    pushFollow(FOLLOW_inline_in_moduleDecl1480);
                    inline85=inline(true);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_inline.add(inline85.getTree());


                    // AST REWRITE
                    // elements: left, inline, Symbol
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 110:48: -> ^( FnDecl Symbol ( left )+ inline )
                    {
                        // src/antlr/Vitry.g:110:51: ^( FnDecl Symbol ( left )+ inline )
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
                    // src/antlr/Vitry.g:111:7: left '=' expr
                    {
                    pushFollow(FOLLOW_left_in_moduleDecl1502);
                    left86=left();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_left.add(left86.getTree());
                    char_literal87=(Token)match(input,54,FOLLOW_54_in_moduleDecl1504); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_54.add(char_literal87);

                    pushFollow(FOLLOW_expr_in_moduleDecl1506);
                    expr88=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr88.getTree());


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
                    // 111:50: -> ^( MemberDecl left expr )
                    {
                        // src/antlr/Vitry.g:111:53: ^( MemberDecl left expr )
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
    // src/antlr/Vitry.g:114:1: moduleName : Symbol ( '.' Symbol )* -> ^( Symbol ( Symbol )+ ) ;
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
        RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
        RewriteRuleTokenStream stream_Symbol=new RewriteRuleTokenStream(adaptor,"token Symbol");

        try {
            // src/antlr/Vitry.g:114:12: ( Symbol ( '.' Symbol )* -> ^( Symbol ( Symbol )+ ) )
            // src/antlr/Vitry.g:115:5: Symbol ( '.' Symbol )*
            {
            Symbol89=(Token)match(input,Symbol,FOLLOW_Symbol_in_moduleName1566); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_Symbol.add(Symbol89);

            // src/antlr/Vitry.g:115:12: ( '.' Symbol )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==59) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // src/antlr/Vitry.g:115:13: '.' Symbol
            	    {
            	    char_literal90=(Token)match(input,59,FOLLOW_59_in_moduleName1569); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_59.add(char_literal90);

            	    Symbol91=(Token)match(input,Symbol,FOLLOW_Symbol_in_moduleName1571); if (state.failed) return retval; 
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
            // 115:26: -> ^( Symbol ( Symbol )+ )
            {
                // src/antlr/Vitry.g:115:29: ^( Symbol ( Symbol )+ )
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
        // src/antlr/Vitry.g:36:7: ( delim[true] ':' )
        // src/antlr/Vitry.g:36:8: delim[true] ':'
        {
        pushFollow(FOLLOW_delim_in_synpred1_Vitry186);
        delim(true);

        state._fsp--;
        if (state.failed) return ;
        match(input,38,FOLLOW_38_in_synpred1_Vitry189); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_Vitry

    // $ANTLR start synpred2_Vitry
    public final void synpred2_Vitry_fragment() throws RecognitionException {   
        // src/antlr/Vitry.g:43:7: ( delim[false] ':' )
        // src/antlr/Vitry.g:43:8: delim[false] ':'
        {
        pushFollow(FOLLOW_delim_in_synpred2_Vitry245);
        delim(false);

        state._fsp--;
        if (state.failed) return ;
        match(input,38,FOLLOW_38_in_synpred2_Vitry248); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_Vitry

    // $ANTLR start synpred3_Vitry
    public final void synpred3_Vitry_fragment() throws RecognitionException {   
        // src/antlr/Vitry.g:69:7: ( apply Op )
        // src/antlr/Vitry.g:69:8: apply Op
        {
        pushFollow(FOLLOW_apply_in_synpred3_Vitry739);
        apply();

        state._fsp--;
        if (state.failed) return ;
        match(input,Op,FOLLOW_Op_in_synpred3_Vitry741); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_Vitry

    // $ANTLR start synpred4_Vitry
    public final void synpred4_Vitry_fragment() throws RecognitionException {   
        // src/antlr/Vitry.g:90:7: ( expr expr )
        // src/antlr/Vitry.g:90:8: expr expr
        {
        pushFollow(FOLLOW_expr_in_synpred4_Vitry1201);
        expr();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_expr_in_synpred4_Vitry1203);
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
        "\20\uffff";
    static final String DFA11_eofS =
        "\20\uffff";
    static final String DFA11_minS =
        "\1\32\10\uffff\5\0\2\uffff";
    static final String DFA11_maxS =
        "\1\65\10\uffff\5\0\2\uffff";
    static final String DFA11_acceptS =
        "\1\uffff\1\1\6\uffff\1\2\5\uffff\1\3\1\4";
    static final String DFA11_specialS =
        "\11\uffff\1\0\1\1\1\2\1\3\1\4\2\uffff}>";
    static final String[] DFA11_transitionS = {
            "\1\10\5\15\7\uffff\1\11\1\uffff\1\12\1\uffff\1\13\1\uffff\1"+
            "\14\5\1\1\uffff\2\1",
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
            return "66:1: inline[boolean rs] : ({...}? inlineRight | ( Op ( apply )? )+ -> ^( Ops ( ^( Op ( apply )? ) )+ ) | ( apply Op )=>e+= apply ( Op (f+= apply )? )+ -> ^( Ops $e ( ^( Op $f) )+ ) | apply );";
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
                        if ( (synpred3_Vitry()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index11_9);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA11_10 = input.LA(1);

                         
                        int index11_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_Vitry()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index11_10);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA11_11 = input.LA(1);

                         
                        int index11_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_Vitry()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index11_11);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA11_12 = input.LA(1);

                         
                        int index11_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_Vitry()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index11_12);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
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
 

    public static final BitSet FOLLOW_delim_in_expr194 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_expr197 = new BitSet(new long[]{0x00002A80F8000000L});
    public static final BitSet FOLLOW_expr_in_expr199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_delim_in_expr220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_delim_in_left253 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_left256 = new BitSet(new long[]{0x00002A80F8000000L});
    public static final BitSet FOLLOW_expr_in_left258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_delim_in_left281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_delim342 = new BitSet(new long[]{0x0037EB80FC000000L});
    public static final BitSet FOLLOW_inline_in_delim344 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_delim348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_delim390 = new BitSet(new long[]{0x0037EE80FC000000L});
    public static final BitSet FOLLOW_inline_in_delim392 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_delim396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_delim438 = new BitSet(new long[]{0x0037FA80FC000000L});
    public static final BitSet FOLLOW_inline_in_delim440 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_delim444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_delim486 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_Op_in_delim488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_delim542 = new BitSet(new long[]{0x00002A80F8000000L});
    public static final BitSet FOLLOW_delim_in_delim544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_delim592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_atom0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inlineRight_in_inline670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Op_in_inline679 = new BitSet(new long[]{0x00002A80FC000002L});
    public static final BitSet FOLLOW_apply_in_inline681 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_apply_in_inline748 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_Op_in_inline751 = new BitSet(new long[]{0x00002A80FC000002L});
    public static final BitSet FOLLOW_apply_in_inline755 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_apply_in_inline790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_inlineRight834 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_inlineRight836 = new BitSet(new long[]{0x00002B80F8000000L});
    public static final BitSet FOLLOW_left_in_inlineRight838 = new BitSet(new long[]{0x00002B80F8000000L});
    public static final BitSet FOLLOW_40_in_inlineRight841 = new BitSet(new long[]{0x0037EA80FC000000L});
    public static final BitSet FOLLOW_inline_in_inlineRight843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_inlineRight876 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_inlineRight878 = new BitSet(new long[]{0x00002B80F8000000L});
    public static final BitSet FOLLOW_assign_in_inlineRight880 = new BitSet(new long[]{0x00002B80F8000000L});
    public static final BitSet FOLLOW_40_in_inlineRight883 = new BitSet(new long[]{0x0037EA80FC000000L});
    public static final BitSet FOLLOW_inline_in_inlineRight885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_inlineRight915 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_inlineRight917 = new BitSet(new long[]{0x00002B80F8000000L});
    public static final BitSet FOLLOW_assign_in_inlineRight919 = new BitSet(new long[]{0x00002B80F8000000L});
    public static final BitSet FOLLOW_40_in_inlineRight922 = new BitSet(new long[]{0x0037EA80FC000000L});
    public static final BitSet FOLLOW_inline_in_inlineRight924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_inlineRight953 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_inlineRight955 = new BitSet(new long[]{0x00002B80F8000000L});
    public static final BitSet FOLLOW_assign_in_inlineRight957 = new BitSet(new long[]{0x00002B80F8000000L});
    public static final BitSet FOLLOW_40_in_inlineRight960 = new BitSet(new long[]{0x00002A80F8000002L});
    public static final BitSet FOLLOW_expr_in_inlineRight962 = new BitSet(new long[]{0x00002A80F8000002L});
    public static final BitSet FOLLOW_50_in_inlineRight1001 = new BitSet(new long[]{0x00002A80F8000000L});
    public static final BitSet FOLLOW_expr_in_inlineRight1003 = new BitSet(new long[]{0x00002A80F8000000L});
    public static final BitSet FOLLOW_expr_in_inlineRight1005 = new BitSet(new long[]{0x003FEA80FC000000L});
    public static final BitSet FOLLOW_51_in_inlineRight1007 = new BitSet(new long[]{0x0037EA80FC000000L});
    public static final BitSet FOLLOW_inline_in_inlineRight1010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_inlineRight1040 = new BitSet(new long[]{0x00002A80F8000000L});
    public static final BitSet FOLLOW_expr_in_inlineRight1044 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_inlineRight1046 = new BitSet(new long[]{0x00002B80F8000000L});
    public static final BitSet FOLLOW_left_in_inlineRight1051 = new BitSet(new long[]{0x00002A80F8000000L});
    public static final BitSet FOLLOW_expr_in_inlineRight1055 = new BitSet(new long[]{0x00002B80F8000000L});
    public static final BitSet FOLLOW_40_in_inlineRight1059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_inlineRight1088 = new BitSet(new long[]{0x00002A80F8000002L});
    public static final BitSet FOLLOW_expr_in_inlineRight1090 = new BitSet(new long[]{0x00002A80F8000002L});
    public static final BitSet FOLLOW_left_in_assign1133 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_assign1135 = new BitSet(new long[]{0x00002A80F8000000L});
    public static final BitSet FOLLOW_expr_in_assign1137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_apply1208 = new BitSet(new long[]{0x00002A80F8000002L});
    public static final BitSet FOLLOW_expr_in_apply1250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_module1282 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_moduleName_in_module1284 = new BitSet(new long[]{0x0100008000000002L});
    public static final BitSet FOLLOW_39_in_module1287 = new BitSet(new long[]{0x0000010008000000L});
    public static final BitSet FOLLOW_Symbol_in_module1291 = new BitSet(new long[]{0x0000010008000000L});
    public static final BitSet FOLLOW_40_in_module1294 = new BitSet(new long[]{0x0100008000000002L});
    public static final BitSet FOLLOW_56_in_module1305 = new BitSet(new long[]{0x0100008008000002L});
    public static final BitSet FOLLOW_moduleName_in_module1309 = new BitSet(new long[]{0x0100008008000002L});
    public static final BitSet FOLLOW_39_in_module1322 = new BitSet(new long[]{0x06002A80F8000000L});
    public static final BitSet FOLLOW_moduleDecl_in_module1326 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_module1328 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_57_in_moduleDecl1382 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_moduleDecl1387 = new BitSet(new long[]{0x00002B80F8000000L});
    public static final BitSet FOLLOW_assign_in_moduleDecl1389 = new BitSet(new long[]{0x00002B80F8000000L});
    public static final BitSet FOLLOW_40_in_moduleDecl1392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_moduleDecl1424 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_moduleDecl1426 = new BitSet(new long[]{0x00002B80F8000000L});
    public static final BitSet FOLLOW_expr_in_moduleDecl1429 = new BitSet(new long[]{0x00002A80F8000000L});
    public static final BitSet FOLLOW_expr_in_moduleDecl1431 = new BitSet(new long[]{0x00002B80F8000000L});
    public static final BitSet FOLLOW_40_in_moduleDecl1435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Symbol_in_moduleDecl1466 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_moduleDecl1471 = new BitSet(new long[]{0x00002B80F8000000L});
    public static final BitSet FOLLOW_left_in_moduleDecl1473 = new BitSet(new long[]{0x00002B80F8000000L});
    public static final BitSet FOLLOW_40_in_moduleDecl1476 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_moduleDecl1478 = new BitSet(new long[]{0x0037EA80FC000000L});
    public static final BitSet FOLLOW_inline_in_moduleDecl1480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_left_in_moduleDecl1502 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_moduleDecl1504 = new BitSet(new long[]{0x00002A80F8000000L});
    public static final BitSet FOLLOW_expr_in_moduleDecl1506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Symbol_in_moduleName1566 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_59_in_moduleName1569 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_Symbol_in_moduleName1571 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_delim_in_synpred1_Vitry186 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_synpred1_Vitry189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_delim_in_synpred2_Vitry245 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_synpred2_Vitry248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_apply_in_synpred3_Vitry739 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_Op_in_synpred3_Vitry741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_synpred4_Vitry1201 = new BitSet(new long[]{0x00002A80F8000000L});
    public static final BitSet FOLLOW_expr_in_synpred4_Vitry1203 = new BitSet(new long[]{0x0000000000000002L});

}