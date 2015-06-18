/**
 * 
 */
package mg.fjkm.ankadifotsy.bo;

import java.io.Serializable;
import java.util.Date;

/**
 * Zava-nitranga amin'ny fiainan'ny Mpino
 * @author Rija RATEFIARIVONY
 *
 */
public class Tranga extends SaveableEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Date fDaty = null;
	
	private String fLaharana = null;
	
	private Mpivavaka fMpivavaka = null;
	
	private KarazaTranga fKarazaTranga = null;
	
	private Fitandremana fFitandremana = null;
	
	public static Tranga createTranga(Mpivavaka mpivavaka, KarazaTranga karazaTranga, Date daty){
		if (karazaTranga == null || daty == null || mpivavaka == null)
			throw new IllegalArgumentException();
		
		Tranga ret = new Tranga();
		ret.setDaty(daty);
		ret.setKarazaTranga(karazaTranga);
		ret.setMpivavaka(mpivavaka);
		
		return ret;
	}
	
	protected Tranga(){
	}
	
	public Tranga(Mpivavaka mpivavaka){
		setMpivavaka(mpivavaka);
	}

	public Date getDaty() {
		return fDaty;
	}

	public void setDaty(Date daty) {
		fDaty = daty;
	}

	public KarazaTranga getKarazaTranga() {
		return fKarazaTranga;
	}

	public void setKarazaTranga(KarazaTranga karazaTranga) {
		fKarazaTranga = karazaTranga;
	}

	public String getLaharana() {
		return fLaharana;
	}

	public void setLaharana(String laharana) {
		fLaharana = laharana;
	}

	public Mpivavaka getMpivavaka() {
		return fMpivavaka;
	}

	public void setMpivavaka(Mpivavaka mpivavaka) {
		fMpivavaka = mpivavaka;
	}

	/**
	 * @return the fFitandremana
	 */
	public Fitandremana getFitandremana() {
		return fFitandremana;
	}

	/**
	 * @param fitandremana the fFitandremana to set
	 */
	public void setFitandremana(Fitandremana fitandremana) {
		fFitandremana = fitandremana;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (fId == null)
			return false;
		if(!(o instanceof Tranga))
			return false;
		Tranga other = (Tranga)o;
		
		return fId.equals(other.fId);
	}

	@Override
	public int hashCode() {
		return fId != null ? fId.hashCode() : -1;
	}
}
