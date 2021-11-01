package com.erdogan.can.utku.movie.movieservice.dto.response

import com.erdogan.can.utku.movie.movieservice.model.MovieType

data class MovieDto(
        val id : Long,
        val name : String,
        val type : MovieType,
        val releaseDate : String,
        val description : String,
        val actors : List<ActorDto>
)
