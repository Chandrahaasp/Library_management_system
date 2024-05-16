package org.cts.lms.exceptions;

public class BookNotFoundException extends Exception{
	public BookNotFoundException(){
		
	}
	public BookNotFoundException(String message) {
		super(message);
	}
	
	@Override
	public String toString() {
		return "BookNotFoundException: " + super.getMessage();
	}
	
}
