/**
 * 
 */
package mg.fjkm.ankadifotsy.bo;

import java.io.Serializable;

/**
 * Classe entité fournissant les champs id, intitule et description
 * @author Rija
 *
 */
public abstract class Entity implements Serializable {
	private static final long serialVersionUID = 1L;

	protected Long fId = null;
	
	protected String fIntitule = null;
	
	protected String fDescription = null;
	
	protected Entity(){
		
	}

	public Entity(Long id, String intitule, String description){
		if (intitule == null || "".equals(intitule.trim()))
			throw new IllegalArgumentException();
		setId(id);
		setIntitule(intitule);
		setDescription(description);
	}
	
	/**
	 * @return the fDescription
	 */
	public String getDescription() {
		return fDescription;
	}

	/**
	 * @param description the fDescription to set
	 */
	public void setDescription(String description) {
		fDescription = description;
	}

	/**
	 * @return the fId
	 */
	public Long getId() {
		return fId;
	}

	/**
	 * @param id the fId to set
	 */
	protected void setId(Long id) {
		fId = id;
	}

	/**
	 * @return the fIntitule
	 */
	public String getIntitule() {
		return fIntitule;
	}

	/**
	 * @param intitule the fIntitule to set
	 */
	public void setIntitule(String intitule) {
		fIntitule = intitule;
	}
	
	@Override
	public int hashCode() {
		int ret = -1;
		if (fId != null)
			ret = fId.hashCode();
		return ret;
	}

	@Override
	public String toString() {
		return fIntitule;
	}
}
