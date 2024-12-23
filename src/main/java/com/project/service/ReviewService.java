package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.beans.Movie;
import com.project.beans.Review;
import com.project.repository.MovieRepository;
import com.project.repository.ReviewRepository;
import com.project.service.response.ReviewResponse;

import java.util.Optional;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewRepository reviewRepository;
	@Autowired
	private MovieRepository movieRepository;
	
	public void addReview(Review review) {
		Movie movie = movieRepository.findById(review.getMovie().getId()).orElse(null);
		reviewRepository.save(review);
		if(movie != null) {
			Double average = reviewRepository.getReviewAverage(movie.getId());
			movie.setRating(average);
			movieRepository.save(movie);
		}
	}
	public ReviewResponse getReviewById(Long reviewId) {
		Optional<Review> review = reviewRepository.findById(reviewId);
		return review.map(Review::toReviewResponse).orElse(null);
	}
}