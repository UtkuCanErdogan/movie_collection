package com.erdogan.can.utku.movie.dto

import com.erdogan.can.utku.movie.model.Actor
import com.erdogan.can.utku.movie.model.MovieType
import java.time.LocalDateTime

data class CreateMovieRequest(
        val name : String,
        val year : LocalDateTime,
        val description : String,
        val media : String,
        val type : MovieType,
        val actors : List<Actor>
)