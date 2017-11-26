package com.wiktorkielar.moviesmananger.model;

import static com.wiktorkielar.moviesmananger.util.Constants.ACTOR;
import static com.wiktorkielar.moviesmananger.util.Constants.CANNOT_BE_EMPTY;
import static com.wiktorkielar.moviesmananger.util.Constants.CANNOT_BE_MISSING;
import static com.wiktorkielar.moviesmananger.util.Constants.CANNOT_CONTAIN_WHITESPACE;
import static com.wiktorkielar.moviesmananger.util.Constants.CAN_CONTAIN_BOTH;
import static com.wiktorkielar.moviesmananger.util.Constants.CHARACTERS;
import static com.wiktorkielar.moviesmananger.util.Constants.DIRECTOR;
import static com.wiktorkielar.moviesmananger.util.Constants.DOT;
import static com.wiktorkielar.moviesmananger.util.Constants.ID;
import static com.wiktorkielar.moviesmananger.util.Constants.MUST_BE_UUID;
import static com.wiktorkielar.moviesmananger.util.Constants.MUST_CONTAIN_MAX;
import static com.wiktorkielar.moviesmananger.util.Constants.MUST_CONTAIN_MIN;
import static com.wiktorkielar.moviesmananger.util.Constants.MUST_CONTAIN_ONLY_LETTERS;
import static com.wiktorkielar.moviesmananger.util.Constants.MUST_VALUE_MAX;
import static com.wiktorkielar.moviesmananger.util.Constants.MUST_VALUE_MIN;
import static com.wiktorkielar.moviesmananger.util.Constants.RATING;
import static com.wiktorkielar.moviesmananger.util.Constants.SPACE;
import static com.wiktorkielar.moviesmananger.util.Constants.TITLE;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.wiktorkielar.moviesmananger.exception.MissingFieldException;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
@JsonDeserialize(builder = Movie.MovieBuilder.class)
public class Movie {
	
	@ApiModelProperty(
			hidden=true, 
			notes =  
			ID + SPACE + MUST_BE_UUID + DOT)
	private String id;
	
	@ApiModelProperty(
			required=true, 
			notes =  
			TITLE + SPACE + CANNOT_BE_MISSING + DOT + SPACE +
			TITLE + SPACE + CANNOT_BE_EMPTY + DOT + SPACE + 
			TITLE + SPACE + MUST_CONTAIN_MIN + SPACE + "3" + SPACE + CHARACTERS + DOT + SPACE +
			TITLE + SPACE + MUST_CONTAIN_MAX + SPACE + "50" + SPACE + CHARACTERS + DOT + SPACE +
			TITLE + SPACE +  MUST_CONTAIN_ONLY_LETTERS + DOT)
	private String title;
	
	@ApiModelProperty(
			required=true, 
			notes =  
			RATING + SPACE + CANNOT_BE_MISSING + DOT + SPACE +
			RATING + SPACE + MUST_VALUE_MIN + SPACE + "1" + DOT + SPACE +
			RATING + SPACE + MUST_VALUE_MAX + SPACE + "10" + DOT)
	private Double rating;
	
	@ApiModelProperty(
			required=true, 
			notes =  
			DIRECTOR + SPACE + CANNOT_BE_MISSING + DOT + SPACE +
			DIRECTOR + SPACE + CANNOT_BE_EMPTY + DOT + SPACE + 
			DIRECTOR + SPACE + CAN_CONTAIN_BOTH + DOT + SPACE +
			DIRECTOR + SPACE + CANNOT_CONTAIN_WHITESPACE + DOT + SPACE)
	private String director;
	
	@ApiModelProperty(
			required=true, 
			notes =  
			ACTOR + SPACE + CANNOT_BE_MISSING + DOT + SPACE +
			ACTOR + SPACE + CANNOT_BE_EMPTY + DOT + SPACE + 
			ACTOR + SPACE + CAN_CONTAIN_BOTH + DOT + SPACE +
			ACTOR + SPACE + CANNOT_CONTAIN_WHITESPACE + DOT + SPACE)
	private List<String> actors;
	
	@ApiModelProperty(hidden = true)
	private LocalDateTime createdAt;

	public Movie(MovieBuilder builder) {
		this.id = builder.id;
		this.title = builder.title;
		this.rating = builder.rating;
		this.director = builder.director;
		this.actors = builder.actors;
		this.createdAt = builder.createdAt;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actors == null) ? 0 : actors.hashCode());
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((director == null) ? 0 : director.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (actors == null) {
			if (other.actors != null)
				return false;
		} else if (!actors.equals(other.actors))
			return false;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (director == null) {
			if (other.director != null)
				return false;
		} else if (!director.equals(other.director))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	@JsonPOJOBuilder(buildMethodName = "create", withPrefix = "set")
	public static class MovieBuilder {
		
		private String id;
		private String title;
		private Double rating;
		private String director;
		private List<String> actors;
		private LocalDateTime createdAt;
		
		public MovieBuilder title(String title) {
			this.title = title;
			return this;
		}
		public MovieBuilder rating(Double rating) {
			this.rating = rating;
			return this;
		}
		public MovieBuilder director(String director) {
			this.director = director;
			return this;
		}
		public MovieBuilder actors(List<String> actors) {
			this.actors = actors;
			return this;
		}
		
		public Movie build() {
			
			if(title == null){
				throwMissingFieldExceptionWithFieldName("title");
			}
			if(rating == null){
				throwMissingFieldExceptionWithFieldName("rating");
			}
			if(director == null){
				throwMissingFieldExceptionWithFieldName("director");
			}
			if(actors == null) {
				throwMissingFieldExceptionWithFieldName("actors");
			}
			this.id = UUID.randomUUID().toString();
			this.createdAt = LocalDateTime.now();
			
			return new Movie(this);

		}
		
		private void throwMissingFieldExceptionWithFieldName(String fieldName) {
			String message = String.format("Missing mandatory %s field.", fieldName);
			throw new MissingFieldException(message);
		}
		

	}
	
	

}
