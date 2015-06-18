/**
 * 
 */
package mg.fjkm.ankadifotsy.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mg.fjkm.ankadifotsy.bo.FanisamBato;
import mg.fjkm.ankadifotsy.bo.Fifidianana;
import mg.fjkm.ankadifotsy.bo.Vato;
import mg.fjkm.ankadifotsy.controller.propertyEditor.DatePropertyEditorSupport;
import mg.fjkm.ankadifotsy.form.FormManisaVato;
import mg.fjkm.ankadifotsy.form.FormSearchVato;
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
 * Controleur pour la saisie des informations pour la recherche d'un fifidianana
 * 
 * @access : protégé
 * @author rija
 * @version 1.0
 */
public class SearchVatoController extends SimpleFormController {
	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	private FjkmAnkadifotsyService fFjkmService = null;

	public void setFjkmAnkadifotsyService(FjkmAnkadifotsyService nifService) {
		fFjkmService = nifService;
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest req, HttpServletResponse rep, Object command, BindException ex) throws Exception {
		FormSearchVato formulaire = (FormSearchVato)command;
				
		String lehilahy = req.getParameter("lehilahy");
		Boolean isLehilahy = Boolean.parseBoolean(lehilahy);
		formulaire.setLehilahy(isLehilahy);
		
		String vatoLaharana = req.getParameter("vatoLaharana");
		formulaire.setVatoLaharana(vatoLaharana);
		
		ModelAndView modelAndView = null;

		Vato vato = fFjkmService.findVato(formulaire.getVatoLaharana(), formulaire.getFifidianana().getId(), formulaire.getLehilahy());
		FormManisaVato formManisaVato = new FormManisaVato();
		FanisamBato fanisamBato = fFjkmService.findFanisamBatoByFifidianana(formulaire.getFifidianana(), formulaire.getLehilahy());
		formManisaVato.setFanisamBato(fanisamBato);
		Fifidianana fifidianana = Utils.getFifidiananaFromSession(req);
		List<Map<String, Object>> list = fFjkmService.findMapMirotsakaFidiana(fifidianana.getId(), true, formulaire.getLehilahy());
		formManisaVato.setMirotsakaFidianas(list);

		if (vato != null){
			formManisaVato.setVatoLaharana(vato.getVatoLaharana());
			formManisaVato.setMirotsakaFidianaIdsMiverina(vato.getSafidys());
			
			formManisaVato.setVatoFotsy(vato.getSafidys().size()==0);
			formManisaVato.setVatoMaty(vato.getSafidys().size() > fifidianana.getIsaOlonaFidiana().intValue());
			req.setAttribute(ConstantUtils.sfSaveableEntity, vato);
		}
		else{
			formManisaVato.setVatoLaharana(vatoLaharana);
			
			//afficher un message => VatoLaharana [XXXXX] tsy misy
			String message = "Vato laharana ["+formulaire.getVatoLaharana()+"] tsy misy.";
			req.setAttribute(ConstantUtils.sfMessageContent, message);
			req.setAttribute(ConstantUtils.sfMessageExist, true);
			req.setAttribute(ConstantUtils.sfSaveableEntity, null);
		}

		req.getSession().setAttribute("FormMijeryVato", formManisaVato);
		modelAndView = new ModelAndView("secure/showVato", FormManisaVato.sfFORM_ID, formManisaVato);

		Utils.setSelectedTab(req, ConstantUtils.sfAccessFifidianana);
		
		Utils.setCurrentSearchForm(req, formulaire);		
		
		return modelAndView;
	}

	@Override
	protected Object formBackingObject(HttpServletRequest req) throws Exception {
		FormSearchVato formulaire = (FormSearchVato)req.getAttribute(FormSearchVato.sfFORM_ID);
		if (formulaire == null)
			formulaire = new FormSearchVato();
		
		formulaire.setPageNo(0);
		formulaire.setFrom((String) req.getParameter(ConstantUtils.sfPARAM_FROM));
		
		Fifidianana fifidianana = Utils.getFifidiananaFromSession(req);
		formulaire.setFifidianana(fifidianana);
		formulaire.setLehilahy(true);	//Par défaut : lehilahy
	
		req.setAttribute("lehilahy", true);
		req.setAttribute(ConstantUtils.sfREQUEST_FIFIDIANANA, fifidianana);

		if (formulaire.getFrom() == null || "".equals(formulaire.getFrom().trim()))
			Utils.setSelectedTab(req, ConstantUtils.sfAccessFifidianana);

		Utils.setCurrentSearchForm(req, formulaire);
			
		return formulaire;
	}

	protected void initBinder(HttpServletRequest req,
			ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Date.class, new DatePropertyEditorSupport());
	}

}
