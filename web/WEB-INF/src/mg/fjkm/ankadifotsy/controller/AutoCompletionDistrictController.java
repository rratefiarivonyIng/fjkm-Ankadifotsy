package mg.fjkm.ankadifotsy.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mg.fjkm.ankadifotsy.bo.District;
import mg.fjkm.ankadifotsy.bo.ILabelable;
import mg.fjkm.ankadifotsy.service.FjkmAnkadifotsyService;
import mg.fjkm.ankadifotsy.util.ConstantUtils;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


/**
 * Controleur permettant de renvoyer la liste des districts suivant la province et/ou le district sélectionnés
 * Si aucune province et/ou région n'est encore sélectionnée alors renvoier tous les districts disponibles et suivant le filtre  
 * @author Rija
 * @version 1.0
 */
public class AutoCompletionDistrictController implements Controller{

	private FjkmAnkadifotsyService fFjkmAnkadifotsyService = null;
	
	
	public void setFjkmAnkadifotsyService(FjkmAnkadifotsyService nifService) {
		fFjkmAnkadifotsyService = nifService;
	}

	/**
	 * Renvoie la valeur du paramètre dont le nom commence par "region"
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
				if (current.startsWith("region"))
					value.put(ConstantUtils.sfAJAX_IDREGION,request.getParameter(current));				
				else if (current.startsWith("province"))
					value.put(ConstantUtils.sfAJAX_IDFIRAISANA,request.getParameter(current));
				else if (current.startsWith("district"))
					value.put(ConstantUtils.sfAJAX_DISTRICT, request.getParameter(current));
			}
		}

		return value;
	}
	
	/**
	* @NOTE : non utilisé car remplacé par handleRequest qui utilise une vue spécifique 
	*/ 
	public ModelAndView handleRequestWithoutPageRendere(HttpServletRequest request, HttpServletResponse resp) throws Exception {
		//Rcuprer les informations sur l'tat  Imprimer
		resp.setContentType("text/xml");
		ServletOutputStream out = resp.getOutputStream();
		
		Map<String,String> parameters = getParameterValue(request);

		List<District> districts = fFjkmAnkadifotsyService.getDistricts(parameters); 
		StringBuffer data = new StringBuffer("<?xml version=\"1.0\" encoding=\"ISO_8859-1\" ?>");
		data.append("<ajax-response>");
		data.append("<response>");
		data.append("<list>");
		for (District district : districts){
			data.append("<item>");
			data.append("<name><![CDATA["+district.getLabel()+"]]></name>");
			data.append("<value><![CDATA["+district.getId()+"]]></value>");
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

		List<District> districts = fFjkmAnkadifotsyService.getDistricts(parameters); 
		List<ILabelable> localisations = new ArrayList<ILabelable>();
		for (District district : districts){
			localisations.add(district);			
		}
		
		return new ModelAndView("localisationAjaxResponse", "data", localisations);
	}
}
