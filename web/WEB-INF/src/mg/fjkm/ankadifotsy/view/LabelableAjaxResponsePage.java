/**
 * 
 */
package mg.fjkm.ankadifotsy.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;

import mg.fjkm.ankadifotsy.bo.ILabelable;

/**
 * Rendu des réponses ajax pour les données de type implémentant
 * l'interface ILocalisation
 * @see mg.fjkm.ankadifotsy.ILabelable
 * @author rija
 *
 */
public class LabelableAjaxResponsePage extends AjaxResponsePage {

	/* (non-Javadoc)
	 * @see mg.dgi.nif.view.AjaxResponsePage#writeData(java.lang.Object, javax.servlet.ServletOutputStream)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void writeData(Object datas, ServletOutputStream outServ) throws IOException {
		List<ILabelable> labelables =(List<ILabelable>)datas;
		if (labelables != null){
			for (ILabelable labelable : labelables){
				outServ.print("<item>");
				outServ.print("<name><![CDATA["+labelable.getLabel()+"]]></name>");
				outServ.print("<value><![CDATA["+labelable.getId()+"]]></value>");
				outServ.print("</item>");
			}
		}
	}

}
