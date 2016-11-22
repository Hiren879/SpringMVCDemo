package com.hr.customValidators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = HobbyValidator.class)
@Target( {ElementType.FIELD} )
@Retention(RetentionPolicy.RUNTIME)

public @interface IsValidHobby {
	
	// if user of annotation will not provide any list of values then these values will be taken as default values.
	String listOfValidHobbies() default "Music|Football|Cricket|Hockey";
	
	String message() default "Pelase provide a valid Hobby. " +
			"Accepted hobbies are - Music, Football, Cricket, Hockey (choose anyone)";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};

}
