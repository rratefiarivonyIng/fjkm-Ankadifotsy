package mg.fjkm.ankadifotsy.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import mg.fjkm.ankadifotsy.bo.AntonAsa;
import mg.fjkm.ankadifotsy.bo.AuthorizedIP;
import mg.fjkm.ankadifotsy.bo.District;
import mg.fjkm.ankadifotsy.bo.Etat;
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
import mg.fjkm.ankadifotsy.dao.FjkmAnkadifotsyDao;
import mg.fjkm.ankadifotsy.exception.CreationVatoException;
import mg.fjkm.ankadifotsy.util.Utils;

/**
 * Implémentation hibernate du service pour IntraPoste
 * 
 * @author rija
 * @version 1.0
 */
public class FjkmAnkadifotsyServiceImpl implements FjkmAnkadifotsyService {

	private FjkmAnkadifotsyDao fFjkmAnkadifotsyDao = null;

	public void setFjkmAnkadifotsyDao(FjkmAnkadifotsyDao fjkmAnkadifotsyDao) {
		fFjkmAnkadifotsyDao = fjkmAnkadifotsyDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mg.fjkm.ankadifotsy.service.FjkmAnkadifotsyService#findFitandremanaById
	 * (java.lang.Integer)
	 */
	public Fitandremana findFitandremanaById(Long id) {
		return fFjkmAnkadifotsyDao.findFitandremanaById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mg.fjkm.ankadifotsy.service.FjkmAnkadifotsyService#findAllFitandremana()
	 */
	public List<Fitandremana> findAllFitandremana() {
		return fFjkmAnkadifotsyDao.findAllfitandremana();
	}

	public Mpivavaka saveMpivavaka(Mpivavaka mpivavaka, String userName) {
		User user = fFjkmAnkadifotsyDao.getUser(userName);
		Date date = new Date();

		if (mpivavaka.getId() == null)
			mpivavaka.setCreateInfo(date, user);
		else
			mpivavaka.setModificationInfo(date, user);

		return fFjkmAnkadifotsyDao.saveMpivavaka(mpivavaka);
	}

	public synchronized Mpivavaka saveMpivavaka(Mpivavaka mpivavaka,
			Mpivavaka vady, Mpivavaka vadyTaloha, Fanambadiana fanambadiana,
			String userName) {
		User user = fFjkmAnkadifotsyDao.getUser(userName);
		Date date = new Date();

		if (mpivavaka.getId() == null)
			mpivavaka.setCreateInfo(date, user);
		else
			mpivavaka.setModificationInfo(date, user);

		mpivavaka = fFjkmAnkadifotsyDao.saveMpivavaka(mpivavaka);

		if (fanambadiana != null) {
			if (fanambadiana.getId() == null) {
				fanambadiana.setCreateInfo(date, user);
				fanambadiana.setMpivavaka(mpivavaka);
			} else {
				assert fanambadiana.getMpivavaka() != null;
				fanambadiana.setModificationInfo(date, user);
			}

			fFjkmAnkadifotsyDao.saveFanambadiana(fanambadiana);

			if (vady != null) {
				vady.addFanambadiana(fanambadiana);
				fFjkmAnkadifotsyDao.saveMpivavaka(vady);
			}

			mpivavaka.addFanambadiana(fanambadiana);
		}

		if (vadyTaloha != null)
			fFjkmAnkadifotsyDao.saveMpivavaka(vadyTaloha);

		return mpivavaka;
	}

	public Mpivavaka findMpivavakaByLaharana(String laharana) {
		return fFjkmAnkadifotsyDao.findMpivavakaByLaharana(laharana);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mg.fjkm.ankadifotsy.service.FjkmAnkadifotsyService#findMpivavakaById(
	 * java.lang.String)
	 */
	public Mpivavaka findMpivavakaById(Long id) {
		return fFjkmAnkadifotsyDao.findMpivavakaById(id);
	}

	public List<TaomPanompoana> findAllTaomPanompoana() {
		return fFjkmAnkadifotsyDao.findAllTaomPanompoana();
	}

	public List<TaomPanompoana> findTaomPanompoanasWithoutDaty(Date daty) {
		if (daty != null)
			return fFjkmAnkadifotsyDao.findTaomPanompoanasWithoutDaty(daty);
		else
			return fFjkmAnkadifotsyDao.findAllTaomPanompoana();
	}

	public TaomPanompoana findTaomPanompoanaById(Long id) {
		return fFjkmAnkadifotsyDao.findTaomPanompoanaById(id);
	}

	public TaomPanompoana findTaomPanompoanaByDate(Date daty) {
		return fFjkmAnkadifotsyDao.findTaomPanompoanaByDate(daty);
	}

	/**
	 * 
	 * @param parameters
	 * @return TaomPanompoana selon les critères spécifiés dans la paramètre
	 *         (Ajax)
	 */
	public List<TaomPanompoana> getTaomPanompoana(Map<String, String> parameters) {
		return fFjkmAnkadifotsyDao.getTaomPanompoana(parameters);
	}

	public KarazamPifidianana findKarazamPifidiananaById(Long id) {
		return fFjkmAnkadifotsyDao.findKarazamPifidiananaById(id);
	}

	/**
	 * 
	 * @return les mpivavaka existant
	 */
	public List<Mpivavaka> findAllMpivavaka(Integer pageNo, Integer nbElement) {
		return fFjkmAnkadifotsyDao.findAllMpivavaka(pageNo, nbElement);
	}

	/**
	 * 
	 * @param parameterNameValues
	 * @param pageNo
	 * @param nbElement
	 * @return Les Mpivavaka qui satisfait les critères passés en paramètre et
	 *         suivant le numéro de page
	 */
	public List<Mpivavaka> findMpivavaka(
			Map<String, Object> parameterNameValues, Integer pageNo,
			Integer nbElement) {
		return fFjkmAnkadifotsyDao.findMpivavaka(parameterNameValues, pageNo,
				nbElement);
	}

	/**
	 * 
	 * @param parameterNameValues
	 * @return le nb de Mpivavaka qui satisfait les critères passés en paramètre
	 */
	public Long findNumberOfMpivavaka(Map<String, Object> parameterNameValues) {
		return fFjkmAnkadifotsyDao.findNumberOfMpivavaka(parameterNameValues);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mg.fjkm.ankadifotsy.service.FjkmAnkadifotsyService#getFaritras(java.util
	 * .Map)
	 */
	public List<Faritra> getFaritras(Map<String, String> parameters) {
		return fFjkmAnkadifotsyDao.getFaritras(parameters);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mg.fjkm.ankadifotsy.service.FjkmAnkadifotsyService#getFiraisanas(java
	 * .lang.String)
	 */
	public List<Firaisana> getFiraisanas(String label) {
		return fFjkmAnkadifotsyDao.getFiraisanas(label);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mg.fjkm.ankadifotsy.service.FjkmAnkadifotsyService#findFaritra(java.lang
	 * .Integer)
	 */
	public Faritra findFaritra(Long id) {
		return fFjkmAnkadifotsyDao.findFaritra(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mg.fjkm.ankadifotsy.service.FjkmAnkadifotsyService#findFiraisana(java
	 * .lang.Integer)
	 */
	public Firaisana findFiraisana(Long id) {
		return fFjkmAnkadifotsyDao.findFiraisana(id);
	}

	public AntonAsa findAntonAsa(Long id) {
		return fFjkmAnkadifotsyDao.findAntonAsa(id);
	}

	public Firaisana findCommune(Long id) {
		return fFjkmAnkadifotsyDao.findCommune(id);
	}

	public District findDistrict(Long id) {
		return fFjkmAnkadifotsyDao.findDistrict(id);
	}

	public List<AntonAsa> getAntonAsas(Map<String, String> parameters) {
		return fFjkmAnkadifotsyDao.getAntonAsas(parameters);
	}

	public List<Mpivavaka> getMpivavaka(Map<String, String> parameters) {
		return fFjkmAnkadifotsyDao.getMpivavaka(parameters);
	}

	public List<ILabelable> getLabelablesForAutoCompletion(
			Map<String, String> parameters) {
		return fFjkmAnkadifotsyDao.getAutoCompletionLabelable(parameters,
				Fitandremana.class);
	}

	public List<ILabelable> getKarazamPifidianana(Map<String, String> parameters) {
		return fFjkmAnkadifotsyDao.getAutoCompletionLabelable(parameters,
				KarazamPifidianana.class);
	}

	public List<Faritra> getCentreFiscaux() {
		return fFjkmAnkadifotsyDao.getCentreFiscaux();
	}

	public List<Faritra> getCentreFiscaux(Map<String, String> parameters) {
		return fFjkmAnkadifotsyDao.getCentreFiscaux(parameters);
	}

	public List<Firaisana> getCommunes() {
		return fFjkmAnkadifotsyDao.getCommunes();
	}

	public List<Firaisana> getCommunes(Map<String, String> parameters) {
		return fFjkmAnkadifotsyDao.getCommunes(parameters);
	}

	public List<Firaisana> getCommunesParDisctrict(Integer idDistrict) {
		return fFjkmAnkadifotsyDao.getCommunesParDisctrict(idDistrict);
	}

	public List<Mpivavaka> getContribuables(Map<String, String> parameters) {
		return fFjkmAnkadifotsyDao.getContribuablesAvecDoublons(parameters);
	}

	public List<Mpivavaka> getContribuables(String typeRecherche, String filter) {
		return fFjkmAnkadifotsyDao.getContribuables(typeRecherche, filter);
	}

	public List<Mpivavaka> getContribuablesAcceptables(Long idCentreFiscal) {
		return fFjkmAnkadifotsyDao.getContribuablesParEtat(
				Etat.sfID_APPROUVABLE, idCentreFiscal);
	}

	public List<Mpivavaka> getContribuablesNonVerifies(Long idCentreFiscal) {
		return fFjkmAnkadifotsyDao.getContribuablesParEtat(
				Etat.sfID_NON_VERIFIE, idCentreFiscal);
	}

	public List<Mpivavaka> getContribuablesRejetes(Long idCentreFiscal) {
		return fFjkmAnkadifotsyDao.getContribuablesParEtat(Etat.sfID_REJETEE,
				idCentreFiscal);
	}

	public List<Mpivavaka> getContribuablesValides(Long idCentreFiscal) {
		return fFjkmAnkadifotsyDao.getContribuablesParEtat(Etat.sfID_VALIDEE,
				idCentreFiscal);
	}

	public Mpivavaka getContribuableByReference(Long taxPayerNo) {
		List<Mpivavaka> list = fFjkmAnkadifotsyDao.getContribuables(taxPayerNo);
		Mpivavaka ret = null;
		if (taxPayerNo != null) {
			if (list.size() == 1)
				ret = list.get(0);
		}
		return ret;
	}

	public Mpivavaka getContribuableByNif(String nif) {
		return fFjkmAnkadifotsyDao.getContribuableByNif(nif);
	}

	public Mpivavaka getContribuableByAncienNif(String ancienNif) {
		return fFjkmAnkadifotsyDao.getContribuableByAncienNif(ancienNif);
	}

	public List<District> getDistricts() {
		return fFjkmAnkadifotsyDao.getDistricts();
	}

	public List<District> getDistricts(Map<String, String> parameters) {
		return fFjkmAnkadifotsyDao.getDistricts(parameters);
	}

	public List<District> getDistrictsParRegion(Integer idRegion) {
		return fFjkmAnkadifotsyDao.getDistrictsParRegion(idRegion);
	}

	public Province getProvince(Long id) {
		return fFjkmAnkadifotsyDao.getProvince(id);
	}

	public List<Province> getProvinces() {
		return fFjkmAnkadifotsyDao.getProvinces();
	}

	public List<Province> getProvinces(String intitule) {
		return fFjkmAnkadifotsyDao.getProvinces(intitule);
	}

	public Region getRegion(Long id) {
		return fFjkmAnkadifotsyDao.getRegion(id);
	}

	public List<Region> getRegions() {
		return fFjkmAnkadifotsyDao.getRegions();
	}

	public List<Region> getRegionsParProvince(Integer idProvince) {
		return fFjkmAnkadifotsyDao.getRegionsParProvince(idProvince);
	}

	public List<Region> getRegions(Map<String, String> parameters) {
		return fFjkmAnkadifotsyDao.getRegions(parameters);
	}

	public Mpivavaka validerContribuable(Mpivavaka contribuable) {
		return contribuable;
	}

	public void removeContribuable(Mpivavaka contribuable) {
		fFjkmAnkadifotsyDao.removeContribuable(contribuable);
	}

	public List<Mpivavaka> getDoublons(Mpivavaka contribuable) {
		List<Mpivavaka> contribuables = fFjkmAnkadifotsyDao
				.getContribuablesParEtat(Etat.sfID_VALIDEE, null);
		List<Mpivavaka> ret = new Vector<Mpivavaka>();
		for (Mpivavaka current : contribuables) {
			// if (Utils.isDoublon(contribuable, current))
			ret.add(current);
		}
		return ret;
	}

	public List<Mpivavaka> getDoublons(Map<String, String> parameters) {
		List<Mpivavaka> ret = new Vector<Mpivavaka>();
		if (parameters != null && parameters.size() > 0) {
			List<Mpivavaka> contribuables = fFjkmAnkadifotsyDao
					.getContribuablesParEtatPourDoublon(Etat.sfID_EN_INSTANCE);
			for (Mpivavaka contribuable : contribuables) {
				// if (Utils.isDoublon(parameters, contribuable))
				ret.add(contribuable);
			}
		}
		return ret;
	}

	public String creerUtilisateurPourContribuable(Mpivavaka contribuable) {
		String motDePasse = null;
		return motDePasse;
	}

	public mg.fjkm.ankadifotsy.bo.User modifierUtilisateur(String login,
			String password) {
		mg.fjkm.ankadifotsy.bo.User user = fFjkmAnkadifotsyDao.getUser(login);
		if (user != null) {
			user.setPassword(password);
			fFjkmAnkadifotsyDao.saveUser(user);
		}
		return user;
	}

	public mg.fjkm.ankadifotsy.bo.User getUser(String login) {
		return fFjkmAnkadifotsyDao.getUser(login);
	}

	public List<mg.fjkm.ankadifotsy.bo.User> findUsers() {
		return fFjkmAnkadifotsyDao.findUsers();
	}

	public Fanambadiana findFanambadianaByMpivavaka(Mpivavaka mpivavaka) {
		return fFjkmAnkadifotsyDao.findFanambadianaByMpivavaka(mpivavaka);
	}

	public List<Fifidianana> findAllFifidianana(Integer pageNo,
			Integer nbElement) {
		return fFjkmAnkadifotsyDao.findAllFifidianana(pageNo, nbElement);
	}

	public List<Fifidianana> findFifidianana(
			Map<String, Object> parameterNameValues, Integer pageNo,
			Integer nbElement) {
		return fFjkmAnkadifotsyDao.findFifidianana(parameterNameValues, pageNo,
				nbElement);
	}

	public Long findNumberOfFifidianana(Map<String, Object> parameterNameValues) {
		return fFjkmAnkadifotsyDao.findNumberOfFifidianana(parameterNameValues);
	}

	public Fifidianana findFifidianana(Long id) {
		return fFjkmAnkadifotsyDao.findFifidianana(id);
	}

	public Fifidianana saveFifidianana(Fifidianana fifidianana, String userName) {
		if (fifidianana != null) {
			User user = fFjkmAnkadifotsyDao.getUser(userName);
			Date date = new Date();
			if (fifidianana.getId() == null)
				fifidianana.setCreateInfo(date, user);
			else
				fifidianana.setModificationInfo(date, user);
		}
		return fFjkmAnkadifotsyDao.saveFifidianana(fifidianana);
	}

	public synchronized MirotsakaFidiana saveMirotsakaFidiana(
			MirotsakaFidiana mirotsakaFidiana) {
		return fFjkmAnkadifotsyDao.saveMirotsakaFidiana(mirotsakaFidiana);
	}

	public Map<Long, Long> findMapMpivavakaId2MirotsakaFidianaIdByTaomPanompoanaId(
			Long fifidiananaId, Collection<Long> mpivavakaIds) {
		return fFjkmAnkadifotsyDao
				.findMapMpivavakaId2MirotsakaFidianaIdByTaomPanompoanaId(
						fifidiananaId, mpivavakaIds);
	}

	public MirotsakaFidiana findMirotsakaFidianaById(Long id) {
		return fFjkmAnkadifotsyDao.findMirotsakaFidianaById(id);
	}

	public List<Map<String, Object>> findMirotsakaFidiana(
			Fifidianana fifidianana, boolean tsyAnkanavaka,
			Boolean ekenaFirotsahana, Boolean lehilahy, Integer pageNo,
			Integer nbElement) {
		return fFjkmAnkadifotsyDao.findMirotsakaFidiana(fifidianana,
				tsyAnkanavaka, ekenaFirotsahana, lehilahy, pageNo, nbElement);
	}

	public Long findNumberOfMirotsakaFidiana(Long fifidiananaId,
			boolean tsyAnkanavaka, Boolean ekenaFirotsahana, Boolean lehilahy) {
		return fFjkmAnkadifotsyDao.findNumberOfMirotsakaFidiana(fifidiananaId,
				tsyAnkanavaka, ekenaFirotsahana, lehilahy);
	}

	/**
	 * initialiser les laharana des MirotsakaFidiana en vue des élections
	 * 
	 * @param fifidianana
	 */
	public void attributeLaharanaMirotsaka(Fifidianana fifidianana) {
		if (fifidianana != null) {
			// vérifier que la réception des candidatures pour le fifidianana
			// est close
			Date now = new Date();
			if (fifidianana.getDatyManakatona() != null) {
				if (now.getTime() > fifidianana.getDatyManakatona().getTime())
					throw new RuntimeException("Fifidianana efa mikatona");
			}

			if (now.getTime() < fifidianana.getDatyMamaranaFirotsahana().getTime())
				throw new RuntimeException("Mbola tsy mikatona ny firotsahana ho fidiana");

			// Charger tous les candidats acceptés trié par ordre de dépôt de candidature
			List<MirotsakaFidiana> list = fFjkmAnkadifotsyDao.findMirotsakaFidiana(fifidianana.getId(), false, true);

			// pour chaque candidat : initialiser le numéro et passer sur le
			// suivant
			// si élection d'un seul candidat alors les numéros sont uniques à
			// chaque candidat
			attributeLaharana(list, fifidianana.isFifidiananaOloTokana() ? true : fifidianana.isMitohyLaharana());
		}
	}

	/**
	 * 
	 * @param list
	 * @param mitohy
	 *            si true alors les laharana générés se suivent pour tous les
	 *            candidats si false alors les laharana débutent par 1 pour les
	 *            candidats féminins et idem pour les candidats masculins
	 */
	private void attributeLaharana(List<MirotsakaFidiana> list, boolean mitohy) {
		if (mitohy) {
			int laharana = 1;
			for (MirotsakaFidiana mirotsakaFidiana : list) {
				mirotsakaFidiana.setLaharanaMpirotsaka(laharana);
				laharana++;
			}
		} else {
			int laharanaLahy = 1, laharanaVavy = 1;
			for (MirotsakaFidiana mirotsakaFidiana : list) {
				if (mirotsakaFidiana.getMpivavaka().isLahy()) {
					mirotsakaFidiana.setLaharanaMpirotsaka(laharanaLahy);
					laharanaLahy++;
				} else {
					mirotsakaFidiana.setLaharanaMpirotsaka(laharanaVavy);
					laharanaVavy++;
				}
			}
		}
	}

	/**
	 * 
	 * @param fifidiananaId
	 * @param ekenaFirotsahana
	 *            , null = Mpirotsaka rehetra, true = mpirotsaka nekena ihany,
	 *            false = mpirotsaka nolavina ihany
	 * @return les MirotsakaFidiana (Candidatures) d'un Fifidianana (élection)
	 */
	public List<MirotsakaFidiana> findMirotsakaFidiana(Long fifidiananaId,
			Boolean ekenaFirotsahana) {
		return fFjkmAnkadifotsyDao.findMirotsakaFidiana(fifidiananaId, true, ekenaFirotsahana);
	}

	public List<Map<String, Object>> findMapMirotsakaFidiana(Long fifidiananaId, Boolean ekenaFirotsahana, Boolean lehilahy) {
		return fFjkmAnkadifotsyDao.findMapMirotsakaFidiana(fifidiananaId, ekenaFirotsahana, lehilahy, false);
	}

	/**
	 * 
	 * @param fifidiananaId
	 * @return les statistiques concernant les MirotsakaFidiana
	 */
	public Map<String, Integer> getStatMirotsakaFidiana(Long fifidiananaId) {
		Map<String, Integer> ret = new HashMap<String, Integer>();
		ret.put("numberTotalMirotsakaFidiana", fFjkmAnkadifotsyDao.getNumberMirotsakaFidiana(fifidiananaId));
		ret.put("numberNotChecked", fFjkmAnkadifotsyDao.getNumberMirotsakaFidiana(fifidiananaId, null));
		ret.put("numberCheckedOk", fFjkmAnkadifotsyDao.getNumberMirotsakaFidiana(fifidiananaId, true));
		ret.put("numberCheckedKo", fFjkmAnkadifotsyDao.getNumberMirotsakaFidiana(fifidiananaId, false));
		return ret;
	}

	public int getNumberMirotsakaFidianaNotChecked(Long fifidiananaId) {
		return fFjkmAnkadifotsyDao.getNumberMirotsakaFidiana(fifidiananaId, null);
	}

	/**
	 * 
	 * @param fifidianana
	 * @param vatoLaharana : numéro du bulletin de vote
	 * @param mirotsakaFidianaIds
	 *            , les mirotsakaFidianaIds des candidats qui ont obtenu chacun
	 *            un voix supplémentaire
	 * @return FanisamBato synthèse du comptabilisation du scrutin NOTE : pour
	 *         que le vote soit valable, il ne faut pas que le nombre de choix
	 *         sélectionné ne dépasse 140 dont 70 hommes et 70 femmes Ex : si le
	 *         bulletin de vote comporte 141 choix cochés alors le VOTE est nul.
	 *         si le bulletin de vote comporte moins de 140 choix cochés , et si
	 *         pour un sexe donné le nombre total de choix ne dépasse pas 70
	 *         alors le vote est pris en compte
	 * @throws CreationVatoException 
	 */
	public synchronized FanisamBato isaoVato(Fifidianana fifidianana,
			String vatoLaharana,
			Set<Long> mirotsakaFidianaIds, boolean vatoMaty, boolean vatoFotsy,
			Boolean lehilahy,
			boolean isFamerenena,
			String username,
			String ip) throws CreationVatoException {
		FanisamBato ret = null;

		if (vatoLaharana == null || "".equals(vatoLaharana.trim()))
			throw new CreationVatoException("Ampidiro ny laharan'ny vato");
		
		if (fifidianana != null && fifidianana.getId() != null) {
			if (fifidianana.getIsan_Nomerao() != null){
				if (vatoLaharana.trim().length() != fifidianana.getIsan_Nomerao().intValue())
					throw new CreationVatoException("Tsy mety ny laharana ["+vatoLaharana+"]. "+Utils.getVatoLaharanaPadded(vatoLaharana, '0', fifidianana.getIsan_Nomerao())+" no mety.");
			}

			if (isFamerenena){
				//Retrancher d'abord les fanisambato réalisés auparavant
				Vato vatoTaloha = findVato(vatoLaharana, fifidianana.getId(), lehilahy);
				if (vatoTaloha == null)
					throw new RuntimeException("Vato laharana ["+vatoLaharana+"] tsy mbola misy.");

				if (!vatoTaloha.isVatoFotsy() && !vatoTaloha.isVatoMaty()){
					//Nisaina ny vato teo aloha fa tsy vato maty na vato fotsy akory
					//esorina ny isam-bato teo aloha
					ret = esoryVato(fifidianana, vatoTaloha.getSafidys(), lehilahy);
				}
				else{
					ret = esoryVatoMatyNaFotsy(fifidianana, vatoTaloha.isVatoMaty(), vatoTaloha.isVatoFotsy(), lehilahy);
				}
			}
			else
				ret = fFjkmAnkadifotsyDao.getFanisamBato(fifidianana, lehilahy);

			//le vatoLaharana est vérifié. S'il y a un pb alors le reste du code ne sera pas exécuté ET on revient vers le controlleur appelant qui traitera l'exception 
			creerVato(fifidianana, vatoLaharana, lehilahy, mirotsakaFidianaIds, isFamerenena, username, ip);

			ret.incrementIsamBatoVoaisa();

			if (vatoMaty)
				ret.incrementIsamBatoMaty();
			else if (vatoFotsy)
				ret.incrementIsamBatoFotsy();
			else if (mirotsakaFidianaIds != null && mirotsakaFidianaIds.size() > 0)
				fFjkmAnkadifotsyDao.ampioVatoIrayNyMpirotsakas(fifidianana, mirotsakaFidianaIds);
			else 
				throw new RuntimeException("Tsy tokony ho tonga eto.");
		}

		return ret;
	}

	public synchronized Vato creerVato(Fifidianana fifidianana, String laharana, Boolean lehilahy, Set<Long> mirotsakaFidianaIds, boolean isFamerenana, String username, String ip) throws CreationVatoException{
		Vato ret = null;

		//Info de création / modification diakona
		User user = fFjkmAnkadifotsyDao.getUser(username);
		Date now = new Date();

		if (laharana == null || "".equals(laharana.trim()))
			throw new CreationVatoException("Nomerao bulletin tsy misy!");
		else{
			ret = findVato(laharana, fifidianana.getId(), lehilahy);
			if (ret != null){
				if (!isFamerenana)
					throw new CreationVatoException("Nomerao ["+laharana+"] efa miasa.");
				else{
					ret.setSafidy(mirotsakaFidianaIds);	//Mis à jour des choix sélectionnés
					ret.setModificationInfo(now, user);
					ret.setIp(ip);
				}
			}
			else{
				ret = new Vato();
				ret.setVatoLaharana(laharana);
				ret.setFifidianana(fifidianana);
				ret.setLehilahy(lehilahy);
				ret.setSafidy(mirotsakaFidianaIds);
				ret.setCreateInfo(now, user);
				ret.setIp(ip);
			}
		}

		return fFjkmAnkadifotsyDao.saveVato(ret);
	}	
	
	public Vato findVato(String laharana, Long fifidiananaId, Boolean lehilahy) {
		return fFjkmAnkadifotsyDao.findVato(laharana, fifidiananaId, lehilahy);
	}

	public synchronized FanisamBato esoryVato(Fifidianana fifidianana,
			Set<Long> mirotsakaFidianaIds, Boolean lehilahy) {
		FanisamBato ret = null;

		if (fifidianana != null && fifidianana.getId() != null) {
			ret = fFjkmAnkadifotsyDao.getFanisamBato(fifidianana, lehilahy);

			ret.decrementIsamBatoVoaisa();

			if (mirotsakaFidianaIds != null && mirotsakaFidianaIds.size() > 0)
				fFjkmAnkadifotsyDao.esoryVatoIrayNyMpirotsakas(fifidianana, mirotsakaFidianaIds);
		}

		return ret;
	}

	public synchronized FanisamBato esoryVatoMatyNaFotsy(Fifidianana fifidianana, boolean vatoMaty, boolean vatoFotsy, Boolean lehilahy){
		FanisamBato ret = null;

		if (vatoMaty && vatoFotsy)
			throw new RuntimeException("NA vato maty NA vato Fotsy fa tsy izy 2 miaraka");
		
		if (fifidianana != null && fifidianana.getId() != null) {
			ret = fFjkmAnkadifotsyDao.getFanisamBato(fifidianana, lehilahy);

			if (vatoMaty)
				ret.decrementIsamBatoMaty();
			else if (vatoFotsy)
				ret.decrementIsamBatoFotsy();
		}
		
		return ret;
		
	}
	
	public Map<Integer, Long> getLaharana2MirotsakaFidianaId(Collection<Integer> laharanaIds) {
		return fFjkmAnkadifotsyDao.getLaharana2MirotsakaFidianaId(laharanaIds);
	}

	public FanisamBato findFanisamBatoByFifidianana(Fifidianana fifidianana, Boolean lehilahy) {
		return fFjkmAnkadifotsyDao.getFanisamBato(fifidianana, lehilahy);
	}

	public synchronized List<Map<String, Object>> getIsamBatoAmbonyIndrindra(
			Long fifidiananaId, Boolean lahy, boolean izayNahazoVato,
			Integer pageNo, Integer nbElement) {
		return fFjkmAnkadifotsyDao.getIsamBatoAmbonyIndrindra(fifidiananaId, lahy, izayNahazoVato, pageNo, nbElement);
	}

	private Map<String, Object> getMapByLaharana(
			List<Map<String, Object>> datas, Integer laharana) {
		Map<String, Object> result = null;
		if (laharana != null) {
			for (Map<String, Object> map : datas) {
				if (laharana.equals(map.get("laharana"))) {
					result = map;
					break;
				}
			}
		}
		return result;
	}

	public synchronized List<Map<String, Object>> getIsamBatoAmbonyIndrindraOrderByName(
			Fifidianana fifidianana, Boolean lahy) {
		assert fifidianana != null;
		int pageNo = 0;
		int nbElement = fifidianana.getIsaOlonaFidiana();

		List<Map<String, Object>> listMap = fFjkmAnkadifotsyDao.getIsamBatoAmbonyIndrindra(fifidianana.getId(), lahy, true, pageNo, nbElement);
		List<Integer> laharanaMpirotsakas = new ArrayList<Integer>();
		for (Map<String, Object> map : listMap) {
			laharanaMpirotsakas.add((Integer) map.get("laharana"));
		}

		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		if (laharanaMpirotsakas.size() > 1) {
			// Trié les laharana
			Collections.sort(laharanaMpirotsakas);

			for (Integer current : laharanaMpirotsakas) {
				Map<String, Object> map = getMapByLaharana(listMap, current);
				if (current != null)
					result.add(map);
			}
		}

		return result;
	}

	public Integer getNbMaxResult(Long fifidiananaId, Boolean lahy,
			boolean izayNahazoVato) {
		return fFjkmAnkadifotsyDao.getNbMaxResult(fifidiananaId, lahy, izayNahazoVato);
	}

	/**
	 * Permet de savoir si le vote peut commencer, si les conditions suivantes
	 * sont toutes remplies : - Toutes les candidatures acceptées ont leur
	 * numéro attribuée - La date de vote est la date du jour
	 * 
	 * @param fifidianana
	 * @return true si on peut voter à la date du jour
	 */
	public boolean canBeginVote(Fifidianana fifidianana) {
		boolean ret = false;
		if (fifidianana != null) {
			if (haveAllMirotsakaFidianaEkenaLaharana(fifidianana))
				ret = fifidianana.getDatyFifidianana() != null
						&& Utils.sfDateFormatJJMMYYYY.format(
								fifidianana.getDatyFifidianana()).equals(
								Utils.sfDateFormatJJMMYYYY.format(new Date()));
		}
		return ret;
	}

	public boolean haveAllMirotsakaFidianaEkenaLaharana(Fifidianana fifidianana) {
		boolean ret = true;
		if (fifidianana != null) {
			List<Map<String, Object>> list = fFjkmAnkadifotsyDao.findMapMirotsakaFidiana(fifidianana.getId(), true, null, true);
			if (list.size() > 0) {
				for (Map<String, Object> map : list) {
					Integer laharanaMpirotsaka = (Integer) map.get("laharanaMpirotsaka");
					if (laharanaMpirotsaka == null) {
						ret = false;
						break;
					}
				}
			}
		}
		return ret;
	}

	/**
	 * @return parameter, le paramètre de l'utilisateur depuis la base de
	 *         données sinon le crée et l'enregistre en base NOTE : un
	 *         utilisateur doit au plus avoir un seul et unique paramètre en
	 *         base
	 */
	public Parameter findParameterByUser(String login) {
		return fFjkmAnkadifotsyDao.findParameterByUser(login);
	}

	/**
	 * Enregistre en base les modifications effectuées sur parameter
	 * 
	 * @param parameter
	 */
	public void saveParameter(Parameter parameter) {
		fFjkmAnkadifotsyDao.saveParameter(parameter);
	}

	public boolean updatePassword(String userLogin, String lastPass,
			String newPass) {
		return fFjkmAnkadifotsyDao.updatePassword(userLogin, lastPass, newPass);
	}

	/**
	 * Ré-initialise à 0 les voies obtenues dans MirotsakaFidiana pour le Fifidianana ET
	 * Ré-initialise à 0 les statistiques dans Fanisambato 
	 * @param id
	 */
	public void initFifidianana(Long id){
		fFjkmAnkadifotsyDao.initFifidianana(id);
	}

	/**
	 * Ajoute une nouvelle IP autorisée dans la base et dans le cache
	 * @param ip
	 * @param description
	 */
	public void addAuthorizedId(String ip, String description){
		fFjkmAnkadifotsyDao.addAuthorizedId(ip, description);
	}
	
	/**
	 * Supprime une IP anciennement autorisée dans la base et dans le cache
	 * @param ip
	 */
	public void removeAuthorizedIP(String ip){
		fFjkmAnkadifotsyDao.removeAuthorizedIP(ip);
	}
	
	/**
	 * Vérifie si une IP donnée est autorisée ou non
	 * NOTE : vérifie dans le cache d'abord (pour des raisons de performances), si non trouvé dans le cache alors vérifie en base
	 * @param ip
	 * @return true si authorisée, false sinon
	 */
	public boolean isIPAuthorized(String ip){
		return fFjkmAnkadifotsyDao.isIPAuthorized(ip);
	}
	
	/**
	 * Permet d'activer/désactiver l'IP 
	 * @param ip
	 * @param active
	 */
	public void activateAuthorizedIP(String ip, boolean active){
		fFjkmAnkadifotsyDao.activateAuthorizedIP(ip, active);
	}

	/**
	 * 
	 * @return la liste de toutes les IPs en base
	 */
	public List<AuthorizedIP> getAllAuthorizedIps(){
		return fFjkmAnkadifotsyDao.getAllAuthorizedIps();
	}

	public void saveAuthorizedIP(AuthorizedIP aip) {
		if (aip != null)
			fFjkmAnkadifotsyDao.saveAuthorizedIP(aip);
	}

	public void deleteAuthorizedIP(Long id) {
		if (id != null)
			fFjkmAnkadifotsyDao.deleteAuthorizedIP(id);
	}

	public AuthorizedIP findAuthorizedIP(Long id) {
		if (id != null)
			return fFjkmAnkadifotsyDao.findAuthorizedIP(id);
		return null;
	}

	public Map<String, Long> getStats(Long fifidiananaId, boolean lehilahy,
			String ip) {
		return fFjkmAnkadifotsyDao.getStats(fifidiananaId, lehilahy, ip);
	}

	public boolean canProcessFanisambato(Long fifidiananaId) {
		return fFjkmAnkadifotsyDao.canProcessFanisambato(fifidiananaId);
	}

	public void startStopFanisambato(Long fifidiananaId, boolean start) {
		fFjkmAnkadifotsyDao.startStopFanisambato(fifidiananaId, start);
	}
	
}
