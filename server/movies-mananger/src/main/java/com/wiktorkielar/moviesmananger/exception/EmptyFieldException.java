package com.wiktorkielar.moviesmananger.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmptyFieldException extends RuntimeException {
	
	private static final long serialVersionUID = 8921305615095403636L;

	public EmptyFieldException(String message) {
		super(message);
	}

}
