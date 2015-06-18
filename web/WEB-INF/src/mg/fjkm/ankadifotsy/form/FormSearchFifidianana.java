package mg.fjkm.ankadifotsy.form;

import java.util.Date;

import mg.fjkm.ankadifotsy.bo.Fitandremana;
import mg.fjkm.ankadifotsy.bo.KarazamPifidianana;
import mg.fjkm.ankadifotsy.bo.TaomPanompoana;

/**
 * Formulaire de recherche d'un fifidianana
 * @author Rija RATEFIARIVONY
 *
 */
public class FormSearchFifidianana extends AbstractFormSearch{
	public static final String sfFORM_ID = "formSearchFifidianana";
	
	private KarazamPifidianana fKarazamPifidianana = null;
	private TaomPanompoana fTaomPanompoana = null;
	private Fitandremana fFitandremana = null;
	private Date fDatyManakatona = null;
	
	/**
	 * l'appel à la recherche est effectué depuis ?
	 */
	private String fFrom = null;
	
	public FormSearchFifidianana(){
		super();
	}
	

	public Date getDatyManakatona() {
		return fDatyManakatona;
	}


	public void setDatyManakatona(Date datyManakatona) {
		fDatyManakatona = datyManakatona;
	}


	public KarazamPifidianana getKarazamPifidianana() {
		return fKarazamPifidianana;
	}


	public void setKarazamPifidianana(KarazamPifidianana karazamPifidianana) {
		fKarazamPifidianana = karazamPifidianana;
	}


	public TaomPanompoana getTaomPanompoana() {
		return fTaomPanompoana;
	}

	public void setTaomPanompoana(TaomPanompoana taomPanompoana) {
		fTaomPanompoana = taomPanompoana;
	}


	public Fitandremana getFitandremana() {
		return fFitandremana;
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


	@Override
	public String getFormID() {
		return sfFORM_ID;
	}
}
