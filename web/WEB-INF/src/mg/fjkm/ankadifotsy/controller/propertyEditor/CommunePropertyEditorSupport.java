/**
 * 
 */
package mg.fjkm.ankadifotsy.controller.propertyEditor;

import java.beans.PropertyEditorSupport;

import mg.fjkm.ankadifotsy.bo.Firaisana;
import mg.fjkm.ankadifotsy.service.FjkmAnkadifotsyService;

/**
 * Editeur de propriété de type Commune
 * @author rija
 * @version 1.0
 */
public class CommunePropertyEditorSupport extends PropertyEditorSupport {
	private FjkmAnkadifotsyService fNifService = null;
	
	public CommunePropertyEditorSupport(FjkmAnkadifotsyService nifService){
		fNifService = nifService;
	}
	
	public void setAsText(String text) throws IllegalArgumentException {
		if (text!=null && !"".equals(text.trim())){
			Firaisana commune = fNifService.findCommune(new Long(text.trim()));
			setValue(commune);
		}
		else
			setValue((Firaisana)null);
	}
}
