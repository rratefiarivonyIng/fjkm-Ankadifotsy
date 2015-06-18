/**
 * 
 */
package mg.fjkm.ankadifotsy.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mg.fjkm.ankadifotsy.bo.Fifidianana;
import mg.fjkm.ankadifotsy.bo.Mpivavaka;
import mg.fjkm.ankadifotsy.bo.Parameter;
import mg.fjkm.ankadifotsy.form.AbstractFormSearch;
import mg.fjkm.ankadifotsy.form.FormManisaVato;
import mg.fjkm.ankadifotsy.service.FjkmAnkadifotsyService;

import org.acegisecurity.Authentication;
import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.providers.encoding.Md5PasswordEncoder;
import org.acegisecurity.ui.rememberme.TokenBasedRememberMeServices;
import org.acegisecurity.userdetails.User;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.JstlView;


/**
 * Classe utilitaire contenant des fonctionnalités transversales
 * @author rija
 * @version 1.0
 */
public class Utils {
	
	public static final int sfNBMAX_ERREUR = 3;
	
	public static final String _255 = "(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";
	public static final Pattern pattern = Pattern.compile("^(?:" + _255 + "\\.){3}" + _255 + "$");
	
	private static Md5PasswordEncoder sfMd5PasswordEncoder = new Md5PasswordEncoder();
	public static final SimpleDateFormat sfDateFormatJJMMYYYY = new SimpleDateFormat("dd/MM/yyyy");
	public static final SimpleDateFormat sfDateFormatJJMMYYYYHHmmss = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	public static final SimpleDateFormat sfDateFormatYYYY = new SimpleDateFormat("yyyy");

	public static ModelAndView getErrorSessionExpiredView(){
		JstlView errorView = new JstlView();
		errorView.setUrl("errorSessionExpired.jsp");
		return new ModelAndView(errorView);
	}
	
	/**
	 * Calcul de la distance de Levenshtein entre 2 chaînes
	 * @param s1
	 * @param s2
	 * @return -1 si une des chaîne est null, >0 sinon , =0 si les deux chaînes sont identiques 
	 */
	public static int getDistance(String s1, String s2){
		int res = Integer.MAX_VALUE;
		if (s1 != null && s2 != null){
			int[][] d = new int[s1.length()+1][s2.length()+1];
			
			for (int i = 1; i <= s1.length(); i++)
				d[i][0] = s1.charAt(i-1);

			for (int j = 1; j <= s2.length(); j++)
				d[0][j] = s2.charAt(j-1);
			
			for (int i = 1; i <= s1.length(); i++){
				for (int j = 1; j <= s2.length(); j++){
					int cost = 0;
					//On ne différencie pas le majuscule du minuscule
					if (Character.toUpperCase(s1.charAt(i-1)) == Character.toUpperCase(s2.charAt(j-1)))
						cost = 0;
					else
						cost = 1;
					
					d[i][j] = min(d[i-1][j]+1, d[i][j-1]+1, d[i-1][j-1]+cost);
				}
			}
			res = d[s1.length()][s2.length()];
		}
		
		return res;
	}
	
	/**
	 * Renvoie le min entre 3 nombres entiers 
	 * @param i1
	 * @param i2
	 * @param i3
	 * @return
	 */
	public static int min(int i1, int i2, int i3){
		int ret = 0;
		ret = Math.min(i1, i2);
		ret = Math.min(ret, i3);
		return ret;
	}
	
	/**
	 * Complète à gauche par des '0' pour obtenir un code sur le nombre max de caractère
	 * @param code
	 * @param maxLength
	 * @return
	 */
	public static String completeString(String code, int maxLength){
		String completed = "";
		if (code == null || "".equals(code.trim()))
			completed="";
		else{
			completed = new String(code);
			for (int i=0; i < maxLength - code.length(); i++){
				completed = "0" + completed;
			}
		}
		return completed;
	}

	/**
	 * Permet de savoir si une chaîne contient des caractères alphabétiques ou uniquement des numériques et espace
	 * @param s
	 * @return
	 */
	public static boolean containsChar(String s){
		boolean ret = false;
		if (s != null && !"".equals(s.trim())){
			for (int i = 0; !ret && i < s.length() ; i++){
				char c = s.charAt(i);
				if ((c < 48 || c > 57) && c != 32){					
					ret = true;
				}
			}
		}
		return ret;
	}
	
	/**
	 * Renvoie la valeur de la variable dans le paramètre.
	 * Si la var n'existe pas dans le paramètre alors renvoie null
	 * @param parameter, couple var=val (Ex : etablissement=1   ou dirigeant=2)
	 * @param var
	 * @return
	 */
	public static String getIndexValue(String parameter, String var){
		String value = null;
		if (parameter != null && var != null){
			if (parameter.startsWith(var+"=")){
				int index = parameter.lastIndexOf(var);
				value = parameter.substring(index + var.length() + 1);
			}
		}
		return value;
	}
	
	/**
	 * Permet de fermer la session en cours en supprimant l'authentification déjà validée
	 * @param req
	 * @param rep
	 */
	public static void logout(HttpServletRequest req, HttpServletResponse rep){
		HttpSession session = req.getSession();
		session.invalidate();
		Cookie terminate = new Cookie(TokenBasedRememberMeServices.ACEGI_SECURITY_HASHED_REMEMBER_ME_COOKIE_KEY, null);
		terminate.setMaxAge(0);
		rep.addCookie(terminate);		
	}
	
	/**
	 * 
	 * @return le nom de l'utilisateur connecté
	 */
	public static String getLoggedUserName(){
		Authentication authentication = org.acegisecurity.context.SecurityContextHolder.getContext().getAuthentication(); 
		if (authentication != null){
			Object principal = authentication.getPrincipal();
			return ((User)principal).getUsername();
		}
		else
			return null;
	}

	/**
	 * 
	 * @return le nom de l'utilisateur connecté
	 */
	public static boolean isLoggedUserAdmin(){
		boolean ret = false;
		Authentication authentication = org.acegisecurity.context.SecurityContextHolder.getContext().getAuthentication(); 
		if (authentication != null){
			GrantedAuthority[] authorities = authentication.getAuthorities();
			if (authorities != null && authorities.length>0){
				for (GrantedAuthority authority : authorities){
					if ("ROLE_ADMIN".equals(authority.getAuthority())){
						ret = true;
						break;
					}
				}
			}
			else
				ret = false;
		}
		else
			ret = false;
		
		return ret;
	}
	
	/**
	 * Positionne l'onglet courant
	 * @param req
	 * @param tabName
	 */
	public static void setSelectedTab(HttpServletRequest req, String tabName){
		if (req != null && req.getSession() != null)
			req.getSession().setAttribute(ConstantUtils.sfSelectedTab, tabName);
	}

	/**
	 * 
	 * @param req
	 * @return le nom de l'onglet sélectionné
	 */
	public static String getSelectedTab(HttpServletRequest req){
		if (req != null && req.getSession() != null)
			return (String) req.getSession().getAttribute(ConstantUtils.sfSelectedTab);
		return null;
	}
	
	/**
	 * Positionne le Mpivavaka en session en vue d'une édition
	 * @param req
	 * @param mpivavaka
	 */
	public static void setMpivavakaInSession(HttpServletRequest req , Mpivavaka mpivavaka){
		if (req != null && req.getSession() != null)
			req.getSession().setAttribute(ConstantUtils.sfSESSION_MPIVAVAKA, mpivavaka);
	}

	/**
	 * Récupère le mpivavaka en session
	 * @param req
	 * @return
	 */
	public static Mpivavaka getMpivavakaFromSession(HttpServletRequest req){
		Mpivavaka ret = null;
		if (req != null && req.getSession() != null)
			ret = (Mpivavaka)req.getSession().getAttribute(ConstantUtils.sfSESSION_MPIVAVAKA);
		return ret;
	}

	/**
	 * Positionne le bulletin de vote en session pour cet utilisateur en vue de le traiter ultérieurement
	 * @param req
	 * @param mirotsakaFidianaIds
	 */
	public static void setVatoIsainaInSession(HttpServletRequest req, FormManisaVato formaManisaVato){
		if (req != null && req.getSession() != null)
			req.getSession().setAttribute(ConstantUtils.sfSESSION_MANISAVATO, formaManisaVato);
	}
	
	/**
	 * Renvoie le dernier bulletin comptabilisé par cet utilisateur (l'utilisateur associé à la session)
	 * @param req
	 * @return
	 */
	public static FormManisaVato getVatoIsainaFromSession(HttpServletRequest req){
		FormManisaVato ret = null;
		if (req != null && req.getSession() != null){
			ret = (FormManisaVato)req.getSession().getAttribute(ConstantUtils.sfSESSION_MANISAVATO);
		}
		return ret;
	}
	
	public static String getVatoLaharanaFromSession(HttpServletRequest req){
		String ret = null;
	
		if (req != null && req.getSession() != null)
			ret = (String)req.getSession().getAttribute(ConstantUtils.sfSESSION_MANISAVATO_LAHARANA);
		
		return ret;
	}
	
	/**
	 * Positionne le Fifidianana sélectionné en session durant le mode d'édition d'un Fifidianana
	 * @param req
	 * @param fifidianana
	 */
	public static void setFifidiananaInSession(HttpServletRequest req , Fifidianana fifidianana){
		if (req != null && req.getSession() != null)
			req.getSession().setAttribute(ConstantUtils.sfSESSION_FIFIDIANANA, fifidianana);
	}
	
	public static Fifidianana getFifidiananaFromSession(HttpServletRequest req){
		Fifidianana ret = null;
		if (req != null && req.getSession() != null)
			ret = (Fifidianana)req.getSession().getAttribute(ConstantUtils.sfSESSION_FIFIDIANANA);
		return ret;
	}

	public static void setObjectInSession(HttpServletRequest req , Object object){
		if (req != null && req.getSession() != null)
			req.getSession().setAttribute(ConstantUtils.sfSESSION_OBJECT, object);
	}

	public static Object getObjectFromSession(HttpServletRequest req){
		Object ret = null;
		if (req != null && req.getSession() != null)
			ret = req.getSession().getAttribute(ConstantUtils.sfSESSION_OBJECT);
		return ret;
	}

	/**
	 * Ré-initialiser le formulaire  en session
	 * @param req
	 * @param name
	 * @param formulaire
	 */
	public static void setFormulaireInSession(HttpServletRequest req, String name, AbstractFormSearch formulaire){
		if (req != null && name != null)
			req.getSession().setAttribute(name, formulaire);
	}
	
	public static AbstractFormSearch getFormulaireFromSession(HttpServletRequest req, String name){
		AbstractFormSearch ret = null;
		if (req != null && name != null)
			ret = (AbstractFormSearch)req.getSession().getAttribute(name);
		
		return ret;
	}
	
	/**
	 * 
	 * @param req
	 * @return le numéro de page courant de l'utilisateur lors de sa dernière recherche.
	 * Si c'est la première recherche , le numéro renvoyé est 1
	 */
	public static Integer getCurrentPage(HttpServletRequest req){
		Integer ret = (Integer)req.getSession().getAttribute(ConstantUtils.sfCurrentPage);
		if (ret == null){
			ret = 1;
			setCurrentPage(req, ret);
		}
		return ret;
	}
	
	/**
	 * @param req
	 * @return Renvoie le numéro de page suivante et met à jour la session
	 */
	public static Integer getNextPageNoAndUpdateSession(HttpServletRequest req){
		return getPageNoByStep(req, 1, true);
	}

	/**
	 * @param req
	 * @return Renvoie le numéro de page suivante MAIS ne met pas à jour la session
	 */
	public static Integer getNextPageNo(HttpServletRequest req){
		return getPageNoByStep(req, 1, false);
	}
	
	/**
	 * @param req
	 * @return Renvoie le numéro de page précédente et met à jour la session
	 */
	public static Integer getPreviousPageNoAndUpdateSession(HttpServletRequest req){
		return getPageNoByStep(req, -1, true);
	}

	/**
	 * @param req
	 * @return Renvoie le numéro de page précédente MAIS NE met PAS à jour la session
	 */
	public static Integer getPreviousPageNo(HttpServletRequest req){
		return getPageNoByStep(req, -1, false);
	}

	/**
	 * @param req
	 * @param step
	 * @param updateSession, si true alors met à jour la session
	 * @return Renvoie le numéro de page en fonction du pas
	 */
	private static Integer getPageNoByStep(HttpServletRequest req , int step, boolean updateSession){
		Integer ret = getCurrentPage(req);
		ret = ret + step;
		
		if (updateSession)
			setCurrentPage(req, ret);
		return ret;
	}
	
	/**
	 * Positionne le numéro de page courant en session de l'utilisateur
	 * @param req
	 * @param pageNo
	 */
	public static void setCurrentPage(HttpServletRequest req, Integer pageNo){
		req.getSession().setAttribute(ConstantUtils.sfCurrentPage,  pageNo);
	}
	
	/**
	 * Positionne le formulaire d'information sur le numero de page courant, le nb total de page etc ...
	 * pour la gestion de la pagination
	 * @param req
	 * @param form
	 */
	public static void setCurrentSearchForm(HttpServletRequest req, AbstractFormSearch form){
		if (req != null)
			req.setAttribute(ConstantUtils.sfDATA_SEARCHFORM, form);
	}
	
	public static AbstractFormSearch getCurrentSearchForm(HttpServletRequest req){
		if (req != null)
			return (AbstractFormSearch)req.getAttribute(ConstantUtils.sfDATA_SEARCHFORM);
		else
			return null;
	}
	
	/**
	 * Ré-initialise le numéro de page en cours de l'utilisateur
	 * @param req
	 */
	public static void initCurrentPage(HttpServletRequest req){
		setCurrentPage(req, null);
	}

	public static String getPhotoName(String anarana, Long id){
		String path = ConstantUtils.sfPhotosRootPath + anarana + id + ConstantUtils.sfPhotosJpegSuffix;			
		return path;
	}
	
	public static String getPhotoName(HttpServletRequest req, Mpivavaka mpivavaka){
		String ret = mpivavaka.getPhotoName();
		if (req != null){
			String fileName = req.getSession().getServletContext().getRealPath(ret);
			if (!new File(fileName).exists())
				ret = mpivavaka.getDefaultPhotoName();
		}

		return ret;		
	}

	public static String getDefaultPhotoName(boolean isLahy){
		String ret = ConstantUtils.sfPhotosRootPath + ConstantUtils.sfPhotosDefaultBoy + ConstantUtils.sfPhotosJpegSuffix;
		
		if (!isLahy)
			ret = ConstantUtils.sfPhotosRootPath + ConstantUtils.sfPhotosDefaultGirl + ConstantUtils.sfPhotosJpegSuffix;
		
		return ret;
	}

	public static String getPhotoName(HttpServletRequest req, String anarana, Long id, boolean isLahy){
		String ret = getPhotoName(anarana, id);
		if (req != null){
			String fileName = req.getSession().getServletContext().getRealPath(ret);
			if (!new File(fileName).exists())
				ret = getDefaultPhotoName(isLahy);
		}

		return ret;		
	}

	/**
	 * Renommer un fichier existant
	 * @param oldName
	 * @param newName
	 */
	public static void renamePhotoName(HttpServletRequest req, String oldName, String newName){
		if (req != null && oldName != null && newName != null){
			String oldFileName = req.getSession().getServletContext().getRealPath(oldName);
			File oldFile = new File(oldFileName);
			if (oldFile.exists()){
				String newFileName = req.getSession().getServletContext().getRealPath(newName);
				oldFile.renameTo(new File(newFileName));
			}
		}
	}
	
	/**
	 * Ajout ou soustrait la durée spécifiée à la date en paramètre 
	 * @param date - date.
	 * @param field - calendar field.
	 * @param amount - la durée à ajouter ou à soustraire
	 * @return date
	 */
	public static Date add(Date date, int field, int amount){
		if(date != null){
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(field, amount);
			return cal.getTime();
		}
		return null;
	}
	
	public static Date getDateMoins5Ans(Date date){
		Date dateMoins5Ans = Utils.add(date, Calendar.YEAR, -5);
	
		return dateMoins5Ans;
	}
	
	/**
	 * 
	 * @return la durée en ms de 25 ans
	 */
	public static long get25AnsDuration(){
		Double duration = 25.0 * 365.25 * 24.0 * 60.0 * 60.0 * 1000.0;
		return duration.longValue();
	}

	/**
	 * 
	 * @param s
	 * @return la chaîne passée en paramètre en supprimant tous les espaces (NOTE : renvoie une nouvelle instance)
	 */
	public static String getTrimmedString(String s){
		String ret = "";
		if (s != null){
			StringTokenizer st =new StringTokenizer(s.trim(), " ");
			StringBuffer sb = new StringBuffer();
			while (st.hasMoreTokens()) {
				String token = st.nextToken();
				if (!token.trim().equals(""))
					sb.append(token);
			}
			ret = sb.toString();
		}
		return ret;
	}
	
	/**
	 * 
	 * @param nbElements
	 * @param nbElementPerPage
	 * @return nombre total de page en fonction du nombre d'éléments et du nombre d'éléments par page
	 */
	public static Long getNbPageTotal(Long nbElements, Integer nbElementPerPage){
		Long pageTotal = nbElements / nbElementPerPage;
		if (nbElements % nbElementPerPage == 0)
			pageTotal --;
		
		return pageTotal;
	}
	
	/**
	 * 
	 * @param str
	 * @param size
	 * @param padChar
	 * @return la chaîne de caractère complété par padChar autant de fois que nécessaire jusqu'à l'obtention de la taille size
	 */
	public static String pad(String str, int size, char padChar){
		StringBuffer padded = new StringBuffer(str);
		while (padded.length() < size){
			padded.append(padChar);
		}
		return padded.toString();
	}

	/**
	 * 
	 * @param req
	 * @return true si l'édition en cours a été lancée depuis les résultats d'une recherche 
	 */
	public static boolean isFromSearch(HttpServletRequest req){
		boolean ret = isParameterNameExist(req, ConstantUtils.sfEditedFromSearch);
			
		return ret;
	}

	public static boolean isReload(HttpServletRequest req){
		boolean ret = isParameterNameExist(req, ConstantUtils.sfReload);
		return ret;
	}
	
	@SuppressWarnings("unchecked")
	public static boolean isParameterNameExist(HttpServletRequest req, String parameterName){
		boolean ret = false;
		if (req != null && parameterName != null && !"".equals(parameterName.trim())){
			Enumeration<String> parameterNames = req.getParameterNames();
			while(parameterNames.hasMoreElements()){
				if (parameterName.equalsIgnoreCase(parameterNames.nextElement())){
					ret = true;
					break;
				}
			}
		}
			
		return ret;
	}
	
	/**
	 * 
	 * @param req
	 * @return le paramètre associé à l'utilisateur depuis la session. Si le paramètre ni est pas encore alors le charger
	 * depuis la base de données. Si le paramètre n'existe pas encore en base alors , le créer.
	 */
	public static Parameter getParameter(HttpServletRequest req, FjkmAnkadifotsyService fjkmAnkadifotsyService){
		Parameter parameter = null;
		if (req != null && fjkmAnkadifotsyService != null){
			parameter = (Parameter)req.getSession().getAttribute(ConstantUtils.sfSESSION_PARAMETER);
			if (parameter == null){
				parameter = fjkmAnkadifotsyService.findParameterByUser(getLoggedUserName());
				setParameter(req, parameter);
			}
		}
		return parameter;
	}
	
	/**
	 * Rafraîchit le paramètre dans la session
	 * @param req
	 * @param parameter
	 */
	public static void setParameter(HttpServletRequest req, Parameter parameter){
		if (req != null)
			req.getSession().setAttribute(ConstantUtils.sfSESSION_PARAMETER, parameter);
	}
	
	/**
	 * 
	 * @param req
	 * @param fjkmAnkadifotsyService
	 * @return nb de ligne de résultat de recherche de Mpivavaka
	 */
	public static Integer getNbElementPerPageFromParameter(HttpServletRequest req, FjkmAnkadifotsyService fjkmAnkadifotsyService){
		Integer ret = null;
		if (req != null && fjkmAnkadifotsyService != null){
			Parameter parameter = getParameter(req, fjkmAnkadifotsyService);
			if (parameter != null)
				ret = parameter.getNbElementPerPage();
		}
		
		return ret;
	}
	
	/**
	 * 
	 * @param req
	 * @param fjkmAnkadifotsyService
	 * @return le nombre de lignes affichées pour le résultat temporaire des votes dans les formulaires ManisaVato et ManisaVatoOloTokana
	 */
	public static Integer getNbTempResultVote(HttpServletRequest req, FjkmAnkadifotsyService fjkmAnkadifotsyService){
		Integer ret = null;
		if (req != null && fjkmAnkadifotsyService != null){
			Parameter parameter = getParameter(req, fjkmAnkadifotsyService);
			if (parameter != null)
				ret = parameter.getNbTempResultVote();
		}
		return ret;
	}
	
	
	public static String encodePassword(String password){
		String encoded = null;
		if (password != null && !"".equals(password))
			encoded = sfMd5PasswordEncoder.encodePassword(password, null); 
		return encoded;
	}

	public static boolean isPasswordValid(String encPass, String rawPass){
		return sfMd5PasswordEncoder.isPasswordValid(encPass, rawPass, null);
	}
	
	private static long ipV4ToLong(String ip) {
		String[] octets = ip.split("\\.");
		return (Long.parseLong(octets[0]) << 24) + (Integer.parseInt(octets[1]) << 16) + (Integer.parseInt(octets[2]) << 8) + Integer.parseInt(octets[3]);
	}
		  
	private static boolean isIPv4Private(String ip) {
		long longIp = ipV4ToLong(ip);
		return (longIp >= ipV4ToLong("10.0.0.0") && longIp <= ipV4ToLong("10.255.255.255")) ||
		        (longIp >= ipV4ToLong("172.16.0.0") && longIp <= ipV4ToLong("172.31.255.255")) ||
		        longIp >= ipV4ToLong("192.168.0.0") && longIp <= ipV4ToLong("192.168.255.255");
	}

	public static boolean isIPv4Valid(String ip) {
		return pattern.matcher(ip).matches();
	}

	/**
	 * 
	 * @param request
	 * @return user IP even if user is over proxy or request is forwarded 
	 */
	public static String getIpFromRequest(HttpServletRequest request) {
		String ip;
		boolean found = false;
		if ((ip = request.getHeader("x-forwarded-for")) != null) {
			StringTokenizer tokenizer = new StringTokenizer(ip, ",");
			while (tokenizer.hasMoreTokens()) {
				ip = tokenizer.nextToken().trim();
				if (isIPv4Valid(ip) && !isIPv4Private(ip)) {
					found = true;
					break;
				}
			}
		}
		if (!found) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/**
	 * Permet de compléter la chaine de caractère par le pad autant de fois que nécessaire pour 
	 * que la longueur totale soit égale à totalLength
	 * vatoLaharana = "12", pad = '0', totalLength = 5 => résultat = "00012" 
	 * @param vatoLaharana
	 * @param pad
	 * @param totalLength
	 * @return
	 */
	public static String getVatoLaharanaPadded(String vatoLaharana, char pad, int totalLength){
		String ret = vatoLaharana;
		while (ret.length() < totalLength){
			ret = String.valueOf(pad) + ret;
		}
		return ret;
	}
}
