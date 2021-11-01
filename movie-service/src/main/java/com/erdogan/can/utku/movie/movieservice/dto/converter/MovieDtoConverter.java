package com.erdogan.can.utku.movie.movieservice.dto.converter;

import com.erdogan.can.utku.movie.movieservice.dto.response.MovieDto;
import com.erdogan.can.utku.movie.movieservice.model.Movie;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
                from.getType(),
                from.getReleaseDate(),
                from.getDescription(),
                from.getActors().size()>0 ? converter.convert(from.getActors()) : new ArrayList<>()
        );
    }

    public List<MovieDto> convert(List<Movie> fromList){
        return fromList.stream()
                .map(this::convert).collect(Collectors.toList());
    }
}
