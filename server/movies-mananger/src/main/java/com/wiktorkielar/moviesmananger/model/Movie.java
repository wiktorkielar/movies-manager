package com.wiktorkielar.moviesmananger.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Movie {

	private String id;
	private String title;
	private Double rating;
	private String director;
	private List<String> actors;
	private LocalDateTime createdAt;

	public Movie(String title, Double rating, String director, List<String> actors) {
		this.id = UUID.randomUUID().toString();
		this.title = title;
		this.rating = rating;
		this.director = director;
		this.actors = actors;
		this.createdAt = LocalDateTime.now();
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Double getRating() {
		return rating;
	}

	public String getDirector() {
		return director;
	}

	public List<String> getActors() {
		return actors;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

}
