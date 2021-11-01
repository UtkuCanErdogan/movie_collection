package com.erdogan.can.utku.movie.movieservice.model


import javax.persistence.*

@Entity
data class Actor(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id : Long,
        val name : String,
        val surname : String,
        val age : Int,
        @ManyToMany(mappedBy = "actors")
        val movies : List<Movie>
){
        constructor(name: String,surname: String,age: Int): this(
                0,
                name,
                surname,
                age,
                ArrayList()
        )
}
