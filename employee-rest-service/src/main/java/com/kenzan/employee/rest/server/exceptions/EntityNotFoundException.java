package com.kenzan.employee.rest.server.exceptions;

public class EntityNotFoundException extends GenericException {

	private static final long serialVersionUID = -1074081540668299320L;
	
	public EntityNotFoundException(String exceptionId, String message) {
		super(exceptionId, message);
	}

}
