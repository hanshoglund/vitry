// $ANTLR 3.2 Sep 23, 2009 12:02:23 src/antlr/Vitry.g 2011-02-07 02:30:41
// See src/antlr/Vitry.g        
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Par", "Bra", "Ang", "Module", "Fn", "Let", "Where", "Assign", "Left", "Quote", "Apply", "Type", "If", "Match", "Loop", "Recur", "Do", "Ops", "TypeDecl", "ImplicitDecl", "FnDecl", "MemberDecl", "Op", "Symbol", "Natural", "Float", "Complex", "String", "Exponent", "Whitespace", "EscapeSeq", "HexDigit", "UnicodeEsc", "OctalEsc", "':'", "'('", "')'", "'['", "']'", "'{'", "'}'", "'`'", "'fn'", "'let'", "'loop'", "'do'", "'match'", "'if'", "'else'", "'recur'", "'='"
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
    public static final int T__51=51;
    public static final int Let=9;
    public static final int Assign=11;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
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
    public static final int T__41=41;
    public static final int FnDecl=24;
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
    // src/antlr/Vitry.g:62:1: expr : ( ( delim[true] ':' )=> delim[true] ':' expr -> ^( Type delim expr ) | delim[true] );
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
            // src/antlr/Vitry.g:63:5: ( ( delim[true] ':' )=> delim[true] ':' expr -> ^( Type delim expr ) | delim[true] )
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
                    // src/antlr/Vitry.g:63:7: ( delim[true] ':' )=> delim[true] ':' expr
                    {
                    pushFollow(FOLLOW_delim_in_expr237);
                    delim1=delim(true);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_delim.add(delim1.getTree());
                    char_literal2=(Token)match(input,38,FOLLOW_38_in_expr240); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_38.add(char_literal2);

                    pushFollow(FOLLOW_expr_in_expr242);
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
                    // 63:52: -> ^( Type delim expr )
                    {
                        // src/antlr/Vitry.g:63:55: ^( Type delim expr )
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
                    // src/antlr/Vitry.g:64:7: delim[true]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_delim_in_expr263);
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
    // src/antlr/Vitry.g:71:1: left : ( ( delim[false] ':' )=> delim[false] ':' expr -> ^( Left ^( Type delim expr ) ) | delim[false] -> ^( Left delim ) );
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
            // src/antlr/Vitry.g:72:5: ( ( delim[false] ':' )=> delim[false] ':' expr -> ^( Left ^( Type delim expr ) ) | delim[false] -> ^( Left delim ) )
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
                    // src/antlr/Vitry.g:72:7: ( delim[false] ':' )=> delim[false] ':' expr
                    {
                    pushFollow(FOLLOW_delim_in_left296);
                    delim5=delim(false);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_delim.add(delim5.getTree());
                    char_literal6=(Token)match(input,38,FOLLOW_38_in_left299); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_38.add(char_literal6);

                    pushFollow(FOLLOW_expr_in_left301);
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
                    // 72:52: -> ^( Left ^( Type delim expr ) )
                    {
                        // src/antlr/Vitry.g:72:55: ^( Left ^( Type delim expr ) )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Left, "Left"), root_1);

                        // src/antlr/Vitry.g:72:62: ^( Type delim expr )
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
                    // src/antlr/Vitry.g:73:7: delim[false]
                    {
                    pushFollow(FOLLOW_delim_in_left324);
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
                    // 73:52: -> ^( Left delim )
                    {
                        // src/antlr/Vitry.g:73:55: ^( Left delim )
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
    // src/antlr/Vitry.g:79:1: delim[boolean rs] : ( '(' ( inline[rs] )? ')' -> ^( Par ( inline )? ) | '[' ( inline[rs] )? ']' -> ^( Bra ( inline )? ) | '{' ( inline[rs] )? '}' -> ^( Ang ( inline )? ) | '`' Op -> ^( Quote Op ) | '`' delim[rs] -> ^( Quote delim ) | atom );
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
            // src/antlr/Vitry.g:80:5: ( '(' ( inline[rs] )? ')' -> ^( Par ( inline )? ) | '[' ( inline[rs] )? ']' -> ^( Bra ( inline )? ) | '{' ( inline[rs] )? '}' -> ^( Ang ( inline )? ) | '`' Op -> ^( Quote Op ) | '`' delim[rs] -> ^( Quote delim ) | atom )
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
                    // src/antlr/Vitry.g:80:7: '(' ( inline[rs] )? ')'
                    {
                    char_literal9=(Token)match(input,39,FOLLOW_39_in_delim386); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_39.add(char_literal9);

                    // src/antlr/Vitry.g:80:11: ( inline[rs] )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( ((LA3_0>=Op && LA3_0<=String)||LA3_0==39||LA3_0==41||LA3_0==43||(LA3_0>=45 && LA3_0<=51)||LA3_0==53) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // src/antlr/Vitry.g:80:11: inline[rs]
                            {
                            pushFollow(FOLLOW_inline_in_delim388);
                            inline10=inline(rs);

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_inline.add(inline10.getTree());

                            }
                            break;

                    }

                    char_literal11=(Token)match(input,40,FOLLOW_40_in_delim392); if (state.failed) return retval; 
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
                    // 80:33: -> ^( Par ( inline )? )
                    {
                        // src/antlr/Vitry.g:80:36: ^( Par ( inline )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Par, "Par"), root_1);

                        // src/antlr/Vitry.g:80:42: ( inline )?
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
                    // src/antlr/Vitry.g:81:7: '[' ( inline[rs] )? ']'
                    {
                    char_literal12=(Token)match(input,41,FOLLOW_41_in_delim415); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_41.add(char_literal12);

                    // src/antlr/Vitry.g:81:11: ( inline[rs] )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( ((LA4_0>=Op && LA4_0<=String)||LA4_0==39||LA4_0==41||LA4_0==43||(LA4_0>=45 && LA4_0<=51)||LA4_0==53) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // src/antlr/Vitry.g:81:11: inline[rs]
                            {
                            pushFollow(FOLLOW_inline_in_delim417);
                            inline13=inline(rs);

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_inline.add(inline13.getTree());

                            }
                            break;

                    }

                    char_literal14=(Token)match(input,42,FOLLOW_42_in_delim421); if (state.failed) return retval; 
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
                    // 81:33: -> ^( Bra ( inline )? )
                    {
                        // src/antlr/Vitry.g:81:36: ^( Bra ( inline )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Bra, "Bra"), root_1);

                        // src/antlr/Vitry.g:81:42: ( inline )?
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
                    // src/antlr/Vitry.g:82:7: '{' ( inline[rs] )? '}'
                    {
                    char_literal15=(Token)match(input,43,FOLLOW_43_in_delim444); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_43.add(char_literal15);

                    // src/antlr/Vitry.g:82:11: ( inline[rs] )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( ((LA5_0>=Op && LA5_0<=String)||LA5_0==39||LA5_0==41||LA5_0==43||(LA5_0>=45 && LA5_0<=51)||LA5_0==53) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // src/antlr/Vitry.g:82:11: inline[rs]
                            {
                            pushFollow(FOLLOW_inline_in_delim446);
                            inline16=inline(rs);

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_inline.add(inline16.getTree());

                            }
                            break;

                    }

                    char_literal17=(Token)match(input,44,FOLLOW_44_in_delim450); if (state.failed) return retval; 
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
                    // 82:33: -> ^( Ang ( inline )? )
                    {
                        // src/antlr/Vitry.g:82:36: ^( Ang ( inline )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Ang, "Ang"), root_1);

                        // src/antlr/Vitry.g:82:42: ( inline )?
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
                    // src/antlr/Vitry.g:83:7: '`' Op
                    {
                    char_literal18=(Token)match(input,45,FOLLOW_45_in_delim473); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_45.add(char_literal18);

                    Op19=(Token)match(input,Op,FOLLOW_Op_in_delim475); if (state.failed) return retval; 
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
                    // 83:33: -> ^( Quote Op )
                    {
                        // src/antlr/Vitry.g:83:36: ^( Quote Op )
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
                    // src/antlr/Vitry.g:84:7: '`' delim[rs]
                    {
                    char_literal20=(Token)match(input,45,FOLLOW_45_in_delim510); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_45.add(char_literal20);

                    pushFollow(FOLLOW_delim_in_delim512);
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
                    // 84:33: -> ^( Quote delim )
                    {
                        // src/antlr/Vitry.g:84:36: ^( Quote delim )
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
                    // src/antlr/Vitry.g:85:7: atom
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_atom_in_delim541);
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
    // src/antlr/Vitry.g:88:1: atom : ( Symbol | Natural | Float | Complex | String );
    public final VitryParser.atom_return atom() throws RecognitionException {
        VitryParser.atom_return retval = new VitryParser.atom_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set23=null;

        Object set23_tree=null;

        try {
            // src/antlr/Vitry.g:89:5: ( Symbol | Natural | Float | Complex | String )
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
    // src/antlr/Vitry.g:99:1: inline[boolean rs] : ({...}? inlineRight | ( Op )=> Op | ( Op apply )+ -> ^( Ops ( ^( Op ( apply )? ) )+ ) | ( apply Op )=>e+= apply ( Op (f+= apply )? )+ -> ^( Ops $e ( ^( Op $f) )+ ) | apply );
    public final VitryParser.inline_return inline(boolean rs) throws RecognitionException {
        VitryParser.inline_return retval = new VitryParser.inline_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Op25=null;
        Token Op26=null;
        Token Op28=null;
        List list_e=null;
        List list_f=null;
        VitryParser.inlineRight_return inlineRight24 = null;

        VitryParser.apply_return apply27 = null;

        VitryParser.apply_return apply29 = null;

        RuleReturnScope e = null;
        RuleReturnScope f = null;
        Object Op25_tree=null;
        Object Op26_tree=null;
        Object Op28_tree=null;
        RewriteRuleTokenStream stream_Op=new RewriteRuleTokenStream(adaptor,"token Op");
        RewriteRuleSubtreeStream stream_apply=new RewriteRuleSubtreeStream(adaptor,"rule apply");
        try {
            // src/antlr/Vitry.g:100:5: ({...}? inlineRight | ( Op )=> Op | ( Op apply )+ -> ^( Ops ( ^( Op ( apply )? ) )+ ) | ( apply Op )=>e+= apply ( Op (f+= apply )? )+ -> ^( Ops $e ( ^( Op $f) )+ ) | apply )
            int alt10=5;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // src/antlr/Vitry.g:100:7: {...}? inlineRight
                    {
                    root_0 = (Object)adaptor.nil();

                    if ( !((rs)) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "inline", "$rs");
                    }
                    pushFollow(FOLLOW_inlineRight_in_inline616);
                    inlineRight24=inlineRight();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, inlineRight24.getTree());

                    }
                    break;
                case 2 :
                    // src/antlr/Vitry.g:101:7: ( Op )=> Op
                    {
                    root_0 = (Object)adaptor.nil();

                    Op25=(Token)match(input,Op,FOLLOW_Op_in_inline630); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Op25_tree = (Object)adaptor.create(Op25);
                    adaptor.addChild(root_0, Op25_tree);
                    }

                    }
                    break;
                case 3 :
                    // src/antlr/Vitry.g:102:7: ( Op apply )+
                    {
                    // src/antlr/Vitry.g:102:7: ( Op apply )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==Op) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:102:8: Op apply
                    	    {
                    	    Op26=(Token)match(input,Op,FOLLOW_Op_in_inline639); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_Op.add(Op26);

                    	    pushFollow(FOLLOW_apply_in_inline641);
                    	    apply27=apply();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_apply.add(apply27.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt7 >= 1 ) break loop7;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(7, input);
                                throw eee;
                        }
                        cnt7++;
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
                    // 102:52: -> ^( Ops ( ^( Op ( apply )? ) )+ )
                    {
                        // src/antlr/Vitry.g:102:55: ^( Ops ( ^( Op ( apply )? ) )+ )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Ops, "Ops"), root_1);

                        if ( !(stream_Op.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_Op.hasNext() ) {
                            // src/antlr/Vitry.g:102:61: ^( Op ( apply )? )
                            {
                            Object root_2 = (Object)adaptor.nil();
                            root_2 = (Object)adaptor.becomeRoot(stream_Op.nextNode(), root_2);

                            // src/antlr/Vitry.g:102:66: ( apply )?
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
                case 4 :
                    // src/antlr/Vitry.g:103:7: ( apply Op )=>e+= apply ( Op (f+= apply )? )+
                    {
                    pushFollow(FOLLOW_apply_in_inline708);
                    e=apply();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_apply.add(e.getTree());
                    if (list_e==null) list_e=new ArrayList();
                    list_e.add(e.getTree());

                    // src/antlr/Vitry.g:103:30: ( Op (f+= apply )? )+
                    int cnt9=0;
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==Op) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:103:31: Op (f+= apply )?
                    	    {
                    	    Op28=(Token)match(input,Op,FOLLOW_Op_in_inline711); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_Op.add(Op28);

                    	    // src/antlr/Vitry.g:103:35: (f+= apply )?
                    	    int alt8=2;
                    	    int LA8_0 = input.LA(1);

                    	    if ( ((LA8_0>=Symbol && LA8_0<=String)||LA8_0==39||LA8_0==41||LA8_0==43||LA8_0==45) ) {
                    	        alt8=1;
                    	    }
                    	    switch (alt8) {
                    	        case 1 :
                    	            // src/antlr/Vitry.g:103:35: f+= apply
                    	            {
                    	            pushFollow(FOLLOW_apply_in_inline715);
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
                    	    if ( cnt9 >= 1 ) break loop9;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(9, input);
                                throw eee;
                        }
                        cnt9++;
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
                    // 103:52: -> ^( Ops $e ( ^( Op $f) )+ )
                    {
                        // src/antlr/Vitry.g:103:55: ^( Ops $e ( ^( Op $f) )+ )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Ops, "Ops"), root_1);

                        adaptor.addChild(root_1, stream_e.nextTree());
                        if ( !(stream_Op.hasNext()||stream_f.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_Op.hasNext()||stream_f.hasNext() ) {
                            // src/antlr/Vitry.g:103:64: ^( Op $f)
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
                case 5 :
                    // src/antlr/Vitry.g:104:7: apply
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_apply_in_inline749);
                    apply29=apply();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, apply29.getTree());

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
    // src/antlr/Vitry.g:116:1: inlineRight : ( 'fn' '(' ( left )* ')' inline[true] -> ^( Fn ( left )* inline ) | 'fn' '[' ( left )* ']' inline[true] -> ^( Fn ( left )* inline ) | 'let' '(' ( assign )* ')' inline[true] -> ^( Let ( assign )* inline ) | 'let' '[' ( assign )* ']' inline[true] -> ^( Let ( assign )* inline ) | 'loop' '(' ( assign )* ')' inline[true] -> ^( Loop ( assign )* inline ) | 'loop' '[' ( assign )* ']' inline[true] -> ^( Loop ( assign )* inline ) | 'do' '(' ( assign )* ')' ( expr )* -> ^( Do ( assign )* ( expr )* ) | 'do' '[' ( assign )* ']' ( expr )* -> ^( Do ( assign )* ( expr )* ) | 'match' v= expr '(' (c+= left e+= expr )* ')' -> ^( Match $v ( ^( $c $e) )* ) | 'if' expr expr ( 'else' )? inline[true] -> ^( If expr expr inline ) | 'recur' ( expr )* -> ^( Recur ( expr )* ) );
    public final VitryParser.inlineRight_return inlineRight() throws RecognitionException {
        VitryParser.inlineRight_return retval = new VitryParser.inlineRight_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal30=null;
        Token char_literal31=null;
        Token char_literal33=null;
        Token string_literal35=null;
        Token char_literal36=null;
        Token char_literal38=null;
        Token string_literal40=null;
        Token char_literal41=null;
        Token char_literal43=null;
        Token string_literal45=null;
        Token char_literal46=null;
        Token char_literal48=null;
        Token string_literal50=null;
        Token char_literal51=null;
        Token char_literal53=null;
        Token string_literal55=null;
        Token char_literal56=null;
        Token char_literal58=null;
        Token string_literal60=null;
        Token char_literal61=null;
        Token char_literal63=null;
        Token string_literal65=null;
        Token char_literal66=null;
        Token char_literal68=null;
        Token string_literal70=null;
        Token char_literal71=null;
        Token char_literal72=null;
        Token string_literal73=null;
        Token string_literal76=null;
        Token string_literal78=null;
        List list_c=null;
        List list_e=null;
        VitryParser.expr_return v = null;

        VitryParser.left_return left32 = null;

        VitryParser.inline_return inline34 = null;

        VitryParser.left_return left37 = null;

        VitryParser.inline_return inline39 = null;

        VitryParser.assign_return assign42 = null;

        VitryParser.inline_return inline44 = null;

        VitryParser.assign_return assign47 = null;

        VitryParser.inline_return inline49 = null;

        VitryParser.assign_return assign52 = null;

        VitryParser.inline_return inline54 = null;

        VitryParser.assign_return assign57 = null;

        VitryParser.inline_return inline59 = null;

        VitryParser.assign_return assign62 = null;

        VitryParser.expr_return expr64 = null;

        VitryParser.assign_return assign67 = null;

        VitryParser.expr_return expr69 = null;

        VitryParser.expr_return expr74 = null;

        VitryParser.expr_return expr75 = null;

        VitryParser.inline_return inline77 = null;

        VitryParser.expr_return expr79 = null;

        RuleReturnScope c = null;
        RuleReturnScope e = null;
        Object string_literal30_tree=null;
        Object char_literal31_tree=null;
        Object char_literal33_tree=null;
        Object string_literal35_tree=null;
        Object char_literal36_tree=null;
        Object char_literal38_tree=null;
        Object string_literal40_tree=null;
        Object char_literal41_tree=null;
        Object char_literal43_tree=null;
        Object string_literal45_tree=null;
        Object char_literal46_tree=null;
        Object char_literal48_tree=null;
        Object string_literal50_tree=null;
        Object char_literal51_tree=null;
        Object char_literal53_tree=null;
        Object string_literal55_tree=null;
        Object char_literal56_tree=null;
        Object char_literal58_tree=null;
        Object string_literal60_tree=null;
        Object char_literal61_tree=null;
        Object char_literal63_tree=null;
        Object string_literal65_tree=null;
        Object char_literal66_tree=null;
        Object char_literal68_tree=null;
        Object string_literal70_tree=null;
        Object char_literal71_tree=null;
        Object char_literal72_tree=null;
        Object string_literal73_tree=null;
        Object string_literal76_tree=null;
        Object string_literal78_tree=null;
        RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
        RewriteRuleTokenStream stream_48=new RewriteRuleTokenStream(adaptor,"token 48");
        RewriteRuleTokenStream stream_42=new RewriteRuleTokenStream(adaptor,"token 42");
        RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
        RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
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
            // src/antlr/Vitry.g:117:5: ( 'fn' '(' ( left )* ')' inline[true] -> ^( Fn ( left )* inline ) | 'fn' '[' ( left )* ']' inline[true] -> ^( Fn ( left )* inline ) | 'let' '(' ( assign )* ')' inline[true] -> ^( Let ( assign )* inline ) | 'let' '[' ( assign )* ']' inline[true] -> ^( Let ( assign )* inline ) | 'loop' '(' ( assign )* ')' inline[true] -> ^( Loop ( assign )* inline ) | 'loop' '[' ( assign )* ']' inline[true] -> ^( Loop ( assign )* inline ) | 'do' '(' ( assign )* ')' ( expr )* -> ^( Do ( assign )* ( expr )* ) | 'do' '[' ( assign )* ']' ( expr )* -> ^( Do ( assign )* ( expr )* ) | 'match' v= expr '(' (c+= left e+= expr )* ')' -> ^( Match $v ( ^( $c $e) )* ) | 'if' expr expr ( 'else' )? inline[true] -> ^( If expr expr inline ) | 'recur' ( expr )* -> ^( Recur ( expr )* ) )
            int alt24=11;
            alt24 = dfa24.predict(input);
            switch (alt24) {
                case 1 :
                    // src/antlr/Vitry.g:117:7: 'fn' '(' ( left )* ')' inline[true]
                    {
                    string_literal30=(Token)match(input,46,FOLLOW_46_in_inlineRight790); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_46.add(string_literal30);

                    char_literal31=(Token)match(input,39,FOLLOW_39_in_inlineRight794); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_39.add(char_literal31);

                    // src/antlr/Vitry.g:117:18: ( left )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( ((LA11_0>=Symbol && LA11_0<=String)||LA11_0==39||LA11_0==41||LA11_0==43||LA11_0==45) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:117:18: left
                    	    {
                    	    pushFollow(FOLLOW_left_in_inlineRight796);
                    	    left32=left();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_left.add(left32.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);

                    char_literal33=(Token)match(input,40,FOLLOW_40_in_inlineRight801); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(char_literal33);

                    pushFollow(FOLLOW_inline_in_inlineRight803);
                    inline34=inline(true);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_inline.add(inline34.getTree());


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
                    // 117:56: -> ^( Fn ( left )* inline )
                    {
                        // src/antlr/Vitry.g:117:59: ^( Fn ( left )* inline )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Fn, "Fn"), root_1);

                        // src/antlr/Vitry.g:117:64: ( left )*
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
                    // src/antlr/Vitry.g:118:7: 'fn' '[' ( left )* ']' inline[true]
                    {
                    string_literal35=(Token)match(input,46,FOLLOW_46_in_inlineRight836); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_46.add(string_literal35);

                    char_literal36=(Token)match(input,41,FOLLOW_41_in_inlineRight840); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_41.add(char_literal36);

                    // src/antlr/Vitry.g:118:18: ( left )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( ((LA12_0>=Symbol && LA12_0<=String)||LA12_0==39||LA12_0==41||LA12_0==43||LA12_0==45) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:118:18: left
                    	    {
                    	    pushFollow(FOLLOW_left_in_inlineRight842);
                    	    left37=left();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_left.add(left37.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    char_literal38=(Token)match(input,42,FOLLOW_42_in_inlineRight847); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_42.add(char_literal38);

                    pushFollow(FOLLOW_inline_in_inlineRight849);
                    inline39=inline(true);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_inline.add(inline39.getTree());


                    // AST REWRITE
                    // elements: inline, left
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 118:56: -> ^( Fn ( left )* inline )
                    {
                        // src/antlr/Vitry.g:118:59: ^( Fn ( left )* inline )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Fn, "Fn"), root_1);

                        // src/antlr/Vitry.g:118:64: ( left )*
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
                case 3 :
                    // src/antlr/Vitry.g:119:7: 'let' '(' ( assign )* ')' inline[true]
                    {
                    string_literal40=(Token)match(input,47,FOLLOW_47_in_inlineRight882); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_47.add(string_literal40);

                    char_literal41=(Token)match(input,39,FOLLOW_39_in_inlineRight885); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_39.add(char_literal41);

                    // src/antlr/Vitry.g:119:18: ( assign )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( ((LA13_0>=Symbol && LA13_0<=String)||LA13_0==39||LA13_0==41||LA13_0==43||LA13_0==45) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:119:18: assign
                    	    {
                    	    pushFollow(FOLLOW_assign_in_inlineRight887);
                    	    assign42=assign();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_assign.add(assign42.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    char_literal43=(Token)match(input,40,FOLLOW_40_in_inlineRight890); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(char_literal43);

                    pushFollow(FOLLOW_inline_in_inlineRight892);
                    inline44=inline(true);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_inline.add(inline44.getTree());


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
                    // 119:56: -> ^( Let ( assign )* inline )
                    {
                        // src/antlr/Vitry.g:119:59: ^( Let ( assign )* inline )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Let, "Let"), root_1);

                        // src/antlr/Vitry.g:119:65: ( assign )*
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
                    // src/antlr/Vitry.g:120:7: 'let' '[' ( assign )* ']' inline[true]
                    {
                    string_literal45=(Token)match(input,47,FOLLOW_47_in_inlineRight925); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_47.add(string_literal45);

                    char_literal46=(Token)match(input,41,FOLLOW_41_in_inlineRight928); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_41.add(char_literal46);

                    // src/antlr/Vitry.g:120:18: ( assign )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( ((LA14_0>=Symbol && LA14_0<=String)||LA14_0==39||LA14_0==41||LA14_0==43||LA14_0==45) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:120:18: assign
                    	    {
                    	    pushFollow(FOLLOW_assign_in_inlineRight930);
                    	    assign47=assign();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_assign.add(assign47.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    char_literal48=(Token)match(input,42,FOLLOW_42_in_inlineRight933); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_42.add(char_literal48);

                    pushFollow(FOLLOW_inline_in_inlineRight935);
                    inline49=inline(true);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_inline.add(inline49.getTree());


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
                    // 120:56: -> ^( Let ( assign )* inline )
                    {
                        // src/antlr/Vitry.g:120:59: ^( Let ( assign )* inline )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Let, "Let"), root_1);

                        // src/antlr/Vitry.g:120:65: ( assign )*
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
                case 5 :
                    // src/antlr/Vitry.g:121:7: 'loop' '(' ( assign )* ')' inline[true]
                    {
                    string_literal50=(Token)match(input,48,FOLLOW_48_in_inlineRight968); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_48.add(string_literal50);

                    char_literal51=(Token)match(input,39,FOLLOW_39_in_inlineRight970); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_39.add(char_literal51);

                    // src/antlr/Vitry.g:121:18: ( assign )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( ((LA15_0>=Symbol && LA15_0<=String)||LA15_0==39||LA15_0==41||LA15_0==43||LA15_0==45) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:121:18: assign
                    	    {
                    	    pushFollow(FOLLOW_assign_in_inlineRight972);
                    	    assign52=assign();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_assign.add(assign52.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);

                    char_literal53=(Token)match(input,40,FOLLOW_40_in_inlineRight975); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(char_literal53);

                    pushFollow(FOLLOW_inline_in_inlineRight977);
                    inline54=inline(true);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_inline.add(inline54.getTree());


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
                    // 121:56: -> ^( Loop ( assign )* inline )
                    {
                        // src/antlr/Vitry.g:121:59: ^( Loop ( assign )* inline )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Loop, "Loop"), root_1);

                        // src/antlr/Vitry.g:121:66: ( assign )*
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
                case 6 :
                    // src/antlr/Vitry.g:122:7: 'loop' '[' ( assign )* ']' inline[true]
                    {
                    string_literal55=(Token)match(input,48,FOLLOW_48_in_inlineRight1010); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_48.add(string_literal55);

                    char_literal56=(Token)match(input,41,FOLLOW_41_in_inlineRight1012); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_41.add(char_literal56);

                    // src/antlr/Vitry.g:122:18: ( assign )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( ((LA16_0>=Symbol && LA16_0<=String)||LA16_0==39||LA16_0==41||LA16_0==43||LA16_0==45) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:122:18: assign
                    	    {
                    	    pushFollow(FOLLOW_assign_in_inlineRight1014);
                    	    assign57=assign();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_assign.add(assign57.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);

                    char_literal58=(Token)match(input,42,FOLLOW_42_in_inlineRight1017); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_42.add(char_literal58);

                    pushFollow(FOLLOW_inline_in_inlineRight1019);
                    inline59=inline(true);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_inline.add(inline59.getTree());


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
                    // 122:56: -> ^( Loop ( assign )* inline )
                    {
                        // src/antlr/Vitry.g:122:59: ^( Loop ( assign )* inline )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Loop, "Loop"), root_1);

                        // src/antlr/Vitry.g:122:66: ( assign )*
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
                case 7 :
                    // src/antlr/Vitry.g:123:7: 'do' '(' ( assign )* ')' ( expr )*
                    {
                    string_literal60=(Token)match(input,49,FOLLOW_49_in_inlineRight1052); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_49.add(string_literal60);

                    char_literal61=(Token)match(input,39,FOLLOW_39_in_inlineRight1056); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_39.add(char_literal61);

                    // src/antlr/Vitry.g:123:18: ( assign )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( ((LA17_0>=Symbol && LA17_0<=String)||LA17_0==39||LA17_0==41||LA17_0==43||LA17_0==45) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:123:18: assign
                    	    {
                    	    pushFollow(FOLLOW_assign_in_inlineRight1058);
                    	    assign62=assign();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_assign.add(assign62.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);

                    char_literal63=(Token)match(input,40,FOLLOW_40_in_inlineRight1061); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(char_literal63);

                    // src/antlr/Vitry.g:123:30: ( expr )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( ((LA18_0>=Symbol && LA18_0<=String)||LA18_0==39||LA18_0==41||LA18_0==43||LA18_0==45) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:123:30: expr
                    	    {
                    	    pushFollow(FOLLOW_expr_in_inlineRight1063);
                    	    expr64=expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_expr.add(expr64.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop18;
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
                    // 123:56: -> ^( Do ( assign )* ( expr )* )
                    {
                        // src/antlr/Vitry.g:123:59: ^( Do ( assign )* ( expr )* )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Do, "Do"), root_1);

                        // src/antlr/Vitry.g:123:64: ( assign )*
                        while ( stream_assign.hasNext() ) {
                            adaptor.addChild(root_1, stream_assign.nextTree());

                        }
                        stream_assign.reset();
                        // src/antlr/Vitry.g:123:72: ( expr )*
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
                case 8 :
                    // src/antlr/Vitry.g:124:7: 'do' '[' ( assign )* ']' ( expr )*
                    {
                    string_literal65=(Token)match(input,49,FOLLOW_49_in_inlineRight1104); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_49.add(string_literal65);

                    char_literal66=(Token)match(input,41,FOLLOW_41_in_inlineRight1108); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_41.add(char_literal66);

                    // src/antlr/Vitry.g:124:18: ( assign )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( ((LA19_0>=Symbol && LA19_0<=String)||LA19_0==39||LA19_0==41||LA19_0==43||LA19_0==45) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:124:18: assign
                    	    {
                    	    pushFollow(FOLLOW_assign_in_inlineRight1110);
                    	    assign67=assign();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_assign.add(assign67.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);

                    char_literal68=(Token)match(input,42,FOLLOW_42_in_inlineRight1113); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_42.add(char_literal68);

                    // src/antlr/Vitry.g:124:30: ( expr )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( ((LA20_0>=Symbol && LA20_0<=String)||LA20_0==39||LA20_0==41||LA20_0==43||LA20_0==45) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:124:30: expr
                    	    {
                    	    pushFollow(FOLLOW_expr_in_inlineRight1115);
                    	    expr69=expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_expr.add(expr69.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);



                    // AST REWRITE
                    // elements: expr, assign
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 124:56: -> ^( Do ( assign )* ( expr )* )
                    {
                        // src/antlr/Vitry.g:124:59: ^( Do ( assign )* ( expr )* )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Do, "Do"), root_1);

                        // src/antlr/Vitry.g:124:64: ( assign )*
                        while ( stream_assign.hasNext() ) {
                            adaptor.addChild(root_1, stream_assign.nextTree());

                        }
                        stream_assign.reset();
                        // src/antlr/Vitry.g:124:72: ( expr )*
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
                case 9 :
                    // src/antlr/Vitry.g:125:7: 'match' v= expr '(' (c+= left e+= expr )* ')'
                    {
                    string_literal70=(Token)match(input,50,FOLLOW_50_in_inlineRight1156); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_50.add(string_literal70);

                    pushFollow(FOLLOW_expr_in_inlineRight1160);
                    v=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(v.getTree());
                    char_literal71=(Token)match(input,39,FOLLOW_39_in_inlineRight1162); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_39.add(char_literal71);

                    // src/antlr/Vitry.g:125:26: (c+= left e+= expr )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( ((LA21_0>=Symbol && LA21_0<=String)||LA21_0==39||LA21_0==41||LA21_0==43||LA21_0==45) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:125:27: c+= left e+= expr
                    	    {
                    	    pushFollow(FOLLOW_left_in_inlineRight1167);
                    	    c=left();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_left.add(c.getTree());
                    	    if (list_c==null) list_c=new ArrayList();
                    	    list_c.add(c.getTree());

                    	    pushFollow(FOLLOW_expr_in_inlineRight1171);
                    	    e=expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_expr.add(e.getTree());
                    	    if (list_e==null) list_e=new ArrayList();
                    	    list_e.add(e.getTree());


                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);

                    char_literal72=(Token)match(input,40,FOLLOW_40_in_inlineRight1175); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(char_literal72);



                    // AST REWRITE
                    // elements: v, c, e
                    // token labels: 
                    // rule labels: v, retval
                    // token list labels: 
                    // rule list labels: e, c
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_v=new RewriteRuleSubtreeStream(adaptor,"rule v",v!=null?v.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_e=new RewriteRuleSubtreeStream(adaptor,"token e",list_e);
                    RewriteRuleSubtreeStream stream_c=new RewriteRuleSubtreeStream(adaptor,"token c",list_c);
                    root_0 = (Object)adaptor.nil();
                    // 125:56: -> ^( Match $v ( ^( $c $e) )* )
                    {
                        // src/antlr/Vitry.g:125:59: ^( Match $v ( ^( $c $e) )* )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Match, "Match"), root_1);

                        adaptor.addChild(root_1, stream_v.nextTree());
                        // src/antlr/Vitry.g:125:70: ( ^( $c $e) )*
                        while ( stream_c.hasNext()||stream_e.hasNext() ) {
                            // src/antlr/Vitry.g:125:70: ^( $c $e)
                            {
                            Object root_2 = (Object)adaptor.nil();
                            root_2 = (Object)adaptor.becomeRoot(stream_c.nextNode(), root_2);

                            adaptor.addChild(root_2, stream_e.nextTree());

                            adaptor.addChild(root_1, root_2);
                            }

                        }
                        stream_c.reset();
                        stream_e.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 10 :
                    // src/antlr/Vitry.g:126:7: 'if' expr expr ( 'else' )? inline[true]
                    {
                    string_literal73=(Token)match(input,51,FOLLOW_51_in_inlineRight1212); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_51.add(string_literal73);

                    pushFollow(FOLLOW_expr_in_inlineRight1214);
                    expr74=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr74.getTree());
                    pushFollow(FOLLOW_expr_in_inlineRight1216);
                    expr75=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr75.getTree());
                    // src/antlr/Vitry.g:126:22: ( 'else' )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==52) ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // src/antlr/Vitry.g:126:22: 'else'
                            {
                            string_literal76=(Token)match(input,52,FOLLOW_52_in_inlineRight1218); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_52.add(string_literal76);


                            }
                            break;

                    }

                    pushFollow(FOLLOW_inline_in_inlineRight1221);
                    inline77=inline(true);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_inline.add(inline77.getTree());


                    // AST REWRITE
                    // elements: expr, inline, expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 126:56: -> ^( If expr expr inline )
                    {
                        // src/antlr/Vitry.g:126:59: ^( If expr expr inline )
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
                case 11 :
                    // src/antlr/Vitry.g:127:7: 'recur' ( expr )*
                    {
                    string_literal78=(Token)match(input,53,FOLLOW_53_in_inlineRight1255); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_53.add(string_literal78);

                    // src/antlr/Vitry.g:127:15: ( expr )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( ((LA23_0>=Symbol && LA23_0<=String)||LA23_0==39||LA23_0==41||LA23_0==43||LA23_0==45) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:127:15: expr
                    	    {
                    	    pushFollow(FOLLOW_expr_in_inlineRight1257);
                    	    expr79=expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_expr.add(expr79.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop23;
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
                    // 127:39: -> ^( Recur ( expr )* )
                    {
                        // src/antlr/Vitry.g:127:42: ^( Recur ( expr )* )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Recur, "Recur"), root_1);

                        // src/antlr/Vitry.g:127:50: ( expr )*
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
    // src/antlr/Vitry.g:130:1: assign : left '=' expr -> ^( Assign left expr ) ;
    public final VitryParser.assign_return assign() throws RecognitionException {
        VitryParser.assign_return retval = new VitryParser.assign_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal81=null;
        VitryParser.left_return left80 = null;

        VitryParser.expr_return expr82 = null;


        Object char_literal81_tree=null;
        RewriteRuleTokenStream stream_54=new RewriteRuleTokenStream(adaptor,"token 54");
        RewriteRuleSubtreeStream stream_left=new RewriteRuleSubtreeStream(adaptor,"rule left");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // src/antlr/Vitry.g:131:5: ( left '=' expr -> ^( Assign left expr ) )
            // src/antlr/Vitry.g:131:7: left '=' expr
            {
            pushFollow(FOLLOW_left_in_assign1302);
            left80=left();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_left.add(left80.getTree());
            char_literal81=(Token)match(input,54,FOLLOW_54_in_assign1304); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_54.add(char_literal81);

            pushFollow(FOLLOW_expr_in_assign1306);
            expr82=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expr.add(expr82.getTree());


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
            // 131:52: -> ^( Assign left expr )
            {
                // src/antlr/Vitry.g:131:55: ^( Assign left expr )
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
    // src/antlr/Vitry.g:135:1: apply : ( ( expr expr )=> ( expr )+ -> ^( Apply ( expr )+ ) | expr );
    public final VitryParser.apply_return apply() throws RecognitionException {
        VitryParser.apply_return retval = new VitryParser.apply_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        VitryParser.expr_return expr83 = null;

        VitryParser.expr_return expr84 = null;


        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // src/antlr/Vitry.g:136:5: ( ( expr expr )=> ( expr )+ -> ^( Apply ( expr )+ ) | expr )
            int alt26=2;
            switch ( input.LA(1) ) {
            case 39:
                {
                int LA26_1 = input.LA(2);

                if ( (synpred5_Vitry()) ) {
                    alt26=1;
                }
                else if ( (true) ) {
                    alt26=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 26, 1, input);

                    throw nvae;
                }
                }
                break;
            case 41:
                {
                int LA26_2 = input.LA(2);

                if ( (synpred5_Vitry()) ) {
                    alt26=1;
                }
                else if ( (true) ) {
                    alt26=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 26, 2, input);

                    throw nvae;
                }
                }
                break;
            case 43:
                {
                int LA26_3 = input.LA(2);

                if ( (synpred5_Vitry()) ) {
                    alt26=1;
                }
                else if ( (true) ) {
                    alt26=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 26, 3, input);

                    throw nvae;
                }
                }
                break;
            case 45:
                {
                int LA26_4 = input.LA(2);

                if ( (synpred5_Vitry()) ) {
                    alt26=1;
                }
                else if ( (true) ) {
                    alt26=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 26, 4, input);

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
                int LA26_5 = input.LA(2);

                if ( (synpred5_Vitry()) ) {
                    alt26=1;
                }
                else if ( (true) ) {
                    alt26=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 26, 5, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // src/antlr/Vitry.g:136:7: ( expr expr )=> ( expr )+
                    {
                    // src/antlr/Vitry.g:136:22: ( expr )+
                    int cnt25=0;
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( ((LA25_0>=Symbol && LA25_0<=String)||LA25_0==39||LA25_0==41||LA25_0==43||LA25_0==45) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:136:22: expr
                    	    {
                    	    pushFollow(FOLLOW_expr_in_apply1377);
                    	    expr83=expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_expr.add(expr83.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt25 >= 1 ) break loop25;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(25, input);
                                throw eee;
                        }
                        cnt25++;
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
                    // 136:52: -> ^( Apply ( expr )+ )
                    {
                        // src/antlr/Vitry.g:136:55: ^( Apply ( expr )+ )
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
                    // src/antlr/Vitry.g:137:7: expr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_expr_in_apply1419);
                    expr84=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr84.getTree());

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

    // $ANTLR start synpred1_Vitry
    public final void synpred1_Vitry_fragment() throws RecognitionException {   
        // src/antlr/Vitry.g:63:7: ( delim[true] ':' )
        // src/antlr/Vitry.g:63:8: delim[true] ':'
        {
        pushFollow(FOLLOW_delim_in_synpred1_Vitry229);
        delim(true);

        state._fsp--;
        if (state.failed) return ;
        match(input,38,FOLLOW_38_in_synpred1_Vitry232); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_Vitry

    // $ANTLR start synpred2_Vitry
    public final void synpred2_Vitry_fragment() throws RecognitionException {   
        // src/antlr/Vitry.g:72:7: ( delim[false] ':' )
        // src/antlr/Vitry.g:72:8: delim[false] ':'
        {
        pushFollow(FOLLOW_delim_in_synpred2_Vitry288);
        delim(false);

        state._fsp--;
        if (state.failed) return ;
        match(input,38,FOLLOW_38_in_synpred2_Vitry291); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_Vitry

    // $ANTLR start synpred3_Vitry
    public final void synpred3_Vitry_fragment() throws RecognitionException {   
        // src/antlr/Vitry.g:101:7: ( Op )
        // src/antlr/Vitry.g:101:8: Op
        {
        match(input,Op,FOLLOW_Op_in_synpred3_Vitry625); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_Vitry

    // $ANTLR start synpred4_Vitry
    public final void synpred4_Vitry_fragment() throws RecognitionException {   
        // src/antlr/Vitry.g:103:7: ( apply Op )
        // src/antlr/Vitry.g:103:8: apply Op
        {
        pushFollow(FOLLOW_apply_in_synpred4_Vitry699);
        apply();

        state._fsp--;
        if (state.failed) return ;
        match(input,Op,FOLLOW_Op_in_synpred4_Vitry701); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_Vitry

    // $ANTLR start synpred5_Vitry
    public final void synpred5_Vitry_fragment() throws RecognitionException {   
        // src/antlr/Vitry.g:136:7: ( expr expr )
        // src/antlr/Vitry.g:136:8: expr expr
        {
        pushFollow(FOLLOW_expr_in_synpred5_Vitry1370);
        expr();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_expr_in_synpred5_Vitry1372);
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


    protected DFA10 dfa10 = new DFA10(this);
    protected DFA24 dfa24 = new DFA24(this);
    static final String DFA10_eotS =
        "\22\uffff";
    static final String DFA10_eofS =
        "\22\uffff";
    static final String DFA10_minS =
        "\1\32\7\uffff\6\0\4\uffff";
    static final String DFA10_maxS =
        "\1\65\7\uffff\6\0\4\uffff";
    static final String DFA10_acceptS =
        "\1\uffff\1\1\14\uffff\1\2\1\3\1\4\1\5";
    static final String DFA10_specialS =
        "\10\uffff\1\0\1\1\1\2\1\3\1\4\1\5\4\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\10\5\15\7\uffff\1\11\1\uffff\1\12\1\uffff\1\13\1\uffff\1"+
            "\14\6\1\1\uffff\1\1",
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
            "",
            "",
            ""
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "99:1: inline[boolean rs] : ({...}? inlineRight | ( Op )=> Op | ( Op apply )+ -> ^( Ops ( ^( Op ( apply )? ) )+ ) | ( apply Op )=>e+= apply ( Op (f+= apply )? )+ -> ^( Ops $e ( ^( Op $f) )+ ) | apply );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA10_8 = input.LA(1);

                         
                        int index10_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_Vitry()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index10_8);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA10_9 = input.LA(1);

                         
                        int index10_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Vitry()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index10_9);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA10_10 = input.LA(1);

                         
                        int index10_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Vitry()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index10_10);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA10_11 = input.LA(1);

                         
                        int index10_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Vitry()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index10_11);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA10_12 = input.LA(1);

                         
                        int index10_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Vitry()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index10_12);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA10_13 = input.LA(1);

                         
                        int index10_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Vitry()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index10_13);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 10, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA24_eotS =
        "\20\uffff";
    static final String DFA24_eofS =
        "\20\uffff";
    static final String DFA24_minS =
        "\1\56\4\47\13\uffff";
    static final String DFA24_maxS =
        "\1\65\4\51\13\uffff";
    static final String DFA24_acceptS =
        "\5\uffff\1\11\1\12\1\13\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10";
    static final String DFA24_specialS =
        "\20\uffff}>";
    static final String[] DFA24_transitionS = {
            "\1\1\1\2\1\3\1\4\1\5\1\6\1\uffff\1\7",
            "\1\10\1\uffff\1\11",
            "\1\12\1\uffff\1\13",
            "\1\14\1\uffff\1\15",
            "\1\16\1\uffff\1\17",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA24_eot = DFA.unpackEncodedString(DFA24_eotS);
    static final short[] DFA24_eof = DFA.unpackEncodedString(DFA24_eofS);
    static final char[] DFA24_min = DFA.unpackEncodedStringToUnsignedChars(DFA24_minS);
    static final char[] DFA24_max = DFA.unpackEncodedStringToUnsignedChars(DFA24_maxS);
    static final short[] DFA24_accept = DFA.unpackEncodedString(DFA24_acceptS);
    static final short[] DFA24_special = DFA.unpackEncodedString(DFA24_specialS);
    static final short[][] DFA24_transition;

    static {
        int numStates = DFA24_transitionS.length;
        DFA24_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA24_transition[i] = DFA.unpackEncodedString(DFA24_transitionS[i]);
        }
    }

    class DFA24 extends DFA {

        public DFA24(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 24;
            this.eot = DFA24_eot;
            this.eof = DFA24_eof;
            this.min = DFA24_min;
            this.max = DFA24_max;
            this.accept = DFA24_accept;
            this.special = DFA24_special;
            this.transition = DFA24_transition;
        }
        public String getDescription() {
            return "116:1: inlineRight : ( 'fn' '(' ( left )* ')' inline[true] -> ^( Fn ( left )* inline ) | 'fn' '[' ( left )* ']' inline[true] -> ^( Fn ( left )* inline ) | 'let' '(' ( assign )* ')' inline[true] -> ^( Let ( assign )* inline ) | 'let' '[' ( assign )* ']' inline[true] -> ^( Let ( assign )* inline ) | 'loop' '(' ( assign )* ')' inline[true] -> ^( Loop ( assign )* inline ) | 'loop' '[' ( assign )* ']' inline[true] -> ^( Loop ( assign )* inline ) | 'do' '(' ( assign )* ')' ( expr )* -> ^( Do ( assign )* ( expr )* ) | 'do' '[' ( assign )* ']' ( expr )* -> ^( Do ( assign )* ( expr )* ) | 'match' v= expr '(' (c+= left e+= expr )* ')' -> ^( Match $v ( ^( $c $e) )* ) | 'if' expr expr ( 'else' )? inline[true] -> ^( If expr expr inline ) | 'recur' ( expr )* -> ^( Recur ( expr )* ) );";
        }
    }
 

    public static final BitSet FOLLOW_delim_in_expr237 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_expr240 = new BitSet(new long[]{0x00002A80F8000000L});
    public static final BitSet FOLLOW_expr_in_expr242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_delim_in_expr263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_delim_in_left296 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_left299 = new BitSet(new long[]{0x00002A80F8000000L});
    public static final BitSet FOLLOW_expr_in_left301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_delim_in_left324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_delim386 = new BitSet(new long[]{0x002FEB80FC000000L});
    public static final BitSet FOLLOW_inline_in_delim388 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_delim392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_delim415 = new BitSet(new long[]{0x002FEE80FC000000L});
    public static final BitSet FOLLOW_inline_in_delim417 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_delim421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_delim444 = new BitSet(new long[]{0x002FFA80FC000000L});
    public static final BitSet FOLLOW_inline_in_delim446 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_delim450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_delim473 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_Op_in_delim475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_delim510 = new BitSet(new long[]{0x00002A80F8000000L});
    public static final BitSet FOLLOW_delim_in_delim512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_delim541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_atom0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inlineRight_in_inline616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Op_in_inline630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Op_in_inline639 = new BitSet(new long[]{0x00002A80F8000000L});
    public static final BitSet FOLLOW_apply_in_inline641 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_apply_in_inline708 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_Op_in_inline711 = new BitSet(new long[]{0x00002A80FC000002L});
    public static final BitSet FOLLOW_apply_in_inline715 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_apply_in_inline749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_inlineRight790 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_inlineRight794 = new BitSet(new long[]{0x00002B80F8000000L});
    public static final BitSet FOLLOW_left_in_inlineRight796 = new BitSet(new long[]{0x00002B80F8000000L});
    public static final BitSet FOLLOW_40_in_inlineRight801 = new BitSet(new long[]{0x002FEA80FC000000L});
    public static final BitSet FOLLOW_inline_in_inlineRight803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_inlineRight836 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_inlineRight840 = new BitSet(new long[]{0x00002E80F8000000L});
    public static final BitSet FOLLOW_left_in_inlineRight842 = new BitSet(new long[]{0x00002E80F8000000L});
    public static final BitSet FOLLOW_42_in_inlineRight847 = new BitSet(new long[]{0x002FEA80FC000000L});
    public static final BitSet FOLLOW_inline_in_inlineRight849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_inlineRight882 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_inlineRight885 = new BitSet(new long[]{0x00002B80F8000000L});
    public static final BitSet FOLLOW_assign_in_inlineRight887 = new BitSet(new long[]{0x00002B80F8000000L});
    public static final BitSet FOLLOW_40_in_inlineRight890 = new BitSet(new long[]{0x002FEA80FC000000L});
    public static final BitSet FOLLOW_inline_in_inlineRight892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_inlineRight925 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_inlineRight928 = new BitSet(new long[]{0x00002E80F8000000L});
    public static final BitSet FOLLOW_assign_in_inlineRight930 = new BitSet(new long[]{0x00002E80F8000000L});
    public static final BitSet FOLLOW_42_in_inlineRight933 = new BitSet(new long[]{0x002FEA80FC000000L});
    public static final BitSet FOLLOW_inline_in_inlineRight935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_inlineRight968 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_inlineRight970 = new BitSet(new long[]{0x00002B80F8000000L});
    public static final BitSet FOLLOW_assign_in_inlineRight972 = new BitSet(new long[]{0x00002B80F8000000L});
    public static final BitSet FOLLOW_40_in_inlineRight975 = new BitSet(new long[]{0x002FEA80FC000000L});
    public static final BitSet FOLLOW_inline_in_inlineRight977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_inlineRight1010 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_inlineRight1012 = new BitSet(new long[]{0x00002E80F8000000L});
    public static final BitSet FOLLOW_assign_in_inlineRight1014 = new BitSet(new long[]{0x00002E80F8000000L});
    public static final BitSet FOLLOW_42_in_inlineRight1017 = new BitSet(new long[]{0x002FEA80FC000000L});
    public static final BitSet FOLLOW_inline_in_inlineRight1019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_inlineRight1052 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_inlineRight1056 = new BitSet(new long[]{0x00002B80F8000000L});
    public static final BitSet FOLLOW_assign_in_inlineRight1058 = new BitSet(new long[]{0x00002B80F8000000L});
    public static final BitSet FOLLOW_40_in_inlineRight1061 = new BitSet(new long[]{0x00002A80F8000002L});
    public static final BitSet FOLLOW_expr_in_inlineRight1063 = new BitSet(new long[]{0x00002A80F8000002L});
    public static final BitSet FOLLOW_49_in_inlineRight1104 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_inlineRight1108 = new BitSet(new long[]{0x00002E80F8000000L});
    public static final BitSet FOLLOW_assign_in_inlineRight1110 = new BitSet(new long[]{0x00002E80F8000000L});
    public static final BitSet FOLLOW_42_in_inlineRight1113 = new BitSet(new long[]{0x00002A80F8000002L});
    public static final BitSet FOLLOW_expr_in_inlineRight1115 = new BitSet(new long[]{0x00002A80F8000002L});
    public static final BitSet FOLLOW_50_in_inlineRight1156 = new BitSet(new long[]{0x00002A80F8000000L});
    public static final BitSet FOLLOW_expr_in_inlineRight1160 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_inlineRight1162 = new BitSet(new long[]{0x00002B80F8000000L});
    public static final BitSet FOLLOW_left_in_inlineRight1167 = new BitSet(new long[]{0x00002A80F8000000L});
    public static final BitSet FOLLOW_expr_in_inlineRight1171 = new BitSet(new long[]{0x00002B80F8000000L});
    public static final BitSet FOLLOW_40_in_inlineRight1175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_inlineRight1212 = new BitSet(new long[]{0x00002A80F8000000L});
    public static final BitSet FOLLOW_expr_in_inlineRight1214 = new BitSet(new long[]{0x00002A80F8000000L});
    public static final BitSet FOLLOW_expr_in_inlineRight1216 = new BitSet(new long[]{0x003FEA80FC000000L});
    public static final BitSet FOLLOW_52_in_inlineRight1218 = new BitSet(new long[]{0x002FEA80FC000000L});
    public static final BitSet FOLLOW_inline_in_inlineRight1221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_inlineRight1255 = new BitSet(new long[]{0x00002A80F8000002L});
    public static final BitSet FOLLOW_expr_in_inlineRight1257 = new BitSet(new long[]{0x00002A80F8000002L});
    public static final BitSet FOLLOW_left_in_assign1302 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_assign1304 = new BitSet(new long[]{0x00002A80F8000000L});
    public static final BitSet FOLLOW_expr_in_assign1306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_apply1377 = new BitSet(new long[]{0x00002A80F8000002L});
    public static final BitSet FOLLOW_expr_in_apply1419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_delim_in_synpred1_Vitry229 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_synpred1_Vitry232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_delim_in_synpred2_Vitry288 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_synpred2_Vitry291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Op_in_synpred3_Vitry625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_apply_in_synpred4_Vitry699 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_Op_in_synpred4_Vitry701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_synpred5_Vitry1370 = new BitSet(new long[]{0x00002A80F8000000L});
    public static final BitSet FOLLOW_expr_in_synpred5_Vitry1372 = new BitSet(new long[]{0x0000000000000002L});

}