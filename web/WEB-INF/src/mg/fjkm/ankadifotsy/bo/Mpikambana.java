/**
 * 
 */
package mg.fjkm.ankadifotsy.bo;


/**
 * Mpikambana ao amin'ny Sampana
 * @author Rija
 *
 */
public class Mpikambana extends SaveableEntity{
	
	private static final long serialVersionUID = 1L;

	private Mpivavaka fMpivavaka = null;
	
	private SampanAsa fSampanAsa = null;
	
	private Andraikitra fAndraikitra = null;
	
	private TaomPanompoana fTaomPanompoana = null;
	
	private Fitandremana fFitandremana = null;
	
	protected Mpikambana(){
		
	}
	
	public Mpikambana(Mpivavaka mpivavaka, SampanAsa sampanAsa, TaomPanompoana taomPanompoana , Fitandremana fitandremana){
		if (mpivavaka == null || sampanAsa == null || taomPanompoana == null || fitandremana == null)
			throw new IllegalArgumentException();
		
		setMpivavaka(mpivavaka);
		setTaomPanompoana(taomPanompoana);
		setFitandremana(fitandremana);
		setSampanAsa(sampanAsa);
		setAndraikitra(Andraikitra.sfAndraikitraMpikambanaTsotra);
	}

	/**
	 * @return the fAndraikitra
	 */
	public Andraikitra getAndraikitra() {
		return fAndraikitra;
	}

	/**
	 * @param andraikitra the fAndraikitra to set
	 */
	public void setAndraikitra(Andraikitra andraikitra) {
		fAndraikitra = andraikitra;
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

	/**
	 * @return the fMpivavaka
	 */
	public Mpivavaka getMpivavaka() {
		return fMpivavaka;
	}

	/**
	 * @param mpivavaka the fMpivavaka to set
	 */
	public void setMpivavaka(Mpivavaka mpivavaka) {
		fMpivavaka = mpivavaka;
	}

	/**
	 * @return the fSampanAsa
	 */
	public SampanAsa getSampanAsa() {
		return fSampanAsa;
	}

	/**
	 * @param sampanAsa the fSampanAsa to set
	 */
	public void setSampanAsa(SampanAsa sampanAsa) {
		fSampanAsa = sampanAsa;
	}

	/**
	 * @return the fTaomPanompoana
	 */
	public TaomPanompoana getTaomPanompoana() {
		return fTaomPanompoana;
	}

	/**
	 * @param taomPanompoana the fTaomPanompoana to set
	 */
	public void setTaomPanompoana(TaomPanompoana taomPanompoana) {
		fTaomPanompoana = taomPanompoana;
	}
}
