/**
 * 
 */
package mg.fjkm.ankadifotsy.bo;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Classe représentant une commune 
 * @author rija
 * @version 1.0
 */
public class Firaisana implements Serializable , ILabelable{

	private static final long serialVersionUID = -9010135578128602891L;

	/**
	 * Le code de la commune
	 */
	private Long fId = null;
	
	/**
	 * L'intitulé
	 */
	private String fLabel = null;
	
	
	private Set<Faritra> fFaritras = new HashSet<Faritra>();
	
	protected Firaisana(){		
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

	public void addFaritra(Faritra faritra){
		if (faritra != null && ! fFaritras.contains(faritra))
			fFaritras.add(faritra);
	}
	
	public void removeFaritra(Faritra centreFiscal){
		fFaritras.remove(centreFiscal);
	}
	
	public Set<Faritra> getAllFaritra(){
		return Collections.unmodifiableSet(fFaritras);
	}
	
	//hibernate
	protected Set<Faritra> getFaritras() {
		return fFaritras;
	}

	//hibernate
	protected void setFaritras(Set<Faritra> centreFiscaux) {
		fFaritras = centreFiscaux;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Firaisana))
			return false;
		if (fId == null)
			return false;
		Firaisana other = (Firaisana)o;
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
