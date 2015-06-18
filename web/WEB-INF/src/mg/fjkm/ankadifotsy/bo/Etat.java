/**
 * 
 */
package mg.fjkm.ankadifotsy.bo;

import java.io.Serializable;

/**
 * L'état d'une instance d'un contribuable
 * @author rija
 * @version 1.0
 */
public class Etat implements Serializable {

	private static final long serialVersionUID = 760125304647069233L;
	
	public static final Long sfID_EN_INSTANCE = 0L;
	public static final Long sfID_NON_VERIFIE = 1L;
	public static final Long sfID_VALIDEE = 2L;
	public static final Long sfID_REJETEE = 3L;
	public static final Long sfID_APPROUVABLE = 4L;

	public static final Etat sfEtatEnInstance = new Etat(sfID_EN_INSTANCE, "En instance");
	public static final Etat sfEtatNonVerifiee = new Etat(sfID_NON_VERIFIE, "Non vérifiée");
	public static final Etat sfEtatValidee = new Etat(sfID_VALIDEE, "Validée");
	public static final Etat sfEtatRejetee = new Etat(sfID_REJETEE, "Rejetée");
	public static final Etat sfEtatApprouvable = new Etat(sfID_APPROUVABLE, "Approuvable");
	
	private Long fId = null;
	private String fIntitule = null;
	
	protected Etat(){		
	}
	
	public Etat(Long id, String intitule){
		fId = id;
		fIntitule = intitule;
	}

	public Long getId() {
		return fId;
	}

	public void setId(Long id) {
		fId = id;
	}

	public String getIntitule() {
		return fIntitule;
	}

	public void setIntitule(String intitule) {
		fIntitule = intitule;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (fId == null)
			return false;
		if(!(o instanceof Etat))
			return false;
		Etat other = (Etat)o;
		return fId.equals(other.fId);
	}

	@Override
	public int hashCode() {
		return fId != null ? fId.hashCode() : -1;
	}

	@Override
	public String toString() {
		StringBuffer ret = new StringBuffer();
		if (fId != null)
			ret.append(fId);
		if (fIntitule != null)
			ret.append(" - ").append(fIntitule);
		
		return ret.toString();
	}

	
}
