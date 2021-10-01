package com.erdogan.can.utku.movie.dto

import com.erdogan.can.utku.movie.model.Actor
import com.erdogan.can.utku.movie.model.MovieType
import java.time.LocalDateTime

data class MovieDto(
        val id : Long,
        val name : String,
        val year : LocalDateTime,
        val type : MovieType,
        val actors : List<ActorDto>?
)
