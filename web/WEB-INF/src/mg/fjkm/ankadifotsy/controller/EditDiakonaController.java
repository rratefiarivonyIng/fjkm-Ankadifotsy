/**
 * 
 */
package mg.fjkm.ankadifotsy.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mg.fjkm.ankadifotsy.bo.AntonAsa;
import mg.fjkm.ankadifotsy.bo.Diakona;
import mg.fjkm.ankadifotsy.bo.Faritra;
import mg.fjkm.ankadifotsy.bo.Firaisana;
import mg.fjkm.ankadifotsy.bo.Fitandremana;
import mg.fjkm.ankadifotsy.bo.Mpivavaka;
import mg.fjkm.ankadifotsy.bo.TaomPanompoana;
import mg.fjkm.ankadifotsy.bo.User;
import mg.fjkm.ankadifotsy.controller.propertyEditor.AntonAsaPropertyEditorSupport;
import mg.fjkm.ankadifotsy.controller.propertyEditor.DatePropertyEditorSupport;
import mg.fjkm.ankadifotsy.controller.propertyEditor.DoublePropertyEditorSupport;
import mg.fjkm.ankadifotsy.controller.propertyEditor.FaritraPropertyEditorSupport;
import mg.fjkm.ankadifotsy.controller.propertyEditor.FiraisanaPropertyEditorSupport;
import mg.fjkm.ankadifotsy.controller.propertyEditor.FitandremanaPropertyEditorSupport;
import mg.fjkm.ankadifotsy.controller.propertyEditor.LongPropertyEditorSupport;
import mg.fjkm.ankadifotsy.controller.propertyEditor.TaomPanompoanaPropertyEditorSupport;
import mg.fjkm.ankadifotsy.form.FormDiakona;
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
 * Controleur pour la saisie des informations concernant un Diakona
 * @author rija
 * @version 1.0
 */
public class EditDiakonaController extends SimpleFormController{
	/** Logger for this class and subclasses */    
	protected final Log logger = LogFactory.getLog(getClass());

	private FjkmAnkadifotsyService fFjkmService = null;
		
	public void setFjkmAnkadifotsyService(FjkmAnkadifotsyService nifService) {
		fFjkmService = nifService;
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest req, HttpServletResponse rep, Object command, BindException ex) throws Exception {
		FormDiakona formulaire = (FormDiakona)command;
		String submitName = req.getParameter("Valider");
		boolean addMode = false;
		if (submitName != null && !"".equals(submitName.trim()) && "Alefa".equalsIgnoreCase(submitName)){
			Mpivavaka mpivavaka = formulaire.getMpivavaka();
			Diakona diakona = formulaire.getDiakona();
			addMode = diakona.getId() == null;
			
			//Info de création / modification diakona
			User user = fFjkmService.getUser(Utils.getLoggedUserName());
			if (diakona.getId() == null)
				diakona.setCreateInfo(new Date(), user);
			else
				diakona.setModificationInfo(new Date(), user);
			
			mpivavaka.addDiakona(diakona);
			mpivavaka = fFjkmService.saveMpivavaka(mpivavaka, Utils.getLoggedUserName());
			formulaire.setMpivavaka(mpivavaka);
		}
		req.setAttribute(ConstantUtils.sfSaveableEntity, null);
		Utils.setSelectedTab(req, ConstantUtils.sfAccessDiakona);

		Map<String, Object> datas = new HashMap<String, Object>();
		datas.put(ConstantUtils.sfMessageEnregistrementOK, true);
		String message = "Vita soa aman-tsara ny fangatahanao";
		if (addMode)
			message = "Lasa diakona ny mpivavaka <b>"+formulaire.getMpivavaka().getAnarana()+" "+formulaire.getMpivavaka().getFanampiny()+"</b> amin'ny taom-panompoana ["+formulaire.getDiakona().getTaomPanompoana().toString()+"]";
		else
			message = "Voaray ny fanitsina natao tamin'ny diakona <b>"+formulaire.getMpivavaka().getAnarana()+" "+formulaire.getMpivavaka().getFanampiny()+"</b> amin'ny taom-panompoana ["+formulaire.getDiakona().getTaomPanompoana().toString()+"]";
		datas.put(ConstantUtils.sfMessageContent, message);
		
		datas.put(ConstantUtils.sfEditedFromSearch, formulaire.isFromSearch());

		ModelAndView modelAndView = new ModelAndView("secure/diakona", datas);
		
		return modelAndView;
	}
	
	@Override
	protected Object formBackingObject(HttpServletRequest req) throws Exception {
		String laharana = (String)req.getParameter(ConstantUtils.sfLaharana);
		String idStr = (String)req.getParameter(ConstantUtils.sfId);
		String selectedTab = Utils.getSelectedTab(req);
		
		Mpivavaka mpivavaka = null;
		if ((laharana == null || "".equals(laharana.trim())) && (idStr == null || "".equals(idStr.trim())))
			throw new IllegalArgumentException();
		else{
			if (laharana != null && !"".equals(laharana.trim())){
				mpivavaka = fFjkmService.findMpivavakaByLaharana(laharana);	//Mode édition
			}
			else{
				Long id = Long.parseLong(idStr);
				mpivavaka = fFjkmService.findMpivavakaById(id);	//Mode édition
			}
			req.setAttribute(ConstantUtils.sfSaveableEntity, mpivavaka);
		}

		FormDiakona formulaire = new FormDiakona(mpivavaka);
		
		Diakona diakona = null;
		Date now = new Date();
		if (mpivavaka.isDiakona(now))
			diakona = mpivavaka.getDiakona(now);
		else{
			Fitandremana fitandremanaAnkadifotsy = fFjkmService.findFitandremanaById(Fitandremana.sfIntFitandremanaAnkadifotsy);
			TaomPanompoana taomPanompoana = fFjkmService.findTaomPanompoanaByDate(now);
			//diakona = mpivavaka.addDiakona(taomPanompoana, fitandremanaAnkadifotsy);
			diakona = new Diakona(mpivavaka, fitandremanaAnkadifotsy, taomPanompoana);
		}
		formulaire.setDiakona(diakona);
		
		Utils.setSelectedTab(req, selectedTab);
		
		if (ConstantUtils.sfAccessFifidianana.equals(selectedTab))
			req.setAttribute(ConstantUtils.sfREQUEST_FIFIDIANANA, Utils.getFifidiananaFromSession(req));
		
		formulaire.setFromSearch(Utils.isFromSearch(req));
		
		return formulaire;
	}
	
	@Override
	protected Map<String, Object> referenceData(HttpServletRequest req) throws Exception {
		Map<String, Object> datas = new HashMap<String, Object>();
		
		//Charger la liste des Formes juridiques
		List<Fitandremana> fitandremanas = fFjkmService.findAllFitandremana();
		datas.put(ConstantUtils.sfDATA_FITANDREMANAS, fitandremanas);
		
		List<TaomPanompoana> taompanompoanas = fFjkmService.findTaomPanompoanasWithoutDaty(new Date());
		datas.put(ConstantUtils.sfDATA_TAOMPANOMPOANAS, taompanompoanas);
		
		return datas;
	}

	protected void initBinder(HttpServletRequest req, ServletRequestDataBinder binder) throws Exception {
	    binder.registerCustomEditor(Date.class, new DatePropertyEditorSupport());
	    
	    binder.registerCustomEditor(Long.class, new LongPropertyEditorSupport());

	    binder.registerCustomEditor(Double.class, new DoublePropertyEditorSupport());

	    binder.registerCustomEditor(Fitandremana.class, new FitandremanaPropertyEditorSupport(fFjkmService));
	    
	    binder.registerCustomEditor(Firaisana.class, new FiraisanaPropertyEditorSupport(fFjkmService));
	    
	    binder.registerCustomEditor(Faritra.class, new FaritraPropertyEditorSupport(fFjkmService));

	    binder.registerCustomEditor(TaomPanompoana.class, new TaomPanompoanaPropertyEditorSupport(fFjkmService));

	    binder.registerCustomEditor(AntonAsa.class, new AntonAsaPropertyEditorSupport(fFjkmService));
	}

}
