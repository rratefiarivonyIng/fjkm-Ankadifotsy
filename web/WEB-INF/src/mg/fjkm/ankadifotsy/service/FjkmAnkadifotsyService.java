/**
 * 
 */
package mg.fjkm.ankadifotsy.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import mg.fjkm.ankadifotsy.exception.CreationVatoException;


/**
 * Contrat de service IntraPoste
 * @author rija
 * @version 1.0
 */
public interface FjkmAnkadifotsyService {
	/**
	 * 
	 * @param id
	 * @return Fitandremana par son Id
	 */
	Fitandremana findFitandremanaById(Long id);
	
	/**
	 * Tous les Fitandremana
	 * @return
	 */
	List<Fitandremana> findAllFitandremana();

	/**
	 * 
	 * @return tous les taom-panompoana
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
	 * @param id
	 * @return Le TaomPanompoana en fonction de l'id pass� en param�tre
	 */
	TaomPanompoana findTaomPanompoanaById(Long id);

	/**
	 * 
	 * @param daty
	 * @return Le TaomPanompoana en fonction de la daty pass�e en param�tre
	 */
	TaomPanompoana findTaomPanompoanaByDate(Date daty);

	/**
	 * 
	 * @param parameters
	 * @return TaomPanompoana selon les crit�res sp�cifi�s dans la param�tre (Ajax)
	 */
	List<TaomPanompoana> getTaomPanompoana(Map<String, String> parameters);

	/**
	 * 
	 * @param id
	 * @return KarazamPifidianana par son id
	 */
	KarazamPifidianana findKarazamPifidiananaById(Long id);
	
	/**
	 * Enregistre en base les modifications dans Mpivavaka
	 * @param mpivavaka
	 * @return mpivavaka persist� en base
	 */
	Mpivavaka saveMpivavaka(Mpivavaka mpivavaka, String userName);

	/**
	 * Enregistre en base les modifications dans Mpivavaka et tenant compte 
	 * de l'insertion/modification �ventuelle des infos sur le Vady (Fanambadiana)
	 * @param mpivavaka
	 * @param vady
	 * @param fanambadiana
	 * @param userName
	 * @return
	 */
	Mpivavaka saveMpivavaka(Mpivavaka mpivavaka, Mpivavaka vady, Mpivavaka vadyTaloha, Fanambadiana fanambadiana, String userName);
	
	/**
	 * 
	 * @param laharana
	 * @return Mpivavaka
	 */
	Mpivavaka findMpivavakaByLaharana(String laharana);
	
	/**
	 * 
	 * @param id
	 * @return
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
	 * @param pageNo
	 * @param nbElement
	 * @return Les Mpivavaka qui satisfait les crit�res pass�s en param�tre et suivant le num�ro de page
	 */
	public List<Mpivavaka> findMpivavaka(Map<String, Object> parameterNameValues, Integer pageNo, Integer nbElement);

	/**
	 * @param parameterNameValues
	 * @return le nb de Mpivavaka qui satisfait les crit�res pass�s en param�tre
	 */
	public Long findNumberOfMpivavaka(Map<String, Object> parameterNameValues);

	/**
	 * Liste des r�gions
	 * @return
	 */
	List<Region> getRegions();
	
	/**
	 * Liste des r�gions d'une province
	 * @param idProvince
	 * @return
	 */
	List<Region> getRegionsParProvince(Integer idProvince);
	
	/**
	 * Liste des provinces
	 * @return
	 */
	List<Province> getProvinces();
		
	/**
	 * Liste des provinces filtr�s par l'intitule 
	 * @NOTE : pour l'ajax (autocompl�tion)
	 * @param intitule
	 * @return
	 */
	List<Province>getProvinces(String intitule);

	/**
	 * 
	 * @param label
	 * @return liste des firaisanas filtr�s par label
	 */
	List<Firaisana>getFiraisanas(String label);

	/**
	 * Liste des faritras filtr�s par label et par Firaisana
	 * @NOTE si aucun Firaisana n'est pr�cis�e alors renvoie la liste de tous les faritras filtr�s par label
	 * @param parameters
	 * @return
	 */
	List<Faritra>getFaritras(Map<String, String> parameters);
	
	Firaisana findFiraisana(Long id);
	
	Faritra findFaritra(Long id);
	
	/**
	 * Renvoie la commune dont l'identifiant est pass� en param�tre
	 * @param id
	 * @return
	 */
	Firaisana findCommune(Long id);
	
	/**
	 * Renvoie le District dont l'identifiant est pass� en param�tre
	 * @param id
	 * @return
	 */
	District findDistrict(Long id);

	/**
	 * Renvoie l'activit� dont l'identifiant est pass� en param�tre
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
	 * Renvoie la r�gion
	 * @param codeRegion, code de la r�gion
	 * @return
	 */
	Region getRegion(Long id);		
	
	/**
	 * Renvoie la liste des activit�s pour l'autocompl�tion suivant le libell� pass� en param�tre
	 * @param parameters
	 * @return
	 */
	List<AntonAsa> getAntonAsas(Map<String, String> parameters);

	/**
	 * Renvoie la liste des mpivavaka pour l'autocompl�tion suivant le libell� pass� en param�tre
	 * @param parameters
	 * @return
	 */
	public List<Mpivavaka> getMpivavaka(Map<String, String> parameters);

	/**
	 * 
	 * @param parameters
	 * @return
	 */
	public List<ILabelable> getLabelablesForAutoCompletion(Map<String, String> parameters);

	/**
	 * Autocompl�tion Karazampifidianana
	 * @param parameters
	 * @return
	 */
	public List<ILabelable> getKarazamPifidianana(Map<String, String> parameters);
	
	/**
	 * La liste des centres fiscaux
	 * @return
	 */
	List<Faritra> getCentreFiscaux();

	/**
	 * La liste des centres fiscaux suivant les filtres pass�s en param�tre
	 * @return
	 */
	List<Faritra> getCentreFiscaux(Map<String, String> parameters);
	
	/**
	 * Renvoie la liste des communes
	 * @return
	 */
	List<Firaisana>getCommunes();
	
	/**
	 * Liste les communes filtr�es par intitul� , par le province , par r�gion et par le district
	 * @NOTE si aucune province ou r�gion ou district n'est pr�cis�e alors renvoie la liste de toutes les communes filtr�es par l'intitul�
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
	 * Liste les districts filtr�es par intitul� , par le province et par r�gion
	 * @NOTE si aucune province ou r�gion n'est pr�cis�e alors renvoie la liste de tous les districts filtr�s par l'intitul�
	 * @param intitule
	 * @param provinceId
	 * @return
	 */
	List<District>getDistricts(Map<String, String> parameters);
	
	/**
	 * Liste des districts d'une r�gion
	 * @param idRegion
	 * @return
	 */
	List<District> getDistrictsParRegion(Integer idRegion);
			
	/**
	 * Permet de valider un contribuable ayant obtenu son nif
	 * @param contribuable
	 * @return
	 */
	Mpivavaka validerContribuable(Mpivavaka contribuable);
		
	/**
	 * Recherche des contribuables avec les doublons possibles
	 * @param parameters <cl�, valeur> : cl� possible (NIF, RAISON_SOC, ACTIVITE, CIN, FORME_JURIDIQUE, REGIME_FISCAL
	 * @return
	 */
	List<Mpivavaka> getContribuables(Map<String, String> parameters);

	/**
	 * Renvoie la liste des contribuables suivant le filtre fourni
	 * @param typeRecherche, par NIF, par raison sociale ou par nom commercial
	 * @param filter, la valeur du filtre
	 * @return
	 */
	List<Mpivavaka> getContribuables(String typeRecherche, String filter);
	
	/**
	 * Renvoie la liste des contribuables � l'�tat Approuvable
	 * @param idCentreFiscal, filtre des utilisateurs sur le centre fiscal de leur 1er �tablissement. Si null alors pas de filtre sur le centre fiscal 
	 * @return
	 */
	List<Mpivavaka> getContribuablesAcceptables(Long idCentreFiscal);
	
	/**
	 * Renvoie la liste des contribuables � l'�tat rejet�
	 * @param idCentreFiscal, filtre des utilisateurs sur le centre fiscal de leur 1er �tablissement. Si null alors pas de filtre sur le centre fiscal 
	 * @return
	 */
	List<Mpivavaka> getContribuablesRejetes(Long idCentreFiscal);

	/**
	 * Renvoie la liste des contribuables � l'�tat "Non v�rifi�" (en cours de v�irifcation ?)
	 * @param idCentreFiscal, filtre des utilisateurs sur le centre fiscal de leur 1er �tablissement. Si null alors pas de filtre sur le centre fiscal 
	 * @return
	 */
	List<Mpivavaka> getContribuablesNonVerifies(Long idCentreFiscal);

	/**
	 * Renvoie la liste des contribuables � l'�tat "valid�"
	 * @param idCentreFiscal, filtre des utilisateurs sur le centre fiscal de leur 1er �tablissement. Si null alors pas de filtre sur le centre fiscal 
	 * @return
	 */
	List<Mpivavaka> getContribuablesValides(Long idCentreFiscal);

	/**
	 * Renvoie le contribuable par la r�f�rence de son enregistrement
	 * @param taxPayerNo
	 * @return
	 */
	Mpivavaka getContribuableByReference(Long taxPayerNo);	
		
	/**
	 * Renvoie le contribuable par le nif de l'utilisateur
	 * @param nif
	 * @return
	 */
	Mpivavaka getContribuableByNif(String nif);
	
	/**
	 * Renvoie le contribuable par son ancien nif 
	 * @param ancienNif
	 * @return
	 */
	Mpivavaka getContribuableByAncienNif(String ancienNif);
	
	/**
	 * Suppression d'un contribuable
	 * @param contribuable
	 */
	void removeContribuable(Mpivavaka contribuable);

	/**
	 * Renvoie la liste des doublons possibles de ce contribuable parmi les
	 * contribuables ayant d�j� �t� valid�s (ayant obtenu leur NIF) 
	 * @param contribuable
	 * @return
	 */
	List<Mpivavaka> getDoublons(Mpivavaka contribuable);
	
	/**
	 * Renvoie la liste des doublons possibles suivant les param�tres parmi les
	 * contribuables ayant d�j� �t� valid�s (ayant obtenu leur NIF) 
	 * @param parameters
	 * @return
	 */
	List<Mpivavaka> getDoublons(Map<String, String>parameters);
			
	/**
	 * Cr�er un login (correspond au nif nouveau format si il existe ou au nif ancien format si le contribuable n'a pas encore me NIF nouveau format)
	 * et un mot de passe obtenu par le NIF et le nom ou raison sociale du contribuable
	 * @param contribuable
	 * @return le mot de passe g�n�r�
	 */
	String creerUtilisateurPourContribuable(Mpivavaka contribuable);
	
	/**
	 * Met � jour les informations de connexion de l'utilisateur
	 * @param login
	 * @param password
	 * @return
	 */
	User modifierUtilisateur(String login, String password);
	
	/**
	 * Renvoie l'utilisateur suivant le login fourni 
	 * @param login
	 * @return
	 */
	User getUser(String login);
	
	/**
	 * 
	 * @return liste de tous les utilisateurs (login)
	 */
	List<User> findUsers();
	
	/**
	 * Renvoie le Fanambadiana associ� au mpivavaka pass� en param�tre s'il existe
	 * @param mpivavaka
	 * @return
	 */
	Fanambadiana findFanambadianaByMpivavaka(Mpivavaka mpivavaka);
	
	/**
	 * 
	 * @return les fifidianana existant
	 */
	List<Fifidianana> findAllFifidianana(Integer pageNo, Integer nbElement);

	/**
	 * 
	 * @param parameterNameValues
	 * @param pageNo
	 * @param nbElement
	 * @return Les Fifidianana qui satisfait les crit�res pass�s en param�tre et suivant le num�ro de page
	 */
	public List<Fifidianana> findFifidianana(Map<String, Object> parameterNameValues, Integer pageNo, Integer nbElement);

	/**
	 * @param parameterNameValues
	 * @return le nb de Fifidianana qui satisfait les crit�res pass�s en param�tre
	 */
	public Long findNumberOfFifidianana(Map<String, Object> parameterNameValues);

	/**
	 * 
	 * @param id
	 * @return le Fifidianana par son id
	 */
	Fifidianana findFifidianana(Long id);

	/**
	 * Enregistre en base la cr�ation ou la modification d'un Fifidianana
	 * @param fifidianana
	 * @return le fifidianana enregistr�
	 */
	Fifidianana saveFifidianana(Fifidianana fifidianana, String userName);

	/**
	 * Permet de savoir si le Mpivavaka est d�j� MirotsakaFidiana ou non pour le Fifidianana
	 * @param fifidiananaId
	 * @param mpivavakaIds, les identiifants des Mpivavaka � v�rifier
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
	 * @return MirotsakaFidiana
	 */
	MirotsakaFidiana findMirotsakaFidianaById(Long id);
	
	/**
	 * 
	 * @param fifidiananaId
	 * @param tsyAnkanavaka, si true = tsy ampiasaina ekenaFirotsahana
	 * @param ekenaFirotsahana, si true = lisitry ny mirotsaka efa nekena, si false = lisitry ny mirotsaka efa nolavina, si null lisitry ny mirotsaka mbola tsy nojerena
	 * @param lehilahy, si null alors prend en compte les hommes et les femmes, si true prend uniquement les hommes, si false prend uniquement les femmes
	 * @return le nombre total de Mirotsaka Fidiana
	 */
	Long findNumberOfMirotsakaFidiana(Long fifidiananaId, boolean tsyAnkanavaka, Boolean ekenaFirotsahana, Boolean lehilahy);
	
	/**
	 * 
	 * @param fifidiananaId
	 * @param tsyAnkanavaka, si true alors prise en compte de toutes les candidatures accept�es ou refus�es sans distinction
	 * @param ekenaFirotsahana, si tsyAnkanavaka == false alors
	 * 	si ekenaFirotsahana == true => seulement les candidatures accept�es seront prises en compte, 
	 * 	sinon si ekenaFirotsahana == false => seulement les candidatures refus�es seront prise en compte
	 * @param lehilahy, si null alors toutes les candidatures hommes ou femmes seront prises en compte, si true alors uniquement les hommes, si false alors uniquement les femmes
	 * @param pageNo
	 * @param nbElement
	 * @return les informations d'affichages des MirotsakaFidiana sous forme de Map
	 */
	List<Map<String, Object>> findMirotsakaFidiana(Fifidianana fifidianana, boolean tsyAnkanavaka, Boolean ekenaFirotsahana, Boolean lehilahy, Integer pageNo, Integer nbElement);
	
	/**
	 * 
	 * @param fifidiananaId
	 * @param ekenaFirotsahana, null = Mpirotsaka rehetra, true = mpirotsaka nekena ihany, false = mpirotsaka nolavina ihany
	 * @return les MirotsakaFidiana (Candidatures) d'un Fifidianana (�lection)
	 */
	List<MirotsakaFidiana> findMirotsakaFidiana(Long fifidiananaId, Boolean ekenaFirotsahana);

	/**
	 * renvoie sous-forme de Map (pour raison d'optimisation) les informations sur les candidatures 
	 * @param fifidiananaId
	 * @param ekenaFirotsahana
	 * @param lehilahy, si null alors renvoie toutes les candidatures, si true alors renvoie uniquement les candidatures lehilahy, si false alors renvoie uniquement les candidatures vehivavy
	 * @return Map<String, Object> , cl� = mirotsakaFidianaId/laharanaMpirotsaka/lahy
	 */
	List<Map<String, Object>> findMapMirotsakaFidiana(Long fifidiananaId, Boolean ekenaFirotsahana, Boolean lehilahy);

	/**
	 * initialiser les laharana des MirotsakaFidiana en vue des �lections
	 * @param fifidianana
	 */
	void attributeLaharanaMirotsaka(Fifidianana fifidianana);
	
	/**
	 * 
	 * @param fifidiananaId
	 * @return les statistiques concernant les MirotsakaFidiana
	 */
	Map<String, Integer> getStatMirotsakaFidiana(Long fifidiananaId);
	
	/**
	 * 
	 * @param fifidiananaId
	 * @return le nombre de MirotsakaFidiana non encore trait�
	 */
	int getNumberMirotsakaFidianaNotChecked(Long fifidiananaId);

	/**
	 * Ampitomboina 1 avy ny vato azon'ny candidat ao anatin'ny mirotsakaFidianaIds
	 * @param fifidianana
	 * @param vatoLaharana, num�ro du bulletin de vote
	 * @param mirotsakaFidianaIds, les identifiants des MirotsakaFidiana des candidats qui ont obtenu chacun un voix suppl�mentaire
	 * @param vatoMaty, si true alors le voix sera comptabilis� comme nul
	 * @param vatoFotsy, si true alors le voix sera comptabilis� comme blanc
	 * @param lehilahy, si null = la comptabilisation s'effectue sur les candidats sans distinction de genre, si true la comptabilisation s'effectue uniquement sur les candidats masculins
	 * 		  si false alors la comptabilisation s'effectue uniquement sur les candidats f�minins
	 * @param isFamerenana, true si il s'agit d'une re-edition d'un bulletin de vote saisi pr�c�demment
	 * @param username, le nom de l'op�rateur de saisie
	 * @param ip, l'adresse IP de la machine cliente
	 * @return FanisamBato  synth�se du comptabilisation du scrutin
	 * NOTE : pour que le vote soit valable, il ne faut pas que le nombre de choix s�lectionn� ne d�passe 140 dont 70 hommes et 70 femmes
	 * Ex : si le bulletin de vote comporte 141 choix coch�s alors le VOTE est nul.
	 * si le bulletin de vote comporte moins de 140 choix coch�s , et si pour un sexe donn� le nombre total de choix ne d�passe pas 70 alors le vote est pris en compte
	 * @throws CreationVatoException
	 */
	FanisamBato isaoVato(Fifidianana fifidianana, String vatoLaharana, Set<Long> mirotsakaFidianaIds, boolean vatoMaty, boolean vatoFotsy, Boolean lehilahy, boolean isFamerenana, String username, String ip) throws CreationVatoException;
	
	/**
	 * Cr�er un Vato avec les s�lections sans comptabiliser. Cette m�thode est surtout utilis�es dans le cas o�
	 * le Vato est maty OU fotsy afin de garder trace du bulletin dans le syst�me
	 * @param fifidianana
	 * @param laharana
	 * @param lehilahy
	 * @param mirotsakaFidianaIds
	 * @param isFamerenana, si true alors le Vato est d�j� en base et sera mise � jour et non cr��.
	 * @param username, le nom du cr�ateur ou du modifieur
	 * @param ip, l'adresse IP de la machine cliente
	 * @return
	 * @throws CreationVatoException
	 */
	Vato creerVato(Fifidianana fifidianana, String laharana, Boolean lehilahy, Set<Long> mirotsakaFidianaIds, boolean isFamerenana, String username, String ip) throws CreationVatoException;
	
	/**
	 * mitady vato anaty fifidianana @ alalan'ny laharany
	 * @param laharana
	 * @param fifidiananaId
	 * @param lehilahy
	 * @return
	 */
	Vato findVato(String laharana, Long fifidiananaId, Boolean lehilahy);
	
	/**
	 * Anesorana 1 ny vaton'ny candidat ao anatin'ny mirotsakaFidianaIds
	 * @param fifidianana
	 * @param mirotsakaFidianaIds
	 * @param lehilahy
	 * @return
	 */
	FanisamBato esoryVato(Fifidianana fifidianana, Set<Long> mirotsakaFidianaIds, Boolean lehilahy);

	/**
	 * Anesorana 1 ny isan'ny vatoMaty NA vatoFotsy (fa tsy izy 2 miaraka akory)
	 * @param fifidianana
	 * @param vatoMaty
	 * @param vatoFotsy
	 * @param lehilahy
	 * @return
	 */
	FanisamBato esoryVatoMatyNaFotsy(Fifidianana fifidianana, boolean vatoMaty, boolean vatoFotsy, Boolean lehilahy);
	
	/**
	 * 
	 * @param fifidianana
	 * @param lehilahy, si null = la comptabilisation s'effectue sur les candidats sans distinction de genre, si true la comptabilisation s'effectue uniquement sur les candidats masculins
	 * 		  si false alors la comptabilisation s'effectue uniquement sur les candidats f�minins
	 * @return FanisamBato associ� au Fifidianana
	 */
	FanisamBato findFanisamBatoByFifidianana(Fifidianana fifidianana, Boolean lehilahy);

	/**
	 * 
	 * @param laharanaIds
	 * @return Map<laharanaMpirotsaka, MirotsakaFidianaId>
	 */
	Map<Integer, Long> getLaharana2MirotsakaFidianaId(Collection<Integer> laharanaIds);

	/**
	 * Le nombre de voix obtenu par les candidats pour un fifidianana donn� <br/>
	 * Le nombre de r�sultat renvoy� est param�tr� et tri� par nb de voix obtenu <br/>
	 * le cl� est compos� du laharanaMpirotsaka et du nom du candidat
	 * @param fifidiananaId
	 * @param lahy
	 * @param izayNahazoVato, si true alors seulement les candidats ayant obtenu au moins un voix
	 * @param pageNo
	 * @param nbElement
	 * @return Map<laharanaMirotsaka + Nom, isamBato>
	 */
	List<Map<String, Object>> getIsamBatoAmbonyIndrindra(Long fifidiananaId, Boolean lahy, boolean izayNahazoVato, Integer pageNo, Integer nbElement);

	/**
	 * Les candidats ayant obtenus le plus grand nombre de voix.
	 * Tri� par ordre alphab�tique
	 * Le nombre de candidat admis est donn� par fifidianana.getIsaOlonaFidiana()
	 * @param fifidianana
	 * @param lahy
	 * @return
	 */
	List<Map<String, Object>> getIsamBatoAmbonyIndrindraOrderByName(Fifidianana fifidianana, Boolean lahy);
	
	/**
	 * 
	 * @param fifidiananaId
	 * @param lahy
	 * @param izayNahazoVato
	 * @return le nombre de lignes max pour l'affichage des r�sultats temporaires
	 */
	Integer getNbMaxResult(Long fifidiananaId, Boolean lahy, boolean izayNahazoVato);

	/**
	 * Permet de savoir si le vote peut commencer, si les conditions suivantes sont toutes remplies :
	 * - Toutes les candidatures accept�es ont leur num�ro attribu�e
	 * - La date de vote est la date du jour
	 * @param fifidianana
	 * @return true si on peut voter � la date du jour
	 */
	public boolean canBeginVote(Fifidianana fifidianana);
	
	/**
	 * 
	 * @param fifidianana
	 * @return true si toutes les MirotsakaFidiana accept�e ont d�j� leur num�ro laharanaMirotsaka
	 */
	boolean haveAllMirotsakaFidianaEkenaLaharana(Fifidianana fifidianana);
	
	/**
	 * @return parameter, le param�tre de l'utilisateur depuis la base de donn�es sinon le cr�e et l'enregistre en base
	 * NOTE : un utilisateur doit au plus avoir un seul et unique param�tre en base
	 */
	Parameter findParameterByUser(String login);
	
	/**
	 * Enregistre en base les modifications effectu�es sur parameter
	 * @param parameter
	 */
	void saveParameter(Parameter parameter);

	/**
	 * Modifie le mot de passe de l'utilisateur
	 * @return true si la modification est ok, false sinon
	 */
	boolean updatePassword(String userLogin, String lastPass, String newPass);
	
	/**
	 * R�-initialise � 0 les voies obtenues dans MirotsakaFidiana pour le Fifidianana ET
	 * R�-initialise � 0 les statistiques dans Fanisambato 
	 * @param id
	 */
	void initFifidianana(Long id);

	/**
	 * Ajoute une nouvelle IP autoris�e dans la base et dans le cache
	 * @param ip
	 * @param description
	 */
	void addAuthorizedId(String ip, String description);
	
	/**
	 * Supprime une IP anciennement autoris�e dans la base et dans le cache
	 * @param ip
	 */
	void removeAuthorizedIP(String ip);
	
	/**
	 * V�rifie si une IP donn�e est autoris�e ou non
	 * NOTE : v�rifie dans le cache d'abord (pour des raisons de performances), si non trouv� dans le cache alors v�rifie en base
	 * @param ip
	 * @return true si authoris�e, false sinon
	 */
	boolean isIPAuthorized(String ip);
	
	/**
	 * Permet d'activer/d�sactiver l'IP 
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
	 * Supprime en base et en cache l'IP autoris�e. Par la suite l'IP ne sera plus autoris�e
	 * @param id
	 */
	void deleteAuthorizedIP(Long id);

	/**
	 * 
	 * @param id
	 * @return l'instance de AuthorizedIP par son id
	 */
	AuthorizedIP findAuthorizedIP(Long id);

	/**
	 * r�cup�re les stats des bulletins de vote saisis sur la machine dont l'IP est donn�e en param�tre
	 * @param fifidiananaId
	 * @param lehilahy
	 * @param ip
	 * @return Map, les cl�s sont isaVatoVoaisa, isaVatoManankery, isaVatoFotsy, isaVatoMaty
	 */
	Map<String, Long> getStats(Long fifidiananaId, boolean lehilahy, String ip);
	
	/**
	 * Permet de d�marrer ou d'interdire le fanisambato pour le fifidianana
	 * @param fifidiananaId
	 * @param start
	 */
	void startStopFanisambato(Long fifidiananaId, boolean start);
	
	/**
	 * 
	 * @param fifidiananaId
	 * @return true si l'on peut proc�der au fanisambato.
	 */
	boolean canProcessFanisambato(Long fifidiananaId);
}
