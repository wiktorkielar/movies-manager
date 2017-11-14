package com.wiktorkielar.moviesmananger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.wiktorkielar.moviesmananger.model.Movie;
import com.wiktorkielar.moviesmananger.model.SortDirection;
import com.wiktorkielar.moviesmananger.repository.MoviesRepository;

@Service
public class MoviesService {

	@Autowired
	private MoviesRepository moviesRepository;

	public List<Movie> getMovies(SortDirection sortDirection) {
		Direction direction = Direction.valueOf(sortDirection.name());
		Sort sort = new Sort(direction, "rating");
		return moviesRepository.findAll(sort);
	}

	public Movie createMovie(Movie movie) {
		return moviesRepository.insert(movie);
	}

	public void deleteMovie(String id) {
		moviesRepository.deleteById(id);
	}

}
