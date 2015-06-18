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

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * @author Rija
 * Controller pour éditer une IP existante 
 */
public class EditIpController implements Controller {

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
		FormAuthorizedIp formulaire = new FormAuthorizedIp();
		if (id != null && !"".equals(id.trim())){
			AuthorizedIP aip = fFjkmAnkadifotsyService.findAuthorizedIP(Long.parseLong(id));
			if (aip != null)
				formulaire.setAuthorizedIP(aip);
		}
		request.setAttribute(ConstantUtils.sfMessageExist, null);
		
		return new ModelAndView("secure/formAddIp", FormAuthorizedIp.sfFORM_ID, formulaire);
	}

}
