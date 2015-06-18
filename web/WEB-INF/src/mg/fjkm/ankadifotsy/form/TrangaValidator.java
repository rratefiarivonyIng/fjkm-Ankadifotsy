/**
 * 
 */
package mg.fjkm.ankadifotsy.form;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Classe de validation des informations saisies sur un événement Batisa
 * @author Rija RATEFIARIVONY
 */
public class TrangaValidator implements Validator {
	
	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	public boolean supports(Class clazz) {
		return clazz.isAssignableFrom(FormTranga.class);
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	public void validate(Object command, Errors errors) {
		FormTranga formBatisa = (FormTranga)command;
		if (formBatisa != null){
			//if (formBatisa.getLaharana() == null || "".equals(formBatisa.getLaharana().trim()))
			//	errors.rejectValue("laharanaTranga", "error.not-specified", null, "tsy maintsy fenoina");

			if (formBatisa.getDaty() == null)
				errors.rejectValue("daty", "error.not-specified", null, "tsy maintsy fenoina");
			
			if (formBatisa.getFitandremana() == null)
				errors.rejectValue("fitandremana", "error.not-specified", null, "tsy maintsy fenoina");
		}
	}

}
