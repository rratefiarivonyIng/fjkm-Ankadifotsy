package mg.fjkm.ankadifotsy.print;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;


public class JRMasterReport implements JRDataSource{

	private List<MasterReport> fList ;
	private int size = 0; 
	private int index = -1;
	public JRMasterReport(List<MasterReport> list ){
		fList = list;
		size = fList.size();

	}
	public Object getFieldValue(JRField arg0) throws JRException {

		MasterReport dataSource = (MasterReport) fList.get(index);
		if(arg0.getName().equalsIgnoreCase("contribuable"))
			return dataSource.getContribuable();
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
