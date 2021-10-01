package com.erdogan.can.utku.movie.dto.converter;

import com.erdogan.can.utku.movie.dto.ActorDto;
import com.erdogan.can.utku.movie.model.Actor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ActorDtoConverter {

    public ActorDto convert(Actor from){
        return new ActorDto(
                from.getId(),
                from.getName(),
                from.getSurname(),
                from.getRole()
        );
    }

    public List<ActorDto> convertList(List<Actor> fromList){
        return fromList.stream().map(this::convert).collect(Collectors.toList());
    }
}
