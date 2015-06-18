package mg.fjkm.ankadifotsy.form;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import mg.fjkm.ankadifotsy.bo.AntonAsa;
import mg.fjkm.ankadifotsy.bo.Fanambadiana;
import mg.fjkm.ankadifotsy.bo.Faritra;
import mg.fjkm.ankadifotsy.bo.Firaisana;
import mg.fjkm.ankadifotsy.bo.Fitandremana;
import mg.fjkm.ankadifotsy.bo.Mpivavaka;
import mg.fjkm.ankadifotsy.bo.Tranga;
import mg.fjkm.ankadifotsy.util.Utils;

/**
 * Formulaire de saisi d'un fidèle
 * @author Rija RATEFIARIVONY
 *
 */
public class FormChristian {
	public static final String sfFORM_ID = "formChristian";

	private Mpivavaka fMpivavaka = null;
	
	//Pour les informations sur le vady
	private Mpivavaka fVady = null;
	private String fAnaranaVady = null;
	private Date fDatyFanambadiana = null;
	private Fitandremana fFitandremanaFanambadiana = null;
	
	/**
	 * L'ancien nom de le cas de modification d'un Mpivavaka déjà existant afin de pouvoir mettre à jour le nom de la photo associée
	 */
	private String fOldName = null;
	
	/**
	 * Indique si l'édition a été lancée depuis les résultats de recherche
	 */
	private boolean fFromSearch = false;
	
	protected FormChristian(){
		
	}
	
	public FormChristian(Mpivavaka mpivavaka){
		setMpivavaka(mpivavaka);
	}

	public void setMpivavaka(Mpivavaka mpivavaka){
		fMpivavaka = mpivavaka;
		if (mpivavaka != null){
			fOldName = mpivavaka.getAnarana();
			Fanambadiana fanambadiana = fMpivavaka.getFanambadiana();
			if (fanambadiana != null){
				fVady = fanambadiana.getVady(fMpivavaka);
				if (fVady != null)
					fAnaranaVady = fVady.getAnarana()+" "+fVady.getFanampiny();
				else
					fAnaranaVady = fanambadiana.getAnaranaVady_();
				
				fDatyFanambadiana = fanambadiana.getDatyFanamasinana();
				fFitandremanaFanambadiana = fanambadiana.getFitandremana();
			}
		}
	}
	
	/**
	 * 
	 * @return ancien anarana du Mpivavaka avant sa modification éventuelle par l'utilisateur depuis la vue
	 */
	public String getOldName(){
		return fOldName;
	}
	
	public Mpivavaka getMpivavaka(){
		return fMpivavaka;
	}
	
	public boolean isFromSearch() {
		return fFromSearch;
	}

	public void setFromSearch(boolean fromSearch) {
		fFromSearch = fromSearch;
	}

	/**
	 * @return
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#getMailaka()
	 */
	public String getMailaka() {
		return fMpivavaka.getMailaka();
	}

	/**
	 * @param mailaka
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#setMailaka(java.lang.String)
	 */
	public void setMailaka(String mailaka) {
		fMpivavaka.setMailaka(mailaka);
	}

	/**
	 * @return
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#getTel()
	 */
	public String getTel() {
		return fMpivavaka.getTel();
	}

	/**
	 * @param tel
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#setTel(java.lang.String)
	 */
	public void setTel(String tel) {
		fMpivavaka.setTel(tel);
	}

	/**
	 * @return
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#getLaharana()
	 */
	public String getLaharana() {
		return fMpivavaka.getLaharana();
	}

	/**
	 * @param laharana
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#setLaharana(java.lang.String)
	 */
	public void setLaharana(String laharana) {
		fMpivavaka.setLaharana(laharana);
	}

	/**
	 * @return
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#getDatyCIN()
	 */
	public Date getDatyCIN() {
		return fMpivavaka.getDatyCIN();
	}

	/**
	 * @return
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#getDatyNanoloinaCIN()
	 */
	public Date getDatyNanoloinaCIN() {
		return fMpivavaka.getDatyNanoloinaCIN();
	}

	/**
	 * @return
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#getLaharanaCIN()
	 */
	public String getLaharanaCIN() {
		return fMpivavaka.getLaharanaCIN();
	}

	/**
	 * @return
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#getTaoCIN()
	 */
	public Firaisana getTaoCIN() {
		return fMpivavaka.getTaoCIN();
	}

	/**
	 * @return
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#getTaoNanoloinaCIN()
	 */
	public Firaisana getTaoNanoloinaCIN() {
		return fMpivavaka.getTaoNanoloinaCIN();
	}

	/**
	 * @return
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#getAntonAsa()
	 */
	public AntonAsa getAntonAsa() {
		return fMpivavaka.getAntonAsa();
	}

	public Tranga getBatisa() {
		return fMpivavaka.getBatisa();
	}

	public Tranga getMpandray() {
		return fMpivavaka.getMpandray();
	}

	/**
	 * @param antonAsa
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#setAntonAsa(mg.fjkm.ankadifotsy.bo.AntonAsa)
	 */
	public void setAntonAsa(AntonAsa antonAsa) {
		fMpivavaka.setAntonAsa(antonAsa);
	}

	/**
	 * @param datyCIN
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#setDatyCIN(java.util.Date)
	 */
	public void setDatyCIN(Date datyCIN) {
		fMpivavaka.setDatyCIN(datyCIN);
	}

	/**
	 * @param datyNanoloinaCIN
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#setDatyNanoloinaCIN(java.util.Date)
	 */
	public void setDatyNanoloinaCIN(Date datyNanoloinaCIN) {
		fMpivavaka.setDatyNanoloinaCIN(datyNanoloinaCIN);
	}

	/**
	 * @param laharanaCIN
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#setLaharanaCIN(java.lang.String)
	 */
	public void setLaharanaCIN(String laharanaCIN) {
		fMpivavaka.setLaharanaCIN(laharanaCIN);
	}

	/**
	 * @return
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#getTalenta()
	 */
	public String getTalenta() {
		return fMpivavaka.getTalenta();
	}

	/**
	 * @param talenta
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#setTalenta(java.lang.String)
	 */
	public void setTalenta(String talenta) {
		fMpivavaka.setTalenta(talenta);
	}

	/**
	 * @param taoCIN
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#setTaoCIN(mg.fjkm.ankadifotsy.bo.Firaisana)
	 */
	public void setTaoCIN(Firaisana taoCIN) {
		fMpivavaka.setTaoCIN(taoCIN);
	}

	/**
	 * @param taoNanoloinaCIN
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#setTaoNanoloinaCIN(mg.fjkm.ankadifotsy.bo.Firaisana)
	 */
	public void setTaoNanoloinaCIN(Firaisana taoNanoloinaCIN) {
		fMpivavaka.setTaoNanoloinaCIN(taoNanoloinaCIN);
	}

	/**
	 * @return
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#getAdresse()
	 */
	public String getAdresse() {
		return fMpivavaka.getAdresse();
	}

	/**
	 * @return
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#getFaritra()
	 */
	public Faritra getFaritra() {
		return fMpivavaka.getFaritra();
	}

	/**
	 * @return
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#getFiraisana()
	 */
	public Firaisana getFiraisana() {
		return fMpivavaka.getFiraisana();
	}

	/**
	 * @param faritra
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#setFaritra(mg.fjkm.ankadifotsy.bo.Faritra)
	 */
	public void setFaritra(Faritra faritra) {
		fMpivavaka.setFaritra(faritra);
	}

	/**
	 * @param firaisana
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#setFiraisana(mg.fjkm.ankadifotsy.bo.Firaisana)
	 */
	public void setFiraisana(Firaisana firaisana) {
		fMpivavaka.setFiraisana(firaisana);
	}

	/**
	 * @return
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#getAnarana()
	 */
	public String getAnarana() {
		return fMpivavaka.getAnarana();
	}

	/**
	 * @return
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#getDatyTeraka()
	 */
	public Date getDatyTeraka() {
		return fMpivavaka.getDatyTeraka();
	}

	/**
	 * @return
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#getFanampiny()
	 */
	public String getFanampiny() {
		return fMpivavaka.getFanampiny();
	}

	/**
	 * @return
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#getFitandremana()
	 */
	public Fitandremana getFitandremana() {
		return fMpivavaka.getFitandremana();
	}

	public Fitandremana getFitandremanaNiaviana() {
		return fMpivavaka.getFitandremanaNiaviana();
	}

	public void setFitandremanaNiaviana(Fitandremana fitandremanaNiaviana) {
		fMpivavaka.setFitandremanaNiaviana(fitandremanaNiaviana);
	}

	/**
	 * @return
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#getId()
	 */
	public Long getId() {
		return fMpivavaka.getId();
	}

	/**
	 * @return
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#getRay()
	 */
	public String getMpivavakaRayAnarana() {
		return fMpivavaka.getRay();
	}

	/**
	 * @return
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#getReny()
	 */
	public String getMpivavakaRenyAnarana() {
		return fMpivavaka.getReny();
	}

	public Mpivavaka getRay_() {
		return fMpivavaka.getRay_();
	}

	public Mpivavaka getReny_() {
		return fMpivavaka.getReny_();
	}

	public void setRay_(Mpivavaka ray_) {
		fMpivavaka.setRay_(ray_);
	}

	public void setReny_(Mpivavaka reny_) {
		fMpivavaka.setReny_(reny_);
	}

	/**
	 * @return
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#getToeranaTeraka()
	 */
	public String getToeranaTeraka() {
		return fMpivavaka.getToeranaTeraka();
	}

	/**
	 * @return
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#isLahy()
	 */
	public boolean isLahy() {
		return fMpivavaka.isLahy();
	}

	/**
	 * @return true si à la date du jour le Mpivavaka est déjà Mpandray
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#isMpandrayFrom(java.util.Date)
	 */
	public boolean isMpandray() {
		return fMpivavaka.isMpandrayFrom(new Date());
	}

	/**
	 * @return true si à la date du jour le Mpivavaka est déjà vita Batisa
	 */
	public boolean isVitaBatisa() {
		return fMpivavaka.isVitaBatisa(new Date());
	}

	/**
	 * @param adresse
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#setAdresse(java.lang.String)
	 */
	public void setAdresse(String adresse) {
		fMpivavaka.setAdresse(adresse);
	}

	/**
	 * @param anarana
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#setAnarana(java.lang.String)
	 */
	public void setAnarana(String anarana) {
		fMpivavaka.setAnarana(anarana);
	}

	/**
	 * @param datyTeraka
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#setDatyTeraka(java.util.Date)
	 */
	public void setDatyTeraka(Date datyTeraka) {
		fMpivavaka.setDatyTeraka(datyTeraka);
	}

	/**
	 * @param fanampiny
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#setFanampiny(java.lang.String)
	 */
	public void setFanampiny(String fanampiny) {
		fMpivavaka.setFanampiny(fanampiny);
	}

	/**
	 * @param fitandremana
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#setFitandremana(mg.fjkm.ankadifotsy.bo.Fitandremana)
	 */
	public void setFitandremana(Fitandremana fitandremana) {
		fMpivavaka.setFitandremana(fitandremana);
	}

	/**
	 * @param id
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#setId(java.lang.Integer)
	 */
	public void setId(Long id) {
		fMpivavaka.setId(id);
	}

	/**
	 * @param lahy
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#setLahy(boolean)
	 */
	public void setLahy(boolean lahy) {
		fMpivavaka.setLahy(lahy);
	}

	/**
	 * @param ray
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#setRay(java.lang.String)
	 */
	public void setMpivavakaRayAnarana(String ray) {
		fMpivavaka.setRay(ray);
	}

	/**
	 * @param reny
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#setReny(java.lang.String)
	 */
	public void setMpivavakaRenyAnarana(String reny) {
		fMpivavaka.setReny(reny);
	}

	/**
	 * @param toeranaTeraka
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#setToeranaTeraka(java.lang.String)
	 */
	public void setToeranaTeraka(String toeranaTeraka) {
		fMpivavaka.setToeranaTeraka(toeranaTeraka);
	}

	public Mpivavaka getVady(){
		return fVady;
	}
	
	public void setVady(Mpivavaka vady){
		fVady = vady;
	}
	
	/**
	 * @return
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#getAnaranaVady()
	 */
	public String getMpivavakaAnaranaVady() {
		return fAnaranaVady;
	}

	/**
	 * @param vady
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#setAnaranaVady(java.lang.String)
	 */
	public void setMpivavakaAnaranaVady(String anaranaVady) {
		fAnaranaVady = anaranaVady;
	}
	
	public Date getDatyFanambadiana(){	
		return fDatyFanambadiana;
	}
	
	public void setDatyFanambadiana(Date daty){
		fDatyFanambadiana = daty;
	}
	
	public Fitandremana getFitandremanaFanambadiana(){
		return fFitandremanaFanambadiana;
	}
	
	public void setFitandremanaFanambadiana(Fitandremana fitandremana){
		fFitandremanaFanambadiana = fitandremana;
	}
	
	public String getPhotoName(HttpServletRequest req){
		String ret = Utils.getPhotoName(req, fMpivavaka);

		return ret;
	}
}
