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
import mg.fjkm.ankadifotsy.bo.Fanambadiana;
import mg.fjkm.ankadifotsy.bo.Faritra;
import mg.fjkm.ankadifotsy.bo.Firaisana;
import mg.fjkm.ankadifotsy.bo.Fitandremana;
import mg.fjkm.ankadifotsy.bo.Mpivavaka;
import mg.fjkm.ankadifotsy.controller.propertyEditor.AntonAsaPropertyEditorSupport;
import mg.fjkm.ankadifotsy.controller.propertyEditor.DatePropertyEditorSupport;
import mg.fjkm.ankadifotsy.controller.propertyEditor.DoublePropertyEditorSupport;
import mg.fjkm.ankadifotsy.controller.propertyEditor.FaritraPropertyEditorSupport;
import mg.fjkm.ankadifotsy.controller.propertyEditor.FiraisanaPropertyEditorSupport;
import mg.fjkm.ankadifotsy.controller.propertyEditor.FitandremanaPropertyEditorSupport;
import mg.fjkm.ankadifotsy.controller.propertyEditor.LongPropertyEditorSupport;
import mg.fjkm.ankadifotsy.controller.propertyEditor.MpivavakaPropertyEditorSupport;
import mg.fjkm.ankadifotsy.form.FormChristian;
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
 * Controleur pour la saisie des informations concernant un Chrétien
 * @author rija
 * @version 1.0
 */
public class EditChristianController extends SimpleFormController{
	/** Logger for this class and subclasses */    
	protected final Log logger = LogFactory.getLog(getClass());

	private FjkmAnkadifotsyService fFjkmService = null;
		
	public void setFjkmAnkadifotsyService(FjkmAnkadifotsyService nifService) {
		fFjkmService = nifService;
	}

	@Override
	protected ModelAndView processFormSubmission(HttpServletRequest req, HttpServletResponse resp, Object command, BindException errors) throws Exception {
		if (errors.hasErrors())
			req.setAttribute(ConstantUtils.sfMessageEnregistrementKO, true);
		return super.processFormSubmission(req, resp, command, errors);
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest req, HttpServletResponse rep, Object command, BindException ex) throws Exception {
		FormChristian formulaire = (FormChristian)command;
		String submitName = req.getParameter("Valider");

		boolean addMode = false;
		if (submitName != null && !"".equals(submitName.trim()) && "Alefa".equalsIgnoreCase(submitName)){
			Mpivavaka mpivavaka = formulaire.getMpivavaka();
			addMode = mpivavaka.getId() == null;
			if (mpivavaka.getId() != null && !formulaire.getOldName().equals(mpivavaka.getAnarana())){
				String oldName = Utils.getPhotoName(formulaire.getOldName(), mpivavaka.getId());
				Utils.renamePhotoName(req, oldName, Utils.getPhotoName(mpivavaka.getAnarana(), mpivavaka.getId()));
			}
			
			Fanambadiana fanambadiana = null;
			Mpivavaka vadyTaloha = null;
			//On ne modifie pas le vady QUE par une autre instance de Vady et non par un simple nom (lien de mariage entre 2 Mpivavaka)
			if (formulaire.getVady() != null || (formulaire.getMpivavakaAnaranaVady() != null && !formulaire.getMpivavakaAnaranaVady().trim().equals(""))){
				if (formulaire.getVady() != null && formulaire.getMpivavakaAnaranaVady() != null){
					String anaranaVady = Utils.getTrimmedString(formulaire.getMpivavakaAnaranaVady());
					String anaranaVady_ = Utils.getTrimmedString(formulaire.getVady().getAnarana().trim())+Utils.getTrimmedString(formulaire.getVady().getFanampiny().trim());
					if (!anaranaVady.equalsIgnoreCase(anaranaVady_))
						formulaire.setVady(null);
				}
				
				fanambadiana = mpivavaka.getFanambadiana();
				if (fanambadiana == null){
					//Il faut d'abord chercher qu'il n'existe déjà une instance de Fanambadiana du côté de formulaire.getVady()
					//Si une telle instance n'existe pas encore, alors on crée l'instance et on lie les 2 Mpivavaka par Fanambadiana					
					if (formulaire.getVady() != null){
						fanambadiana = fFjkmService.findFanambadianaByMpivavaka(formulaire.getVady());
						if (fanambadiana == null)
							fanambadiana = Fanambadiana.createFanambadiana(mpivavaka, formulaire.getVady(), formulaire.getDatyFanambadiana(), null,formulaire.getFitandremanaFanambadiana());
						else{
							//On peut modifier uniquement le vady si et seulement si pas de Vady de type Mpivavaka associé à Fanambadiana
							if ((formulaire.getVady().equals(fanambadiana.getVady()) && fanambadiana.getMpivavaka() == null)
																	||
								(formulaire.getVady().equals(fanambadiana.getMpivavaka()) && fanambadiana.getVady() == null))
								fanambadiana.setVadyOrMpivavaka(mpivavaka, formulaire.getVady());
							else
								throw new RuntimeException("Tsy azo ovaina ny mpivady.");
						}
					}
					else
						fanambadiana = Fanambadiana.createFanambadiana(mpivavaka, formulaire.getMpivavakaAnaranaVady(), formulaire.getDatyFanambadiana(), null,formulaire.getFitandremanaFanambadiana());	
				}
				else{
					vadyTaloha = fanambadiana.getVady(mpivavaka);
					if (vadyTaloha != null)
						vadyTaloha = fFjkmService.findMpivavakaById(vadyTaloha.getId());
					
					if (vadyTaloha != null){
						if (formulaire.getVady() != null){
							if (!vadyTaloha.equals(formulaire.getVady())){
								vadyTaloha.removeFanambadiana(fanambadiana);
								fanambadiana.replaceVady(formulaire.getVady(), vadyTaloha);
							}
							else{
								//on ne fait rien car le vady n'a pas changé
								vadyTaloha = null;
							}
						}
						else{
							//le vady de type Mpivavaka va être remplacé par un simple nom + prénom qui n'est pas encore un Mpivavaka au sens base de données
							vadyTaloha.removeFanambadiana(fanambadiana);
							fanambadiana.setAnaranaVady(formulaire.getMpivavakaAnaranaVady(), vadyTaloha);
						}
					}
					else{
						if (formulaire.getVady() != null){
							if (formulaire.getVady().isManambady() && !fanambadiana.equals(formulaire.getVady().getFanambadiana()))
								throw new RuntimeException("Efa manambady i "+formulaire.getVady().getAnarana()+" "+formulaire.getVady().getFanampiny());
							fanambadiana.setVadyOrMpivavaka(formulaire.getVady(), mpivavaka);
						}
						else
							fanambadiana.setAnaranaVady(mpivavaka, formulaire.getMpivavakaAnaranaVady());
					}
				}
			}
			
			mpivavaka.checkAnaranaRayWithRay_();
			mpivavaka.checkAnaranaRenyWithReny_();
			
			mpivavaka = fFjkmService.saveMpivavaka(formulaire.getMpivavaka(), formulaire.getVady(), vadyTaloha, fanambadiana, Utils.getLoggedUserName());

			formulaire.setMpivavaka(mpivavaka);
		}
		
		req.setAttribute(ConstantUtils.sfSaveableEntity, null);
		
		Utils.setSelectedTab(req, ConstantUtils.sfAccessMpivavaka);

		Map<String, Object> datas = new HashMap<String, Object>();
		datas.put(ConstantUtils.sfMessageEnregistrementOK, true);
		String message = "Vita soa aman-tsara ny fangatahanao";
		if (addMode)
			message = "Tafiditra ny mpivavaka No ["+formulaire.getMpivavaka().getId()+"] <b>"+formulaire.getMpivavaka().getAnarana()+" "+formulaire.getMpivavaka().getFanampiny()+"</b>";
		else
			message = "Voaray ny fanitsina natao tamin'ny mpivavaka No ["+formulaire.getMpivavaka().getId()+"] <b>"+formulaire.getMpivavaka().getAnarana()+" "+formulaire.getMpivavaka().getFanampiny()+"</b>";
		datas.put(ConstantUtils.sfMessageContent, message);
		
		datas.put(ConstantUtils.sfEditedFromSearch, formulaire.isFromSearch());

		ModelAndView modelAndView = new ModelAndView("secure/mpivavaka", datas);
		
		//Ré-initialiser la session
		Utils.setMpivavakaInSession(req, null);
		
		return modelAndView;
	}
	
	@Override
	protected Object formBackingObject(HttpServletRequest req) throws Exception {
		String laharana = (String)req.getParameter(ConstantUtils.sfLaharana);
		String idStr = (String)req.getParameter(ConstantUtils.sfId);
		String selectedTab = Utils.getSelectedTab(req);
		Mpivavaka mpivavaka = null;
		if ((laharana == null || "".equals(laharana.trim())) && (idStr == null || "".equals(idStr.trim())))
			mpivavaka = new Mpivavaka();								//Mode création
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

		if (mpivavaka.getId() == null){
			Fitandremana ankadifotsy = fFjkmService.findFitandremanaById(1L);
			mpivavaka.setFitandremana(ankadifotsy);
		}
		
		FormChristian formulaire = (FormChristian)req.getSession().getAttribute(FormChristian.sfFORM_ID);
		if (formulaire == null)
			formulaire = new FormChristian(mpivavaka);
		else
			formulaire.setMpivavaka(mpivavaka);
		
		Utils.setMpivavakaInSession(req, formulaire.getMpivavaka());
		
		Utils.setSelectedTab(req, selectedTab);
		if (ConstantUtils.sfAccessFifidianana.equals(selectedTab))
			req.setAttribute(ConstantUtils.sfREQUEST_FIFIDIANANA, Utils.getFifidiananaFromSession(req));

		formulaire.setFromSearch(Utils.isFromSearch(req));
			
		return formulaire;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected Map referenceData(HttpServletRequest req) throws Exception {
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
	    
	    binder.registerCustomEditor(Firaisana.class, new FiraisanaPropertyEditorSupport(fFjkmService));
	    
	    binder.registerCustomEditor(Faritra.class, new FaritraPropertyEditorSupport(fFjkmService));

	    binder.registerCustomEditor(AntonAsa.class, new AntonAsaPropertyEditorSupport(fFjkmService));
	    
	    binder.registerCustomEditor(Mpivavaka.class, new MpivavakaPropertyEditorSupport(fFjkmService));
	}

}
