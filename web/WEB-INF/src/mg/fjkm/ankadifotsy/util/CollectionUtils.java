package mg.fjkm.ankadifotsy.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CollectionUtils {
	
  /**
   * Permet de filtrer une liste d'objets en supprimant les doublons présents
   * et en conservant l'ordre.
   * @param objets  Une liste d'objets.
   */
	@SuppressWarnings("unchecked")
	public static void filtrerDoublonsSurPlace(List objets) {
		Map objetsDejaPresents = new HashMap();
		for (Iterator i = objets.iterator(); i.hasNext();) {
			Object objet = i.next();
			if (!objetsDejaPresents.containsKey(objet)) 
				objetsDejaPresents.put(objet, null);
			else 
				i.remove();			
		}
  }	

  	/**
  	 * Filtrer une liste de Map 
  	 * @param objets, liste de Map
  	 * @param filter, le filtre qui doit être unique
  	 */
	@SuppressWarnings("unchecked")
	public static void filtrerDoublonsSurPlace(List<Map> objets, Object filter) {
	    Map objetsDejaPresents = new HashMap();
	    Map filterDejaPresents = new HashMap();
	    for (Iterator i = objets.iterator(); i.hasNext();) {
	    	Map objet = (Map)i.next();
	    	if (!objetsDejaPresents.containsKey(objet) && objet!= null && !filterDejaPresents.containsKey(objet.get(filter))) {
	    		objetsDejaPresents.put(objet, null);
	    		filterDejaPresents.put(objet.get(filter), null);
	    	} 
	    	else 
	    		i.remove();
	    }
	}	

}
