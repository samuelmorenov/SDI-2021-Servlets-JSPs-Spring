package com.uniovi.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.uniovi.entities.Mark;
import com.uniovi.entities.Professor;
import com.uniovi.services.ProfessorService;

@Component
public class AddProfessorValidator implements Validator{
	@Autowired
	private ProfessorService professorService;

	@Override
	public boolean supports(Class<?> clazz) {
		return Mark.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Professor professor = (Professor) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "DNI", "Error.empty");
		if (professor.getDNI().length() != 9) {
			errors.rejectValue("DNI", "Error.professor.dni.length");
		}
		if (professorService.getProfessorByDNI(professor.getDNI()) != null) {
			errors.rejectValue("DNI", "Error.professor.dni.duplicate");
		}
	}

}