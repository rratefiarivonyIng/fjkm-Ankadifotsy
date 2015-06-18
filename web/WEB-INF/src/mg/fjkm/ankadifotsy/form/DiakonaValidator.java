/**
 * 
 */
package mg.fjkm.ankadifotsy.form;

import mg.fjkm.ankadifotsy.service.FjkmAnkadifotsyService;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Classe de validation des informations saisies sur un Diakona
 * @author Rija RATEFIARIVONY
 */
public class DiakonaValidator implements Validator {

	@SuppressWarnings("unused")
	private FjkmAnkadifotsyService fFjkmAnkadifotsyService = null;
	
	/**
	 * @param fjkmAnkadifotsyService the fFjkmAnkadifotsyService to set
	 */
	public void setFjkmAnkadifotsyService(FjkmAnkadifotsyService fjkmAnkadifotsyService) {
		fFjkmAnkadifotsyService = fjkmAnkadifotsyService;
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	public boolean supports(Class clazz) {
		return clazz.isAssignableFrom(FormDiakona.class);
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	public void validate(Object command, Errors errors) {
		FormDiakona formDiakona = (FormDiakona)command;
		if (formDiakona != null){
			
		}
		//if (formChristian.getLaharana() == null || formChristian.getLaharana().trim().equals(""))
		//	errors.rejectValue("laharana", "error.not-specified", null, "tsy maintsy fenoina");		
	}

}
