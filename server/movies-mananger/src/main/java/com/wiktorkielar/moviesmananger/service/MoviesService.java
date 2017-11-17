package com.wiktorkielar.moviesmananger.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.wiktorkielar.moviesmananger.model.Movie;
import com.wiktorkielar.moviesmananger.model.SortDirection;
import com.wiktorkielar.moviesmananger.repository.MoviesRepository;
import com.wiktorkielar.moviesmananger.validator.IdValidator;
import com.wiktorkielar.moviesmananger.validator.MovieValidator;

@Service
public class MoviesService {

	@Autowired
	private MoviesRepository moviesRepository;
	
	@Autowired
	private MovieValidator movieValidator;

	@Autowired
	private IdValidator idValidator;

	public List<Movie> getMovies(SortDirection sortDirection) throws Exception {
		Direction direction = Direction.valueOf(sortDirection.name());
		Sort sort = new Sort(direction, "rating");
		
		return moviesRepository.findAll(sort);
	}

	public Movie createMovie(Movie movie) throws Exception {
		movieValidator.validateMovie(movie);
		
		return moviesRepository.insert(movie);
	}

	public boolean deleteMovie(String id) throws Exception {
		idValidator.validateId(id);
		
		Optional<Movie> optional = moviesRepository.findById(id);
		if(optional.isPresent()) {
			moviesRepository.deleteById(id);
			return true;
		}
		return false;
		
	}

}
