package com.wiktorkielar.moviesmananger.validator;

import org.springframework.stereotype.Component;

import com.wiktorkielar.moviesmananger.exception.InvalidStringFormatException;

@Component
public class IdValidator {

	public void validateId(String id) {
		checkFormat(id);	
	}
	
	private void checkFormat(String id) {
		String regex = "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f‌​]{4}-[0-9a-f]{12}$";
		if(!id.matches(regex)) {
			throw new InvalidStringFormatException("The id is not of a UUID format.");
		}
	}

}
