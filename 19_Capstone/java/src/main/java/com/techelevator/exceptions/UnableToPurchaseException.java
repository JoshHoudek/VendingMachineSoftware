package com.techelevator.exceptions;

public class UnableToPurchaseException extends Exception {
private String message;
	
	public UnableToPurchaseException(String message) {
		super();
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
}
