/**
 * 
 */
package mg.fjkm.ankadifotsy.dao;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import mg.fjkm.ankadifotsy.bo.AntonAsa;
import mg.fjkm.ankadifotsy.bo.AuthorizedIP;
import mg.fjkm.ankadifotsy.bo.District;
import mg.fjkm.ankadifotsy.bo.Fanambadiana;
import mg.fjkm.ankadifotsy.bo.FanisamBato;
import mg.fjkm.ankadifotsy.bo.Faritra;
import mg.fjkm.ankadifotsy.bo.Fifidianana;
import mg.fjkm.ankadifotsy.bo.Firaisana;
import mg.fjkm.ankadifotsy.bo.Fitandremana;
import mg.fjkm.ankadifotsy.bo.ILabelable;
import mg.fjkm.ankadifotsy.bo.KarazamPifidianana;
import mg.fjkm.ankadifotsy.bo.MirotsakaFidiana;
import mg.fjkm.ankadifotsy.bo.Mpivavaka;
import mg.fjkm.ankadifotsy.bo.Parameter;
import mg.fjkm.ankadifotsy.bo.Province;
import mg.fjkm.ankadifotsy.bo.Region;
import mg.fjkm.ankadifotsy.bo.TaomPanompoana;
import mg.fjkm.ankadifotsy.bo.User;
import mg.fjkm.ankadifotsy.bo.Vato;


/**
 * @author rija
 *
 */
public interface FjkmAnkadifotsyDao {
	/**
	 * 
	 * @param id
	 * @return Fitandremana dont l'id est passé en paramètre
	 */
	Fitandremana findFitandremanaById(Long id);
	
	/**
	 * 
	 * @return tous les fitandremanas
	 */
	List<Fitandremana> findAllfitandremana();

	/**
	 * 
	 * @return tous les TaomPanompoana
	 */
	List<TaomPanompoana> findAllTaomPanompoana();

	/**
	 * 
	 * @param daty
	 * @return tous les TaomPanompoana avant cette daty
	 */
	List<TaomPanompoana> findTaomPanompoanasWithoutDaty(Date daty);
	
	/**
	 * 
	 * @param parameters
	 * @return TaomPanompoana selon les critères spécifiés dans la paramètre (Ajax)
	 */
	List<TaomPanompoana> getTaomPanompoana(Map<String, String> parameters);
	
	/**
	 * 
	 * @param id
	 * @return Le TaomPanompoana en fonction de l'id passé en paramètre
	 */
	TaomPanompoana findTaomPanompoanaById(Long id);
	
	/**
	 * 
	 * @param daty
	 * @return Le TaomPanompoana de la daty passée en paramètre
	 */
	TaomPanompoana findTaomPanompoanaByDate(Date daty);
	
	/**
	 * 
	 * @param id
	 * @return le KarazamPifidianana par son id
	 */
	KarazamPifidianana findKarazamPifidiananaById(Long id);
	
	/**
	 * Enregistre en base sur les modifications dans Mpivavaka
	 * @param mpivavaka
	 * @return mpivavaka persisté en base
	 */
	Mpivavaka saveMpivavaka(Mpivavaka mpivavaka);
	
	/**
	 * Enregistre en base un Fanambadiana
	 * @param fanambadiana
	 * @return fanambadiana persisté
	 */
	Fanambadiana saveFanambadiana(Fanambadiana fanambadiana);

	/**
	 * Renvoie le Fanambadiana associé au mpivavaka passé en paramètre s'il existe
	 * @param mpivavaka
	 * @return
	 */
	Fanambadiana findFanambadianaByMpivavaka(Mpivavaka mpivavaka);
	
	/**
	 * 
	 * @param laharana
	 * @return Mpivavaka
	 */
	Mpivavaka findMpivavakaByLaharana(String laharana);
	
	/**
	 * 
	 * @param id
	 * @return Mpivavaka
	 */
	Mpivavaka findMpivavakaById(Long id);
	
	/**
	 * 
	 * @return les mpivavaka existant
	 */
	List<Mpivavaka> findAllMpivavaka(Integer pageNo, Integer nbElement);

	/**
	 * 
	 * @param parameterNameValues
	 * @return le nb de Mpivavaka qui satisfait les critères passés en paramètre
	 */
	public Long findNumberOfMpivavaka(Map<String, Object> parameterNameValues);

	/**
	 * 
	 * @param parameterNameValues
	 * @param pageNo
	 * @param nbElement
	 * @return Les Mpivavaka qui satisfait les critères passés en paramètre et suivant le numéro de page
	 */
	public List<Mpivavaka> findMpivavaka(Map<String, Object> parameterNameValues, Integer pageNo, Integer nbElement);
	
	/**
	 * Permet de récupérer les instances de ILablelable pour l'autocomplétion
	 * Cette méthode pourrait être appelée pour tout bo implémentant ILabelable
	 * @param parameters
	 * @param boClass
	 * @return
	 */
	public List<ILabelable> getAutoCompletionLabelable(Map<String, String> parameters, Class<? extends Object> boClass);
	
	/**
	 * Pour l'autocomplétion
	 * @param parameters
	 * @return
	 */
	public List<Mpivavaka> getMpivavaka(Map<String, String> parameters);

	/** 
	 * @param label
	 * @return liste des firaisana filtrés par label
	 */
	List<Firaisana> getFiraisanas(String label);
	
	List<Faritra>getFaritras(Map<String, String> parameters);
	
	Firaisana findFiraisana(Long id);
	
	Faritra findFaritra(Long id);
	
	/**
	 * Liste des régions
	 * @return
	 */
	List<Region> getRegions();
	
	/**
	 * Liste des régions d'une province
	 * @param idProvince
	 * @return
	 */
	List<Region> getRegionsParProvince(Integer idProvince);
	
	/**
	 * Liste les régions filtrées par intitulé et par le province
	 * @NOTE si aucune province n'est précisée alors renvoie la liste de toutes les régions filtrées par l'intitulé
	 * @param intitule
	 * @param provinceId
	 * @return
	 */
	List<Region>getRegions(Map<String, String> parameters);
	
	/**
	 * Liste des provinces
	 * @return
	 */
	List<Province> getProvinces();
	
	/**
	 * Liste des provinces filtrés par l'intitule 
	 * @NOTE : pour l'ajax (autocomplétion)
	 * @param intitule
	 * @return
	 */
	List<Province>getProvinces(String intitule);
	
	/**
	 * Renvoie le district à partir de son identifiant
	 * @param id
	 * @return
	 */
	District findDistrict(Long id);
	
	/**
	 * Renvoie la commune dont l'identifiant est passé en paramètre
	 * @param id
	 * @return
	 */
	Firaisana findCommune(Long id);
	
	/**
	 * Renvoie l'activité dont l'identifiant est passé en paramètre
	 * @param id
	 * @return
	 */
	AntonAsa findAntonAsa(Long id);
	
	/**
	 * Renvoie la province
	 * @param id, identifiant de la province
	 * @return
	 */
	Province getProvince(Long id);
	
	/**
	 * Renvoie la région
	 * @param codeRegion, code de la région
	 * @return
	 */
	Region getRegion(Long id);		
	
	/**
	 * Renvoie la liste des activités pour l'autoComplétion
	 * @param parameters
	 * @return
	 */
	List<AntonAsa> getAntonAsas(Map<String, String>parameters);
	
	/**
	 * La liste des centres fiscaux
	 * @return
	 */
	List<Faritra> getCentreFiscaux();
	
	/**
	 * Liste des centres fiscaux suivant les paramètres 
	 * @note autocompletion
	 * @param parameters
	 * @return
	 */
	List<Faritra> getCentreFiscaux(Map<String, String>parameters);
	
	/**
	 * Renvoie la liste des communes
	 * @return
	 */
	List<Firaisana>getCommunes();

	/**
	 * Liste les communes filtrées par intitulé , par le province , par région et par le district
	 * @NOTE si aucune province ou région ou district n'est précisée alors renvoie la liste de toutes les communes filtrées par l'intitulé
	 * @param intitule
	 * @param provinceId
	 * @return
	 */
	List<Firaisana>getCommunes(Map<String, String> parameters);

	/**
	 * Liste des communes pour un district
	 * @param idDistrict
	 * @return
	 */
	List<Firaisana>getCommunesParDisctrict(Integer idDistrict);
	
	/**
	 * Liste des districts
	 * @return
	 */
	List<District> getDistricts();
	
	/**
	 * Pour l'ajax autocompletion de la saisie d'un district
	 * @param parameters
	 * @return
	 */
	List<District> getDistricts(Map<String, String> parameters);
	
	/**
	 * Liste des districts d'une région
	 * @param idRegion
	 * @return
	 */
	List<District> getDistrictsParRegion(Integer idRegion);
	
	/**
	 * Recherche des contribuables avec les doublons possibles
	 * @param parameters <clé, valeur> : clé possible (NIF, RAISON_SOC, ACTIVITE, CIN, FORME_JURIDIQUE, REGIME_FISCAL
	 * @return
	 */
	List<Mpivavaka> getContribuablesAvecDoublons(Map<String, String> parameters);
	
	/**
	 * Renvoie la liste des contribuables suivant le filtre fourni
	 * @param typeRecherche, par NIF, par raison sociale ou par nom commercial
	 * @param filter, la valeur du filtre
	 * @return
	 */
	List<Mpivavaka> getContribuables(String typeRecherche, String filter);
	
	/**
	 * Recherche de contribuables par la référence d'enregistrement de la demande
	 * @param taxPayerNo
	 * @return
	 */
	List<Mpivavaka> getContribuables(Long taxPayerNo);
		
	/**
	 * Renvoie le contribuable à partir de son NIF
	 * @NOTE : le nif doit respecter le format N NNN NNN NNN
	 * @param nif
	 * @return
	 */	
	Mpivavaka getContribuableByNif(String nif);

	/**
	 * Renvoie le contribuable par son ancien NIF
	 * @param ancienNif
	 * @return
	 */
	Mpivavaka getContribuableByAncienNif(String ancienNif);
	
	/**
	 * Recherche de contribuables par son état (validé, approuvable, rejeté, non vérifié) 
	 * @param idEtat
	 * @param idCentreFiscal, filtre sur le centre fiscal du premier établissement du contribuable. Si null alors aucun filtre appliqué sur le centre fiscal
	 * @return
	 */
	List<Mpivavaka> getContribuablesParEtat(Long idEtat, Long idCentreFiscal);

	/**
	 * Recherche de contribuables par son état (validé, approuvable, rejeté, non vérifié) pour recherche doublon 
	 * @param idEtat
	 * @return
	 */
	List<Mpivavaka> getContribuablesParEtatPourDoublon(Long idEtat);

	/**
	 * Suppression d'un contribuable
	 * @param contribuable
	 */
	void removeContribuable(Mpivavaka contribuable);
		
	/**
	 * Renvoie l'uitilisateur associé au login
	 * @param login
	 * @return
	 */
	User getUser(String login);
	
	/**
	 * Enregistre ou insère les modifications en base pour l'utilisateur 
	 * @param user
	 * @return
	 */
	User saveUser(User user);
	
	/**
	 * Supprimer un utilisateur en base
	 * @param user
	 */
	void removeUser(String login);
	
	/**
	 * 
	 * @return liste de tous les utilisateurs
	 */
	List<User> findUsers();

	/**
	 * 
	 * @param parameterNameValues
	 * @param pageNo
	 * @param nbElement
	 * @return le nb de Fifidianana qui satisfait les critères passés en paramètre
	 */
	public Long findNumberOfFifidianana(Map<String, Object> parameterNameValues);
	
	/**
	 * 
	 * @param pageNo
	 * @param nbElement
	 * @return liste des Fifidianana compris dans la page
	 */
	List<Fifidianana> findAllFifidianana(Integer pageNo, Integer nbElement);
	
	/**
	 * 
	 * @param parameterNameValues
	 * @param pageNo
	 * @param nbElement
	 * @return liste des Fifidiananas répondant aux critères et compris dans la page
	 */
	List<Fifidianana> findFifidianana(Map<String, Object> parameterNameValues, Integer pageNo, Integer nbElement);
	
	/**
	 * 
	 * @param id
	 * @return le Fifidianana par son id
	 */
	Fifidianana findFifidianana(Long id);

	/**
	 * Enregistre en base la création ou la modification d'un Fifidianana
	 * @param fifidianana
	 * @return le fifidianana enregistré
	 */
	Fifidianana saveFifidianana(Fifidianana fifidianana);
	
	/**
	 * Permet de savoir si le Mpivavaka est déjà MirotsakaFidiana ou non pour le Fifidianana
	 * @param fifidiananaId
	 * @param mpivavakaIds, les identiifants des Mpivavaka à vérifier
	 * @return Map<mpivavakaId, mirotsakaFidianaId> en fonction de fifidiananaId
	 */
	Map<Long, Long> findMapMpivavakaId2MirotsakaFidianaIdByTaomPanompoanaId(Long fifidiananaId, Collection<Long>mpivavakaIds);

	/**
	 * Enregistre le MirotsakaFidiana (candidature) en base
	 * @param mirotsakaFidiana
	 * @return
	 */
	MirotsakaFidiana saveMirotsakaFidiana(MirotsakaFidiana mirotsakaFidiana);
	
	/**
	 * 
	 * @param id
	 * @return MirotsakaFidiana (candidature)
	 */
	MirotsakaFidiana findMirotsakaFidianaById(Long id);
	
	/**
	 * 
	 * @param fifidiananaId
	 * @param tsyAnkanavaka, si true = tsy ampiasaina ekenaFirotsahana
	 * @param ekenaFirotsahana, si true = lisitry ny mirotsaka efa nekena, si false = lisitry ny mirotsaka efa nolavina, si null lisitry ny mirotsaka mbola tsy nojerena
	 * @param lehilahy, si null alors ne considère pas le genre (homme / femme), si true alors prend seulement les hommes, si false => femmes uniquement
	 * @return le nombre total de Mirotsaka Fidiana
	 */
	Long findNumberOfMirotsakaFidiana(Long fifidiananaId, boolean tsyAnkanavaka, Boolean ekenaFirotsahana, Boolean lehilahy);
	
	/**
	 * 
	 * @param fifidiananaId
	 * @param tsyAnkanavaka, si true alors toutes les candidatures reçues (acceptées ou refusées) seront prises en compte
	 * @param lahy, si null alors tout genre confondu, si true alors les hommes seulement, si false alors les femmes uniquement
	 * @param pageNo
	 * @param nbElement
	 * @return les informations d'affichages des MirotsakaFidiana sous forme de Map
	 */
	List<Map<String, Object>> findMirotsakaFidiana(Fifidianana fifidianana, boolean tsyAnkanavaka, Boolean ekenaFirotsahana, Boolean lahy, Integer pageNo, Integer nbElement);
	
	/**
	 * 
	 * @param fifidiananaId
	 * @param orderByName
	 * @param ekenaFirotsahana, null = Mpirotsaka rehetra, true = mpirotsaka nekena ihany, false = mpirotsaka nolavina ihany
	 * @return les MirotsakaFidiana (Candidatures) d'un Fifidianana (élection)
	 */
	List<MirotsakaFidiana> findMirotsakaFidiana(Long fifidiananaId, boolean orderByName, Boolean ekenaFirotsahana);

	/**
	 * renvoie sous-forme de Map les informations sur les candidatures 
	 * @param fifidiananaId
	 * @param ekenaFirotsahana
	 * @param lehilahy, si null alors renvoie toutes les candidatures, si true alors renvoie uniquement les candidatures lehilahy, si false alors renvoie uniquement les candidatures vehivavy
	 * @param orderByName, SI true tri par ordre alphabetique des noms et prénoms SINON tri par numéro laharanaMpirotsaka 
	 * @return Map<String, Object> , clé = mirotsakaFidianaId/laharanaMpirotsaka/lahy
	 */
	List<Map<String, Object>> findMapMirotsakaFidiana(Long fifidiananaId, Boolean ekenaFirotsahana, Boolean lehilahy, boolean orderByName);
	
	/**
	 * 
	 * @param fifidiananaId
	 * @return le nombre total de MirotsakaFidiana quel que soit leur état
	 */
	int getNumberMirotsakaFidiana(Long fifidiananaId);
	
	/**
	 * 
	 * @param fifidiananaId
	 * @param nekena : null => non encore traité, true => accepté, false => refusé
	 * @return
	 */
	int getNumberMirotsakaFidiana(Long fifidiananaId, Boolean nekena);
	
	/**
	 * 
	 * @param fifidianana
	 * @param lehilahy
	 * @return le FanisamBato associé au Fifidianana passé en paramètre
	 * NOTE : il ne doit pas y avoir plus d'UN FanisamBato pour UN Fifidianana
	 */
	FanisamBato getFanisamBato(Fifidianana fifidianana, Boolean lehilahy);

	/**
	 * 
	 * @param laharanaIds
	 * @return Map<laharanaMpirotsaka, MirotsakaFidianaId>
	 */
	Map<Integer, Long> getLaharana2MirotsakaFidianaId(Collection<Integer> laharanaIds);
	
	/**
	 * Manampy iray ny isan'ny vato azon'ny MirotsakaFidiana manana ny laharanaMpirotsaka ao anatiny laharanaMpirotsakas
	 * @param fifidianana
	 * @param mirotsakaFidianaIds
	 * @param lehilahy
	 */
	void ampioVatoIrayNyMpirotsakas(Fifidianana fifidianana, Collection<Long> mirotsakaFidianaIds);

	/**
	 * Manala iray ny isan'ny vato azon'ny MirotsakaFidiana manana laharanaMpirotsaka ao anatin'ny mirotsakaFidianaIds 
	 * @param fifidianana
	 * @param mirotsakaFidianaIds
	 */
	void esoryVatoIrayNyMpirotsakas(Fifidianana fifidianana, Collection<Long> mirotsakaFidianaIds);
	
	/**
	 * Le nombre de voix obtenu par les candidats pour un fifidianana donné
	 * Le nombre de résultat renvoyé est paramétré
	 * le clé est composé du laharanaMpirotsaka et du nom du candidat
	 * @param fifidiananaId
	 * @param lahy, si null alors on renvoie les résultats tout genre confondu
	 * @param izayNahazoVato, si true alors seulement les candidats ayant obtenus au moins un voix
	 * @param page
	 * @param nbElement
	 * @return
	 */
	List<Map<String, Object>> getIsamBatoAmbonyIndrindra(Long fifidiananaId, Boolean lahy, boolean izayNahazoVato,Integer page, Integer nbElement);

	/**
	 * 
	 * @param fifidiananaId
	 * @param lahy
	 * @param izayNahazoVato
	 * @return le nombre de lignes max pour l'affichage des résultats temporaires
	 */
	Integer getNbMaxResult(Long fifidiananaId, Boolean lahy, boolean izayNahazoVato);
	
	//-------------- gestion des paramètres ----------------------------
	/**
	 * @return parameter, le paramètre de l'utilisateur depuis la base de données sinon le crée et l'enregistre en base
	 * NOTE : un utilisateur doit au plus avoir un seul et unique paramètre en base
	 */
	Parameter findParameterByUser(String login);
	
	/**
	 * Enregistre en base les modifications effectuées sur parameter
	 * @param parameter
	 */
	void saveParameter(Parameter parameter);
	
	/**
	 * Modifie le mot de passe de l'utilisateur
	 * @return true si la modification est ok, false sinon
	 */
	boolean updatePassword(String userLogin, String lastPass, String newPass);
	
	/**
	 * Enregistre les informations dans vato dans la base de données
	 * @throws Exception
	 */
	Vato saveVato(Vato vato);
	
	/**
	 * mitady vato anaty fifidianana @ alalan'ny laharany
	 * @param laharana
	 * @param fifidiananaId
	 * @param lehilahy
	 * @return
	 */
	Vato findVato(String laharana, Long fifidiananaId, Boolean lehilahy);
	
	/**
	 * Ré-initialise à 0 les voies obtenues dans MirotsakaFidiana pour le Fifidianana ET
	 * Ré-initialise à 0 les statistiques dans Fanisambato 
	 * @param id
	 */
	void initFifidianana(Long id);
	
	/**
	 * Ajoute une nouvelle IP autorisée dans la base et dans le cache
	 * @param ip
	 * @param description
	 */
	void addAuthorizedId(String ip, String description);
	
	/**
	 * Supprime une IP anciennement autorisée dans la base et dans le cache
	 * @param ip
	 */
	void removeAuthorizedIP(String ip);
	
	/**
	 * 
	 * @param id
	 * @return l'instance de AuthorizedIP par son id
	 */
	AuthorizedIP findAuthorizedIP(Long id);
	
	/**
	 * Vérifie si une IP donnée est autorisée ou non
	 * NOTE : vérifie dans le cache d'abord (pour des raisons de performances), si non trouvé dans le cache alors vérifie en base
	 * @param ip
	 * @return true si authorisée, false sinon
	 */
	boolean isIPAuthorized(String ip);
	
	/**
	 * Permet d'activer/désactiver l'IP 
	 * @param ip
	 * @param active
	 */
	void activateAuthorizedIP(String ip, boolean active);
	
	/**
	 * 
	 * @return la liste de toutes les IPs en base
	 */
	List<AuthorizedIP> getAllAuthorizedIps();
	
	/**
	 * enregistre en base les modifications dans AuthorizedIP
	 * @param aip
	 */
	void saveAuthorizedIP(AuthorizedIP aip);
	
	/**
	 * Supprime en base et en cache l'IP autorisée. Par la suite l'IP ne sera plus autorisée
	 * @param id
	 */
	void deleteAuthorizedIP(Long id);
	
	/**
	 * récupère les stats des bulletins de vote saisis sur la machine dont l'IP est donnée en paramètre
	 * @param fifidiananaId
	 * @param lehilahy
	 * @param ip
	 * @return Map, les clés sont isaVatoVoaisa, isaVatoManankery, isaVatoFotsy, isaVatoMaty
	 */
	Map<String, Long> getStats(Long fifidiananaId, boolean lehilahy, String ip);
	
	/**
	 * Permet de démarrer ou d'interdire le fanisambato pour le fifidianana
	 * @param fifidiananaId
	 * @param start
	 */
	void startStopFanisambato(Long fifidiananaId, boolean start);
	
	/**
	 * 
	 * @param fifidiananaId
	 * @return true si l'on peut procéder au fanisambato.
	 */
	boolean canProcessFanisambato(Long fifidiananaId);
}
