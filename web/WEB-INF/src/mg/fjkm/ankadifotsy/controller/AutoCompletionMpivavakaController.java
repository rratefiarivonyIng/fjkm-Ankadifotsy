package mg.fjkm.ankadifotsy.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mg.fjkm.ankadifotsy.bo.Mpivavaka;
import mg.fjkm.ankadifotsy.service.FjkmAnkadifotsyService;
import mg.fjkm.ankadifotsy.util.ConstantUtils;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


/**
 * Controleur permettant de renvoyer la liste des mpivavaka suivant le d�but de libell� saisi comme filtre
 * @author Rija
 * @version 1.0
 */
public class AutoCompletionMpivavakaController implements Controller{

	private FjkmAnkadifotsyService fFjkmAnkadifotsyService = null;
	
	
	public void setFjkmAnkadifotsyService(FjkmAnkadifotsyService fjkmService) {
		fFjkmAnkadifotsyService = fjkmService;
	}

	/**
	 * Renvoie la valeur du param�tre dont le nom commence par "mpivavaka"
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Map<String, String> getParameterValue(HttpServletRequest request){
		Map<String, String> value = new HashMap<String, String>();
		Enumeration<String> parameterNames = request.getParameterNames();
		while(parameterNames.hasMoreElements()){
			String current = parameterNames.nextElement();
			if (current != null){
				if (current.startsWith("mpivavaka"))
					value.put(ConstantUtils.sfAJAX_MPIVAVAKA,request.getParameter(current));
				else if (current.startsWith("excluMpivavaka"))
					value.put(ConstantUtils.sfAJAX_EXCLU_MPIVAVAKA,request.getParameter(current));
				else if (current.startsWith("lehilahy"))
					value.put(ConstantUtils.sfAJAX_MPIVAVAKA_LEHILAHY,request.getParameter(current));
				else if (current.startsWith("excluLehilahy"))
					value.put(ConstantUtils.sfAJAX_EXCLU_MPIVAVAKA_LEHILAHY,request.getParameter(current));
			}
		}

		return value;
	}
	
	public ModelAndView handleRequestWithoutPageRenderer(HttpServletRequest request, HttpServletResponse resp) throws Exception {
		//Rcuprer les informations sur l'tat  Imprimer
		resp.setContentType("text/xml");
		ServletOutputStream out = resp.getOutputStream();
		
		Map<String,String> parameters = getParameterValue(request);

		List<Mpivavaka> mpivavakas = fFjkmAnkadifotsyService.getMpivavaka(parameters); 
		StringBuffer data = new StringBuffer("<?xml version=\"1.0\" encoding=\"ISO_8859-1\" ?>");
		data.append("<ajax-response>");
		data.append("<response>");
		data.append("<list>");
		for (Mpivavaka mpivavaka : mpivavakas){
			data.append("<item>");
			data.append("<name><![CDATA["+mpivavaka.getAnarana()+" "+mpivavaka.getFanampiny()+"]]></name>");
			data.append("<value><![CDATA["+mpivavaka.getId()+"]]></value>");
			data.append("</item>");
		}
		data.append("</list>");
		data.append("</response>");
		data.append("</ajax-response>");
		out.print(data.toString());
		return null;
	}

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse resp) throws Exception {
		//Rcuprer les informations sur l'tat  Imprimer
		resp.setContentType("text/xml");
		Map<String,String> parameters = getParameterValue(request);

		List<Mpivavaka> mpivavakas = fFjkmAnkadifotsyService.getMpivavaka(parameters);
		
		return new ModelAndView("mpivavakaAjaxResponse", "data", mpivavakas);
	}
}
