package com.hsbc.exception;

public class InvalidContactIdException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidContactIdException() {
		super();
	}

	public InvalidContactIdException(String message) {
		super(message);
	}
}
