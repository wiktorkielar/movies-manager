package com.wiktorkielar.moviesmananger.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class Movie {
	
	
	

	@ApiModelProperty(
			hidden = true)
	private String id;
//	@ApiModelProperty(
//			required=true, 
//			notes =  
//			TITLE + SPACE + CANNOT_BE_EMPTY + SPACE +
//			TITLE + SPACE + CANNOT_BE_MISSING + SPACE + 
//			TITLE + MUST_CONTAIN_MIN + SPACE + "3"
// 			cannot be empty. and has to contain at least 3 characters but no more than 50 characters")
	private String title;
	@ApiModelProperty(required=true)
	private Double rating;
	@ApiModelProperty(required=true)
	private String director;
	@ApiModelProperty(required=true)
	private List<String> actors;
	@ApiModelProperty(hidden = true)
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
