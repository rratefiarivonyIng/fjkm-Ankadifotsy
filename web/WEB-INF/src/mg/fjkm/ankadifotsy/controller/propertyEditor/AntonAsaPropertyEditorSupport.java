/**
 * 
 */
package mg.fjkm.ankadifotsy.controller.propertyEditor;

import java.beans.PropertyEditorSupport;

import mg.fjkm.ankadifotsy.bo.AntonAsa;
import mg.fjkm.ankadifotsy.service.FjkmAnkadifotsyService;

/**
 * Editeur de propriété de type Activité
 * @author rija
 * @version 1.0
 */
public class AntonAsaPropertyEditorSupport extends PropertyEditorSupport {
	private FjkmAnkadifotsyService fFjkmService = null;
	
	public AntonAsaPropertyEditorSupport(FjkmAnkadifotsyService fjkmService){
		fFjkmService = fjkmService;
	}
	
	public void setAsText(String text) throws IllegalArgumentException {
		if (text!=null && !"".equals(text.trim())){
			AntonAsa antonAsa = fFjkmService.findAntonAsa(new Long(text.trim()));
			setValue(antonAsa);
		}
		else
			setValue(null);
	}
}
