package org.cts.lms.exceptions;

public class StudentNotFoundException extends Exception{
	public StudentNotFoundException() {
		
	}
	public StudentNotFoundException(String message) {
		super(message);
	}
	
	@Override
	public String toString() {
		return "StudentNotFoundException: " + super.getMessage();
	}
	
}
