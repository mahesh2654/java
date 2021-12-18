package com.jpa.exceptions;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationErrorHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<String> errorList = ex.getBindingResult().getFieldErrors().stream().map(fe -> fe.getDefaultMessage())
				.collect(Collectors.toList());

		Map<String, Object> errorBody = new LinkedHashMap<>();
		errorBody.put("errors", errorList);

		return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(DuplicateEmployeeException.class)
	public ResponseEntity<?> handleDuplicateEntity(DuplicateEmployeeException ex) {

		Map<String, Object> errorBody = new LinkedHashMap<>();
		errorBody.put("error", "save error");
		errorBody.put("details", ex.getMessage());
		errorBody.put("timestamp", LocalDate.now());

		return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EmptyDataException.class)
	public ResponseEntity<?> handleEmptyData(EmptyDataException ex) {
		Map<String, Object> errorBody = new LinkedHashMap<>();
		errorBody.put("errorMessage", ex.getMessage());
		return new ResponseEntity<>(errorBody, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<?> handleMissingEmployee(EmployeeNotFoundException ex) {

		Map<String, Object> errorBody = new LinkedHashMap<>();
		errorBody.put("error", "Not Found");
		errorBody.put("details", ex.getMessage());
		errorBody.put("timestamp", LocalDate.now());

		return new ResponseEntity<>(errorBody, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(LoginException.class)
	public ResponseEntity<?> handleLoginError(LoginException ex) {

		Map<String, Object> errorBody = new LinkedHashMap<>();
		errorBody.put("error", "login error");
		errorBody.put("details", ex.getMessage());
		errorBody.put("timestamp", LocalDateTime.now());

		return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NotAuthorizedException.class)
	public ResponseEntity<?> handleLoginError(NotAuthorizedException ex) {

		Map<String, Object> errorBody = new LinkedHashMap<>();
		errorBody.put("error", "Authorization Error");
		errorBody.put("details", ex.getMessage());
		errorBody.put("timestamp", LocalDateTime.now());

		return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(InvalidTokenException.class)
	public ResponseEntity<?> handleTokenErrors(InvalidTokenException ex) {

		Map<String, Object> errorBody = new LinkedHashMap<>();
		errorBody.put("errorMessage", ex.getMessage());

		return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
	}
}
