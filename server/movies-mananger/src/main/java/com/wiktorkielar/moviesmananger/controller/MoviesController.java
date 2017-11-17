package com.wiktorkielar.moviesmananger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wiktorkielar.moviesmananger.model.Movie;
import com.wiktorkielar.moviesmananger.model.SortDirection;
import com.wiktorkielar.moviesmananger.service.MoviesService;

@RestController
@RequestMapping("/movies")
public class MoviesController {

	@Autowired
	private MoviesService moviesService;

	@GetMapping
	public List<Movie> getMovies(SortDirection sortDirection) throws Exception {
		return moviesService.getMovies(sortDirection);
	}

	@PostMapping
	public Movie createMovie(Movie movie) throws Exception {
		return moviesService.createMovie(movie);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteMovie(@PathVariable String id) throws Exception {
		if(moviesService.deleteMovie(id)) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

}
