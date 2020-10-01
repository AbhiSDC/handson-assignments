package com.hsbc.exception;

public class DuplicateContactException extends Exception {
	private static final long serialVersionUID = 1L;

	public DuplicateContactException() {
		super("Duplicate contact cannot be added.");
	}

	public DuplicateContactException(String message) {
		super(message);
	}
}
