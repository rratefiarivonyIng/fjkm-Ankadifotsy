/**
 * 
 */
package mg.fjkm.ankadifotsy.controller.propertyEditor;

import java.beans.PropertyEditorSupport;

/**
 * Editeur de propriété de données de type Double
 * @author rija
 * @version 1.0
 */
public class DoublePropertyEditorSupport extends PropertyEditorSupport {
	public void setAsText(String text) throws IllegalArgumentException {
		if (text!=null && !"".equals(text.trim()))
			setValue(new Double(text));
		else
			setValue((Double)null);
	}
	
	public String getAsText(){
		return getValue()==null? "" : ((Double)getValue()).toString();
	}
}
