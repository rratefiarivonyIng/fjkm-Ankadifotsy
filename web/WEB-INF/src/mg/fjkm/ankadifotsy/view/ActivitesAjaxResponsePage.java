/**
 * 
 */
package mg.fjkm.ankadifotsy.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;

import mg.fjkm.ankadifotsy.bo.AntonAsa;

/**
 * Rendu des r�ponses ajax pour les donn�es de type Activit�s 
 * @author rija
 */
public class ActivitesAjaxResponsePage extends AjaxResponsePage {

	/* (non-Javadoc)
	 * @see mg.dgi.nif.view.AjaxResponsePage#writeData(java.lang.Object, javax.servlet.ServletOutputStream)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void writeData(Object datas, ServletOutputStream outServ) throws IOException {
		List<AntonAsa> activites =(List<AntonAsa>)datas;
		if (activites != null){
			for (AntonAsa activite : activites){
				outServ.print("<item>");
				outServ.print("<name><![CDATA["+activite.getIntitule()+"]]></name>");
				outServ.print("<value><![CDATA["+activite.getId()+"]]></value>");
				outServ.print("</item>");
			}
		}
	}

}
