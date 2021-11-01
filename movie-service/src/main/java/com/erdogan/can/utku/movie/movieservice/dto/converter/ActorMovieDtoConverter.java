package com.erdogan.can.utku.movie.movieservice.dto.converter;

import com.erdogan.can.utku.movie.movieservice.dto.response.ActorMovieDto;
import com.erdogan.can.utku.movie.movieservice.model.Actor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ActorMovieDtoConverter {

    private final MovieActorDtoConverter converter;

    public ActorMovieDtoConverter(MovieActorDtoConverter converter) {
        this.converter = converter;
    }

    public ActorMovieDto convert(Actor from){
        return new ActorMovieDto(
                from.getId(),
                from.getName(),
                from.getSurname(),
                from.getAge(),
                from.getMovies().size()>0 ? converter.convert(from.getMovies()) : new ArrayList<>()
        );
    }

    public List<ActorMovieDto> convert(List<Actor> fromList){
        return fromList.stream()
                .map(this::convert).collect(Collectors.toList());
    }
}
