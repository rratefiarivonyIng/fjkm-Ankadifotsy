/**
 * 
 */
package mg.fjkm.ankadifotsy.controller.propertyEditor;

import java.beans.PropertyEditorSupport;

import mg.fjkm.ankadifotsy.bo.Region;
import mg.fjkm.ankadifotsy.service.FjkmAnkadifotsyService;

/**
 * Editeur de propriété de type Region
 * @author rija
 * @version 1.0
 */
public class RegionPropertyEditorSupport extends PropertyEditorSupport {
	private FjkmAnkadifotsyService fNifService = null;
	
	public RegionPropertyEditorSupport(FjkmAnkadifotsyService nifService){
		fNifService = nifService;
	}
	
	public void setAsText(String text) throws IllegalArgumentException {
		if (text!=null && !"".equals(text.trim())){
			Region region = fNifService.getRegion(new Long(text.trim()));
			setValue(region);
		}
		else
			setValue((Region)null);
	}
}
