package com.erdogan.can.utku.movie.movieservice.repository;

import com.erdogan.can.utku.movie.movieservice.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Optional<List<Movie>> getMoviesByName(String name);
}
