package com.avesta.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avesta.dao.EtudiantDAO;
import com.avesta.model.Etudiant;
import com.avesta.utils.AppUtils;
import com.avesta.utils.Constantes;
import com.avesta.vo.EtudiantVO;

@Transactional
@Service("etudiantService")
@Scope("singleton")
public class EtudiantServiceImpl implements EtudiantService {

	@Autowired
	private EtudiantDAO etudiantDao;
	
	public void setEtudiantDao(EtudiantDAO etudiantDao) {
		this.etudiantDao = etudiantDao;
	}

	@Override
	public List<EtudiantVO> getAllEtudiants() {
		return etudiantDao.getAllEtudiants();
	}

	@Override
	public EtudiantVO getEtudiantByNum(final String numEtd) {
		return etudiantDao.getEtudiantByNum(numEtd);
	}

	@Override
	public Boolean isEtudiantUnique(String numEtd) {
		EtudiantVO etudiantVO = getEtudiantByNum(numEtd);
		return etudiantVO == null;
	}

	@Override
	public int ajoutEtudiant(EtudiantVO etudiantVO) {
		return etudiantDao.ajoutEtudiant(etudiantVO);
	}

	@Override
	public int updateEtudiant(EtudiantVO etudiantVO) {
		return etudiantDao.updateEtudiant(etudiantVO);
	}

	@Override
	public int deleteEtudiant(String numEtd) {
		return etudiantDao.deleteEtudiant(numEtd);
	}

	@Override
	public Boolean isEtudiantExistByNum(String numEtd) {
		return etudiantDao.isEtudiantExistByNum(numEtd) != null;
	}

	@Override
	public Map<String, String> getCriteriaSearch(MessageSource messageSource) {
		Map<String, String> mapCriteriaSearch = new LinkedHashMap<>();
		Map<String, String> mapForSelect = getMapForSelect(messageSource);
		List<String> listAttributes = new Etudiant().getAllClassAttributes();
		for (String attr : listAttributes) {
			if (!"id".equalsIgnoreCase(attr)) {
				String text = mapForSelect.get(attr);
				mapCriteriaSearch.put(attr, text != null ? text : attr);
			}
		}
		return mapCriteriaSearch;
	}
	
	@Override
	public List<EtudiantVO> getEtudiantByCriteria(String searchField, String criteriaSearch) {
		List<EtudiantVO> listEtudiant = etudiantDao.getListEtudiantsByCriteria(searchField, criteriaSearch);
		return listEtudiant;
	}
	
	@Override
	public String getNumEtdToBeAdded() {
		String numEtdMax = etudiantDao.getMaxNumEtd();
		String numEtdToBeAddes = "NUM001";
		if (numEtdMax != null && !"".equalsIgnoreCase(numEtdMax)) {
			int numEtdInt = Integer.parseInt( numEtdMax.substring(3, numEtdMax.length()) );
			numEtdToBeAddes = String.format("NUM%03d", (++numEtdInt));
		}
		return numEtdToBeAddes;
	}

	
	public Map<String, String> getMapForSelect(MessageSource messageSource) {
		Map<String, String> mapForSelect = new LinkedHashMap<>();
		mapForSelect.put(Constantes.ETUDIANT_NUM_ETD, AppUtils.getMessage(messageSource, "etudiant.col.numEtd"));
		mapForSelect.put(Constantes.ETUDIANT_NOM, AppUtils.getMessage(messageSource, "etudiant.col.nom"));
		mapForSelect.put(Constantes.ETUDIANT_PRENOM, AppUtils.getMessage(messageSource, "etudiant.col.prenom"));
		mapForSelect.put(Constantes.ETUDIANT_CREATED_DATE, AppUtils.getMessage(messageSource, "etudiant.col.createdDate"));
		mapForSelect.put(Constantes.ETUDIANT_UPDATED_DATE, AppUtils.getMessage(messageSource, "etudiant.col.updatedDate"));
		return mapForSelect;
	}
	

}
