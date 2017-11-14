package com.wiktorkielar.moviesmananger.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.wiktorkielar.moviesmananger.model.Movie;

@Repository
public interface MoviesRepository extends MongoRepository<Movie, String> {
}
