package com.kenzan.employee.rest.server.resources.exceptions;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.kenzan.employee.rest.server.services.exceptions.EntityAlreadyExistsException;
import com.kenzan.employee.rest.server.services.exceptions.EntityNotFoundException;


/**
 * @author alejandro
 * This component is for error handling at controller level. Here we could specify which error our rest
 * api could throw and handle them in a properly manner.
 */
@ControllerAdvice(basePackages = "com.kenzan.employee.rest.server.resources")
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(RestExceptionHandler.class);
	
	@ExceptionHandler(value = {EntityAlreadyExistsException.class})
	protected ResponseEntity<Object> handleEntityAlreadyExitsException(EntityAlreadyExistsException ex) {
		ApiError apiError = new ApiError(HttpStatus.CONFLICT);
		apiError.setExceptionId(ex.getExceptionId());
		apiError.setMessage(ex.getMessage());
		return buildResponseEntity(apiError);
	}
	
	@ExceptionHandler(value = {EntityNotFoundException.class})
	protected ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex) {
		ApiError apiError = new ApiError(HttpStatus.CONFLICT);
		apiError.setExceptionId(ex.getExceptionId());
		apiError.setMessage(ex.getMessage());
		return buildResponseEntity(apiError);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<FieldError> errors = ex.getBindingResult().getFieldErrors();
		
		String message = "Invalid request data";
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, message);
		
		List<ApiSubError> subErrors = errors.stream().map(fieldError -> new ApiValidationError(fieldError.getObjectName(), fieldError.getField(), fieldError.getRejectedValue(),
				fieldError.getDefaultMessage())).collect(Collectors.toList());
		
		apiError.setSubErrors(subErrors);
		
		return buildResponseEntity(apiError);
		
	}
	
	@ExceptionHandler(value = {Exception.class} )
	protected ResponseEntity<Object> handleException(Exception ex) {
		
		LOGGER.error(ex.getCause().toString());
		
		String message = "An internal error has ocurred";
		ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR);
		apiError.setMessage(message);
		return buildResponseEntity(apiError);
		
	}

	private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}
	
}
