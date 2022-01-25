package com.trg.boot.exceptions;

public class DataNotFoundException  extends RuntimeException{

	private String code;
	private String message;
	
	public DataNotFoundException(String code, String message) {
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
