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
public class Parameter implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long fId = null;
	
	private User fUser = null;
	
	private Integer fNbElementPerPage = 5;
	
	private Integer fNbMirotsakaFidianaPerPage = 8;
	
	private Integer fNbTempResultVote = 10;
	

	protected Parameter(){
	}
	
	public Parameter(User user){
		fUser = user;
	}

	public Long getId() {
		return fId;
	}

	protected void setId(Long id) {
		fId = id;
	}

	public User getUser() {
		return fUser;
	}

	public void setUser(User user) {
		fUser = user;
	}

	public Integer getNbElementPerPage() {
		return fNbElementPerPage;
	}

	public void setNbElementPerPage(Integer nbElementPerPage) {
		fNbElementPerPage = nbElementPerPage;
	}

	public Integer getNbMirotsakaFidianaPerPage() {
		return fNbMirotsakaFidianaPerPage;
	}

	public void setNbMirotsakaFidianaPerPage(Integer nbMirotsakaFidianaPerPage) {
		fNbMirotsakaFidianaPerPage = nbMirotsakaFidianaPerPage;
	}

	public Integer getNbTempResultVote() {
		return fNbTempResultVote;
	}

	public void setNbTempResultVote(Integer nbTempResultVote) {
		fNbTempResultVote = nbTempResultVote;
	}

}
