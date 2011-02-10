// $ANTLR 3.2 Sep 23, 2009 12:02:23 src/antlr/Vitry.g 2011-02-09 23:53:51
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
            this.state.ruleMemo = new HashMap[12+1];
             
             
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
    // src/antlr/Vitry.g:63:1: expr : ( ( delim[true] ':' )=> delim[true] ':' expr -> ^( Type delim expr ) | delim[true] );
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
        RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        RewriteRuleSubtreeStream stream_delim=new RewriteRuleSubtreeStream(adaptor,"rule delim");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return retval; }
            // src/antlr/Vitry.g:64:5: ( ( delim[true] ':' )=> delim[true] ':' expr -> ^( Type delim expr ) | delim[true] )
            int alt1=2;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // src/antlr/Vitry.g:64:7: ( delim[true] ':' )=> delim[true] ':' expr
                    {
                    pushFollow(FOLLOW_delim_in_expr246);
                    delim1=delim(true);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_delim.add(delim1.getTree());
                    char_literal2=(Token)match(input,38,FOLLOW_38_in_expr249); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_38.add(char_literal2);

                    pushFollow(FOLLOW_expr_in_expr251);
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
                    // 64:52: -> ^( Type delim expr )
                    {
                        // src/antlr/Vitry.g:64:55: ^( Type delim expr )
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
                    // src/antlr/Vitry.g:65:7: delim[true]
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_delim_in_expr272);
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
    // src/antlr/Vitry.g:72:1: left : ( ( delim[false] ':' )=> delim[false] ':' expr -> ^( Left ^( Type delim expr ) ) | delim[false] -> ^( Left delim ) );
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
        RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        RewriteRuleSubtreeStream stream_delim=new RewriteRuleSubtreeStream(adaptor,"rule delim");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return retval; }
            // src/antlr/Vitry.g:73:5: ( ( delim[false] ':' )=> delim[false] ':' expr -> ^( Left ^( Type delim expr ) ) | delim[false] -> ^( Left delim ) )
            int alt2=2;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // src/antlr/Vitry.g:73:7: ( delim[false] ':' )=> delim[false] ':' expr
                    {
                    pushFollow(FOLLOW_delim_in_left305);
                    delim5=delim(false);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_delim.add(delim5.getTree());
                    char_literal6=(Token)match(input,38,FOLLOW_38_in_left308); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_38.add(char_literal6);

                    pushFollow(FOLLOW_expr_in_left310);
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
                    // 73:52: -> ^( Left ^( Type delim expr ) )
                    {
                        // src/antlr/Vitry.g:73:55: ^( Left ^( Type delim expr ) )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Left, "Left"), root_1);

                        // src/antlr/Vitry.g:73:62: ^( Type delim expr )
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
                    // src/antlr/Vitry.g:74:7: delim[false]
                    {
                    pushFollow(FOLLOW_delim_in_left333);
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
                    // 74:52: -> ^( Left delim )
                    {
                        // src/antlr/Vitry.g:74:55: ^( Left delim )
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
    // src/antlr/Vitry.g:80:1: delim[boolean rs] : ( '(' ( inline[rs] )? ')' -> ^( Par ( inline )? ) | '[' ( inline[rs] )? ']' -> ^( Bra ( inline )? ) | '{' ( inline[rs] )? '}' -> ^( Ang ( inline )? ) | '`' Op -> ^( Quote Op ) | '`' delim[rs] -> ^( Quote delim ) | Symbol | Natural | Float | Complex | String );
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }
            // src/antlr/Vitry.g:81:5: ( '(' ( inline[rs] )? ')' -> ^( Par ( inline )? ) | '[' ( inline[rs] )? ']' -> ^( Bra ( inline )? ) | '{' ( inline[rs] )? '}' -> ^( Ang ( inline )? ) | '`' Op -> ^( Quote Op ) | '`' delim[rs] -> ^( Quote delim ) | Symbol | Natural | Float | Complex | String )
            int alt6=10;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // src/antlr/Vitry.g:81:7: '(' ( inline[rs] )? ')'
                    {
                    char_literal9=(Token)match(input,39,FOLLOW_39_in_delim395); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_39.add(char_literal9);

                    // src/antlr/Vitry.g:81:11: ( inline[rs] )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( ((LA3_0>=Op && LA3_0<=String)||LA3_0==39||LA3_0==41||LA3_0==43||(LA3_0>=45 && LA3_0<=51)||LA3_0==53) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // src/antlr/Vitry.g:81:11: inline[rs]
                            {
                            pushFollow(FOLLOW_inline_in_delim397);
                            inline10=inline(rs);

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_inline.add(inline10.getTree());

                            }
                            break;

                    }

                    char_literal11=(Token)match(input,40,FOLLOW_40_in_delim401); if (state.failed) return retval; 
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
                    // 81:33: -> ^( Par ( inline )? )
                    {
                        // src/antlr/Vitry.g:81:36: ^( Par ( inline )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Par, "Par"), root_1);

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
                case 2 :
                    // src/antlr/Vitry.g:82:7: '[' ( inline[rs] )? ']'
                    {
                    char_literal12=(Token)match(input,41,FOLLOW_41_in_delim424); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_41.add(char_literal12);

                    // src/antlr/Vitry.g:82:11: ( inline[rs] )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( ((LA4_0>=Op && LA4_0<=String)||LA4_0==39||LA4_0==41||LA4_0==43||(LA4_0>=45 && LA4_0<=51)||LA4_0==53) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // src/antlr/Vitry.g:82:11: inline[rs]
                            {
                            pushFollow(FOLLOW_inline_in_delim426);
                            inline13=inline(rs);

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_inline.add(inline13.getTree());

                            }
                            break;

                    }

                    char_literal14=(Token)match(input,42,FOLLOW_42_in_delim430); if (state.failed) return retval; 
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
                    // 82:33: -> ^( Bra ( inline )? )
                    {
                        // src/antlr/Vitry.g:82:36: ^( Bra ( inline )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Bra, "Bra"), root_1);

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
                case 3 :
                    // src/antlr/Vitry.g:83:7: '{' ( inline[rs] )? '}'
                    {
                    char_literal15=(Token)match(input,43,FOLLOW_43_in_delim453); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_43.add(char_literal15);

                    // src/antlr/Vitry.g:83:11: ( inline[rs] )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( ((LA5_0>=Op && LA5_0<=String)||LA5_0==39||LA5_0==41||LA5_0==43||(LA5_0>=45 && LA5_0<=51)||LA5_0==53) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // src/antlr/Vitry.g:83:11: inline[rs]
                            {
                            pushFollow(FOLLOW_inline_in_delim455);
                            inline16=inline(rs);

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_inline.add(inline16.getTree());

                            }
                            break;

                    }

                    char_literal17=(Token)match(input,44,FOLLOW_44_in_delim459); if (state.failed) return retval; 
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
                    // 83:33: -> ^( Ang ( inline )? )
                    {
                        // src/antlr/Vitry.g:83:36: ^( Ang ( inline )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Ang, "Ang"), root_1);

                        // src/antlr/Vitry.g:83:42: ( inline )?
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
                    // src/antlr/Vitry.g:84:7: '`' Op
                    {
                    char_literal18=(Token)match(input,45,FOLLOW_45_in_delim482); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_45.add(char_literal18);

                    Op19=(Token)match(input,Op,FOLLOW_Op_in_delim484); if (state.failed) return retval; 
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
                    // 84:33: -> ^( Quote Op )
                    {
                        // src/antlr/Vitry.g:84:36: ^( Quote Op )
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
                    // src/antlr/Vitry.g:85:7: '`' delim[rs]
                    {
                    char_literal20=(Token)match(input,45,FOLLOW_45_in_delim519); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_45.add(char_literal20);

                    pushFollow(FOLLOW_delim_in_delim521);
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
                    // 85:33: -> ^( Quote delim )
                    {
                        // src/antlr/Vitry.g:85:36: ^( Quote delim )
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
                    // src/antlr/Vitry.g:86:7: Symbol
                    {
                    root_0 = (Object)adaptor.nil();

                    Symbol22=(Token)match(input,Symbol,FOLLOW_Symbol_in_delim550); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Symbol22_tree = (Object)adaptor.create(Symbol22);
                    adaptor.addChild(root_0, Symbol22_tree);
                    }

                    }
                    break;
                case 7 :
                    // src/antlr/Vitry.g:87:7: Natural
                    {
                    root_0 = (Object)adaptor.nil();

                    Natural23=(Token)match(input,Natural,FOLLOW_Natural_in_delim558); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Natural23_tree = (Object)adaptor.create(Natural23);
                    adaptor.addChild(root_0, Natural23_tree);
                    }

                    }
                    break;
                case 8 :
                    // src/antlr/Vitry.g:88:7: Float
                    {
                    root_0 = (Object)adaptor.nil();

                    Float24=(Token)match(input,Float,FOLLOW_Float_in_delim566); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Float24_tree = (Object)adaptor.create(Float24);
                    adaptor.addChild(root_0, Float24_tree);
                    }

                    }
                    break;
                case 9 :
                    // src/antlr/Vitry.g:89:7: Complex
                    {
                    root_0 = (Object)adaptor.nil();

                    Complex25=(Token)match(input,Complex,FOLLOW_Complex_in_delim574); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Complex25_tree = (Object)adaptor.create(Complex25);
                    adaptor.addChild(root_0, Complex25_tree);
                    }

                    }
                    break;
                case 10 :
                    // src/antlr/Vitry.g:90:7: String
                    {
                    root_0 = (Object)adaptor.nil();

                    String26=(Token)match(input,String,FOLLOW_String_in_delim582); if (state.failed) return retval;
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
    // src/antlr/Vitry.g:98:1: inline[boolean rs] : ({...}? inlineRight | ( Op ( ')' | ']' | '}' ) )=> Op | ( Op apply )+ -> ^( Ops ( ^( Op apply ) )+ ) | ( apply Op )=>e= apply ( Op f+= apply )+ -> ^( Ops $e ( ^( Op $f) )+ ) | apply );
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
            // src/antlr/Vitry.g:99:5: ({...}? inlineRight | ( Op ( ')' | ']' | '}' ) )=> Op | ( Op apply )+ -> ^( Ops ( ^( Op apply ) )+ ) | ( apply Op )=>e= apply ( Op f+= apply )+ -> ^( Ops $e ( ^( Op $f) )+ ) | apply )
            int alt9=5;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // src/antlr/Vitry.g:99:7: {...}? inlineRight
                    {
                    root_0 = (Object)adaptor.nil();

                    if ( !((rs)) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "inline", "$rs");
                    }
                    pushFollow(FOLLOW_inlineRight_in_inline605);
                    inlineRight27=inlineRight();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, inlineRight27.getTree());

                    }
                    break;
                case 2 :
                    // src/antlr/Vitry.g:100:7: ( Op ( ')' | ']' | '}' ) )=> Op
                    {
                    root_0 = (Object)adaptor.nil();

                    Op28=(Token)match(input,Op,FOLLOW_Op_in_inline631); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Op28_tree = (Object)adaptor.create(Op28);
                    adaptor.addChild(root_0, Op28_tree);
                    }

                    }
                    break;
                case 3 :
                    // src/antlr/Vitry.g:101:7: ( Op apply )+
                    {
                    // src/antlr/Vitry.g:101:7: ( Op apply )+
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
                    	    // src/antlr/Vitry.g:101:8: Op apply
                    	    {
                    	    Op29=(Token)match(input,Op,FOLLOW_Op_in_inline640); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_Op.add(Op29);

                    	    pushFollow(FOLLOW_apply_in_inline642);
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
                    // 101:57: -> ^( Ops ( ^( Op apply ) )+ )
                    {
                        // src/antlr/Vitry.g:101:60: ^( Ops ( ^( Op apply ) )+ )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Ops, "Ops"), root_1);

                        if ( !(stream_apply.hasNext()||stream_Op.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_apply.hasNext()||stream_Op.hasNext() ) {
                            // src/antlr/Vitry.g:101:66: ^( Op apply )
                            {
                            Object root_2 = (Object)adaptor.nil();
                            root_2 = (Object)adaptor.becomeRoot(stream_Op.nextNode(), root_2);

                            adaptor.addChild(root_2, stream_apply.nextTree());

                            adaptor.addChild(root_1, root_2);
                            }

                        }
                        stream_apply.reset();
                        stream_Op.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // src/antlr/Vitry.g:102:7: ( apply Op )=>e= apply ( Op f+= apply )+
                    {
                    pushFollow(FOLLOW_apply_in_inline713);
                    e=apply();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_apply.add(e.getTree());
                    // src/antlr/Vitry.g:102:29: ( Op f+= apply )+
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
                    	    // src/antlr/Vitry.g:102:30: Op f+= apply
                    	    {
                    	    Op31=(Token)match(input,Op,FOLLOW_Op_in_inline716); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_Op.add(Op31);

                    	    pushFollow(FOLLOW_apply_in_inline720);
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
                    // elements: f, e, Op
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
                    // 102:57: -> ^( Ops $e ( ^( Op $f) )+ )
                    {
                        // src/antlr/Vitry.g:102:60: ^( Ops $e ( ^( Op $f) )+ )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Ops, "Ops"), root_1);

                        adaptor.addChild(root_1, stream_e.nextTree());
                        if ( !(stream_f.hasNext()||stream_Op.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_f.hasNext()||stream_Op.hasNext() ) {
                            // src/antlr/Vitry.g:102:69: ^( Op $f)
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
                case 5 :
                    // src/antlr/Vitry.g:103:7: apply
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_apply_in_inline762);
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
    // src/antlr/Vitry.g:112:1: inlineRight : ( 'fn' '(' ( left )* ')' inline[true] -> ^( Fn ( left )* inline ) | 'fn' '[' ( left )* ']' inline[true] -> ^( Fn ( left )* inline ) | 'let' '(' ( assign )* ')' inline[true] -> ^( Let ( assign )* inline ) | 'let' '[' ( assign )* ']' inline[true] -> ^( Let ( assign )* inline ) | 'loop' '(' ( assign )* ')' inline[true] -> ^( Loop ( assign )* inline ) | 'loop' '[' ( assign )* ']' inline[true] -> ^( Loop ( assign )* inline ) | 'do' '(' ( assign )* ')' ( expr )* -> ^( Do ( assign )* ( expr )* ) | 'do' '[' ( assign )* ']' ( expr )* -> ^( Do ( assign )* ( expr )* ) | 'match' v= expr '(' (c+= left e+= expr )* ')' -> ^( Match $v ( ^( $c $e) )* ) | 'if' expr expr ( 'else' )? inline[true] -> ^( If expr expr inline ) | 'recur' ( expr )* -> ^( Recur ( expr )* ) );
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
        Token char_literal66=null;
        Token string_literal68=null;
        Token char_literal69=null;
        Token char_literal71=null;
        Token string_literal73=null;
        Token char_literal74=null;
        Token char_literal75=null;
        Token string_literal76=null;
        Token string_literal79=null;
        Token string_literal81=null;
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

        VitryParser.inline_return inline57 = null;

        VitryParser.assign_return assign60 = null;

        VitryParser.inline_return inline62 = null;

        VitryParser.assign_return assign65 = null;

        VitryParser.expr_return expr67 = null;

        VitryParser.assign_return assign70 = null;

        VitryParser.expr_return expr72 = null;

        VitryParser.expr_return expr77 = null;

        VitryParser.expr_return expr78 = null;

        VitryParser.inline_return inline80 = null;

        VitryParser.expr_return expr82 = null;

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
        Object char_literal66_tree=null;
        Object string_literal68_tree=null;
        Object char_literal69_tree=null;
        Object char_literal71_tree=null;
        Object string_literal73_tree=null;
        Object char_literal74_tree=null;
        Object char_literal75_tree=null;
        Object string_literal76_tree=null;
        Object string_literal79_tree=null;
        Object string_literal81_tree=null;
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
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return retval; }
            // src/antlr/Vitry.g:113:5: ( 'fn' '(' ( left )* ')' inline[true] -> ^( Fn ( left )* inline ) | 'fn' '[' ( left )* ']' inline[true] -> ^( Fn ( left )* inline ) | 'let' '(' ( assign )* ')' inline[true] -> ^( Let ( assign )* inline ) | 'let' '[' ( assign )* ']' inline[true] -> ^( Let ( assign )* inline ) | 'loop' '(' ( assign )* ')' inline[true] -> ^( Loop ( assign )* inline ) | 'loop' '[' ( assign )* ']' inline[true] -> ^( Loop ( assign )* inline ) | 'do' '(' ( assign )* ')' ( expr )* -> ^( Do ( assign )* ( expr )* ) | 'do' '[' ( assign )* ']' ( expr )* -> ^( Do ( assign )* ( expr )* ) | 'match' v= expr '(' (c+= left e+= expr )* ')' -> ^( Match $v ( ^( $c $e) )* ) | 'if' expr expr ( 'else' )? inline[true] -> ^( If expr expr inline ) | 'recur' ( expr )* -> ^( Recur ( expr )* ) )
            int alt23=11;
            alt23 = dfa23.predict(input);
            switch (alt23) {
                case 1 :
                    // src/antlr/Vitry.g:113:7: 'fn' '(' ( left )* ')' inline[true]
                    {
                    string_literal33=(Token)match(input,46,FOLLOW_46_in_inlineRight803); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_46.add(string_literal33);

                    char_literal34=(Token)match(input,39,FOLLOW_39_in_inlineRight807); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_39.add(char_literal34);

                    // src/antlr/Vitry.g:113:18: ( left )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( ((LA10_0>=Symbol && LA10_0<=String)||LA10_0==39||LA10_0==41||LA10_0==43||LA10_0==45) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:113:18: left
                    	    {
                    	    pushFollow(FOLLOW_left_in_inlineRight809);
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

                    char_literal36=(Token)match(input,40,FOLLOW_40_in_inlineRight814); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(char_literal36);

                    pushFollow(FOLLOW_inline_in_inlineRight816);
                    inline37=inline(true);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_inline.add(inline37.getTree());


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
                    // 113:56: -> ^( Fn ( left )* inline )
                    {
                        // src/antlr/Vitry.g:113:59: ^( Fn ( left )* inline )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Fn, "Fn"), root_1);

                        // src/antlr/Vitry.g:113:64: ( left )*
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
                    // src/antlr/Vitry.g:114:7: 'fn' '[' ( left )* ']' inline[true]
                    {
                    string_literal38=(Token)match(input,46,FOLLOW_46_in_inlineRight849); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_46.add(string_literal38);

                    char_literal39=(Token)match(input,41,FOLLOW_41_in_inlineRight853); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_41.add(char_literal39);

                    // src/antlr/Vitry.g:114:18: ( left )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( ((LA11_0>=Symbol && LA11_0<=String)||LA11_0==39||LA11_0==41||LA11_0==43||LA11_0==45) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:114:18: left
                    	    {
                    	    pushFollow(FOLLOW_left_in_inlineRight855);
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

                    char_literal41=(Token)match(input,42,FOLLOW_42_in_inlineRight860); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_42.add(char_literal41);

                    pushFollow(FOLLOW_inline_in_inlineRight862);
                    inline42=inline(true);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_inline.add(inline42.getTree());


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
                    // 114:56: -> ^( Fn ( left )* inline )
                    {
                        // src/antlr/Vitry.g:114:59: ^( Fn ( left )* inline )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Fn, "Fn"), root_1);

                        // src/antlr/Vitry.g:114:64: ( left )*
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
                    // src/antlr/Vitry.g:115:7: 'let' '(' ( assign )* ')' inline[true]
                    {
                    string_literal43=(Token)match(input,47,FOLLOW_47_in_inlineRight895); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_47.add(string_literal43);

                    char_literal44=(Token)match(input,39,FOLLOW_39_in_inlineRight898); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_39.add(char_literal44);

                    // src/antlr/Vitry.g:115:18: ( assign )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( ((LA12_0>=Symbol && LA12_0<=String)||LA12_0==39||LA12_0==41||LA12_0==43||LA12_0==45) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:115:18: assign
                    	    {
                    	    pushFollow(FOLLOW_assign_in_inlineRight900);
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

                    char_literal46=(Token)match(input,40,FOLLOW_40_in_inlineRight903); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(char_literal46);

                    pushFollow(FOLLOW_inline_in_inlineRight905);
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
                    // 115:56: -> ^( Let ( assign )* inline )
                    {
                        // src/antlr/Vitry.g:115:59: ^( Let ( assign )* inline )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Let, "Let"), root_1);

                        // src/antlr/Vitry.g:115:65: ( assign )*
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
                    // src/antlr/Vitry.g:116:7: 'let' '[' ( assign )* ']' inline[true]
                    {
                    string_literal48=(Token)match(input,47,FOLLOW_47_in_inlineRight938); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_47.add(string_literal48);

                    char_literal49=(Token)match(input,41,FOLLOW_41_in_inlineRight941); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_41.add(char_literal49);

                    // src/antlr/Vitry.g:116:18: ( assign )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( ((LA13_0>=Symbol && LA13_0<=String)||LA13_0==39||LA13_0==41||LA13_0==43||LA13_0==45) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:116:18: assign
                    	    {
                    	    pushFollow(FOLLOW_assign_in_inlineRight943);
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

                    char_literal51=(Token)match(input,42,FOLLOW_42_in_inlineRight946); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_42.add(char_literal51);

                    pushFollow(FOLLOW_inline_in_inlineRight948);
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
                    // 116:56: -> ^( Let ( assign )* inline )
                    {
                        // src/antlr/Vitry.g:116:59: ^( Let ( assign )* inline )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Let, "Let"), root_1);

                        // src/antlr/Vitry.g:116:65: ( assign )*
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
                    // src/antlr/Vitry.g:117:7: 'loop' '(' ( assign )* ')' inline[true]
                    {
                    string_literal53=(Token)match(input,48,FOLLOW_48_in_inlineRight981); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_48.add(string_literal53);

                    char_literal54=(Token)match(input,39,FOLLOW_39_in_inlineRight983); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_39.add(char_literal54);

                    // src/antlr/Vitry.g:117:18: ( assign )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( ((LA14_0>=Symbol && LA14_0<=String)||LA14_0==39||LA14_0==41||LA14_0==43||LA14_0==45) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:117:18: assign
                    	    {
                    	    pushFollow(FOLLOW_assign_in_inlineRight985);
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

                    char_literal56=(Token)match(input,40,FOLLOW_40_in_inlineRight988); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(char_literal56);

                    pushFollow(FOLLOW_inline_in_inlineRight990);
                    inline57=inline(true);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_inline.add(inline57.getTree());


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
                    // 117:56: -> ^( Loop ( assign )* inline )
                    {
                        // src/antlr/Vitry.g:117:59: ^( Loop ( assign )* inline )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Loop, "Loop"), root_1);

                        // src/antlr/Vitry.g:117:66: ( assign )*
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
                    // src/antlr/Vitry.g:118:7: 'loop' '[' ( assign )* ']' inline[true]
                    {
                    string_literal58=(Token)match(input,48,FOLLOW_48_in_inlineRight1023); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_48.add(string_literal58);

                    char_literal59=(Token)match(input,41,FOLLOW_41_in_inlineRight1025); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_41.add(char_literal59);

                    // src/antlr/Vitry.g:118:18: ( assign )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( ((LA15_0>=Symbol && LA15_0<=String)||LA15_0==39||LA15_0==41||LA15_0==43||LA15_0==45) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:118:18: assign
                    	    {
                    	    pushFollow(FOLLOW_assign_in_inlineRight1027);
                    	    assign60=assign();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_assign.add(assign60.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);

                    char_literal61=(Token)match(input,42,FOLLOW_42_in_inlineRight1030); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_42.add(char_literal61);

                    pushFollow(FOLLOW_inline_in_inlineRight1032);
                    inline62=inline(true);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_inline.add(inline62.getTree());


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
                    // 118:56: -> ^( Loop ( assign )* inline )
                    {
                        // src/antlr/Vitry.g:118:59: ^( Loop ( assign )* inline )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Loop, "Loop"), root_1);

                        // src/antlr/Vitry.g:118:66: ( assign )*
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
                    // src/antlr/Vitry.g:119:7: 'do' '(' ( assign )* ')' ( expr )*
                    {
                    string_literal63=(Token)match(input,49,FOLLOW_49_in_inlineRight1065); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_49.add(string_literal63);

                    char_literal64=(Token)match(input,39,FOLLOW_39_in_inlineRight1069); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_39.add(char_literal64);

                    // src/antlr/Vitry.g:119:18: ( assign )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( ((LA16_0>=Symbol && LA16_0<=String)||LA16_0==39||LA16_0==41||LA16_0==43||LA16_0==45) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:119:18: assign
                    	    {
                    	    pushFollow(FOLLOW_assign_in_inlineRight1071);
                    	    assign65=assign();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_assign.add(assign65.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);

                    char_literal66=(Token)match(input,40,FOLLOW_40_in_inlineRight1074); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(char_literal66);

                    // src/antlr/Vitry.g:119:30: ( expr )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( ((LA17_0>=Symbol && LA17_0<=String)||LA17_0==39||LA17_0==41||LA17_0==43||LA17_0==45) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:119:30: expr
                    	    {
                    	    pushFollow(FOLLOW_expr_in_inlineRight1076);
                    	    expr67=expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_expr.add(expr67.getTree());

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
                    // 119:56: -> ^( Do ( assign )* ( expr )* )
                    {
                        // src/antlr/Vitry.g:119:59: ^( Do ( assign )* ( expr )* )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Do, "Do"), root_1);

                        // src/antlr/Vitry.g:119:64: ( assign )*
                        while ( stream_assign.hasNext() ) {
                            adaptor.addChild(root_1, stream_assign.nextTree());

                        }
                        stream_assign.reset();
                        // src/antlr/Vitry.g:119:72: ( expr )*
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
                    // src/antlr/Vitry.g:120:7: 'do' '[' ( assign )* ']' ( expr )*
                    {
                    string_literal68=(Token)match(input,49,FOLLOW_49_in_inlineRight1117); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_49.add(string_literal68);

                    char_literal69=(Token)match(input,41,FOLLOW_41_in_inlineRight1121); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_41.add(char_literal69);

                    // src/antlr/Vitry.g:120:18: ( assign )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( ((LA18_0>=Symbol && LA18_0<=String)||LA18_0==39||LA18_0==41||LA18_0==43||LA18_0==45) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:120:18: assign
                    	    {
                    	    pushFollow(FOLLOW_assign_in_inlineRight1123);
                    	    assign70=assign();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_assign.add(assign70.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);

                    char_literal71=(Token)match(input,42,FOLLOW_42_in_inlineRight1126); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_42.add(char_literal71);

                    // src/antlr/Vitry.g:120:30: ( expr )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( ((LA19_0>=Symbol && LA19_0<=String)||LA19_0==39||LA19_0==41||LA19_0==43||LA19_0==45) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:120:30: expr
                    	    {
                    	    pushFollow(FOLLOW_expr_in_inlineRight1128);
                    	    expr72=expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_expr.add(expr72.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop19;
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
                    // 120:56: -> ^( Do ( assign )* ( expr )* )
                    {
                        // src/antlr/Vitry.g:120:59: ^( Do ( assign )* ( expr )* )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Do, "Do"), root_1);

                        // src/antlr/Vitry.g:120:64: ( assign )*
                        while ( stream_assign.hasNext() ) {
                            adaptor.addChild(root_1, stream_assign.nextTree());

                        }
                        stream_assign.reset();
                        // src/antlr/Vitry.g:120:72: ( expr )*
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
                    // src/antlr/Vitry.g:121:7: 'match' v= expr '(' (c+= left e+= expr )* ')'
                    {
                    string_literal73=(Token)match(input,50,FOLLOW_50_in_inlineRight1169); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_50.add(string_literal73);

                    pushFollow(FOLLOW_expr_in_inlineRight1173);
                    v=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(v.getTree());
                    char_literal74=(Token)match(input,39,FOLLOW_39_in_inlineRight1175); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_39.add(char_literal74);

                    // src/antlr/Vitry.g:121:26: (c+= left e+= expr )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( ((LA20_0>=Symbol && LA20_0<=String)||LA20_0==39||LA20_0==41||LA20_0==43||LA20_0==45) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:121:27: c+= left e+= expr
                    	    {
                    	    pushFollow(FOLLOW_left_in_inlineRight1180);
                    	    c=left();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_left.add(c.getTree());
                    	    if (list_c==null) list_c=new ArrayList();
                    	    list_c.add(c.getTree());

                    	    pushFollow(FOLLOW_expr_in_inlineRight1184);
                    	    e=expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_expr.add(e.getTree());
                    	    if (list_e==null) list_e=new ArrayList();
                    	    list_e.add(e.getTree());


                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);

                    char_literal75=(Token)match(input,40,FOLLOW_40_in_inlineRight1188); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(char_literal75);



                    // AST REWRITE
                    // elements: v, e, c
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
                    // 121:56: -> ^( Match $v ( ^( $c $e) )* )
                    {
                        // src/antlr/Vitry.g:121:59: ^( Match $v ( ^( $c $e) )* )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Match, "Match"), root_1);

                        adaptor.addChild(root_1, stream_v.nextTree());
                        // src/antlr/Vitry.g:121:70: ( ^( $c $e) )*
                        while ( stream_e.hasNext()||stream_c.hasNext() ) {
                            // src/antlr/Vitry.g:121:70: ^( $c $e)
                            {
                            Object root_2 = (Object)adaptor.nil();
                            root_2 = (Object)adaptor.becomeRoot(stream_c.nextNode(), root_2);

                            adaptor.addChild(root_2, stream_e.nextTree());

                            adaptor.addChild(root_1, root_2);
                            }

                        }
                        stream_e.reset();
                        stream_c.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 10 :
                    // src/antlr/Vitry.g:122:7: 'if' expr expr ( 'else' )? inline[true]
                    {
                    string_literal76=(Token)match(input,51,FOLLOW_51_in_inlineRight1225); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_51.add(string_literal76);

                    pushFollow(FOLLOW_expr_in_inlineRight1227);
                    expr77=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr77.getTree());
                    pushFollow(FOLLOW_expr_in_inlineRight1229);
                    expr78=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr78.getTree());
                    // src/antlr/Vitry.g:122:22: ( 'else' )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==52) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // src/antlr/Vitry.g:122:22: 'else'
                            {
                            string_literal79=(Token)match(input,52,FOLLOW_52_in_inlineRight1231); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_52.add(string_literal79);


                            }
                            break;

                    }

                    pushFollow(FOLLOW_inline_in_inlineRight1234);
                    inline80=inline(true);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_inline.add(inline80.getTree());


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
                    // 122:56: -> ^( If expr expr inline )
                    {
                        // src/antlr/Vitry.g:122:59: ^( If expr expr inline )
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
                    // src/antlr/Vitry.g:123:7: 'recur' ( expr )*
                    {
                    string_literal81=(Token)match(input,53,FOLLOW_53_in_inlineRight1268); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_53.add(string_literal81);

                    // src/antlr/Vitry.g:123:15: ( expr )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( ((LA22_0>=Symbol && LA22_0<=String)||LA22_0==39||LA22_0==41||LA22_0==43||LA22_0==45) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:123:15: expr
                    	    {
                    	    pushFollow(FOLLOW_expr_in_inlineRight1270);
                    	    expr82=expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_expr.add(expr82.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop22;
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
                    // 123:39: -> ^( Recur ( expr )* )
                    {
                        // src/antlr/Vitry.g:123:42: ^( Recur ( expr )* )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Recur, "Recur"), root_1);

                        // src/antlr/Vitry.g:123:50: ( expr )*
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
    // src/antlr/Vitry.g:126:1: assign : left '=' expr -> ^( Assign left expr ) ;
    public final VitryParser.assign_return assign() throws RecognitionException {
        VitryParser.assign_return retval = new VitryParser.assign_return();
        retval.start = input.LT(1);
        int assign_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal84=null;
        VitryParser.left_return left83 = null;

        VitryParser.expr_return expr85 = null;


        Object char_literal84_tree=null;
        RewriteRuleTokenStream stream_54=new RewriteRuleTokenStream(adaptor,"token 54");
        RewriteRuleSubtreeStream stream_left=new RewriteRuleSubtreeStream(adaptor,"rule left");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return retval; }
            // src/antlr/Vitry.g:127:5: ( left '=' expr -> ^( Assign left expr ) )
            // src/antlr/Vitry.g:127:7: left '=' expr
            {
            pushFollow(FOLLOW_left_in_assign1315);
            left83=left();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_left.add(left83.getTree());
            char_literal84=(Token)match(input,54,FOLLOW_54_in_assign1317); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_54.add(char_literal84);

            pushFollow(FOLLOW_expr_in_assign1319);
            expr85=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expr.add(expr85.getTree());


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
            // 127:52: -> ^( Assign left expr )
            {
                // src/antlr/Vitry.g:127:55: ^( Assign left expr )
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
    // src/antlr/Vitry.g:131:1: apply : ( ( expr expr )=> ( expr )+ -> ^( Apply ( expr )+ ) | expr );
    public final VitryParser.apply_return apply() throws RecognitionException {
        VitryParser.apply_return retval = new VitryParser.apply_return();
        retval.start = input.LT(1);
        int apply_StartIndex = input.index();
        Object root_0 = null;

        VitryParser.expr_return expr86 = null;

        VitryParser.expr_return expr87 = null;


        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return retval; }
            // src/antlr/Vitry.g:132:5: ( ( expr expr )=> ( expr )+ -> ^( Apply ( expr )+ ) | expr )
            int alt25=2;
            alt25 = dfa25.predict(input);
            switch (alt25) {
                case 1 :
                    // src/antlr/Vitry.g:132:7: ( expr expr )=> ( expr )+
                    {
                    // src/antlr/Vitry.g:132:22: ( expr )+
                    int cnt24=0;
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( ((LA24_0>=Symbol && LA24_0<=String)||LA24_0==39||LA24_0==41||LA24_0==43||LA24_0==45) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // src/antlr/Vitry.g:132:22: expr
                    	    {
                    	    pushFollow(FOLLOW_expr_in_apply1390);
                    	    expr86=expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_expr.add(expr86.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt24 >= 1 ) break loop24;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(24, input);
                                throw eee;
                        }
                        cnt24++;
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
                    // 132:52: -> ^( Apply ( expr )+ )
                    {
                        // src/antlr/Vitry.g:132:55: ^( Apply ( expr )+ )
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
                    // src/antlr/Vitry.g:133:7: expr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_expr_in_apply1432);
                    expr87=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr87.getTree());

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

    // $ANTLR start synpred1_Vitry
    public final void synpred1_Vitry_fragment() throws RecognitionException {   
        // src/antlr/Vitry.g:64:7: ( delim[true] ':' )
        // src/antlr/Vitry.g:64:8: delim[true] ':'
        {
        pushFollow(FOLLOW_delim_in_synpred1_Vitry238);
        delim(true);

        state._fsp--;
        if (state.failed) return ;
        match(input,38,FOLLOW_38_in_synpred1_Vitry241); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_Vitry

    // $ANTLR start synpred2_Vitry
    public final void synpred2_Vitry_fragment() throws RecognitionException {   
        // src/antlr/Vitry.g:73:7: ( delim[false] ':' )
        // src/antlr/Vitry.g:73:8: delim[false] ':'
        {
        pushFollow(FOLLOW_delim_in_synpred2_Vitry297);
        delim(false);

        state._fsp--;
        if (state.failed) return ;
        match(input,38,FOLLOW_38_in_synpred2_Vitry300); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_Vitry

    // $ANTLR start synpred3_Vitry
    public final void synpred3_Vitry_fragment() throws RecognitionException {   
        // src/antlr/Vitry.g:100:7: ( Op ( ')' | ']' | '}' ) )
        // src/antlr/Vitry.g:100:8: Op ( ')' | ']' | '}' )
        {
        match(input,Op,FOLLOW_Op_in_synpred3_Vitry614); if (state.failed) return ;
        if ( input.LA(1)==40||input.LA(1)==42||input.LA(1)==44 ) {
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
        // src/antlr/Vitry.g:102:7: ( apply Op )
        // src/antlr/Vitry.g:102:8: apply Op
        {
        pushFollow(FOLLOW_apply_in_synpred4_Vitry704);
        apply();

        state._fsp--;
        if (state.failed) return ;
        match(input,Op,FOLLOW_Op_in_synpred4_Vitry706); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_Vitry

    // $ANTLR start synpred5_Vitry
    public final void synpred5_Vitry_fragment() throws RecognitionException {   
        // src/antlr/Vitry.g:132:7: ( expr expr )
        // src/antlr/Vitry.g:132:8: expr expr
        {
        pushFollow(FOLLOW_expr_in_synpred5_Vitry1383);
        expr();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_expr_in_synpred5_Vitry1385);
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
    protected DFA23 dfa23 = new DFA23(this);
    protected DFA25 dfa25 = new DFA25(this);
    static final String DFA1_eotS =
        "\14\uffff";
    static final String DFA1_eofS =
        "\14\uffff";
    static final String DFA1_minS =
        "\1\33\11\0\2\uffff";
    static final String DFA1_maxS =
        "\1\55\11\0\2\uffff";
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
            return "63:1: expr : ( ( delim[true] ':' )=> delim[true] ':' expr -> ^( Type delim expr ) | delim[true] );";
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
        "\1\33\11\0\2\uffff";
    static final String DFA2_maxS =
        "\1\55\11\0\2\uffff";
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
            return "72:1: left : ( ( delim[false] ':' )=> delim[false] ':' expr -> ^( Left ^( Type delim expr ) ) | delim[false] -> ^( Left delim ) );";
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
        "\1\33\3\uffff\1\32\7\uffff";
    static final String DFA6_maxS =
        "\1\55\3\uffff\1\55\7\uffff";
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
            return "80:1: delim[boolean rs] : ( '(' ( inline[rs] )? ')' -> ^( Par ( inline )? ) | '[' ( inline[rs] )? ']' -> ^( Bra ( inline )? ) | '{' ( inline[rs] )? '}' -> ^( Ang ( inline )? ) | '`' Op -> ^( Quote Op ) | '`' delim[rs] -> ^( Quote delim ) | Symbol | Natural | Float | Complex | String );";
        }
    }
    static final String DFA9_eotS =
        "\26\uffff";
    static final String DFA9_eofS =
        "\26\uffff";
    static final String DFA9_minS =
        "\1\32\7\uffff\12\0\4\uffff";
    static final String DFA9_maxS =
        "\1\65\7\uffff\12\0\4\uffff";
    static final String DFA9_acceptS =
        "\1\uffff\1\1\20\uffff\1\2\1\3\1\4\1\5";
    static final String DFA9_specialS =
        "\10\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\4\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\10\1\15\1\16\1\17\1\20\1\21\7\uffff\1\11\1\uffff\1\12\1\uffff"+
            "\1\13\1\uffff\1\14\6\1\1\uffff\1\1",
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
            return "98:1: inline[boolean rs] : ({...}? inlineRight | ( Op ( ')' | ']' | '}' ) )=> Op | ( Op apply )+ -> ^( Ops ( ^( Op apply ) )+ ) | ( apply Op )=>e= apply ( Op f+= apply )+ -> ^( Ops $e ( ^( Op $f) )+ ) | apply );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA9_8 = input.LA(1);

                         
                        int index9_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_Vitry()) ) {s = 18;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index9_8);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA9_9 = input.LA(1);

                         
                        int index9_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Vitry()) ) {s = 20;}

                        else if ( (true) ) {s = 21;}

                         
                        input.seek(index9_9);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA9_10 = input.LA(1);

                         
                        int index9_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Vitry()) ) {s = 20;}

                        else if ( (true) ) {s = 21;}

                         
                        input.seek(index9_10);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA9_11 = input.LA(1);

                         
                        int index9_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Vitry()) ) {s = 20;}

                        else if ( (true) ) {s = 21;}

                         
                        input.seek(index9_11);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA9_12 = input.LA(1);

                         
                        int index9_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Vitry()) ) {s = 20;}

                        else if ( (true) ) {s = 21;}

                         
                        input.seek(index9_12);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA9_13 = input.LA(1);

                         
                        int index9_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Vitry()) ) {s = 20;}

                        else if ( (true) ) {s = 21;}

                         
                        input.seek(index9_13);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA9_14 = input.LA(1);

                         
                        int index9_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Vitry()) ) {s = 20;}

                        else if ( (true) ) {s = 21;}

                         
                        input.seek(index9_14);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA9_15 = input.LA(1);

                         
                        int index9_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Vitry()) ) {s = 20;}

                        else if ( (true) ) {s = 21;}

                         
                        input.seek(index9_15);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA9_16 = input.LA(1);

                         
                        int index9_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Vitry()) ) {s = 20;}

                        else if ( (true) ) {s = 21;}

                         
                        input.seek(index9_16);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA9_17 = input.LA(1);

                         
                        int index9_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Vitry()) ) {s = 20;}

                        else if ( (true) ) {s = 21;}

                         
                        input.seek(index9_17);
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
    static final String DFA23_eotS =
        "\20\uffff";
    static final String DFA23_eofS =
        "\20\uffff";
    static final String DFA23_minS =
        "\1\56\4\47\13\uffff";
    static final String DFA23_maxS =
        "\1\65\4\51\13\uffff";
    static final String DFA23_acceptS =
        "\5\uffff\1\11\1\12\1\13\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10";
    static final String DFA23_specialS =
        "\20\uffff}>";
    static final String[] DFA23_transitionS = {
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

    static final short[] DFA23_eot = DFA.unpackEncodedString(DFA23_eotS);
    static final short[] DFA23_eof = DFA.unpackEncodedString(DFA23_eofS);
    static final char[] DFA23_min = DFA.unpackEncodedStringToUnsignedChars(DFA23_minS);
    static final char[] DFA23_max = DFA.unpackEncodedStringToUnsignedChars(DFA23_maxS);
    static final short[] DFA23_accept = DFA.unpackEncodedString(DFA23_acceptS);
    static final short[] DFA23_special = DFA.unpackEncodedString(DFA23_specialS);
    static final short[][] DFA23_transition;

    static {
        int numStates = DFA23_transitionS.length;
        DFA23_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA23_transition[i] = DFA.unpackEncodedString(DFA23_transitionS[i]);
        }
    }

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = DFA23_eot;
            this.eof = DFA23_eof;
            this.min = DFA23_min;
            this.max = DFA23_max;
            this.accept = DFA23_accept;
            this.special = DFA23_special;
            this.transition = DFA23_transition;
        }
        public String getDescription() {
            return "112:1: inlineRight : ( 'fn' '(' ( left )* ')' inline[true] -> ^( Fn ( left )* inline ) | 'fn' '[' ( left )* ']' inline[true] -> ^( Fn ( left )* inline ) | 'let' '(' ( assign )* ')' inline[true] -> ^( Let ( assign )* inline ) | 'let' '[' ( assign )* ']' inline[true] -> ^( Let ( assign )* inline ) | 'loop' '(' ( assign )* ')' inline[true] -> ^( Loop ( assign )* inline ) | 'loop' '[' ( assign )* ']' inline[true] -> ^( Loop ( assign )* inline ) | 'do' '(' ( assign )* ')' ( expr )* -> ^( Do ( assign )* ( expr )* ) | 'do' '[' ( assign )* ']' ( expr )* -> ^( Do ( assign )* ( expr )* ) | 'match' v= expr '(' (c+= left e+= expr )* ')' -> ^( Match $v ( ^( $c $e) )* ) | 'if' expr expr ( 'else' )? inline[true] -> ^( If expr expr inline ) | 'recur' ( expr )* -> ^( Recur ( expr )* ) );";
        }
    }
    static final String DFA25_eotS =
        "\14\uffff";
    static final String DFA25_eofS =
        "\14\uffff";
    static final String DFA25_minS =
        "\1\33\11\0\2\uffff";
    static final String DFA25_maxS =
        "\1\55\11\0\2\uffff";
    static final String DFA25_acceptS =
        "\12\uffff\1\1\1\2";
    static final String DFA25_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\2\uffff}>";
    static final String[] DFA25_transitionS = {
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

    static final short[] DFA25_eot = DFA.unpackEncodedString(DFA25_eotS);
    static final short[] DFA25_eof = DFA.unpackEncodedString(DFA25_eofS);
    static final char[] DFA25_min = DFA.unpackEncodedStringToUnsignedChars(DFA25_minS);
    static final char[] DFA25_max = DFA.unpackEncodedStringToUnsignedChars(DFA25_maxS);
    static final short[] DFA25_accept = DFA.unpackEncodedString(DFA25_acceptS);
    static final short[] DFA25_special = DFA.unpackEncodedString(DFA25_specialS);
    static final short[][] DFA25_transition;

    static {
        int numStates = DFA25_transitionS.length;
        DFA25_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA25_transition[i] = DFA.unpackEncodedString(DFA25_transitionS[i]);
        }
    }

    class DFA25 extends DFA {

        public DFA25(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 25;
            this.eot = DFA25_eot;
            this.eof = DFA25_eof;
            this.min = DFA25_min;
            this.max = DFA25_max;
            this.accept = DFA25_accept;
            this.special = DFA25_special;
            this.transition = DFA25_transition;
        }
        public String getDescription() {
            return "131:1: apply : ( ( expr expr )=> ( expr )+ -> ^( Apply ( expr )+ ) | expr );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA25_1 = input.LA(1);

                         
                        int index25_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_Vitry()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index25_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA25_2 = input.LA(1);

                         
                        int index25_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_Vitry()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index25_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA25_3 = input.LA(1);

                         
                        int index25_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_Vitry()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index25_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA25_4 = input.LA(1);

                         
                        int index25_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_Vitry()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index25_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA25_5 = input.LA(1);

                         
                        int index25_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_Vitry()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index25_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA25_6 = input.LA(1);

                         
                        int index25_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_Vitry()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index25_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA25_7 = input.LA(1);

                         
                        int index25_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_Vitry()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index25_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA25_8 = input.LA(1);

                         
                        int index25_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_Vitry()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index25_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA25_9 = input.LA(1);

                         
                        int index25_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_Vitry()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index25_9);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 25, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_delim_in_expr246 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_expr249 = new BitSet(new long[]{0x00002A80F8000000L});
    public static final BitSet FOLLOW_expr_in_expr251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_delim_in_expr272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_delim_in_left305 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_left308 = new BitSet(new long[]{0x00002A80F8000000L});
    public static final BitSet FOLLOW_expr_in_left310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_delim_in_left333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_delim395 = new BitSet(new long[]{0x002FEB80FC000000L});
    public static final BitSet FOLLOW_inline_in_delim397 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_delim401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_delim424 = new BitSet(new long[]{0x002FEE80FC000000L});
    public static final BitSet FOLLOW_inline_in_delim426 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_delim430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_delim453 = new BitSet(new long[]{0x002FFA80FC000000L});
    public static final BitSet FOLLOW_inline_in_delim455 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_delim459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_delim482 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_Op_in_delim484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_delim519 = new BitSet(new long[]{0x00002A80F8000000L});
    public static final BitSet FOLLOW_delim_in_delim521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Symbol_in_delim550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Natural_in_delim558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Float_in_delim566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Complex_in_delim574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_String_in_delim582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inlineRight_in_inline605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Op_in_inline631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Op_in_inline640 = new BitSet(new long[]{0x00002A80F8000000L});
    public static final BitSet FOLLOW_apply_in_inline642 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_apply_in_inline713 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_Op_in_inline716 = new BitSet(new long[]{0x00002A80F8000000L});
    public static final BitSet FOLLOW_apply_in_inline720 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_apply_in_inline762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_inlineRight803 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_inlineRight807 = new BitSet(new long[]{0x00002B80F8000000L});
    public static final BitSet FOLLOW_left_in_inlineRight809 = new BitSet(new long[]{0x00002B80F8000000L});
    public static final BitSet FOLLOW_40_in_inlineRight814 = new BitSet(new long[]{0x002FEA80FC000000L});
    public static final BitSet FOLLOW_inline_in_inlineRight816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_inlineRight849 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_inlineRight853 = new BitSet(new long[]{0x00002E80F8000000L});
    public static final BitSet FOLLOW_left_in_inlineRight855 = new BitSet(new long[]{0x00002E80F8000000L});
    public static final BitSet FOLLOW_42_in_inlineRight860 = new BitSet(new long[]{0x002FEA80FC000000L});
    public static final BitSet FOLLOW_inline_in_inlineRight862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_inlineRight895 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_inlineRight898 = new BitSet(new long[]{0x00002B80F8000000L});
    public static final BitSet FOLLOW_assign_in_inlineRight900 = new BitSet(new long[]{0x00002B80F8000000L});
    public static final BitSet FOLLOW_40_in_inlineRight903 = new BitSet(new long[]{0x002FEA80FC000000L});
    public static final BitSet FOLLOW_inline_in_inlineRight905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_inlineRight938 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_inlineRight941 = new BitSet(new long[]{0x00002E80F8000000L});
    public static final BitSet FOLLOW_assign_in_inlineRight943 = new BitSet(new long[]{0x00002E80F8000000L});
    public static final BitSet FOLLOW_42_in_inlineRight946 = new BitSet(new long[]{0x002FEA80FC000000L});
    public static final BitSet FOLLOW_inline_in_inlineRight948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_inlineRight981 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_inlineRight983 = new BitSet(new long[]{0x00002B80F8000000L});
    public static final BitSet FOLLOW_assign_in_inlineRight985 = new BitSet(new long[]{0x00002B80F8000000L});
    public static final BitSet FOLLOW_40_in_inlineRight988 = new BitSet(new long[]{0x002FEA80FC000000L});
    public static final BitSet FOLLOW_inline_in_inlineRight990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_inlineRight1023 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_inlineRight1025 = new BitSet(new long[]{0x00002E80F8000000L});
    public static final BitSet FOLLOW_assign_in_inlineRight1027 = new BitSet(new long[]{0x00002E80F8000000L});
    public static final BitSet FOLLOW_42_in_inlineRight1030 = new BitSet(new long[]{0x002FEA80FC000000L});
    public static final BitSet FOLLOW_inline_in_inlineRight1032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_inlineRight1065 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_inlineRight1069 = new BitSet(new long[]{0x00002B80F8000000L});
    public static final BitSet FOLLOW_assign_in_inlineRight1071 = new BitSet(new long[]{0x00002B80F8000000L});
    public static final BitSet FOLLOW_40_in_inlineRight1074 = new BitSet(new long[]{0x00002A80F8000002L});
    public static final BitSet FOLLOW_expr_in_inlineRight1076 = new BitSet(new long[]{0x00002A80F8000002L});
    public static final BitSet FOLLOW_49_in_inlineRight1117 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_inlineRight1121 = new BitSet(new long[]{0x00002E80F8000000L});
    public static final BitSet FOLLOW_assign_in_inlineRight1123 = new BitSet(new long[]{0x00002E80F8000000L});
    public static final BitSet FOLLOW_42_in_inlineRight1126 = new BitSet(new long[]{0x00002A80F8000002L});
    public static final BitSet FOLLOW_expr_in_inlineRight1128 = new BitSet(new long[]{0x00002A80F8000002L});
    public static final BitSet FOLLOW_50_in_inlineRight1169 = new BitSet(new long[]{0x00002A80F8000000L});
    public static final BitSet FOLLOW_expr_in_inlineRight1173 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_inlineRight1175 = new BitSet(new long[]{0x00002B80F8000000L});
    public static final BitSet FOLLOW_left_in_inlineRight1180 = new BitSet(new long[]{0x00002A80F8000000L});
    public static final BitSet FOLLOW_expr_in_inlineRight1184 = new BitSet(new long[]{0x00002B80F8000000L});
    public static final BitSet FOLLOW_40_in_inlineRight1188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_inlineRight1225 = new BitSet(new long[]{0x00002A80F8000000L});
    public static final BitSet FOLLOW_expr_in_inlineRight1227 = new BitSet(new long[]{0x00002A80F8000000L});
    public static final BitSet FOLLOW_expr_in_inlineRight1229 = new BitSet(new long[]{0x003FEA80FC000000L});
    public static final BitSet FOLLOW_52_in_inlineRight1231 = new BitSet(new long[]{0x002FEA80FC000000L});
    public static final BitSet FOLLOW_inline_in_inlineRight1234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_inlineRight1268 = new BitSet(new long[]{0x00002A80F8000002L});
    public static final BitSet FOLLOW_expr_in_inlineRight1270 = new BitSet(new long[]{0x00002A80F8000002L});
    public static final BitSet FOLLOW_left_in_assign1315 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_assign1317 = new BitSet(new long[]{0x00002A80F8000000L});
    public static final BitSet FOLLOW_expr_in_assign1319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_apply1390 = new BitSet(new long[]{0x00002A80F8000002L});
    public static final BitSet FOLLOW_expr_in_apply1432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_delim_in_synpred1_Vitry238 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_synpred1_Vitry241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_delim_in_synpred2_Vitry297 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_synpred2_Vitry300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Op_in_synpred3_Vitry614 = new BitSet(new long[]{0x0000150000000000L});
    public static final BitSet FOLLOW_set_in_synpred3_Vitry616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_apply_in_synpred4_Vitry704 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_Op_in_synpred4_Vitry706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_synpred5_Vitry1383 = new BitSet(new long[]{0x00002A80F8000000L});
    public static final BitSet FOLLOW_expr_in_synpred5_Vitry1385 = new BitSet(new long[]{0x0000000000000002L});

}