package com.avesta.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.avesta.vo.EtudiantVO;

@Component
public class EtudiantValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return EtudiantVO.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "validator.id.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "numEtd", "validator.numEtd.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom", "validator.nom.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prenom", "validator.prenom.required");
		
//		errors.rejectValue("nom", "validator.nom.required");
//		for(FieldError error: errors.getFieldErrors()) {
//			System.out.println("field: "+error.getField());
//			System.out.println("rejected value: "+error.getRejectedValue().toString());
//		}
		
	}

}
