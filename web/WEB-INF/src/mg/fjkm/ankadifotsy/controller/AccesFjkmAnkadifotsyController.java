/**
 * 
 */
package mg.fjkm.ankadifotsy.controller;

import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mg.fjkm.ankadifotsy.bo.Fifidianana;
import mg.fjkm.ankadifotsy.form.FormListMirotsakaFidiana;
import mg.fjkm.ankadifotsy.form.FormManisaVato;
import mg.fjkm.ankadifotsy.form.FormSearchChristian;
import mg.fjkm.ankadifotsy.form.FormSearchFifidianana;
import mg.fjkm.ankadifotsy.service.FjkmAnkadifotsyService;
import mg.fjkm.ankadifotsy.util.ConstantUtils;
import mg.fjkm.ankadifotsy.util.Utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


/**
 * Classe permettant d'accéder aux fonctionnalités spécifiques à la DGI
 * @author rija
 * @version 1.0
 */
public class AccesFjkmAnkadifotsyController implements Controller {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    private FjkmAnkadifotsyService fFjkmAnkadifotsyService = null;
    
	public void setFjkmAnkadifotsyService(FjkmAnkadifotsyService fjkmAnkadifotsyService) {
		fFjkmAnkadifotsyService = fjkmAnkadifotsyService;
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.Controller#handleRequest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse rep) throws Exception {
		Enumeration<String> parameterNames = req.getParameterNames();
		String view = "secure/mpivavaka";
		String selectedTab = ConstantUtils.sfAccessMpivavaka;
		ModelAndView modelAndView = null;
		boolean mivoakaFifidianana = false;
		while (parameterNames.hasMoreElements()){
			String name = parameterNames.nextElement();
			if (ConstantUtils.sfAccessSampana.equals(name)){
				view = "secure/sampana";
				selectedTab = ConstantUtils.sfAccessSampana;
			}
			else if (ConstantUtils.sfAccessDiakona.equals(name)){
				view = "secure/diakona";
				selectedTab = ConstantUtils.sfAccessDiakona;
			}
			else if (ConstantUtils.sfAccessFifidianana.equals(name)){
				view = "secure/fifidianana";
				selectedTab = ConstantUtils.sfAccessFifidianana;
			}
			else if (ConstantUtils.sfAccessAdmin.equals(name)){
				view = "secure/administration";
				selectedTab = ConstantUtils.sfAccessAdmin;
			}
			else if (ConstantUtils.sfParameterMivoakaFifidianana.equals(name))
				mivoakaFifidianana = true;
		}

		if (mivoakaFifidianana){
			//On sort du mode d'édition de Fifidianana
			Utils.setFifidiananaInSession(req, null);
			Utils.setFormulaireInSession(req, FormListMirotsakaFidiana.sfFORM_ID, null);
			req.getSession().setAttribute(FormManisaVato.sfFORM_ID, null);
		}
		
		if ("secure/fifidianana".equals(view)){
			Fifidianana fifidianana = Utils.getFifidiananaFromSession(req);
			if (!mivoakaFifidianana && fifidianana != null){
				//Positionner le Fifidianana sélectionné dans la requête pour l'onglet Fifidianana
				//ET ouvrir directement dans la page fifidiananaSelected.jsp pour que l'utilisateur puisse continuer sur la manipulation du Fifidianana déjà sélectionné
				req.setAttribute(ConstantUtils.sfREQUEST_AFAKA_MANISA_VATO, fFjkmAnkadifotsyService.canBeginVote(fifidianana));
				req.setAttribute(ConstantUtils.sfREQUEST_FIFIDIANANA, fifidianana);
				view = "secure/fifidiananaSelected";
				Map<String, Integer> stats = fFjkmAnkadifotsyService.getStatMirotsakaFidiana(fifidianana.getId());
				for (String key : stats.keySet())
					req.setAttribute(key, stats.get(key));
			}
		}
		
		Utils.setSelectedTab(req, selectedTab);

		//Traitement d'un éventuel message à afficher
		Map<String, Object> datas = new HashMap<String, Object>();
		String message = req.getParameter("message");
		if (message != null && !"".equals(message.trim())){
			datas.put(ConstantUtils.sfMessageExist,"true");
			datas.put(ConstantUtils.sfMessageContent,URLDecoder.decode(message, "utf-8"));
		}
			
		modelAndView = new ModelAndView(view, datas);
		
		Boolean initFormulaire = (Boolean)req.getAttribute(ConstantUtils.sfFormulaireInit);
		
		if (initFormulaire == null || !initFormulaire.booleanValue()){
			Utils.setFormulaireInSession(req, FormSearchChristian.sfFORM_ID, null);
			Utils.setFormulaireInSession(req, FormSearchFifidianana.sfFORM_ID, null);
			Utils.setFormulaireInSession(req, FormListMirotsakaFidiana.sfFORM_ID, null);
		}
		
		return modelAndView;
	}	
}
