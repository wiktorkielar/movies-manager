package com.wiktorkielar.moviesmananger.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MinFieldValueException extends RuntimeException {
	
	private static final long serialVersionUID = -1147822475468165194L;

	public MinFieldValueException(String message) {
		super(message);
	}

}
