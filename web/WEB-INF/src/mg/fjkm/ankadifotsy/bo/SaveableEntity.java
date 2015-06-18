/**
 * 
 */
package mg.fjkm.ankadifotsy.bo;

import java.io.Serializable;
import java.util.Date;

/**
 * Classe à faire hériter par les classes persistées et qui doivent
 * gérer les informations de création et de modification
 * NOTE : actuellement, ce sont les dates de création, l'utilisateur créateur et la date de dernière modification
 * et l'utilisateur ayant effectué la dernière modification sont tracées
 * @author Rija
 *
 */
public class SaveableEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	protected Long fId = null;
	private Date fDateCreation = null;
	private User fUserCreator = null;
	private Date fDateLastModification = null;
	private User fUserLastModification = null;
	
	protected SaveableEntity(){
	}

	/**
	 * @return the fId
	 */
	public Long getId() {
		return fId;
	}

	/**
	 * @param id the fId to set
	 */
	public void setId(Long id) {
		fId = id;
	}

	/**
	 * @return the fDateCreation
	 */
	public Date getDateCreation() {
		return fDateCreation;
	}

	/**
	 * @param dateCreation the fDateCreation to set
	 */
	private void setDateCreation(Date dateCreation) {
		fDateCreation = dateCreation;
	}

	/**
	 * @return the fDateLastModification
	 */
	public Date getDateLastModification() {
		return fDateLastModification;
	}

	/**
	 * @param dateLastModification the fDateLastModification to set
	 */
	private void setDateLastModification(Date dateLastModification) {
		fDateLastModification = dateLastModification;
	}

	/**
	 * @return the fUserCreator
	 */
	public User getUserCreator() {
		return fUserCreator;
	}

	/**
	 * @param userCreator the fUserCreator to set
	 */
	private void setUserCreator(User userCreator) {
		fUserCreator = userCreator;
	}

	/**
	 * @return the fUserLastModification
	 */
	public User getUserLastModification() {
		return fUserLastModification;
	}

	/**
	 * @param userLastModification the fUserLastModification to set
	 */
	private void setUserLastModification(User userLastModification) {
		fUserLastModification = userLastModification;
	}
	
	public void setCreateInfo(Date date, User creator){
		if (date == null || creator == null)
			throw new IllegalArgumentException();
		
		setDateCreation(date);
		setUserCreator(creator);
	}
	
	public void setModificationInfo(Date date, User modifier){
		if (date == null || modifier == null)
			throw new IllegalArgumentException();
		
		setDateLastModification(date);
		setUserLastModification(modifier);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((fId == null) ? 0 : fId.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final SaveableEntity other = (SaveableEntity) obj;
		if (fId == null) {
			if (other.fId != null)
				return false;
		} else if (!fId.equals(other.fId))
			return false;
		return true;
	}
		
}
