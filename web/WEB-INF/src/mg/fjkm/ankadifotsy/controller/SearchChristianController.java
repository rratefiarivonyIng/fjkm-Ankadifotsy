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

import mg.fjkm.ankadifotsy.bo.AntonAsa;
import mg.fjkm.ankadifotsy.bo.Faritra;
import mg.fjkm.ankadifotsy.bo.Fifidianana;
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
import mg.fjkm.ankadifotsy.form.FormSearchChristian;
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
import org.springframework.web.servlet.view.RedirectView;

/**
 * Controleur pour la saisie des informations de recherche d'un Mpivavaka (ou Diakona)
 * 
 * @access : proteégé
 * @author rija
 * @version 1.0
 */
public class SearchChristianController extends SimpleFormController {
	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	private FjkmAnkadifotsyService fFjkmService = null;

	public void setFjkmAnkadifotsyService(FjkmAnkadifotsyService nifService) {
		fFjkmService = nifService;
	}

	/**
	 * Parse les critères de recherche saisi par l'utilisateur dans le
	 * formulaire
	 * 
	 * @param formulaire
	 * @return parameterNameValues <String, Object>, couple nom, valeur des
	 *         critères de recherche
	 */
	private Map<String, Object> parseParameters(FormSearchChristian formulaire) {
		Map<String, Object> parameterNameValues = new HashMap<String, Object>();
		parameterNameValues.put(ConstantUtils.sfCriteriaAnarana, formulaire.getAnarana());
		parameterNameValues.put(ConstantUtils.sfCriteriaFanampiny, formulaire.getFanampiny());
		parameterNameValues.put(ConstantUtils.sfCriteriaLaharana, formulaire.getLaharana());
		parameterNameValues.put(ConstantUtils.sfCriteriaVitaBatisa, formulaire.isVitaBatisa());
		parameterNameValues.put(ConstantUtils.sfCriteriaMpandray, formulaire.isMpandray());
		parameterNameValues.put(ConstantUtils.sfCriteriaLahy, formulaire.isLahy());
		parameterNameValues.put(ConstantUtils.sfCriteriaTalenta, formulaire.getTalenta());
		parameterNameValues.put(ConstantUtils.sfCriteriaAntonAsa, formulaire.getAntonAsa());
		parameterNameValues.put(ConstantUtils.sfCriteriaFitandremana, formulaire.getFitandremana());

		return parameterNameValues;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected ModelAndView onSubmit(HttpServletRequest req, HttpServletResponse rep, Object command, BindException ex) throws Exception {
		FormSearchChristian formulaire = (FormSearchChristian)command;
		
		String submitName = req.getParameter("Valider");
		if (submitName != null && !"".equals(submitName.trim()) && "Tadiavo".equalsIgnoreCase(submitName)){
			//ré-initilaliser le numéro de page courant du formulaire car l'utilisateur a modifié ses critères de recherche
			//et cliquer à nouveau sur le bouton Tadiavo.
			formulaire.setPageNo(0);
		}

		Fifidianana fifidianana = Utils.getFifidiananaFromSession(req);
		ModelAndView modelAndView = null;
		Map<String, Object> datas = loadDatas(formulaire, req);
		List<Mpivavaka> list = (List<Mpivavaka>)datas.get(ConstantUtils.sfDATA_MPIVAVAKAS);
		if ("Tadiavo".equalsIgnoreCase(submitName) && ConstantUtils.sfFromDiakona.equals(formulaire.getFrom()) && list.size() == 1 && list.get(0).isElligibleDiakona(fifidianana.getDatyFifidianana() != null ? fifidianana.getDatyFifidianana() : new Date())){
			//un seul résultat et recherche depuis le lien 'Hampiditra diakona' => ouvrir directement dans le formulaire si elligible
			Mpivavaka mpivavaka = list.get(0);
			modelAndView = new ModelAndView(new RedirectView("editDiakona.htm?id="+mpivavaka.getId()));
			Utils.setSelectedTab(req, ConstantUtils.sfAccessDiakona);
			req.setAttribute(ConstantUtils.sfSaveableEntity, mpivavaka);
		}
		else{
			req.setAttribute(ConstantUtils.sfSaveableEntity, null);
			if (formulaire.getFrom() == null || "".equals(formulaire.getFrom().trim()))
				Utils.setSelectedTab(req, ConstantUtils.sfAccessMpivavaka);
			else if (ConstantUtils.sfFromDiakona.equals(formulaire.getFrom()))
				Utils.setSelectedTab(req, ConstantUtils.sfAccessDiakona);
			else if (ConstantUtils.sfFromFifidianana.equals(formulaire.getFrom()))
				Utils.setSelectedTab(req, ConstantUtils.sfAccessFifidianana);
			else
				throw new NotImplementedException();
			
			modelAndView = new ModelAndView("secure/searchChristian", datas);
		}
		
		Utils.setFormulaireInSession(req, formulaire.getFormID(), formulaire);
		Utils.setCurrentSearchForm(req, formulaire);
		
		return modelAndView;
	}

	private Map<String, Object> loadDatas(FormSearchChristian formulaire, HttpServletRequest req) throws Exception{		
		Map<String, Object> parameterNameValues = parseParameters(formulaire);
		Integer nbElementPerPage = Utils.getNbElementPerPageFromParameter(req, fFjkmService);
		List<Mpivavaka> list = fFjkmService.findMpivavaka(parameterNameValues, formulaire.getPageNo(), nbElementPerPage);
		Map<String, Object> datas = referenceData(req);
		datas.put(FormSearchChristian.sfFORM_ID, formulaire);
		datas.put(ConstantUtils.sfDATA_MPIVAVAKAS, list);
		Long nbElements = fFjkmService.findNumberOfMpivavaka(parameterNameValues);
		
		Long pageTotal = Utils.getNbPageTotal(nbElements, nbElementPerPage);
		
		formulaire.setNbInstances(nbElements);
		formulaire.setNbElementsPerPage(new Long(nbElementPerPage));
		
		if (formulaire.getPageNo() > 0)
			formulaire.setPreviousPageNo(formulaire.getPageNo() - 1);
		if (formulaire.getPageNo() < pageTotal)
			formulaire.setNextPageNo(formulaire.getPageNo() + 1);
		
		//datas.put(ConstantUtils.sfDATA_NBPAGE_MAX, pageTotal);
		formulaire.setNbPageTotal(pageTotal.intValue());
		
		return datas;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected Object formBackingObject(HttpServletRequest req) throws Exception {
		FormSearchChristian formulaire = (FormSearchChristian)Utils.getFormulaireFromSession(req, FormSearchChristian.sfFORM_ID);
		if (formulaire == null){
			formulaire = new FormSearchChristian();
		
			formulaire.setPageNo(0);
			formulaire.setVitaBatisa(null);
			formulaire.setMpandray(null);
			formulaire.setLahy(null);

			Fitandremana ankadifotsy = fFjkmService.findFitandremanaById(Fitandremana.sfIntFitandremanaAnkadifotsy);
			formulaire.setFitandremana(ankadifotsy);
		}
		else{
			Enumeration<String> parameterNames = req.getParameterNames();
			formulaire.setSubmit(false);
			while (parameterNames.hasMoreElements()){
				if (parameterNames.nextElement().equalsIgnoreCase("submit"))
					formulaire.setSubmit(true);
			}
		}
		
		formulaire.setFrom((String) req.getParameter(ConstantUtils.sfPARAM_FROM));
		

		if (formulaire.getFrom() == null || "".equals(formulaire.getFrom().trim()))
			Utils.setSelectedTab(req, ConstantUtils.sfAccessMpivavaka);
		
		Utils.setCurrentSearchForm(req, formulaire);

		return formulaire;
	}

	@Override
	protected Map<String, Object> referenceData(HttpServletRequest req) throws Exception {
		Map<String, Object> datas = new HashMap<String, Object>();

		// Charger la liste des Formes juridiques
		//List<Fitandremana> fitandremana = fFjkmService.findAllFitandremana();
		//datas.put(ConstantUtils.sfDATA_FITANDREMANAS, fitandremana);

		return datas;
	}

	protected void initBinder(HttpServletRequest req,
			ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Date.class, new DatePropertyEditorSupport());

		binder.registerCustomEditor(Long.class, new LongPropertyEditorSupport());

		binder.registerCustomEditor(Double.class, new DoublePropertyEditorSupport());

		binder.registerCustomEditor(Fitandremana.class, new FitandremanaPropertyEditorSupport(fFjkmService));

		binder.registerCustomEditor(Firaisana.class, new FiraisanaPropertyEditorSupport(fFjkmService));

		binder.registerCustomEditor(Faritra.class, new FaritraPropertyEditorSupport(fFjkmService));

		binder.registerCustomEditor(AntonAsa.class, new AntonAsaPropertyEditorSupport(fFjkmService));
	}

}
