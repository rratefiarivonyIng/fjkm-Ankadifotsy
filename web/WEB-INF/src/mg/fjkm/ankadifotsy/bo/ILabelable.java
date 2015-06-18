/**
 * 
 */
package mg.fjkm.ankadifotsy.bo;

/**
 * Interface definissant une localisation géographique
 * @author rija
 * @version 1.0
 */
public interface ILabelable {

	/**
	 * Identifiant de la localisation
	 * @return
	 */
	Long getId();
	
	/**
	 * L'intitulé de la localisation
	 * @return
	 */
	String getLabel();
}
