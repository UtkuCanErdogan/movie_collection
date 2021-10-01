package com.erdogan.can.utku.movie.service;

import com.erdogan.can.utku.movie.dto.CreateMovieRequest;
import com.erdogan.can.utku.movie.dto.MovieDto;
import com.erdogan.can.utku.movie.dto.UpdateMovieRequest;
import com.erdogan.can.utku.movie.dto.converter.MovieDtoConverter;
import com.erdogan.can.utku.movie.exception.MovieNotFoundException;
import com.erdogan.can.utku.movie.model.Movie;
import com.erdogan.can.utku.movie.model.MovieType;
import com.erdogan.can.utku.movie.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository repository;
    private final MovieDtoConverter converter;

    public MovieServiceImpl(MovieRepository repository, MovieDtoConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public MovieDto getMovieById(long id) {
        return converter.convert(findById(id));
    }

    @Override
    public List<MovieDto> getAllMovies() {
        return converter.convertList(repository.findAll());
    }

    @Override
    public List<MovieDto> getMoviesByType(MovieType type) {
        return converter.convertList(repository.getMoviesByType(type));
    }

    @Override
    public List<MovieDto> getMoviesByYear() {
        return converter.convertList(repository.findAllByOrderByYearAsc());
    }

    @Override
    public MovieDto createMovie(final CreateMovieRequest request) {
        Movie movie = new Movie(
                request.getName(),
                request.getYear(),
                request.getDescription(),
                request.getMedia(),
                request.getType(),
                request.getActors()
        );
        return converter.convert(repository.save(movie));
    }

    @Override
    public MovieDto updateMovie(final UpdateMovieRequest request, final long id) {
        var movie = findById(id);
        Movie updatedMovie = new Movie(
                movie.getId(),
                request.getName(),
                request.getYear(),
                request.getDescription(),
                request.getMedia(),
                request.getType(),
                request.getActors()
        );
        return converter.convert(repository.save(updatedMovie));
    }

    @Override
    public MovieDto getMovieByName(String name) {
        return converter.convert(repository.getMovieByName(name));
    }

    @Override
    public void deleteMovie(long id) {
        var movie = findById(id);
        repository.deleteById(id);
    }

    private Movie findById(final long id){
        return repository.findById(id).orElseThrow(() -> new MovieNotFoundException("Film Bulunamadı."));
    }
}
