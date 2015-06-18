/**
 * 
 */
package mg.fjkm.ankadifotsy.form;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Validation du formulaire d'attribution de mot de passe
 * @author rija
 * @version 1.0
 */
public class FormMotDePasseValidator implements Validator {

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	public boolean supports(Class clazz) {
		return clazz.isAssignableFrom(FormMotDePasse.class);
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	public void validate(Object command, Errors errors) {
		FormMotDePasse formulaire = (FormMotDePasse)command;
		
		if (formulaire.getLogin() == null || "".equals(formulaire.getLogin().trim()))
			errors.rejectValue("login", "error.not-specified", null, "Tsy maintsy fenoina");

		if (formulaire.getPassword() == null || "".equals(formulaire.getPassword().trim()))
			errors.rejectValue("password", "error.not-specified", null, "Tsy maintsy fenoina");
		
		if (formulaire.getOldPassword() == null || "".equals(formulaire.getOldPassword().trim()))
			errors.rejectValue("oldPassword", "error.not-specified", null, "Tsy maintsy fenoina");
		
		if (formulaire.getConfirmation() == null || "".equals(formulaire.getConfirmation().trim()))
			errors.rejectValue("confirmation", "error.not-specified", null, "Tsy maintsy fenoina");
		else{
			if (!formulaire.getConfirmation().equals(formulaire.getPassword()))
				errors.rejectValue("confirmation", "error.not-equal", null, "Tsy mitovy.");
		}
	}

}
