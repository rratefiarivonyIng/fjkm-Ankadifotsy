/**
 * 
 */
package mg.fjkm.ankadifotsy.form;

import mg.fjkm.ankadifotsy.bo.Mpivavaka;

import org.springframework.web.multipart.MultipartFile;

/**
 * Formulaire d'upload de fichier
 * @author Rija
 *
 */
public class FormUploadPhoto {
	private MultipartFile fFile;
	private boolean fSubmitted = true;
	private Mpivavaka fMpivavaka = null;

	public FormUploadPhoto(Mpivavaka mpivavaka){
		if (mpivavaka == null || mpivavaka.getId() == null)
			throw new IllegalArgumentException();
		
		fMpivavaka = mpivavaka;
	}
	
	public MultipartFile getFile() {
		return fFile;
	}

	public void setFile(MultipartFile file) {
		fFile = file;
	}

	public boolean isSubmitted() {
		return fSubmitted;
	}

	public void setSubmitted(boolean submit) {
		fSubmitted = submit;
	}

	public Mpivavaka getMpivavaka() {
		return fMpivavaka;
	}

}
