package com.movie.search.dto;

import org.springframework.stereotype.Component;

@Component
public class UserRequestFilter {

	private String title;
    private String genre;
    private String rating;
    private String watchTime;
    private String releaseYear;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getWatchTime() {
		return watchTime;
	}
	public void setWatchTime(String watchTime) {
		this.watchTime = watchTime;
	}
	public String getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}
    
	
}
