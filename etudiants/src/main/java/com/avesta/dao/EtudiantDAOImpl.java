package com.avesta.dao;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.avesta.model.Etudiant;
import com.avesta.utils.Constantes;
import com.avesta.vo.EtudiantVO;

@Repository("etudiantDao")
@Scope("singleton")
public class EtudiantDAOImpl implements EtudiantDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EtudiantVO> getAllEtudiants() {
		String hqlColumns = getAllEtudiantHqlColumn(Constantes.EMPTY_STR);
		return sessionFactory.getCurrentSession()
				.createQuery("select" + hqlColumns + " from Etudiant")
				.setResultTransformer(Transformers.aliasToBean(EtudiantVO.class)).list();
	}

	@Override
	public EtudiantVO getEtudiantByNum(final String numEtd) {
		String hqlColumns = getAllEtudiantHqlColumn(Constantes.EMPTY_STR);
		return (EtudiantVO) sessionFactory.getCurrentSession()
				.createQuery("select" + hqlColumns + " from Etudiant where numEtd = :numEtd")
				.setParameter("numEtd", numEtd)
				.setResultTransformer(Transformers.aliasToBean(EtudiantVO.class)).uniqueResult();
	}

	@Override
	public int ajoutEtudiant(EtudiantVO etudiantVO) {
		Etudiant etudiant = new Etudiant();
		etudiant.setNumEtd(etudiantVO.getNumEtd());
		etudiant.setNom(etudiantVO.getNom());
		etudiant.setPrenom(etudiantVO.getPrenom());
		etudiant.setCreatedDate(LocalDateTime.now());
		etudiant.setUpdatedDate(LocalDateTime.now());
		return (int) sessionFactory.getCurrentSession().save(etudiant);
	}

	@Override
	public int updateEtudiant(EtudiantVO etudiantVO) {
		Etudiant etudiant = (Etudiant) sessionFactory.getCurrentSession().get(Etudiant.class, etudiantVO.getId());
		if (etudiant != null) {
			etudiant.setNom(etudiantVO.getNom());
			etudiant.setPrenom(etudiantVO.getPrenom());
			etudiant.setUpdatedDate(LocalDateTime.now());
			sessionFactory.getCurrentSession().update(etudiant);
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteEtudiant(String numEtd) {
		return sessionFactory.getCurrentSession().createQuery("delete from Etudiant where numEtd = :numEtd").setParameter("numEtd", numEtd).executeUpdate();
	}
	
	@Override
	public String getMaxNumEtd() {
		return (String) sessionFactory.getCurrentSession().createQuery("select numEtd from Etudiant order by numEtd desc").setMaxResults(1).uniqueResult();
	}

	@Override
	public Object isEtudiantExistByNum(String numEtd) {
		return sessionFactory.getCurrentSession().createQuery("select 1 from Etudiant where numEtd = :numEtd").setParameter("numEtd", numEtd).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EtudiantVO> getListEtudiantsByCriteria(String searchField, String criteriaSearch) {
		String hqlColumns = getAllEtudiantHqlColumn(Constantes.EMPTY_STR);
		StringBuilder hql = new StringBuilder();
		hql.append("select ").append(hqlColumns).append(" from Etudiant where "+criteriaSearch+" like :searchField");
		return sessionFactory.getCurrentSession()
				.createQuery(hql.toString())
				.setString("searchField", "%"+searchField+"%")
				.setResultTransformer(Transformers.aliasToBean(EtudiantVO.class))
				.list();
	}
	
	/**
	 * Description: Méthode récupére une liste des colonnes de la table "Etudiant" sous une chaine de caractère 
	 * Date création: 9 déc. 2017 20:45:00 
	 * User: saadxbelbsir
	 * @param tableAlias
	 * @param columnsToExclude
	 * @return String
	 */
	private String getAllEtudiantHqlColumn(String tableAlias, String... columnsToExclude) {
		if (tableAlias != null && tableAlias.trim().length() > 0) {
			tableAlias += Constantes.POINT;
		}
		List<String> listAttributes = new Etudiant().getAllClassAttributes();
		StringBuilder sbColumns = new StringBuilder();
		for (String attr : listAttributes) {
			if (!Arrays.asList(columnsToExclude).contains(attr)) {
				sbColumns.append(Constantes.EMPTY_SPACE).append(tableAlias);
				sbColumns.append(attr).append(Constantes.EMPTY_SPACE);
				sbColumns.append(Constantes.AS).append(Constantes.EMPTY_SPACE);
				sbColumns.append(attr).append(Constantes.VIRGULE);
			}
		}
		// supprimer la dérnier virgule
		if (sbColumns.length() > 0 && Constantes.VIRGULE.equalsIgnoreCase( String.valueOf((sbColumns.charAt(sbColumns.length()-1)))) ) {
			sbColumns.deleteCharAt(sbColumns.length() - 1);
		}
		return sbColumns.toString();
	}

	

}
