package org.cts.lms.exceptions;

public class UserAlreadyExistsException extends Exception{
public UserAlreadyExistsException() {
		
	}
	public UserAlreadyExistsException(String message) {
		super(message);
	}
	
	@Override
	public String toString() {
		return "UserAlreadyExistsException: " + super.getMessage();
	}
}
