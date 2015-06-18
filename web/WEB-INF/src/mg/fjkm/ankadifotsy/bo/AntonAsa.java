/**
 * 
 */
package mg.fjkm.ankadifotsy.bo;


/**
 * Classe des activités
 * @author rija
 * @version 1.0
 */
public class AntonAsa extends Entity{

	private static final long serialVersionUID = 1L;

	public static AntonAsa sfActiviteInitialisation = new AntonAsa(0L, "INITIALISATION ACTIVITE");
	
	protected AntonAsa(){
		super();
	}
	
	protected AntonAsa(Long id, String intitule){
		super(id, intitule, null);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (fId == null)
			return false;
		if (!(o instanceof AntonAsa))
			return false;
		AntonAsa other = (AntonAsa)o;
		return fId.equals(other.fId);
	}

}
