/**
 * 
 */
package mg.fjkm.ankadifotsy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mg.fjkm.ankadifotsy.bo.AuthorizedIP;
import mg.fjkm.ankadifotsy.form.FormAuthorizedIp;
import mg.fjkm.ankadifotsy.service.FjkmAnkadifotsyService;
import mg.fjkm.ankadifotsy.util.ConstantUtils;
import mg.fjkm.ankadifotsy.util.Utils;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * @author Rija
 * Controller pour gérer l'ajout d'une nouvelle IP qui sera autorisée à utilisée certaines fonctionnalités comme le ManisaVato
 */
public class AddIpController implements Controller {

	private FjkmAnkadifotsyService fFjkmAnkadifotsyService = null;
	
	
	public void setFjkmAnkadifotsyService(FjkmAnkadifotsyService fjkmAnkadifotsyService) {
		fFjkmAnkadifotsyService = fjkmAnkadifotsyService;
	}


	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.Controller#handleRequest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String idStr = request.getParameter("id");
		Long id = null;
		if (idStr != null && !"".equals(idStr.trim()))
			id = Long.parseLong(idStr);
		
		String ip = request.getParameter("ip");
		String descr = request.getParameter("descr");
		
		String ekena = request.getParameter("ekena");
		
		AuthorizedIP aip = new AuthorizedIP(ip, descr);
		aip.setId(id);
		aip.setAuthorized(Boolean.parseBoolean(ekena));
		
		FormAuthorizedIp form = new FormAuthorizedIp();
		if (Utils.isIPv4Valid(ip)){
			fFjkmAnkadifotsyService.saveAuthorizedIP(aip);
			request.setAttribute(ConstantUtils.sfMessageContent, "Voaray ny IP ["+ip+"].");
		}
		else{
			request.setAttribute(ConstantUtils.sfMessageContent, "Hamarino ny IP ["+ip+"] azafady.");
			form.setAuthorizedIP(aip);
		}
		request.setAttribute(ConstantUtils.sfMessageExist, Boolean.TRUE);
		
		return new ModelAndView("secure/formAddIp", FormAuthorizedIp.sfFORM_ID, form);
	}

}
