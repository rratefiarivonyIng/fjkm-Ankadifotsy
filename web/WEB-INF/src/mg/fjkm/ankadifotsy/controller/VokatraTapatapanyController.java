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
 * Controleur pour renvoyer des résultats officieux et partiels par ajax dans la fiche de saisi des bulletins de vote
 * En fait renvoie le nombre de voix obtenus par les quelques candidats en partant du candidat ayant reçu 
 * le plus grand nombre de voix et ainsi de suite
 * @author rija
 * @version 1.0
 */
public class VokatraTapatapanyController implements Controller{
	/** Logger for this class and subclasses */    
	protected final Log logger = LogFactory.getLog(getClass());
	public static long sfNBAPPEL = 0L;	//Pour test uniquement
	private FjkmAnkadifotsyService fFjkmService = null;
		
	public void setFjkmAnkadifotsyService(FjkmAnkadifotsyService fjkmService) {
		fFjkmService = fjkmService;
	}


	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse response) throws Exception {
		List<Map<String, Object>> mapLaharanaAnarana2Vato = new ArrayList<Map<String, Object>>();
		Boolean lahy = null;
		String lahyStr = req.getParameter("lahy");
		if (lahyStr != null && !"".equals(lahyStr.trim()))
			lahy = Boolean.parseBoolean(lahyStr);
		
		Fifidianana fifidianana = Utils.getFifidiananaFromSession(req);
		req.setAttribute(ConstantUtils.sfREQUEST_FIFIDIANANA, fifidianana);
		Integer nbLigneResultVote = Utils.getNbTempResultVote(req, fFjkmService);
		
		if (fifidianana != null){
			 mapLaharanaAnarana2Vato = fFjkmService.getIsamBatoAmbonyIndrindra(fifidianana.getId(), lahy, true, 0, nbLigneResultVote);
			 /* TEST 
			 sfNBAPPEL +=10;
			 Map<String, Object> map = new HashMap<String, Object>();
			 map.put("laharana", 241);
			 map.put("anarana", "Randriatsalama Mbolatiana");
			 map.put("vato", sfNBAPPEL);
			 mapLaharanaAnarana2Vato.add(map);
			 */
		}
		
		Utils.setSelectedTab(req, ConstantUtils.sfAccessFifidianana);
		
		HashMap<String, Object> datas = new HashMap<String, Object>();
		datas.put(ConstantUtils.sfDATA_TEMP_RESULT, mapLaharanaAnarana2Vato);
		datas.put(ConstantUtils.sfTEMP_RESULT_NBLINES, nbLigneResultVote);
		if (fifidianana.isFifidiananaOloTokana()){
			FanisamBato fanisamBato = fFjkmService.findFanisamBatoByFifidianana(fifidianana, null);
			datas.put(ConstantUtils.sfDATA_FANISAMBATO, fanisamBato);
		}
		else{
			if (fifidianana.isMitohyLaharana()){
				FanisamBato fanisamBato = fFjkmService.findFanisamBatoByFifidianana(fifidianana, null);
				datas.put(ConstantUtils.sfDATA_FANISAMBATO, fanisamBato);
			}
			else{
				FanisamBato fanisamBatoLehilahy = fFjkmService.findFanisamBatoByFifidianana(fifidianana, true);
				datas.put(ConstantUtils.sfDATA_FANISAMBATO_LEHILAHY, fanisamBatoLehilahy);
				FanisamBato fanisamBatoVehilahy = fFjkmService.findFanisamBatoByFifidianana(fifidianana, false);
				datas.put(ConstantUtils.sfDATA_FANISAMBATO_VEHIVAVY, fanisamBatoVehilahy);
			}
		}
		
		return new ModelAndView("secure/vokatraVonjyMaika", datas);
	}
		
}
