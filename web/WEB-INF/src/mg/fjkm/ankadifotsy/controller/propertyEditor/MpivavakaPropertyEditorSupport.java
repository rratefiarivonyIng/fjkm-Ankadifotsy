/**
 * 
 */
package mg.fjkm.ankadifotsy.controller.propertyEditor;

import java.beans.PropertyEditorSupport;

import mg.fjkm.ankadifotsy.bo.Mpivavaka;
import mg.fjkm.ankadifotsy.service.FjkmAnkadifotsyService;

/**
 * Editeur de propriété de type Mpivavaka
 * @author rija
 * @version 1.0
 */
public class MpivavakaPropertyEditorSupport extends PropertyEditorSupport {
	private FjkmAnkadifotsyService fFjkmAnkadifotsyService = null;
	
	public MpivavakaPropertyEditorSupport(FjkmAnkadifotsyService service){
		fFjkmAnkadifotsyService = service;
	}
	
	public void setAsText(String text) throws IllegalArgumentException {
		if (text!=null && !"".equals(text.trim())){
			Mpivavaka mpivavaka = fFjkmAnkadifotsyService.findMpivavakaById(new Long(text.trim()));
			setValue(mpivavaka);
		}
		else
			setValue((Mpivavaka)null);
	}
}
