/**
 * 
 */
package mg.fjkm.ankadifotsy.controller;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mg.fjkm.ankadifotsy.bo.Mpivavaka;
import mg.fjkm.ankadifotsy.service.FjkmAnkadifotsyService;
import mg.fjkm.ankadifotsy.util.ConstantUtils;
import mg.fjkm.ankadifotsy.util.Utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


/**
 * Classe permettant d'accéder à la liste des chrétien
 * @author rija
 * @version 1.0
 */
public class ListChristianController implements Controller {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    private FjkmAnkadifotsyService fFjkmAnkadifotsyService = null;
           
	/**
	 * @param fjkmAnkadifotsyService the fFjkmAnkadifotsyService to set
	 */
	public void setFjkmAnkadifotsyService(FjkmAnkadifotsyService fjkmAnkadifotsyService) {
		fFjkmAnkadifotsyService = fjkmAnkadifotsyService;
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.Controller#handleRequest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse rep) throws Exception {
		Enumeration<String> attributeNames = req.getParameterNames();
		Integer pageNo = null;
		if (attributeNames.hasMoreElements()){
			String attribute = attributeNames.nextElement();
			try{
				pageNo = Integer.parseInt(attribute);
			}
			catch(NumberFormatException e){
				pageNo = 1;
				Utils.setCurrentPage(req, pageNo);
			}
		}
		
		List<Mpivavaka> list = fFjkmAnkadifotsyService.findAllMpivavaka(pageNo, Utils.getNbElementPerPageFromParameter(req, fFjkmAnkadifotsyService));
		String view = "secure/listChristian";

		Utils.setSelectedTab(req, ConstantUtils.sfAccessMpivavaka);

		return new ModelAndView(view, ConstantUtils.sfDATA_MPIVAVAKAS, list);
	}	
}
