package com.project.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.project.beans.Genre;
import com.project.beans.Movie;
import com.project.repository.MovieRepository;
import com.project.service.response.MovieResponse;

@Service
public class MovieService {
	
	private MovieRepository movieRepository;
	
	public MovieResponse findMovie(String title) {
		Movie movie = movieRepository.findByTitle(title);
		if(Objects.nonNull(movie))
			return movie.toMovieResponse();
		return null;
	}
	public List<MovieResponse> findMoviesByGenre(String genre){
		if(Arrays.stream(Genre.values()).noneMatch(g -> g.toString().equals(genre)))
			return new ArrayList<>();
		List<Movie> movieList = movieRepository.findByGenre(Genre.valueOf(genre));
		if(!CollectionUtils.isEmpty(movieList)) {
			List<MovieResponse> movieResponseList = movieList.stream().sorted(Comparator.comparing(Movie::getRating, Comparator.reverseOrder())).map(m -> m.toMovieResponse()).collect(Collectors.toList());
			if(movieResponseList.size() > 5)
				return movieResponseList.subList(0, 4);
			return movieResponseList;
		}
		return new ArrayList<>();
	}

}
