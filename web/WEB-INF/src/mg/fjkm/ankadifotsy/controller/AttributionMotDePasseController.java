/**
 * 
 */
package mg.fjkm.ankadifotsy.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mg.fjkm.ankadifotsy.bo.Mpivavaka;
import mg.fjkm.ankadifotsy.bo.User;
import mg.fjkm.ankadifotsy.form.FormMotDePasse;
import mg.fjkm.ankadifotsy.service.FjkmAnkadifotsyService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * Controller pour la génération et/ou modification de mot de passe pour un contribuable
 * @acces Opérateur DGI uniquement
 * @author rija
 * @version 1.0
 */
public class AttributionMotDePasseController extends SimpleFormController {
	/** Logger for this class and subclasses */    
	protected final Log logger = LogFactory.getLog(getClass());

	protected FjkmAnkadifotsyService fNifService = null;
		
	public void setFjkmAnkadifotsyService(FjkmAnkadifotsyService nifService) {
		fNifService = nifService;
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest req, HttpServletResponse rep, Object command, BindException ex) throws Exception {
		ModelAndView modelAndView = null;
		FormMotDePasse form = (FormMotDePasse)command;
		if (form.getLogin() != null){
			Mpivavaka contribuable = fNifService.getContribuableByNif(form.getLogin());
			if (contribuable == null)
				contribuable = fNifService.getContribuableByAncienNif(form.getLogin());
			if (contribuable != null){
				fNifService.creerUtilisateurPourContribuable(contribuable);							//Créer l'utilisateur
				User user = fNifService.modifierUtilisateur(form.getLogin(), form.getPassword());	//positionner le mot de passe saisi
				Map<String, String> userInfo = new HashMap<String, String>();
				userInfo.put("login", user.getLogin());
				userInfo.put("password", user.getPassword());
				//renvoyer une page indiquant que l'enregistrement est bien effectué
				modelAndView = new ModelAndView(getSuccessView(), "userInfo", userInfo);
			}
			else{
				//Le NIF n'existe pas
				//form.setMessage("Le NIF n'est pas correct ou n'existe pas encore.");
				modelAndView = new ModelAndView(getFormView(), getCommandName(), form);
			}
		}
		return modelAndView;
	}

	@Override
	protected Object formBackingObject(HttpServletRequest req) throws Exception {
		String nif = req.getParameter("nif");
		User user = fNifService.getUser(nif);
		FormMotDePasse form = new FormMotDePasse(user);
		
		return form;
	}
}
