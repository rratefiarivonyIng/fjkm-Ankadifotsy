package mg.fjkm.ankadifotsy.view;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;


/**
 * Pour le rendu de fichier text/csv
 * @author rija
 *
 */
public abstract class AjaxResponsePage extends AbstractView {

	public AjaxResponsePage() 
	{
		setContentType("text/xml");
	}
	
	protected void writeHeader(ServletOutputStream outServ) throws IOException{
		outServ.print("<?xml version=\"1.0\" encoding=\"ISO_8859-1\" ?>");
		outServ.print("<ajax-response>");
		outServ.print("<response>");
		outServ.print("<list>");
	}

	protected void writeClosingResponse(ServletOutputStream outServ) throws IOException{
      	outServ.print("</list>");
      	outServ.print("</response>");
      	outServ.print("</ajax-response>");
	}
	
	public abstract void writeData(Object datas, ServletOutputStream outServ) throws IOException ;
	
	@SuppressWarnings("unchecked")
	protected final void renderMergedOutputModel(
			Map model, HttpServletRequest request, 
			HttpServletResponse response) throws Exception 
	{
			
		Object data = model.get("data");
		
      	ServletOutputStream outServ = response.getOutputStream();
      	outServ.flush();
      	
      	writeHeader(outServ);

      	writeData(data, outServ);
      	
      	writeClosingResponse(outServ);
      	
      	outServ.flush();
      	outServ.close();
	}

}
