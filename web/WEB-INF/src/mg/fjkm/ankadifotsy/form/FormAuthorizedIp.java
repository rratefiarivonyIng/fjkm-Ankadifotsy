/**
 * 
 */
package mg.fjkm.ankadifotsy.form;

import mg.fjkm.ankadifotsy.bo.AuthorizedIP;

/**
 * Formulaire pour la saisie de nouvelle IP
 * @author Rija
 *
 */
public class FormAuthorizedIp {
	public static final String sfFORM_ID = "formAuthorizedIp";

	private AuthorizedIP authorizedIP = null;

	public FormAuthorizedIp(){
		authorizedIP = new AuthorizedIP("", "");
	}
	
	public AuthorizedIP getAuthorizedIP() {
		return authorizedIP;
	}

	public void setAuthorizedIP(AuthorizedIP authorizedIP) {
		this.authorizedIP = authorizedIP;
	}
	
	public Long getId() {
		return authorizedIP.getId();
	}

	public String getDescription() {
		return authorizedIP.getDescription();
	}

	public String getIp() {
		return authorizedIP.getIp();
	}

	public boolean isAuthorized() {
		return authorizedIP.isAuthorized();
	}

	public void setAuthorized(boolean authorized) {
		authorizedIP.setAuthorized(authorized);
	}

	public void setDescription(String description) {
		authorizedIP.setDescription(description);
	}

	public void setIp(String ip) {
		authorizedIP.setIp(ip);
	}
}
