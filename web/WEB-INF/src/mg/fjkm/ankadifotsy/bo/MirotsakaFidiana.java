/**
 * 
 */
package mg.fjkm.ankadifotsy.bo;

import java.util.Date;

/**
 * Classe pour les candidatures à une élection
 * @author Rija
 *
 */
public class MirotsakaFidiana extends SaveableEntity implements ILabelable {

	private static final long serialVersionUID = 1L;

	/**
	 * Le numéro du candidat pour le scrutin (choix des électeurs) et pour la décompte de voix
	 * Ce champs est uniquement renseigné quand la candidature est validée
	 */
	private Integer fLaharanaMpirotsaka = null;
	
	/**
	 * Le mpivavaka qui se porte candidat
	 */
	private Mpivavaka fMpivavaka = null;
	
	/**
	 * Le Fifidianana sur laquelle porte la candidature du Mpivavaka
	 */
	private Fifidianana fFifidianana = null;
	
	private Date fDatyNirotsahana = null;
	
	/**
	 * Isan'ny vato azo
	 */
	private Long fIsamBato = 0L;
	
	/**
	 * si null alors demande de candidature non encore traitée
	 * si true alors la candidature est acceptée
	 */
	private Boolean fEkenaFirotsahana = null;

	/**
	 * Fanazavana fanampiny (oh : antony nandàvana ny Mpirotsaka)
	 */
	private String fFanamarihana = null;
	
	protected MirotsakaFidiana(){
		
	}
	
	public MirotsakaFidiana(Mpivavaka mpivavaka, Fifidianana fifidianana, Date nirotsahana){
		assert mpivavaka  != null && fifidianana != null && nirotsahana != null && nirotsahana != null;
		fMpivavaka = mpivavaka;
		fFifidianana = fifidianana;
		fDatyNirotsahana = nirotsahana;
	}
	
	/* (non-Javadoc)
	 * @see mg.fjkm.ankadifotsy.bo.ILabelable#getLabel()
	 */
	public String getLabel() {
		if (fMpivavaka != null)
			return fMpivavaka.getAnarana()+" "+fMpivavaka.getFanampiny();
		
		return null;
	}

	public Date getDatyNirotsahana() {
		return fDatyNirotsahana;
	}

	public void setDatyNirotsahana(Date datyNirotsahana) {
		fDatyNirotsahana = datyNirotsahana;
	}

	public Boolean isEkenaFirotsahana() {
		return fEkenaFirotsahana;
	}

	public void setEkenaFirotsahana(Boolean ekenaFirotsahana) {
		fEkenaFirotsahana = ekenaFirotsahana;
	}

	public Long getIsamBato() {
		return fIsamBato;
	}

	protected void setIsamBato(Long isamBato) {
		fIsamBato = isamBato;
	}

	public void incrementIsamBato(){
		fIsamBato = fIsamBato + 1;
	}
	
	public void decrementIsamBato(){
		fIsamBato = fIsamBato - 1;
	}
	
	public Integer getLaharanaMpirotsaka() {
		return fLaharanaMpirotsaka;
	}

	public void setLaharanaMpirotsaka(Integer laharanaMpirotsaka) {
		fLaharanaMpirotsaka = laharanaMpirotsaka;
	}

	public Fifidianana getFifidianana() {
		return fFifidianana;
	}

	public void setFifidianana(Fifidianana fifidianana){
		fFifidianana = fifidianana;
	}
	
	public Mpivavaka getMpivavaka() {
		return fMpivavaka;
	}
	
	public void setMpivavaka(Mpivavaka mpivavaka){
		fMpivavaka = mpivavaka;
	}

	public String getFanamarihana() {
		return fFanamarihana;
	}

	public void setFanamarihana(String fanamarihana) {
		fFanamarihana = fanamarihana;
	}

}
