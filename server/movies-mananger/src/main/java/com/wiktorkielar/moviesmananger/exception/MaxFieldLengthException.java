package com.wiktorkielar.moviesmananger.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MaxFieldLengthException extends RuntimeException {

	private static final long serialVersionUID = -66374015881498271L;

	public MaxFieldLengthException(String message) {
		super(message);
	}
}
