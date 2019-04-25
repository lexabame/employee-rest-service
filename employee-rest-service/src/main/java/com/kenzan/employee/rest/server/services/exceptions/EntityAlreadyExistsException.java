package com.kenzan.employee.rest.server.services.exceptions;

/**
 * @author alejandro
 * Exception to be thrown when an employee already exists
 */
public class EntityAlreadyExistsException extends GenericException {

	private static final long serialVersionUID = 339901704003430417L;
	
	public EntityAlreadyExistsException(String exceptionId, String message) {
		super(exceptionId, message);
	}

}
