/**
 * 
 */
package mg.fjkm.ankadifotsy.bo;


/**
 * Classe pour la gestion des IPs authorisées ou non à accéder à certaines fonctionnalités : InitManisaVatoController et ManisaVatoController
 * @author rija
 * @version 1.0
 */
public class AuthorizedIP extends Entity{

	private static final long serialVersionUID = 1L;

	private String fIp;
	private boolean fAuthorized = true;
	
	protected AuthorizedIP(){
		super();
	}
	
	protected AuthorizedIP(Long id, String intitule){
		super(id, intitule, null);
	}

	public AuthorizedIP(String ip, String description){
		super();
		this.fIp = ip;
		setDescription(description);
	}
	
	public void setId(Long id){
		super.setId(id);
	}
	
	public String getIp() {
		return fIp;
	}

	public void setIp(String ip) {
		fIp = ip;
	}

	public boolean isAuthorized() {
		return fAuthorized;
	}

	public void setAuthorized(boolean authorized) {
		fAuthorized = authorized;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (fId == null)
			return false;
		if (!(o instanceof AuthorizedIP))
			return false;
		AuthorizedIP other = (AuthorizedIP)o;
		return fId.equals(other.fId);
	}

}
