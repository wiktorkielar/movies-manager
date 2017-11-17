package com.wiktorkielar.moviesmananger.validator;

import org.springframework.stereotype.Component;

import com.wiktorkielar.moviesmananger.exception.InvalidSortDirectionException;
import com.wiktorkielar.moviesmananger.model.SortDirection;

@Component
public class SortDirectionValidator {

	public void validateSortDirection(SortDirection sortDirection) {

		validateSortDirectionValue("sortDirection", sortDirection);

	}

	public void validateSortDirectionValue(String fieldName, SortDirection sortDirection) {

		SortDirection[] sortDirectionArray = sortDirection.values();
		boolean throwExceptionFlag = true;
		for (SortDirection sortDirectionElement : sortDirectionArray) {
			if (sortDirectionElement.name().equals(sortDirection.name())) {
				throwExceptionFlag = false;
			}
		}
		if (throwExceptionFlag) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("'" + fieldName + "' field's value is not any of the available types ( ");
			for(SortDirection sortDirectionElement : sortDirectionArray) {
				stringBuilder.append(sortDirectionElement.name());
				stringBuilder.append(" ");
			}
			stringBuilder.append(".");
			throw new InvalidSortDirectionException(stringBuilder.toString());
		}
	}

}
