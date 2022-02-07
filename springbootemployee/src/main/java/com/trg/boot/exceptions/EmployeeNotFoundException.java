package com.trg.boot.exceptions;

public class EmployeeNotFoundException  extends RuntimeException{

	private String code;
	private String message;
	
	public EmployeeNotFoundException(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
	

}
