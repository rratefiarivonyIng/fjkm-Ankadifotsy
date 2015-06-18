/**
 * 
 */
package mg.fjkm.ankadifotsy.controller.propertyEditor;

import java.beans.PropertyEditorSupport;
import java.text.DecimalFormat;

/**
 * Editeur de propriété de type monnaie (Ex capital)
 * Permet de supprimer éventuellement les espaces servant de séparateur de millier
 * et d'afficher les montants avec des séparateurs de millier
 * @author rija
 * @version 1.0
 */
public class CapitalPropertyEditorSupport extends PropertyEditorSupport {
	public void setAsText(String text) throws IllegalArgumentException {
		if (text!=null && !"".equals(text.trim())){
			StringBuffer sTrimed = new StringBuffer();
			for (int i=0; i < text.length(); i++){
				char c = text.charAt(i);
				int n = c;
				if (c != ' ' && c != ',' && n != 160)
					sTrimed.append(c);
				if (c == ',')
					sTrimed.append('.');
			}
			setValue(new Double(sTrimed.toString()));
		}
		else
			setValue((Double)null);
	}
	
	public String getAsText(){
		String ret = "";
		DecimalFormat df = new DecimalFormat("#,##0.00");
		Double value = (Double)getValue();
		if (value != null)
			ret = df.format((Double)getValue());
		return ret;
	}
}
