package com.erdogan.can.utku.movie.movieservice.model

import javax.persistence.*

@Entity
data class Movie(
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       val id : Long,
       val name : String,
       val type : MovieType,
       val releaseDate : String,
       val description : String,
       @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
       val actors : List<Actor>
){
    constructor(name: String, type: MovieType, releaseDate: String, description: String): this(
            0,
            name,
            type,
            releaseDate,
            description,
            ArrayList()
    )
}

enum class MovieType{
    ACTION,DRAMA,COMEDY
}
