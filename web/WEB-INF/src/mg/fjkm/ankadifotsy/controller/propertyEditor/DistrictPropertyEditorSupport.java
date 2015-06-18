/**
 * 
 */
package mg.fjkm.ankadifotsy.controller.propertyEditor;

import java.beans.PropertyEditorSupport;

import mg.fjkm.ankadifotsy.bo.District;
import mg.fjkm.ankadifotsy.service.FjkmAnkadifotsyService;

/**
 * Editeur de propriété de type District
 * @author rija
 * @version 1.0
 */
public class DistrictPropertyEditorSupport extends PropertyEditorSupport {
	private FjkmAnkadifotsyService fNifService = null;
	
	public DistrictPropertyEditorSupport(FjkmAnkadifotsyService nifService){
		fNifService = nifService;
	}
	
	public void setAsText(String text) throws IllegalArgumentException {
		if (text!=null && !"".equals(text.trim())){
			District district = fNifService.findDistrict(new Long(text.trim()));
			setValue(district);
		}
		else
			setValue((District)null);
	}
}
