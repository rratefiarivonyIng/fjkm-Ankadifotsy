/**
 * 
 */
package mg.fjkm.ankadifotsy.bo;

import java.io.Serializable;

/**
 * Classe repr�sentant une r�gion 
 * @author rija
 * @version 1.0
 */
public class District implements Serializable, ILabelable {

	private static final long serialVersionUID = -9010135578128602891L;

	/**
	 * Le code r�gion
	 */
	private Long fId = null;
	
	/**
	 * L'intitul�
	 */
	private String fIntitule = null;
	
	/**
	 * La r�gion � laquelle appartient le district
	 */
	private Region fRegion = null;
	
	protected District(){		
	}

	public Long getId() {
		return fId;
	}

	public void setId(Long codeRegion) {
		fId = codeRegion;
	}

	public String getLabel() {
		return fIntitule;
	}

	public void setIntitule(String intitule) {
		fIntitule = intitule;
	}

	public Region getRegion() {
		return fRegion;
	}

	public void setRegion(Region region) {
		fRegion = region;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof District))
			return false;
		if (fId == null)
			return false;
		District other = (District)o;
		return fId.equals(other.fId);
	}

	@Override
	public int hashCode() {
		int ret = -1;
		if (fId != null)
			ret = fId.hashCode();
		return ret;
	}
		
}
