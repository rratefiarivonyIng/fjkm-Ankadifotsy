/**
 * 
 */
package mg.fjkm.ankadifotsy.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mg.fjkm.ankadifotsy.bo.Mpivavaka;
import mg.fjkm.ankadifotsy.util.ConstantUtils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


/**
 * Classe permettant d'exporter uniquement les données sélectionnées
 * @access : institution et dgi uniquement (non accessible au public)
 * @author rija
 * @version 1.0
 */
public class ExportResultatController implements Controller {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.Controller#handleRequest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse rep) throws Exception {
		List<Mpivavaka> resultats = (List<Mpivavaka>)req.getSession().getAttribute(ConstantUtils.sfCSV_DATA);
		String title = getTitle(req);		

		List<String>essai = new ArrayList<String>();
		if (title != null && !"".equals(title.trim()))
			essai.add(title);
		
		//Entête des colonnes
		essai.add("NIF/REF; CENTRE ; RAISON SOCIALE ; FORME JURIDIQUE ; ACTIVITE PRINCIPALE ; CIN ; CAPITAL");
		if (resultats != null){
//			for (AbstractContribuable contribuable : resultats){
//				StringBuffer record = new StringBuffer();
//				if (contribuable.getIdContribuable() != null)
//					record.append("'").append(contribuable.getIdContribuable()).append("';'");
//				else if (contribuable.getAncienNif() != null && !"".equals(contribuable.getAncienNif().trim()))
//					record.append("'").append(contribuable.getAncienNif()).append("';'");
//				else
//					record.append("'").append(contribuable.getTaxPayerNo()).append("';'");
//					
//				if (contribuable.getFirstEtablissement() != null && contribuable.getFirstEtablissement().getCentreFiscal() != null && contribuable.getFirstEtablissement().getCentreFiscal().getIntitule() != null)
//					record.append("'").append(contribuable.getFirstEtablissement().getCentreFiscal().getIntitule()).append("';'");
//				if (contribuable.getRaisonSociale() != null)
//					record.append(contribuable.getRaisonSociale()).append("';'");
//				if (contribuable.getFormeJuridique() != null && contribuable.getFormeJuridique().getIntitule() != null)
//					record.append(contribuable.getFormeJuridique().getIntitule()).append("';'");
//				if (contribuable.getActivitePrincipale() != null)
//					record.append(contribuable.getActivitePrincipale()).append("';");
//				if (contribuable.getCin() != null)
//					record.append(contribuable.getCin()).append(";");
//				if (contribuable.getCapital() != null)
//					record.append(contribuable.getCapital());
//				
//				essai.add(record.toString());
//			}
		}		

		return new ModelAndView("csv","data", essai);
	}
	
	private String getTitle(HttpServletRequest req){
		String title = (String)req.getParameter(ConstantUtils.sfCSV_TITLE);
		if ("Approuvable".equals(title))
			title = "Demandes approuvables";
		else if ("Rejetees".equals(title))
			title = "Demandes rejetées";
		else if ("enInstance".equals(title))
			title = "Demandes en cours";
		return title;
	}
}
