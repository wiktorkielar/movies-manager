package com.wiktorkielar.moviesmananger.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MissingFieldException extends RuntimeException {

	private static final long serialVersionUID = 5542415732976504102L;

	public MissingFieldException(String message) {
		super(message);
	}

}
