package mg.fjkm.ankadifotsy.print;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 * classe abstraire rassemblant les donn�es et les methodes de base pour imprimer ou visualiser un fichier .jasper
 * 
 */
public abstract class Printer {
	/**
	 * le fichier jasper(il y a une exception si le fichier n'existe pas)
	 */
	private String fFileName = "";
	/**
	 * Les parametres pass�s � Jasper
	 */
	private Map<String, String> fParametres = new HashMap<String, String>();

	/**
	 * L'objet contenant le model � imprimer
	 */
	private JasperReport fJasperReport = null;

	/**
	 * objet obtenu apr�s les remplissages des donn�es du fichier .jasper
	 */
	private JasperPrint fJasperPrint = null;

	/**
	 * contient les donn�es que l'on passe au rapport
	 */
	protected JRDataSource fDataSource = new JREmptyDataSource();//par defaut pas de donn�es

	/**
	 * charge le fichier .jasper � imprimer
	 * @param fileName  fichier valide 
	 */
	public Printer(String fileName){
		fFileName = fileName;
		try {
			/*Chargement du fichier .jasper*/
			InputStream is  = getClass().getResourceAsStream("/"+fFileName);
			fJasperReport = (JasperReport)JRLoader.loadObject(is);
		} 
		catch (JRException e) {
			System.out.println(e.getMessage());
		} 
	}

	/**
	 * Sert � remplir les variables (champs pr�c�d�s de $F) du rapport
	 * 
	 * Les variables sont des champs contenues dans le fichier .jasper et qui correspondent � des objets Java.
	 * Ces variables et ces objets doivent avoir obligatoirement le m�me nom et le m�me type.
	 */
	public abstract void loadData();

	/**
	 * Sert � remplir les param�tres (champs pr�c�d�s de $P) du rapport
	 *
	 * Les param�tres contenues dans le fichier .jasper correspondent � des objets.
	 * Ces param�tres et ces objets doivent avoir obligatoirement le m�me nom et le m�me type.
	 */
	abstract void loadParametres();

	/**
	 * Remplissages des param�tres($P) et des variables($F)
	 *
	 */
	private void fillReport(){
		//charge tous les param�tres (tous les champs pr�c�d�s de $P dans le fichier .Jasper) 
		loadParametres();
		//charge toutes les variables (tous les champs pr�c�d�s de $F dans le fichier .Jasper) 
		loadData();
		try {
			fJasperPrint = JasperFillManager.fillReport(fJasperReport, fParametres, fDataSource);
		} 
		catch (JRException e) {

		}
	}

	/**
	 * Visualisation
	 *
	 */
	public void preview(){
		fillReport();
		JasperViewer jasperViewer = new JasperViewer(fJasperPrint);
		jasperViewer.setVisible(true);

	}

	/**
	 * impression
	 *
	 */
	public void print(){
		fillReport();
		try {
			JasperPrintManager.printReport(fJasperPrint,true);
		} 
		catch (JRException e) {

		}
	}

	public String getFileName() {
		return fFileName;
	}

	/**
	 * Le fichier .Jasper
	 * @param fileName
	 */
	public void setFileName(String fileName) {
		fFileName = fileName;
	}
	
	public Map<String, String> getParametres() {
		return fParametres;
	}
	
	public void setParametres(Map<String, String> parametres) {
		fParametres = parametres;
	}

	/**
	 * 
	 * @return
	 */
	public byte[] exportToPDFAsByteArray(){
		fillReport();
		byte[] bytes = null;
		try {
			bytes = JasperExportManager.exportReportToPdf(fJasperPrint);
		} 
		catch (JRException e) {
			e.printStackTrace();
		}
		return bytes;
	}

	/**
	 * 
	 * @param fileName : nom du fichier + .pdf
	 * @return
	 */
	public byte[] exportToPDFAndSaveAsByteArray(String fileName){
		fillReport();
		byte[] bytes = null;
		try {
			bytes = JasperExportManager.exportReportToPdf(fJasperPrint);
			File file = new File(fileName);
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			fileOutputStream.write(bytes);
			fileOutputStream.flush();
			fileOutputStream.close();
		} catch (JRException e) {
		}
		catch (FileNotFoundException e) {
		}
		catch (IOException e) {
		}
		return bytes;
	}
}
