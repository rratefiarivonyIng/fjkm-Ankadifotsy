package mg.fjkm.ankadifotsy.print;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;


public class JRDirigeant implements JRDataSource{

	private int size = 0; 
	private int index = -1;
	@SuppressWarnings("unchecked")
	public JRDirigeant(List list ){
	}
	
	public Object getFieldValue(JRField arg0) throws JRException {
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
