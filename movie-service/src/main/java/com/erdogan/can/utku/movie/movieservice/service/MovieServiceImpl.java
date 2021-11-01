package com.erdogan.can.utku.movie.movieservice.service;

import com.erdogan.can.utku.movie.movieservice.dto.converter.MovieDtoConverter;
import com.erdogan.can.utku.movie.movieservice.dto.request.CreateMovieRequest;
import com.erdogan.can.utku.movie.movieservice.dto.request.UpdateMovieRequest;
import com.erdogan.can.utku.movie.movieservice.dto.response.MovieDto;
import com.erdogan.can.utku.movie.movieservice.exception.MovieNotFoundException;
import com.erdogan.can.utku.movie.movieservice.model.Actor;
import com.erdogan.can.utku.movie.movieservice.model.Movie;
import com.erdogan.can.utku.movie.movieservice.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{

    private final MovieRepository repository;
    private final MovieDtoConverter converter;

    public MovieServiceImpl(MovieRepository repository, MovieDtoConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public MovieDto getMovieById(long id) {
        return converter.convert(findMovieById(id));
    }

    @Override
    public List<MovieDto> getAllMovies() {
        return converter.convert(repository.findAll());
    }

    @Override
    public MovieDto createMovie(CreateMovieRequest request) {
        Movie movie = new Movie(
                request.getName(),
                request.getType(),
                request.getReleaseDate(),
                request.getDescription()
        );
        return converter.convert(repository.save(movie));
    }

    @Override
    public MovieDto updateMovie(UpdateMovieRequest request, long id) {
        Movie movie = findMovieById(id);
        Movie updatedMovie = new Movie(
                movie.getId(),
                request.getName(),
                request.getType(),
                request.getReleaseDate(),
                request.getDescription(),
                movie.getActors()
        );
        return converter.convert(repository.save(updatedMovie));
    }

    @Override
    public void addActors(long id, List<Actor> actors) {
        Movie movie = findMovieById(id);
        movie.getActors().addAll(actors);
    }

    @Override
    public List<MovieDto> getMoviesByName(String name) {
        return converter.convert(repository.getMoviesByName(name).orElseThrow(() -> new MovieNotFoundException("Film Bulunamadı")));
    }

    @Override
    public void deleteMovieById(long id) {
        findMovieById(id);
        repository.deleteById(id);
    }

    private Movie findMovieById(final long id){
        return repository.findById(id).orElseThrow(() -> new MovieNotFoundException("Film Bulunamadı"));
    }
}
