package mg.fjkm.ankadifotsy.form;

import mg.fjkm.ankadifotsy.bo.Parameter;
import mg.fjkm.ankadifotsy.bo.User;

/**
 * Formulaire de saisi d'un paramètre d'un utilisateur (User) du système
 * @author Rija RATEFIARIVONY
 *
 */
public class FormParameter {
	public static final String sfFORM_ID = "formParameter";

	private Parameter fParameter = null;
			
	/**
	 * Indique si l'édition a été lancée depuis les résultats de recherche
	 */
	private boolean fFromSearch = false;
	
	protected FormParameter(){
		
	}
	
	public FormParameter(Parameter parameter){
		if (parameter == null)
			throw new IllegalArgumentException();
		
		fParameter = parameter;
	}

	public boolean isFromSearch() {
		return fFromSearch;
	}

	public void setFromSearch(boolean fromSearch) {
		fFromSearch = fromSearch;
	}

	public Parameter getParameter() {
		return fParameter;
	}

	public Integer getNbElementPerPage() {
		return fParameter.getNbElementPerPage();
	}

	public Integer getNbMirotsakaFidianaPerPage() {
		return fParameter.getNbMirotsakaFidianaPerPage();
	}

	public Integer getNbTempResultVote() {
		return fParameter.getNbTempResultVote();
	}

	public User getUser() {
		return fParameter.getUser();
	}

	public void setNbElementPerPage(Integer nbElementPerPage) {
		fParameter.setNbElementPerPage(nbElementPerPage);
	}

	public void setNbMirotsakaFidianaPerPage(Integer nbMirotsakaFidianaPerPage) {
		fParameter.setNbMirotsakaFidianaPerPage(nbMirotsakaFidianaPerPage);
	}

	public void setNbTempResultVote(Integer nbTempResultVote) {
		fParameter.setNbTempResultVote(nbTempResultVote);
	}

	public void setUser(User user) {
		fParameter.setUser(user);
	}

	
}
