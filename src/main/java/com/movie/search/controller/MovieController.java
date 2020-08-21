package com.movie.search.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movie.search.dto.Movie;
import com.movie.search.dto.MovieResponseDTO;
import com.movie.search.dto.MovieSpecification;
import com.movie.search.dto.UserRequestFilter;
import com.movie.search.repo.MovieRepository;

@Component
@RestController
public class MovieController {

	@Autowired
	MovieRepository movieRepository;
	
	@GetMapping(value="/search")
	public ResponseEntity<MovieResponseDTO> findMovies(@RequestBody UserRequestFilter userRequestFilter) {
		MovieResponseDTO movieResponseDTO = new MovieResponseDTO();
//		 movieRepository.saveAll(Arrays.asList(
//                 new Movie("Troy", "Drama", 7.2, 196, 2004),
//                 new Movie("The Godfather", "Crime", 9.2, 178, 1972),
//                 new Movie("Invictus", "Sport", 7.3, 135, 2009),
//                 new Movie("Black Panther", "Action", 7.3, 135, 2018),
//                 new Movie("Joker", "Drama", 8.9, 122, 2018),
//                 new Movie("Iron Man", "Action", 8.9, 126, 2008)
//         ));

		List<Movie> movies = new ArrayList<>();
		movies = movieRepository.findAll(MovieSpecification.findByCriteria(userRequestFilter));
		movieResponseDTO.setMovies(movies);
		return new ResponseEntity<>(movieResponseDTO,HttpStatus.OK);
	}
}

