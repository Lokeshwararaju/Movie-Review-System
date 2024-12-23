package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.beans.Movie;
import com.project.repository.MovieRepository;



@Service
public class AdminService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	public AdminService(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}
	
	public Movie addMovie(Movie movie) {
		return movieRepository.save(movie);
	}
	

}
