/**
 * 
 */
package mg.fjkm.ankadifotsy.controller.propertyEditor;

import java.beans.PropertyEditorSupport;

/**
 * Editeur de propriété de type CIN
 * Le Cin est limité à 15 caractères et le format est 999 999 999 999 
 * @author rija
 * @version 1.0
 */
public class CinPropertyEditorSupport extends PropertyEditorSupport {
	public void setAsText(String text) throws IllegalArgumentException {
		if (text!=null && !"".equals(text.trim())){
			String sTrimed = trimText(text);
			String formatted = formatTextToCin(sTrimed);
			
			setValue(formatted);
		}
		else
			setValue((String)null);
	}
	
	public String getAsText(){
		String ret = "";
		Object value = getValue();
		if (value != null){
			ret = value.toString();
			String sTrimed = trimText(ret);
			ret = formatTextToCin(sTrimed);
		}
		return ret;
	}
	
	private String trimText(String toTrim){
		StringBuffer sTrimed = new StringBuffer();
		for (int i=0; i < toTrim.length(); i++){
			char c = toTrim.charAt(i);
			int n = c;
			if (c != ' ' && c != ',' && n != 160 && c != '.')
				sTrimed.append(c);
		}
		return sTrimed.toString();
	}
	
	private String formatTextToCin(String text){
		StringBuffer formatted = new StringBuffer();
		for (int i=0; i < text.length(); i++){
			if (i<15){
				formatted.append(text.charAt(i));
				if ((i+1)%3 == 0)
					formatted.append(' ');
			}
		}
		return formatted.toString();
	}
}
