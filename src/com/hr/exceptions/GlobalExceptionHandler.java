package com.hr.exceptions;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This class is generic exception handler class for all exceptions occurred in any controller across the application.
 * @author hsavalia
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ResponseStatus(value = HttpStatus.BAD_GATEWAY)
	@ExceptionHandler(value = NullPointerException.class)
	public String handleNullPointerException(Exception e) {
		System.out.println("Null pointer occured " + e);
		return "NullPointerException";
	}
	
	@ExceptionHandler(value = IOException.class)
	public String handleIOException(Exception e) {
		System.out.println("IO occured " + e);
		return "IOException";
	}
	
	@ExceptionHandler(value = Exception.class)
	public String handleException(Exception e) {
		System.out.println("Unknown error occured " + e);
		return "Exception";
	}
}
