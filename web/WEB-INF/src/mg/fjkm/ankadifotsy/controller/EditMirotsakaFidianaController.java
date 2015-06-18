/**
 * 
 */
package mg.fjkm.ankadifotsy.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mg.fjkm.ankadifotsy.bo.AntonAsa;
import mg.fjkm.ankadifotsy.bo.Faritra;
import mg.fjkm.ankadifotsy.bo.Fifidianana;
import mg.fjkm.ankadifotsy.bo.Firaisana;
import mg.fjkm.ankadifotsy.bo.Fitandremana;
import mg.fjkm.ankadifotsy.bo.MirotsakaFidiana;
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
import mg.fjkm.ankadifotsy.form.FormMirotsakaFidiana;
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
 * Controleur pour la saisie des informations concernant une Candidature pour une élection
 * @author rija
 * @version 1.0
 */
public class EditMirotsakaFidianaController extends SimpleFormController{
	/** Logger for this class and subclasses */    
	protected final Log logger = LogFactory.getLog(getClass());

	private FjkmAnkadifotsyService fFjkmService = null;
		
	public void setFjkmAnkadifotsyService(FjkmAnkadifotsyService nifService) {
		fFjkmService = nifService;
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest req, HttpServletResponse rep, Object command, BindException ex) throws Exception {
		FormMirotsakaFidiana formulaire = (FormMirotsakaFidiana)command;
		Fifidianana fifidianana = Utils.getFifidiananaFromSession(req);
		Mpivavaka mpivavaka = formulaire.getMpivavaka();
		String submitName = req.getParameter("Valider");
		boolean addMode = false;
		String message = "Vita soa aman-tsara ny fangatahanao";
		if (submitName != null && !"".equals(submitName.trim())){
			MirotsakaFidiana mirotsakaFidiana = formulaire.getMirotsakaFidiana();
			
			//Info de création / modification diakona
			User user = fFjkmService.getUser(Utils.getLoggedUserName());
			if (mirotsakaFidiana.getId() == null)
				mirotsakaFidiana.setCreateInfo(new Date(), user);
			else
				mirotsakaFidiana.setModificationInfo(new Date(), user);

			if ("Mirotsaka".equalsIgnoreCase(submitName)){
				assert mirotsakaFidiana.getId() == null;
				if (addMode)
					message = "Voaray ny firotsahana hofidiana ny mpivavaka <b>"+mpivavaka.getAnarana()+" "+mpivavaka.getFanampiny()+"</b> amin'ny taom-panompoana ["+formulaire.getTaomPanompoana().toString()+"]";
				else
					message = "Voaray ny fanitsina natao tamin'ny firotsahana hofidiana <b>"+mpivavaka.getAnarana()+" "+mpivavaka.getFanampiny()+"</b> amin'ny taom-panompoana ["+formulaire.getTaomPanompoana().toString()+"]";				
			}
			else if ("Ekena".equalsIgnoreCase(submitName)){
				assert mirotsakaFidiana.getId() != null;
				mirotsakaFidiana.setEkenaFirotsahana(true);
				message = "Ekena ny firotsahana ho fidiana "+fifidianana.getKarazamPifidianana().getLabel()+" ny <b>"+mpivavaka.getAnarana()+" "+mpivavaka.getFanampiny()+"</b> amin'ny taom-panompoana ["+formulaire.getTaomPanompoana().toString()+"]";
			}
			else if ("Lavina".equalsIgnoreCase(submitName)){
				assert mirotsakaFidiana.getId() != null;
				mirotsakaFidiana.setEkenaFirotsahana(false);
				message = "Lavina ny firotsahana ho fidiana "+fifidianana.getKarazamPifidianana().getLabel()+" ny <b>"+mpivavaka.getAnarana()+" "+mpivavaka.getFanampiny()+"</b> amin'ny taom-panompoana ["+formulaire.getTaomPanompoana().toString()+"]";
			}
			mirotsakaFidiana = fFjkmService.saveMirotsakaFidiana(mirotsakaFidiana);				
			formulaire.setMirotsakaFidiana(mirotsakaFidiana);
		}
		
		req.setAttribute(ConstantUtils.sfSaveableEntity, null);
		Utils.setSelectedTab(req, ConstantUtils.sfAccessFifidianana);

		ModelAndView modelAndView = null;
		
		if (formulaire.isFromSearch()){
			req.setAttribute(ConstantUtils.sfMessageEnregistrementOK, true);
			req.setAttribute(ConstantUtils.sfMessageContent, message);
			req.setAttribute(ConstantUtils.sfEditedFromSearch, formulaire.isFromSearch());
			modelAndView = new ModelAndView(new RedirectView(formulaire.getFrom()+"&from="+Utils.getSelectedTab(req)));
		}
		else{
			Map<String, Object> datas = new HashMap<String, Object>();
			datas.put(ConstantUtils.sfMessageEnregistrementOK, true);
			datas.put(ConstantUtils.sfMessageContent, message);
			datas.put(ConstantUtils.sfEditedFromSearch, formulaire.isFromSearch());
			modelAndView = new ModelAndView("secure/diakona", datas);
		}
		
		return modelAndView;
	}
	
	@Override
	protected Object formBackingObject(HttpServletRequest req) throws Exception {
		String laharana = (String)req.getParameter(ConstantUtils.sfLaharana);
		String idStr = (String)req.getParameter(ConstantUtils.sfId);
		String idMirotsakaFidianaStr = (String)req.getParameter(ConstantUtils.sfMirotsakaFidianaId);
		String selectedTab = Utils.getSelectedTab(req);
		
		Fifidianana fifidianana = Utils.getFifidiananaFromSession(req);
		if (fifidianana == null)
			throw new RuntimeException("Mila misafidy fifidianana aloha vao afaka mampiditra candidat.");

		MirotsakaFidiana mirotsakaFidiana = null;
		Mpivavaka mpivavaka = null;
		if ((laharana == null || "".equals(laharana.trim())) && (idStr == null || "".equals(idStr.trim())) && (idMirotsakaFidianaStr == null || "".equals(idMirotsakaFidianaStr.trim())))
			throw new IllegalArgumentException();
		else{
			if (idMirotsakaFidianaStr != null && !"".equals(idMirotsakaFidianaStr.trim())){
				Long idMirotsakaFidiana = Long.parseLong(idMirotsakaFidianaStr);
				mirotsakaFidiana = fFjkmService.findMirotsakaFidianaById(idMirotsakaFidiana);
				mpivavaka = fFjkmService.findMpivavakaById(mirotsakaFidiana.getMpivavaka().getId());
				//Pour éviter des pb de lazy
				mirotsakaFidiana.setMpivavaka(mpivavaka);
				mirotsakaFidiana.setFifidianana(fifidianana);
			}
			else{
				if (laharana != null && !"".equals(laharana.trim())){
					mpivavaka = fFjkmService.findMpivavakaByLaharana(laharana);	//Mode édition
				}
				else if (idStr != null && !"".equals(idStr.trim())){
					Long id = Long.parseLong(idStr);
					mpivavaka = fFjkmService.findMpivavakaById(id);	//Mode édition
				}
				else
					throw new RuntimeException("Mila misafidy mpivavaka");
				
				mirotsakaFidiana = new MirotsakaFidiana(mpivavaka, fifidianana, new Date());
			}
			
			if (mirotsakaFidiana.getId() != null)
				req.setAttribute(ConstantUtils.sfSaveableEntity, mirotsakaFidiana);
			else
				req.setAttribute(ConstantUtils.sfSaveableEntity, null);
		}
		
		FormMirotsakaFidiana formulaire = new FormMirotsakaFidiana (mirotsakaFidiana);
		formulaire.setFrom((String)req.getParameter(ConstantUtils.sfEditedFromSearch));
				
		Utils.setSelectedTab(req, selectedTab);
		
		if (ConstantUtils.sfAccessFifidianana.equals(selectedTab))
			req.setAttribute(ConstantUtils.sfREQUEST_FIFIDIANANA, Utils.getFifidiananaFromSession(req));
		
		formulaire.setFromSearch(Utils.isFromSearch(req));
		
		return formulaire;
	}
	
	@Override
	protected Map<String, Object> referenceData(HttpServletRequest req) throws Exception {
		Map<String, Object> datas = new HashMap<String, Object>();

		/*
		//Charger la liste des Formes juridiques
		List<Fitandremana> fitandremanas = fFjkmService.findAllFitandremana();
		datas.put(ConstantUtils.sfDATA_FITANDREMANAS, fitandremanas);
		
		List<TaomPanompoana> taompanompoanas = fFjkmService.findTaomPanompoanasWithoutDaty(new Date());
		datas.put(ConstantUtils.sfDATA_TAOMPANOMPOANAS, taompanompoanas);
		*/
		
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
