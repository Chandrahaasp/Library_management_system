package org.cts.lms.exceptions;

public class InvalidLoginDetailsException extends Exception{
public InvalidLoginDetailsException() {
		
	}
	public InvalidLoginDetailsException(String message) {
		super(message);
	}
	
	@Override
	public String toString() {
		return "InvalidLoginDetailsException: " + super.getMessage();
	}
}
