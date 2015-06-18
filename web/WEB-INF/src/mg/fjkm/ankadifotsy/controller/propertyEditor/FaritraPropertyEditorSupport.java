/**
 * 
 */
package mg.fjkm.ankadifotsy.controller.propertyEditor;

import java.beans.PropertyEditorSupport;

import mg.fjkm.ankadifotsy.bo.Faritra;
import mg.fjkm.ankadifotsy.service.FjkmAnkadifotsyService;

/**
 * Editeur de propriété de type Region
 * @author rija
 * @version 1.0
 */
public class FaritraPropertyEditorSupport extends PropertyEditorSupport {
	private FjkmAnkadifotsyService fService = null;
	
	public FaritraPropertyEditorSupport(FjkmAnkadifotsyService nifService){
		fService = nifService;
	}
	
	public void setAsText(String text) throws IllegalArgumentException {
		if (text!=null && !"".equals(text.trim())){
			Faritra faritra = fService.findFaritra(new Long(text.trim()));
			setValue(faritra);
		}
		else
			setValue((Faritra)null);
	}
}
