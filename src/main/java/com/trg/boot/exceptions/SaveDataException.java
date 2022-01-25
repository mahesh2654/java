package com.trg.boot.exceptions;

public class SaveDataException extends RuntimeException {

	private String code;
	private String message;

	public SaveDataException(String code, String message) {
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
