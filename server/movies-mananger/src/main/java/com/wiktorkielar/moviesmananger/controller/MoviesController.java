package com.wiktorkielar.moviesmananger.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<Movie> getMovies(SortDirection sortDirection) {
		return moviesService.getMovies(sortDirection);
	}

	@PostMapping
	public Movie createMovie(Movie movie) {
		return moviesService.createMovie(movie);
	}

	@DeleteMapping("/{id}")
	public void deleteMovie(@PathVariable String id) {
		moviesService.deleteMovie(id);
	}

}
