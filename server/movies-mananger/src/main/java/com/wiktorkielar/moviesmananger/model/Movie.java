package com.wiktorkielar.moviesmananger.model;

import java.time.LocalDateTime;
import java.util.List;

public class Movie {

	private String id;
	private String title;
	private double rating;
	private String director;
	private List<String> actors;
	private LocalDateTime createdAt;

	public Movie(String id, String title, double rating, String director, List<String> actors,
			LocalDateTime createdAt) {
		super();
		this.id = id;
		this.title = title;
		this.rating = rating;
		this.director = director;
		this.actors = actors;
		this.createdAt = createdAt;
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public double getRating() {
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
