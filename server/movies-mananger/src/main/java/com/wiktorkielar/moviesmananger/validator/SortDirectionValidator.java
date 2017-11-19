package com.wiktorkielar.moviesmananger.validator;

import org.springframework.stereotype.Component;

import com.wiktorkielar.moviesmananger.util.Preconditions;

@Component
public class SortDirectionValidator {
	
	public static final String SORT_DIRECTION = "sortDirection"; 

	public void validateSortDirection(String sortDirection) {
		Preconditions.validateMissingField(SORT_DIRECTION, sortDirection);
		Preconditions.validateEmptyField(SORT_DIRECTION, sortDirection);
		Preconditions.validateSortDirectionValue(SORT_DIRECTION, sortDirection);
	}

	
}
