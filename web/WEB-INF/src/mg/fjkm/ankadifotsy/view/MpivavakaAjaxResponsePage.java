/**
 * 
 */
package mg.fjkm.ankadifotsy.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;

import mg.fjkm.ankadifotsy.bo.Mpivavaka;

/**
 * Rendu des réponses ajax pour les données de type Mpivavaka 
 * @author rija
 */
public class MpivavakaAjaxResponsePage extends AjaxResponsePage {

	/* (non-Javadoc)
	 * @see mg.dgi.nif.view.AjaxResponsePage#writeData(java.lang.Object, javax.servlet.ServletOutputStream)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void writeData(Object datas, ServletOutputStream outServ) throws IOException {
		List<Mpivavaka> mpivavakas =(List<Mpivavaka>)datas;
		if (mpivavakas != null){
			for (Mpivavaka mpivavaka : mpivavakas){
				outServ.print("<item>");
				outServ.print("<name><![CDATA["+mpivavaka.getAnarana()+" "+mpivavaka.getFanampiny()+"]]></name>");
				outServ.print("<value><![CDATA["+mpivavaka.getId()+"]]></value>");
				outServ.print("</item>");
			}
		}
	}

}
