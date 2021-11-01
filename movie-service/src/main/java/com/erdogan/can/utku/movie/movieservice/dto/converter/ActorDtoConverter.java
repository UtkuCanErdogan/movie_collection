package com.erdogan.can.utku.movie.movieservice.dto.converter;

import com.erdogan.can.utku.movie.movieservice.dto.response.ActorDto;
import com.erdogan.can.utku.movie.movieservice.dto.response.MovieDto;
import com.erdogan.can.utku.movie.movieservice.model.Actor;
import com.erdogan.can.utku.movie.movieservice.model.Movie;
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
                from.getAge()
        );
    }

    public List<ActorDto> convert(List<Actor> fromList){
        return fromList.stream()
                .map(this::convert).collect(Collectors.toList());
    }
}
