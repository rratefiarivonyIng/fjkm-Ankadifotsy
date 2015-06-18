
package mg.fjkm.ankadifotsy.bo;

import java.io.Serializable;
import java.util.Date;

/**
 * Classe repr�sentant un fifidianana
 * @author rija
 * @version 1.0
 */
public class Fifidianana extends SaveableEntity implements Serializable, ILabelable {

	private static final long serialVersionUID = 5407995599769418145L;
		
	/**
	 * ILabelable
	 */
	private String fLabel = null;
	
	/**
	 * ouverture du d�p�t des candidatures 
	 */
	private Date fDatyManombokaFirotsahana = null;
	
	/**
	 * fermeture du d�p�t des candidatures
	 */
	private Date fDatyMamaranaFirotsahana = null;
	
	/**
	 * Date du scrutin
	 */
	private Date fDatyFifidianana = null;
	
	/**
	 * Cl�ture du fifidianana => officialisation des r�sultats
	 */
	private Date fDatyManakatona = null;
	
	/**
	 * D�compte des voix
	 */
	private Date fDatyFanisambato = null;
	
	private KarazamPifidianana fKarazamPifidianana = null;
	
	private TaomPanompoana fTaomPanompoana = null;
	
	private Fitandremana fFitandremana = null;
	
	/**
	 * Si true alors l'�lection consiste � �lire une seule personne (un pr�sident par exemple)
	 */
	private boolean fFifidiananaOloTokana = false;	

	/**
	 * Si fFifidiananaOloTokana alors this n'est pas utilis�e
	 * Sinon, la valeur de this servira � v�rifier que lors du comptage des voix , le nombre
	 * de choix de l'�lecteur n'est pas trop nombreux (Ex : si on doit �lire 5 candidats alors 
	 * le nb de choix de chaque �lecteur ne doit pas d�passer 5 sous peine que son voix est comptabilis� comme nul) 
	 */
	private Integer fIsaOlonaFidiana = null;

	/**
	 * Si non null alors le num�ro du bulletin de vote doit avoir exactement la longueur rens�ign�e dans ce champs
	 * Ex si fIsan_Nomerao = 3; ALORS vatoLaharana est de la forme 999 (Donc 1 doit �tre saisi sous forme 001)
	 * Ex si fIsan_Nomerao = 4; ALORS vatoLaharana est de la forme 9999 (Donc 15 doit �tre saisi sous forme 0015)
	 */
	private Integer fIsan_Nomerao = null;
	
	/**
	 * Si fFifidiananaOloTokana == true alors this n'est pas utilis�, sinon this est utilis� :
	 * Si true alors le laharana g�n�r� sera continu et ne recommence pas � 1 pour les candidats masculins
	 */
	private boolean fMitohyLaharana = false;

	/**
	 * drapeau indiquant si la d�compte de voix peut commencer ou non
	 */
	private boolean fManomboka = false;
	
	protected Fifidianana(){		
	}
	
	public Fifidianana(Fitandremana fitandremana, Date manombokaFirotsahana, Date mamaranaFirotsahana, Date fifidianana, Date fanisambato){
		assert manombokaFirotsahana != null && mamaranaFirotsahana != null && fitandremana != null;
		setFitandremana(fitandremana);
		setDatys(manombokaFirotsahana, mamaranaFirotsahana);
		setDatyFifidianana_(fifidianana);
		setDatyFanisambato_(fanisambato);
	}
		
	//------------- ILabelable ------------------
	public String getLabel() {
		return fLabel;
	}

	public void setLabel(String label) {
		fLabel = label;
	}
	
	//-------------- Les champs de this -----------
	
	public Date getDatyFanisambato() {
		return fDatyFanisambato;
	}

	protected void setDatyFanisambato(Date datyFanisambato) {
		fDatyFanisambato = datyFanisambato;
	}

	public Date getDatyFifidianana() {
		return fDatyFifidianana;
	}

	protected void setDatyFifidianana(Date datyFifidianana) {
		fDatyFifidianana = datyFifidianana;
	}

	public Date getDatyMamaranaFirotsahana() {
		return fDatyMamaranaFirotsahana;
	}

	protected void setDatyMamaranaFirotsahana(Date datyMamaranaFirotsahana) {
		fDatyMamaranaFirotsahana = datyMamaranaFirotsahana;
	}

	public void setDatyMamaranaFirotsahana_(Date datyMamaranaFirotsahana) {
		fDatyMamaranaFirotsahana = datyMamaranaFirotsahana;
	}

	public Date getDatyManakatona() {
		return fDatyManakatona;
	}

	protected void setDatyManakatona(Date datyManakatona) {
		fDatyManakatona = datyManakatona;
	}

	public Date getDatyManombokaFirotsahana() {
		return fDatyManombokaFirotsahana;
	}

	protected void setDatyManombokaFirotsahana(Date datyManombokaFirotsahana) {
		fDatyManombokaFirotsahana = datyManombokaFirotsahana;
	}

	public void setDatyManombokaFirotsahana_(Date datyManombokaFirotsahana) {
		fDatyManombokaFirotsahana = datyManombokaFirotsahana;
	}

	public void setDatys(Date fanokafanaFirotsahana, Date famarananaFirotsahana){
		assert fanokafanaFirotsahana != null && famarananaFirotsahana != null;
		if (fanokafanaFirotsahana.getTime() > famarananaFirotsahana.getTime())
			throw new RuntimeException("daty fanokafana tokony alohan'ny daty famaranana");
		setDatyManombokaFirotsahana(fanokafanaFirotsahana);
		setDatyMamaranaFirotsahana(famarananaFirotsahana);
	}
	
	public void setDatyFifidianana_(Date daty){
		if (daty != null){
			if (daty.getTime() < fDatyMamaranaFirotsahana.getTime()){
				//System.out.println(daty.getTime() + " < "+ fDatyMamaranaFirotsahana.getTime());
				throw new RuntimeException("Daty fifidianana tokony aorian'ny fikatonan'ny firotsahana");
			}
			setDatyFifidianana(daty);
		}
		else
			setDatyFifidianana(null);
	}
	
	public void setDatyFanisambato_(Date daty){
		if (daty != null){
			if (daty.getTime() < fDatyFifidianana.getTime())
				throw new RuntimeException("Daty fanisambato tokony aorian'ny daty fifidianana");
			setDatyFanisambato(daty);
		}
		else
			setDatyFanisambato(null);
	}
	
	public void setDatyManakatona_(Date daty){
		if (daty != null){
			if (daty.getTime() < fDatyManakatona.getTime())
				throw new RuntimeException("daty manakatona tokony aorian'ny daty fanisambato");
		}
		setDatyManakatona(daty);
	}
	
	public KarazamPifidianana getKarazamPifidianana() {
		return fKarazamPifidianana;
	}

	public void setKarazamPifidianana(KarazamPifidianana karazamPifidianana) {
		fKarazamPifidianana = karazamPifidianana;
	}

	public TaomPanompoana getTaomPanompoana() {
		return fTaomPanompoana;
	}

	public void setTaomPanompoana(TaomPanompoana taomPanompoana) {
		fTaomPanompoana = taomPanompoana;
	}

	public Fitandremana getFitandremana() {
		return fFitandremana;
	}

	public void setFitandremana(Fitandremana fitandremana) {
		fFitandremana = fitandremana;
	}

	/**
	 * 
	 * @param daty
	 * @return true raha efa mihoatra ny daty ny fDatyManakatona
	 */
	public boolean isMikatona(Date daty){
		boolean ret = false;
		if (fDatyManakatona != null){
			ret = daty.getTime() > fDatyManakatona.getTime();
		}
		else if (fDatyFanisambato != null)
			ret =  daty.getTime() > fDatyFanisambato.getTime();
		
		return ret;
	}
	
	public boolean isFifidiananaOloTokana() {
		return fFifidiananaOloTokana;
	}

	public void setFifidiananaOloTokana(boolean fifidiananaOloTokana) {
		fFifidiananaOloTokana = fifidiananaOloTokana;
	}

	public Integer getIsaOlonaFidiana() {
		return fIsaOlonaFidiana;
	}

	public void setIsaOlonaFidiana(Integer isaOlonaFidiana) {
		fIsaOlonaFidiana = isaOlonaFidiana;
	}

	public Integer getIsan_Nomerao() {
		return fIsan_Nomerao;
	}

	public void setIsan_Nomerao(Integer isan_Nomerao) {
		fIsan_Nomerao = isan_Nomerao;
	}

	public boolean isMitohyLaharana() {
		return fMitohyLaharana;
	}

	public void setMitohyLaharana(boolean mitohy) {
		fMitohyLaharana = mitohy;
	}

	public boolean isManomboka() {
		return fManomboka;
	}

	public void setManomboka(boolean manomboka) {
		fManomboka = manomboka;
	}

	
	//-----------------------------------------------------

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (fId == null)
			return false;
		if(!(o instanceof Fifidianana))
			return false;
		Fifidianana other = (Fifidianana)o;
		
		return fId.equals(other.fId);
	}

	@Override
	public int hashCode() {
		return fId != null ? fId.hashCode() : -1;
	}

}
