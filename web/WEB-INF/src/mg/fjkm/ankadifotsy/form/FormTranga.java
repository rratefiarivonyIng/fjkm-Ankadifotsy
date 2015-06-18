/**
 * 
 */
package mg.fjkm.ankadifotsy.form;

import java.util.Date;

import org.apache.commons.lang.NotImplementedException;

import mg.fjkm.ankadifotsy.bo.KarazaTranga;
import mg.fjkm.ankadifotsy.bo.Mpivavaka;
import mg.fjkm.ankadifotsy.bo.Tranga;

/**
 * formulaire pour l'édition d'un Batisa et d'un Mpandray
 * @author Rija
 *
 */
public class FormTranga extends AbstractFormTranga {
	public static final String sfFORM_ID = "formTranga";

	private String fTitle = null;
	private String fLabel = null;
	private boolean fPopup = false;	//indique si la page est affichée en tant que popup et non comme un div
	
	protected FormTranga(){
		super();
	}
	
	public FormTranga(Mpivavaka mpivavaka, KarazaTranga karazaTranga){
		if (mpivavaka == null || karazaTranga == null)
			throw new IllegalArgumentException();

		setMpivavaka(mpivavaka, karazaTranga);
	}
	
	public void setMpivavaka(Mpivavaka mpivavaka, KarazaTranga karazaTranga){
		Tranga tranga = null;
		Date now = new Date();
		if (KarazaTranga.sfLONG_BATISA.equals(karazaTranga.getId())){
			if (mpivavaka.isVitaBatisa(now))
				tranga = mpivavaka.getBatisa();
		}
		else if (KarazaTranga.sfLONG_MPANDRAY.equals(karazaTranga.getId())){
			if (mpivavaka.isMpandrayFrom(now))
				tranga = mpivavaka.getMpandray();
		}
		else
			throw new NotImplementedException();
			
		if (tranga == null){
			tranga = new Tranga(mpivavaka);
			tranga.setKarazaTranga(karazaTranga);
			tranga.setDaty(now);
		}
		
		setTranga(tranga);
	}

	public String getLabel() {
		return fLabel;
	}

	public void setLabel(String label) {
		fLabel = label;
	}

	public String getTitle() {
		return fTitle;
	}

	public void setTitle(String title) {
		fTitle = title;
	}

	public boolean isPopup() {
		return fPopup;
	}

	public void setPopup(boolean popup) {
		fPopup = popup;
	}
	
}
