package mg.fjkm.ankadifotsy.bo;

import java.io.Serializable;
import java.util.Date;

/**
 * Ny taom-panompoana sy ny fitandremana naha-diakona
 * @author Rija
 *
 */
public class Diakona extends SaveableEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private TaomPanompoana fTaomPanompoana = null;
	
	private Fitandremana fFitandremana = null;
	
	private Mpivavaka fMpivavaka = null;

	private String fSamihafa = null;
	
	private boolean fNisaraBady = false;
	
	private int fIsaZanakaLahy = 0;
	private int fIsaZanakaVavy = 0;
	
	private int fIsaZanakaVitaBatisa = 0;
	private int fIsaZanakaMpandray = 0;

	protected Diakona(){
	}
	
	public Diakona(Mpivavaka mpivavaka, Fitandremana fitandremana, TaomPanompoana taomPanompoana){
		if (mpivavaka == null || fitandremana == null || taomPanompoana == null)
			throw new IllegalArgumentException();
		
		setMpivavaka(mpivavaka);
		setFitandremana(fitandremana);
		setTaomPanompoana(taomPanompoana);
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

	/**
	 * @return the fNisaraBady
	 */
	public boolean isNisaraBady() {
		return fNisaraBady;
	}

	/**
	 * @param nisaraBady the fNisaraBady to set
	 */
	public void setNisaraBady(boolean nisaraBady) {
		fNisaraBady = nisaraBady;
	}

	/**
	 * @return the fSamihafa
	 */
	public String getSamihafa() {
		return fSamihafa;
	}

	/**
	 * @param samihafa the fSamihafa to set
	 */
	public void setSamihafa(String samihafa) {
		fSamihafa = samihafa;
	}

	/**
	 * @return
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#getAdresse()
	 */
	public String getAdresse() {
		return fMpivavaka.getAdresse();
	}

	/**
	 * @return
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#getAnarana()
	 */
	public String getAnarana() {
		return fMpivavaka.getAnarana();
	}

	/**
	 * @param sampanAsa
	 * @param date
	 * @return
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#getAndraikitraSampana(mg.fjkm.ankadifotsy.bo.SampanAsa, java.util.Date)
	 */
	public Andraikitra getAndraikitraSampana(SampanAsa sampanAsa, Date date) {
		return fMpivavaka.getAndraikitraSampana(sampanAsa, date);
	}

	/**
	 * @return
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#getFanampiny()
	 */
	public String getFanampiny() {
		return fMpivavaka.getFanampiny();
	}

	/**
	 * @return
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#getFaritra()
	 */
	public Faritra getFaritra() {
		return fMpivavaka.getFaritra();
	}

	/**
	 * @return
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#getFiraisana()
	 */
	public Firaisana getFiraisana() {
		return fMpivavaka.getFiraisana();
	}

	/**
	 * @return
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#getLaharana()
	 */
	public String getLaharana() {
		return fMpivavaka.getLaharana();
	}

	/**
	 * @return
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#getLaharanaCIN()
	 */
	public String getLaharanaCIN() {
		return fMpivavaka.getLaharanaCIN();
	}

	/**
	 * @return
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#getMailaka()
	 */
	public String getMailaka() {
		return fMpivavaka.getMailaka();
	}

	/**
	 * @return
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#getPhotoName()
	 */
	public String getPhotoName() {
		return fMpivavaka.getPhotoName();
	}

	/**
	 * @return
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#getRay()
	 */
	public String getRay() {
		return fMpivavaka.getRay();
	}

	/**
	 * @return
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#getReny()
	 */
	public String getReny() {
		return fMpivavaka.getReny();
	}

	/**
	 * @return
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#getTalenta()
	 */
	public String getTalenta() {
		return fMpivavaka.getTalenta();
	}

	/**
	 * @return
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#getTel()
	 */
	public String getTel() {
		return fMpivavaka.getTel();
	}

	/**
	 * @return
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#getToeranaTeraka()
	 */
	public String getToeranaTeraka() {
		return fMpivavaka.getToeranaTeraka();
	}

	/**
	 * @return
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#getAnaranaVady()
	 */
	public String getVady() {
		return fMpivavaka.getAnaranaVady();
	}

	/**
	 * @return
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#isLahy()
	 */
	public boolean isLahy() {
		return fMpivavaka.isLahy();
	}

	/**
	 * @param adresse
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#setAdresse(java.lang.String)
	 */
	public void setAdresse(String adresse) {
		fMpivavaka.setAdresse(adresse);
	}

	/**
	 * @param anarana
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#setAnarana(java.lang.String)
	 */
	public void setAnarana(String anarana) {
		fMpivavaka.setAnarana(anarana);
	}

	/**
	 * @param datyTeraka
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#setDatyTeraka(java.util.Date)
	 */
	public void setDatyTeraka(Date datyTeraka) {
		fMpivavaka.setDatyTeraka(datyTeraka);
	}

	/**
	 * @param fanampiny
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#setFanampiny(java.lang.String)
	 */
	public void setFanampiny(String fanampiny) {
		fMpivavaka.setFanampiny(fanampiny);
	}

	/**
	 * @param faritra
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#setFaritra(mg.fjkm.ankadifotsy.bo.Faritra)
	 */
	public void setFaritra(Faritra faritra) {
		fMpivavaka.setFaritra(faritra);
	}

	/**
	 * @param firaisana
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#setFiraisana(mg.fjkm.ankadifotsy.bo.Firaisana)
	 */
	public void setFiraisana(Firaisana firaisana) {
		fMpivavaka.setFiraisana(firaisana);
	}

	/**
	 * @param laharana
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#setLaharana(java.lang.String)
	 */
	public void setLaharana(String laharana) {
		fMpivavaka.setLaharana(laharana);
	}

	/**
	 * @param laharanaCIN
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#setLaharanaCIN(java.lang.String)
	 */
	public void setLaharanaCIN(String laharanaCIN) {
		fMpivavaka.setLaharanaCIN(laharanaCIN);
	}

	/**
	 * @param lahy
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#setLahy(boolean)
	 */
	public void setLahy(boolean lahy) {
		fMpivavaka.setLahy(lahy);
	}

	/**
	 * @param mailaka
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#setMailaka(java.lang.String)
	 */
	public void setMailaka(String mailaka) {
		fMpivavaka.setMailaka(mailaka);
	}

	/**
	 * @param ray
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#setRay(java.lang.String)
	 */
	public void setRay(String ray) {
		fMpivavaka.setRay(ray);
	}

	/**
	 * @param reny
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#setReny(java.lang.String)
	 */
	public void setReny(String reny) {
		fMpivavaka.setReny(reny);
	}

	/**
	 * @param talenta
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#setTalenta(java.lang.String)
	 */
	public void setTalenta(String talenta) {
		fMpivavaka.setTalenta(talenta);
	}

	/**
	 * @param tel
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#setTel(java.lang.String)
	 */
	public void setTel(String tel) {
		fMpivavaka.setTel(tel);
	}

	/**
	 * @param toeranaTeraka
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#setToeranaTeraka(java.lang.String)
	 */
	public void setToeranaTeraka(String toeranaTeraka) {
		fMpivavaka.setToeranaTeraka(toeranaTeraka);
	}

	/**
	 * @param vady
	 * @see mg.fjkm.ankadifotsy.bo.Mpivavaka#setAnaranaVady(java.lang.String)
	 */
	public void setVady(String vady) {
		fMpivavaka.setAnaranaVady(vady);
	}

	/**
	 * @return the fIsaZanakaLahy
	 */
	public int getIsaZanakaLahy() {
		return fIsaZanakaLahy;
	}

	/**
	 * @param isaZanakaLahy the fIsaZanakaLahy to set
	 */
	public void setIsaZanakaLahy(int isaZanakaLahy) {
		fIsaZanakaLahy = isaZanakaLahy;
	}

	/**
	 * @return the fIsaZanakaMpandray
	 */
	public int getIsaZanakaMpandray() {
		return fIsaZanakaMpandray;
	}

	/**
	 * @param isaZanakaMpandray the fIsaZanakaMpandray to set
	 */
	public void setIsaZanakaMpandray(int isaZanakaMpandray) {
		fIsaZanakaMpandray = isaZanakaMpandray;
	}

	/**
	 * @return the fIsaZanakaVavy
	 */
	public int getIsaZanakaVavy() {
		return fIsaZanakaVavy;
	}

	/**
	 * @param isaZanakaVavy the fIsaZanakaVavy to set
	 */
	public void setIsaZanakaVavy(int isaZanakaVavy) {
		fIsaZanakaVavy = isaZanakaVavy;
	}

	/**
	 * @return the fIsaZanakaVitaBatisa
	 */
	public int getIsaZanakaVitaBatisa() {
		return fIsaZanakaVitaBatisa;
	}

	/**
	 * @param isaZanakaVitaBatisa the fIsaZanakaVitaBatisa to set
	 */
	public void setIsaZanakaVitaBatisa(int isaZanakaVitaBatisa) {
		fIsaZanakaVitaBatisa = isaZanakaVitaBatisa;
	}

	public int getIsaZanaka(){
		return fIsaZanakaLahy + fIsaZanakaVavy;
	}
	
	//--------------- hashCode , equals -------------------------
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((fFitandremana == null) ? 0 : fFitandremana.hashCode());
		result = PRIME * result + ((fMpivavaka == null) ? 0 : fMpivavaka.hashCode());
		result = PRIME * result + ((fTaomPanompoana == null) ? 0 : fTaomPanompoana.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Diakona other = (Diakona) obj;
		if (fFitandremana == null) {
			if (other.fFitandremana != null)
				return false;
		} else if (!fFitandremana.equals(other.fFitandremana))
			return false;
		if (fMpivavaka == null) {
			if (other.fMpivavaka != null)
				return false;
		} else if (!fMpivavaka.equals(other.fMpivavaka))
			return false;
		if (fTaomPanompoana == null) {
			if (other.fTaomPanompoana != null)
				return false;
		} else if (!fTaomPanompoana.equals(other.fTaomPanompoana))
			return false;
		return true;
	}
		
}
