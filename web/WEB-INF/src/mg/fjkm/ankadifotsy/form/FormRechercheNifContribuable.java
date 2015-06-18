/**
 * 
 */
package mg.fjkm.ankadifotsy.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import mg.fjkm.ankadifotsy.bo.Mpivavaka;


/**
 * Formulaire de saisie des critères de recherche de NIF  
 * @author rija RATEFIARIVONY
 * @version 1.0
 */
public class FormRechercheNifContribuable implements Serializable {

	private static final long serialVersionUID = 4088792483549773822L;
	public static final String sfFORM_ID = "rechercheNifCommand";
	
	//Les types de recherche disponibles à positionner par Javascript lors du submit de la recherche
	public static final int sfTYPE_RECHERCHE_NIF = 1;
	public static final int sfTYPE_RECHERCHE_RAISONSOC = 2;
	public static final int sfTYPE_RECHERCHE_NOMCOM = 3;

	//Les critères de recherche : leur utilisation est exclusif 
	//La recherche se fait soit par NIF soit par raison sociale soit par nom commercial
	//mais jamais par la combinaison des 3 critères
	private Long fReference = null;		//La référence d'enregistrement de la demande (Contribuable.taxPayerNo)
	private String fNif = null;
	private String fRaisonSociale = null;
	private String fNomCommercial = null;
	private String fAdresse = null;
	private String fCin = null;
	private String fRc = null;
	
	//Le type de recherche effectué : est un champ caché et positionné par javascript lors
	//du submit de la recherche
	private int fTypeRecherche =  sfTYPE_RECHERCHE_NIF;
	
	private String fMessage = null;
	
	/**
	 * Résultat de la recherche
	 */
	private List<Mpivavaka> fResultats = new ArrayList<Mpivavaka>();
	
	public FormRechercheNifContribuable(){
	}

	public String getNif() {
		return fNif;
	}

	public void setNif(String nif) {
		fNif = nif;
	}

	public String getNomCommercial() {
		return fNomCommercial;
	}

	public void setNomCommercial(String nomCommercial) {
		fNomCommercial = nomCommercial;
	}

	public String getRaisonSociale() {
		return fRaisonSociale;
	}

	public void setRaisonSociale(String raisonSociale) {
		fRaisonSociale = raisonSociale;
	}

	public List<Mpivavaka> getResultats() {
		return fResultats;
	}

	public void setResultats(List<Mpivavaka> resultats) {
		fResultats = resultats;
	}

	public int getTypeRecherche() {
		return fTypeRecherche;
	}

	public void setTypeRecherche(int typeRecherche) {
		fTypeRecherche = typeRecherche;
	}

	public String getMessage() {
		return fMessage;
	}

	public void setMessage(String message) {
		fMessage = message;
	}

	public Long getReference() {
		return fReference;
	}

	public void setReference(Long reference) {
		fReference = reference;
	}

	public String getAdresse() {
		return fAdresse;
	}

	public void setAdresse(String adresse) {
		fAdresse = adresse;
	}

	public String getCin() {
		return fCin;
	}

	public void setCin(String cin) {
		fCin = cin;
	}

	public String getRc() {
		return fRc;
	}

	public void setRc(String rc) {
		fRc = rc;
	}	

}
