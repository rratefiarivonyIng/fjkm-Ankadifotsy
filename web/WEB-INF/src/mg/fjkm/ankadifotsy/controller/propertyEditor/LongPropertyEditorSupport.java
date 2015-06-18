/**
 * 
 */
package mg.fjkm.ankadifotsy.controller.propertyEditor;

import java.beans.PropertyEditorSupport;

/**
 * Editeur de propriété de type Long
 * @author rija
 * @version 1.0
 */
public class LongPropertyEditorSupport extends PropertyEditorSupport {
	public void setAsText(String text) throws IllegalArgumentException {
		if (text!=null && !"".equals(text.trim()))
			setValue(new Long(text));
		else
			setValue((Long)null);
	}
	
	public String getAsText(){
		return getValue()==null? "" : ((Long)getValue()).toString();
	}
}
