package com.uniovi.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.uniovi.entities.Mark;

@Component
public class AddMarkValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Mark.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Mark mark = (Mark) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "score", "Error.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "Error.empty");
		if (mark.getScore()>= 10 || mark.getScore()<= 0) {
			errors.rejectValue("score", "Error.addMark.score");
		}
		if(mark.getDescription().length() < 20) {
			errors.rejectValue("description", "Error.addMark.description");
		}
	}

}
