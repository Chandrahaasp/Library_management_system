package org.cts.lms.exceptions;

public class AdminAlreadyExistsException extends Exception{
	public AdminAlreadyExistsException() {
		
	}
	public AdminAlreadyExistsException(String message) {
		super(message);
	}
	
	@Override
	public String toString() {
		return "AdminAlreadyExistsException: " + super.getMessage();
	}
	
}
