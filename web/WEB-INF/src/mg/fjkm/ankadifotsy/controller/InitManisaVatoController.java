/**
 * 
 */
package mg.fjkm.ankadifotsy.controller;

import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mg.fjkm.ankadifotsy.bo.Fifidianana;
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
 * Controleur pour l'initialisation de la saisie des voix pour les candidats pour le comptabiliser (un bulletin contient
 * les voix de 0 ou plusieurs candidats).
 * La comptabilisation se fait par ajax depuis un autre Controller
 * @author rija
 * @version 1.0
 */
public class InitManisaVatoController implements Controller{
	/** Logger for this class and subclasses */    
	protected final Log logger = LogFactory.getLog(getClass());

	private FjkmAnkadifotsyService fFjkmService = null;
		
	public void setFjkmAnkadifotsyService(FjkmAnkadifotsyService fjkmService) {
		fFjkmService = fjkmService;
	}


	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		FormManisaVato formulaire = (FormManisaVato) request.getSession().getAttribute(FormManisaVato.sfFORM_ID);
		Fifidianana fifidianana = Utils.getFifidiananaFromSession(request);
		if (fifidianana == null)
			return new ModelAndView(new RedirectView(request.getContextPath()+"/secure/index.htm?message="+URLEncoder.encode("Miverena misafidy fifidiana.", "utf-8")));
		else{
			if (! fFjkmService.canProcessFanisambato(fifidianana.getId()))
				return new ModelAndView(new RedirectView(request.getContextPath()+"/secure/selectFifidianana.htm?id="+fifidianana.getId()+"&message="+URLEncoder.encode("Mbola tsy manomboka ny Fanisambato.", "utf-8")));
		}
		
		//Contrôle de sécurité
		String ip = Utils.getIpFromRequest(request);
		if (!fFjkmService.isIPAuthorized(ip))
			return new ModelAndView(new RedirectView(request.getContextPath()+"/secure/selectFifidianana.htm?id="+fifidianana.getId()+"&message="+URLEncoder.encode("Tsy mahazo alalana ny IP : ["+ip+"]", "utf-8")));
		
		Boolean lehilahy = null;
		if (Utils.isParameterNameExist(request, "lehilahy"))
			lehilahy = true;
		else if (Utils.isParameterNameExist(request, "vehivavy"))
			lehilahy = false;
				
		//Soit première initialisation du formulaire Soit dans le cas de fifidianana olona maro ET misaraka ET changement de formulaire d'un genre à un autre
		if (formulaire == null || (!fifidianana.isFifidiananaOloTokana() && !formulaire.getLehilahy().equals(lehilahy))){
			formulaire = new FormManisaVato();
			//optimiser en ne récupérant que les ids des Mpirotsaka au lieu de List<MirotsakaFidiana>  
			//List<MirotsakaFidiana> list = fFjkmService.findMirotsakaFidiana(fifidianana.getId(), true);
			List<Map<String, Object>> list = fFjkmService.findMapMirotsakaFidiana(fifidianana.getId(), true, lehilahy);
			formulaire.setMirotsakaFidianas(list);
			formulaire.setFanisamBato(fFjkmService.findFanisamBatoByFifidianana(fifidianana, lehilahy));
			formulaire.setVatoFotsy(false);
			formulaire.setVatoMaty(false);

		}
				
		formulaire.setDisabledMiverinaVatoTeoAloha();
		formulaire.setLehilahy(lehilahy);
		formulaire.setDtime((new Date()).getTime());
		
		Map<String, Long> stats = fFjkmService.getStats(fifidianana.getId(), lehilahy, ip);
		formulaire.setIPStats(stats);
		
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
