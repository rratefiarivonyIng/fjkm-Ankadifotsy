package mg.fjkm.ankadifotsy.view;

import java.io.ByteArrayOutputStream;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;


public class PdfPage extends AbstractView {

	public PdfPage() 
	{
		setContentType("application/pdf");
	}
	
	@SuppressWarnings("unchecked")
	protected final void renderMergedOutputModel(
			Map model, HttpServletRequest request, 
			HttpServletResponse response) throws Exception 
	{
			
		byte[] data = (byte[])model.get("data");
		
      	ServletOutputStream outServ = response.getOutputStream();
      	outServ.flush();

      	ByteArrayOutputStream outByte = new ByteArrayOutputStream();
      	outByte.write(data);
      	outByte.writeTo(outServ);
      	outByte.close();
			
      	outServ.flush();
      	outServ.close();
	}

}
