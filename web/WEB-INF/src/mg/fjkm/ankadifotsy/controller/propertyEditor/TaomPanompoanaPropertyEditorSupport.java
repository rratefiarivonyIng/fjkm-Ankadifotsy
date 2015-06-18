/**
 * 
 */
package mg.fjkm.ankadifotsy.controller.propertyEditor;

import java.beans.PropertyEditorSupport;

import mg.fjkm.ankadifotsy.bo.TaomPanompoana;
import mg.fjkm.ankadifotsy.service.FjkmAnkadifotsyService;

/**
 * Editeur de propriété de type Fitandremana
 * @author rija
 * @version 1.0
 */
public class TaomPanompoanaPropertyEditorSupport extends PropertyEditorSupport {
	private FjkmAnkadifotsyService fFjkmAnkadifotsyService = null;
	
	public TaomPanompoanaPropertyEditorSupport(FjkmAnkadifotsyService service){
		fFjkmAnkadifotsyService = service;
	}
	
	public void setAsText(String text) throws IllegalArgumentException {
		if (text!=null && !"".equals(text.trim())){
			TaomPanompoana taomPanompoana = fFjkmAnkadifotsyService.findTaomPanompoanaById(new Long(text.trim()));
			setValue(taomPanompoana);
		}
		else
			setValue((TaomPanompoana)null);
	}
}
