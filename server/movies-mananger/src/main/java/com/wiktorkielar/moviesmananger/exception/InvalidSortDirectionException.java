package com.wiktorkielar.moviesmananger.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidSortDirectionException extends RuntimeException {
	
	private static final long serialVersionUID = 4186739891584117526L;

	public InvalidSortDirectionException(String message) {
		super(message);
	}

}
