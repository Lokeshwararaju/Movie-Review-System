package com.project.service.request;

import com.project.beans.Movie;
import com.project.beans.Review;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewRequest {
	
	private String movieReview;
	private double rating;
	private Long movieId;
	
	public Review toReview() {
		return Review.builder()
				.movieReview(movieReview)
				.rating(rating)
				.movie(Movie.builder()
						.id(movieId)
				        .build())
				.build();
	}
  
}
