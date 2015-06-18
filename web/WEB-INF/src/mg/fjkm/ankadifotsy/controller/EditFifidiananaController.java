/**
 * 
 */
package mg.fjkm.ankadifotsy.controller;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mg.fjkm.ankadifotsy.bo.Fifidianana;
import mg.fjkm.ankadifotsy.bo.Fitandremana;
import mg.fjkm.ankadifotsy.bo.KarazamPifidianana;
import mg.fjkm.ankadifotsy.bo.TaomPanompoana;
import mg.fjkm.ankadifotsy.controller.propertyEditor.DatePropertyEditorSupport;
import mg.fjkm.ankadifotsy.controller.propertyEditor.DoublePropertyEditorSupport;
import mg.fjkm.ankadifotsy.controller.propertyEditor.FitandremanaPropertyEditorSupport;
import mg.fjkm.ankadifotsy.controller.propertyEditor.IntegerPropertyEditorSupport;
import mg.fjkm.ankadifotsy.controller.propertyEditor.KarazamPifidiananaPropertyEditorSupport;
import mg.fjkm.ankadifotsy.controller.propertyEditor.TaomPanompoanaPropertyEditorSupport;
import mg.fjkm.ankadifotsy.form.FormFifidianana;
import mg.fjkm.ankadifotsy.service.FjkmAnkadifotsyService;
import mg.fjkm.ankadifotsy.util.ConstantUtils;
import mg.fjkm.ankadifotsy.util.Utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Controleur pour la saisie des informations sur un Fifidianana 
 * @author rija
 * @version 1.0
 */
public class EditFifidiananaController extends SimpleFormController{
	/** Logger for this class and subclasses */    
	protected final Log logger = LogFactory.getLog(getClass());

	private FjkmAnkadifotsyService fFjkmService = null;
		
	public void setFjkmAnkadifotsyService(FjkmAnkadifotsyService nifService) {
		fFjkmService = nifService;
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest req, HttpServletResponse rep, Object command, BindException ex) throws Exception {
		FormFifidianana formulaire = (FormFifidianana)command;
		String submitName = req.getParameter("Valider");

		boolean addMode = true;
		Fifidianana fifidianana = formulaire.getFifidianana(); 
		String message = null;
		Map<String, Object> datas = new HashMap<String, Object>();
		if (submitName != null && !"".equals(submitName.trim()) && "Alefa".equalsIgnoreCase(submitName)){
			try{
				addMode = fifidianana.getId() == null;
				if (fifidianana.isFifidiananaOloTokana())
					fifidianana.setIsaOlonaFidiana(null);
				
				fFjkmService.saveFifidianana(fifidianana, Utils.getLoggedUserName());
			}
			catch(RuntimeException e){
				message = e.getMessage();				
				ModelAndView modelAndView = new ModelAndView(new RedirectView(req.getContextPath()+"/admin/editFifidianana.htm?fifidiananaId="+formulaire.getId()+"&message="+URLEncoder.encode(message, "utf-8")));
				
				return modelAndView;
			}
		}
		else if (submitName != null && !"".equals(submitName.trim()) && "Ajanony".equalsIgnoreCase(submitName)){
			fifidianana.setManomboka(false);
			fFjkmService.saveFifidianana(fifidianana, Utils.getLoggedUserName());
		}
		else if (submitName != null && !"".equals(submitName.trim()) && "Atombohy".equalsIgnoreCase(submitName)){
			fifidianana.setManomboka(true);
			fFjkmService.saveFifidianana(fifidianana, Utils.getLoggedUserName());
		}
		
		req.setAttribute(ConstantUtils.sfSaveableEntity, null);
		
		Utils.setSelectedTab(req, ConstantUtils.sfAccessFifidianana);

		datas.put(ConstantUtils.sfMessageEnregistrementOK, true);
		if (!addMode)
			message = "Voaray ny fanovàna amin'ny Fifidianana";
		else
			message = "Tafiditra ny Fifidianana vaovao";
			
		datas.put(ConstantUtils.sfMessageContent, message);
		datas.put(ConstantUtils.sfEditedFromSearch, formulaire.isFromSearch());

		ModelAndView modelAndView = new ModelAndView(new RedirectView(req.getContextPath()+"/secure/index.htm?fifidianana"));
		
		//Ré-initialiser la session
		Utils.setMpivavakaInSession(req, null);
		
		return modelAndView;
	}
	
	@Override
	protected Object formBackingObject(HttpServletRequest req) throws Exception {
		Fifidianana fifidianana = null;
		
		if (req.getParameter(ConstantUtils.sfFifidiananaId) != null && !"".equals(req.getParameter(ConstantUtils.sfFifidiananaId).trim())){
			Long fifidiananaId = Long.parseLong(req.getParameter(ConstantUtils.sfFifidiananaId).trim());
			fifidianana = fFjkmService.findFifidianana(fifidiananaId);
			req.setAttribute(ConstantUtils.sfSaveableEntity, fifidianana);
			String message = req.getParameter("message");
			if (message != null && !"".equals(message.trim())){
				req.setAttribute(ConstantUtils.sfMessageEnregistrementKO, true);
				req.setAttribute("message", URLDecoder.decode(message, "utf-8"));
			}
		}
		else{
			//Fifidianana par défaut pour Fjkm Ankadifotsy , date de début des dépôts de candidatures aujourd'hui, date de clôture candidature dans 1 mois
			fifidianana = new Fifidianana(fFjkmService.findFitandremanaById(1L), new Date(), Utils.add(new Date(), Calendar.MONTH, 1), null, null);
		}
		
		FormFifidianana formulaire = new FormFifidianana(fifidianana);
		
		return formulaire;
	}
	
	protected void initBinder(HttpServletRequest req, ServletRequestDataBinder binder) throws Exception {
	    binder.registerCustomEditor(Date.class, new DatePropertyEditorSupport());
	    
	    binder.registerCustomEditor(Integer.class, new IntegerPropertyEditorSupport());

	    binder.registerCustomEditor(Double.class, new DoublePropertyEditorSupport());

	    binder.registerCustomEditor(Fitandremana.class, new FitandremanaPropertyEditorSupport(fFjkmService));

	    binder.registerCustomEditor(TaomPanompoana.class, new TaomPanompoanaPropertyEditorSupport(fFjkmService));

	    binder.registerCustomEditor(KarazamPifidianana.class, new KarazamPifidiananaPropertyEditorSupport(fFjkmService));
	}

}
