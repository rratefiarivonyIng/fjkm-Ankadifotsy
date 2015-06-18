/**
 * 
 */
package mg.fjkm.ankadifotsy.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mg.fjkm.ankadifotsy.bo.Parameter;
import mg.fjkm.ankadifotsy.controller.propertyEditor.DatePropertyEditorSupport;
import mg.fjkm.ankadifotsy.controller.propertyEditor.DoublePropertyEditorSupport;
import mg.fjkm.ankadifotsy.controller.propertyEditor.IntegerPropertyEditorSupport;
import mg.fjkm.ankadifotsy.form.FormParameter;
import mg.fjkm.ankadifotsy.service.FjkmAnkadifotsyService;
import mg.fjkm.ankadifotsy.util.ConstantUtils;
import mg.fjkm.ankadifotsy.util.Utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * Controleur pour la saisie des paramètres d'un utilisateur du système
 * @author rija
 * @version 1.0
 */
public class EditParameterController extends SimpleFormController{
	/** Logger for this class and subclasses */    
	protected final Log logger = LogFactory.getLog(getClass());

	private FjkmAnkadifotsyService fFjkmService = null;
		
	public void setFjkmAnkadifotsyService(FjkmAnkadifotsyService nifService) {
		fFjkmService = nifService;
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest req, HttpServletResponse rep, Object command, BindException ex) throws Exception {
		FormParameter formulaire = (FormParameter)command;
		String submitName = req.getParameter("Valider");

		if (submitName != null && !"".equals(submitName.trim()) && "Alefa".equalsIgnoreCase(submitName)){
			fFjkmService.saveParameter(formulaire.getParameter());
			Parameter parameter = fFjkmService.findParameterByUser(Utils.getLoggedUserName());
			Utils.setParameter(req, parameter);
		}
		
		req.setAttribute(ConstantUtils.sfSaveableEntity, null);
		
		Utils.setSelectedTab(req, ConstantUtils.sfAccessAdmin);

		Map<String, Object> datas = new HashMap<String, Object>();
		datas.put(ConstantUtils.sfMessageEnregistrementOK, true);
		String message = "Voaray ny fanovàna amin'ny paramètres";
		datas.put(ConstantUtils.sfMessageContent, message);
		datas.put(ConstantUtils.sfEditedFromSearch, formulaire.isFromSearch());

		ModelAndView modelAndView = new ModelAndView("secure/administration", datas);
		
		//Ré-initialiser la session
		Utils.setMpivavakaInSession(req, null);
		
		return modelAndView;
	}
	
	@Override
	protected Object formBackingObject(HttpServletRequest req) throws Exception {
		Parameter parameter = fFjkmService.findParameterByUser(Utils.getLoggedUserName());
		FormParameter formulaire = new FormParameter(parameter);
		
		return formulaire;
	}
	
	protected void initBinder(HttpServletRequest req, ServletRequestDataBinder binder) throws Exception {
	    binder.registerCustomEditor(Date.class, new DatePropertyEditorSupport());
	    
	    binder.registerCustomEditor(Integer.class, new IntegerPropertyEditorSupport());

	    binder.registerCustomEditor(Double.class, new DoublePropertyEditorSupport());
	}

}
