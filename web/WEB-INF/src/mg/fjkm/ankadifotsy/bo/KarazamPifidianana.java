/**
 * 
 */
package mg.fjkm.ankadifotsy.bo;

import java.io.Serializable;

/**
 * Karazana Fifidianana azo atao
 * @author Rija RATEFIARIVONY
 */
public class KarazamPifidianana implements ILabelable, Serializable {

	private static final long serialVersionUID = 1L;

	public static final Long sfLONG_DIAKONA = 1L;
	public static final Long sfLONG_FILOHA_SAMPANA = 2L;
	
	public static KarazamPifidianana sfKarazamPifidiananaDiakona = new KarazamPifidianana(sfLONG_DIAKONA, "Fifidianana Diakona");
	public static KarazamPifidianana sfKarazamPifidiananaFilohaSampana = new KarazamPifidianana(sfLONG_FILOHA_SAMPANA, "Fifidianana Filoha Sampana");
	
	private Long fId = null;
	
	private String fLabel = null;
	
	protected KarazamPifidianana(){
		
	}
	
	public KarazamPifidianana(Long id, String anarana){
		fId = id;
		fLabel = anarana;
	}

	public String getLabel() {
		return fLabel;
	}

	public void setLabel(String anarana) {
		fLabel = anarana;
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
		if(!(o instanceof KarazamPifidianana))
			return false;
		KarazamPifidianana other = (KarazamPifidianana)o;
		
		return fId.equals(other.fId);
	}

	@Override
	public int hashCode() {
		return fId != null ? fId.hashCode() : -1;
	}
}
