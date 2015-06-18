/**
 * 
 */
package mg.fjkm.ankadifotsy.controller;

import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mg.fjkm.ankadifotsy.bo.Fifidianana;
import mg.fjkm.ankadifotsy.bo.Vato;
import mg.fjkm.ankadifotsy.form.FormManisaVato;
import mg.fjkm.ankadifotsy.service.FjkmAnkadifotsyService;
import mg.fjkm.ankadifotsy.util.ConstantUtils;
import mg.fjkm.ankadifotsy.util.Utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Controleur pour l'édition d'un bulletin de vote avec les voix pour les candidats pour une modification (un bulletin contient
 * les voix de 0 ou plusieurs candidats).
 * La comptabilisation se fait par ajax depuis un autre Controller
 * @author rija
 * @version 1.0
 */
public class EditVatoController implements Controller{
	/** Logger for this class and subclasses */    
	protected final Log logger = LogFactory.getLog(getClass());

	private FjkmAnkadifotsyService fFjkmService = null;
		
	public void setFjkmAnkadifotsyService(FjkmAnkadifotsyService nifService) {
		fFjkmService = nifService;
	}


	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		FormManisaVato formulaire = null;
		Fifidianana fifidianana = Utils.getFifidiananaFromSession(request);
		if (fifidianana == null)
			return new ModelAndView(new RedirectView(request.getContextPath()+"/secure/index.htm?message="+URLEncoder.encode("Miverena misafidy fifidiana.", "utf-8")));
		
		Boolean lehilahy = null;
		if (Utils.isParameterNameExist(request, "lehilahy"))
			lehilahy = true;
		else if (Utils.isParameterNameExist(request, "vehivavy"))
			lehilahy = false;
		
		if (fifidianana == null)
			throw new RuntimeException("Misafidiana fifidianana.");
		
		String vatoLaharana = (String)request.getParameter("vatoLaharana");
		
		//Soit première initialisation du formulaire Soit dans le cas de fifidianana olona maro ET misaraka ET changement de formulaire d'un genre à un autre
		if (vatoLaharana != null && !"".equals(vatoLaharana.trim())){
			formulaire = new FormManisaVato();
			Vato vato = fFjkmService.findVato(vatoLaharana, fifidianana.getId(), lehilahy);
			List<Map<String, Object>> list = fFjkmService.findMapMirotsakaFidiana(fifidianana.getId(), true, lehilahy);
			formulaire.setMirotsakaFidianas(list);
			formulaire.setFanisamBato(fFjkmService.findFanisamBatoByFifidianana(fifidianana, lehilahy));
			Set<Long> mirotsakaFidianaIdsNisaina = vato.getSafidys();
			formulaire.setMirotsakaFidianaIdsMiverina(mirotsakaFidianaIdsNisaina);
			formulaire.setVatoLaharana(vatoLaharana);
			formulaire.setVatoFotsy(vato.isVatoFotsy());
			formulaire.setVatoMaty(vato.isVatoMaty());
			formulaire.setFamerenana(true);
		}
				
		formulaire.setDisabledMiverinaVatoTeoAloha();
		
		request.setAttribute("lehilahy", lehilahy);
		request.setAttribute(ConstantUtils.sfREQUEST_FIFIDIANANA, fifidianana);
		request.getSession().setAttribute(FormManisaVato.sfFORM_ID, formulaire);

		if (fifidianana.isFifidiananaOloTokana()){
			//Fifidianana olo-tokana
			return new ModelAndView("secure/manisaVatoOloTokana", FormManisaVato.sfFORM_ID, formulaire);
		}
		else{
			if (lehilahy == null){
				//Fifidianana mitambatra
				return new ModelAndView("secure/manisaVato", FormManisaVato.sfFORM_ID, formulaire);
			}
			else{
				//Fifidianana misaraka ny lahy sy ny vavy
				return new ModelAndView("secure/manisaVatoMisaraka", FormManisaVato.sfFORM_ID, formulaire);
			}
		}
	}
	
}
