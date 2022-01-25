package com.trg.boot.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.trg.boot.entity.AppResponse;
import com.trg.boot.exceptions.DataNotFoundException;
import com.trg.boot.exceptions.SaveDataException;

@ControllerAdvice
public class EmployeeErrorHandler {

	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<AppResponse> handleDNF(DataNotFoundException dne) {

		return new ResponseEntity<AppResponse>(new AppResponse(dne.getCode(), dne.getMessage()),HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(SaveDataException.class)
	public ResponseEntity<AppResponse> handleSD(SaveDataException sde) {
		return new ResponseEntity<AppResponse>(new AppResponse(sde.getCode(), sde.getMessage()),HttpStatus.BAD_REQUEST);
	}

}
