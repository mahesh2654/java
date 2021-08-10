package com.trg.student.advice;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.trg.crud.exceptions.StudentException;

@ControllerAdvice
public class StudentExceptionHandler {

	@ExceptionHandler(StudentException.class)
	public ResponseEntity<?> handleStudentException(StudentException ex) {

		Map<String, Object> errorBody = new LinkedHashMap<>();

		errorBody.put("error", "Request Failed");
		errorBody.put("timestamp", LocalDateTime.now());
		errorBody.put("details", ex.getMessage());

		return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
	}
}
