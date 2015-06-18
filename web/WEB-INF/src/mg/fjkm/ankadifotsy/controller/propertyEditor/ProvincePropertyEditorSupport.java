/**
 * 
 */
package mg.fjkm.ankadifotsy.controller.propertyEditor;

import java.beans.PropertyEditorSupport;

import mg.fjkm.ankadifotsy.bo.Province;
import mg.fjkm.ankadifotsy.service.FjkmAnkadifotsyService;

/**
 * Editeur de propriété de type Province
 * @author rija
 * @version 1.0
 */
public class ProvincePropertyEditorSupport extends PropertyEditorSupport {
	private FjkmAnkadifotsyService fNifService = null;
	
	public ProvincePropertyEditorSupport(FjkmAnkadifotsyService nifService){
		fNifService = nifService;
	}
	
	public void setAsText(String text) throws IllegalArgumentException {
		if (text!=null && !"".equals(text.trim())){
			Province province = fNifService.getProvince(new Long(text.trim()));
			setValue(province);
		}
		else
			setValue((Province)null);
	}
}
