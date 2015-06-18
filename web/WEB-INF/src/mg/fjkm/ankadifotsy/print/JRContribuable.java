package mg.fjkm.ankadifotsy.print;
import java.util.List;

import mg.fjkm.ankadifotsy.bo.Mpivavaka;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;


public class JRContribuable implements JRDataSource{

	private List<Mpivavaka> fList ;
	private int size = 0; 
	private int index = -1;
	public JRContribuable(List<Mpivavaka> list ){
		fList = list;
		size = fList.size();

	}
	public Object getFieldValue(JRField arg0) throws JRException {
		Mpivavaka contribuable = (Mpivavaka) fList.get(index);
		if(arg0.getName().equalsIgnoreCase("nif"))
			return contribuable.getId();
		else if(arg0.getName().equalsIgnoreCase("resident")){
			return "résident";
		}
		else if(arg0.getName().equalsIgnoreCase("index"))
			return "index";
		else if(arg0.getName().equalsIgnoreCase("etablissement")){
			return null;
		}
		else if(arg0.getName().equalsIgnoreCase("nombreEtablissement"))//$F{nombreEtablissement}
			return 0;

		return null;
	}

	public boolean next() throws JRException {
		if(  index<size-1){
			index++;
			return true;
		}
		return false;
	}
}
