package mg.fjkm.ankadifotsy.print;

import java.util.LinkedList;
import java.util.List;

import mg.fjkm.ankadifotsy.bo.Mpivavaka;


public class PrintContribuable extends Printer {
	private Mpivavaka fContribuable = null;
	
	public PrintContribuable(String fileName, Mpivavaka contribuable) {
		super(fileName);
		fContribuable = contribuable;
	}

	@Override
	public void loadData() {
		fDataSource = getMasterReport(fContribuable);
	}

	private JRContribuable getJRContribuable(Mpivavaka contribuable){
		List<Mpivavaka> list = new LinkedList<Mpivavaka>();
		list.add(contribuable);
		return new JRContribuable(list); 
	}

	private JRMasterReport getMasterReport(Mpivavaka contribuable){
		List<MasterReport> list = new LinkedList<MasterReport>();
		MasterReport masterReport = new MasterReport();
		masterReport.setContribuable(getJRContribuable(contribuable));
		list.add(masterReport);

		return new JRMasterReport(list); 
	}

	@Override
	void loadParametres() {
		// TODO Auto-generated method stub
		
	}

}
