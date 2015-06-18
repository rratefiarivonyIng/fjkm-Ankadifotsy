/**
 * 
 */
package mg.fjkm.ankadifotsy.form;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Classe de validation des informations saisies sur les paramètres d'un utilisateur du système
 * @author Rija RATEFIARIVONY
 */
public class FormParameterValidator implements Validator {

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	public boolean supports(Class clazz) {
		return clazz.isAssignableFrom(FormParameter.class);
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	public void validate(Object command, Errors errors) {
		FormParameter formParameter = (FormParameter)command;
		if (formParameter.getNbElementPerPage() == null)
			errors.rejectValue("nbElementPerPage", "error.not-specified", null, "tsy maintsy fenoina");
				
		if (formParameter.getNbMirotsakaFidianaPerPage() == null )
			errors.rejectValue("nbMirotsakaFidianaPerPage", "error.not-specified", null, "tsy maintsy fenoina");
		
		if (formParameter.getNbTempResultVote() == null)
			errors.rejectValue("nbTempResultVote", "error.not-specified", null, "tsy maintsy fenoina");
	}

}
