/**
 * 
 */
package mg.fjkm.ankadifotsy.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
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
import mg.fjkm.ankadifotsy.util.CollectionUtils;
import mg.fjkm.ankadifotsy.util.ConstantUtils;
import mg.fjkm.ankadifotsy.util.Utils;

import org.apache.commons.lang.NotImplementedException;
import org.hibernate.Session;

/**
 * Implémentation hibernate de la couche d'accès aux données pour intraPoste
 * 
 * @author rija
 * @version 1.0
 */
public class FjkmAnkadifotsyMySQLDaoImpl implements FjkmAnkadifotsyDao {

	private FjkmHibernateTemplate fHibernateTemplate = null;

	//Gestion de cache pour les élections de candidats multiples
	private Map<Long, List<Map<String, Object>>> fifidiananaId2MirotsakaFidianaLehilahy = new HashMap<Long, List<Map<String,Object>>>();
	private Map<Long, List<Map<String, Object>>> fifidiananaId2MirotsakaFidianaVehivavy = new HashMap<Long, List<Map<String,Object>>>();

	//Gestion de cache pour les IPs autorisées
	private Set<String>fAuthorizedIPsCache = new HashSet<String>();
	
	private void putInCache(Long fifidiananaId, List<Map<String, Object>> mpirotsakaFidiana, Boolean lehilahy){
		if (lehilahy != null){
			if (lehilahy.booleanValue())
				fifidiananaId2MirotsakaFidianaLehilahy.put(fifidiananaId, mpirotsakaFidiana);
			else
				fifidiananaId2MirotsakaFidianaVehivavy.put(fifidiananaId, mpirotsakaFidiana);
		}
	}
	
	private List<Map<String, Object>> getFromCache(Long fifidiananaId, Boolean lehilahy){
		List<Map<String, Object>> ret = null;
		if (lehilahy != null){
			if (lehilahy.booleanValue())
				ret = fifidiananaId2MirotsakaFidianaLehilahy.get(fifidiananaId);
			else
				ret = fifidiananaId2MirotsakaFidianaVehivavy.get(fifidiananaId);
		}
		return ret;
	}
	
	private void putInCache(String ip){
		if (ip != null && !"".equals(ip.trim())){
			if (!fAuthorizedIPsCache.contains(ip))
				fAuthorizedIPsCache.add(ip);
		}
	}
	
	private void removeInCache(String ip){
		if (ip != null && !"".equals(ip.trim())){
			if (!fAuthorizedIPsCache.contains(ip))
				fAuthorizedIPsCache.remove(ip);
		}
	}
	
	private Set<String> getAuthorizedIPsFromCache(){
		return fAuthorizedIPsCache;
	}
	
	public void setHibernateTemplate(FjkmHibernateTemplate hibernateTemplate) {
		fHibernateTemplate = hibernateTemplate;
	}

	@SuppressWarnings("unchecked")
	public Firaisana findCommune(Long id) {
		Firaisana ret = null;
		if (id != null && !"".equals(id)) {
			StringBuffer hql = new StringBuffer("from Commune c \n");
			hql.append(" inner join fetch c.district d \n");
			hql.append("   inner join fetch d.region r \n");
			hql.append("     inner join fetch r.province \n");
			hql.append("where c.id = :id ");
			List<Firaisana> list = fHibernateTemplate.findByNamedParam(hql
					.toString(), "id", id);
			if (list.size() > 0)
				ret = list.get(0);
		}
		return ret;
	}

	@SuppressWarnings("unchecked")
	public District findDistrict(Long id) {
		District ret = null;
		if (id == null) {
			StringBuffer hql = new StringBuffer("from District d \n");
			hql.append(" inner join fetch d.region r \n");
			hql.append("   inner join fetch r.province \n");
			hql.append("where d.id = :id ");
			List<District> list = fHibernateTemplate.findByNamedParam(hql
					.toString(), "id", id);
			if (list.size() > 0)
				ret = list.get(0);
		}
		return ret;
	}

	@SuppressWarnings("unchecked")
	public AntonAsa findAntonAsa(Long id) {
		AntonAsa ret = null;
		if (id != null && !"".equals(id)) {
			StringBuffer hql = new StringBuffer("from AntonAsa act \n");
			hql.append("where act.id = '").append(id).append("'");
			List<AntonAsa> list = fHibernateTemplate.find(hql.toString());
			if (list.size() > 0)
				ret = list.get(0);
		}
		return ret;
	}

	@SuppressWarnings("unchecked")
	public List<AntonAsa> getAntonAsas(Map<String, String> parameters) {
		List<AntonAsa> list = null;
		String intitule = parameters.get(ConstantUtils.sfAJAX_ANTONASA);

		StringBuffer hql = new StringBuffer("select act from AntonAsa act \n");

		if (intitule != null && !"".equals(intitule.trim()))
			hql.append(" where UPPER(act.intitule) like '").append(
					intitule.trim().toUpperCase()).append("%' \n");

		hql.append(" order by act.intitule ");
		list = fHibernateTemplate.find(hql.toString());

		CollectionUtils.filtrerDoublonsSurPlace(list);

		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Mpivavaka> getMpivavaka(Map<String, String> parameters) {
		List<Mpivavaka> list = null;
		String intitule = parameters.get(ConstantUtils.sfAJAX_MPIVAVAKA);
				
		StringBuffer hql = new StringBuffer("select m from Mpivavaka m \n");
		
		if (intitule != null && !"".equals(intitule.trim()))
			hql.append(" where CONCAT_WS(' ',UPPER(m.anarana) , UPPER(m.fanampiny)) like '").append(intitule.trim().toUpperCase()).append("%' \n");

		//---- y a-til un Mpivavaka à exclure ?
		Long excludedId = null;
		String excludedIdStr = parameters.get(ConstantUtils.sfAJAX_EXCLU_MPIVAVAKA);
		try{
			excludedId = Long.parseLong(excludedIdStr);
		}
		catch(Exception e){
			//Aucune action à faire : pas d'id à exclure
		}
		if (excludedId != null)
			hql.append(" and m.id != ").append(excludedId).append(" \n");

		//--------- Prend on uniquement les Lehilahy ou les Vehivavys ?
		String isLahy = parameters.get(ConstantUtils.sfAJAX_MPIVAVAKA_LEHILAHY);
		if (isLahy != null){
			if (!"1".equals(isLahy) && ! "0".equals(isLahy))
				throw new NotImplementedException();
		}

		if (isLahy != null)
			hql.append(" and m.lahy = ").append(isLahy).append("\n");
		
		//------- exclureLahy / exclureVavy : on exclu les Mpivavaka Lehilahy / on exclu les Mpivavaka Vehivavy
		String exclure = parameters.get(ConstantUtils.sfAJAX_EXCLU_MPIVAVAKA_LEHILAHY);
		if (exclure != null){
			hql.append(" and m.lahy != ").append(exclure).append("\n");
		}
		
		//--------- Tri
		hql.append(" order by m.anarana, m.fanampiny ");
		list = fHibernateTemplate.find(hql.toString());

		CollectionUtils.filtrerDoublonsSurPlace(list);

		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see intraPoste.comptability.dao.IntraPosteDao#getDepartements()
	 */
	@SuppressWarnings("unchecked")
	public List<Province> getProvinces() {
		List<Province> list = null;
		StringBuffer hql = new StringBuffer("select p from Province p \n");
		hql.append(" order by p.intitule ");
		list = fHibernateTemplate.find(hql.toString());
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Province> getProvinces(String intitule) {
		List<Province> list = null;
		StringBuffer hql = new StringBuffer("select p from Province p \n");
		if (intitule != null && !"".equals(intitule.trim()))
			hql.append(" where upper(p.intitule) like '").append(
					intitule.trim().toUpperCase()).append("%'");
		hql.append(" order by p.intitule ");
		list = fHibernateTemplate.find(hql.toString());
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Firaisana> getFiraisanas(String label) {
		List<Firaisana> list = null;
		StringBuffer hql = new StringBuffer("select p from Firaisana p \n");
		if (label != null && !"".equals(label.trim()))
			hql.append(" where upper(p.label) like '").append(
					label.trim().toUpperCase()).append("%'");
		hql.append(" order by p.label ");
		list = fHibernateTemplate.find(hql.toString());
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see intraPoste.comptability.dao.IntraPosteDao#getRegions()
	 */
	@SuppressWarnings("unchecked")
	public List<Region> getRegions() {
		List<Region> list = null;
		StringBuffer hql = new StringBuffer(
				"select region from Region region \n");
		hql.append(" inner join fetch region.province \n");
		hql.append(" order by region.intitule ");
		list = fHibernateTemplate.find(hql.toString());
		CollectionUtils.filtrerDoublonsSurPlace(list);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Region> getRegionsParProvince(Integer idProvince) {
		List<Region> list = null;
		StringBuffer hql = new StringBuffer(
				"select region from Region region \n");
		hql.append(" inner join fetch region.province p \n");
		hql.append(" where p.id = :idProvince \n");
		hql.append(" order by region.intitule ");
		list = fHibernateTemplate.findByNamedParam(hql.toString(),
				"idProvince", idProvince);
		CollectionUtils.filtrerDoublonsSurPlace(list);
		return list;
	}

	/**
	 * Liste les régions filtrées par intitulé et par le province
	 * 
	 * @NOTE si aucune province n'est précisée alors renvoie la liste de toutes
	 *       les régions filtrées par l'intitulé
	 * @param intitule
	 * @param provinceId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Region> getRegions(Map<String, String> parameters) {
		List<Region> list = null;
		String idProvinceStr = parameters.get(ConstantUtils.sfAJAX_IDFIRAISANA);
		Long idProvince = null;
		try {
			idProvince = Long.parseLong(idProvinceStr);
		} catch (Exception e) {
			// NE RIEN FAIRE : l'identifiant de la province n'a pas été précisée
		}
		String intitule = parameters.get(ConstantUtils.sfAJAX_FARITRA);

		StringBuffer hql = new StringBuffer(
				"select region from Region region \n");
		hql.append(" inner join fetch region.province p \n");
		hql.append(" where  UPPER(region.intitule) like '").append(
				intitule.trim().toUpperCase()).append("%' \n");
		if (idProvince != null) {
			hql.append(" and p.id = :idProvince \n");
			hql.append(" order by region.intitule ");
			list = fHibernateTemplate.findByNamedParam(hql.toString(),
					"idProvince", idProvince);
		} else {
			hql.append(" order by region.intitule ");
			list = fHibernateTemplate.find(hql.toString());
		}

		CollectionUtils.filtrerDoublonsSurPlace(list);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Faritra> getFaritras(Map<String, String> parameters) {
		List<Faritra> list = null;
		String idFiraisanaStr = parameters.get(ConstantUtils.sfAJAX_IDFIRAISANA);
		Long idFiraisana = null;
		try {
			idFiraisana = Long.parseLong(idFiraisanaStr);
		} catch (Exception e) {
			// NE RIEN FAIRE : l'identifiant de la province n'a pas été précisée
		}
		String label = parameters.get(ConstantUtils.sfAJAX_FARITRA);

		StringBuffer hql = new StringBuffer("select faritra from Faritra faritra \n");
		hql.append(" inner join fetch faritra.firaisana p \n");
		hql.append(" where  UPPER(faritra.label) like '").append(label.trim().toUpperCase()).append("%' \n");
		if (idFiraisana != null) {
			hql.append(" and p.id = :idFiraisana \n");
			hql.append(" order by faritra.label ");
			list = fHibernateTemplate.findByNamedParam(hql.toString(),"idFiraisana", idFiraisana);
		} 
		else {
			hql.append(" order by faritra.label ");
			list = fHibernateTemplate.find(hql.toString());
		}

		CollectionUtils.filtrerDoublonsSurPlace(list);
		return list;
	}

	public Province getProvince(Long id) {
		Province dept = null;
		if (id != null)
			dept = (Province) fHibernateTemplate.get(Province.class, id);

		return dept;
	}

	@SuppressWarnings("unchecked")
	public Region getRegion(Long codeRegion) {
		Region region = null;
		if (codeRegion != null) {
			StringBuffer hql = new StringBuffer("from Region r \n");
			hql.append("   inner join fetch r.province \n");
			hql.append("where r.id = :id ");
			List<Region> list = fHibernateTemplate.findByNamedParam(hql
					.toString(), "id", codeRegion);
			if (list.size() > 0)
				region = list.get(0);
		}

		return region;
	}

	@SuppressWarnings("unchecked")
	public List<Faritra> getCentreFiscaux() {
		List<Faritra> ret = null;
		StringBuffer hql = new StringBuffer("from CentreFiscal cf \n");
		hql.append(" order by cf.intitule ");
		ret = fHibernateTemplate.find(hql.toString());

		return ret;
	}

	@SuppressWarnings("unchecked")
	public List<Faritra> getCentreFiscaux(Map<String, String> parameters) {
		List<Faritra> list = null;
		String intitule = parameters.get(ConstantUtils.sfAJAX_FARITRA);
		String idCommuneStr = parameters.get(ConstantUtils.sfAJAX_IDCOMMUNE);
		Long idCommune = null;
		if (idCommuneStr != null && !"".equals(idCommuneStr))
			idCommune = new Long(idCommuneStr);

		StringBuffer hql = new StringBuffer("select cf from CentreFiscal cf \n");
		hql.append(" left join fetch cf.communes commune \n");

		if (intitule != null && !"".equals(intitule.trim()))
			hql.append(" where UPPER(cf.intitule) like '").append(
					intitule.trim().toUpperCase()).append("%' \n");

		if (idCommune != null) {
			if (intitule != null && !"".equals(intitule.trim()))
				hql.append(" and ");
			else
				hql.append(" where ");

			hql.append(" commune.id = ").append(idCommune);
		}

		hql.append(" order by cf.intitule ");
		list = fHibernateTemplate.find(hql.toString());

		CollectionUtils.filtrerDoublonsSurPlace(list);

		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Firaisana> getCommunes() {
		List<Firaisana> ret = null;
		StringBuffer hql = new StringBuffer(" from Commune c \n");
		hql.append(" inner join fetch c.district ");
		hql.append(" order by c.intitule ");
		ret = fHibernateTemplate.find(hql.toString());

		return ret;
	}

	@SuppressWarnings("unchecked")
	public List<Firaisana> getCommunes(Map<String, String> parameters) {
		List<Firaisana> list = null;
		String idProvinceStr = parameters.get(ConstantUtils.sfAJAX_IDFIRAISANA);
		Long idProvince = null;
		try {
			idProvince = Long.parseLong(idProvinceStr);
		} catch (Exception e) {
			// NE RIEN FAIRE : l'identifiant de la province n'a pas été précisée
		}
		String idRegionStr = parameters.get(ConstantUtils.sfAJAX_IDREGION);
		Long idRegion = null;
		try {
			idRegion = Long.parseLong(idRegionStr);
		} catch (Exception e) {
			// NE RIEN FAIRE : l'identifiant de la région n'a pas été précisée
		}

		String idDistrictStr = parameters.get(ConstantUtils.sfAJAX_IDDISTRICT);
		Long idDistrict = null;
		try {
			idDistrict = Long.parseLong(idDistrictStr);
		} catch (Exception e) {
			// NE RIEN FAIRE : l'identifiant de la région n'a pas été précisée
		}

		String intitule = parameters.get(ConstantUtils.sfAJAX_COMMUNE);

		StringBuffer hql = new StringBuffer("select com from Commune com \n");
		hql.append(" inner join fetch com.district d \n");
		hql.append("   inner join fetch d.region r \n");
		hql.append("     inner join fetch r.province p \n");
		hql.append(" where  UPPER(com.intitule) like '").append(
				intitule.trim().toUpperCase()).append("%' \n");

		if (idDistrict != null) {
			hql.append(" and d.id = :idDistrict \n");

			hql.append(" order by com.intitule ");
			list = fHibernateTemplate.findByNamedParam(hql.toString(),
					"idDistrict", idDistrict);
		} else if (idRegion != null) {
			hql.append(" and r.id = :idRegion \n");

			hql.append(" order by com.intitule ");
			list = fHibernateTemplate.findByNamedParam(hql.toString(),
					"idRegion", idRegion);
		} else if (idProvince != null) {
			hql.append(" and p.id = :idProvince\n");

			hql.append(" order by com.intitule ");
			list = fHibernateTemplate.findByNamedParam(hql.toString(),
					"idProvince", idProvince);
		} else {
			hql.append(" order by com.intitule ");
			list = fHibernateTemplate.find(hql.toString());
		}

		CollectionUtils.filtrerDoublonsSurPlace(list);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Firaisana> getCommunesParDisctrict(Integer idDistrict) {
		List<Firaisana> ret = null;
		StringBuffer hql = new StringBuffer(" from Commune c \n");
		hql.append(" inner join fetch c.district d \n");
		hql.append(" where d.id = :idDistrict ");
		hql.append(" order by c.intitule ");
		ret = fHibernateTemplate.findByNamedParam(hql.toString(), "idDistrict",
				idDistrict);

		return ret;
	}

	@SuppressWarnings("unchecked")
	public List<District> getDistricts() {
		List<District> ret = null;
		StringBuffer hql = new StringBuffer("from District d \n");
		hql.append(" inner join fetch d.region \n");
		hql.append(" order by d.intitule ");
		ret = fHibernateTemplate.find(hql.toString());

		return ret;
	}

	@SuppressWarnings("unchecked")
	public List<District> getDistricts(Map<String, String> parameters) {
		List<District> list = null;
		String idProvinceStr = parameters.get(ConstantUtils.sfAJAX_IDFIRAISANA);
		Long idProvince = null;
		try {
			idProvince = Long.parseLong(idProvinceStr);
		} catch (Exception e) {
			// NE RIEN FAIRE : l'identifiant de la province n'a pas été précisée
		}
		String idRegionStr = parameters.get(ConstantUtils.sfAJAX_IDREGION);
		Long idRegion = null;
		try {
			idRegion = Long.parseLong(idRegionStr);
		} catch (Exception e) {
			// NE RIEN FAIRE : l'identifiant de la région n'a pas été précisée
		}

		String intitule = parameters.get(ConstantUtils.sfAJAX_DISTRICT);

		StringBuffer hql = new StringBuffer("select dis from District dis \n");
		hql.append(" inner join fetch dis.region r \n");
		hql.append("   inner join fetch r.province p \n");
		hql.append(" where  UPPER(dis.intitule) like '").append(
				intitule.trim().toUpperCase()).append("%' \n");

		if (idRegion != null) {
			hql.append(" and r.id = :idRegion \n");

			hql.append(" order by dis.intitule ");
			list = fHibernateTemplate.findByNamedParam(hql.toString(),
					"idRegion", idRegion);
		} else if (idProvince != null) {
			hql.append(" and p.id = :idProvince\n");

			hql.append(" order by dis.intitule ");
			list = fHibernateTemplate.findByNamedParam(hql.toString(),
					"idProvince", idProvince);
		} else {
			hql.append(" order by dis.intitule ");
			list = fHibernateTemplate.find(hql.toString());
		}

		CollectionUtils.filtrerDoublonsSurPlace(list);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<District> getDistrictsParRegion(Integer idRegion) {
		List<District> ret = null;
		StringBuffer hql = new StringBuffer("from District d \n");
		hql.append(" inner join fetch d.region reg \n");
		hql.append(" where reg.id = :idRegion \n");
		hql.append(" order by d.intitule ");
		ret = fHibernateTemplate.findByNamedParam(hql.toString(), "idRegion",
				idRegion);

		return ret;
	}

	public List<Mpivavaka> getContribuablesAvecDoublons(
			Map<String, String> parameters) {
		List<Mpivavaka> ret = null;
		return ret;
	}

	@SuppressWarnings("unchecked")
	public List<Mpivavaka> getContribuables(String typeRecherche, String filter) {
		List<Mpivavaka> ret = null;
		StringBuffer hql = new StringBuffer();
		if ("rechercherNom".equals(typeRecherche)) {
			hql.append(" select c from Contribuable c \n");
			hql.append(" left join fetch c.formeJuridique \n"); // pour
																// l'affichage
																// de la forme
																// juridique
			hql.append(" left join fetch c.etablissements es \n");
			hql.append(" left join fetch es.centreFiscal \n");
			hql.append(" left join fetch es.activite \n");
			hql.append(" where upper(es.nomCommercial) like '").append(
					filter.trim().toUpperCase()).append("%'");
		} else {
			hql.append("select c from Contribuable c\n");
			hql.append(" left join fetch c.formeJuridique \n"); // pour
																// l'affichage
																// de la forme
																// juridique
			hql.append(" left join fetch c.etablissements e \n"); // pour
																	// l'affichage
																	// de la
																	// raison
																	// sociale
			hql.append(" left join fetch e.centreFiscal "); // Pour l'affichage
															// du centre
			hql.append(" left join fetch e.activite \n");
			if ("rechercherNif".equals(typeRecherche))
				hql.append(" where upper(c.idContribuable) like '").append(
						filter.trim().toUpperCase()).append("%'");
			else if ("rechercherRaisonSociale".equals(typeRecherche))
				hql.append(" where upper(c.raisonSociale) like '").append(
						filter.trim().toUpperCase()).append("%'");
		}
		ret = fHibernateTemplate.find(hql.toString());
		CollectionUtils.filtrerDoublonsSurPlace(ret);

		return ret;
	}

	@SuppressWarnings("unchecked")
	public List<Mpivavaka> getContribuables(Long taxPayerNo) {
		List<Mpivavaka> ret = null;
		StringBuffer hql = new StringBuffer(" select c from Contribuable c \n");
		hql.append(" left join fetch c.etat etat \n"); // pour l'affichage de
														// la forme juridique
		hql.append(" left join fetch c.formeJuridique \n"); // pour l'affichage
															// de la forme
															// juridique
		hql.append(" left join fetch c.etablissements es \n");
		hql.append("   left join fetch es.dirigeants dir \n");
		hql.append("     left join fetch dir.region \n");
		hql.append("     left join fetch dir.commune \n");
		hql.append("   left join fetch es.province \n");
		hql.append("   left join fetch es.region \n");
		hql.append("   left join fetch es.district \n");
		hql.append("   left join fetch es.commune \n");
		hql.append("   left join fetch es.activite \n");
		hql.append(" left join fetch es.centreFiscal \n");
		hql.append(" where c.taxPayerNo = :taxPayerNo ");

		ret = fHibernateTemplate.findByNamedParam(hql.toString(), "taxPayerNo",
				taxPayerNo);
		CollectionUtils.filtrerDoublonsSurPlace(ret);

		return ret;
	}

	@SuppressWarnings("unchecked")
	public Mpivavaka getContribuableByNif(String nif) {
		if (nif != null && !"".equals(nif.trim())) {
			List<Mpivavaka> ret = null;
			StringBuffer hql = new StringBuffer(
					" select c from Contribuable c \n");
			hql.append(" left join fetch c.etat etat \n"); // pour l'affichage
															// de la forme
															// juridique
			hql.append(" left join fetch c.formeJuridique \n"); // pour
																// l'affichage
																// de la forme
																// juridique
			hql.append(" left join fetch c.etablissements es \n");
			hql.append("   left join fetch es.dirigeants dir \n");
			hql.append("     left join fetch dir.region \n");
			hql.append("     left join fetch dir.commune \n");
			hql.append("   left join fetch es.province \n");
			hql.append("   left join fetch es.region \n");
			hql.append("   left join fetch es.district \n");
			hql.append("   left join fetch es.commune \n");
			hql.append("   left join fetch es.activite \n");
			hql.append(" left join fetch es.centreFiscal \n");
			hql.append(" where c.idContribuable = :nif ");

			ret = fHibernateTemplate.findByNamedParam(hql.toString(), "nif",
					nif);

			if (ret.size() > 0)
				return ret.get(0);
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	public Mpivavaka getContribuableByAncienNif(String ancienNif) {
		if (ancienNif != null && !"".equals(ancienNif.trim())) {
			List<Mpivavaka> ret = null;
			StringBuffer hql = new StringBuffer(
					" select c from Contribuable c \n");
			hql.append(" left join fetch c.etat etat \n"); // pour l'affichage
															// de la forme
															// juridique
			hql.append(" left join fetch c.formeJuridique \n"); // pour
																// l'affichage
																// de la forme
																// juridique
			hql.append(" left join fetch c.etablissements es \n");
			hql.append("   left join fetch es.dirigeants dir \n");
			hql.append("     left join fetch dir.region \n");
			hql.append("     left join fetch dir.commune \n");
			hql.append("   left join fetch es.province \n");
			hql.append("   left join fetch es.region \n");
			hql.append("   left join fetch es.district \n");
			hql.append("   left join fetch es.commune \n");
			hql.append("   left join fetch es.activite \n");
			hql.append(" left join fetch es.centreFiscal \n");
			hql.append(" where c.ancienNif = :ancienNif ");

			ret = fHibernateTemplate.findByNamedParam(hql.toString(),
					"ancienNif", ancienNif);

			if (ret.size() > 0)
				return ret.get(0);
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Mpivavaka> getContribuablesParEtat(Long idEtat,
			Long idCentreFiscal) {
		List<Mpivavaka> ret = null;
		StringBuffer hql = new StringBuffer(" select c from Contribuable c \n");
		hql.append(" inner join fetch c.formeJuridique \n"); // pour
																// l'affichage
																// de la forme
																// juridique
		hql.append(" inner join fetch c.etat etat \n"); // pour l'affichage de
														// la forme juridique
		hql.append(" left join fetch c.etablissements es \n");
		hql.append("   left join fetch es.dirigeants dir \n");
		hql.append("     left join fetch dir.region \n");
		hql.append("     left join fetch dir.commune \n");
		hql.append("   left join fetch es.province \n");
		hql.append("   left join fetch es.region \n");
		hql.append("   left join fetch es.district \n");
		hql.append("   left join fetch es.commune \n");
		hql.append("   left join fetch es.activite \n");
		hql.append(" left join fetch es.centreFiscal \n");
		hql.append(" where etat.id = :idEtat ");

		ret = fHibernateTemplate.findByNamedParam(hql.toString(), "idEtat",
				idEtat);
		CollectionUtils.filtrerDoublonsSurPlace(ret);

		if (idCentreFiscal != null) {
			// Filtre sur le centre fiscal
			List<Mpivavaka> list = new ArrayList<Mpivavaka>();
			for (Mpivavaka contribuable : ret) {
				// if (contribuable.getFirstEtablissement() != null &&
				// contribuable.getFirstEtablissement().getCentreFiscal() !=
				// null &&
				// idCentreFiscal.equals(contribuable.getFirstEtablissement().getCentreFiscal().getId()))
				list.add(contribuable);
			}
			ret = list;
		}

		return ret;
	}

	@SuppressWarnings("unchecked")
	public List<Mpivavaka> getContribuablesParEtatPourDoublon(Long idEtat) {
		List<Mpivavaka> ret = null;

		StringBuffer hql = new StringBuffer(" select c from Contribuable c \n");
		hql.append(" inner join fetch c.etat etat \n"); // pour l'affichage de
														// la forme juridique
		hql.append(" left join fetch c.etablissements es \n");
		// hql.append(" left join fetch es.dirigeants dir \n");
		hql.append(" left join fetch es.centreFiscal \n");
		hql.append(" left join fetch es.activite \n");
		hql.append(" where etat.id = :idEtat ");

		ret = fHibernateTemplate.findByNamedParam(hql.toString(), "idEtat",
				idEtat);

		CollectionUtils.filtrerDoublonsSurPlace(ret);

		return ret;
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getDatasParEtatPourDoublon(Long idEtat) {
		List<Map<String, Object>> ret = null;
		StringBuffer hql = new StringBuffer(" select new map (c.id as id, c.raisonSociale as raisonSociale, c.nomCommercial as nomCommercial, c.adresse as adresse, c.cin as cin, c.rc as rc, etat.intitule as etat) from Contribuable c, Etat etat \n");
		hql.append(" where etat.id = :idEtat and c.etat.id = etat.id");

		ret = fHibernateTemplate.findByNamedParam(hql.toString(), "idEtat",idEtat);
		CollectionUtils.filtrerDoublonsSurPlace(ret);

		return ret;
	}

	public void removeContribuable(Mpivavaka contribuable) {
		// if (contribuable != null && contribuable.getTaxPayerNo() != null)
		fHibernateTemplate.delete(contribuable);
	}

	@SuppressWarnings("unchecked")
	public User getUser(String login) {
		User ret = null;
		if (login != null && !"".equals(login)) {
			StringBuffer hql = new StringBuffer("from User u \n");
			hql.append(" left join fetch u.authorities \n");
			hql.append(" where u.login = :login ");
			List<User> users = fHibernateTemplate.findByNamedParam(hql.toString(), "login", login);
			if (users.size() > 0)
				ret = users.get(0);
		}
		return ret;
	}

	public User saveUser(User user) {
		if (user != null) {
			if (user.getId() == null)
				fHibernateTemplate.save(user);
			else
				fHibernateTemplate.update(user);
		}
		return user;
	}

	@SuppressWarnings("unchecked")
	public void removeUser(String login) {
		if (login != null) {
			List<User> list = fHibernateTemplate.findByNamedParam(
					"from User where login = :login", "login", login);
			User user = null;
			if (list.size() > 0)
				user = list.get(0);

			if (user != null)
				fHibernateTemplate.delete(user);
		}
	}

	@SuppressWarnings("unchecked")
	public List<User> findUsers() {
		List<User> list = fHibernateTemplate.find("from User");

		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Fitandremana> findAllfitandremana() {
		StringBuffer hql = new StringBuffer("from Fitandremana order by upper (label) ");
		List<Fitandremana> list = fHibernateTemplate.find(hql.toString());
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<TaomPanompoana> findAllTaomPanompoana() {
		List<TaomPanompoana> ret = fHibernateTemplate.find("from TaomPanompoana ");
		return ret;
	}

	@SuppressWarnings("unchecked")
	public List<TaomPanompoana> findTaomPanompoanasWithoutDaty(Date daty) {
		StringBuffer hql = new StringBuffer("from TaomPanompoana t \n");
		hql.append(" where t.datyManomboka < :daty ");
		List<TaomPanompoana> ret = fHibernateTemplate.findByNamedParam(hql.toString(), "daty", daty);
		
		return ret;
	}

	@SuppressWarnings("unchecked")
	public List<TaomPanompoana> getTaomPanompoana(Map<String, String> parameters) {
		List<TaomPanompoana> list = null;
		String taonaStr = parameters.get(ConstantUtils.sfAJAX_TAONA);
		taonaStr = Utils.pad(taonaStr, 4, '0');

		StringBuffer hql = new StringBuffer("select t from TaomPanompoana t \n");

		if (taonaStr != null && !"".equals(taonaStr.trim()))
			hql.append(" where date_format(t.datyManomboka, '%Y') >=  ").append(taonaStr.trim());

		hql.append(" order by t.datyManomboka ");
		list = fHibernateTemplate.find(hql.toString());

		CollectionUtils.filtrerDoublonsSurPlace(list);

		return list;
	}
	
	@SuppressWarnings("unchecked")
	public KarazamPifidianana findKarazamPifidiananaById(Long id){
		KarazamPifidianana ret = null;
		if (id != null){
			StringBuffer hql  = new StringBuffer("from KarazamPifidianana k where k.id = :id ");
			List<KarazamPifidianana> list = fHibernateTemplate.findByNamedParam(hql.toString(), "id", id);
			if (list.size() > 0)
				ret = list.get(0);
		}
		return ret;
	}
	
	@SuppressWarnings("unchecked")
	public TaomPanompoana findTaomPanompoanaById(Long id) {
		TaomPanompoana ret = null;
		if (id != null) {
			StringBuffer hql = new StringBuffer("from TaomPanompoana t where t.id = :id ");
			List<TaomPanompoana> list = fHibernateTemplate.findByNamedParam(hql.toString(), "id", id);
			if (list.size() > 0)
				ret = list.get(0);
		}
		return ret;
	}

	@SuppressWarnings("unchecked")
	public TaomPanompoana findTaomPanompoanaByDate(Date daty) {
		TaomPanompoana ret = null;
		if (daty != null) {
			StringBuffer hql = new StringBuffer("from TaomPanompoana t \n");
			hql.append(" where t.datyManomboka <= :daty and t.datyMamarana >= :daty ");
			List<TaomPanompoana> list = fHibernateTemplate.findByNamedParam(hql.toString(), "daty", daty);
			if (list.size() > 0)
				ret = list.get(0);
		}
		return ret;
	}

	@SuppressWarnings("unchecked")
	public List<ILabelable> getAutoCompletionLabelable(Map<String, String> parameters, Class<? extends Object> boClass) {
		assert boClass != null && parameters != null; 
		List<ILabelable> list = null;
		String intitule = parameters.get(ConstantUtils.sfAJAX_LABEL);

		StringBuffer hql = new StringBuffer("select l from ").append(boClass.getSimpleName()).append(" l \n");

		if (intitule != null && !"".equals(intitule.trim()))
			hql.append(" where UPPER(l.label) like '").append(
					intitule.trim().toUpperCase()).append("%' \n");

		hql.append(" order by l.label ");
		list = fHibernateTemplate.find(hql.toString());

		CollectionUtils.filtrerDoublonsSurPlace(list);

		return list;
	}
	
	@SuppressWarnings("unchecked")
	public Fitandremana findFitandremanaById(Long id) {
		Fitandremana ret = null;
		if (id != null) {
			StringBuffer hql = new StringBuffer("from Fitandremana f \n");
			hql.append(" inner join fetch f.synodamParitra \n");
			hql.append(" where f.id = :id ");
			List<Fitandremana> list = fHibernateTemplate.findByNamedParam(hql
					.toString(), "id", id);
			if (list.size() > 0)
				ret = list.get(0);

		}
		return ret;
	}

	@SuppressWarnings("unchecked")
	public List<Mpivavaka> findAllMpivavaka(Integer pageNo, Integer nbElement) {
		StringBuffer hql = new StringBuffer(
				"select distinct m from Mpivavaka m \n");
		hql.append(" inner join fetch m.fitandremana \n");
		hql.append(" left join fetch m.trangas \n");
		hql.append(" order by m.anarana, m.fanampiny ");
		List<Mpivavaka> list = fHibernateTemplate.findByPage(hql.toString(),
				(Object[]) null, pageNo, nbElement);
		CollectionUtils.filtrerDoublonsSurPlace(list);

		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mg.fjkm.ankadifotsy.dao.FjkmAnkadifotsyDao#findMpivavaka(java.util.Map, java.lang.Integer, java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	public List<Mpivavaka> findMpivavaka(Map<String, Object> parameterNameValues, Integer pageNo, Integer nbElement) {
		List<Mpivavaka> ret = new ArrayList<Mpivavaka>();
		if (parameterNameValues == null || parameterNameValues.size() == 0)
			ret = findAllMpivavaka(pageNo, nbElement);
		else {
			StringBuffer hql = new StringBuffer("select distinct m.id from Mpivavaka m \n");
			// hql.append(" inner join fetch m.fitandremana \n");
			hql.append(" left join m.trangas tr \n");
			hql.append("   left join tr.karazaTranga ktr \n");

			addMpivavakaCriterias(hql, parameterNameValues);

			hql.append(" order by m.anarana, m.fanampiny ");

			List<Long> list = fHibernateTemplate.findByPage(hql.toString(), (Object[]) null, pageNo, nbElement);

			if (list.size() > 0) {
				hql = new StringBuffer("select m from Mpivavaka m \n");
				hql.append(" inner join fetch m.fitandremana \n");
				hql.append(" left join fetch m.trangas tr \n");
				hql.append("   left join fetch tr.karazaTranga ktr \n");
				hql.append(" left join fetch m.diakonas \n");

				addMpivavakaCriterias(hql, parameterNameValues);

				hql.append(" and m.id in (:list) \n");
				hql.append(" order by m.anarana, m.fanampiny ");
				ret = fHibernateTemplate.findByNamedParam(hql.toString(), "list", list);
				CollectionUtils.filtrerDoublonsSurPlace(ret);
			}
		}
		return ret;
	}

	/**
	 * 
	 * @param parameterNameValues
	 * @param pageNo
	 * @param nbElement
	 * @return le nb de Mpivavaka qui satisfait les critères passés en paramètre
	 */
	@SuppressWarnings("unchecked")
	public Long findNumberOfMpivavaka(Map<String, Object> parameterNameValues) {
		Long ret = 0L;
		StringBuffer hql = new StringBuffer(
				"select distinct m.id from Mpivavaka m \n");
		hql.append(" left join m.trangas tr \n");
		hql.append("   left join tr.karazaTranga ktr \n");

		addMpivavakaCriterias(hql, parameterNameValues);

		List<Long> list = fHibernateTemplate.find(hql.toString());
		ret = new Long(list.size());

		return ret;
	}

	/**
	 * Ajoute les critères stockés dans la collection de paramètre
	 * 
	 * @param hql
	 * @param parameterNameValues
	 */
	private void addMpivavakaCriterias(StringBuffer hql, Map<String, Object> parameterNameValues) {
		if (hql != null && parameterNameValues != null && parameterNameValues.size() != 0) {
			hql.append(" where 1=1 \n");

			String laharana = (String) parameterNameValues.get(ConstantUtils.sfCriteriaLaharana);
			if (laharana != null && !"".equals(laharana.trim()))
				hql.append(" and m.laharana like '%").append(laharana).append("%' \n");

			String anarana = (String) parameterNameValues.get(ConstantUtils.sfCriteriaAnarana);
			if (anarana != null && !"".equals(anarana.trim()))
				hql.append(" and m.anarana like '%").append(anarana).append("%' \n");

			String fanampiny = (String) parameterNameValues
					.get(ConstantUtils.sfCriteriaFanampiny);
			if (fanampiny != null && !"".equals(fanampiny.trim()))
				hql.append(" and m.fanampiny like '%").append(fanampiny).append("%' \n");

			Fitandremana fitandremana = (Fitandremana) parameterNameValues
					.get(ConstantUtils.sfCriteriaFitandremana);
			if (fitandremana != null)
				hql.append(" and m.fitandremana.id = ").append(fitandremana.getId());

			String talenta = (String) parameterNameValues.get(ConstantUtils.sfCriteriaTalenta);
			if (talenta != null && !"".equals(talenta.trim()))
				hql.append(" and m.talenta like '%").append(talenta).append("%' \n");

			AntonAsa asa = (AntonAsa) parameterNameValues.get(ConstantUtils.sfCriteriaAntonAsa);
			if (asa != null)
				hql.append(" and m.antonAsa.id = ").append(asa.getId()).append("\n");

			Boolean lahy = (Boolean) parameterNameValues
					.get(ConstantUtils.sfCriteriaLahy);
			if (lahy != null) {
				if (lahy.booleanValue())
					hql.append(" and m.lahy = 1 \n");
				else
					hql.append(" and m.lahy = 0 \n");
			}

			Boolean batisa = (Boolean) parameterNameValues.get(ConstantUtils.sfCriteriaVitaBatisa);
			if (batisa != null) {
				if (batisa.booleanValue())
					hql.append(" and exists (select tr2.id from Tranga tr2 where tr2.mpivavaka.id = m.id and tr2.karazaTranga.id = 1 ) \n");
				else
					hql.append(" and not exists (select tr2.id from Tranga tr2 where tr2.mpivavaka.id = m.id and tr2.karazaTranga.id = 1 ) \n");
			}

			Boolean mpandray = (Boolean) parameterNameValues
					.get(ConstantUtils.sfCriteriaMpandray);
			if (mpandray != null) {
				if (mpandray.booleanValue())
					hql.append(" and exists (select tr2.id from Tranga tr2 where tr2.mpivavaka.id = m.id and tr2.karazaTranga.id = 2) \n");
				else
					hql.append(" and not exists (select tr2.id from Tranga tr2 where tr2.mpivavaka.id = m.id and tr2.karazaTranga.id = 2) \n");
			}

		}
	}

	public Mpivavaka saveMpivavaka(Mpivavaka mpivavaka) {
		if (mpivavaka != null)
			fHibernateTemplate.saveOrUpdate(mpivavaka);

		return mpivavaka;
	}

	public Fanambadiana saveFanambadiana(Fanambadiana fanambadiana){
		if (fanambadiana != null)
			fHibernateTemplate.saveOrUpdate(fanambadiana);
		
		return fanambadiana;
	}
	
	@SuppressWarnings("unchecked")
	public Fanambadiana findFanambadianaByMpivavaka(Mpivavaka mpivavaka){
		Fanambadiana ret = null;
		if (mpivavaka != null && mpivavaka.getId() != null){
			StringBuffer hql = new StringBuffer("from Fanambadiana f \n");
			hql.append(" inner join fetch f.mpivavaka m \n");
			hql.append(" left join fetch f.vadyForPersistence v \n");
			hql.append(" left join fetch f.fitandremana \n");
			hql.append(" where m.id = :id or v.id = :id ");
			List<Fanambadiana> list = fHibernateTemplate.findByNamedParam(hql.toString(), "id", mpivavaka.getId());
			CollectionUtils.filtrerDoublonsSurPlace(list);
			if (list.size() > 1)
				throw new NotImplementedException();
			else
				ret = list.get(0);
		}
		return ret;
	}
	
	/**
	 * 
	 * @param parameterName =
	 *            laharana / id
	 * @param parameterValue =
	 *            String / Long
	 * @return Mpivavaka
	 */
	@SuppressWarnings("unchecked")
	public Mpivavaka findMpivavakaByParameter(String parameterName,
			Serializable parameterValue) {
		Mpivavaka ret = null;
		if (parameterValue != null) {
			StringBuffer hql = new StringBuffer("from Mpivavaka m \n");
			hql.append(" inner join fetch m.fitandremana \n");//inner
			
			hql.append(" left join fetch m.antonAsa \n");
			hql.append(" left join fetch m.taoCIN \n");

			hql.append(" left join fetch m.ray_ \n");
			hql.append(" left join fetch m.reny_ \n");
			
			hql.append(" left join fetch m.taoNanoloinaCIN \n");
			
			hql.append(" inner join fetch m.userCreator \n");//inner
			hql.append(" left join fetch m.userLastModification \n");
			hql.append(" left join fetch m.firaisana \n");
			hql.append(" left join fetch m.faritra \n");

			hql.append(" left join fetch m.trangas tr \n");
			hql.append("   left join fetch tr.karazaTranga \n");//inner
			hql.append("   left join fetch tr.fitandremana \n");
			hql.append("   left join fetch tr.userCreator \n");//inner
			hql.append("   left join fetch tr.userLastModification \n");

			hql.append(" left join fetch m.fanambadianas f \n");
			hql.append("   left join fetch f.fitandremana \n");
			hql.append("   left join fetch f.vadyForPersistence \n");
			hql.append("   left join fetch f.mpivavaka \n");
			hql.append("   left join fetch f.userCreator \n");//inner
			hql.append("   left join fetch f.userLastModification \n");

			hql.append(" left join fetch m.diakonas diakona \n");
			hql.append("   left join fetch diakona.taomPanompoana ");//inner
			hql.append("   left join fetch diakona.fitandremana ");//inner
			hql.append(" left join fetch m.mpikambanas \n");

			hql.append(" where ");
			hql.append("m.").append(parameterName).append("= :").append(parameterName);
			List<Mpivavaka> list = fHibernateTemplate.findByNamedParam(hql.toString(), parameterName, parameterValue);
			if (list.size() > 0)
				ret = list.get(0);
		}
		return ret;
	}

	public Mpivavaka findMpivavakaByLaharana(String laharana) {
		Mpivavaka ret = findMpivavakaByParameter("laharana", laharana);
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mg.fjkm.ankadifotsy.dao.FjkmAnkadifotsyDao#findMpivavakaById(java.lang.Long)
	 */
	public Mpivavaka findMpivavakaById(Long id) {
		return findMpivavakaByParameter("id", id);
	}

	@SuppressWarnings("unchecked")
	public Firaisana findFiraisana(Long id) {
		Firaisana ret = null;
		if (id != null) {
			StringBuffer hql = new StringBuffer(
					"from Firaisana where id = :id ");
			List<Firaisana> list = fHibernateTemplate.findByNamedParam(hql
					.toString(), "id", id);
			if (list.size() > 0)
				ret = list.get(0);
		}
		return ret;
	}

	@SuppressWarnings("unchecked")
	public Faritra findFaritra(Long id) {
		Faritra ret = null;
		if (id != null) {
			StringBuffer hql = new StringBuffer("from Faritra where id = :id ");
			List<Faritra> list = fHibernateTemplate.findByNamedParam(hql
					.toString(), "id", id);
			if (list.size() > 0)
				ret = list.get(0);
		}
		return ret;
	}

	/**
	 * Ajoute les critères stockés dans la collection de paramètre
	 * 
	 * @param hql
	 * @param parameterNameValues
	 */
	private void addFifidiananaCriterias(StringBuffer hql, Map<String, Object> parameterNameValues) {
		if (hql != null && parameterNameValues != null && parameterNameValues.size() != 0) {
			hql.append(" where 1=1 \n");

			Fitandremana fitandremana = (Fitandremana) parameterNameValues.get(ConstantUtils.sfCriteriaFitandremana);
			if (fitandremana != null)
				hql.append(" and f.fitandremana.id = ").append(fitandremana.getId());

			KarazamPifidianana karazamPifidianana = (KarazamPifidianana)parameterNameValues.get(ConstantUtils.sfCriteriaKarazampifidianana);
			if (karazamPifidianana != null)
				hql.append(" and f.karazamPifidianana.id = ").append(karazamPifidianana.getId());
			
			TaomPanompoana taomPanompoana = (TaomPanompoana) parameterNameValues.get(ConstantUtils.sfCriteriaTaomPanompoana);
			if (taomPanompoana != null)
				hql.append(" and f.taomPanompoana = ").append(taomPanompoana.getId());

			Date manakatona = (Date) parameterNameValues.get(ConstantUtils.sfCriteriaDatyManakatona);
			if (manakatona != null)
				hql.append(" and (f.datyManakatona <= :daty or f.datyManakatona is null) ");
		}
	}

	/**
	 * 
	 * @param parameterNameValues
	 * @param pageNo
	 * @param nbElement
	 * @return le nb de Fifidianana qui satisfait les critères passés en paramètre
	 */
	@SuppressWarnings("unchecked")
	public Long findNumberOfFifidianana(Map<String, Object> parameterNameValues) {
		Long ret = 0L;
		StringBuffer hql = new StringBuffer("select distinct f.id from Fifidianana f \n");
		hql.append(" inner join f.fitandremana \n");
		hql.append(" inner join f.taomPanompoana \n");
		hql.append(" inner join f.karazamPifidianana \n");

		addFifidiananaCriterias(hql, parameterNameValues);

		List<Long> list = null;
		Date datyManakatona = (Date)parameterNameValues.get(ConstantUtils.sfCriteriaDatyManakatona);
		
		if (datyManakatona == null)
			list = fHibernateTemplate.find(hql.toString());
		else
			list = fHibernateTemplate.findByNamedParam(hql.toString(), "daty", datyManakatona);
		
		ret = new Long(list.size());

		return ret;
	}

	public Fifidianana saveFifidianana(Fifidianana fifidianana){
		if (fifidianana != null){
			if (fifidianana.getId() == null)
				fHibernateTemplate.save(fifidianana);
			else
				fHibernateTemplate.update(fifidianana);
		}
		
		return fifidianana;
	}
	
	@SuppressWarnings("unchecked")
	public List<Fifidianana> findFifidianana(Map<String, Object> parameterNameValues, Integer pageNo, Integer nbElement) {
		List<Fifidianana> ret = new ArrayList<Fifidianana>();
		if (parameterNameValues == null || parameterNameValues.size() == 0)
			ret = findAllFifidianana(pageNo, nbElement);
		else {
			StringBuffer hql = new StringBuffer("select distinct f.id from Fifidianana f \n");
			hql.append(" inner join f.taomPanompoana t \n");

			addFifidiananaCriterias(hql, parameterNameValues);

			Date manakatona = (Date)parameterNameValues.get(ConstantUtils.sfCriteriaDatyManakatona);
			
			hql.append(" order by t.datyManomboka, t.datyMamarana ");

			List<Long> list = null;
			if (manakatona == null)
				list = fHibernateTemplate.findByPage(hql.toString(), (Object[]) null, pageNo, nbElement);
			else
				list = fHibernateTemplate.findByNamedParamAndPage(hql.toString(), new String[]{"daty"}, new Object[]{manakatona}, pageNo, nbElement);
			
			List<String> parameterNames = new ArrayList<String>();
			List<Object> parameterValues = new ArrayList<Object>();
			parameterNames.add("list");
			parameterValues.add(list);
			
			if (manakatona == null)
				list = fHibernateTemplate.findByPage(hql.toString(), (Object[]) null, pageNo, nbElement);
			else{
				list = fHibernateTemplate.findByNamedParamAndPage(hql.toString(), new String[]{"daty"}, new Object[]{manakatona}, pageNo, nbElement);
				parameterNames.add("daty");
				parameterValues.add(manakatona);
			}

			if (list.size() > 0) {
				hql = new StringBuffer("select f from Fifidianana f \n");
				hql.append(" inner join fetch f.fitandremana \n");
				hql.append(" inner join fetch f.taomPanompoana t \n");
				hql.append(" inner join fetch f.karazamPifidianana k \n");

				addFifidiananaCriterias(hql, parameterNameValues);

				hql.append(" and f.id in (:list) \n");
				hql.append(" order by t.datyManomboka, t.datyMamarana ");
				
				ret = fHibernateTemplate.findByNamedParam(hql.toString(), parameterNames.toArray(new String[parameterNames.size()]), parameterValues.toArray(new Object[parameterValues.size()]));

				CollectionUtils.filtrerDoublonsSurPlace(ret);
			}
		}
		return ret;
	}

	@SuppressWarnings("unchecked")
	public List<Fifidianana> findAllFifidianana(Integer pageNo, Integer nbElement) {
		StringBuffer hql = new StringBuffer("select distinct f from Fifidianana f \n");
		hql.append(" inner join fetch f.fitandremana \n");
		hql.append(" inner join fetch f.karazamPifidianana k \n");
		hql.append(" inner join fetch f.taomPanompoana t \n");
		hql.append(" order by t.datyManomboka, t.datyMamarana ");
		List<Fifidianana> list = fHibernateTemplate.findByPage(hql.toString(), (Object[]) null, pageNo, nbElement);
		CollectionUtils.filtrerDoublonsSurPlace(list);

		return list;
	}

	@SuppressWarnings("unchecked")
	public Fifidianana findFifidianana(Long id) {
		Fifidianana ret = null;
		if (id != null) {
			StringBuffer hql = new StringBuffer("select f from Fifidianana f \n");
			hql.append(" inner join fetch f.fitandremana \n");
			hql.append(" inner join fetch f.taomPanompoana t \n");
			hql.append(" inner join fetch f.karazamPifidianana k \n");
			hql.append(" inner join fetch f.userCreator \n");
			hql.append(" left join fetch f.userLastModification \n");
			hql.append(" where f.id = :id");
			hql.append(" order by t.datyManomboka, t.datyMamarana ");
			
			List<Fifidianana> list = fHibernateTemplate.findByNamedParam(hql.toString(), "id", id);
			if (list.size() > 0)
				ret = list.get(0);
		}
		return ret;
	}

	//------------------------ Fifidianana ------------------------------------------
	public MirotsakaFidiana saveMirotsakaFidiana(MirotsakaFidiana mirotsakaFidiana){
		if (mirotsakaFidiana != null)
			fHibernateTemplate.saveOrUpdate(mirotsakaFidiana);
		
		return mirotsakaFidiana;
	}
	
	/**
	 * Permet de savoir si le Mpivavaka est déjà MirotsakaFidiana ou non pour le Fifidianana
	 * @param fifidiananaId
	 * @param mpivavakaIds, les identiifants des Mpivavaka à vérifier
	 * @return Map<mpivavakaId, mirotsakaFidianaId> en fonction de fifidiananaId
	 */
	@SuppressWarnings("unchecked")
	public Map<Long, Long> findMapMpivavakaId2MirotsakaFidianaIdByTaomPanompoanaId(Long fifidiananaId, Collection<Long>mpivavakaIds){
		Map<Long, Long> ret = new HashMap<Long, Long>();
		if (fifidiananaId != null && mpivavakaIds != null && mpivavakaIds.size() > 0){
			StringBuffer hql = new StringBuffer("select distinct new map(mf.mpivavaka.id as mpivavakaId, mf.id as mirotsakaFidianaId) from MirotsakaFidiana mf \n");
			hql.append(" where mf.mpivavaka.id in (:mpivavakaIds) \n");
			hql.append(" and mf.fifidianana.id = :fifidiananaId ");
			
			List<Map<String, Long>> list = fHibernateTemplate.findByNamedParam(hql.toString(), new String[]{"mpivavakaIds", "fifidiananaId"}, new Object[]{mpivavakaIds, fifidiananaId});
			if (list.size() > 0){
				for (Map<String, Long> map : list)
					ret.put(map.get("mpivavakaId"), map.get("mirotsakaFidianaId"));
			}
		}
		return ret;
	}
	
	@SuppressWarnings("unchecked")
	public MirotsakaFidiana findMirotsakaFidianaById(Long id){
		MirotsakaFidiana ret = null;
		if (id != null){
			StringBuffer hql = new StringBuffer("from MirotsakaFidiana mf \n");
			hql.append(" inner join fetch mf.mpivavaka \n");
			hql.append(" inner join fetch mf.fifidianana \n");
			hql.append(" inner join fetch mf.userCreator \n");//inner
			hql.append(" left join fetch mf.userLastModification \n");
			hql.append(" where mf.id = :id ");
			List<MirotsakaFidiana> list = fHibernateTemplate.findByNamedParam(hql.toString(), "id", id);
			if (list.size()>0)
				ret = list.get(0);
		}
		return ret;
	}
	
	/**
	 * @param tsyAnkanavaka, si true alors toutes les candidatures acceptées ou non
	 * @param ekenaFirotsahana,si tsyAnkanavaka == false alors 
	 *  si true => les candidatures acceptées uniquement, si false => les candidatures refusées seulement
	 * @param lehilahy, si null alors toutes les candidatures sans distinction de genre, si true alors les hommes uniquement, si false alors les femmes uniquement
	 * @return la requête HQL pour récupérer le nombre de MirotsakaFidiana (nombre de candidature)
	 */
	private String getHqlNumberOfMirotsakaFidiana(boolean tsyAnkanavaka, Boolean ekenaFirotsahana, Boolean lehilahy){
		StringBuffer hql = new StringBuffer("select distinct mf.id from MirotsakaFidiana mf \n");
		
		if (lehilahy != null)
			hql.append(" inner join mf.mpivavaka mp \n");
		
		hql.append(" where mf.fifidianana.id = :id \n");
		if (!tsyAnkanavaka){
			if (ekenaFirotsahana != null){
				if (ekenaFirotsahana.booleanValue())
					hql.append(" and mf.ekenaFirotsahana = 1 \n");
				else
					hql.append(" and mf.ekenaFirotsahana = 0 \n");
			}
			else{
				//mbola tsy nojerena
				hql.append(" and mf.ekenaFirotsahana is null \n");
			}
		}
		
		if (lehilahy != null)
			hql.append(" and mp.lahy = ").append(lehilahy.booleanValue() ? "1 " : "0 ");
		
		return hql.toString();
	}
	
	/**
	 * 
	 * @param fifidiananaId
	 * @param tsyAnkanavaka, si true = tsy ampiasaina ekenaFirotsahana
	 * @param ekenaFirotsahana, si true = lisitry ny mirotsaka efa nekena, si false = lisitry ny mirotsaka efa nolavina, si null lisitry ny mirotsaka mbola tsy nojerena
	 * @return le nombre total de Mirotsaka Fidiana
	 */
	@SuppressWarnings("unchecked")
	public Long findNumberOfMirotsakaFidiana(Long fifidiananaId, boolean tsyAnkanavaka, Boolean ekenaFirotsahana, Boolean lehilahy){
		Long ret = 0L;
		if (fifidiananaId != null){
			List<Long> list = fHibernateTemplate.findByNamedParam(getHqlNumberOfMirotsakaFidiana(tsyAnkanavaka, ekenaFirotsahana, lehilahy), "id", fifidiananaId);
			ret = new Long(list.size());
		}
		return ret;
	}
	
	/**
	 * 
	 * @param fifidiananaId
	 * @param tsyAnkanavaka
	 * @param ekenaFirotsahana, 
	 * @param lehilahy
	 * @param pageNo
	 * @param nbElement
	 * @return les informations d'affichages des MirotsakaFidiana sous forme de Map
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> findMirotsakaFidiana(Fifidianana fifidianana, boolean tsyAnkanavaka, Boolean ekenaFirotsahana, Boolean lehilahy, Integer pageNo, Integer nbElement){
		List<Map<String, Object>> ret = new ArrayList<Map<String, Object>>();
		if (fifidianana != null){
			Long fifidiananaId = fifidianana.getId();
			StringBuffer hqlNbMirotsakaFidiana = new StringBuffer(getHqlNumberOfMirotsakaFidiana(tsyAnkanavaka, ekenaFirotsahana, lehilahy));
			if (fifidianana.isMitohyLaharana())
				hqlNbMirotsakaFidiana.append(" order by mf.laharanaMpirotsaka, mf.mpivavaka.anarana, mf.mpivavaka.fanampiny ");
			else
				hqlNbMirotsakaFidiana.append(" order by mf.laharanaMpirotsaka, mf.mpivavaka.lahy, mf.mpivavaka.anarana, mf.mpivavaka.fanampiny ");
			List<Long> list = fHibernateTemplate.findByNamedParamAndPage(hqlNbMirotsakaFidiana.toString(), new String[]{"id"},new Object[]{fifidiananaId}, pageNo, nbElement);
			
			if (list.size() > 0){
				StringBuffer hql = new StringBuffer("select distinct new map (mf.id as mirotsakaFidianaId, ");
				hql.append(" mp.id as mpivavakaId, mp.laharana as laharana, mp.anarana as anarana, ");
				hql.append(" mp.fanampiny as fanampiny, mp.lahy as lahy, mp.adresse as adiresy, ");
				hql.append(" mf.datyNirotsahana as datyNirotsahana, mf.ekenaFirotsahana as ekena, mf.laharanaMpirotsaka as laharanaMpirotsaka) ");
				hql.append(" from MirotsakaFidiana mf \n");
				hql.append(" inner join mf.mpivavaka mp \n ");
				hql.append(" inner join mf.fifidianana f \n");
				hql.append(" where mf.id in (:list) \n");
				if (fifidianana.isMitohyLaharana())
					hql.append(" order by mf.laharanaMpirotsaka, mp.anarana, mp.fanampiny ");
				else
					hql.append(" order by mf.laharanaMpirotsaka, mp.lahy, mp.anarana, mp.fanampiny ");
				ret = fHibernateTemplate.findByNamedParam(hql.toString(), "list", list);
			}
		}
		return ret;
	}
	
	/**
	 * @param fifidiananaId
	 * @param orderByName, true alors le résultat est trié par nom et prénom SINON le résultat est trié par datyNirotsahana
	 * @param ekenaFirotsahana, null = Mpirotsaka rehetra, true = mpirotsaka nekena ihany, false = mpirotsaka nolavina ihany
	 * @return les MirotsakaFidiana (Candidatures) d'un Fifidianana (élection)
	 */
	@SuppressWarnings("unchecked")
	public List<MirotsakaFidiana> findMirotsakaFidiana(Long fifidiananaId, boolean orderByName, Boolean ekenaFirotsahana){
		List<MirotsakaFidiana> ret = new ArrayList<MirotsakaFidiana>();
		if (fifidiananaId != null){
			boolean tsyAnkanavaka = ekenaFirotsahana == null;
			StringBuffer hqlNbMirotsakaFidiana = new StringBuffer(getHqlNumberOfMirotsakaFidiana(tsyAnkanavaka, ekenaFirotsahana, null));
			
			StringBuffer hql = new StringBuffer("select mf from MirotsakaFidiana mf \n");
			hql.append(" inner join fetch mf.mpivavaka mp \n ");
			hql.append(" inner join mf.fifidianana f \n");
			hql.append(" where mf.id in (").append(hqlNbMirotsakaFidiana.toString()).append(") \n");
			
			if (orderByName)
				hql.append(" order by mp.anarana, mp.fanampiny ");
			else
				hql.append(" order by mf.datyNirotsahana ");
			
			ret = fHibernateTemplate.findByNamedParam(hql.toString(), "id", fifidiananaId);
		}
		return ret;
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> findMapMirotsakaFidiana(Long fifidiananaId, Boolean ekenaFirotsahana, Boolean lehilahy, boolean orderByName){
		List<Map<String, Object>> ret = new ArrayList<Map<String, Object>>();
		
		if (fifidiananaId != null){
			
			ret = getFromCache(fifidiananaId, lehilahy);
			if (ret == null){			
				boolean tsyAnkanavaka = ekenaFirotsahana == null;
				StringBuffer hqlNbMirotsakaFidiana = new StringBuffer(getHqlNumberOfMirotsakaFidiana(tsyAnkanavaka, ekenaFirotsahana, lehilahy));
				
				StringBuffer hql = new StringBuffer("select distinct new map (mf.id as mirotsakaFidianaId, mf.laharanaMpirotsaka as laharanaMpirotsaka, mp.lahy as lahy) from MirotsakaFidiana mf \n");
				hql.append(" inner join mf.mpivavaka mp \n ");
				hql.append(" inner join mf.fifidianana f \n");
				hql.append(" where mf.id in (").append(hqlNbMirotsakaFidiana.toString()).append(") \n");
				
				if (orderByName)
					hql.append(" order by mp.anarana, mp.fanampiny ");
				else
					hql.append(" order by mf.laharanaMpirotsaka ");
					
				ret = fHibernateTemplate.findByNamedParam(hql.toString(), "id", fifidiananaId);
				
				putInCache(fifidiananaId, ret, lehilahy);
			}
		}
		return ret;
	}

	@SuppressWarnings("unchecked")
	public int getNumberMirotsakaFidiana(Long fifidiananaId){
		int ret = 0;
		if (fifidiananaId != null){
			StringBuffer hql = new StringBuffer("select distinct mf.id from MirotsakaFidiana mf \n");
			hql.append(" where mf.fifidianana.id = :fifidiananaId ");
			List<Long> list = fHibernateTemplate.findByNamedParam(hql.toString(), "fifidiananaId", fifidiananaId);
			ret = list.size();
		}		
		return ret;
	}
	
	@SuppressWarnings("unchecked")
	public int getNumberMirotsakaFidiana(Long fifidiananaId, Boolean nekena){
		int ret = 0;
		if (fifidiananaId != null){			
			if (nekena == null){
				//Mbola tsy notapahina
				StringBuffer hql = new StringBuffer("select distinct mf.id from MirotsakaFidiana mf \n");
				hql.append(" where mf.fifidianana.id = :fifidiananaId and mf.ekenaFirotsahana is null ");
				List<Long>list = fHibernateTemplate.findByNamedParam(hql.toString(), "fifidiananaId", fifidiananaId);
				ret = list.size();
			}
			else{
				StringBuffer hql = new StringBuffer("select distinct mf.id from MirotsakaFidiana mf \n");
				hql.append(" where mf.fifidianana.id = :fifidiananaId ");
				if (nekena.booleanValue())
					hql.append(" and mf.ekenaFirotsahana = 1 ");
				else
					hql.append(" and mf.ekenaFirotsahana = 0 ");
				List<Long>list = fHibernateTemplate.findByNamedParam(hql.toString(), "fifidiananaId", fifidiananaId);
				ret = list.size();
			}
		}
		return ret;
	}
	
	@SuppressWarnings("unchecked")
	public synchronized FanisamBato getFanisamBato(Fifidianana fifidianana, Boolean lehilahy){
		FanisamBato ret = null;

		if (fifidianana != null){
			if (!fifidianana.isFifidiananaOloTokana()){
				if (fifidianana.isMitohyLaharana() && lehilahy != null)
					throw new RuntimeException("Fifidianana iray ihany tokony tsy manavaka ny lehilahy sy ny vehivavy.");
				
				if (!fifidianana.isMitohyLaharana() && lehilahy == null)
					throw new RuntimeException("Tokony ho fifidianana samihafa ny lehilahy sy ny vehivavy.");
			}
		
			StringBuffer hql = new StringBuffer("select fb from FanisamBato fb \n");
			hql.append(" where fb.fifidianana.id = :id \n");
			if (lehilahy != null)
				hql.append(" and fb.lehilahy = ").append(lehilahy.booleanValue() ? "1 " : "0 ");
			else
				hql.append(" and fb.lehilahy is null ");
			
			List<FanisamBato> list = fHibernateTemplate.findByNamedParam(hql.toString(), "id", fifidianana.getId());
			if (list.size() > 0)
				ret = list.get(0);
			else{
				ret = new FanisamBato(fifidianana);
				ret.setLehilahy(lehilahy);
				fHibernateTemplate.save(ret);
			}
		}
		
		return ret;
	}

	public synchronized void ampioVatoIrayNyMpirotsakas(Fifidianana fifidianana, Collection<Long> mirotsakaFidianaIds) {
		assert mirotsakaFidianaIds != null && mirotsakaFidianaIds.size() > 0;
		
		StringBuffer sql = new StringBuffer("update MirotsakaFidiana  set mirotsakafidiana_isambato = mirotsakafidiana_isambato + 1 where MIROTSAKAFIDIANA_ID in ( ");
		boolean first = true;
		for (Long laharana : mirotsakaFidianaIds){
			if (!first)
				sql.append(',');
			sql.append(laharana);
			first = false;
		}
		sql.append(')');
		
		sql.append(" and FIFIDIANANA_ID = ").append(fifidianana.getId());
				
		Session session = fHibernateTemplate.getSessionFactory().getCurrentSession();
		Connection connection = session.connection();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql.toString());
			stmt.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public synchronized void esoryVatoIrayNyMpirotsakas(Fifidianana fifidianana, Collection<Long> mirotsakaFidianaIds) {
		assert mirotsakaFidianaIds != null && mirotsakaFidianaIds.size() > 0;
		
		StringBuffer sql = new StringBuffer("update MirotsakaFidiana  set mirotsakafidiana_isambato = mirotsakafidiana_isambato - 1 where MIROTSAKAFIDIANA_ID in ( ");
		boolean first = true;
		for (Long laharana : mirotsakaFidianaIds){
			if (!first)
				sql.append(',');
			sql.append(laharana);
			first = false;
		}
		sql.append(')');
		
		sql.append(" and FIFIDIANANA_ID = ").append(fifidianana.getId());
				
		Session session = fHibernateTemplate.getSessionFactory().getCurrentSession();
		Connection connection = session.connection();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql.toString());
			stmt.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public Map<Integer, Long> getLaharana2MirotsakaFidianaId(Collection<Integer> laharanaIds){
		Map<Integer, Long> ret = new HashMap<Integer, Long>();
		if (laharanaIds != null && laharanaIds.size() > 0){
			StringBuffer hql = new StringBuffer("select distinct new map (mf.id as mirotsakaId, mf.laharanaMpirotsaka as laharana) from MirotsakaFidiana mf \n");
			hql.append(" where mf.laharanaMpirotsaka in (:laharanaIds) ");
			List<Map<String, Number>> list = fHibernateTemplate.findByNamedParam(hql.toString(), "laharanaIds", laharanaIds);
			if (list.size() > 0){
				for (Map<String, Number> map : list){
					ret.put((Integer)map.get("laharana"), (Long)map.get("mirotsakaId"));
				}
				
				//Compléter le résultat
				for (Integer laharanaId : laharanaIds){
					if (!ret.keySet().contains(laharanaId))
						ret.put(laharanaId, null);
				}
			}
			
		}
		return ret;
	}
	
	/**
	 * Le nombre de voix obtenu par les candidats pour un fifidianana donné
	 * Le nombre de résultat renvoyé est paramétré
	 * le clé est composé du laharanaMpirotsaka et du nom du candidat
	 * @param fifidiananaId
	 * @param lahy
	 * @param izayNahazoVato,
	 * @param pageNo 
	 * @param nbElement
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getIsamBatoAmbonyIndrindra(Long fifidiananaId, Boolean lahy, boolean izayNahazoVato, Integer pageNo, Integer nbElement){
		List<Map<String, Object>> ret = new ArrayList<Map<String, Object>>();
		StringBuffer hql = new StringBuffer(" select distinct new map(mf.laharanaMpirotsaka as laharana, mp.anarana as anarana, mp.fanampiny as fanampiny, mp.id as mpivavakaId, mp.lahy as lahy,  mf.isamBato as vato) from MirotsakaFidiana mf \n");
		hql.append(" left join mf.mpivavaka mp \n");
		hql.append(" where mf.fifidianana.id = :fifidiananaId and mf.ekenaFirotsahana = 1 \n");
		if (lahy != null)
			hql.append(" and mp.lahy = :lahy \n");
		
		if (izayNahazoVato)
			hql.append(" and mf.isamBato > 0 \n");
		hql.append(" order by mf.isamBato desc, mp.datyTeraka asc , mf.datyNirotsahana asc, mf.laharanaMpirotsaka asc \n");
				
		if (lahy != null){
			if (pageNo != null && nbElement != null)
				ret = fHibernateTemplate.findByNamedParamAndPage(hql.toString(), new String[]{"fifidiananaId", "lahy"}, new Object[]{fifidiananaId, lahy}, pageNo, nbElement);
			else
				ret = fHibernateTemplate.findByNamedParam(hql.toString(), new String[]{"fifidiananaId", "lahy"}, new Object[]{fifidiananaId, lahy});
		}
		else{
			if (pageNo != null && nbElement != null)
				ret = fHibernateTemplate.findByNamedParamAndPage(hql.toString(), new String[]{"fifidiananaId"}, new Object[]{fifidiananaId}, pageNo, nbElement);
			else
				ret = fHibernateTemplate.findByNamedParam(hql.toString(),"fifidiananaId", fifidiananaId);
		}

		return ret;
	}

	@SuppressWarnings("unchecked")
	public Integer getNbMaxResult(Long fifidiananaId, Boolean lahy, boolean izayNahazoVato){
		List<Map<String, Object>> ret = new ArrayList<Map<String, Object>>();
		StringBuffer hql = new StringBuffer(" select distinct new map(mf.laharanaMpirotsaka as laharana, mp.lahy as lahy,  mf.id as mirotsakaFidianaId) from MirotsakaFidiana mf \n");
		hql.append(" left join mf.mpivavaka mp \n");
		hql.append(" where mf.fifidianana.id = :fifidiananaId and mf.ekenaFirotsahana = 1 \n");
		if (lahy != null)
			hql.append(" and mp.lahy = :lahy \n");
		
		if (izayNahazoVato)
			hql.append(" and mf.isamBato > 0 \n");
		hql.append(" order by mf.isamBato desc, mf.datyNirotsahana asc, mf.laharanaMpirotsaka asc \n");
				
		if (lahy != null)
			ret = fHibernateTemplate.findByNamedParam(hql.toString(), new String[]{"fifidiananaId", "lahy"}, new Object[]{fifidiananaId, lahy});
		else
			ret = fHibernateTemplate.findByNamedParam(hql.toString(),"fifidiananaId", fifidiananaId);

		return ret.size();
	}

	//----------------- Paramètres -----------------------------
	
	/**
	 * @return parameter, le paramètre de l'utilisateur depuis la base de données sinon le crée et l'enregistre en base
	 * NOTE : un utilisateur doit au plus avoir un seul et unique paramètre en base
	 */
	@SuppressWarnings("unchecked")
	public Parameter findParameterByUser(String login){
		Parameter ret = null;
		if (login != null){
			User user = getUser(login);
			if (user != null){
				StringBuffer hql = new StringBuffer("select pm from Parameter pm \n");
				hql.append(" where pm.user.id = :userId ");
				List<Parameter> list = fHibernateTemplate.findByNamedParam(hql.toString(), "userId", user.getId());
				if (list.size() > 0)
					ret = list.get(0);
				else{
					ret = new Parameter(user);
					fHibernateTemplate.save(ret);
				}
			}
			else
				throw new RuntimeException("Login ["+login+"] tsy misy.");
		}
		return ret;
	}

	public void saveParameter(Parameter parameter) {
		assert parameter != null && parameter.getId() != null;
		fHibernateTemplate.saveOrUpdate(parameter);
	}

	//--------------------------------- Modification de Mot de passe ---------------------------
	/**
	 * Modifie le mot de passe de l'utilisateur
	 * @return true si la modification est ok, false sinon
	 */
	@SuppressWarnings("unchecked")
	public boolean updatePassword(String userLogin, String lastPass, String newPass){
		boolean ret = true;
		if (userLogin != null && !"".equals(userLogin.trim())){
			StringBuffer hql = new StringBuffer("from User where login = :login ");
			List<User> list = fHibernateTemplate.findByNamedParam(hql.toString(), "login", userLogin);
			if (list.size()>0){
				User user = list.get(0);
				if (Utils.isPasswordValid(user.getPassword(), lastPass))
					user.setPassword(Utils.encodePassword(newPass));
				else
					throw new RuntimeException("Teny miafina tsy mitovy @ teo aloha");
			}
		}
		return ret;
	}
	
	public Vato saveVato(Vato vato) {
		if (vato != null)
			fHibernateTemplate.saveOrUpdate(vato);
		return vato;
	}
	
	@SuppressWarnings("unchecked")
	public Vato findVato(String laharana, Long fifidiananaId, Boolean lehilahy){
		Vato ret = null;
		if (laharana != null && !"".equals(laharana.trim()) && fifidiananaId != null){
			StringBuffer hql = new StringBuffer("select v from Vato v ");
			hql.append("   inner join fetch v.fifidianana \n");//inner
			hql.append("   inner join fetch v.userCreator \n");//inner
			hql.append("   left join fetch v.userLastModification \n");
			hql.append(" where v.vatoLaharana = :laharana and v.fifidianana.id = :fifidiananaId ");
			if (lehilahy != null)
				hql.append(" and v.lehilahy = ").append(lehilahy.booleanValue());
			else
				hql.append(" and v.lehilahy is null ");
			
			List<Vato> list = fHibernateTemplate.findByNamedParam(hql.toString(),  new String[]{"laharana", "fifidiananaId"}, new Object[]{laharana, fifidiananaId});
			
			if (list.size()>0)
				ret = list.get(0);
		}
		return ret;
	}
	
	public void initFifidianana(Long id){
		if (id != null){
			StringBuffer sql = new StringBuffer("update MIROTSAKAFIDIANA  set MIROTSAKAFIDIANA_ISAMBATO = 0 where FIFIDIANANA_ID = ").append(id);
			Session session = fHibernateTemplate.getSessionFactory().getCurrentSession();
			Connection connection = session.connection();
			try {
				PreparedStatement stmtM = connection.prepareStatement(sql.toString());
				stmtM.executeUpdate();
				
				sql = new StringBuffer("update FANISAMBATO set FANISAMBATO_VATOFOTSY = 0, FANISAMBATO_VATOMATY = 0, FANISAMBATO_VATO_VOAISA = 0 where FIFIDIANANA_ID = ").append(id);
				PreparedStatement stmtF = connection.prepareStatement(sql.toString());
				stmtF.executeUpdate();

				sql = new StringBuffer("delete from VATO where FIFIDIANANA_ID = ").append(id);
				PreparedStatement stmtV = connection.prepareStatement(sql.toString());
				stmtV.executeUpdate();

			} 
			catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
	
	public void addAuthorizedId(String ip, String description){
		if (ip != null && !"".equals(ip.trim())){
			putInCache(ip);
			
			AuthorizedIP authorizedIP = new AuthorizedIP(ip, description);
			fHibernateTemplate.saveOrUpdate(authorizedIP);
		}
	}
	
	@SuppressWarnings("unchecked")
	private AuthorizedIP findAuthorizedIP(String ip){
		AuthorizedIP ret = null;
		if (ip != null && !"".equals(ip.trim())){
			StringBuffer hql = new StringBuffer("select aip from AuthorizedIP aip where aip.ip = :ip");
			List<AuthorizedIP> authorizedIPs = (List<AuthorizedIP>)fHibernateTemplate.findByNamedParam(hql.toString(), "ip", ip);
			
			if (authorizedIPs.size()>0)
				ret = authorizedIPs.get(0);
		}		
		return ret;
	}
	
	@SuppressWarnings("unchecked")
	public AuthorizedIP findAuthorizedIP(Long id){
		AuthorizedIP ret = null;
		StringBuffer hql = new StringBuffer("select aip from AuthorizedIP aip where aip.id = :id");
		List<AuthorizedIP> authorizedIPs = (List<AuthorizedIP>)fHibernateTemplate.findByNamedParam(hql.toString(), "id", id);
		
		if (authorizedIPs.size()>0)
			ret = authorizedIPs.get(0);
		
		return ret;
	}
	
	public void removeAuthorizedIP(String ip){
		if (ip != null && !"".equals(ip.trim())){
			removeInCache(ip);
			
			AuthorizedIP theIP = findAuthorizedIP(ip);
			if (theIP != null)
				fHibernateTemplate.delete(theIP);
		}
	}
	
	@SuppressWarnings("unchecked")
	public boolean isIPAuthorized(String ip){
		boolean ret = false;
		if (ip != null && !"".equals(ip.trim())){
			Set<String> authorizedIps = getAuthorizedIPsFromCache();
			ret = authorizedIps.contains(ip);
			if (!ret){
				StringBuffer hql = new StringBuffer("select aip from AuthorizedIP aip where aip.ip = :ip and aip.authorized=true");
				List<AuthorizedIP> authorizedIPs = (List<AuthorizedIP>)fHibernateTemplate.findByNamedParam(hql.toString(), "ip", ip);
				ret = authorizedIPs.size() > 0;
				if (ret)
					putInCache(ip);
			}
		}
		return ret;
	}

	public void activateAuthorizedIP(String ip, boolean active) {
		AuthorizedIP authorizedIP = findAuthorizedIP(ip);
		if (authorizedIP != null)
			authorizedIP.setAuthorized(active);
	}

	@SuppressWarnings("unchecked")
	public List<AuthorizedIP> getAllAuthorizedIps(){
		StringBuffer hql = new StringBuffer("select aip from AuthorizedIP aip order by aip.ip asc ");
		List<AuthorizedIP> authorizedIPs = (List<AuthorizedIP>)fHibernateTemplate.find(hql.toString());
		
		return authorizedIPs;
	}

	public void saveAuthorizedIP(AuthorizedIP aip) {
		if (aip != null){
			if (aip.getId() != null){
				if (aip.isAuthorized())
					putInCache(aip.getIp());
				else
					removeInCache(aip.getIp());
			}
			else{
				if (aip.isAuthorized())
					putInCache(aip.getIp());
			}
			fHibernateTemplate.saveOrUpdate(aip);
		}
	}

	public void deleteAuthorizedIP(Long id) {
		AuthorizedIP aip = (AuthorizedIP) fHibernateTemplate.get(AuthorizedIP.class, id);
		if (aip != null){
			fHibernateTemplate.delete(aip);
			removeInCache(aip.getIp());
		}
	}
	
	public Map<String, Long> getStats(Long fifidiananaId, boolean lehilahy, String ip){
		Map<String, Long> ret = new HashMap<String, Long>();
		StringBuffer sql = new StringBuffer("select count(*) from VATO where FIFIDIANANA_ID=").append(fifidiananaId);
		sql.append(" and VATO_LEHILAHY = ").append(lehilahy);
		sql.append(" and VATO_IP = '").append(ip).append("'");
		
		Session session = fHibernateTemplate.getSessionFactory().getCurrentSession();
		Connection connection = session.connection();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql.toString());
			ResultSet rs =  stmt.executeQuery();
			if (rs.first()){
				long nbVatoRehetra = rs.getLong(1);
				ret.put("isaVatoVoaisa", nbVatoRehetra);
			}
			
			rs.close();
			
			StringBuffer sqlVatoManankery = new StringBuffer(sql.toString());
			sqlVatoManankery.append(" and VATO_SAFIDY is not null and VATO_MATY = 0");
			stmt = connection.prepareStatement(sqlVatoManankery.toString());
			rs = stmt.executeQuery();
			if (rs.first()){
				long nbVatoManankery = rs.getLong(1);
				ret.put("isaVatoManankery", nbVatoManankery);
			}
			
			rs.close();
			
			StringBuffer sqlVatoFotsy = new StringBuffer(sql.toString());
			sqlVatoFotsy.append(" and VATO_SAFIDY is null");
			stmt = connection.prepareStatement(sqlVatoFotsy.toString());
			rs = stmt.executeQuery();
			if (rs.first()){
				long nbVatoFotsy = rs.getLong(1);
				ret.put("isaVatoFotsy", nbVatoFotsy);
			}
			
			rs.close();
			
			StringBuffer sqlVatoMaty = new StringBuffer(sql.toString());
			sqlVatoMaty.append(" and VATO_MATY = 1");
			stmt = connection.prepareStatement(sqlVatoMaty.toString());
			rs = stmt.executeQuery();
			if (rs.first()){
				long nbVatoMaty= rs.getLong(1);
				ret.put("isaVatoMaty", nbVatoMaty);
			}

			rs.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}

		return ret;
	}
	
	public void startStopFanisambato(Long fifidiananaId, boolean start){
		StringBuffer sql = new StringBuffer("update FIFIDIANANA set MANOMBOKA=").append(start).append(" where FIFIDIANANA_ID = ").append(fifidiananaId);
		Session session = fHibernateTemplate.getSessionFactory().getCurrentSession();
		Connection connection = session.connection();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql.toString());
			stmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}		
	}
	
	public boolean canProcessFanisambato(Long fifidiananaId){
		boolean ret = false;

		StringBuffer sql = new StringBuffer("select MANOMBOKA from FIFIDIANANA where FIFIDIANANA_ID = ").append(fifidiananaId);
		Session session = fHibernateTemplate.getSessionFactory().getCurrentSession();
		Connection connection = session.connection();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql.toString());
			ResultSet rs =  stmt.executeQuery();
			if (rs.next())
				ret = rs.getBoolean(1);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return ret;
	}
}