package com.wiktorkielar.moviesmananger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.wiktorkielar.moviesmananger.exception.MovieNotFoundException;
import com.wiktorkielar.moviesmananger.model.Movie;
import com.wiktorkielar.moviesmananger.model.SortDirection;
import com.wiktorkielar.moviesmananger.repository.MoviesRepository;
import com.wiktorkielar.moviesmananger.validator.IdValidator;

@Service
public class MoviesService {

	@Autowired
	private MoviesRepository moviesRepository;
	
	@Autowired
	private IdValidator idValidator;

	public List<Movie> getMovies(SortDirection sortDirection) throws Exception {
		Direction direction = Direction.valueOf(sortDirection.name());
		Sort sort = new Sort(direction, "rating");
		return moviesRepository.findAll(sort);
	}

	public Movie createMovie(Movie movie) throws Exception {
		return moviesRepository.insert(movie);
	}

	public void deleteMovie(String id) throws Exception {
		idValidator.validateId(id);
		try {
			moviesRepository.deleteById(id);
		} catch (IllegalArgumentException e) {
			throw new MovieNotFoundException("The movie with a given id was not found in the database");
		}
		
	}

}
