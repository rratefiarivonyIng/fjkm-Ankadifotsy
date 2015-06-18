/**
 * 
 */
package mg.fjkm.ankadifotsy.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mg.fjkm.ankadifotsy.bo.Mpivavaka;
import mg.fjkm.ankadifotsy.form.FormRechercheNifContribuable;
import mg.fjkm.ankadifotsy.service.FjkmAnkadifotsyService;
import mg.fjkm.ankadifotsy.util.ConstantUtils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * Controleur pour la recherche de Nif existant dans la base 
 * @user : contribuable, institution (possibilité de téléchargement), DGI
 * @author rija
 * @version 1.0
 */
public class RechercheNifController extends SimpleFormController{
	/** Logger for this class and subclasses */    
	protected final Log logger = LogFactory.getLog(getClass());

	private FjkmAnkadifotsyService fNifService = null;
		
	public void setFjkmAnkadifotsyService(FjkmAnkadifotsyService nifService) {
		fNifService = nifService;
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest req, HttpServletResponse rep, Object command, BindException ex) throws Exception {
		ModelAndView modelAndView = null;
		FormRechercheNifContribuable formulaire = (FormRechercheNifContribuable)command;
		if (formulaire.getNif() != null && !"".equals(formulaire.getNif()) ||
			formulaire.getRaisonSociale() != null && !"".equals(formulaire.getRaisonSociale()) ||
			formulaire.getNomCommercial() != null && !"".equals(formulaire.getNomCommercial())){
			List<Mpivavaka> resultats = null;
			
			//Récupérer les critères de recherche et selon le type de recherche
			String typeRecherche = req.getParameter("rechercherNif");
			if (typeRecherche != null && !"".equals(typeRecherche.trim()))
				resultats = fNifService.getContribuables("rechercherNif", formulaire.getNif());		
			else{ 
				typeRecherche = req.getParameter("rechercherRaisonSociale");
				if (typeRecherche != null && !"".equals(typeRecherche.trim()))
					resultats = fNifService.getContribuables("rechercherRaisonSociale", formulaire.getRaisonSociale());
				else{
					typeRecherche = req.getParameter("rechercherNom");
					if (typeRecherche != null && !"".equals(typeRecherche.trim()))
						resultats = fNifService.getContribuables("rechercherNom", formulaire.getNomCommercial());
				}
			}

			if (resultats.size() == 0)
				formulaire.setMessage(ConstantUtils.sfMESSAGE_AUCUNRESULTAT);
			
			req.getSession().setAttribute(ConstantUtils.sfCSV_DATA, resultats);
			
			formulaire.setResultats(resultats);
		}
		else
			formulaire.setMessage(ConstantUtils.sfMESSAGE_AUCUNFILTRE);		
		
		modelAndView = new ModelAndView(getSuccessView(), FormRechercheNifContribuable.sfFORM_ID, formulaire);
		
		return modelAndView;
	}
		
	@Override
	protected Object formBackingObject(HttpServletRequest req) throws Exception {
		FormRechercheNifContribuable formulaire = new FormRechercheNifContribuable();
		return formulaire;
	}
	
}
