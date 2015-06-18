/**
 * 
 */
package mg.fjkm.ankadifotsy.bo;

import java.io.Serializable;

/**
 * Une Authority représente un ROLE_ associé à des utilisateurs.
 * Les Authority d'un utilisateur seront utilisés pour vérifier ses droits d'accès à une ressource.
 * @author rija
 * @version 1.0
 */
public class Authority implements Serializable {

	private static final long serialVersionUID = 6285433597730876845L;
	
	public static final String sfROLE_MODIFY = "ROLE_MODIFY";
	public static final String sfROLE_CONTRIBUABLE = "ROLE_CONTRIBUABLE";
		
	private Long fId = null;
	
	private User fUser = null;
	
	private String fRole = null;

	protected Authority(){		
	}
	
	public Authority(User user, String role){
		if (user == null || role == null || "".equals(role.trim()))
			throw new RuntimeException("role et User ne doivent pas être NULL");
		fUser = user;
		fRole = role;
	}

	public Long getId() {
		return fId;
	}

	protected void setId(Long id) {
		fId = id;
	}

	public String getRole() {
		return fRole;
	}

	public void setRole(String role) {
		fRole = role;
	}

	public User getUser() {
		return fUser;
	}

	public void setUser(User user) {
		fUser = user;
	}
	
	protected String getLogin(){
		String login = null;
		if (fUser != null)
			login = fUser.getLogin();
		
		return login; 
	}
	
	protected void setLogin(String login){
		//Rien : c'est uniquement pour Hibernate 
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (!(obj instanceof Authority))
			return false;
		
		Authority other = (Authority)obj;
		
		if (fId != null)
			return fId.equals(other.fId);
		else{
			if (fUser != null && fRole != null)
				return fUser.equals(other.fUser) && fRole.equals(other.fRole);
			else
				return false;
		}		
	}

	@Override
	public int hashCode() {
		int ret = -1;
		if (fId != null)
			ret = fId.hashCode();
		else{
			if (fUser != null)
				ret = fUser.hashCode();
			
			if (fRole != null)
				ret = ret * 29 + fRole.hashCode();
		}
		return ret;
	}
	
}
