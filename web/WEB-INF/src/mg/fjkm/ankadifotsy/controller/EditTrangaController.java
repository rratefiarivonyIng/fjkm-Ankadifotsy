/**
 * 
 */
package mg.fjkm.ankadifotsy.controller;

import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mg.fjkm.ankadifotsy.bo.Fitandremana;
import mg.fjkm.ankadifotsy.bo.KarazaTranga;
import mg.fjkm.ankadifotsy.bo.Mpivavaka;
import mg.fjkm.ankadifotsy.bo.Tranga;
import mg.fjkm.ankadifotsy.bo.User;
import mg.fjkm.ankadifotsy.controller.propertyEditor.DatePropertyEditorSupport;
import mg.fjkm.ankadifotsy.controller.propertyEditor.DoublePropertyEditorSupport;
import mg.fjkm.ankadifotsy.controller.propertyEditor.FitandremanaPropertyEditorSupport;
import mg.fjkm.ankadifotsy.controller.propertyEditor.LongPropertyEditorSupport;
import mg.fjkm.ankadifotsy.form.FormTranga;
import mg.fjkm.ankadifotsy.service.FjkmAnkadifotsyService;
import mg.fjkm.ankadifotsy.util.ConstantUtils;
import mg.fjkm.ankadifotsy.util.Utils;

import org.apache.commons.lang.NotImplementedException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * Controleur pour la saisie des informations concernant un Batisa d'un Chrétien.
 * @NOTE ce contrôleur ne devrait jamais être appelé QUE depuis le formulaire d'édition d'un Mpivavak
 * AUTREMENT DIT : un Mpivavaka est déjà positionné en SESSION ET c'est ce Mpivavaka qui va être associé au Batisa
 * en cours d'édition
 * @author rija
 * @version 1.0
 */
public class EditTrangaController extends SimpleFormController{
	/** Logger for this class and subclasses */    
	protected final Log logger = LogFactory.getLog(getClass());

	private FjkmAnkadifotsyService fFjkmService = null;
		
	public void setFjkmAnkadifotsyService(FjkmAnkadifotsyService nifService) {
		fFjkmService = nifService;
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest req, HttpServletResponse rep, Object command, BindException ex) throws Exception {
		FormTranga formulaire = (FormTranga)command;

		Mpivavaka mpivavaka = Utils.getMpivavakaFromSession(req);
		Tranga tranga = formulaire.getTranga();
		KarazaTranga karazaTranga = tranga.getKarazaTranga();
			
		//Info de création / modification diakona
		User user = fFjkmService.getUser(Utils.getLoggedUserName());
		Date now = new Date();
		if (tranga.getId() == null){
			tranga.setCreateInfo(now, user);
			mpivavaka.addTranga(tranga);
		}
		else
			tranga.setModificationInfo(now, user);
		
		req.setAttribute(ConstantUtils.sfSaveableEntity, mpivavaka);

		Utils.setSelectedTab(req, ConstantUtils.sfAccessMpivavaka);
		
		//idKarazaTranga permettra de mettre à jour par javascript (à la volée) la valeur affichée dans la fiche addChristian.jsp pour Batisa ou Mpandray en fonction du Tranga en cours d'édition
		ModelAndView modelAndView = null;
		
		if (formulaire.isPopup())
			modelAndView = new ModelAndView("secure/closeTrangaPopup", "idKarazaTranga", karazaTranga.getId().equals(KarazaTranga.sfLONG_BATISA) ? "batisaId":"mpandrayId");
		else
			modelAndView = new ModelAndView("secure/closeTranga", "idKarazaTranga", karazaTranga.getId().equals(KarazaTranga.sfLONG_BATISA) ? "batisaId":"mpandrayId");
		
		return modelAndView;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected Object formBackingObject(HttpServletRequest req) throws Exception {
		Mpivavaka mpivavaka = Utils.getMpivavakaFromSession(req);
		Enumeration<String> attributeNames = req.getParameterNames();
		
		boolean trangaBatisa = false;
		boolean trangaMpandray = false;
		boolean popup = false;
		while (attributeNames.hasMoreElements()){
			String attrName = attributeNames.nextElement();
			if (ConstantUtils.sfTRANGA_BATISA.equals(attrName))
				trangaBatisa = true;
			
			if (ConstantUtils.sfTRANGA_MPANDRAY.equals(attrName))
				trangaMpandray = true;

			if ("popup".equalsIgnoreCase(attrName))
				popup = true;
		}
		
		KarazaTranga karazaTranga = null;
		if (trangaBatisa)
			karazaTranga = KarazaTranga.sfKarazaTrangaBatisa;
		else if (trangaMpandray)
			karazaTranga = KarazaTranga.sfKarazaTrangaMpandray;
		else
			throw new NotImplementedException();
		
		if (mpivavaka == null)
			throw new RuntimeException("Un Mpivavaka doit être positionné en session avant de pouvoir saisir un Batisa (cf EditChristianController.formBackingObject(...)).");
		
		if (mpivavaka.getId() == null){
			Fitandremana ankadifotsy = fFjkmService.findFitandremanaById(1L);
			mpivavaka.setFitandremana(ankadifotsy);
		}
		
		FormTranga formulaire = (FormTranga)req.getSession().getAttribute(FormTranga.sfFORM_ID);
		if (formulaire == null)
			formulaire = new FormTranga(mpivavaka, karazaTranga);
		else
			formulaire.setMpivavaka(mpivavaka, karazaTranga);

		formulaire.setPopup(popup);
		
		if (formulaire.getTranga().getId() != null)
			req.setAttribute(ConstantUtils.sfSaveableEntity, formulaire.getTranga());

		if (trangaBatisa){
			formulaire.setTitle("Batisa");
			formulaire.setLabel("Batisa natao :");
		}
		else if (trangaMpandray){
			formulaire.setTitle("Mpandray Fanasan'ny Tompo");
			formulaire.setLabel("Fanamasinana Mpandray natao :");
		}
		else
			throw new NotImplementedException();

		Utils.setSelectedTab(req, ConstantUtils.sfAccessMpivavaka);
		
		if (popup)
			super.setFormView("secure/editTrangaPopup");
		else
			super.setFormView("secure/editTranga");
			
		return formulaire;
	}
	
	@Override
	protected Map<String, Object> referenceData(HttpServletRequest req) throws Exception {
		Map<String, Object> datas = new HashMap<String, Object>();
		
		//Charger la liste des Formes juridiques
		List<Fitandremana> fitandremana = fFjkmService.findAllFitandremana();
		datas.put(ConstantUtils.sfDATA_FITANDREMANAS, fitandremana);
		
		return datas;
	}

	protected void initBinder(HttpServletRequest req, ServletRequestDataBinder binder) throws Exception {
	    binder.registerCustomEditor(Date.class, new DatePropertyEditorSupport());
	    
	    binder.registerCustomEditor(Long.class, new LongPropertyEditorSupport());

	    binder.registerCustomEditor(Double.class, new DoublePropertyEditorSupport());

	    binder.registerCustomEditor(Fitandremana.class, new FitandremanaPropertyEditorSupport(fFjkmService));	    
	}

}
