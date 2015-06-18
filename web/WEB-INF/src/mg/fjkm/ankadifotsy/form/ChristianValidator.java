/**
 * 
 */
package mg.fjkm.ankadifotsy.form;

import mg.fjkm.ankadifotsy.bo.Mpivavaka;
import mg.fjkm.ankadifotsy.service.FjkmAnkadifotsyService;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Classe de validation des informations saisies sur un fidèle
 * @author Rija RATEFIARIVONY
 *TODO : vérifier que le laharana est unique
 */
public class ChristianValidator implements Validator {

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
		return clazz.isAssignableFrom(FormChristian.class);
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	public void validate(Object command, Errors errors) {
		FormChristian formChristian = (FormChristian)command;
		if (formChristian.getAnarana() == null || formChristian.getAnarana().trim().equals(""))
			errors.rejectValue("anarana", "error.not-specified", null, "tsy maintsy fenoina");
		
		//if (formChristian.getLaharana() == null || formChristian.getLaharana().trim().equals(""))
		//	errors.rejectValue("laharana", "error.not-specified", null, "tsy maintsy fenoina");
		
		if (formChristian.getLaharana() != null && !formChristian.getLaharana().trim().equals("")){
			Mpivavaka mpivavaka = fFjkmAnkadifotsyService.findMpivavakaByLaharana(formChristian.getLaharana());
			if (mpivavaka != null && !mpivavaka.getId().equals(formChristian.getMpivavaka().getId()))
				errors.rejectValue("laharana", "error.already-used", null, "laharana efa miasa");
		}
		
		if (formChristian.getRay_() != null && !formChristian.getRay_().isLahy())
			errors.rejectValue("mpivavakaAnaranaRay", "error.may-lehilahy", null, "Lehilahy ny ray");

		if (formChristian.getReny_() != null && formChristian.getReny_().isLahy())
			errors.rejectValue("mpivavakaAnaranaReny", "error.may-vehivavy", null, "Vehivavy ny reny");

		if (formChristian.getVady() != null){
			if (formChristian.getVady().equals(formChristian.getMpivavaka()))
				errors.rejectValue("mpivavakaAnaranaVady", "error.same-person", null, "Ny mpivady dia olona roa samihafa");
			
			if (formChristian.getMpivavaka() != null && formChristian.getMpivavaka().isLahy() == formChristian.getVady().isLahy())
				errors.rejectValue("mpivavakaAnaranaVady", "error.same-sex", null, "Lahy sy vavy no mpivady");

			if (formChristian.getFitandremanaFanambadiana() == null)
				errors.rejectValue("fitandremanaFanambadiana", "error.not-specified", null, "tsy maintsy fenoina raha manambady");
		}
		else{
			if (formChristian.getMpivavakaAnaranaVady() != null && !"".equals(formChristian.getMpivavakaAnaranaVady().trim())){
				if (formChristian.getFitandremanaFanambadiana() == null)
					errors.rejectValue("fitandremanaFanambadiana", "error.not-specified", null, "tsy maintsy fenoina raha manambady");
			}
		}
	}

}
