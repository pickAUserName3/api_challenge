package com.disney.studios.exception;

import java.sql.SQLException;

public class DogServiceException extends SQLException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3116418598496198922L;

	String message;

	int errorCode;

	public DogServiceException(String message, String state, int errCode, Throwable ex) {
		super(message, state, errCode, ex);
	}

}
