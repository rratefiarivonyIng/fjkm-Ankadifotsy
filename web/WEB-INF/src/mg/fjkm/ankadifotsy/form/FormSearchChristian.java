package mg.fjkm.ankadifotsy.form;

import mg.fjkm.ankadifotsy.bo.AntonAsa;
import mg.fjkm.ankadifotsy.bo.Fitandremana;

/**
 * Formulaire de recherche d'un fidèle
 * @author Rija RATEFIARIVONY
 *
 */
public class FormSearchChristian extends AbstractFormSearch{
	public static final String sfFORM_ID = "formSearchChristian";
	
	private String fLaharana = null;
	private AntonAsa fAntonAsa = null;
	private String fTalenta = null;
	private String fAnarana = null;
	private String fFanampiny = null;
	private int fMpandray = -1;		//0=Tsia	 / 1=Eny  / -1=tsy jerena 
	private int fLahy = -1;			//0=Vehivavy / 1=Lehilahy / -1=Tsy jerena
	private int fBatisa = -1;		//0=Tsy vita / 1=Vita / -1=Tsy jerena
	private Fitandremana fFitandremana = null;
	private boolean fSubmit = false;
		
	/**
	 * l'appel à la recherche est effectué depuis ?
	 */
	private String fFrom = null;
	
	public FormSearchChristian(){
	}
	
	/**
	 * @return
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#getLaharana()
	 */
	public String getLaharana() {
		return fLaharana;
	}

	/**
	 * @param laharana
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#setLaharana(java.lang.String)
	 */
	public void setLaharana(String laharana) {
		fLaharana = laharana;
	}

	/**
	 * @return
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#getAntonAsa()
	 */
	public AntonAsa getAntonAsa() {
		return fAntonAsa;
	}

	/**
	 * @param antonAsa
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#setAntonAsa(mg.fjkm.ankadifotsy.bo.AntonAsa)
	 */
	public void setAntonAsa(AntonAsa antonAsa) {
		fAntonAsa = antonAsa;
	}

	/**
	 * @return
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#getTalenta()
	 */
	public String getTalenta() {
		return fTalenta;
	}

	/**
	 * @param talenta
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#setTalenta(java.lang.String)
	 */
	public void setTalenta(String talenta) {
		fTalenta = talenta;
	}

	/**
	 * @return
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#getAnarana()
	 */
	public String getAnarana() {
		return fAnarana;
	}

	/**
	 * @return
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#getFanampiny()
	 */
	public String getFanampiny() {
		return fFanampiny;
	}

	/**
	 * @return
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#getFitandremana()
	 */
	public Fitandremana getFitandremana() {
		return fFitandremana;
	}

	//------ pour la fonction de recherche ---------
	public Boolean isLahy() {
		Boolean lehilahy = null;
		if (fLahy >= 0)
			lehilahy = fLahy == 1;
		
		return lehilahy;
	}

	public void setLahy(Boolean lahy){
		if (lahy != null){
			fLahy = lahy.booleanValue() ? 1 : 0;
		}
		else
			fLahy = -1;
	}
	
	//------------- pour jsp ----------------
	public int getLahy() {
		return fLahy;
	}

	public void setLahy(int lahy) {
		fLahy = lahy;
	}

	/**
	 * @return true si à la date du jour le Mpivavaka est déjà Mpandray
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#isMpandrayFrom(java.util.Date)
	 */
	public Boolean isMpandray() {
		Boolean mpandray = null;
		if (fMpandray >= 0)
			mpandray = fMpandray == 1;
		return mpandray;
	}

	public void setMpandray(Boolean mpandray){
		if (mpandray != null)
			fMpandray = mpandray.booleanValue() ? 1 : 0;
		else
			fMpandray = -1;
	}
		
	public int getMpandray() {
		return fMpandray;
	}

	public void setMpandray(int mpandray) {
		fMpandray = mpandray;
	}

	/**
	 * @return true si à la date du jour le Mpivavaka est déjà vita Batisa
	 */
	public Boolean isVitaBatisa() {
		Boolean vitaBatisa = null;
		if (fBatisa >= 0 )
			vitaBatisa = fBatisa == 1;
		return vitaBatisa;
	}

	public void setVitaBatisa(Boolean vitaBatisa){
		if (vitaBatisa != null){
			fBatisa = vitaBatisa.booleanValue() ? 1 : 0;
		}
		else
			fBatisa = -1;
	}
		
	//---------- pour l'affichage jsp ---------------
	public int getBatisa() {
		return fBatisa;
	}

	public void setBatisa(int batisa) {
		fBatisa = batisa;
	}
	//-----------------------------------------------
	
	/**
	 * @param anarana
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#setAnarana(java.lang.String)
	 */
	public void setAnarana(String anarana) {
		fAnarana = anarana;
	}

	/**
	 * @param fanampiny
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#setFanampiny(java.lang.String)
	 */
	public void setFanampiny(String fanampiny) {
		fFanampiny = fanampiny;
	}

	/**
	 * @param fitandremana
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#setFitandremana(mg.fjkm.ankadifotsy.bo.Fitandremana)
	 */
	public void setFitandremana(Fitandremana fitandremana) {
		fFitandremana = fitandremana;
	}

	public String getFrom() {
		return fFrom;
	}

	public void setFrom(String from) {
		fFrom = from;
	}

	public boolean isSubmit() {
		return fSubmit;
	}

	public void setSubmit(boolean submit) {
		fSubmit = submit;
	}

	@Override
	public String getFormID() {
		return sfFORM_ID;
	}
}
