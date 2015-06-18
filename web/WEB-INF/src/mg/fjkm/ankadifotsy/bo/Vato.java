/**
 * 
 */
package mg.fjkm.ankadifotsy.bo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * @author Rija
 * Bulletin de vote 
 */
public class Vato extends SaveableEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String fVatoLaharana;
	
	private String fSafidy; //Les numéros des candidats sélectionnés dans ce bulletin séparés par un ;

	private Fifidianana fFifidianana;
	
	private Boolean fLehilahy;
	
	private String fIp;
	
	public String getVatoLaharana() {
		return fVatoLaharana;
	}

	public void setVatoLaharana(String vatoLaharana) {
		this.fVatoLaharana = vatoLaharana;
	}

	protected String getSafidy() {
		return fSafidy;
	}

	protected void setSafidy(String safidy) {
		this.fSafidy = safidy;
	}

	public Fifidianana getFifidianana() {
		return fFifidianana;
	}

	public void setFifidianana(Fifidianana fifidianana) {
		this.fFifidianana = fifidianana;
	}

	public Boolean getLehilahy() {
		return fLehilahy;
	}

	public void setLehilahy(Boolean lehilahy) {
		fLehilahy = lehilahy;
	}

	public String getIp() {
		return fIp;
	}

	public void setIp(String ip) {
		fIp = ip;
	}

	public void setSafidy(Set<Long> mirotsakaFidianaIds){
		if (mirotsakaFidianaIds != null){
			StringBuffer sb = new StringBuffer();
			boolean first = true;
			if (mirotsakaFidianaIds.size()>0){
				for (Long mirotsakaId : mirotsakaFidianaIds){
					if (!first)
						sb.append(';');
					sb.append(mirotsakaId);
					first = false;
				}
				fSafidy = sb.toString();
			}
			else
				fSafidy = null;
		}
		else
			fSafidy = null;
	}
	
	public Set<Long> getSafidys(){
		Set<Long> ret = new HashSet<Long>();
		if (fSafidy != null && !"".equals(fSafidy.trim())){
			StringTokenizer st = new StringTokenizer(fSafidy, ";");
			while (st.hasMoreTokens())
				ret.add(Long.parseLong(st.nextToken()));
		}
		return ret;
	}
	
	public boolean isVatoFotsy(){
		return getSafidys().size() == 0;
	}
	
	public boolean isVatoMaty(){
		boolean ret = fFifidianana.getIsaOlonaFidiana().intValue() < getSafidys().size();
		return ret;
	}
	
	protected void setVatoMaty (boolean vm){
		//Pour hibernate afin de pouvoir persister l'état du Vato ppour pouvoir faire des requêtes SQL dessus
	}
}
