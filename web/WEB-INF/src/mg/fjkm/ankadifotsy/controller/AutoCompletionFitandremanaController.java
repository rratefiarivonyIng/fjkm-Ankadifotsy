package mg.fjkm.ankadifotsy.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mg.fjkm.ankadifotsy.bo.ILabelable;
import mg.fjkm.ankadifotsy.service.FjkmAnkadifotsyService;
import mg.fjkm.ankadifotsy.util.ConstantUtils;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


/**
 * Controleur permettant de renvoyer la liste des mpivavaka suivant le début de libellé saisi comme filtre
 * @author Rija
 * @version 1.0
 */
public class AutoCompletionFitandremanaController implements Controller{

	private FjkmAnkadifotsyService fFjkmAnkadifotsyService = null;
	
	
	public void setFjkmAnkadifotsyService(FjkmAnkadifotsyService fjkmService) {
		fFjkmAnkadifotsyService = fjkmService;
	}

	/**
	 * Renvoie la valeur du paramètre dont le nom commence par "mpivavaka"
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
				if (current.startsWith("fitandremana"))
					value.put(ConstantUtils.sfAJAX_LABEL,request.getParameter(current));				
			}
		}

		return value;
	}
	
	public ModelAndView handleRequestWithoutPageRenderer(HttpServletRequest request, HttpServletResponse resp) throws Exception {
		//Rcuprer les informations sur l'tat  Imprimer
		resp.setContentType("text/xml");
		ServletOutputStream out = resp.getOutputStream();
		
		Map<String,String> parameters = getParameterValue(request);

		List<ILabelable> fitandremanas = fFjkmAnkadifotsyService.getLabelablesForAutoCompletion(parameters); 
		StringBuffer data = new StringBuffer("<?xml version=\"1.0\" encoding=\"ISO_8859-1\" ?>");
		data.append("<ajax-response>");
		data.append("<response>");
		data.append("<list>");
		for (ILabelable fitandremana : fitandremanas){
			data.append("<item>");
			data.append("<name><![CDATA["+fitandremana.getLabel()+"]]></name>");
			data.append("<value><![CDATA["+fitandremana.getId()+"]]></value>");
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

		List<ILabelable> fitandremanas = fFjkmAnkadifotsyService.getLabelablesForAutoCompletion(parameters);
		
		return new ModelAndView("labelableAjaxResponse", "data", fitandremanas);
	}
}
