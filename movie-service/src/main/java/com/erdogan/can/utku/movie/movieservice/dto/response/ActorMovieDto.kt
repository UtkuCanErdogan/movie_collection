package com.erdogan.can.utku.movie.movieservice.dto.response

data class ActorMovieDto(
        val id : Long,
        val name : String,
        val surname : String,
        val age : Int,
        val movies : List<MovieActorDto>
)
