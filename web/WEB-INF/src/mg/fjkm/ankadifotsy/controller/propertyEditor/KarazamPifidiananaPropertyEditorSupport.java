/**
 * 
 */
package mg.fjkm.ankadifotsy.controller.propertyEditor;

import java.beans.PropertyEditorSupport;

import mg.fjkm.ankadifotsy.bo.KarazamPifidianana;
import mg.fjkm.ankadifotsy.bo.TaomPanompoana;
import mg.fjkm.ankadifotsy.service.FjkmAnkadifotsyService;

/**
 * Editeur de propriété de type KarazamPifidianana
 * @author rija
 * @version 1.0
 */
public class KarazamPifidiananaPropertyEditorSupport extends PropertyEditorSupport {
	private FjkmAnkadifotsyService fFjkmAnkadifotsyService = null;
	
	public KarazamPifidiananaPropertyEditorSupport(FjkmAnkadifotsyService service){
		fFjkmAnkadifotsyService = service;
	}
	
	public void setAsText(String text) throws IllegalArgumentException {
		if (text!=null && !"".equals(text.trim())){
			KarazamPifidianana karazamPifidianana = fFjkmAnkadifotsyService.findKarazamPifidiananaById(new Long(text.trim()));
			setValue(karazamPifidianana);
		}
		else
			setValue((TaomPanompoana)null);
	}
}
