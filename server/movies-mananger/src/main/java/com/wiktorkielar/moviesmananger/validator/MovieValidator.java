package com.wiktorkielar.moviesmananger.validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.wiktorkielar.moviesmananger.exception.EmptyFieldException;
import com.wiktorkielar.moviesmananger.exception.MaxFieldValueException;
import com.wiktorkielar.moviesmananger.exception.MinFieldLengthException;
import com.wiktorkielar.moviesmananger.exception.MinFieldValueException;
import com.wiktorkielar.moviesmananger.exception.MissingFieldException;
import com.wiktorkielar.moviesmananger.exception.StringContentException;
import com.wiktorkielar.moviesmananger.model.Movie;

@Component
public class MovieValidator {

	@Value("${movie_title_length_min}")
	public int movieTitleLenghtMin;
	@Value("${movie_title_length_max}")
	public int movieTitleLenghtMax;
	@Value("${movie_title_regex}")
	public String movieTitleRegex;

	@Value("${movie_rating_min}")
	public double movieRatingMin;
	@Value("${movie_rating_max}")
	public double movieRatingMax;
	
	@Value("${movie_director_regex}")
	public String movieDirectorRegex;
	
	@Value("${movie_actors_regex}")
	public String movieActorsRegex;

	public void validateMovie(Movie movie) {

		validateMovieTitle(movie.getTitle());
		validateMovieRating(movie.getRating());
		validateMovieDirector(movie.getDirector());
		validateMovieActors(movie.getActors());
	}

	private void validateMovieTitle(String title) {
		validateMissingField("title", title);
		validateEmptyField("title", title);
		validateMinFieldLength("title", title, movieTitleLenghtMin);
		validateMaxFieldLength("title", title, movieTitleLenghtMax);
		validateStringContent("title", title, movieTitleRegex);
	}

	private void validateMovieRating(Double rating) {
		validateMissingField("rating", rating);
		validateMinFieldValue("rating", rating, movieRatingMin);
		validateMaxFieldValue("rating", rating, movieRatingMax);
	}

	private void validateMovieDirector(String director) {
		validateMissingField("director", director);
		validateEmptyField("director", director);
		validateStringContent("director", director, movieDirectorRegex);
	}

	private void validateMovieActors(List<String> actors) {
		validateMissingField("actors", actors);
		
		for (int i=0; i<actors.size(); i++) {
			
			validateEmptyField("actors[" + i + "]", actors.get(i));
			validateStringContent("actors[" + i + "]", actors.get(i), movieDirectorRegex);
		}
	}

	private void validateMissingField(String fieldName, Object value) {
		if (value == null) {
			throw new MissingFieldException("Missing mandatory '" + fieldName + "' field.");
		}
	}

	private void validateEmptyField(String fieldName, String value) {
		if (value.trim().length() == 0) {
			throw new EmptyFieldException("Empty '" + fieldName + "' field.");
		}
	}

	private void validateMinFieldLength(String fieldName, String value, int minLength) {
		int valueLength = value.length();

		if (valueLength < minLength) {
			throw new MinFieldLengthException("'" + fieldName + "' field's length (" + valueLength
					+ ") is lower than minimum expected (" + minLength + ").");
		}
	}

	private void validateMaxFieldLength(String fieldName, String value, int maxLength) {
		int valueLength = value.length();

		if (valueLength > maxLength) {
			throw new MinFieldLengthException("'" + fieldName + "' field's length (" + valueLength
					+ ") is higher than maximum expected (" + maxLength + ").");
		}
	}

	private void validateStringContent(String fieldName, String value, String regex) {
		if (!value.matches(regex)) {
			throw new StringContentException(
					"'" + fieldName + "' field's content does not match regex pattern (" + regex + ").");
		}
	}

	private void validateMinFieldValue(String fieldName, Double value, Double minValue) {
		if (value < minValue) {
			throw new MinFieldValueException("'" + fieldName + "' field's value (" + value
					+ ") is lower than minimum expected (" + minValue + ").");
		}
	}

	private void validateMaxFieldValue(String fieldName, Double value, Double maxValue) {
		if (value > maxValue) {
			throw new MaxFieldValueException("'" + fieldName + "' field's value (" + value
					+ ") is higher than maximum expected (" + maxValue + ").");
		}
	}

}
