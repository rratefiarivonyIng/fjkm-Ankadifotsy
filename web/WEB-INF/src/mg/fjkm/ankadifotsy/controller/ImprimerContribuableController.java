/**
 * 
 */
package mg.fjkm.ankadifotsy.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mg.fjkm.ankadifotsy.bo.Mpivavaka;
import mg.fjkm.ankadifotsy.print.PrintContribuable;
import mg.fjkm.ankadifotsy.service.FjkmAnkadifotsyService;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * Controleur pour l'impression des renseignements sur le contribuable (ses entreprises et les dirigeants de ses entreprises)
 * 
 * @access : opérateur DGI à la validation de la demande
 * @author rija
 * @version 1.0
 */
public class ImprimerContribuableController implements Controller{

	private FjkmAnkadifotsyService fNifService = null;
		
	public void setFjkmAnkadifotsyService(FjkmAnkadifotsyService nifService) {
		fNifService = nifService;
	}

	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse rep) throws Exception {
		ModelAndView modelAndView = null;
		
		//Récupération de l'identifiant du contribuable		
		String taxPayerNo = req.getParameter("taxPayerNo");
		
		Mpivavaka contribuable = fNifService.getContribuableByReference(new Long(taxPayerNo));
		
		PrintContribuable printContribuable = new PrintContribuable("MasterReport.jasper", contribuable);

		//Date
		byte[] contenu = printContribuable.exportToPDFAsByteArray();
		
		if (contenu!=null){
			Map<String, byte[]> model = new HashMap<String, byte[]>();
			model.put("data", contenu);
			modelAndView = new ModelAndView("pdf", model);
		}

		return modelAndView;
	}
}
