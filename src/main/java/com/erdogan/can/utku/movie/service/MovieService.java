package com.erdogan.can.utku.movie.service;

import com.erdogan.can.utku.movie.dto.CreateMovieRequest;
import com.erdogan.can.utku.movie.dto.MovieDto;
import com.erdogan.can.utku.movie.dto.UpdateMovieRequest;
import com.erdogan.can.utku.movie.model.MovieType;

import java.util.List;

public interface MovieService {

    MovieDto getMovieById(final long id);
    List<MovieDto> getAllMovies();
    List<MovieDto> getMoviesByType(final MovieType type);
    List<MovieDto> getMoviesByYear();
    MovieDto createMovie(final CreateMovieRequest request);
    MovieDto updateMovie(final UpdateMovieRequest request, final long id);
    MovieDto getMovieByName(final String name);
    void deleteMovie(final long id);
}
