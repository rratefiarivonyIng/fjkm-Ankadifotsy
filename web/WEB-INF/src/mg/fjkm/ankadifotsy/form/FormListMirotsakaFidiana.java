package mg.fjkm.ankadifotsy.form;


/**
 * Formulaire pour l'affichage de la liste des MirotsakaFidiana (candidatures
 * @author Rija RATEFIARIVONY
 *
 */
public class FormListMirotsakaFidiana extends AbstractFormSearch{
	public static final String sfFORM_ID = "formListMirotsakaFidiana";

	private static final String sfTitleMpirotsakaRehetra = "Lisitry ny mpirotsaka ho fidiana";
	private static final String sfTitleMpirotsakaEkena = "Lisitry ny mpirotsaka efa nekena";
	private static final String sfTitleMpirotsakaLavina = "Lisitry ny mpirotsaka efa nolavina";

	private Long fFifidiananaId = null;
	private boolean fAllMirotsakaFidiana = true;
	private Boolean fEkenaFirotsahana = null;
	private Boolean fLehilahy = null;
	private boolean fSubmit = false;
	private String fTitle = sfTitleMpirotsakaRehetra;
	private boolean fHaveAllMirotsakaFidianaEkenaLaharana = true; 
		
	/**
	 * l'appel à la recherche est effectué depuis ?
	 */
	private String fFrom = null;
	
	public FormListMirotsakaFidiana(Long fifidiananaId){
		if (fifidiananaId == null)
			throw new IllegalArgumentException();
		fFifidiananaId = fifidiananaId;
	}
	
	//--------------------------------------------------
	public boolean isAllMirotsakaFidiana() {
		return fAllMirotsakaFidiana;
	}

	public void setAllMirotsakaFidiana(boolean allMirotsakaFidiana) {
		fAllMirotsakaFidiana = allMirotsakaFidiana;
		if (fAllMirotsakaFidiana)
			setTitle(sfTitleMpirotsakaRehetra);
	}

	public Boolean getEkenaFirotsahana() {
		return fEkenaFirotsahana;
	}

	public void setEkenaFirotsahana(Boolean ekenaFirotsahana) {
		fEkenaFirotsahana = ekenaFirotsahana;
		if (!fAllMirotsakaFidiana){
			if (fEkenaFirotsahana != null){
				if (fEkenaFirotsahana.booleanValue()){
					setTitle(sfTitleMpirotsakaEkena);
				}
				else{
					setTitle(sfTitleMpirotsakaLavina);
				}
			}
		}
	}

	public Boolean getLehilahy() {
		return fLehilahy;
	}

	public void setLehilahy(Boolean lehilahy) {
		fLehilahy = lehilahy;
	}

	public Long getFifidiananaId() {
		return fFifidiananaId;
	}

	public void setFifidiananaId(Long fifidiananaId) {
		fFifidiananaId = fifidiananaId;
	}

	public String getTitle() {
		return fTitle;
	}

	public void setTitle(String title) {
		fTitle = title;
	}
	

	public boolean isHaveAllMirotsakaFidianaEkenaLaharana() {
		return fHaveAllMirotsakaFidianaEkenaLaharana;
	}

	public void setHaveAllMirotsakaFidianaEkenaLaharana( boolean ffHaveAllMirotsakaFidianaEkenaLaharana) {
		this.fHaveAllMirotsakaFidianaEkenaLaharana = ffHaveAllMirotsakaFidianaEkenaLaharana;
	}
	
	//--------------------------------------------------


	public String getFrom() {
		return fFrom;
	}

	public void setFrom(String from) {
		fFrom = from;
	}

	public boolean isSubmit() {
		return fSubmit;
	}

	public void setSubmit(boolean submit) {
		fSubmit = submit;
	}

	@Override
	public String getFormID() {
		return sfFORM_ID;
	}

}
