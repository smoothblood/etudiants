package com.avesta.service;

import java.util.List;

import com.avesta.vo.EtudiantVO;

public interface EtudiantService {

	List<EtudiantVO> getAllEtudiants();
	
	EtudiantVO getEtudiantByNum(final String numEtd);
	
	Boolean isEtudiantUnique(final String numEtd);
	
	int ajoutEtudiant(final EtudiantVO etudiantVO);
	
	int updateEtudiant(final EtudiantVO etudiantVO);
	
	int deleteEtudiant(final String numEtd);
	
	String getNumEtdToBeAdded();
	
}
