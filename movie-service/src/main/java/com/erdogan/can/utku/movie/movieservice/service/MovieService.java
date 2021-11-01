package com.erdogan.can.utku.movie.movieservice.service;

import com.erdogan.can.utku.movie.movieservice.dto.request.CreateMovieRequest;
import com.erdogan.can.utku.movie.movieservice.dto.request.UpdateMovieRequest;
import com.erdogan.can.utku.movie.movieservice.dto.response.MovieDto;
import com.erdogan.can.utku.movie.movieservice.model.Actor;

import java.util.List;

public interface MovieService {

    MovieDto getMovieById(final long id);
    List<MovieDto> getAllMovies();
    MovieDto createMovie(final CreateMovieRequest request);
    MovieDto updateMovie(final UpdateMovieRequest request, final long id);
    void addActors(final long id, final List<Actor> actors);
    List<MovieDto> getMoviesByName(final String name);
    void deleteMovieById(final long id);
}
