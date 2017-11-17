package com.wiktorkielar.moviesmananger.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class StringContentException extends RuntimeException{

	private static final long serialVersionUID = 2791113898992739420L;
	
	public StringContentException(String message) {
		super(message);
	}

}
