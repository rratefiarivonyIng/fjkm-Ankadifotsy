/**
 * 
 */
package mg.fjkm.ankadifotsy.form;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author Rija
 *
 */
public class FileUploadValidator implements Validator {

	@SuppressWarnings("unchecked")
	public boolean supports(Class clazz) {
		return FormUploadPhoto.class.isAssignableFrom(clazz);
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	public void validate(Object command, Errors errors) {
		FormUploadPhoto form = (FormUploadPhoto)command;
		 
		if (form.isSubmitted() && form.getFile().getSize()==0)
			errors.rejectValue("file", "tsy maintsy fenoina.");
	}
}
