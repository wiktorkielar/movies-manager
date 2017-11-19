package com.wiktorkielar.moviesmananger.util;

import com.wiktorkielar.moviesmananger.exception.EmptyFieldException;
import com.wiktorkielar.moviesmananger.exception.InvalidSortDirectionException;
import com.wiktorkielar.moviesmananger.exception.InvalidStringFormatException;
import com.wiktorkielar.moviesmananger.exception.MaxFieldValueException;
import com.wiktorkielar.moviesmananger.exception.MinFieldLengthException;
import com.wiktorkielar.moviesmananger.exception.MinFieldValueException;
import com.wiktorkielar.moviesmananger.exception.MissingFieldException;
import com.wiktorkielar.moviesmananger.exception.StringContentException;
import com.wiktorkielar.moviesmananger.model.SortDirection;

public class Preconditions {
	
	private Preconditions() {}

	public static void validateMissingField(String fieldName, Object value) {
		if (value == null) {
			throw new MissingFieldException("Missing mandatory '" + fieldName + "' field.");
		}
	}

	public static void validateEmptyField(String fieldName, String value) {
		if (value.trim().length() == 0) {
			throw new EmptyFieldException("Empty '" + fieldName + "' field.");
		}
	}

	public static void validateMinFieldLength(String fieldName, String value, int minLength) {
		int valueLength = value.length();

		if (valueLength < minLength) {
			throw new MinFieldLengthException("'" + fieldName + "' field's length (" + valueLength
					+ ") is lower than minimum expected (" + minLength + ").");
		}
	}

	public static void validateMaxFieldLength(String fieldName, String value, int maxLength) {
		int valueLength = value.length();

		if (valueLength > maxLength) {
			throw new MinFieldLengthException("'" + fieldName + "' field's length (" + valueLength
					+ ") is higher than maximum expected (" + maxLength + ").");
		}
	}

	public static void validateStringContent(String fieldName, String value, String regex) {
		if (!value.matches(regex)) {
			throw new StringContentException(
					"'" + fieldName + "' field's content does not match regex pattern (" + regex + ").");
		}
	}

	public static void validateMinFieldValue(String fieldName, Double value, Double minValue) {
		if (value < minValue) {
			throw new MinFieldValueException("'" + fieldName + "' field's value (" + value
					+ ") is lower than minimum expected (" + minValue + ").");
		}
	}

	public static void validateMaxFieldValue(String fieldName, Double value, Double maxValue) {
		if (value > maxValue) {
			throw new MaxFieldValueException("'" + fieldName + "' field's value (" + value
					+ ") is higher than maximum expected (" + maxValue + ").");
		}
	}

	public static void validateUuidFormat(String fieldName, String id) {
		String regex = "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f‌​]{4}-[0-9a-f]{12}$";
		if (!id.matches(regex)) {
			throw new InvalidStringFormatException("The '" + fieldName + "' field is not of a valid UUID format.");
		}
	}

	public static void validateSortDirectionValue(String fieldName, String value) {

		boolean throwExceptionFlag = true;
		SortDirection[] sortDirectionArray = SortDirection.values();

		for (SortDirection sortDirectionElement : sortDirectionArray) {
			if (sortDirectionElement.name().equals(value)) {
				throwExceptionFlag = false;
			}
		}
		if (throwExceptionFlag) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("'" + fieldName + "' field's value is not in a valid values set (");
			for (int i = 0; i < sortDirectionArray.length; i++) {
				stringBuilder.append(sortDirectionArray[i].name());
				if(i != sortDirectionArray.length-1) {
					stringBuilder.append(", ");
				}
			}
			stringBuilder.append(").");
			throw new InvalidSortDirectionException(stringBuilder.toString());
		}
	}

}
