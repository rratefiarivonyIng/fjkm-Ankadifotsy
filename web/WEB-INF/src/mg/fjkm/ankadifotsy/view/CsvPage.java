package mg.fjkm.ankadifotsy.view;

import java.util.List;
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
public class CsvPage extends AbstractView {

	public CsvPage() 
	{
		setContentType("text/csv");
	}
	
	@SuppressWarnings("unchecked")
	protected final void renderMergedOutputModel(
			Map model, HttpServletRequest request, 
			HttpServletResponse response) throws Exception 
	{
			
		List<String> data = (List<String>)model.get("data");
		
      	ServletOutputStream outServ = response.getOutputStream();
      	outServ.flush();

      	if (data != null){
      		for (String line : data){
      			outServ.println(line);		
      		}
      	}
      	outServ.flush();
      	outServ.close();
	}

}
