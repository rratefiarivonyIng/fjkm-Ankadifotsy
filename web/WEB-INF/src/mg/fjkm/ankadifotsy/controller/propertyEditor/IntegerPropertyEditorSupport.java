/**
 * 
 */
package mg.fjkm.ankadifotsy.controller.propertyEditor;

import java.beans.PropertyEditorSupport;

/**
 * Editeur de propriété de type Integer
 * @author rija
 * @version 1.0
 */
public class IntegerPropertyEditorSupport extends PropertyEditorSupport {
	public void setAsText(String text) throws IllegalArgumentException {
		if (text!=null && !"".equals(text.trim()))
			setValue(new Integer(text));
		else
			setValue((Integer)null);
	}
	
	public String getAsText(){
		return getValue()==null? "" : ((Integer)getValue()).toString();
	}
}
