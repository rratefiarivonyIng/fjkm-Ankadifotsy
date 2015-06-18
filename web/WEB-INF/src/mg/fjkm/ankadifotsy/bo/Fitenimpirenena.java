/**
 * 
 */
package mg.fjkm.ankadifotsy.bo;

import java.io.Serializable;

/**
 * Ireo Fitenim-pirenena hain'ny mpivavaka tenenina
 * @author Rija
 *
 */
public class Fitenimpirenena implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final Long sfLONG_MAGALASY = 1L;
	public static final Long sfLONG_FRANTSAY = 2L;
	public static final Long sfLONG_ANGLISY = 3L;
	public static final Long sfLONG_ALEMANA = 4L;

	public static final Fitenimpirenena sfMalagasy = new Fitenimpirenena(sfLONG_MAGALASY, "MG", "Malagasy");
	public static final Fitenimpirenena sfFrantsay = new Fitenimpirenena(sfLONG_FRANTSAY, "FR", "Frantsay");
	public static final Fitenimpirenena sfAnglisy = new Fitenimpirenena(sfLONG_ANGLISY, "EN", "Anglisy");
	public static final Fitenimpirenena sfAlemana = new Fitenimpirenena(sfLONG_ALEMANA, "DE", "Alemana");
	
	private Long fId = null;
	
	private String fCode = null;
	
	private String fIntitule = null;
	
	protected Fitenimpirenena(){
	}
	
	public Fitenimpirenena(Long id, String code, String intitule){
		fId = id;
		fCode = code;
		fIntitule = intitule;
	}

	/**
	 * @return the fCode
	 */
	public String getCode() {
		return fCode;
	}

	/**
	 * @param code the fCode to set
	 */
	public void setCode(String code) {
		fCode = code;
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
	public void setId(Long id) {
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

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (fId == null)
			return false;
		
		if (!(obj instanceof Fitenimpirenena))
			return false;
		
		Fitenimpirenena other = (Fitenimpirenena)obj;
		
		return fId.equals(other.fId);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return fId != null ? fId.hashCode() : -1;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer ret = new StringBuffer("");
		if (fCode != null)
			ret.append(fCode);
		if (fIntitule != null)
			ret.append(" - ").append(fIntitule);
		
		return ret.toString();
	}
		
}
