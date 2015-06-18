/**
 * 
 */
package mg.fjkm.ankadifotsy.bo;

import java.io.Serializable;

/**
 * Le Centre fiscal où est recensé un contribuable
 * @author rija
 * @version 1.0
 */
public class Faritra implements Serializable, ILabelable {

	private static final long serialVersionUID = 2240578651530594253L;

	private Long fId = null;
	
	private String fLabel = null;
	
	private Firaisana fFiraisana = null;
	
	protected Faritra(){		
	}
	
	public Faritra(Long id, String intitule){
		fId = id;
		fLabel = intitule;
	}

	public Long getId() {
		return fId;
	}

	public void setId(Long id) {
		fId = id;
	}

	public String getLabel() {
		return fLabel;
	}

	public void setLabel(String label) {
		fLabel = label;
	}

	/**
	 * @return the fFiraisana
	 */
	public Firaisana getFiraisana() {
		return fFiraisana;
	}

	/**
	 * @param firaisana the fFiraisana to set
	 */
	public void setFiraisana(Firaisana firaisana) {
		fFiraisana = firaisana;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (fId == null)
			return false;
		if(!(o instanceof Faritra))
			return false;
		Faritra other = (Faritra)o;
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
		if (fLabel != null)
			ret.append(" - ").append(fLabel);
		
		return ret.toString();
	}
}
