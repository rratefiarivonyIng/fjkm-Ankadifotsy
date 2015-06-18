/**
 * 
 */
package mg.fjkm.ankadifotsy.form;

import java.util.Date;

import mg.fjkm.ankadifotsy.bo.Fitandremana;
import mg.fjkm.ankadifotsy.bo.KarazaTranga;
import mg.fjkm.ankadifotsy.bo.Mpivavaka;
import mg.fjkm.ankadifotsy.bo.Tranga;

/**
 * Classe abstraite que doivent hériter les formulaires pour les Trangas
 * @author Rija
 *
 */
public class AbstractFormTranga {
	protected Tranga fTranga = null;

	protected AbstractFormTranga(){
		
	}
	
	public AbstractFormTranga(Tranga tranga){
		setTranga(tranga);
	}
	
	public Tranga getTranga() {
		return fTranga;
	}

	public void setTranga(Tranga tranga) {
		fTranga = tranga;
	}

	public Date getDaty() {
		return fTranga.getDaty();
	}

	public Fitandremana getFitandremana() {
		return fTranga.getFitandremana();
	}

	public String getLaharana() {
		return fTranga.getLaharana();
	}

	public void setDaty(Date daty) {
		fTranga.setDaty(daty);
	}

	public void setFitandremana(Fitandremana fitandremana) {
		fTranga.setFitandremana(fitandremana);
	}

	public void setLaharana(String laharana) {
		fTranga.setLaharana(laharana);
	}

	public KarazaTranga getKarazaTranga() {
		return fTranga.getKarazaTranga();
	}

	public Mpivavaka getMpivavaka() {
		return fTranga.getMpivavaka();
	}
		
}
