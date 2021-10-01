package com.erdogan.can.utku.movie.repository;

import com.erdogan.can.utku.movie.model.Actor;
import com.erdogan.can.utku.movie.model.Movie;
import com.erdogan.can.utku.movie.model.MovieType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    Movie getMovieByName(String name);
    List<Movie> getMoviesByType(MovieType type);
    List<Movie> findAllByOrderByYearAsc();
}
