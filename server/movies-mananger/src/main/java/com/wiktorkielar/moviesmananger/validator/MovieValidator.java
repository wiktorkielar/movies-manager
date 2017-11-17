package com.wiktorkielar.moviesmananger.validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

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
		Utils.validateMissingField("title", title);
		Utils.validateEmptyField("title", title);
		Utils.validateMinFieldLength("title", title, movieTitleLenghtMin);
		Utils.validateMaxFieldLength("title", title, movieTitleLenghtMax);
		Utils.validateStringContent("title", title, movieTitleRegex);
	}

	private void validateMovieRating(Double rating) {
		Utils.validateMissingField("rating", rating);
		Utils.validateMinFieldValue("rating", rating, movieRatingMin);
		Utils.validateMaxFieldValue("rating", rating, movieRatingMax);
	}

	private void validateMovieDirector(String director) {
		Utils.validateMissingField("director", director);
		Utils.validateEmptyField("director", director);
		Utils.validateStringContent("director", director, movieDirectorRegex);
	}

	private void validateMovieActors(List<String> actors) {
		Utils.validateMissingField("actors", actors);
		
		for (int i=0; i<actors.size(); i++) {
			Utils.validateEmptyField("actors[" + i + "]", actors.get(i));
			Utils.validateStringContent("actors[" + i + "]", actors.get(i), movieDirectorRegex);
		}
	}

	

}
