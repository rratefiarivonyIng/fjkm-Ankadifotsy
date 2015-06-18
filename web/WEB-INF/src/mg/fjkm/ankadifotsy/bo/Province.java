/**
 * 
 */
package mg.fjkm.ankadifotsy.bo;

import java.io.Serializable;

/**
 * Classe repr�sentant une province
 * @author rija
 * @version 1.0
 */
public class Province implements Serializable, ILabelable {

	private static final long serialVersionUID = 368657028063611642L;

	/**
	 * Le code du d�partement
	 */
	private Long fId = null;
	
	/**
	 * L'intitul� du d�partement
	 */
	private String fIntitule = null;
	
	protected Province(){		
	}

	public Long getId() {
		return fId;
	}

	public void setId(Long id) {
		fId = id;
	}

	public String getLabel() {
		return fIntitule;
	}

	public void setIntitule(String intitule) {
		fIntitule = intitule;
	}
	
		
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Province))
			return false;
		if (fId == null)
			return false;
		Province other = (Province)o;
		return fId.equals(other.fId);
	}

	@Override
	public int hashCode() {
		return fId == null ? -1 : fId.hashCode();
	}
		
}
