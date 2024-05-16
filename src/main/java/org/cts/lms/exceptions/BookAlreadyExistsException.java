package org.cts.lms.exceptions;

public class BookAlreadyExistsException extends Exception{
	public BookAlreadyExistsException() {
		
	}
	public BookAlreadyExistsException(String message) {
		super(message);
	}
	@Override
	public String toString() {
		return "BookAlreadyExistsException: " + super.getMessage();
	}
	
}
