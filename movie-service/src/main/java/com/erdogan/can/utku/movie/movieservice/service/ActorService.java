package com.erdogan.can.utku.movie.movieservice.service;

import com.erdogan.can.utku.movie.movieservice.dto.request.CreateActorRequest;
import com.erdogan.can.utku.movie.movieservice.dto.request.UpdateActorRequest;
import com.erdogan.can.utku.movie.movieservice.dto.response.ActorDto;
import com.erdogan.can.utku.movie.movieservice.dto.response.ActorMovieDto;
import com.erdogan.can.utku.movie.movieservice.model.Actor;
import com.erdogan.can.utku.movie.movieservice.model.Movie;

import java.util.List;

public interface ActorService {

    ActorDto getActorById(final long id);
    ActorMovieDto getActorMovieById(final long id);
    List<ActorDto> getAllActors();
    ActorDto createActor(final CreateActorRequest request);
    ActorMovieDto updateActor(final UpdateActorRequest request, final long id);
    void addMovie(final Movie movie, final long id);
    void addMovies(final List<Movie> movieList, final long id);
    List<ActorDto> getActorsByName(final String name);
    void deleteActorById(final long id);


}
