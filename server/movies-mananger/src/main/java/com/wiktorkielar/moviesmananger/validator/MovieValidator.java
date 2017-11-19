package com.wiktorkielar.moviesmananger.validator;

import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.wiktorkielar.moviesmananger.model.Movie;
import com.wiktorkielar.moviesmananger.util.Preconditions;

@Component
public class MovieValidator {
	
	public static final String TITLE = "title"; 
	public static final String RATING = "rating";
	public static final String DIRECTOR = "director";
	public static final String ACTORS = "actors";

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
		Preconditions.validateMissingField(TITLE, title);
		Preconditions.validateEmptyField(TITLE, title);
		Preconditions.validateMinFieldLength(TITLE, title, movieTitleLenghtMin);
		Preconditions.validateMaxFieldLength(TITLE, title, movieTitleLenghtMax);
		Preconditions.validateStringContent(TITLE, title, movieTitleRegex);
	}

	private void validateMovieRating(Double rating) {
		Preconditions.validateMissingField(RATING, rating);
		Preconditions.validateMinFieldValue(RATING, rating, movieRatingMin);
		Preconditions.validateMaxFieldValue(RATING, rating, movieRatingMax);
	}

	private void validateMovieDirector(String director) {
		Preconditions.validateMissingField(DIRECTOR, director);
		Preconditions.validateEmptyField(DIRECTOR, director);
		Preconditions.validateStringContent(DIRECTOR, director, movieDirectorRegex);
	}

	private void validateMovieActors(List<String> actors) {
		Preconditions.validateMissingField(ACTORS, actors);
		
		IntStream.range(0, actors.size()).forEach(value -> {
			Preconditions.validateEmptyField(ACTORS + "[" + value + "]", actors.get(value));
			Preconditions.validateStringContent(ACTORS + "[" + value + "]", actors.get(value), movieActorsRegex);
		});
	}

	

}
