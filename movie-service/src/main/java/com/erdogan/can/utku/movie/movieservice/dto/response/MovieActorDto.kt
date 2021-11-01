package com.erdogan.can.utku.movie.movieservice.dto.response

import com.erdogan.can.utku.movie.movieservice.model.MovieType

data class MovieActorDto(
        val id : Long,
        val name : String,
        val type : MovieType,
        val releaseDate : String,
        val description : String
)
