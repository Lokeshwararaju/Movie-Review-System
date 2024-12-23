package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.beans.Genre;
import com.project.beans.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{

	public Movie findByTitle(String title);
	public List<Movie> findByGenre(Genre genre);
}