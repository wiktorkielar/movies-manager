package com.wiktorkielar.moviesmananger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.wiktorkielar.moviesmananger.model.Movie;
import com.wiktorkielar.moviesmananger.repository.MoviesRepository;
import com.wiktorkielar.moviesmananger.validator.IdValidator;
import com.wiktorkielar.moviesmananger.validator.MovieValidator;
import com.wiktorkielar.moviesmananger.validator.SortDirectionValidator;

@Service
public class MoviesService {

	@Autowired
	private MoviesRepository moviesRepository;
	
	@Autowired
	private SortDirectionValidator sortDirectionValidator;
	
	@Autowired
	private MovieValidator movieValidator;

	@Autowired
	private IdValidator idValidator;

	public List<Movie> get(String sortDirection) throws Exception {
		sortDirectionValidator.validateSortDirection(sortDirection);
		
		Direction direction = Direction.valueOf(sortDirection);
		Sort sort = new Sort(direction, "rating");
		
		return moviesRepository.findAll(sort);
	}

	public Movie create(Movie movie) throws Exception {
		movieValidator.validateMovie(movie);
		
		return moviesRepository.insert(movie);
	}

	public boolean delete(String id) throws Exception {
		idValidator.validateId(id);
		
		if(moviesRepository.findById(id).isPresent()){
			moviesRepository.deleteById(id);
			return true;
		}
		return false;
		
	}

}
