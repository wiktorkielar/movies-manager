package com.wiktorkielar.moviesmananger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wiktorkielar.moviesmananger.model.Movie;
import com.wiktorkielar.moviesmananger.service.MoviesService;

@RestController
@RequestMapping("/movies")
@CrossOrigin
public class MoviesController {

	@Autowired
	private MoviesService moviesService;

	@GetMapping
	public ResponseEntity<List<Movie>> getMovies(String sortDirection) throws Exception {
		List<Movie> movieList = moviesService.get(sortDirection);
		return new ResponseEntity<>(movieList, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Movie> createMovie(Movie movie) throws Exception {
		Movie createdMovie = moviesService.create(movie);
		return new ResponseEntity<>(createdMovie, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteMovie(@PathVariable String id) throws Exception {
		if(moviesService.delete(id)) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
