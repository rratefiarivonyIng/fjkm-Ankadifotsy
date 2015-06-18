/**
 * 
 */
package mg.fjkm.ankadifotsy.bo;

import java.io.Serializable;

/**
 * classe récapitulant le vote
 * @author Rija
 *
 */
public class FanisamBato implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long fId = null;
	
	private Fifidianana fFifidianana = null;
	
	/**
	 * Isan'ny vato voaisa (bulletin de vote comptabilisé) 
	 */
	private long fIsamBatoVoaisa = 0;
	
	private long fIsamBatoFotsy = 0;
	
	private long fIsamBatoMaty = 0;

	private Boolean fLehilahy = null;	//si null = fanisambato mitambatra ny lehilahy sy ny vehivavy, si true = fanisambato lehilahy, si false = fanisambato vehivavy

	protected FanisamBato(){
	}
	
	public FanisamBato(Fifidianana fifidianana){
		fFifidianana = fifidianana;
	}

	public Long getId() {
		return fId;
	}

	protected void setId(Long id) {
		fId = id;
	}

	public long getIsamBatoFotsy() {
		return fIsamBatoFotsy;
	}

	protected void setIsamBatoFotsy(long isamBatoFotsy) {
		fIsamBatoFotsy = isamBatoFotsy;
	}

	public void incrementIsamBatoFotsy(){
		fIsamBatoFotsy ++;
	}
	
	public long getIsamBatoMaty() {
		return fIsamBatoMaty;
	}

	protected void setIsamBatoMaty(long isamBatoMaty) {
		fIsamBatoMaty = isamBatoMaty;
	}

	public void incrementIsamBatoMaty(){
		fIsamBatoMaty ++;
	}
	
	public void decrementIsamBatoMaty(){
		fIsamBatoMaty --;
		decrementIsamBatoVoaisa();
	}
	
	public void decrementIsamBatoFotsy(){
		fIsamBatoFotsy --;
		decrementIsamBatoVoaisa();
	}
	
	public long getIsamBatoVoaisa() {
		return fIsamBatoVoaisa;
	}

	protected void setIsamBatoVoaisa(long isamBatoNirotsaka) {
		fIsamBatoVoaisa = isamBatoNirotsaka;
	}

	public void incrementIsamBatoVoaisa(){
		fIsamBatoVoaisa ++;
	}
	
	public void decrementIsamBatoVoaisa(){
		fIsamBatoVoaisa --;
	}
	
	public Fifidianana getFifidianana() {
		return fFifidianana;
	}
	
	protected void setFifidianana(Fifidianana fifidianana){
		fFifidianana = fifidianana;
	}
	
	public long getIsamBatoManankery(){
		return getIsamBatoVoaisa() - getIsamBatoFotsy() - getIsamBatoMaty();
	}

	public Boolean getLehilahy() {
		return fLehilahy;
	}

	public void setLehilahy(Boolean lehilahy) {
		fLehilahy = lehilahy;
	}
		
}
