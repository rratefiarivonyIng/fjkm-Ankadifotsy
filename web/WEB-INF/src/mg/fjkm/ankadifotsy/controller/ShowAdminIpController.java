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

import mg.fjkm.ankadifotsy.bo.AuthorizedIP;
import mg.fjkm.ankadifotsy.form.FormAuthorizedIp;
import mg.fjkm.ankadifotsy.service.FjkmAnkadifotsyService;
import mg.fjkm.ankadifotsy.util.Utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Controleur pour l'affichage de la gestion des adresses IPs autorisées à utiliser certaines
 * fonctionnalités comme le ManisaVatoController
 * @author rija
 * @version 1.0
 */
public class ShowAdminIpController implements Controller{
	/** Logger for this class and subclasses */    
	protected final Log logger = LogFactory.getLog(getClass());

	private FjkmAnkadifotsyService fFjkmService = null;
		
	public void setFjkmAnkadifotsyService(FjkmAnkadifotsyService fjkmService) {
		fFjkmService = fjkmService;
	}

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//Contrôle de sécurité
		String ip = Utils.getIpFromRequest(request);
		if (!fFjkmService.isIPAuthorized(ip))
			return new ModelAndView(new RedirectView(request.getContextPath()+"/secure/index.htm?message="+URLEncoder.encode("Tsy mahazo alalana ny IP : ["+ip+"]", "utf-8")));

		Map<String, Object> datas = new HashMap<String, Object>();
		
		List<AuthorizedIP> aips = fFjkmService.getAllAuthorizedIps();
		datas.put("aips", aips);
		datas.put(FormAuthorizedIp.sfFORM_ID, new FormAuthorizedIp());
		
		return new ModelAndView("secure/showAdminIp", datas);
	}
	
}
