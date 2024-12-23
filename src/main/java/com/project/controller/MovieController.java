package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.service.MovieService;
import com.project.service.response.MovieResponse;

@RestController
@RequestMapping("/movie")
public class MovieController {
	
	@Autowired
	MovieService movieService;
	
	@GetMapping("/title")
	public MovieResponse findMovie(@RequestParam String title) {
		return movieService.findMovie(title);
	}
	
	@GetMapping("/genre")
	public List<MovieResponse> findMovieByGenre(@RequestParam String genre){
		return movieService.findMoviesByGenre(genre);
	}
	
	

}
