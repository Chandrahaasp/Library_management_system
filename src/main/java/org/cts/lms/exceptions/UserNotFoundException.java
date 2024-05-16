package org.cts.lms.exceptions;

public class UserNotFoundException extends Exception{
public UserNotFoundException() {
		
	}
	public UserNotFoundException(String message) {
		super(message);
	}
	
	@Override
	public String toString() {
		return "UserNotFoundException: " + super.getMessage();
	}
}
