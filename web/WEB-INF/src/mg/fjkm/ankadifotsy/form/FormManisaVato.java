/**
 * 
 */
package mg.fjkm.ankadifotsy.form;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import mg.fjkm.ankadifotsy.bo.FanisamBato;

/**
 * Formulaire pour le scrutin
 * @author Rija
 *
 */
public class FormManisaVato {
	public static final String sfFORM_ID = "formManisaVato";
	
	private Boolean fVatoFotsy = false;
	private Boolean fVatoMaty = false;
	private FanisamBato fFanisamBato = null;
	//private List<MirotsakaFidiana> fMirotsakaFidianas = null;
	private List<Map<String, Object>> fMirotsakaFidianas = null;
	
	/**
	 * collection des ids des candidats qui ont eu des voix dans la décompte précédente
	 */
	private Set<Long>fMirotsakaFidianaIdsMiverina = null;
	
	private String miverinaVatoTeoAloha = null;
	
	private String fVatoLaharana = null;
	
	private boolean fFamerenana = false;

	private Map<String, Long> fStats = new HashMap<String, Long>();
	
	private Long dtime = 1L;
	
	public FormManisaVato(){
	}

//	public List<MirotsakaFidiana> getMirotsakaFidianas() {
//		return fMirotsakaFidianas;
//	}
//
//	public void setMirotsakaFidianas(List<MirotsakaFidiana> mirotsakaFidianas) {
//		fMirotsakaFidianas = mirotsakaFidianas;
//	}

	public List<Map<String, Object>> getMirotsakaFidianas() {
		return fMirotsakaFidianas;
	}

	public void setMirotsakaFidianas(List<Map<String, Object>> mirotsakaFidianas) {
		fMirotsakaFidianas = mirotsakaFidianas;
	}

	/**
	 * 
	 * @param mirotsakaFidianaId
	 * @return true si l'id du candidat a obtenu une voix dans le comptage précédent
	 */
	public boolean isMirotsakaFidianaVoafidy(Long mirotsakaFidianaId){
		boolean ret = false;
		if (mirotsakaFidianaId != null && fMirotsakaFidianaIdsMiverina != null)
			ret = fMirotsakaFidianaIdsMiverina.contains(mirotsakaFidianaId);
		
		return ret;
	}
	
	public Set<Long> getMirotsakaFidianaIdsMiverina() {
		return fMirotsakaFidianaIdsMiverina;
	}

	public void setMirotsakaFidianaIdsMiverina(Set<Long> mirotsakaFidianaIdsMiverina) {
		fMirotsakaFidianaIdsMiverina = mirotsakaFidianaIdsMiverina;
	}

	public boolean isVatoFotsy() {
		return fVatoFotsy;
	}

	public void setVatoFotsy(boolean vatoFotsy) {
		fVatoFotsy = vatoFotsy;
	}

	public boolean isVatoMaty() {
		return fVatoMaty;
	}

	public void setVatoMaty(boolean vatoMaty) {
		fVatoMaty = vatoMaty;
	}
	
	public void setFanisamBato(FanisamBato fanisamBato){
		fFanisamBato = fanisamBato;
	}
	
	public FanisamBato getFanisamBato(){
		return fFanisamBato;
	}
	
	public long getIsaVatoVoaisa(){
		long ret = 0;
		if (fFanisamBato != null)
			ret = fFanisamBato.getIsamBatoVoaisa();
		return ret;
	}
	
	public long getIsaVatoMaty(){
		long ret = 0;
		if (fFanisamBato != null)
			ret = fFanisamBato.getIsamBatoMaty();
		return ret;
	}
	
	public long getIsaVatoFotsy(){
		long ret = 0;
		if (fFanisamBato != null)
			ret = fFanisamBato.getIsamBatoFotsy();
		return ret;
	}

	public long getIsaVatoManankery(){
		long ret = 0;
		if (fFanisamBato != null)
			ret = fFanisamBato.getIsamBatoManankery();
		return ret;
	}

	public Boolean getLehilahy() {
		return fFanisamBato.getLehilahy();
	}

	public void setLehilahy(Boolean lehilahy) {
		fFanisamBato.setLehilahy(lehilahy);
	}

	public String getMiverinaVatoTeoAloha() {
		return miverinaVatoTeoAloha;
	}

	public void resetMiverinaVatoTeoAloha(){
		miverinaVatoTeoAloha = null;
	}
	
	public void setDisabledMiverinaVatoTeoAloha(){
		miverinaVatoTeoAloha = "disabled=\"disabled\"";
	}

	public String getVatoLaharana() {
		return fVatoLaharana;
	}

	public void setVatoLaharana(String vatoLaharana) {
		this.fVatoLaharana = vatoLaharana;
	}

	public boolean isFamerenana() {
		return fFamerenana;
	}

	public void setFamerenana(boolean famerenana) {
		fFamerenana = famerenana;
	}

	public void setIPStats(Map<String, Long> stats){
		if (stats != null){
			fStats = stats;
		}
	}
	
	public long getIsaVatoVoaisaIP(){
		return fStats.get("isaVatoVoaisa");
	}
	
	public long getIsaVatoFotsyIP(){
		return fStats.get("isaVatoFotsy");
	}
	
	public long getIsaVatoManankeryIP(){
		return fStats.get("isaVatoManankery");
	}
	
	public long getIsaVatoMatyIP(){
		return fStats.get("isaVatoMaty");
	}

	public Long getDtime() {
		return dtime;
	}

	public void setDtime(Long dtime) {
		this.dtime = dtime;
	}
	
}
