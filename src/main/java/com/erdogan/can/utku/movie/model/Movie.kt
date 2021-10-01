package com.erdogan.can.utku.movie.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Movie(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id : Long,
        val name : String,
        val year : LocalDateTime,
        val description : String,
        val media : String,
        val type : MovieType,

        @OneToMany(mappedBy = "movie",fetch = FetchType.LAZY,cascade = [CascadeType.ALL])
        val actors : List<Actor>
){
    constructor(name: String, year: LocalDateTime, description: String, media: String, type: MovieType, actors: List<Actor>) : this(
            0,
            name,
            year,
            description,
            media,
            type,
            actors
    )
}

enum class MovieType{
    DRAM, COMEDY, ACTION, FANTASTIC, SCIENCE_FICTION
}
