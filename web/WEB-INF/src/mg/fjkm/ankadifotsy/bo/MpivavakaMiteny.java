/**
 * 
 */
package mg.fjkm.ankadifotsy.bo;

import java.io.Serializable;

/**
 * Fitenimpirenena hain'ny mpivavaka ampiasaina
 * @author Rija
 *
 */
public class MpivavakaMiteny implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long fId = null;
	private Mpivavaka fMpivavaka = null;
	private Fitenimpirenena fFitenimpirenena = null;
	private boolean fSoratana = true;
	private boolean fTenenina = true;
	
	protected MpivavakaMiteny(){
		
	}
	
	public MpivavakaMiteny(Mpivavaka mpivavaka, Fitenimpirenena fitenimpirenena){
		fMpivavaka = mpivavaka;
		fFitenimpirenena = fitenimpirenena;
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
	 * @return the fMpivavaka
	 */
	public Mpivavaka getMpivavaka() {
		return fMpivavaka;
	}

	/**
	 * @param mpivavaka the fMpivavaka to set
	 */
	protected void setMpivavaka(Mpivavaka mpivavaka) {
		fMpivavaka = mpivavaka;
	}

	/**
	 * @return the fSoratana
	 */
	public boolean isSoratana() {
		return fSoratana;
	}

	/**
	 * @param soratana the fSoratana to set
	 */
	public void setSoratana(boolean soratana) {
		fSoratana = soratana;
	}

	/**
	 * @return the fTenenina
	 */
	public boolean isTenenina() {
		return fTenenina;
	}

	/**
	 * @param tenenina the fTenenina to set
	 */
	public void setTenenina(boolean tenenina) {
		fTenenina = tenenina;
	}

	/**
	 * @return the fFitenimpirenena
	 */
	public Fitenimpirenena getFitenimpirenena() {
		return fFitenimpirenena;
	}

	/**
	 * @param fitenimpirenena the fFitenimpirenena to set
	 */
	protected void setFitenimpirenena(Fitenimpirenena fitenimpirenena) {
		fFitenimpirenena = fitenimpirenena;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (fMpivavaka == null || fFitenimpirenena == null)
			return false;
		
		if (!(obj instanceof MpivavakaMiteny))
			return false;
		
		MpivavakaMiteny other = (MpivavakaMiteny)obj;
		
		return fMpivavaka.equals(other.fMpivavaka) && fFitenimpirenena.equals(other.fFitenimpirenena);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int ret = -1;
		if (fMpivavaka != null)
			ret = fMpivavaka.hashCode();
		
		if (fFitenimpirenena != null)
			ret = ret * 29 + fFitenimpirenena.hashCode();
		
		return ret;
	}
		
}
