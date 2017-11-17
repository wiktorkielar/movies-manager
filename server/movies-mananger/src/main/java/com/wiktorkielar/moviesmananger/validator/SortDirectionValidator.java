package com.wiktorkielar.moviesmananger.validator;

import org.springframework.stereotype.Component;

@Component
public class SortDirectionValidator {

	public void validateSortDirection(String sortDirection) {
		Utils.validateMissingField("sortDirection", sortDirection);
		Utils.validateEmptyField("sortDirection", sortDirection);
		Utils.validateSortDirectionValue("sortDirection", sortDirection);
	}

	
}
