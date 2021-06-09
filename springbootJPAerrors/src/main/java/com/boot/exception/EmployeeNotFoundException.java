package com.boot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class EmployeeNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;

	public EmployeeNotFoundException(String message){
    	super(message);
    }
}
