/**
 * 
 */
package mg.fjkm.ankadifotsy.bo;

import java.io.Serializable;
import java.util.Date;

import mg.fjkm.ankadifotsy.util.Utils;

/**
 * Classe représentant une intervalle de temps en année pour un mandat donné
 * @author Rija
 */
public class TaomPanompoana implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long fId = null;
	private Date fDatyManomboka = null;
	private Date fDatyMamarana = null;
	
	protected TaomPanompoana(){
		
	}
	
	public TaomPanompoana(Date manomboka, Date mamarana){
		if (manomboka == null || mamarana == null)
			throw new IllegalArgumentException();
		
		if (manomboka.getTime() > mamarana.getTime())
			throw new IllegalArgumentException(Utils.sfDateFormatJJMMYYYY.format(mamarana)+" < "+Utils.sfDateFormatJJMMYYYY.format(manomboka));
		
		setDatyMamarana(mamarana);
		setDatyManomboka(manomboka);
	}

	/**
	 * @return the fDatyMamarana
	 */
	public Date getDatyMamarana() {
		return fDatyMamarana;
	}

	/**
	 * @param datyMamarana the fDatyMamarana to set
	 */
	public void setDatyMamarana(Date datyMamarana) {
		fDatyMamarana = datyMamarana;
	}

	/**
	 * @return the fDatyManomboka
	 */
	public Date getDatyManomboka() {
		return fDatyManomboka;
	}

	/**
	 * @param datyManomboka the fDatyManomboka to set
	 */
	public void setDatyManomboka(Date datyManomboka) {
		fDatyManomboka = datyManomboka;
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

	public boolean isDateInTaomPanompoana(Date daty){
		boolean ret = false;
		if (daty != null)
			ret = fDatyManomboka.getTime() <= daty.getTime() && daty.getTime() <= fDatyMamarana.getTime();
		
		return ret;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((fDatyMamarana == null) ? 0 : fDatyMamarana.hashCode());
		result = PRIME * result + ((fDatyManomboka == null) ? 0 : fDatyManomboka.hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuffer ret = new StringBuffer("");
		if (getDatyManomboka() != null)
			ret.append(Utils.sfDateFormatYYYY.format(getDatyManomboka()));
		
		ret.append(" - ");
		
		if (getDatyMamarana() != null)
			ret.append(Utils.sfDateFormatYYYY.format(getDatyMamarana()));

		return ret.toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final TaomPanompoana other = (TaomPanompoana) obj;
		if (fDatyMamarana == null) {
			if (other.fDatyMamarana != null)
				return false;
		} else if (!fDatyMamarana.equals(other.fDatyMamarana))
			return false;
		if (fDatyManomboka == null) {
			if (other.fDatyManomboka != null)
				return false;
		} else if (!fDatyManomboka.equals(other.fDatyManomboka))
			return false;
		return true;
	}
	
	
}
