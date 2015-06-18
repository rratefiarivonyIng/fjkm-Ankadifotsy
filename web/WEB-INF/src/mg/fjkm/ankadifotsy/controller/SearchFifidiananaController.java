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

import mg.fjkm.ankadifotsy.bo.Fifidianana;
import mg.fjkm.ankadifotsy.bo.Fitandremana;
import mg.fjkm.ankadifotsy.bo.KarazamPifidianana;
import mg.fjkm.ankadifotsy.bo.TaomPanompoana;
import mg.fjkm.ankadifotsy.controller.propertyEditor.DatePropertyEditorSupport;
import mg.fjkm.ankadifotsy.controller.propertyEditor.DoublePropertyEditorSupport;
import mg.fjkm.ankadifotsy.controller.propertyEditor.FitandremanaPropertyEditorSupport;
import mg.fjkm.ankadifotsy.controller.propertyEditor.KarazamPifidiananaPropertyEditorSupport;
import mg.fjkm.ankadifotsy.controller.propertyEditor.LongPropertyEditorSupport;
import mg.fjkm.ankadifotsy.controller.propertyEditor.TaomPanompoanaPropertyEditorSupport;
import mg.fjkm.ankadifotsy.form.FormSearchFifidianana;
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
public class SearchFifidiananaController extends SimpleFormController {
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
	private Map<String, Object> parseParameters(FormSearchFifidianana formulaire) {
		Map<String, Object> parameterNameValues = new HashMap<String, Object>();
		parameterNameValues.put(ConstantUtils.sfCriteriaKarazampifidianana, formulaire.getKarazamPifidianana());
		parameterNameValues.put(ConstantUtils.sfCriteriaTaomPanompoana, formulaire.getTaomPanompoana());
		parameterNameValues.put(ConstantUtils.sfCriteriaFitandremana, formulaire.getFitandremana());
		parameterNameValues.put(ConstantUtils.sfCriteriaDatyManakatona, formulaire.getDatyManakatona());

		return parameterNameValues;
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest req, HttpServletResponse rep, Object command, BindException ex) throws Exception {
		FormSearchFifidianana formulaire = (FormSearchFifidianana)command;
		
		String submitName = req.getParameter("Valider");
		if (submitName != null && !"".equals(submitName.trim()) && "Tadiavo".equalsIgnoreCase(submitName)){
			//ré-initilaliser le numéro de page courant du formulaire car l'utilisateur a modifié ses critères de recherche
			//et cliquer à nouveau sur le bouton Tadiavo.
			formulaire.setPageNo(0);
		}
		
		List<Fifidianana> list = null;
		ModelAndView modelAndView = null;
		
		Map<String, Object> parameterNameValues = parseParameters(formulaire);
		Integer nbElementPerPage = Utils.getNbElementPerPageFromParameter(req, fFjkmService);
		list = fFjkmService.findFifidianana(parameterNameValues, formulaire.getPageNo(), nbElementPerPage);
		Map<String, Object> datas = referenceData(req);
		datas.put(FormSearchFifidianana.sfFORM_ID, formulaire);
		datas.put(ConstantUtils.sfDATA_FIFIDIANANAS, list);
		
		Long nbElements = fFjkmService.findNumberOfFifidianana(parameterNameValues);
		
		Long pageTotal = Utils.getNbPageTotal(nbElements,nbElementPerPage);
	
		formulaire.setNbInstances(nbElements);
		formulaire.setNbElementsPerPage(new Long(nbElementPerPage));
		
		if (formulaire.getPageNo() > 0)
			formulaire.setPreviousPageNo(formulaire.getPageNo() - 1);
		if (formulaire.getPageNo() < pageTotal)
			formulaire.setNextPageNo(formulaire.getPageNo() + 1);
		
		//datas.put(ConstantUtils.sfDATA_NBPAGE_MAX, pageTotal);
		formulaire.setNbPageTotal(pageTotal.intValue());
						
		req.setAttribute(ConstantUtils.sfSaveableEntity, null);

		Utils.setSelectedTab(req, ConstantUtils.sfAccessFifidianana);
		
		Utils.setCurrentSearchForm(req, formulaire);
		
		modelAndView = new ModelAndView("secure/searchFifidianana", datas);
		
		return modelAndView;
	}

	@Override
	protected Object formBackingObject(HttpServletRequest req) throws Exception {
		FormSearchFifidianana formulaire = (FormSearchFifidianana)req.getAttribute(FormSearchFifidianana.sfFORM_ID);
		if (formulaire == null)
			formulaire = new FormSearchFifidianana();
		
		formulaire.setPageNo(0);
		formulaire.setFrom((String) req.getParameter(ConstantUtils.sfPARAM_FROM));
		
		Fitandremana ankadifotsy = fFjkmService.findFitandremanaById(Fitandremana.sfIntFitandremanaAnkadifotsy);
		formulaire.setFitandremana(ankadifotsy);

		if (formulaire.getFrom() == null || "".equals(formulaire.getFrom().trim()))
			Utils.setSelectedTab(req, ConstantUtils.sfAccessFifidianana);

		Utils.setCurrentSearchForm(req, formulaire);
		
		return formulaire;
	}

	@Override
	protected Map<String, Object> referenceData(HttpServletRequest req) throws Exception {
		Map<String, Object> datas = new HashMap<String, Object>();

		return datas;
	}

	protected void initBinder(HttpServletRequest req,
			ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Date.class, new DatePropertyEditorSupport());

		binder.registerCustomEditor(Long.class, new LongPropertyEditorSupport());

		binder.registerCustomEditor(Double.class, new DoublePropertyEditorSupport());

		binder.registerCustomEditor(Fitandremana.class, new FitandremanaPropertyEditorSupport(fFjkmService));

		binder.registerCustomEditor(TaomPanompoana.class, new TaomPanompoanaPropertyEditorSupport(fFjkmService));

		binder.registerCustomEditor(KarazamPifidianana.class, new KarazamPifidiananaPropertyEditorSupport(fFjkmService));
	}

}
