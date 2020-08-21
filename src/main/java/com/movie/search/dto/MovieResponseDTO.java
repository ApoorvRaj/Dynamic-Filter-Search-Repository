package com.movie.search.dto;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MovieResponseDTO {

	private List<Movie> movies;

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
}
