/**
 * 
 */
package mg.fjkm.ankadifotsy.bo;

import java.io.Serializable;
import java.util.Date;

/**
 * Tranga Fanambadiana
 * @author Rija RATEFIARIVONY
 * @NOTE : l'implémantation de cette classe hérite de Tranga car le code dans Tranga est toujours valable pour Fanambadiana
 * MAIS du point de vue hibernate et table, Fanambadiana n'hérite plus de Tranga
 */
public class Fanambadiana extends SaveableEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	private Date fDaty = null;
	
	private String fLaharana = null;
	
	private Mpivavaka fMpivavaka = null;
		
	private Fitandremana fFitandremana = null;

	private String fAnaranaVady = null;	//utilisé uniquement si le conjoint n'est pas encore recensé en tant que Mpivavaka en base

	private Mpivavaka fVady = null;		//préféré à fAnaranaVady si le conjoint est déjà référencé en base
	
	/**
	 * Daty nisoratam-panambadiana ara-panjakana
	 */
	private Date fDatySoratra = null;
			
	/**
	 * Isan'ny zanaka lahy	 
	 */
	private Integer fIsanJanakaLahy = null;
	
	/**
	 * Isan'ny zanaka vavy
	 */
	private Integer fIsanJanakaVavy = null;
	
	private Integer fIsanJanakaVitaBatisa = null;
	
	private Integer fIsanJanakaMpandray = null;

	//--------------- création de fanambadiana ----------------------
	public static Fanambadiana createFanambadiana(Mpivavaka mpivavaka, String anaranaVady){
		if (anaranaVady == null || "".equals(anaranaVady.trim()))
			throw new IllegalArgumentException();
				
		Fanambadiana ret = new Fanambadiana(mpivavaka);
		ret.setAnaranaVady(anaranaVady);
		
		return ret;
	}

	public static Fanambadiana createFanambadiana(Mpivavaka mpivavaka, Mpivavaka vady){
		if (vady == null)
			throw new IllegalArgumentException();
				
		Fanambadiana ret = new Fanambadiana(mpivavaka);
		ret.setVady(vady);
		
		return ret;
	}
	
	public static Fanambadiana createFanambadiana(Mpivavaka mpivavaka, Mpivavaka vady, Date datyNanamasinana, Date datySoratra, Fitandremana fitandremana){
		if (vady == null || fitandremana == null)
			throw new IllegalArgumentException();
				
		Fanambadiana ret = new Fanambadiana(mpivavaka);
		ret.setVady(vady);
		ret.setDatySoratra(datySoratra);
		ret.setDatyFanamasinana(datyNanamasinana);
		ret.setFitandremana(fitandremana);
		
		return ret;
	}

	public static Fanambadiana createFanambadiana(Mpivavaka mpivavaka, String anaranaVady, Date datyNanamasinana, Date datySoratra, Fitandremana fitandremana){
		if (anaranaVady == null || "".equals(anaranaVady.trim()) || fitandremana == null)
			throw new IllegalArgumentException();
				
		Fanambadiana ret = new Fanambadiana(mpivavaka);
		ret.setAnaranaVady(anaranaVady);
		ret.setDatySoratra(datySoratra);
		ret.setDatyFanamasinana(datyNanamasinana);
		ret.setFitandremana(fitandremana);
		
		return ret;
	}
	//----------------------------------------------------------------
	public Date getDaty() {
		return fDaty;
	}

	public void setDaty(Date daty) {
		fDaty = daty;
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
	
	//------------------ création de Fanambadiana --------------------
	protected Fanambadiana(){
		//pour hibernate uniquement
	}
	
	protected Fanambadiana(Mpivavaka mpivavaka){
	}

	public Mpivavaka getVady(Mpivavaka mpivavaka){
		Mpivavaka vady = fVady;
		if (mpivavaka != null){
			if (!getMpivavaka().equals(mpivavaka))
				vady = getMpivavaka();
		}
		return vady;
	}
	
	//----------- pour hibernate -----------
	protected void setVadyForPersistence(Mpivavaka vady){
		fVady = vady;
	}
	
	protected Mpivavaka getVadyForPersistence() {
		return fVady;
	}
	//---------------------------------------
	
	public Mpivavaka getVady() {
		return fVady;
	}

	/**
	 * Remplace soit this.fVady soit this.fMpivavaka par vadyVaovao en comparant par rapport vadyAnkehitriny  
	 * @param vadyVaovao
	 * @param vadyAnkehitriny
	 */
	public void replaceVady(Mpivavaka vadyVaovao, Mpivavaka vadyAnkehitriny){
		assert vadyAnkehitriny != null && vadyVaovao != null;
		if (vadyAnkehitriny.equals(getMpivavaka()))
			setMpivavaka(vadyVaovao);
		else if (vadyAnkehitriny.equals(getVady())){
			setVady(vadyVaovao);
			setAnaranaVady(null);
		}
	}
	
	/**
	 * @param vady, le vady à partir de this.fMpivavaka ou this.fVady en comparant avec le paramètre
	 */
	public void setVady(Mpivavaka vady) {
		if (vady != null && !vady.equals(getMpivavaka())){
			if (getMpivavaka() != null && getMpivavaka().isLahy() == vady.isLahy())
				throw new RuntimeException("Lahy sy vavy no mpivady.");
			
			fVady = vady;
		}
		else{
			if (vady.equals(getMpivavaka()))
				throw new RuntimeException("Ny mpivady dia tokony olona roa samihafa");
		}
	}

	/**
	 * positionne le this.fVady ou this.fMpivavaka en comparant p/r à vadyTsyMiova 
	 */
	public void setVadyOrMpivavaka(Mpivavaka vady, Mpivavaka vadyTsyMiova) {
		if (vadyTsyMiova.equals(fVady))
			setMpivavaka(vady);
		else if (vadyTsyMiova.equals(getMpivavaka())){
			setVady(vady);
			setAnaranaVady(null);
		}
	}

	private String getAnaranaVady() {
		return fAnaranaVady;
	}

	public String getAnaranaVady_(){
		if (fVady != null)
			return (fVady.getAnarana()+" "+fVady.getFanampiny() != null ? fVady.getFanampiny(): "").trim();
		else
			return getAnaranaVady();
	}
	
	public void setAnaranaVady(String anaranaVady) {
		fAnaranaVady = anaranaVady;
	}

	/**
	 * Esorina ilay vady taloha (izay Mpivavaka) fa kosa ovaina anaranaVady izay tsy mbola Mpivavaka ao anaty base de données
	 * @param anaranaVady
	 * @param vadyTaloha
	 */
	public void setAnaranaVady(String anaranaVady, Mpivavaka vadyTaloha){
		assert(vadyTaloha != null);
		
		if (!vadyTaloha.equals(fVady))
			setMpivavaka(fVady);
		
		fVady = null;
		setAnaranaVady(anaranaVady);
	}

	/**
	 * Mametraka ny anaran'ny vady (izay tsy Mpivavaka) ho an'ilay vady
	 * @param vady
	 * @param anaranaVady
	 */
	public void setAnaranaVady(Mpivavaka vady, String anaranaVady){
		assert(vady != null);
		setMpivavaka(vady);
		
		fVady = null;
		setAnaranaVady(anaranaVady);
	}

	/**
	 * @return the fDatyFanamasinana
	 */
	public Date getDatyFanamasinana() {
		return getDaty();
	}

	/**
	 * @param datyFanamasinana the fDatyFanamasinana to set
	 */
	public void setDatyFanamasinana(Date datyFanamasinana) {
		setDaty(datyFanamasinana);
	}

	/**
	 * @return the fDatySoratra
	 */
	public Date getDatySoratra() {
		return fDatySoratra;
	}

	/**
	 * @param datySoratra the fDatySoratra to set
	 */
	public void setDatySoratra(Date datySoratra) {
		fDatySoratra = datySoratra;
	}

	/**
	 * @return the fIsanJanaka
	 */
	public Integer getIsanJanakaLahy() {
		return fIsanJanakaLahy;
	}

	/**
	 * @param isanJanaka the fIsanJanaka to set
	 */
	public void setIsanJanakaLahy(Integer isanJanaka) {
		fIsanJanakaLahy = isanJanaka;
	}

	public Integer getIsanJanakaVavy() {
		return fIsanJanakaVavy;
	}

	public void setIsanJanakaVavy(Integer isanJanakaVavy) {
		fIsanJanakaVavy = isanJanakaVavy;
	}

	/**
	 * @return the fIsanJanakaMpandray
	 */
	public Integer getIsanJanakaMpandray() {
		return fIsanJanakaMpandray;
	}

	/**
	 * @param isanJanakaMpandray the fIsanJanakaMpandray to set
	 */
	public void setIsanJanakaMpandray(Integer isanJanakaMpandray) {
		fIsanJanakaMpandray = isanJanakaMpandray;
	}

	/**
	 * @return the fIsanJanakaVitaBatisa
	 */
	public Integer getIsanJanakaVitaBatisa() {
		return fIsanJanakaVitaBatisa;
	}

	/**
	 * @param isanJanakaVitaBatisa the fIsanJanakaVitaBatisa to set
	 */
	public void setIsanJanakaVitaBatisa(Integer isanJanakaVitaBatisa) {
		fIsanJanakaVitaBatisa = isanJanakaVitaBatisa;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (fId == null)
			return false;
		if(!(o instanceof Fanambadiana))
			return false;
		Fanambadiana other = (Fanambadiana)o;
		
		return fId.equals(other.fId);
	}

	@Override
	public int hashCode() {
		return fId != null ? fId.hashCode() : -1;
	}
}
