/**
 * 
 */
package mg.fjkm.ankadifotsy.controller;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mg.fjkm.ankadifotsy.bo.FanisamBato;
import mg.fjkm.ankadifotsy.bo.Fifidianana;
import mg.fjkm.ankadifotsy.bo.Vato;
import mg.fjkm.ankadifotsy.exception.CreationVatoException;
import mg.fjkm.ankadifotsy.form.FormManisaVato;
import mg.fjkm.ankadifotsy.service.FjkmAnkadifotsyService;
import mg.fjkm.ankadifotsy.util.ConstantUtils;
import mg.fjkm.ankadifotsy.util.Utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * Controleur pour la saisie des voix pour les candidats pour le comptabiliser (un bulletin contient
 * les voix de 0 ou plusieurs candidats)
 * Egalement le controller utilisé pour re-éditer le dernier bulletin de vote enregistré (mamerina)
 * Egalement utilisé depuis le contrôle de bulletin pour corriger les erreurs éventuelles (fromAdmin)
 * @author rija
 * @version 1.0
 */
public class ManisaVatoController implements Controller{
	/** Logger for this class and subclasses */    
	protected final Log logger = LogFactory.getLog(getClass());

	private FjkmAnkadifotsyService fFjkmService = null;
		
	public void setFjkmAnkadifotsyService(FjkmAnkadifotsyService fjkmService) {
		fFjkmService = fjkmService;
	}


	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = null;
		
		//Forcer le rechargement de this lors de la prochaine requête (enmpêche le navigateur de mettre en cache les données retournées)
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setDateHeader("Expires", 0); // Proxies.
		
		FormManisaVato formulaire = (FormManisaVato)req.getSession().getAttribute(FormManisaVato.sfFORM_ID);
		formulaire.setDtime((new Date()).getTime());
		
		//ainsi que le nombre total de voix exprimé
		Fifidianana fifidianana = Utils.getFifidiananaFromSession(req);
		if (fifidianana == null){
			req.setAttribute(ConstantUtils.sfMessageExist, true);			
			req.setAttribute(ConstantUtils.sfMessageContent, "Miverena misafidy fifidiana.");

			return new ModelAndView("secure/formManisaVato", FormManisaVato.sfFORM_ID, formulaire);
		}
		else{
			if (! fFjkmService.canProcessFanisambato(fifidianana.getId())){
				req.setAttribute(ConstantUtils.sfMessageExist, true);			
				req.setAttribute(ConstantUtils.sfMessageContent, "Mbola tsy manomboka ny Fanisambato.");
				
				return new ModelAndView("secure/formManisaVato", FormManisaVato.sfFORM_ID, formulaire);
			}
		}

		//Contrôle de sécurité
		String ip = Utils.getIpFromRequest(req);
		if (!fFjkmService.isIPAuthorized(ip)){
			return new ModelAndView("secure/accessDeniedFromIp", "message", "TSY MAHAZO alalana hanisa vato ny IP "+ip);
		}

		String s = req.getParameter("miverina");
		boolean miverina = Boolean.parseBoolean(s);

		if (miverina){
			formulaire.setFamerenana(true);
			
			//Miverina @ vato nisaina teo aloha
			formulaire.setDisabledMiverinaVatoTeoAloha();
			
			FanisamBato fanisamBato = fFjkmService.findFanisamBatoByFifidianana(fifidianana, formulaire.getLehilahy());
			
			//Vato nisaina teo aloha
			String laharana = (String)Utils.getObjectFromSession(req);
			Vato vato = fFjkmService.findVato(laharana, fifidianana.getId(), formulaire.getLehilahy());
			Set<Long> mirotsakaFidianaIdsNisaina = vato.getSafidys();
			formulaire.setMirotsakaFidianaIdsMiverina(mirotsakaFidianaIdsNisaina);
			formulaire.setVatoLaharana(laharana);
			formulaire.setVatoFotsy(vato.isVatoFotsy());
			formulaire.setVatoMaty(vato.isVatoMaty());

			formulaire.setFanisamBato(fanisamBato);
			
			//Averina aseho ny vato
			if (fifidianana.isFifidiananaOloTokana())
				modelAndView = new ModelAndView("secure/formManisaVatoOloTokana", FormManisaVato.sfFORM_ID, formulaire);
			else
				modelAndView = new ModelAndView("secure/formManisaVato", FormManisaVato.sfFORM_ID, formulaire);
		}
		else{
			//Fanisam-bato
			req.setAttribute(ConstantUtils.sfREQUEST_FIFIDIANANA, fifidianana);

			formulaire.setVatoFotsy(req.getParameter("vatoFotsy") != null);
			formulaire.setVatoMaty(req.getParameter("vatoMaty") != null);
			formulaire.setMirotsakaFidianaIdsMiverina(null);	//Réinitialiser le formulaire en décochant tout

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

			String message = "Voaray soa aman-tsara ny vato nampidirina teo";
			String vatoLaharana = req.getParameter("vatoLaharana");

			String famerenana = req.getParameter("famerenana");
			boolean isFamerenana = Boolean.parseBoolean(famerenana);

			String username = Utils.getLoggedUserName(); 
				
			if (vatoLaharana == null || "".equals(vatoLaharana.trim())){
				formulaire.setMirotsakaFidianaIdsMiverina(mirotsakaFidianaIds);
				formulaire.setVatoLaharana(vatoLaharana);
				message = "Ampidiro ny nomerao bulletin";
			}
			else{
				Utils.setObjectInSession(req, vatoLaharana);
				try{
					FanisamBato fanisamBato = fFjkmService.isaoVato(fifidianana, vatoLaharana, mirotsakaFidianaIds, vatoMaty, vatoFotsy, formulaire.getLehilahy(), isFamerenana, username, ip);
					formulaire.setFanisamBato(fanisamBato);
					formulaire.setVatoLaharana("");
					
					Map<String, Long> stats = fFjkmService.getStats(fifidianana.getId(), formulaire.getLehilahy(), ip);
					formulaire.setIPStats(stats);

					if (vatoMaty)
						message = "Maty ny vato nampidirina  teo";
					else if (vatoFotsy)
						message = "Fotsy ny vato nampidirina teo";
				}
				catch(CreationVatoException e){
					formulaire.setMirotsakaFidianaIdsMiverina(mirotsakaFidianaIds);
					if (fifidianana.getIsan_Nomerao() != null)
						vatoLaharana = Utils.getVatoLaharanaPadded(vatoLaharana, '0', fifidianana.getIsan_Nomerao());
					formulaire.setVatoLaharana(vatoLaharana);
					message = e.getMessage();
				}
			}

			String url = req.getRequestURL().toString();
			if (url.contains("/admin/"))
				req.setAttribute("fromAdmin", "true");
			
			req.setAttribute(ConstantUtils.sfMessageExist, true);			
			req.setAttribute(ConstantUtils.sfMessageContent, message);
			
			formulaire.resetMiverinaVatoTeoAloha();
			formulaire.setFamerenana(false);
		}
		
		//Ré-initialiser le formulaire
		formulaire.setVatoFotsy(false);
		formulaire.setVatoMaty(false);
		
		Utils.setSelectedTab(req, ConstantUtils.sfAccessFifidianana);
		
		return modelAndView;
	}
		
}
