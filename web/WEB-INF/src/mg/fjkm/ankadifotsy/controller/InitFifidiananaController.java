/**
 * 
 */
package mg.fjkm.ankadifotsy.controller;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mg.fjkm.ankadifotsy.bo.Fifidianana;
import mg.fjkm.ankadifotsy.form.FormFifidianana;
import mg.fjkm.ankadifotsy.service.FjkmAnkadifotsyService;
import mg.fjkm.ankadifotsy.util.Utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Controleur pour re-initialiser un fifidianana : le nombre de voies obtenues par les candidats à zéro et les 
 * statistiques dans Fanisambato à 0
 * @author rija
 * @version 1.0
 */
public class InitFifidiananaController extends SimpleFormController{
	/** Logger for this class and subclasses */    
	protected final Log logger = LogFactory.getLog(getClass());

	private FjkmAnkadifotsyService fFjkmService = null;
		
	public void setFjkmAnkadifotsyService(FjkmAnkadifotsyService nifService) {
		fFjkmService = nifService;
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		FormFifidianana formFifidianana = (FormFifidianana)command;

		fFjkmService.initFifidianana(formFifidianana.getFifidianana().getId());
		
		return new ModelAndView(new RedirectView(request.getContextPath()+"/secure/selectFifidianana.htm?id="+formFifidianana.getFifidianana().getId()+"&message="+URLEncoder.encode("Vita ny famerenana 0.", "utf-8")));
	}

	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		Fifidianana fifidianana = Utils.getFifidiananaFromSession(request);
		FormFifidianana form = new FormFifidianana(fifidianana);
		return form;
	}
	
}
