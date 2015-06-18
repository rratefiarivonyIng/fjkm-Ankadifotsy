/**
 * 
 */
package mg.fjkm.ankadifotsy.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mg.fjkm.ankadifotsy.bo.Mpivavaka;
import mg.fjkm.ankadifotsy.form.FormUploadPhoto;
import mg.fjkm.ankadifotsy.util.Utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Controlleur pour l'envoi (upload) de photo de l'utilisateur
 * @author Rija
 *
 */
public class UploadPhotoController extends SimpleFormController {

	/** Logger for this class and subclasses */    
	protected final Log logger = LogFactory.getLog(getClass());
	
	private static final int sfBUFFER_SIZE = 10000;
	
	@Override
	protected Object formBackingObject(HttpServletRequest request) throws Exception {
		FormUploadPhoto formUploadPhoto = null;
		Mpivavaka mpivavaka = Utils.getMpivavakaFromSession(request);
		
		if (mpivavaka != null)
			formUploadPhoto = new FormUploadPhoto(mpivavaka);
		
		return formUploadPhoto;
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest req, HttpServletResponse rep, Object command, BindException ex) throws Exception {
		FormUploadPhoto formUpload = (FormUploadPhoto)command;
  
		Mpivavaka mpivavaka = Utils.getMpivavakaFromSession(req);
		if (mpivavaka != null){
			MultipartFile multipartFile = formUpload.getFile();
			 	 
			if(multipartFile!=null && multipartFile.getBytes() != null && multipartFile.getSize() > 0){
				String fileName = Utils.getPhotoName(mpivavaka.getAnarana(), mpivavaka.getId());
				String path = req.getSession().getServletContext().getRealPath(fileName);
				File file = new File(path);
				if (file.exists())
					file.delete();
				
				InputStream is = multipartFile.getInputStream();
				OutputStream os = new FileOutputStream(path);

                int readBytes = 0;
                byte[] buffer = new byte[sfBUFFER_SIZE];
                while ((readBytes = is.read(buffer, 0, sfBUFFER_SIZE)) != -1) {
                	os.write(buffer, 0, readBytes);
                }
                os.close();
                is.close();
			}
		}
		else
			throw new RuntimeException();
		
		return new ModelAndView(new RedirectView("editChristian.htm?id="+mpivavaka.getId()));
	}
	
    @Override
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws ServletException {
    	// Convert multipart object to byte[]
    	binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
    }
}
