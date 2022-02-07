package com.trg.boot.exceptions;

public class EmployeeDuplicateException extends RuntimeException {

	private String code;
	private String message;

	public EmployeeDuplicateException(String code, String message) {
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
