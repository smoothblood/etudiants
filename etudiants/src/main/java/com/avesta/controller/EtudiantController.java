package com.avesta.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.avesta.service.EtudiantService;
import com.avesta.utils.AppUtils;
import com.avesta.utils.Constantes;
import com.avesta.vo.EtudiantVO;

@Controller
@RequestMapping("/")
public class EtudiantController {

	@Autowired
	private MessageSource messageSource;
	@Autowired
	private EtudiantService etudiantService;
	
	public void setEtudiantService(EtudiantService etudiantService) {
		this.etudiantService = etudiantService;
	}
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	
	@RequestMapping(value = {Constantes.SLASH, Constantes.ETUDIANT_LIST_MAPPING}, method = RequestMethod.GET)
	public String listEtudiant(ModelMap model) {
		List<EtudiantVO> listEtudiant = new ArrayList<EtudiantVO>();
		try { 
			listEtudiant = etudiantService.getAllEtudiants();
			if (listEtudiant == null || listEtudiant.size() == 0) {
				model.addAttribute(Constantes.WARNING, AppUtils.getMessage(messageSource, "etudiant.warning.list.empty"));
			}
		} catch (Exception e) {
			model.addAttribute(Constantes.ERROR, AppUtils.getMessage(messageSource, "etudiant.error.list", e.getMessage()));
			e.printStackTrace();
		} finally {
			model.addAttribute(Constantes.LIST_ETUDIANT, listEtudiant);
		}
		return Constantes.ETUDIANT_LIST_PAGE;
	}
	
	
	@RequestMapping(value = {Constantes.ETUDIANT_FORM_MAPPING}, method = RequestMethod.GET)
	public String formEtudiant(ModelMap model) {
		EtudiantVO etudiantVO = new EtudiantVO();
		try {
			final String numEtdToBrAdded = etudiantService.getNumEtdToBeAdded();
			etudiantVO.setNumEtd(numEtdToBrAdded);
		} catch (Exception e) {
			model.addAttribute(Constantes.ERROR, AppUtils.getMessage(messageSource, "etudiant.error.form", e.getMessage()));
			e.printStackTrace();
		} finally {
			model.addAttribute(Constantes.ETUDIANT, etudiantVO);
			model.addAttribute(Constantes.EDIT, false);
		}
		return Constantes.ETUDIANT_FORM_PAGE;
	}
	
	
	@RequestMapping(value = {Constantes.ETUDIANT_FORM_MAPPING}, method = RequestMethod.POST)
	public String formAddEtudiant(@Valid EtudiantVO etudiantVO, BindingResult result, ModelMap model) {
		try {
			if (result.hasErrors()) {
				model.addAttribute(Constantes.ETUDIANT, etudiantVO);
				model.addAttribute(Constantes.EDIT, false);
				return Constantes.ETUDIANT_FORM_PAGE;
			}
			if (etudiantService.isEtudiantUnique(etudiantVO.getNumEtd())) {
				int returnedIdValue = etudiantService.ajoutEtudiant(etudiantVO);
				if (returnedIdValue != 0) {
					model.addAttribute(Constantes.MESSAGE, AppUtils.getMessage(messageSource, "etudiant.add.success", etudiantVO.getNumEtd()));
				} else {
					model.addAttribute(Constantes.ERROR, AppUtils.getMessage(messageSource, "etudiant.add.fail", etudiantVO.getNumEtd()));
				}
			} else {
				model.addAttribute(Constantes.WARNING, AppUtils.getMessage(messageSource, "etudiant.warning.unique.numetd", etudiantVO.getNumEtd()));
			}
		} catch (HibernateException he) {
			model.addAttribute(Constantes.ERROR, AppUtils.getMessage(messageSource, "etudiant.error.add", etudiantVO.getNumEtd(), he.getCause().getMessage() + "<br>" + he.getMessage()));
			he.printStackTrace();
		} catch (Exception e) {
			model.addAttribute(Constantes.ERROR, AppUtils.getMessage(messageSource, "etudiant.error.add", etudiantVO.getNumEtd(), e.getMessage()));
			e.printStackTrace();
		}
		return listEtudiant(model);
	}
	
	
}
