package com.avesta.service;

import java.util.List;
import java.util.Map;

import org.springframework.context.MessageSource;

import com.avesta.vo.EtudiantVO;

public interface EtudiantService {

	List<EtudiantVO> getAllEtudiants();
	
	EtudiantVO getEtudiantByNum(final String numEtd);
	
	Boolean isEtudiantUnique(final String numEtd);
	
	int ajoutEtudiant(final EtudiantVO etudiantVO);
	
	int updateEtudiant(final EtudiantVO etudiantVO);
	
	int deleteEtudiant(final String numEtd);
	
	String getNumEtdToBeAdded();
	
	Boolean isEtudiantExistByNum(final String numEtd);
	
	Map<String, String> getCriteriaSearch(MessageSource messageSource);
	
	List<EtudiantVO> getEtudiantByCriteria(final String searchField, final String criteriaSearch);
	
}
