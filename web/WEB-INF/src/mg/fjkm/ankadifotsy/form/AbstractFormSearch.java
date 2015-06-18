/**
 * 
 */
package mg.fjkm.ankadifotsy.form;

/**
 * Formulaire de recherche abstraite avec résultat.
 * Gestion de la pagination
 * @author Rija
 *
 */
public abstract class AbstractFormSearch {
	private int fPageNo = 1;
	private Long nbElementsPerPage = null;
	private Integer fNextPageNo = null;
	private Integer fPreviousPageNo = null;
	private Long fNbInstances = null;
	private int fNbPageTotal = 0;

	protected AbstractFormSearch(){
		
	}
	
	public abstract String getFormID();
	
	//------------- Gestion de la pagination des résultats de recherche
	/**
	 * @return the fPageNo
	 */
	public int getPageNo() {
		return fPageNo;
	}

	/**
	 * @param pageNo the fPageNo to set
	 */
	public void setPageNo(int pageNo) {
		fPageNo = pageNo;
	}

	public int getNbPageTotal() {
		return fNbPageTotal;
	}

	public void setNbPageTotal(int nbPageTotal) {
		fNbPageTotal = nbPageTotal;
	}

	public Integer getNextPageNo() {
		return fNextPageNo;
	}

	public void setNextPageNo(Integer nextPageNo) {
		fNextPageNo = nextPageNo;
	}

	public Integer getPreviousPageNo() {
		return fPreviousPageNo;
	}

	public void setPreviousPageNo(Integer previousPageNo) {
		fPreviousPageNo = previousPageNo;
	}

	public void setNbElementsPerPage(Long nb){
		nbElementsPerPage = nb;
	}

	public void setNbInstances(Long nb){
		fNbInstances = nb;
	}
	
	/**
	 * Renvoie true s'il existe une page suivante
	 * @return
	 */
	public boolean hasNextPage(){
		boolean ret = false;
		if (nbElementsPerPage != null){
			ret = (new Long(fPageNo) + 1) * nbElementsPerPage.longValue() < fNbInstances;
		}
		return ret;
	}
	//-------------------------------------------------------
	
	/**
	 * Renvoie true s'il existe une page précédente
	 * @return
	 */
	public boolean hasPreviousPage(){
		boolean ret = new Long(fPageNo) >= 1L;
		return ret;
	}

}
