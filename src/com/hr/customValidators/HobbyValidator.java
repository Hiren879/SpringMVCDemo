package com.hr.customValidators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HobbyValidator implements ConstraintValidator<IsValidHobby, String> {

	private String listOfValidHobbies;

	@Override
	public void initialize(IsValidHobby isValidHobby) {
		this.listOfValidHobbies = isValidHobby.listOfValidHobbies();
	}

	@Override
	public boolean isValid(String studentHooby, ConstraintValidatorContext ctx) {
		// match any of the strings
		if (studentHooby != null 
				&& !studentHooby.isEmpty() 
				&& studentHooby.matches(listOfValidHobbies)) {
			return true;
		} else {
			return false;
		}
	}

}
