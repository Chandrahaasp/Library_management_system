package org.cts.lms.exceptions;

public class StudentIdAlreadyExistsException extends Exception{
	public StudentIdAlreadyExistsException() {
		
	}
	public StudentIdAlreadyExistsException(String message) {
		super(message);
	}
	
	@Override
	public String toString() {
		return "StudentIdAlreadyExistsException: " + super.getMessage();
	}
	
}
