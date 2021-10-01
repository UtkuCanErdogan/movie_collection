package com.erdogan.can.utku.movie.dto.converter;

import com.erdogan.can.utku.movie.dto.MovieDto;
import com.erdogan.can.utku.movie.model.Movie;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovieDtoConverter {

    private final ActorDtoConverter converter;

    public MovieDtoConverter(ActorDtoConverter converter) {
        this.converter = converter;
    }

    public MovieDto convert(Movie from){
        return new MovieDto(
                from.getId(),
                from.getName(),
                from.getYear(),
                from.getType(),
                converter.convertList(from.getActors())
        );
    }

    public List<MovieDto> convertList(List<Movie> fromList){
        return fromList.stream().map(this :: convert).collect(Collectors.toList());
    }
}
