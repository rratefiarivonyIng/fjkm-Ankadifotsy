/**
 * 
 */
package mg.fjkm.ankadifotsy.bo;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import mg.fjkm.ankadifotsy.util.Utils;

import org.apache.commons.lang.NotImplementedException;


/**
 * Les informations sur un fidèle.
 * @author rija
 * @version 1.0
 */
public class Mpivavaka extends SaveableEntity implements Serializable{

	private static final long serialVersionUID = 1L;	
	
	private String fLaharana = null;
	private String fAnarana = null;
	private String fFanampiny = null;

	private String fLaharanaCIN = null;
	private Date fDatyCIN = null;
	private Firaisana fTaoCIN = null;
	private Date fDatyNanoloinaCIN = null;
	private Firaisana fTaoNanoloinaCIN = null;

	private Date fDatyTeraka = null;	
	private String fToeranaTeraka = null;
	private boolean fLahy = true;
	
	private String fAdresse = null;
	private Firaisana fFiraisana = null;
	private Faritra fFaritra = null;
	private String fMailaka = null;
	private String fTel = null;

	private String fSamihafa = null;
	
	private Fitandremana fFitandremana =null;
	private Fitandremana fFitandremanaNiaviana = null;
	
	private String fRay = null;
	private Mpivavaka fRay_ = null;
	private String fReny = null;
	private Mpivavaka fReny_ = null;

	private String fTalenta = null;
	private AntonAsa fAntonAsa = null;
	
	private Set<Tranga> fTrangas = new HashSet<Tranga>();
	private Set<Fanambadiana> fFanambadianas = new HashSet<Fanambadiana>();

	private Set<Diakona> fDiakonas = new HashSet<Diakona>();

	private Set<Mpikambana> fMpikambanas = new HashSet<Mpikambana>();
	
	private Set<MpivavakaMiteny> fFitenys = new HashSet<MpivavakaMiteny>();
	
	public Mpivavaka(){
	}

	/**
	 * @return the fLaharana
	 */
	public String getLaharana() {
		return fLaharana;
	}

	/**
	 * @param laharana the fLaharana to set
	 */
	public void setLaharana(String laharana) {
		fLaharana = laharana;
	}

	public String getAdresse() {
		return fAdresse;
	}

	public void setAdresse(String adresse) {
		fAdresse = adresse;
	}

	/**
	 * @return the fFaritra
	 */
	public Faritra getFaritra() {
		return fFaritra;
	}

	/**
	 * @param faritra the fFaritra to set
	 */
	public void setFaritra(Faritra faritra) {
		fFaritra = faritra;
	}

	/**
	 * @return the fFiraisana
	 */
	public Firaisana getFiraisana() {
		return fFiraisana;
	}

	/**
	 * @param firaisana the fFiraisana to set
	 */
	public void setFiraisana(Firaisana firaisana) {
		fFiraisana = firaisana;
	}

	/**
	 * @return the fMailaka
	 */
	public String getMailaka() {
		return fMailaka;
	}

	/**
	 * @param mailaka the fMailaka to set
	 */
	public void setMailaka(String mailaka) {
		fMailaka = mailaka;
	}

	/**
	 * @return the fTel
	 */
	public String getTel() {
		return fTel;
	}

	/**
	 * @param tel the fTel to set
	 */
	public void setTel(String tel) {
		fTel = tel;
	}

	public String getAnarana() {
		return fAnarana;
	}

	public void setAnarana(String anarana) {
		fAnarana = anarana;
	}

	public Date getDatyTeraka() {
		return fDatyTeraka;
	}

	public void setDatyTeraka(Date datyTeraka) {
		fDatyTeraka = datyTeraka;
	}

	public String getFanampiny() {
		return fFanampiny;
	}

	public void setFanampiny(String fanampiny) {
		fFanampiny = fanampiny;
	}

	public Fitandremana getFitandremana() {
		return fFitandremana;
	}

	public void setFitandremana(Fitandremana fitandremana) {
		fFitandremana = fitandremana;
	}

	/**
	 * @return the fFitandremanaNiaviana
	 */
	public Fitandremana getFitandremanaNiaviana() {
		return fFitandremanaNiaviana;
	}

	/**
	 * @param fitandremanaNiaviana the fFitandremanaNiaviana to set
	 */
	public void setFitandremanaNiaviana(Fitandremana fitandremanaNiaviana) {
		fFitandremanaNiaviana = fitandremanaNiaviana;
	}

	//------------- Momba ny Fianakaviana -----------------
	public String getRay() {
		return fRay;
	}

	public void setRay(String ray) {
		fRay = ray;
	}
	
	/**
	 * @return the fRay_
	 */
	public Mpivavaka getRay_() {
		return fRay_;
	}

	/**
	 * @param ray_ the fRay_ to set
	 */
	public void setRay_(Mpivavaka ray_) {
		fRay_ = ray_;
	}

	public void checkAnaranaRayWithRay_(){
		if (fRay != null && !"".equals(fRay.trim())){
			if (fRay_ != null){
				String anaranaRay = Utils.getTrimmedString(fRay);
				String anaranaFanampiny = fRay_.getAnarana().trim()+fRay_.getFanampiny().trim();
				if (!anaranaRay.equalsIgnoreCase(anaranaFanampiny))
					fRay_ = null;
				else
					fRay = fRay_.getAnarana()+" "+fRay_.getFanampiny();
			}
		}
	}

	public String getReny() {
		return fReny;
	}

	public void setReny(String reny) {
		fReny = reny;
	}

	/**
	 * @return the fReny_
	 */
	public Mpivavaka getReny_() {
		return fReny_;
	}

	/**
	 * @param reny_ the fReny_ to set
	 */
	public void setReny_(Mpivavaka reny_) {
		fReny_ = reny_;
	}

	public void checkAnaranaRenyWithReny_(){
		if (fReny != null && !"".equals(fReny.trim())){
			if (fReny_ != null){
				String anaranaReny = Utils.getTrimmedString(fReny);
				String anaranaFanampiny = fReny_.getAnarana().trim()+fReny_.getFanampiny().trim();
				if (!anaranaReny.toString().equalsIgnoreCase(anaranaFanampiny))
					fReny_ = null;
				else
					fReny = fReny_.getAnarana()+" "+fReny_.getFanampiny();
			}
		}
	}

	public String getToeranaTeraka() {
		return fToeranaTeraka;
	}

	public void setToeranaTeraka(String toeranaTeraka) {
		fToeranaTeraka = toeranaTeraka;
	}

	//------- pour hibernate ----------------
	protected Set<Fanambadiana> getFanambadianas() {
		return fFanambadianas;
	}

	protected void setFanambadianas(Set<Fanambadiana> fanambadianas) {
		fFanambadianas = fanambadianas;
	}
	
	public void addFanambadiana(Fanambadiana fanambadiana){
		if (!fFanambadianas.contains(fanambadiana))
			fFanambadianas.add(fanambadiana);
	}
	
	public void removeFanambadiana(Fanambadiana fanambadiana){
		fFanambadianas.remove(fanambadiana);
	}
	
	//---------------------------------------
	
	public Set<Fanambadiana> getAllFanambadiana(){
		return Collections.unmodifiableSet(fFanambadianas);
	}
	
	public boolean isManambady(){
		return getAllFanambadiana().size() > 0;
	}
	
	public Fanambadiana getFanambadiana(){
		Fanambadiana fanambadiana = null;
		Set<Fanambadiana> vadys = getAllFanambadiana();
		if (vadys.size() > 1)
			throw new NotImplementedException();
		else{
			Iterator<Fanambadiana> i = fFanambadianas.iterator();
			if (i.hasNext())
				fanambadiana = i.next();
		}
		return fanambadiana;
	}
	
	public String getAnaranaVady() {
		String ret = "";
		Fanambadiana fanambadiana = getFanambadiana();
		if (fanambadiana != null){
			Mpivavaka vady = fanambadiana.getVady(this);
			if (vady != null)
				ret = vady.getAnarana()+" "+ (vady.getFanampiny() != null ? vady.getFanampiny() : "");
			else
				ret = fanambadiana.getAnaranaVady_();
		}
		return ret;
	}

	/**
	 * On ne peut pas modifier le nom d'un vady d'ici MAIS on peut en créer seulement si this n'est pas encore marié
	 * @param anaranaVady
	 */
	public void setAnaranaVady(String anaranaVady) {
		Fanambadiana fanambadiana = getFanambadiana();
		if (fanambadiana == null){
			fanambadiana = Fanambadiana.createFanambadiana(this, anaranaVady);
			fFanambadianas.add(fanambadiana);
		}
	}

	/**
	 * @return the fVady_
	 */
	public Mpivavaka getVady() {
		Mpivavaka vady = null;
		Fanambadiana fanambadiana = getFanambadiana();
		if (fanambadiana != null)
			vady = fanambadiana.getVady();

		return vady;
	}

	/**
	 * @param vady_ the fVady_ to set
	 */
	public void setVady(Mpivavaka vady) {
		if (vady == null)
			throw new IllegalArgumentException();
		
		Fanambadiana fanambadiana = getFanambadiana();
		if (fanambadiana == null){
			fanambadiana = Fanambadiana.createFanambadiana(this, vady);
			fFanambadianas.add(fanambadiana);
		}
		else
			fanambadiana.setVady(vady);
	}

	public boolean isLahy() {
		return fLahy;
	}

	public void setLahy(boolean lahy) {
		fLahy = lahy;
	}

	//------- Asa aman-draharaha sy Talenta -----------------------
	/**
	 * @return the fTalenta
	 */
	public String getTalenta() {
		return fTalenta;
	}

	/**
	 * @param talenta the fTalenta to set
	 */
	public void setTalenta(String talenta) {
		fTalenta = talenta;
	}

	/**
	 * @return the fAntonAsa
	 */
	public AntonAsa getAntonAsa() {
		return fAntonAsa;
	}

	/**
	 * @param antonAsa the fAntonAsa to set
	 */
	public void setAntonAsa(AntonAsa antonAsa) {
		fAntonAsa = antonAsa;
	}

	//------------ Kara-panondrom-pirenena -------------------------
	/**
	 * @return the fLaharanaCIN
	 */
	public String getLaharanaCIN() {
		return fLaharanaCIN;
	}

	/**
	 * @param laharanaCIN the fLaharanaCIN to set
	 */
	public void setLaharanaCIN(String laharanaCIN) {
		fLaharanaCIN = laharanaCIN;
	}

	/**
	 * @return the fDatyCIN
	 */
	public Date getDatyCIN() {
		return fDatyCIN;
	}

	/**
	 * @param datyCIN the fDatyCIN to set
	 */
	public void setDatyCIN(Date datyCIN) {
		fDatyCIN = datyCIN;
	}

	/**
	 * @return the fDatyNanoloinaCIN
	 */
	public Date getDatyNanoloinaCIN() {
		return fDatyNanoloinaCIN;
	}

	/**
	 * @param datyNanoloinaCIN the fDatyNanoloinaCIN to set
	 */
	public void setDatyNanoloinaCIN(Date datyNanoloinaCIN) {
		fDatyNanoloinaCIN = datyNanoloinaCIN;
	}

	/**
	 * @return the fTaoCIN
	 */
	public Firaisana getTaoCIN() {
		return fTaoCIN;
	}

	/**
	 * @param taoCIN the fTaoCIN to set
	 */
	public void setTaoCIN(Firaisana taoCIN) {
		fTaoCIN = taoCIN;
	}

	/**
	 * @return the fTaoNanoloinaCIN
	 */
	public Firaisana getTaoNanoloinaCIN() {
		return fTaoNanoloinaCIN;
	}

	/**
	 * @param taoNanoloinaCIN the fTaoNanoloinaCIN to set
	 */
	public void setTaoNanoloinaCIN(Firaisana taoNanoloinaCIN) {
		fTaoNanoloinaCIN = taoNanoloinaCIN;
	}

	public String getSamihafa() {
		return fSamihafa;
	}

	public void setSamihafa(String samihafa) {
		fSamihafa = samihafa;
	}

	/**
	 * @return the fFitenys
	 */
	protected Set<MpivavakaMiteny> getFitenys() {
		return fFitenys;
	}

	/**
	 * @param fitenys the fFitenys to set
	 */
	protected void setFitenys(Set<MpivavakaMiteny> fitenys) {
		fFitenys = fitenys;
	}

	public Set<MpivavakaMiteny> getAllFiteny(){
		return Collections.unmodifiableSet(fFitenys);
	}
	
	public void addFiteny(Fitenimpirenena fitenimpirenena, boolean soratana, boolean tenenina){
		if (fitenimpirenena == null)
			throw new IllegalArgumentException();
		
		MpivavakaMiteny mpivavakaMiteny = new MpivavakaMiteny(this, fitenimpirenena);
		mpivavakaMiteny.setSoratana(soratana);
		mpivavakaMiteny.setTenenina(tenenina);
		
		fFitenys.add(mpivavakaMiteny);
	}
	
	/**
	 * 
	 * @param fitenimpirenena
	 * @return true si le mpivavaka parle la langue
	 */
	public boolean miteny(Fitenimpirenena fitenimpirenena){
		boolean ret = false;
		if (fitenimpirenena != null){
			for (MpivavakaMiteny mpivavakaMiteny : getAllFiteny()){
				if (fitenimpirenena.equals(mpivavakaMiteny.getFitenimpirenena())){
					ret = true;
					break;
				}
			}
		}
		
		return ret;
	}
	//--------------------------------------------------------------------	

	public String getDefaultPhotoName(){
		return Utils.getDefaultPhotoName(isLahy());
	}
	
	public String getPhotoName(){
		return Utils.getPhotoName(getAnarana(), getId());
	}
	
	protected Set<Tranga> getTrangas() {
		return fTrangas;
	}

	protected void setTrangas(Set<Tranga> trangas) {
		fTrangas = trangas;
	}

	public void addTranga(Tranga tranga){
		if (!fTrangas.contains(tranga))
			fTrangas.add(tranga);
	}
	
	public void addTrangaBatisa(Date daty){
		if (daty == null)
			throw new IllegalArgumentException();
		Tranga batisa = Tranga.createTranga(this, KarazaTranga.sfKarazaTrangaBatisa, daty);
		if (!fTrangas.contains(batisa))
			fTrangas.add(batisa);
	}
	
	public void addTrangaMpandray(Date daty){
		if (daty == null)
			throw new IllegalArgumentException();
		Tranga mpandray = Tranga.createTranga(this, KarazaTranga.sfKarazaTrangaMpandray, daty);
		if (!fTrangas.contains(mpandray))
			fTrangas.add(mpandray);
	}
	
	/**
	 * @return the fDiakonas
	 */
	protected Set<Diakona> getDiakonas() {
		return fDiakonas;
	}

	/**
	 * @param diakonas the fDiakonas to set
	 */
	protected void setDiakonas(Set<Diakona> diakonas) {
		fDiakonas = diakonas;
	}

	public Set<Diakona> getAllDiakona(){
		return Collections.unmodifiableSet(fDiakonas);
	}
	
	public Diakona getDiakona(Date daty){
		Diakona ret = null;
		if (daty != null){
			for (Diakona diakona : fDiakonas){
				TaomPanompoana taomPanompoana = diakona.getTaomPanompoana();
				if (taomPanompoana.isDateInTaomPanompoana(daty)){
					ret = diakona;
					break;
				}
			}
		}
		return ret;
	}
	
	public void addDiakona(Diakona diakona){
		if (!fDiakonas.contains(diakona))
			fDiakonas.add(diakona);
	}
	
	public Diakona addDiakona(TaomPanompoana taomPanompoana, Fitandremana fitandremana){
		Diakona diakona = new Diakona(this, fitandremana, taomPanompoana);
		addDiakona(diakona);
		return diakona;
	}
	
	/**
	 * @return the fMpikambanas
	 */
	protected Set<Mpikambana> getMpikambanas() {
		return fMpikambanas;
	}

	/**
	 * @param mpikambanas the fMpikambanas to set
	 */
	protected void setMpikambanas(Set<Mpikambana> mpikambanas) {
		fMpikambanas = mpikambanas;
	}

	/**
	 * 
	 * @return les relations de this avec les sampana et les TaomPanomboana associés
	 */
	public Set<Mpikambana> getAllFikambanana(){
		return Collections.unmodifiableSet(fMpikambanas);
	}
	
	public void manambady(Mpivavaka vady, Fitandremana fitandremana, Date datySoratra, Date datyNanamasinana){
		if (vady == null)
			throw new IllegalArgumentException();
	
		if (fLahy){
			if (vady.isLahy())
				throw new RuntimeException("Lahy manambady lahy.");
		}
		else{
			if (!vady.isLahy())
				throw new RuntimeException("Vavy manambady vavy.");
		}
			
		Fanambadiana fanambadiana = Fanambadiana.createFanambadiana(this, vady, datyNanamasinana, datySoratra, fitandremana);
		
		fFanambadianas.add(fanambadiana);
	}

	/**
	 * 
	 * @param karazaTrangaId
	 * @return ny daty nitrangan'ny Tranga
	 */
	private Date getDatyTranga(Long karazaTrangaId){
		Date ret = null;
		if (karazaTrangaId != null){
			Tranga tranga = getTrangaByKarazana(karazaTrangaId);
			if (tranga != null)
				ret = tranga.getDaty();
		}
		return ret;
	}
	
	public Date getDatyFanambadiana(){
		Fanambadiana fanambadiana = getFanambadiana();
		Date daty = null;
		if (fanambadiana != null)
			daty = fanambadiana.getDatyFanamasinana();
		
		return daty;
	}
	
	public Fitandremana getFitandremanaFanambadiana(){
		Fanambadiana fanambadiana = getFanambadiana();
		Fitandremana fitandremana = null;
		if (fanambadiana != null)
			fitandremana = fanambadiana.getFitandremana();
		
		return fitandremana;
	}
	
	private Tranga getTrangaByKarazana(Long karazaTrangaId){
		Tranga ret = null;
		if (karazaTrangaId != null){
			for (Tranga tranga : fTrangas){
				if (karazaTrangaId.equals(tranga.getKarazaTranga().getId())){
					ret = tranga;
					break;
				}
			}			
		}
		return ret;
	}
	
	/**
	 * 
	 * @param karazaTrangaId
	 * @return ny Fitandremana nanamasinana ny Tranga
	 */
	private Fitandremana getFitandremanaTranga(Long karazaTrangaId){
		Fitandremana ret = null;
		if (karazaTrangaId != null){
			Tranga tranga = getTrangaByKarazana(karazaTrangaId);
			if (tranga != null)
				ret = tranga.getFitandremana();
		}
		return ret;
	}
	
	private boolean isTrangaFrom(Date date, Long karazaTrangaId){
		boolean ret = false;
		if (karazaTrangaId != null){
			for (Tranga tranga : fTrangas){
				if (karazaTrangaId.equals(tranga.getKarazaTranga().getId())){
					if (date != null  && tranga.getDaty() != null)
						ret = date.getTime() >= tranga.getDaty().getTime();
					else
						ret = true;
					
					if (ret)
						break;
				}
			}
		}
		return ret;
	}
	
	/**
	 * 
	 * @return Daty nanamasinana ho mpandray
	 */
	public Date getDatyMpandray(){
		return getDatyTranga(KarazaTranga.sfLONG_MPANDRAY);
	}
	
	public Fitandremana getFitandremanaMpandray(){
		return getFitandremanaTranga(KarazaTranga.sfLONG_MPANDRAY);
	}
	
	public boolean isMpandrayFrom(Date date){
		boolean ret = isTrangaFrom(date, KarazaTranga.sfLONG_MPANDRAY);
		return ret;
	}
	
	public Tranga getMpandray(){
		return getTrangaByKarazana(KarazaTranga.sfLONG_MPANDRAY);
	}
	
	public Tranga getBatisa(){
		return getTrangaByKarazana(KarazaTranga.sfLONG_BATISA);
	}
	
	public Date getDatyBatisa(){
		return getDatyTranga(KarazaTranga.sfLONG_BATISA);
	}
	
	public Fitandremana getFitandremanaBatisa(){
		return getFitandremanaTranga(KarazaTranga.sfLONG_BATISA);
	}
	
	public boolean isVitaBatisa(Date date){
		boolean ret = isTrangaFrom(date, KarazaTranga.sfLONG_BATISA);
		return ret;
	}
	
	/**
	 * 
	 * @return true si Mpivavaka a déjà été Diakona même si pour le TaomPanompoana courant elle ne l'est plus
	 */
	public boolean efaDiakona(){
		return fDiakonas.size() > 0;
	}
	
	/**
	 * 
	 * @param date
	 * @return true , si Mpivavaka est Diakona pour le TaomPanompoana courant
	 */
	public boolean isDiakona(Date date){
		boolean ret = false;
		if (date != null){
			for (Diakona diakona : fDiakonas){
				TaomPanompoana taomPanompoana = diakona.getTaomPanompoana();
				
				ret = taomPanompoana.getDatyManomboka().getTime() <= date.getTime() && date.getTime() <= taomPanompoana.getDatyMamarana().getTime();
				
				if (ret)
					break;
			}
		}
		return ret;
	}
	
	/**
	 * 
	 * @param date
	 * @return true si le mpivavaka est elligible diakona ie si il peut se porter candidat à une election diakona
	 * - Mpandray depuis 5 ans
	 * - Agé au moins de 25 ans
	 */
	public boolean isElligibleDiakona(Date date){
		Date dateMoins5Ans = Utils.getDateMoins5Ans(date);
		boolean ret = isMpandrayFrom(dateMoins5Ans);

		if (ret)
			ret = isOlderThan25Years(date);
		
		return ret;
	}

	/**
	 * 
	 * @param date
	 * @return true si Mpivavaka est plus vieux de 25 ans
	 */
	public boolean isOlderThan25Years(Date date){
		boolean ret = false;
		if (getDatyTeraka() != null)
			ret = date.getTime() - getDatyTeraka().getTime() >= Utils.get25AnsDuration();
		
		return ret;
		
	}
	
	/**
	 * 
	 * @param date
	 * @return ireo Sampana na Asa misy ny mpivavaka t@ taona voatondro
	 */
	public Map<SampanAsa, Andraikitra> getSampanAsaMpikambana(Date date){
		Map<SampanAsa, Andraikitra> ret = new HashMap<SampanAsa, Andraikitra>();
		if (date != null){
			for (Mpikambana mpikambana : fMpikambanas){
				TaomPanompoana taomPanompoana = mpikambana.getTaomPanompoana();
				if (taomPanompoana.getDatyManomboka().getTime() <= date.getTime() && date.getTime() <= taomPanompoana.getDatyMamarana().getTime()){
					ret.put(mpikambana.getSampanAsa(), mpikambana.getAndraikitra());
				}
			}
		}
		return ret;
	}
	
	/**
	 * 
	 * @param sampanAsa
	 * @param date
	 * @return Andraikitry ny mpivavaka ao amin'ny sampana t@ taona voatondro
	 */
	public Andraikitra getAndraikitraSampana(SampanAsa sampanAsa, Date date){
		Andraikitra ret = null;
		if (date != null && sampanAsa != null){
			Map<SampanAsa, Andraikitra> mapSampanaAndraikitra = getSampanAsaMpikambana(date);
			if (mapSampanaAndraikitra.size() > 0){
				for (SampanAsa current : mapSampanaAndraikitra.keySet()){
					if (current.equals(sampanAsa)){
						ret = mapSampanaAndraikitra.get(sampanAsa);
						break;
					}
				}
			}
		}
		return ret;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (fId == null)
			return false;
		if(!(o instanceof Mpivavaka))
			return false;
		Mpivavaka other = (Mpivavaka)o;
		
		return fId.equals(other.fId);
	}

	@Override
	public int hashCode() {
		return fId != null ? fId.hashCode() : -1;
	}

}
