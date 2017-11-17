package com.wiktorkielar.moviesmananger.exception;

public class InvalidSortDirectionException extends RuntimeException {
	
	private static final long serialVersionUID = 4186739891584117526L;

	public InvalidSortDirectionException(String message) {
		super(message);
	}

}
