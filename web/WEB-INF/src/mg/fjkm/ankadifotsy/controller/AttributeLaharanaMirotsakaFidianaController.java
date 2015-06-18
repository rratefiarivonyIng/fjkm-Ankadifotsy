/**
 * 
 */
package mg.fjkm.ankadifotsy.controller;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mg.fjkm.ankadifotsy.bo.Fifidianana;
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
 * Classe permettant d'attribuer les numéros de tous les MirotsakaFidiana (candidatures) pour un Fifidianana donné
 * NOTE : 
 * 	- cette opération doit être disponible uniquement après la clôture de la réception des demandes de candidature
 *  - cette opération doit être lancer UNE seule fois pour un fifidianana donné
 * 
 * @author rija
 * @version 1.0
 */
public class AttributeLaharanaMirotsakaFidianaController implements Controller {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    private FjkmAnkadifotsyService fFjkmAnkadifotsyService = null;
    
	public void setFjkmAnkadifotsyService(FjkmAnkadifotsyService fjkmAnkadifotsyService) {
		fFjkmAnkadifotsyService = fjkmAnkadifotsyService;
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.Controller#handleRequest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse rep) throws Exception {
		Fifidianana fifidianana = Utils.getFifidiananaFromSession(req);
		ModelAndView modelAndView = null;
		
		if (fifidianana != null){
			Utils.setFormulaireInSession(req, FormListMirotsakaFidiana.sfFORM_ID, null);
			Utils.setSelectedTab(req, ConstantUtils.sfAccessFifidianana);
			//Map<String, Object> datas = new HashMap<String, Object>();
			String message = "";
			if (fFjkmAnkadifotsyService.getNumberMirotsakaFidianaNotChecked(fifidianana.getId()) == 0){
				fFjkmAnkadifotsyService.attributeLaharanaMirotsaka(fifidianana);
				message = "Vita ny fanomezana laharana ho an'ny mpirotsaka ho fidiana.";
			}
			else
				message = "Mbola misy mpirotsaka ho fidiana tsy voajery.";
			
			//datas.putAll(fFjkmAnkadifotsyService.getStatMirotsakaFidiana(fifidianana.getId()));
			//datas.put(ConstantUtils.sfMessageAttributionNumero, true);

			rep.getWriter().write(message);
		}
		else
			modelAndView = new ModelAndView(new RedirectView(req.getContextPath()+"/secure/index.htm?message="+URLEncoder.encode("Miverena misafidy fifidiana.", "utf-8")));
				
		return modelAndView;
	}	
}
