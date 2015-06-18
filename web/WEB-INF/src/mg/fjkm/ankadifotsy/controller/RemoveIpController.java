/**
 * 
 */
package mg.fjkm.ankadifotsy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mg.fjkm.ankadifotsy.form.FormAuthorizedIp;
import mg.fjkm.ankadifotsy.service.FjkmAnkadifotsyService;
import mg.fjkm.ankadifotsy.util.ConstantUtils;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * @author Rija
 * Controller pour supprimer une IP dans la base : l'IP ne sera plus autorisée pour certaines fonctionnalités
 */
public class RemoveIpController implements Controller {

	private FjkmAnkadifotsyService fFjkmAnkadifotsyService = null;
	
	
	public void setFjkmAnkadifotsyService(FjkmAnkadifotsyService fjkmAnkadifotsyService) {
		fFjkmAnkadifotsyService = fjkmAnkadifotsyService;
	}


	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.Controller#handleRequest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		if (id != null && !"".equals(id.trim())){
			fFjkmAnkadifotsyService.deleteAuthorizedIP(Long.parseLong(id));
			request.setAttribute(ConstantUtils.sfMessageContent, "Voafafa ny IP.");
		}
		request.setAttribute(ConstantUtils.sfMessageExist, Boolean.TRUE);
		
		return new ModelAndView("secure/formAddIp", FormAuthorizedIp.sfFORM_ID, new FormAuthorizedIp());
	}

}
