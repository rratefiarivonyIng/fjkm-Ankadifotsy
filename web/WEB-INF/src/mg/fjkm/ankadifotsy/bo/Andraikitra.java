/**
 * 
 */
package mg.fjkm.ankadifotsy.bo;


/**
 * Andraikitra ao amin'ny Sampana 
 * @author Rija
 *
 */
public class Andraikitra extends Entity{

	private static final long serialVersionUID = 1L;

	public static final long sfLongFiloha = 1;
	public static final long sfLongFilohaMpanampy = 2;
	public static final long sfLongMpanoloTsaina = 3;
	public static final long sfLongMpitantSoratra = 4;
	public static final long sfLongMpitamBola = 5;
	public static final long sfLongMpitanTsoratraVola = 6;
	public static final long sfLongMpikambanaTsotra = 7;
	public static final long sfLongTeknisiana = 8;
	public static final long sfLongTonia = 9;
	public static final long sfLongMpanoratra = 10;
	
	public static final Andraikitra sfAndraikitraFiloha = new Andraikitra(sfLongFiloha, "Filoha", "Filohan'ny sampana");
	public static final Andraikitra sfAndraikitraFilohaMpanampy = new Andraikitra(sfLongFilohaMpanampy, "Filoha mpanampy", "Filoha mpanampy ny sampana");
	public static final Andraikitra sfAndraikitraMpanoloTsaina = new Andraikitra(sfLongMpanoloTsaina, "Mpanolo-tsaina", "Mpanolon-tsaina ao amin'ny sampana");
	public static final Andraikitra sfAndraikitraMpitantSoratra = new Andraikitra(sfLongMpitantSoratra, "Mpitan-tsoratra", "mpitan-tsoratry ny sampana");
	public static final Andraikitra sfAndraikitraMpitamBola = new Andraikitra(sfLongMpitamBola, "Mpitam-bola", "Mpitam-bolan''ny sampana");
	public static final Andraikitra sfAndraikitraMpitantSoratraVola = new Andraikitra(sfLongMpitanTsoratraVola, "Mpitan-tsoratry ny vola", "mpitan-tsoratry ny vola ny sampana");
	public static final Andraikitra sfAndraikitraMpikambanaTsotra = new Andraikitra(sfLongMpikambanaTsotra, "Mpikambana", "mpikambana ao amin'ny sampana");
	public static final Andraikitra sfAndraikitraTeknisiana = new Andraikitra(sfLongTeknisiana, "Teknisiana", "misahana ny lafiny ara-teknika ao amin''ny sampana");
	public static final Andraikitra sfAndraikitraTonia = new Andraikitra(sfLongTonia, "Tonia ny fanoratana", "Fanoratana lahatsoratra amin''ny gazety fafana");
	public static final Andraikitra sfAndraikitraMpanoratra = new Andraikitra(sfLongMpanoratra, "Mpanoratra", "Mpanoratra lahatsoratra");
	
	protected Andraikitra(){
	}
	
	public Andraikitra(Long id, String intitule, String description){
		if (intitule == null || "".equals(intitule.trim()))
			throw new IllegalArgumentException();
		fId = id;
		fIntitule = intitule;
		fDescription = description;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (fId == null)
			return false;
		if (!(o instanceof Andraikitra))
			return false;
		Andraikitra other = (Andraikitra)o;
		return fId.equals(other.fId);
	}

	/* (non-Javadoc)
	 * @see mg.fjkm.ankadifotsy.bo.Entity#hashCode()
	 */
	@Override
	public int hashCode() {
		return fId != null ? fId.hashCode() : -1;
	}
		
}
