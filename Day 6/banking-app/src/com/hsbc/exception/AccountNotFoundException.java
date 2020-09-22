package com.hsbc.exception;

//Add constructors inside AccountNotFoundException
@SuppressWarnings("serial")
public class AccountNotFoundException extends Exception {
	public AccountNotFoundException() {
		super("Accont does not exist.");
	}
	
	public AccountNotFoundException(String m) {
		super(m);
	}
}
