/**
 * 
 */
package mg.fjkm.ankadifotsy.bo;

import java.io.Serializable;

/**
 * Karazana Tranga amin'ny fiainan'ny mpino
 * @author Rija RATEFIARIVONY
 *
 */
public class KarazaTranga implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final Long sfLONG_BATISA = 1L;
	public static final Long sfLONG_MPANDRAY = 2L;
	public static final Long sfLONG_FAHAFATESANA = 3L;
	
	public static KarazaTranga sfKarazaTrangaBatisa = new KarazaTranga(sfLONG_BATISA, "Batisa");
	public static KarazaTranga sfKarazaTrangaMpandray = new KarazaTranga(sfLONG_MPANDRAY, "Mpandray Fanasan'ny Tompo");
	public static KarazaTranga sfKarazaTrangaFahafatesana = new KarazaTranga(sfLONG_FAHAFATESANA, "Fahafatesana");
	
	private Long fId = null;
	
	private String fAnarana = null;
	
	protected KarazaTranga(){
		
	}
	
	public KarazaTranga(Long id, String anarana){
		fId = id;
		fAnarana = anarana;
	}

	public String getAnarana() {
		return fAnarana;
	}

	public void setAnarana(String anarana) {
		fAnarana = anarana;
	}

	public Long getId() {
		return fId;
	}

	public void setId(Long id) {
		fId = id;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (fId == null)
			return false;
		if(!(o instanceof KarazaTranga))
			return false;
		KarazaTranga other = (KarazaTranga)o;
		
		return fId.equals(other.fId);
	}

	@Override
	public int hashCode() {
		return fId != null ? fId.hashCode() : -1;
	}


}
