package com.erdogan.can.utku.movie.model

import javax.persistence.*

@Entity
data class Actor(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id : Long,
        val name : String,
        val surname : String,
        val role : String?,
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "movie_id", referencedColumnName = "id")
        val movie: Movie?
){
        constructor(name: String,surname: String):this(
                0,
                name,
                surname,
                null,
                null
        )
}
