package com.wiktorkielar.moviesmananger.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MaxFieldValueException extends RuntimeException {

	private static final long serialVersionUID = 412312967357037077L;

	public MaxFieldValueException(String message) {
		super(message);
	}

}
