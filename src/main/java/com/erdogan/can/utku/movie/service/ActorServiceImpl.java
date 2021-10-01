package com.erdogan.can.utku.movie.service;

import com.erdogan.can.utku.movie.dto.ActorDto;
import com.erdogan.can.utku.movie.dto.CreateActorRequest;
import com.erdogan.can.utku.movie.dto.UpdateActorRequest;
import com.erdogan.can.utku.movie.dto.converter.ActorDtoConverter;
import com.erdogan.can.utku.movie.exception.ActorNotFoundException;
import com.erdogan.can.utku.movie.exception.MovieNotFoundException;
import com.erdogan.can.utku.movie.model.Actor;
import com.erdogan.can.utku.movie.repository.ActorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService{

    private final ActorRepository repository;
    private final ActorDtoConverter converter;

    public ActorServiceImpl(ActorRepository repository, ActorDtoConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public ActorDto getActorById(long id) {
        return converter.convert(findActorById(id));
    }

    @Override
    public ActorDto createActor(CreateActorRequest request) {
        Actor actor = new Actor(
                request.getName(),
                request.getSurname()
        );
        return converter.convert(repository.save(actor));
    }

    @Override
    public ActorDto updateActor(UpdateActorRequest request, long id) {
        Actor actor = findActorById(id);
        Actor updatedActor = new Actor(
                actor.getId(),
                request.getName(),
                request.getSurname(),
                actor.getRole(),
                actor.getMovie()
                );
        return converter.convert(repository.save(updatedActor));
    }

    @Override
    public void deleteActor(long id) {
        repository.deleteById(id);
    }

    @Override
    public List<ActorDto> getAllActors() {
        return converter.convertList(repository.findAll());
    }

    private Actor findActorById(final long id){
        return repository.findById(id).orElseThrow(() -> new ActorNotFoundException("Aktör Bulunamadı."));
    }
}
