package mg.fjkm.ankadifotsy.print;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PrintAttestation extends Printer {

	/**
	 * $P{raisonSociale}
	 */
	private String fRaisonSociale;

	/**
	 * $P{nomCommercial}
	 */
	private String fNomCommercial;

	/**
	 * $P{siegeSocial}
	 */
	private String fSiegeSocial;

	/**
	 * $P{date}
	 */
	private Date fDate = null;

	/**
	 * 
	 */
	private Long fIdFiscale ;

	private Integer fNumero ;
	
	public PrintAttestation(String fileName) {
		super(fileName);
	}

	@Override
	public void loadParametres() {
		fRaisonSociale = fRaisonSociale != null ? fRaisonSociale : "";
		getParametres().put("raisonSociale",fRaisonSociale);
		fNomCommercial = fNomCommercial != null ? fNomCommercial : "";
		getParametres().put("nomCommercial",fNomCommercial);
		fSiegeSocial = fSiegeSocial != null ? fSiegeSocial : "";
		getParametres().put("siegeSocial",fSiegeSocial);
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = fDate != null ? format.format(fDate) : "";
		getParametres().put("date",strDate);
		String strNumero = fNumero != null ? " N° " + fNumero : "N°   ";
		getParametres().put("numero",strNumero);
		//$P{id}
		String id = "NG. CD " + strNumero + " - IN - 2006 - [1971-06]";	
		getParametres().put("id",id);
		
		//Id fiscale
		getParametres().put("idFiscale1", getIdFiscal(fIdFiscale,0));
		getParametres().put("idFiscale2", getIdFiscal(fIdFiscale,1));
		getParametres().put("idFiscale3", getIdFiscal(fIdFiscale,2));
		getParametres().put("idFiscale4", getIdFiscal(fIdFiscale,3));
		getParametres().put("idFiscale5", getIdFiscal(fIdFiscale,4));
		getParametres().put("idFiscale6", getIdFiscal(fIdFiscale,5));
		getParametres().put("idFiscale7", getIdFiscal(fIdFiscale,6));
		getParametres().put("idFiscale8", getIdFiscal(fIdFiscale,7));
		getParametres().put("idFiscale9", getIdFiscal(fIdFiscale,8));
		getParametres().put("idFiscale10",getIdFiscal(fIdFiscale,9));
	}

	/**
	 * 
	 * @param id
	 * @param pos
	 * @return
	 */
	private static String getIdFiscal(Long id,int pos){
		if(id == null)
			return "";
		String longAsText = "" + id;
		if((longAsText.length() - 1) < 9  ){
			String temp = "";
			int val = 9 - (longAsText.length() -1 );
			for (int i= 0;i<val;i++){
				temp += "0";
			}
			temp += longAsText;
			longAsText = temp;
		}
		if(pos >= 0 && pos <= longAsText.length() - 1 ){
			return "" + longAsText.charAt(pos);	
		}
		return "";
	}
	
	@Override
	public void loadData() {

	}

	public Date getDate() {
		return fDate;
	}

	public void setDate(Date date) {
		fDate = date;
	}

	public String getNomCommercial() {
		return fNomCommercial;
	}


	public void setNomCommercial(String nomCommercial) {
		fNomCommercial = nomCommercial;
	}


	public String getRaisonSociale() {
		return fRaisonSociale;
	}

	public void setRaisonSociale(String raisonSociale) {
		fRaisonSociale = raisonSociale;
	}

	public String getSiegeSocial() {
		return fSiegeSocial;
	}

	public void setSiegeSocial(String siegeSocial) {
		fSiegeSocial = siegeSocial;
	}

	public Integer getNumero() {
		return fNumero;
	}

	public void setNumero(Integer numero) {
		fNumero = numero;
	}

	public Long getIdFiscale() {
		return fIdFiscale;
	}

	public void setIdFiscale(Long idFiscale) {
		fIdFiscale = idFiscale;
	}

}

