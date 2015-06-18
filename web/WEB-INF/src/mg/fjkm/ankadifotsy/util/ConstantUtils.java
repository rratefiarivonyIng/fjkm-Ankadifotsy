package mg.fjkm.ankadifotsy.util;

/**
 * Classe servant à stocker les constantes utilisées dans IntraPoste
 * @author rija
 * @version 1.0
 */
public class ConstantUtils {
	//Accès au mpivavaka en cours d'édition depuis la session
	public static final String sfSESSION_MPIVAVAKA = "_SESS_MPIVAVAKA_";
	public static final String sfSESSION_FIFIDIANANA = "_SESS_FIFIDIANANA_";
	public static final String sfSESSION_MANISAVATO = "_SESS_MANISAVATO_";
	public static final String sfSESSION_MANISAVATO_LAHARANA = "_SESS_MANISAVATO_LAHARANA_";
	public static final String sfSESSION_OBJECT = "_SESS_OBJECT_";

	public static final String sfREQUEST_FIFIDIANANA = "_REQ_FIFIDIANANA_";
	public static final String sfREQUEST_AFAKA_MANISA_VATO = "_REQ_AFAKA_MANISA_VATO_";
	public static final String sfREQUEST_NAHAZO_LAHARANA	 = "_REQ_NAHAZO_LAHARANA_";

	//édition de tranga de type : batisa / mpandray / fanambadiana
	public static final String sfTRANGA_BATISA = "Batisa";
	public static final String sfTRANGA_MPANDRAY = "Mpandray";
	public static final String sfTRANGA_FANAMBADIANA = "Fanambadiana";
	
	//Accès aux onglets
	public static final String sfAccessMpivavaka = "mpivavaka";
	public static final String sfAccessMpandray = "mpandray";
	public static final String sfAccessSampana = "sampana";
	public static final String sfAccessDiakona= "diakona";
	public static final String sfAccessFifidianana= "fifidianana";
	public static final String sfAccessAdmin = "administration";
	public static final String sfParameterMivoakaFifidianana = "mivoakaFifidianana";
	
	public static final String sfMode = "_MODE_";	//Mode d'ouverture de la vue
	public static final String sfLaharana = "laharana";	//Paramètre laharan'ny mpivavaka
	public static final String sfId = "id";	//Paramètre id ny mpivavaka
	public static final String sfMirotsakaFidianaId = "mirotsakaFidianaId";	//Paramètre id ny mirotsakaFidiana (candidature)
	public static final String sfFifidiananaId = "fifidiananaId";	//Paramètre id ny fifidianana

	public static final String sfSelectedTab = "_SELECTED_TAB_";	//Le nom de l'onglet sélectionné
	
	//paramètres pour la liste des mirotsakaFidiana (candidatures)
	public static final String sfParamMirotsakaFidianaRehetra = "mirotsakaFidianaRehetra";
	public static final String sfParamMirotsakaFidianaNekena = "mirotsakaFidianaNekena";
	
	//gestion des chemins des photos
	public static final String sfPhotosRootPath ="photos/";
	public static final String sfPhotosDefaultBoy ="saryLehilahy";
	public static final String sfPhotosDefaultGirl ="saryVehivavy";
	public static final String sfPhotosJpegSuffix =".jpg";
	
	public static final String sfSaveableEntity = "_SAVEABLEENTITY_";

	public static final String sfCurrentPage = "_CURRENT_PAGE_";
	
	//Critères de recherche
	public static final String sfCriteriaLaharana = "_CRIT_LAHARANA_";
	public static final String sfCriteriaAnarana = "_CRIT_ANARANA_";
	public static final String sfCriteriaFanampiny = "_CRIT_FANAMPINY_";
	public static final String sfCriteriaFitandremana = "_CRIT_FITANDREMANA_";
	public static final String sfCriteriaLahy = "_CRIT_LAHY_";
	public static final String sfCriteriaMpandray = "_CRIT_MPANDRAY_";
	public static final String sfCriteriaVitaBatisa = "_CRIT_BATISA_";
	public static final String sfCriteriaAntonAsa = "_CRIT_ANTONASA_";
	public static final String sfCriteriaTalenta = "_CRIT_TALENTA_";
	public static final String sfCriteriaKarazampifidianana = "_CRIT_KARAZAMPIFIDIANANA_";
	public static final String sfCriteriaTaomPanompoana = "_CRIT_TAOMPANOMPOANA_";
	public static final String sfCriteriaDatyManakatona = "_CRIT_DATYMANAKATONA_";	

	//Message dans les boîtes de dialogue
	public static final String sfMessageExist = "_MESSAGE_EXIST_";	//un message à afficher ?
	public static final String sfMessageEnregistrementOK = "_ENREGISTREMENT_OK_";	//Opération réussie
	public static final String sfMessageEnregistrementKO = "_ENREGISTREMENT_KO_";	//Opération échouée
	public static final String sfMessageContent = "_MESSAGE_CONTENT_";	//Le contenu du message à afficher dans une BD modale
	public static final String sfFormulaireInit = "_FORMULAIRE_INIT_";	//ré-initialisation ou non des formilaires de recherche
	public static final String sfMessageAttributionNumero = "_ATTR_LAHARANA__";	//Message pour l'Attribution laharana Mirotsaka OK

	public static final String sfDATA_TEMP_RESULT = "_VOKATRA_VONJY_MAIKA_";
	
	/**
	 * Nombre de ligne pour l'affichage de résultats de vote temporaire afficchés par Ajax dans la fiche de saisi des bulletins de vote 
	 * (cf VokatraTapatapanyController.java et vokatraVonjyMaika.jsp et manisaVato.jsp
	 */
	public static final String sfTEMP_RESULT_NBLINES = "_TEMP_RESULT_VOTE_NBLINES_";

	public static final String sfDATA_VALINY_FIFIDIANANA = "_RESULT_VOTE_";
	public static final String sfDATA_VALINY_FIFIDIANANA_VEHIVAVY = "_RESULT_VOTE_VEHIVAVY_";
	public static final String sfDATA_VALINY_FIFIDIANANA_LEHILAHY = "_RESULT_VOTE_LEHILAHY_";
	
	/**
	 * La liste des communes
	 */
	public static final String sfDATA_COMMUNES = "_COMMUNES_";
		
	/**
	 * les Fitandremanas
	 */
	public static final String sfDATA_FITANDREMANAS = "_FITANDREMANA_";

	/**
	 * les Taom-panompoana
	 */
	public static final String sfDATA_TAOMPANOMPOANAS = "_TAOMPANOMPOANA_";

	/**
	 * liste de Mpivavaka
	 */
	public static final String sfDATA_MPIVAVAKAS = "_MPIVAVAKAS_";

	/**
	 * liste de MirotsakaFidiana sous forme de Map<String, Object>
	 */
	public static final String sfDATA_MIROTSAKAFIDIANAS = "_MIROTSAKA_FIDIANA_";

	/**
	 * liste de fifidianana
	 */
	public static final String sfDATA_FIFIDIANANAS = "_FIFIDIANANAS_";

	public static final String sfDATA_FANISAMBATO = "_FANISAMBATO_";
	public static final String sfDATA_FANISAMBATO_LEHILAHY = "_FANISAMBATO_LEHILAHY_";
	public static final String sfDATA_FANISAMBATO_VEHIVAVY = "_FANISAMBATO_VEHIVAVY_";

	//Gestion de pagination des résultats de recherche
	//public static final String sfDATA_NBPAGE_MAX = "_NBPAGE_MAX_";
	public static final String sfDATA_SEARCHFORM = "_PAGE_SEARCHFORM_";
	public static final String sfDATA_PAGE_PREV = "_PAGE_PREV_";
	public static final String sfDATA_PAGE_NEXT = "_PAGE_NEXT_";
	public static final String sfDATA_PAGE_NO = "_PAGE_NO_";
	
	/**
	 * La région sélectionnée
	 */
	public static final String sfDATA_REGION = "_REGION_";

	public static final String sfDATA_FARITRAS = "_FARITRAS_";
	
	//résultat de recherche déclenché depuis l'un des onglets suivant
	public static final String sfFromDiakona = "diakona";
	public static final String sfFromFifidianana = "fifidianana";
	public static final String sfFromSampana = "sampana";
	public static final String sfFromMpandray = "mpandray";
	public static final String sfFromMpivavaka = "mpivavaka";

	//Information sur les mpivavaka qui ont déjà enregistrés leur candidature
	public static final String sfInfoMirotsakaFidiana = "_MPIVAVAKA_MIROTSAKA_FIDIANA_";
	
	//fiche actionnée depuis les résultats d'une recherche
	public static final String sfEditedFromSearch = "fromSearch";

	//fiche actionnée depuis la modification par l'administrateur d'un bulletin de vote
	public static final String sfEditedFromAdmin = "fromAdmin";

	public static final String sfReload = "reload";
	
	/**
	 * Le département sélectionné
	 */
	public static final String sfDATA_DEPARTEMENT = "_DEPARTEMENT_";

	/*
	 * Le nom des paramètres utilisés pour Ajax
	 */
	public static final String sfAJAX_FARITRA = "_AJAX_FARITRA_";
	public static final String sfAJAX_DISTRICT = "_AJAX_DISTRICT_";
	public static final String sfAJAX_COMMUNE = "_AJAX_COMMUNE_";
	public static final String sfAJAX_ANTONASA = "_AJAX_ACTIVITE_";
	public static final String sfAJAX_MPIVAVAKA = "_AJAX_MPIVAVAKA_";
	public static final String sfAJAX_EXCLU_MPIVAVAKA = "_AJAX_EXCLU_MPIVAVAKA_";
	public static final String sfAJAX_LABEL = "_AJAX_LABEL_";
	public static final String sfAJAX_MPIVAVAKA_LEHILAHY = "_AJAX_MPIVAVAKA_LEHILAHY_";
	public static final String sfAJAX_EXCLU_MPIVAVAKA_LEHILAHY = "_AJAX_EXCLU_MPIVAVAKA_LEHILAHY_";
	public static final String sfAJAX_TAONA = "_AJAX_TAONA_";
	
	public static final String sfAJAX_IDCOMMUNE = "_AJAX_IDCOMMUNE_";
	public static final String sfAJAX_IDDISTRICT = "_AJAX_IDDISTRICT_";
	public static final String sfAJAX_IDFIRAISANA = "_AJAX_IDFIRAISANA_";
	public static final String sfAJAX_IDREGION = "_AJAX_IDREGION_";
	
	/*
	 * Les variables de type session
	 */
	public static final String sfSESSION_PARAMETER = "_SESSION_PARAMETER_";

	/**
	 * Message de résultat de recherche dans l'annuaire
	 */
	public static final String sfMESSAGE_AUCUNFILTRE = "Vous devez spécifier un critère pour la recherche.";
	public static final String sfMESSAGE_AUCUNRESULTAT = "Le critère ne correspond à aucun résultat.";
	public static final String sfMESSAGE_SPECIFIERNIF = "Veuillez entrer le NIF suivant le format spécifié.";
	public static final String sfMESSAGE_AUCUNCONTRIBUABLE = "Le NIF ne correspond à aucun contribuable.";
	
	/**
	 * Données d'impression csv suivant les résultats de la recherche dans l'annuaire
	 */
	public static final String sfCSV_DATA = "_CSV_DATA_";
	public static final String sfCSV_TITLE = "title";
	
	/**
	 * Le seuil de sécurité utilisé pour la comparaison de la distance entre 2 contribuables
	 */
	public static final float sfSEUIL_DOUBLON = 0.3f;
	
	//Les pondérations utilisées pour le calcul de la distance entre 2 contribuables
	public static final float sfPONDERATION_RAISONSOCIALE = 0.125f;
	public static final float sfPONDERATION_NOM = 0.125f;
	public static final float sfPONDERATION_ADRESSE = 0.125f;
	public static final float sfPONDERATION_CIN = 0.25f;
	public static final float sfPONDERATION_REGISTRE_COMMERCE = 0.25f;
	
	//Le nom des paramètres utilisés lors de la recherche de doublon
	public static final String sfPARAM_FROM = "from";
	public static final String sfPARAM_NOMCOMMERCIAL = "_PARAM_NOM_COMMERCIAL_";
	public static final String sfPARAM_ADRESSE = "_PARAM_ADRESSE_";
	public static final String sfPARAM_CIN = "_PARAM_CIN_";
	public static final String sfPARAM_REGISTRECOMMERCE = "_PARAM_RC_";
}
