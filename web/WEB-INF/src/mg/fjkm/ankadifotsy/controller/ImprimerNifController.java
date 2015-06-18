/**
 * 
 */
package mg.fjkm.ankadifotsy.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mg.fjkm.ankadifotsy.bo.Mpivavaka;
import mg.fjkm.ankadifotsy.print.PrintAttestation;
import mg.fjkm.ankadifotsy.print.PrintContribuable;
import mg.fjkm.ankadifotsy.service.FjkmAnkadifotsyService;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * Controleur pour l'impression du certificat d'obtention du NIF
 * 
 * @access : opérateur DGI à la validation de la demande
 * @author rija
 * @version 1.0
 */
public class ImprimerNifController implements Controller{

	private FjkmAnkadifotsyService fNifService = null;
	
	public void setFjkmAnkadifotsyService(FjkmAnkadifotsyService nifService) {
		fNifService = nifService;
	}

	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse rep) throws Exception {
		ModelAndView modelAndView = null;
		
		//Récupération des données à imprimer
		String typeImpression = req.getParameter("type");
		typeImpression = typeImpression.trim();
		if ("attestation".equals(typeImpression.trim()))
			modelAndView = imprimerAttestation(req);		
		else
			modelAndView = imprimerRenseignementContribuable(req);		
		
		return modelAndView;
	}
	
	private ModelAndView imprimerAttestation(HttpServletRequest req){
		ModelAndView modelAndView = null;
		String nif = req.getParameter("nif");
		String[] split = nif.split(" ");
		StringBuffer nifTrimed = new StringBuffer();
		for (int i = 0; i < split.length; i++){
			nifTrimed.append(split[i]);
		}

		Long nifInt = Long.parseLong(nifTrimed.toString());
		
		PrintAttestation printAttestation = new PrintAttestation("attestation.jasper");
		//Raison social
//		printAttestation.setRaisonSociale(contribuable.getRaisonSociale());
//		//Nom commercial
//		printAttestation.setNomCommercial(contribuable.getNomCommercial());
//		//Siege social
//		printAttestation.setSiegeSocial(contribuable.getAdresseEtablissement());
		//Numéro d'identification fiscal
		printAttestation.setIdFiscale(nifInt);

		//Date
		printAttestation.setDate(new Date());

		String taxPayerNo = req.getParameter("taxPayerNo");
		printAttestation.setNumero(new Long(taxPayerNo).intValue());

		byte[] contenu = printAttestation.exportToPDFAsByteArray();
		
		if (contenu!=null){
			Map<String, byte[]> model = new HashMap<String, byte[]>();
			model.put("data", contenu);
			modelAndView = new ModelAndView("pdf", model);
		}

		return modelAndView;		
	}
	
	private ModelAndView imprimerRenseignementContribuable(HttpServletRequest req){
		ModelAndView modelAndView = null;
		
		Mpivavaka contribuable = getContribuable(req);
		
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
	
	private Mpivavaka getContribuable(HttpServletRequest req){
		String nif = req.getParameter("nif");
		String[] split = nif.split(" ");
		StringBuffer nifTrimed = new StringBuffer();
		for (int i = 0; i < split.length; i++){
			nifTrimed.append(split[i]);
		}
		
		String taxPayerNo = req.getParameter("taxPayerNo");
		
		Mpivavaka contribuable = fNifService.getContribuableByReference(new Long(taxPayerNo));
		if (contribuable == null)
			contribuable = fNifService.getContribuableByNif(nif);

		return contribuable;
	}
}
