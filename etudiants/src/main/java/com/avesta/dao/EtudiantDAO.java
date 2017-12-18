package com.avesta.dao;

import java.util.List;
import java.util.Map;

import com.avesta.vo.EtudiantVO;

public interface EtudiantDAO {

	List<EtudiantVO> getAllEtudiants();
	
	EtudiantVO getEtudiantByNum(final String numEtd);
	
	int ajoutEtudiant(final EtudiantVO etudiantVO);
	
	int updateEtudiant(final EtudiantVO etudiantVO);
	
	int deleteEtudiant(final String numEtd);
	
	String getMaxNumEtd();
	
	Object isEtudiantExistByNum(final String numEtd);
	
	List<EtudiantVO> getListEtudiantsByCriteria(final String searchField, final String criteriaSearch);
	
}
