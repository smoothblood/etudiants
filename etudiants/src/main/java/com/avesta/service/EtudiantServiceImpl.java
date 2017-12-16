package com.avesta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avesta.dao.EtudiantDAO;
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
	public String getNumEtdToBeAdded() {
		String numEtdMax = etudiantDao.getMaxNumEtd();
		String numEtdToBeAddes = "NUM001";
		if (numEtdMax != null && !"".equalsIgnoreCase(numEtdMax)) {
			int numEtdInt = Integer.parseInt( numEtdMax.substring(3, numEtdMax.length()) );
			numEtdToBeAddes = String.format("NUM%03d", (++numEtdInt));
		}
		return numEtdToBeAddes;
	}

}
