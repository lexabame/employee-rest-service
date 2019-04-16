package com.kenzan.employee.rest.server.exceptions;

public class GenericException extends RuntimeException {
	
	private static final long serialVersionUID = 6548075067901767497L;
	
	protected String exceptionId;
	protected String message;
	
	public GenericException(String exceptionId, String message) {
		super(exceptionId + " " + message);
		this.exceptionId = exceptionId;
		this.message = message;
	}

}
