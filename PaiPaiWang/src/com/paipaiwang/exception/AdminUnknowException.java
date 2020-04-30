package com.paipaiwang.exception;

public class AdminUnknowException extends Exception {

	private String message;
	private Exception exception;

	public final Exception getException() {
		return exception;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public AdminUnknowException(String message,Exception e){
		super(message);
		this.message = message;
		this.exception = e;
	}
}
