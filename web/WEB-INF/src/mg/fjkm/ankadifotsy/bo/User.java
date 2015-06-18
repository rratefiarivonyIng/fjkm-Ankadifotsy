/**
 * 
 */
package mg.fjkm.ankadifotsy.bo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Classe représentant un utilisateur 
 * @author rija
 * @version 1.0
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long fId = null;
	
	private String fLogin = null;	//Doit être unique
	
	private String fPassword = null;
	
	private Set<Authority> fAuthorities = new HashSet<Authority>();
	
	/**
	 * Le centre fiscal de l'opérateur DGI
	 */
	private Faritra fFaritra = null;
	
	protected User(){		
	}
	
	public User(String login, String pwd){
		fLogin = login;
		fPassword = pwd;
	}

	public Long getId() {
		return fId;
	}

	public void setId(Long id) {
		fId = id;
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

	protected Set<Authority> getAuthorities() {
		return fAuthorities;
	}

	protected void setAuthorities(Set<Authority> authorities) {
		fAuthorities = authorities;
	}

	public void addAuthority(Authority authority){
		if (authority != null){
			authority.setUser(this);
			if (!fAuthorities.contains(authority))
				fAuthorities.add(authority);
		}
	}
	
	public void removeAuthority(Authority authority){
		fAuthorities.remove(authority);
		if (authority != null)
			authority.setUser(null);
	}
	
	public Faritra getFaritra() {
		return fFaritra;
	}

	public void setFaritra(Faritra faritra) {
		fFaritra = faritra;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof User))
			return false;
		User other = (User)obj;

		if (fId == null ){
			if (fLogin == null || "".equals(fLogin.trim()))
				return false;
			else
				return fLogin.equals(other.fLogin);
		}
		
		return fId.equals(other.fId);
	}

	@Override
	public int hashCode() {
		int ret = -1;
		if (fId != null)
			ret = fId.hashCode();
		else{
			if (fLogin != null)
				ret = fLogin.hashCode();
		}
		return ret;
	}
	
	public boolean isAdmin(){
		boolean ret = false;
		if (fAuthorities != null && fAuthorities.size()>0){
			for (Authority authority: fAuthorities){
				ret = "ROLE_ADMIN".equals(authority.getRole());
				if (ret)
					break;
			}
		}
		return ret;
	}
}
