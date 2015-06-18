/**
 * 
 */
package mg.fjkm.ankadifotsy.bo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Synodam-paritany
 * @author Rija RATEFIARIVONY
 * 
 */
public class SynodamParitra implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long fId = null;
	
	private String fLabel = null;
	
	private String fDescription = null;
	
	private Set<Fitandremana> fFitandremanas = new HashSet<Fitandremana>();
	
	protected SynodamParitra(){
		
	}

	public String getDescription() {
		return fDescription;
	}

	public void setDescription(String description) {
		fDescription = description;
	}

	protected Set<Fitandremana> getFitandremanas() {
		return fFitandremanas;
	}

	protected void setFitandremanas(Set<Fitandremana> fitandremanas) {
		fFitandremanas = fitandremanas;
	}

	public void addFitandremana(Fitandremana fitandremana){
		if (fitandremana != null && ! fFitandremanas.contains(fitandremana)){
			fitandremana.setSynodamParitra(this);
			fFitandremanas.add(fitandremana);
		}
	}
	
	public void removeFitandremana(Fitandremana fitandremana){
		fFitandremanas.remove(fitandremana);
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
	
	
}
