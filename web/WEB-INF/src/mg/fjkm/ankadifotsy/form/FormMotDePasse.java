/**
 * 
 */
package mg.fjkm.ankadifotsy.form;

import mg.fjkm.ankadifotsy.bo.User;

/**
 * Formulaire de saisie de mot de passe
 * @author rija
 * @version 1.0
 */
public class FormMotDePasse {

	/**
	 * Le contribuable 
	 */
	private User fUser = null; 
	
	private String fLogin = null;
	
	private String fPassword = null;
	
	private String fConfirmation = null;
	
	private String fOldPassword = null;
	
	
	public FormMotDePasse(User user){
		if (user != null){
			fUser = user;
			fLogin = fUser.getLogin();
		}
	}

	public User getUser() {
		return fUser;
	}

	public void setUser(User user) {
		fUser = user;
	}

	public String getConfirmation() {
		return fConfirmation;
	}

	public void setConfirmation(String confirmation) {
		fConfirmation = confirmation;
	}

	public String getLogin() {
		return fLogin;
	}

	public void setLogin(String login) {
		fLogin = login;
	}

	public String getPassword() {
		return fPassword;
	}

	public void setPassword(String password) {
		fPassword = password;
	}

	public String getOldPassword() {
		return fOldPassword;
	}

	public void setOldPassword(String oldPassword) {
		fOldPassword = oldPassword;
	}

}
