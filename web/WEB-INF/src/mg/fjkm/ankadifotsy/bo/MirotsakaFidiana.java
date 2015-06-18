/**
 * 
 */
package mg.fjkm.ankadifotsy.bo;

import java.util.Date;

/**
 * Classe pour les candidatures � une �lection
 * @author Rija
 *
 */
public class MirotsakaFidiana extends SaveableEntity implements ILabelable {

	private static final long serialVersionUID = 1L;

	/**
	 * Le num�ro du candidat pour le scrutin (choix des �lecteurs) et pour la d�compte de voix
	 * Ce champs est uniquement renseign� quand la candidature est valid�e
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
	 * si null alors demande de candidature non encore trait�e
	 * si true alors la candidature est accept�e
	 */
	private Boolean fEkenaFirotsahana = null;

	/**
	 * Fanazavana fanampiny (oh : antony nand�vana ny Mpirotsaka)
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
