package mg.fjkm.ankadifotsy.form;

import java.util.Date;

import mg.fjkm.ankadifotsy.bo.Fifidianana;
import mg.fjkm.ankadifotsy.bo.Fitandremana;
import mg.fjkm.ankadifotsy.bo.KarazamPifidianana;
import mg.fjkm.ankadifotsy.bo.TaomPanompoana;
import mg.fjkm.ankadifotsy.bo.User;

/**
 * Formulaire d'édition d'un Fifidianana
 * @author Rija RATEFIARIVONY
 *
 */
public class FormFifidianana {
	public static final String sfFORM_ID = "formFifidianana";

	private Fifidianana fFifidianana = null;
	
	private Date fDatyFifidianana = null;
	private Date fDatyManakatona = null;
	private Date fDatyManokatra = null;
	private Date fDatyMamarana = null;
	private Date fDatyFanisambato = null;
			
	/**
	 * Indique si l'édition a été lancée depuis les résultats de recherche
	 */
	private boolean fFromSearch = false;
	
	protected FormFifidianana(){
		
	}
	
	public FormFifidianana(Fifidianana fifidianana){
		if (fifidianana == null)
			throw new IllegalArgumentException();
		
		fFifidianana = fifidianana;
		
		setFifidianana2DateFields();
	}

	/**
	 * Rafraîchit les dates depuis le fifidianana
	 */
	private void setFifidianana2DateFields(){
		fDatyFanisambato = fFifidianana.getDatyFanisambato();
		fDatyFifidianana = fFifidianana.getDatyFifidianana();
		fDatyMamarana = fFifidianana.getDatyMamaranaFirotsahana();
		fDatyManakatona = fFifidianana.getDatyManakatona();
		fDatyManokatra = fFifidianana.getDatyManombokaFirotsahana();
	}
	
	/**
	 * Récupère les dates depuis le formulaire
	 */
	private void getDateFields(){
		fFifidianana.setDatyManombokaFirotsahana_(fDatyManokatra);
		fFifidianana.setDatyMamaranaFirotsahana_(fDatyMamarana);
		fFifidianana.setDatyFanisambato_(fDatyFanisambato);
		fFifidianana.setDatyFifidianana_(fDatyFifidianana);
		fFifidianana.setDatyManakatona_(fDatyManakatona);
	}
	
	public Fifidianana getFifidianana() {
		getDateFields();
		return fFifidianana;
	}

	public void setFifidianana(Fifidianana fifidianana) {
		fFifidianana = fifidianana;
	}

	public Date getDateCreation() {
		return fFifidianana.getDateCreation();
	}

	public Date getDateLastModification() {
		return fFifidianana.getDateLastModification();
	}

	public Date getDatyFanisambato() {
		return fDatyFanisambato;
	}

	public Date getDatyFifidianana() {
		return fDatyFifidianana;
	}

	public Date getDatyMamaranaFirotsahana() {
		return fDatyMamarana;
	}

	public void setDatyMamaranaFirotsahana(Date daty) {
		fDatyMamarana = daty;
	}

	public Date getDatyManakatona() {
		return fDatyManakatona;
	}

	public Date getDatyManombokaFirotsahana() {
		return fDatyManokatra;
	}

	public void setDatyManombokaFirotsahana(Date daty) {
		fDatyManokatra = daty;
	}

	public Fitandremana getFitandremana() {
		return fFifidianana.getFitandremana();
	}

	public KarazamPifidianana getKarazamPifidianana() {
		return fFifidianana.getKarazamPifidianana();
	}

	public String getLabel() {
		return fFifidianana.getLabel();
	}

	public TaomPanompoana getTaomPanompoana() {
		return fFifidianana.getTaomPanompoana();
	}

	public User getUserCreator() {
		return fFifidianana.getUserCreator();
	}

	public User getUserLastModification() {
		return fFifidianana.getUserLastModification();
	}

	public boolean isMikatona(Date daty) {
		return fFifidianana.isMikatona(daty);
	}

	public boolean isMitohyLaharana() {
		return fFifidianana.isMitohyLaharana();
	}

	public void setCreateInfo(Date date, User creator) {
		fFifidianana.setCreateInfo(date, creator);
	}

	public void setDatyFanisambato_(Date daty) {
		fDatyFanisambato = daty;
	}

	public void setDatyFifidianana(Date daty) {
		fDatyFifidianana = daty;
	}

	public void setDatyManakatona(Date daty) {
		fDatyManakatona = daty;
	}

	public void setFitandremana(Fitandremana fitandremana) {
		fFifidianana.setFitandremana(fitandremana);
	}

	public void setKarazamPifidianana(KarazamPifidianana karazamPifidianana) {
		fFifidianana.setKarazamPifidianana(karazamPifidianana);
	}

	public void setLabel(String label) {
		fFifidianana.setLabel(label);
	}

	public void setMitohyLaharana(boolean mitohy) {
		fFifidianana.setMitohyLaharana(mitohy);
	}

	public void setTaomPanompoana(TaomPanompoana taomPanompoana) {
		fFifidianana.setTaomPanompoana(taomPanompoana);
	}

	public boolean isFromSearch() {
		return fFromSearch;
	}

	public void setFromSearch(boolean fromSearch) {
		fFromSearch = fromSearch;
	}

	public Integer getIsaOlonaFidiana() {
		return fFifidianana.getIsaOlonaFidiana();
	}

	public boolean isFifidiananaOloTokana() {
		return fFifidianana.isFifidiananaOloTokana();
	}

	public Integer getIsan_Nomerao() {
		return fFifidianana.getIsan_Nomerao();
	}

	public void setIsan_Nomerao(Integer isan_Nomerao) {
		fFifidianana.setIsan_Nomerao(isan_Nomerao);
	}

	public void setFifidiananaOloTokana(boolean fifidiananaOloTokana) {
		fFifidianana.setFifidiananaOloTokana(fifidiananaOloTokana);
	}

	public void setIsaOlonaFidiana(Integer isaOlonaFidiana) {
		fFifidianana.setIsaOlonaFidiana(isaOlonaFidiana);
	}

	public boolean isManomboka() {
		return fFifidianana.isManomboka();
	}

	public void setManomboka(boolean manomboka) {
		fFifidianana.setManomboka(manomboka);
	}

	public Long getId() {
		return fFifidianana.getId();
	}
	
}
