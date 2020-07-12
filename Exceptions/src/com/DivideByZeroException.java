package com;

public class DivideByZeroException extends Exception{

	public DivideByZeroException() {
		super("This is a divide by zero exception");
		
	}

	public DivideByZeroException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public DivideByZeroException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public DivideByZeroException(String message) {
		super(message);
		
	}

	public DivideByZeroException(Throwable cause) {
		super(cause);
		
	}

	
}
