package mg.fjkm.ankadifotsy.util;

public class TestCharacter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "0123456789";
		
		for (int i=0; i< s.length(); i++){
			int c = s.charAt(i);	//Le code du caract�re quand c'est r�cup�r� en int
			System.out.println(c - 48);	//La valeur num�rique du caract�re num�rique correspondant
		}
	}

}
