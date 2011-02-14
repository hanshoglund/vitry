// $ANTLR 3.2 Sep 23, 2009 12:02:23 src/antlr/Vitry.g 2011-02-14 01:36:18
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Par", "Bra", "Ang", "Left", "Quote", "Module", "Fn", "Let", "Assign", "Apply", "Ops", "If", "Match", "Do", "Type", "TypeDecl", "ImplicitDecl", "FnDecl", "MemberDecl", "Op", "Symbol", "Natural", "Float", "Complex", "String", "Exponent", "Whitespace", "EscapeSeq", "HexDigit", "UnicodeEsc", "OctalEsc", "':'", "'('", "')'", "'['", "']'", "'{'", "'}'", "'`'", "'fn'", "'let'", "'do'", "'match'", "'if'", "'else'", "'='", "'module'", "'import'"
    };
    public static final int TypeDecl=19;
    public static final int Ops=14;
    public static final int MemberDecl=22;
    public static final int Module=9;
    public static final int Exponent=29;
    public static final int Quote=8;
    public static final int EOF=-1;
    public static final int HexDigit=32;
    public static final int T__51=51;
    public static final int Let=11;
    public static final int Assign=12;
    public static final int Left=7;
    public static final int OctalEsc=34;
    public static final int Do=17;
    public static final int UnicodeEsc=33;
    public static final int Ang=6;
    public static final int Bra=5;
    public static final int Op=23;
    public static final int String=28;
    public static final int Symbol=24;
    public static final int Whitespace=30;
    public static final int T__50=50;
    public static final int If=15;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int FnDecl=21;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int Type=18;
    public static final int T__45=45;
    public static final int Natural=25;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int Complex=27;
    public static final int Apply=13;
    public static final int ImplicitDecl=20;
    public static final int Float=26;
    public static final int EscapeSeq=31;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int Match=16;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int Par=4;
    public static final int Fn=10;

    // delegates
    // delegators


        public VitryParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public VitryParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            this.state.ruleMemo = new HashMap[15+1];
             
             
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
    // src/antlr/Vitry.g:71:1: expr : ( ( delim[true] ':' )=> delim[true] ':' expr -> ^( Type delim expr ) | delim[true] );
    public final VitryParser.expr_return expr() throws RecognitionException {
        VitryParser.expr_return retval = new VitryParser.expr_return();
        retval.start = input.LT(1);
        int expr_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal2=null;
        VitryParser.delim_return delim1 = null;

        VitryParser.expr_return expr3 = null;

        VitryParser.delim_return delim4 = null;


        Object char_literal2_tree=null;
        RewriteRuleTokenStream stream_35=new RewriteRuleTokenStream(adaptor,"token 35");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        RewriteRuleSubtreeStream stream_delim=new RewriteRuleSubtreeStream(adaptor,"rule delim");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return retval; }
            // src/antlr/Vitry.g:72:5: ( ( delim[true] ':' )=> delim[true] ':' expr -> ^( Type delim expr ) | delim[true] )
            int alt1=2;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // src/antlr/Vitry.g:72:7: ( delim[true] ':' )=> delim[true] ':' expr
                    {
                    pushFollow(FOLLOW_delim_in_expr275);
                    delim1=delim(true);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_delim.add(delim1.getTree());
                    char_literal2=(Token)match(input,35,FOLLOW_35_in_expr278); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_35.add(char_literal2);

                    pushFollow(FOLLOW_expr_in_expr280);
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
                    // 72:51: -> ^( Type delim expr )
                    {
                        // src/antlr/Vitry.g:72:54: ^( Type delim expr )
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
                    // src/antlr/Vitry.g:73:7: delim[true]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_delim_in_expr300);
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
            if ( state.backtracking>0 ) { memoize(input, 1, expr_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "expr"

    public static class left_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "left"
    // src/antlr/Vitry.g:80:1: left : ( ( delim[false] ':' )=> delim[false] ':' expr -> ^( Left ^( Type delim expr ) ) | delim[false] -> ^( Left delim ) );
    public final VitryParser.left_return left() throws RecognitionException {
        VitryParser.left_return retval = new VitryParser.left_return();
        retval.start = input.LT(1);
        int left_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal6=null;
        VitryParser.delim_return delim5 = null;

        VitryParser.expr_return expr7 = null;

        VitryParser.delim_return delim8 = null;


        Object char_literal6_tree=null;
        RewriteRuleTokenStream stream_35=new RewriteRuleTokenStream(adaptor,"token 35");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        RewriteRuleSubtreeStream stream_delim=new RewriteRuleSubtreeStream(adaptor,"rule delim");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return retval; }
            // src/antlr/Vitry.g:81:5: ( ( delim[false] ':' )=> delim[false] ':' expr -> ^( Left ^( Type delim expr ) ) | delim[false] -> ^( Left delim ) )
            int alt2=2;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // src/antlr/Vitry.g:81:7: ( delim[false] ':' )=> delim[false] ':' expr
                    {
                    pushFollow(FOLLOW_delim_in_left333);
                    delim5=delim(false);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_delim.add(delim5.getTree());
                    char_literal6=(Token)match(input,35,FOLLOW_35_in_left336); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_35.add(char_literal6);

                    pushFollow(FOLLOW_expr_in_left338);
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
                    // 81:51: -> ^( Left ^( Type delim expr ) )
                    {
                        // src/antlr/Vitry.g:81:54: ^( Left ^( Type delim expr ) )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Left, "Left"), root_1);

                        // src/antlr/Vitry.g:81:61: ^( Type delim expr )
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
                    // src/antlr/Vitry.g:82:7: delim[false]
                    {
                    pushFollow(FOLLOW_delim_in_left360);
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
                    // 82:51: -> ^( Left delim )
                    {
                        // src/antlr/Vitry.g:82:54: ^( Left delim )
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
            if ( state.backtracking>0 ) { memoize(input, 2, left_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "left"

    public static class delim_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "delim"
    // src/antlr/Vitry.g:88:1: delim[boolean rs] : ( '(' ( inline[rs] )? ')' -> ^( Par ( inline )? ) | '[' ( inline[rs] )? ']' -> ^( Bra ( inline )? ) | '{' ( inline[rs] )? '}' -> ^( Ang ( inline )? ) | '`' Op -> ^( Quote Op ) | '`' delim[rs] -> ^( Quote delim ) | Symbol | Natural | Float | Complex | String );
    public final VitryParser.delim_return delim(boolean rs) throws RecognitionException {
        VitryParser.delim_return retval = new VitryParser.delim_return();
        retval.start = input.LT(1);
        int delim_StartIndex = input.index();
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
        Token Symbol22=null;
        Token Natural23=null;
        Token Float24=null;
        Token Complex25=null;
        Token String26=null;
        VitryParser.inline_return inline10 = null;

        VitryParser.inline_return inline13 = null;

        VitryParser.inline_return inline16 = null;

        VitryParser.delim_return delim21 = null;


        Object char_literal9_tree=null;
        Object char_literal11_tree=null;
        Object char_literal12_tree=null;
        Object char_literal14_tree=null;
        Object char_literal15_tree=null;
        Object char_literal17_tree=null;
        Object char_literal18_tree=null;
        Object Op19_tree=null;
        Object char_literal20_tree=null;
        Object Symbol22_tree=null;
        Object Natural23_tree=null;
        Object Float24_tree=null;
        Object Complex25_tree=null;
        Object String26_tree=null;
        RewriteRuleTokenStream stream_42=new RewriteRuleTokenStream(adaptor,"token 42");
        RewriteRuleTokenStream stream_Op=new RewriteRuleTokenStream(adaptor,"token Op");
        RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
        RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
        RewriteRuleTokenStream stream_36=new RewriteRuleTokenStream(adaptor,"token 36");
        RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");
        RewriteRuleTokenStream stream_37=new RewriteRuleTokenStream(adaptor,"token 37");
        RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
        RewriteRuleSubtreeStream stream_inline=new RewriteRuleSubtreeStream(adaptor,"rule inline");
        RewriteRuleSubtreeStream stream_delim=new RewriteRuleSubtreeStream(adaptor,"rule delim");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }
            // src/antlr/Vitry.g:89:5: ( '(' ( inline[rs] )? ')' -> ^( Par ( inline )? ) | '[' ( inline[rs] )? ']' -> ^( Bra ( inline )? ) | '{' ( inline[rs] )? '}' -> ^( Ang ( inline )? ) | '`' Op -> ^( Quote Op ) | '`' delim[rs] -> ^( Quote delim ) | Symbol | Natural | Float | Complex | String )
            int alt6=10;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // src/antlr/Vitry.g:89:7: '(' ( inline[rs] )? ')'
                    {
                    char_literal9=(Token)match(input,36,FOLLOW_36_in_delim421); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_36.add(char_literal9);

                    // src/antlr/Vitry.g:89:11: ( inline[rs] )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( ((LA3_0>=Op && LA3_0<=String)||LA3_0==36||LA3_0==38||LA3_0==40||(LA3_0>=42 && LA3_0<=47)) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // src/antlr/Vitry.g:89:11: inline[rs]
                            {
                            pushFollow(FOLLOW_inline_in_delim423);
                            inline10=inline(rs);

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_inline.add(inline10.getTree());

                            }
                            break;

                    }

                    char_literal11=(Token)match(input,37,FOLLOW_37_in_delim427); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_37.add(char_literal11);



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
                    // 89:28: -> ^( Par ( inline )? )
                    {
                        // src/antlr/Vitry.g:89:31: ^( Par ( inline )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Par, "Par"), root_1);

                        // src/antlr/Vitry.g:89:37: ( inline )?
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
                    // src/antlr/Vitry.g:90:7: '[' ( inline[rs] )? ']'
                    {
                    char_literal12=(Token)match(input,38,FOLLOW_38_in_delim445); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_38.add(char_literal12);

                    // src/antlr/Vitry.g:90:11: ( inline[rs] )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( ((LA4_0>=Op && LA4_0<=String)||LA4_0==36||LA4_0==38||LA4_0==40||(LA4_0>=42 && LA4_0<=47)) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // src/antlr/Vitry.g:90:11: inline[rs]
                            {
                            pushFollow(FOLLOW_inline_in_delim447);
                            inline13=inline(rs);

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_inline.add(inline13.getTree());

                            }
                            break;

                    }

                    char_literal14=(Token)match(input,39,FOLLOW_39_in_delim451); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_39.add(char_literal14);



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
                    // 90:28: -> ^( Bra ( inline )? )
                    {
                        // src/antlr/Vitry.g:90:31: ^( Bra ( inline )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Bra, "Bra"), root_1);

                        // src/antlr/Vitry.g:90:37: ( inline )?
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
                    // src/antlr/Vitry.g:91:7: '{' ( inline[rs] )? '}'
                    {
                    char_literal15=(Token)match(input,40,FOLLOW_40_in_delim469); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(char_literal15);

                    // src/antlr/Vitry.g:91:11: ( inline[rs] )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( ((LA5_0>=Op && LA5_0<=String)||LA5_0==36||LA5_0==38||LA5_0==40||(LA5_0>=42 && LA5_0<=47)) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // src/antlr/Vitry.g:91:11: inline[rs]
                            {
                            pushFollow(FOLLOW_inline_in_delim471);
                            inline16=inline(rs);

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_inline.add(inline16.getTree());

                            }
                            break;

                    }

                    char_literal17=(Token)match(input,41,FOLLOW_41_in_delim475); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_41.add(char_literal17);



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
                    // 91:28: -> ^( Ang ( inline )? )
                    {
                        // src/antlr/Vitry.g:91:31: ^( Ang ( inline )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Ang, "Ang"), root_1);

                        // src/antlr/Vitry.g:91:37: ( inline )?
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
                    // src/antlr/Vitry.g:92:7: '`' Op
                    {
                    char_literal18=(Token)match(input,42,FOLLOW_42_in_delim493); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_42.add(char_literal18);

                    Op19=(Token)match(input,Op,FOLLOW_Op_in_delim495); if (state.failed) return retval; 
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
                    // 92:28: -> ^( Quote Op )
                    {
                        // src/antlr/Vitry.g:92:31: ^( Quote Op )
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
                    // src/antlr/Vitry.g:93:7: '`' delim[rs]
                    {
                    char_literal20=(Token)match(input,42,FOLLOW_42_in_delim525); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_42.add(char_literal20);

                    pushFollow(FOLLOW_delim_in_delim527);
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
                    // 93:28: -> ^( Quote delim )
                    {
                        // src/antlr/Vitry.g:93:31: ^( Quote delim )
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
                    // src/antlr/Vitry.g:94:7: Symbol
                    {
                    root_0 = (Object)adaptor.nil();

                    Symbol22=(Token)match(input,Symbol,FOLLOW_Symbol_in_delim551); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Symbol22_tree = (Object)adaptor.create(Symbol22);
                    adaptor.addChild(root_0, Symbol22_tree);
                    }

                    }
                    break;
                case 7 :
                    // src/antlr/Vitry.g:95:7: Natural
                    {
                    root_0 = (Object)adaptor.nil();

                    Natural23=(Token)match(input,Natural,FOLLOW_Natural_in_delim559); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Natural23_tree = (Object)adaptor.create(Natural23);
                    adaptor.addChild(root_0, Natural23_tree);
                    }

                    }
                    break;
                case 8 :
                    // src/antlr/Vitry.g:96:7: Float
                    {
                    root_0 = (Object)adaptor.nil();

                    Float24=(Token)match(input,Float,FOLLOW_Float_in_delim567); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Float24_tree = (Object)adaptor.create(Float24);
                    adaptor.addChild(root_0, Float24_tree);
                    }

                    }
                    break;
                case 9 :
                    // src/antlr/Vitry.g:97:7: Complex
                    {
                    root_0 = (Object)adaptor.nil();

                    Complex25=(Token)match(input,Complex,FOLLOW_Complex_in_delim575); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Complex25_tree = (Object)adaptor.create(Complex25);
                    adaptor.addChild(root_0, Complex25_tree);
                    }

                    }
                    break;
                case 10 :
                    // src/antlr/Vitry.g:98:7: String
                    {
                    root_0 = (Object)adaptor.nil();

                    String26=(Token)match(input,String,FOLLOW_String_in_delim583); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    String26_tree = (Object)adaptor.create(String26);
                    adaptor.addChild(root_0, String26_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 3, delim_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "delim"

    public static class inline_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "inline"
    // src/antlr/Vitry.g:106:1: inline[boolean rs] : ({...}? inlineRight | ( Op ( ')' | ']' | '}' ) )=> Op | ( Op apply )+ -> ^( Ops ( ^( Op apply ) )+ ) | ( apply Op )=>e= apply ( Op f+= apply )+ -> ^( Ops $e ( ^( Op $f) )+ ) | apply );
    public final VitryParser.inline_return inline(boolean rs) throws RecognitionException {
        VitryParser.inline_return retval = new VitryParser.inline_return();
        retval.start = input.LT(1);
        int inline_StartIndex = input.index();
        Object root_0 = null;

        Token Op28=null;
        Token Op29=null;
        Token Op31=null;
        List list_f=null;
        VitryParser.apply_return e = null;

        VitryParser.inlineRight_return inlineRight27 = null;

        VitryParser.apply_return apply30 = null;

        VitryParser.apply_return apply32 = null;

        RuleReturnScope f = null;
        Object Op28_tree=null;
        Object Op29_tree=null;
        Object Op31_tree=null;
        RewriteRuleTokenStream stream_Op=new RewriteRuleTokenStream(adaptor,"token Op");
        RewriteRuleSubtreeStream stream_apply=new RewriteRuleSubtreeStream(adaptor,"rule apply");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return retval; }
            // src/antlr/Vitry.g:107:5: ({...}? inlineRight | ( Op ( ')' | ']' | '}' ) )=> Op | ( Op apply )+ -> ^( Ops ( ^( Op apply ) )+ ) | ( apply Op )=>e= apply ( Op f+= apply )+ -> ^( Ops $e ( ^( Op $f) )+ ) | apply )
            int alt9=5;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // src/antlr/Vitry.g:107:7: {...}? inlineRight
                    {
                    root_0 = (Object)adaptor.nil();

                    if ( !((rs)) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "inline", "$rs");
                    }
                    pushFollow(FOLLOW_inlineRight_in_inline606);
                    inlineRight27=inlineRight();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, inlineRight27.getTree());

                    }
                    break;
                case 2 :
                    // src/antlr/Vitry.g:108:7: ( Op ( ')' | ']' | '}' ) )=> Op
                    {
                    root_0 = (Object)adaptor.nil();

                    Op28=(Token)match(input,Op,FOLLOW_Op_in_inline632); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Op28_tree = (Object)adaptor.create(Op28);
                    adaptor.addChild(root_0, Op28_tree);
                    }

                    }
                    break;
                case 3 :
                    // src/antlr/Vitry.g:109:7: ( Op apply )+
                    {
                    // src/antlr/Vitry.g:109:7: ( Op apply )+
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
                    	    // src/antlr/Vitry.g:109:8: Op apply
                    	    {
                    	    Op29=(Token)match(input,Op,FOLLOW_Op_in_inline641); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_Op.add(Op29);

                    	    pushFollow(FOLLOW_apply_in_inline643);
                    	    apply30=apply();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_apply.add(apply30.getTree());

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
                    // 109:46: -> ^( Ops ( ^( Op apply ) )+ )
                    {
                        // src/antlr/Vitry.g:109:49: ^( Ops ( ^( Op apply ) )+ )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Ops, "Ops"), root_1);

                        if ( !(stream_Op.hasNext()||stream_apply.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_Op.hasNext()||stream_apply.hasNext() ) {
                            // src/antlr/Vitry.g:109:55: ^( Op apply )
                            {
                            Object root_2 = (Object)adaptor.nil();
                            root_2 = (Object)adaptor.becomeRoot(stream_Op.nextNode(), root_2);

                            adaptor.addChild(root_2, stream_apply.nextTree());

                            adaptor.addChild(root_1, root_2);
                            }

                        }
                        stream_Op.reset();
                        stream_apply.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // src/antlr/Vitry.g:110:7: ( apply Op )=>e= apply ( Op f+= apply )+
                    {
                    pushFollow(FOLLOW_apply_in_inline703);
                    e=apply();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_apply.add(e.getTree());
                    // src/antlr/Vitry.g:110:29: ( Op f+= apply )+
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
                    	    // src/antlr/Vitry.g:110:30: Op f+= apply
                    	    {
                    	    Op31=(Token)match(input,Op,FOLLOW_Op_in_inline706); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_Op.add(Op31);

                    	    pushFollow(FOLLOW_apply_in_inline710);
                    	    f=apply();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_apply.add(f.getTree());
                    	    if (list_f==null) list_f=new ArrayList();
                    	    list_f.add(f.getTree());


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
                    // elements: Op, f, e
                    // token labels: 
                    // rule labels: retval, e
                    // token list labels: 
                    // rule list labels: f
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_e=new RewriteRuleSubtreeStream(adaptor,"rule e",e!=null?e.tree:null);
                    RewriteRuleSubtreeStream stream_f=new RewriteRuleSubtreeStream(adaptor,"token f",list_f);
                    root_0 = (Object)adaptor.nil();
                    // 110:46: -> ^( Ops $e ( ^( Op $f) )+ )
                    {
                        // src/antlr/Vitry.g:110:49: ^( Ops $e ( ^( Op $f) )+ )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Ops, "Ops"), root_1);

                        adaptor.addChild(root_1, stream_e.nextTree());
                        if ( !(stream_Op.hasNext()||stream_f.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_Op.hasNext()||stream_f.hasNext() ) {
                            // src/antlr/Vitry.g:110:58: ^( Op $f)
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
                    // src/antlr/Vitry.g:111:7: apply
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_apply_in_inline741);
                    apply32=apply();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, apply32.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 4, inline_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "inline"

    public static class inlineRight_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "inlineRight"
    // src/antlr/Vitry.g:120:1: inlineRight : ( 'fn' '(' ( left )* ')' inline[true] -> ^( Fn ( left )* inline ) | 'fn' '[' ( left )* ']' inline[true] -> ^( Fn ( left )* inline ) | 'let' '(' ( assign )* ')' inline[true] -> ^( Let ( assign )* inline ) | 'let' '[' ( assign )* ']' inline[true] -> ^( Let ( assign )* inline ) | 'do' '(' ( assign )* ')' ( expr )* -> ^( Do ( assign )* ( expr )* ) | 'do' '[' ( assign )* ']' ( expr )* -> ^( Do ( assign )* ( expr )* ) | 'match' v= expr '(' (c+= left e+= expr )* ')' -> ^( Match $v ( ^( $c $e) )* ) | 'if' expr expr ( 'else' )? inline[true] -> ^( If expr expr inline ) );
    public final VitryParser.inlineRight_return inlineRight() throws RecognitionException {
        VitryParser.inlineRight_return retval = new VitryParser.inlineRight_return();
        retval.start = input.LT(1);
        int inlineRight_StartIndex = input.index();
        Object root_0 = null;

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
        Token char_literal49=null;
        Token char_literal51=null;
        Token string_literal53=null;
        Token char_literal54=null;
        Token char_literal56=null;
        Token string_literal58=null;
        Token char_literal59=null;
        Token char_literal61=null;
        Token string_literal63=null;
        Token char_literal64=null;
        Token char_literal65=null;
        Token string_literal66=null;
        Token string_literal69=null;
        List list_c=null;
        List list_e=null;
        VitryParser.expr_return v = null;

        VitryParser.left_return left35 = null;

        VitryParser.inline_return inline37 = null;

        VitryParser.left_return left40 = null;

        VitryParser.inline_return inline42 = null;

        VitryParser.assign_return assign45 = null;

        VitryParser.inline_return inline47 = null;

        VitryParser.assign_return assign50 = null;

        VitryParser.inline_return inline52 = null;

        VitryParser.assign_return assign55 = null;

        VitryParser.expr_return expr57 = null;

        VitryParser.assign_return assign60 = null;

        VitryParser.expr_return expr62 = null;

        VitryParser.expr_return expr67 = null;

        VitryParser.expr_return expr68 = null;

        VitryParser.inline_return inline70 = null;

        RuleReturnScope c = null;
        RuleReturnScope e = null;
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
        Object char_literal49_tree=null;
        Object char_literal51_tree=null;
        Object string_literal53_tree=null;
        Object char_literal54_tree=null;
        Object char_literal56_tree=null;
        Object string_literal58_tree=null;
        Object char_literal59_tree=null;
        Object char_literal61_tree=null;
        Object string_literal63_tree=null;
        Object char_literal64_tree=null;
        Object char_literal65_tree=null;
        Object string_literal66_tree=null;
        Object string_literal69_tree=null;
        RewriteRuleTokenStream stream_48=new RewriteRuleTokenStream(adaptor,"token 48");
        RewriteRuleTokenStream stream_45=new RewriteRuleTokenStream(adaptor,"token 45");
        RewriteRuleTokenStream stream_43=new RewriteRuleTokenStream(adaptor,"token 43");
        RewriteRuleTokenStream stream_44=new RewriteRuleTokenStream(adaptor,"token 44");
        RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
        RewriteRuleTokenStream stream_46=new RewriteRuleTokenStream(adaptor,"token 46");
        RewriteRuleTokenStream stream_36=new RewriteRuleTokenStream(adaptor,"token 36");
        RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");
        RewriteRuleTokenStream stream_37=new RewriteRuleTokenStream(adaptor,"token 37");
        RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
        RewriteRuleSubtreeStream stream_assign=new RewriteRuleSubtreeStream(adaptor,"rule assign");
        RewriteRuleSubtreeStream stream_inline=new RewriteRuleSubtreeStream(adaptor,"rule inline");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        RewriteRuleSubtreeStream stream_left=new RewriteRuleSubtreeStream(adaptor,"rule left");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return retval; }
            // src/antlr/Vitry.g:121:5: ( 'fn' '(' ( left )* ')' inline[true] -> ^( Fn ( left )* inline ) | 'fn' '[' ( left )* ']' inline[true] -> ^( Fn ( left )* inline ) | 'let' '(' ( assign )* ')' inline[true] -> ^( Let ( assign )* inline ) | 'let' '[' ( assign )* ']' inline[true] -> ^( Let ( assign )* inline ) | 'do' '(' ( assign )* ')' ( expr )* -> ^( Do ( assign )* ( expr )* ) | 'do' '[' ( assign )* ']' ( expr )* -> ^( Do ( assign )* ( expr )* ) | 'match' v= expr '(' (c+= left e+= expr )* ')' -> ^( Match $v ( ^( $c $e) )* ) | 'if' expr expr ( 'else' )? inline[true] -> ^( If expr expr inline ) )
            int alt20=8;
            alt20 = dfa20.predict(input);
            switch (alt20) {
                case 1 :
                    // src/antlr/Vitry.g:121:7: 'fn' '(' ( left )* ')' inline[true]
                    {
                    string_literal33=(Token)match(input,43,FOLLOW_43_in_inlineRight782); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_43.add(string_literal33);

                    char_literal34=(Token)match(input,36,FOLLOW_36_in_inlineRight786); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_36.add(char_literal34);

                    // src/antlr/Vitry.g:121:18: ( left )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( ((LA10_0>=Symbol && LA10_0<=String)||LA10_0==36||LA10_0==38||LA10_0==40||LA10_0==42) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:121:18: left
                    	    {
                    	    pushFollow(FOLLOW_left_in_inlineRight788);
                    	    left35=left();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_left.add(left35.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    char_literal36=(Token)match(input,37,FOLLOW_37_in_inlineRight793); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_37.add(char_literal36);

                    pushFollow(FOLLOW_inline_in_inlineRight795);
                    inline37=inline(true);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_inline.add(inline37.getTree());


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
                    // 121:50: -> ^( Fn ( left )* inline )
                    {
                        // src/antlr/Vitry.g:121:53: ^( Fn ( left )* inline )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Fn, "Fn"), root_1);

                        // src/antlr/Vitry.g:121:58: ( left )*
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
                    // src/antlr/Vitry.g:122:7: 'fn' '[' ( left )* ']' inline[true]
                    {
                    string_literal38=(Token)match(input,43,FOLLOW_43_in_inlineRight822); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_43.add(string_literal38);

                    char_literal39=(Token)match(input,38,FOLLOW_38_in_inlineRight826); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_38.add(char_literal39);

                    // src/antlr/Vitry.g:122:18: ( left )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( ((LA11_0>=Symbol && LA11_0<=String)||LA11_0==36||LA11_0==38||LA11_0==40||LA11_0==42) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:122:18: left
                    	    {
                    	    pushFollow(FOLLOW_left_in_inlineRight828);
                    	    left40=left();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_left.add(left40.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);

                    char_literal41=(Token)match(input,39,FOLLOW_39_in_inlineRight833); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_39.add(char_literal41);

                    pushFollow(FOLLOW_inline_in_inlineRight835);
                    inline42=inline(true);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_inline.add(inline42.getTree());


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
                    // 122:50: -> ^( Fn ( left )* inline )
                    {
                        // src/antlr/Vitry.g:122:53: ^( Fn ( left )* inline )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Fn, "Fn"), root_1);

                        // src/antlr/Vitry.g:122:58: ( left )*
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
                    // src/antlr/Vitry.g:123:7: 'let' '(' ( assign )* ')' inline[true]
                    {
                    string_literal43=(Token)match(input,44,FOLLOW_44_in_inlineRight862); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_44.add(string_literal43);

                    char_literal44=(Token)match(input,36,FOLLOW_36_in_inlineRight865); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_36.add(char_literal44);

                    // src/antlr/Vitry.g:123:18: ( assign )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( ((LA12_0>=Symbol && LA12_0<=String)||LA12_0==36||LA12_0==38||LA12_0==40||LA12_0==42) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:123:18: assign
                    	    {
                    	    pushFollow(FOLLOW_assign_in_inlineRight867);
                    	    assign45=assign();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_assign.add(assign45.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    char_literal46=(Token)match(input,37,FOLLOW_37_in_inlineRight870); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_37.add(char_literal46);

                    pushFollow(FOLLOW_inline_in_inlineRight872);
                    inline47=inline(true);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_inline.add(inline47.getTree());


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
                    // 123:50: -> ^( Let ( assign )* inline )
                    {
                        // src/antlr/Vitry.g:123:53: ^( Let ( assign )* inline )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Let, "Let"), root_1);

                        // src/antlr/Vitry.g:123:59: ( assign )*
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
                    // src/antlr/Vitry.g:124:7: 'let' '[' ( assign )* ']' inline[true]
                    {
                    string_literal48=(Token)match(input,44,FOLLOW_44_in_inlineRight899); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_44.add(string_literal48);

                    char_literal49=(Token)match(input,38,FOLLOW_38_in_inlineRight902); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_38.add(char_literal49);

                    // src/antlr/Vitry.g:124:18: ( assign )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( ((LA13_0>=Symbol && LA13_0<=String)||LA13_0==36||LA13_0==38||LA13_0==40||LA13_0==42) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:124:18: assign
                    	    {
                    	    pushFollow(FOLLOW_assign_in_inlineRight904);
                    	    assign50=assign();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_assign.add(assign50.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    char_literal51=(Token)match(input,39,FOLLOW_39_in_inlineRight907); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_39.add(char_literal51);

                    pushFollow(FOLLOW_inline_in_inlineRight909);
                    inline52=inline(true);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_inline.add(inline52.getTree());


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
                    // 124:50: -> ^( Let ( assign )* inline )
                    {
                        // src/antlr/Vitry.g:124:53: ^( Let ( assign )* inline )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Let, "Let"), root_1);

                        // src/antlr/Vitry.g:124:59: ( assign )*
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
                    // src/antlr/Vitry.g:125:7: 'do' '(' ( assign )* ')' ( expr )*
                    {
                    string_literal53=(Token)match(input,45,FOLLOW_45_in_inlineRight936); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_45.add(string_literal53);

                    char_literal54=(Token)match(input,36,FOLLOW_36_in_inlineRight940); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_36.add(char_literal54);

                    // src/antlr/Vitry.g:125:18: ( assign )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( ((LA14_0>=Symbol && LA14_0<=String)||LA14_0==36||LA14_0==38||LA14_0==40||LA14_0==42) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:125:18: assign
                    	    {
                    	    pushFollow(FOLLOW_assign_in_inlineRight942);
                    	    assign55=assign();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_assign.add(assign55.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    char_literal56=(Token)match(input,37,FOLLOW_37_in_inlineRight945); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_37.add(char_literal56);

                    // src/antlr/Vitry.g:125:30: ( expr )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( ((LA15_0>=Symbol && LA15_0<=String)||LA15_0==36||LA15_0==38||LA15_0==40||LA15_0==42) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:125:30: expr
                    	    {
                    	    pushFollow(FOLLOW_expr_in_inlineRight947);
                    	    expr57=expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_expr.add(expr57.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop15;
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
                    // 125:50: -> ^( Do ( assign )* ( expr )* )
                    {
                        // src/antlr/Vitry.g:125:53: ^( Do ( assign )* ( expr )* )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Do, "Do"), root_1);

                        // src/antlr/Vitry.g:125:58: ( assign )*
                        while ( stream_assign.hasNext() ) {
                            adaptor.addChild(root_1, stream_assign.nextTree());

                        }
                        stream_assign.reset();
                        // src/antlr/Vitry.g:125:66: ( expr )*
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
                case 6 :
                    // src/antlr/Vitry.g:126:7: 'do' '[' ( assign )* ']' ( expr )*
                    {
                    string_literal58=(Token)match(input,45,FOLLOW_45_in_inlineRight982); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_45.add(string_literal58);

                    char_literal59=(Token)match(input,38,FOLLOW_38_in_inlineRight986); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_38.add(char_literal59);

                    // src/antlr/Vitry.g:126:18: ( assign )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( ((LA16_0>=Symbol && LA16_0<=String)||LA16_0==36||LA16_0==38||LA16_0==40||LA16_0==42) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:126:18: assign
                    	    {
                    	    pushFollow(FOLLOW_assign_in_inlineRight988);
                    	    assign60=assign();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_assign.add(assign60.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);

                    char_literal61=(Token)match(input,39,FOLLOW_39_in_inlineRight991); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_39.add(char_literal61);

                    // src/antlr/Vitry.g:126:30: ( expr )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( ((LA17_0>=Symbol && LA17_0<=String)||LA17_0==36||LA17_0==38||LA17_0==40||LA17_0==42) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:126:30: expr
                    	    {
                    	    pushFollow(FOLLOW_expr_in_inlineRight993);
                    	    expr62=expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_expr.add(expr62.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop17;
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
                    // 126:50: -> ^( Do ( assign )* ( expr )* )
                    {
                        // src/antlr/Vitry.g:126:53: ^( Do ( assign )* ( expr )* )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Do, "Do"), root_1);

                        // src/antlr/Vitry.g:126:58: ( assign )*
                        while ( stream_assign.hasNext() ) {
                            adaptor.addChild(root_1, stream_assign.nextTree());

                        }
                        stream_assign.reset();
                        // src/antlr/Vitry.g:126:66: ( expr )*
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
                case 7 :
                    // src/antlr/Vitry.g:127:7: 'match' v= expr '(' (c+= left e+= expr )* ')'
                    {
                    string_literal63=(Token)match(input,46,FOLLOW_46_in_inlineRight1028); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_46.add(string_literal63);

                    pushFollow(FOLLOW_expr_in_inlineRight1032);
                    v=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(v.getTree());
                    char_literal64=(Token)match(input,36,FOLLOW_36_in_inlineRight1034); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_36.add(char_literal64);

                    // src/antlr/Vitry.g:127:26: (c+= left e+= expr )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( ((LA18_0>=Symbol && LA18_0<=String)||LA18_0==36||LA18_0==38||LA18_0==40||LA18_0==42) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:127:27: c+= left e+= expr
                    	    {
                    	    pushFollow(FOLLOW_left_in_inlineRight1039);
                    	    c=left();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_left.add(c.getTree());
                    	    if (list_c==null) list_c=new ArrayList();
                    	    list_c.add(c.getTree());

                    	    pushFollow(FOLLOW_expr_in_inlineRight1043);
                    	    e=expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_expr.add(e.getTree());
                    	    if (list_e==null) list_e=new ArrayList();
                    	    list_e.add(e.getTree());


                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);

                    char_literal65=(Token)match(input,37,FOLLOW_37_in_inlineRight1047); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_37.add(char_literal65);



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
                    // 127:50: -> ^( Match $v ( ^( $c $e) )* )
                    {
                        // src/antlr/Vitry.g:127:53: ^( Match $v ( ^( $c $e) )* )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Match, "Match"), root_1);

                        adaptor.addChild(root_1, stream_v.nextTree());
                        // src/antlr/Vitry.g:127:64: ( ^( $c $e) )*
                        while ( stream_c.hasNext()||stream_e.hasNext() ) {
                            // src/antlr/Vitry.g:127:64: ^( $c $e)
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
                case 8 :
                    // src/antlr/Vitry.g:128:7: 'if' expr expr ( 'else' )? inline[true]
                    {
                    string_literal66=(Token)match(input,47,FOLLOW_47_in_inlineRight1078); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_47.add(string_literal66);

                    pushFollow(FOLLOW_expr_in_inlineRight1080);
                    expr67=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr67.getTree());
                    pushFollow(FOLLOW_expr_in_inlineRight1082);
                    expr68=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr68.getTree());
                    // src/antlr/Vitry.g:128:22: ( 'else' )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==48) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // src/antlr/Vitry.g:128:22: 'else'
                            {
                            string_literal69=(Token)match(input,48,FOLLOW_48_in_inlineRight1084); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_48.add(string_literal69);


                            }
                            break;

                    }

                    pushFollow(FOLLOW_inline_in_inlineRight1087);
                    inline70=inline(true);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_inline.add(inline70.getTree());


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
                    // 128:50: -> ^( If expr expr inline )
                    {
                        // src/antlr/Vitry.g:128:53: ^( If expr expr inline )
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
            if ( state.backtracking>0 ) { memoize(input, 5, inlineRight_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "inlineRight"

    public static class assign_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assign"
    // src/antlr/Vitry.g:131:1: assign : left '=' expr -> ^( Assign left expr ) ;
    public final VitryParser.assign_return assign() throws RecognitionException {
        VitryParser.assign_return retval = new VitryParser.assign_return();
        retval.start = input.LT(1);
        int assign_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal72=null;
        VitryParser.left_return left71 = null;

        VitryParser.expr_return expr73 = null;


        Object char_literal72_tree=null;
        RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
        RewriteRuleSubtreeStream stream_left=new RewriteRuleSubtreeStream(adaptor,"rule left");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return retval; }
            // src/antlr/Vitry.g:132:5: ( left '=' expr -> ^( Assign left expr ) )
            // src/antlr/Vitry.g:132:7: left '=' expr
            {
            pushFollow(FOLLOW_left_in_assign1124);
            left71=left();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_left.add(left71.getTree());
            char_literal72=(Token)match(input,49,FOLLOW_49_in_assign1126); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_49.add(char_literal72);

            pushFollow(FOLLOW_expr_in_assign1128);
            expr73=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expr.add(expr73.getTree());


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
            // 132:29: -> ^( Assign left expr )
            {
                // src/antlr/Vitry.g:132:32: ^( Assign left expr )
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
            if ( state.backtracking>0 ) { memoize(input, 6, assign_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "assign"

    public static class apply_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "apply"
    // src/antlr/Vitry.g:136:1: apply : ( ( expr expr )=> ( expr )+ -> ^( Apply ( expr )+ ) | expr );
    public final VitryParser.apply_return apply() throws RecognitionException {
        VitryParser.apply_return retval = new VitryParser.apply_return();
        retval.start = input.LT(1);
        int apply_StartIndex = input.index();
        Object root_0 = null;

        VitryParser.expr_return expr74 = null;

        VitryParser.expr_return expr75 = null;


        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return retval; }
            // src/antlr/Vitry.g:137:5: ( ( expr expr )=> ( expr )+ -> ^( Apply ( expr )+ ) | expr )
            int alt22=2;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1 :
                    // src/antlr/Vitry.g:137:7: ( expr expr )=> ( expr )+
                    {
                    // src/antlr/Vitry.g:137:22: ( expr )+
                    int cnt21=0;
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( ((LA21_0>=Symbol && LA21_0<=String)||LA21_0==36||LA21_0==38||LA21_0==40||LA21_0==42) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:137:22: expr
                    	    {
                    	    pushFollow(FOLLOW_expr_in_apply1176);
                    	    expr74=expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_expr.add(expr74.getTree());

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
                    // 137:29: -> ^( Apply ( expr )+ )
                    {
                        // src/antlr/Vitry.g:137:32: ^( Apply ( expr )+ )
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
                    // src/antlr/Vitry.g:138:7: expr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_expr_in_apply1195);
                    expr75=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr75.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 7, apply_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "apply"

    public static class module_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "module"
    // src/antlr/Vitry.g:146:1: module : 'module' moduleName ( '(' (exports+= Symbol )* ')' )? ( 'import' (imports+= moduleName )* )* ( '(' declarations+= declaration ')' )* ;
    public final VitryParser.module_return module() throws RecognitionException {
        VitryParser.module_return retval = new VitryParser.module_return();
        retval.start = input.LT(1);
        int module_StartIndex = input.index();
        Object root_0 = null;

        Token string_literal76=null;
        Token char_literal78=null;
        Token char_literal79=null;
        Token string_literal80=null;
        Token char_literal81=null;
        Token char_literal82=null;
        Token exports=null;
        List list_exports=null;
        List list_imports=null;
        List list_declarations=null;
        VitryParser.moduleName_return moduleName77 = null;

        RuleReturnScope imports = null;
        RuleReturnScope declarations = null;
        Object string_literal76_tree=null;
        Object char_literal78_tree=null;
        Object char_literal79_tree=null;
        Object string_literal80_tree=null;
        Object char_literal81_tree=null;
        Object char_literal82_tree=null;
        Object exports_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return retval; }
            // src/antlr/Vitry.g:147:5: ( 'module' moduleName ( '(' (exports+= Symbol )* ')' )? ( 'import' (imports+= moduleName )* )* ( '(' declarations+= declaration ')' )* )
            // src/antlr/Vitry.g:147:7: 'module' moduleName ( '(' (exports+= Symbol )* ')' )? ( 'import' (imports+= moduleName )* )* ( '(' declarations+= declaration ')' )*
            {
            root_0 = (Object)adaptor.nil();

            string_literal76=(Token)match(input,50,FOLLOW_50_in_module1216); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal76_tree = (Object)adaptor.create(string_literal76);
            adaptor.addChild(root_0, string_literal76_tree);
            }
            pushFollow(FOLLOW_moduleName_in_module1218);
            moduleName77=moduleName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, moduleName77.getTree());
            // src/antlr/Vitry.g:148:7: ( '(' (exports+= Symbol )* ')' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==36) ) {
                int LA24_1 = input.LA(2);

                if ( (LA24_1==Symbol) ) {
                    int LA24_3 = input.LA(3);

                    if ( (LA24_3==Symbol||LA24_3==37) ) {
                        alt24=1;
                    }
                }
                else if ( (LA24_1==37) ) {
                    alt24=1;
                }
            }
            switch (alt24) {
                case 1 :
                    // src/antlr/Vitry.g:149:9: '(' (exports+= Symbol )* ')'
                    {
                    char_literal78=(Token)match(input,36,FOLLOW_36_in_module1238); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal78_tree = (Object)adaptor.create(char_literal78);
                    adaptor.addChild(root_0, char_literal78_tree);
                    }
                    // src/antlr/Vitry.g:149:20: (exports+= Symbol )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==Symbol) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:149:20: exports+= Symbol
                    	    {
                    	    exports=(Token)match(input,Symbol,FOLLOW_Symbol_in_module1242); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    exports_tree = (Object)adaptor.create(exports);
                    	    adaptor.addChild(root_0, exports_tree);
                    	    }
                    	    if (list_exports==null) list_exports=new ArrayList();
                    	    list_exports.add(exports);


                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);

                    char_literal79=(Token)match(input,37,FOLLOW_37_in_module1245); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal79_tree = (Object)adaptor.create(char_literal79);
                    adaptor.addChild(root_0, char_literal79_tree);
                    }

                    }
                    break;

            }

            // src/antlr/Vitry.g:151:7: ( 'import' (imports+= moduleName )* )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==51) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // src/antlr/Vitry.g:152:9: 'import' (imports+= moduleName )*
            	    {
            	    string_literal80=(Token)match(input,51,FOLLOW_51_in_module1274); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal80_tree = (Object)adaptor.create(string_literal80);
            	    adaptor.addChild(root_0, string_literal80_tree);
            	    }
            	    // src/antlr/Vitry.g:152:25: (imports+= moduleName )*
            	    loop25:
            	    do {
            	        int alt25=2;
            	        int LA25_0 = input.LA(1);

            	        if ( (LA25_0==Symbol) ) {
            	            alt25=1;
            	        }


            	        switch (alt25) {
            	    	case 1 :
            	    	    // src/antlr/Vitry.g:152:25: imports+= moduleName
            	    	    {
            	    	    pushFollow(FOLLOW_moduleName_in_module1278);
            	    	    imports=moduleName();

            	    	    state._fsp--;
            	    	    if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, imports.getTree());
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

            // src/antlr/Vitry.g:154:7: ( '(' declarations+= declaration ')' )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==36) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // src/antlr/Vitry.g:155:9: '(' declarations+= declaration ')'
            	    {
            	    char_literal81=(Token)match(input,36,FOLLOW_36_in_module1307); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal81_tree = (Object)adaptor.create(char_literal81);
            	    adaptor.addChild(root_0, char_literal81_tree);
            	    }
            	    pushFollow(FOLLOW_declaration_in_module1311);
            	    declarations=declaration();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, declarations.getTree());
            	    if (list_declarations==null) list_declarations=new ArrayList();
            	    list_declarations.add(declarations.getTree());

            	    char_literal82=(Token)match(input,37,FOLLOW_37_in_module1313); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal82_tree = (Object)adaptor.create(char_literal82);
            	    adaptor.addChild(root_0, char_literal82_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);


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
            if ( state.backtracking>0 ) { memoize(input, 8, module_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "module"

    public static class declaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "declaration"
    // src/antlr/Vitry.g:160:1: declaration : left '=' expr ;
    public final VitryParser.declaration_return declaration() throws RecognitionException {
        VitryParser.declaration_return retval = new VitryParser.declaration_return();
        retval.start = input.LT(1);
        int declaration_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal84=null;
        VitryParser.left_return left83 = null;

        VitryParser.expr_return expr85 = null;


        Object char_literal84_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return retval; }
            // src/antlr/Vitry.g:161:5: ( left '=' expr )
            // src/antlr/Vitry.g:161:7: left '=' expr
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_left_in_declaration1351);
            left83=left();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, left83.getTree());
            char_literal84=(Token)match(input,49,FOLLOW_49_in_declaration1353); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal84_tree = (Object)adaptor.create(char_literal84);
            adaptor.addChild(root_0, char_literal84_tree);
            }
            pushFollow(FOLLOW_expr_in_declaration1355);
            expr85=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expr85.getTree());

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
            if ( state.backtracking>0 ) { memoize(input, 9, declaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "declaration"

    public static class moduleName_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "moduleName"
    // src/antlr/Vitry.g:175:1: moduleName : Symbol ( Op Symbol )* -> ^( Symbol ( Symbol )* ) ;
    public final VitryParser.moduleName_return moduleName() throws RecognitionException {
        VitryParser.moduleName_return retval = new VitryParser.moduleName_return();
        retval.start = input.LT(1);
        int moduleName_StartIndex = input.index();
        Object root_0 = null;

        Token Symbol86=null;
        Token Op87=null;
        Token Symbol88=null;

        Object Symbol86_tree=null;
        Object Op87_tree=null;
        Object Symbol88_tree=null;
        RewriteRuleTokenStream stream_Op=new RewriteRuleTokenStream(adaptor,"token Op");
        RewriteRuleTokenStream stream_Symbol=new RewriteRuleTokenStream(adaptor,"token Symbol");

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return retval; }
            // src/antlr/Vitry.g:175:12: ( Symbol ( Op Symbol )* -> ^( Symbol ( Symbol )* ) )
            // src/antlr/Vitry.g:176:5: Symbol ( Op Symbol )*
            {
            Symbol86=(Token)match(input,Symbol,FOLLOW_Symbol_in_moduleName1430); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_Symbol.add(Symbol86);

            // src/antlr/Vitry.g:176:12: ( Op Symbol )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==Op) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // src/antlr/Vitry.g:176:13: Op Symbol
            	    {
            	    Op87=(Token)match(input,Op,FOLLOW_Op_in_moduleName1433); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_Op.add(Op87);

            	    Symbol88=(Token)match(input,Symbol,FOLLOW_Symbol_in_moduleName1435); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_Symbol.add(Symbol88);


            	    }
            	    break;

            	default :
            	    break loop28;
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
            // 176:25: -> ^( Symbol ( Symbol )* )
            {
                // src/antlr/Vitry.g:176:28: ^( Symbol ( Symbol )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_Symbol.nextNode(), root_1);

                // src/antlr/Vitry.g:176:37: ( Symbol )*
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
            if ( state.backtracking>0 ) { memoize(input, 10, moduleName_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "moduleName"

    // $ANTLR start synpred1_Vitry
    public final void synpred1_Vitry_fragment() throws RecognitionException {   
        // src/antlr/Vitry.g:72:7: ( delim[true] ':' )
        // src/antlr/Vitry.g:72:8: delim[true] ':'
        {
        pushFollow(FOLLOW_delim_in_synpred1_Vitry267);
        delim(true);

        state._fsp--;
        if (state.failed) return ;
        match(input,35,FOLLOW_35_in_synpred1_Vitry270); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_Vitry

    // $ANTLR start synpred2_Vitry
    public final void synpred2_Vitry_fragment() throws RecognitionException {   
        // src/antlr/Vitry.g:81:7: ( delim[false] ':' )
        // src/antlr/Vitry.g:81:8: delim[false] ':'
        {
        pushFollow(FOLLOW_delim_in_synpred2_Vitry325);
        delim(false);

        state._fsp--;
        if (state.failed) return ;
        match(input,35,FOLLOW_35_in_synpred2_Vitry328); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_Vitry

    // $ANTLR start synpred3_Vitry
    public final void synpred3_Vitry_fragment() throws RecognitionException {   
        // src/antlr/Vitry.g:108:7: ( Op ( ')' | ']' | '}' ) )
        // src/antlr/Vitry.g:108:8: Op ( ')' | ']' | '}' )
        {
        match(input,Op,FOLLOW_Op_in_synpred3_Vitry615); if (state.failed) return ;
        if ( input.LA(1)==37||input.LA(1)==39||input.LA(1)==41 ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }


        }
    }
    // $ANTLR end synpred3_Vitry

    // $ANTLR start synpred4_Vitry
    public final void synpred4_Vitry_fragment() throws RecognitionException {   
        // src/antlr/Vitry.g:110:7: ( apply Op )
        // src/antlr/Vitry.g:110:8: apply Op
        {
        pushFollow(FOLLOW_apply_in_synpred4_Vitry694);
        apply();

        state._fsp--;
        if (state.failed) return ;
        match(input,Op,FOLLOW_Op_in_synpred4_Vitry696); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_Vitry

    // $ANTLR start synpred5_Vitry
    public final void synpred5_Vitry_fragment() throws RecognitionException {   
        // src/antlr/Vitry.g:137:7: ( expr expr )
        // src/antlr/Vitry.g:137:8: expr expr
        {
        pushFollow(FOLLOW_expr_in_synpred5_Vitry1169);
        expr();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_expr_in_synpred5_Vitry1171);
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


    protected DFA1 dfa1 = new DFA1(this);
    protected DFA2 dfa2 = new DFA2(this);
    protected DFA6 dfa6 = new DFA6(this);
    protected DFA9 dfa9 = new DFA9(this);
    protected DFA20 dfa20 = new DFA20(this);
    protected DFA22 dfa22 = new DFA22(this);
    static final String DFA1_eotS =
        "\14\uffff";
    static final String DFA1_eofS =
        "\14\uffff";
    static final String DFA1_minS =
        "\1\30\11\0\2\uffff";
    static final String DFA1_maxS =
        "\1\52\11\0\2\uffff";
    static final String DFA1_acceptS =
        "\12\uffff\1\1\1\2";
    static final String DFA1_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\2\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\5\1\6\1\7\1\10\1\11\7\uffff\1\1\1\uffff\1\2\1\uffff\1\3\1"+
            "\uffff\1\4",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            ""
    };

    static final short[] DFA1_eot = DFA.unpackEncodedString(DFA1_eotS);
    static final short[] DFA1_eof = DFA.unpackEncodedString(DFA1_eofS);
    static final char[] DFA1_min = DFA.unpackEncodedStringToUnsignedChars(DFA1_minS);
    static final char[] DFA1_max = DFA.unpackEncodedStringToUnsignedChars(DFA1_maxS);
    static final short[] DFA1_accept = DFA.unpackEncodedString(DFA1_acceptS);
    static final short[] DFA1_special = DFA.unpackEncodedString(DFA1_specialS);
    static final short[][] DFA1_transition;

    static {
        int numStates = DFA1_transitionS.length;
        DFA1_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA1_transition[i] = DFA.unpackEncodedString(DFA1_transitionS[i]);
        }
    }

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = DFA1_eot;
            this.eof = DFA1_eof;
            this.min = DFA1_min;
            this.max = DFA1_max;
            this.accept = DFA1_accept;
            this.special = DFA1_special;
            this.transition = DFA1_transition;
        }
        public String getDescription() {
            return "71:1: expr : ( ( delim[true] ':' )=> delim[true] ':' expr -> ^( Type delim expr ) | delim[true] );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA1_1 = input.LA(1);

                         
                        int index1_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_Vitry()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index1_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA1_2 = input.LA(1);

                         
                        int index1_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_Vitry()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index1_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA1_3 = input.LA(1);

                         
                        int index1_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_Vitry()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index1_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA1_4 = input.LA(1);

                         
                        int index1_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_Vitry()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index1_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA1_5 = input.LA(1);

                         
                        int index1_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_Vitry()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index1_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA1_6 = input.LA(1);

                         
                        int index1_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_Vitry()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index1_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA1_7 = input.LA(1);

                         
                        int index1_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_Vitry()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index1_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA1_8 = input.LA(1);

                         
                        int index1_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_Vitry()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index1_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA1_9 = input.LA(1);

                         
                        int index1_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_Vitry()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index1_9);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 1, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA2_eotS =
        "\14\uffff";
    static final String DFA2_eofS =
        "\14\uffff";
    static final String DFA2_minS =
        "\1\30\11\0\2\uffff";
    static final String DFA2_maxS =
        "\1\52\11\0\2\uffff";
    static final String DFA2_acceptS =
        "\12\uffff\1\1\1\2";
    static final String DFA2_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\2\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\5\1\6\1\7\1\10\1\11\7\uffff\1\1\1\uffff\1\2\1\uffff\1\3\1"+
            "\uffff\1\4",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            ""
    };

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "80:1: left : ( ( delim[false] ':' )=> delim[false] ':' expr -> ^( Left ^( Type delim expr ) ) | delim[false] -> ^( Left delim ) );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA2_1 = input.LA(1);

                         
                        int index2_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_Vitry()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index2_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA2_2 = input.LA(1);

                         
                        int index2_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_Vitry()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index2_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA2_3 = input.LA(1);

                         
                        int index2_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_Vitry()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index2_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA2_4 = input.LA(1);

                         
                        int index2_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_Vitry()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index2_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA2_5 = input.LA(1);

                         
                        int index2_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_Vitry()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index2_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA2_6 = input.LA(1);

                         
                        int index2_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_Vitry()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index2_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA2_7 = input.LA(1);

                         
                        int index2_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_Vitry()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index2_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA2_8 = input.LA(1);

                         
                        int index2_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_Vitry()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index2_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA2_9 = input.LA(1);

                         
                        int index2_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_Vitry()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index2_9);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 2, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA6_eotS =
        "\14\uffff";
    static final String DFA6_eofS =
        "\14\uffff";
    static final String DFA6_minS =
        "\1\30\3\uffff\1\27\7\uffff";
    static final String DFA6_maxS =
        "\1\52\3\uffff\1\52\7\uffff";
    static final String DFA6_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\uffff\1\6\1\7\1\10\1\11\1\12\1\4\1\5";
    static final String DFA6_specialS =
        "\14\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\5\1\6\1\7\1\10\1\11\7\uffff\1\1\1\uffff\1\2\1\uffff\1\3\1"+
            "\uffff\1\4",
            "",
            "",
            "",
            "\1\12\5\13\7\uffff\1\13\1\uffff\1\13\1\uffff\1\13\1\uffff\1"+
            "\13",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "88:1: delim[boolean rs] : ( '(' ( inline[rs] )? ')' -> ^( Par ( inline )? ) | '[' ( inline[rs] )? ']' -> ^( Bra ( inline )? ) | '{' ( inline[rs] )? '}' -> ^( Ang ( inline )? ) | '`' Op -> ^( Quote Op ) | '`' delim[rs] -> ^( Quote delim ) | Symbol | Natural | Float | Complex | String );";
        }
    }
    static final String DFA9_eotS =
        "\24\uffff";
    static final String DFA9_eofS =
        "\24\uffff";
    static final String DFA9_minS =
        "\1\27\5\uffff\12\0\4\uffff";
    static final String DFA9_maxS =
        "\1\57\5\uffff\12\0\4\uffff";
    static final String DFA9_acceptS =
        "\1\uffff\1\1\16\uffff\1\2\1\3\1\4\1\5";
    static final String DFA9_specialS =
        "\6\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\4\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\6\1\13\1\14\1\15\1\16\1\17\7\uffff\1\7\1\uffff\1\10\1\uffff"+
            "\1\11\1\uffff\1\12\5\1",
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
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "106:1: inline[boolean rs] : ({...}? inlineRight | ( Op ( ')' | ']' | '}' ) )=> Op | ( Op apply )+ -> ^( Ops ( ^( Op apply ) )+ ) | ( apply Op )=>e= apply ( Op f+= apply )+ -> ^( Ops $e ( ^( Op $f) )+ ) | apply );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA9_6 = input.LA(1);

                         
                        int index9_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_Vitry()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index9_6);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA9_7 = input.LA(1);

                         
                        int index9_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Vitry()) ) {s = 18;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index9_7);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA9_8 = input.LA(1);

                         
                        int index9_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Vitry()) ) {s = 18;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index9_8);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA9_9 = input.LA(1);

                         
                        int index9_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Vitry()) ) {s = 18;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index9_9);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA9_10 = input.LA(1);

                         
                        int index9_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Vitry()) ) {s = 18;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index9_10);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA9_11 = input.LA(1);

                         
                        int index9_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Vitry()) ) {s = 18;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index9_11);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA9_12 = input.LA(1);

                         
                        int index9_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Vitry()) ) {s = 18;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index9_12);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA9_13 = input.LA(1);

                         
                        int index9_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Vitry()) ) {s = 18;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index9_13);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA9_14 = input.LA(1);

                         
                        int index9_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Vitry()) ) {s = 18;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index9_14);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA9_15 = input.LA(1);

                         
                        int index9_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Vitry()) ) {s = 18;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index9_15);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 9, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA20_eotS =
        "\14\uffff";
    static final String DFA20_eofS =
        "\14\uffff";
    static final String DFA20_minS =
        "\1\53\3\44\10\uffff";
    static final String DFA20_maxS =
        "\1\57\3\46\10\uffff";
    static final String DFA20_acceptS =
        "\4\uffff\1\7\1\10\1\1\1\2\1\3\1\4\1\5\1\6";
    static final String DFA20_specialS =
        "\14\uffff}>";
    static final String[] DFA20_transitionS = {
            "\1\1\1\2\1\3\1\4\1\5",
            "\1\6\1\uffff\1\7",
            "\1\10\1\uffff\1\11",
            "\1\12\1\uffff\1\13",
            "",
            "",
            "",
            "",
            "",
            "",
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
            return "120:1: inlineRight : ( 'fn' '(' ( left )* ')' inline[true] -> ^( Fn ( left )* inline ) | 'fn' '[' ( left )* ']' inline[true] -> ^( Fn ( left )* inline ) | 'let' '(' ( assign )* ')' inline[true] -> ^( Let ( assign )* inline ) | 'let' '[' ( assign )* ']' inline[true] -> ^( Let ( assign )* inline ) | 'do' '(' ( assign )* ')' ( expr )* -> ^( Do ( assign )* ( expr )* ) | 'do' '[' ( assign )* ']' ( expr )* -> ^( Do ( assign )* ( expr )* ) | 'match' v= expr '(' (c+= left e+= expr )* ')' -> ^( Match $v ( ^( $c $e) )* ) | 'if' expr expr ( 'else' )? inline[true] -> ^( If expr expr inline ) );";
        }
    }
    static final String DFA22_eotS =
        "\14\uffff";
    static final String DFA22_eofS =
        "\14\uffff";
    static final String DFA22_minS =
        "\1\30\11\0\2\uffff";
    static final String DFA22_maxS =
        "\1\52\11\0\2\uffff";
    static final String DFA22_acceptS =
        "\12\uffff\1\1\1\2";
    static final String DFA22_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\2\uffff}>";
    static final String[] DFA22_transitionS = {
            "\1\5\1\6\1\7\1\10\1\11\7\uffff\1\1\1\uffff\1\2\1\uffff\1\3\1"+
            "\uffff\1\4",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            ""
    };

    static final short[] DFA22_eot = DFA.unpackEncodedString(DFA22_eotS);
    static final short[] DFA22_eof = DFA.unpackEncodedString(DFA22_eofS);
    static final char[] DFA22_min = DFA.unpackEncodedStringToUnsignedChars(DFA22_minS);
    static final char[] DFA22_max = DFA.unpackEncodedStringToUnsignedChars(DFA22_maxS);
    static final short[] DFA22_accept = DFA.unpackEncodedString(DFA22_acceptS);
    static final short[] DFA22_special = DFA.unpackEncodedString(DFA22_specialS);
    static final short[][] DFA22_transition;

    static {
        int numStates = DFA22_transitionS.length;
        DFA22_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA22_transition[i] = DFA.unpackEncodedString(DFA22_transitionS[i]);
        }
    }

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = DFA22_eot;
            this.eof = DFA22_eof;
            this.min = DFA22_min;
            this.max = DFA22_max;
            this.accept = DFA22_accept;
            this.special = DFA22_special;
            this.transition = DFA22_transition;
        }
        public String getDescription() {
            return "136:1: apply : ( ( expr expr )=> ( expr )+ -> ^( Apply ( expr )+ ) | expr );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA22_1 = input.LA(1);

                         
                        int index22_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_Vitry()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index22_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA22_2 = input.LA(1);

                         
                        int index22_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_Vitry()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index22_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA22_3 = input.LA(1);

                         
                        int index22_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_Vitry()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index22_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA22_4 = input.LA(1);

                         
                        int index22_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_Vitry()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index22_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA22_5 = input.LA(1);

                         
                        int index22_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_Vitry()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index22_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA22_6 = input.LA(1);

                         
                        int index22_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_Vitry()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index22_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA22_7 = input.LA(1);

                         
                        int index22_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_Vitry()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index22_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA22_8 = input.LA(1);

                         
                        int index22_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_Vitry()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index22_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA22_9 = input.LA(1);

                         
                        int index22_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_Vitry()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index22_9);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 22, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_delim_in_expr275 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_expr278 = new BitSet(new long[]{0x000005501F000000L});
    public static final BitSet FOLLOW_expr_in_expr280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_delim_in_expr300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_delim_in_left333 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_left336 = new BitSet(new long[]{0x000005501F000000L});
    public static final BitSet FOLLOW_expr_in_left338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_delim_in_left360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_delim421 = new BitSet(new long[]{0x0000FD701F800000L});
    public static final BitSet FOLLOW_inline_in_delim423 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_delim427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_delim445 = new BitSet(new long[]{0x0000FDD01F800000L});
    public static final BitSet FOLLOW_inline_in_delim447 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_delim451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_delim469 = new BitSet(new long[]{0x0000FF501F800000L});
    public static final BitSet FOLLOW_inline_in_delim471 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_delim475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_delim493 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_Op_in_delim495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_delim525 = new BitSet(new long[]{0x000005501F000000L});
    public static final BitSet FOLLOW_delim_in_delim527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Symbol_in_delim551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Natural_in_delim559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Float_in_delim567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Complex_in_delim575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_String_in_delim583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inlineRight_in_inline606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Op_in_inline632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Op_in_inline641 = new BitSet(new long[]{0x000005501F000000L});
    public static final BitSet FOLLOW_apply_in_inline643 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_apply_in_inline703 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_Op_in_inline706 = new BitSet(new long[]{0x000005501F000000L});
    public static final BitSet FOLLOW_apply_in_inline710 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_apply_in_inline741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_inlineRight782 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_inlineRight786 = new BitSet(new long[]{0x000005701F000000L});
    public static final BitSet FOLLOW_left_in_inlineRight788 = new BitSet(new long[]{0x000005701F000000L});
    public static final BitSet FOLLOW_37_in_inlineRight793 = new BitSet(new long[]{0x0000FD501F800000L});
    public static final BitSet FOLLOW_inline_in_inlineRight795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_inlineRight822 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_inlineRight826 = new BitSet(new long[]{0x000005D01F000000L});
    public static final BitSet FOLLOW_left_in_inlineRight828 = new BitSet(new long[]{0x000005D01F000000L});
    public static final BitSet FOLLOW_39_in_inlineRight833 = new BitSet(new long[]{0x0000FD501F800000L});
    public static final BitSet FOLLOW_inline_in_inlineRight835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_inlineRight862 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_inlineRight865 = new BitSet(new long[]{0x000005701F000000L});
    public static final BitSet FOLLOW_assign_in_inlineRight867 = new BitSet(new long[]{0x000005701F000000L});
    public static final BitSet FOLLOW_37_in_inlineRight870 = new BitSet(new long[]{0x0000FD501F800000L});
    public static final BitSet FOLLOW_inline_in_inlineRight872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_inlineRight899 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_inlineRight902 = new BitSet(new long[]{0x000005D01F000000L});
    public static final BitSet FOLLOW_assign_in_inlineRight904 = new BitSet(new long[]{0x000005D01F000000L});
    public static final BitSet FOLLOW_39_in_inlineRight907 = new BitSet(new long[]{0x0000FD501F800000L});
    public static final BitSet FOLLOW_inline_in_inlineRight909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_inlineRight936 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_inlineRight940 = new BitSet(new long[]{0x000005701F000000L});
    public static final BitSet FOLLOW_assign_in_inlineRight942 = new BitSet(new long[]{0x000005701F000000L});
    public static final BitSet FOLLOW_37_in_inlineRight945 = new BitSet(new long[]{0x000005501F000002L});
    public static final BitSet FOLLOW_expr_in_inlineRight947 = new BitSet(new long[]{0x000005501F000002L});
    public static final BitSet FOLLOW_45_in_inlineRight982 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_inlineRight986 = new BitSet(new long[]{0x000005D01F000000L});
    public static final BitSet FOLLOW_assign_in_inlineRight988 = new BitSet(new long[]{0x000005D01F000000L});
    public static final BitSet FOLLOW_39_in_inlineRight991 = new BitSet(new long[]{0x000005501F000002L});
    public static final BitSet FOLLOW_expr_in_inlineRight993 = new BitSet(new long[]{0x000005501F000002L});
    public static final BitSet FOLLOW_46_in_inlineRight1028 = new BitSet(new long[]{0x000005501F000000L});
    public static final BitSet FOLLOW_expr_in_inlineRight1032 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_inlineRight1034 = new BitSet(new long[]{0x000005701F000000L});
    public static final BitSet FOLLOW_left_in_inlineRight1039 = new BitSet(new long[]{0x000005501F000000L});
    public static final BitSet FOLLOW_expr_in_inlineRight1043 = new BitSet(new long[]{0x000005701F000000L});
    public static final BitSet FOLLOW_37_in_inlineRight1047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_inlineRight1078 = new BitSet(new long[]{0x000005501F000000L});
    public static final BitSet FOLLOW_expr_in_inlineRight1080 = new BitSet(new long[]{0x000005501F000000L});
    public static final BitSet FOLLOW_expr_in_inlineRight1082 = new BitSet(new long[]{0x0001FD501F800000L});
    public static final BitSet FOLLOW_48_in_inlineRight1084 = new BitSet(new long[]{0x0000FD501F800000L});
    public static final BitSet FOLLOW_inline_in_inlineRight1087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_left_in_assign1124 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_assign1126 = new BitSet(new long[]{0x000005501F000000L});
    public static final BitSet FOLLOW_expr_in_assign1128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_apply1176 = new BitSet(new long[]{0x000005501F000002L});
    public static final BitSet FOLLOW_expr_in_apply1195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_module1216 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_moduleName_in_module1218 = new BitSet(new long[]{0x0008001000000002L});
    public static final BitSet FOLLOW_36_in_module1238 = new BitSet(new long[]{0x0000002001000000L});
    public static final BitSet FOLLOW_Symbol_in_module1242 = new BitSet(new long[]{0x0000002001000000L});
    public static final BitSet FOLLOW_37_in_module1245 = new BitSet(new long[]{0x0008001000000002L});
    public static final BitSet FOLLOW_51_in_module1274 = new BitSet(new long[]{0x0008001001000002L});
    public static final BitSet FOLLOW_moduleName_in_module1278 = new BitSet(new long[]{0x0008001001000002L});
    public static final BitSet FOLLOW_36_in_module1307 = new BitSet(new long[]{0x000005501F000000L});
    public static final BitSet FOLLOW_declaration_in_module1311 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_module1313 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_left_in_declaration1351 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_declaration1353 = new BitSet(new long[]{0x000005501F000000L});
    public static final BitSet FOLLOW_expr_in_declaration1355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Symbol_in_moduleName1430 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_Op_in_moduleName1433 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_Symbol_in_moduleName1435 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_delim_in_synpred1_Vitry267 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_synpred1_Vitry270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_delim_in_synpred2_Vitry325 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_synpred2_Vitry328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Op_in_synpred3_Vitry615 = new BitSet(new long[]{0x000002A000000000L});
    public static final BitSet FOLLOW_set_in_synpred3_Vitry617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_apply_in_synpred4_Vitry694 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_Op_in_synpred4_Vitry696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_synpred5_Vitry1169 = new BitSet(new long[]{0x000005501F000000L});
    public static final BitSet FOLLOW_expr_in_synpred5_Vitry1171 = new BitSet(new long[]{0x0000000000000002L});

}