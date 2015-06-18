/**
 * 
 */
package mg.fjkm.ankadifotsy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mg.fjkm.ankadifotsy.service.FjkmAnkadifotsyService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


/**
 * Classe permettant d'accéder à la page d'index
 * @author rija
 * @version 1.0
 */
public class IndexController implements Controller {

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
		return new ModelAndView("secure/index", "users", fFjkmAnkadifotsyService.findUsers());
	}	
}
