package mg.fjkm.ankadifotsy.form;

import java.util.Date;

import mg.fjkm.ankadifotsy.bo.Fifidianana;
import mg.fjkm.ankadifotsy.bo.Fitandremana;
import mg.fjkm.ankadifotsy.bo.KarazamPifidianana;
import mg.fjkm.ankadifotsy.bo.TaomPanompoana;

/**
 * Formulaire de recherche d'un fifidianana
 * @author Rija RATEFIARIVONY
 *
 */
public class FormSearchVato extends AbstractFormSearch{
	public static final String sfFORM_ID = "formSearchVato";
	
	private Fifidianana fFifidianana = null;
	private String fVatoLaharana = null;
	private Boolean fLehilahy = null;
	
	/**
	 * l'appel à la recherche est effectué depuis ?
	 */
	private String fFrom = null;
	
	public FormSearchVato(){
		super();
	}
	
	public Fifidianana getFifidianana() {
		return fFifidianana;
	}

	public void setFifidianana(Fifidianana fifidianana) {
		fFifidianana = fifidianana;
	}

	public String getVatoLaharana() {
		return fVatoLaharana;
	}

	public void setVatoLaharana(String vatoLaharana) {
		fVatoLaharana = vatoLaharana;
	}

	public Boolean getLehilahy() {
		return fLehilahy;
	}

	public void setLehilahy(Boolean lehilahy) {
		fLehilahy = lehilahy;
	}

	public String getFrom() {
		return fFrom;
	}

	public void setFrom(String from) {
		fFrom = from;
	}

	public Fitandremana getFitandremana(){
		Fitandremana ret = null;
		if (fFifidianana != null)
			ret = fFifidianana.getFitandremana();
		
		return ret;
	}
	
	public KarazamPifidianana getKarazamPifidianana(){
		KarazamPifidianana ret = null;
		if (fFifidianana != null)
			ret = fFifidianana.getKarazamPifidianana();
		
		return ret;
	}
	
	public Date getDatyManakatona(){
		Date ret = null;
		if (fFifidianana != null)
			ret = fFifidianana.getDatyManakatona();
		return ret;
	}
	
	public TaomPanompoana getTaomPanompoana() {
		return fFifidianana != null ? fFifidianana.getTaomPanompoana() : null;
	}

	@Override
	public String getFormID() {
		return sfFORM_ID;
	}
}
