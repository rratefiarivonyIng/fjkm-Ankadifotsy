/**
 * 
 */
package mg.fjkm.ankadifotsy.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mg.fjkm.ankadifotsy.bo.Fifidianana;
import mg.fjkm.ankadifotsy.bo.Fitandremana;
import mg.fjkm.ankadifotsy.bo.Mpivavaka;
import mg.fjkm.ankadifotsy.form.FormSearchChristian;
import mg.fjkm.ankadifotsy.service.FjkmAnkadifotsyService;
import mg.fjkm.ankadifotsy.util.ConstantUtils;
import mg.fjkm.ankadifotsy.util.Utils;

import org.apache.commons.lang.NotImplementedException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Controleur pour la saisie des informations de recherche d'un Mpivavaka (ou Diakona)
 * 
 * @access : proteégé
 * @author rija
 * @version 1.0
 */
public class SearchChristianAjaxController implements Controller {
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
	private Map<String, Object> parseParameters(HttpServletRequest request, FormSearchChristian formulaire) {
		boolean reload = false;
		//if (request.getParameterNames().hasMoreElements()){
		//	reload = "reload".equals(request.getParameterNames().nextElement());	//cf message.jsp options.onClose
		//}
		reload = Utils.isReload(request);

		Map<String, Object> parameterNameValues = new HashMap<String, Object>();

		if (!reload){
			//Si nouveau chargement alors prendre les paramètres dans la requêtes
			String fitandremanaIdStr = request.getParameter("fitandremanaId");
			if (fitandremanaIdStr != null && !"".equals(fitandremanaIdStr.trim())){
				Long fitandremanaId = Long.parseLong(fitandremanaIdStr);
				Fitandremana fitandremana = fFjkmService.findFitandremanaById(fitandremanaId);
				formulaire.setFitandremana(fitandremana);
			}
			
			String laharana = request.getParameter("laharana");
			if (laharana != null && !"".equals(laharana.trim()))
				formulaire.setLaharana(laharana);
			else
				formulaire.setLaharana(null);
			
			String pageNoStr = request.getParameter("pageNo");
			if (pageNoStr != null && !"".equals(pageNoStr.trim()))
				formulaire.setPageNo(Integer.parseInt(pageNoStr));
			
			String anarana = request.getParameter("anarana");
			if (anarana != null && !"".equals(anarana.trim()))
				formulaire.setAnarana(anarana);
			else
				formulaire.setAnarana(null);
			
			String fanampiny = request.getParameter("fanampiny");
			if (fanampiny != null && !"".equals(fanampiny.trim()))
				formulaire.setFanampiny(fanampiny);
			else
				formulaire.setFanampiny(null);
			
			String mpandrayStr = request.getParameter("mpandray");
			if (mpandrayStr != null && !"".equals(mpandrayStr.trim())){
				int mpandray = Integer.parseInt(mpandrayStr);
				formulaire.setMpandray(mpandray);
			}
			else
				formulaire.setMpandray(null);

			String batisaStr = request.getParameter("batisa");
			if (batisaStr != null && !"".equals(batisaStr.trim())){
				int batisa = Integer.parseInt(batisaStr);
				formulaire.setBatisa(batisa);
			}
			else
				formulaire.setVitaBatisa(null);

			String lahyStr = request.getParameter("lahy");
			if (lahyStr != null && !"".equals(lahyStr.trim())){
				int lahy = Integer.parseInt(lahyStr);
				formulaire.setLahy(lahy);
			}
			else
				formulaire.setLahy(null);
			
			String talenta = request.getParameter("talenta");
			if (talenta != null && !"".equals(talenta))
				formulaire.setTalenta(talenta);
		}
		else{
			//Aucun action à faire : les valeurs dans le formulaire sont déjà les bonnes car il s'agit d'un rechargement
		}

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

	private Map<String, Object> loadDatas(FormSearchChristian formulaire, HttpServletRequest req) throws Exception{		
		Map<String, Object> parameterNameValues = parseParameters(req, formulaire);
		Map<String, Object> datas = referenceData(req);
		Integer nbElementPerPage = Utils.getNbElementPerPageFromParameter(req, fFjkmService);		
		List<Mpivavaka> list = fFjkmService.findMpivavaka(parameterNameValues, formulaire.getPageNo(), nbElementPerPage);
		
		if (ConstantUtils.sfFromFifidianana.equals(formulaire.getFrom()) && list.size() > 0){
			//Charger les informations sur les candidatures déjà passées
			Set<Long> mpivavakaIds = new HashSet<Long>();
			for (Mpivavaka mpivavaka : list)
				mpivavakaIds.add(mpivavaka.getId());
			
			Fifidianana fifidianana = Utils.getFifidiananaFromSession(req);
			Map<Long, Long> mapMpivavakaId2MirotsakaFidianaId = fFjkmService.findMapMpivavakaId2MirotsakaFidianaIdByTaomPanompoanaId(fifidianana.getId(), mpivavakaIds);
			datas.put(ConstantUtils.sfInfoMirotsakaFidiana, mapMpivavakaId2MirotsakaFidianaId);
		}
		
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
	
	protected Map<String, Object> referenceData(HttpServletRequest req) throws Exception {
		Map<String, Object> datas = new HashMap<String, Object>();

		// Charger la liste des Formes juridiques
		//List<Fitandremana> fitandremana = fFjkmService.findAllFitandremana();
		//datas.put(ConstantUtils.sfDATA_FITANDREMANAS, fitandremana);

		return datas;
	}

	@SuppressWarnings("unchecked")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		FormSearchChristian formulaire = null;
		if (!Utils.isParameterNameExist(request, "init"))
			formulaire = (FormSearchChristian)Utils.getFormulaireFromSession(request, FormSearchChristian.sfFORM_ID);
		
		Fifidianana fifidianana = Utils.getFifidiananaFromSession(request);
		ModelAndView modelAndView = null;
		if (formulaire == null){
			//1er appel => affichage du formulaire des critères de recherche
			formulaire = new FormSearchChristian();
			
			formulaire.setPageNo(0);
			formulaire.setVitaBatisa(null);
			formulaire.setMpandray(null);
			formulaire.setLahy(null);

			Fitandremana ankadifotsy = fFjkmService.findFitandremanaById(Fitandremana.sfIntFitandremanaAnkadifotsy);
			formulaire.setFitandremana(ankadifotsy);
			
			modelAndView = new ModelAndView("secure/searchChristianAjax", FormSearchChristian.sfFORM_ID, formulaire);
		}
		else{
			//chargement des résultats des recherches suite au click sur le bouton Tadiavo ou sur les liens manaraka / teo aloha par AJAX
			Map<String, Object> datas = loadDatas(formulaire, request);
			String submitName = request.getParameter("valider");
			List<Mpivavaka> list = (List<Mpivavaka>)datas.get(ConstantUtils.sfDATA_MPIVAVAKAS);
			if ("Tadiavo".equalsIgnoreCase(submitName) && ConstantUtils.sfFromDiakona.equals(formulaire.getFrom()) && list.size() == 1 && list.get(0).isElligibleDiakona(fifidianana.getDatyFifidianana() != null ? fifidianana.getDatyFifidianana() : new Date())){
				//un seul résultat et recherche depuis le lien 'Hampiditra diakona' => ouvrir directement dans le formulaire si elligible
				Mpivavaka mpivavaka = list.get(0);
				modelAndView = new ModelAndView(new RedirectView("editDiakona.htm?id="+mpivavaka.getId()));
				Utils.setSelectedTab(request, ConstantUtils.sfAccessDiakona);
				request.setAttribute(ConstantUtils.sfSaveableEntity, mpivavaka);
			}
			else{
				boolean reload = false;
				//if (request.getParameterNames().hasMoreElements()){
				//	reload = "reload".equals(request.getParameterNames().nextElement());	//cf message.jsp options.onClose
				//}
				reload = Utils.isReload(request);
				
				String view = "secure/searchChristianResultsAjax";
				request.setAttribute(ConstantUtils.sfSaveableEntity, null);
				if (formulaire.getFrom() == null || "".equals(formulaire.getFrom().trim()) || ConstantUtils.sfFromMpivavaka.equals(formulaire.getFrom()))
					Utils.setSelectedTab(request, ConstantUtils.sfAccessMpivavaka);
				else if (ConstantUtils.sfFromDiakona.equals(formulaire.getFrom())){
					Utils.setSelectedTab(request, ConstantUtils.sfAccessDiakona);
					view = "secure/searchDiakonaResultsAjax";
				}
				else if (ConstantUtils.sfFromFifidianana.equals(formulaire.getFrom())){
					Utils.setSelectedTab(request, ConstantUtils.sfAccessFifidianana);
					view = "secure/searchMirotsakaFidianaResultsAjax";
				}
				else
					throw new NotImplementedException();
				
				if (reload){
					formulaire.setSubmit(true);
					modelAndView = new ModelAndView("secure/searchChristianAjax", FormSearchChristian.sfFORM_ID, formulaire);
				}
				else
					modelAndView = new ModelAndView(view, datas);
			}
		}
		
		formulaire.setFrom((String) request.getParameter(ConstantUtils.sfPARAM_FROM));
		if ("fifidianana".equals(formulaire.getFrom()))
			request.setAttribute(ConstantUtils.sfREQUEST_FIFIDIANANA, Utils.getFifidiananaFromSession(request));
		

		Utils.setFormulaireInSession(request, formulaire.getFormID(), formulaire);
		Utils.setCurrentSearchForm(request, formulaire);

		return modelAndView;
	}

}
