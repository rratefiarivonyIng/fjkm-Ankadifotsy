/**
 * 
 */
package mg.fjkm.ankadifotsy.controller;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mg.fjkm.ankadifotsy.bo.Fifidianana;
import mg.fjkm.ankadifotsy.form.FormListMirotsakaFidiana;
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
 * Classe permettant de sélectionner un Fifidianana et d'accéder aux fonctionnalités de gestion de Fifidianana
 * @author rija
 * @version 1.0
 */
public class SelectFifidiananaController implements Controller {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

	private FjkmAnkadifotsyService fFjkmService = null;
	
	public void setFjkmAnkadifotsyService(FjkmAnkadifotsyService nifService) {
		fFjkmService = nifService;
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.Controller#handleRequest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse rep) throws Exception {
		String idStr = req.getParameter("id");
		Fifidianana fifidianana = null;
		if (idStr != null && !"".equals(idStr.trim())){
			Long id = Long.parseLong(idStr);
			fifidianana = fFjkmService.findFifidianana(id);
			if (fifidianana == null)
				throw new RuntimeException("Ny fifidianana manana ID ["+idStr+"] dia tsy misy.");
			else
				Utils.setFifidiananaInSession(req, fifidianana);
		}
		else
			throw new IllegalArgumentException("Mifidiana fifidianana iray.");
		
		Utils.setSelectedTab(req, ConstantUtils.sfAccessFifidianana);
		
		Boolean initFormulaire = (Boolean)req.getAttribute(ConstantUtils.sfFormulaireInit);
		
		if (initFormulaire == null || !initFormulaire.booleanValue()){
			Utils.setFormulaireInSession(req, FormSearchChristian.sfFORM_ID, null);
			Utils.setFormulaireInSession(req, FormSearchFifidianana.sfFORM_ID, null);
			Utils.setFormulaireInSession(req, FormListMirotsakaFidiana.sfFORM_ID, null);
		}

		String view = "secure/fifidiananaSelected";
		Map<String, Object>datas = new HashMap<String, Object>();
		datas.put(ConstantUtils.sfREQUEST_FIFIDIANANA, fifidianana);
		datas.putAll(fFjkmService.getStatMirotsakaFidiana(fifidianana.getId()));
		datas.put(ConstantUtils.sfREQUEST_AFAKA_MANISA_VATO, fFjkmService.canBeginVote(fifidianana));
		datas.put(ConstantUtils.sfREQUEST_NAHAZO_LAHARANA, fFjkmService.haveAllMirotsakaFidianaEkenaLaharana(fifidianana));
		
		String message = req.getParameter("message");
		if (message != null && !"".equals(message.trim())){
			datas.put(ConstantUtils.sfMessageEnregistrementOK, true);
			datas.put(ConstantUtils.sfMessageContent, URLDecoder.decode(message, "utf-8"));
		}
		
		return new ModelAndView(view, datas);
	}	
}
