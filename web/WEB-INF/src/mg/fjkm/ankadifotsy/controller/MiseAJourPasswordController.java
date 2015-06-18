/**
 * 
 */
package mg.fjkm.ankadifotsy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mg.fjkm.ankadifotsy.form.FormMotDePasse;
import mg.fjkm.ankadifotsy.service.FjkmAnkadifotsyService;
import mg.fjkm.ankadifotsy.util.ConstantUtils;

import org.acegisecurity.Authentication;
import org.acegisecurity.context.SecurityContextHolder;
import org.acegisecurity.userdetails.User;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Controleur pour la modification du mot de passe de l'utilisateur actuellement connecté
 * @access : contribuable
 * @author rija
 * @version 1.0
 */
public class MiseAJourPasswordController extends SimpleFormController{

	private FjkmAnkadifotsyService fFjkmAnkadifotsyService = null;
	
	public void setFjkmAnkadifotsyService(FjkmAnkadifotsyService nifService) {
		fFjkmAnkadifotsyService = nifService;
	}

	@Override	
	protected ModelAndView onSubmit(HttpServletRequest req, HttpServletResponse rep, Object command, BindException ex) throws Exception {
		ModelAndView modelAndView = new ModelAndView(new RedirectView(getSuccessView()));
		FormMotDePasse formulaire = (FormMotDePasse)command;
		
		String enregistrer = req.getParameter("Enregistrer");
		if (enregistrer != null && !"".equals(enregistrer.trim())){
			//Sauvegarde des modifications
			try{
				fFjkmAnkadifotsyService.updatePassword(formulaire.getLogin(), formulaire.getOldPassword(), formulaire.getPassword());
			}
			catch(Exception e){
				//afficher un message d'erreur explicite
				req.setAttribute(ConstantUtils.sfMessageExist, true);
				req.setAttribute(ConstantUtils.sfMessageContent, "Hamarino ny teny miafina taloha");
				req.setAttribute(getCommandName(), formulaire);
				modelAndView = new ModelAndView(getFormView());
			}
			
			//Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			//User user = ((User)authentication.getPrincipal()); 
			//Map<String, String> userInfo = new HashMap<String, String>();
		}
		
		return modelAndView;
	}
		
	@Override
	protected Object formBackingObject(HttpServletRequest req) throws Exception {
		FormMotDePasse formulaire = null;

		//nif du contribuable à modifier qui est aussi son login d'authentification 
		String login = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null){
			//Positionnement de la date de validation et du login de l'opérateur ayant effectué la validation
			User user = ((User)authentication.getPrincipal()); 
			login = user.getUsername();

			mg.fjkm.ankadifotsy.bo.User u = fFjkmAnkadifotsyService.getUser(login);
			formulaire = new FormMotDePasse(u);
			
			formulaire.setLogin(login);
			formulaire.setPassword("");
			formulaire.setConfirmation("");
		}	
		return formulaire;
	}
		
	/**
	 * NE PAS VALIDER LES DONNEES si annulation de la modification ou recherche
	 */
	@Override
	protected boolean suppressValidation(HttpServletRequest req) {		
		String cancelled = req.getParameter("Annuler");	
		String mode = req.getParameter("mode");
		
		//à cause d'un bug d'Interne Explorer qui revoie null une fois sur deux pour le nom du bouton de submit cliqué par l'utilisateur
		//j'ai passé en simultané dans la var mode le nom du bouton au cas où le bug apparaît
		boolean ret = (cancelled != null && !"".equals(cancelled.trim())) || (mode != null && !"".equals(mode.trim()));
			
		return ret;
	}
		
}
