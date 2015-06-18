/**
 * 
 */
package mg.fjkm.ankadifotsy.controller.propertyEditor;

import java.beans.PropertyEditorSupport;

import mg.fjkm.ankadifotsy.bo.Fitandremana;
import mg.fjkm.ankadifotsy.service.FjkmAnkadifotsyService;

/**
 * Editeur de propriété de type Fitandremana
 * @author rija
 * @version 1.0
 */
public class FitandremanaPropertyEditorSupport extends PropertyEditorSupport {
	private FjkmAnkadifotsyService fFjkmAnkadifotsyService = null;
	
	public FitandremanaPropertyEditorSupport(FjkmAnkadifotsyService service){
		fFjkmAnkadifotsyService = service;
	}
	
	public void setAsText(String text) throws IllegalArgumentException {
		if (text!=null && !"".equals(text.trim())){
			Fitandremana fitandremana = fFjkmAnkadifotsyService.findFitandremanaById(new Long(text.trim()));
			setValue(fitandremana);
		}
		else
			setValue((Fitandremana)null);
	}
}
