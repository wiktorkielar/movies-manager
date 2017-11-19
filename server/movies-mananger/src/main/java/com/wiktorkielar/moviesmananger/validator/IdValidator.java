package com.wiktorkielar.moviesmananger.validator;

import org.springframework.stereotype.Component;

import com.wiktorkielar.moviesmananger.util.Preconditions;

@Component
public class IdValidator {

	public void validateId(String id) {
		Preconditions.validateUuidFormat("id", id);	
	}

}
