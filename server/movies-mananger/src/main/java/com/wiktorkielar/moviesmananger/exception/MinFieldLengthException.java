package com.wiktorkielar.moviesmananger.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MinFieldLengthException extends RuntimeException {

	private static final long serialVersionUID = 3194292449121543209L;

	public MinFieldLengthException(String message) {
		super(message);
	}
}
