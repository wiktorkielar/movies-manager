package com.wiktorkielar.moviesmananger.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wiktorkielar.moviesmananger.model.Movie;

@Service
public interface MoviesService {
	
	public List<Movie> get(String sortDirection) throws Exception;
	public Movie create(Movie movie) throws Exception;
	public boolean delete(String id) throws Exception;

}
