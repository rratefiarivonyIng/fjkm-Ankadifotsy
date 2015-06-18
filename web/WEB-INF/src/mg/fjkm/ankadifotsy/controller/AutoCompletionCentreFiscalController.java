package mg.fjkm.ankadifotsy.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mg.fjkm.ankadifotsy.bo.Faritra;
import mg.fjkm.ankadifotsy.bo.ILabelable;
import mg.fjkm.ankadifotsy.service.FjkmAnkadifotsyService;
import mg.fjkm.ankadifotsy.util.ConstantUtils;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


/**
 * Controleur permettant de renvoyer la liste des r�gions suivant la province s�lectionn�e
 * Si aucune province n'est encore s�lectionn�e alors renvoier toutes les r�gions disponibles et suivant le filtre  
 * @author Rija
 * @version 1.0
 */
public class AutoCompletionCentreFiscalController implements Controller{

	private FjkmAnkadifotsyService fFjkmAnkadifotsyService = null;
	
	
	public void setFjkmAnkadifotsyService(FjkmAnkadifotsyService nifService) {
		fFjkmAnkadifotsyService = nifService;
	}

	/**
	 * Renvoie la valeur du param�tre dont le nom commence par "region"
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
				if (current.startsWith("centreFiscal"))
					value.put(ConstantUtils.sfDATA_FARITRAS,request.getParameter(current));				
				else if (current.startsWith("commune"))
					value.put(ConstantUtils.sfAJAX_IDCOMMUNE,request.getParameter(current));				
			}
		}

		return value;
	}
	
	public ModelAndView handleRequestWithoutPageRenderer(HttpServletRequest request, HttpServletResponse resp) throws Exception {
		//Rcuprer les informations sur l'tat  Imprimer
		resp.setContentType("text/xml");
		ServletOutputStream out = resp.getOutputStream();
		
		Map<String,String> parameters = getParameterValue(request);

		List<Faritra> centreFiscaux = fFjkmAnkadifotsyService.getCentreFiscaux(parameters); 
		StringBuffer data = new StringBuffer("<?xml version=\"1.0\" encoding=\"ISO_8859-1\" ?>");
		data.append("<ajax-response>");
		data.append("<response>");
		data.append("<list>");
		for (Faritra centre : centreFiscaux){
			data.append("<item>");
			data.append("<name><![CDATA["+centre.getLabel()+"]]></name>");
			data.append("<value><![CDATA["+centre.getId()+"]]></value>");
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

		List<Faritra> centreFiscaux = fFjkmAnkadifotsyService.getCentreFiscaux(parameters);
		List<ILabelable> localisations = new ArrayList<ILabelable>();
		for (Faritra centreFiscal : centreFiscaux){
			localisations.add(centreFiscal);			
		}
		
		return new ModelAndView("localisationAjaxResponse", "data", localisations);
	}
}
