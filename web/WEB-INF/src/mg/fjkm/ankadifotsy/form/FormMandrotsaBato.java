/**
 * 
 */
package mg.fjkm.ankadifotsy.form;

import mg.fjkm.ankadifotsy.bo.FanisamBato;

/**
 * Formulaire pour le scrutin
 * @author Rija
 *
 */
public class FormMandrotsaBato {
	public static final String sfFORM_ID = "formMandrotsaBato";
	
	private FanisamBato fFanisamBato = null;
	
	public FormMandrotsaBato(){
	}
	
	public void setFanisamBato(FanisamBato fanisamBato){
		fFanisamBato = fanisamBato;
	}
	
	public long getIsaVatoNirotsaka(){
		long ret = 0;
		if (fFanisamBato != null)
			ret = fFanisamBato.getIsamBatoVoaisa();
		return ret;
	}
	
}
