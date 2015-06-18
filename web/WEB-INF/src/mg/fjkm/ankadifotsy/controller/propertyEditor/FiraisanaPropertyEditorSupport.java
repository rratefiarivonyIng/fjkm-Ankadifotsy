/**
 * 
 */
package mg.fjkm.ankadifotsy.controller.propertyEditor;

import java.beans.PropertyEditorSupport;

import mg.fjkm.ankadifotsy.bo.Firaisana;
import mg.fjkm.ankadifotsy.service.FjkmAnkadifotsyService;

/**
 * Editeur de propriété de type Firaisana
 * @author rija
 * @version 1.0
 */
public class FiraisanaPropertyEditorSupport extends PropertyEditorSupport {
	private FjkmAnkadifotsyService fService = null;
	
	public FiraisanaPropertyEditorSupport(FjkmAnkadifotsyService nifService){
		fService = nifService;
	}
	
	public void setAsText(String text) throws IllegalArgumentException {
		if (text!=null && !"".equals(text.trim())){
			Firaisana firaisana = fService.findFiraisana(new Long(text.trim()));
			setValue(firaisana);
		}
		else
			setValue((Firaisana)null);
	}
}
