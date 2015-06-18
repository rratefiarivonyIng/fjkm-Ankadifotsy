/**
 * 
 */
package mg.fjkm.ankadifotsy.controller;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mg.fjkm.ankadifotsy.bo.Fifidianana;
import mg.fjkm.ankadifotsy.bo.Parameter;
import mg.fjkm.ankadifotsy.form.FormListMirotsakaFidiana;
import mg.fjkm.ankadifotsy.service.FjkmAnkadifotsyService;
import mg.fjkm.ankadifotsy.util.ConstantUtils;
import mg.fjkm.ankadifotsy.util.Utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Controleur de traitement de la liste des MirotsakaFidiana (candidatures) définitive 
 * avec affichage sur 2 colonnes des candidats pour impression PDF
 * 
 * @access : protégé
 * @author rija
 * @version 1.0
 */
public class ListMirotsakaFidiana2ColonnesAjaxController implements Controller {
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
	 */
	private void parseParameters(HttpServletRequest request, FormListMirotsakaFidiana formulaire) {
		boolean reload = false;
		if (request.getParameterNames().hasMoreElements())
			reload = "reload".equals(request.getParameterNames().nextElement());	//cf message.jsp options.onClose
		
		if (!reload){
			//Si nouveau chargement alors prendre les paramètres dans la requêtes			
			String pageNoStr = request.getParameter("pageNo");
			if (pageNoStr != null && !"".equals(pageNoStr.trim()))
				formulaire.setPageNo(Integer.parseInt(pageNoStr));
			
			String rehetra = request.getParameter(ConstantUtils.sfParamMirotsakaFidianaRehetra);
			if (rehetra != null && !"".equals(rehetra.trim()))
				formulaire.setAllMirotsakaFidiana("1".equals(rehetra.trim()));
			else
				formulaire.setAllMirotsakaFidiana(false);
			
			if (!formulaire.isAllMirotsakaFidiana()){
				String mirotsakaFidianaNekena = request.getParameter(ConstantUtils.sfParamMirotsakaFidianaNekena);
				if (mirotsakaFidianaNekena != null && !"".equals(mirotsakaFidianaNekena.trim()))
					formulaire.setEkenaFirotsahana("1".equals(mirotsakaFidianaNekena.trim()));
				else
					formulaire.setEkenaFirotsahana(null);
			}
		}
		else{
			//Aucun action à faire : les valeurs dans le formulaire sont déjà les bonnes car il s'agit d'un rechargement
		}
	}

	/**
	 * 
	 * @param formulaire
	 * @param req
	 * @return
	 * @throws Exception
	 */
	private Map<String, Object> loadDatas(FormListMirotsakaFidiana formulaire, boolean init, HttpServletRequest req, Boolean lehilahy) throws Exception{		
		parseParameters(req, formulaire);
		Map<String, Object> datas = referenceData(req);
		
		datas.put(FormListMirotsakaFidiana.sfFORM_ID, formulaire);
		
		Parameter parameter = Utils.getParameter(req, fFjkmService);
		Integer nbElementPerPage = parameter.getNbMirotsakaFidianaPerPage();
		
		Fifidianana fifidianana = Utils.getFifidiananaFromSession(req);
		
		if (!init){
			List<Map<String, Object>> list = fFjkmService.findMirotsakaFidiana(fifidianana, formulaire.isAllMirotsakaFidiana(), formulaire.getEkenaFirotsahana(), lehilahy, formulaire.getPageNo(), nbElementPerPage);		
			datas.put(ConstantUtils.sfDATA_MIROTSAKAFIDIANAS, list);
		}

		Long nbElements = fFjkmService.findNumberOfMirotsakaFidiana(formulaire.getFifidiananaId(), formulaire.isAllMirotsakaFidiana(), formulaire.getEkenaFirotsahana(), lehilahy);
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

		//Pour les données de références éventuellement utilisées dans la vue
		
		return datas;
	}

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		FormListMirotsakaFidiana formulaire = (FormListMirotsakaFidiana)Utils.getFormulaireFromSession(request, FormListMirotsakaFidiana.sfFORM_ID);
		Fifidianana fifidianana = Utils.getFifidiananaFromSession(request);
		if (fifidianana == null)
			return new ModelAndView(new RedirectView(request.getContextPath()+"/secure/index.htm?message="+URLEncoder.encode("Miverena misafidy fifidiana.", "utf-8")));
		
		ModelAndView modelAndView = null;
		if (formulaire == null){
			//1er appel => affichage du formulaire des critères de recherche
			Boolean lehilahy = null;
			if (Utils.isParameterNameExist(request, "lehilahy"))
				lehilahy = true;
			else if (Utils.isParameterNameExist(request, "vehivavy"))
				lehilahy = false;
			
			formulaire = new FormListMirotsakaFidiana(fifidianana.getId());
			formulaire.setLehilahy(lehilahy);
			formulaire.setPageNo(0);
			Map<String, Object> datas = loadDatas(formulaire, true, request, lehilahy);
			formulaire.setSubmit(true);
			formulaire.setHaveAllMirotsakaFidianaEkenaLaharana(fFjkmService.haveAllMirotsakaFidianaEkenaLaharana(fifidianana));
			modelAndView = new ModelAndView("secure/listFaranyMirotsakaFidianaAjax", datas);
		}
		else{
			//chargement des résultats des recherches suite au click sur les liens manaraka / teo aloha par AJAX
			Map<String, Object> datas = loadDatas(formulaire, false, request, formulaire.getLehilahy());

			boolean reload = Utils.isParameterNameExist(request, "reload");
			
			String view = "secure/listFaranyMirotsakaFidianaResultsAjax";
			request.setAttribute(ConstantUtils.sfSaveableEntity, null);
			Utils.setSelectedTab(request, ConstantUtils.sfAccessFifidianana);
			
			if (reload){
				formulaire.setSubmit(true);	//Pour demander le rechargement du résultat
				modelAndView = new ModelAndView("secure/listFaranyMirotsakaFidianaAjax", FormListMirotsakaFidiana.sfFORM_ID, formulaire);
			}
			else
				modelAndView = new ModelAndView(view, datas);
		}
		
		request.setAttribute(ConstantUtils.sfREQUEST_FIFIDIANANA, Utils.getFifidiananaFromSession(request));		

		Utils.setFormulaireInSession(request, formulaire.getFormID(), formulaire);
		
		Utils.setCurrentSearchForm(request, formulaire);

		return modelAndView;
	}

}
