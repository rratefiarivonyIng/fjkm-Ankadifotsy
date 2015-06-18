
package mg.fjkm.ankadifotsy.bo;

import java.io.Serializable;

/**
 * Classe représentant un archive d'un établissement d'un contribuable
 * @author rija
 * @version 1.0
 */
public class Fitandremana implements Serializable, ILabelable {

	private static final long serialVersionUID = 5407995599769418145L;

	public static final long sfIntFitandremanaAnkadifotsy = 1L;
	/**
	 * Identifiant technique de l'archive != Identifiant technique de l'établissement archivé
	 */
	private Long fId = null;
		
	private String fLabel = null;
	
	private String fDescription = null;
		
	private String fAdresse = null;
	
	private SynodamParitra fSynodamParitra = null;
		
	protected Fitandremana(){		
	}
	
	public Long getId() {
		return fId;
	}

	public void setId(Long id) {
		fId = id;
	}
		
	public String getDescription() {
		return fDescription;
	}

	public void setDescription(String description) {
		fDescription = description;
	}

	public String getLabel() {
		return fLabel;
	}

	public void setLabel(String label) {
		fLabel = label;
	}

	public String getAdresse() {
		return fAdresse;
	}

	public void setAdresse(String adresse) {
		fAdresse = adresse;
	}

	public SynodamParitra getSynodamParitra() {
		return fSynodamParitra;
	}

	public void setSynodamParitra(SynodamParitra synodamParitra) {
		fSynodamParitra = synodamParitra;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (fId == null)
			return false;
		if(!(o instanceof Fitandremana))
			return false;
		Fitandremana other = (Fitandremana)o;
		
		return fId.equals(other.fId);
	}

	@Override
	public int hashCode() {
		return fId != null ? fId.hashCode() : -1;
	}

}
