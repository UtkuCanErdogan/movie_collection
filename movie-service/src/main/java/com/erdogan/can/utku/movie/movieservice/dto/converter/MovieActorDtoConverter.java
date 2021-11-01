package com.erdogan.can.utku.movie.movieservice.dto.converter;

import com.erdogan.can.utku.movie.movieservice.dto.response.MovieActorDto;
import com.erdogan.can.utku.movie.movieservice.dto.response.MovieDto;
import com.erdogan.can.utku.movie.movieservice.model.Movie;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovieActorDtoConverter {

    public MovieActorDto convert(Movie from){
        return new MovieActorDto(
                from.getId(),
                from.getName(),
                from.getType(),
                from.getReleaseDate(),
                from.getDescription()
        );
    }

    public List<MovieActorDto> convert(List<Movie> fromList){
        return fromList.stream()
                .map(this::convert).collect(Collectors.toList());
    }
}
