package org.xtext.example.symboleo.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.xtext.example.symboleo.services.SymboleoGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSymboleoParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Domain'", "';'", "'endDomain'", "'Contract'", "'('", "','", "')'", "'Declarations'", "'Preconditions'", "'Postconditions'", "'Obligations'", "'SurvivingObligations'", "'Powers'", "'Constraints'", "'endContract'", "'isA'", "'with'", "':'", "'Enumeration'", "'NUMBER'", "'STRING'", "'DATE'", "'ASSET'", "'EVENT'", "'ROLE'", "'SITUATION'", "'CONTRACT'", "':='", "'->'", "'obligation'", "'power'", "'OR'", "'AND'", "'NOT'", "'happens'", "'occurs'", "'within'", "'TRUE'", "'FALSE'", "'['", "']'", "'UNNAMED_INTERVAL'", "'SECONDS'", "'MINUTES'", "'HOURS'", "'DAYS'", "'WEEKS'", "'MONTHS'", "'QUARTERS'", "'YEARS'", "'BEFORE'", "'AFTER'", "'AT'", "'WITHIN'", "'+'", "'-'", "'UNNAMED_POINT'", "'pTRIGGERED'", "'pACTIVATED'", "'pSUSPENDED'", "'pRESUMED'", "'pEXERTED'", "'pEXPIRED'", "'pTERMINATED'", "'cACTIVATED'", "'cSUSPENDED'", "'cRESUMED'", "'cFULFILLED_ACTIVE_OBLS'", "'cREVOKED_PARTY'", "'cASSIGNED_PARTY'", "'cTERMINATED'", "'oTRIGGERED'", "'oACTIVATED'", "'oSUSPENDED'", "'oRESUMED'", "'oDISCHARGED'", "'oEXPIRED'", "'oFULFILLED'", "'oVIOLATED'", "'oTERMINATED'", "'oCREATE'", "'oINEFFECT'", "'oSUSPENSION'", "'oSUCCESSFUL_TERMINATION'", "'oUNSUCCESSFUL_TERMINATION'", "'oVIOLATION'", "'oFULFILLMENT'", "'oDISCHARGE'", "'cFORM'", "'cINEFFECT'", "'cSUSPENSION'", "'cSUCCESSFUL_TERMINATION'", "'cUNSECCESSFUL_TERMINATION'", "'cUNASSIGN'", "'pCREATE'", "'pINEFFECT'", "'pSUSPENSION'", "'pSUCCESSFUL_TERMINATION'", "'pUNSUCCESSFUL_TERMINATION'"
    };
    public static final int T__50=50;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int RULE_INT=5;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__99=99;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int T__109=109;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int T__87=87;
    public static final int T__105=105;

    // delegates
    // delegators


        public InternalSymboleoParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSymboleoParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSymboleoParser.tokenNames; }
    public String getGrammarFileName() { return "InternalSymboleo.g"; }



     	private SymboleoGrammarAccess grammarAccess;

        public InternalSymboleoParser(TokenStream input, SymboleoGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected SymboleoGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalSymboleo.g:64:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalSymboleo.g:64:46: (iv_ruleModel= ruleModel EOF )
            // InternalSymboleo.g:65:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalSymboleo.g:71:1: ruleModel returns [EObject current=null] : (otherlv_0= 'Domain' ( (lv_domainName_1_0= RULE_ID ) ) ( ( (lv_domainConcepts_2_0= ruleDomainConcept ) ) otherlv_3= ';' )+ otherlv_4= 'endDomain' otherlv_5= 'Contract' ( (lv_contractName_6_0= RULE_ID ) ) otherlv_7= '(' ( ( (lv_parameters_8_0= ruleParameter ) ) otherlv_9= ',' )+ ( (lv_parameters_10_0= ruleParameter ) ) otherlv_11= ')' (otherlv_12= 'Declarations' ( ( (lv_declarations_13_0= ruleDeclar ) ) otherlv_14= ';' )* )? (otherlv_15= 'Preconditions' ( ( (lv_preconditions_16_0= ruleProposition ) ) otherlv_17= ';' )* )? (otherlv_18= 'Postconditions' ( ( (lv_postconditions_19_0= ruleProposition ) ) otherlv_20= ';' )* )? (otherlv_21= 'Obligations' ( ( (lv_obligations_22_0= ruleObligation ) ) otherlv_23= ';' )* )? (otherlv_24= 'SurvivingObligations' ( ( (lv_sobligations_25_0= ruleObligation ) ) otherlv_26= ';' )* )? (otherlv_27= 'Powers' ( ( (lv_powers_28_0= rulePower ) ) otherlv_29= ';' )* )? (otherlv_30= 'Constraints' ( ( (lv_constraints_31_0= ruleProposition ) ) otherlv_32= ';' )* )? otherlv_33= 'endContract' ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_domainName_1_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_contractName_6_0=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_26=null;
        Token otherlv_27=null;
        Token otherlv_29=null;
        Token otherlv_30=null;
        Token otherlv_32=null;
        Token otherlv_33=null;
        EObject lv_domainConcepts_2_0 = null;

        EObject lv_parameters_8_0 = null;

        EObject lv_parameters_10_0 = null;

        EObject lv_declarations_13_0 = null;

        EObject lv_preconditions_16_0 = null;

        EObject lv_postconditions_19_0 = null;

        EObject lv_obligations_22_0 = null;

        EObject lv_sobligations_25_0 = null;

        EObject lv_powers_28_0 = null;

        EObject lv_constraints_31_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:77:2: ( (otherlv_0= 'Domain' ( (lv_domainName_1_0= RULE_ID ) ) ( ( (lv_domainConcepts_2_0= ruleDomainConcept ) ) otherlv_3= ';' )+ otherlv_4= 'endDomain' otherlv_5= 'Contract' ( (lv_contractName_6_0= RULE_ID ) ) otherlv_7= '(' ( ( (lv_parameters_8_0= ruleParameter ) ) otherlv_9= ',' )+ ( (lv_parameters_10_0= ruleParameter ) ) otherlv_11= ')' (otherlv_12= 'Declarations' ( ( (lv_declarations_13_0= ruleDeclar ) ) otherlv_14= ';' )* )? (otherlv_15= 'Preconditions' ( ( (lv_preconditions_16_0= ruleProposition ) ) otherlv_17= ';' )* )? (otherlv_18= 'Postconditions' ( ( (lv_postconditions_19_0= ruleProposition ) ) otherlv_20= ';' )* )? (otherlv_21= 'Obligations' ( ( (lv_obligations_22_0= ruleObligation ) ) otherlv_23= ';' )* )? (otherlv_24= 'SurvivingObligations' ( ( (lv_sobligations_25_0= ruleObligation ) ) otherlv_26= ';' )* )? (otherlv_27= 'Powers' ( ( (lv_powers_28_0= rulePower ) ) otherlv_29= ';' )* )? (otherlv_30= 'Constraints' ( ( (lv_constraints_31_0= ruleProposition ) ) otherlv_32= ';' )* )? otherlv_33= 'endContract' ) )
            // InternalSymboleo.g:78:2: (otherlv_0= 'Domain' ( (lv_domainName_1_0= RULE_ID ) ) ( ( (lv_domainConcepts_2_0= ruleDomainConcept ) ) otherlv_3= ';' )+ otherlv_4= 'endDomain' otherlv_5= 'Contract' ( (lv_contractName_6_0= RULE_ID ) ) otherlv_7= '(' ( ( (lv_parameters_8_0= ruleParameter ) ) otherlv_9= ',' )+ ( (lv_parameters_10_0= ruleParameter ) ) otherlv_11= ')' (otherlv_12= 'Declarations' ( ( (lv_declarations_13_0= ruleDeclar ) ) otherlv_14= ';' )* )? (otherlv_15= 'Preconditions' ( ( (lv_preconditions_16_0= ruleProposition ) ) otherlv_17= ';' )* )? (otherlv_18= 'Postconditions' ( ( (lv_postconditions_19_0= ruleProposition ) ) otherlv_20= ';' )* )? (otherlv_21= 'Obligations' ( ( (lv_obligations_22_0= ruleObligation ) ) otherlv_23= ';' )* )? (otherlv_24= 'SurvivingObligations' ( ( (lv_sobligations_25_0= ruleObligation ) ) otherlv_26= ';' )* )? (otherlv_27= 'Powers' ( ( (lv_powers_28_0= rulePower ) ) otherlv_29= ';' )* )? (otherlv_30= 'Constraints' ( ( (lv_constraints_31_0= ruleProposition ) ) otherlv_32= ';' )* )? otherlv_33= 'endContract' )
            {
            // InternalSymboleo.g:78:2: (otherlv_0= 'Domain' ( (lv_domainName_1_0= RULE_ID ) ) ( ( (lv_domainConcepts_2_0= ruleDomainConcept ) ) otherlv_3= ';' )+ otherlv_4= 'endDomain' otherlv_5= 'Contract' ( (lv_contractName_6_0= RULE_ID ) ) otherlv_7= '(' ( ( (lv_parameters_8_0= ruleParameter ) ) otherlv_9= ',' )+ ( (lv_parameters_10_0= ruleParameter ) ) otherlv_11= ')' (otherlv_12= 'Declarations' ( ( (lv_declarations_13_0= ruleDeclar ) ) otherlv_14= ';' )* )? (otherlv_15= 'Preconditions' ( ( (lv_preconditions_16_0= ruleProposition ) ) otherlv_17= ';' )* )? (otherlv_18= 'Postconditions' ( ( (lv_postconditions_19_0= ruleProposition ) ) otherlv_20= ';' )* )? (otherlv_21= 'Obligations' ( ( (lv_obligations_22_0= ruleObligation ) ) otherlv_23= ';' )* )? (otherlv_24= 'SurvivingObligations' ( ( (lv_sobligations_25_0= ruleObligation ) ) otherlv_26= ';' )* )? (otherlv_27= 'Powers' ( ( (lv_powers_28_0= rulePower ) ) otherlv_29= ';' )* )? (otherlv_30= 'Constraints' ( ( (lv_constraints_31_0= ruleProposition ) ) otherlv_32= ';' )* )? otherlv_33= 'endContract' )
            // InternalSymboleo.g:79:3: otherlv_0= 'Domain' ( (lv_domainName_1_0= RULE_ID ) ) ( ( (lv_domainConcepts_2_0= ruleDomainConcept ) ) otherlv_3= ';' )+ otherlv_4= 'endDomain' otherlv_5= 'Contract' ( (lv_contractName_6_0= RULE_ID ) ) otherlv_7= '(' ( ( (lv_parameters_8_0= ruleParameter ) ) otherlv_9= ',' )+ ( (lv_parameters_10_0= ruleParameter ) ) otherlv_11= ')' (otherlv_12= 'Declarations' ( ( (lv_declarations_13_0= ruleDeclar ) ) otherlv_14= ';' )* )? (otherlv_15= 'Preconditions' ( ( (lv_preconditions_16_0= ruleProposition ) ) otherlv_17= ';' )* )? (otherlv_18= 'Postconditions' ( ( (lv_postconditions_19_0= ruleProposition ) ) otherlv_20= ';' )* )? (otherlv_21= 'Obligations' ( ( (lv_obligations_22_0= ruleObligation ) ) otherlv_23= ';' )* )? (otherlv_24= 'SurvivingObligations' ( ( (lv_sobligations_25_0= ruleObligation ) ) otherlv_26= ';' )* )? (otherlv_27= 'Powers' ( ( (lv_powers_28_0= rulePower ) ) otherlv_29= ';' )* )? (otherlv_30= 'Constraints' ( ( (lv_constraints_31_0= ruleProposition ) ) otherlv_32= ';' )* )? otherlv_33= 'endContract'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getModelAccess().getDomainKeyword_0());
            		
            // InternalSymboleo.g:83:3: ( (lv_domainName_1_0= RULE_ID ) )
            // InternalSymboleo.g:84:4: (lv_domainName_1_0= RULE_ID )
            {
            // InternalSymboleo.g:84:4: (lv_domainName_1_0= RULE_ID )
            // InternalSymboleo.g:85:5: lv_domainName_1_0= RULE_ID
            {
            lv_domainName_1_0=(Token)match(input,RULE_ID,FOLLOW_3); 

            					newLeafNode(lv_domainName_1_0, grammarAccess.getModelAccess().getDomainNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getModelRule());
            					}
            					setWithLastConsumed(
            						current,
            						"domainName",
            						lv_domainName_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalSymboleo.g:101:3: ( ( (lv_domainConcepts_2_0= ruleDomainConcept ) ) otherlv_3= ';' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalSymboleo.g:102:4: ( (lv_domainConcepts_2_0= ruleDomainConcept ) ) otherlv_3= ';'
            	    {
            	    // InternalSymboleo.g:102:4: ( (lv_domainConcepts_2_0= ruleDomainConcept ) )
            	    // InternalSymboleo.g:103:5: (lv_domainConcepts_2_0= ruleDomainConcept )
            	    {
            	    // InternalSymboleo.g:103:5: (lv_domainConcepts_2_0= ruleDomainConcept )
            	    // InternalSymboleo.g:104:6: lv_domainConcepts_2_0= ruleDomainConcept
            	    {

            	    						newCompositeNode(grammarAccess.getModelAccess().getDomainConceptsDomainConceptParserRuleCall_2_0_0());
            	    					
            	    pushFollow(FOLLOW_4);
            	    lv_domainConcepts_2_0=ruleDomainConcept();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getModelRule());
            	    						}
            	    						add(
            	    							current,
            	    							"domainConcepts",
            	    							lv_domainConcepts_2_0,
            	    							"org.xtext.example.symboleo.Symboleo.DomainConcept");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    otherlv_3=(Token)match(input,12,FOLLOW_5); 

            	    				newLeafNode(otherlv_3, grammarAccess.getModelAccess().getSemicolonKeyword_2_1());
            	    			

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

            otherlv_4=(Token)match(input,13,FOLLOW_6); 

            			newLeafNode(otherlv_4, grammarAccess.getModelAccess().getEndDomainKeyword_3());
            		
            otherlv_5=(Token)match(input,14,FOLLOW_3); 

            			newLeafNode(otherlv_5, grammarAccess.getModelAccess().getContractKeyword_4());
            		
            // InternalSymboleo.g:134:3: ( (lv_contractName_6_0= RULE_ID ) )
            // InternalSymboleo.g:135:4: (lv_contractName_6_0= RULE_ID )
            {
            // InternalSymboleo.g:135:4: (lv_contractName_6_0= RULE_ID )
            // InternalSymboleo.g:136:5: lv_contractName_6_0= RULE_ID
            {
            lv_contractName_6_0=(Token)match(input,RULE_ID,FOLLOW_7); 

            					newLeafNode(lv_contractName_6_0, grammarAccess.getModelAccess().getContractNameIDTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getModelRule());
            					}
            					setWithLastConsumed(
            						current,
            						"contractName",
            						lv_contractName_6_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_7=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_7, grammarAccess.getModelAccess().getLeftParenthesisKeyword_6());
            		
            // InternalSymboleo.g:156:3: ( ( (lv_parameters_8_0= ruleParameter ) ) otherlv_9= ',' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    int LA2_1 = input.LA(2);

                    if ( (LA2_1==28) ) {
                        switch ( input.LA(3) ) {
                        case RULE_ID:
                            {
                            int LA2_3 = input.LA(4);

                            if ( (LA2_3==16) ) {
                                alt2=1;
                            }


                            }
                            break;
                        case 30:
                            {
                            int LA2_4 = input.LA(4);

                            if ( (LA2_4==16) ) {
                                alt2=1;
                            }


                            }
                            break;
                        case 31:
                            {
                            int LA2_5 = input.LA(4);

                            if ( (LA2_5==16) ) {
                                alt2=1;
                            }


                            }
                            break;
                        case 32:
                            {
                            int LA2_6 = input.LA(4);

                            if ( (LA2_6==16) ) {
                                alt2=1;
                            }


                            }
                            break;

                        }

                    }


                }


                switch (alt2) {
            	case 1 :
            	    // InternalSymboleo.g:157:4: ( (lv_parameters_8_0= ruleParameter ) ) otherlv_9= ','
            	    {
            	    // InternalSymboleo.g:157:4: ( (lv_parameters_8_0= ruleParameter ) )
            	    // InternalSymboleo.g:158:5: (lv_parameters_8_0= ruleParameter )
            	    {
            	    // InternalSymboleo.g:158:5: (lv_parameters_8_0= ruleParameter )
            	    // InternalSymboleo.g:159:6: lv_parameters_8_0= ruleParameter
            	    {

            	    						newCompositeNode(grammarAccess.getModelAccess().getParametersParameterParserRuleCall_7_0_0());
            	    					
            	    pushFollow(FOLLOW_8);
            	    lv_parameters_8_0=ruleParameter();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getModelRule());
            	    						}
            	    						add(
            	    							current,
            	    							"parameters",
            	    							lv_parameters_8_0,
            	    							"org.xtext.example.symboleo.Symboleo.Parameter");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    otherlv_9=(Token)match(input,16,FOLLOW_3); 

            	    				newLeafNode(otherlv_9, grammarAccess.getModelAccess().getCommaKeyword_7_1());
            	    			

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);

            // InternalSymboleo.g:181:3: ( (lv_parameters_10_0= ruleParameter ) )
            // InternalSymboleo.g:182:4: (lv_parameters_10_0= ruleParameter )
            {
            // InternalSymboleo.g:182:4: (lv_parameters_10_0= ruleParameter )
            // InternalSymboleo.g:183:5: lv_parameters_10_0= ruleParameter
            {

            					newCompositeNode(grammarAccess.getModelAccess().getParametersParameterParserRuleCall_8_0());
            				
            pushFollow(FOLLOW_9);
            lv_parameters_10_0=ruleParameter();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getModelRule());
            					}
            					add(
            						current,
            						"parameters",
            						lv_parameters_10_0,
            						"org.xtext.example.symboleo.Symboleo.Parameter");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_11=(Token)match(input,17,FOLLOW_10); 

            			newLeafNode(otherlv_11, grammarAccess.getModelAccess().getRightParenthesisKeyword_9());
            		
            // InternalSymboleo.g:204:3: (otherlv_12= 'Declarations' ( ( (lv_declarations_13_0= ruleDeclar ) ) otherlv_14= ';' )* )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==18) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalSymboleo.g:205:4: otherlv_12= 'Declarations' ( ( (lv_declarations_13_0= ruleDeclar ) ) otherlv_14= ';' )*
                    {
                    otherlv_12=(Token)match(input,18,FOLLOW_11); 

                    				newLeafNode(otherlv_12, grammarAccess.getModelAccess().getDeclarationsKeyword_10_0());
                    			
                    // InternalSymboleo.g:209:4: ( ( (lv_declarations_13_0= ruleDeclar ) ) otherlv_14= ';' )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==RULE_ID) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // InternalSymboleo.g:210:5: ( (lv_declarations_13_0= ruleDeclar ) ) otherlv_14= ';'
                    	    {
                    	    // InternalSymboleo.g:210:5: ( (lv_declarations_13_0= ruleDeclar ) )
                    	    // InternalSymboleo.g:211:6: (lv_declarations_13_0= ruleDeclar )
                    	    {
                    	    // InternalSymboleo.g:211:6: (lv_declarations_13_0= ruleDeclar )
                    	    // InternalSymboleo.g:212:7: lv_declarations_13_0= ruleDeclar
                    	    {

                    	    							newCompositeNode(grammarAccess.getModelAccess().getDeclarationsDeclarParserRuleCall_10_1_0_0());
                    	    						
                    	    pushFollow(FOLLOW_4);
                    	    lv_declarations_13_0=ruleDeclar();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getModelRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"declarations",
                    	    								lv_declarations_13_0,
                    	    								"org.xtext.example.symboleo.Symboleo.Declar");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }

                    	    otherlv_14=(Token)match(input,12,FOLLOW_11); 

                    	    					newLeafNode(otherlv_14, grammarAccess.getModelAccess().getSemicolonKeyword_10_1_1());
                    	    				

                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalSymboleo.g:235:3: (otherlv_15= 'Preconditions' ( ( (lv_preconditions_16_0= ruleProposition ) ) otherlv_17= ';' )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==19) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalSymboleo.g:236:4: otherlv_15= 'Preconditions' ( ( (lv_preconditions_16_0= ruleProposition ) ) otherlv_17= ';' )*
                    {
                    otherlv_15=(Token)match(input,19,FOLLOW_12); 

                    				newLeafNode(otherlv_15, grammarAccess.getModelAccess().getPreconditionsKeyword_11_0());
                    			
                    // InternalSymboleo.g:240:4: ( ( (lv_preconditions_16_0= ruleProposition ) ) otherlv_17= ';' )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>=RULE_ID && LA5_0<=RULE_INT)||(LA5_0>=44 && LA5_0<=46)||(LA5_0>=48 && LA5_0<=49)||(LA5_0>=67 && LA5_0<=109)) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalSymboleo.g:241:5: ( (lv_preconditions_16_0= ruleProposition ) ) otherlv_17= ';'
                    	    {
                    	    // InternalSymboleo.g:241:5: ( (lv_preconditions_16_0= ruleProposition ) )
                    	    // InternalSymboleo.g:242:6: (lv_preconditions_16_0= ruleProposition )
                    	    {
                    	    // InternalSymboleo.g:242:6: (lv_preconditions_16_0= ruleProposition )
                    	    // InternalSymboleo.g:243:7: lv_preconditions_16_0= ruleProposition
                    	    {

                    	    							newCompositeNode(grammarAccess.getModelAccess().getPreconditionsPropositionParserRuleCall_11_1_0_0());
                    	    						
                    	    pushFollow(FOLLOW_4);
                    	    lv_preconditions_16_0=ruleProposition();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getModelRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"preconditions",
                    	    								lv_preconditions_16_0,
                    	    								"org.xtext.example.symboleo.Symboleo.Proposition");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }

                    	    otherlv_17=(Token)match(input,12,FOLLOW_12); 

                    	    					newLeafNode(otherlv_17, grammarAccess.getModelAccess().getSemicolonKeyword_11_1_1());
                    	    				

                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalSymboleo.g:266:3: (otherlv_18= 'Postconditions' ( ( (lv_postconditions_19_0= ruleProposition ) ) otherlv_20= ';' )* )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==20) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalSymboleo.g:267:4: otherlv_18= 'Postconditions' ( ( (lv_postconditions_19_0= ruleProposition ) ) otherlv_20= ';' )*
                    {
                    otherlv_18=(Token)match(input,20,FOLLOW_13); 

                    				newLeafNode(otherlv_18, grammarAccess.getModelAccess().getPostconditionsKeyword_12_0());
                    			
                    // InternalSymboleo.g:271:4: ( ( (lv_postconditions_19_0= ruleProposition ) ) otherlv_20= ';' )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0>=RULE_ID && LA7_0<=RULE_INT)||(LA7_0>=44 && LA7_0<=46)||(LA7_0>=48 && LA7_0<=49)||(LA7_0>=67 && LA7_0<=109)) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalSymboleo.g:272:5: ( (lv_postconditions_19_0= ruleProposition ) ) otherlv_20= ';'
                    	    {
                    	    // InternalSymboleo.g:272:5: ( (lv_postconditions_19_0= ruleProposition ) )
                    	    // InternalSymboleo.g:273:6: (lv_postconditions_19_0= ruleProposition )
                    	    {
                    	    // InternalSymboleo.g:273:6: (lv_postconditions_19_0= ruleProposition )
                    	    // InternalSymboleo.g:274:7: lv_postconditions_19_0= ruleProposition
                    	    {

                    	    							newCompositeNode(grammarAccess.getModelAccess().getPostconditionsPropositionParserRuleCall_12_1_0_0());
                    	    						
                    	    pushFollow(FOLLOW_4);
                    	    lv_postconditions_19_0=ruleProposition();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getModelRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"postconditions",
                    	    								lv_postconditions_19_0,
                    	    								"org.xtext.example.symboleo.Symboleo.Proposition");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }

                    	    otherlv_20=(Token)match(input,12,FOLLOW_13); 

                    	    					newLeafNode(otherlv_20, grammarAccess.getModelAccess().getSemicolonKeyword_12_1_1());
                    	    				

                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalSymboleo.g:297:3: (otherlv_21= 'Obligations' ( ( (lv_obligations_22_0= ruleObligation ) ) otherlv_23= ';' )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==21) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalSymboleo.g:298:4: otherlv_21= 'Obligations' ( ( (lv_obligations_22_0= ruleObligation ) ) otherlv_23= ';' )*
                    {
                    otherlv_21=(Token)match(input,21,FOLLOW_14); 

                    				newLeafNode(otherlv_21, grammarAccess.getModelAccess().getObligationsKeyword_13_0());
                    			
                    // InternalSymboleo.g:302:4: ( ( (lv_obligations_22_0= ruleObligation ) ) otherlv_23= ';' )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==RULE_ID) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalSymboleo.g:303:5: ( (lv_obligations_22_0= ruleObligation ) ) otherlv_23= ';'
                    	    {
                    	    // InternalSymboleo.g:303:5: ( (lv_obligations_22_0= ruleObligation ) )
                    	    // InternalSymboleo.g:304:6: (lv_obligations_22_0= ruleObligation )
                    	    {
                    	    // InternalSymboleo.g:304:6: (lv_obligations_22_0= ruleObligation )
                    	    // InternalSymboleo.g:305:7: lv_obligations_22_0= ruleObligation
                    	    {

                    	    							newCompositeNode(grammarAccess.getModelAccess().getObligationsObligationParserRuleCall_13_1_0_0());
                    	    						
                    	    pushFollow(FOLLOW_4);
                    	    lv_obligations_22_0=ruleObligation();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getModelRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"obligations",
                    	    								lv_obligations_22_0,
                    	    								"org.xtext.example.symboleo.Symboleo.Obligation");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }

                    	    otherlv_23=(Token)match(input,12,FOLLOW_14); 

                    	    					newLeafNode(otherlv_23, grammarAccess.getModelAccess().getSemicolonKeyword_13_1_1());
                    	    				

                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalSymboleo.g:328:3: (otherlv_24= 'SurvivingObligations' ( ( (lv_sobligations_25_0= ruleObligation ) ) otherlv_26= ';' )* )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==22) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalSymboleo.g:329:4: otherlv_24= 'SurvivingObligations' ( ( (lv_sobligations_25_0= ruleObligation ) ) otherlv_26= ';' )*
                    {
                    otherlv_24=(Token)match(input,22,FOLLOW_15); 

                    				newLeafNode(otherlv_24, grammarAccess.getModelAccess().getSurvivingObligationsKeyword_14_0());
                    			
                    // InternalSymboleo.g:333:4: ( ( (lv_sobligations_25_0= ruleObligation ) ) otherlv_26= ';' )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==RULE_ID) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // InternalSymboleo.g:334:5: ( (lv_sobligations_25_0= ruleObligation ) ) otherlv_26= ';'
                    	    {
                    	    // InternalSymboleo.g:334:5: ( (lv_sobligations_25_0= ruleObligation ) )
                    	    // InternalSymboleo.g:335:6: (lv_sobligations_25_0= ruleObligation )
                    	    {
                    	    // InternalSymboleo.g:335:6: (lv_sobligations_25_0= ruleObligation )
                    	    // InternalSymboleo.g:336:7: lv_sobligations_25_0= ruleObligation
                    	    {

                    	    							newCompositeNode(grammarAccess.getModelAccess().getSobligationsObligationParserRuleCall_14_1_0_0());
                    	    						
                    	    pushFollow(FOLLOW_4);
                    	    lv_sobligations_25_0=ruleObligation();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getModelRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"sobligations",
                    	    								lv_sobligations_25_0,
                    	    								"org.xtext.example.symboleo.Symboleo.Obligation");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }

                    	    otherlv_26=(Token)match(input,12,FOLLOW_15); 

                    	    					newLeafNode(otherlv_26, grammarAccess.getModelAccess().getSemicolonKeyword_14_1_1());
                    	    				

                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalSymboleo.g:359:3: (otherlv_27= 'Powers' ( ( (lv_powers_28_0= rulePower ) ) otherlv_29= ';' )* )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==23) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalSymboleo.g:360:4: otherlv_27= 'Powers' ( ( (lv_powers_28_0= rulePower ) ) otherlv_29= ';' )*
                    {
                    otherlv_27=(Token)match(input,23,FOLLOW_16); 

                    				newLeafNode(otherlv_27, grammarAccess.getModelAccess().getPowersKeyword_15_0());
                    			
                    // InternalSymboleo.g:364:4: ( ( (lv_powers_28_0= rulePower ) ) otherlv_29= ';' )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==RULE_ID) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalSymboleo.g:365:5: ( (lv_powers_28_0= rulePower ) ) otherlv_29= ';'
                    	    {
                    	    // InternalSymboleo.g:365:5: ( (lv_powers_28_0= rulePower ) )
                    	    // InternalSymboleo.g:366:6: (lv_powers_28_0= rulePower )
                    	    {
                    	    // InternalSymboleo.g:366:6: (lv_powers_28_0= rulePower )
                    	    // InternalSymboleo.g:367:7: lv_powers_28_0= rulePower
                    	    {

                    	    							newCompositeNode(grammarAccess.getModelAccess().getPowersPowerParserRuleCall_15_1_0_0());
                    	    						
                    	    pushFollow(FOLLOW_4);
                    	    lv_powers_28_0=rulePower();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getModelRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"powers",
                    	    								lv_powers_28_0,
                    	    								"org.xtext.example.symboleo.Symboleo.Power");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }

                    	    otherlv_29=(Token)match(input,12,FOLLOW_16); 

                    	    					newLeafNode(otherlv_29, grammarAccess.getModelAccess().getSemicolonKeyword_15_1_1());
                    	    				

                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalSymboleo.g:390:3: (otherlv_30= 'Constraints' ( ( (lv_constraints_31_0= ruleProposition ) ) otherlv_32= ';' )* )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==24) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalSymboleo.g:391:4: otherlv_30= 'Constraints' ( ( (lv_constraints_31_0= ruleProposition ) ) otherlv_32= ';' )*
                    {
                    otherlv_30=(Token)match(input,24,FOLLOW_17); 

                    				newLeafNode(otherlv_30, grammarAccess.getModelAccess().getConstraintsKeyword_16_0());
                    			
                    // InternalSymboleo.g:395:4: ( ( (lv_constraints_31_0= ruleProposition ) ) otherlv_32= ';' )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( ((LA15_0>=RULE_ID && LA15_0<=RULE_INT)||(LA15_0>=44 && LA15_0<=46)||(LA15_0>=48 && LA15_0<=49)||(LA15_0>=67 && LA15_0<=109)) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // InternalSymboleo.g:396:5: ( (lv_constraints_31_0= ruleProposition ) ) otherlv_32= ';'
                    	    {
                    	    // InternalSymboleo.g:396:5: ( (lv_constraints_31_0= ruleProposition ) )
                    	    // InternalSymboleo.g:397:6: (lv_constraints_31_0= ruleProposition )
                    	    {
                    	    // InternalSymboleo.g:397:6: (lv_constraints_31_0= ruleProposition )
                    	    // InternalSymboleo.g:398:7: lv_constraints_31_0= ruleProposition
                    	    {

                    	    							newCompositeNode(grammarAccess.getModelAccess().getConstraintsPropositionParserRuleCall_16_1_0_0());
                    	    						
                    	    pushFollow(FOLLOW_4);
                    	    lv_constraints_31_0=ruleProposition();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getModelRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"constraints",
                    	    								lv_constraints_31_0,
                    	    								"org.xtext.example.symboleo.Symboleo.Proposition");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }

                    	    otherlv_32=(Token)match(input,12,FOLLOW_17); 

                    	    					newLeafNode(otherlv_32, grammarAccess.getModelAccess().getSemicolonKeyword_16_1_1());
                    	    				

                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_33=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_33, grammarAccess.getModelAccess().getEndContractKeyword_17());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleDomainConcept"
    // InternalSymboleo.g:429:1: entryRuleDomainConcept returns [EObject current=null] : iv_ruleDomainConcept= ruleDomainConcept EOF ;
    public final EObject entryRuleDomainConcept() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDomainConcept = null;


        try {
            // InternalSymboleo.g:429:54: (iv_ruleDomainConcept= ruleDomainConcept EOF )
            // InternalSymboleo.g:430:2: iv_ruleDomainConcept= ruleDomainConcept EOF
            {
             newCompositeNode(grammarAccess.getDomainConceptRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDomainConcept=ruleDomainConcept();

            state._fsp--;

             current =iv_ruleDomainConcept; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDomainConcept"


    // $ANTLR start "ruleDomainConcept"
    // InternalSymboleo.g:436:1: ruleDomainConcept returns [EObject current=null] : (this_Regular_0= ruleRegular | this_Enumeration_1= ruleEnumeration ) ;
    public final EObject ruleDomainConcept() throws RecognitionException {
        EObject current = null;

        EObject this_Regular_0 = null;

        EObject this_Enumeration_1 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:442:2: ( (this_Regular_0= ruleRegular | this_Enumeration_1= ruleEnumeration ) )
            // InternalSymboleo.g:443:2: (this_Regular_0= ruleRegular | this_Enumeration_1= ruleEnumeration )
            {
            // InternalSymboleo.g:443:2: (this_Regular_0= ruleRegular | this_Enumeration_1= ruleEnumeration )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID) ) {
                int LA17_1 = input.LA(2);

                if ( (LA17_1==26) ) {
                    int LA17_2 = input.LA(3);

                    if ( (LA17_2==29) ) {
                        alt17=2;
                    }
                    else if ( (LA17_2==RULE_ID||(LA17_2>=30 && LA17_2<=37)) ) {
                        alt17=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 17, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalSymboleo.g:444:3: this_Regular_0= ruleRegular
                    {

                    			newCompositeNode(grammarAccess.getDomainConceptAccess().getRegularParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Regular_0=ruleRegular();

                    state._fsp--;


                    			current = this_Regular_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:453:3: this_Enumeration_1= ruleEnumeration
                    {

                    			newCompositeNode(grammarAccess.getDomainConceptAccess().getEnumerationParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Enumeration_1=ruleEnumeration();

                    state._fsp--;


                    			current = this_Enumeration_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDomainConcept"


    // $ANTLR start "entryRuleRegular"
    // InternalSymboleo.g:465:1: entryRuleRegular returns [EObject current=null] : iv_ruleRegular= ruleRegular EOF ;
    public final EObject entryRuleRegular() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegular = null;


        try {
            // InternalSymboleo.g:465:48: (iv_ruleRegular= ruleRegular EOF )
            // InternalSymboleo.g:466:2: iv_ruleRegular= ruleRegular EOF
            {
             newCompositeNode(grammarAccess.getRegularRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRegular=ruleRegular();

            state._fsp--;

             current =iv_ruleRegular; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRegular"


    // $ANTLR start "ruleRegular"
    // InternalSymboleo.g:472:1: ruleRegular returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'isA' ( (lv_conceptType_2_0= ruleCType ) ) (otherlv_3= 'with' ( ( (lv_attributes_4_0= ruleAttribute ) ) otherlv_5= ',' )* ( (lv_attributes_6_0= ruleAttribute ) ) )? ) ;
    public final EObject ruleRegular() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_conceptType_2_0 = null;

        EObject lv_attributes_4_0 = null;

        EObject lv_attributes_6_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:478:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'isA' ( (lv_conceptType_2_0= ruleCType ) ) (otherlv_3= 'with' ( ( (lv_attributes_4_0= ruleAttribute ) ) otherlv_5= ',' )* ( (lv_attributes_6_0= ruleAttribute ) ) )? ) )
            // InternalSymboleo.g:479:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'isA' ( (lv_conceptType_2_0= ruleCType ) ) (otherlv_3= 'with' ( ( (lv_attributes_4_0= ruleAttribute ) ) otherlv_5= ',' )* ( (lv_attributes_6_0= ruleAttribute ) ) )? )
            {
            // InternalSymboleo.g:479:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'isA' ( (lv_conceptType_2_0= ruleCType ) ) (otherlv_3= 'with' ( ( (lv_attributes_4_0= ruleAttribute ) ) otherlv_5= ',' )* ( (lv_attributes_6_0= ruleAttribute ) ) )? )
            // InternalSymboleo.g:480:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'isA' ( (lv_conceptType_2_0= ruleCType ) ) (otherlv_3= 'with' ( ( (lv_attributes_4_0= ruleAttribute ) ) otherlv_5= ',' )* ( (lv_attributes_6_0= ruleAttribute ) ) )?
            {
            // InternalSymboleo.g:480:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalSymboleo.g:481:4: (lv_name_0_0= RULE_ID )
            {
            // InternalSymboleo.g:481:4: (lv_name_0_0= RULE_ID )
            // InternalSymboleo.g:482:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_18); 

            					newLeafNode(lv_name_0_0, grammarAccess.getRegularAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRegularRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,26,FOLLOW_19); 

            			newLeafNode(otherlv_1, grammarAccess.getRegularAccess().getIsAKeyword_1());
            		
            // InternalSymboleo.g:502:3: ( (lv_conceptType_2_0= ruleCType ) )
            // InternalSymboleo.g:503:4: (lv_conceptType_2_0= ruleCType )
            {
            // InternalSymboleo.g:503:4: (lv_conceptType_2_0= ruleCType )
            // InternalSymboleo.g:504:5: lv_conceptType_2_0= ruleCType
            {

            					newCompositeNode(grammarAccess.getRegularAccess().getConceptTypeCTypeParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_20);
            lv_conceptType_2_0=ruleCType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRegularRule());
            					}
            					set(
            						current,
            						"conceptType",
            						lv_conceptType_2_0,
            						"org.xtext.example.symboleo.Symboleo.CType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSymboleo.g:521:3: (otherlv_3= 'with' ( ( (lv_attributes_4_0= ruleAttribute ) ) otherlv_5= ',' )* ( (lv_attributes_6_0= ruleAttribute ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==27) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalSymboleo.g:522:4: otherlv_3= 'with' ( ( (lv_attributes_4_0= ruleAttribute ) ) otherlv_5= ',' )* ( (lv_attributes_6_0= ruleAttribute ) )
                    {
                    otherlv_3=(Token)match(input,27,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getRegularAccess().getWithKeyword_3_0());
                    			
                    // InternalSymboleo.g:526:4: ( ( (lv_attributes_4_0= ruleAttribute ) ) otherlv_5= ',' )*
                    loop18:
                    do {
                        int alt18=2;
                        alt18 = dfa18.predict(input);
                        switch (alt18) {
                    	case 1 :
                    	    // InternalSymboleo.g:527:5: ( (lv_attributes_4_0= ruleAttribute ) ) otherlv_5= ','
                    	    {
                    	    // InternalSymboleo.g:527:5: ( (lv_attributes_4_0= ruleAttribute ) )
                    	    // InternalSymboleo.g:528:6: (lv_attributes_4_0= ruleAttribute )
                    	    {
                    	    // InternalSymboleo.g:528:6: (lv_attributes_4_0= ruleAttribute )
                    	    // InternalSymboleo.g:529:7: lv_attributes_4_0= ruleAttribute
                    	    {

                    	    							newCompositeNode(grammarAccess.getRegularAccess().getAttributesAttributeParserRuleCall_3_1_0_0());
                    	    						
                    	    pushFollow(FOLLOW_8);
                    	    lv_attributes_4_0=ruleAttribute();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getRegularRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"attributes",
                    	    								lv_attributes_4_0,
                    	    								"org.xtext.example.symboleo.Symboleo.Attribute");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }

                    	    otherlv_5=(Token)match(input,16,FOLLOW_3); 

                    	    					newLeafNode(otherlv_5, grammarAccess.getRegularAccess().getCommaKeyword_3_1_1());
                    	    				

                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);

                    // InternalSymboleo.g:551:4: ( (lv_attributes_6_0= ruleAttribute ) )
                    // InternalSymboleo.g:552:5: (lv_attributes_6_0= ruleAttribute )
                    {
                    // InternalSymboleo.g:552:5: (lv_attributes_6_0= ruleAttribute )
                    // InternalSymboleo.g:553:6: lv_attributes_6_0= ruleAttribute
                    {

                    						newCompositeNode(grammarAccess.getRegularAccess().getAttributesAttributeParserRuleCall_3_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_attributes_6_0=ruleAttribute();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRegularRule());
                    						}
                    						add(
                    							current,
                    							"attributes",
                    							lv_attributes_6_0,
                    							"org.xtext.example.symboleo.Symboleo.Attribute");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRegular"


    // $ANTLR start "entryRuleAttribute"
    // InternalSymboleo.g:575:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // InternalSymboleo.g:575:50: (iv_ruleAttribute= ruleAttribute EOF )
            // InternalSymboleo.g:576:2: iv_ruleAttribute= ruleAttribute EOF
            {
             newCompositeNode(grammarAccess.getAttributeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttribute=ruleAttribute();

            state._fsp--;

             current =iv_ruleAttribute; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // InternalSymboleo.g:582:1: ruleAttribute returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_attributeType_2_0= ruleCType ) ) ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_attributeType_2_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:588:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_attributeType_2_0= ruleCType ) ) ) )
            // InternalSymboleo.g:589:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_attributeType_2_0= ruleCType ) ) )
            {
            // InternalSymboleo.g:589:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_attributeType_2_0= ruleCType ) ) )
            // InternalSymboleo.g:590:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_attributeType_2_0= ruleCType ) )
            {
            // InternalSymboleo.g:590:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalSymboleo.g:591:4: (lv_name_0_0= RULE_ID )
            {
            // InternalSymboleo.g:591:4: (lv_name_0_0= RULE_ID )
            // InternalSymboleo.g:592:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_21); 

            					newLeafNode(lv_name_0_0, grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAttributeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,28,FOLLOW_19); 

            			newLeafNode(otherlv_1, grammarAccess.getAttributeAccess().getColonKeyword_1());
            		
            // InternalSymboleo.g:612:3: ( (lv_attributeType_2_0= ruleCType ) )
            // InternalSymboleo.g:613:4: (lv_attributeType_2_0= ruleCType )
            {
            // InternalSymboleo.g:613:4: (lv_attributeType_2_0= ruleCType )
            // InternalSymboleo.g:614:5: lv_attributeType_2_0= ruleCType
            {

            					newCompositeNode(grammarAccess.getAttributeAccess().getAttributeTypeCTypeParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_attributeType_2_0=ruleCType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAttributeRule());
            					}
            					set(
            						current,
            						"attributeType",
            						lv_attributeType_2_0,
            						"org.xtext.example.symboleo.Symboleo.CType");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleEnumeration"
    // InternalSymboleo.g:635:1: entryRuleEnumeration returns [EObject current=null] : iv_ruleEnumeration= ruleEnumeration EOF ;
    public final EObject entryRuleEnumeration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumeration = null;


        try {
            // InternalSymboleo.g:635:52: (iv_ruleEnumeration= ruleEnumeration EOF )
            // InternalSymboleo.g:636:2: iv_ruleEnumeration= ruleEnumeration EOF
            {
             newCompositeNode(grammarAccess.getEnumerationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnumeration=ruleEnumeration();

            state._fsp--;

             current =iv_ruleEnumeration; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumeration"


    // $ANTLR start "ruleEnumeration"
    // InternalSymboleo.g:642:1: ruleEnumeration returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'isA' otherlv_2= 'Enumeration' otherlv_3= '(' ( ( (lv_enumerationItems_4_0= ruleenumItem ) ) otherlv_5= ',' )* ( (lv_enumerationItems_6_0= ruleenumItem ) ) otherlv_7= ')' ) ;
    public final EObject ruleEnumeration() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_enumerationItems_4_0 = null;

        EObject lv_enumerationItems_6_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:648:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'isA' otherlv_2= 'Enumeration' otherlv_3= '(' ( ( (lv_enumerationItems_4_0= ruleenumItem ) ) otherlv_5= ',' )* ( (lv_enumerationItems_6_0= ruleenumItem ) ) otherlv_7= ')' ) )
            // InternalSymboleo.g:649:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'isA' otherlv_2= 'Enumeration' otherlv_3= '(' ( ( (lv_enumerationItems_4_0= ruleenumItem ) ) otherlv_5= ',' )* ( (lv_enumerationItems_6_0= ruleenumItem ) ) otherlv_7= ')' )
            {
            // InternalSymboleo.g:649:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'isA' otherlv_2= 'Enumeration' otherlv_3= '(' ( ( (lv_enumerationItems_4_0= ruleenumItem ) ) otherlv_5= ',' )* ( (lv_enumerationItems_6_0= ruleenumItem ) ) otherlv_7= ')' )
            // InternalSymboleo.g:650:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'isA' otherlv_2= 'Enumeration' otherlv_3= '(' ( ( (lv_enumerationItems_4_0= ruleenumItem ) ) otherlv_5= ',' )* ( (lv_enumerationItems_6_0= ruleenumItem ) ) otherlv_7= ')'
            {
            // InternalSymboleo.g:650:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalSymboleo.g:651:4: (lv_name_0_0= RULE_ID )
            {
            // InternalSymboleo.g:651:4: (lv_name_0_0= RULE_ID )
            // InternalSymboleo.g:652:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_18); 

            					newLeafNode(lv_name_0_0, grammarAccess.getEnumerationAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEnumerationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,26,FOLLOW_22); 

            			newLeafNode(otherlv_1, grammarAccess.getEnumerationAccess().getIsAKeyword_1());
            		
            otherlv_2=(Token)match(input,29,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getEnumerationAccess().getEnumerationKeyword_2());
            		
            otherlv_3=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getEnumerationAccess().getLeftParenthesisKeyword_3());
            		
            // InternalSymboleo.g:680:3: ( ( (lv_enumerationItems_4_0= ruleenumItem ) ) otherlv_5= ',' )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_ID) ) {
                    int LA20_1 = input.LA(2);

                    if ( (LA20_1==16) ) {
                        alt20=1;
                    }


                }


                switch (alt20) {
            	case 1 :
            	    // InternalSymboleo.g:681:4: ( (lv_enumerationItems_4_0= ruleenumItem ) ) otherlv_5= ','
            	    {
            	    // InternalSymboleo.g:681:4: ( (lv_enumerationItems_4_0= ruleenumItem ) )
            	    // InternalSymboleo.g:682:5: (lv_enumerationItems_4_0= ruleenumItem )
            	    {
            	    // InternalSymboleo.g:682:5: (lv_enumerationItems_4_0= ruleenumItem )
            	    // InternalSymboleo.g:683:6: lv_enumerationItems_4_0= ruleenumItem
            	    {

            	    						newCompositeNode(grammarAccess.getEnumerationAccess().getEnumerationItemsEnumItemParserRuleCall_4_0_0());
            	    					
            	    pushFollow(FOLLOW_8);
            	    lv_enumerationItems_4_0=ruleenumItem();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getEnumerationRule());
            	    						}
            	    						add(
            	    							current,
            	    							"enumerationItems",
            	    							lv_enumerationItems_4_0,
            	    							"org.xtext.example.symboleo.Symboleo.enumItem");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    otherlv_5=(Token)match(input,16,FOLLOW_3); 

            	    				newLeafNode(otherlv_5, grammarAccess.getEnumerationAccess().getCommaKeyword_4_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            // InternalSymboleo.g:705:3: ( (lv_enumerationItems_6_0= ruleenumItem ) )
            // InternalSymboleo.g:706:4: (lv_enumerationItems_6_0= ruleenumItem )
            {
            // InternalSymboleo.g:706:4: (lv_enumerationItems_6_0= ruleenumItem )
            // InternalSymboleo.g:707:5: lv_enumerationItems_6_0= ruleenumItem
            {

            					newCompositeNode(grammarAccess.getEnumerationAccess().getEnumerationItemsEnumItemParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_9);
            lv_enumerationItems_6_0=ruleenumItem();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEnumerationRule());
            					}
            					add(
            						current,
            						"enumerationItems",
            						lv_enumerationItems_6_0,
            						"org.xtext.example.symboleo.Symboleo.enumItem");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getEnumerationAccess().getRightParenthesisKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumeration"


    // $ANTLR start "entryRuleenumItem"
    // InternalSymboleo.g:732:1: entryRuleenumItem returns [EObject current=null] : iv_ruleenumItem= ruleenumItem EOF ;
    public final EObject entryRuleenumItem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleenumItem = null;


        try {
            // InternalSymboleo.g:732:49: (iv_ruleenumItem= ruleenumItem EOF )
            // InternalSymboleo.g:733:2: iv_ruleenumItem= ruleenumItem EOF
            {
             newCompositeNode(grammarAccess.getEnumItemRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleenumItem=ruleenumItem();

            state._fsp--;

             current =iv_ruleenumItem; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleenumItem"


    // $ANTLR start "ruleenumItem"
    // InternalSymboleo.g:739:1: ruleenumItem returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleenumItem() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalSymboleo.g:745:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalSymboleo.g:746:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalSymboleo.g:746:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // InternalSymboleo.g:747:3: () ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalSymboleo.g:747:3: ()
            // InternalSymboleo.g:748:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getEnumItemAccess().getEnumItemAction_0(),
            					current);
            			

            }

            // InternalSymboleo.g:754:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSymboleo.g:755:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSymboleo.g:755:4: (lv_name_1_0= RULE_ID )
            // InternalSymboleo.g:756:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getEnumItemAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEnumItemRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleenumItem"


    // $ANTLR start "entryRuleCType"
    // InternalSymboleo.g:776:1: entryRuleCType returns [EObject current=null] : iv_ruleCType= ruleCType EOF ;
    public final EObject entryRuleCType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCType = null;


        try {
            // InternalSymboleo.g:776:46: (iv_ruleCType= ruleCType EOF )
            // InternalSymboleo.g:777:2: iv_ruleCType= ruleCType EOF
            {
             newCompositeNode(grammarAccess.getCTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCType=ruleCType();

            state._fsp--;

             current =iv_ruleCType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCType"


    // $ANTLR start "ruleCType"
    // InternalSymboleo.g:783:1: ruleCType returns [EObject current=null] : (this_DomainType_0= ruleDomainType | this_OntoCType_1= ruleOntoCType | this_BasicType_2= ruleBasicType ) ;
    public final EObject ruleCType() throws RecognitionException {
        EObject current = null;

        EObject this_DomainType_0 = null;

        EObject this_OntoCType_1 = null;

        EObject this_BasicType_2 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:789:2: ( (this_DomainType_0= ruleDomainType | this_OntoCType_1= ruleOntoCType | this_BasicType_2= ruleBasicType ) )
            // InternalSymboleo.g:790:2: (this_DomainType_0= ruleDomainType | this_OntoCType_1= ruleOntoCType | this_BasicType_2= ruleBasicType )
            {
            // InternalSymboleo.g:790:2: (this_DomainType_0= ruleDomainType | this_OntoCType_1= ruleOntoCType | this_BasicType_2= ruleBasicType )
            int alt21=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt21=1;
                }
                break;
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
                {
                alt21=2;
                }
                break;
            case 30:
            case 31:
            case 32:
                {
                alt21=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // InternalSymboleo.g:791:3: this_DomainType_0= ruleDomainType
                    {

                    			newCompositeNode(grammarAccess.getCTypeAccess().getDomainTypeParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_DomainType_0=ruleDomainType();

                    state._fsp--;


                    			current = this_DomainType_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:800:3: this_OntoCType_1= ruleOntoCType
                    {

                    			newCompositeNode(grammarAccess.getCTypeAccess().getOntoCTypeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_OntoCType_1=ruleOntoCType();

                    state._fsp--;


                    			current = this_OntoCType_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:809:3: this_BasicType_2= ruleBasicType
                    {

                    			newCompositeNode(grammarAccess.getCTypeAccess().getBasicTypeParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_BasicType_2=ruleBasicType();

                    state._fsp--;


                    			current = this_BasicType_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCType"


    // $ANTLR start "entryRuleDomainType"
    // InternalSymboleo.g:821:1: entryRuleDomainType returns [EObject current=null] : iv_ruleDomainType= ruleDomainType EOF ;
    public final EObject entryRuleDomainType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDomainType = null;


        try {
            // InternalSymboleo.g:821:51: (iv_ruleDomainType= ruleDomainType EOF )
            // InternalSymboleo.g:822:2: iv_ruleDomainType= ruleDomainType EOF
            {
             newCompositeNode(grammarAccess.getDomainTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDomainType=ruleDomainType();

            state._fsp--;

             current =iv_ruleDomainType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDomainType"


    // $ANTLR start "ruleDomainType"
    // InternalSymboleo.g:828:1: ruleDomainType returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleDomainType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalSymboleo.g:834:2: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalSymboleo.g:835:2: ( (otherlv_0= RULE_ID ) )
            {
            // InternalSymboleo.g:835:2: ( (otherlv_0= RULE_ID ) )
            // InternalSymboleo.g:836:3: (otherlv_0= RULE_ID )
            {
            // InternalSymboleo.g:836:3: (otherlv_0= RULE_ID )
            // InternalSymboleo.g:837:4: otherlv_0= RULE_ID
            {

            				if (current==null) {
            					current = createModelElement(grammarAccess.getDomainTypeRule());
            				}
            			
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(otherlv_0, grammarAccess.getDomainTypeAccess().getSuperTypeDomainConceptCrossReference_0());
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDomainType"


    // $ANTLR start "entryRuleBasicType"
    // InternalSymboleo.g:851:1: entryRuleBasicType returns [EObject current=null] : iv_ruleBasicType= ruleBasicType EOF ;
    public final EObject entryRuleBasicType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBasicType = null;


        try {
            // InternalSymboleo.g:851:50: (iv_ruleBasicType= ruleBasicType EOF )
            // InternalSymboleo.g:852:2: iv_ruleBasicType= ruleBasicType EOF
            {
             newCompositeNode(grammarAccess.getBasicTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBasicType=ruleBasicType();

            state._fsp--;

             current =iv_ruleBasicType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBasicType"


    // $ANTLR start "ruleBasicType"
    // InternalSymboleo.g:858:1: ruleBasicType returns [EObject current=null] : ( ( (lv_name_0_1= 'NUMBER' | lv_name_0_2= 'STRING' | lv_name_0_3= 'DATE' ) ) ) ;
    public final EObject ruleBasicType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;
        Token lv_name_0_3=null;


        	enterRule();

        try {
            // InternalSymboleo.g:864:2: ( ( ( (lv_name_0_1= 'NUMBER' | lv_name_0_2= 'STRING' | lv_name_0_3= 'DATE' ) ) ) )
            // InternalSymboleo.g:865:2: ( ( (lv_name_0_1= 'NUMBER' | lv_name_0_2= 'STRING' | lv_name_0_3= 'DATE' ) ) )
            {
            // InternalSymboleo.g:865:2: ( ( (lv_name_0_1= 'NUMBER' | lv_name_0_2= 'STRING' | lv_name_0_3= 'DATE' ) ) )
            // InternalSymboleo.g:866:3: ( (lv_name_0_1= 'NUMBER' | lv_name_0_2= 'STRING' | lv_name_0_3= 'DATE' ) )
            {
            // InternalSymboleo.g:866:3: ( (lv_name_0_1= 'NUMBER' | lv_name_0_2= 'STRING' | lv_name_0_3= 'DATE' ) )
            // InternalSymboleo.g:867:4: (lv_name_0_1= 'NUMBER' | lv_name_0_2= 'STRING' | lv_name_0_3= 'DATE' )
            {
            // InternalSymboleo.g:867:4: (lv_name_0_1= 'NUMBER' | lv_name_0_2= 'STRING' | lv_name_0_3= 'DATE' )
            int alt22=3;
            switch ( input.LA(1) ) {
            case 30:
                {
                alt22=1;
                }
                break;
            case 31:
                {
                alt22=2;
                }
                break;
            case 32:
                {
                alt22=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // InternalSymboleo.g:868:5: lv_name_0_1= 'NUMBER'
                    {
                    lv_name_0_1=(Token)match(input,30,FOLLOW_2); 

                    					newLeafNode(lv_name_0_1, grammarAccess.getBasicTypeAccess().getNameNUMBERKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBasicTypeRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:879:5: lv_name_0_2= 'STRING'
                    {
                    lv_name_0_2=(Token)match(input,31,FOLLOW_2); 

                    					newLeafNode(lv_name_0_2, grammarAccess.getBasicTypeAccess().getNameSTRINGKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBasicTypeRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_2, null);
                    				

                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:890:5: lv_name_0_3= 'DATE'
                    {
                    lv_name_0_3=(Token)match(input,32,FOLLOW_2); 

                    					newLeafNode(lv_name_0_3, grammarAccess.getBasicTypeAccess().getNameDATEKeyword_0_2());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBasicTypeRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_3, null);
                    				

                    }
                    break;

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBasicType"


    // $ANTLR start "entryRuleOntoCType"
    // InternalSymboleo.g:906:1: entryRuleOntoCType returns [EObject current=null] : iv_ruleOntoCType= ruleOntoCType EOF ;
    public final EObject entryRuleOntoCType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOntoCType = null;


        try {
            // InternalSymboleo.g:906:50: (iv_ruleOntoCType= ruleOntoCType EOF )
            // InternalSymboleo.g:907:2: iv_ruleOntoCType= ruleOntoCType EOF
            {
             newCompositeNode(grammarAccess.getOntoCTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOntoCType=ruleOntoCType();

            state._fsp--;

             current =iv_ruleOntoCType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOntoCType"


    // $ANTLR start "ruleOntoCType"
    // InternalSymboleo.g:913:1: ruleOntoCType returns [EObject current=null] : ( ( (lv_name_0_1= 'ASSET' | lv_name_0_2= 'EVENT' | lv_name_0_3= 'ROLE' | lv_name_0_4= 'SITUATION' | lv_name_0_5= 'CONTRACT' ) ) ) ;
    public final EObject ruleOntoCType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;
        Token lv_name_0_3=null;
        Token lv_name_0_4=null;
        Token lv_name_0_5=null;


        	enterRule();

        try {
            // InternalSymboleo.g:919:2: ( ( ( (lv_name_0_1= 'ASSET' | lv_name_0_2= 'EVENT' | lv_name_0_3= 'ROLE' | lv_name_0_4= 'SITUATION' | lv_name_0_5= 'CONTRACT' ) ) ) )
            // InternalSymboleo.g:920:2: ( ( (lv_name_0_1= 'ASSET' | lv_name_0_2= 'EVENT' | lv_name_0_3= 'ROLE' | lv_name_0_4= 'SITUATION' | lv_name_0_5= 'CONTRACT' ) ) )
            {
            // InternalSymboleo.g:920:2: ( ( (lv_name_0_1= 'ASSET' | lv_name_0_2= 'EVENT' | lv_name_0_3= 'ROLE' | lv_name_0_4= 'SITUATION' | lv_name_0_5= 'CONTRACT' ) ) )
            // InternalSymboleo.g:921:3: ( (lv_name_0_1= 'ASSET' | lv_name_0_2= 'EVENT' | lv_name_0_3= 'ROLE' | lv_name_0_4= 'SITUATION' | lv_name_0_5= 'CONTRACT' ) )
            {
            // InternalSymboleo.g:921:3: ( (lv_name_0_1= 'ASSET' | lv_name_0_2= 'EVENT' | lv_name_0_3= 'ROLE' | lv_name_0_4= 'SITUATION' | lv_name_0_5= 'CONTRACT' ) )
            // InternalSymboleo.g:922:4: (lv_name_0_1= 'ASSET' | lv_name_0_2= 'EVENT' | lv_name_0_3= 'ROLE' | lv_name_0_4= 'SITUATION' | lv_name_0_5= 'CONTRACT' )
            {
            // InternalSymboleo.g:922:4: (lv_name_0_1= 'ASSET' | lv_name_0_2= 'EVENT' | lv_name_0_3= 'ROLE' | lv_name_0_4= 'SITUATION' | lv_name_0_5= 'CONTRACT' )
            int alt23=5;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt23=1;
                }
                break;
            case 34:
                {
                alt23=2;
                }
                break;
            case 35:
                {
                alt23=3;
                }
                break;
            case 36:
                {
                alt23=4;
                }
                break;
            case 37:
                {
                alt23=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // InternalSymboleo.g:923:5: lv_name_0_1= 'ASSET'
                    {
                    lv_name_0_1=(Token)match(input,33,FOLLOW_2); 

                    					newLeafNode(lv_name_0_1, grammarAccess.getOntoCTypeAccess().getNameASSETKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getOntoCTypeRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:934:5: lv_name_0_2= 'EVENT'
                    {
                    lv_name_0_2=(Token)match(input,34,FOLLOW_2); 

                    					newLeafNode(lv_name_0_2, grammarAccess.getOntoCTypeAccess().getNameEVENTKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getOntoCTypeRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_2, null);
                    				

                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:945:5: lv_name_0_3= 'ROLE'
                    {
                    lv_name_0_3=(Token)match(input,35,FOLLOW_2); 

                    					newLeafNode(lv_name_0_3, grammarAccess.getOntoCTypeAccess().getNameROLEKeyword_0_2());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getOntoCTypeRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_3, null);
                    				

                    }
                    break;
                case 4 :
                    // InternalSymboleo.g:956:5: lv_name_0_4= 'SITUATION'
                    {
                    lv_name_0_4=(Token)match(input,36,FOLLOW_2); 

                    					newLeafNode(lv_name_0_4, grammarAccess.getOntoCTypeAccess().getNameSITUATIONKeyword_0_3());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getOntoCTypeRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_4, null);
                    				

                    }
                    break;
                case 5 :
                    // InternalSymboleo.g:967:5: lv_name_0_5= 'CONTRACT'
                    {
                    lv_name_0_5=(Token)match(input,37,FOLLOW_2); 

                    					newLeafNode(lv_name_0_5, grammarAccess.getOntoCTypeAccess().getNameCONTRACTKeyword_0_4());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getOntoCTypeRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_5, null);
                    				

                    }
                    break;

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOntoCType"


    // $ANTLR start "entryRuleParameter"
    // InternalSymboleo.g:983:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalSymboleo.g:983:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalSymboleo.g:984:2: iv_ruleParameter= ruleParameter EOF
            {
             newCompositeNode(grammarAccess.getParameterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameter=ruleParameter();

            state._fsp--;

             current =iv_ruleParameter; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // InternalSymboleo.g:990:1: ruleParameter returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypeName ) ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_type_2_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:996:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypeName ) ) ) )
            // InternalSymboleo.g:997:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypeName ) ) )
            {
            // InternalSymboleo.g:997:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypeName ) ) )
            // InternalSymboleo.g:998:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypeName ) )
            {
            // InternalSymboleo.g:998:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalSymboleo.g:999:4: (lv_name_0_0= RULE_ID )
            {
            // InternalSymboleo.g:999:4: (lv_name_0_0= RULE_ID )
            // InternalSymboleo.g:1000:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_21); 

            					newLeafNode(lv_name_0_0, grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getParameterRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,28,FOLLOW_19); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterAccess().getColonKeyword_1());
            		
            // InternalSymboleo.g:1020:3: ( (lv_type_2_0= ruleTypeName ) )
            // InternalSymboleo.g:1021:4: (lv_type_2_0= ruleTypeName )
            {
            // InternalSymboleo.g:1021:4: (lv_type_2_0= ruleTypeName )
            // InternalSymboleo.g:1022:5: lv_type_2_0= ruleTypeName
            {

            					newCompositeNode(grammarAccess.getParameterAccess().getTypeTypeNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_type_2_0=ruleTypeName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParameterRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_2_0,
            						"org.xtext.example.symboleo.Symboleo.TypeName");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleTypeName"
    // InternalSymboleo.g:1043:1: entryRuleTypeName returns [EObject current=null] : iv_ruleTypeName= ruleTypeName EOF ;
    public final EObject entryRuleTypeName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeName = null;


        try {
            // InternalSymboleo.g:1043:49: (iv_ruleTypeName= ruleTypeName EOF )
            // InternalSymboleo.g:1044:2: iv_ruleTypeName= ruleTypeName EOF
            {
             newCompositeNode(grammarAccess.getTypeNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTypeName=ruleTypeName();

            state._fsp--;

             current =iv_ruleTypeName; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeName"


    // $ANTLR start "ruleTypeName"
    // InternalSymboleo.g:1050:1: ruleTypeName returns [EObject current=null] : (this_DomainType_0= ruleDomainType | this_BasicType_1= ruleBasicType ) ;
    public final EObject ruleTypeName() throws RecognitionException {
        EObject current = null;

        EObject this_DomainType_0 = null;

        EObject this_BasicType_1 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:1056:2: ( (this_DomainType_0= ruleDomainType | this_BasicType_1= ruleBasicType ) )
            // InternalSymboleo.g:1057:2: (this_DomainType_0= ruleDomainType | this_BasicType_1= ruleBasicType )
            {
            // InternalSymboleo.g:1057:2: (this_DomainType_0= ruleDomainType | this_BasicType_1= ruleBasicType )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_ID) ) {
                alt24=1;
            }
            else if ( ((LA24_0>=30 && LA24_0<=32)) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // InternalSymboleo.g:1058:3: this_DomainType_0= ruleDomainType
                    {

                    			newCompositeNode(grammarAccess.getTypeNameAccess().getDomainTypeParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_DomainType_0=ruleDomainType();

                    state._fsp--;


                    			current = this_DomainType_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:1067:3: this_BasicType_1= ruleBasicType
                    {

                    			newCompositeNode(grammarAccess.getTypeNameAccess().getBasicTypeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_BasicType_1=ruleBasicType();

                    state._fsp--;


                    			current = this_BasicType_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeName"


    // $ANTLR start "entryRuleDeclarPair"
    // InternalSymboleo.g:1079:1: entryRuleDeclarPair returns [EObject current=null] : iv_ruleDeclarPair= ruleDeclarPair EOF ;
    public final EObject entryRuleDeclarPair() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclarPair = null;


        try {
            // InternalSymboleo.g:1079:51: (iv_ruleDeclarPair= ruleDeclarPair EOF )
            // InternalSymboleo.g:1080:2: iv_ruleDeclarPair= ruleDeclarPair EOF
            {
             newCompositeNode(grammarAccess.getDeclarPairRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDeclarPair=ruleDeclarPair();

            state._fsp--;

             current =iv_ruleDeclarPair; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDeclarPair"


    // $ANTLR start "ruleDeclarPair"
    // InternalSymboleo.g:1086:1: ruleDeclarPair returns [EObject current=null] : ( ( (lv_attr_0_0= RULE_ID ) ) otherlv_1= ':=' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleDeclarPair() throws RecognitionException {
        EObject current = null;

        Token lv_attr_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSymboleo.g:1092:2: ( ( ( (lv_attr_0_0= RULE_ID ) ) otherlv_1= ':=' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalSymboleo.g:1093:2: ( ( (lv_attr_0_0= RULE_ID ) ) otherlv_1= ':=' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalSymboleo.g:1093:2: ( ( (lv_attr_0_0= RULE_ID ) ) otherlv_1= ':=' ( (otherlv_2= RULE_ID ) ) )
            // InternalSymboleo.g:1094:3: ( (lv_attr_0_0= RULE_ID ) ) otherlv_1= ':=' ( (otherlv_2= RULE_ID ) )
            {
            // InternalSymboleo.g:1094:3: ( (lv_attr_0_0= RULE_ID ) )
            // InternalSymboleo.g:1095:4: (lv_attr_0_0= RULE_ID )
            {
            // InternalSymboleo.g:1095:4: (lv_attr_0_0= RULE_ID )
            // InternalSymboleo.g:1096:5: lv_attr_0_0= RULE_ID
            {
            lv_attr_0_0=(Token)match(input,RULE_ID,FOLLOW_23); 

            					newLeafNode(lv_attr_0_0, grammarAccess.getDeclarPairAccess().getAttrIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDeclarPairRule());
            					}
            					setWithLastConsumed(
            						current,
            						"attr",
            						lv_attr_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,38,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getDeclarPairAccess().getColonEqualsSignKeyword_1());
            		
            // InternalSymboleo.g:1116:3: ( (otherlv_2= RULE_ID ) )
            // InternalSymboleo.g:1117:4: (otherlv_2= RULE_ID )
            {
            // InternalSymboleo.g:1117:4: (otherlv_2= RULE_ID )
            // InternalSymboleo.g:1118:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDeclarPairRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(otherlv_2, grammarAccess.getDeclarPairAccess().getParamParameterCrossReference_2_0());
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDeclarPair"


    // $ANTLR start "entryRuleDeclar"
    // InternalSymboleo.g:1133:1: entryRuleDeclar returns [EObject current=null] : iv_ruleDeclar= ruleDeclar EOF ;
    public final EObject entryRuleDeclar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclar = null;


        try {
            // InternalSymboleo.g:1133:47: (iv_ruleDeclar= ruleDeclar EOF )
            // InternalSymboleo.g:1134:2: iv_ruleDeclar= ruleDeclar EOF
            {
             newCompositeNode(grammarAccess.getDeclarRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDeclar=ruleDeclar();

            state._fsp--;

             current =iv_ruleDeclar; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDeclar"


    // $ANTLR start "ruleDeclar"
    // InternalSymboleo.g:1140:1: ruleDeclar returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) otherlv_3= 'with' ( ( (lv_attributes_4_0= ruleDeclarPair ) ) otherlv_5= ',' )* ( (lv_attributes_6_0= ruleDeclarPair ) ) ) ;
    public final EObject ruleDeclar() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_attributes_4_0 = null;

        EObject lv_attributes_6_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:1146:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) otherlv_3= 'with' ( ( (lv_attributes_4_0= ruleDeclarPair ) ) otherlv_5= ',' )* ( (lv_attributes_6_0= ruleDeclarPair ) ) ) )
            // InternalSymboleo.g:1147:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) otherlv_3= 'with' ( ( (lv_attributes_4_0= ruleDeclarPair ) ) otherlv_5= ',' )* ( (lv_attributes_6_0= ruleDeclarPair ) ) )
            {
            // InternalSymboleo.g:1147:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) otherlv_3= 'with' ( ( (lv_attributes_4_0= ruleDeclarPair ) ) otherlv_5= ',' )* ( (lv_attributes_6_0= ruleDeclarPair ) ) )
            // InternalSymboleo.g:1148:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) otherlv_3= 'with' ( ( (lv_attributes_4_0= ruleDeclarPair ) ) otherlv_5= ',' )* ( (lv_attributes_6_0= ruleDeclarPair ) )
            {
            // InternalSymboleo.g:1148:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalSymboleo.g:1149:4: (lv_name_0_0= RULE_ID )
            {
            // InternalSymboleo.g:1149:4: (lv_name_0_0= RULE_ID )
            // InternalSymboleo.g:1150:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_21); 

            					newLeafNode(lv_name_0_0, grammarAccess.getDeclarAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDeclarRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,28,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getDeclarAccess().getColonKeyword_1());
            		
            // InternalSymboleo.g:1170:3: ( (otherlv_2= RULE_ID ) )
            // InternalSymboleo.g:1171:4: (otherlv_2= RULE_ID )
            {
            // InternalSymboleo.g:1171:4: (otherlv_2= RULE_ID )
            // InternalSymboleo.g:1172:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDeclarRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_24); 

            					newLeafNode(otherlv_2, grammarAccess.getDeclarAccess().getTypeRegularCrossReference_2_0());
            				

            }


            }

            otherlv_3=(Token)match(input,27,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getDeclarAccess().getWithKeyword_3());
            		
            // InternalSymboleo.g:1187:3: ( ( (lv_attributes_4_0= ruleDeclarPair ) ) otherlv_5= ',' )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_ID) ) {
                    int LA25_1 = input.LA(2);

                    if ( (LA25_1==38) ) {
                        int LA25_2 = input.LA(3);

                        if ( (LA25_2==RULE_ID) ) {
                            int LA25_3 = input.LA(4);

                            if ( (LA25_3==16) ) {
                                alt25=1;
                            }


                        }


                    }


                }


                switch (alt25) {
            	case 1 :
            	    // InternalSymboleo.g:1188:4: ( (lv_attributes_4_0= ruleDeclarPair ) ) otherlv_5= ','
            	    {
            	    // InternalSymboleo.g:1188:4: ( (lv_attributes_4_0= ruleDeclarPair ) )
            	    // InternalSymboleo.g:1189:5: (lv_attributes_4_0= ruleDeclarPair )
            	    {
            	    // InternalSymboleo.g:1189:5: (lv_attributes_4_0= ruleDeclarPair )
            	    // InternalSymboleo.g:1190:6: lv_attributes_4_0= ruleDeclarPair
            	    {

            	    						newCompositeNode(grammarAccess.getDeclarAccess().getAttributesDeclarPairParserRuleCall_4_0_0());
            	    					
            	    pushFollow(FOLLOW_8);
            	    lv_attributes_4_0=ruleDeclarPair();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getDeclarRule());
            	    						}
            	    						add(
            	    							current,
            	    							"attributes",
            	    							lv_attributes_4_0,
            	    							"org.xtext.example.symboleo.Symboleo.DeclarPair");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    otherlv_5=(Token)match(input,16,FOLLOW_3); 

            	    				newLeafNode(otherlv_5, grammarAccess.getDeclarAccess().getCommaKeyword_4_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            // InternalSymboleo.g:1212:3: ( (lv_attributes_6_0= ruleDeclarPair ) )
            // InternalSymboleo.g:1213:4: (lv_attributes_6_0= ruleDeclarPair )
            {
            // InternalSymboleo.g:1213:4: (lv_attributes_6_0= ruleDeclarPair )
            // InternalSymboleo.g:1214:5: lv_attributes_6_0= ruleDeclarPair
            {

            					newCompositeNode(grammarAccess.getDeclarAccess().getAttributesDeclarPairParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_2);
            lv_attributes_6_0=ruleDeclarPair();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDeclarRule());
            					}
            					add(
            						current,
            						"attributes",
            						lv_attributes_6_0,
            						"org.xtext.example.symboleo.Symboleo.DeclarPair");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDeclar"


    // $ANTLR start "entryRuleObligation"
    // InternalSymboleo.g:1235:1: entryRuleObligation returns [EObject current=null] : iv_ruleObligation= ruleObligation EOF ;
    public final EObject entryRuleObligation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObligation = null;


        try {
            // InternalSymboleo.g:1235:51: (iv_ruleObligation= ruleObligation EOF )
            // InternalSymboleo.g:1236:2: iv_ruleObligation= ruleObligation EOF
            {
             newCompositeNode(grammarAccess.getObligationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleObligation=ruleObligation();

            state._fsp--;

             current =iv_ruleObligation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleObligation"


    // $ANTLR start "ruleObligation"
    // InternalSymboleo.g:1242:1: ruleObligation returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->' )? otherlv_4= 'obligation' otherlv_5= '(' ( (lv_role1_6_0= RULE_ID ) ) otherlv_7= ',' ( (lv_role2_8_0= RULE_ID ) ) otherlv_9= ',' ( (lv_antecedent_10_0= ruleProposition ) ) otherlv_11= ',' ( (lv_consequent_12_0= ruleProposition ) ) otherlv_13= ')' ) ;
    public final EObject ruleObligation() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_role1_6_0=null;
        Token otherlv_7=null;
        Token lv_role2_8_0=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_trigger_2_0 = null;

        EObject lv_antecedent_10_0 = null;

        EObject lv_consequent_12_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:1248:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->' )? otherlv_4= 'obligation' otherlv_5= '(' ( (lv_role1_6_0= RULE_ID ) ) otherlv_7= ',' ( (lv_role2_8_0= RULE_ID ) ) otherlv_9= ',' ( (lv_antecedent_10_0= ruleProposition ) ) otherlv_11= ',' ( (lv_consequent_12_0= ruleProposition ) ) otherlv_13= ')' ) )
            // InternalSymboleo.g:1249:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->' )? otherlv_4= 'obligation' otherlv_5= '(' ( (lv_role1_6_0= RULE_ID ) ) otherlv_7= ',' ( (lv_role2_8_0= RULE_ID ) ) otherlv_9= ',' ( (lv_antecedent_10_0= ruleProposition ) ) otherlv_11= ',' ( (lv_consequent_12_0= ruleProposition ) ) otherlv_13= ')' )
            {
            // InternalSymboleo.g:1249:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->' )? otherlv_4= 'obligation' otherlv_5= '(' ( (lv_role1_6_0= RULE_ID ) ) otherlv_7= ',' ( (lv_role2_8_0= RULE_ID ) ) otherlv_9= ',' ( (lv_antecedent_10_0= ruleProposition ) ) otherlv_11= ',' ( (lv_consequent_12_0= ruleProposition ) ) otherlv_13= ')' )
            // InternalSymboleo.g:1250:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->' )? otherlv_4= 'obligation' otherlv_5= '(' ( (lv_role1_6_0= RULE_ID ) ) otherlv_7= ',' ( (lv_role2_8_0= RULE_ID ) ) otherlv_9= ',' ( (lv_antecedent_10_0= ruleProposition ) ) otherlv_11= ',' ( (lv_consequent_12_0= ruleProposition ) ) otherlv_13= ')'
            {
            // InternalSymboleo.g:1250:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalSymboleo.g:1251:4: (lv_name_0_0= RULE_ID )
            {
            // InternalSymboleo.g:1251:4: (lv_name_0_0= RULE_ID )
            // InternalSymboleo.g:1252:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_21); 

            					newLeafNode(lv_name_0_0, grammarAccess.getObligationAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getObligationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,28,FOLLOW_25); 

            			newLeafNode(otherlv_1, grammarAccess.getObligationAccess().getColonKeyword_1());
            		
            // InternalSymboleo.g:1272:3: ( ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>=RULE_ID && LA26_0<=RULE_INT)||(LA26_0>=44 && LA26_0<=46)||(LA26_0>=48 && LA26_0<=49)||(LA26_0>=67 && LA26_0<=109)) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalSymboleo.g:1273:4: ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->'
                    {
                    // InternalSymboleo.g:1273:4: ( (lv_trigger_2_0= ruleProposition ) )
                    // InternalSymboleo.g:1274:5: (lv_trigger_2_0= ruleProposition )
                    {
                    // InternalSymboleo.g:1274:5: (lv_trigger_2_0= ruleProposition )
                    // InternalSymboleo.g:1275:6: lv_trigger_2_0= ruleProposition
                    {

                    						newCompositeNode(grammarAccess.getObligationAccess().getTriggerPropositionParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_26);
                    lv_trigger_2_0=ruleProposition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getObligationRule());
                    						}
                    						set(
                    							current,
                    							"trigger",
                    							lv_trigger_2_0,
                    							"org.xtext.example.symboleo.Symboleo.Proposition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,39,FOLLOW_27); 

                    				newLeafNode(otherlv_3, grammarAccess.getObligationAccess().getHyphenMinusGreaterThanSignKeyword_2_1());
                    			

                    }
                    break;

            }

            otherlv_4=(Token)match(input,40,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getObligationAccess().getObligationKeyword_3());
            		
            otherlv_5=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_5, grammarAccess.getObligationAccess().getLeftParenthesisKeyword_4());
            		
            // InternalSymboleo.g:1305:3: ( (lv_role1_6_0= RULE_ID ) )
            // InternalSymboleo.g:1306:4: (lv_role1_6_0= RULE_ID )
            {
            // InternalSymboleo.g:1306:4: (lv_role1_6_0= RULE_ID )
            // InternalSymboleo.g:1307:5: lv_role1_6_0= RULE_ID
            {
            lv_role1_6_0=(Token)match(input,RULE_ID,FOLLOW_8); 

            					newLeafNode(lv_role1_6_0, grammarAccess.getObligationAccess().getRole1IDTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getObligationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"role1",
            						lv_role1_6_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_7=(Token)match(input,16,FOLLOW_3); 

            			newLeafNode(otherlv_7, grammarAccess.getObligationAccess().getCommaKeyword_6());
            		
            // InternalSymboleo.g:1327:3: ( (lv_role2_8_0= RULE_ID ) )
            // InternalSymboleo.g:1328:4: (lv_role2_8_0= RULE_ID )
            {
            // InternalSymboleo.g:1328:4: (lv_role2_8_0= RULE_ID )
            // InternalSymboleo.g:1329:5: lv_role2_8_0= RULE_ID
            {
            lv_role2_8_0=(Token)match(input,RULE_ID,FOLLOW_8); 

            					newLeafNode(lv_role2_8_0, grammarAccess.getObligationAccess().getRole2IDTerminalRuleCall_7_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getObligationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"role2",
            						lv_role2_8_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_9=(Token)match(input,16,FOLLOW_28); 

            			newLeafNode(otherlv_9, grammarAccess.getObligationAccess().getCommaKeyword_8());
            		
            // InternalSymboleo.g:1349:3: ( (lv_antecedent_10_0= ruleProposition ) )
            // InternalSymboleo.g:1350:4: (lv_antecedent_10_0= ruleProposition )
            {
            // InternalSymboleo.g:1350:4: (lv_antecedent_10_0= ruleProposition )
            // InternalSymboleo.g:1351:5: lv_antecedent_10_0= ruleProposition
            {

            					newCompositeNode(grammarAccess.getObligationAccess().getAntecedentPropositionParserRuleCall_9_0());
            				
            pushFollow(FOLLOW_8);
            lv_antecedent_10_0=ruleProposition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getObligationRule());
            					}
            					set(
            						current,
            						"antecedent",
            						lv_antecedent_10_0,
            						"org.xtext.example.symboleo.Symboleo.Proposition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_11=(Token)match(input,16,FOLLOW_28); 

            			newLeafNode(otherlv_11, grammarAccess.getObligationAccess().getCommaKeyword_10());
            		
            // InternalSymboleo.g:1372:3: ( (lv_consequent_12_0= ruleProposition ) )
            // InternalSymboleo.g:1373:4: (lv_consequent_12_0= ruleProposition )
            {
            // InternalSymboleo.g:1373:4: (lv_consequent_12_0= ruleProposition )
            // InternalSymboleo.g:1374:5: lv_consequent_12_0= ruleProposition
            {

            					newCompositeNode(grammarAccess.getObligationAccess().getConsequentPropositionParserRuleCall_11_0());
            				
            pushFollow(FOLLOW_9);
            lv_consequent_12_0=ruleProposition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getObligationRule());
            					}
            					set(
            						current,
            						"consequent",
            						lv_consequent_12_0,
            						"org.xtext.example.symboleo.Symboleo.Proposition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_13=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_13, grammarAccess.getObligationAccess().getRightParenthesisKeyword_12());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleObligation"


    // $ANTLR start "entryRulePower"
    // InternalSymboleo.g:1399:1: entryRulePower returns [EObject current=null] : iv_rulePower= rulePower EOF ;
    public final EObject entryRulePower() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePower = null;


        try {
            // InternalSymboleo.g:1399:46: (iv_rulePower= rulePower EOF )
            // InternalSymboleo.g:1400:2: iv_rulePower= rulePower EOF
            {
             newCompositeNode(grammarAccess.getPowerRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePower=rulePower();

            state._fsp--;

             current =iv_rulePower; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePower"


    // $ANTLR start "rulePower"
    // InternalSymboleo.g:1406:1: rulePower returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->' )? otherlv_4= 'power' otherlv_5= '(' ( (lv_role1_6_0= RULE_ID ) ) otherlv_7= ',' ( (lv_role2_8_0= RULE_ID ) ) otherlv_9= ',' ( (lv_antecedent_10_0= ruleProposition ) ) otherlv_11= ',' ( (lv_consequent_12_0= ruleProposition ) ) otherlv_13= ')' ) ;
    public final EObject rulePower() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_role1_6_0=null;
        Token otherlv_7=null;
        Token lv_role2_8_0=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_trigger_2_0 = null;

        EObject lv_antecedent_10_0 = null;

        EObject lv_consequent_12_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:1412:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->' )? otherlv_4= 'power' otherlv_5= '(' ( (lv_role1_6_0= RULE_ID ) ) otherlv_7= ',' ( (lv_role2_8_0= RULE_ID ) ) otherlv_9= ',' ( (lv_antecedent_10_0= ruleProposition ) ) otherlv_11= ',' ( (lv_consequent_12_0= ruleProposition ) ) otherlv_13= ')' ) )
            // InternalSymboleo.g:1413:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->' )? otherlv_4= 'power' otherlv_5= '(' ( (lv_role1_6_0= RULE_ID ) ) otherlv_7= ',' ( (lv_role2_8_0= RULE_ID ) ) otherlv_9= ',' ( (lv_antecedent_10_0= ruleProposition ) ) otherlv_11= ',' ( (lv_consequent_12_0= ruleProposition ) ) otherlv_13= ')' )
            {
            // InternalSymboleo.g:1413:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->' )? otherlv_4= 'power' otherlv_5= '(' ( (lv_role1_6_0= RULE_ID ) ) otherlv_7= ',' ( (lv_role2_8_0= RULE_ID ) ) otherlv_9= ',' ( (lv_antecedent_10_0= ruleProposition ) ) otherlv_11= ',' ( (lv_consequent_12_0= ruleProposition ) ) otherlv_13= ')' )
            // InternalSymboleo.g:1414:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->' )? otherlv_4= 'power' otherlv_5= '(' ( (lv_role1_6_0= RULE_ID ) ) otherlv_7= ',' ( (lv_role2_8_0= RULE_ID ) ) otherlv_9= ',' ( (lv_antecedent_10_0= ruleProposition ) ) otherlv_11= ',' ( (lv_consequent_12_0= ruleProposition ) ) otherlv_13= ')'
            {
            // InternalSymboleo.g:1414:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalSymboleo.g:1415:4: (lv_name_0_0= RULE_ID )
            {
            // InternalSymboleo.g:1415:4: (lv_name_0_0= RULE_ID )
            // InternalSymboleo.g:1416:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_21); 

            					newLeafNode(lv_name_0_0, grammarAccess.getPowerAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPowerRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,28,FOLLOW_29); 

            			newLeafNode(otherlv_1, grammarAccess.getPowerAccess().getColonKeyword_1());
            		
            // InternalSymboleo.g:1436:3: ( ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( ((LA27_0>=RULE_ID && LA27_0<=RULE_INT)||(LA27_0>=44 && LA27_0<=46)||(LA27_0>=48 && LA27_0<=49)||(LA27_0>=67 && LA27_0<=109)) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalSymboleo.g:1437:4: ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->'
                    {
                    // InternalSymboleo.g:1437:4: ( (lv_trigger_2_0= ruleProposition ) )
                    // InternalSymboleo.g:1438:5: (lv_trigger_2_0= ruleProposition )
                    {
                    // InternalSymboleo.g:1438:5: (lv_trigger_2_0= ruleProposition )
                    // InternalSymboleo.g:1439:6: lv_trigger_2_0= ruleProposition
                    {

                    						newCompositeNode(grammarAccess.getPowerAccess().getTriggerPropositionParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_26);
                    lv_trigger_2_0=ruleProposition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPowerRule());
                    						}
                    						set(
                    							current,
                    							"trigger",
                    							lv_trigger_2_0,
                    							"org.xtext.example.symboleo.Symboleo.Proposition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,39,FOLLOW_30); 

                    				newLeafNode(otherlv_3, grammarAccess.getPowerAccess().getHyphenMinusGreaterThanSignKeyword_2_1());
                    			

                    }
                    break;

            }

            otherlv_4=(Token)match(input,41,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getPowerAccess().getPowerKeyword_3());
            		
            otherlv_5=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_5, grammarAccess.getPowerAccess().getLeftParenthesisKeyword_4());
            		
            // InternalSymboleo.g:1469:3: ( (lv_role1_6_0= RULE_ID ) )
            // InternalSymboleo.g:1470:4: (lv_role1_6_0= RULE_ID )
            {
            // InternalSymboleo.g:1470:4: (lv_role1_6_0= RULE_ID )
            // InternalSymboleo.g:1471:5: lv_role1_6_0= RULE_ID
            {
            lv_role1_6_0=(Token)match(input,RULE_ID,FOLLOW_8); 

            					newLeafNode(lv_role1_6_0, grammarAccess.getPowerAccess().getRole1IDTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPowerRule());
            					}
            					setWithLastConsumed(
            						current,
            						"role1",
            						lv_role1_6_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_7=(Token)match(input,16,FOLLOW_3); 

            			newLeafNode(otherlv_7, grammarAccess.getPowerAccess().getCommaKeyword_6());
            		
            // InternalSymboleo.g:1491:3: ( (lv_role2_8_0= RULE_ID ) )
            // InternalSymboleo.g:1492:4: (lv_role2_8_0= RULE_ID )
            {
            // InternalSymboleo.g:1492:4: (lv_role2_8_0= RULE_ID )
            // InternalSymboleo.g:1493:5: lv_role2_8_0= RULE_ID
            {
            lv_role2_8_0=(Token)match(input,RULE_ID,FOLLOW_8); 

            					newLeafNode(lv_role2_8_0, grammarAccess.getPowerAccess().getRole2IDTerminalRuleCall_7_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPowerRule());
            					}
            					setWithLastConsumed(
            						current,
            						"role2",
            						lv_role2_8_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_9=(Token)match(input,16,FOLLOW_28); 

            			newLeafNode(otherlv_9, grammarAccess.getPowerAccess().getCommaKeyword_8());
            		
            // InternalSymboleo.g:1513:3: ( (lv_antecedent_10_0= ruleProposition ) )
            // InternalSymboleo.g:1514:4: (lv_antecedent_10_0= ruleProposition )
            {
            // InternalSymboleo.g:1514:4: (lv_antecedent_10_0= ruleProposition )
            // InternalSymboleo.g:1515:5: lv_antecedent_10_0= ruleProposition
            {

            					newCompositeNode(grammarAccess.getPowerAccess().getAntecedentPropositionParserRuleCall_9_0());
            				
            pushFollow(FOLLOW_8);
            lv_antecedent_10_0=ruleProposition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPowerRule());
            					}
            					set(
            						current,
            						"antecedent",
            						lv_antecedent_10_0,
            						"org.xtext.example.symboleo.Symboleo.Proposition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_11=(Token)match(input,16,FOLLOW_28); 

            			newLeafNode(otherlv_11, grammarAccess.getPowerAccess().getCommaKeyword_10());
            		
            // InternalSymboleo.g:1536:3: ( (lv_consequent_12_0= ruleProposition ) )
            // InternalSymboleo.g:1537:4: (lv_consequent_12_0= ruleProposition )
            {
            // InternalSymboleo.g:1537:4: (lv_consequent_12_0= ruleProposition )
            // InternalSymboleo.g:1538:5: lv_consequent_12_0= ruleProposition
            {

            					newCompositeNode(grammarAccess.getPowerAccess().getConsequentPropositionParserRuleCall_11_0());
            				
            pushFollow(FOLLOW_9);
            lv_consequent_12_0=ruleProposition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPowerRule());
            					}
            					set(
            						current,
            						"consequent",
            						lv_consequent_12_0,
            						"org.xtext.example.symboleo.Symboleo.Proposition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_13=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_13, grammarAccess.getPowerAccess().getRightParenthesisKeyword_12());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePower"


    // $ANTLR start "entryRuleProposition"
    // InternalSymboleo.g:1563:1: entryRuleProposition returns [EObject current=null] : iv_ruleProposition= ruleProposition EOF ;
    public final EObject entryRuleProposition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProposition = null;


        try {
            // InternalSymboleo.g:1563:52: (iv_ruleProposition= ruleProposition EOF )
            // InternalSymboleo.g:1564:2: iv_ruleProposition= ruleProposition EOF
            {
             newCompositeNode(grammarAccess.getPropositionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProposition=ruleProposition();

            state._fsp--;

             current =iv_ruleProposition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProposition"


    // $ANTLR start "ruleProposition"
    // InternalSymboleo.g:1570:1: ruleProposition returns [EObject current=null] : ( ( (lv_junctions_0_0= ruleJunction ) ) (otherlv_1= 'OR' ( (lv_junctions_2_0= ruleJunction ) ) )* ) ;
    public final EObject ruleProposition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_junctions_0_0 = null;

        EObject lv_junctions_2_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:1576:2: ( ( ( (lv_junctions_0_0= ruleJunction ) ) (otherlv_1= 'OR' ( (lv_junctions_2_0= ruleJunction ) ) )* ) )
            // InternalSymboleo.g:1577:2: ( ( (lv_junctions_0_0= ruleJunction ) ) (otherlv_1= 'OR' ( (lv_junctions_2_0= ruleJunction ) ) )* )
            {
            // InternalSymboleo.g:1577:2: ( ( (lv_junctions_0_0= ruleJunction ) ) (otherlv_1= 'OR' ( (lv_junctions_2_0= ruleJunction ) ) )* )
            // InternalSymboleo.g:1578:3: ( (lv_junctions_0_0= ruleJunction ) ) (otherlv_1= 'OR' ( (lv_junctions_2_0= ruleJunction ) ) )*
            {
            // InternalSymboleo.g:1578:3: ( (lv_junctions_0_0= ruleJunction ) )
            // InternalSymboleo.g:1579:4: (lv_junctions_0_0= ruleJunction )
            {
            // InternalSymboleo.g:1579:4: (lv_junctions_0_0= ruleJunction )
            // InternalSymboleo.g:1580:5: lv_junctions_0_0= ruleJunction
            {

            					newCompositeNode(grammarAccess.getPropositionAccess().getJunctionsJunctionParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_31);
            lv_junctions_0_0=ruleJunction();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPropositionRule());
            					}
            					add(
            						current,
            						"junctions",
            						lv_junctions_0_0,
            						"org.xtext.example.symboleo.Symboleo.Junction");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSymboleo.g:1597:3: (otherlv_1= 'OR' ( (lv_junctions_2_0= ruleJunction ) ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==42) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalSymboleo.g:1598:4: otherlv_1= 'OR' ( (lv_junctions_2_0= ruleJunction ) )
            	    {
            	    otherlv_1=(Token)match(input,42,FOLLOW_28); 

            	    				newLeafNode(otherlv_1, grammarAccess.getPropositionAccess().getORKeyword_1_0());
            	    			
            	    // InternalSymboleo.g:1602:4: ( (lv_junctions_2_0= ruleJunction ) )
            	    // InternalSymboleo.g:1603:5: (lv_junctions_2_0= ruleJunction )
            	    {
            	    // InternalSymboleo.g:1603:5: (lv_junctions_2_0= ruleJunction )
            	    // InternalSymboleo.g:1604:6: lv_junctions_2_0= ruleJunction
            	    {

            	    						newCompositeNode(grammarAccess.getPropositionAccess().getJunctionsJunctionParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_31);
            	    lv_junctions_2_0=ruleJunction();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getPropositionRule());
            	    						}
            	    						add(
            	    							current,
            	    							"junctions",
            	    							lv_junctions_2_0,
            	    							"org.xtext.example.symboleo.Symboleo.Junction");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProposition"


    // $ANTLR start "entryRuleJunction"
    // InternalSymboleo.g:1626:1: entryRuleJunction returns [EObject current=null] : iv_ruleJunction= ruleJunction EOF ;
    public final EObject entryRuleJunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJunction = null;


        try {
            // InternalSymboleo.g:1626:49: (iv_ruleJunction= ruleJunction EOF )
            // InternalSymboleo.g:1627:2: iv_ruleJunction= ruleJunction EOF
            {
             newCompositeNode(grammarAccess.getJunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJunction=ruleJunction();

            state._fsp--;

             current =iv_ruleJunction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJunction"


    // $ANTLR start "ruleJunction"
    // InternalSymboleo.g:1633:1: ruleJunction returns [EObject current=null] : ( ( (lv_negativeAtoms_0_0= ruleNegation ) ) (otherlv_1= 'AND' ( (lv_negativeAtoms_2_0= ruleNegation ) ) )* ) ;
    public final EObject ruleJunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_negativeAtoms_0_0 = null;

        EObject lv_negativeAtoms_2_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:1639:2: ( ( ( (lv_negativeAtoms_0_0= ruleNegation ) ) (otherlv_1= 'AND' ( (lv_negativeAtoms_2_0= ruleNegation ) ) )* ) )
            // InternalSymboleo.g:1640:2: ( ( (lv_negativeAtoms_0_0= ruleNegation ) ) (otherlv_1= 'AND' ( (lv_negativeAtoms_2_0= ruleNegation ) ) )* )
            {
            // InternalSymboleo.g:1640:2: ( ( (lv_negativeAtoms_0_0= ruleNegation ) ) (otherlv_1= 'AND' ( (lv_negativeAtoms_2_0= ruleNegation ) ) )* )
            // InternalSymboleo.g:1641:3: ( (lv_negativeAtoms_0_0= ruleNegation ) ) (otherlv_1= 'AND' ( (lv_negativeAtoms_2_0= ruleNegation ) ) )*
            {
            // InternalSymboleo.g:1641:3: ( (lv_negativeAtoms_0_0= ruleNegation ) )
            // InternalSymboleo.g:1642:4: (lv_negativeAtoms_0_0= ruleNegation )
            {
            // InternalSymboleo.g:1642:4: (lv_negativeAtoms_0_0= ruleNegation )
            // InternalSymboleo.g:1643:5: lv_negativeAtoms_0_0= ruleNegation
            {

            					newCompositeNode(grammarAccess.getJunctionAccess().getNegativeAtomsNegationParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_32);
            lv_negativeAtoms_0_0=ruleNegation();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getJunctionRule());
            					}
            					add(
            						current,
            						"negativeAtoms",
            						lv_negativeAtoms_0_0,
            						"org.xtext.example.symboleo.Symboleo.Negation");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSymboleo.g:1660:3: (otherlv_1= 'AND' ( (lv_negativeAtoms_2_0= ruleNegation ) ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==43) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalSymboleo.g:1661:4: otherlv_1= 'AND' ( (lv_negativeAtoms_2_0= ruleNegation ) )
            	    {
            	    otherlv_1=(Token)match(input,43,FOLLOW_28); 

            	    				newLeafNode(otherlv_1, grammarAccess.getJunctionAccess().getANDKeyword_1_0());
            	    			
            	    // InternalSymboleo.g:1665:4: ( (lv_negativeAtoms_2_0= ruleNegation ) )
            	    // InternalSymboleo.g:1666:5: (lv_negativeAtoms_2_0= ruleNegation )
            	    {
            	    // InternalSymboleo.g:1666:5: (lv_negativeAtoms_2_0= ruleNegation )
            	    // InternalSymboleo.g:1667:6: lv_negativeAtoms_2_0= ruleNegation
            	    {

            	    						newCompositeNode(grammarAccess.getJunctionAccess().getNegativeAtomsNegationParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_32);
            	    lv_negativeAtoms_2_0=ruleNegation();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getJunctionRule());
            	    						}
            	    						add(
            	    							current,
            	    							"negativeAtoms",
            	    							lv_negativeAtoms_2_0,
            	    							"org.xtext.example.symboleo.Symboleo.Negation");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJunction"


    // $ANTLR start "entryRuleNegation"
    // InternalSymboleo.g:1689:1: entryRuleNegation returns [EObject current=null] : iv_ruleNegation= ruleNegation EOF ;
    public final EObject entryRuleNegation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNegation = null;


        try {
            // InternalSymboleo.g:1689:49: (iv_ruleNegation= ruleNegation EOF )
            // InternalSymboleo.g:1690:2: iv_ruleNegation= ruleNegation EOF
            {
             newCompositeNode(grammarAccess.getNegationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNegation=ruleNegation();

            state._fsp--;

             current =iv_ruleNegation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNegation"


    // $ANTLR start "ruleNegation"
    // InternalSymboleo.g:1696:1: ruleNegation returns [EObject current=null] : ( ( (lv_negated_0_0= 'NOT' ) )? ( (lv_atomicExpression_1_0= ruleAtom ) ) ) ;
    public final EObject ruleNegation() throws RecognitionException {
        EObject current = null;

        Token lv_negated_0_0=null;
        EObject lv_atomicExpression_1_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:1702:2: ( ( ( (lv_negated_0_0= 'NOT' ) )? ( (lv_atomicExpression_1_0= ruleAtom ) ) ) )
            // InternalSymboleo.g:1703:2: ( ( (lv_negated_0_0= 'NOT' ) )? ( (lv_atomicExpression_1_0= ruleAtom ) ) )
            {
            // InternalSymboleo.g:1703:2: ( ( (lv_negated_0_0= 'NOT' ) )? ( (lv_atomicExpression_1_0= ruleAtom ) ) )
            // InternalSymboleo.g:1704:3: ( (lv_negated_0_0= 'NOT' ) )? ( (lv_atomicExpression_1_0= ruleAtom ) )
            {
            // InternalSymboleo.g:1704:3: ( (lv_negated_0_0= 'NOT' ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==44) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalSymboleo.g:1705:4: (lv_negated_0_0= 'NOT' )
                    {
                    // InternalSymboleo.g:1705:4: (lv_negated_0_0= 'NOT' )
                    // InternalSymboleo.g:1706:5: lv_negated_0_0= 'NOT'
                    {
                    lv_negated_0_0=(Token)match(input,44,FOLLOW_28); 

                    					newLeafNode(lv_negated_0_0, grammarAccess.getNegationAccess().getNegatedNOTKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getNegationRule());
                    					}
                    					setWithLastConsumed(current, "negated", lv_negated_0_0 != null, "NOT");
                    				

                    }


                    }
                    break;

            }

            // InternalSymboleo.g:1718:3: ( (lv_atomicExpression_1_0= ruleAtom ) )
            // InternalSymboleo.g:1719:4: (lv_atomicExpression_1_0= ruleAtom )
            {
            // InternalSymboleo.g:1719:4: (lv_atomicExpression_1_0= ruleAtom )
            // InternalSymboleo.g:1720:5: lv_atomicExpression_1_0= ruleAtom
            {

            					newCompositeNode(grammarAccess.getNegationAccess().getAtomicExpressionAtomParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_atomicExpression_1_0=ruleAtom();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNegationRule());
            					}
            					set(
            						current,
            						"atomicExpression",
            						lv_atomicExpression_1_0,
            						"org.xtext.example.symboleo.Symboleo.Atom");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNegation"


    // $ANTLR start "entryRuleAtom"
    // InternalSymboleo.g:1741:1: entryRuleAtom returns [EObject current=null] : iv_ruleAtom= ruleAtom EOF ;
    public final EObject entryRuleAtom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtom = null;


        try {
            // InternalSymboleo.g:1741:45: (iv_ruleAtom= ruleAtom EOF )
            // InternalSymboleo.g:1742:2: iv_ruleAtom= ruleAtom EOF
            {
             newCompositeNode(grammarAccess.getAtomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAtom=ruleAtom();

            state._fsp--;

             current =iv_ruleAtom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAtom"


    // $ANTLR start "ruleAtom"
    // InternalSymboleo.g:1748:1: ruleAtom returns [EObject current=null] : ( (otherlv_0= 'happens' otherlv_1= '(' ( (lv_eventProposition_2_0= ruleEventProp ) ) otherlv_3= ')' ) | (otherlv_4= 'occurs' otherlv_5= '(' ( (lv_situationProposition_6_0= ruleSitProp ) ) otherlv_7= ')' ) | ( ( (lv_point_8_0= rulePoint ) ) otherlv_9= 'within' ( (lv_interval_10_0= ruleInterval ) ) ) | ( (lv_bool_11_0= 'TRUE' ) ) | ( (lv_bool_12_0= 'FALSE' ) ) ) ;
    public final EObject ruleAtom() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token lv_bool_11_0=null;
        Token lv_bool_12_0=null;
        EObject lv_eventProposition_2_0 = null;

        EObject lv_situationProposition_6_0 = null;

        EObject lv_point_8_0 = null;

        EObject lv_interval_10_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:1754:2: ( ( (otherlv_0= 'happens' otherlv_1= '(' ( (lv_eventProposition_2_0= ruleEventProp ) ) otherlv_3= ')' ) | (otherlv_4= 'occurs' otherlv_5= '(' ( (lv_situationProposition_6_0= ruleSitProp ) ) otherlv_7= ')' ) | ( ( (lv_point_8_0= rulePoint ) ) otherlv_9= 'within' ( (lv_interval_10_0= ruleInterval ) ) ) | ( (lv_bool_11_0= 'TRUE' ) ) | ( (lv_bool_12_0= 'FALSE' ) ) ) )
            // InternalSymboleo.g:1755:2: ( (otherlv_0= 'happens' otherlv_1= '(' ( (lv_eventProposition_2_0= ruleEventProp ) ) otherlv_3= ')' ) | (otherlv_4= 'occurs' otherlv_5= '(' ( (lv_situationProposition_6_0= ruleSitProp ) ) otherlv_7= ')' ) | ( ( (lv_point_8_0= rulePoint ) ) otherlv_9= 'within' ( (lv_interval_10_0= ruleInterval ) ) ) | ( (lv_bool_11_0= 'TRUE' ) ) | ( (lv_bool_12_0= 'FALSE' ) ) )
            {
            // InternalSymboleo.g:1755:2: ( (otherlv_0= 'happens' otherlv_1= '(' ( (lv_eventProposition_2_0= ruleEventProp ) ) otherlv_3= ')' ) | (otherlv_4= 'occurs' otherlv_5= '(' ( (lv_situationProposition_6_0= ruleSitProp ) ) otherlv_7= ')' ) | ( ( (lv_point_8_0= rulePoint ) ) otherlv_9= 'within' ( (lv_interval_10_0= ruleInterval ) ) ) | ( (lv_bool_11_0= 'TRUE' ) ) | ( (lv_bool_12_0= 'FALSE' ) ) )
            int alt31=5;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt31=1;
                }
                break;
            case 46:
                {
                alt31=2;
                }
                break;
            case RULE_ID:
            case RULE_INT:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
                {
                alt31=3;
                }
                break;
            case 48:
                {
                alt31=4;
                }
                break;
            case 49:
                {
                alt31=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // InternalSymboleo.g:1756:3: (otherlv_0= 'happens' otherlv_1= '(' ( (lv_eventProposition_2_0= ruleEventProp ) ) otherlv_3= ')' )
                    {
                    // InternalSymboleo.g:1756:3: (otherlv_0= 'happens' otherlv_1= '(' ( (lv_eventProposition_2_0= ruleEventProp ) ) otherlv_3= ')' )
                    // InternalSymboleo.g:1757:4: otherlv_0= 'happens' otherlv_1= '(' ( (lv_eventProposition_2_0= ruleEventProp ) ) otherlv_3= ')'
                    {
                    otherlv_0=(Token)match(input,45,FOLLOW_7); 

                    				newLeafNode(otherlv_0, grammarAccess.getAtomAccess().getHappensKeyword_0_0());
                    			
                    otherlv_1=(Token)match(input,15,FOLLOW_33); 

                    				newLeafNode(otherlv_1, grammarAccess.getAtomAccess().getLeftParenthesisKeyword_0_1());
                    			
                    // InternalSymboleo.g:1765:4: ( (lv_eventProposition_2_0= ruleEventProp ) )
                    // InternalSymboleo.g:1766:5: (lv_eventProposition_2_0= ruleEventProp )
                    {
                    // InternalSymboleo.g:1766:5: (lv_eventProposition_2_0= ruleEventProp )
                    // InternalSymboleo.g:1767:6: lv_eventProposition_2_0= ruleEventProp
                    {

                    						newCompositeNode(grammarAccess.getAtomAccess().getEventPropositionEventPropParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_9);
                    lv_eventProposition_2_0=ruleEventProp();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAtomRule());
                    						}
                    						set(
                    							current,
                    							"eventProposition",
                    							lv_eventProposition_2_0,
                    							"org.xtext.example.symboleo.Symboleo.EventProp");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,17,FOLLOW_2); 

                    				newLeafNode(otherlv_3, grammarAccess.getAtomAccess().getRightParenthesisKeyword_0_3());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:1790:3: (otherlv_4= 'occurs' otherlv_5= '(' ( (lv_situationProposition_6_0= ruleSitProp ) ) otherlv_7= ')' )
                    {
                    // InternalSymboleo.g:1790:3: (otherlv_4= 'occurs' otherlv_5= '(' ( (lv_situationProposition_6_0= ruleSitProp ) ) otherlv_7= ')' )
                    // InternalSymboleo.g:1791:4: otherlv_4= 'occurs' otherlv_5= '(' ( (lv_situationProposition_6_0= ruleSitProp ) ) otherlv_7= ')'
                    {
                    otherlv_4=(Token)match(input,46,FOLLOW_7); 

                    				newLeafNode(otherlv_4, grammarAccess.getAtomAccess().getOccursKeyword_1_0());
                    			
                    otherlv_5=(Token)match(input,15,FOLLOW_34); 

                    				newLeafNode(otherlv_5, grammarAccess.getAtomAccess().getLeftParenthesisKeyword_1_1());
                    			
                    // InternalSymboleo.g:1799:4: ( (lv_situationProposition_6_0= ruleSitProp ) )
                    // InternalSymboleo.g:1800:5: (lv_situationProposition_6_0= ruleSitProp )
                    {
                    // InternalSymboleo.g:1800:5: (lv_situationProposition_6_0= ruleSitProp )
                    // InternalSymboleo.g:1801:6: lv_situationProposition_6_0= ruleSitProp
                    {

                    						newCompositeNode(grammarAccess.getAtomAccess().getSituationPropositionSitPropParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_9);
                    lv_situationProposition_6_0=ruleSitProp();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAtomRule());
                    						}
                    						set(
                    							current,
                    							"situationProposition",
                    							lv_situationProposition_6_0,
                    							"org.xtext.example.symboleo.Symboleo.SitProp");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_7=(Token)match(input,17,FOLLOW_2); 

                    				newLeafNode(otherlv_7, grammarAccess.getAtomAccess().getRightParenthesisKeyword_1_3());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:1824:3: ( ( (lv_point_8_0= rulePoint ) ) otherlv_9= 'within' ( (lv_interval_10_0= ruleInterval ) ) )
                    {
                    // InternalSymboleo.g:1824:3: ( ( (lv_point_8_0= rulePoint ) ) otherlv_9= 'within' ( (lv_interval_10_0= ruleInterval ) ) )
                    // InternalSymboleo.g:1825:4: ( (lv_point_8_0= rulePoint ) ) otherlv_9= 'within' ( (lv_interval_10_0= ruleInterval ) )
                    {
                    // InternalSymboleo.g:1825:4: ( (lv_point_8_0= rulePoint ) )
                    // InternalSymboleo.g:1826:5: (lv_point_8_0= rulePoint )
                    {
                    // InternalSymboleo.g:1826:5: (lv_point_8_0= rulePoint )
                    // InternalSymboleo.g:1827:6: lv_point_8_0= rulePoint
                    {

                    						newCompositeNode(grammarAccess.getAtomAccess().getPointPointParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_35);
                    lv_point_8_0=rulePoint();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAtomRule());
                    						}
                    						set(
                    							current,
                    							"point",
                    							lv_point_8_0,
                    							"org.xtext.example.symboleo.Symboleo.Point");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_9=(Token)match(input,47,FOLLOW_36); 

                    				newLeafNode(otherlv_9, grammarAccess.getAtomAccess().getWithinKeyword_2_1());
                    			
                    // InternalSymboleo.g:1848:4: ( (lv_interval_10_0= ruleInterval ) )
                    // InternalSymboleo.g:1849:5: (lv_interval_10_0= ruleInterval )
                    {
                    // InternalSymboleo.g:1849:5: (lv_interval_10_0= ruleInterval )
                    // InternalSymboleo.g:1850:6: lv_interval_10_0= ruleInterval
                    {

                    						newCompositeNode(grammarAccess.getAtomAccess().getIntervalIntervalParserRuleCall_2_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_interval_10_0=ruleInterval();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAtomRule());
                    						}
                    						set(
                    							current,
                    							"interval",
                    							lv_interval_10_0,
                    							"org.xtext.example.symboleo.Symboleo.Interval");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalSymboleo.g:1869:3: ( (lv_bool_11_0= 'TRUE' ) )
                    {
                    // InternalSymboleo.g:1869:3: ( (lv_bool_11_0= 'TRUE' ) )
                    // InternalSymboleo.g:1870:4: (lv_bool_11_0= 'TRUE' )
                    {
                    // InternalSymboleo.g:1870:4: (lv_bool_11_0= 'TRUE' )
                    // InternalSymboleo.g:1871:5: lv_bool_11_0= 'TRUE'
                    {
                    lv_bool_11_0=(Token)match(input,48,FOLLOW_2); 

                    					newLeafNode(lv_bool_11_0, grammarAccess.getAtomAccess().getBoolTRUEKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAtomRule());
                    					}
                    					setWithLastConsumed(current, "bool", lv_bool_11_0, "TRUE");
                    				

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalSymboleo.g:1884:3: ( (lv_bool_12_0= 'FALSE' ) )
                    {
                    // InternalSymboleo.g:1884:3: ( (lv_bool_12_0= 'FALSE' ) )
                    // InternalSymboleo.g:1885:4: (lv_bool_12_0= 'FALSE' )
                    {
                    // InternalSymboleo.g:1885:4: (lv_bool_12_0= 'FALSE' )
                    // InternalSymboleo.g:1886:5: lv_bool_12_0= 'FALSE'
                    {
                    lv_bool_12_0=(Token)match(input,49,FOLLOW_2); 

                    					newLeafNode(lv_bool_12_0, grammarAccess.getAtomAccess().getBoolFALSEKeyword_4_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAtomRule());
                    					}
                    					setWithLastConsumed(current, "bool", lv_bool_12_0, "FALSE");
                    				

                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAtom"


    // $ANTLR start "entryRuleSitProp"
    // InternalSymboleo.g:1902:1: entryRuleSitProp returns [EObject current=null] : iv_ruleSitProp= ruleSitProp EOF ;
    public final EObject entryRuleSitProp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSitProp = null;


        try {
            // InternalSymboleo.g:1902:48: (iv_ruleSitProp= ruleSitProp EOF )
            // InternalSymboleo.g:1903:2: iv_ruleSitProp= ruleSitProp EOF
            {
             newCompositeNode(grammarAccess.getSitPropRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSitProp=ruleSitProp();

            state._fsp--;

             current =iv_ruleSitProp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSitProp"


    // $ANTLR start "ruleSitProp"
    // InternalSymboleo.g:1909:1: ruleSitProp returns [EObject current=null] : ( ( ( (lv_situationName_0_0= RULE_ID ) ) | ( (lv_oSituationName_1_0= ruleoState ) ) | ( (lv_cSituationName_2_0= rulecState ) ) | ( (lv_pSituationName_3_0= rulepState ) ) ) otherlv_4= ',' ( (lv_interval_5_0= ruleInterval ) ) ) ;
    public final EObject ruleSitProp() throws RecognitionException {
        EObject current = null;

        Token lv_situationName_0_0=null;
        Token otherlv_4=null;
        EObject lv_oSituationName_1_0 = null;

        EObject lv_cSituationName_2_0 = null;

        EObject lv_pSituationName_3_0 = null;

        EObject lv_interval_5_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:1915:2: ( ( ( ( (lv_situationName_0_0= RULE_ID ) ) | ( (lv_oSituationName_1_0= ruleoState ) ) | ( (lv_cSituationName_2_0= rulecState ) ) | ( (lv_pSituationName_3_0= rulepState ) ) ) otherlv_4= ',' ( (lv_interval_5_0= ruleInterval ) ) ) )
            // InternalSymboleo.g:1916:2: ( ( ( (lv_situationName_0_0= RULE_ID ) ) | ( (lv_oSituationName_1_0= ruleoState ) ) | ( (lv_cSituationName_2_0= rulecState ) ) | ( (lv_pSituationName_3_0= rulepState ) ) ) otherlv_4= ',' ( (lv_interval_5_0= ruleInterval ) ) )
            {
            // InternalSymboleo.g:1916:2: ( ( ( (lv_situationName_0_0= RULE_ID ) ) | ( (lv_oSituationName_1_0= ruleoState ) ) | ( (lv_cSituationName_2_0= rulecState ) ) | ( (lv_pSituationName_3_0= rulepState ) ) ) otherlv_4= ',' ( (lv_interval_5_0= ruleInterval ) ) )
            // InternalSymboleo.g:1917:3: ( ( (lv_situationName_0_0= RULE_ID ) ) | ( (lv_oSituationName_1_0= ruleoState ) ) | ( (lv_cSituationName_2_0= rulecState ) ) | ( (lv_pSituationName_3_0= rulepState ) ) ) otherlv_4= ',' ( (lv_interval_5_0= ruleInterval ) )
            {
            // InternalSymboleo.g:1917:3: ( ( (lv_situationName_0_0= RULE_ID ) ) | ( (lv_oSituationName_1_0= ruleoState ) ) | ( (lv_cSituationName_2_0= rulecState ) ) | ( (lv_pSituationName_3_0= rulepState ) ) )
            int alt32=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt32=1;
                }
                break;
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
                {
                alt32=2;
                }
                break;
            case 99:
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
                {
                alt32=3;
                }
                break;
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
                {
                alt32=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // InternalSymboleo.g:1918:4: ( (lv_situationName_0_0= RULE_ID ) )
                    {
                    // InternalSymboleo.g:1918:4: ( (lv_situationName_0_0= RULE_ID ) )
                    // InternalSymboleo.g:1919:5: (lv_situationName_0_0= RULE_ID )
                    {
                    // InternalSymboleo.g:1919:5: (lv_situationName_0_0= RULE_ID )
                    // InternalSymboleo.g:1920:6: lv_situationName_0_0= RULE_ID
                    {
                    lv_situationName_0_0=(Token)match(input,RULE_ID,FOLLOW_8); 

                    						newLeafNode(lv_situationName_0_0, grammarAccess.getSitPropAccess().getSituationNameIDTerminalRuleCall_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getSitPropRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"situationName",
                    							lv_situationName_0_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:1937:4: ( (lv_oSituationName_1_0= ruleoState ) )
                    {
                    // InternalSymboleo.g:1937:4: ( (lv_oSituationName_1_0= ruleoState ) )
                    // InternalSymboleo.g:1938:5: (lv_oSituationName_1_0= ruleoState )
                    {
                    // InternalSymboleo.g:1938:5: (lv_oSituationName_1_0= ruleoState )
                    // InternalSymboleo.g:1939:6: lv_oSituationName_1_0= ruleoState
                    {

                    						newCompositeNode(grammarAccess.getSitPropAccess().getOSituationNameOStateParserRuleCall_0_1_0());
                    					
                    pushFollow(FOLLOW_8);
                    lv_oSituationName_1_0=ruleoState();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSitPropRule());
                    						}
                    						set(
                    							current,
                    							"oSituationName",
                    							lv_oSituationName_1_0,
                    							"org.xtext.example.symboleo.Symboleo.oState");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:1957:4: ( (lv_cSituationName_2_0= rulecState ) )
                    {
                    // InternalSymboleo.g:1957:4: ( (lv_cSituationName_2_0= rulecState ) )
                    // InternalSymboleo.g:1958:5: (lv_cSituationName_2_0= rulecState )
                    {
                    // InternalSymboleo.g:1958:5: (lv_cSituationName_2_0= rulecState )
                    // InternalSymboleo.g:1959:6: lv_cSituationName_2_0= rulecState
                    {

                    						newCompositeNode(grammarAccess.getSitPropAccess().getCSituationNameCStateParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_8);
                    lv_cSituationName_2_0=rulecState();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSitPropRule());
                    						}
                    						set(
                    							current,
                    							"cSituationName",
                    							lv_cSituationName_2_0,
                    							"org.xtext.example.symboleo.Symboleo.cState");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalSymboleo.g:1977:4: ( (lv_pSituationName_3_0= rulepState ) )
                    {
                    // InternalSymboleo.g:1977:4: ( (lv_pSituationName_3_0= rulepState ) )
                    // InternalSymboleo.g:1978:5: (lv_pSituationName_3_0= rulepState )
                    {
                    // InternalSymboleo.g:1978:5: (lv_pSituationName_3_0= rulepState )
                    // InternalSymboleo.g:1979:6: lv_pSituationName_3_0= rulepState
                    {

                    						newCompositeNode(grammarAccess.getSitPropAccess().getPSituationNamePStateParserRuleCall_0_3_0());
                    					
                    pushFollow(FOLLOW_8);
                    lv_pSituationName_3_0=rulepState();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSitPropRule());
                    						}
                    						set(
                    							current,
                    							"pSituationName",
                    							lv_pSituationName_3_0,
                    							"org.xtext.example.symboleo.Symboleo.pState");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,16,FOLLOW_36); 

            			newLeafNode(otherlv_4, grammarAccess.getSitPropAccess().getCommaKeyword_1());
            		
            // InternalSymboleo.g:2001:3: ( (lv_interval_5_0= ruleInterval ) )
            // InternalSymboleo.g:2002:4: (lv_interval_5_0= ruleInterval )
            {
            // InternalSymboleo.g:2002:4: (lv_interval_5_0= ruleInterval )
            // InternalSymboleo.g:2003:5: lv_interval_5_0= ruleInterval
            {

            					newCompositeNode(grammarAccess.getSitPropAccess().getIntervalIntervalParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_interval_5_0=ruleInterval();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSitPropRule());
            					}
            					set(
            						current,
            						"interval",
            						lv_interval_5_0,
            						"org.xtext.example.symboleo.Symboleo.Interval");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSitProp"


    // $ANTLR start "entryRuleEventProp"
    // InternalSymboleo.g:2024:1: entryRuleEventProp returns [EObject current=null] : iv_ruleEventProp= ruleEventProp EOF ;
    public final EObject entryRuleEventProp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEventProp = null;


        try {
            // InternalSymboleo.g:2024:50: (iv_ruleEventProp= ruleEventProp EOF )
            // InternalSymboleo.g:2025:2: iv_ruleEventProp= ruleEventProp EOF
            {
             newCompositeNode(grammarAccess.getEventPropRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEventProp=ruleEventProp();

            state._fsp--;

             current =iv_ruleEventProp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEventProp"


    // $ANTLR start "ruleEventProp"
    // InternalSymboleo.g:2031:1: ruleEventProp returns [EObject current=null] : ( ( ( (lv_eventName_0_0= RULE_ID ) ) | ( (lv_oEventName_1_0= ruleoEvent ) ) | ( (lv_cEventName_2_0= rulecEvent ) ) | ( (lv_pEventName_3_0= rulepEvent ) ) ) otherlv_4= ',' ( (lv_point_5_0= rulePoint ) ) ) ;
    public final EObject ruleEventProp() throws RecognitionException {
        EObject current = null;

        Token lv_eventName_0_0=null;
        Token otherlv_4=null;
        EObject lv_oEventName_1_0 = null;

        EObject lv_cEventName_2_0 = null;

        EObject lv_pEventName_3_0 = null;

        EObject lv_point_5_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:2037:2: ( ( ( ( (lv_eventName_0_0= RULE_ID ) ) | ( (lv_oEventName_1_0= ruleoEvent ) ) | ( (lv_cEventName_2_0= rulecEvent ) ) | ( (lv_pEventName_3_0= rulepEvent ) ) ) otherlv_4= ',' ( (lv_point_5_0= rulePoint ) ) ) )
            // InternalSymboleo.g:2038:2: ( ( ( (lv_eventName_0_0= RULE_ID ) ) | ( (lv_oEventName_1_0= ruleoEvent ) ) | ( (lv_cEventName_2_0= rulecEvent ) ) | ( (lv_pEventName_3_0= rulepEvent ) ) ) otherlv_4= ',' ( (lv_point_5_0= rulePoint ) ) )
            {
            // InternalSymboleo.g:2038:2: ( ( ( (lv_eventName_0_0= RULE_ID ) ) | ( (lv_oEventName_1_0= ruleoEvent ) ) | ( (lv_cEventName_2_0= rulecEvent ) ) | ( (lv_pEventName_3_0= rulepEvent ) ) ) otherlv_4= ',' ( (lv_point_5_0= rulePoint ) ) )
            // InternalSymboleo.g:2039:3: ( ( (lv_eventName_0_0= RULE_ID ) ) | ( (lv_oEventName_1_0= ruleoEvent ) ) | ( (lv_cEventName_2_0= rulecEvent ) ) | ( (lv_pEventName_3_0= rulepEvent ) ) ) otherlv_4= ',' ( (lv_point_5_0= rulePoint ) )
            {
            // InternalSymboleo.g:2039:3: ( ( (lv_eventName_0_0= RULE_ID ) ) | ( (lv_oEventName_1_0= ruleoEvent ) ) | ( (lv_cEventName_2_0= rulecEvent ) ) | ( (lv_pEventName_3_0= rulepEvent ) ) )
            int alt33=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt33=1;
                }
                break;
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
                {
                alt33=2;
                }
                break;
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
                {
                alt33=3;
                }
                break;
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
                {
                alt33=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }

            switch (alt33) {
                case 1 :
                    // InternalSymboleo.g:2040:4: ( (lv_eventName_0_0= RULE_ID ) )
                    {
                    // InternalSymboleo.g:2040:4: ( (lv_eventName_0_0= RULE_ID ) )
                    // InternalSymboleo.g:2041:5: (lv_eventName_0_0= RULE_ID )
                    {
                    // InternalSymboleo.g:2041:5: (lv_eventName_0_0= RULE_ID )
                    // InternalSymboleo.g:2042:6: lv_eventName_0_0= RULE_ID
                    {
                    lv_eventName_0_0=(Token)match(input,RULE_ID,FOLLOW_8); 

                    						newLeafNode(lv_eventName_0_0, grammarAccess.getEventPropAccess().getEventNameIDTerminalRuleCall_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getEventPropRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"eventName",
                    							lv_eventName_0_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:2059:4: ( (lv_oEventName_1_0= ruleoEvent ) )
                    {
                    // InternalSymboleo.g:2059:4: ( (lv_oEventName_1_0= ruleoEvent ) )
                    // InternalSymboleo.g:2060:5: (lv_oEventName_1_0= ruleoEvent )
                    {
                    // InternalSymboleo.g:2060:5: (lv_oEventName_1_0= ruleoEvent )
                    // InternalSymboleo.g:2061:6: lv_oEventName_1_0= ruleoEvent
                    {

                    						newCompositeNode(grammarAccess.getEventPropAccess().getOEventNameOEventParserRuleCall_0_1_0());
                    					
                    pushFollow(FOLLOW_8);
                    lv_oEventName_1_0=ruleoEvent();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getEventPropRule());
                    						}
                    						set(
                    							current,
                    							"oEventName",
                    							lv_oEventName_1_0,
                    							"org.xtext.example.symboleo.Symboleo.oEvent");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:2079:4: ( (lv_cEventName_2_0= rulecEvent ) )
                    {
                    // InternalSymboleo.g:2079:4: ( (lv_cEventName_2_0= rulecEvent ) )
                    // InternalSymboleo.g:2080:5: (lv_cEventName_2_0= rulecEvent )
                    {
                    // InternalSymboleo.g:2080:5: (lv_cEventName_2_0= rulecEvent )
                    // InternalSymboleo.g:2081:6: lv_cEventName_2_0= rulecEvent
                    {

                    						newCompositeNode(grammarAccess.getEventPropAccess().getCEventNameCEventParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_8);
                    lv_cEventName_2_0=rulecEvent();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getEventPropRule());
                    						}
                    						set(
                    							current,
                    							"cEventName",
                    							lv_cEventName_2_0,
                    							"org.xtext.example.symboleo.Symboleo.cEvent");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalSymboleo.g:2099:4: ( (lv_pEventName_3_0= rulepEvent ) )
                    {
                    // InternalSymboleo.g:2099:4: ( (lv_pEventName_3_0= rulepEvent ) )
                    // InternalSymboleo.g:2100:5: (lv_pEventName_3_0= rulepEvent )
                    {
                    // InternalSymboleo.g:2100:5: (lv_pEventName_3_0= rulepEvent )
                    // InternalSymboleo.g:2101:6: lv_pEventName_3_0= rulepEvent
                    {

                    						newCompositeNode(grammarAccess.getEventPropAccess().getPEventNamePEventParserRuleCall_0_3_0());
                    					
                    pushFollow(FOLLOW_8);
                    lv_pEventName_3_0=rulepEvent();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getEventPropRule());
                    						}
                    						set(
                    							current,
                    							"pEventName",
                    							lv_pEventName_3_0,
                    							"org.xtext.example.symboleo.Symboleo.pEvent");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,16,FOLLOW_37); 

            			newLeafNode(otherlv_4, grammarAccess.getEventPropAccess().getCommaKeyword_1());
            		
            // InternalSymboleo.g:2123:3: ( (lv_point_5_0= rulePoint ) )
            // InternalSymboleo.g:2124:4: (lv_point_5_0= rulePoint )
            {
            // InternalSymboleo.g:2124:4: (lv_point_5_0= rulePoint )
            // InternalSymboleo.g:2125:5: lv_point_5_0= rulePoint
            {

            					newCompositeNode(grammarAccess.getEventPropAccess().getPointPointParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_point_5_0=rulePoint();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEventPropRule());
            					}
            					set(
            						current,
            						"point",
            						lv_point_5_0,
            						"org.xtext.example.symboleo.Symboleo.Point");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEventProp"


    // $ANTLR start "entryRuleInterval"
    // InternalSymboleo.g:2146:1: entryRuleInterval returns [EObject current=null] : iv_ruleInterval= ruleInterval EOF ;
    public final EObject entryRuleInterval() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterval = null;


        try {
            // InternalSymboleo.g:2146:49: (iv_ruleInterval= ruleInterval EOF )
            // InternalSymboleo.g:2147:2: iv_ruleInterval= ruleInterval EOF
            {
             newCompositeNode(grammarAccess.getIntervalRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInterval=ruleInterval();

            state._fsp--;

             current =iv_ruleInterval; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInterval"


    // $ANTLR start "ruleInterval"
    // InternalSymboleo.g:2153:1: ruleInterval returns [EObject current=null] : ( ( (lv_situationName_0_0= ruleSitName ) ) | (otherlv_1= '[' ( (lv_start_2_0= rulePoint ) ) otherlv_3= ',' ( (lv_end_4_0= rulePoint ) ) otherlv_5= ']' ) | ( (lv_unnamed_6_0= 'UNNAMED_INTERVAL' ) ) | ( ( (lv_situationName_7_0= ruleSitName ) ) ( (lv_tempOp_8_0= ruleTempOp ) ) ( (lv_intConst_9_0= ruleIntConst ) ) ( (lv_unit_10_0= ruleUnit ) ) ) ) ;
    public final EObject ruleInterval() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token lv_unnamed_6_0=null;
        EObject lv_situationName_0_0 = null;

        EObject lv_start_2_0 = null;

        EObject lv_end_4_0 = null;

        EObject lv_situationName_7_0 = null;

        AntlrDatatypeRuleToken lv_tempOp_8_0 = null;

        EObject lv_intConst_9_0 = null;

        AntlrDatatypeRuleToken lv_unit_10_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:2159:2: ( ( ( (lv_situationName_0_0= ruleSitName ) ) | (otherlv_1= '[' ( (lv_start_2_0= rulePoint ) ) otherlv_3= ',' ( (lv_end_4_0= rulePoint ) ) otherlv_5= ']' ) | ( (lv_unnamed_6_0= 'UNNAMED_INTERVAL' ) ) | ( ( (lv_situationName_7_0= ruleSitName ) ) ( (lv_tempOp_8_0= ruleTempOp ) ) ( (lv_intConst_9_0= ruleIntConst ) ) ( (lv_unit_10_0= ruleUnit ) ) ) ) )
            // InternalSymboleo.g:2160:2: ( ( (lv_situationName_0_0= ruleSitName ) ) | (otherlv_1= '[' ( (lv_start_2_0= rulePoint ) ) otherlv_3= ',' ( (lv_end_4_0= rulePoint ) ) otherlv_5= ']' ) | ( (lv_unnamed_6_0= 'UNNAMED_INTERVAL' ) ) | ( ( (lv_situationName_7_0= ruleSitName ) ) ( (lv_tempOp_8_0= ruleTempOp ) ) ( (lv_intConst_9_0= ruleIntConst ) ) ( (lv_unit_10_0= ruleUnit ) ) ) )
            {
            // InternalSymboleo.g:2160:2: ( ( (lv_situationName_0_0= ruleSitName ) ) | (otherlv_1= '[' ( (lv_start_2_0= rulePoint ) ) otherlv_3= ',' ( (lv_end_4_0= rulePoint ) ) otherlv_5= ']' ) | ( (lv_unnamed_6_0= 'UNNAMED_INTERVAL' ) ) | ( ( (lv_situationName_7_0= ruleSitName ) ) ( (lv_tempOp_8_0= ruleTempOp ) ) ( (lv_intConst_9_0= ruleIntConst ) ) ( (lv_unit_10_0= ruleUnit ) ) ) )
            int alt34=4;
            alt34 = dfa34.predict(input);
            switch (alt34) {
                case 1 :
                    // InternalSymboleo.g:2161:3: ( (lv_situationName_0_0= ruleSitName ) )
                    {
                    // InternalSymboleo.g:2161:3: ( (lv_situationName_0_0= ruleSitName ) )
                    // InternalSymboleo.g:2162:4: (lv_situationName_0_0= ruleSitName )
                    {
                    // InternalSymboleo.g:2162:4: (lv_situationName_0_0= ruleSitName )
                    // InternalSymboleo.g:2163:5: lv_situationName_0_0= ruleSitName
                    {

                    					newCompositeNode(grammarAccess.getIntervalAccess().getSituationNameSitNameParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_situationName_0_0=ruleSitName();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getIntervalRule());
                    					}
                    					set(
                    						current,
                    						"situationName",
                    						lv_situationName_0_0,
                    						"org.xtext.example.symboleo.Symboleo.SitName");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:2181:3: (otherlv_1= '[' ( (lv_start_2_0= rulePoint ) ) otherlv_3= ',' ( (lv_end_4_0= rulePoint ) ) otherlv_5= ']' )
                    {
                    // InternalSymboleo.g:2181:3: (otherlv_1= '[' ( (lv_start_2_0= rulePoint ) ) otherlv_3= ',' ( (lv_end_4_0= rulePoint ) ) otherlv_5= ']' )
                    // InternalSymboleo.g:2182:4: otherlv_1= '[' ( (lv_start_2_0= rulePoint ) ) otherlv_3= ',' ( (lv_end_4_0= rulePoint ) ) otherlv_5= ']'
                    {
                    otherlv_1=(Token)match(input,50,FOLLOW_37); 

                    				newLeafNode(otherlv_1, grammarAccess.getIntervalAccess().getLeftSquareBracketKeyword_1_0());
                    			
                    // InternalSymboleo.g:2186:4: ( (lv_start_2_0= rulePoint ) )
                    // InternalSymboleo.g:2187:5: (lv_start_2_0= rulePoint )
                    {
                    // InternalSymboleo.g:2187:5: (lv_start_2_0= rulePoint )
                    // InternalSymboleo.g:2188:6: lv_start_2_0= rulePoint
                    {

                    						newCompositeNode(grammarAccess.getIntervalAccess().getStartPointParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_8);
                    lv_start_2_0=rulePoint();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIntervalRule());
                    						}
                    						set(
                    							current,
                    							"start",
                    							lv_start_2_0,
                    							"org.xtext.example.symboleo.Symboleo.Point");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,16,FOLLOW_37); 

                    				newLeafNode(otherlv_3, grammarAccess.getIntervalAccess().getCommaKeyword_1_2());
                    			
                    // InternalSymboleo.g:2209:4: ( (lv_end_4_0= rulePoint ) )
                    // InternalSymboleo.g:2210:5: (lv_end_4_0= rulePoint )
                    {
                    // InternalSymboleo.g:2210:5: (lv_end_4_0= rulePoint )
                    // InternalSymboleo.g:2211:6: lv_end_4_0= rulePoint
                    {

                    						newCompositeNode(grammarAccess.getIntervalAccess().getEndPointParserRuleCall_1_3_0());
                    					
                    pushFollow(FOLLOW_38);
                    lv_end_4_0=rulePoint();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIntervalRule());
                    						}
                    						set(
                    							current,
                    							"end",
                    							lv_end_4_0,
                    							"org.xtext.example.symboleo.Symboleo.Point");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,51,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getIntervalAccess().getRightSquareBracketKeyword_1_4());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:2234:3: ( (lv_unnamed_6_0= 'UNNAMED_INTERVAL' ) )
                    {
                    // InternalSymboleo.g:2234:3: ( (lv_unnamed_6_0= 'UNNAMED_INTERVAL' ) )
                    // InternalSymboleo.g:2235:4: (lv_unnamed_6_0= 'UNNAMED_INTERVAL' )
                    {
                    // InternalSymboleo.g:2235:4: (lv_unnamed_6_0= 'UNNAMED_INTERVAL' )
                    // InternalSymboleo.g:2236:5: lv_unnamed_6_0= 'UNNAMED_INTERVAL'
                    {
                    lv_unnamed_6_0=(Token)match(input,52,FOLLOW_2); 

                    					newLeafNode(lv_unnamed_6_0, grammarAccess.getIntervalAccess().getUnnamedUNNAMED_INTERVALKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getIntervalRule());
                    					}
                    					setWithLastConsumed(current, "unnamed", lv_unnamed_6_0, "UNNAMED_INTERVAL");
                    				

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalSymboleo.g:2249:3: ( ( (lv_situationName_7_0= ruleSitName ) ) ( (lv_tempOp_8_0= ruleTempOp ) ) ( (lv_intConst_9_0= ruleIntConst ) ) ( (lv_unit_10_0= ruleUnit ) ) )
                    {
                    // InternalSymboleo.g:2249:3: ( ( (lv_situationName_7_0= ruleSitName ) ) ( (lv_tempOp_8_0= ruleTempOp ) ) ( (lv_intConst_9_0= ruleIntConst ) ) ( (lv_unit_10_0= ruleUnit ) ) )
                    // InternalSymboleo.g:2250:4: ( (lv_situationName_7_0= ruleSitName ) ) ( (lv_tempOp_8_0= ruleTempOp ) ) ( (lv_intConst_9_0= ruleIntConst ) ) ( (lv_unit_10_0= ruleUnit ) )
                    {
                    // InternalSymboleo.g:2250:4: ( (lv_situationName_7_0= ruleSitName ) )
                    // InternalSymboleo.g:2251:5: (lv_situationName_7_0= ruleSitName )
                    {
                    // InternalSymboleo.g:2251:5: (lv_situationName_7_0= ruleSitName )
                    // InternalSymboleo.g:2252:6: lv_situationName_7_0= ruleSitName
                    {

                    						newCompositeNode(grammarAccess.getIntervalAccess().getSituationNameSitNameParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_39);
                    lv_situationName_7_0=ruleSitName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIntervalRule());
                    						}
                    						set(
                    							current,
                    							"situationName",
                    							lv_situationName_7_0,
                    							"org.xtext.example.symboleo.Symboleo.SitName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalSymboleo.g:2269:4: ( (lv_tempOp_8_0= ruleTempOp ) )
                    // InternalSymboleo.g:2270:5: (lv_tempOp_8_0= ruleTempOp )
                    {
                    // InternalSymboleo.g:2270:5: (lv_tempOp_8_0= ruleTempOp )
                    // InternalSymboleo.g:2271:6: lv_tempOp_8_0= ruleTempOp
                    {

                    						newCompositeNode(grammarAccess.getIntervalAccess().getTempOpTempOpParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_40);
                    lv_tempOp_8_0=ruleTempOp();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIntervalRule());
                    						}
                    						set(
                    							current,
                    							"tempOp",
                    							lv_tempOp_8_0,
                    							"org.xtext.example.symboleo.Symboleo.TempOp");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalSymboleo.g:2288:4: ( (lv_intConst_9_0= ruleIntConst ) )
                    // InternalSymboleo.g:2289:5: (lv_intConst_9_0= ruleIntConst )
                    {
                    // InternalSymboleo.g:2289:5: (lv_intConst_9_0= ruleIntConst )
                    // InternalSymboleo.g:2290:6: lv_intConst_9_0= ruleIntConst
                    {

                    						newCompositeNode(grammarAccess.getIntervalAccess().getIntConstIntConstParserRuleCall_3_2_0());
                    					
                    pushFollow(FOLLOW_41);
                    lv_intConst_9_0=ruleIntConst();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIntervalRule());
                    						}
                    						set(
                    							current,
                    							"intConst",
                    							lv_intConst_9_0,
                    							"org.xtext.example.symboleo.Symboleo.IntConst");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalSymboleo.g:2307:4: ( (lv_unit_10_0= ruleUnit ) )
                    // InternalSymboleo.g:2308:5: (lv_unit_10_0= ruleUnit )
                    {
                    // InternalSymboleo.g:2308:5: (lv_unit_10_0= ruleUnit )
                    // InternalSymboleo.g:2309:6: lv_unit_10_0= ruleUnit
                    {

                    						newCompositeNode(grammarAccess.getIntervalAccess().getUnitUnitParserRuleCall_3_3_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_unit_10_0=ruleUnit();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIntervalRule());
                    						}
                    						set(
                    							current,
                    							"unit",
                    							lv_unit_10_0,
                    							"org.xtext.example.symboleo.Symboleo.Unit");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInterval"


    // $ANTLR start "entryRuleSitName"
    // InternalSymboleo.g:2331:1: entryRuleSitName returns [EObject current=null] : iv_ruleSitName= ruleSitName EOF ;
    public final EObject entryRuleSitName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSitName = null;


        try {
            // InternalSymboleo.g:2331:48: (iv_ruleSitName= ruleSitName EOF )
            // InternalSymboleo.g:2332:2: iv_ruleSitName= ruleSitName EOF
            {
             newCompositeNode(grammarAccess.getSitNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSitName=ruleSitName();

            state._fsp--;

             current =iv_ruleSitName; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSitName"


    // $ANTLR start "ruleSitName"
    // InternalSymboleo.g:2338:1: ruleSitName returns [EObject current=null] : ( ( (lv_SitName_0_0= RULE_ID ) ) | ( (lv_oState_1_0= ruleoState ) ) | ( (lv_pState_2_0= rulepState ) ) | ( (lv_cState_3_0= rulecState ) ) | ( (lv_oEvent_4_0= ruleoEvent ) ) | ( (lv_cEvent_5_0= rulecEvent ) ) | ( (lv_pEvent_6_0= rulepEvent ) ) ) ;
    public final EObject ruleSitName() throws RecognitionException {
        EObject current = null;

        Token lv_SitName_0_0=null;
        EObject lv_oState_1_0 = null;

        EObject lv_pState_2_0 = null;

        EObject lv_cState_3_0 = null;

        EObject lv_oEvent_4_0 = null;

        EObject lv_cEvent_5_0 = null;

        EObject lv_pEvent_6_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:2344:2: ( ( ( (lv_SitName_0_0= RULE_ID ) ) | ( (lv_oState_1_0= ruleoState ) ) | ( (lv_pState_2_0= rulepState ) ) | ( (lv_cState_3_0= rulecState ) ) | ( (lv_oEvent_4_0= ruleoEvent ) ) | ( (lv_cEvent_5_0= rulecEvent ) ) | ( (lv_pEvent_6_0= rulepEvent ) ) ) )
            // InternalSymboleo.g:2345:2: ( ( (lv_SitName_0_0= RULE_ID ) ) | ( (lv_oState_1_0= ruleoState ) ) | ( (lv_pState_2_0= rulepState ) ) | ( (lv_cState_3_0= rulecState ) ) | ( (lv_oEvent_4_0= ruleoEvent ) ) | ( (lv_cEvent_5_0= rulecEvent ) ) | ( (lv_pEvent_6_0= rulepEvent ) ) )
            {
            // InternalSymboleo.g:2345:2: ( ( (lv_SitName_0_0= RULE_ID ) ) | ( (lv_oState_1_0= ruleoState ) ) | ( (lv_pState_2_0= rulepState ) ) | ( (lv_cState_3_0= rulecState ) ) | ( (lv_oEvent_4_0= ruleoEvent ) ) | ( (lv_cEvent_5_0= rulecEvent ) ) | ( (lv_pEvent_6_0= rulepEvent ) ) )
            int alt35=7;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt35=1;
                }
                break;
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
                {
                alt35=2;
                }
                break;
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
                {
                alt35=3;
                }
                break;
            case 99:
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
                {
                alt35=4;
                }
                break;
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
                {
                alt35=5;
                }
                break;
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
                {
                alt35=6;
                }
                break;
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
                {
                alt35=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // InternalSymboleo.g:2346:3: ( (lv_SitName_0_0= RULE_ID ) )
                    {
                    // InternalSymboleo.g:2346:3: ( (lv_SitName_0_0= RULE_ID ) )
                    // InternalSymboleo.g:2347:4: (lv_SitName_0_0= RULE_ID )
                    {
                    // InternalSymboleo.g:2347:4: (lv_SitName_0_0= RULE_ID )
                    // InternalSymboleo.g:2348:5: lv_SitName_0_0= RULE_ID
                    {
                    lv_SitName_0_0=(Token)match(input,RULE_ID,FOLLOW_2); 

                    					newLeafNode(lv_SitName_0_0, grammarAccess.getSitNameAccess().getSitNameIDTerminalRuleCall_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getSitNameRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"SitName",
                    						lv_SitName_0_0,
                    						"org.eclipse.xtext.common.Terminals.ID");
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:2365:3: ( (lv_oState_1_0= ruleoState ) )
                    {
                    // InternalSymboleo.g:2365:3: ( (lv_oState_1_0= ruleoState ) )
                    // InternalSymboleo.g:2366:4: (lv_oState_1_0= ruleoState )
                    {
                    // InternalSymboleo.g:2366:4: (lv_oState_1_0= ruleoState )
                    // InternalSymboleo.g:2367:5: lv_oState_1_0= ruleoState
                    {

                    					newCompositeNode(grammarAccess.getSitNameAccess().getOStateOStateParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_oState_1_0=ruleoState();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getSitNameRule());
                    					}
                    					set(
                    						current,
                    						"oState",
                    						lv_oState_1_0,
                    						"org.xtext.example.symboleo.Symboleo.oState");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:2385:3: ( (lv_pState_2_0= rulepState ) )
                    {
                    // InternalSymboleo.g:2385:3: ( (lv_pState_2_0= rulepState ) )
                    // InternalSymboleo.g:2386:4: (lv_pState_2_0= rulepState )
                    {
                    // InternalSymboleo.g:2386:4: (lv_pState_2_0= rulepState )
                    // InternalSymboleo.g:2387:5: lv_pState_2_0= rulepState
                    {

                    					newCompositeNode(grammarAccess.getSitNameAccess().getPStatePStateParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_pState_2_0=rulepState();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getSitNameRule());
                    					}
                    					set(
                    						current,
                    						"pState",
                    						lv_pState_2_0,
                    						"org.xtext.example.symboleo.Symboleo.pState");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalSymboleo.g:2405:3: ( (lv_cState_3_0= rulecState ) )
                    {
                    // InternalSymboleo.g:2405:3: ( (lv_cState_3_0= rulecState ) )
                    // InternalSymboleo.g:2406:4: (lv_cState_3_0= rulecState )
                    {
                    // InternalSymboleo.g:2406:4: (lv_cState_3_0= rulecState )
                    // InternalSymboleo.g:2407:5: lv_cState_3_0= rulecState
                    {

                    					newCompositeNode(grammarAccess.getSitNameAccess().getCStateCStateParserRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_cState_3_0=rulecState();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getSitNameRule());
                    					}
                    					set(
                    						current,
                    						"cState",
                    						lv_cState_3_0,
                    						"org.xtext.example.symboleo.Symboleo.cState");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalSymboleo.g:2425:3: ( (lv_oEvent_4_0= ruleoEvent ) )
                    {
                    // InternalSymboleo.g:2425:3: ( (lv_oEvent_4_0= ruleoEvent ) )
                    // InternalSymboleo.g:2426:4: (lv_oEvent_4_0= ruleoEvent )
                    {
                    // InternalSymboleo.g:2426:4: (lv_oEvent_4_0= ruleoEvent )
                    // InternalSymboleo.g:2427:5: lv_oEvent_4_0= ruleoEvent
                    {

                    					newCompositeNode(grammarAccess.getSitNameAccess().getOEventOEventParserRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_oEvent_4_0=ruleoEvent();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getSitNameRule());
                    					}
                    					set(
                    						current,
                    						"oEvent",
                    						lv_oEvent_4_0,
                    						"org.xtext.example.symboleo.Symboleo.oEvent");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalSymboleo.g:2445:3: ( (lv_cEvent_5_0= rulecEvent ) )
                    {
                    // InternalSymboleo.g:2445:3: ( (lv_cEvent_5_0= rulecEvent ) )
                    // InternalSymboleo.g:2446:4: (lv_cEvent_5_0= rulecEvent )
                    {
                    // InternalSymboleo.g:2446:4: (lv_cEvent_5_0= rulecEvent )
                    // InternalSymboleo.g:2447:5: lv_cEvent_5_0= rulecEvent
                    {

                    					newCompositeNode(grammarAccess.getSitNameAccess().getCEventCEventParserRuleCall_5_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_cEvent_5_0=rulecEvent();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getSitNameRule());
                    					}
                    					set(
                    						current,
                    						"cEvent",
                    						lv_cEvent_5_0,
                    						"org.xtext.example.symboleo.Symboleo.cEvent");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalSymboleo.g:2465:3: ( (lv_pEvent_6_0= rulepEvent ) )
                    {
                    // InternalSymboleo.g:2465:3: ( (lv_pEvent_6_0= rulepEvent ) )
                    // InternalSymboleo.g:2466:4: (lv_pEvent_6_0= rulepEvent )
                    {
                    // InternalSymboleo.g:2466:4: (lv_pEvent_6_0= rulepEvent )
                    // InternalSymboleo.g:2467:5: lv_pEvent_6_0= rulepEvent
                    {

                    					newCompositeNode(grammarAccess.getSitNameAccess().getPEventPEventParserRuleCall_6_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_pEvent_6_0=rulepEvent();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getSitNameRule());
                    					}
                    					set(
                    						current,
                    						"pEvent",
                    						lv_pEvent_6_0,
                    						"org.xtext.example.symboleo.Symboleo.pEvent");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSitName"


    // $ANTLR start "entryRuleUnit"
    // InternalSymboleo.g:2488:1: entryRuleUnit returns [String current=null] : iv_ruleUnit= ruleUnit EOF ;
    public final String entryRuleUnit() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnit = null;


        try {
            // InternalSymboleo.g:2488:44: (iv_ruleUnit= ruleUnit EOF )
            // InternalSymboleo.g:2489:2: iv_ruleUnit= ruleUnit EOF
            {
             newCompositeNode(grammarAccess.getUnitRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUnit=ruleUnit();

            state._fsp--;

             current =iv_ruleUnit.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnit"


    // $ANTLR start "ruleUnit"
    // InternalSymboleo.g:2495:1: ruleUnit returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'SECONDS' | kw= 'MINUTES' | kw= 'HOURS' | kw= 'DAYS' | kw= 'WEEKS' | kw= 'MONTHS' | kw= 'QUARTERS' | kw= 'YEARS' ) ;
    public final AntlrDatatypeRuleToken ruleUnit() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSymboleo.g:2501:2: ( (kw= 'SECONDS' | kw= 'MINUTES' | kw= 'HOURS' | kw= 'DAYS' | kw= 'WEEKS' | kw= 'MONTHS' | kw= 'QUARTERS' | kw= 'YEARS' ) )
            // InternalSymboleo.g:2502:2: (kw= 'SECONDS' | kw= 'MINUTES' | kw= 'HOURS' | kw= 'DAYS' | kw= 'WEEKS' | kw= 'MONTHS' | kw= 'QUARTERS' | kw= 'YEARS' )
            {
            // InternalSymboleo.g:2502:2: (kw= 'SECONDS' | kw= 'MINUTES' | kw= 'HOURS' | kw= 'DAYS' | kw= 'WEEKS' | kw= 'MONTHS' | kw= 'QUARTERS' | kw= 'YEARS' )
            int alt36=8;
            switch ( input.LA(1) ) {
            case 53:
                {
                alt36=1;
                }
                break;
            case 54:
                {
                alt36=2;
                }
                break;
            case 55:
                {
                alt36=3;
                }
                break;
            case 56:
                {
                alt36=4;
                }
                break;
            case 57:
                {
                alt36=5;
                }
                break;
            case 58:
                {
                alt36=6;
                }
                break;
            case 59:
                {
                alt36=7;
                }
                break;
            case 60:
                {
                alt36=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // InternalSymboleo.g:2503:3: kw= 'SECONDS'
                    {
                    kw=(Token)match(input,53,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getUnitAccess().getSECONDSKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:2509:3: kw= 'MINUTES'
                    {
                    kw=(Token)match(input,54,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getUnitAccess().getMINUTESKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:2515:3: kw= 'HOURS'
                    {
                    kw=(Token)match(input,55,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getUnitAccess().getHOURSKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalSymboleo.g:2521:3: kw= 'DAYS'
                    {
                    kw=(Token)match(input,56,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getUnitAccess().getDAYSKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalSymboleo.g:2527:3: kw= 'WEEKS'
                    {
                    kw=(Token)match(input,57,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getUnitAccess().getWEEKSKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalSymboleo.g:2533:3: kw= 'MONTHS'
                    {
                    kw=(Token)match(input,58,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getUnitAccess().getMONTHSKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalSymboleo.g:2539:3: kw= 'QUARTERS'
                    {
                    kw=(Token)match(input,59,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getUnitAccess().getQUARTERSKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalSymboleo.g:2545:3: kw= 'YEARS'
                    {
                    kw=(Token)match(input,60,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getUnitAccess().getYEARSKeyword_7());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnit"


    // $ANTLR start "entryRuleIntConst"
    // InternalSymboleo.g:2554:1: entryRuleIntConst returns [EObject current=null] : iv_ruleIntConst= ruleIntConst EOF ;
    public final EObject entryRuleIntConst() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntConst = null;


        try {
            // InternalSymboleo.g:2554:49: (iv_ruleIntConst= ruleIntConst EOF )
            // InternalSymboleo.g:2555:2: iv_ruleIntConst= ruleIntConst EOF
            {
             newCompositeNode(grammarAccess.getIntConstRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIntConst=ruleIntConst();

            state._fsp--;

             current =iv_ruleIntConst; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntConst"


    // $ANTLR start "ruleIntConst"
    // InternalSymboleo.g:2561:1: ruleIntConst returns [EObject current=null] : ( () ( (lv_Type_1_0= RULE_INT ) ) ) ;
    public final EObject ruleIntConst() throws RecognitionException {
        EObject current = null;

        Token lv_Type_1_0=null;


        	enterRule();

        try {
            // InternalSymboleo.g:2567:2: ( ( () ( (lv_Type_1_0= RULE_INT ) ) ) )
            // InternalSymboleo.g:2568:2: ( () ( (lv_Type_1_0= RULE_INT ) ) )
            {
            // InternalSymboleo.g:2568:2: ( () ( (lv_Type_1_0= RULE_INT ) ) )
            // InternalSymboleo.g:2569:3: () ( (lv_Type_1_0= RULE_INT ) )
            {
            // InternalSymboleo.g:2569:3: ()
            // InternalSymboleo.g:2570:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getIntConstAccess().getIntConstAction_0(),
            					current);
            			

            }

            // InternalSymboleo.g:2576:3: ( (lv_Type_1_0= RULE_INT ) )
            // InternalSymboleo.g:2577:4: (lv_Type_1_0= RULE_INT )
            {
            // InternalSymboleo.g:2577:4: (lv_Type_1_0= RULE_INT )
            // InternalSymboleo.g:2578:5: lv_Type_1_0= RULE_INT
            {
            lv_Type_1_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            					newLeafNode(lv_Type_1_0, grammarAccess.getIntConstAccess().getTypeINTTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getIntConstRule());
            					}
            					setWithLastConsumed(
            						current,
            						"Type",
            						lv_Type_1_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntConst"


    // $ANTLR start "entryRuleTempOp"
    // InternalSymboleo.g:2598:1: entryRuleTempOp returns [String current=null] : iv_ruleTempOp= ruleTempOp EOF ;
    public final String entryRuleTempOp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleTempOp = null;


        try {
            // InternalSymboleo.g:2598:46: (iv_ruleTempOp= ruleTempOp EOF )
            // InternalSymboleo.g:2599:2: iv_ruleTempOp= ruleTempOp EOF
            {
             newCompositeNode(grammarAccess.getTempOpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTempOp=ruleTempOp();

            state._fsp--;

             current =iv_ruleTempOp.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTempOp"


    // $ANTLR start "ruleTempOp"
    // InternalSymboleo.g:2605:1: ruleTempOp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'BEFORE' | kw= 'AFTER' | kw= 'AT' | kw= 'WITHIN' | kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleTempOp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSymboleo.g:2611:2: ( (kw= 'BEFORE' | kw= 'AFTER' | kw= 'AT' | kw= 'WITHIN' | kw= '+' | kw= '-' ) )
            // InternalSymboleo.g:2612:2: (kw= 'BEFORE' | kw= 'AFTER' | kw= 'AT' | kw= 'WITHIN' | kw= '+' | kw= '-' )
            {
            // InternalSymboleo.g:2612:2: (kw= 'BEFORE' | kw= 'AFTER' | kw= 'AT' | kw= 'WITHIN' | kw= '+' | kw= '-' )
            int alt37=6;
            switch ( input.LA(1) ) {
            case 61:
                {
                alt37=1;
                }
                break;
            case 62:
                {
                alt37=2;
                }
                break;
            case 63:
                {
                alt37=3;
                }
                break;
            case 64:
                {
                alt37=4;
                }
                break;
            case 65:
                {
                alt37=5;
                }
                break;
            case 66:
                {
                alt37=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }

            switch (alt37) {
                case 1 :
                    // InternalSymboleo.g:2613:3: kw= 'BEFORE'
                    {
                    kw=(Token)match(input,61,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTempOpAccess().getBEFOREKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:2619:3: kw= 'AFTER'
                    {
                    kw=(Token)match(input,62,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTempOpAccess().getAFTERKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:2625:3: kw= 'AT'
                    {
                    kw=(Token)match(input,63,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTempOpAccess().getATKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalSymboleo.g:2631:3: kw= 'WITHIN'
                    {
                    kw=(Token)match(input,64,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTempOpAccess().getWITHINKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalSymboleo.g:2637:3: kw= '+'
                    {
                    kw=(Token)match(input,65,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTempOpAccess().getPlusSignKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalSymboleo.g:2643:3: kw= '-'
                    {
                    kw=(Token)match(input,66,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTempOpAccess().getHyphenMinusKeyword_5());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTempOp"


    // $ANTLR start "entryRulePoint"
    // InternalSymboleo.g:2652:1: entryRulePoint returns [EObject current=null] : iv_rulePoint= rulePoint EOF ;
    public final EObject entryRulePoint() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePoint = null;


        try {
            // InternalSymboleo.g:2652:46: (iv_rulePoint= rulePoint EOF )
            // InternalSymboleo.g:2653:2: iv_rulePoint= rulePoint EOF
            {
             newCompositeNode(grammarAccess.getPointRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePoint=rulePoint();

            state._fsp--;

             current =iv_rulePoint; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePoint"


    // $ANTLR start "rulePoint"
    // InternalSymboleo.g:2659:1: rulePoint returns [EObject current=null] : ( ( (lv_eventName_0_0= ruleSitName ) ) | ( (lv_unnamed_1_0= 'UNNAMED_POINT' ) ) | ( (lv_pointConst_2_0= rulePointConst ) ) | ( ( (lv_pointConst_3_0= rulePointConst ) ) ( (lv_unit_4_0= ruleUnit ) ) ( (lv_tempOp_5_0= ruleTempOp ) ) ( (lv_eventName_6_0= ruleSitName ) ) ) ) ;
    public final EObject rulePoint() throws RecognitionException {
        EObject current = null;

        Token lv_unnamed_1_0=null;
        EObject lv_eventName_0_0 = null;

        EObject lv_pointConst_2_0 = null;

        EObject lv_pointConst_3_0 = null;

        AntlrDatatypeRuleToken lv_unit_4_0 = null;

        AntlrDatatypeRuleToken lv_tempOp_5_0 = null;

        EObject lv_eventName_6_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:2665:2: ( ( ( (lv_eventName_0_0= ruleSitName ) ) | ( (lv_unnamed_1_0= 'UNNAMED_POINT' ) ) | ( (lv_pointConst_2_0= rulePointConst ) ) | ( ( (lv_pointConst_3_0= rulePointConst ) ) ( (lv_unit_4_0= ruleUnit ) ) ( (lv_tempOp_5_0= ruleTempOp ) ) ( (lv_eventName_6_0= ruleSitName ) ) ) ) )
            // InternalSymboleo.g:2666:2: ( ( (lv_eventName_0_0= ruleSitName ) ) | ( (lv_unnamed_1_0= 'UNNAMED_POINT' ) ) | ( (lv_pointConst_2_0= rulePointConst ) ) | ( ( (lv_pointConst_3_0= rulePointConst ) ) ( (lv_unit_4_0= ruleUnit ) ) ( (lv_tempOp_5_0= ruleTempOp ) ) ( (lv_eventName_6_0= ruleSitName ) ) ) )
            {
            // InternalSymboleo.g:2666:2: ( ( (lv_eventName_0_0= ruleSitName ) ) | ( (lv_unnamed_1_0= 'UNNAMED_POINT' ) ) | ( (lv_pointConst_2_0= rulePointConst ) ) | ( ( (lv_pointConst_3_0= rulePointConst ) ) ( (lv_unit_4_0= ruleUnit ) ) ( (lv_tempOp_5_0= ruleTempOp ) ) ( (lv_eventName_6_0= ruleSitName ) ) ) )
            int alt38=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
                {
                alt38=1;
                }
                break;
            case 67:
                {
                alt38=2;
                }
                break;
            case RULE_INT:
                {
                int LA38_3 = input.LA(2);

                if ( (LA38_3==EOF||(LA38_3>=16 && LA38_3<=17)||LA38_3==47||LA38_3==51) ) {
                    alt38=3;
                }
                else if ( ((LA38_3>=53 && LA38_3<=60)) ) {
                    alt38=4;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }

            switch (alt38) {
                case 1 :
                    // InternalSymboleo.g:2667:3: ( (lv_eventName_0_0= ruleSitName ) )
                    {
                    // InternalSymboleo.g:2667:3: ( (lv_eventName_0_0= ruleSitName ) )
                    // InternalSymboleo.g:2668:4: (lv_eventName_0_0= ruleSitName )
                    {
                    // InternalSymboleo.g:2668:4: (lv_eventName_0_0= ruleSitName )
                    // InternalSymboleo.g:2669:5: lv_eventName_0_0= ruleSitName
                    {

                    					newCompositeNode(grammarAccess.getPointAccess().getEventNameSitNameParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_eventName_0_0=ruleSitName();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getPointRule());
                    					}
                    					set(
                    						current,
                    						"eventName",
                    						lv_eventName_0_0,
                    						"org.xtext.example.symboleo.Symboleo.SitName");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:2687:3: ( (lv_unnamed_1_0= 'UNNAMED_POINT' ) )
                    {
                    // InternalSymboleo.g:2687:3: ( (lv_unnamed_1_0= 'UNNAMED_POINT' ) )
                    // InternalSymboleo.g:2688:4: (lv_unnamed_1_0= 'UNNAMED_POINT' )
                    {
                    // InternalSymboleo.g:2688:4: (lv_unnamed_1_0= 'UNNAMED_POINT' )
                    // InternalSymboleo.g:2689:5: lv_unnamed_1_0= 'UNNAMED_POINT'
                    {
                    lv_unnamed_1_0=(Token)match(input,67,FOLLOW_2); 

                    					newLeafNode(lv_unnamed_1_0, grammarAccess.getPointAccess().getUnnamedUNNAMED_POINTKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getPointRule());
                    					}
                    					setWithLastConsumed(current, "unnamed", lv_unnamed_1_0, "UNNAMED_POINT");
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:2702:3: ( (lv_pointConst_2_0= rulePointConst ) )
                    {
                    // InternalSymboleo.g:2702:3: ( (lv_pointConst_2_0= rulePointConst ) )
                    // InternalSymboleo.g:2703:4: (lv_pointConst_2_0= rulePointConst )
                    {
                    // InternalSymboleo.g:2703:4: (lv_pointConst_2_0= rulePointConst )
                    // InternalSymboleo.g:2704:5: lv_pointConst_2_0= rulePointConst
                    {

                    					newCompositeNode(grammarAccess.getPointAccess().getPointConstPointConstParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_pointConst_2_0=rulePointConst();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getPointRule());
                    					}
                    					set(
                    						current,
                    						"pointConst",
                    						lv_pointConst_2_0,
                    						"org.xtext.example.symboleo.Symboleo.PointConst");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalSymboleo.g:2722:3: ( ( (lv_pointConst_3_0= rulePointConst ) ) ( (lv_unit_4_0= ruleUnit ) ) ( (lv_tempOp_5_0= ruleTempOp ) ) ( (lv_eventName_6_0= ruleSitName ) ) )
                    {
                    // InternalSymboleo.g:2722:3: ( ( (lv_pointConst_3_0= rulePointConst ) ) ( (lv_unit_4_0= ruleUnit ) ) ( (lv_tempOp_5_0= ruleTempOp ) ) ( (lv_eventName_6_0= ruleSitName ) ) )
                    // InternalSymboleo.g:2723:4: ( (lv_pointConst_3_0= rulePointConst ) ) ( (lv_unit_4_0= ruleUnit ) ) ( (lv_tempOp_5_0= ruleTempOp ) ) ( (lv_eventName_6_0= ruleSitName ) )
                    {
                    // InternalSymboleo.g:2723:4: ( (lv_pointConst_3_0= rulePointConst ) )
                    // InternalSymboleo.g:2724:5: (lv_pointConst_3_0= rulePointConst )
                    {
                    // InternalSymboleo.g:2724:5: (lv_pointConst_3_0= rulePointConst )
                    // InternalSymboleo.g:2725:6: lv_pointConst_3_0= rulePointConst
                    {

                    						newCompositeNode(grammarAccess.getPointAccess().getPointConstPointConstParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_41);
                    lv_pointConst_3_0=rulePointConst();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPointRule());
                    						}
                    						set(
                    							current,
                    							"pointConst",
                    							lv_pointConst_3_0,
                    							"org.xtext.example.symboleo.Symboleo.PointConst");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalSymboleo.g:2742:4: ( (lv_unit_4_0= ruleUnit ) )
                    // InternalSymboleo.g:2743:5: (lv_unit_4_0= ruleUnit )
                    {
                    // InternalSymboleo.g:2743:5: (lv_unit_4_0= ruleUnit )
                    // InternalSymboleo.g:2744:6: lv_unit_4_0= ruleUnit
                    {

                    						newCompositeNode(grammarAccess.getPointAccess().getUnitUnitParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_39);
                    lv_unit_4_0=ruleUnit();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPointRule());
                    						}
                    						set(
                    							current,
                    							"unit",
                    							lv_unit_4_0,
                    							"org.xtext.example.symboleo.Symboleo.Unit");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalSymboleo.g:2761:4: ( (lv_tempOp_5_0= ruleTempOp ) )
                    // InternalSymboleo.g:2762:5: (lv_tempOp_5_0= ruleTempOp )
                    {
                    // InternalSymboleo.g:2762:5: (lv_tempOp_5_0= ruleTempOp )
                    // InternalSymboleo.g:2763:6: lv_tempOp_5_0= ruleTempOp
                    {

                    						newCompositeNode(grammarAccess.getPointAccess().getTempOpTempOpParserRuleCall_3_2_0());
                    					
                    pushFollow(FOLLOW_33);
                    lv_tempOp_5_0=ruleTempOp();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPointRule());
                    						}
                    						set(
                    							current,
                    							"tempOp",
                    							lv_tempOp_5_0,
                    							"org.xtext.example.symboleo.Symboleo.TempOp");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalSymboleo.g:2780:4: ( (lv_eventName_6_0= ruleSitName ) )
                    // InternalSymboleo.g:2781:5: (lv_eventName_6_0= ruleSitName )
                    {
                    // InternalSymboleo.g:2781:5: (lv_eventName_6_0= ruleSitName )
                    // InternalSymboleo.g:2782:6: lv_eventName_6_0= ruleSitName
                    {

                    						newCompositeNode(grammarAccess.getPointAccess().getEventNameSitNameParserRuleCall_3_3_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_eventName_6_0=ruleSitName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPointRule());
                    						}
                    						set(
                    							current,
                    							"eventName",
                    							lv_eventName_6_0,
                    							"org.xtext.example.symboleo.Symboleo.SitName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePoint"


    // $ANTLR start "entryRulepEvent"
    // InternalSymboleo.g:2804:1: entryRulepEvent returns [EObject current=null] : iv_rulepEvent= rulepEvent EOF ;
    public final EObject entryRulepEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_rulepEvent = null;


        try {
            // InternalSymboleo.g:2804:47: (iv_rulepEvent= rulepEvent EOF )
            // InternalSymboleo.g:2805:2: iv_rulepEvent= rulepEvent EOF
            {
             newCompositeNode(grammarAccess.getPEventRule()); 
            pushFollow(FOLLOW_1);
            iv_rulepEvent=rulepEvent();

            state._fsp--;

             current =iv_rulepEvent; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulepEvent"


    // $ANTLR start "rulepEvent"
    // InternalSymboleo.g:2811:1: rulepEvent returns [EObject current=null] : ( ( (lv_powEvent_0_0= rulePowEvent ) ) otherlv_1= '(' ( (lv_powName_2_0= RULE_ID ) ) otherlv_3= ')' ) ;
    public final EObject rulepEvent() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_powName_2_0=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_powEvent_0_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:2817:2: ( ( ( (lv_powEvent_0_0= rulePowEvent ) ) otherlv_1= '(' ( (lv_powName_2_0= RULE_ID ) ) otherlv_3= ')' ) )
            // InternalSymboleo.g:2818:2: ( ( (lv_powEvent_0_0= rulePowEvent ) ) otherlv_1= '(' ( (lv_powName_2_0= RULE_ID ) ) otherlv_3= ')' )
            {
            // InternalSymboleo.g:2818:2: ( ( (lv_powEvent_0_0= rulePowEvent ) ) otherlv_1= '(' ( (lv_powName_2_0= RULE_ID ) ) otherlv_3= ')' )
            // InternalSymboleo.g:2819:3: ( (lv_powEvent_0_0= rulePowEvent ) ) otherlv_1= '(' ( (lv_powName_2_0= RULE_ID ) ) otherlv_3= ')'
            {
            // InternalSymboleo.g:2819:3: ( (lv_powEvent_0_0= rulePowEvent ) )
            // InternalSymboleo.g:2820:4: (lv_powEvent_0_0= rulePowEvent )
            {
            // InternalSymboleo.g:2820:4: (lv_powEvent_0_0= rulePowEvent )
            // InternalSymboleo.g:2821:5: lv_powEvent_0_0= rulePowEvent
            {

            					newCompositeNode(grammarAccess.getPEventAccess().getPowEventPowEventParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_7);
            lv_powEvent_0_0=rulePowEvent();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPEventRule());
            					}
            					set(
            						current,
            						"powEvent",
            						lv_powEvent_0_0,
            						"org.xtext.example.symboleo.Symboleo.PowEvent");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getPEventAccess().getLeftParenthesisKeyword_1());
            		
            // InternalSymboleo.g:2842:3: ( (lv_powName_2_0= RULE_ID ) )
            // InternalSymboleo.g:2843:4: (lv_powName_2_0= RULE_ID )
            {
            // InternalSymboleo.g:2843:4: (lv_powName_2_0= RULE_ID )
            // InternalSymboleo.g:2844:5: lv_powName_2_0= RULE_ID
            {
            lv_powName_2_0=(Token)match(input,RULE_ID,FOLLOW_9); 

            					newLeafNode(lv_powName_2_0, grammarAccess.getPEventAccess().getPowNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPEventRule());
            					}
            					setWithLastConsumed(
            						current,
            						"powName",
            						lv_powName_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getPEventAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulepEvent"


    // $ANTLR start "entryRulePowEvent"
    // InternalSymboleo.g:2868:1: entryRulePowEvent returns [String current=null] : iv_rulePowEvent= rulePowEvent EOF ;
    public final String entryRulePowEvent() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePowEvent = null;


        try {
            // InternalSymboleo.g:2868:48: (iv_rulePowEvent= rulePowEvent EOF )
            // InternalSymboleo.g:2869:2: iv_rulePowEvent= rulePowEvent EOF
            {
             newCompositeNode(grammarAccess.getPowEventRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePowEvent=rulePowEvent();

            state._fsp--;

             current =iv_rulePowEvent.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePowEvent"


    // $ANTLR start "rulePowEvent"
    // InternalSymboleo.g:2875:1: rulePowEvent returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'pTRIGGERED' | kw= 'pACTIVATED' | kw= 'pSUSPENDED' | kw= 'pRESUMED' | kw= 'pEXERTED' | kw= 'pEXPIRED' | kw= 'pTERMINATED' ) ;
    public final AntlrDatatypeRuleToken rulePowEvent() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSymboleo.g:2881:2: ( (kw= 'pTRIGGERED' | kw= 'pACTIVATED' | kw= 'pSUSPENDED' | kw= 'pRESUMED' | kw= 'pEXERTED' | kw= 'pEXPIRED' | kw= 'pTERMINATED' ) )
            // InternalSymboleo.g:2882:2: (kw= 'pTRIGGERED' | kw= 'pACTIVATED' | kw= 'pSUSPENDED' | kw= 'pRESUMED' | kw= 'pEXERTED' | kw= 'pEXPIRED' | kw= 'pTERMINATED' )
            {
            // InternalSymboleo.g:2882:2: (kw= 'pTRIGGERED' | kw= 'pACTIVATED' | kw= 'pSUSPENDED' | kw= 'pRESUMED' | kw= 'pEXERTED' | kw= 'pEXPIRED' | kw= 'pTERMINATED' )
            int alt39=7;
            switch ( input.LA(1) ) {
            case 68:
                {
                alt39=1;
                }
                break;
            case 69:
                {
                alt39=2;
                }
                break;
            case 70:
                {
                alt39=3;
                }
                break;
            case 71:
                {
                alt39=4;
                }
                break;
            case 72:
                {
                alt39=5;
                }
                break;
            case 73:
                {
                alt39=6;
                }
                break;
            case 74:
                {
                alt39=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }

            switch (alt39) {
                case 1 :
                    // InternalSymboleo.g:2883:3: kw= 'pTRIGGERED'
                    {
                    kw=(Token)match(input,68,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowEventAccess().getPTRIGGEREDKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:2889:3: kw= 'pACTIVATED'
                    {
                    kw=(Token)match(input,69,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowEventAccess().getPACTIVATEDKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:2895:3: kw= 'pSUSPENDED'
                    {
                    kw=(Token)match(input,70,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowEventAccess().getPSUSPENDEDKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalSymboleo.g:2901:3: kw= 'pRESUMED'
                    {
                    kw=(Token)match(input,71,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowEventAccess().getPRESUMEDKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalSymboleo.g:2907:3: kw= 'pEXERTED'
                    {
                    kw=(Token)match(input,72,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowEventAccess().getPEXERTEDKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalSymboleo.g:2913:3: kw= 'pEXPIRED'
                    {
                    kw=(Token)match(input,73,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowEventAccess().getPEXPIREDKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalSymboleo.g:2919:3: kw= 'pTERMINATED'
                    {
                    kw=(Token)match(input,74,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowEventAccess().getPTERMINATEDKeyword_6());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePowEvent"


    // $ANTLR start "entryRulecEvent"
    // InternalSymboleo.g:2928:1: entryRulecEvent returns [EObject current=null] : iv_rulecEvent= rulecEvent EOF ;
    public final EObject entryRulecEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_rulecEvent = null;


        try {
            // InternalSymboleo.g:2928:47: (iv_rulecEvent= rulecEvent EOF )
            // InternalSymboleo.g:2929:2: iv_rulecEvent= rulecEvent EOF
            {
             newCompositeNode(grammarAccess.getCEventRule()); 
            pushFollow(FOLLOW_1);
            iv_rulecEvent=rulecEvent();

            state._fsp--;

             current =iv_rulecEvent; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulecEvent"


    // $ANTLR start "rulecEvent"
    // InternalSymboleo.g:2935:1: rulecEvent returns [EObject current=null] : ( ( (lv_contrEvent_0_0= ruleContrEvent ) ) otherlv_1= '(' ( (lv_contrName_2_0= RULE_ID ) ) otherlv_3= ')' ) ;
    public final EObject rulecEvent() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_contrName_2_0=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_contrEvent_0_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:2941:2: ( ( ( (lv_contrEvent_0_0= ruleContrEvent ) ) otherlv_1= '(' ( (lv_contrName_2_0= RULE_ID ) ) otherlv_3= ')' ) )
            // InternalSymboleo.g:2942:2: ( ( (lv_contrEvent_0_0= ruleContrEvent ) ) otherlv_1= '(' ( (lv_contrName_2_0= RULE_ID ) ) otherlv_3= ')' )
            {
            // InternalSymboleo.g:2942:2: ( ( (lv_contrEvent_0_0= ruleContrEvent ) ) otherlv_1= '(' ( (lv_contrName_2_0= RULE_ID ) ) otherlv_3= ')' )
            // InternalSymboleo.g:2943:3: ( (lv_contrEvent_0_0= ruleContrEvent ) ) otherlv_1= '(' ( (lv_contrName_2_0= RULE_ID ) ) otherlv_3= ')'
            {
            // InternalSymboleo.g:2943:3: ( (lv_contrEvent_0_0= ruleContrEvent ) )
            // InternalSymboleo.g:2944:4: (lv_contrEvent_0_0= ruleContrEvent )
            {
            // InternalSymboleo.g:2944:4: (lv_contrEvent_0_0= ruleContrEvent )
            // InternalSymboleo.g:2945:5: lv_contrEvent_0_0= ruleContrEvent
            {

            					newCompositeNode(grammarAccess.getCEventAccess().getContrEventContrEventParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_7);
            lv_contrEvent_0_0=ruleContrEvent();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCEventRule());
            					}
            					set(
            						current,
            						"contrEvent",
            						lv_contrEvent_0_0,
            						"org.xtext.example.symboleo.Symboleo.ContrEvent");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getCEventAccess().getLeftParenthesisKeyword_1());
            		
            // InternalSymboleo.g:2966:3: ( (lv_contrName_2_0= RULE_ID ) )
            // InternalSymboleo.g:2967:4: (lv_contrName_2_0= RULE_ID )
            {
            // InternalSymboleo.g:2967:4: (lv_contrName_2_0= RULE_ID )
            // InternalSymboleo.g:2968:5: lv_contrName_2_0= RULE_ID
            {
            lv_contrName_2_0=(Token)match(input,RULE_ID,FOLLOW_9); 

            					newLeafNode(lv_contrName_2_0, grammarAccess.getCEventAccess().getContrNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCEventRule());
            					}
            					setWithLastConsumed(
            						current,
            						"contrName",
            						lv_contrName_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getCEventAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulecEvent"


    // $ANTLR start "entryRuleContrEvent"
    // InternalSymboleo.g:2992:1: entryRuleContrEvent returns [String current=null] : iv_ruleContrEvent= ruleContrEvent EOF ;
    public final String entryRuleContrEvent() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleContrEvent = null;


        try {
            // InternalSymboleo.g:2992:50: (iv_ruleContrEvent= ruleContrEvent EOF )
            // InternalSymboleo.g:2993:2: iv_ruleContrEvent= ruleContrEvent EOF
            {
             newCompositeNode(grammarAccess.getContrEventRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContrEvent=ruleContrEvent();

            state._fsp--;

             current =iv_ruleContrEvent.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContrEvent"


    // $ANTLR start "ruleContrEvent"
    // InternalSymboleo.g:2999:1: ruleContrEvent returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'cACTIVATED' | kw= 'cSUSPENDED' | kw= 'cRESUMED' | kw= 'cFULFILLED_ACTIVE_OBLS' | kw= 'cREVOKED_PARTY' | kw= 'cASSIGNED_PARTY' | kw= 'cTERMINATED' ) ;
    public final AntlrDatatypeRuleToken ruleContrEvent() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSymboleo.g:3005:2: ( (kw= 'cACTIVATED' | kw= 'cSUSPENDED' | kw= 'cRESUMED' | kw= 'cFULFILLED_ACTIVE_OBLS' | kw= 'cREVOKED_PARTY' | kw= 'cASSIGNED_PARTY' | kw= 'cTERMINATED' ) )
            // InternalSymboleo.g:3006:2: (kw= 'cACTIVATED' | kw= 'cSUSPENDED' | kw= 'cRESUMED' | kw= 'cFULFILLED_ACTIVE_OBLS' | kw= 'cREVOKED_PARTY' | kw= 'cASSIGNED_PARTY' | kw= 'cTERMINATED' )
            {
            // InternalSymboleo.g:3006:2: (kw= 'cACTIVATED' | kw= 'cSUSPENDED' | kw= 'cRESUMED' | kw= 'cFULFILLED_ACTIVE_OBLS' | kw= 'cREVOKED_PARTY' | kw= 'cASSIGNED_PARTY' | kw= 'cTERMINATED' )
            int alt40=7;
            switch ( input.LA(1) ) {
            case 75:
                {
                alt40=1;
                }
                break;
            case 76:
                {
                alt40=2;
                }
                break;
            case 77:
                {
                alt40=3;
                }
                break;
            case 78:
                {
                alt40=4;
                }
                break;
            case 79:
                {
                alt40=5;
                }
                break;
            case 80:
                {
                alt40=6;
                }
                break;
            case 81:
                {
                alt40=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // InternalSymboleo.g:3007:3: kw= 'cACTIVATED'
                    {
                    kw=(Token)match(input,75,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContrEventAccess().getCACTIVATEDKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:3013:3: kw= 'cSUSPENDED'
                    {
                    kw=(Token)match(input,76,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContrEventAccess().getCSUSPENDEDKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:3019:3: kw= 'cRESUMED'
                    {
                    kw=(Token)match(input,77,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContrEventAccess().getCRESUMEDKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalSymboleo.g:3025:3: kw= 'cFULFILLED_ACTIVE_OBLS'
                    {
                    kw=(Token)match(input,78,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContrEventAccess().getCFULFILLED_ACTIVE_OBLSKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalSymboleo.g:3031:3: kw= 'cREVOKED_PARTY'
                    {
                    kw=(Token)match(input,79,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContrEventAccess().getCREVOKED_PARTYKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalSymboleo.g:3037:3: kw= 'cASSIGNED_PARTY'
                    {
                    kw=(Token)match(input,80,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContrEventAccess().getCASSIGNED_PARTYKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalSymboleo.g:3043:3: kw= 'cTERMINATED'
                    {
                    kw=(Token)match(input,81,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContrEventAccess().getCTERMINATEDKeyword_6());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContrEvent"


    // $ANTLR start "entryRuleoEvent"
    // InternalSymboleo.g:3052:1: entryRuleoEvent returns [EObject current=null] : iv_ruleoEvent= ruleoEvent EOF ;
    public final EObject entryRuleoEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleoEvent = null;


        try {
            // InternalSymboleo.g:3052:47: (iv_ruleoEvent= ruleoEvent EOF )
            // InternalSymboleo.g:3053:2: iv_ruleoEvent= ruleoEvent EOF
            {
             newCompositeNode(grammarAccess.getOEventRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleoEvent=ruleoEvent();

            state._fsp--;

             current =iv_ruleoEvent; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleoEvent"


    // $ANTLR start "ruleoEvent"
    // InternalSymboleo.g:3059:1: ruleoEvent returns [EObject current=null] : ( ( (lv_oblEvent_0_0= ruleOblEvent ) ) otherlv_1= '(' ( (lv_oblName_2_0= RULE_ID ) ) otherlv_3= ')' ) ;
    public final EObject ruleoEvent() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_oblName_2_0=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_oblEvent_0_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:3065:2: ( ( ( (lv_oblEvent_0_0= ruleOblEvent ) ) otherlv_1= '(' ( (lv_oblName_2_0= RULE_ID ) ) otherlv_3= ')' ) )
            // InternalSymboleo.g:3066:2: ( ( (lv_oblEvent_0_0= ruleOblEvent ) ) otherlv_1= '(' ( (lv_oblName_2_0= RULE_ID ) ) otherlv_3= ')' )
            {
            // InternalSymboleo.g:3066:2: ( ( (lv_oblEvent_0_0= ruleOblEvent ) ) otherlv_1= '(' ( (lv_oblName_2_0= RULE_ID ) ) otherlv_3= ')' )
            // InternalSymboleo.g:3067:3: ( (lv_oblEvent_0_0= ruleOblEvent ) ) otherlv_1= '(' ( (lv_oblName_2_0= RULE_ID ) ) otherlv_3= ')'
            {
            // InternalSymboleo.g:3067:3: ( (lv_oblEvent_0_0= ruleOblEvent ) )
            // InternalSymboleo.g:3068:4: (lv_oblEvent_0_0= ruleOblEvent )
            {
            // InternalSymboleo.g:3068:4: (lv_oblEvent_0_0= ruleOblEvent )
            // InternalSymboleo.g:3069:5: lv_oblEvent_0_0= ruleOblEvent
            {

            					newCompositeNode(grammarAccess.getOEventAccess().getOblEventOblEventParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_7);
            lv_oblEvent_0_0=ruleOblEvent();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOEventRule());
            					}
            					set(
            						current,
            						"oblEvent",
            						lv_oblEvent_0_0,
            						"org.xtext.example.symboleo.Symboleo.OblEvent");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getOEventAccess().getLeftParenthesisKeyword_1());
            		
            // InternalSymboleo.g:3090:3: ( (lv_oblName_2_0= RULE_ID ) )
            // InternalSymboleo.g:3091:4: (lv_oblName_2_0= RULE_ID )
            {
            // InternalSymboleo.g:3091:4: (lv_oblName_2_0= RULE_ID )
            // InternalSymboleo.g:3092:5: lv_oblName_2_0= RULE_ID
            {
            lv_oblName_2_0=(Token)match(input,RULE_ID,FOLLOW_9); 

            					newLeafNode(lv_oblName_2_0, grammarAccess.getOEventAccess().getOblNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOEventRule());
            					}
            					setWithLastConsumed(
            						current,
            						"oblName",
            						lv_oblName_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getOEventAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleoEvent"


    // $ANTLR start "entryRuleOblEvent"
    // InternalSymboleo.g:3116:1: entryRuleOblEvent returns [String current=null] : iv_ruleOblEvent= ruleOblEvent EOF ;
    public final String entryRuleOblEvent() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOblEvent = null;


        try {
            // InternalSymboleo.g:3116:48: (iv_ruleOblEvent= ruleOblEvent EOF )
            // InternalSymboleo.g:3117:2: iv_ruleOblEvent= ruleOblEvent EOF
            {
             newCompositeNode(grammarAccess.getOblEventRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOblEvent=ruleOblEvent();

            state._fsp--;

             current =iv_ruleOblEvent.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOblEvent"


    // $ANTLR start "ruleOblEvent"
    // InternalSymboleo.g:3123:1: ruleOblEvent returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'oTRIGGERED' | kw= 'oACTIVATED' | kw= 'oSUSPENDED' | kw= 'oRESUMED' | kw= 'oDISCHARGED' | kw= 'oEXPIRED' | kw= 'oFULFILLED' | kw= 'oVIOLATED' | kw= 'oTERMINATED' ) ;
    public final AntlrDatatypeRuleToken ruleOblEvent() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSymboleo.g:3129:2: ( (kw= 'oTRIGGERED' | kw= 'oACTIVATED' | kw= 'oSUSPENDED' | kw= 'oRESUMED' | kw= 'oDISCHARGED' | kw= 'oEXPIRED' | kw= 'oFULFILLED' | kw= 'oVIOLATED' | kw= 'oTERMINATED' ) )
            // InternalSymboleo.g:3130:2: (kw= 'oTRIGGERED' | kw= 'oACTIVATED' | kw= 'oSUSPENDED' | kw= 'oRESUMED' | kw= 'oDISCHARGED' | kw= 'oEXPIRED' | kw= 'oFULFILLED' | kw= 'oVIOLATED' | kw= 'oTERMINATED' )
            {
            // InternalSymboleo.g:3130:2: (kw= 'oTRIGGERED' | kw= 'oACTIVATED' | kw= 'oSUSPENDED' | kw= 'oRESUMED' | kw= 'oDISCHARGED' | kw= 'oEXPIRED' | kw= 'oFULFILLED' | kw= 'oVIOLATED' | kw= 'oTERMINATED' )
            int alt41=9;
            switch ( input.LA(1) ) {
            case 82:
                {
                alt41=1;
                }
                break;
            case 83:
                {
                alt41=2;
                }
                break;
            case 84:
                {
                alt41=3;
                }
                break;
            case 85:
                {
                alt41=4;
                }
                break;
            case 86:
                {
                alt41=5;
                }
                break;
            case 87:
                {
                alt41=6;
                }
                break;
            case 88:
                {
                alt41=7;
                }
                break;
            case 89:
                {
                alt41=8;
                }
                break;
            case 90:
                {
                alt41=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // InternalSymboleo.g:3131:3: kw= 'oTRIGGERED'
                    {
                    kw=(Token)match(input,82,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOblEventAccess().getOTRIGGEREDKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:3137:3: kw= 'oACTIVATED'
                    {
                    kw=(Token)match(input,83,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOblEventAccess().getOACTIVATEDKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:3143:3: kw= 'oSUSPENDED'
                    {
                    kw=(Token)match(input,84,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOblEventAccess().getOSUSPENDEDKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalSymboleo.g:3149:3: kw= 'oRESUMED'
                    {
                    kw=(Token)match(input,85,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOblEventAccess().getORESUMEDKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalSymboleo.g:3155:3: kw= 'oDISCHARGED'
                    {
                    kw=(Token)match(input,86,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOblEventAccess().getODISCHARGEDKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalSymboleo.g:3161:3: kw= 'oEXPIRED'
                    {
                    kw=(Token)match(input,87,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOblEventAccess().getOEXPIREDKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalSymboleo.g:3167:3: kw= 'oFULFILLED'
                    {
                    kw=(Token)match(input,88,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOblEventAccess().getOFULFILLEDKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalSymboleo.g:3173:3: kw= 'oVIOLATED'
                    {
                    kw=(Token)match(input,89,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOblEventAccess().getOVIOLATEDKeyword_7());
                    		

                    }
                    break;
                case 9 :
                    // InternalSymboleo.g:3179:3: kw= 'oTERMINATED'
                    {
                    kw=(Token)match(input,90,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOblEventAccess().getOTERMINATEDKeyword_8());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOblEvent"


    // $ANTLR start "entryRulePointConst"
    // InternalSymboleo.g:3188:1: entryRulePointConst returns [EObject current=null] : iv_rulePointConst= rulePointConst EOF ;
    public final EObject entryRulePointConst() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePointConst = null;


        try {
            // InternalSymboleo.g:3188:51: (iv_rulePointConst= rulePointConst EOF )
            // InternalSymboleo.g:3189:2: iv_rulePointConst= rulePointConst EOF
            {
             newCompositeNode(grammarAccess.getPointConstRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePointConst=rulePointConst();

            state._fsp--;

             current =iv_rulePointConst; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePointConst"


    // $ANTLR start "rulePointConst"
    // InternalSymboleo.g:3195:1: rulePointConst returns [EObject current=null] : ( () ( (lv_Type_1_0= RULE_INT ) ) ) ;
    public final EObject rulePointConst() throws RecognitionException {
        EObject current = null;

        Token lv_Type_1_0=null;


        	enterRule();

        try {
            // InternalSymboleo.g:3201:2: ( ( () ( (lv_Type_1_0= RULE_INT ) ) ) )
            // InternalSymboleo.g:3202:2: ( () ( (lv_Type_1_0= RULE_INT ) ) )
            {
            // InternalSymboleo.g:3202:2: ( () ( (lv_Type_1_0= RULE_INT ) ) )
            // InternalSymboleo.g:3203:3: () ( (lv_Type_1_0= RULE_INT ) )
            {
            // InternalSymboleo.g:3203:3: ()
            // InternalSymboleo.g:3204:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPointConstAccess().getPointConstAction_0(),
            					current);
            			

            }

            // InternalSymboleo.g:3210:3: ( (lv_Type_1_0= RULE_INT ) )
            // InternalSymboleo.g:3211:4: (lv_Type_1_0= RULE_INT )
            {
            // InternalSymboleo.g:3211:4: (lv_Type_1_0= RULE_INT )
            // InternalSymboleo.g:3212:5: lv_Type_1_0= RULE_INT
            {
            lv_Type_1_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            					newLeafNode(lv_Type_1_0, grammarAccess.getPointConstAccess().getTypeINTTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPointConstRule());
            					}
            					setWithLastConsumed(
            						current,
            						"Type",
            						lv_Type_1_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePointConst"


    // $ANTLR start "entryRuleoState"
    // InternalSymboleo.g:3232:1: entryRuleoState returns [EObject current=null] : iv_ruleoState= ruleoState EOF ;
    public final EObject entryRuleoState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleoState = null;


        try {
            // InternalSymboleo.g:3232:47: (iv_ruleoState= ruleoState EOF )
            // InternalSymboleo.g:3233:2: iv_ruleoState= ruleoState EOF
            {
             newCompositeNode(grammarAccess.getOStateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleoState=ruleoState();

            state._fsp--;

             current =iv_ruleoState; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleoState"


    // $ANTLR start "ruleoState"
    // InternalSymboleo.g:3239:1: ruleoState returns [EObject current=null] : ( ( (lv_oblState_0_0= ruleOblState ) ) otherlv_1= '(' ( (lv_oblName_2_0= RULE_ID ) ) otherlv_3= ')' ) ;
    public final EObject ruleoState() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_oblName_2_0=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_oblState_0_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:3245:2: ( ( ( (lv_oblState_0_0= ruleOblState ) ) otherlv_1= '(' ( (lv_oblName_2_0= RULE_ID ) ) otherlv_3= ')' ) )
            // InternalSymboleo.g:3246:2: ( ( (lv_oblState_0_0= ruleOblState ) ) otherlv_1= '(' ( (lv_oblName_2_0= RULE_ID ) ) otherlv_3= ')' )
            {
            // InternalSymboleo.g:3246:2: ( ( (lv_oblState_0_0= ruleOblState ) ) otherlv_1= '(' ( (lv_oblName_2_0= RULE_ID ) ) otherlv_3= ')' )
            // InternalSymboleo.g:3247:3: ( (lv_oblState_0_0= ruleOblState ) ) otherlv_1= '(' ( (lv_oblName_2_0= RULE_ID ) ) otherlv_3= ')'
            {
            // InternalSymboleo.g:3247:3: ( (lv_oblState_0_0= ruleOblState ) )
            // InternalSymboleo.g:3248:4: (lv_oblState_0_0= ruleOblState )
            {
            // InternalSymboleo.g:3248:4: (lv_oblState_0_0= ruleOblState )
            // InternalSymboleo.g:3249:5: lv_oblState_0_0= ruleOblState
            {

            					newCompositeNode(grammarAccess.getOStateAccess().getOblStateOblStateParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_7);
            lv_oblState_0_0=ruleOblState();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOStateRule());
            					}
            					set(
            						current,
            						"oblState",
            						lv_oblState_0_0,
            						"org.xtext.example.symboleo.Symboleo.OblState");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getOStateAccess().getLeftParenthesisKeyword_1());
            		
            // InternalSymboleo.g:3270:3: ( (lv_oblName_2_0= RULE_ID ) )
            // InternalSymboleo.g:3271:4: (lv_oblName_2_0= RULE_ID )
            {
            // InternalSymboleo.g:3271:4: (lv_oblName_2_0= RULE_ID )
            // InternalSymboleo.g:3272:5: lv_oblName_2_0= RULE_ID
            {
            lv_oblName_2_0=(Token)match(input,RULE_ID,FOLLOW_9); 

            					newLeafNode(lv_oblName_2_0, grammarAccess.getOStateAccess().getOblNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOStateRule());
            					}
            					setWithLastConsumed(
            						current,
            						"oblName",
            						lv_oblName_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getOStateAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleoState"


    // $ANTLR start "entryRuleOblState"
    // InternalSymboleo.g:3296:1: entryRuleOblState returns [String current=null] : iv_ruleOblState= ruleOblState EOF ;
    public final String entryRuleOblState() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOblState = null;


        try {
            // InternalSymboleo.g:3296:48: (iv_ruleOblState= ruleOblState EOF )
            // InternalSymboleo.g:3297:2: iv_ruleOblState= ruleOblState EOF
            {
             newCompositeNode(grammarAccess.getOblStateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOblState=ruleOblState();

            state._fsp--;

             current =iv_ruleOblState.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOblState"


    // $ANTLR start "ruleOblState"
    // InternalSymboleo.g:3303:1: ruleOblState returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'oCREATE' | kw= 'oINEFFECT' | kw= 'oSUSPENSION' | kw= 'oSUCCESSFUL_TERMINATION' | kw= 'oUNSUCCESSFUL_TERMINATION' | kw= 'oVIOLATION' | kw= 'oFULFILLMENT' | kw= 'oDISCHARGE' ) ;
    public final AntlrDatatypeRuleToken ruleOblState() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSymboleo.g:3309:2: ( (kw= 'oCREATE' | kw= 'oINEFFECT' | kw= 'oSUSPENSION' | kw= 'oSUCCESSFUL_TERMINATION' | kw= 'oUNSUCCESSFUL_TERMINATION' | kw= 'oVIOLATION' | kw= 'oFULFILLMENT' | kw= 'oDISCHARGE' ) )
            // InternalSymboleo.g:3310:2: (kw= 'oCREATE' | kw= 'oINEFFECT' | kw= 'oSUSPENSION' | kw= 'oSUCCESSFUL_TERMINATION' | kw= 'oUNSUCCESSFUL_TERMINATION' | kw= 'oVIOLATION' | kw= 'oFULFILLMENT' | kw= 'oDISCHARGE' )
            {
            // InternalSymboleo.g:3310:2: (kw= 'oCREATE' | kw= 'oINEFFECT' | kw= 'oSUSPENSION' | kw= 'oSUCCESSFUL_TERMINATION' | kw= 'oUNSUCCESSFUL_TERMINATION' | kw= 'oVIOLATION' | kw= 'oFULFILLMENT' | kw= 'oDISCHARGE' )
            int alt42=8;
            switch ( input.LA(1) ) {
            case 91:
                {
                alt42=1;
                }
                break;
            case 92:
                {
                alt42=2;
                }
                break;
            case 93:
                {
                alt42=3;
                }
                break;
            case 94:
                {
                alt42=4;
                }
                break;
            case 95:
                {
                alt42=5;
                }
                break;
            case 96:
                {
                alt42=6;
                }
                break;
            case 97:
                {
                alt42=7;
                }
                break;
            case 98:
                {
                alt42=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }

            switch (alt42) {
                case 1 :
                    // InternalSymboleo.g:3311:3: kw= 'oCREATE'
                    {
                    kw=(Token)match(input,91,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOblStateAccess().getOCREATEKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:3317:3: kw= 'oINEFFECT'
                    {
                    kw=(Token)match(input,92,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOblStateAccess().getOINEFFECTKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:3323:3: kw= 'oSUSPENSION'
                    {
                    kw=(Token)match(input,93,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOblStateAccess().getOSUSPENSIONKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalSymboleo.g:3329:3: kw= 'oSUCCESSFUL_TERMINATION'
                    {
                    kw=(Token)match(input,94,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOblStateAccess().getOSUCCESSFUL_TERMINATIONKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalSymboleo.g:3335:3: kw= 'oUNSUCCESSFUL_TERMINATION'
                    {
                    kw=(Token)match(input,95,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOblStateAccess().getOUNSUCCESSFUL_TERMINATIONKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalSymboleo.g:3341:3: kw= 'oVIOLATION'
                    {
                    kw=(Token)match(input,96,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOblStateAccess().getOVIOLATIONKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalSymboleo.g:3347:3: kw= 'oFULFILLMENT'
                    {
                    kw=(Token)match(input,97,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOblStateAccess().getOFULFILLMENTKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalSymboleo.g:3353:3: kw= 'oDISCHARGE'
                    {
                    kw=(Token)match(input,98,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOblStateAccess().getODISCHARGEKeyword_7());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOblState"


    // $ANTLR start "entryRulecState"
    // InternalSymboleo.g:3362:1: entryRulecState returns [EObject current=null] : iv_rulecState= rulecState EOF ;
    public final EObject entryRulecState() throws RecognitionException {
        EObject current = null;

        EObject iv_rulecState = null;


        try {
            // InternalSymboleo.g:3362:47: (iv_rulecState= rulecState EOF )
            // InternalSymboleo.g:3363:2: iv_rulecState= rulecState EOF
            {
             newCompositeNode(grammarAccess.getCStateRule()); 
            pushFollow(FOLLOW_1);
            iv_rulecState=rulecState();

            state._fsp--;

             current =iv_rulecState; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulecState"


    // $ANTLR start "rulecState"
    // InternalSymboleo.g:3369:1: rulecState returns [EObject current=null] : ( ( (lv_contrState_0_0= ruleContrState ) ) otherlv_1= '(' ( (lv_contractName_2_0= RULE_ID ) ) otherlv_3= ')' ) ;
    public final EObject rulecState() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_contractName_2_0=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_contrState_0_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:3375:2: ( ( ( (lv_contrState_0_0= ruleContrState ) ) otherlv_1= '(' ( (lv_contractName_2_0= RULE_ID ) ) otherlv_3= ')' ) )
            // InternalSymboleo.g:3376:2: ( ( (lv_contrState_0_0= ruleContrState ) ) otherlv_1= '(' ( (lv_contractName_2_0= RULE_ID ) ) otherlv_3= ')' )
            {
            // InternalSymboleo.g:3376:2: ( ( (lv_contrState_0_0= ruleContrState ) ) otherlv_1= '(' ( (lv_contractName_2_0= RULE_ID ) ) otherlv_3= ')' )
            // InternalSymboleo.g:3377:3: ( (lv_contrState_0_0= ruleContrState ) ) otherlv_1= '(' ( (lv_contractName_2_0= RULE_ID ) ) otherlv_3= ')'
            {
            // InternalSymboleo.g:3377:3: ( (lv_contrState_0_0= ruleContrState ) )
            // InternalSymboleo.g:3378:4: (lv_contrState_0_0= ruleContrState )
            {
            // InternalSymboleo.g:3378:4: (lv_contrState_0_0= ruleContrState )
            // InternalSymboleo.g:3379:5: lv_contrState_0_0= ruleContrState
            {

            					newCompositeNode(grammarAccess.getCStateAccess().getContrStateContrStateParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_7);
            lv_contrState_0_0=ruleContrState();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCStateRule());
            					}
            					set(
            						current,
            						"contrState",
            						lv_contrState_0_0,
            						"org.xtext.example.symboleo.Symboleo.ContrState");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getCStateAccess().getLeftParenthesisKeyword_1());
            		
            // InternalSymboleo.g:3400:3: ( (lv_contractName_2_0= RULE_ID ) )
            // InternalSymboleo.g:3401:4: (lv_contractName_2_0= RULE_ID )
            {
            // InternalSymboleo.g:3401:4: (lv_contractName_2_0= RULE_ID )
            // InternalSymboleo.g:3402:5: lv_contractName_2_0= RULE_ID
            {
            lv_contractName_2_0=(Token)match(input,RULE_ID,FOLLOW_9); 

            					newLeafNode(lv_contractName_2_0, grammarAccess.getCStateAccess().getContractNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCStateRule());
            					}
            					setWithLastConsumed(
            						current,
            						"contractName",
            						lv_contractName_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getCStateAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulecState"


    // $ANTLR start "entryRuleContrState"
    // InternalSymboleo.g:3426:1: entryRuleContrState returns [String current=null] : iv_ruleContrState= ruleContrState EOF ;
    public final String entryRuleContrState() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleContrState = null;


        try {
            // InternalSymboleo.g:3426:50: (iv_ruleContrState= ruleContrState EOF )
            // InternalSymboleo.g:3427:2: iv_ruleContrState= ruleContrState EOF
            {
             newCompositeNode(grammarAccess.getContrStateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContrState=ruleContrState();

            state._fsp--;

             current =iv_ruleContrState.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContrState"


    // $ANTLR start "ruleContrState"
    // InternalSymboleo.g:3433:1: ruleContrState returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'cFORM' | kw= 'cINEFFECT' | kw= 'cSUSPENSION' | kw= 'cSUCCESSFUL_TERMINATION' | kw= 'cUNSECCESSFUL_TERMINATION' | kw= 'cUNASSIGN' ) ;
    public final AntlrDatatypeRuleToken ruleContrState() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSymboleo.g:3439:2: ( (kw= 'cFORM' | kw= 'cINEFFECT' | kw= 'cSUSPENSION' | kw= 'cSUCCESSFUL_TERMINATION' | kw= 'cUNSECCESSFUL_TERMINATION' | kw= 'cUNASSIGN' ) )
            // InternalSymboleo.g:3440:2: (kw= 'cFORM' | kw= 'cINEFFECT' | kw= 'cSUSPENSION' | kw= 'cSUCCESSFUL_TERMINATION' | kw= 'cUNSECCESSFUL_TERMINATION' | kw= 'cUNASSIGN' )
            {
            // InternalSymboleo.g:3440:2: (kw= 'cFORM' | kw= 'cINEFFECT' | kw= 'cSUSPENSION' | kw= 'cSUCCESSFUL_TERMINATION' | kw= 'cUNSECCESSFUL_TERMINATION' | kw= 'cUNASSIGN' )
            int alt43=6;
            switch ( input.LA(1) ) {
            case 99:
                {
                alt43=1;
                }
                break;
            case 100:
                {
                alt43=2;
                }
                break;
            case 101:
                {
                alt43=3;
                }
                break;
            case 102:
                {
                alt43=4;
                }
                break;
            case 103:
                {
                alt43=5;
                }
                break;
            case 104:
                {
                alt43=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }

            switch (alt43) {
                case 1 :
                    // InternalSymboleo.g:3441:3: kw= 'cFORM'
                    {
                    kw=(Token)match(input,99,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContrStateAccess().getCFORMKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:3447:3: kw= 'cINEFFECT'
                    {
                    kw=(Token)match(input,100,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContrStateAccess().getCINEFFECTKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:3453:3: kw= 'cSUSPENSION'
                    {
                    kw=(Token)match(input,101,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContrStateAccess().getCSUSPENSIONKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalSymboleo.g:3459:3: kw= 'cSUCCESSFUL_TERMINATION'
                    {
                    kw=(Token)match(input,102,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContrStateAccess().getCSUCCESSFUL_TERMINATIONKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalSymboleo.g:3465:3: kw= 'cUNSECCESSFUL_TERMINATION'
                    {
                    kw=(Token)match(input,103,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContrStateAccess().getCUNSECCESSFUL_TERMINATIONKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalSymboleo.g:3471:3: kw= 'cUNASSIGN'
                    {
                    kw=(Token)match(input,104,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContrStateAccess().getCUNASSIGNKeyword_5());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContrState"


    // $ANTLR start "entryRulepState"
    // InternalSymboleo.g:3480:1: entryRulepState returns [EObject current=null] : iv_rulepState= rulepState EOF ;
    public final EObject entryRulepState() throws RecognitionException {
        EObject current = null;

        EObject iv_rulepState = null;


        try {
            // InternalSymboleo.g:3480:47: (iv_rulepState= rulepState EOF )
            // InternalSymboleo.g:3481:2: iv_rulepState= rulepState EOF
            {
             newCompositeNode(grammarAccess.getPStateRule()); 
            pushFollow(FOLLOW_1);
            iv_rulepState=rulepState();

            state._fsp--;

             current =iv_rulepState; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulepState"


    // $ANTLR start "rulepState"
    // InternalSymboleo.g:3487:1: rulepState returns [EObject current=null] : ( ( (lv_powState_0_0= rulePowState ) ) otherlv_1= '(' ( (lv_powName_2_0= RULE_ID ) ) otherlv_3= ')' ) ;
    public final EObject rulepState() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_powName_2_0=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_powState_0_0 = null;



        	enterRule();

        try {
            // InternalSymboleo.g:3493:2: ( ( ( (lv_powState_0_0= rulePowState ) ) otherlv_1= '(' ( (lv_powName_2_0= RULE_ID ) ) otherlv_3= ')' ) )
            // InternalSymboleo.g:3494:2: ( ( (lv_powState_0_0= rulePowState ) ) otherlv_1= '(' ( (lv_powName_2_0= RULE_ID ) ) otherlv_3= ')' )
            {
            // InternalSymboleo.g:3494:2: ( ( (lv_powState_0_0= rulePowState ) ) otherlv_1= '(' ( (lv_powName_2_0= RULE_ID ) ) otherlv_3= ')' )
            // InternalSymboleo.g:3495:3: ( (lv_powState_0_0= rulePowState ) ) otherlv_1= '(' ( (lv_powName_2_0= RULE_ID ) ) otherlv_3= ')'
            {
            // InternalSymboleo.g:3495:3: ( (lv_powState_0_0= rulePowState ) )
            // InternalSymboleo.g:3496:4: (lv_powState_0_0= rulePowState )
            {
            // InternalSymboleo.g:3496:4: (lv_powState_0_0= rulePowState )
            // InternalSymboleo.g:3497:5: lv_powState_0_0= rulePowState
            {

            					newCompositeNode(grammarAccess.getPStateAccess().getPowStatePowStateParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_7);
            lv_powState_0_0=rulePowState();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPStateRule());
            					}
            					set(
            						current,
            						"powState",
            						lv_powState_0_0,
            						"org.xtext.example.symboleo.Symboleo.PowState");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getPStateAccess().getLeftParenthesisKeyword_1());
            		
            // InternalSymboleo.g:3518:3: ( (lv_powName_2_0= RULE_ID ) )
            // InternalSymboleo.g:3519:4: (lv_powName_2_0= RULE_ID )
            {
            // InternalSymboleo.g:3519:4: (lv_powName_2_0= RULE_ID )
            // InternalSymboleo.g:3520:5: lv_powName_2_0= RULE_ID
            {
            lv_powName_2_0=(Token)match(input,RULE_ID,FOLLOW_9); 

            					newLeafNode(lv_powName_2_0, grammarAccess.getPStateAccess().getPowNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPStateRule());
            					}
            					setWithLastConsumed(
            						current,
            						"powName",
            						lv_powName_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getPStateAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulepState"


    // $ANTLR start "entryRulePowState"
    // InternalSymboleo.g:3544:1: entryRulePowState returns [String current=null] : iv_rulePowState= rulePowState EOF ;
    public final String entryRulePowState() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePowState = null;


        try {
            // InternalSymboleo.g:3544:48: (iv_rulePowState= rulePowState EOF )
            // InternalSymboleo.g:3545:2: iv_rulePowState= rulePowState EOF
            {
             newCompositeNode(grammarAccess.getPowStateRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePowState=rulePowState();

            state._fsp--;

             current =iv_rulePowState.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePowState"


    // $ANTLR start "rulePowState"
    // InternalSymboleo.g:3551:1: rulePowState returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'pCREATE' | kw= 'pINEFFECT' | kw= 'pSUSPENSION' | kw= 'pSUCCESSFUL_TERMINATION' | kw= 'pUNSUCCESSFUL_TERMINATION' ) ;
    public final AntlrDatatypeRuleToken rulePowState() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSymboleo.g:3557:2: ( (kw= 'pCREATE' | kw= 'pINEFFECT' | kw= 'pSUSPENSION' | kw= 'pSUCCESSFUL_TERMINATION' | kw= 'pUNSUCCESSFUL_TERMINATION' ) )
            // InternalSymboleo.g:3558:2: (kw= 'pCREATE' | kw= 'pINEFFECT' | kw= 'pSUSPENSION' | kw= 'pSUCCESSFUL_TERMINATION' | kw= 'pUNSUCCESSFUL_TERMINATION' )
            {
            // InternalSymboleo.g:3558:2: (kw= 'pCREATE' | kw= 'pINEFFECT' | kw= 'pSUSPENSION' | kw= 'pSUCCESSFUL_TERMINATION' | kw= 'pUNSUCCESSFUL_TERMINATION' )
            int alt44=5;
            switch ( input.LA(1) ) {
            case 105:
                {
                alt44=1;
                }
                break;
            case 106:
                {
                alt44=2;
                }
                break;
            case 107:
                {
                alt44=3;
                }
                break;
            case 108:
                {
                alt44=4;
                }
                break;
            case 109:
                {
                alt44=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // InternalSymboleo.g:3559:3: kw= 'pCREATE'
                    {
                    kw=(Token)match(input,105,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowStateAccess().getPCREATEKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalSymboleo.g:3565:3: kw= 'pINEFFECT'
                    {
                    kw=(Token)match(input,106,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowStateAccess().getPINEFFECTKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalSymboleo.g:3571:3: kw= 'pSUSPENSION'
                    {
                    kw=(Token)match(input,107,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowStateAccess().getPSUSPENSIONKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalSymboleo.g:3577:3: kw= 'pSUCCESSFUL_TERMINATION'
                    {
                    kw=(Token)match(input,108,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowStateAccess().getPSUCCESSFUL_TERMINATIONKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalSymboleo.g:3583:3: kw= 'pUNSUCCESSFUL_TERMINATION'
                    {
                    kw=(Token)match(input,109,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowStateAccess().getPUNSUCCESSFUL_TERMINATIONKeyword_4());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePowState"

    // Delegated rules


    protected DFA18 dfa18 = new DFA18(this);
    protected DFA34 dfa34 = new DFA34(this);
    static final String dfa_1s = "\16\uffff";
    static final String dfa_2s = "\3\uffff\11\15\2\uffff";
    static final String dfa_3s = "\1\4\1\34\1\4\11\14\2\uffff";
    static final String dfa_4s = "\1\4\1\34\1\45\11\20\2\uffff";
    static final String dfa_5s = "\14\uffff\1\1\1\2";
    static final String dfa_6s = "\16\uffff}>";
    static final String[] dfa_7s = {
            "\1\1",
            "\1\2",
            "\1\3\31\uffff\1\11\1\12\1\13\1\4\1\5\1\6\1\7\1\10",
            "\1\15\3\uffff\1\14",
            "\1\15\3\uffff\1\14",
            "\1\15\3\uffff\1\14",
            "\1\15\3\uffff\1\14",
            "\1\15\3\uffff\1\14",
            "\1\15\3\uffff\1\14",
            "\1\15\3\uffff\1\14",
            "\1\15\3\uffff\1\14",
            "\1\15\3\uffff\1\14",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "()* loopback of 526:4: ( ( (lv_attributes_4_0= ruleAttribute ) ) otherlv_5= ',' )*";
        }
    }
    static final String dfa_8s = "\102\uffff";
    static final String dfa_9s = "\1\uffff\1\56\72\uffff\6\56";
    static final String dfa_10s = "\1\4\1\14\52\17\4\uffff\6\4\6\21\6\14";
    static final String dfa_11s = "\1\155\1\102\52\17\4\uffff\6\4\6\21\6\102";
    static final String dfa_12s = "\54\uffff\1\2\1\3\1\1\1\4\22\uffff";
    static final String dfa_13s = "\102\uffff}>";
    static final String[] dfa_14s = {
            "\1\1\55\uffff\1\54\1\uffff\1\55\17\uffff\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\17\1\20\1\21\1\22\1\23\1\24\1\12\1\13\1\14\1\15\1\16",
            "\1\56\3\uffff\2\56\25\uffff\1\56\2\uffff\2\56\21\uffff\6\57",
            "\1\60",
            "\1\60",
            "\1\60",
            "\1\60",
            "\1\60",
            "\1\60",
            "\1\60",
            "\1\60",
            "\1\61",
            "\1\61",
            "\1\61",
            "\1\61",
            "\1\61",
            "\1\62",
            "\1\62",
            "\1\62",
            "\1\62",
            "\1\62",
            "\1\62",
            "\1\63",
            "\1\63",
            "\1\63",
            "\1\63",
            "\1\63",
            "\1\63",
            "\1\63",
            "\1\63",
            "\1\63",
            "\1\64",
            "\1\64",
            "\1\64",
            "\1\64",
            "\1\64",
            "\1\64",
            "\1\64",
            "\1\65",
            "\1\65",
            "\1\65",
            "\1\65",
            "\1\65",
            "\1\65",
            "\1\65",
            "",
            "",
            "",
            "",
            "\1\66",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\74",
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\56\3\uffff\2\56\25\uffff\1\56\2\uffff\2\56\21\uffff\6\57",
            "\1\56\3\uffff\2\56\25\uffff\1\56\2\uffff\2\56\21\uffff\6\57",
            "\1\56\3\uffff\2\56\25\uffff\1\56\2\uffff\2\56\21\uffff\6\57",
            "\1\56\3\uffff\2\56\25\uffff\1\56\2\uffff\2\56\21\uffff\6\57",
            "\1\56\3\uffff\2\56\25\uffff\1\56\2\uffff\2\56\21\uffff\6\57",
            "\1\56\3\uffff\2\56\25\uffff\1\56\2\uffff\2\56\21\uffff\6\57"
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final short[] dfa_9 = DFA.unpackEncodedString(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final char[] dfa_11 = DFA.unpackEncodedStringToUnsignedChars(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final short[][] dfa_14 = unpackEncodedStringArray(dfa_14s);

    class DFA34 extends DFA {

        public DFA34(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 34;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "2160:2: ( ( (lv_situationName_0_0= ruleSitName ) ) | (otherlv_1= '[' ( (lv_start_2_0= rulePoint ) ) otherlv_3= ',' ( (lv_end_4_0= rulePoint ) ) otherlv_5= ']' ) | ( (lv_unnamed_6_0= 'UNNAMED_INTERVAL' ) ) | ( ( (lv_situationName_7_0= ruleSitName ) ) ( (lv_tempOp_8_0= ruleTempOp ) ) ( (lv_intConst_9_0= ruleIntConst ) ) ( (lv_unit_10_0= ruleUnit ) ) ) )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000003FC0000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000003F80010L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0003700003F00030L,0x00003FFFFFFFFFF8L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0003700003E00030L,0x00003FFFFFFFFFF8L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000003C00010L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000003800010L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000003000010L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0003700002000030L,0x00003FFFFFFFFFF8L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000003FC0000010L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0003710000000030L,0x00003FFFFFFFFFF8L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0003700000000030L,0x00003FFFFFFFFFF8L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0003720000000030L,0x00003FFFFFFFFFF8L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000010L,0x00003FFFFFFFFFF0L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000010L,0x00003FFFF8000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0014000000000010L,0x00003FFFFFFFFFF0L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000030L,0x00003FFFFFFFFFF8L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0xE000000000000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x1FE0000000000000L});

}