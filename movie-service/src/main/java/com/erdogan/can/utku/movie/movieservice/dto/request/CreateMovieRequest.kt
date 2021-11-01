package com.erdogan.can.utku.movie.movieservice.dto.request

import com.erdogan.can.utku.movie.movieservice.model.MovieType

data class CreateMovieRequest(
        val name : String,
        val type : MovieType,
        val releaseDate : String,
        val description : String
)
