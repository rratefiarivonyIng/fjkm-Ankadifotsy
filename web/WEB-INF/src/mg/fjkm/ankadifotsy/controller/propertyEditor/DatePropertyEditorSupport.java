/**
 * 
 */
package mg.fjkm.ankadifotsy.controller.propertyEditor;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Editeur des propriétés de type Date
 * @author rija
 * @version 1.0
 */
public class DatePropertyEditorSupport extends PropertyEditorSupport {
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public void setAsText(String text) throws IllegalArgumentException {
		if (text!=null && !"".equals(text.trim())){
			try {
				setValue(sdf.parseObject(text));
			} 
			catch (ParseException e){
				throw new IllegalArgumentException();
			}                    		  
		}
		else
			setValue(null);
	}

	public String getAsText(){
		Object obj = getValue();
		if (obj!=null)
			return sdf.format((Date)getValue());
		else
			return "";
	}	              
}
