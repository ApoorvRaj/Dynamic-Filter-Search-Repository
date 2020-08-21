package com.movie.search.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

public class MovieSpecification {

	 	private static final String title ="title";
	    private static final String genre = "genre";
	    private static final String rating = "rating";
	    private static final String watchTime = "watchTime";
	    private static final String releaseYear = "releaseYear";
	    private static final String PERCENTAGE = "%";

	    
	public static Specification<Movie> findByCriteria(final UserRequestFilter userRequestFilter){
		return new Specification<Movie>() {
		private static final long serialVersionUID = 1L;
		List<Predicate> predicates = new ArrayList<>();

		@Override
		public Predicate toPredicate(Root<Movie> root, CriteriaQuery<?> query,
				CriteriaBuilder builder) {
			if(null != userRequestFilter.getGenre() && !userRequestFilter.getGenre().isEmpty()) {
				predicates.add(builder.equal(root.get(genre), userRequestFilter.getGenre()));
			}
			if(null != userRequestFilter.getTitle() && !userRequestFilter.getTitle().isEmpty()) {
				predicates.add(builder.like(root.get(title), PERCENTAGE + userRequestFilter.getTitle() + PERCENTAGE));
			}
			if(null != userRequestFilter.getRating() && !userRequestFilter.getRating().isEmpty()) {
				predicates.add(builder.greaterThanOrEqualTo(root.get(rating), userRequestFilter.getRating()));
			}
			if(null != userRequestFilter.getReleaseYear() && !userRequestFilter.getReleaseYear().isEmpty()) {
				predicates.add(builder.lessThan(root.get(releaseYear), userRequestFilter.getReleaseYear()));
			}
			if(null != userRequestFilter.getWatchTime() && !userRequestFilter.getWatchTime().isEmpty()) {
				predicates.add(builder.lessThan(root.get(watchTime), userRequestFilter.getWatchTime()));
			}
			return builder.and(predicates.toArray(new Predicate[predicates.size()]));
		}
	   };
	}
}
