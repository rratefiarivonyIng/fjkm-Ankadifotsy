/**
 * 
 */
package mg.fjkm.ankadifotsy.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mg.fjkm.ankadifotsy.bo.FanisamBato;
import mg.fjkm.ankadifotsy.bo.Fifidianana;
import mg.fjkm.ankadifotsy.service.FjkmAnkadifotsyService;
import mg.fjkm.ankadifotsy.util.ConstantUtils;
import mg.fjkm.ankadifotsy.util.Utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * Controleur pour renvoyer des résultats officieux et partiels
 * En fait renvoie le nombre de voix obtenus par les quelques candidats en partant du candidat ayant reçu 
 * le plus grand nombre de voix et ainsi de suite
 * @author rija
 * @version 1.0
 */
public class VokatraFifidiananaController implements Controller{
	/** Logger for this class and subclasses */    
	protected final Log logger = LogFactory.getLog(getClass());
	
	public static long sfNBAPPEL = 0L;
	private static final String sfSESSION_PAGENO = "_SESS_PAGENO_";
	
	private FjkmAnkadifotsyService fFjkmService = null;
	private Integer fNbElementPerPage = null;
	private Integer fNbMaxElement = null;
		
	public void setFjkmAnkadifotsyService(FjkmAnkadifotsyService fjkmService) {
		fFjkmService = fjkmService;
	}

	/**
	 * 
	 * @param req
	 * @return le numéro de page suivante
	 */
	private Integer getPageNo(HttpServletRequest req){
		Integer pageNo = (Integer)req.getSession().getAttribute(sfSESSION_PAGENO);
		if (pageNo == null)
			pageNo = 0;
		else{
			if (fNbMaxElement / ((pageNo + 1) * fNbElementPerPage) >= 1)
				pageNo ++;
			else
				pageNo = 0;
		}
		
		req.getSession().setAttribute(sfSESSION_PAGENO, pageNo);
		return pageNo;
	}
	
	private Integer getNbElement(HttpServletRequest req){
		if (fNbElementPerPage == null)
			fNbElementPerPage = Utils.getNbTempResultVote(req, fFjkmService);
		
		return fNbElementPerPage;
	}
	
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse response) throws Exception {
		List<Map<String, Object>> mapLaharanaAnaranaVavy2Vato = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> mapLaharanaAnaranaLahy2Vato = new ArrayList<Map<String, Object>>();
		Map<String, Object> datas = new HashMap<String, Object>();
		ModelAndView modelAndView = null;
		
		String init = req.getParameter("init");
		Fifidianana fifidianana = Utils.getFifidiananaFromSession(req);
		req.setAttribute(ConstantUtils.sfREQUEST_FIFIDIANANA, fifidianana);
		if (fifidianana != null){
			if (init != null && !"".equals(init.trim())){
				boolean isOrderedByName = "2".equals(init.trim());
				
				if (isOrderedByName){
					//Résultat définitif : sans AJAX mais chargement immédiat donc utilisation d'une autre view
					// sans pagination mais affichage de tous les candidats reçus (cf paramètre)
					FanisamBato fanisamBatoVehivavy = fFjkmService.findFanisamBatoByFifidianana(fifidianana, false);
					datas.put(ConstantUtils.sfDATA_FANISAMBATO_VEHIVAVY, fanisamBatoVehivavy);
					mapLaharanaAnaranaVavy2Vato = fFjkmService.getIsamBatoAmbonyIndrindraOrderByName(fifidianana, false);
					datas.put(ConstantUtils.sfDATA_VALINY_FIFIDIANANA_VEHIVAVY, mapLaharanaAnaranaVavy2Vato);
					FanisamBato fanisamBatoLehilahy = fFjkmService.findFanisamBatoByFifidianana(fifidianana, true);
					datas.put(ConstantUtils.sfDATA_FANISAMBATO_LEHILAHY, fanisamBatoLehilahy);
					mapLaharanaAnaranaLahy2Vato = fFjkmService.getIsamBatoAmbonyIndrindraOrderByName(fifidianana, true);
					datas.put(ConstantUtils.sfDATA_VALINY_FIFIDIANANA_LEHILAHY, mapLaharanaAnaranaLahy2Vato);
					modelAndView = new ModelAndView("secure/vokatraOfisialyMisaraka", datas);
				}
				else{
					if (fifidianana.isFifidiananaOloTokana())
						modelAndView = new ModelAndView("secure/vokatraFifidiananaMitambatra");
					else{
						if (fifidianana.isMitohyLaharana()){
							//Fifidianana de plusieurs candidats tout genre confondu
							fNbMaxElement = fFjkmService.getNbMaxResult(fifidianana.getId(), null, true);
							modelAndView = new ModelAndView("secure/vokatraFifidiananaMitambatra", datas);
						}
						else{
							//Fifidianana plusieurs candidats mais dont on sépare les femmes des hommes (chaque genre a leur quota propre)
							int nbMaxLehilahy = fFjkmService.getNbMaxResult(fifidianana.getId(), true, false);
							int nbMaxVehivavy = fFjkmService.getNbMaxResult(fifidianana.getId(), false, false);
							fNbMaxElement = nbMaxLehilahy > nbMaxVehivavy ? nbMaxLehilahy : nbMaxVehivavy;
							modelAndView = new ModelAndView("secure/vokatraFifidiananaMisaraka", datas);
						}
					}
				}
			}
			else{
				if (fifidianana.isFifidiananaOloTokana()){
					FanisamBato fanisamBato = fFjkmService.findFanisamBatoByFifidianana(fifidianana, null);
					List<Map<String, Object>>mapLaharanaAnarana2Vato = fFjkmService.getIsamBatoAmbonyIndrindra(fifidianana.getId(), null, false, null, null);
					datas.put(ConstantUtils.sfDATA_VALINY_FIFIDIANANA, mapLaharanaAnarana2Vato);
					datas.put(ConstantUtils.sfDATA_FANISAMBATO, fanisamBato);
					modelAndView = new ModelAndView("secure/vokatraMitambatraAjax", datas);										
				}
				else{
					//gestion de la pagination
					Integer nbElement = getNbElement(req);
					Integer pageNo = getPageNo(req);
					datas.put(ConstantUtils.sfDATA_PAGE_NO, pageNo);
					if (fifidianana.isMitohyLaharana()){
						FanisamBato fanisamBato = fFjkmService.findFanisamBatoByFifidianana(fifidianana, null);
						List<Map<String, Object>>mapLaharanaAnarana2Vato = fFjkmService.getIsamBatoAmbonyIndrindra(fifidianana.getId(), null, false, pageNo, nbElement);
						datas.put(ConstantUtils.sfDATA_VALINY_FIFIDIANANA, mapLaharanaAnarana2Vato);
						datas.put(ConstantUtils.sfDATA_FANISAMBATO, fanisamBato);
						modelAndView = new ModelAndView("secure/vokatraMitambatraAjax", datas);						
					}
					else{
						FanisamBato fanisamBatoVehivavy = fFjkmService.findFanisamBatoByFifidianana(fifidianana, false);
						datas.put(ConstantUtils.sfDATA_FANISAMBATO_VEHIVAVY, fanisamBatoVehivavy);
						mapLaharanaAnaranaVavy2Vato = fFjkmService.getIsamBatoAmbonyIndrindra(fifidianana.getId(), false, false, pageNo, nbElement);
						datas.put(ConstantUtils.sfDATA_VALINY_FIFIDIANANA_VEHIVAVY, mapLaharanaAnaranaVavy2Vato);
						FanisamBato fanisamBatoLehilahy = fFjkmService.findFanisamBatoByFifidianana(fifidianana, true);
						datas.put(ConstantUtils.sfDATA_FANISAMBATO_LEHILAHY, fanisamBatoLehilahy);
						mapLaharanaAnaranaLahy2Vato = fFjkmService.getIsamBatoAmbonyIndrindra(fifidianana.getId(), true, false, pageNo, nbElement);
						datas.put(ConstantUtils.sfDATA_VALINY_FIFIDIANANA_LEHILAHY, mapLaharanaAnaranaLahy2Vato);
						modelAndView = new ModelAndView("secure/vokatraMisarakaAjax", datas);
					}
				}
			}
		}
		
		Utils.setSelectedTab(req, ConstantUtils.sfAccessFifidianana);
		
		return modelAndView;
	}
		
}
