package com.wiktorkielar.moviesmananger.validator;

import org.springframework.stereotype.Component;

@Component
public class IdValidator {

	public void validateId(String id) {
		Utils.validateUuidFormat("id", id);	
	}

}
