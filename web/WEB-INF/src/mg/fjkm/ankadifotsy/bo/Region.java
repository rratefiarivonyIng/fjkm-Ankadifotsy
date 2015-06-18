/**
 * 
 */
package mg.fjkm.ankadifotsy.bo;

import java.io.Serializable;

/**
 * Classe représentant une région 
 * @author rija
 * @version 1.0
 */
public class Region implements Serializable, ILabelable {

	private static final long serialVersionUID = -9010135578128602891L;

	/**
	 * Le code région
	 */
	private Long fId = null;
	
	/**
	 * L'intitulé
	 */
	private String fIntitule = null;
	
	/**
	 * La province à laquelle appartient la région
	 */
	private Province fProvince = null;
	
	protected Region(){		
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

	public Province getProvince() {
		return fProvince;
	}

	public void setProvince(Province province) {
		fProvince = province;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Region))
			return false;
		if (fId == null)
			return false;
		Region other = (Region)o;
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
