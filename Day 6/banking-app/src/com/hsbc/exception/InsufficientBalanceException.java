package com.hsbc.exception;

@SuppressWarnings("serial")
public class InsufficientBalanceException extends Exception{
	
	public InsufficientBalanceException() {
		super("Balance is too low");
	}
	public InsufficientBalanceException(String m) {
		super(m);
	}
}
