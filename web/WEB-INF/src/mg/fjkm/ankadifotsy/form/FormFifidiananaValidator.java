/**
 * 
 */
package mg.fjkm.ankadifotsy.form;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Classe de validation des informations sur le Fifidianana 
 * @author Rija RATEFIARIVONY
 */
public class FormFifidiananaValidator implements Validator {

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	public boolean supports(Class clazz) {
		return clazz.isAssignableFrom(FormFifidianana.class);
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	public void validate(Object command, Errors errors) {
		FormFifidianana formFifidianana = (FormFifidianana)command;
		if (formFifidianana.getFitandremana() == null)
			errors.rejectValue("fitandremana", "error.not-specified", null, "tsy maintsy fenoina");

		if (formFifidianana.getLabel() == null || "".equals(formFifidianana.getLabel().trim()))
			errors.rejectValue("label", "error.not-specified", null, "tsy maintsy fenoina");
				
		if (formFifidianana.getTaomPanompoana() == null )
			errors.rejectValue("taomPanompoana", "error.not-specified", null, "tsy maintsy fenoina");
		
		if (formFifidianana.getKarazamPifidianana() == null )
			errors.rejectValue("karazamPifidianana", "error.not-specified", null, "tsy maintsy fenoina");

		if (formFifidianana.getDatyManombokaFirotsahana() == null)
			errors.rejectValue("datyManombokaFirotsahana", "error.not-specified", null, "tsy maintsy fenoina");

		if (formFifidianana.getDatyMamaranaFirotsahana() == null)
			errors.rejectValue("datyMamaranaFirotsahana", "error.not-specified", null, "tsy maintsy fenoina");

		if (formFifidianana.getDatyFifidianana() == null)
			errors.rejectValue("datyFifidianana", "error.not-specified", null, "tsy maintsy fenoina");
		
		if (!formFifidianana.isFifidiananaOloTokana()){
			if (formFifidianana.getIsaOlonaFidiana() == null)
				errors.rejectValue("isaOlonaFidiana", "error.not-specified", null, "tsy maintsy fenoina");
		}
	}

}
