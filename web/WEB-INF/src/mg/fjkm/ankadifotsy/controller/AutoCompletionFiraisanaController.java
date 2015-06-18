package mg.fjkm.ankadifotsy.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mg.fjkm.ankadifotsy.bo.Firaisana;
import mg.fjkm.ankadifotsy.bo.ILabelable;
import mg.fjkm.ankadifotsy.service.FjkmAnkadifotsyService;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


/**
 * Controleur permettant de gnrer les tats 1105/1104 
 * @author Rija
 * @version 1.0
 */
public class AutoCompletionFiraisanaController implements Controller{

	private FjkmAnkadifotsyService fFjkmAnkadifotsyService = null;
	
	
	public void setFjkmAnkadifotsyService(FjkmAnkadifotsyService nifService) {
		fFjkmAnkadifotsyService = nifService;
	}

	/**
	 * Renvoie la valeur du paramètre dont le nom commence par "province"
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private String getParameterValue(HttpServletRequest request){
		String value = null;
		Enumeration<String> parameterNames = request.getParameterNames();
		while(parameterNames.hasMoreElements()){
			String current = parameterNames.nextElement();
			if (current != null && current.startsWith("firaisana")){
				value = request.getParameter(current);
				break;
			}
		}

		return value;
	}
	
	public ModelAndView handleRequestWithoutRendererPage(HttpServletRequest request, HttpServletResponse resp) throws Exception {
		//Rcuprer les informations sur l'tat  Imprimer
		resp.setContentType("text/xml");
		ServletOutputStream out = resp.getOutputStream();
		String firaisanaLabel = getParameterValue(request);

		List<Firaisana> firaisanas = fFjkmAnkadifotsyService.getFiraisanas(firaisanaLabel); 
		StringBuffer data = new StringBuffer("<?xml version=\"1.0\" encoding=\"ISO_8859-1\" ?>");
		data.append("<ajax-response>");
		data.append("<response>");
		data.append("<list>");
		for (Firaisana firaisana : firaisanas){
			data.append("<item>");
			data.append("<name><![CDATA["+firaisana.getLabel()+"]]></name>");
			data.append("<value><![CDATA["+firaisana.getId()+"]]></value>");
			data.append("</item>");
		}
		data.append("</list>");
		data.append("</response>");
		data.append("</ajax-response>");
		out.print(data.toString());
		return null;
	}

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse resp) throws Exception {
		String firaisanaLabel = getParameterValue(request);
		resp.setContentType("text/xml");

		List<Firaisana> firaisanas = fFjkmAnkadifotsyService.getFiraisanas(firaisanaLabel);
		List<ILabelable> localisations = new ArrayList<ILabelable>();
		for (Firaisana firaisana : firaisanas)
			localisations.add(firaisana);

		return new ModelAndView("labelableAjaxResponse", "data", localisations);
	}
}
