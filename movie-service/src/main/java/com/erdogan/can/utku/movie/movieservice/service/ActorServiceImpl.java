package com.erdogan.can.utku.movie.movieservice.service;

import com.erdogan.can.utku.movie.movieservice.dto.converter.ActorDtoConverter;
import com.erdogan.can.utku.movie.movieservice.dto.converter.ActorMovieDtoConverter;
import com.erdogan.can.utku.movie.movieservice.dto.request.CreateActorRequest;
import com.erdogan.can.utku.movie.movieservice.dto.request.UpdateActorRequest;
import com.erdogan.can.utku.movie.movieservice.dto.response.ActorDto;
import com.erdogan.can.utku.movie.movieservice.dto.response.ActorMovieDto;
import com.erdogan.can.utku.movie.movieservice.exception.ActorNotFoundException;
import com.erdogan.can.utku.movie.movieservice.model.Actor;
import com.erdogan.can.utku.movie.movieservice.model.Movie;
import com.erdogan.can.utku.movie.movieservice.repository.ActorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ActorServiceImpl implements ActorService{

    private final ActorRepository repository;
    private final ActorDtoConverter converter;
    private final ActorMovieDtoConverter dtoConverter;

    public ActorServiceImpl(ActorRepository repository, ActorDtoConverter converter, ActorMovieDtoConverter dtoConverter) {
        this.repository = repository;
        this.converter = converter;
        this.dtoConverter = dtoConverter;
    }

    @Override
    public ActorDto getActorById(long id) {
        return converter.convert(findActorById(id));
    }

    @Override
    public ActorMovieDto getActorMovieById(long id) {
        return dtoConverter.convert(findActorById(id));
    }

    @Override
    public List<ActorDto> getAllActors() {
        return converter.convert(repository.findAll());
    }

    @Override
    public ActorDto createActor(CreateActorRequest request) {
        Actor actor = new Actor(
                request.getName(),
                request.getSurname(),
                request.getAge()
        );
        return converter.convert(repository.save(actor));
    }

    @Override
    public ActorMovieDto updateActor(UpdateActorRequest request, long id) {
        Actor actor = findActorById(id);
        Actor updatedActor = new Actor(
                actor.getId(),
                request.getName(),
                request.getSurname(),
                request.getAge(),
                actor.getMovies()
        );
        return dtoConverter.convert(repository.save(updatedActor));
    }

    @Override
    public void addMovie(Movie movie, long id) {
        Actor actor = findActorById(id);
        actor.getMovies().add(movie);
    }

    @Override
    public void addMovies(List<Movie> movieList, long id) {
        Actor actor = findActorById(id);
        actor.getMovies().addAll(movieList);
    }

    @Override
    public List<ActorDto> getActorsByName(String name) {
        return converter.convert(repository.getActorsByName(name).orElseThrow(() -> new ActorNotFoundException("Aktör Bulunamadı")));
    }

    @Override
    public void deleteActorById(long id) {
        findActorById(id);
        repository.deleteById(id);
    }

    private Actor findActorById(final long id){
        return repository.findById(id).orElseThrow(() -> new ActorNotFoundException("Aktör Bulunamadı"));
    }
}
