package com.erdogan.can.utku.movie.service;

import com.erdogan.can.utku.movie.dto.ActorDto;
import com.erdogan.can.utku.movie.dto.CreateActorRequest;
import com.erdogan.can.utku.movie.dto.UpdateActorRequest;
import com.erdogan.can.utku.movie.model.Actor;

import java.util.List;

public interface ActorService {

    ActorDto getActorById(final long id);
    ActorDto createActor(final CreateActorRequest request);
    ActorDto updateActor(final UpdateActorRequest request, final long id);
    void deleteActor(final long id);
    List<ActorDto> getAllActors();
}
