/**
 * 
 */
package mg.fjkm.ankadifotsy.controller;

import java.net.URLEncoder;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mg.fjkm.ankadifotsy.bo.FanisamBato;
import mg.fjkm.ankadifotsy.bo.Fifidianana;
import mg.fjkm.ankadifotsy.exception.CreationVatoException;
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
 * Controleur pour la saisie des voix pour les candidats pour le comptabiliser (un bulletin contient
 * les voix de 0 ou plusieurs candidats)
 * @author rija
 * @version 1.0
 */
public class MandrotsaBatoController implements Controller{
	/** Logger for this class and subclasses */    
	protected final Log logger = LogFactory.getLog(getClass());

	private FjkmAnkadifotsyService fFjkmService = null;
		
	public void setFjkmAnkadifotsyService(FjkmAnkadifotsyService nifService) {
		fFjkmService = nifService;
	}


	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = null;
		
		FormManisaVato formulaire = (FormManisaVato)req.getSession().getAttribute(FormManisaVato.sfFORM_ID);
		
		//ainsi que le nombre total de voix exprimé
		Fifidianana fifidianana = Utils.getFifidiananaFromSession(req);
		if (fifidianana == null)
			return new ModelAndView(new RedirectView(req.getContextPath()+"/secure/index.htm?message="+URLEncoder.encode("Miverena misafidy fifidiana.", "utf-8")));
		
		req.setAttribute(ConstantUtils.sfREQUEST_FIFIDIANANA, fifidianana);

		formulaire.setVatoFotsy(req.getParameter("vatoFotsy") != null);
		formulaire.setVatoMaty(req.getParameter("vatoMaty") != null);

		boolean vatoMaty = false;
		boolean vatoFotsy = false;
		Set<Long> mirotsakaFidianaIds = new HashSet<Long>();
		
		if (fifidianana.isFifidiananaOloTokana()){
			int nb = 0;	//Pour controler les voix blancs

			String mirotsaka = "mirotsaka";
			String value = req.getParameter(mirotsaka);
			
			//Récupérer les laharanaMpirotsakas qui vont être incrémenté de 1 : ce sont ceux dont le value affiché ci-dessus est "on"
			Collection<Integer> laharanaIds = new HashSet<Integer>();
			if (value != null && !"".equals(value.trim())){
				laharanaIds.add(Integer.parseInt(value));
				nb ++ ;					
			}

			if (laharanaIds.size() > 0){
				Map<Integer, Long> mapLaharanaId2MirotsakaFididanaId = fFjkmService.getLaharana2MirotsakaFidianaId(laharanaIds);
				for (Integer laharanaId : mapLaharanaId2MirotsakaFididanaId.keySet())
					mirotsakaFidianaIds.add(mapLaharanaId2MirotsakaFididanaId.get(laharanaId));
			}
			
			//Vato fotsy si le nb de choix de Lehilahy = 0 ET le nb de choix de vehivavy = 0
			vatoMaty = formulaire.isVatoMaty();			
			vatoFotsy = formulaire.isVatoFotsy() || nb == 0;
			
			modelAndView = new ModelAndView("secure/formManisaVatoOloTokana", FormManisaVato.sfFORM_ID, formulaire);
		}
		else{
			//Fifidianana olona maromaro
			int col = 0;
			int nbLahy = 0;
			int nbVavy = 0;
			for (Map<String,Object> mirotsakaFidiana : formulaire.getMirotsakaFidianas()){
				Integer laharanaMpirotsaka = (Integer)mirotsakaFidiana.get("laharanaMpirotsaka");
				String mirotsaka = "mirotsaka"+laharanaMpirotsaka;
				String value = req.getParameter(mirotsaka);
				if (col % 10 == 0)
					System.out.println();

				System.out.print(laharanaMpirotsaka+" : "+value +"   ");
				col ++;
				
				//Récupérer les laharanaMpirotsakas qui vont être incrémenté de 1 : ce sont ceux dont le value affiché ci-dessus est "on"
				if (value != null && "on".equals(value.trim())){
					mirotsakaFidianaIds.add((Long)mirotsakaFidiana.get("mirotsakaFidianaId"));
					Boolean lahy = (Boolean)mirotsakaFidiana.get("lahy");
					if (lahy.booleanValue())
						nbLahy ++ ;
					else
						nbVavy ++;
					
				}
			}
			
			//Vato maty si le nb de choix pour les Diakona lehilahy est > sfNB_LEHILAHY_MAX ou si le nb de choix pour les Diakona vehivavy est >  sfNB_VEHIVAVY_MAX
			//Vato fotsy si le nb de choix de Lehilahy = 0 ET le nb de choix de vehivavy = 0
			int nbMaxOlonaFidiana = fifidianana.getIsaOlonaFidiana();
			vatoMaty = formulaire.isVatoMaty() || nbLahy > nbMaxOlonaFidiana || nbVavy > nbMaxOlonaFidiana;
			
			vatoFotsy = formulaire.isVatoFotsy() || (nbLahy == 0 && nbVavy == 0);
			
			modelAndView = new ModelAndView("secure/formManisaVato", FormManisaVato.sfFORM_ID, formulaire);
		}

		FanisamBato fanisamBato = null;
		try {
			fanisamBato = fFjkmService.isaoVato(fifidianana, req.getParameter("vatoLaharana"), mirotsakaFidianaIds, vatoMaty, vatoFotsy, formulaire.getLehilahy(), false, Utils.getLoggedUserName(), Utils.getIpFromRequest(req));
		} 
		catch (CreationVatoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute(ConstantUtils.sfMessageExist, true);
		String message = "Voaray soa aman-tsara ny vato nampidirina teo";
		if (vatoMaty)
			message = "Maty ny vato nampidirina  teo";
		else if (vatoFotsy)
			message = "Fotsy ny vato nampidirina teo";
		req.setAttribute(ConstantUtils.sfMessageContent, message);
		
		formulaire.setFanisamBato(fanisamBato);

		//Ré-initialiser le formulaire
		formulaire.setVatoFotsy(false);
		formulaire.setVatoMaty(false);
		
		Utils.setSelectedTab(req, ConstantUtils.sfAccessFifidianana);
		
		return modelAndView;
	}
		
}
