package com.trg.boot.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.trg.boot.entity.AppResponse;
import com.trg.boot.exceptions.EmployeeDuplicateException;
import com.trg.boot.exceptions.EmployeeNotFoundException;

@ControllerAdvice
public class ErrorHandler {

	@ExceptionHandler(EmployeeDuplicateException.class)
	public ResponseEntity<AppResponse> handleMD(EmployeeDuplicateException exp) {

		return new ResponseEntity<AppResponse>(new AppResponse(exp.getCode(), exp.getMessage()),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<AppResponse> handleMNF(EmployeeNotFoundException exp) {
		return new ResponseEntity<AppResponse>(new AppResponse(exp.getCode(), exp.getMessage()),
				HttpStatus.BAD_REQUEST);
	}

}